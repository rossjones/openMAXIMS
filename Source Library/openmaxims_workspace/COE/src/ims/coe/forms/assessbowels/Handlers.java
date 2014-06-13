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

package ims.coe.forms.assessbowels;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcomboBoxBowelsOpenLookup();
	abstract protected void defaultcomboBoxBowelsOpenLookupValue();
	abstract protected void bindanswerBoxLaxativesLookup();
	abstract protected void defaultanswerBoxLaxativesLookupValue();
	abstract protected void bindanswerBoxNoticedStainingLookup();
	abstract protected void defaultanswerBoxNoticedStainingLookupValue();
	abstract protected void bindanswerBoxLeakagePastLookup();
	abstract protected void defaultanswerBoxLeakagePastLookupValue();
	abstract protected void bindanswerBoxLeakagePresentLookup();
	abstract protected void defaultanswerBoxLeakagePresentLookupValue();
	abstract protected void bindanswerBoxProneToConsLookup();
	abstract protected void defaultanswerBoxProneToConsLookupValue();
	abstract protected void bindcomboBoxAmountLookup();
	abstract protected void defaultcomboBoxAmountLookupValue();
	abstract protected void bindcomboBoxColourLookup();
	abstract protected void defaultcomboBoxColourLookupValue();
	abstract protected void bindcomboBoxOdourLookup();
	abstract protected void defaultcomboBoxOdourLookupValue();
	abstract protected void bindcomboBoxConsistencyLookup();
	abstract protected void defaultcomboBoxConsistencyLookupValue();
	abstract protected void bindcomboBoxFreqLookup();
	abstract protected void defaultcomboBoxFreqLookupValue();
	abstract protected void bindanswerBoxProneDiarrLookup();
	abstract protected void defaultanswerBoxProneDiarrLookupValue();
	abstract protected void bindgridMedicationColRouteLookup();
	abstract protected void bindgridMedicationColFrequencyLookup();
	abstract protected void bindcomboBoxOstomyLookup();
	abstract protected void defaultcomboBoxOstomyLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onInfoLinkClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomboBoxBowelsOpenValueSet(Object value);
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxLaxativesValueSet(Object value);
	abstract protected void onAnswerBoxLaxativesValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxNoticedStainingValueSet(Object value);
	abstract protected void onanswerBoxLeakagePastValueSet(Object value);
	abstract protected void onAnswerBoxLeakagePastValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxLeakagePresentValueSet(Object value);
	abstract protected void onanswerBoxProneToConsValueSet(Object value);
	abstract protected void onAnswerBoxProneToConsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomboBoxAmountValueSet(Object value);
	abstract protected void oncomboBoxColourValueSet(Object value);
	abstract protected void oncomboBoxOdourValueSet(Object value);
	abstract protected void oncomboBoxConsistencyValueSet(Object value);
	abstract protected void oncomboBoxFreqValueSet(Object value);
	abstract protected void onanswerBoxProneDiarrValueSet(Object value);
	abstract protected void onAnswerBoxProneDiarrValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBUpdateMedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBMedicationClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onMedSelChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomboBoxOstomyValueSet(Object value);
	abstract protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;

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
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onDialogClosed(formName, result);
			}
		});
		this.form.linkInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onInfoLinkClick();
			}
		});
		this.form.container1().comboBoxBowelsOpen().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxBowelsOpenValueSet(value);
			}
		});
		this.form.container1().bCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
		this.form.container1().bSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.container1().answerBoxLaxatives().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxLaxativesValueSet(value);
			}
		});
		this.form.container1().answerBoxLaxatives().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxLaxativesValueChanged();
			}
		});
		this.form.container1().answerBoxNoticedStaining().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxNoticedStainingValueSet(value);
			}
		});
		this.form.container1().answerBoxLeakagePast().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxLeakagePastValueSet(value);
			}
		});
		this.form.container1().answerBoxLeakagePast().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxLeakagePastValueChanged();
			}
		});
		this.form.container1().answerBoxLeakagePresent().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxLeakagePresentValueSet(value);
			}
		});
		this.form.container1().answerBoxProneToCons().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxProneToConsValueSet(value);
			}
		});
		this.form.container1().answerBoxProneToCons().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxProneToConsValueChanged();
			}
		});
		this.form.container1().comboBoxAmount().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxAmountValueSet(value);
			}
		});
		this.form.container1().comboBoxColour().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxColourValueSet(value);
			}
		});
		this.form.container1().comboBoxOdour().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxOdourValueSet(value);
			}
		});
		this.form.container1().comboBoxConsistency().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxConsistencyValueSet(value);
			}
		});
		this.form.container1().comboBoxFreq().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxFreqValueSet(value);
			}
		});
		this.form.container1().answerBoxProneDiarr().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxProneDiarrValueSet(value);
			}
		});
		this.form.container1().answerBoxProneDiarr().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxProneDiarrValueChanged();
			}
		});
		this.form.container1().bUpdateMed().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBUpdateMedClick();
			}
		});
		this.form.container1().bMedication().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBMedicationClick();
			}
		});
		this.form.container1().gridMedication().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onMedSelChanged();
			}
		});
		this.form.container1().comboBoxOstomy().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxOstomyValueSet(value);
			}
		});
		this.form.checkBoxCopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCopyPrevAssessmentValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindcomboBoxBowelsOpenLookup();
		bindanswerBoxLaxativesLookup();
		bindanswerBoxNoticedStainingLookup();
		bindanswerBoxLeakagePastLookup();
		bindanswerBoxLeakagePresentLookup();
		bindanswerBoxProneToConsLookup();
		bindcomboBoxAmountLookup();
		bindcomboBoxColourLookup();
		bindcomboBoxOdourLookup();
		bindcomboBoxConsistencyLookup();
		bindcomboBoxFreqLookup();
		bindanswerBoxProneDiarrLookup();
		bindgridMedicationColRouteLookup();
		bindgridMedicationColFrequencyLookup();
		bindcomboBoxOstomyLookup();
	}
	protected void rebindAllLookups()
	{
		bindcomboBoxBowelsOpenLookup();
		bindanswerBoxLaxativesLookup();
		bindanswerBoxNoticedStainingLookup();
		bindanswerBoxLeakagePastLookup();
		bindanswerBoxLeakagePresentLookup();
		bindanswerBoxProneToConsLookup();
		bindcomboBoxAmountLookup();
		bindcomboBoxColourLookup();
		bindcomboBoxOdourLookup();
		bindcomboBoxConsistencyLookup();
		bindcomboBoxFreqLookup();
		bindanswerBoxProneDiarrLookup();
		bindgridMedicationColRouteLookup();
		bindgridMedicationColFrequencyLookup();
		bindcomboBoxOstomyLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcomboBoxBowelsOpenLookupValue();
		defaultanswerBoxLaxativesLookupValue();
		defaultanswerBoxNoticedStainingLookupValue();
		defaultanswerBoxLeakagePastLookupValue();
		defaultanswerBoxLeakagePresentLookupValue();
		defaultanswerBoxProneToConsLookupValue();
		defaultcomboBoxAmountLookupValue();
		defaultcomboBoxColourLookupValue();
		defaultcomboBoxOdourLookupValue();
		defaultcomboBoxConsistencyLookupValue();
		defaultcomboBoxFreqLookupValue();
		defaultanswerBoxProneDiarrLookupValue();
		defaultcomboBoxOstomyLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
