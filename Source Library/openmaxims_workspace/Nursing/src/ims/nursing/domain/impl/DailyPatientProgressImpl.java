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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2433.21597)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.assessment.configuration.vo.AssessmentQuestionRefVo;
import ims.assessment.configuration.vo.AssessmentQuestionRefVoCollection;
import ims.assessment.domain.PatientGraphicStages;
import ims.assessment.domain.impl.PatientGraphicStagesImpl;
import ims.assessment.instantiation.domain.objects.PatientAssessment;
import ims.assessment.instantiation.vo.PatientAssessmentRefVo;
import ims.assessment.vo.PatientAssessmentListVo;
import ims.assessment.vo.PatientAssessmentListVoCollection;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.domain.PatientAssessmentListVoAssembler;
import ims.assessment.vo.domain.PatientAssessmentVoAssembler;
import ims.assessment.vo.domain.UserAssessmentVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.nursing.domain.BradenScaleVIEW;
import ims.nursing.domain.InvasiveDevice;
import ims.nursing.domain.MUST;
import ims.nursing.domain.RepositioningPlan;
import ims.nursing.domain.base.impl.BaseDailyPatientProgressImpl;
import ims.nursing.domain.objects.PlanOfCare;
import ims.nursing.vo.BradenScale;
import ims.nursing.vo.MUSTVo;
import ims.nursing.vo.PatientInvasiveDeviceShortVoCollection;
import ims.nursing.vo.PlanOfCareVo;
import ims.nursing.vo.PlanOfCareVoCollection;
import ims.nursing.vo.RepositioningPlanVo;
import ims.nursing.vo.domain.PlanOfCareVoAssembler;
import ims.nursing.vo.lookups.PlanOfCareStatus;
import ims.vo.interfaces.IDPPItem;

import java.util.ArrayList;
import java.util.List;

public class DailyPatientProgressImpl extends BaseDailyPatientProgressImpl
{
	public ims.assessment.vo.UserAssessmentVo getCurrentDPPUserAssessment(ims.core.vo.lookups.UserDefinedAssessmentType assessmentType)
	{
		if(assessmentType == null)
			throw new CodingRuntimeException("Cannot get UserAssessmentVo for null UserDefinedAssessmentType");
		
		StringBuffer hql = new StringBuffer("from UserAssessment u ");
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " where ";
		
		hql.append(andStr + " u.activeStatus =:status");
		markers.add("status");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		andStr = " and ";
		
		if(assessmentType != null)
		{
			hql.append(andStr + " u.assessmentType =:assType");
			markers.add("assType");
			values.add(getDomLookup(assessmentType));
			andStr = " and ";
		}
		
		List list = getDomainFactory().find(hql.toString(), markers, values);
		if(list != null )
		{
			if(list.size() > 1)
				throw new CodingRuntimeException("More than one active DPP User Assessment found on the system.");
			else if(list.size() > 0)
				return UserAssessmentVoAssembler.createUserAssessmentVoCollectionFromUserAssessment(list).get(0);
		}

		return null;
	}

	public PatientAssessmentListVoCollection listPatientAssessments(CareContextRefVo careContextRefVo, UserDefinedAssessmentType assessmentType, Date dteDateFrom, Date dteDateTo)
	{
		if(careContextRefVo == null || careContextRefVo.getID_CareContext() == null)
			throw new RuntimeException("Cannot list PatientAssessments for null CareContextRefVo");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from PatientAssessment pa where pa.careContext.id =:RefId");
		ArrayList values  = new ArrayList();
		ArrayList params  = new ArrayList();
	
		values.add(careContextRefVo.getID_CareContext());
		params.add("RefId");
		
		if(assessmentType != null)
		{
			hql.append(" and ");
			hql.append("pa.assessmentData.userAssessment.assessmentType =:assType");
			values.add(getDomLookup(assessmentType));
			params.add("assType");	
		}
		if(dteDateFrom != null)
		{
			hql.append(" and ");
			hql.append(" pa.authoringInformation.authoringDateTime >= :dateFrom ");
			params.add("dateFrom");
			values.add(dteDateFrom.getDate());
		}
		if(dteDateTo != null)
		{
			hql.append(" and ");
			hql.append(" pa.authoringInformation.authoringDateTime <= :dateTo ");
			params.add("dateTo");
			Date d = (Date)dteDateTo.clone();
			values.add(d.addDay(1).getDate());
		}
				
		hql.append(" order by pa.authoringInformation.authoringDateTime desc");
		
		List list = factory.find(hql.toString(), params, values);
		return PatientAssessmentListVoAssembler.createPatientAssessmentListVoCollectionFromPatientAssessment(list).sort();
		
	}

