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

package ims.clinical.vo.beans;

public class InpatientEpisodeForVTERiskAsessmentVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeForVTERiskAsessmentVoBean()
	{
	}
	public InpatientEpisodeForVTERiskAsessmentVoBean(ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
	}

	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo();
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
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.vo.LookupInstanceBean getVTEAssessmentStatus()
	{
		return this.vteassessmentstatus;
	}
	public void setVTEAssessmentStatus(ims.vo.LookupInstanceBean value)
	{
		this.vteassessmentstatus = value;
	}
	public ims.vo.RefVoBean getVTERiskAssessment()
	{
		return this.vteriskassessment;
	}
	public void setVTERiskAssessment(ims.vo.RefVoBean value)
	{
		this.vteriskassessment = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.vo.LookupInstanceBean vteassessmentstatus;
	private ims.vo.RefVoBean vteriskassessment;
}
