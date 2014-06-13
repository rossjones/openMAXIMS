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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface MedNeuroSensation extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.generalmedical.vo.NeuroSensationExaminationVo getNeuroSensationRecord(ims.core.vo.ClinicalContactShortVo voClinicalContact, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSensation);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.NeuroSensationExaminationVo saveNeuroSensationRecord(ims.generalmedical.vo.NeuroSensationExaminationVo exam) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.VertebrallevelVoCollection listVertebralLevel(Boolean activeOnly);

	// Generated from form domain interface definition
	/**
	* lists Sensations
	*/
	public ims.generalmedical.vo.NeuroSensationFindingsShortVoCollection listByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.NeuroSensationExaminationVo getNeuroSensationByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSensation);

	// Generated from form domain interface definition
	/**
	* checks if there is a Clinical Contact of type SpinalMedicalAdission that has a Sensation Exam within the CareContext, if so it will be displayed
	*/
	public ims.generalmedical.vo.NeuroSensationExaminationVo getSpinalMedicalAdmissionSensationByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	/**
	* List HCP's based on filter HCP passed in
	*/
	public ims.core.vo.HcpLiteVoCollection listHCPs(String strHcpName);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MedicalProbOnAdmisVo getPatientProblemByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalContact);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.NeuroSenastionFindingsVoCollection getNeuroSensationRecordCollByClinCont(ims.core.vo.ClinicalContactShortVo voClinicalContact, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSens);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MedicalProbOnAdmisVo getPatientProblemByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.NeuroSenastionFindingsVoCollection getNeuroSensationCollByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSensation);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.NeuroSenastionFindingsVoCollection getSpinalMedicalAdmissionSensationByCareContextColl(ims.core.admin.vo.CareContextRefVo voCareContextRef);
}
