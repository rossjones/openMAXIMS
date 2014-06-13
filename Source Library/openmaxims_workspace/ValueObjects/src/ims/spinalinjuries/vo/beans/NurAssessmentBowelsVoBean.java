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

package ims.spinalinjuries.vo.beans;

public class NurAssessmentBowelsVoBean extends ims.vo.ValueObjectBean
{
	public NurAssessmentBowelsVoBean()
	{
	}
	public NurAssessmentBowelsVoBean(ims.spinalinjuries.vo.NurAssessmentBowelsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean();
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.usualbowelpattern = vo.getUsualBowelPattern() == null ? null : (ims.vo.LookupInstanceBean)vo.getUsualBowelPattern().getBean();
		this.timeofday = vo.getTimeOfDay() == null ? null : (ims.vo.LookupInstanceBean)vo.getTimeOfDay().getBean();
		this.bowelroutineperformedin = vo.getBowelRoutinePerformedIn() == null ? null : (ims.vo.LookupInstanceBean)vo.getBowelRoutinePerformedIn().getBean();
		this.bowelroutineperformedby = vo.getBowelRoutinePerformedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getBowelRoutinePerformedBy().getBean();
		this.bowelsopenspontaneously = vo.getBowelsOpenSpontaneously() == null ? null : (ims.vo.LookupInstanceBean)vo.getBowelsOpenSpontaneously().getBean();
		this.notes = vo.getNotes();
		this.bowelmedication = vo.getBowelMedication() == null ? null : vo.getBowelMedication().getBeanCollection();
		this.ostomydetails = vo.getOstomyDetails() == null ? null : (ims.nursing.vo.beans.BowelOstomyVoBean)vo.getOstomyDetails().getBean();
		this.sufferfrom = vo.getSufferFrom() == null ? null : vo.getSufferFrom().getBeanCollection();
		this.bowelregime = vo.getBowelRegime() == null ? null : vo.getBowelRegime().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.NurAssessmentBowelsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean(map);
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.usualbowelpattern = vo.getUsualBowelPattern() == null ? null : (ims.vo.LookupInstanceBean)vo.getUsualBowelPattern().getBean();
		this.timeofday = vo.getTimeOfDay() == null ? null : (ims.vo.LookupInstanceBean)vo.getTimeOfDay().getBean();
		this.bowelroutineperformedin = vo.getBowelRoutinePerformedIn() == null ? null : (ims.vo.LookupInstanceBean)vo.getBowelRoutinePerformedIn().getBean();
		this.bowelroutineperformedby = vo.getBowelRoutinePerformedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getBowelRoutinePerformedBy().getBean();
		this.bowelsopenspontaneously = vo.getBowelsOpenSpontaneously() == null ? null : (ims.vo.LookupInstanceBean)vo.getBowelsOpenSpontaneously().getBean();
		this.notes = vo.getNotes();
		this.bowelmedication = vo.getBowelMedication() == null ? null : vo.getBowelMedication().getBeanCollection();
		this.ostomydetails = vo.getOstomyDetails() == null ? null : (ims.nursing.vo.beans.BowelOstomyVoBean)vo.getOstomyDetails().getBean(map);
		this.sufferfrom = vo.getSufferFrom() == null ? null : vo.getSufferFrom().getBeanCollection();
		this.bowelregime = vo.getBowelRegime() == null ? null : vo.getBowelRegime().getBeanCollection();
	}

