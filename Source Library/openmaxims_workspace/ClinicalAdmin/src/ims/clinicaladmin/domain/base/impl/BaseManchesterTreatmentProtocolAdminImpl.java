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

package ims.clinicaladmin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseManchesterTreatmentProtocolAdminImpl extends DomainImpl implements ims.clinicaladmin.domain.ManchesterTreatmentProtocolAdmin, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistActiveProblems(String pcName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAssessments(String name, ims.core.vo.lookups.UserAssessmentCategory category, ims.core.vo.lookups.UserDefinedAssessmentType assessmentType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProblemTriageProtocols(Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveProblemTriageProtocol(ims.emergency.vo.ProblemTriageProtocolVo ptProtocolVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetProblemTriageProtocol(ims.emergency.configuration.vo.ProblemTriageProtocolRefVo probtriProtocolRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatecheckForConfiguredAssessment(ims.assessment.configuration.vo.UserAssessmentRefVo userAssessmentShortVoRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecheckForConfiguredClinicalProblem(ims.clinical.configuration.vo.ClinicalProblemRefVo clinicalProblemShortRefVo)
	{
	}
}
