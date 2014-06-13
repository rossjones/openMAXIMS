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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.ApplicationRoles;
import ims.admin.domain.impl.ApplicationRolesImpl;
import ims.assessment.configuration.domain.objects.UserAssessment;
import ims.assessment.configuration.vo.UserAssessmentRefVo;
import ims.assessment.vo.UserAssessmentVo;
import ims.assessment.vo.domain.UserAssessmentVoAssembler;
import ims.admin.vo.AppRoleShortVoCollection;
import ims.core.admin.domain.objects.TemplateBo;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.vo.TemplateBoLiteVo;
import ims.core.vo.domain.TemplateBoLiteVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;

public class UserAssessmentNewImpl extends DomainImpl implements ims.assessment.domain.UserAssessmentNew, ims.domain.impl.Transactional
{
	/**
	* saveAssessment
	*/
	
	public UserAssessmentVo getAssessment(Integer id)
	{
		if(id == null)
			throw new RuntimeException("Cannot get UserAssessmentVo for null id");
		DomainFactory factory = getDomainFactory();
		
		UserAssessment obj = (UserAssessment)factory.getDomainObject(UserAssessment.class, id);
		
		return UserAssessmentVoAssembler.create(obj);
	}
	
	public AppRoleShortVoCollection listRoles()
	{
		ApplicationRoles impl = (ApplicationRoles)getDomainImpl(ApplicationRolesImpl.class);
		if(impl != null)
			return impl.listRoles();
		return null;
	}

	public Boolean isExtraActiveThirdLevelAssessmentSaved(UserAssessmentRefVo userAssessmentRefVo, UserDefinedAssessmentType assessmentType)
	{
		if(assessmentType == null)
			throw new CodingRuntimeException("Cannot UserAssessment for null UserDefinedAssessmentType");
		
		StringBuffer hql = new StringBuffer("from UserAssessment u ");
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " where ";
		
		hql.append(andStr + " u.activeStatus =:status");
		markers.add("status");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		andStr = " and ";
		
		if(assessmentType != null)
		{
			hql.append(andStr + " u.assessmentType =:assType");
			markers.add("assType");
			values.add(getDomLookup(assessmentType));
			andStr = " and ";
		}
		
		if (userAssessmentRefVo != null && userAssessmentRefVo.getID_UserAssessmentIsNotNull())
		{
			hql.append(andStr);
			hql.append("u.id !=:uaId");
			markers.add("uaId");
			values.add(userAssessmentRefVo.getID_UserAssessment());
			andStr = " and ";
		}
			
		List list = getDomainFactory().find(hql.toString(), markers, values);
		return new Boolean(list != null && list.size() > 0?true:false);
	}

	public TemplateBoLiteVo getReportTemplate(TemplateBoRefVo refTemplate)
	{
		if(refTemplate == null)
			throw new CodingRuntimeException("Cannot get TemplateBoLiteVo for null TemplateBoRefVo");

		TemplateBo template = (TemplateBo) getDomainFactory().getDomainObject(TemplateBo.class, refTemplate.getID_TemplateBo());
		
		return TemplateBoLiteVoAssembler.create(template);
	}

	public UserAssessmentVo saveAssessment(UserAssessmentVo assessment)	throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{
		if(assessment.isValidated() == false)
			throw new DomainRuntimeException("UserAssessmentVo not validated");
		
		DomainFactory factory = getDomainFactory();
		UserAssessment obj = UserAssessmentVoAssembler.extractUserAssessment(factory, assessment);
		
		try
		{
			factory.save(obj);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("Already exists a question with this taxonomy code.", e);
		}
		
		return UserAssessmentVoAssembler.create(obj);
	}
}
