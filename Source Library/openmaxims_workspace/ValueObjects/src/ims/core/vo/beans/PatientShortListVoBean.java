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

package ims.core.vo.beans;

public class PatientShortListVoBean extends ims.vo.ValueObjectBean
{
	public PatientShortListVoBean()
	{
	}
	public PatientShortListVoBean(ims.core.vo.PatientShortListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean();
		this.ward = vo.getWard() == null ? null : new ims.vo.RefVoBean(vo.getWard().getBoId(), vo.getWard().getBoVersion());
		this.identifiers = vo.getIdentifiers() == null ? null : vo.getIdentifiers().getBeanCollection();
		this.dod = vo.getDod() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDod().getBean();
		this.associatedpatient = vo.getAssociatedPatient() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedPatient().getBoId(), vo.getAssociatedPatient().getBoVersion());
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.patientalerts = vo.getPatientAlerts() == null ? null : vo.getPatientAlerts().getBeanCollection();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.age = vo.getAge();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientShortListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean(map);
		this.ward = vo.getWard() == null ? null : new ims.vo.RefVoBean(vo.getWard().getBoId(), vo.getWard().getBoVersion());
		this.identifiers = vo.getIdentifiers() == null ? null : vo.getIdentifiers().getBeanCollection();
		this.dod = vo.getDod() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDod().getBean();
		this.associatedpatient = vo.getAssociatedPatient() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedPatient().getBoId(), vo.getAssociatedPatient().getBoVersion());
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.patientalerts = vo.getPatientAlerts() == null ? null : vo.getPatientAlerts().getBeanCollection();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.age = vo.getAge();
	}

	public ims.core.vo.PatientShortListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientShortListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientShortListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientShortListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientShortListVo();
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
	public ims.core.vo.beans.PersonNameBean getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.beans.PersonNameBean value)
	{
		this.name = value;
	}
	public ims.vo.RefVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.vo.RefVoBean value)
	{
		this.ward = value;
	}
	public ims.core.vo.beans.PatientIdBean[] getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.beans.PatientIdBean[] value)
	{
		this.identifiers = value;
	}
	public ims.framework.utils.beans.DateBean getDod()
	{
		return this.dod;
	}
	public void setDod(ims.framework.utils.beans.DateBean value)
	{
		this.dod = value;
	}
	public ims.vo.RefVoBean getAssociatedPatient()
	{
		return this.associatedpatient;
	}
	public void setAssociatedPatient(ims.vo.RefVoBean value)
	{
		this.associatedpatient = value;
	}
	public ims.vo.LookupInstanceBean getSex()
	{
		return this.sex;
	}
	public void setSex(ims.vo.LookupInstanceBean value)
	{
		this.sex = value;
	}
	public ims.core.vo.beans.PatientAlertLiteVoBean[] getPatientAlerts()
	{
		return this.patientalerts;
	}
	public void setPatientAlerts(ims.core.vo.beans.PatientAlertLiteVoBean[] value)
	{
		this.patientalerts = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dob = value;
	}
	public Integer getAge()
	{
		return this.age;
	}
	public void setAge(Integer value)
	{
		this.age = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PersonNameBean name;
	private ims.vo.RefVoBean ward;
	private ims.core.vo.beans.PatientIdBean[] identifiers;
	private ims.framework.utils.beans.DateBean dod;
	private ims.vo.RefVoBean associatedpatient;
	private ims.vo.LookupInstanceBean sex;
	private ims.core.vo.beans.PatientAlertLiteVoBean[] patientalerts;
	private ims.framework.utils.beans.PartialDateBean dob;
	private Integer age;
}
