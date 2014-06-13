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

package ims.therapies.forms.handrangeofmovement;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbDominantHandLookup();
	abstract protected void defaultcmbDominantHandLookupValue();
	abstract protected void bindcmbActionLookup();
	abstract protected void defaultcmbActionLookupValue();
	abstract protected void bindcmbLateralityLookup();
	abstract protected void defaultcmbLateralityLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDominantHandValueSet(Object value);
	abstract protected void onCmbDigitValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbActionValueSet(Object value);
	abstract protected void onCmbJointValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbLateralityValueSet(Object value);
	abstract protected void onBtnCancelDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdMovementSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

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
				onFormOpen();
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
		this.form.recbrHandRangeOfMovements().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrValueChanged();
			}
		});
		this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDominantHandValueSet(value);
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetails().cmbDigit().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbDigitValueChanged();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbActionValueSet(value);
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetails().cmbJoint().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbJointValueChanged();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLateralityValueSet(value);
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetails().btnCancelDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelDetailsClick();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetails().btnOK().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOKClick();
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
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
		this.form.grdMovement().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMovementSelectionChanged();
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementNEW_PARENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.NEW_PARENT, sender);
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementUPDATE_PARENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.UPDATE_PARENT, sender);
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementNEW_DETAILItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.NEW_DETAIL, sender);
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementUPDATE_DETAILItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.UPDATE_DETAIL, sender);
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementREMOVE_DETAILItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.REMOVE_DETAIL, sender);
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementNEW_JOINTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.NEW_JOINT, sender);
			}
		});
		this.form.getContextMenus().getHandRangeOfMovementNEW_MOVEMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HandRangeOfMovement.NEW_MOVEMENT, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbDominantHandLookup();
		bindcmbActionLookup();
		bindcmbLateralityLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbDominantHandLookup();
		bindcmbActionLookup();
		bindcmbLateralityLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbDominantHandLookupValue();
		defaultcmbActionLookupValue();
		defaultcmbLateralityLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