	public PatientAssessmentVo getPatientAssessment(PatientAssessmentRefVo userAssessmentRefVo)
	{
		if(userAssessmentRefVo == null)
			throw new CodingRuntimeException("Cannot get PatientAssessmentRefVo for null UserAssessmentRefVo");
		DomainFactory factory = getDomainFactory();
		PatientAssessment doPatientAssessment = (PatientAssessment) factory.getDomainObject(ims.assessment.instantiation.domain.objects.PatientAssessment.class, userAssessmentRefVo.getID_PatientAssessment());
		return PatientAssessmentVoAssembler.create(doPatientAssessment);
	}

	public IDPPItem savePatientAssessment(PatientAssessmentVo patientAssessment, PlanOfCareVoCollection planOfCareCollection) throws StaleObjectException
	{
		if (patientAssessment == null)
			throw new CodingRuntimeException("Cannot save null PatientAssessmentVo");

		if (patientAssessment.isValidated() == false)
			throw new CodingRuntimeException("PatientAssessmentVo has not been validated");

		if (planOfCareCollection != null && planOfCareCollection.isValidated() == false)
			throw new CodingRuntimeException("PlanOfCareVoCollection have not been validated");

		DomainFactory factory = getDomainFactory();
		PatientAssessment doPatientAssessment = PatientAssessmentVoAssembler.extractPatientAssessment(factory, patientAssessment);
		factory.save(doPatientAssessment);

		int countNewCarePlan = 0;
		for (int i = 0; planOfCareCollection != null && i < planOfCareCollection.size(); i++)
		{
			PlanOfCareVo voPlanOfCare = planOfCareCollection.get(i);
			if (voPlanOfCare.getID_PlanOfCare() == null)
				countNewCarePlan++;
			PlanOfCare doPlanOfCare = PlanOfCareVoAssembler.extractPlanOfCare(factory, voPlanOfCare);
			factory.save(doPlanOfCare);
		}

		PatientAssessmentVo voPatAss = PatientAssessmentVoAssembler.create(doPatientAssessment);
		Integer newPlanOfCares = new Integer(countNewCarePlan);
		DPPItem item = new DPPItem(voPatAss, newPlanOfCares);

		return item;
	}

	public PlanOfCareVoCollection listPlanOfCare(CareContextRefVo careContext, AssessmentQuestionRefVoCollection assessmentQuestionRefVoColl)
	{
		if (careContext == null)
			throw new CodingRuntimeException("Cannot list PlanOfCareVoCollection for null Care Context");

		if (assessmentQuestionRefVoColl == null || assessmentQuestionRefVoColl.size() == 0)
			return null;

		StringBuffer query = new StringBuffer("from PlanOfCare poc where ");
		ArrayList values = new ArrayList();
		ArrayList params = new ArrayList();
		
		query.append(" poc.status is not :status ");
		params.add("status");
		values.add(getDomLookup(PlanOfCareStatus.RESOLVED));
		
		if(careContext != null)
		{
			if(values.size() > 0)
				query.append(" and ");
			query.append("poc.careContext.id =:careContextID");
			params.add("careContextID");
			values.add(careContext.getID_CareContext());
		}

		if(assessmentQuestionRefVoColl != null  && assessmentQuestionRefVoColl.size() > 0)
		{
			if (values.size() > 0)
				query.append(" and ");
			query.append(" poc.assessmentQuestion.id in ");
			query.append("(");
			for (int i = 0; i < assessmentQuestionRefVoColl.size(); i++)
			{
				AssessmentQuestionRefVo voAssQ = assessmentQuestionRefVoColl.get(i);
				query.append(" :assQId" + Integer.toString(i));
				if (i < (assessmentQuestionRefVoColl.size() - 1))
					query.append(", ");
				params.add("assQId" + Integer.toString(i));
				values.add(voAssQ.getID_AssessmentQuestion());
			}
			query.append(")");
		}
		
		DomainFactory factory = getDomainFactory();
		List list = factory.find(query.toString(), params, values);
		
		return PlanOfCareVoAssembler.createPlanOfCareVoCollectionFromPlanOfCare(list);
	}
	
