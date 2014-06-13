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
public class EmergencyAttendanceForEventHistoryVo extends ims.core.admin.vo.EmergencyAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceForEventHistoryVo()
	{
	}
	public EmergencyAttendanceForEventHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceForEventHistoryVo(ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episode = bean.getEpisode() == null ? null : bean.getEpisode().buildVo();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episode = bean.getEpisode() == null ? null : bean.getEpisode().buildVo(map);
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean();
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
		if(fieldName.equals("ARRIVALDATETIME"))
			return getArrivalDateTime();
		if(fieldName.equals("REGISTRATIONDATETIME"))
			return getRegistrationDateTime();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getArrivalDateTimeIsNotNull()
	{
		return this.arrivaldatetime != null;
	}
	public ims.framework.utils.DateTime getArrivalDateTime()
	{
		return this.arrivaldatetime;
	}
	public void setArrivalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.arrivaldatetime = value;
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
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.emergency.vo.EmergencyEpisodeForEventHistoryVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.EmergencyEpisodeForEventHistoryVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.emergency.vo.PatientForEventHistoryVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.emergency.vo.PatientForEventHistoryVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.emergency.vo.lookups.AttendanceOutcome getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.emergency.vo.lookups.AttendanceOutcome value)
	{
		this.isValidated = false;
		this.outcome = value;
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
		if(this.arrivaldatetime == null)
			listOfErrors.add("ArrivalDateTime is mandatory");
		if(this.registrationdatetime == null)
			listOfErrors.add("RegistrationDateTime is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
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
	
		EmergencyAttendanceForEventHistoryVo clone = new EmergencyAttendanceForEventHistoryVo(this.id, this.version);
		
		if(this.arrivaldatetime == null)
			clone.arrivaldatetime = null;
		else
			clone.arrivaldatetime = (ims.framework.utils.DateTime)this.arrivaldatetime.clone();
		if(this.registrationdatetime == null)
			clone.registrationdatetime = null;
		else
			clone.registrationdatetime = (ims.framework.utils.DateTime)this.registrationdatetime.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		clone.carecontext = this.carecontext;
		if(this.episode == null)
			clone.episode = null;
		else
			clone.episode = (ims.emergency.vo.EmergencyEpisodeForEventHistoryVo)this.episode.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.emergency.vo.PatientForEventHistoryVo)this.patient.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.emergency.vo.lookups.AttendanceOutcome)this.outcome.clone();
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
		if (!(EmergencyAttendanceForEventHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceForEventHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceForEventHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceForEventHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.arrivaldatetime != null)
			count++;
		if(this.registrationdatetime != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.outcome != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.framework.utils.DateTime arrivaldatetime;
	protected ims.framework.utils.DateTime registrationdatetime;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.emergency.vo.EmergencyEpisodeForEventHistoryVo episode;
	protected ims.emergency.vo.PatientForEventHistoryVo patient;
	protected ims.emergency.vo.lookups.AttendanceOutcome outcome;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
