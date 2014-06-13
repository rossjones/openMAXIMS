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

package ims.assessment.vo;

/**
 * Linked to Assessment.Configuration.UserAssessment business object (ID: 1003100043).
 */
public class UserAssessmentWithServiceCollVo extends ims.assessment.configuration.vo.UserAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserAssessmentWithServiceCollVo()
	{
	}
	public UserAssessmentWithServiceCollVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserAssessmentWithServiceCollVo(ims.assessment.vo.beans.UserAssessmentWithServiceCollVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserAssessmentCategory.buildLookup(bean.getCategory());
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.UserAssessmentWithServiceCollVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserAssessmentCategory.buildLookup(bean.getCategory());
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.UserAssessmentWithServiceCollVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.UserAssessmentWithServiceCollVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.UserAssessmentWithServiceCollVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("SERVICES"))
			return getServices();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 500;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.UserAssessmentCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.UserAssessmentCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getServicesIsNotNull()
	{
		return this.services != null;
	}
	public ims.core.vo.ServiceShortVoCollection getServices()
	{
		return this.services;
	}
	public void setServices(ims.core.vo.ServiceShortVoCollection value)
	{
		this.isValidated = false;
		this.services = value;
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
		if(this.services != null)
		{
			if(!this.services.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.assessment.vo.UserAssessmentWithServiceCollVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.assessment.vo.UserAssessmentWithServiceCollVo] is too big. It should be less or equal to 500");
		if(this.services != null)
		{
			String[] listOfOtherErrors = this.services.validate();
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
	
		UserAssessmentWithServiceCollVo clone = new UserAssessmentWithServiceCollVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.UserAssessmentCategory)this.category.clone();
		if(this.services == null)
			clone.services = null;
		else
			clone.services = (ims.core.vo.ServiceShortVoCollection)this.services.clone();
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
		if (!(UserAssessmentWithServiceCollVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserAssessmentWithServiceCollVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((UserAssessmentWithServiceCollVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((UserAssessmentWithServiceCollVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.category != null)
			count++;
		if(this.services != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected String description;
	protected ims.core.vo.lookups.UserAssessmentCategory category;
	protected ims.core.vo.ServiceShortVoCollection services;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
