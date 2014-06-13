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

package ims.clinical.forms.outpatientstreatmentplan;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.OutPatientsTreatmentPlan.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.OutPatientsTreatmentPlan domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbFollowUpValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbFollowUp().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.OpdFollowUp existingInstance = (ims.clinical.vo.lookups.OpdFollowUp)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFollowUpLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.OpdFollowUp)
		{
			ims.clinical.vo.lookups.OpdFollowUp instance = (ims.clinical.vo.lookups.OpdFollowUp)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbFollowUpLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.OpdFollowUp existingInstance = (ims.clinical.vo.lookups.OpdFollowUp)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbFollowUp().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFollowUpLookup()
	{
		this.form.cmbFollowUp().clear();
		ims.clinical.vo.lookups.OpdFollowUpCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getOpdFollowUp(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbFollowUp().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFollowUpLookupValue(int id)
	{
		ims.clinical.vo.lookups.OpdFollowUp instance = ims.clinical.vo.lookups.LookupHelper.getOpdFollowUpInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbFollowUp().setValue(instance);
	}
	protected final void defaultcmbFollowUpLookupValue()
	{
		this.form.cmbFollowUp().setValue((ims.clinical.vo.lookups.OpdFollowUp)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.OpdFollowUp.class, engine.getFormName().getID(), ims.clinical.vo.lookups.OpdFollowUp.TYPE_ID));
	}
	protected final void oncmbReviewValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReview().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReviewInDuration existingInstance = (ims.clinical.vo.lookups.ReviewInDuration)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReviewLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.ReviewInDuration)
		{
			ims.clinical.vo.lookups.ReviewInDuration instance = (ims.clinical.vo.lookups.ReviewInDuration)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReviewLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReviewInDuration existingInstance = (ims.clinical.vo.lookups.ReviewInDuration)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReview().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReviewLookup()
	{
		this.form.cmbReview().clear();
		ims.clinical.vo.lookups.ReviewInDurationCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getReviewInDuration(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReview().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReviewLookupValue(int id)
	{
		ims.clinical.vo.lookups.ReviewInDuration instance = ims.clinical.vo.lookups.LookupHelper.getReviewInDurationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReview().setValue(instance);
	}
	protected final void defaultcmbReviewLookupValue()
	{
		this.form.cmbReview().setValue((ims.clinical.vo.lookups.ReviewInDuration)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.ReviewInDuration.class, engine.getFormName().getID(), ims.clinical.vo.lookups.ReviewInDuration.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.OutPatientsTreatmentPlan domain;
}
