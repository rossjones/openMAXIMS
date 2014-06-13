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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.42 build 2196.26417)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.mdtnotes;

import ims.clinical.forms.mdtnotes.GenForm.grdMDTRow;
import ims.clinical.forms.mdtnotes.GenForm.grdNotesSummaryRow;
import ims.clinical.vo.KeyDatesVo;
import ims.clinical.vo.KeyDatesVoCollection;
import ims.clinical.vo.MDTListAndDatesVo;
import ims.clinical.vo.MDTMeetingLiteVo;
import ims.clinical.vo.MDTMeetingLiteVoCollection;
import ims.clinical.vo.MDTMeetingVo;
import ims.clinical.vo.MDTNotesVo;
import ims.clinical.vo.MDTNotesVoCollection;
import ims.clinical.vo.lookups.LookupHelper;
import ims.clinical.vo.lookups.MDTArea;
import ims.clinical.vo.lookups.MDTListAorB;
import ims.clinical.vo.lookups.MDTListAorBCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.KeyDateType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.DateTime;
import ims.generalmedical.vo.AdmisSummary;
import ims.vo.LookupInstVo;

import java.util.ArrayList;


public class Logic extends BaseLogic
{
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handler region
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		// Initialize the form
		initialize();
		
		// Present form to screen
		open();
	}

	@Override
	protected void onFormModeChanged() 
	{
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.getLocalContext().setEditMDTNoteMode(Boolean.FALSE);
			form.getLocalContext().setNewNote(Boolean.FALSE);
		}
		
		updateControlsState();
	}
	
	@Override
	protected void onLnkReturnClick() throws PresentationLogicException 
	{
		engine.open(form.getForms().Clinical.MDTList);
	}

	@Override
	protected void onGrdMDTSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// Set 'MDT Meeting' selection, clear other selection
		// & populate screen with selected record
		updateSelection(form.grdMDT().getValue());
		
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onGrdNotesSummarySelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// Set 'MDT Note' selection & populate screen with selected record
		updateMDTNoteSelection(form.grdNotesSummary().getValue());

		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	@Override
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onImbSpellcheckClick() throws PresentationLogicException
	{
		form.ctnDetails().richNotes().spellCheck();
	}

	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newMDTNoteInstance();
				break;
				
			case GenForm.ContextMenus.GenericGrid.Update:
				updateMDTNoteInstance();
				break;
		}
		
		updateControlsState();
	}
	
	@Override
	protected void onBtnOKNotesClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (saveNote())
		{
			if (Boolean.TRUE.equals(form.getLocalContext().getNewNote()))
			{
				newMDTNoteInstance();
			}
		}
		
		updateControlsState();
	}

	@Override
	protected void onBtnCancelNotesClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setEditMDTNoteMode(Boolean.FALSE);
		form.getLocalContext().setNewNote(Boolean.FALSE);
		updateMDTNoteSelection(form.getLocalContext().getCurrentMDTNote());
		
		updateControlsState();
	}
	
	@Override
	protected void onQmbRecHCPTextSubmited(String value) throws PresentationLogicException 
	{
		// Clear query-combo box
		form.ctnDetails().qmbRecHCP().clear();
		
		
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.ctnDetails().qmbRecHCP().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.ctnDetails().qmbRecHCP().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.ctnDetails().qmbRecHCP().showOpened();		
		}		
	}

	

	


	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	

	/**
	 * Function used to initialize the form
	 * It will hide all context menu options and manage manual data-binding
	 */
	private void initialize()
	{
		// Hide all context menu options
		form.getContextMenus().hideAllGenericGridMenuItems();
		
		initializeComboBoxDataBinding();
	}
	
	/**
	 * Function used to data-bind 'MDT Area' & 'MDT List A or B' lookups to combo-boxes
	 * Since these two lookups are non-system and non-system entries are relevant
	 * we need to manually data-bind them
	 */
	private void initializeComboBoxDataBinding()
	{
		// Get 'MDT Area' lookup values (non-system) and bid them to the 'Area' combobox
		LookupInstVo[] roots = LookupHelper.getMDTArea(domain.getLookupService()).getRoots();
		
		// Add each root entry from lookup to combo-box 
		for (int i = 0; i < roots.length; i++)
		{
			MDTArea area = (MDTArea) roots[i];
			form.ctnDetails().cmbArea().newRow(area, area.getText());
		}
		
		
		// Get 'MDTListAorB' lookup values (non-system) and bind them to the 'MDT List' combobox 
		MDTListAorBCollection values_MDT_AorB = LookupHelper.getMDTListAorB(domain.getLookupService());
		
		// Add each entry from lookup to combo-box
		for (int i = 0; i < values_MDT_AorB.size(); i++)
		{
			MDTListAorB instance = values_MDT_AorB.get(i);
			
			if (!MDTListAorB.NOTONANYLISTYET.equals(instance) && Boolean.TRUE.equals(instance.isActive()))
			{
				form.cmbListMDT().newRow(instance, instance.getText());
			}
		}
	}	

	
	/**
	 * Function used to present screen to user.
	 * It will query records and populate screen.
	 * <br>Call this function to refresh the screen.
	 */
	private void open()
	{
		// Clear screen
		clearScreen();
		
		// Get the latest 'MDT Meeting - List and ' record for current Patient
		form.getLocalContext().setMDTListAndDates(domain.getLatestMDTListDetailsForPatient(form.getGlobalContext().Core.getPatientShort(), form.getGlobalContext().Core.getCurrentCareContext()));
		
		// Get admission summary - if any
		AdmisSummary admissionSummary;
		
		if (form.getGlobalContext().Core.getCurrentClinicalContact() != null)
		{
			admissionSummary = domain.getAdmissionSummaryByClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		}
		else
		{
			admissionSummary = domain.getAdmissionSummaryByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		}
		
		// Populate header controls
		populateHeaderControls(form.getLocalContext().getMDTListAndDates(), admissionSummary);
		
		// Get the 'MDT Meeting' records for current Patient and for current CareContext
		MDTMeetingLiteVoCollection mdtMeetingRecords = domain.listMDTMeeting(form.getGlobalContext().Core.getPatientShort(), form.getGlobalContext().Core.getCurrentCareContext());
		// Populate screen with data
		populateMDTMeetingGrid(mdtMeetingRecords);
		

		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);	
	}

	
	/**
	 * Function used to clear entire screen
	 */
	private void clearScreen() 
	{
		clearHeaderControls();
		
		clearDataControls();
	}

	/**
	 * Function used to clear only header controls
	 */
	private void clearHeaderControls()
	{
		form.lblClassification().setValue("-");
		form.lblPrimaryPathology().setValue("-");
		
		form.lblMDTList().setValue("-");
		form.lblNextGoalPlanDate().setValue("-");
		form.lblProposedDischageDate().setValue("-");
	}

	/**
	 * Function used to MDT grid and instance controls
	 */
	private void clearDataControls()
	{
		form.grdMDT().getRows().clear();

		clearInstanceControls();
	}

	/**
	 * Function used to clear instance controls
	 */
	private void clearInstanceControls()
	{
		form.dteMDTMeetingDate().setValue(null);
		form.pdtNextGoalPlanDate().setValue(null);
		form.pdtProposedDischargedDate().setValue(null);
		form.cmbListMDT().setValue(null);
		form.grdNotesSummary().getRows().clear();
		
		clearNoteInstanceControls();
	}

	/**
	 * Function used to clear note instance controls
	 */
	private void clearNoteInstanceControls()
	{
		form.ctnDetails().qmbRecHCP().clear();
		form.ctnDetails().cmbArea().setValue(null);
		form.ctnDetails().dtimRecDateTime().setValue(null);
		form.ctnDetails().richNotes().setValue(null);
	}

	
	/**
	 * Function used to update the local context with selected 'MDT Meeting' record
	 * and populate screen based on selected record
	 * 
	 * @param mdtMeeting - The 'MDT Meeting' record to be considered selected
	 */
	private void updateSelection(MDTMeetingLiteVo mdtMeeting)
	{
		// Set selection in local context
		form.getLocalContext().setCurrentMDTMeeting(domain.getMDTMeeting(mdtMeeting));
		

		// Populate instance controls
		populateInstanceControlsFromData(form.getLocalContext().getCurrentMDTMeeting());
	}
	
	
	/**
	 * Function used to update the local context with selected 'MDT Note' record
	 * and populate screen based on selected record
	 * 
	 * @param note - The 'MDT Note' record to be considered selected
	 */
	private void updateMDTNoteSelection(MDTNotesVo note)
	{
		// Set selection in local context
		form.getLocalContext().setCurrentMDTNote(note);
		form.grdNotesSummary().setValue(note);
		
		// Populate MDT Note controls
		populateMDTNoteControlsFromData(note);
	}
	
	
	/**
	 * Function used to prepare the screen for recording a new 'MDT Meeting'
	 */
	private void newInstance()
	{
		// Clear instance controls
		clearInstanceControls();
		form.grdMDT().setValue(null);
		
		// Clear local contexts holding current records
		form.getLocalContext().setCurrentMDTMeeting(null);
		form.getLocalContext().setCurrentMDTNote(null);
		
		// Set default values
		MDTListAndDatesVo latestListMDT = form.getLocalContext().getMDTListAndDates();
		
		if (latestListMDT != null)
		{
			form.cmbListMDT().setValue(latestListMDT.getListPatientisOn());
			
			for (KeyDatesVo keyDate : latestListMDT.getKeyDates())
			{
				if (KeyDateType.NEXTGOALPLANDATE.equals(keyDate.getDateType()))
					form.pdtNextGoalPlanDate().setValue(keyDate.getDate());
				
				if (KeyDateType.PROPOSEDDISCHARGEDATE.equals(keyDate.getDateType()))
					form.pdtProposedDischargedDate().setValue(keyDate.getDate());
			}
		}
		
		form.dteMDTMeetingDate().setValue(new Date());
		
		// Default in authoring info for MDT Notes
		form.ctnDetails().qmbRecHCP().clear();
		
		Hcp hcp = (Hcp) domain.getHcpUser();
		if(hcp != null)
		{
			form.ctnDetails().qmbRecHCP().newRow(hcp, hcp.toString());
			form.ctnDetails().qmbRecHCP().setValue(hcp);
		}
		
		form.ctnDetails().dtimRecDateTime().setValue(new DateTime());
		
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);
	}

	
	/**
	 * Function used to prepare screen for updating current 
	 */
	private void updateInstance()
	{
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean save()
	{
		try
		{
			// Populate 'MDT Meeting' record with data from screen
			MDTMeetingVo mdtMeeting = populateDataFromInstanceControls(form.getLocalContext().getCurrentMDTMeeting());
			
			// Validate records to save and apply UI validation rules
			String[] errors = mdtMeeting.validate(form.getLocalContext().getMDTListAndDates().validate(validateUIRules()));

			if (errors != null && errors.length > 0)
			{
				errors = cleanUpErrors(errors, "Date is mandatory");
				engine.showErrors(errors);
				return false;
			}

			// If a new MDT Meeting record is created or the latest one is saved
			// then update the MDT List record
			if (form.getLocalContext().getLatestMDTMeeting() == null || form.getLocalContext().getLatestMDTMeeting().equals(mdtMeeting)
					||	(mdtMeeting.getID_MDTMeeting() == null
							&& mdtMeeting.getMDTMeetingDate() != null
							&& mdtMeeting.getMDTMeetingDate().isGreaterOrEqualThan(form.getLocalContext().getLatestMDTMeeting().getMDTMeetingDate()))
				)
			{
    			form.getLocalContext().setCurrentMDTMeeting(domain.save(mdtMeeting, form.getLocalContext().getMDTListAndDates()));
			}
			else
			{
    			// Attempt to save
				form.getLocalContext().setCurrentMDTMeeting(domain.save(mdtMeeting));
			}

			return true;

		}
		// Treat any exceptions that might arise
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			open();
			return false;
		}
	}
	

	private String[] cleanUpErrors(String[] errors, String messageToRemove)
	{
		ArrayList<String> errorList = new ArrayList<String>();
		
		for (String error : errors)
		{
			if (!messageToRemove.equals(error))
			{
				errorList.add(error);
			}
		}
		
		return errorList.toArray(new String[errorList.size()]);
	}

	/**
	 * Function used to prepare the screen for adding a new MDT Note record
	 */
	private void newMDTNoteInstance()
	{
		// Clear MDT Note controls
		clearNoteInstanceControls();
		form.grdNotesSummary().setValue(null);
		
		// Clear local context for selected MDT Note
		form.getLocalContext().setCurrentMDTNote(null);
		
		// Set default values
		Hcp hcp = (Hcp) domain.getHcpUser();
		if(hcp != null)
		{
			form.ctnDetails().qmbRecHCP().newRow(hcp, hcp.toString());
			form.ctnDetails().qmbRecHCP().setValue(hcp);
		}

		form.ctnDetails().dtimRecDateTime().setValue(new DateTime());
		
		// Set form to mode of editing MDT Note
		// Set local context for mode editing MDT Note
		form.getLocalContext().setEditMDTNoteMode(Boolean.TRUE);
		form.getLocalContext().setNewNote(Boolean.TRUE);
	}


	/**
	 * Function used to prepare the screen for updating a MDT Note record 
	 */
	private void updateMDTNoteInstance()
	{
		// Set form to mode of editing MDT Note
		// Set local context for mode editing MDT Note
		form.getLocalContext().setEditMDTNoteMode(Boolean.TRUE);
		form.getLocalContext().setNewNote(Boolean.FALSE);
	}

	
	/**
	 * Function used to add or update a MDT Note record to current MDT Meeting record
	 * @return
	 */
	private boolean saveNote()
	{

		MDTNotesVo note = null;
		
		if (form.getLocalContext().getCurrentMDTNote() != null)
		{
			note = (MDTNotesVo) form.getLocalContext().getCurrentMDTNote().clone();
		}
		
		// Get MDT Note data from screen
		note = populateDataFromMDTNoteControls(note);
		
		// Validate MDT Note
		String[] errors = note.validate();
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		// Update row with MDT Note record data
		grdNotesSummaryRow noteRow = getOrCreateNoteRow(note);
		
		noteRow.setValue(note);
		noteRow.setColArea(note.getArea().getText());
		noteRow.setColNotes(note.getNotes());
		
		// Update local context & local context that signals a MDT Note edit
		form.getLocalContext().setCurrentMDTNote(note);
		form.getLocalContext().setEditMDTNoteMode(Boolean.FALSE);
		
		return true;
	}

	
	/**
	 * Function used to perform custom validation
	 * @return - String array with validation errors
	 */
	private String[] validateUIRules()
	{
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (form.cmbListMDT().getValue() == null)
		{
			errorList.add("MDT List for Patient is mandatory.");
		}
		
//		if (form.pdtNextGoalPlanDate().getValue() == null)
//		{
//			errorList.add("Next Goal Plan Date is mandatory.");
//		}
//		
//		if (form.pdtProposedDischargedDate().getValue() == null)
//		{
//			errorList.add("Proposed Discharged Date is mandatory.");
//		}

		return errorList.toArray(new String[errorList.size()]);
	}



	/**
	 * Function used to update the controls state (Visible / Hidden, Enabled / Disabled)
	 */
	private void updateControlsState()
	{
		// The link 'Return to MDT List' must be visible on form alias, but not on dialog alias 
		form.lnkReturn().setVisible(!engine.getFormName().equals(form.getForms().Clinical.MDTNotesForm));
		// The link 'Return to MDT List' must be visible only in VIEW mode
		form.lnkReturn().setEnabled(FormMode.VIEW.equals(form.getMode()));
		
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnUpdate().setVisible(form.grdMDT().getSelectedRow() != null);
			form.btnUpdate().setEnabled(form.grdMDT().getSelectedRow() != null);
		}

		boolean editNote = FormMode.EDIT.equals(form.getMode()) && Boolean.TRUE.equals(form.getLocalContext().getEditMDTNoteMode());
		boolean selectedNote = form.grdNotesSummary().getSelectedRow() != null;

		if (FormMode.EDIT.equals(form.getMode()))
		{
			form.grdNotesSummary().setEnabled(!editNote);
			
			// Enable / disable MDT Note controls
			form.ctnDetails().qmbRecHCP().setEnabled(editNote);
			// form.ctnDetails().dtimRecDateTime().setEnabled(editNote); - Authoring DateTime is always disabled 
			form.ctnDetails().cmbArea().setEnabled(editNote);
			form.ctnDetails().richNotes().setEnabled(editNote);
			form.ctnDetails().imbSpellcheck().setEnabled(editNote);
			
			form.ctnDetails().btnOKNotes().setEnabled(editNote);
			form.ctnDetails().btnCancelNotes().setEnabled(editNote);
		}
		
		form.ctnDetails().setCollapsed(!selectedNote && !editNote);

		// Update context menu options
		updateContextMenus();
	}
	
	
	/**
	 * Function used to update context menu state
	 */
	private void updateContextMenus()
	{
		boolean editMode = FormMode.EDIT.equals(form.getMode());
		boolean noteSelected = form.grdNotesSummary().getSelectedRow() != null;
		boolean inEditNoteMode = Boolean.TRUE.equals(form.getLocalContext().getEditMDTNoteMode());
		
		form.getContextMenus().getGenericGridAddItem().setVisible(editMode && !inEditNoteMode);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(editMode && noteSelected && !inEditNoteMode);
	}	


	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Function used to exchange data from and to screen
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------


	/**
	 * Function used to set values to labels in the header of the form
	 */
	private void populateHeaderControls(MDTListAndDatesVo mdtDetails, AdmisSummary admissionSummary)
	{
		// Clear header details
		clearHeaderControls();
		
		// Check parameter
		if (mdtDetails == null)
			return;
		
		// Fill in 'MDT List' name
		form.lblMDTList().setValue(mdtDetails.getListPatientisOn().getText());
		
		KeyDatesVoCollection keyDates = mdtDetails.getKeyDates();

		// Fill in 'Next Goal Plan' date and 'Proposed Discharge Date' 
		for (KeyDatesVo keyDate : keyDates)
		{
			if (KeyDateType.NEXTGOALPLANDATE.equals(keyDate.getDateType()))
				form.lblNextGoalPlanDate().setValue(keyDate.getDate().toString(DateFormat.STANDARD));
			
			if (KeyDateType.PROPOSEDDISCHARGEDATE.equals(keyDate.getDateType()))
				form.lblProposedDischageDate().setValue(keyDate.getDate().toString(DateFormat.STANDARD));
		}
		
		
		form.lblClassification().setValue(getClassification(admissionSummary));
		
		form.lblPrimaryPathology().setValue(getPrimaryPathology(admissionSummary));
	}
	

	/**
	 * Function used to populate MDT Meeting records to MDT grid
	 * @param mdtMeetingRecords - Records that will be populated to MDT grid
	 */
	private void populateMDTMeetingGrid(MDTMeetingLiteVoCollection mdtMeetingRecords)
	{
		// Clear grid & instance controls
		clearDataControls();
		
		// Check 'MDT Meeting' records collection parameter
		if (mdtMeetingRecords == null)
			return;
		
		// Populate 'MDT Meeting' records to grid
		for (MDTMeetingLiteVo mdtMeeting : mdtMeetingRecords)
		{
			grdMDTRow mdtRow = form.grdMDT().getRows().newRow();
			mdtRow.setColDate(mdtMeeting.getMDTMeetingDate().toString());
			mdtRow.setValue(mdtMeeting);
		}

		form.grdMDT().setValue(form.getLocalContext().getCurrentMDTMeeting());
		
		if (mdtMeetingRecords.size() > 0)
		{
			if (form.grdMDT().getValue() == null)
			{
				form.grdMDT().setValue(mdtMeetingRecords.get(0));
			}
			
			form.getLocalContext().setLatestMDTMeeting(mdtMeetingRecords.get(0));
		}
		
		updateSelection(form.grdMDT().getValue());
	}


	/**
	 * Function used to populate a MDT Meeting instance to controls
	 * @param mdtMeeting
	 */
	private void populateInstanceControlsFromData(MDTMeetingVo mdtMeeting)
	{
		// Clear instance controls
		clearInstanceControls();
		
		// Check parameter
		if (mdtMeeting == null)
			return;
		
		// Populate 'Meeting Date' control
		form.dteMDTMeetingDate().setValue(mdtMeeting.getMDTMeetingDate());
		
		// Populate MDT List
		if (mdtMeeting.getListPatientisOn() != null)
		{
			form.cmbListMDT().setValue(mdtMeeting.getListPatientisOn());

			if (form.cmbListMDT().getValue() == null)
			{
				form.cmbListMDT().newRow(mdtMeeting.getListPatientisOn(), mdtMeeting.getListPatientisOn().getText());
				form.cmbListMDT().setValue(mdtMeeting.getListPatientisOn());
			}
		}
		
		// Populate Key Dates
		if (mdtMeeting.getKeyDates() != null)
		{
			for (KeyDatesVo keyDate : mdtMeeting.getKeyDates())
			{
				if (KeyDateType.NEXTGOALPLANDATE.equals(keyDate.getDateType()))
				{
					form.pdtNextGoalPlanDate().setValue(keyDate.getDate());
				}

				if (KeyDateType.PROPOSEDDISCHARGEDATE.equals(keyDate.getDateType()))
				{
					form.pdtProposedDischargedDate().setValue(keyDate.getDate());
				}
			}
		}
		
		// Populate 'MDT Meeting Notes' to notes grid
		for (MDTNotesVo note : mdtMeeting.getMeetingNotes())
		{
			grdNotesSummaryRow noteRow = form.grdNotesSummary().getRows().newRow();
			
			noteRow.setColArea(note.getArea().getText());
			
			replaceSingleLineBreaks(note);//WDEV-17379
			
			noteRow.setColNotes(note.getNotes());
			
			noteRow.setValue(note);
		}
	}


	private MDTMeetingVo populateDataFromInstanceControls(MDTMeetingVo mdtMeeting)
	{
		if (mdtMeeting == null)
		{
			mdtMeeting = new MDTMeetingVo();
			mdtMeeting.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		}
		
		// Set 'MDT Meeting date'
		mdtMeeting.setMDTMeetingDate(form.dteMDTMeetingDate().getValue());
		
		// Set values for MDT List
		mdtMeeting.setListPatientisOn(form.cmbListMDT().getValue());
		
		// Set Key dates
		KeyDatesVoCollection originalDates = null;
			
		if (mdtMeeting.getKeyDates() != null)
		{
			originalDates = (KeyDatesVoCollection) mdtMeeting.getKeyDates().clone();
		}
			
		mdtMeeting.setKeyDates(new KeyDatesVoCollection());

		if (form.pdtNextGoalPlanDate().getValue() != null)
		{
			KeyDatesVo nextGoal = getOrCreateNextGoalPlanDate(originalDates);
			nextGoal.setDate(form.pdtNextGoalPlanDate().getValue());
			mdtMeeting.getKeyDates().add(nextGoal);
		}

		if (form.pdtProposedDischargedDate().getValue() != null)
		{
			KeyDatesVo proposedDischarged = getOrCreateProposedDischargedDate(originalDates);
			proposedDischarged.setDate(form.pdtProposedDischargedDate().getValue());
			mdtMeeting.getKeyDates().add(proposedDischarged);
		}
		
		
		// Check if MDT List needs to be updated
		// When a new MDT Meeting records is created with a date after latest MDT Meeting
		// or edited MDT record is the latest MDT record
		if (form.getLocalContext().getLatestMDTMeeting() == null || form.getLocalContext().getLatestMDTMeeting().equals(mdtMeeting)
				||
				(mdtMeeting.getID_MDTMeeting() == null
					&& mdtMeeting.getMDTMeetingDateIsNotNull()
					&& mdtMeeting.getMDTMeetingDate().isGreaterOrEqualThan(form.getLocalContext().getLatestMDTMeeting().getMDTMeetingDate()))
			)
		{
			form.getLocalContext().setMDTListAndDates(populateMDTListDataFromScreen(form.getLocalContext().getMDTListAndDates()));
		}
		
		// Get MDT Notes
		MDTNotesVoCollection notes = new MDTNotesVoCollection();
		
		for (int i = 0; i < form.grdNotesSummary().getRows().size(); i++)
		{
			notes.add(form.grdNotesSummary().getRows().get(i).getValue());
		}
		
		mdtMeeting.setMeetingNotes(notes);
		

		return mdtMeeting;
	}
	
	
	private KeyDatesVo getOrCreateNextGoalPlanDate(KeyDatesVoCollection keyDates)
	{
		if (keyDates != null)
		{
			for (KeyDatesVo keyDate : keyDates)
			{
				if (KeyDateType.NEXTGOALPLANDATE.equals(keyDate.getDateType()))
					return keyDate;
			}
		}
		
		
		KeyDatesVo date = new KeyDatesVo();
		date.setDateType(KeyDateType.NEXTGOALPLANDATE);
		
		return date;
	}

	private KeyDatesVo getOrCreateProposedDischargedDate(KeyDatesVoCollection keyDates)
	{
		if (keyDates != null)
		{
			for (KeyDatesVo keyDate : keyDates)
			{
				if (KeyDateType.PROPOSEDDISCHARGEDATE.equals(keyDate.getDateType()))
					return keyDate;
			}
		}
		
		KeyDatesVo date = new KeyDatesVo();
		date.setDateType(KeyDateType.PROPOSEDDISCHARGEDATE);

		return date;
	}

	private MDTListAndDatesVo populateMDTListDataFromScreen(MDTListAndDatesVo mdtListAndDates)
	{
		if (mdtListAndDates == null)
		{
			mdtListAndDates = new MDTListAndDatesVo();
			
			mdtListAndDates.setPatient(form.getGlobalContext().Core.getPatientShort());
			mdtListAndDates.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		}

		// Get MDT List
		mdtListAndDates.setListPatientisOn(form.cmbListMDT().getValue());
		
		// Get Key Dates
		KeyDatesVoCollection originalDates = null;

		if (mdtListAndDates.getKeyDates() != null)
		{
			originalDates = (KeyDatesVoCollection) mdtListAndDates.getKeyDates().clone();
		}

		mdtListAndDates.setKeyDates(new KeyDatesVoCollection());

		if (form.pdtNextGoalPlanDate().getValue() != null)
		{
			// Create Key Date - Next Goal Plan Date
			KeyDatesVo nextGoal = getOrCreateNextGoalPlanDate(originalDates);
			nextGoal.setDate(form.pdtNextGoalPlanDate().getValue());
			mdtListAndDates.getKeyDates().add(nextGoal);
		}

		if (form.pdtProposedDischargedDate().getValue() != null)
		{
			// Create Key Date - Proposed Discharged Date
			KeyDatesVo proposeDischarge = getOrCreateProposedDischargedDate(originalDates);
			proposeDischarge.setDate(form.pdtProposedDischargedDate().getValue());
			mdtListAndDates.getKeyDates().add(proposeDischarge);
		}

		return mdtListAndDates;
	}

	
	/**
	 * Function used to populate MDT Note instance to controls
	 */
	private void populateMDTNoteControlsFromData(MDTNotesVo note)
	{
		// Clear instance controls
		clearNoteInstanceControls();
		
		// Check parameter
		if (note == null)
			return;
		
		
		// Populate 'MDT Note' controls
		form.ctnDetails().qmbRecHCP().newRow(note.getAuthoringCP(), note.getAuthoringCP().toString());
		form.ctnDetails().qmbRecHCP().setValue(note.getAuthoringCP());
		
		form.ctnDetails().dtimRecDateTime().setValue(note.getAuthoringDateTime());
		form.ctnDetails().cmbArea().setValue(note.getArea());
		
		replaceSingleLineBreaks(note);//WDEV-17379
		
		form.ctnDetails().richNotes().setValue(note.getNotes());
	}

	private void replaceSingleLineBreaks(MDTNotesVo note)
	{
		if (note == null || note.getNotes() == null)
			return;
		
		if (note.getNotes().contains("<br/>"))
			note.setNotes(note.getNotes().replaceAll("<br/>", "\n"));
	}
	

	/**
	 * Function used to populate MDT Note record with data from controls
	 */
	private MDTNotesVo populateDataFromMDTNoteControls(MDTNotesVo note)
	{
		if (note == null)
			note = new MDTNotesVo();
		
		note.setAuthoringCP(form.ctnDetails().qmbRecHCP().getValue());
		note.setAuthoringDateTime(form.ctnDetails().dtimRecDateTime().getValue());
		note.setArea(form.ctnDetails().cmbArea().getValue());
		note.setNotes(form.ctnDetails().richNotes().getValue());
		
		return note;
	}


	

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Auxiliary functions
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to get Primary Pathology string from Admission Summary record
	 */
	private String getPrimaryPathology(AdmisSummary admissionSummary)
	{
		if (admissionSummary == null)
			return "-";
		
		StringBuffer PrimaryPathology = new StringBuffer();
		if (admissionSummary.getLevelOfInjuryIsNotNull())
			PrimaryPathology.append(admissionSummary.getLevelOfInjury());
							
		if (admissionSummary.getTypeOfInjuryIsNotNull())
			PrimaryPathology.append(", " + admissionSummary.getTypeOfInjury());
		
		return PrimaryPathology.toString();
	}

	/**
	 * Function used to get Classification string from Admission Summary record
	 */
	private String getClassification(AdmisSummary admissionSummary)
	{
		if (admissionSummary == null)
			return "-";
		
		StringBuffer Classification = new StringBuffer();
		
		if (admissionSummary.getOverallNeuroIsNotNull())
			Classification.append(admissionSummary.getOverallNeuro());
							
		if (admissionSummary.getCompleteIncompleteIsNotNull())
			Classification.append(", " + admissionSummary.getCompleteIncomplete());
		
		return Classification.toString();
	}
	
	
	/**
	 * Function used to get (or create) a row for 'MDT Note' record 
	 */
	private grdNotesSummaryRow getOrCreateNoteRow(MDTNotesVo note)
	{
		if (Boolean.TRUE.equals(form.getLocalContext().getNewNote()))
			return form.grdNotesSummary().getRows().newRow();
		
		if (form.grdNotesSummary().getSelectedRow() != null)
			return form.grdNotesSummary().getSelectedRow();
		
		// Return a new row
		return form.grdNotesSummary().getRows().newRow();
	}
}
