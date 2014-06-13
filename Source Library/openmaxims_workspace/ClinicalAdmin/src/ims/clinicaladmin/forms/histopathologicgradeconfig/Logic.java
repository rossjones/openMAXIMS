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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.histopathologicgradeconfig;

import ims.clinicaladmin.forms.histopathologicgradeconfig.GenForm.grdHistopathologicalGradeRow;
import ims.clinicaladmin.vo.HistopathologicGradeVo;
import ims.clinicaladmin.vo.HistopathologicGradeVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers region
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		
		open();
	}
	
	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (formName.equals(form.getForms().Core.YesNoDialog) && result.equals(DialogResult.YES))
		{
			HistopathologicGradeVo saveDiff = form.grdHistopathologicalGrade().getSelectedRow().getValue();
			saveDiff.setIsActive( !saveDiff.getIsActive());
			form.grdHistopathologicalGrade().getSelectedRow().setValue(saveDiff);
		}
		updateContextMenus();
	}

	protected void onGrdDifferentationSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// Update local context
		form.getLocalContext().setSelectedRecord(domain.getHistopathologicGrade(form.grdHistopathologicalGrade().getValue()));
		// Populate instance controls
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onGrdDifferentationSelectionCleared() throws PresentationLogicException
	{
		// Clear local context
		form.getLocalContext().setSelectedRecord(null);
		// Populate instance controls
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		newInstance();		
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
			break;
			
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
			break;
			
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeItemFromDefaults();
			break;
		}

		updateControlsState();
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void initialize() throws FormOpenException
	{
		// Clear local context
		form.getLocalContext().setSelectedRecord(null);
		
		// Hide all context menu options
		form.getContextMenus().hideAllGenericGridMenuItems();
		
		// Set text for context menu options
	}
	
	public void open() throws PresentationLogicException
	{
		// Clear screen
		clearScreen();

		// List histologies
		populateHistologyGrades(domain.listHistopathologicGrade());

		// Reselect histology edited or created
		form.grdHistopathologicalGrade().setValue(form.getLocalContext().getSelectedRecord());
		form.getLocalContext().setSelectedRecord(domain.getHistopathologicGrade(form.grdHistopathologicalGrade().getValue()));

		// Populate instance controls with selected histology
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		
		// Set form in VIEW mode
		form.setMode(FormMode.VIEW);
	}

	public void newInstance() throws PresentationLogicException
	{
		// Clear grid selection
		form.grdHistopathologicalGrade().setValue(null);
		// Clear selected local context
		form.getLocalContext().setSelectedRecord(null);
		// Clear instance controls
		clearInstanceControls();
		
		// Set form in EDIT mode
		form.setMode(FormMode.EDIT);
	}

	public void updateInstance()
	{
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);
	}

	private void removeItemFromDefaults() throws PresentationLogicException
	{
		try
		{
			if (!(form.grdHistopathologicalGrade().getValue() instanceof HistopathologicGradeVo))
				throw new CodingRuntimeException("Can not remove invalid value.");

			// Get value from grid
			HistopathologicGradeVo histopathologyGrade = form.grdHistopathologicalGrade().getValue();
			histopathologyGrade.setIsDefault(Boolean.FALSE);

			// Validate value
			histopathologyGrade.validate();

			// Inactivate record
			domain.saveHistopathologicGrade(histopathologyGrade);
			
			open();
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
		}
		catch (ForeignKeyViolationException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
		}
		catch (UniqueKeyViolationException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
		}
		catch (UnqViolationUncheckedException e)
		{
			e.printStackTrace();
			engine.showMessage("Taxonomy Mapping is registered to another record");
		}
	}

	public boolean save() throws PresentationLogicException
	{
		try
		{
			// Get data from screen
			form.getLocalContext().setSelectedRecord(populateDataFromInstanceControls(form.getLocalContext().getSelectedRecord()));

			// Validate data
			String[] errors = form.getLocalContext().getSelectedRecord().validate();

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			// Attempt to save data
			form.getLocalContext().setSelectedRecord(domain.saveHistopathologicGrade(form.getLocalContext().getSelectedRecord()));

			return true;
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UnqViolationUncheckedException e)
		{
			e.printStackTrace();
			engine.showMessage("Taxonomy Mapping is registered to another record");
			return false;
		}
	}

	private void clearScreen()
	{
		// Clear grid
		form.grdHistopathologicalGrade().getRows().clear();

		clearInstanceControls();
	}

	public void clearInstanceControls()
	{
		form.ctnDetails().txtGrade().setValue(null);
		form.ctnDetails().txtDescription().setValue(null);
	}

	public void updateControlsState()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.btnEdit().setVisible(true);
			form.btnEdit().setEnabled(form.grdHistopathologicalGrade().getValue() instanceof HistopathologicGradeVo);
		}
		
		updateContextMenus();
	}


	protected void updateContextMenus()
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdHistopathologicalGrade().getValue() instanceof HistopathologicGradeVo);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(form.grdHistopathologicalGrade().getValue() instanceof HistopathologicGradeVo);
	}


	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Data exchange functions
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	private void populateHistologyGrades(HistopathologicGradeVoCollection histologyGradeCollection)
	{
		// Clear grid
		form.grdHistopathologicalGrade().getRows().clear();

		// Check collection for null
		if (histologyGradeCollection == null)
			return;

		// Populate grid
		for (HistopathologicGradeVo histologyGrade : histologyGradeCollection)
		{
			if (histologyGrade == null)
				continue;

			grdHistopathologicalGradeRow newRow = form.grdHistopathologicalGrade().getRows().newRow();

			newRow.setColGrade(histologyGrade.getGrade());
			newRow.setColDescription(histologyGrade.getTumourDifferentation());

			newRow.setValue(histologyGrade);
		}
	}

	private void populateInstanceControls(HistopathologicGradeVo histologyGrade)
	{
		// Clear instance controls
		clearInstanceControls();

		// Check parameter for null value
		if (histologyGrade == null)
			return;

		form.ctnDetails().txtGrade().setValue(histologyGrade.getGrade());
		form.ctnDetails().txtDescription().setValue(histologyGrade.getTumourDifferentation());
	}

	private HistopathologicGradeVo populateDataFromInstanceControls(HistopathologicGradeVo histologyGrade)
	{
		if (histologyGrade == null)
		{
			histologyGrade = new HistopathologicGradeVo();
			histologyGrade.setIsDefault(Boolean.TRUE);
			histologyGrade.setIsActive(Boolean.TRUE);
		}
		
		histologyGrade.setGrade(form.ctnDetails().txtGrade().getValue());
		histologyGrade.setTumourDifferentation(form.ctnDetails().txtDescription().getValue());

		return histologyGrade;
	}
}
