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

package ims.core.forms.vitalsignsbaselineandall;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTimePeriodLookup();
	abstract protected void defaultcmbTimePeriodLookupValue();
	abstract protected void bindcmbPainScoreLookup();
	abstract protected void defaultcmbPainScoreLookupValue();
	abstract protected void bindcmbPatientConcernLookup();
	abstract protected void defaultcmbPatientConcernLookupValue();
	abstract protected void bindcmbUrineLookup();
	abstract protected void defaultcmbUrineLookupValue();
	abstract protected void bindcmbConsciousLookup();
	abstract protected void defaultcmbConsciousLookupValue();
	abstract protected void bindcmbVisualRightLookup();
	abstract protected void defaultcmbVisualRightLookupValue();
	abstract protected void bindcmbRightReactionPupilLookup();
	abstract protected void defaultcmbRightReactionPupilLookupValue();
	abstract protected void bindcmbVisualLeftLookup();
	abstract protected void defaultcmbVisualLeftLookupValue();
	abstract protected void bindcmbLeftReactionPupilLookup();
	abstract protected void defaultcmbLeftReactionPupilLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrHistoryValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonBloodGlucoseGroup1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTimePeriodValueSet(Object value);
	abstract protected void onLnkCBGMClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkBMIClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPainScoreValueSet(Object value);
	abstract protected void onLnkPainLadderClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBMIClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkTemperatureClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkMetricsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkPeakFlowClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkonFiO2ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkOxygenSaturationClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkRespirationsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupBPValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkBloodPresureClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkPulseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPatientConcernValueSet(Object value);
	abstract protected void oncmbUrineValueSet(Object value);
	abstract protected void oncmbConsciousValueSet(Object value);
	abstract protected void oncmbVisualRightValueSet(Object value);
	abstract protected void onLnkGCSClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkPupilsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkVisualAcuityClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbRightReactionPupilValueSet(Object value);
	abstract protected void onCmbVResponseValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbMResponseValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbEyeOpeningValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbVisualLeftValueSet(Object value);
	abstract protected void oncmbLeftReactionPupilValueSet(Object value);

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.recbrHistory().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrHistoryValueChanged();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
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
		this.form.lyrVital().tabPageBaseline().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrVitaltabPageBaselineActivated();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrVitaltabPageOtherVitalSignsActivated();
			}
		});
		this.form.lyrVital().tabPageBaseline().BloodGlucoseGroup1().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonBloodGlucoseGroup1ValueChanged();
			}
		});
		this.form.lyrVital().tabPageBaseline().cmbTimePeriod().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTimePeriodValueSet(value);
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkCBGM().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkCBGMClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkBMI().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkBMIClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().cmbPainScore().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPainScoreValueSet(value);
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkPainLadder().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkPainLadderClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().btnBMI().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBMIClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkTemperature().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkTemperatureClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkMetrics().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkMetricsClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkPeakFlow().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkPeakFlowClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().chkonFiO2().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkonFiO2ValueChanged();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkOxygenSaturation().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkOxygenSaturationClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkRespirations().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkRespirationsClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().GroupBP().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupBPValueChanged();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkBloodPresure().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkBloodPresureClick();
			}
		});
		this.form.lyrVital().tabPageBaseline().lnkPulse().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkPulseClick();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbPatientConcern().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPatientConcernValueSet(value);
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbUrine().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbUrineValueSet(value);
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbConscious().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbConsciousValueSet(value);
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbVisualRight().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbVisualRightValueSet(value);
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().lnkGCS().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkGCSClick();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().lnkPupils().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkPupilsClick();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().lnkVisualAcuity().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkVisualAcuityClick();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbRightReactionPupil().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbRightReactionPupilValueSet(value);
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbVResponse().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbVResponseValueChanged();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbMResponse().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbMResponseValueChanged();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbEyeOpening().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbEyeOpeningValueChanged();
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbVisualLeft().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbVisualLeftValueSet(value);
			}
		});
		this.form.lyrVital().tabPageOtherVitalSigns().cmbLeftReactionPupil().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLeftReactionPupilValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTimePeriodLookup();
		bindcmbPainScoreLookup();
		bindcmbVisualRightLookup();
		bindcmbRightReactionPupilLookup();
		bindcmbVisualLeftLookup();
		bindcmbLeftReactionPupilLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTimePeriodLookup();
		bindcmbPainScoreLookup();
		bindcmbPatientConcernLookup();
		bindcmbUrineLookup();
		bindcmbConsciousLookup();
		bindcmbVisualRightLookup();
		bindcmbRightReactionPupilLookup();
		bindcmbVisualLeftLookup();
		bindcmbLeftReactionPupilLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTimePeriodLookupValue();
		defaultcmbPainScoreLookupValue();
		defaultcmbPatientConcernLookupValue();
		defaultcmbUrineLookupValue();
		defaultcmbConsciousLookupValue();
		defaultcmbVisualRightLookupValue();
		defaultcmbRightReactionPupilLookupValue();
		defaultcmbVisualLeftLookupValue();
		defaultcmbLeftReactionPupilLookupValue();
	}
	private void onlyrVitaltabPageBaselineActivated()
	{
		this.form.lyrVital().showtabPageBaseline();
	}
	private void onlyrVitaltabPageOtherVitalSignsActivated()
	{
		this.form.lyrVital().showtabPageOtherVitalSigns();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
