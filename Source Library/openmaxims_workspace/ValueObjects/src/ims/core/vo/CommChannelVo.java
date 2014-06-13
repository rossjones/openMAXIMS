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
 * Linked to core.generic.CommunicationChannel business object (ID: 1002100003).
 */
public class CommChannelVo extends ims.core.generic.vo.CommunicationChannelRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CommChannelVo()
	{
	}
	public CommChannelVo(Integer id, int version)
	{
		super(id, version);
	}
	public CommChannelVo(ims.core.vo.beans.CommChannelVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.channeltype = bean.getChannelType() == null ? null : ims.core.vo.lookups.ChannelType.buildLookup(bean.getChannelType());
		this.commvalue = bean.getCommValue();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CommChannelVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.channeltype = bean.getChannelType() == null ? null : ims.core.vo.lookups.ChannelType.buildLookup(bean.getChannelType());
		this.commvalue = bean.getCommValue();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CommChannelVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CommChannelVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CommChannelVoBean();
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
		if(fieldName.equals("CHANNELTYPE"))
			return getChannelType();
		if(fieldName.equals("COMMVALUE"))
			return getCommValue();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getChannelTypeIsNotNull()
	{
		return this.channeltype != null;
	}
	public ims.core.vo.lookups.ChannelType getChannelType()
	{
		return this.channeltype;
	}
	public void setChannelType(ims.core.vo.lookups.ChannelType value)
	{
		this.isValidated = false;
		this.channeltype = value;
	}
	public boolean getCommValueIsNotNull()
	{
		return this.commvalue != null;
	}
	public String getCommValue()
	{
		return this.commvalue;
	}
	public static int getCommValueMaxLength()
	{
		return 50;
	}
	public void setCommValue(String value)
	{
		this.isValidated = false;
		this.commvalue = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.commvalue != null)
			sb.append(this.commvalue);
		return sb.toString();
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
		if(this.channeltype == null)
			listOfErrors.add("Method is a mandatory field");
		if(this.commvalue == null || this.commvalue.length() == 0)
			listOfErrors.add("Contact value is a mandatory field");
		else if(this.commvalue.length() > 50)
			listOfErrors.add("The length of the field [commvalue] in the value object [ims.core.vo.CommChannelVo] is too big. It should be less or equal to 50");
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
	
		CommChannelVo clone = new CommChannelVo(this.id, this.version);
		
		if(this.channeltype == null)
			clone.channeltype = null;
		else
			clone.channeltype = (ims.core.vo.lookups.ChannelType)this.channeltype.clone();
		clone.commvalue = this.commvalue;
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
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
		if (!(CommChannelVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CommChannelVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CommChannelVo compareObj = (CommChannelVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSystemInformation() == null && compareObj.getSystemInformation() != null)
				return -1;
			if(this.getSystemInformation() != null && compareObj.getSystemInformation() == null)
				return 1;
			if(this.getSystemInformation() != null && compareObj.getSystemInformation() != null)
				retVal = this.getSystemInformation().compareTo(compareObj.getSystemInformation());
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
		if(this.channeltype != null)
			count++;
		if(this.commvalue != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.ChannelType channeltype;
	protected String commvalue;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
