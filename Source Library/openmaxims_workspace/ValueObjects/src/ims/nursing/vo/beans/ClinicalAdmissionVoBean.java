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

public class ClinicalAdmissionVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalAdmissionVoBean()
	{
	}
	public ClinicalAdmissionVoBean(ims.nursing.vo.ClinicalAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.admittingnurse = vo.getAdmittingNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAdmittingNurse().getBean();
		this.dischargeddatetime = vo.getDischargedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargedDateTime().getBean();
		this.dischargedby = vo.getDischargedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getDischargedBy().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.clientunderstanding = vo.getClientUnderstanding();
		this.socialcircumstance = vo.getSocialCircumstance();
		this.admissionchecklist = vo.getAdmissionChecklist() == null ? null : vo.getAdmissionChecklist().getBeanCollection();
		this.confirmeddatetime = vo.getConfirmedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDateTime().getBean();
		this.confirmedby = vo.getConfirmedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getConfirmedBy().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.ClinicalAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.admittingnurse = vo.getAdmittingNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAdmittingNurse().getBean(map);
		this.dischargeddatetime = vo.getDischargedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargedDateTime().getBean();
		this.dischargedby = vo.getDischargedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getDischargedBy().getBean(map);
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.clientunderstanding = vo.getClientUnderstanding();
		this.socialcircumstance = vo.getSocialCircumstance();
		this.admissionchecklist = vo.getAdmissionChecklist() == null ? null : vo.getAdmissionChecklist().getBeanCollection();
		this.confirmeddatetime = vo.getConfirmedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDateTime().getBean();
		this.confirmedby = vo.getConfirmedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getConfirmedBy().getBean(map);
	}

	public ims.nursing.vo.ClinicalAdmissionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.ClinicalAdmissionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.ClinicalAdmissionVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.ClinicalAdmissionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.ClinicalAdmissionVo();
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
	public ims.core.vo.beans.NurseVoBean getAdmittingNurse()
	{
		return this.admittingnurse;
	}
	public void setAdmittingNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.admittingnurse = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargedDateTime()
	{
		return this.dischargeddatetime;
	}
	public void setDischargedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargeddatetime = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getDischargedBy()
	{
		return this.dischargedby;
	}
	public void setDischargedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.dischargedby = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public String getClientUnderstanding()
	{
		return this.clientunderstanding;
	}
	public void setClientUnderstanding(String value)
	{
		this.clientunderstanding = value;
	}
	public String getSocialCircumstance()
	{
		return this.socialcircumstance;
	}
	public void setSocialCircumstance(String value)
	{
		this.socialcircumstance = value;
	}
	public ims.nursing.vo.beans.AdmissionChecklistVoBean[] getAdmissionChecklist()
	{
		return this.admissionchecklist;
	}
	public void setAdmissionChecklist(ims.nursing.vo.beans.AdmissionChecklistVoBean[] value)
	{
		this.admissionchecklist = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConfirmedDateTime()
	{
		return this.confirmeddatetime;
	}
	public void setConfirmedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.confirmeddatetime = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getConfirmedBy()
	{
		return this.confirmedby;
	}
	public void setConfirmedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.confirmedby = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.NurseVoBean admittingnurse;
	private ims.framework.utils.beans.DateTimeBean dischargeddatetime;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean dischargedby;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private String clientunderstanding;
	private String socialcircumstance;
	private ims.nursing.vo.beans.AdmissionChecklistVoBean[] admissionchecklist;
	private ims.framework.utils.beans.DateTimeBean confirmeddatetime;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean confirmedby;
}
