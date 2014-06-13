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

package ims.careuk.vo.beans;

public class ReferralTransferVoBean extends ims.vo.ValueObjectBean
{
	public ReferralTransferVoBean()
	{
	}
	public ReferralTransferVoBean(ims.careuk.vo.ReferralTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.rttstatusdate = vo.getRTTStatusDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRTTStatusDate().getBean();
		this.otherpatientnumber = vo.getOtherPatientNumber();
		this.otherorganisationcode = vo.getOTherOrganisationCode();
		this.currentrttstatus = vo.getCurrentRTTStatus() == null ? null : (ims.pathways.vo.beans.RTTStatusPointVoBean)vo.getCurrentRTTStatus().getBean();
		this.pathwayid = vo.getPathwayID();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ReferralTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.rttstatusdate = vo.getRTTStatusDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRTTStatusDate().getBean();
		this.otherpatientnumber = vo.getOtherPatientNumber();
		this.otherorganisationcode = vo.getOTherOrganisationCode();
		this.currentrttstatus = vo.getCurrentRTTStatus() == null ? null : (ims.pathways.vo.beans.RTTStatusPointVoBean)vo.getCurrentRTTStatus().getBean(map);
		this.pathwayid = vo.getPathwayID();
	}

	public ims.careuk.vo.ReferralTransferVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ReferralTransferVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ReferralTransferVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ReferralTransferVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ReferralTransferVo();
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
	public ims.framework.utils.beans.DateBean getRTTStatusDate()
	{
		return this.rttstatusdate;
	}
	public void setRTTStatusDate(ims.framework.utils.beans.DateBean value)
	{
		this.rttstatusdate = value;
	}
	public String getOtherPatientNumber()
	{
		return this.otherpatientnumber;
	}
	public void setOtherPatientNumber(String value)
	{
		this.otherpatientnumber = value;
	}
	public String getOTherOrganisationCode()
	{
		return this.otherorganisationcode;
	}
	public void setOTherOrganisationCode(String value)
	{
		this.otherorganisationcode = value;
	}
	public ims.pathways.vo.beans.RTTStatusPointVoBean getCurrentRTTStatus()
	{
		return this.currentrttstatus;
	}
	public void setCurrentRTTStatus(ims.pathways.vo.beans.RTTStatusPointVoBean value)
	{
		this.currentrttstatus = value;
	}
	public String getPathwayID()
	{
		return this.pathwayid;
	}
	public void setPathwayID(String value)
	{
		this.pathwayid = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean rttstatusdate;
	private String otherpatientnumber;
	private String otherorganisationcode;
	private ims.pathways.vo.beans.RTTStatusPointVoBean currentrttstatus;
	private String pathwayid;
}
