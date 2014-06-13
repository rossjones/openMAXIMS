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

public class CareContextLiteVoBean extends ims.vo.ValueObjectBean
{
	public CareContextLiteVoBean()
	{
	}
	public CareContextLiteVoBean(ims.core.vo.CareContextLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventVoBean)vo.getPasEvent().getBean();
		this.context = vo.getContext() == null ? null : (ims.vo.LookupInstanceBean)vo.getContext().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.core.vo.beans.EpisodeofCareLiteVoBean)vo.getEpisodeOfCare().getBean();
		this.orderinghospital = vo.getOrderingHospital() == null ? null : new ims.vo.RefVoBean(vo.getOrderingHospital().getBoId(), vo.getOrderingHospital().getBoVersion());
		this.estimateddischargedate = vo.getEstimatedDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstimatedDischargeDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CareContextLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventVoBean)vo.getPasEvent().getBean(map);
		this.context = vo.getContext() == null ? null : (ims.vo.LookupInstanceBean)vo.getContext().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.core.vo.beans.EpisodeofCareLiteVoBean)vo.getEpisodeOfCare().getBean(map);
		this.orderinghospital = vo.getOrderingHospital() == null ? null : new ims.vo.RefVoBean(vo.getOrderingHospital().getBoId(), vo.getOrderingHospital().getBoVersion());
		this.estimateddischargedate = vo.getEstimatedDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstimatedDischargeDate().getBean();
	}

	public ims.core.vo.CareContextLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CareContextLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CareContextLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CareContextLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CareContextLiteVo();
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
	public ims.core.vo.beans.PasEventVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventVoBean value)
	{
		this.pasevent = value;
	}
	public ims.vo.LookupInstanceBean getContext()
	{
		return this.context;
	}
	public void setContext(ims.vo.LookupInstanceBean value)
	{
		this.context = value;
	}
	public ims.core.vo.beans.EpisodeofCareLiteVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.beans.EpisodeofCareLiteVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.vo.RefVoBean getOrderingHospital()
	{
		return this.orderinghospital;
	}
	public void setOrderingHospital(ims.vo.RefVoBean value)
	{
		this.orderinghospital = value;
	}
	public ims.framework.utils.beans.DateBean getEstimatedDischargeDate()
	{
		return this.estimateddischargedate;
	}
	public void setEstimatedDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.estimateddischargedate = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventVoBean pasevent;
	private ims.vo.LookupInstanceBean context;
	private ims.core.vo.beans.EpisodeofCareLiteVoBean episodeofcare;
	private ims.vo.RefVoBean orderinghospital;
	private ims.framework.utils.beans.DateBean estimateddischargedate;
}
