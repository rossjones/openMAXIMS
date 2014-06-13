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

package ims.therapies.forms.rangeofmovement;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.RangeOfMovement.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.RangeOfMovement domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbCentralActionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCentral().cmbCentralAction().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementAction existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCentralActionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RangeOfMovementAction)
		{
			ims.spinalinjuries.vo.lookups.RangeOfMovementAction instance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCentralActionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementAction existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCentral().cmbCentralAction().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCentralActionLookup()
	{
		this.form.lyrDetails().tabCentral().cmbCentralAction().clear();
		ims.spinalinjuries.vo.lookups.RangeOfMovementActionCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementAction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCentral().cmbCentralAction().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCentralActionLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RangeOfMovementAction instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementActionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCentral().cmbCentralAction().setValue(instance);
	}
	protected final void defaultcmbCentralActionLookupValue()
	{
		this.form.lyrDetails().tabCentral().cmbCentralAction().setValue((ims.spinalinjuries.vo.lookups.RangeOfMovementAction)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RangeOfMovementAction.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RangeOfMovementAction.TYPE_ID));
	}
	protected final void oncmbRangeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCentral().cmbRange().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRangeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange)
		{
			ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange instance = (ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRangeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCentral().cmbRange().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRangeLookup()
	{
		this.form.lyrDetails().tabCentral().cmbRange().clear();
		ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRangeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementQualitativeRange(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCentral().cmbRange().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRangeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementQualitativeRangeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCentral().cmbRange().setValue(instance);
	}
	protected final void defaultcmbRangeLookupValue()
	{
		this.form.lyrDetails().tabCentral().cmbRange().setValue((ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RangeOfMovementQualitativeRange.TYPE_ID));
	}
	protected final void oncmbCentralMovementValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCentral().cmbCentralMovement().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.MskJointsMovements existingInstance = (ims.spinalinjuries.vo.lookups.MskJointsMovements)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCentralMovementLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.MskJointsMovements)
		{
			ims.spinalinjuries.vo.lookups.MskJointsMovements instance = (ims.spinalinjuries.vo.lookups.MskJointsMovements)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCentralMovementLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.MskJointsMovements existingInstance = (ims.spinalinjuries.vo.lookups.MskJointsMovements)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCentral().cmbCentralMovement().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCentralMovementLookup()
	{
		this.form.lyrDetails().tabCentral().cmbCentralMovement().clear();
		ims.spinalinjuries.vo.lookups.MskJointsMovementsCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getMskJointsMovements(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCentral().cmbCentralMovement().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCentralMovementLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.MskJointsMovements instance = ims.spinalinjuries.vo.lookups.LookupHelper.getMskJointsMovementsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCentral().cmbCentralMovement().setValue(instance);
	}
	protected final void defaultcmbCentralMovementLookupValue()
	{
		this.form.lyrDetails().tabCentral().cmbCentralMovement().setValue((ims.spinalinjuries.vo.lookups.MskJointsMovements)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.MskJointsMovements.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.MskJointsMovements.TYPE_ID));
	}
	protected final void oncmbCentralLimitedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCentral().cmbCentralLimited().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementLimited existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCentralLimitedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)
		{
			ims.spinalinjuries.vo.lookups.RangeOfMovementLimited instance = (ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCentralLimitedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementLimited existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCentral().cmbCentralLimited().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCentralLimitedLookup()
	{
		this.form.lyrDetails().tabCentral().cmbCentralLimited().clear();
		ims.spinalinjuries.vo.lookups.RangeOfMovementLimitedCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementLimited(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCentral().cmbCentralLimited().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCentralLimitedLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RangeOfMovementLimited instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementLimitedInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCentral().cmbCentralLimited().setValue(instance);
	}
	protected final void defaultcmbCentralLimitedLookupValue()
	{
		this.form.lyrDetails().tabCentral().cmbCentralLimited().setValue((ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RangeOfMovementLimited.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RangeOfMovementLimited.TYPE_ID));
	}
	protected final void oncmbPeripheralActionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPeripheral().cmbPeripheralAction().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementAction existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPeripheralActionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RangeOfMovementAction)
		{
			ims.spinalinjuries.vo.lookups.RangeOfMovementAction instance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPeripheralActionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementAction existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPeripheral().cmbPeripheralAction().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPeripheralActionLookup()
	{
		this.form.lyrDetails().tabPeripheral().cmbPeripheralAction().clear();
		ims.spinalinjuries.vo.lookups.RangeOfMovementActionCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementAction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPeripheral().cmbPeripheralAction().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPeripheralActionLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RangeOfMovementAction instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementActionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPeripheral().cmbPeripheralAction().setValue(instance);
	}
	protected final void defaultcmbPeripheralActionLookupValue()
	{
		this.form.lyrDetails().tabPeripheral().cmbPeripheralAction().setValue((ims.spinalinjuries.vo.lookups.RangeOfMovementAction)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RangeOfMovementAction.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RangeOfMovementAction.TYPE_ID));
	}
	protected final void oncmbPeripheralMovementValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPeripheral().cmbPeripheralMovement().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.MskJointsMovements existingInstance = (ims.spinalinjuries.vo.lookups.MskJointsMovements)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPeripheralMovementLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.MskJointsMovements)
		{
			ims.spinalinjuries.vo.lookups.MskJointsMovements instance = (ims.spinalinjuries.vo.lookups.MskJointsMovements)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPeripheralMovementLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.MskJointsMovements existingInstance = (ims.spinalinjuries.vo.lookups.MskJointsMovements)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPeripheral().cmbPeripheralMovement().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPeripheralMovementLookup()
	{
		this.form.lyrDetails().tabPeripheral().cmbPeripheralMovement().clear();
		ims.spinalinjuries.vo.lookups.MskJointsMovementsCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getMskJointsMovements(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPeripheral().cmbPeripheralMovement().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPeripheralMovementLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.MskJointsMovements instance = ims.spinalinjuries.vo.lookups.LookupHelper.getMskJointsMovementsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPeripheral().cmbPeripheralMovement().setValue(instance);
	}
	protected final void defaultcmbPeripheralMovementLookupValue()
	{
		this.form.lyrDetails().tabPeripheral().cmbPeripheralMovement().setValue((ims.spinalinjuries.vo.lookups.MskJointsMovements)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.MskJointsMovements.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.MskJointsMovements.TYPE_ID));
	}
	protected final void oncmbPeripheralLimitedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPeripheral().cmbPeripheralLimited().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementLimited existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPeripheralLimitedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)
		{
			ims.spinalinjuries.vo.lookups.RangeOfMovementLimited instance = (ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPeripheralLimitedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementLimited existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPeripheral().cmbPeripheralLimited().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPeripheralLimitedLookup()
	{
		this.form.lyrDetails().tabPeripheral().cmbPeripheralLimited().clear();
		ims.spinalinjuries.vo.lookups.RangeOfMovementLimitedCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementLimited(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPeripheral().cmbPeripheralLimited().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPeripheralLimitedLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RangeOfMovementLimited instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementLimitedInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPeripheral().cmbPeripheralLimited().setValue(instance);
	}
	protected final void defaultcmbPeripheralLimitedLookupValue()
	{
		this.form.lyrDetails().tabPeripheral().cmbPeripheralLimited().setValue((ims.spinalinjuries.vo.lookups.RangeOfMovementLimited)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RangeOfMovementLimited.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RangeOfMovementLimited.TYPE_ID));
	}
	protected final void oncmbLateralityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPeripheral().cmbLaterality().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRonly existingInstance = (ims.core.vo.lookups.LateralityLRonly)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLateralityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LateralityLRonly)
		{
			ims.core.vo.lookups.LateralityLRonly instance = (ims.core.vo.lookups.LateralityLRonly)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLateralityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRonly existingInstance = (ims.core.vo.lookups.LateralityLRonly)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPeripheral().cmbLaterality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLateralityLookup()
	{
		this.form.lyrDetails().tabPeripheral().cmbLaterality().clear();
		ims.core.vo.lookups.LateralityLRonlyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLateralityLRonly(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPeripheral().cmbLaterality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLateralityLookupValue(int id)
	{
		ims.core.vo.lookups.LateralityLRonly instance = ims.core.vo.lookups.LookupHelper.getLateralityLRonlyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPeripheral().cmbLaterality().setValue(instance);
	}
	protected final void defaultcmbLateralityLookupValue()
	{
		this.form.lyrDetails().tabPeripheral().cmbLaterality().setValue((ims.core.vo.lookups.LateralityLRonly)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LateralityLRonly.class, engine.getFormName().getID(), ims.core.vo.lookups.LateralityLRonly.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.RangeOfMovement domain;
}