	public class DPPItem implements IDPPItem
	{
		PatientAssessmentVo voPatAss = null;
		Integer countSavedNewPlanOfCares = null;
		public DPPItem(PatientAssessmentVo voPatAss, Integer planOfCares)
		{
			this.voPatAss = voPatAss;
			this.countSavedNewPlanOfCares = planOfCares;
		}
		
		public PatientAssessmentVo getPatientAssessment()
		{
			return this.voPatAss;
		}

		public Integer getNewPlanOfCareSaved()
		{
			return this.countSavedNewPlanOfCares;
		}

		public int compareTo(Object obj)
		{
			if (obj == null)
			{
				return -1;
			}
			if (!(DPPItem.class.isAssignableFrom(obj.getClass())))
			{
				throw new ClassCastException("A DPPItem object cannot be compared an Object of type " + obj.getClass().getName());
			}
			DPPItem compareObj = (DPPItem)obj;
			int retVal = 0;
			if (retVal == 0)
			{
				if(this.getPatientAssessment() == null && compareObj.getPatientAssessment() != null)
					return -1;
				if(this.getPatientAssessment() != null && compareObj.getPatientAssessment() == null)
					return 1;
				if(this.getPatientAssessment() != null && compareObj.getPatientAssessment() != null)
					retVal = this.getPatientAssessment().compareTo(compareObj.getPatientAssessment());
			}
			return retVal;
		}
	}

	public PatientInvasiveDeviceShortVoCollection listCurrentPatientInvasiveDevice(CareContextRefVo careContext)
	{
		InvasiveDevice implInvasiveDevice = (InvasiveDevice) getDomainImpl(InvasiveDeviceImpl.class);
		return implInvasiveDevice.listCurrentPatientInvasiveDevice(careContext);
	}

	public BradenScale getLastCompletedBradenScale(CareContextRefVo careContextRefVo)
	{
		BradenScaleVIEW BradenScaleViewImpl = (BradenScaleVIEW) getDomainImpl(BradenScaleVIEWImpl.class);
		return BradenScaleViewImpl.getLastCompletedBradenScale(careContextRefVo);
	}

	public MUSTVo getLastComplementedMustRecord(CareContextRefVo careContextRefVo)
	{
		MUST mustDommainImpl = (MUST) getDomainImpl(MUSTImpl.class);
		return mustDommainImpl.getLastComplementedMustRecord(careContextRefVo);
	}

	public PatientAssessmentListVo getLastCompletedAssessment(UserDefinedAssessmentType type, CareContextRefVo careContext, Boolean isCurrentForType)
	{
		PatientGraphicStages patientGraphicStagesImpl = (PatientGraphicStages) getDomainImpl(PatientGraphicStagesImpl.class);
		return patientGraphicStagesImpl.getLastCompletedAssessment(type, careContext, isCurrentForType);
	}

	public RepositioningPlanVo getLastCompletedRepositioningPlan(CareContextRefVo voCareContextRef)
	{
		RepositioningPlan repositioningPlanImpl = (RepositioningPlan) getDomainImpl(RepositioningPlanImpl.class);
		return repositioningPlanImpl.getLastCompletedRepositioningPlan(voCareContextRef);
	}

	//WDEV-12215
	public PatientAssessmentListVo getLastStructuredAssessment(UserDefinedAssessmentType type, CareContextRefVo careContext)
	{
		List list = getDomainFactory().find("from PatientAssessment as p1_1 where p1_1.assessmentData.userAssessment.assessmentType.id = :TYPE and p1_1.careContext.id = :CARE_CONTEXT order by p1_1.authoringInformation.authoringDateTime desc", new String[] {"TYPE", "CARE_CONTEXT"}, new Object[] {new Integer(type.getID()), careContext.getID_CareContext()});
		
		//Get only the first record (to optimise the work of the assembler)
		if(list != null && list.size() > 1)
		{
			Object firstItem = list.get(0);
			list.removeAll(list);
			list.add(firstItem);
		}
		
		PatientAssessmentListVoCollection voColl = PatientAssessmentListVoAssembler.createPatientAssessmentListVoCollectionFromPatientAssessment(list);
		if(voColl != null && voColl.size() > 0)
			return voColl.get(0);
			
		return null;
	}
}
