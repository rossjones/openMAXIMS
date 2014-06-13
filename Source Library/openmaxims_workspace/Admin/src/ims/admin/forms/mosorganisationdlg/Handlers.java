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

package ims.admin.forms.mosorganisationdlg;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdOrganisationLocationCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdOrganisationLocationCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdOrganisationLocationRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdOrganisationLocationRowChecked(ims.framework.controls.DynamicGridRow row);
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
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
		this.form.dyngrdOrganisationLocation().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdOrganisationLocationCellButtonClicked(cell);
			}
		});
		this.form.dyngrdOrganisationLocation().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdOrganisationLocationCellValueChanged(cell);
			}
		});
		this.form.dyngrdOrganisationLocation().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdOrganisationLocationRowSelectionChanged(row);
			}
		});
		this.form.dyngrdOrganisationLocation().setDynamicGridRowCheckedEvent(new DynamicGridRowChecked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdOrganisationLocationRowChecked(row);
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
		this.form.getContextMenus().getMosLocationSetPrimaryLocationItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MosLocation.SetPrimaryLocation, sender);
			}
		});
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
