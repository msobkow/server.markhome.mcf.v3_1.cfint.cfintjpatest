
// Description: Spring JPA tests for CFInt for the JpaTest program

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

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.jpa.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfint.cfint.jpa.*;

@Service("JpaTestCFInt")
public class CFIntJpaTestTestSchema {
    
    @Autowired
    @Qualifier("cfint31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean cFInt31EntityManagerFactory;
	@Autowired
	private CFIntJpaLicenseService cFIntLicenseService;

	@Autowired
	private CFIntJpaMajorVersionService cFIntMajorVersionService;

	@Autowired
	private CFIntJpaMimeTypeService cFIntMimeTypeService;

	@Autowired
	private CFIntJpaMinorVersionService cFIntMinorVersionService;

	@Autowired
	private CFIntJpaSubProjectService cFIntSubProjectService;

	@Autowired
	private CFIntJpaTldService cFIntTldService;

	@Autowired
	private CFIntJpaTopDomainService cFIntTopDomainService;

	@Autowired
	private CFIntJpaTopProjectService cFIntTopProjectService;

	@Autowired
	private CFIntJpaURLProtocolService cFIntURLProtocolService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "cfint31TransactionManager")
    // @PersistenceContext(unitName = "CFInt31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFInt tests...\n");
		List<?> licenseResults = cFIntLicenseService.findAll();
		if (licenseResults == null) {
			messages.append("Erroneously retrieved null for CFIntLicenseService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + licenseResults.size() + " entities from CFInt.License\n");
		}

		List<?> majorVersionResults = cFIntMajorVersionService.findAll();
		if (majorVersionResults == null) {
			messages.append("Erroneously retrieved null for CFIntMajorVersionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + majorVersionResults.size() + " entities from CFInt.MajorVersion\n");
		}

		List<?> mimeTypeResults = cFIntMimeTypeService.findAll();
		if (mimeTypeResults == null) {
			messages.append("Erroneously retrieved null for CFIntMimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + mimeTypeResults.size() + " entities from CFInt.MimeType\n");
		}

		List<?> minorVersionResults = cFIntMinorVersionService.findAll();
		if (minorVersionResults == null) {
			messages.append("Erroneously retrieved null for CFIntMinorVersionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + minorVersionResults.size() + " entities from CFInt.MinorVersion\n");
		}

		List<?> subProjectResults = cFIntSubProjectService.findAll();
		if (subProjectResults == null) {
			messages.append("Erroneously retrieved null for CFIntSubProjectService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + subProjectResults.size() + " entities from CFInt.SubProject\n");
		}

		List<?> tldResults = cFIntTldService.findAll();
		if (tldResults == null) {
			messages.append("Erroneously retrieved null for CFIntTldService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tldResults.size() + " entities from CFInt.Tld\n");
		}

		List<?> topDomainResults = cFIntTopDomainService.findAll();
		if (topDomainResults == null) {
			messages.append("Erroneously retrieved null for CFIntTopDomainService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + topDomainResults.size() + " entities from CFInt.TopDomain\n");
		}

		List<?> topProjectResults = cFIntTopProjectService.findAll();
		if (topProjectResults == null) {
			messages.append("Erroneously retrieved null for CFIntTopProjectService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + topProjectResults.size() + " entities from CFInt.TopProject\n");
		}

		List<?> uRLProtocolResults = cFIntURLProtocolService.findAll();
		if (uRLProtocolResults == null) {
			messages.append("Erroneously retrieved null for CFIntURLProtocolService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uRLProtocolResults.size() + " entities from CFInt.URLProtocol\n");
		}

		messages.append("CFInt tests complete\n");
		return( messages.toString() );
	}
}
