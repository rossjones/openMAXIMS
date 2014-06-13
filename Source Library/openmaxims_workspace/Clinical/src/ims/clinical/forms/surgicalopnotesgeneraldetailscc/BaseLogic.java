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

package ims.clinical.forms.surgicalopnotesgeneraldetailscc;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.SurgicalOPNotesGeneralDetailsCC.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.clinical.domain.SurgicalOPNotesGeneralDetailsCC domain)
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
	protected final void oncmbAnaestheticGivenValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAnaestheticGiven().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.AnaestheticType existingInstance = (ims.clinical.vo.lookups.AnaestheticType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAnaestheticGivenLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.AnaestheticType)
		{
			ims.clinical.vo.lookups.AnaestheticType instance = (ims.clinical.vo.lookups.AnaestheticType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAnaestheticGivenLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.AnaestheticType existingInstance = (ims.clinical.vo.lookups.AnaestheticType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAnaestheticGiven().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAnaestheticGivenLookup()
	{
		this.form.cmbAnaestheticGiven().clear();
		ims.clinical.vo.lookups.AnaestheticTypeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getAnaestheticType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAnaestheticGiven().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAnaestheticGivenLookupValue(int id)
	{
		ims.clinical.vo.lookups.AnaestheticType instance = ims.clinical.vo.lookups.LookupHelper.getAnaestheticTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAnaestheticGiven().setValue(instance);
	}
	protected final void defaultcmbAnaestheticGivenLookupValue()
	{
		this.form.cmbAnaestheticGiven().setValue((ims.clinical.vo.lookups.AnaestheticType)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.AnaestheticType.class, engine.getFormName().getID(), ims.clinical.vo.lookups.AnaestheticType.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.SurgicalOPNotesGeneralDetailsCC domain;
}
