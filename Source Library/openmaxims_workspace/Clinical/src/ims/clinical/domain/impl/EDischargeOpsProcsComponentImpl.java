//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3355.29413)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.PastMedicalHistory;
import ims.clinical.domain.base.impl.BaseEDischargeOpsProcsComponentImpl;
import ims.clinical.domain.objects.SurgicalOperationNotes;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.clinical.vo.EDischargeSTHKSummaryForProcComponentVo;
import ims.clinical.vo.SurgicalOperationNotesShortVo;
import ims.clinical.vo.SurgicalOperationNotesShortVoCollection;
import ims.clinical.vo.domain.EDischargeSTHKSummaryForProcComponentVoAssembler;
import ims.clinical.vo.domain.SurgicalOperationNotesShortVoAssembler;
import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.PatientCharacteristic;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.CareContextVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientPastMedicalHistoryVo;
import ims.core.vo.PatientProcedureProcsComponentLiteVo;
import ims.core.vo.PatientProcedureProcsComponentLiteVoCollection;
import ims.core.vo.PatientProcedureProcsComponentVo;
import ims.core.vo.PatientProcedureShortVoCollection;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.PatientProcedureProcsComponentLiteVoAssembler;
import ims.core.vo.domain.PatientProcedureProcsComponentVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.hibernate3.IMSCriteria;
import ims.edischarge.domain.objects.Summary;
import ims.edischarge.vo.SummaryRefVo;
import ims.framework.FormName;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.interfaces.IMos;

import java.util.Iterator;
import java.util.List;

