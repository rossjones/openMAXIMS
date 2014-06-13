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

package ims.core.forms.datasettypeaddedit;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbUnitOfMeasureLookup();
	abstract protected void defaultcmbUnitOfMeasureLookupValue();
	abstract protected void bindcmbLineTypeLookup();
	abstract protected void defaultcmbLineTypeLookupValue();
	abstract protected void bindcmbColourIconLookup();
	abstract protected void defaultcmbColourIconLookupValue();
	abstract protected void bindcmbCategoryLookup();
	abstract protected void defaultcmbCategoryLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbUnitOfMeasureValueSet(Object value);
	abstract protected void onChkGenderValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbLineTypeValueSet(Object value);
	abstract protected void oncmbColourIconValueSet(Object value);
	abstract protected void oncmbCategoryValueSet(Object value);

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.cmbUnitOfMeasure().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbUnitOfMeasureValueSet(value);
			}
		});
		this.form.chkGender().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkGenderValueChanged();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.cmbLineType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLineTypeValueSet(value);
			}
		});
		this.form.cmbColourIcon().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbColourIconValueSet(value);
			}
		});
		this.form.cmbCategory().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCategoryValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbUnitOfMeasureLookup();
		bindcmbLineTypeLookup();
		bindcmbColourIconLookup();
		bindcmbCategoryLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbUnitOfMeasureLookup();
		bindcmbLineTypeLookup();
		bindcmbColourIconLookup();
		bindcmbCategoryLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbUnitOfMeasureLookupValue();
		defaultcmbLineTypeLookupValue();
		defaultcmbColourIconLookupValue();
		defaultcmbCategoryLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
