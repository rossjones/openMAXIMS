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

package ims.coe.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseAssessActivityLevelImpl extends DomainImpl implements ims.coe.domain.AssessActivityLevel, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetComponent(ims.nursing.assessment.vo.AssessmentComponentRefVo voRefAssessComp)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveComponent(ims.nursing.vo.AssessmentHeaderInfo assessmentVo, ims.nursing.vo.AssessmentComponent componentVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLastAssessmentComponent(ims.core.vo.PatientShort patientVo, ims.nursing.vo.lookups.AssessmentComponentType componentTypeVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetComponent(ims.core.clinical.vo.AssessmentRefVo assessmentVo, ims.nursing.vo.lookups.AssessmentComponentType componentType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAssessment(ims.core.admin.vo.CareContextRefVo careContextVo)
	{
	}
}
