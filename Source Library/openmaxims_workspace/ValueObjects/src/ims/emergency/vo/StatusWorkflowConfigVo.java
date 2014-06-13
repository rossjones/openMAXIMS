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
 * Linked to emergency.Configuration.StatusWorkflowConfig business object (ID: 1087100023).
 */
public class StatusWorkflowConfigVo extends ims.emergency.configuration.vo.StatusWorkflowConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public StatusWorkflowConfigVo()
	{
	}
	public StatusWorkflowConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public StatusWorkflowConfigVo(ims.emergency.vo.beans.StatusWorkflowConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.workflowstatus = bean.getWorkflowStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getWorkflowStatus());
		this.createsclinicaldischarge = bean.getCreatesClinicalDischarge();
		this.requirespreadmission = bean.getRequiresPreAdmission();
		this.recordeddeparture = bean.getRecordEDDeparture();
		this.departurecontinuetodisplay = bean.getDepartureContinueToDisplay();
		this.departureseperatecontextrecord = bean.getDepartureSeperateContextRecord();
		this.departureoutcomedefault = bean.getDepartureOutcomeDefault() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getDepartureOutcomeDefault());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.StatusWorkflowConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.workflowstatus = bean.getWorkflowStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getWorkflowStatus());
		this.createsclinicaldischarge = bean.getCreatesClinicalDischarge();
		this.requirespreadmission = bean.getRequiresPreAdmission();
		this.recordeddeparture = bean.getRecordEDDeparture();
		this.departurecontinuetodisplay = bean.getDepartureContinueToDisplay();
		this.departureseperatecontextrecord = bean.getDepartureSeperateContextRecord();
		this.departureoutcomedefault = bean.getDepartureOutcomeDefault() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getDepartureOutcomeDefault());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.StatusWorkflowConfigVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.StatusWorkflowConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.StatusWorkflowConfigVoBean();
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
		if(fieldName.equals("WORKFLOWSTATUS"))
			return getWorkflowStatus();
		if(fieldName.equals("CREATESCLINICALDISCHARGE"))
			return getCreatesClinicalDischarge();
		if(fieldName.equals("REQUIRESPREADMISSION"))
			return getRequiresPreAdmission();
		if(fieldName.equals("RECORDEDDEPARTURE"))
			return getRecordEDDeparture();
		if(fieldName.equals("DEPARTURECONTINUETODISPLAY"))
			return getDepartureContinueToDisplay();
		if(fieldName.equals("DEPARTURESEPERATECONTEXTRECORD"))
			return getDepartureSeperateContextRecord();
		if(fieldName.equals("DEPARTUREOUTCOMEDEFAULT"))
			return getDepartureOutcomeDefault();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWorkflowStatusIsNotNull()
	{
		return this.workflowstatus != null;
	}
	public ims.emergency.vo.lookups.TrackingStatus getWorkflowStatus()
	{
		return this.workflowstatus;
	}
	public void setWorkflowStatus(ims.emergency.vo.lookups.TrackingStatus value)
	{
		this.isValidated = false;
		this.workflowstatus = value;
	}
	public boolean getCreatesClinicalDischargeIsNotNull()
	{
		return this.createsclinicaldischarge != null;
	}
	public Boolean getCreatesClinicalDischarge()
	{
		return this.createsclinicaldischarge;
	}
	public void setCreatesClinicalDischarge(Boolean value)
	{
		this.isValidated = false;
		this.createsclinicaldischarge = value;
	}
	public boolean getRequiresPreAdmissionIsNotNull()
	{
		return this.requirespreadmission != null;
	}
	public Boolean getRequiresPreAdmission()
	{
		return this.requirespreadmission;
	}
	public void setRequiresPreAdmission(Boolean value)
	{
		this.isValidated = false;
		this.requirespreadmission = value;
	}
	public boolean getRecordEDDepartureIsNotNull()
	{
		return this.recordeddeparture != null;
	}
	public Boolean getRecordEDDeparture()
	{
		return this.recordeddeparture;
	}
	public void setRecordEDDeparture(Boolean value)
	{
		this.isValidated = false;
		this.recordeddeparture = value;
	}
	public boolean getDepartureContinueToDisplayIsNotNull()
	{
		return this.departurecontinuetodisplay != null;
	}
	public Boolean getDepartureContinueToDisplay()
	{
		return this.departurecontinuetodisplay;
	}
	public void setDepartureContinueToDisplay(Boolean value)
	{
		this.isValidated = false;
		this.departurecontinuetodisplay = value;
	}
	public boolean getDepartureSeperateContextRecordIsNotNull()
	{
		return this.departureseperatecontextrecord != null;
	}
	public Boolean getDepartureSeperateContextRecord()
	{
		return this.departureseperatecontextrecord;
	}
	public void setDepartureSeperateContextRecord(Boolean value)
	{
		this.isValidated = false;
		this.departureseperatecontextrecord = value;
	}
	public boolean getDepartureOutcomeDefaultIsNotNull()
	{
		return this.departureoutcomedefault != null;
	}
	public ims.emergency.vo.lookups.AttendanceOutcome getDepartureOutcomeDefault()
	{
		return this.departureoutcomedefault;
	}
	public void setDepartureOutcomeDefault(ims.emergency.vo.lookups.AttendanceOutcome value)
	{
		this.isValidated = false;
		this.departureoutcomedefault = value;
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
		if(this.workflowstatus == null)
			listOfErrors.add("WorkflowStatus is mandatory");
		if(this.createsclinicaldischarge == null)
			listOfErrors.add("CreatesClinicalDischarge is mandatory");
		if(this.requirespreadmission == null)
			listOfErrors.add("RequiresPreAdmission is mandatory");
		if(this.recordeddeparture == null)
			listOfErrors.add("RecordEDDeparture is mandatory");
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
	
		StatusWorkflowConfigVo clone = new StatusWorkflowConfigVo(this.id, this.version);
		
		if(this.workflowstatus == null)
			clone.workflowstatus = null;
		else
			clone.workflowstatus = (ims.emergency.vo.lookups.TrackingStatus)this.workflowstatus.clone();
		clone.createsclinicaldischarge = this.createsclinicaldischarge;
		clone.requirespreadmission = this.requirespreadmission;
		clone.recordeddeparture = this.recordeddeparture;
		clone.departurecontinuetodisplay = this.departurecontinuetodisplay;
		clone.departureseperatecontextrecord = this.departureseperatecontextrecord;
		if(this.departureoutcomedefault == null)
			clone.departureoutcomedefault = null;
		else
			clone.departureoutcomedefault = (ims.emergency.vo.lookups.AttendanceOutcome)this.departureoutcomedefault.clone();
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
		if (!(StatusWorkflowConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A StatusWorkflowConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((StatusWorkflowConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((StatusWorkflowConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.workflowstatus != null)
			count++;
		if(this.createsclinicaldischarge != null)
			count++;
		if(this.requirespreadmission != null)
			count++;
		if(this.recordeddeparture != null)
			count++;
		if(this.departurecontinuetodisplay != null)
			count++;
		if(this.departureseperatecontextrecord != null)
			count++;
		if(this.departureoutcomedefault != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.emergency.vo.lookups.TrackingStatus workflowstatus;
	protected Boolean createsclinicaldischarge;
	protected Boolean requirespreadmission;
	protected Boolean recordeddeparture;
	protected Boolean departurecontinuetodisplay;
	protected Boolean departureseperatecontextrecord;
	protected ims.emergency.vo.lookups.AttendanceOutcome departureoutcomedefault;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
