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

public class SurgicalAuditPreOpChecksTheatreNurseVoBean extends ims.vo.ValueObjectBean
{
	public SurgicalAuditPreOpChecksTheatreNurseVoBean()
	{
	}
	public SurgicalAuditPreOpChecksTheatreNurseVoBean(ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.theatrename = vo.getTheatreName() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getTheatreName().getBean();
		this.comments = vo.getComments();
		this.operationtype = vo.getOperationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getOperationType().getBean();
		this.accompanyingtheatrenurse = vo.getAccompanyingTheatreNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAccompanyingTheatreNurse().getBean();
		this.accompanyingtheatrenurselocumbool = vo.getAccompanyingTheatreNurseLocumBool();
		this.accompanyingtheatrenurselocumnurse = vo.getAccompanyingTheatreNurseLocumNurse();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.theatrename = vo.getTheatreName() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getTheatreName().getBean(map);
		this.comments = vo.getComments();
		this.operationtype = vo.getOperationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getOperationType().getBean();
		this.accompanyingtheatrenurse = vo.getAccompanyingTheatreNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAccompanyingTheatreNurse().getBean(map);
		this.accompanyingtheatrenurselocumbool = vo.getAccompanyingTheatreNurseLocumBool();
		this.accompanyingtheatrenurselocumnurse = vo.getAccompanyingTheatreNurseLocumNurse();
	}

	public ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.SurgicalAuditPreOpChecksTheatreNurseVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
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
	public ims.core.vo.beans.LocationLiteVoBean getTheatreName()
	{
		return this.theatrename;
	}
	public void setTheatreName(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.theatrename = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.vo.LookupInstanceBean getOperationType()
	{
		return this.operationtype;
	}
	public void setOperationType(ims.vo.LookupInstanceBean value)
	{
		this.operationtype = value;
	}
	public ims.core.vo.beans.NurseVoBean getAccompanyingTheatreNurse()
	{
		return this.accompanyingtheatrenurse;
	}
	public void setAccompanyingTheatreNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.accompanyingtheatrenurse = value;
	}
	public Boolean getAccompanyingTheatreNurseLocumBool()
	{
		return this.accompanyingtheatrenurselocumbool;
	}
	public void setAccompanyingTheatreNurseLocumBool(Boolean value)
	{
		this.accompanyingtheatrenurselocumbool = value;
	}
	public String getAccompanyingTheatreNurseLocumNurse()
	{
		return this.accompanyingtheatrenurselocumnurse;
	}
	public void setAccompanyingTheatreNurseLocumNurse(String value)
	{
		this.accompanyingtheatrenurselocumnurse = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.LocationLiteVoBean theatrename;
	private String comments;
	private ims.vo.LookupInstanceBean operationtype;
	private ims.core.vo.beans.NurseVoBean accompanyingtheatrenurse;
	private Boolean accompanyingtheatrenurselocumbool;
	private String accompanyingtheatrenurselocumnurse;
}