	public ims.spinalinjuries.vo.NurAssessmentBowelsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.spinalinjuries.vo.NurAssessmentBowelsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.NurAssessmentBowelsVo vo = null;
		if(map != null)
			vo = (ims.spinalinjuries.vo.NurAssessmentBowelsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.spinalinjuries.vo.NurAssessmentBowelsVo();
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
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.iscomplete = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean[] getAssessmentInfo()
	{
		return this.assessmentinfo;
	}
	public void setAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean[] value)
	{
		this.assessmentinfo = value;
	}
	public Boolean getCopy()
	{
		return this.copy;
	}
	public void setCopy(Boolean value)
	{
		this.copy = value;
	}
	public ims.vo.LookupInstanceBean getComponentType()
	{
		return this.componenttype;
	}
	public void setComponentType(ims.vo.LookupInstanceBean value)
	{
		this.componenttype = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean getLastAssessmentInfo()
	{
		return this.lastassessmentinfo;
	}
	public void setLastAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean value)
	{
		this.lastassessmentinfo = value;
	}
	public ims.nursing.vo.beans.CarePlanTemplateBean[] getCarePlanTemplate()
	{
		return this.careplantemplate;
	}
	public void setCarePlanTemplate(ims.nursing.vo.beans.CarePlanTemplateBean[] value)
	{
		this.careplantemplate = value;
	}
	public ims.nursing.vo.beans.CarePlanBean[] getCarePlans()
	{
		return this.careplans;
	}
	public void setCarePlans(ims.nursing.vo.beans.CarePlanBean[] value)
	{
		this.careplans = value;
	}
	public ims.vo.LookupInstanceBean getUsualBowelPattern()
	{
		return this.usualbowelpattern;
	}
	public void setUsualBowelPattern(ims.vo.LookupInstanceBean value)
	{
		this.usualbowelpattern = value;
	}
	public ims.vo.LookupInstanceBean getTimeOfDay()
	{
		return this.timeofday;
	}
	public void setTimeOfDay(ims.vo.LookupInstanceBean value)
	{
		this.timeofday = value;
	}
	public ims.vo.LookupInstanceBean getBowelRoutinePerformedIn()
	{
		return this.bowelroutineperformedin;
	}
	public void setBowelRoutinePerformedIn(ims.vo.LookupInstanceBean value)
	{
		this.bowelroutineperformedin = value;
	}
	public ims.vo.LookupInstanceBean getBowelRoutinePerformedBy()
	{
		return this.bowelroutineperformedby;
	}
	public void setBowelRoutinePerformedBy(ims.vo.LookupInstanceBean value)
	{
		this.bowelroutineperformedby = value;
	}
	public ims.vo.LookupInstanceBean getBowelsOpenSpontaneously()
	{
		return this.bowelsopenspontaneously;
	}
	public void setBowelsOpenSpontaneously(ims.vo.LookupInstanceBean value)
	{
		this.bowelsopenspontaneously = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public ims.core.vo.beans.PatientMedicationVoBean[] getBowelMedication()
	{
		return this.bowelmedication;
	}
	public void setBowelMedication(ims.core.vo.beans.PatientMedicationVoBean[] value)
	{
		this.bowelmedication = value;
	}
	public ims.nursing.vo.beans.BowelOstomyVoBean getOstomyDetails()
	{
		return this.ostomydetails;
	}
	public void setOstomyDetails(ims.nursing.vo.beans.BowelOstomyVoBean value)
	{
		this.ostomydetails = value;
	}
	public ims.nursing.vo.beans.BowelDiarrhoeaConstipationVoBean[] getSufferFrom()
	{
		return this.sufferfrom;
	}
	public void setSufferFrom(ims.nursing.vo.beans.BowelDiarrhoeaConstipationVoBean[] value)
	{
		this.sufferfrom = value;
	}
	public ims.nursing.vo.beans.BowelRegimeVoBean[] getBowelRegime()
	{
		return this.bowelregime;
	}
	public void setBowelRegime(ims.nursing.vo.beans.BowelRegimeVoBean[] value)
	{
		this.bowelregime = value;
	}

	private Integer id;
	private int version;
	private Boolean iscomplete;
	private ims.nursing.vo.beans.AssessmentInfoBean[] assessmentinfo;
	private Boolean copy;
	private ims.vo.LookupInstanceBean componenttype;
	private ims.nursing.vo.beans.AssessmentInfoBean lastassessmentinfo;
	private ims.nursing.vo.beans.CarePlanTemplateBean[] careplantemplate;
	private ims.nursing.vo.beans.CarePlanBean[] careplans;
	private ims.vo.LookupInstanceBean usualbowelpattern;
	private ims.vo.LookupInstanceBean timeofday;
	private ims.vo.LookupInstanceBean bowelroutineperformedin;
	private ims.vo.LookupInstanceBean bowelroutineperformedby;
	private ims.vo.LookupInstanceBean bowelsopenspontaneously;
	private String notes;
	private ims.core.vo.beans.PatientMedicationVoBean[] bowelmedication;
	private ims.nursing.vo.beans.BowelOstomyVoBean ostomydetails;
	private ims.nursing.vo.beans.BowelDiarrhoeaConstipationVoBean[] sufferfrom;
	private ims.nursing.vo.beans.BowelRegimeVoBean[] bowelregime;
}
