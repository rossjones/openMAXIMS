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

package ims.clinical.domain;

// Generated from form domain impl
public interface Procedures extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listProcedureByClinalContact
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByClinalContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* listProcedureByPatient
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByPatient(ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	/**
	* listProcedure by clinical contact
	*/
	public ims.core.vo.PatientProcedureShortListVoCollection listProcedure(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* getProcedure
	*/
	public ims.core.vo.PatientProcedureVo getProcedure(ims.core.clinical.vo.PatientProcedureRefVo patientProcedureRefVo);

	// Generated from form domain interface definition
	/**
	* savePlannedProcedure
	*/
	public ims.core.vo.PatientProcedureVo savePlannedProcedure(ims.core.vo.PatientProcedureVo voPatientProcedure, ims.core.vo.PatientShort patientShortVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* listProceduresByCareContext
	*/
	public ims.core.vo.PatientProcedureShortListVoCollection listProceduresByCareContext(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByEpisodeOfCare
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareSpell
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareSpell(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareContextPatientSummary
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareContextPatientSummary(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByEpisodeOfCareShortList
	*/
	public ims.core.vo.PatientProcedureShortListVoCollection listProceduresByEpisodeOfCareShortList(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listHotlistProcedureShort
	*/
	public ims.core.vo.ProcedureLiteVoCollection listHotlistProcedureShort(String procedureName, ims.core.vo.lookups.Specialty specialty) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* list Procedure by Patient and Status
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByPatientAndStatus(ims.core.patient.vo.PatientRefVo patientRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProcedureByClinalContactAndStatus
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByClinicalContactAndStatus(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareContextPatientSummaryAndStatus
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareContextPatientSummaryAndStatus(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProceduresByEpisodeOfCareAndStatus
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByEpisodeOfCareAndStatus(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareSpell
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareSpellAndStatus(ims.core.admin.vo.CareSpellRefVo careSpellRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* saveClinicalDiAssociation
	*/
	public ims.clinical.vo.ClinicalDIAssociationVoCollection saveClinicalDiAssociation(ims.clinical.vo.ClinicalDIAssociationVoCollection list) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Check if there are CDI Assocaitions
	*/
	public Boolean checkIfClinicalCDIAssociationsExist(ims.core.clinical.vo.PatientProcedureRefVo voPatientProcedure);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	/**
	* listProcedureShortListVoByPatient
	*/
	public ims.core.vo.PatientProcedureShortListVoCollection listProcedureShortListVoByPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.clinical.vo.IntraOperativeCareRecordVo getIntraOperativeCareRecord(ims.core.clinical.vo.IntraOperativeCareRecordRefVo refVo);
}
