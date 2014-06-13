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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.Configuration.TumourHistology business object (ID: 1074100012).
 */
public class TumourHistologyLiteVo extends ims.oncology.configuration.vo.TumourHistologyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourHistologyLiteVo()
	{
	}
	public TumourHistologyLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourHistologyLiteVo(ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.histologydescription = bean.getHistologyDescription();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.histologydescription = bean.getHistologyDescription();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean();
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
		if(fieldName.equals("HISTOLOGYDESCRIPTION"))
			return getHistologyDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHistologyDescriptionIsNotNull()
	{
		return this.histologydescription != null;
	}
	public String getHistologyDescription()
	{
		return this.histologydescription;
	}
	public static int getHistologyDescriptionMaxLength()
	{
		return 100;
	}
	public void setHistologyDescription(String value)
	{
		this.isValidated = false;
		this.histologydescription = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
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
		if(this.histologydescription == null || this.histologydescription.length() == 0)
			listOfErrors.add("Histology Description is mandatory");
		else if(this.histologydescription.length() > 100)
			listOfErrors.add("The length of the field [histologydescription] in the value object [ims.clinicaladmin.vo.TumourHistologyLiteVo] is too big. It should be less or equal to 100");
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
	
		TumourHistologyLiteVo clone = new TumourHistologyLiteVo(this.id, this.version);
		
		clone.histologydescription = this.histologydescription;
		clone.isactive = this.isactive;
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
		if (!(TumourHistologyLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourHistologyLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourHistologyLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourHistologyLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.histologydescription != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String histologydescription;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
