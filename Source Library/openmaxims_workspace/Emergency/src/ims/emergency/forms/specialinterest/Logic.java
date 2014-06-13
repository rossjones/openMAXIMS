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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.specialinterest;

import ims.emergency.vo.SpecialInterestDetailsVo;
import ims.emergency.vo.SpecialInterestDetailsVoCollection;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String	COLUMN_SPECIALINTERESTCATEGORY		= "0";
	private static final String	COLUMN_STARTDATE					= "1";
	private static final String	COLUMN_ENDDATE						= "2";

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (args!=null && args.length>0 && args[0]!=null && args[0] instanceof FormMode && FormMode.VIEW.equals((FormMode)args[0]))
		{
			form.getLocalContext().setFormIsReadOnly(true);
		}
		
		createdDynamicGridSpecialInterest();
		open();
		
	}
	
	private void createdDynamicGridSpecialInterest()
	{
		form.dyngrdSpecialInterest().getRows().clear();
		
		DynamicGridColumn columnName = form.dyngrdSpecialInterest().getColumns().newColumn("Category", COLUMN_SPECIALINTERESTCATEGORY);
		columnName.setWidth(155);
		columnName.setAlignment(Alignment.LEFT);
		columnName.setReadOnly(true);
		
		columnName = form.dyngrdSpecialInterest().getColumns().newColumn("Start Date", COLUMN_STARTDATE);
		columnName.setWidth(100);
		columnName.setReadOnly(true);
		
		columnName = form.dyngrdSpecialInterest().getColumns().newColumn("End Date", COLUMN_ENDDATE);
		columnName.setWidth(-1);
		columnName.setReadOnly(true);
	
	}
	
	private void open()
	{
		populateScreenFormData(form.getGlobalContext().Emergency.getCollSpecialInterestDetails());
		form.setMode(FormMode.VIEW);
	}

	private void populateScreenFormData(SpecialInterestDetailsVoCollection collSpecialInterestDetails)
	{
		clearScreen();
		if (collSpecialInterestDetails==null || (collSpecialInterestDetails!=null && collSpecialInterestDetails.size()==0))
			return;
		
		for (int i = 0; i < collSpecialInterestDetails.size(); i++)
		{
			 SpecialInterestDetailsVo specialInterest = collSpecialInterestDetails.get(i);
			 addRowToSpecialInterestDyngrd(specialInterest);
			
		}

		populateInstanceControlsFromData(form.getLocalContext().getSelectedSpecialInterest());
		
	}

	private void populateInstanceControlsFromData(SpecialInterestDetailsVo selectedSpecialInterest)
	{
		clearDetails();
		
		if (selectedSpecialInterest==null)
			return;
		
		form.ctnDetails().dtimStartDate().setValue(selectedSpecialInterest.getStartDateTime());
		form.ctnDetails().dtimEndDate().setValue(selectedSpecialInterest.getCompletedDateTime());
		form.ctnDetails().cmbSpecialInterestCategory().setValue(selectedSpecialInterest.getSpecialInterestCategory());
		
		form.dyngrdSpecialInterest().setValue(selectedSpecialInterest);
		
	}

	private void addRowToSpecialInterestDyngrd(SpecialInterestDetailsVo specialInterest)
	{
		if(	specialInterest == null)
			return;
			
		DynamicGridRow row = form.dyngrdSpecialInterest().getRows().newRow();
		row.setValue(specialInterest);
		
		//row.setReadOnly(true);
		
		DynamicGridCell SpecialIntCategory = row.getCells().newCell(getColumn(COLUMN_SPECIALINTERESTCATEGORY), DynamicCellType.STRING);	
		SpecialIntCategory.setValue(specialInterest.getSpecialInterestCategoryIsNotNull() ?specialInterest.getSpecialInterestCategory().getIItemText():null);
		SpecialIntCategory.setReadOnly(true);
		
		DynamicGridCell startdatecell = row.getCells().newCell(getColumn(COLUMN_STARTDATE), DynamicCellType.STRING);
		startdatecell.setValue(specialInterest.getStartDateTime() != null ? specialInterest.getStartDateTime().toString():"");
		startdatecell.setReadOnly(true);
		
		DynamicGridCell enddate = row.getCells().newCell(getColumn(COLUMN_ENDDATE), DynamicCellType.STRING);
		enddate.setValue(specialInterest.getCompletedDateTime() != null ? specialInterest.getCompletedDateTime().toString():"");
		enddate.setReadOnly(true);
		
	}

	private DynamicGridColumn getColumn(String identifier) 
	{
		return form.dyngrdSpecialInterest().getColumns().getByIdentifier(identifier);
	}
	
	private void clearScreen()
	{
		form.dyngrdSpecialInterest().getRows().clear();
		clearDetails();	
	}

	private void clearDetails()
	{
		form.ctnDetails().cmbSpecialInterestCategory().setValue(null);
		form.ctnDetails().dtimStartDate().setValue(null);
		form.ctnDetails().dtimEndDate().setValue(null);
	}

	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{	
		SpecialInterestDetailsVoCollection collSpecialInterest = new SpecialInterestDetailsVoCollection();
		
		for (int i=0;i<form.dyngrdSpecialInterest().getRows().size();i++)
		{
			collSpecialInterest.add((SpecialInterestDetailsVo) form.dyngrdSpecialInterest().getRows().get(i).getValue());
		}
		
		form.getGlobalContext().Emergency.setCollSpecialInterestDetails(collSpecialInterest);
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			if (form.dyngrdSpecialInterest().getValue()!=null)
			{
				updateRowToSpecialInterestDyngrd(form.getLocalContext().getSelectedSpecialInterest());
				form.dyngrdSpecialInterest().setValue(null);
				form.dyngrdSpecialInterest().setValue(form.getLocalContext().getSelectedSpecialInterest());
			}
			else
			{
				addRowToSpecialInterestDyngrd(form.getLocalContext().getSelectedSpecialInterest());
				//form.dyngrdSpecialInterest().setValue(null);
				form.dyngrdSpecialInterest().setValue(form.getLocalContext().getSelectedSpecialInterest());
			}
			
			form.setMode(FormMode.VIEW);
		}
	}
	
	private void updateRowToSpecialInterestDyngrd(SpecialInterestDetailsVo specialInterest)
	{
		DynamicGridRow row = form.dyngrdSpecialInterest().getSelectedRow();
		row.setValue(specialInterest);
		
		//row.setReadOnly(true);
		
		DynamicGridCell SpecialIntCategory = row.getCells().newCell(getColumn(COLUMN_SPECIALINTERESTCATEGORY), DynamicCellType.STRING);	
		SpecialIntCategory.setValue(specialInterest.getSpecialInterestCategoryIsNotNull() ?specialInterest.getSpecialInterestCategory().getIItemText():null);
		SpecialIntCategory.setReadOnly(true);
		
		DynamicGridCell startdatecell = row.getCells().newCell(getColumn(COLUMN_STARTDATE), DynamicCellType.STRING);
		startdatecell.setValue(specialInterest.getStartDateTime() != null ? specialInterest.getStartDateTime().toString():"");
		startdatecell.setReadOnly(true);
		
		DynamicGridCell enddate = row.getCells().newCell(getColumn(COLUMN_ENDDATE), DynamicCellType.STRING);
		enddate.setValue(specialInterest.getCompletedDateTime() != null ? specialInterest.getCompletedDateTime().toString():"");
		enddate.setReadOnly(true);
	}

	private boolean save()
	{
		SpecialInterestDetailsVo specialInterestToSave = populateInstanceDataFromScreen(form.getLocalContext().getSelectedSpecialInterest());
		
		String[] errors = getUIErrors();
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);			
			return false;
		}
		
		form.getLocalContext().setSelectedSpecialInterest(specialInterestToSave);
	
		return true;
	}

	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if(	form.ctnDetails().dtimStartDate().getValue() == null)
		{
			errors.add("Start Date is mandatory !");	
			
		}
		if( form.ctnDetails().dtimStartDate().getValue() != null)
		{
			if (form.ctnDetails().dtimStartDate().getValue().isGreaterThan(new DateTime()))
			{
				errors.add("Start Date cannot be set in the future!");
			}
			else if(form.ctnDetails().dtimEndDate().getValue() != null && (form.ctnDetails().dtimStartDate().getValue().getDate().isGreaterThan(form.ctnDetails().dtimEndDate().getValue().getDate()) || (form.ctnDetails().dtimStartDate().getValue().getDate().equals(form.ctnDetails().dtimEndDate().getValue().getDate()) && form.ctnDetails().dtimStartDate().getValue().getTime().isGreaterThan(form.ctnDetails().dtimEndDate().getValue().getTime()))))
			{
				errors.add("Start Date cannot be greater than End Date !");
			}
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;	
	}

	private SpecialInterestDetailsVo populateInstanceDataFromScreen(SpecialInterestDetailsVo specialInterest)
	{
		if (specialInterest==null)
			specialInterest=new SpecialInterestDetailsVo();
		else
			specialInterest=(SpecialInterestDetailsVo)specialInterest.clone();
		
		specialInterest.setCompletedDateTime(form.ctnDetails().dtimEndDate().getValue());
		specialInterest.setStartDateTime(form.ctnDetails().dtimStartDate().getValue());
		specialInterest.setSpecialInterestCategory(form.ctnDetails().cmbSpecialInterestCategory().getValue());
		
		return specialInterest;
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	private void newInstance()
	{
		clearDetails();
		form.dyngrdSpecialInterest().setValue(null);
		form.ctnDetails().dtimStartDate().setValue(new DateTime());
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onDyngrdSpecialInterestRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		form.getLocalContext().setSelectedSpecialInterest((SpecialInterestDetailsVo)form.dyngrdSpecialInterest().getValue());
		populateInstanceControlsFromData(form.getLocalContext().getSelectedSpecialInterest());
		updateControlState();
	}
	
	@Override
	protected void onImbRemoveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		removeInstance();
		
	}
	private void removeInstance()
	{
		if(	form.dyngrdSpecialInterest().getSelectedRow() != null)
			form.dyngrdSpecialInterest().getRows().remove(form.dyngrdSpecialInterest().getSelectedRow());
		clearDetails();//WDEV-17192
		updateControlState();
		
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.EmergencyNamespace.SpecialInterest.ADD:
				newInstance();
			break;
			case GenForm.ContextMenus.EmergencyNamespace.SpecialInterest.EDIT:
				form.setMode(FormMode.EDIT);
			break;
			case GenForm.ContextMenus.EmergencyNamespace.SpecialInterest.REMOVE:
				removeInstance();
			break;
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
	}

	private void updateControlState() //WDEV-17246
	{
		form.btnNew().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getFormIsReadOnly()));
				
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getFormIsReadOnly()) && form.dyngrdSpecialInterest().getValue()!=null);
		form.imbRemove().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getFormIsReadOnly()) && form.dyngrdSpecialInterest().getValue()!=null);

		form.getContextMenus().Emergency.getSpecialInterestADDItem().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getFormIsReadOnly()));
		form.getContextMenus().Emergency.getSpecialInterestEDITItem().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getFormIsReadOnly()) && form.dyngrdSpecialInterest().getValue()!=null);
		form.getContextMenus().Emergency.getSpecialInterestREMOVEItem().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getFormIsReadOnly()) && form.dyngrdSpecialInterest().getValue()!=null);
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		form.getLocalContext().setSelectedSpecialInterest((SpecialInterestDetailsVo)form.dyngrdSpecialInterest().getValue());
		populateInstanceControlsFromData(form.getLocalContext().getSelectedSpecialInterest());
	}
}
