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

package ims.core.forms.recentdischarges;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.RecentDischarges.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.core.domain.RecentDischarges domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected final void oncmbIDTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbIDType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbIDTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatIdType)
		{
			ims.core.vo.lookups.PatIdType instance = (ims.core.vo.lookups.PatIdType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbIDTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbIDType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbIDTypeLookup()
	{
		this.form.cmbIDType().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbIDType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbIDTypeLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbIDType().setValue(instance);
	}
	protected final void defaultcmbIDTypeLookupValue()
	{
		this.form.cmbIDType().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void oncmbDischargeDestinationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDischargeDestination().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DischargeDestination existingInstance = (ims.coe.vo.lookups.DischargeDestination)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDischargeDestinationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DischargeDestination)
		{
			ims.coe.vo.lookups.DischargeDestination instance = (ims.coe.vo.lookups.DischargeDestination)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDischargeDestinationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DischargeDestination existingInstance = (ims.coe.vo.lookups.DischargeDestination)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDischargeDestination().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDischargeDestinationLookup()
	{
		this.form.cmbDischargeDestination().clear();
		ims.coe.vo.lookups.DischargeDestinationCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDischargeDestination(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDischargeDestination().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDischargeDestinationLookupValue(int id)
	{
		ims.coe.vo.lookups.DischargeDestination instance = ims.coe.vo.lookups.LookupHelper.getDischargeDestinationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDischargeDestination().setValue(instance);
	}
	protected final void defaultcmbDischargeDestinationLookupValue()
	{
		this.form.cmbDischargeDestination().setValue((ims.coe.vo.lookups.DischargeDestination)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DischargeDestination.class, engine.getFormName().getID(), ims.coe.vo.lookups.DischargeDestination.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.RecentDischarges domain;
}
