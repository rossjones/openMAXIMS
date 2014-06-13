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

package ims.emergency.vo;

/**
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class ifEDAttendanceVo extends ims.core.admin.vo.EmergencyAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ifEDAttendanceVo()
	{
	}
	public ifEDAttendanceVo(Integer id, int version)
	{
		super(id, version);
	}
	public ifEDAttendanceVo(ims.emergency.vo.beans.ifEDAttendanceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.attendancetype = bean.getAttendanceType() == null ? null : ims.emergency.vo.lookups.AttendanceType.buildLookup(bean.getAttendanceType());
		this.registrationlocation = bean.getRegistrationLocation() == null ? null : bean.getRegistrationLocation().buildVo();
		this.emergencyepisode = bean.getEmergencyEpisode() == null ? null : bean.getEmergencyEpisode().buildVo();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ifEDAttendanceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.attendancetype = bean.getAttendanceType() == null ? null : ims.emergency.vo.lookups.AttendanceType.buildLookup(bean.getAttendanceType());
		this.registrationlocation = bean.getRegistrationLocation() == null ? null : bean.getRegistrationLocation().buildVo(map);
		this.emergencyepisode = bean.getEmergencyEpisode() == null ? null : bean.getEmergencyEpisode().buildVo(map);
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ifEDAttendanceVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ifEDAttendanceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ifEDAttendanceVoBean();
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
		if(fieldName.equals("REGISTRATIONDATETIME"))
			return getRegistrationDateTime();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("ATTENDANCETYPE"))
			return getAttendanceType();
		if(fieldName.equals("REGISTRATIONLOCATION"))
			return getRegistrationLocation();
		if(fieldName.equals("EMERGENCYEPISODE"))
			return getEmergencyEpisode();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRegistrationDateTimeIsNotNull()
	{
		return this.registrationdatetime != null;
	}
	public ims.framework.utils.DateTime getRegistrationDateTime()
	{
		return this.registrationdatetime;
	}
	public void setRegistrationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.registrationdatetime = value;
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
	}
	public boolean getAttendanceTypeIsNotNull()
	{
		return this.attendancetype != null;
	}
	public ims.emergency.vo.lookups.AttendanceType getAttendanceType()
	{
		return this.attendancetype;
	}
	public void setAttendanceType(ims.emergency.vo.lookups.AttendanceType value)
	{
		this.isValidated = false;
		this.attendancetype = value;
	}
	public boolean getRegistrationLocationIsNotNull()
	{
		return this.registrationlocation != null;
	}
	public ims.core.vo.LocShortMappingsVo getRegistrationLocation()
	{
		return this.registrationlocation;
	}
	public void setRegistrationLocation(ims.core.vo.LocShortMappingsVo value)
	{
		this.isValidated = false;
		this.registrationlocation = value;
	}
	public boolean getEmergencyEpisodeIsNotNull()
	{
		return this.emergencyepisode != null;
	}
	public ims.emergency.vo.ifEDEpisodeVo getEmergencyEpisode()
	{
		return this.emergencyepisode;
	}
	public void setEmergencyEpisode(ims.emergency.vo.ifEDEpisodeVo value)
	{
		this.isValidated = false;
		this.emergencyepisode = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.Patient getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.Patient value)
	{
		this.isValidated = false;
		this.patient = value;
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
		if(this.registrationdatetime == null)
			listOfErrors.add("RegistrationDateTime is mandatory");
		if(this.emergencyepisode == null)
			listOfErrors.add("EmergencyEpisode is mandatory");
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
	
		ifEDAttendanceVo clone = new ifEDAttendanceVo(this.id, this.version);
		
		if(this.registrationdatetime == null)
			clone.registrationdatetime = null;
		else
			clone.registrationdatetime = (ims.framework.utils.DateTime)this.registrationdatetime.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		if(this.attendancetype == null)
			clone.attendancetype = null;
		else
			clone.attendancetype = (ims.emergency.vo.lookups.AttendanceType)this.attendancetype.clone();
		if(this.registrationlocation == null)
			clone.registrationlocation = null;
		else
			clone.registrationlocation = (ims.core.vo.LocShortMappingsVo)this.registrationlocation.clone();
		if(this.emergencyepisode == null)
			clone.emergencyepisode = null;
		else
			clone.emergencyepisode = (ims.emergency.vo.ifEDEpisodeVo)this.emergencyepisode.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.Patient)this.patient.clone();
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
		if (!(ifEDAttendanceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ifEDAttendanceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ifEDAttendanceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ifEDAttendanceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.registrationdatetime != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.attendancetype != null)
			count++;
		if(this.registrationlocation != null)
			count++;
		if(this.emergencyepisode != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.DateTime registrationdatetime;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected ims.emergency.vo.lookups.AttendanceType attendancetype;
	protected ims.core.vo.LocShortMappingsVo registrationlocation;
	protected ims.emergency.vo.ifEDEpisodeVo emergencyepisode;
	protected ims.core.vo.Patient patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
