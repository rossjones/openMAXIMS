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

public class AppointmentHistoryForSummaryOverviewVoBean extends ims.vo.ValueObjectBean
{
	public AppointmentHistoryForSummaryOverviewVoBean()
	{
	}
	public AppointmentHistoryForSummaryOverviewVoBean(ims.core.vo.AppointmentHistoryForSummaryOverviewVo vo)
	{
		this.type = vo.getType();
		this.hcp = vo.getHcp() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getHcp().getBean();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.AppointmentHistoryForSummaryOverviewVo vo)
	{
		this.type = vo.getType();
		this.hcp = vo.getHcp() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getHcp().getBean(map);
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
	}

	public ims.core.vo.AppointmentHistoryForSummaryOverviewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.AppointmentHistoryForSummaryOverviewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.AppointmentHistoryForSummaryOverviewVo vo = null;
		if(map != null)
			vo = (ims.core.vo.AppointmentHistoryForSummaryOverviewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.AppointmentHistoryForSummaryOverviewVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getType()
	{
		return this.type;
	}
	public void setType(Integer value)
	{
		this.type = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.hcp = value;
	}
	public ims.framework.utils.beans.DateBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateBean value)
	{
		this.date = value;
	}

	private Integer type;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean hcp;
	private ims.framework.utils.beans.DateBean date;
}
