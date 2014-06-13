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

package ims.coe.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class AssessmentDressingAndGrooming extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentDressingAndGrooming()
	{
	}
	public AssessmentDressingAndGrooming(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentDressingAndGrooming(ims.coe.vo.beans.AssessmentDressingAndGroomingBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo();
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.activities = ims.nursing.vo.DressingAndGroomingActivitiesCollection.buildFromBeanCollection(bean.getActivities());
		this.preferences = ims.coe.vo.DressingAndGroomingPreferencesCollection.buildFromBeanCollection(bean.getPreferences());
		this.shavingpreference = bean.getShavingPreference() == null ? null : ims.coe.vo.lookups.ShavingPreference.buildLookup(bean.getShavingPreference());
		this.shavingpattern = bean.getShavingPattern();
		this.assistancewithdressingandgrooming = bean.getAssistanceWithDressingAndGrooming() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAssistanceWithDressingAndGrooming());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.AssessmentDressingAndGroomingBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo(map);
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.activities = ims.nursing.vo.DressingAndGroomingActivitiesCollection.buildFromBeanCollection(bean.getActivities());
		this.preferences = ims.coe.vo.DressingAndGroomingPreferencesCollection.buildFromBeanCollection(bean.getPreferences());
		this.shavingpreference = bean.getShavingPreference() == null ? null : ims.coe.vo.lookups.ShavingPreference.buildLookup(bean.getShavingPreference());
		this.shavingpattern = bean.getShavingPattern();
		this.assistancewithdressingandgrooming = bean.getAssistanceWithDressingAndGrooming() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAssistanceWithDressingAndGrooming());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.AssessmentDressingAndGroomingBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.AssessmentDressingAndGroomingBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.AssessmentDressingAndGroomingBean();
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
		if(fieldName.equals("ACTIVITIES"))
			return getActivities();
		if(fieldName.equals("PREFERENCES"))
			return getPreferences();
		if(fieldName.equals("SHAVINGPREFERENCE"))
			return getShavingPreference();
		if(fieldName.equals("SHAVINGPATTERN"))
			return getShavingPattern();
		if(fieldName.equals("ASSISTANCEWITHDRESSINGANDGROOMING"))
			return getAssistanceWithDressingAndGrooming();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActivitiesIsNotNull()
	{
		return this.activities != null;
	}
	public ims.nursing.vo.DressingAndGroomingActivitiesCollection getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.nursing.vo.DressingAndGroomingActivitiesCollection value)
	{
		this.isValidated = false;
		this.activities = value;
	}
	public boolean getPreferencesIsNotNull()
	{
		return this.preferences != null;
	}
	public ims.coe.vo.DressingAndGroomingPreferencesCollection getPreferences()
	{
		return this.preferences;
	}
	public void setPreferences(ims.coe.vo.DressingAndGroomingPreferencesCollection value)
	{
		this.isValidated = false;
		this.preferences = value;
	}
	public boolean getShavingPreferenceIsNotNull()
	{
		return this.shavingpreference != null;
	}
	public ims.coe.vo.lookups.ShavingPreference getShavingPreference()
	{
		return this.shavingpreference;
	}
	public void setShavingPreference(ims.coe.vo.lookups.ShavingPreference value)
	{
		this.isValidated = false;
		this.shavingpreference = value;
	}
	public boolean getShavingPatternIsNotNull()
	{
		return this.shavingpattern != null;
	}
	public String getShavingPattern()
	{
		return this.shavingpattern;
	}
	public static int getShavingPatternMaxLength()
	{
		return 255;
	}
	public void setShavingPattern(String value)
	{
		this.isValidated = false;
		this.shavingpattern = value;
	}
	public boolean getAssistanceWithDressingAndGroomingIsNotNull()
	{
		return this.assistancewithdressingandgrooming != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getAssistanceWithDressingAndGrooming()
	{
		return this.assistancewithdressingandgrooming;
	}
	public void setAssistanceWithDressingAndGrooming(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.assistancewithdressingandgrooming = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.id);
		return sb.toString();
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
		if(this.assessmentinfo != null)
		{
			if(!this.assessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastassessmentinfo != null)
		{
			if(!this.lastassessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplantemplate != null)
		{
			if(!this.careplantemplate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplans != null)
		{
			if(!this.careplans.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activities != null)
		{
			if(!this.activities.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.preferences != null)
		{
			if(!this.preferences.isValidated())
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
		if(this.assessmentinfo != null)
		{
			String[] listOfOtherErrors = this.assessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastassessmentinfo != null)
		{
			String[] listOfOtherErrors = this.lastassessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplantemplate != null)
		{
			String[] listOfOtherErrors = this.careplantemplate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplans != null)
		{
			String[] listOfOtherErrors = this.careplans.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activities != null)
		{
			String[] listOfOtherErrors = this.activities.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.preferences != null)
		{
			String[] listOfOtherErrors = this.preferences.validate();
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
	
		AssessmentDressingAndGrooming clone = new AssessmentDressingAndGrooming(this.id, this.version);
		
		clone.iscomplete = this.iscomplete;
		if(this.assessmentinfo == null)
			clone.assessmentinfo = null;
		else
			clone.assessmentinfo = (ims.nursing.vo.AssessmentInfoCollection)this.assessmentinfo.clone();
		clone.copy = this.copy;
		if(this.componenttype == null)
			clone.componenttype = null;
		else
			clone.componenttype = (ims.nursing.vo.lookups.AssessmentComponentType)this.componenttype.clone();
		if(this.lastassessmentinfo == null)
			clone.lastassessmentinfo = null;
		else
			clone.lastassessmentinfo = (ims.nursing.vo.AssessmentInfo)this.lastassessmentinfo.clone();
		if(this.careplantemplate == null)
			clone.careplantemplate = null;
		else
			clone.careplantemplate = (ims.nursing.vo.CarePlanTemplateCollection)this.careplantemplate.clone();
		if(this.careplans == null)
			clone.careplans = null;
		else
			clone.careplans = (ims.nursing.vo.CarePlanCollection)this.careplans.clone();
		if(this.activities == null)
			clone.activities = null;
		else
			clone.activities = (ims.nursing.vo.DressingAndGroomingActivitiesCollection)this.activities.clone();
		if(this.preferences == null)
			clone.preferences = null;
		else
			clone.preferences = (ims.coe.vo.DressingAndGroomingPreferencesCollection)this.preferences.clone();
		if(this.shavingpreference == null)
			clone.shavingpreference = null;
		else
			clone.shavingpreference = (ims.coe.vo.lookups.ShavingPreference)this.shavingpreference.clone();
		clone.shavingpattern = this.shavingpattern;
		if(this.assistancewithdressingandgrooming == null)
			clone.assistancewithdressingandgrooming = null;
		else
			clone.assistancewithdressingandgrooming = (ims.core.vo.lookups.YesNoUnknown)this.assistancewithdressingandgrooming.clone();
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
		if (!(AssessmentDressingAndGrooming.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentDressingAndGrooming object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssessmentDressingAndGrooming compareObj = (AssessmentDressingAndGrooming)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_AssessmentComponent() == null && compareObj.getID_AssessmentComponent() != null)
				return -1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() == null)
				return 1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() != null)
				retVal = this.getID_AssessmentComponent().compareTo(compareObj.getID_AssessmentComponent());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.activities != null)
			count++;
		if(this.preferences != null)
			count++;
		if(this.shavingpreference != null)
			count++;
		if(this.shavingpattern != null)
			count++;
		if(this.assistancewithdressingandgrooming != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected ims.nursing.vo.DressingAndGroomingActivitiesCollection activities;
	protected ims.coe.vo.DressingAndGroomingPreferencesCollection preferences;
	protected ims.coe.vo.lookups.ShavingPreference shavingpreference;
	protected String shavingpattern;
	protected ims.core.vo.lookups.YesNoUnknown assistancewithdressingandgrooming;
	private boolean isValidated = false;
	private boolean isBusy = false;
}