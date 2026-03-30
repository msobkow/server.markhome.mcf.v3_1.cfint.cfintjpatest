
// Description: Spring JPA tests for CFSec for the JpaTest program

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

@Service("JpaTestCFSec")
public class CFSecJpaTestTestSchema {
    
    @Autowired
    @Qualifier("cfsec31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean cFSec31EntityManagerFactory;
	@Autowired
	private CFSecJpaClusterService cFSecClusterService;

	@Autowired
	private CFSecJpaTenantService cFSecTenantService;

	@Autowired
	private CFSecJpaISOCcyService cFSecISOCcyService;

	@Autowired
	private CFSecJpaISOCtryService cFSecISOCtryService;

	@Autowired
	private CFSecJpaISOCtryCcyService cFSecISOCtryCcyService;

	@Autowired
	private CFSecJpaISOCtryLangService cFSecISOCtryLangService;

	@Autowired
	private CFSecJpaISOLangService cFSecISOLangService;

	@Autowired
	private CFSecJpaISOTZoneService cFSecISOTZoneService;

	@Autowired
	private CFSecJpaSecUserService cFSecSecUserService;

	@Autowired
	private CFSecJpaSecUserPasswordService cFSecSecUserPasswordService;

	@Autowired
	private CFSecJpaSecUserEMConfService cFSecSecUserEMConfService;

	@Autowired
	private CFSecJpaSecUserPWResetService cFSecSecUserPWResetService;

	@Autowired
	private CFSecJpaSecUserPWHistoryService cFSecSecUserPWHistoryService;

	@Autowired
	private CFSecJpaSecSysGrpService cFSecSecSysGrpService;

	@Autowired
	private CFSecJpaSecSysGrpIncService cFSecSecSysGrpIncService;

	@Autowired
	private CFSecJpaSecSysGrpMembService cFSecSecSysGrpMembService;

	@Autowired
	private CFSecJpaSecClusGrpService cFSecSecClusGrpService;

	@Autowired
	private CFSecJpaSecClusGrpIncService cFSecSecClusGrpIncService;

	@Autowired
	private CFSecJpaSecClusGrpMembService cFSecSecClusGrpMembService;

	@Autowired
	private CFSecJpaSecTentGrpService cFSecSecTentGrpService;

	@Autowired
	private CFSecJpaSecTentGrpIncService cFSecSecTentGrpIncService;

	@Autowired
	private CFSecJpaSecTentGrpMembService cFSecSecTentGrpMembService;

	@Autowired
	private CFSecJpaSecSessionService cFSecSecSessionService;

	@Autowired
	private CFSecJpaSysClusterService cFSecSysClusterService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "cfsec31TransactionManager")
    // @PersistenceContext(unitName = "CFSec31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFSec tests...\n");
		List<?> clusterResults = cFSecClusterService.findAll();
		if (clusterResults == null) {
			messages.append("Erroneously retrieved null for CFSecClusterService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clusterResults.size() + " entities from CFSec.Cluster\n");
		}

		List<?> tenantResults = cFSecTenantService.findAll();
		if (tenantResults == null) {
			messages.append("Erroneously retrieved null for CFSecTenantService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tenantResults.size() + " entities from CFSec.Tenant\n");
		}

		List<?> iSOCcyResults = cFSecISOCcyService.findAll();
		if (iSOCcyResults == null) {
			messages.append("Erroneously retrieved null for CFSecISOCcyService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCcyResults.size() + " entities from CFSec.ISOCcy\n");
		}

		List<?> iSOCtryResults = cFSecISOCtryService.findAll();
		if (iSOCtryResults == null) {
			messages.append("Erroneously retrieved null for CFSecISOCtryService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryResults.size() + " entities from CFSec.ISOCtry\n");
		}

		List<?> iSOCtryCcyResults = cFSecISOCtryCcyService.findAll();
		if (iSOCtryCcyResults == null) {
			messages.append("Erroneously retrieved null for CFSecISOCtryCcyService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryCcyResults.size() + " entities from CFSec.ISOCtryCcy\n");
		}

		List<?> iSOCtryLangResults = cFSecISOCtryLangService.findAll();
		if (iSOCtryLangResults == null) {
			messages.append("Erroneously retrieved null for CFSecISOCtryLangService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryLangResults.size() + " entities from CFSec.ISOCtryLang\n");
		}

		List<?> iSOLangResults = cFSecISOLangService.findAll();
		if (iSOLangResults == null) {
			messages.append("Erroneously retrieved null for CFSecISOLangService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOLangResults.size() + " entities from CFSec.ISOLang\n");
		}

		List<?> iSOTZoneResults = cFSecISOTZoneService.findAll();
		if (iSOTZoneResults == null) {
			messages.append("Erroneously retrieved null for CFSecISOTZoneService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOTZoneResults.size() + " entities from CFSec.ISOTZone\n");
		}

		List<?> secUserResults = cFSecSecUserService.findAll();
		if (secUserResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecUserService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserResults.size() + " entities from CFSec.SecUser\n");
		}

		List<?> secUserPasswordResults = cFSecSecUserPasswordService.findAll();
		if (secUserPasswordResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecUserPasswordService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserPasswordResults.size() + " entities from CFSec.SecUserPassword\n");
		}

		List<?> secUserEMConfResults = cFSecSecUserEMConfService.findAll();
		if (secUserEMConfResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecUserEMConfService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserEMConfResults.size() + " entities from CFSec.SecUserEMConf\n");
		}

		List<?> secUserPWResetResults = cFSecSecUserPWResetService.findAll();
		if (secUserPWResetResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecUserPWResetService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserPWResetResults.size() + " entities from CFSec.SecUserPWReset\n");
		}

		List<?> secUserPWHistoryResults = cFSecSecUserPWHistoryService.findAll();
		if (secUserPWHistoryResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecUserPWHistoryService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserPWHistoryResults.size() + " entities from CFSec.SecUserPWHistory\n");
		}

		List<?> secSysGrpResults = cFSecSecSysGrpService.findAll();
		if (secSysGrpResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecSysGrpService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpResults.size() + " entities from CFSec.SecSysGrp\n");
		}

		List<?> secSysGrpIncResults = cFSecSecSysGrpIncService.findAll();
		if (secSysGrpIncResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecSysGrpIncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpIncResults.size() + " entities from CFSec.SecSysGrpInc\n");
		}

		List<?> secSysGrpMembResults = cFSecSecSysGrpMembService.findAll();
		if (secSysGrpMembResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecSysGrpMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpMembResults.size() + " entities from CFSec.SecSysGrpMemb\n");
		}

