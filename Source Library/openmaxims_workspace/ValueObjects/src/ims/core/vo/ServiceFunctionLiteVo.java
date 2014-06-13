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
 * Linked to core.clinical.ServiceFunction business object (ID: 1003100034).
 */
public class ServiceFunctionLiteVo extends ims.core.clinical.vo.ServiceFunctionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ServiceFunctionLiteVo()
	{
	}
	public ServiceFunctionLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServiceFunctionLiteVo(ims.core.vo.beans.ServiceFunctionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.function = bean.getFunction() == null ? null : ims.core.vo.lookups.ServiceFunction.buildLookup(bean.getFunction());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ServiceFunctionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.function = bean.getFunction() == null ? null : ims.core.vo.lookups.ServiceFunction.buildLookup(bean.getFunction());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ServiceFunctionLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ServiceFunctionLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ServiceFunctionLiteVoBean();
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
		if(fieldName.equals("FUNCTION"))
			return getFunction();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFunctionIsNotNull()
	{
		return this.function != null;
	}
	public ims.core.vo.lookups.ServiceFunction getFunction()
	{
		return this.function;
	}
	public void setFunction(ims.core.vo.lookups.ServiceFunction value)
	{
		this.isValidated = false;
		this.function = value;
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
		if(this.function == null)
			listOfErrors.add("Function is mandatory");
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
	
		ServiceFunctionLiteVo clone = new ServiceFunctionLiteVo(this.id, this.version);
		
		if(this.function == null)
			clone.function = null;
		else
			clone.function = (ims.core.vo.lookups.ServiceFunction)this.function.clone();
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
		if (!(ServiceFunctionLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServiceFunctionLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ServiceFunctionLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ServiceFunctionLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.function != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.core.vo.lookups.ServiceFunction function;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
