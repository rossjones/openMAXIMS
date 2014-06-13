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

package ims.icp.vo;

/**
 * Linked to ICPs.Configuration.ICPPhase business object (ID: 1060100002).
 */
public class ICPPhaseListVo extends ims.icps.configuration.vo.ICPPhaseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPPhaseListVo()
	{
	}
	public ICPPhaseListVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPPhaseListVo(ims.icp.vo.beans.ICPPhaseListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.icpname = bean.getICPName();
		this.stagename = bean.getStageName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPPhaseListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.icpname = bean.getICPName();
		this.stagename = bean.getStageName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPPhaseListVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPPhaseListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPPhaseListVoBean();
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
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("ICPNAME"))
			return getICPName();
		if(fieldName.equals("STAGENAME"))
			return getStageName();
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
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getICPNameIsNotNull()
	{
		return this.icpname != null;
	}
	public String getICPName()
	{
		return this.icpname;
	}
	public static int getICPNameMaxLength()
	{
		return 255;
	}
	public void setICPName(String value)
	{
		this.isValidated = false;
		this.icpname = value;
	}
	public boolean getStageNameIsNotNull()
	{
		return this.stagename != null;
	}
	public String getStageName()
	{
		return this.stagename;
	}
	public static int getStageNameMaxLength()
	{
		return 255;
	}
	public void setStageName(String value)
	{
		this.isValidated = false;
		this.stagename = value;
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
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPPhaseListVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.icp.vo.ICPPhaseListVo] is too big. It should be less or equal to 255");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		ICPPhaseListVo clone = new ICPPhaseListVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.icpname = this.icpname;
		clone.stagename = this.stagename;
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
		if (!(ICPPhaseListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPPhaseListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICPPhaseListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICPPhaseListVo)obj).getBoId());
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
		if(this.status != null)
			count++;
		if(this.icpname != null)
			count++;
		if(this.stagename != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected String description;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected String icpname;
	protected String stagename;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
