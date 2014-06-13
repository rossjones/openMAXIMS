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

package ims.clinical.forms.dementiaworklist;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbSpecialtyLookup();
	abstract protected void defaultcmbSpecialtyLookupValue();
	abstract protected void bindcmbIDTypeLookup();
	abstract protected void defaultcmbIDTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdPatientsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdPatientsColumnHeaderClicked(ims.framework.controls.DynamicGridColumn column);
	abstract protected void onChkInpatientOnlyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkDelirumValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbRefreshClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbWardTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSpecialtyValueSet(Object value);
	abstract protected void onChkDementiaConfirmedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIDTypeValueSet(Object value);
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTimer(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException;

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
		this.form.dyngrdPatients().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPatientsRowSelectionChanged(row);
			}
		});
		this.form.dyngrdPatients().setDynamicGridColumnHeaderClickedEvent(new DynamicGridColumnHeaderClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridColumn column) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPatientsColumnHeaderClicked(column);
			}
		});
		this.form.chkInpatientOnly().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkInpatientOnlyValueChanged();
			}
		});
		this.form.chkDelirum().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkDelirumValueChanged();
			}
		});
		this.form.imbRefresh().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbRefreshClick();
			}
		});
		this.form.qmbWard().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbWardTextSubmited(value);
			}
		});
		this.form.cmbSpecialty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSpecialtyValueSet(value);
			}
		});
		this.form.chkDementiaConfirmed().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkDementiaConfirmedValueChanged();
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.cmbIDType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIDTypeValueSet(value);
			}
		});
		this.form.cmbHospital().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbHospitalValueChanged();
			}
		});
		this.form.setTimerElapsedEvent(new ims.framework.delegates.TimerElapsed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException
			{
				onTimer(timer);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.VIEW, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.EDIT, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuSTEP1Item().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.STEP1, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuSTEP2Item().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.STEP2, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuSTEP3Item().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.STEP3, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuRECORD_FOLLOWUP_AMTSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.RECORD_FOLLOWUP_AMTS, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuEXCLUDE_FROM_DEMENTIA_SCREENINGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.EXCLUDE_FROM_DEMENTIA_SCREENING, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuCONFIRM_PATIENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.CONFIRM_PATIENT, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuRIE_REMOVE_FROM_WORKLISTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.RIE_REMOVE_FROM_WORKLIST, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuCORRECT_CCOMPLETION_DATE_STEP1Item().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.CORRECT_CCOMPLETION_DATE_STEP1, sender);
			}
		});
		this.form.getContextMenus().Clinical.getDementiaWorklistMenuCORRECT_CCOMPLETION_DATE_STEP2Item().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.DementiaWorklistMenu.CORRECT_CCOMPLETION_DATE_STEP2, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbSpecialtyLookup();
		bindcmbIDTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbSpecialtyLookup();
		bindcmbIDTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbSpecialtyLookupValue();
		defaultcmbIDTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
