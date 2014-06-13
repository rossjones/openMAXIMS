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

package ims.nursing.vo.beans;

public class PlanOfCareListVoBean extends ims.vo.ValueObjectBean
{
	public PlanOfCareListVoBean()
	{
	}
	public PlanOfCareListVoBean(ims.nursing.vo.PlanOfCareListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.group = vo.getGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getGroup().getBean();
		this.title = vo.getTitle();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.resolveddatetime = vo.getResolvedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getResolvedDateTime().getBean();
		this.assessmentquestion = vo.getAssessmentQuestion() == null ? null : (ims.core.vo.beans.AssessmentQuestionShortVoBean)vo.getAssessmentQuestion().getBean();
		this.levelofintervention = vo.getLevelOfIntervention() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLevelOfIntervention().getBean();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.PlanOfCareListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.group = vo.getGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getGroup().getBean();
		this.title = vo.getTitle();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.resolveddatetime = vo.getResolvedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getResolvedDateTime().getBean();
		this.assessmentquestion = vo.getAssessmentQuestion() == null ? null : (ims.core.vo.beans.AssessmentQuestionShortVoBean)vo.getAssessmentQuestion().getBean(map);
		this.levelofintervention = vo.getLevelOfIntervention() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLevelOfIntervention().getBean();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
	}

	public ims.nursing.vo.PlanOfCareListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.PlanOfCareListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.PlanOfCareListVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.PlanOfCareListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.PlanOfCareListVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getGroup()
	{
		return this.group;
	}
	public void setGroup(ims.vo.LookupInstanceBean value)
	{
		this.group = value;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String value)
	{
		this.title = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.startdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getResolvedDateTime()
	{
		return this.resolveddatetime;
	}
	public void setResolvedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.resolveddatetime = value;
	}
	public ims.core.vo.beans.AssessmentQuestionShortVoBean getAssessmentQuestion()
	{
		return this.assessmentquestion;
	}
	public void setAssessmentQuestion(ims.core.vo.beans.AssessmentQuestionShortVoBean value)
	{
		this.assessmentquestion = value;
	}
	public ims.framework.utils.beans.ColorBean getLevelOfIntervention()
	{
		return this.levelofintervention;
	}
	public void setLevelOfIntervention(ims.framework.utils.beans.ColorBean value)
	{
		this.levelofintervention = value;
	}
	public ims.nursing.vo.beans.PlanOfCareActionsVoBean[] getActions()
	{
		return this.actions;
	}
	public void setActions(ims.nursing.vo.beans.PlanOfCareActionsVoBean[] value)
	{
		this.actions = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean group;
	private String title;
	private ims.framework.utils.beans.DateTimeBean startdatetime;
	private ims.framework.utils.beans.DateTimeBean resolveddatetime;
	private ims.core.vo.beans.AssessmentQuestionShortVoBean assessmentquestion;
	private ims.framework.utils.beans.ColorBean levelofintervention;
	private ims.nursing.vo.beans.PlanOfCareActionsVoBean[] actions;
}