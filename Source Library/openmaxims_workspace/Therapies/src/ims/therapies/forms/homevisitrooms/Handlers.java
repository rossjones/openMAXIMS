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

package ims.therapies.forms.homevisitrooms;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbUnitLookup();
	abstract protected void defaultcmbUnitLookupValue();
	abstract protected void bindcomboBoxTypeLookup();
	abstract protected void defaultcomboBoxTypeLookupValue();
	abstract protected void bindcomboBoxLocationLookup();
	abstract protected void defaultcomboBoxLocationLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbUnitValueSet(Object value);
	abstract protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelRoomClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomboBoxTypeValueSet(Object value);
	abstract protected void oncomboBoxLocationValueSet(Object value);
	abstract protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGridRoomsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
			}
		});
		this.form.ctnDetails().cmbUnit().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbUnitValueSet(value);
			}
		});
		this.form.ctnDetails().btnOK().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOKClick();
			}
		});
		this.form.ctnDetails().btnCancelRoom().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelRoomClick();
			}
		});
		this.form.ctnDetails().comboBoxType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxTypeValueSet(value);
			}
		});
		this.form.ctnDetails().comboBoxLocation().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxLocationValueSet(value);
			}
		});
		this.form.bNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBNewClick();
			}
		});
		this.form.bSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.bCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
		this.form.gridRooms().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGridRoomsSelectionChanged();
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentBOOK_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.BOOK_APPT, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentCANCEL_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.CANCEL_APPT, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentREBOOK_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.REBOOK_APPT, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentORDER_INVESTIGATIONItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.ORDER_INVESTIGATION, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentBOOK_THEATRE_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.BOOK_THEATRE_APPT, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentCANCEL_THEATRE_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.CANCEL_THEATRE_APPT, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentREBOOK_THEATRE_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.REBOOK_THEATRE_APPT, sender);
			}
		});
		this.form.getContextMenus().CAREUK.getReferralAppointmentDetailsComponentVIEW_APPT_HISTORYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CAREUKNamespace.ReferralAppointmentDetailsComponent.VIEW_APPT_HISTORY, sender);
			}
		});
		this.form.getContextMenus().getGenericGridAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Add, sender);
			}
		});
		this.form.getContextMenus().getGenericGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Update, sender);
			}
		});
		this.form.getContextMenus().getGenericGridRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Remove, sender);
			}
		});
		this.form.getContextMenus().getGenericGridViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.View, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveUp, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveDown, sender);
			}
		});
		this.form.getContextMenus().getGenericGridReplaceItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Replace, sender);
			}
		});
		this.form.getContextMenus().getGenericGridConfirmItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Confirm, sender);
			}
		});
		this.form.getContextMenus().getGenericGridEDIT_VIEW_ICP_ACTIONSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.EDIT_VIEW_ICP_ACTIONS, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbUnitLookup();
		bindcomboBoxTypeLookup();
		bindcomboBoxLocationLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbUnitLookup();
		bindcomboBoxTypeLookup();
		bindcomboBoxLocationLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbUnitLookupValue();
		defaultcomboBoxTypeLookupValue();
		defaultcomboBoxLocationLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
