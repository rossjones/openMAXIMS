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

package ims.clinical.vo;

/**
 * Linked to clinical.configuration.PresentingComplaintHotlist business object (ID: 1073100027).
 */
public class PresentingComplainHotlistVo extends ims.clinical.configuration.vo.PresentingComplaintHotlistRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlistShort, ims.vo.interfaces.IHotlist
{
	private static final long serialVersionUID = 1L;

	public PresentingComplainHotlistVo()
	{
	}
	public PresentingComplainHotlistVo(Integer id, int version)
	{
		super(id, version);
	}
	public PresentingComplainHotlistVo(ims.clinical.vo.beans.PresentingComplainHotlistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.hotlistitems = ims.clinical.vo.PresentingComplaintHotlistItemVoCollection.buildFromBeanCollection(bean.getHotListItems());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PresentingComplainHotlistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.hotlistitems = ims.clinical.vo.PresentingComplaintHotlistItemVoCollection.buildFromBeanCollection(bean.getHotListItems());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PresentingComplainHotlistVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PresentingComplainHotlistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PresentingComplainHotlistVoBean();
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
		if(fieldName.equals("ISGLOBAL"))
			return getIsGlobal();
		if(fieldName.equals("USER"))
			return getUser();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("HOTLISTITEMS"))
			return getHotListItems();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsGlobalIsNotNull()
	{
		return this.isglobal != null;
	}
	public Boolean getIsGlobal()
	{
		return this.isglobal;
	}
	public void setIsGlobal(Boolean value)
	{
		this.isValidated = false;
		this.isglobal = value;
	}
	public boolean getUserIsNotNull()
	{
		return this.user != null;
	}
	public ims.core.resource.people.vo.MedicRefVo getUser()
	{
		return this.user;
	}
	public void setUser(ims.core.resource.people.vo.MedicRefVo value)
	{
		this.isValidated = false;
		this.user = value;
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
	public boolean getHotListItemsIsNotNull()
	{
		return this.hotlistitems != null;
	}
	public ims.clinical.vo.PresentingComplaintHotlistItemVoCollection getHotListItems()
	{
		return this.hotlistitems;
	}
	public void setHotListItems(ims.clinical.vo.PresentingComplaintHotlistItemVoCollection value)
	{
		this.isValidated = false;
		this.hotlistitems = value;
	}
	/**
	* IHotlistShort
	*/
	public Boolean getISpecialtyIsNotNull() 
	{
		return Boolean.valueOf(this.getSpecialtyIsNotNull());
	}
		
	public ims.core.vo.lookups.Specialty getISpecialty() 
	{
		return this.getSpecialty();
	}
	
	public Integer getIHotlistShortID() 
	{
		return this.getID_PresentingComplaintHotlist();
	}
	
	public void setISpecialty(ims.core.vo.lookups.Specialty specialty) 
	{
		this.setSpecialty(specialty);
	}
		
	public void setIisGlobal(Boolean isGlobal) 
	{
		this.setIisGlobal(isGlobal);
	}
	
	public Boolean isIValidated() 
	{
		return Boolean.valueOf(this.isValidated());
	}
	
	public String[] iValidate(String[] strText)
	{
		return this.validate(strText);
	}
	
	/**
	* IHotlist
	*/
		public ims.vo.interfaces.IHotlistItem[] getIHotlistItems() 
		{
			return this.getHotListItems().toIHotlistItemArray();
		}
		
		public void removeIHotlistItem(ims.vo.interfaces.IHotlistItem iHotlistItem) 
		{
			this.getHotListItems().remove((PresentingComplaintHotlistItemVo)iHotlistItem);
		}
		
		public void addIHotlistItem(ims.vo.interfaces.IGenericItemInfo cciItem) 
		{
			PresentingComplaintHotlistItemVo newItem = new PresentingComplaintHotlistItemVo();
			newItem.setPresentingComplaint((PresentingComplaintLiteVo)cciItem);
			this.getHotListItems().add(newItem);
		}
		
		public void setIHotlistItems(ims.vo.interfaces.IHotlistItem[] iHotlistItems) 
		{
			if (iHotlistItems == null)
				return;
			
			PresentingComplaintHotlistItemVoCollection voColl = new PresentingComplaintHotlistItemVoCollection();
			for (int i = 0; i < iHotlistItems.length; i++)
			{
				voColl.add((PresentingComplaintHotlistItemVo)iHotlistItems[i]);
			}
			this.setHotListItems(voColl);
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
		if(this.hotlistitems != null)
		{
			if(!this.hotlistitems.isValidated())
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
		if(this.hotlistitems == null || this.hotlistitems.size() == 0)
			listOfErrors.add("HotListItem are mandatory");
		if(this.hotlistitems != null)
		{
			String[] listOfOtherErrors = this.hotlistitems.validate();
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
	
		PresentingComplainHotlistVo clone = new PresentingComplainHotlistVo(this.id, this.version);
		
		clone.isglobal = this.isglobal;
		clone.user = this.user;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.hotlistitems == null)
			clone.hotlistitems = null;
		else
			clone.hotlistitems = (ims.clinical.vo.PresentingComplaintHotlistItemVoCollection)this.hotlistitems.clone();
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
		if (!(PresentingComplainHotlistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PresentingComplainHotlistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PresentingComplainHotlistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PresentingComplainHotlistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.isglobal != null)
			count++;
		if(this.user != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.hotlistitems != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected Boolean isglobal;
	protected ims.core.resource.people.vo.MedicRefVo user;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.clinical.vo.PresentingComplaintHotlistItemVoCollection hotlistitems;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
