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

package ims.ocrr.forms.specimencontainerlist;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ocrr.domain.SpecimenContainerList.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.ocrr.domain.SpecimenContainerList domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbManufacturerValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbManufacturer().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.SpecimenManufacturer existingInstance = (ims.ocrr.vo.lookups.SpecimenManufacturer)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbManufacturerLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.SpecimenManufacturer)
		{
			ims.ocrr.vo.lookups.SpecimenManufacturer instance = (ims.ocrr.vo.lookups.SpecimenManufacturer)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbManufacturerLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.SpecimenManufacturer existingInstance = (ims.ocrr.vo.lookups.SpecimenManufacturer)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbManufacturer().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbManufacturerLookup()
	{
		this.form.cmbManufacturer().clear();
		ims.ocrr.vo.lookups.SpecimenManufacturerCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getSpecimenManufacturer(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbManufacturer().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbManufacturerLookupValue(int id)
	{
		ims.ocrr.vo.lookups.SpecimenManufacturer instance = ims.ocrr.vo.lookups.LookupHelper.getSpecimenManufacturerInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbManufacturer().setValue(instance);
	}
	protected final void defaultcmbManufacturerLookupValue()
	{
		this.form.cmbManufacturer().setValue((ims.ocrr.vo.lookups.SpecimenManufacturer)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.SpecimenManufacturer.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.SpecimenManufacturer.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ocrr.domain.SpecimenContainerList domain;
}
