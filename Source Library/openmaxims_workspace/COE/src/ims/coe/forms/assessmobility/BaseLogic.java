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

package ims.coe.forms.assessmobility;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.coe.domain.AssessMobility.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.coe.domain.AssessMobility domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onanswerBoxAssistanceWithMobilityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.answerBoxAssistanceWithMobility().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxAssistanceWithMobilityLookup();
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
					bindanswerBoxAssistanceWithMobilityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.answerBoxAssistanceWithMobility().addOption(instance);
		}
	}
	protected final void bindanswerBoxAssistanceWithMobilityLookup()
	{
		this.form.answerBoxAssistanceWithMobility().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.answerBoxAssistanceWithMobility().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxAssistanceWithMobilityLookupValue()
	{
		this.form.answerBoxAssistanceWithMobility().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncomboBoxChairValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBoxChair().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ChairType existingInstance = (ims.nursing.vo.lookups.ChairType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxChairLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.ChairType)
		{
			ims.nursing.vo.lookups.ChairType instance = (ims.nursing.vo.lookups.ChairType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxChairLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ChairType existingInstance = (ims.nursing.vo.lookups.ChairType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBoxChair().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxChairLookup()
	{
		this.form.comboBoxChair().clear();
		ims.nursing.vo.lookups.ChairTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getChairType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBoxChair().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxChairLookupValue(int id)
	{
		ims.nursing.vo.lookups.ChairType instance = ims.nursing.vo.lookups.LookupHelper.getChairTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBoxChair().setValue(instance);
	}
	protected final void defaultcomboBoxChairLookupValue()
	{
		this.form.comboBoxChair().setValue((ims.nursing.vo.lookups.ChairType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.ChairType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.ChairType.TYPE_ID));
	}
	protected final void oncomboBoxBedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBoxBed().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BedType existingInstance = (ims.nursing.vo.lookups.BedType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxBedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.BedType)
		{
			ims.nursing.vo.lookups.BedType instance = (ims.nursing.vo.lookups.BedType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxBedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BedType existingInstance = (ims.nursing.vo.lookups.BedType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBoxBed().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxBedLookup()
	{
		this.form.comboBoxBed().clear();
		ims.nursing.vo.lookups.BedTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getBedType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBoxBed().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxBedLookupValue(int id)
	{
		ims.nursing.vo.lookups.BedType instance = ims.nursing.vo.lookups.LookupHelper.getBedTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBoxBed().setValue(instance);
	}
	protected final void defaultcomboBoxBedLookupValue()
	{
		this.form.comboBoxBed().setValue((ims.nursing.vo.lookups.BedType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.BedType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.BedType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.coe.domain.AssessMobility domain;
}
