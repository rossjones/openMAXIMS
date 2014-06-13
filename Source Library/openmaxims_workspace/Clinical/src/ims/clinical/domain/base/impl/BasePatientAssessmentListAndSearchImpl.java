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

public abstract class BasePatientAssessmentListAndSearchImpl extends DomainImpl implements ims.clinical.domain.PatientAssessmentListAndSearch, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistPatientAssessments(ims.core.patient.vo.PatientRefVo patient, ims.core.vo.lookups.Specialty specialty, ims.core.resource.people.vo.HcpRefVo authoringHcp, ims.core.resource.people.vo.HcpRefVo responsibleHcp, String assessmentName, ims.core.vo.lookups.PatientAssessmentStatusReason status, ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, Boolean useEventDate)
	{
	}

	@SuppressWarnings("unused")
	public void validategetEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContact)
	{
	}
}
