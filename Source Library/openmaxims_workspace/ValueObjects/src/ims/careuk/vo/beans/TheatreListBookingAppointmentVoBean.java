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

public class TheatreListBookingAppointmentVoBean extends ims.vo.ValueObjectBean
{
	public TheatreListBookingAppointmentVoBean()
	{
	}
	public TheatreListBookingAppointmentVoBean(ims.careuk.vo.TheatreListBookingAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingLiteVoBean)vo.getTheatreBooking().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLocationVoBean)vo.getSession().getBean();
		this.apptstatushistory = vo.getApptStatusHistory() == null ? null : vo.getApptStatusHistory().getBeanCollection();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.scheduling.vo.beans.Appointment_StatusVoBean)vo.getCurrentStatusRecord().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.requiresrebook = vo.getRequiresRebook();
		this.theatreslot = vo.getTheatreSlot() == null ? null : new ims.vo.RefVoBean(vo.getTheatreSlot().getBoId(), vo.getTheatreSlot().getBoVersion());
		this.intraoperativecarerecord = vo.getIntraOperativeCareRecord() == null ? null : vo.getIntraOperativeCareRecord().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.TheatreListBookingAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingLiteVoBean)vo.getTheatreBooking().getBean(map);
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean(map);
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLocationVoBean)vo.getSession().getBean(map);
		this.apptstatushistory = vo.getApptStatusHistory() == null ? null : vo.getApptStatusHistory().getBeanCollection();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.scheduling.vo.beans.Appointment_StatusVoBean)vo.getCurrentStatusRecord().getBean(map);
		this.iscabbooking = vo.getIsCABBooking();
		this.requiresrebook = vo.getRequiresRebook();
		this.theatreslot = vo.getTheatreSlot() == null ? null : new ims.vo.RefVoBean(vo.getTheatreSlot().getBoId(), vo.getTheatreSlot().getBoVersion());
		this.intraoperativecarerecord = vo.getIntraOperativeCareRecord() == null ? null : vo.getIntraOperativeCareRecord().getBeanCollection();
	}

	public ims.careuk.vo.TheatreListBookingAppointmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.TheatreListBookingAppointmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.TheatreListBookingAppointmentVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.TheatreListBookingAppointmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.TheatreListBookingAppointmentVo();
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
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.scheduling.vo.beans.TheatreBookingLiteVoBean getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.beans.TheatreBookingLiteVoBean value)
	{
		this.theatrebooking = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.icp.vo.beans.PatientICPLiteVoBean getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.beans.PatientICPLiteVoBean value)
	{
		this.icpinfo = value;
	}
	public ims.scheduling.vo.beans.SessionLocationVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionLocationVoBean value)
	{
		this.session = value;
	}
	public ims.scheduling.vo.beans.Appointment_StatusVoBean[] getApptStatusHistory()
	{
		return this.apptstatushistory;
	}
	public void setApptStatusHistory(ims.scheduling.vo.beans.Appointment_StatusVoBean[] value)
	{
		this.apptstatushistory = value;
	}
	public ims.scheduling.vo.beans.Appointment_StatusVoBean getCurrentStatusRecord()
	{
		return this.currentstatusrecord;
	}
	public void setCurrentStatusRecord(ims.scheduling.vo.beans.Appointment_StatusVoBean value)
	{
		this.currentstatusrecord = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.requiresrebook = value;
	}
	public ims.vo.RefVoBean getTheatreSlot()
	{
		return this.theatreslot;
	}
	public void setTheatreSlot(ims.vo.RefVoBean value)
	{
		this.theatreslot = value;
	}
	public ims.clinical.vo.beans.IntraOperativeCareRecordSchedulingVoBean[] getIntraOperativeCareRecord()
	{
		return this.intraoperativecarerecord;
	}
	public void setIntraOperativeCareRecord(ims.clinical.vo.beans.IntraOperativeCareRecordSchedulingVoBean[] value)
	{
		this.intraoperativecarerecord = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.scheduling.vo.beans.TheatreBookingLiteVoBean theatrebooking;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.icp.vo.beans.PatientICPLiteVoBean icpinfo;
	private ims.scheduling.vo.beans.SessionLocationVoBean session;
	private ims.scheduling.vo.beans.Appointment_StatusVoBean[] apptstatushistory;
	private ims.scheduling.vo.beans.Appointment_StatusVoBean currentstatusrecord;
	private Boolean iscabbooking;
	private Boolean requiresrebook;
	private ims.vo.RefVoBean theatreslot;
	private ims.clinical.vo.beans.IntraOperativeCareRecordSchedulingVoBean[] intraoperativecarerecord;
}
