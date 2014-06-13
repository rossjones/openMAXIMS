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
 * Linked to Scheduling.AppointmentOutcomeAction business object (ID: 1090100020).
 */
public class AppointmentOutcomeActionVo extends ims.scheduling.vo.AppointmentOutcomeActionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppointmentOutcomeActionVo()
	{
	}
	public AppointmentOutcomeActionVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppointmentOutcomeActionVo(ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentaction = bean.getAppointmentAction() == null ? null : ims.scheduling.vo.lookups.AppointmentAction.buildLookup(bean.getAppointmentAction());
		this.outcomeofaction = bean.getOutcomeOfAction() == null ? null : ims.scheduling.vo.lookups.OutcomeAction.buildLookup(bean.getOutcomeOfAction());
		this.futureappointmentdetails = bean.getFutureAppointmentDetails() == null ? null : bean.getFutureAppointmentDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentaction = bean.getAppointmentAction() == null ? null : ims.scheduling.vo.lookups.AppointmentAction.buildLookup(bean.getAppointmentAction());
		this.outcomeofaction = bean.getOutcomeOfAction() == null ? null : ims.scheduling.vo.lookups.OutcomeAction.buildLookup(bean.getOutcomeOfAction());
		this.futureappointmentdetails = bean.getFutureAppointmentDetails() == null ? null : bean.getFutureAppointmentDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean();
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
		if(fieldName.equals("APPOINTMENTACTION"))
			return getAppointmentAction();
		if(fieldName.equals("OUTCOMEOFACTION"))
			return getOutcomeOfAction();
		if(fieldName.equals("FUTUREAPPOINTMENTDETAILS"))
			return getFutureAppointmentDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentActionIsNotNull()
	{
		return this.appointmentaction != null;
	}
	public ims.scheduling.vo.lookups.AppointmentAction getAppointmentAction()
	{
		return this.appointmentaction;
	}
	public void setAppointmentAction(ims.scheduling.vo.lookups.AppointmentAction value)
	{
		this.isValidated = false;
		this.appointmentaction = value;
	}
	public boolean getOutcomeOfActionIsNotNull()
	{
		return this.outcomeofaction != null;
	}
	public ims.scheduling.vo.lookups.OutcomeAction getOutcomeOfAction()
	{
		return this.outcomeofaction;
	}
	public void setOutcomeOfAction(ims.scheduling.vo.lookups.OutcomeAction value)
	{
		this.isValidated = false;
		this.outcomeofaction = value;
	}
	public boolean getFutureAppointmentDetailsIsNotNull()
	{
		return this.futureappointmentdetails != null;
	}
	public ims.scheduling.vo.FutureAppointmentDetailsVo getFutureAppointmentDetails()
	{
		return this.futureappointmentdetails;
	}
	public void setFutureAppointmentDetails(ims.scheduling.vo.FutureAppointmentDetailsVo value)
	{
		this.isValidated = false;
		this.futureappointmentdetails = value;
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
		if(this.futureappointmentdetails != null)
		{
			if(!this.futureappointmentdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.futureappointmentdetails != null)
		{
			String[] listOfOtherErrors = this.futureappointmentdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		AppointmentOutcomeActionVo clone = new AppointmentOutcomeActionVo(this.id, this.version);
		
		if(this.appointmentaction == null)
			clone.appointmentaction = null;
		else
			clone.appointmentaction = (ims.scheduling.vo.lookups.AppointmentAction)this.appointmentaction.clone();
		if(this.outcomeofaction == null)
			clone.outcomeofaction = null;
		else
			clone.outcomeofaction = (ims.scheduling.vo.lookups.OutcomeAction)this.outcomeofaction.clone();
		if(this.futureappointmentdetails == null)
			clone.futureappointmentdetails = null;
		else
			clone.futureappointmentdetails = (ims.scheduling.vo.FutureAppointmentDetailsVo)this.futureappointmentdetails.clone();
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
		if (!(AppointmentOutcomeActionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppointmentOutcomeActionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppointmentOutcomeActionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppointmentOutcomeActionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.appointmentaction != null)
			count++;
		if(this.outcomeofaction != null)
			count++;
		if(this.futureappointmentdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.scheduling.vo.lookups.AppointmentAction appointmentaction;
	protected ims.scheduling.vo.lookups.OutcomeAction outcomeofaction;
	protected ims.scheduling.vo.FutureAppointmentDetailsVo futureappointmentdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
