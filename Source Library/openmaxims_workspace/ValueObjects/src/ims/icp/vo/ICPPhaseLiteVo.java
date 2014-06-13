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
public class ICPPhaseLiteVo extends ims.icps.configuration.vo.ICPPhaseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPPhaseLiteVo()
	{
	}
	public ICPPhaseLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPPhaseLiteVo(ims.icp.vo.beans.ICPPhaseLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.goals = ims.icp.vo.IcpPhaseGoalVoCollection.buildFromBeanCollection(bean.getGoals());
		this.helpurl = bean.getHelpURL();
		this.sequence = bean.getSequence();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPPhaseLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.goals = ims.icp.vo.IcpPhaseGoalVoCollection.buildFromBeanCollection(bean.getGoals());
		this.helpurl = bean.getHelpURL();
		this.sequence = bean.getSequence();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPPhaseLiteVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPPhaseLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPPhaseLiteVoBean();
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
		if(fieldName.equals("GOALS"))
			return getGoals();
		if(fieldName.equals("HELPURL"))
			return getHelpURL();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("STATUS"))
			return getStatus();
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
	public boolean getGoalsIsNotNull()
	{
		return this.goals != null;
	}
	public ims.icp.vo.IcpPhaseGoalVoCollection getGoals()
	{
		return this.goals;
	}
	public void setGoals(ims.icp.vo.IcpPhaseGoalVoCollection value)
	{
		this.isValidated = false;
		this.goals = value;
	}
	public boolean getHelpURLIsNotNull()
	{
		return this.helpurl != null;
	}
	public String getHelpURL()
	{
		return this.helpurl;
	}
	public static int getHelpURLMaxLength()
	{
		return 255;
	}
	public void setHelpURL(String value)
	{
		this.isValidated = false;
		this.helpurl = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
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
		if(this.goals != null)
		{
			if(!this.goals.isValidated())
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
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPPhaseLiteVo] is too big. It should be less or equal to 255");
		if(this.goals != null)
		{
			String[] listOfOtherErrors = this.goals.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.helpurl != null)
			if(this.helpurl.length() > 255)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.icp.vo.ICPPhaseLiteVo] is too big. It should be less or equal to 255");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
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
	
		ICPPhaseLiteVo clone = new ICPPhaseLiteVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.goals == null)
			clone.goals = null;
		else
			clone.goals = (ims.icp.vo.IcpPhaseGoalVoCollection)this.goals.clone();
		clone.helpurl = this.helpurl;
		clone.sequence = this.sequence;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
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
		if (!(ICPPhaseLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPPhaseLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ICPPhaseLiteVo compareObj = (ICPPhaseLiteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSequence() == null && compareObj.getSequence() != null)
				return -1;
			if(this.getSequence() != null && compareObj.getSequence() == null)
				return 1;
			if(this.getSequence() != null && compareObj.getSequence() != null)
				retVal = this.getSequence().compareTo(compareObj.getSequence());
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
		if(this.name != null)
			count++;
		if(this.goals != null)
			count++;
		if(this.helpurl != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected ims.icp.vo.IcpPhaseGoalVoCollection goals;
	protected String helpurl;
	protected Integer sequence;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
