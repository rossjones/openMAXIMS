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

package ims.racpc.forms.racpcplanadvice;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.racpc.domain.RACPCPlanAdvice.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.racpc.domain.RACPCPlanAdvice domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbOverallImpressionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOverallImpression().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OverallImpression existingInstance = (ims.core.vo.lookups.OverallImpression)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOverallImpressionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.OverallImpression)
		{
			ims.core.vo.lookups.OverallImpression instance = (ims.core.vo.lookups.OverallImpression)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOverallImpressionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OverallImpression existingInstance = (ims.core.vo.lookups.OverallImpression)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOverallImpression().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOverallImpressionLookup()
	{
		this.form.cmbOverallImpression().clear();
		ims.core.vo.lookups.OverallImpressionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOverallImpression(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOverallImpression().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOverallImpressionLookupValue(int id)
	{
		ims.core.vo.lookups.OverallImpression instance = ims.core.vo.lookups.LookupHelper.getOverallImpressionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOverallImpression().setValue(instance);
	}
	protected final void defaultcmbOverallImpressionLookupValue()
	{
		this.form.cmbOverallImpression().setValue((ims.core.vo.lookups.OverallImpression)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.OverallImpression.class, engine.getFormName().getID(), ims.core.vo.lookups.OverallImpression.TYPE_ID));
	}
	protected final void bindgrdAdviceToPatientcolAdviceLookup()
	{
		this.form.grdAdviceToPatient().colAdviceComboBox().clear();
		ims.core.vo.lookups.AdviceToPatientCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAdviceToPatient(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdAdviceToPatient().colAdviceComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdAdviceToGPcolFindingLookup()
	{
		this.form.grdAdviceToGP().colFindingComboBox().clear();
		ims.core.vo.lookups.AdviceToGPCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAdviceToGP(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdAdviceToGP().colFindingComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.racpc.domain.RACPCPlanAdvice domain;
}
