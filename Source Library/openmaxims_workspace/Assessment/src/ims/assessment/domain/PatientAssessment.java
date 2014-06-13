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

package ims.assessment.domain;

// Generated from form domain impl
public interface PatientAssessment extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list Patient Assessments
	*/
	public ims.assessment.vo.PatientAssessmentListVoCollection listPatientAssessments(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* save Patient Assessment
	*/
	public ims.assessment.vo.PatientAssessmentVo savePatientAssessment(ims.assessment.vo.PatientAssessmentVo voPatientAssessment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* get Patient Assessment
	*/
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessment(Integer patientAssessmentId);

	// Generated from form domain interface definition
	/**
	* Patient Assessment List
	*/
	public ims.assessment.vo.PatientAssessmentListVo getPatientAssessmentList(Integer patAssessmentId);

	// Generated from form domain interface definition
	/**
	* Save Patient Assessment List
	*/
	public ims.assessment.vo.PatientAssessmentListVo savePatientAssessmentList(ims.assessment.vo.PatientAssessmentListVo voPatientAssessmentList) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list Patient User Defined Objects
	*/
	public ims.assessment.vo.PatientUserDefinedObjectListVoCollection listPatientUserDefinedObjects(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef, ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* savePatientUserDefinedObject
	*/
	public ims.assessment.vo.PatientUserDefinedObjectVo savePatientUserDefinedObject(ims.assessment.vo.PatientUserDefinedObjectVo voPatientUserDefinedObject) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getPatientUserDefinedObjectList
	*/
	public ims.assessment.vo.PatientUserDefinedObjectListVo getPatientUserDefinedObjectList(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo patientUserDefinedObjectRefVo);

	// Generated from form domain interface definition
	/**
	* getPatientUserDefinedObject
	*/
	public ims.assessment.vo.PatientUserDefinedObjectVo getPatientUserDefinedObject(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo patientUserDefinedObjectRefVo);

	// Generated from form domain interface definition
	/**
	* list Patient Assessments
	*/
	public ims.assessment.vo.PatientAssessmentListVoCollection listPatientAssessments(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.vo.lookups.UserDefinedAssessmentType assessmentType);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentListVoCollection getPatinetAssessmentListById(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo recordId);
}