		List<?> secClusGrpResults = cFSecSecClusGrpService.findAll();
		if (secClusGrpResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecClusGrpService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpResults.size() + " entities from CFSec.SecClusGrp\n");
		}

		List<?> secClusGrpIncResults = cFSecSecClusGrpIncService.findAll();
		if (secClusGrpIncResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecClusGrpIncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpIncResults.size() + " entities from CFSec.SecClusGrpInc\n");
		}

		List<?> secClusGrpMembResults = cFSecSecClusGrpMembService.findAll();
		if (secClusGrpMembResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecClusGrpMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpMembResults.size() + " entities from CFSec.SecClusGrpMemb\n");
		}

		List<?> secTentGrpResults = cFSecSecTentGrpService.findAll();
		if (secTentGrpResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecTentGrpService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpResults.size() + " entities from CFSec.SecTentGrp\n");
		}

		List<?> secTentGrpIncResults = cFSecSecTentGrpIncService.findAll();
		if (secTentGrpIncResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecTentGrpIncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpIncResults.size() + " entities from CFSec.SecTentGrpInc\n");
		}

		List<?> secTentGrpMembResults = cFSecSecTentGrpMembService.findAll();
		if (secTentGrpMembResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecTentGrpMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpMembResults.size() + " entities from CFSec.SecTentGrpMemb\n");
		}

		List<?> secSessionResults = cFSecSecSessionService.findAll();
		if (secSessionResults == null) {
			messages.append("Erroneously retrieved null for CFSecSecSessionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSessionResults.size() + " entities from CFSec.SecSession\n");
		}

		List<?> sysClusterResults = cFSecSysClusterService.findAll();
		if (sysClusterResults == null) {
			messages.append("Erroneously retrieved null for CFSecSysClusterService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + sysClusterResults.size() + " entities from CFSec.SysCluster\n");
		}

		messages.append("CFSec tests complete\n");
		return( messages.toString() );
	}
}
