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

package ims.therapies.forms.wheelchairassessment;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.WheelchairAssessment.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.WheelchairAssessment domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdSurfaceColSurfaceLookup()
	{
		this.form.grdSurface().ColSurfaceComboBox().clear();
		ims.spinalinjuries.vo.lookups.WheelchairSurfaceCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getWheelchairSurface(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdSurface().ColSurfaceComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbChairTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbChairType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.WheelchairType existingInstance = (ims.spinalinjuries.vo.lookups.WheelchairType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbChairTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.WheelchairType)
		{
			ims.spinalinjuries.vo.lookups.WheelchairType instance = (ims.spinalinjuries.vo.lookups.WheelchairType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbChairTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.WheelchairType existingInstance = (ims.spinalinjuries.vo.lookups.WheelchairType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbChairType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbChairTypeLookup()
	{
		this.form.cmbChairType().clear();
		ims.spinalinjuries.vo.lookups.WheelchairTypeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getWheelchairType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbChairType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbChairTypeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.WheelchairType instance = ims.spinalinjuries.vo.lookups.LookupHelper.getWheelchairTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbChairType().setValue(instance);
	}
	protected final void defaultcmbChairTypeLookupValue()
	{
		this.form.cmbChairType().setValue((ims.spinalinjuries.vo.lookups.WheelchairType)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.WheelchairType.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.WheelchairType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.WheelchairAssessment domain;
}
