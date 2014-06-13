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

package ims.assessment.vo.beans;

public class Patient_AssessmentDataVoBean extends ims.vo.ValueObjectBean
{
	public Patient_AssessmentDataVoBean()
	{
	}
	public Patient_AssessmentDataVoBean(ims.assessment.vo.Patient_AssessmentDataVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.userassessment = vo.getUserAssessment() == null ? null : (ims.assessment.vo.beans.User_AssessmentVoBean)vo.getUserAssessment().getBean();
		this.answergroups = vo.getAnswerGroups() == null ? null : vo.getAnswerGroups().getBeanCollection();
		this.graphicfindings = vo.getGraphicFindings() == null ? null : vo.getGraphicFindings().getBeanCollection();
		this.graphicquestion = vo.getGraphicQuestion() == null ? null : vo.getGraphicQuestion().getBeanCollection();
		this.graphic = vo.getGraphic() == null ? null : (ims.assessment.vo.beans.Graphic_AssessmentVoBean)vo.getGraphic().getBean();
		this.groupquestionwidth = vo.getGroupQuestionWidth();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.Patient_AssessmentDataVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.userassessment = vo.getUserAssessment() == null ? null : (ims.assessment.vo.beans.User_AssessmentVoBean)vo.getUserAssessment().getBean(map);
		this.answergroups = vo.getAnswerGroups() == null ? null : vo.getAnswerGroups().getBeanCollection();
		this.graphicfindings = vo.getGraphicFindings() == null ? null : vo.getGraphicFindings().getBeanCollection();
		this.graphicquestion = vo.getGraphicQuestion() == null ? null : vo.getGraphicQuestion().getBeanCollection();
		this.graphic = vo.getGraphic() == null ? null : (ims.assessment.vo.beans.Graphic_AssessmentVoBean)vo.getGraphic().getBean(map);
		this.groupquestionwidth = vo.getGroupQuestionWidth();
	}

	public ims.assessment.vo.Patient_AssessmentDataVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.Patient_AssessmentDataVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.Patient_AssessmentDataVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.Patient_AssessmentDataVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.Patient_AssessmentDataVo();
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
	public ims.assessment.vo.beans.User_AssessmentVoBean getUserAssessment()
	{
		return this.userassessment;
	}
	public void setUserAssessment(ims.assessment.vo.beans.User_AssessmentVoBean value)
	{
		this.userassessment = value;
	}
	public ims.assessment.vo.beans.Patient_AssessmentGroupVoBean[] getAnswerGroups()
	{
		return this.answergroups;
	}
	public void setAnswerGroups(ims.assessment.vo.beans.Patient_AssessmentGroupVoBean[] value)
	{
		this.answergroups = value;
	}
	public ims.assessment.vo.beans.Patient_GraphicAssessmentVoBean[] getGraphicFindings()
	{
		return this.graphicfindings;
	}
	public void setGraphicFindings(ims.assessment.vo.beans.Patient_GraphicAssessmentVoBean[] value)
	{
		this.graphicfindings = value;
	}
	public ims.assessment.vo.beans.Patient_GraphicAssessmentQuestionAnswerVoBean[] getGraphicQuestion()
	{
		return this.graphicquestion;
	}
	public void setGraphicQuestion(ims.assessment.vo.beans.Patient_GraphicAssessmentQuestionAnswerVoBean[] value)
	{
		this.graphicquestion = value;
	}
	public ims.assessment.vo.beans.Graphic_AssessmentVoBean getGraphic()
	{
		return this.graphic;
	}
	public void setGraphic(ims.assessment.vo.beans.Graphic_AssessmentVoBean value)
	{
		this.graphic = value;
	}
	public Integer getGroupQuestionWidth()
	{
		return this.groupquestionwidth;
	}
	public void setGroupQuestionWidth(Integer value)
	{
		this.groupquestionwidth = value;
	}

	private Integer id;
	private int version;
	private ims.assessment.vo.beans.User_AssessmentVoBean userassessment;
	private ims.assessment.vo.beans.Patient_AssessmentGroupVoBean[] answergroups;
	private ims.assessment.vo.beans.Patient_GraphicAssessmentVoBean[] graphicfindings;
	private ims.assessment.vo.beans.Patient_GraphicAssessmentQuestionAnswerVoBean[] graphicquestion;
	private ims.assessment.vo.beans.Graphic_AssessmentVoBean graphic;
	private Integer groupquestionwidth;
}
