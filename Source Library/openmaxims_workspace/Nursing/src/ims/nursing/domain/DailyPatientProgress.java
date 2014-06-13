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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.nursing.domain;

// Generated from form domain impl
public interface DailyPatientProgress extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* getCurrentDPPUserAssessment
	*/
	public ims.assessment.vo.UserAssessmentVo getCurrentDPPUserAssessment(ims.core.vo.lookups.UserDefinedAssessmentType assessmentType);

	// Generated from form domain interface definition
	/**
	* list Patient Assessments
	*/
	public ims.assessment.vo.PatientAssessmentListVoCollection listPatientAssessments(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.vo.lookups.UserDefinedAssessmentType assessmentType, ims.framework.utils.Date dteDateFrom, ims.framework.utils.Date dteDateTo);

	// Generated from form domain interface definition
	/**
	* getPatientAssessment
	*/
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo patientAssessmentRefVo);

	// Generated from form domain interface definition
	/**
	* savePatientAssessment
	*/
	public ims.vo.interfaces.IDPPItem savePatientAssessment(ims.assessment.vo.PatientAssessmentVo patientAssessment, ims.nursing.vo.PlanOfCareVoCollection planOfCareCollection) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list planOfCareCollection
	*/
	public ims.nursing.vo.PlanOfCareVoCollection listPlanOfCare(ims.core.admin.vo.CareContextRefVo careContext, ims.assessment.configuration.vo.AssessmentQuestionRefVoCollection assessmentQuestionRefVoColl);

	// Generated from form domain interface definition
	/**
	* list CurrentPatientInvasiveDeviceShortVoCollection
	*/
	public ims.nursing.vo.PatientInvasiveDeviceShortVoCollection listCurrentPatientInvasiveDevice(ims.core.admin.vo.CareContextRefVo careContext);

	// Generated from form domain interface definition
	/**
	* get last completed Braden Scale
	*/
	public ims.nursing.vo.BradenScale getLastCompletedBradenScale(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* getLastComplementedMustRecord
	*/
	public ims.nursing.vo.MUSTVo getLastComplementedMustRecord(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* getLastCompletedRepositioningPlan
	*/
	public ims.nursing.vo.RepositioningPlanVo getLastCompletedRepositioningPlan(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	/**
	* listAssessments
	*/
	public ims.assessment.vo.PatientAssessmentListVo getLastCompletedAssessment(ims.core.vo.lookups.UserDefinedAssessmentType type, ims.core.admin.vo.CareContextRefVo careContext, Boolean isCurrentForType);

	// Generated from form domain interface definition
	/**
	* get Last Structured Assessment
	*/
	public ims.assessment.vo.PatientAssessmentListVo getLastStructuredAssessment(ims.core.vo.lookups.UserDefinedAssessmentType type, ims.core.admin.vo.CareContextRefVo careContext);
}
