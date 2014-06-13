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
 * Linked to core.clinical.Service business object (ID: 1003100032).
 */
public class ServiceLiteVo extends ims.core.clinical.vo.ServiceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ServiceLiteVo()
	{
	}
	public ServiceLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServiceLiteVo(ims.core.vo.beans.ServiceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.servicename = bean.getServiceName();
		this.servicecategory = bean.getServiceCategory() == null ? null : ims.core.vo.lookups.ServiceCategory.buildLookup(bean.getServiceCategory());
		this.canbescheduled = bean.getCanBeScheduled();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.expectedturnaround = bean.getExpectedTurnaround();
		this.turnaroundmeasure = bean.getTurnaroundMeasure() == null ? null : ims.ocrr.vo.lookups.MinReorderPeriod.buildLookup(bean.getTurnaroundMeasure());
		this.maternityindicator = bean.getMaternityIndicator();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ServiceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.servicename = bean.getServiceName();
		this.servicecategory = bean.getServiceCategory() == null ? null : ims.core.vo.lookups.ServiceCategory.buildLookup(bean.getServiceCategory());
		this.canbescheduled = bean.getCanBeScheduled();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.expectedturnaround = bean.getExpectedTurnaround();
		this.turnaroundmeasure = bean.getTurnaroundMeasure() == null ? null : ims.ocrr.vo.lookups.MinReorderPeriod.buildLookup(bean.getTurnaroundMeasure());
		this.maternityindicator = bean.getMaternityIndicator();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ServiceLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ServiceLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ServiceLiteVoBean();
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
		if(fieldName.equals("SERVICENAME"))
			return getServiceName();
		if(fieldName.equals("SERVICECATEGORY"))
			return getServiceCategory();
		if(fieldName.equals("CANBESCHEDULED"))
			return getCanBeScheduled();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("EXPECTEDTURNAROUND"))
			return getExpectedTurnaround();
		if(fieldName.equals("TURNAROUNDMEASURE"))
			return getTurnaroundMeasure();
		if(fieldName.equals("MATERNITYINDICATOR"))
			return getMaternityIndicator();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceNameIsNotNull()
	{
		return this.servicename != null;
	}
	public String getServiceName()
	{
		return this.servicename;
	}
	public static int getServiceNameMaxLength()
	{
		return 100;
	}
	public void setServiceName(String value)
	{
		this.isValidated = false;
		this.servicename = value;
	}
	public boolean getServiceCategoryIsNotNull()
	{
		return this.servicecategory != null;
	}
	public ims.core.vo.lookups.ServiceCategory getServiceCategory()
	{
		return this.servicecategory;
	}
	public void setServiceCategory(ims.core.vo.lookups.ServiceCategory value)
	{
		this.isValidated = false;
		this.servicecategory = value;
	}
	public boolean getCanBeScheduledIsNotNull()
	{
		return this.canbescheduled != null;
	}
	public Boolean getCanBeScheduled()
	{
		return this.canbescheduled;
	}
	public void setCanBeScheduled(Boolean value)
	{
		this.isValidated = false;
		this.canbescheduled = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getExpectedTurnaroundIsNotNull()
	{
		return this.expectedturnaround != null;
	}
	public Integer getExpectedTurnaround()
	{
		return this.expectedturnaround;
	}
	public void setExpectedTurnaround(Integer value)
	{
		this.isValidated = false;
		this.expectedturnaround = value;
	}
	public boolean getTurnaroundMeasureIsNotNull()
	{
		return this.turnaroundmeasure != null;
	}
	public ims.ocrr.vo.lookups.MinReorderPeriod getTurnaroundMeasure()
	{
		return this.turnaroundmeasure;
	}
	public void setTurnaroundMeasure(ims.ocrr.vo.lookups.MinReorderPeriod value)
	{
		this.isValidated = false;
		this.turnaroundmeasure = value;
	}
	public boolean getMaternityIndicatorIsNotNull()
	{
		return this.maternityindicator != null;
	}
	public Boolean getMaternityIndicator()
	{
		return this.maternityindicator;
	}
	public void setMaternityIndicator(Boolean value)
	{
		this.isValidated = false;
		this.maternityindicator = value;
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
		if(this.servicename == null || this.servicename.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.servicename.length() > 100)
			listOfErrors.add("The length of the field [servicename] in the value object [ims.core.vo.ServiceLiteVo] is too big. It should be less or equal to 100");
		if(this.servicecategory == null)
			listOfErrors.add("Category is mandatory");
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
	
		ServiceLiteVo clone = new ServiceLiteVo(this.id, this.version);
		
		clone.servicename = this.servicename;
		if(this.servicecategory == null)
			clone.servicecategory = null;
		else
			clone.servicecategory = (ims.core.vo.lookups.ServiceCategory)this.servicecategory.clone();
		clone.canbescheduled = this.canbescheduled;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		clone.expectedturnaround = this.expectedturnaround;
		if(this.turnaroundmeasure == null)
			clone.turnaroundmeasure = null;
		else
			clone.turnaroundmeasure = (ims.ocrr.vo.lookups.MinReorderPeriod)this.turnaroundmeasure.clone();
		clone.maternityindicator = this.maternityindicator;
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
		if (!(ServiceLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServiceLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ServiceLiteVo compareObj = (ServiceLiteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getServiceName() == null && compareObj.getServiceName() != null)
				return -1;
			if(this.getServiceName() != null && compareObj.getServiceName() == null)
				return 1;
			if(this.getServiceName() != null && compareObj.getServiceName() != null)
			{
				if(caseInsensitive)
					retVal = this.getServiceName().toLowerCase().compareTo(compareObj.getServiceName().toLowerCase());
				else
					retVal = this.getServiceName().compareTo(compareObj.getServiceName());
			}
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
		if(this.servicename != null)
			count++;
		if(this.servicecategory != null)
			count++;
		if(this.canbescheduled != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.expectedturnaround != null)
			count++;
		if(this.turnaroundmeasure != null)
			count++;
		if(this.maternityindicator != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected String servicename;
	protected ims.core.vo.lookups.ServiceCategory servicecategory;
	protected Boolean canbescheduled;
	protected ims.core.vo.lookups.Specialty specialty;
	protected Integer expectedturnaround;
	protected ims.ocrr.vo.lookups.MinReorderPeriod turnaroundmeasure;
	protected Boolean maternityindicator;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
