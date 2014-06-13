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

public class BookingAppointmentForSessionManagementVoBean extends ims.vo.ValueObjectBean
{
	public BookingAppointmentForSessionManagementVoBean()
	{
	}
	public BookingAppointmentForSessionManagementVoBean(ims.scheduling.vo.BookingAppointmentForSessionManagementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptendtime = vo.getApptEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptEndTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.attendancetime = vo.getAttendanceTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getAttendanceTime().getBean();
		this.arrivaltime = vo.getArrivalTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getArrivalTime().getBean();
		this.arrivalstatus = vo.getArrivalStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getArrivalStatus().getBean();
		this.seentime = vo.getSeenTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getSeenTime().getBean();
		this.comments = vo.getComments();
		this.iscabbooking = vo.getIsCABBooking();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteVoBean)vo.getPatient().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.requiresrebook = vo.getRequiresRebook();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : new ims.vo.RefVoBean(vo.getTheatreBooking().getBoId(), vo.getTheatreBooking().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.BookingAppointmentForSessionManagementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptendtime = vo.getApptEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptEndTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.attendancetime = vo.getAttendanceTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getAttendanceTime().getBean();
		this.arrivaltime = vo.getArrivalTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getArrivalTime().getBean();
		this.arrivalstatus = vo.getArrivalStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getArrivalStatus().getBean();
		this.seentime = vo.getSeenTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getSeenTime().getBean();
		this.comments = vo.getComments();
		this.iscabbooking = vo.getIsCABBooking();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteVoBean)vo.getPatient().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.requiresrebook = vo.getRequiresRebook();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : new ims.vo.RefVoBean(vo.getTheatreBooking().getBoId(), vo.getTheatreBooking().getBoVersion());
	}

	public ims.scheduling.vo.BookingAppointmentForSessionManagementVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.BookingAppointmentForSessionManagementVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.BookingAppointmentForSessionManagementVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.BookingAppointmentForSessionManagementVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.BookingAppointmentForSessionManagementVo();
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
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.framework.utils.beans.TimeBean getApptEndTime()
	{
		return this.apptendtime;
	}
	public void setApptEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptendtime = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.framework.utils.beans.TimeBean getAttendanceTime()
	{
		return this.attendancetime;
	}
	public void setAttendanceTime(ims.framework.utils.beans.TimeBean value)
	{
		this.attendancetime = value;
	}
	public ims.framework.utils.beans.TimeBean getArrivalTime()
	{
		return this.arrivaltime;
	}
	public void setArrivalTime(ims.framework.utils.beans.TimeBean value)
	{
		this.arrivaltime = value;
	}
	public ims.vo.LookupInstanceBean getArrivalStatus()
	{
		return this.arrivalstatus;
	}
	public void setArrivalStatus(ims.vo.LookupInstanceBean value)
	{
		this.arrivalstatus = value;
	}
	public ims.framework.utils.beans.TimeBean getSeenTime()
	{
		return this.seentime;
	}
	public void setSeenTime(ims.framework.utils.beans.TimeBean value)
	{
		this.seentime = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.core.vo.beans.PatientLiteVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLiteVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.requiresrebook = value;
	}
	public ims.vo.RefVoBean getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.vo.RefVoBean value)
	{
		this.theatrebooking = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.framework.utils.beans.TimeBean apptendtime;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.framework.utils.beans.TimeBean attendancetime;
	private ims.framework.utils.beans.TimeBean arrivaltime;
	private ims.vo.LookupInstanceBean arrivalstatus;
	private ims.framework.utils.beans.TimeBean seentime;
	private String comments;
	private Boolean iscabbooking;
	private ims.core.vo.beans.PatientLiteVoBean patient;
	private ims.vo.RefVoBean carecontext;
	private Boolean requiresrebook;
	private ims.vo.RefVoBean theatrebooking;
}
