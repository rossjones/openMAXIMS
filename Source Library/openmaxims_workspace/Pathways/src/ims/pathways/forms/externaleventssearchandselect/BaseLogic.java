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

package ims.pathways.forms.externaleventssearchandselect;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pathways.domain.ExternalEventsSearchAndSelect.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pathways.domain.ExternalEventsSearchAndSelect domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbSpecSearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecSearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecSearchLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecSearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecSearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecSearchLookup()
	{
		this.form.cmbSpecSearch().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecSearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecSearchLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecSearch().setValue(instance);
	}
	protected final void defaultcmbSpecSearchLookupValue()
	{
		this.form.cmbSpecSearch().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	protected final void oncmbDetailSearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDetailSearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.PathwaysDetail existingInstance = (ims.pathways.vo.lookups.PathwaysDetail)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDetailSearchLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.PathwaysDetail)
		{
			ims.pathways.vo.lookups.PathwaysDetail instance = (ims.pathways.vo.lookups.PathwaysDetail)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDetailSearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.PathwaysDetail existingInstance = (ims.pathways.vo.lookups.PathwaysDetail)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDetailSearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDetailSearchLookup()
	{
		this.form.cmbDetailSearch().clear();
		ims.pathways.vo.lookups.PathwaysDetailCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getPathwaysDetail(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDetailSearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDetailSearchLookupValue(int id)
	{
		ims.pathways.vo.lookups.PathwaysDetail instance = ims.pathways.vo.lookups.LookupHelper.getPathwaysDetailInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDetailSearch().setValue(instance);
	}
	protected final void defaultcmbDetailSearchLookupValue()
	{
		this.form.cmbDetailSearch().setValue((ims.pathways.vo.lookups.PathwaysDetail)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.PathwaysDetail.class, engine.getFormName().getID(), ims.pathways.vo.lookups.PathwaysDetail.TYPE_ID));
	}
	protected final void oncmbGroupSearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbGroupSearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.PathwaysGroup existingInstance = (ims.pathways.vo.lookups.PathwaysGroup)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbGroupSearchLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.PathwaysGroup)
		{
			ims.pathways.vo.lookups.PathwaysGroup instance = (ims.pathways.vo.lookups.PathwaysGroup)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbGroupSearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.PathwaysGroup existingInstance = (ims.pathways.vo.lookups.PathwaysGroup)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbGroupSearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbGroupSearchLookup()
	{
		this.form.cmbGroupSearch().clear();
		ims.pathways.vo.lookups.PathwaysGroupCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getPathwaysGroup(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbGroupSearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbGroupSearchLookupValue(int id)
	{
		ims.pathways.vo.lookups.PathwaysGroup instance = ims.pathways.vo.lookups.LookupHelper.getPathwaysGroupInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbGroupSearch().setValue(instance);
	}
	protected final void defaultcmbGroupSearchLookupValue()
	{
		this.form.cmbGroupSearch().setValue((ims.pathways.vo.lookups.PathwaysGroup)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.PathwaysGroup.class, engine.getFormName().getID(), ims.pathways.vo.lookups.PathwaysGroup.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.pathways.domain.ExternalEventsSearchAndSelect domain;
}
