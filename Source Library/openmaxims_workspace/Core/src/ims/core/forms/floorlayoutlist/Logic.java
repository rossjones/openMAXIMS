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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.62 build 3110.16630)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.floorlayoutlist;

import ims.core.vo.FloorLayoutLiteVo;
import ims.core.vo.FloorLayoutLiteVoCollection;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Core.BayFloorPlanDesigner) && result.equals(DialogResult.OK))
		{
			open();
		}
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();		
	}
	@Override
	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException
	{
		updateControlsState();
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.View:
				viewInstance();
				break;
		}
	}	
	public void clearInstanceControls() 
	{
		form.grdDetails().getRows().clear();
	}
	public void newInstance() throws PresentationLogicException 
	{
		form.getGlobalContext().Core.FloorLayout.setReadOnly(false);
		form.getGlobalContext().Core.FloorLayout.setSelection(null);
		engine.open(form.getForms().Core.BayFloorPlanDesigner);
	}
	public boolean save() throws PresentationLogicException 
	{
		return false;
	}
	public void updateControlsState() 
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.btnEdit().setVisible(form.grdDetails().getValue() != null);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdDetails().getValue() != null);
			form.getContextMenus().getGenericGridViewItem().setVisible(form.grdDetails().getValue() != null);
		}
		else
		{
			form.btnEdit().setVisible(false);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.getContextMenus().getGenericGridViewItem().setVisible(false);
		}
	}
	public void updateInstance() 
	{
		viewOrUpdateInstance(false);
	}
	public void viewInstance() 
	{
		viewOrUpdateInstance(true);
	}
	private void viewOrUpdateInstance(boolean readOnly)
	{
		form.getGlobalContext().Core.FloorLayout.setReadOnly(readOnly);
		form.getGlobalContext().Core.FloorLayout.setSelection(form.grdDetails().getValue());
		engine.open(form.getForms().Core.BayFloorPlanDesigner);
	}
	public void initialize()
	{		
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
	}
	public void open() throws PresentationLogicException 
	{
		clearInstanceControls();
		
		FloorLayoutLiteVoCollection list = domain.list();
		if(list != null)
		{
			for(int x = 0; x < list.size(); x++)
			{
				add(list.get(x));
			}
		}	
		
		updateControlsState();
	}
	private void add(FloorLayoutLiteVo value) 
	{
		if(value == null)
			return;
			
		ims.core.forms.floorlayoutlist.GenForm.grdDetailsRow row = form.grdDetails().getRows().newRow(value.equals(form.getGlobalContext().Core.FloorLayout.getSelection()));
		
		row.setcolName(value.getName());
		row.setcolStatus(value.getStatus());
		
		row.setValue(value);
	}
}
