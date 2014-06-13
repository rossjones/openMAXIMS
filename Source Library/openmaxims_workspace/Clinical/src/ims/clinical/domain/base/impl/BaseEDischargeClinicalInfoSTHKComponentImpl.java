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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseEDischargeClinicalInfoSTHKComponentImpl extends DomainImpl implements ims.clinical.domain.EDischargeClinicalInfoSTHKComponent, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetClinicalInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveClinicalInfo(ims.core.vo.DischargeClinicalInformationSTHKVo voClinicalInfo, ims.edischarge.vo.SummaryRefVo summary)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHintByLookupID(ims.clinicaladmin.vo.lookups.EDischargeHINT voLookup)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistInvestigationResults(ims.core.patient.vo.PatientRefVo patientRefVo, Integer numDays)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatientAlerts(ims.core.vo.PatientShort patient, Boolean active)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDischargeDetails(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDischargeDetails(ims.clinical.vo.DischargeDetailsVo voDischargeDetails, ims.edischarge.vo.SummaryRefVo summary)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasDiagnosis(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasComorbidity(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasComplications(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validateisSectionComplete(ims.edischarge.vo.SummaryRefVo summary, ims.clinical.vo.lookups.EDischargeSummarySection section)
	{
		if(summary == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'summary' of type 'ims.edischarge.vo.SummaryRefVo' cannot be null.");
		if(section == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'section' of type 'ims.clinical.vo.lookups.EDischargeSummarySection' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistPendingResults(ims.core.patient.vo.PatientRefVo patient, ims.core.vo.CareContextShortVo careContext)
	{
	}
}
