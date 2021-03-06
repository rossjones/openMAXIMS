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

package ims.racpc.vo.beans;

public class RACPCReferralVoBean extends ims.vo.ValueObjectBean
{
	public RACPCReferralVoBean()
	{
	}
	public RACPCReferralVoBean(ims.racpc.vo.RACPCReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : (ims.racpc.vo.beans.CareContextForRACPCReferralVoBean)vo.getCareContext().getBean();
		this.datereferralmade = vo.getDateReferralMade() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralMade().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.waitingtime = vo.getWaitingTime();
		this.referralreason = vo.getReferralReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralReason().getBean();
		this.delayreason = vo.getDelayReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReason().getBean();
		this.cardiologist = vo.getCardiologist() == null ? null : (ims.core.vo.beans.HcpBean)vo.getCardiologist().getBean();
		this.clinicdoctor = vo.getClinicDoctor() == null ? null : (ims.core.vo.beans.HcpBean)vo.getClinicDoctor().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.sourceofreferral = vo.getSourceofReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofReferral().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.racpc.vo.RACPCReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : (ims.racpc.vo.beans.CareContextForRACPCReferralVoBean)vo.getCareContext().getBean(map);
		this.datereferralmade = vo.getDateReferralMade() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralMade().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.waitingtime = vo.getWaitingTime();
		this.referralreason = vo.getReferralReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralReason().getBean();
		this.delayreason = vo.getDelayReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReason().getBean();
		this.cardiologist = vo.getCardiologist() == null ? null : (ims.core.vo.beans.HcpBean)vo.getCardiologist().getBean(map);
		this.clinicdoctor = vo.getClinicDoctor() == null ? null : (ims.core.vo.beans.HcpBean)vo.getClinicDoctor().getBean(map);
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.sourceofreferral = vo.getSourceofReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofReferral().getBean();
	}

	public ims.racpc.vo.RACPCReferralVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.racpc.vo.RACPCReferralVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.racpc.vo.RACPCReferralVo vo = null;
		if(map != null)
			vo = (ims.racpc.vo.RACPCReferralVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.racpc.vo.RACPCReferralVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.racpc.vo.beans.CareContextForRACPCReferralVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.racpc.vo.beans.CareContextForRACPCReferralVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateBean getDateReferralMade()
	{
		return this.datereferralmade;
	}
	public void setDateReferralMade(ims.framework.utils.beans.DateBean value)
	{
		this.datereferralmade = value;
	}
	public ims.framework.utils.beans.DateBean getDateReferralReceived()
	{
		return this.datereferralreceived;
	}
	public void setDateReferralReceived(ims.framework.utils.beans.DateBean value)
	{
		this.datereferralreceived = value;
	}
	public Integer getWaitingTime()
	{
		return this.waitingtime;
	}
	public void setWaitingTime(Integer value)
	{
		this.waitingtime = value;
	}
	public ims.vo.LookupInstanceBean getReferralReason()
	{
		return this.referralreason;
	}
	public void setReferralReason(ims.vo.LookupInstanceBean value)
	{
		this.referralreason = value;
	}
	public ims.vo.LookupInstanceBean getDelayReason()
	{
		return this.delayreason;
	}
	public void setDelayReason(ims.vo.LookupInstanceBean value)
	{
		this.delayreason = value;
	}
	public ims.core.vo.beans.HcpBean getCardiologist()
	{
		return this.cardiologist;
	}
	public void setCardiologist(ims.core.vo.beans.HcpBean value)
	{
		this.cardiologist = value;
	}
	public ims.core.vo.beans.HcpBean getClinicDoctor()
	{
		return this.clinicdoctor;
	}
	public void setClinicDoctor(ims.core.vo.beans.HcpBean value)
	{
		this.clinicdoctor = value;
	}
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.vo.LookupInstanceBean getSourceofReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceofReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.racpc.vo.beans.CareContextForRACPCReferralVoBean carecontext;
	private ims.framework.utils.beans.DateBean datereferralmade;
	private ims.framework.utils.beans.DateBean datereferralreceived;
	private Integer waitingtime;
	private ims.vo.LookupInstanceBean referralreason;
	private ims.vo.LookupInstanceBean delayreason;
	private ims.core.vo.beans.HcpBean cardiologist;
	private ims.core.vo.beans.HcpBean clinicdoctor;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.vo.LookupInstanceBean sourceofreferral;
}