public class EDischargeOpsProcsComponentImpl extends BaseEDischargeOpsProcsComponentImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * will call procedure List Impl to list procedures
	 */
	public ims.core.vo.PatientProcedureProcsComponentLiteVoCollection listProcedures(ims.core.admin.vo.CareContextRefVo careContext) throws ims.domain.exceptions.DomainInterfaceException
	{
		final int PERFORMED_ID = -813;
		
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc = new IMSCriteria(PatientProcedure.class, factory);
		imsc.equal("careContext.id", careContext.getID_CareContext());
		imsc.equal("procedureStatus.id", PERFORMED_ID);
		List procedures = imsc.find();
		if (procedures.size() > 0)
			return PatientProcedureProcsComponentLiteVoAssembler.createPatientProcedureProcsComponentLiteVoCollectionFromPatientProcedure(procedures);
		else
			return null;
	}

	/**
	 * save a procedure and add to the collection for the episode
	 * 
	 * @throws UniqueKeyViolationException
	 */
	
	//	WDEV-13037
	public PatientProcedureProcsComponentVo savePatientProcedure(PatientProcedureProcsComponentVo patientProcedure, PatientRefVo voPatRefVo, EDischargeSTHKSummaryForProcComponentVo summary) throws StaleObjectException, UniqueKeyViolationException
	{
		if (patientProcedure == null)
			throw new CodingRuntimeException("PatientProcedure is null");

		if (!patientProcedure.isValidated())
			throw new CodingRuntimeException("PatientProcedure is not validated");

		DomainFactory factory = getDomainFactory();
		PatientProcedure doPatientProcedure = PatientProcedureProcsComponentVoAssembler.extractPatientProcedure(factory, patientProcedure);

		factory.save(doPatientProcedure);
		// come back to, now in past medical history
		// domRootClinicalContact.getPatientProcedures().add(doPatientProcedure);

		// associate with core clinical

		// bi-directional association
		PatientCharacteristic doCharacteristic;
		Iterator it = doPatientProcedure.getInsertedDevices().iterator();
		while (it.hasNext())
		{
			doCharacteristic = (PatientCharacteristic) it.next();
			doCharacteristic.setInsertionProcedure(doPatientProcedure);
		}

		Iterator it1 = doPatientProcedure.getRemovedDevices().iterator();
		while (it1.hasNext())
		{
			doCharacteristic = (PatientCharacteristic) it1.next();
			doCharacteristic.setRemovalProcedure(doPatientProcedure);
		}

		// Need to get latest from DB so timestamp is up todate for possible PMH
		// record save.
		patientProcedure = PatientProcedureProcsComponentVoAssembler.create(doPatientProcedure);// WDEV-1027

		if (patientProcedure.getSignifProcIsNotNull() && patientProcedure.getSignifProc().booleanValue())
		{ // Save a PMH Procedure record.
			PatientPastMedicalHistoryVo voPMH = new PatientPastMedicalHistoryVo();

			PastMedicalHistory implPMH = (PastMedicalHistory) getDomainImpl(PastMedicalHistoryImpl.class);
			voPMH = implPMH.getPastMedicalHistory(voPatRefVo);

			if (voPMH == null)
				voPMH = new PatientPastMedicalHistoryVo();

			PatientProcedureShortVoCollection voProcColl = voPMH.getProcedure();
			if (voProcColl == null)
				voProcColl = new PatientProcedureShortVoCollection();

			voProcColl.add(patientProcedure);
			voPMH.setProcedure(voProcColl);
			String[] arrErrors = voPMH.validate();
			if (arrErrors != null)
			{
				return patientProcedure; // TODO review all this.
				// throw new DomainRuntimeException("PMH not validated
				// correctly");
			}

			implPMH.savePMH(voPMH);

		}
		if(summary != null)		//wdev-13375
			saveEDischargeSummary(summary); //WDEV-13037
		/*	WDEV-13037
		//updating summary WDEV-11348
		IEDischargeHelper impl = (IEDischargeHelper) getDomainImpl(EDischargeHelper.class); 
		impl.updateSummaryIfRequired(patientProcedure, summary, factory);
		*/
		
		return patientProcedure;
	}

	public ims.core.vo.PatientProcedureProcsComponentVo getProcedure(PatientProcedureRefVo procedure)
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc = new IMSCriteria(PatientProcedure.class, factory);

		imsc.equal("id", procedure.getID_PatientProcedure());
		List procedures = imsc.find();
		if (procedures.size() > 0)
			return PatientProcedureProcsComponentVoAssembler.create((PatientProcedure) procedures.get(0));
		else
			return null;
	}

	//WDEV-13037 - summary argument added
	public void saveProcedures(PatientProcedureProcsComponentLiteVoCollection procedures, EDischargeSTHKSummaryForProcComponentVo summary) throws StaleObjectException

	{
		DomainFactory factory = getDomainFactory();
		if (procedures != null)
		{
			for (int i = 0; i < procedures.size(); i++)
				factory.save(PatientProcedureProcsComponentLiteVoAssembler.extractPatientProcedure(factory, procedures.get(i)));
		}
		
		if(summary != null)		//wdev-13375
			saveEDischargeSummary(summary); //WDEV-13037
	}

	public CareContextVo getCareContext(CareContextRefVo careContextRef)
	{
		DomainFactory factory = getDomainFactory();
		CareContext careDO = (CareContext) factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());
		return CareContextVoAssembler.create(careDO);
	}

	public HcpLiteVo getHcp(IMos iMos)
	{
		if (iMos == null || iMos.getIMosId() == null)
			return null;
		
		String query = "from Hcp as hcp where hcp.isRIE is null and hcp.mos.id = " + iMos.getIMosId().toString();
		
		return HcpLiteVoAssembler.create((Hcp) getDomainFactory().findFirst(query));
	}

	//WDEV-12785
	public void rieProcedure(PatientProcedureProcsComponentLiteVo proc,	FormName formName, Integer patientId, Integer contactId, Integer careContextId, String rieMessage, SummaryRefVo summary) throws StaleObjectException 
	{
		if (summary!=null && summary.getID_SummaryIsNotNull())
		{
			//Check to see if letter status is generated 
			String sql = "select count(summ.id) from Summary as summ left join summ.dischargeLetterStatus as lookup where (summ.id=:summId and lookup.id = :idGenerated)";
			
			long count = getDomainFactory().countWithHQL(sql, new String[]{"summId","idGenerated"}, new Object[]{summary.getID_Summary(),DischargeLetterStatus.GENERATED.getID()});
			if (count >0)
				throw new StaleObjectException(null);
		}
		
		markAsRie(proc, formName, patientId, contactId, careContextId, rieMessage);
	}

	//WDEV-13037
	public EDischargeSTHKSummaryForProcComponentVo getEDischargeSummary(SummaryRefVo summary) 
	{
		if(summary == null || summary.getID_Summary() == null)
			throw new CodingRuntimeException("Can not get EDischargeSummary on nul Id.");
		
		return EDischargeSTHKSummaryForProcComponentVoAssembler.create((Summary) getDomainFactory().getDomainObject(Summary.class, summary.getID_Summary()));
	}

	//WDEV-13037
	public EDischargeSTHKSummaryForProcComponentVo saveEDischargeSummary(EDischargeSTHKSummaryForProcComponentVo summary) throws StaleObjectException 
	{
		if(summary == null)
			throw new CodingRuntimeException("Cannot save a null EDischargeSTHKSummary.");
		
		if(!summary.isValidated())
			throw new CodingRuntimeException("EDischargeSTHKSummary is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		Summary doSummary = EDischargeSTHKSummaryForProcComponentVoAssembler.extractSummary(factory, summary);
		factory.save(doSummary);
		
		return EDischargeSTHKSummaryForProcComponentVoAssembler.create(doSummary);
	}

	//wdev-15860
	public SurgicalOperationNotesShortVo getSurgicalOperationNotesShort( CareContextRefVo careContextRef) 
	{
		if( careContextRef == null)
			return null;
		DomainFactory factory = getDomainFactory();
		 
		List result = factory.find("select s1_1	from SurgicalOperationNotes as s1_1 left join s1_1.careContext as c1_1	where (c1_1.id = :carecontextId)", new String[]{"carecontextId"}, new Object[]{careContextRef.getID_CareContext()});
		if(result != null && result.size() > 0)
		{
			SurgicalOperationNotesShortVoCollection tempColl = SurgicalOperationNotesShortVoAssembler.createSurgicalOperationNotesShortVoCollectionFromSurgicalOperationNotes(result);
			
			if( tempColl != null && tempColl.size() > 0)
				return tempColl.get(0);
		}
		
		return null;
		
		
	}
}
