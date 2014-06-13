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

package ims.therapies.forms.splints;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.Splints.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.Splints domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdInstructionsColInstructionDetailsLookup()
	{
		this.form.ctnDetails().grdInstructions().ColInstructionDetailsComboBox().clear();
		ims.spinalinjuries.vo.lookups.SplintInstructionLeafletCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintInstructionLeaflet(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().grdInstructions().ColInstructionDetailsComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbProductValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbProduct().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintProduct existingInstance = (ims.spinalinjuries.vo.lookups.SplintProduct)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbProductLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintProduct)
		{
			ims.spinalinjuries.vo.lookups.SplintProduct instance = (ims.spinalinjuries.vo.lookups.SplintProduct)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbProductLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintProduct existingInstance = (ims.spinalinjuries.vo.lookups.SplintProduct)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbProduct().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbProductLookup()
	{
		this.form.ctnDetails().cmbProduct().clear();
		ims.spinalinjuries.vo.lookups.SplintProductCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintProduct(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbProduct().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbProductLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintProduct instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintProductInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbProduct().setValue(instance);
	}
	protected final void defaultcmbProductLookupValue()
	{
		this.form.ctnDetails().cmbProduct().setValue((ims.spinalinjuries.vo.lookups.SplintProduct)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintProduct.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintProduct.TYPE_ID));
	}
	protected final void oncmbSizeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbSize().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintSize existingInstance = (ims.spinalinjuries.vo.lookups.SplintSize)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSizeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintSize)
		{
			ims.spinalinjuries.vo.lookups.SplintSize instance = (ims.spinalinjuries.vo.lookups.SplintSize)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSizeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintSize existingInstance = (ims.spinalinjuries.vo.lookups.SplintSize)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbSize().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSizeLookup()
	{
		this.form.ctnDetails().cmbSize().clear();
		ims.spinalinjuries.vo.lookups.SplintSizeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintSize(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbSize().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSizeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintSize instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintSizeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbSize().setValue(instance);
	}
	protected final void defaultcmbSizeLookupValue()
	{
		this.form.ctnDetails().cmbSize().setValue((ims.spinalinjuries.vo.lookups.SplintSize)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintSize.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintSize.TYPE_ID));
	}
	protected final void bindgrdFeaturesColAdditionalFeaturesLookup()
	{
		this.form.ctnDetails().grdFeatures().ColAdditionalFeaturesComboBox().clear();
		ims.spinalinjuries.vo.lookups.SplintAdditionalFeatureCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintAdditionalFeature(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().grdFeatures().ColAdditionalFeaturesComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdWearRegimeColWearRegimeTimeLookup()
	{
		this.form.ctnDetails().grdWearRegime().ColWearRegimeTimeComboBox().clear();
		ims.spinalinjuries.vo.lookups.SplintWearRegimeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintWearRegime(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().grdWearRegime().ColWearRegimeTimeComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbLateralityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbLaterality().getValues();

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

			this.form.ctnDetails().cmbLaterality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLateralityLookup()
	{
		this.form.ctnDetails().cmbLaterality().clear();
		ims.core.vo.lookups.LateralityLRonlyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLateralityLRonly(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbLaterality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLateralityLookupValue(int id)
	{
		ims.core.vo.lookups.LateralityLRonly instance = ims.core.vo.lookups.LookupHelper.getLateralityLRonlyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbLaterality().setValue(instance);
	}
	protected final void defaultcmbLateralityLookupValue()
	{
		this.form.ctnDetails().cmbLaterality().setValue((ims.core.vo.lookups.LateralityLRonly)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LateralityLRonly.class, engine.getFormName().getID(), ims.core.vo.lookups.LateralityLRonly.TYPE_ID));
	}
	protected final void oncmbBasedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbBased().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintBase existingInstance = (ims.spinalinjuries.vo.lookups.SplintBase)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBasedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintBase)
		{
			ims.spinalinjuries.vo.lookups.SplintBase instance = (ims.spinalinjuries.vo.lookups.SplintBase)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBasedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintBase existingInstance = (ims.spinalinjuries.vo.lookups.SplintBase)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbBased().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBasedLookup()
	{
		this.form.ctnDetails().cmbBased().clear();
		ims.spinalinjuries.vo.lookups.SplintBaseCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintBase(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbBased().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBasedLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintBase instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintBaseInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbBased().setValue(instance);
	}
	protected final void defaultcmbBasedLookupValue()
	{
		this.form.ctnDetails().cmbBased().setValue((ims.spinalinjuries.vo.lookups.SplintBase)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintBase.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintBase.TYPE_ID));
	}
	protected final void oncmbTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintType existingInstance = (ims.spinalinjuries.vo.lookups.SplintType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintType)
		{
			ims.spinalinjuries.vo.lookups.SplintType instance = (ims.spinalinjuries.vo.lookups.SplintType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintType existingInstance = (ims.spinalinjuries.vo.lookups.SplintType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTypeLookup()
	{
		this.form.ctnDetails().cmbType().clear();
		ims.spinalinjuries.vo.lookups.SplintTypeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTypeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintType instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbType().setValue(instance);
	}
	protected final void defaultcmbTypeLookupValue()
	{
		this.form.ctnDetails().cmbType().setValue((ims.spinalinjuries.vo.lookups.SplintType)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintType.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintType.TYPE_ID));
	}
	protected final void oncmbMaterialValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbMaterial().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintMaterial existingInstance = (ims.spinalinjuries.vo.lookups.SplintMaterial)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaterialLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintMaterial)
		{
			ims.spinalinjuries.vo.lookups.SplintMaterial instance = (ims.spinalinjuries.vo.lookups.SplintMaterial)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMaterialLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintMaterial existingInstance = (ims.spinalinjuries.vo.lookups.SplintMaterial)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbMaterial().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaterialLookup()
	{
		this.form.ctnDetails().cmbMaterial().clear();
		ims.spinalinjuries.vo.lookups.SplintMaterialCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintMaterial(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbMaterial().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaterialLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintMaterial instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintMaterialInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbMaterial().setValue(instance);
	}
	protected final void defaultcmbMaterialLookupValue()
	{
		this.form.ctnDetails().cmbMaterial().setValue((ims.spinalinjuries.vo.lookups.SplintMaterial)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintMaterial.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintMaterial.TYPE_ID));
	}
	protected final void oncmbCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintCategory existingInstance = (ims.spinalinjuries.vo.lookups.SplintCategory)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintCategory)
		{
			ims.spinalinjuries.vo.lookups.SplintCategory instance = (ims.spinalinjuries.vo.lookups.SplintCategory)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintCategory existingInstance = (ims.spinalinjuries.vo.lookups.SplintCategory)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCategoryLookup()
	{
		this.form.ctnDetails().cmbCategory().clear();
		ims.spinalinjuries.vo.lookups.SplintCategoryCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCategoryLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintCategory instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintCategoryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbCategory().setValue(instance);
	}
	protected final void defaultcmbCategoryLookupValue()
	{
		this.form.ctnDetails().cmbCategory().setValue((ims.spinalinjuries.vo.lookups.SplintCategory)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintCategory.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintCategory.TYPE_ID));
	}
	protected final void oncmbAreaValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbArea().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintArea existingInstance = (ims.spinalinjuries.vo.lookups.SplintArea)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAreaLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SplintArea)
		{
			ims.spinalinjuries.vo.lookups.SplintArea instance = (ims.spinalinjuries.vo.lookups.SplintArea)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAreaLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SplintArea existingInstance = (ims.spinalinjuries.vo.lookups.SplintArea)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbArea().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAreaLookup()
	{
		this.form.ctnDetails().cmbArea().clear();
		ims.spinalinjuries.vo.lookups.SplintAreaCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintArea(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbArea().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAreaLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SplintArea instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSplintAreaInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbArea().setValue(instance);
	}
	protected final void defaultcmbAreaLookupValue()
	{
		this.form.ctnDetails().cmbArea().setValue((ims.spinalinjuries.vo.lookups.SplintArea)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SplintArea.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SplintArea.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.Splints domain;
}
