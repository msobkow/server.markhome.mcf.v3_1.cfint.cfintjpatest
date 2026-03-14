
// Description: Spring StartupListener for the JpaTest program

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfint.cfintjpatest.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.jpa.*;
import server.markhome.mcf.v3_1.cfint.cfint.jpa.*;

@Component
public class CFIntJpaTestStartupListener implements ApplicationContextAware {
    @Autowired
    // @Qualifier("TestCFSec")
    private CFSecJpaTestTestSchema testCFSec;

    @Autowired
    // @Qualifier("TestCFInt")
    private CFIntJpaTestTestSchema testCFInt;


	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>();

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}


	@Autowired
	@Qualifier("cfsec31JpaHooksSchema")
	private CFSecJpaHooksSchema cfsecJpaHooksSchema;

	@Autowired
	@Qualifier("cfint31JpaHooksSchema")
	private CFIntJpaHooksSchema cfintJpaHooksSchema;

	@EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("CFIntJpaTest StartupListener tests beginning...");

		ICFSecSchema.getBackingCFSec().setApplicationContext(getApplicationContext());
		ICFIntSchema.getBackingCFInt().setApplicationContext(getApplicationContext());

		((CFSecJpaSchema)ICFSecSchema.getBackingCFSec()).setJpaHooksSchema(cfsecJpaHooksSchema);
		((CFIntJpaSchema)ICFIntSchema.getBackingCFInt()).setJpaHooksSchema(cfintJpaHooksSchema);


		ICFSecSchema.getBackingCFSec().wireTableTableInstances();
		ICFIntSchema.getBackingCFInt().wireTableTableInstances();

		ICFSecSchema.getBackingCFSec().bootstrapSchema();
		ICFIntSchema.getBackingCFInt().bootstrapSchema();

        System.err.println("Executing testCFSec.performTests()");
        try {
            String response = testCFSec.performTests(null);
            if (response != null) {
                System.err.println("CFSecJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFSecJpaTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFSec.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testCFInt.performTests()");
        try {
            String response = testCFInt.performTests(null);
            if (response != null) {
                System.err.println("CFIntJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFIntJpaTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFInt.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("CFIntJpaTest StartupListener tests complete.");
    }
}
