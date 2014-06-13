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
 * Linked to Scheduling.Appointment_Status business object (ID: 1055100008).
 */
public class Appointment_StatusVo extends ims.scheduling.vo.Appointment_StatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Appointment_StatusVo()
	{
	}
	public Appointment_StatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public Appointment_StatusVo(ims.scheduling.vo.beans.Appointment_StatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.statusreason = bean.getStatusReason() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatusReason());
		this.apptdate = bean.getApptDate() == null ? null : bean.getApptDate().buildDate();
		this.appttime = bean.getApptTime() == null ? null : bean.getApptTime().buildTime();
		this.pasclinic = bean.getPASClinic() == null ? null : ims.scheduling.vo.lookups.SchedPASClinic.buildLookup(bean.getPASClinic());
		this.dos = bean.getDoS() == null ? null : new ims.scheduling.vo.DirectoryofServiceRefVo(new Integer(bean.getDoS().getId()), bean.getDoS().getVersion());
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancellationReason());
		this.comment = bean.getComment();
		this.rebookselected = bean.getRebookSelected();
		this.earliestoffereddate = bean.getEarliestOfferedDate() == null ? null : bean.getEarliestOfferedDate().buildDate();
		this.statuschangedatetime = bean.getStatusChangeDateTime() == null ? null : bean.getStatusChangeDateTime().buildDateTime();
		this.sysinformation = bean.getSysInformation() == null ? null : bean.getSysInformation().buildSystemInformation();
		this.canceltci = bean.getCancelTCI();
		this.cancelledfornonmedicalreason = bean.getCancelledForNonMedicalReason();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Appointment_StatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.statusreason = bean.getStatusReason() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatusReason());
		this.apptdate = bean.getApptDate() == null ? null : bean.getApptDate().buildDate();
		this.appttime = bean.getApptTime() == null ? null : bean.getApptTime().buildTime();
		this.pasclinic = bean.getPASClinic() == null ? null : ims.scheduling.vo.lookups.SchedPASClinic.buildLookup(bean.getPASClinic());
		this.dos = bean.getDoS() == null ? null : new ims.scheduling.vo.DirectoryofServiceRefVo(new Integer(bean.getDoS().getId()), bean.getDoS().getVersion());
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancellationReason());
		this.comment = bean.getComment();
		this.rebookselected = bean.getRebookSelected();
		this.earliestoffereddate = bean.getEarliestOfferedDate() == null ? null : bean.getEarliestOfferedDate().buildDate();
		this.statuschangedatetime = bean.getStatusChangeDateTime() == null ? null : bean.getStatusChangeDateTime().buildDateTime();
		this.sysinformation = bean.getSysInformation() == null ? null : bean.getSysInformation().buildSystemInformation();
		this.canceltci = bean.getCancelTCI();
		this.cancelledfornonmedicalreason = bean.getCancelledForNonMedicalReason();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Appointment_StatusVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Appointment_StatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Appointment_StatusVoBean();
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
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("STATUSREASON"))
			return getStatusReason();
		if(fieldName.equals("APPTDATE"))
			return getApptDate();
		if(fieldName.equals("APPTTIME"))
			return getApptTime();
		if(fieldName.equals("PASCLINIC"))
			return getPASClinic();
		if(fieldName.equals("DOS"))
			return getDoS();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("CANCELLATIONREASON"))
			return getCancellationReason();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("REBOOKSELECTED"))
			return getRebookSelected();
		if(fieldName.equals("EARLIESTOFFEREDDATE"))
			return getEarliestOfferedDate();
		if(fieldName.equals("STATUSCHANGEDATETIME"))
			return getStatusChangeDateTime();
		if(fieldName.equals("SYSINFORMATION"))
			return getSysInformation();
		if(fieldName.equals("CANCELTCI"))
			return getCancelTCI();
		if(fieldName.equals("CANCELLEDFORNONMEDICALREASON"))
			return getCancelledForNonMedicalReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getStatusReasonIsNotNull()
	{
		return this.statusreason != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.statusreason = value;
	}
	public boolean getApptDateIsNotNull()
	{
		return this.apptdate != null;
	}
	public ims.framework.utils.Date getApptDate()
	{
		return this.apptdate;
	}
	public void setApptDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.apptdate = value;
	}
	public boolean getApptTimeIsNotNull()
	{
		return this.appttime != null;
	}
	public ims.framework.utils.Time getApptTime()
	{
		return this.appttime;
	}
	public void setApptTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.appttime = value;
	}
	public boolean getPASClinicIsNotNull()
	{
		return this.pasclinic != null;
	}
	public ims.scheduling.vo.lookups.SchedPASClinic getPASClinic()
	{
		return this.pasclinic;
	}
	public void setPASClinic(ims.scheduling.vo.lookups.SchedPASClinic value)
	{
		this.isValidated = false;
		this.pasclinic = value;
	}
	public boolean getDoSIsNotNull()
	{
		return this.dos != null;
	}
	public ims.scheduling.vo.DirectoryofServiceRefVo getDoS()
	{
		return this.dos;
	}
	public void setDoS(ims.scheduling.vo.DirectoryofServiceRefVo value)
	{
		this.isValidated = false;
		this.dos = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.scheduling.vo.lookups.SchedulingPriority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.scheduling.vo.lookups.SchedulingPriority value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getCancellationReasonIsNotNull()
	{
		return this.cancellationreason != null;
	}
	public ims.scheduling.vo.lookups.CancelAppointmentReason getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.scheduling.vo.lookups.CancelAppointmentReason value)
	{
		this.isValidated = false;
		this.cancellationreason = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getRebookSelectedIsNotNull()
	{
		return this.rebookselected != null;
	}
	public Boolean getRebookSelected()
	{
		return this.rebookselected;
	}
	public void setRebookSelected(Boolean value)
	{
		this.isValidated = false;
		this.rebookselected = value;
	}
	public boolean getEarliestOfferedDateIsNotNull()
	{
		return this.earliestoffereddate != null;
	}
	public ims.framework.utils.Date getEarliestOfferedDate()
	{
		return this.earliestoffereddate;
	}
	public void setEarliestOfferedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.earliestoffereddate = value;
	}
	public boolean getStatusChangeDateTimeIsNotNull()
	{
		return this.statuschangedatetime != null;
	}
	public ims.framework.utils.DateTime getStatusChangeDateTime()
	{
		return this.statuschangedatetime;
	}
	public void setStatusChangeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statuschangedatetime = value;
	}
	public boolean getSysInformationIsNotNull()
	{
		return this.sysinformation != null;
	}
	public ims.vo.SystemInformation getSysInformation()
	{
		return this.sysinformation;
	}
	public void setSysInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinformation = value;
	}
	public boolean getCancelTCIIsNotNull()
	{
		return this.canceltci != null;
	}
	public Boolean getCancelTCI()
	{
		return this.canceltci;
	}
	public void setCancelTCI(Boolean value)
	{
		this.isValidated = false;
		this.canceltci = value;
	}
	public boolean getCancelledForNonMedicalReasonIsNotNull()
	{
		return this.cancelledfornonmedicalreason != null;
	}
	public Boolean getCancelledForNonMedicalReason()
	{
		return this.cancelledfornonmedicalreason;
	}
	public void setCancelledForNonMedicalReason(Boolean value)
	{
		this.isValidated = false;
		this.cancelledfornonmedicalreason = value;
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
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.scheduling.vo.Appointment_StatusVo] is too big. It should be less or equal to 255");
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
	
		Appointment_StatusVo clone = new Appointment_StatusVo(this.id, this.version);
		
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
		if(this.statusreason == null)
			clone.statusreason = null;
		else
			clone.statusreason = (ims.scheduling.vo.lookups.Status_Reason)this.statusreason.clone();
		if(this.apptdate == null)
			clone.apptdate = null;
		else
			clone.apptdate = (ims.framework.utils.Date)this.apptdate.clone();
		if(this.appttime == null)
			clone.appttime = null;
		else
			clone.appttime = (ims.framework.utils.Time)this.appttime.clone();
		if(this.pasclinic == null)
			clone.pasclinic = null;
		else
			clone.pasclinic = (ims.scheduling.vo.lookups.SchedPASClinic)this.pasclinic.clone();
		clone.dos = this.dos;
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.scheduling.vo.lookups.SchedulingPriority)this.priority.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.scheduling.vo.lookups.CancelAppointmentReason)this.cancellationreason.clone();
		clone.comment = this.comment;
		clone.rebookselected = this.rebookselected;
		if(this.earliestoffereddate == null)
			clone.earliestoffereddate = null;
		else
			clone.earliestoffereddate = (ims.framework.utils.Date)this.earliestoffereddate.clone();
		if(this.statuschangedatetime == null)
			clone.statuschangedatetime = null;
		else
			clone.statuschangedatetime = (ims.framework.utils.DateTime)this.statuschangedatetime.clone();
		if(this.sysinformation == null)
			clone.sysinformation = null;
		else
			clone.sysinformation = (ims.vo.SystemInformation)this.sysinformation.clone();
		clone.canceltci = this.canceltci;
		clone.cancelledfornonmedicalreason = this.cancelledfornonmedicalreason;
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
		if (!(Appointment_StatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Appointment_StatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		Appointment_StatusVo compareObj = (Appointment_StatusVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getApptDate() == null && compareObj.getApptDate() != null)
				return -1;
			if(this.getApptDate() != null && compareObj.getApptDate() == null)
				return 1;
			if(this.getApptDate() != null && compareObj.getApptDate() != null)
				retVal = this.getApptDate().compareTo(compareObj.getApptDate());
		}
		if (retVal == 0)
		{
			if(this.getApptTime() == null && compareObj.getApptTime() != null)
				return -1;
			if(this.getApptTime() != null && compareObj.getApptTime() == null)
				return 1;
			if(this.getApptTime() != null && compareObj.getApptTime() != null)
				retVal = this.getApptTime().compareTo(compareObj.getApptTime());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.status != null)
			count++;
		if(this.statusreason != null)
			count++;
		if(this.apptdate != null)
			count++;
		if(this.appttime != null)
			count++;
		if(this.pasclinic != null)
			count++;
		if(this.dos != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.cancellationreason != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.rebookselected != null)
			count++;
		if(this.earliestoffereddate != null)
			count++;
		if(this.statuschangedatetime != null)
			count++;
		if(this.sysinformation != null)
			count++;
		if(this.canceltci != null)
			count++;
		if(this.cancelledfornonmedicalreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.scheduling.vo.lookups.Status_Reason status;
	protected ims.scheduling.vo.lookups.Status_Reason statusreason;
	protected ims.framework.utils.Date apptdate;
	protected ims.framework.utils.Time appttime;
	protected ims.scheduling.vo.lookups.SchedPASClinic pasclinic;
	protected ims.scheduling.vo.DirectoryofServiceRefVo dos;
	protected ims.scheduling.vo.lookups.SchedulingPriority priority;
	protected ims.scheduling.vo.lookups.CancelAppointmentReason cancellationreason;
	protected String comment;
	protected Boolean rebookselected;
	protected ims.framework.utils.Date earliestoffereddate;
	protected ims.framework.utils.DateTime statuschangedatetime;
	protected ims.vo.SystemInformation sysinformation;
	protected Boolean canceltci;
	protected Boolean cancelledfornonmedicalreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
