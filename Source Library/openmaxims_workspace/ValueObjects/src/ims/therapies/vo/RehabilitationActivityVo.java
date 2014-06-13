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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.RehabilitationActivity business object (ID: 1019100009).
 */
public class RehabilitationActivityVo extends ims.therapies.treatment.vo.RehabilitationActivityRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RehabilitationActivityVo()
	{
	}
	public RehabilitationActivityVo(Integer id, int version)
	{
		super(id, version);
	}
	public RehabilitationActivityVo(ims.therapies.vo.beans.RehabilitationActivityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.location = bean.getLocation() == null ? null : ims.spinalinjuries.vo.lookups.RehabLocation.buildLookup(bean.getLocation());
		this.purpose = bean.getPurpose() == null ? null : ims.spinalinjuries.vo.lookups.RehabPurpose.buildLookup(bean.getPurpose());
		this.independencelevel = bean.getIndependenceLevel() == null ? null : ims.spinalinjuries.vo.lookups.RehabIndependenceLevel.buildLookup(bean.getIndependenceLevel());
		this.activitytype = bean.getActivityType() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivityType());
		this.activitycategory = bean.getActivityCategory() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivityCategory());
		this.activitygroup = bean.getActivityGroup() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivityGroup());
		this.activity = bean.getActivity() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivity());
		this.technique = ims.spinalinjuries.vo.lookups.RehabTechniqueCollection.buildFromBeanCollection(bean.getTechnique());
		this.equipment = ims.spinalinjuries.vo.lookups.RehabEquipmentCollection.buildFromBeanCollection(bean.getEquipment());
		this.envadaptations = ims.spinalinjuries.vo.lookups.RehabEnvAdaptationCollection.buildFromBeanCollection(bean.getEnvAdaptations());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.RehabilitationActivityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.location = bean.getLocation() == null ? null : ims.spinalinjuries.vo.lookups.RehabLocation.buildLookup(bean.getLocation());
		this.purpose = bean.getPurpose() == null ? null : ims.spinalinjuries.vo.lookups.RehabPurpose.buildLookup(bean.getPurpose());
		this.independencelevel = bean.getIndependenceLevel() == null ? null : ims.spinalinjuries.vo.lookups.RehabIndependenceLevel.buildLookup(bean.getIndependenceLevel());
		this.activitytype = bean.getActivityType() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivityType());
		this.activitycategory = bean.getActivityCategory() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivityCategory());
		this.activitygroup = bean.getActivityGroup() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivityGroup());
		this.activity = bean.getActivity() == null ? null : ims.spinalinjuries.vo.lookups.RehabActivity.buildLookup(bean.getActivity());
		this.technique = ims.spinalinjuries.vo.lookups.RehabTechniqueCollection.buildFromBeanCollection(bean.getTechnique());
		this.equipment = ims.spinalinjuries.vo.lookups.RehabEquipmentCollection.buildFromBeanCollection(bean.getEquipment());
		this.envadaptations = ims.spinalinjuries.vo.lookups.RehabEnvAdaptationCollection.buildFromBeanCollection(bean.getEnvAdaptations());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.RehabilitationActivityVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.RehabilitationActivityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.RehabilitationActivityVoBean();
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
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("PURPOSE"))
			return getPurpose();
		if(fieldName.equals("INDEPENDENCELEVEL"))
			return getIndependenceLevel();
		if(fieldName.equals("ACTIVITYTYPE"))
			return getActivityType();
		if(fieldName.equals("ACTIVITYCATEGORY"))
			return getActivityCategory();
		if(fieldName.equals("ACTIVITYGROUP"))
			return getActivityGroup();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("TECHNIQUE"))
			return getTechnique();
		if(fieldName.equals("EQUIPMENT"))
			return getEquipment();
		if(fieldName.equals("ENVADAPTATIONS"))
			return getEnvAdaptations();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabLocation getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.spinalinjuries.vo.lookups.RehabLocation value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getPurposeIsNotNull()
	{
		return this.purpose != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabPurpose getPurpose()
	{
		return this.purpose;
	}
	public void setPurpose(ims.spinalinjuries.vo.lookups.RehabPurpose value)
	{
		this.isValidated = false;
		this.purpose = value;
	}
	public boolean getIndependenceLevelIsNotNull()
	{
		return this.independencelevel != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabIndependenceLevel getIndependenceLevel()
	{
		return this.independencelevel;
	}
	public void setIndependenceLevel(ims.spinalinjuries.vo.lookups.RehabIndependenceLevel value)
	{
		this.isValidated = false;
		this.independencelevel = value;
	}
	public boolean getActivityTypeIsNotNull()
	{
		return this.activitytype != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabActivity getActivityType()
	{
		return this.activitytype;
	}
	public void setActivityType(ims.spinalinjuries.vo.lookups.RehabActivity value)
	{
		this.isValidated = false;
		this.activitytype = value;
	}
	public boolean getActivityCategoryIsNotNull()
	{
		return this.activitycategory != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabActivity getActivityCategory()
	{
		return this.activitycategory;
	}
	public void setActivityCategory(ims.spinalinjuries.vo.lookups.RehabActivity value)
	{
		this.isValidated = false;
		this.activitycategory = value;
	}
	public boolean getActivityGroupIsNotNull()
	{
		return this.activitygroup != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabActivity getActivityGroup()
	{
		return this.activitygroup;
	}
	public void setActivityGroup(ims.spinalinjuries.vo.lookups.RehabActivity value)
	{
		this.isValidated = false;
		this.activitygroup = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabActivity getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.spinalinjuries.vo.lookups.RehabActivity value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getTechniqueIsNotNull()
	{
		return this.technique != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabTechniqueCollection getTechnique()
	{
		return this.technique;
	}
	public void setTechnique(ims.spinalinjuries.vo.lookups.RehabTechniqueCollection value)
	{
		this.isValidated = false;
		this.technique = value;
	}
	public boolean getEquipmentIsNotNull()
	{
		return this.equipment != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabEquipmentCollection getEquipment()
	{
		return this.equipment;
	}
	public void setEquipment(ims.spinalinjuries.vo.lookups.RehabEquipmentCollection value)
	{
		this.isValidated = false;
		this.equipment = value;
	}
	public boolean getEnvAdaptationsIsNotNull()
	{
		return this.envadaptations != null;
	}
	public ims.spinalinjuries.vo.lookups.RehabEnvAdaptationCollection getEnvAdaptations()
	{
		return this.envadaptations;
	}
	public void setEnvAdaptations(ims.spinalinjuries.vo.lookups.RehabEnvAdaptationCollection value)
	{
		this.isValidated = false;
		this.envadaptations = value;
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
		if(this.location == null)
			listOfErrors.add("Location is mandatory");
		if(this.purpose == null)
			listOfErrors.add("Purpose is mandatory");
		if(this.independencelevel == null)
			listOfErrors.add("Independence Level is mandatory");
		if(this.activitytype == null)
			listOfErrors.add("Activity Type is mandatory");
		if(this.activitycategory == null)
			listOfErrors.add("Activity Category is mandatory");
		if(this.activitygroup == null)
			listOfErrors.add("Activity Group is mandatory");
		if(this.activity == null)
			listOfErrors.add("Activity is mandatory");
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
	
		RehabilitationActivityVo clone = new RehabilitationActivityVo(this.id, this.version);
		
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.spinalinjuries.vo.lookups.RehabLocation)this.location.clone();
		if(this.purpose == null)
			clone.purpose = null;
		else
			clone.purpose = (ims.spinalinjuries.vo.lookups.RehabPurpose)this.purpose.clone();
		if(this.independencelevel == null)
			clone.independencelevel = null;
		else
			clone.independencelevel = (ims.spinalinjuries.vo.lookups.RehabIndependenceLevel)this.independencelevel.clone();
		if(this.activitytype == null)
			clone.activitytype = null;
		else
			clone.activitytype = (ims.spinalinjuries.vo.lookups.RehabActivity)this.activitytype.clone();
		if(this.activitycategory == null)
			clone.activitycategory = null;
		else
			clone.activitycategory = (ims.spinalinjuries.vo.lookups.RehabActivity)this.activitycategory.clone();
		if(this.activitygroup == null)
			clone.activitygroup = null;
		else
			clone.activitygroup = (ims.spinalinjuries.vo.lookups.RehabActivity)this.activitygroup.clone();
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.spinalinjuries.vo.lookups.RehabActivity)this.activity.clone();
		if(this.technique == null)
			clone.technique = null;
		else
			clone.technique = (ims.spinalinjuries.vo.lookups.RehabTechniqueCollection)this.technique.clone();
		if(this.equipment == null)
			clone.equipment = null;
		else
			clone.equipment = (ims.spinalinjuries.vo.lookups.RehabEquipmentCollection)this.equipment.clone();
		if(this.envadaptations == null)
			clone.envadaptations = null;
		else
			clone.envadaptations = (ims.spinalinjuries.vo.lookups.RehabEnvAdaptationCollection)this.envadaptations.clone();
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
		if (!(RehabilitationActivityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RehabilitationActivityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		RehabilitationActivityVo compareObj = (RehabilitationActivityVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_RehabilitationActivity() == null && compareObj.getID_RehabilitationActivity() != null)
				return -1;
			if(this.getID_RehabilitationActivity() != null && compareObj.getID_RehabilitationActivity() == null)
				return 1;
			if(this.getID_RehabilitationActivity() != null && compareObj.getID_RehabilitationActivity() != null)
				retVal = this.getID_RehabilitationActivity().compareTo(compareObj.getID_RehabilitationActivity());
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
		if(this.location != null)
			count++;
		if(this.purpose != null)
			count++;
		if(this.independencelevel != null)
			count++;
		if(this.activitytype != null)
			count++;
		if(this.activitycategory != null)
			count++;
		if(this.activitygroup != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.technique != null)
			count++;
		if(this.equipment != null)
			count++;
		if(this.envadaptations != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.spinalinjuries.vo.lookups.RehabLocation location;
	protected ims.spinalinjuries.vo.lookups.RehabPurpose purpose;
	protected ims.spinalinjuries.vo.lookups.RehabIndependenceLevel independencelevel;
	protected ims.spinalinjuries.vo.lookups.RehabActivity activitytype;
	protected ims.spinalinjuries.vo.lookups.RehabActivity activitycategory;
	protected ims.spinalinjuries.vo.lookups.RehabActivity activitygroup;
	protected ims.spinalinjuries.vo.lookups.RehabActivity activity;
	protected ims.spinalinjuries.vo.lookups.RehabTechniqueCollection technique;
	protected ims.spinalinjuries.vo.lookups.RehabEquipmentCollection equipment;
	protected ims.spinalinjuries.vo.lookups.RehabEnvAdaptationCollection envadaptations;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
