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

package ims.nursing.vo;

/**
 * Linked to nursing.assessment.Patient Property business object (ID: 1015100005).
 */
public class PatientProperty extends ims.nursing.assessment.vo.PatientPropertyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientProperty()
	{
	}
	public PatientProperty(Integer id, int version)
	{
		super(id, version);
	}
	public PatientProperty(ims.nursing.vo.beans.PatientPropertyBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.propertybookcomplete = bean.getPropertyBookComplete() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPropertyBookComplete());
		this.serialnumber = bean.getSerialNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PatientPropertyBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.propertybookcomplete = bean.getPropertyBookComplete() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPropertyBookComplete());
		this.serialnumber = bean.getSerialNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PatientPropertyBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PatientPropertyBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PatientPropertyBean();
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
		if(fieldName.equals("PROPERTYBOOKCOMPLETE"))
			return getPropertyBookComplete();
		if(fieldName.equals("SERIALNUMBER"))
			return getSerialNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPropertyBookCompleteIsNotNull()
	{
		return this.propertybookcomplete != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getPropertyBookComplete()
	{
		return this.propertybookcomplete;
	}
	public void setPropertyBookComplete(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.propertybookcomplete = value;
	}
	public boolean getSerialNumberIsNotNull()
	{
		return this.serialnumber != null;
	}
	public String getSerialNumber()
	{
		return this.serialnumber;
	}
	public static int getSerialNumberMaxLength()
	{
		return 30;
	}
	public void setSerialNumber(String value)
	{
		this.isValidated = false;
		this.serialnumber = value;
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
		if(this.serialnumber != null)
			if(this.serialnumber.length() > 30)
				listOfErrors.add("The length of the field [serialnumber] in the value object [ims.nursing.vo.PatientProperty] is too big. It should be less or equal to 30");
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
	
		PatientProperty clone = new PatientProperty(this.id, this.version);
		
		if(this.propertybookcomplete == null)
			clone.propertybookcomplete = null;
		else
			clone.propertybookcomplete = (ims.core.vo.lookups.YesNoUnknown)this.propertybookcomplete.clone();
		clone.serialnumber = this.serialnumber;
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
		if (!(PatientProperty.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientProperty object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientProperty compareObj = (PatientProperty)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientProperty() == null && compareObj.getID_PatientProperty() != null)
				return -1;
			if(this.getID_PatientProperty() != null && compareObj.getID_PatientProperty() == null)
				return 1;
			if(this.getID_PatientProperty() != null && compareObj.getID_PatientProperty() != null)
				retVal = this.getID_PatientProperty().compareTo(compareObj.getID_PatientProperty());
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
		if(this.propertybookcomplete != null)
			count++;
		if(this.serialnumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.YesNoUnknown propertybookcomplete;
	protected String serialnumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
