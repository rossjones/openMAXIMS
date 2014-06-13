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

package ims.scheduling.vo.beans;

public class DirectoryOfServiceVoBean extends ims.vo.ValueObjectBean
{
	public DirectoryOfServiceVoBean()
	{
	}
	public DirectoryOfServiceVoBean(ims.scheduling.vo.DirectoryOfServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dosname = vo.getDoSName();
		this.dosid = vo.getDoSId();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean();
		this.functions = vo.getFunctions() == null ? null : vo.getFunctions().getBeanCollection();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.contract = vo.getContract() == null ? null : (ims.careuk.vo.beans.ContractConfigShortVoBean)vo.getContract().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.DirectoryOfServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dosname = vo.getDoSName();
		this.dosid = vo.getDoSId();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean(map);
		this.functions = vo.getFunctions() == null ? null : vo.getFunctions().getBeanCollection();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.contract = vo.getContract() == null ? null : (ims.careuk.vo.beans.ContractConfigShortVoBean)vo.getContract().getBean(map);
	}

	public ims.scheduling.vo.DirectoryOfServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.DirectoryOfServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.DirectoryOfServiceVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.DirectoryOfServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.DirectoryOfServiceVo();
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
	public String getDoSName()
	{
		return this.dosname;
	}
	public void setDoSName(String value)
	{
		this.dosname = value;
	}
	public String getDoSId()
	{
		return this.dosid;
	}
	public void setDoSId(String value)
	{
		this.dosid = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceShortVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.ServiceFunctionVoBean[] getFunctions()
	{
		return this.functions;
	}
	public void setFunctions(ims.core.vo.beans.ServiceFunctionVoBean[] value)
	{
		this.functions = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.careuk.vo.beans.ContractConfigShortVoBean getContract()
	{
		return this.contract;
	}
	public void setContract(ims.careuk.vo.beans.ContractConfigShortVoBean value)
	{
		this.contract = value;
	}

	private Integer id;
	private int version;
	private String dosname;
	private String dosid;
	private Boolean isactive;
	private ims.core.vo.beans.ServiceShortVoBean service;
	private ims.core.vo.beans.ServiceFunctionVoBean[] functions;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.careuk.vo.beans.ContractConfigShortVoBean contract;
}
