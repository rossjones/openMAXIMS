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

package ims.emergency.vo.beans;

public class TrackingConfigurationForTrackingVoBean extends ims.vo.ValueObjectBean
{
	public TrackingConfigurationForTrackingVoBean()
	{
	}
	public TrackingConfigurationForTrackingVoBean(ims.emergency.vo.TrackingConfigurationForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.isactive = vo.getIsActive();
		this.areacountrefreshrate = vo.getAreaCountRefreshRate();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingConfigurationForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.isactive = vo.getIsActive();
		this.areacountrefreshrate = vo.getAreaCountRefreshRate();
	}

	public ims.emergency.vo.TrackingConfigurationForTrackingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingConfigurationForTrackingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingConfigurationForTrackingVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingConfigurationForTrackingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingConfigurationForTrackingVo();
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
	public ims.vo.RefVoBean getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.vo.RefVoBean value)
	{
		this.edlocation = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public Integer getAreaCountRefreshRate()
	{
		return this.areacountrefreshrate;
	}
	public void setAreaCountRefreshRate(Integer value)
	{
		this.areacountrefreshrate = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean edlocation;
	private Boolean isactive;
	private Integer areacountrefreshrate;
}
