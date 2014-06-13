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
public interface MedicationMultipleDoses extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* lists Hcps
	*/
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* Save a Medication Overview Vo
	*/
	public ims.clinical.vo.MedicationOverViewVo saveMedicationOverviewVo(ims.clinical.vo.MedicationOverViewVo voMedicationOverviewVo, ims.core.patient.vo.PatientRefVo patientRefVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void markAsRIE(ims.core.vo.PatientMedicationVo medication, ims.core.vo.ClinicalContactShortVo clinicalContactShortVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	/**
	* getMedicationOverViewVo
	*/
	public ims.clinical.vo.MedicationOverViewVo getLatestMedicationOverViewVo(ims.clinical.vo.MedicationOverViewFilterVo overviewVo);

	// Generated from form domain interface definition
	/**
	* listMedicationOverviews for a Patient
	*/
	public ims.clinical.vo.MedicationOverViewLiteVoCollection listMedicationOverviews(ims.clinical.vo.MedicationOverViewFilterVo voMedicationViewFilter);

	// Generated from form domain interface definition
	/**
	* getMedicationOverView
	*/
	public ims.clinical.vo.MedicationOverViewVo getMedicationOverView(ims.clinical.vo.MedicationOverviewRefVo voRefMedication);

	// Generated from form domain interface definition
	public ims.core.vo.PatientMedicationVoCollection listMedications(ims.clinical.vo.MedicationOverviewRefVo medOverview);
}
