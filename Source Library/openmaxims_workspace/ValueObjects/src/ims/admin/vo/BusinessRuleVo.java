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

package ims.admin.vo;

/**
 * Linked to core.admin.BusinessRule business object (ID: 1004100040).
 */
public class BusinessRuleVo extends ims.core.admin.vo.BusinessRuleRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BusinessRuleVo()
	{
	}
	public BusinessRuleVo(Integer id, int version)
	{
		super(id, version);
	}
	public BusinessRuleVo(ims.admin.vo.beans.BusinessRuleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.category = bean.getCategory() == null ? null : ims.admin.vo.lookups.BusinessRuleCategory.buildLookup(bean.getCategory());
		this.validfrom = bean.getValidFrom() == null ? null : bean.getValidFrom().buildDate();
		this.validto = bean.getValidTo() == null ? null : bean.getValidTo().buildDate();
		this.priority = bean.getPriority();
		this.xmlcontent = bean.getXmlContent();
		this.active = bean.getActive();
		this.rootentity = bean.getRootEntity();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.BusinessRuleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.category = bean.getCategory() == null ? null : ims.admin.vo.lookups.BusinessRuleCategory.buildLookup(bean.getCategory());
		this.validfrom = bean.getValidFrom() == null ? null : bean.getValidFrom().buildDate();
		this.validto = bean.getValidTo() == null ? null : bean.getValidTo().buildDate();
		this.priority = bean.getPriority();
		this.xmlcontent = bean.getXmlContent();
		this.active = bean.getActive();
		this.rootentity = bean.getRootEntity();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.BusinessRuleVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.BusinessRuleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.BusinessRuleVoBean();
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
		if(fieldName.equals("VALIDFROM"))
			return getValidFrom();
		if(fieldName.equals("VALIDTO"))
			return getValidTo();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("XMLCONTENT"))
			return getXmlContent();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("ROOTENTITY"))
			return getRootEntity();
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
		return 255;
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
		return 255;
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
	public ims.admin.vo.lookups.BusinessRuleCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.admin.vo.lookups.BusinessRuleCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getValidFromIsNotNull()
	{
		return this.validfrom != null;
	}
	public ims.framework.utils.Date getValidFrom()
	{
		return this.validfrom;
	}
	public void setValidFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.validfrom = value;
	}
	public boolean getValidToIsNotNull()
	{
		return this.validto != null;
	}
	public ims.framework.utils.Date getValidTo()
	{
		return this.validto;
	}
	public void setValidTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.validto = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public Integer getPriority()
	{
		return this.priority;
	}
	public void setPriority(Integer value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getXmlContentIsNotNull()
	{
		return this.xmlcontent != null;
	}
	public String getXmlContent()
	{
		return this.xmlcontent;
	}
	public static int getXmlContentMaxLength()
	{
		return 100000;
	}
	public void setXmlContent(String value)
	{
		this.isValidated = false;
		this.xmlcontent = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getRootEntityIsNotNull()
	{
		return this.rootentity != null;
	}
	public String getRootEntity()
	{
		return this.rootentity;
	}
	public static int getRootEntityMaxLength()
	{
		return 20;
	}
	public void setRootEntity(String value)
	{
		this.isValidated = false;
		this.rootentity = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.admin.vo.BusinessRuleVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.admin.vo.BusinessRuleVo] is too big. It should be less or equal to 255");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.priority == null)
			listOfErrors.add("Priority is mandatory");
		if(this.xmlcontent == null || this.xmlcontent.length() == 0)
			listOfErrors.add("XmlContent is mandatory");
		if(this.active == null)
			listOfErrors.add("Active is mandatory");
		if(this.rootentity == null || this.rootentity.length() == 0)
			listOfErrors.add("RootEntity is mandatory");
		else if(this.rootentity.length() > 20)
			listOfErrors.add("The length of the field [rootentity] in the value object [ims.admin.vo.BusinessRuleVo] is too big. It should be less or equal to 20");
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
	
		BusinessRuleVo clone = new BusinessRuleVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.admin.vo.lookups.BusinessRuleCategory)this.category.clone();
		if(this.validfrom == null)
			clone.validfrom = null;
		else
			clone.validfrom = (ims.framework.utils.Date)this.validfrom.clone();
		if(this.validto == null)
			clone.validto = null;
		else
			clone.validto = (ims.framework.utils.Date)this.validto.clone();
		clone.priority = this.priority;
		clone.xmlcontent = this.xmlcontent;
		clone.active = this.active;
		clone.rootentity = this.rootentity;
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
		if (!(BusinessRuleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BusinessRuleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BusinessRuleVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BusinessRuleVo)obj).getBoId());
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
		if(this.validfrom != null)
			count++;
		if(this.validto != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.xmlcontent != null)
			count++;
		if(this.active != null)
			count++;
		if(this.rootentity != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String name;
	protected String description;
	protected ims.admin.vo.lookups.BusinessRuleCategory category;
	protected ims.framework.utils.Date validfrom;
	protected ims.framework.utils.Date validto;
	protected Integer priority;
	protected String xmlcontent;
	protected Boolean active;
	protected String rootentity;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
