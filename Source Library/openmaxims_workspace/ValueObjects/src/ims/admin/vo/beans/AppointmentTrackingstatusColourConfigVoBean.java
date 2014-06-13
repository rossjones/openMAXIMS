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

package ims.admin.vo.beans;

public class AppointmentTrackingstatusColourConfigVoBean extends ims.vo.ValueObjectBean
{
	public AppointmentTrackingstatusColourConfigVoBean()
	{
	}
	public AppointmentTrackingstatusColourConfigVoBean(ims.admin.vo.AppointmentTrackingstatusColourConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.trackingstatus = vo.getTrackingStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTrackingStatus().getBean();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.idletimeinmins = vo.getIdleTimeInMins();
		this.idlecolour = vo.getIdleColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getIdleColour().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.AppointmentTrackingstatusColourConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.trackingstatus = vo.getTrackingStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTrackingStatus().getBean();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.idletimeinmins = vo.getIdleTimeInMins();
		this.idlecolour = vo.getIdleColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getIdleColour().getBean();
	}

	public ims.admin.vo.AppointmentTrackingstatusColourConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.AppointmentTrackingstatusColourConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.AppointmentTrackingstatusColourConfigVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.AppointmentTrackingstatusColourConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.AppointmentTrackingstatusColourConfigVo();
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
	public ims.vo.LookupInstanceBean getTrackingStatus()
	{
		return this.trackingstatus;
	}
	public void setTrackingStatus(ims.vo.LookupInstanceBean value)
	{
		this.trackingstatus = value;
	}
	public ims.framework.utils.beans.ColorBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.beans.ColorBean value)
	{
		this.colour = value;
	}
	public Integer getIdleTimeInMins()
	{
		return this.idletimeinmins;
	}
	public void setIdleTimeInMins(Integer value)
	{
		this.idletimeinmins = value;
	}
	public ims.framework.utils.beans.ColorBean getIdleColour()
	{
		return this.idlecolour;
	}
	public void setIdleColour(ims.framework.utils.beans.ColorBean value)
	{
		this.idlecolour = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean trackingstatus;
	private ims.framework.utils.beans.ColorBean colour;
	private Integer idletimeinmins;
	private ims.framework.utils.beans.ColorBean idlecolour;
}
