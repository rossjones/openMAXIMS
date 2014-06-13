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

public class EmergencyEpisodeForEDDischargeVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyEpisodeForEDDischargeVoBean()
	{
	}
	public EmergencyEpisodeForEDDischargeVoBean(ims.emergency.vo.EmergencyEpisodeForEDDischargeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.emergency.vo.beans.EpisodeOfCareForEDDischargeVoBean)vo.getEpisodeOfCare().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyEpisodeForEDDischargeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.emergency.vo.beans.EpisodeOfCareForEDDischargeVoBean)vo.getEpisodeOfCare().getBean(map);
	}

	public ims.emergency.vo.EmergencyEpisodeForEDDischargeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyEpisodeForEDDischargeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyEpisodeForEDDischargeVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyEpisodeForEDDischargeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyEpisodeForEDDischargeVo();
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
	public ims.emergency.vo.beans.EpisodeOfCareForEDDischargeVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.emergency.vo.beans.EpisodeOfCareForEDDischargeVoBean value)
	{
		this.episodeofcare = value;
	}

	private Integer id;
	private int version;
	private ims.emergency.vo.beans.EpisodeOfCareForEDDischargeVoBean episodeofcare;
}
