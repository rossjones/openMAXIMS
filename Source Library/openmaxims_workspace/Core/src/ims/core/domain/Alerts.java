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

package ims.core.domain;

// Generated from form domain impl
public interface Alerts extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Retrieves a Patient Specific List of Alerts
	*/
	public ims.core.vo.PatientAlertCollection listPatientAlerts(ims.core.vo.PatientShort patient, Boolean active);

	// Generated from form domain interface definition
	/**
	* Saves a Patient Alert
	*/
	public ims.core.vo.PatientAlert savePatientAlert(ims.core.vo.PatientAlert patientAlertItem, ims.core.vo.PatientNoAlertInfoVo patientNoAlertInfo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* List HCP's based on filter HCP passed in
	*/
	public ims.core.vo.HcpCollection listHCPs(ims.core.vo.HcpFilter hcpFilter);

	// Generated from form domain interface definition
	/**
	* getPatientAlert
	*/
	public ims.core.vo.PatientAlert getPatientAlert(ims.core.clinical.vo.PatientAlertRefVo patientalertRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.PatientNoAlertInfoVo getPatientNoAlertInfo(ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.PatientNoAlertInfoVo savePatientCoreClinicalData(ims.core.vo.PatientNoAlertInfoVo patientNoAlertInfo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Saves a Patient Alert
	*/
	public ims.core.vo.PatientAlert savePatientAlert(ims.core.vo.PatientAlert patientAlertItem) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public String getPIDDiagnosisInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.admin.vo.EpisodeOfCareRefVo episodeRefVo);

	// Generated from form domain interface definition
	/**
	* returns a collection of Alert strings that are mapped 
	*/
	public String[] listPatientAlertsTextByTaxonomy(ims.core.patient.vo.PatientRefVo patient, Boolean active, ims.core.vo.lookups.TaxonomyType type);

	// Generated from form domain interface definition
	/**
	* Saves a Patient Alert
	*/
	public Boolean saveHeartsAlert(ims.core.patient.vo.PatientRefVo patientRefVo, String pasMapping, Boolean isActive) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.vo.LookupInstVo getMappings(ims.vo.LookupInstVo instance);
}
