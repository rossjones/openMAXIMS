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

package ims.spinalinjuries.forms.nurassessmentsafeenvironement;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.NurAssessmentSafeEnvironement.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.NurAssessmentSafeEnvironement domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansHeadInjuryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansHeadInjury().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansHeadInjuryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansHeadInjuryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansHeadInjury().addOption(instance);
		}
	}
	protected final void bindansHeadInjuryLookup()
	{
		this.form.ansHeadInjury().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansHeadInjury().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansHeadInjuryLookupValue()
	{
		this.form.ansHeadInjury().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onansAutonomicDysreflexiaValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansAutonomicDysreflexia().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansAutonomicDysreflexiaLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansAutonomicDysreflexiaLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansAutonomicDysreflexia().addOption(instance);
		}
	}
	protected final void bindansAutonomicDysreflexiaLookup()
	{
		this.form.ansAutonomicDysreflexia().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansAutonomicDysreflexia().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansAutonomicDysreflexiaLookupValue()
	{
		this.form.ansAutonomicDysreflexia().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onansOwnSafetyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansOwnSafety().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansOwnSafetyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansOwnSafetyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansOwnSafety().addOption(instance);
		}
	}
	protected final void bindansOwnSafetyLookup()
	{
		this.form.ansOwnSafety().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansOwnSafety().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansOwnSafetyLookupValue()
	{
		this.form.ansOwnSafety().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void bindgridSafetyColSelectLookup()
	{
		this.form.gridSafety().answerBoxColumnClear(1);
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.gridSafety().answerBoxColumnNewOption(1, lookupCollection.get(x));
		}
	}
	protected void clearScreen()
	{
		this.form.ansHeadInjury().setValue(null);
		this.form.ansAutonomicDysreflexia().setValue(null);
		this.form.ansOwnSafety().setValue(null);
		this.form.chkSectionComplete().setValue(false);
		this.form.txtNotes().setValue("");
		this.form.chkCopy().setValue(false);
	}
	protected void populateScreenFromData(ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.ansHeadInjury().setValue(value.getHaveAHeadInjuryIsNotNull() ? value.getHaveAHeadInjury() : null);
		this.form.ansAutonomicDysreflexia().setValue(value.getRiskOfAutonomicDysreflexiaIsNotNull() ? value.getRiskOfAutonomicDysreflexia() : null);
		this.form.ansOwnSafety().setValue(value.getMaintainOwnSafetyIsNotNull() ? value.getMaintainOwnSafety() : null);
		if(value.getIsCompleteIsNotNull())
			this.form.chkSectionComplete().setValue(value.getIsComplete().booleanValue());
		this.form.txtNotes().setValue(value.getNotesIsNotNull() ? value.getNotes(): null);
		if(value.getCopyIsNotNull())
			this.form.chkCopy().setValue(value.getCopy().booleanValue());
	}
	protected ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo populateDataFromScreen(ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo value)
	{
		if(value == null)
			value = new ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo();

		value.setHaveAHeadInjury(this.form.ansHeadInjury().getValue());
		value.setRiskOfAutonomicDysreflexia(this.form.ansAutonomicDysreflexia().getValue());
		value.setMaintainOwnSafety(this.form.ansOwnSafety().getValue());
		value.setIsComplete(new Boolean(this.form.chkSectionComplete().getValue()));
		value.setNotes(this.form.txtNotes().getValue());
		value.setCopy(new Boolean(this.form.chkCopy().getValue()));

		return value;
	}
	protected ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.NurAssessmentSafeEnvironement domain;
}
