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

package ims.spinalinjuries.forms.opdmedicalnotes;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.OPDMedicalNotes.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.OPDMedicalNotes domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbNxtOpdUnitValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbNxtOpdUnit().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TimeWeeksMonthsYears existingInstance = (ims.core.vo.lookups.TimeWeeksMonthsYears)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbNxtOpdUnitLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.TimeWeeksMonthsYears)
		{
			ims.core.vo.lookups.TimeWeeksMonthsYears instance = (ims.core.vo.lookups.TimeWeeksMonthsYears)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbNxtOpdUnitLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TimeWeeksMonthsYears existingInstance = (ims.core.vo.lookups.TimeWeeksMonthsYears)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbNxtOpdUnit().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbNxtOpdUnitLookup()
	{
		this.form.cmbNxtOpdUnit().clear();
		ims.core.vo.lookups.TimeWeeksMonthsYearsCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTimeWeeksMonthsYears(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbNxtOpdUnit().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbNxtOpdUnitLookupValue(int id)
	{
		ims.core.vo.lookups.TimeWeeksMonthsYears instance = ims.core.vo.lookups.LookupHelper.getTimeWeeksMonthsYearsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbNxtOpdUnit().setValue(instance);
	}
	protected final void defaultcmbNxtOpdUnitLookupValue()
	{
		this.form.cmbNxtOpdUnit().setValue((ims.core.vo.lookups.TimeWeeksMonthsYears)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.TimeWeeksMonthsYears.class, engine.getFormName().getID(), ims.core.vo.lookups.TimeWeeksMonthsYears.TYPE_ID));
	}
	protected final void oncmbAutoDysreflexiaValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAutoDysreflexia().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AutonomicDysreflexia existingInstance = (ims.core.vo.lookups.AutonomicDysreflexia)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAutoDysreflexiaLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.AutonomicDysreflexia)
		{
			ims.core.vo.lookups.AutonomicDysreflexia instance = (ims.core.vo.lookups.AutonomicDysreflexia)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAutoDysreflexiaLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AutonomicDysreflexia existingInstance = (ims.core.vo.lookups.AutonomicDysreflexia)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAutoDysreflexia().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAutoDysreflexiaLookup()
	{
		this.form.cmbAutoDysreflexia().clear();
		ims.core.vo.lookups.AutonomicDysreflexiaCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAutonomicDysreflexia(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAutoDysreflexia().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAutoDysreflexiaLookupValue(int id)
	{
		ims.core.vo.lookups.AutonomicDysreflexia instance = ims.core.vo.lookups.LookupHelper.getAutonomicDysreflexiaInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAutoDysreflexia().setValue(instance);
	}
	protected final void defaultcmbAutoDysreflexiaLookupValue()
	{
		this.form.cmbAutoDysreflexia().setValue((ims.core.vo.lookups.AutonomicDysreflexia)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.AutonomicDysreflexia.class, engine.getFormName().getID(), ims.core.vo.lookups.AutonomicDysreflexia.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.OPDMedicalNotes domain;
}
