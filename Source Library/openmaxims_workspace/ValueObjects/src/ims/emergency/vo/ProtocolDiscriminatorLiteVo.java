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
 * Linked to emergency.Configuration.ProtocolDiscriminator business object (ID: 1087100011).
 */
public class ProtocolDiscriminatorLiteVo extends ims.emergency.configuration.vo.ProtocolDiscriminatorRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ProtocolDiscriminatorLiteVo()
	{
	}
	public ProtocolDiscriminatorLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProtocolDiscriminatorLiteVo(ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.discriminator = bean.getDiscriminator() == null ? null : bean.getDiscriminator().buildVo();
		this.priority = bean.getPriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getPriority());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.discriminator = bean.getDiscriminator() == null ? null : bean.getDiscriminator().buildVo(map);
		this.priority = bean.getPriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getPriority());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean();
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
		if(fieldName.equals("DISCRIMINATOR"))
			return getDiscriminator();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDiscriminatorIsNotNull()
	{
		return this.discriminator != null;
	}
	public ims.emergency.vo.DiscriminatorConfigLiteVo getDiscriminator()
	{
		return this.discriminator;
	}
	public void setDiscriminator(ims.emergency.vo.DiscriminatorConfigLiteVo value)
	{
		this.isValidated = false;
		this.discriminator = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.emergency.vo.lookups.TriagePriority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.emergency.vo.lookups.TriagePriority value)
	{
		this.isValidated = false;
		this.priority = value;
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
		if(this.discriminator == null)
			listOfErrors.add("Discriminator is mandatory");
		if(this.priority == null)
			listOfErrors.add("Priority is mandatory");
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
	
		ProtocolDiscriminatorLiteVo clone = new ProtocolDiscriminatorLiteVo(this.id, this.version);
		
		if(this.discriminator == null)
			clone.discriminator = null;
		else
			clone.discriminator = (ims.emergency.vo.DiscriminatorConfigLiteVo)this.discriminator.clone();
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.emergency.vo.lookups.TriagePriority)this.priority.clone();
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
		if (!(ProtocolDiscriminatorLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProtocolDiscriminatorLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ProtocolDiscriminatorLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ProtocolDiscriminatorLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.discriminator != null)
			count++;
		if(this.priority != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.emergency.vo.DiscriminatorConfigLiteVo discriminator;
	protected ims.emergency.vo.lookups.TriagePriority priority;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
