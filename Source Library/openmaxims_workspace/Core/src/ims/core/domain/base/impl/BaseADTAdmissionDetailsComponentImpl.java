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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseADTAdmissionDetailsComponentImpl extends DomainImpl implements ims.core.domain.ADTAdmissionDetailsComponent, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetAdmissionDetail(ims.core.patient.vo.PatientRefVo patientRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistEpisodesOfCare(ims.core.patient.vo.PatientRefVo patientRef, ims.framework.utils.Date admissionDate)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcp(Integer hcpId)
	{
	}

	@SuppressWarnings("unused")
	public void validateadmitPatient(ims.core.vo.PatientShort patVo, ims.core.vo.InpatientEpisodeVo episVo, ims.core.vo.CareContextVo careContext, ims.core.vo.EpisodeofCareVo episodeOfCare, ims.core.vo.CareSpellVo careSpell)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpecialtyForConsultant(Integer mosID)
	{
	}

	@SuppressWarnings("unused")
	public void validategetEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfcareRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInpatientEpisode(ims.core.admin.pas.vo.PASEventRefVo pasEventRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmissionTypeFromInpatientEpisode(ims.core.admin.pas.vo.PASEventRefVo pasEventRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContext(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateisPatientDischarged(ims.core.admin.pas.vo.AdmissionDetailRefVo admissionDetRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareSpell(ims.core.admin.vo.CareSpellRefVo careSpellRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmissionTypeFromDischargedEpisode(ims.core.admin.pas.vo.PASEventRefVo pasEventRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmissionWard(ims.core.admin.pas.vo.PASEventRefVo pasEventRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.patient.vo.PatientRefVo patientRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateAdmissionDetails(ims.core.vo.InpatientEpisodeVo episVo, ims.core.vo.CareContextShortVo careContextVo)
	{
	}
}
