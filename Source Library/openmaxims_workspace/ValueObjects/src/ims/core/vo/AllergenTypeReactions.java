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
 * Linked to core.clinical.AllergenTypeReaction business object (ID: 1003100023).
 */
public class AllergenTypeReactions extends ims.core.clinical.vo.AllergenTypeReactionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AllergenTypeReactions()
	{
	}
	public AllergenTypeReactions(Integer id, int version)
	{
		super(id, version);
	}
	public AllergenTypeReactions(ims.core.vo.beans.AllergenTypeReactionsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reaction = bean.getReaction() == null ? null : ims.core.vo.lookups.AllergyReaction.buildLookup(bean.getReaction());
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AllergenTypeReactionsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reaction = bean.getReaction() == null ? null : ims.core.vo.lookups.AllergyReaction.buildLookup(bean.getReaction());
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AllergenTypeReactionsBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AllergenTypeReactionsBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AllergenTypeReactionsBean();
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
		if(fieldName.equals("REACTION"))
			return getReaction();
		if(fieldName.equals("ALLERGENTYPE"))
			return getAllergenType();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReactionIsNotNull()
	{
		return this.reaction != null;
	}
	public ims.core.vo.lookups.AllergyReaction getReaction()
	{
		return this.reaction;
	}
	public void setReaction(ims.core.vo.lookups.AllergyReaction value)
	{
		this.isValidated = false;
		this.reaction = value;
	}
	public boolean getAllergenTypeIsNotNull()
	{
		return this.allergentype != null;
	}
	public ims.core.vo.lookups.AllergenType getAllergenType()
	{
		return this.allergentype;
	}
	public void setAllergenType(ims.core.vo.lookups.AllergenType value)
	{
		this.isValidated = false;
		this.allergentype = value;
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
	
		AllergenTypeReactions clone = new AllergenTypeReactions(this.id, this.version);
		
		if(this.reaction == null)
			clone.reaction = null;
		else
			clone.reaction = (ims.core.vo.lookups.AllergyReaction)this.reaction.clone();
		if(this.allergentype == null)
			clone.allergentype = null;
		else
			clone.allergentype = (ims.core.vo.lookups.AllergenType)this.allergentype.clone();
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
		if (!(AllergenTypeReactions.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AllergenTypeReactions object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AllergenTypeReactions compareObj = (AllergenTypeReactions)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReaction() == null && compareObj.getReaction() != null)
				return -1;
			if(this.getReaction() != null && compareObj.getReaction() == null)
				return 1;
			if(this.getReaction() != null && compareObj.getReaction() != null)
				retVal = this.getReaction().compareTo(compareObj.getReaction());
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
		if(this.reaction != null)
			count++;
		if(this.allergentype != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.AllergyReaction reaction;
	protected ims.core.vo.lookups.AllergenType allergentype;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
