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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointmentTheatreLiteVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BookingAppointmentTheatreLiteVo()
	{
	}
	public BookingAppointmentTheatreLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public BookingAppointmentTheatreLiteVo(ims.scheduling.vo.beans.BookingAppointmentTheatreLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.theatrebooking = bean.getTheatreBooking() == null ? null : bean.getTheatreBooking().buildVo();
		this.customprocedureduration = bean.getCustomProcedureDuration();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.BookingAppointmentTheatreLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.theatrebooking = bean.getTheatreBooking() == null ? null : bean.getTheatreBooking().buildVo(map);
		this.customprocedureduration = bean.getCustomProcedureDuration();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.BookingAppointmentTheatreLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.BookingAppointmentTheatreLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.BookingAppointmentTheatreLiteVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("APPTSTARTTIME"))
			return getApptStartTime();
		if(fieldName.equals("APPTENDTIME"))
			return getApptEndTime();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("THEATREBOOKING"))
			return getTheatreBooking();
		if(fieldName.equals("CUSTOMPROCEDUREDURATION"))
			return getCustomProcedureDuration();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getApptStartTimeIsNotNull()
	{
		return this.apptstarttime != null;
	}
	public ims.framework.utils.Time getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptstarttime = value;
	}
	public boolean getApptEndTimeIsNotNull()
	{
		return this.apptendtime != null;
	}
	public ims.framework.utils.Time getApptEndTime()
	{
		return this.apptendtime;
	}
	public void setApptEndTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptendtime = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getTheatreBookingIsNotNull()
	{
		return this.theatrebooking != null;
	}
	public ims.scheduling.vo.TheatreBookingLiteVo getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.TheatreBookingLiteVo value)
	{
		this.isValidated = false;
		this.theatrebooking = value;
	}
	public boolean getCustomProcedureDurationIsNotNull()
	{
		return this.customprocedureduration != null;
	}
	public Integer getCustomProcedureDuration()
	{
		return this.customprocedureduration;
	}
	public void setCustomProcedureDuration(Integer value)
	{
		this.isValidated = false;
		this.customprocedureduration = value;
	}
	public boolean getApptStatusIsNotNull()
	{
		return this.apptstatus != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.apptstatus = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		BookingAppointmentTheatreLiteVo clone = new BookingAppointmentTheatreLiteVo(this.id, this.version);
		
		if(this.apptstarttime == null)
			clone.apptstarttime = null;
		else
			clone.apptstarttime = (ims.framework.utils.Time)this.apptstarttime.clone();
		if(this.apptendtime == null)
			clone.apptendtime = null;
		else
			clone.apptendtime = (ims.framework.utils.Time)this.apptendtime.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientListVo)this.patient.clone();
		if(this.theatrebooking == null)
			clone.theatrebooking = null;
		else
			clone.theatrebooking = (ims.scheduling.vo.TheatreBookingLiteVo)this.theatrebooking.clone();
		clone.customprocedureduration = this.customprocedureduration;
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(BookingAppointmentTheatreLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BookingAppointmentTheatreLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BookingAppointmentTheatreLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BookingAppointmentTheatreLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.apptstarttime != null)
			count++;
		if(this.apptendtime != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.theatrebooking != null)
			count++;
		if(this.customprocedureduration != null)
			count++;
		if(this.apptstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.Time apptstarttime;
	protected ims.framework.utils.Time apptendtime;
	protected ims.core.vo.PatientListVo patient;
	protected ims.scheduling.vo.TheatreBookingLiteVo theatrebooking;
	protected Integer customprocedureduration;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
