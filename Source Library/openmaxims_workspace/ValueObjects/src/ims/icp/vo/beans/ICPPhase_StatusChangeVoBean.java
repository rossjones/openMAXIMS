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

package ims.icp.vo.beans;

public class ICPPhase_StatusChangeVoBean extends ims.vo.ValueObjectBean
{
	public ICPPhase_StatusChangeVoBean()
	{
	}
	public ICPPhase_StatusChangeVoBean(ims.icp.vo.ICPPhase_StatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.isactivatedoninitiation = vo.getIsActivatedOnInitiation();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
		this.sequence = vo.getSequence();
		this.name = vo.getName();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.ICPPhase_StatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.isactivatedoninitiation = vo.getIsActivatedOnInitiation();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
		this.sequence = vo.getSequence();
		this.name = vo.getName();
	}

	public ims.icp.vo.ICPPhase_StatusChangeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.ICPPhase_StatusChangeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.ICPPhase_StatusChangeVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.ICPPhase_StatusChangeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.ICPPhase_StatusChangeVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public Boolean getIsActivatedOnInitiation()
	{
		return this.isactivatedoninitiation;
	}
	public void setIsActivatedOnInitiation(Boolean value)
	{
		this.isactivatedoninitiation = value;
	}
	public ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] getActions()
	{
		return this.actions;
	}
	public void setActions(ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] value)
	{
		this.actions = value;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.sequence = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private Boolean isactivatedoninitiation;
	private ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] actions;
	private Integer sequence;
	private String name;
}
