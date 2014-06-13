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

public class LocationServiceVoBean extends ims.vo.ValueObjectBean
{
	public LocationServiceVoBean()
	{
	}
	public LocationServiceVoBean(ims.core.vo.LocationServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.contact = vo.getContact() == null ? null : (ims.core.vo.beans.ServiceContactVoBean)vo.getContact().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getLocation().getBean();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceVoBean)vo.getService().getBean();
		this.effectiveto = vo.getEffectiveTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffectiveTo().getBean();
		this.functions = vo.getFunctions() == null ? null : vo.getFunctions().getBeanCollection();
		this.activities = vo.getActivities() == null ? null : vo.getActivities().getBeanCollection();
		this.defaultprinter = vo.getDefaultPrinter();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.LocationServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.contact = vo.getContact() == null ? null : (ims.core.vo.beans.ServiceContactVoBean)vo.getContact().getBean(map);
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getLocation().getBean(map);
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceVoBean)vo.getService().getBean(map);
		this.effectiveto = vo.getEffectiveTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffectiveTo().getBean();
		this.functions = vo.getFunctions() == null ? null : vo.getFunctions().getBeanCollection();
		this.activities = vo.getActivities() == null ? null : vo.getActivities().getBeanCollection();
		this.defaultprinter = vo.getDefaultPrinter();
	}

	public ims.core.vo.LocationServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.LocationServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.LocationServiceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.LocationServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.LocationServiceVo();
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
	public ims.core.vo.beans.ServiceContactVoBean getContact()
	{
		return this.contact;
	}
	public void setContact(ims.core.vo.beans.ServiceContactVoBean value)
	{
		this.contact = value;
	}
	public ims.core.vo.beans.LocShortVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocShortVoBean value)
	{
		this.location = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.ServiceVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceVoBean value)
	{
		this.service = value;
	}
	public ims.framework.utils.beans.DateBean getEffectiveTo()
	{
		return this.effectiveto;
	}
	public void setEffectiveTo(ims.framework.utils.beans.DateBean value)
	{
		this.effectiveto = value;
	}
	public ims.core.vo.beans.LocationServiceFunctionsVoBean[] getFunctions()
	{
		return this.functions;
	}
	public void setFunctions(ims.core.vo.beans.LocationServiceFunctionsVoBean[] value)
	{
		this.functions = value;
	}
	public ims.core.vo.beans.LocationServiceActivityVoBean[] getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.core.vo.beans.LocationServiceActivityVoBean[] value)
	{
		this.activities = value;
	}
	public String getDefaultPrinter()
	{
		return this.defaultprinter;
	}
	public void setDefaultPrinter(String value)
	{
		this.defaultprinter = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceContactVoBean contact;
	private ims.core.vo.beans.LocShortVoBean location;
	private Boolean isactive;
	private ims.core.vo.beans.ServiceVoBean service;
	private ims.framework.utils.beans.DateBean effectiveto;
	private ims.core.vo.beans.LocationServiceFunctionsVoBean[] functions;
	private ims.core.vo.beans.LocationServiceActivityVoBean[] activities;
	private String defaultprinter;
}
