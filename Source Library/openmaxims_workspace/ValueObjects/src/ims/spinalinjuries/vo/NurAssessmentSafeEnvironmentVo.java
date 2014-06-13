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

package ims.spinalinjuries.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class NurAssessmentSafeEnvironmentVo extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurAssessmentSafeEnvironmentVo()
	{
	}
	public NurAssessmentSafeEnvironmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurAssessmentSafeEnvironmentVo(ims.spinalinjuries.vo.beans.NurAssessmentSafeEnvironmentVoBean bean)
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
		this.maintainownsafety = bean.getMaintainOwnSafety() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getMaintainOwnSafety());
		this.haveaheadinjury = bean.getHaveAHeadInjury() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getHaveAHeadInjury());
		this.riskofautonomicdysreflexia = bean.getRiskOfAutonomicDysreflexia() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getRiskOfAutonomicDysreflexia());
		this.notes = bean.getNotes();
		this.safetylevel = ims.nursing.vo.SafetyLevelVoCollection.buildFromBeanCollection(bean.getSafetyLevel());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.beans.NurAssessmentSafeEnvironmentVoBean bean)
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
		this.maintainownsafety = bean.getMaintainOwnSafety() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getMaintainOwnSafety());
		this.haveaheadinjury = bean.getHaveAHeadInjury() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getHaveAHeadInjury());
		this.riskofautonomicdysreflexia = bean.getRiskOfAutonomicDysreflexia() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getRiskOfAutonomicDysreflexia());
		this.notes = bean.getNotes();
		this.safetylevel = ims.nursing.vo.SafetyLevelVoCollection.buildFromBeanCollection(bean.getSafetyLevel());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.beans.NurAssessmentSafeEnvironmentVoBean bean = null;
		if(map != null)
			bean = (ims.spinalinjuries.vo.beans.NurAssessmentSafeEnvironmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.spinalinjuries.vo.beans.NurAssessmentSafeEnvironmentVoBean();
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
		if(fieldName.equals("MAINTAINOWNSAFETY"))
			return getMaintainOwnSafety();
		if(fieldName.equals("HAVEAHEADINJURY"))
			return getHaveAHeadInjury();
		if(fieldName.equals("RISKOFAUTONOMICDYSREFLEXIA"))
			return getRiskOfAutonomicDysreflexia();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("SAFETYLEVEL"))
			return getSafetyLevel();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMaintainOwnSafetyIsNotNull()
	{
		return this.maintainownsafety != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getMaintainOwnSafety()
	{
		return this.maintainownsafety;
	}
	public void setMaintainOwnSafety(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.maintainownsafety = value;
	}
	public boolean getHaveAHeadInjuryIsNotNull()
	{
		return this.haveaheadinjury != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getHaveAHeadInjury()
	{
		return this.haveaheadinjury;
	}
	public void setHaveAHeadInjury(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.haveaheadinjury = value;
	}
	public boolean getRiskOfAutonomicDysreflexiaIsNotNull()
	{
		return this.riskofautonomicdysreflexia != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getRiskOfAutonomicDysreflexia()
	{
		return this.riskofautonomicdysreflexia;
	}
	public void setRiskOfAutonomicDysreflexia(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.riskofautonomicdysreflexia = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public static int getNotesMaxLength()
	{
		return 500;
	}
	public void setNotes(String value)
	{
		this.isValidated = false;
		this.notes = value;
	}
	public boolean getSafetyLevelIsNotNull()
	{
		return this.safetylevel != null;
	}
	public ims.nursing.vo.SafetyLevelVoCollection getSafetyLevel()
	{
		return this.safetylevel;
	}
	public void setSafetyLevel(ims.nursing.vo.SafetyLevelVoCollection value)
	{
		this.isValidated = false;
		this.safetylevel = value;
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
		if(this.safetylevel != null)
		{
			if(!this.safetylevel.isValidated())
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
		if(this.notes != null)
			if(this.notes.length() > 500)
				listOfErrors.add("The length of the field [notes] in the value object [ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo] is too big. It should be less or equal to 500");
		if(this.safetylevel != null)
		{
			String[] listOfOtherErrors = this.safetylevel.validate();
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
	
		NurAssessmentSafeEnvironmentVo clone = new NurAssessmentSafeEnvironmentVo(this.id, this.version);
		
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
		if(this.maintainownsafety == null)
			clone.maintainownsafety = null;
		else
			clone.maintainownsafety = (ims.core.vo.lookups.YesNoUnknown)this.maintainownsafety.clone();
		if(this.haveaheadinjury == null)
			clone.haveaheadinjury = null;
		else
			clone.haveaheadinjury = (ims.core.vo.lookups.YesNoUnknown)this.haveaheadinjury.clone();
		if(this.riskofautonomicdysreflexia == null)
			clone.riskofautonomicdysreflexia = null;
		else
			clone.riskofautonomicdysreflexia = (ims.core.vo.lookups.YesNoUnknown)this.riskofautonomicdysreflexia.clone();
		clone.notes = this.notes;
		if(this.safetylevel == null)
			clone.safetylevel = null;
		else
			clone.safetylevel = (ims.nursing.vo.SafetyLevelVoCollection)this.safetylevel.clone();
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
		if (!(NurAssessmentSafeEnvironmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurAssessmentSafeEnvironmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NurAssessmentSafeEnvironmentVo compareObj = (NurAssessmentSafeEnvironmentVo)obj;
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
		if(this.maintainownsafety != null)
			count++;
		if(this.haveaheadinjury != null)
			count++;
		if(this.riskofautonomicdysreflexia != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.safetylevel != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected ims.core.vo.lookups.YesNoUnknown maintainownsafety;
	protected ims.core.vo.lookups.YesNoUnknown haveaheadinjury;
	protected ims.core.vo.lookups.YesNoUnknown riskofautonomicdysreflexia;
	protected String notes;
	protected ims.nursing.vo.SafetyLevelVoCollection safetylevel;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
