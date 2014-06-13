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

package ims.core.vo;

/**
 * Linked to core.resource.place.WorkQueueStatus business object (ID: 1038100001).
 */
public class WorkQueueStatusHistoryVo extends ims.core.resource.place.vo.WorkQueueStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WorkQueueStatusHistoryVo()
	{
	}
	public WorkQueueStatusHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public WorkQueueStatusHistoryVo(ims.core.vo.beans.WorkQueueStatusHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.ntpf.vo.lookups.WorkQueueStatus.buildLookup(bean.getStatus());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WorkQueueStatusHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.ntpf.vo.lookups.WorkQueueStatus.buildLookup(bean.getStatus());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WorkQueueStatusHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WorkQueueStatusHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WorkQueueStatusHistoryVoBean();
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
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.ntpf.vo.lookups.WorkQueueStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.ntpf.vo.lookups.WorkQueueStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
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
	
		WorkQueueStatusHistoryVo clone = new WorkQueueStatusHistoryVo(this.id, this.version);
		
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.ntpf.vo.lookups.WorkQueueStatus)this.status.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
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
		if (!(WorkQueueStatusHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WorkQueueStatusHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WorkQueueStatusHistoryVo compareObj = (WorkQueueStatusHistoryVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
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
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.ntpf.vo.lookups.WorkQueueStatus status;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
