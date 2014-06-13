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
 * Linked to Oncology.Configuration.TumourCategoryVersionGroups business object (ID: 1075100013).
 */
public class TumourCategoryVersionGroupsLiteVo extends ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourCategoryVersionGroupsLiteVo()
	{
	}
	public TumourCategoryVersionGroupsLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourCategoryVersionGroupsLiteVo(ims.clinicaladmin.vo.beans.TumourCategoryVersionGroupsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tnmversion = bean.getTNMVersion() == null ? null : bean.getTNMVersion().buildVo();
		if(bean.getGroups() != null)
		{
			this.groups = new ims.oncology.configuration.vo.TumourGroupRefVoCollection();
			for(int groups_i = 0; groups_i < bean.getGroups().length; groups_i++)
			{
				this.groups.add(new ims.oncology.configuration.vo.TumourGroupRefVo(new Integer(bean.getGroups()[groups_i].getId()), bean.getGroups()[groups_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourCategoryVersionGroupsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tnmversion = bean.getTNMVersion() == null ? null : bean.getTNMVersion().buildVo(map);
		if(bean.getGroups() != null)
		{
			this.groups = new ims.oncology.configuration.vo.TumourGroupRefVoCollection();
			for(int groups_i = 0; groups_i < bean.getGroups().length; groups_i++)
			{
				this.groups.add(new ims.oncology.configuration.vo.TumourGroupRefVo(new Integer(bean.getGroups()[groups_i].getId()), bean.getGroups()[groups_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourCategoryVersionGroupsLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourCategoryVersionGroupsLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourCategoryVersionGroupsLiteVoBean();
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
		if(fieldName.equals("TNMVERSION"))
			return getTNMVersion();
		if(fieldName.equals("GROUPS"))
			return getGroups();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTNMVersionIsNotNull()
	{
		return this.tnmversion != null;
	}
	public ims.clinicaladmin.vo.TNMStagingClassificationVersionLiteVo getTNMVersion()
	{
		return this.tnmversion;
	}
	public void setTNMVersion(ims.clinicaladmin.vo.TNMStagingClassificationVersionLiteVo value)
	{
		this.isValidated = false;
		this.tnmversion = value;
	}
	public boolean getGroupsIsNotNull()
	{
		return this.groups != null;
	}
	public ims.oncology.configuration.vo.TumourGroupRefVoCollection getGroups()
	{
		return this.groups;
	}
	public void setGroups(ims.oncology.configuration.vo.TumourGroupRefVoCollection value)
	{
		this.isValidated = false;
		this.groups = value;
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
		if(this.tnmversion == null)
			listOfErrors.add("Version is mandatory");
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
	
		TumourCategoryVersionGroupsLiteVo clone = new TumourCategoryVersionGroupsLiteVo(this.id, this.version);
		
		if(this.tnmversion == null)
			clone.tnmversion = null;
		else
			clone.tnmversion = (ims.clinicaladmin.vo.TNMStagingClassificationVersionLiteVo)this.tnmversion.clone();
		clone.groups = this.groups;
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
		if (!(TumourCategoryVersionGroupsLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourCategoryVersionGroupsLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourCategoryVersionGroupsLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourCategoryVersionGroupsLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tnmversion != null)
			count++;
		if(this.groups != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinicaladmin.vo.TNMStagingClassificationVersionLiteVo tnmversion;
	protected ims.oncology.configuration.vo.TumourGroupRefVoCollection groups;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
