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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.38 build 2144.16652)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.familyhistory;

import ims.clinical.vo.FamilyHistoryVo;
import ims.clinical.vo.FamilyHistoryVoCollection;
import ims.clinical.vo.lookups.CodingItemType;
import ims.core.vo.DiagLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.core.vo.lookups.YesNoUnknown;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.PartialDate;
import ims.vo.interfaces.IClinicalCodingValue;

public class Logic extends BaseLogic 
{
	private static final String	NO_CODE_ITEM_SELECTED	= "No Code Item Selected";
	
	/**
	 * sets the age of death control enabled status
	 * @return      void
	 */
	private void setAgeDeathEnableStatus() 
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			if ((form.ctnFamilyHistory().cbLiving().getValue() != null) && (form.ctnFamilyHistory().cbLiving().getValue().equals(YesNoUnknown.YES)))
			{
				form.ctnFamilyHistory().intAgeDeath().setEnabled(false);
				form.ctnFamilyHistory().intAgeDeath().setValue(null);
				form.ctnFamilyHistory().intAgeDeath().setRequired(false); //wdev-13396
			}
			else if((form.ctnFamilyHistory().cbLiving().getValue() != null) && (form.ctnFamilyHistory().cbLiving().getValue().equals(YesNoUnknown.NO))) //wdev-13396 
			{
				form.ctnFamilyHistory().intAgeDeath().setEnabled(true);
				form.ctnFamilyHistory().intAgeDeath().setRequired(true);
			}
			else
			{
				form.ctnFamilyHistory().intAgeDeath().setEnabled(false);  //wdev-15365
				
				form.ctnFamilyHistory().intAgeDeath().setValue(null);	  //wdev-15365
				form.ctnFamilyHistory().intAgeDeath().setRequired(false); //wdev-13396
			}
		}	
	}

	/**
	 * check UI business logic rules and returns errors as String[]
	 * @param  arrErrorsUI
	 * @return String[]
	 */		
	public String[] validateUIRules()
	{
		java.util.ArrayList listOfErrors = new java.util.ArrayList();		
		
		if( form.ctnFamilyHistory().dateDOB().getValue() != null)
		{
			Date dt = new Date();
			if( form.ctnFamilyHistory().dateDOB().getValue().isGreaterThan(dt))
			{
				listOfErrors.add("Date of Birth cannot be in the future.");
			}
		}
		
		if (form.ctnFamilyHistory().cbLiving().getValue() != null)
		{		
			if ((form.ctnFamilyHistory().cbLiving().getValue().equals(YesNoUnknown.NO)) && (form.ctnFamilyHistory().intAgeDeath().getValue() == null))
				listOfErrors.add("Please enter a valid Age at Death:");
		}	
		if ((form.ctnFamilyHistory().intAgeOnset().getValue() != null) && (form.ctnFamilyHistory().intAgeDeath().getValue() != null))
		{
			if (form.ctnFamilyHistory().intAgeOnset().getValue().intValue() > form.ctnFamilyHistory().intAgeDeath().getValue().intValue())
				listOfErrors.add("Age at Onset: cannot be greater than Age at Death:");
		}
		if( form.ctnFamilyHistory().customControlAuthoringInfo().getValue() == null || form.ctnFamilyHistory().customControlAuthoringInfo().getValue().getAuthoringHcp() == null || form.ctnFamilyHistory().customControlAuthoringInfo().getValue().getAuthoringDateTime() == null)
		{
			listOfErrors.add("Authoring HCP and Authoring Date/Time are mandatory.");
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			return null;
		}
		String[] result = new String[errorCount];
		listOfErrors.toArray(result);
		
		return result;
	}
	/**
	 * update the context menu for the grid and update button for the form
	 * @return      void
	 */	
	public void updateControlsState()
	{
		//TODO: will be set as default to New. remove the "New " when this is complete.
		form.getContextMenus().getLIPNewItem().setText("New");

//		boolean bAddnew = form.getMode().equals(FormMode.EDIT) && 
//		  form.getLocalContext().getSelectedRecordIsNotNull() &&
//		  form.getLocalContext().getSelectedRecord().getID_PatientFamilyHistory() == null;

		form.ctnFamilyHistory().customControlCodingItem().setParentEditing(new Boolean(form.getMode().equals(FormMode.EDIT)));

		if (form.getMode().equals(FormMode.EDIT))
		{
			form.getContextMenus().getLIPNewItem().setVisible(false);
			form.getContextMenus().getLIPUpdateItem().setVisible(false);
			form.btnUpdate().setVisible(false);	
			
			form.ctnFamilyHistory().setcustomControlCodingItemEnabled(true);
		}
		else
		{
			if (form.grdList().getSelectedRowIndex()>=0)
			{
				form.getContextMenus().getLIPNewItem().setVisible(true);
				form.getContextMenus().getLIPUpdateItem().setVisible(true);
				if (form.grdList().getSelectedRowIndex()>=0)
					form.btnUpdate().setVisible(true);
				else
					form.btnUpdate().setVisible(false);
			}
			else
			{
				form.getContextMenus().getLIPNewItem().setVisible(true);
				form.getContextMenus().getLIPUpdateItem().setVisible(false);
				form.btnUpdate().setVisible(false);
			}
		}
		form.ctnFamilyHistory().customControlCodingItem().setParentEditing(new Boolean(form.getMode().equals(FormMode.EDIT)));
		setAgeDeathEnableStatus();		
	}
	/**
	 * clear controls used for displaying instance data
	 * @return void 
	 */		
	public void clearInstanceControls() 
	{
		form.ctnFamilyHistory().customControlCodingItem().clear();
		form.ctnFamilyHistory().customControlAuthoringInfo().setValue(null);
		
		form.ctnFamilyHistory().cbLiving().setValue(null);
		form.ctnFamilyHistory().cbRelationship().setValue(null);
		
		form.ctnFamilyHistory().dateDOB().setValue(null);
		
		form.ctnFamilyHistory().intAgeDeath().setValue(null);
		form.ctnFamilyHistory().intAgeOnset().setValue(null);
		form.ctnFamilyHistory().txtNotes().setValue("");
		form.ctnFamilyHistory().txtRelativeName().setValue("");
			
	}
	/**
	 * populates the screen from data from specified FamilyHistoryVoCollection
	 * @param voCollFamHist 
	 * @return      void
	 */
	private void populateListControl(FamilyHistoryVoCollection voCollFamHist)
	{	
		clear();
		
		if (voCollFamHist != null)
		{
			GenForm.grdListRow row;
			for (int i =0; i < voCollFamHist.size();i++)
			{
				row = form.grdList().getRows().newRow();
				
				row.setValue(voCollFamHist.get(i));				
				row.setcolRelativeName(voCollFamHist.get(i).getRelativeName());			
				row.setcolRelationship(voCollFamHist.get(i).getRelationship());
				
				row.setcolDiagnosis(voCollFamHist.get(i).getDiagnosisDescriptionIsNotNull() ? voCollFamHist.get(i).getDiagnosisDescription() : NO_CODE_ITEM_SELECTED);
				
				row.setcolAgeOnset(voCollFamHist.get(i).getAgeAtOnset());				
				row.setcolLiving(voCollFamHist.get(i).getRelativeLiving());					
			}
		}
	}	
	/**
	 * populates the data to be stored from the screen into specified FamilyHistoryVo 
	 * @return      void
	 */
	private FamilyHistoryVo populateInstanceData()	
	{
		FamilyHistoryVo voFamHist = form.getLocalContext().getSelectedRecord();
		
		if(voFamHist == null)
			voFamHist = new FamilyHistoryVo();

		voFamHist.setAgeAtDeath(form.ctnFamilyHistory().intAgeDeath().getValue());
		voFamHist.setAgeAtOnset(form.ctnFamilyHistory().intAgeOnset().getValue());
		voFamHist.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voFamHist.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());		//wdev-18559

		IClinicalCodingValue voResult = form.ctnFamilyHistory().customControlCodingItem().getValue();
		if (voResult != null)
		{
			if (voResult.getIClinicalCodingValue() instanceof DiagLiteVo)
			{
				voFamHist.setDiagnosis((DiagLiteVo) voResult.getIClinicalCodingValue());
				voFamHist.setDiagnosisDescription(voResult.getIClinicalCodingValueDescription());
			}
			else
				throw new CodingRuntimeException("DiagLiteVo expected from component");				
				
		}
		else //http://jira/browse/WDEV-3518 - If no description is entered set the equivalent field in the vo to null;
		{
			voFamHist.setDiagnosisDescription(null);
		}
		
		voFamHist.setNotes(form.ctnFamilyHistory().txtNotes().getValue());
		voFamHist.setRelationship(form.ctnFamilyHistory().cbRelationship().getValue());
		if (form.ctnFamilyHistory().dateDOB().getValue() != null)
			voFamHist.setRelativeDOB(new PartialDate(form.ctnFamilyHistory().dateDOB().getValue()));
		else
			voFamHist.setRelativeDOB(null);
		voFamHist.setRelativeLiving(form.ctnFamilyHistory().cbLiving().getValue());
		voFamHist.setRelativeName(form.ctnFamilyHistory().txtRelativeName().getValue());			
		
		if(voFamHist.getAuthoringInformation() == null)
		{
			voFamHist.setAuthoringInformation(form.ctnFamilyHistory().customControlAuthoringInfo().getValue());
		}
		
		voFamHist.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return voFamHist;
	}
	/**
	 * displays the Family History record specified by FamilyHistoryVo
	 * @param voFamHist
	 */
	private void populateInstanceControl(ims.vo.ValueObject refVo)
	{
		clearInstanceControls();
		
		if (refVo != null)
		{
			FamilyHistoryVo voFamHist = (FamilyHistoryVo)refVo;
			
			form.ctnFamilyHistory().txtRelativeName().setValue(voFamHist.getRelativeName());
			
			if (voFamHist.getRelationshipIsNotNull())
				form.ctnFamilyHistory().cbRelationship().setValue(voFamHist.getRelationship());
			
			form.ctnFamilyHistory().customControlCodingItem().setValue(voFamHist);

			if(voFamHist.getAuthoringInformationIsNotNull())
				form.ctnFamilyHistory().customControlAuthoringInfo().setValue(voFamHist.getAuthoringInformation());
			
			if (voFamHist.getRelativeDOBIsNotNull())
				form.ctnFamilyHistory().dateDOB().setValue(voFamHist.getRelativeDOB().toDate());
			else
				form.ctnFamilyHistory().dateDOB().setValue(null);
			
			if (voFamHist.getAgeAtOnsetIsNotNull())
				form.ctnFamilyHistory().intAgeOnset().setValue(voFamHist.getAgeAtOnset());
			else
				form.ctnFamilyHistory().intAgeOnset().setValue(null);
			
			if (voFamHist.getRelativeLivingIsNotNull())
			{
				form.ctnFamilyHistory().cbLiving().setValue(voFamHist.getRelativeLiving());
				if((form.ctnFamilyHistory().cbLiving().getValue() != null) && (form.ctnFamilyHistory().cbLiving().getValue().equals(YesNoUnknown.NO))) //wdev-13396)
				{
					form.ctnFamilyHistory().intAgeDeath().setRequired(true); //wdev-13396
				}
				else
				{
					form.ctnFamilyHistory().intAgeDeath().setRequired(false); //wdev-13396
				}
			}
			else
			{
				form.ctnFamilyHistory().cbLiving().setValue(null);
				form.ctnFamilyHistory().intAgeDeath().setRequired(false); //wdev-13396
			}
				
			if (voFamHist.getAgeAtDeathIsNotNull())
				form.ctnFamilyHistory().intAgeDeath().setValue(voFamHist.getAgeAtDeath());
			else
				form.ctnFamilyHistory().intAgeDeath().setValue(null);
			
			if (voFamHist.getNotesIsNotNull())
				form.ctnFamilyHistory().txtNotes().setValue(voFamHist.getNotes());
			else
				form.ctnFamilyHistory().txtNotes().setValue(null);
				
			form.ctnFamilyHistory().setCollapsed(false);
		}
	}
	/**
	 * gather search criteria and initiate a search
	 * @return void 
	 */
	public void search()
	{
	}
	/**
	 * checks before allowing an new record to be created
	 * @return void 
	 */		
	public boolean allowNew()
	{
		if (form.ctnFamilyHistory().cbRelationship().size() == 0)
		{
			engine.showMessage("The SupportNetworkRelationship lookup must first be populated before this form can be used. ");;
			return false;
		}
		
		return true;
		
	}
	/**
	 * checks before allowing an update
	 * @return void 
	 */	
	public boolean allowUpdate()
	{
		return (form.getLocalContext().getSelectedRecordIsNotNull()); 
	}
	/**
	 * clear list and instance controls
	 * @return void 
	 */		
	public void clear()
	{
		form.grdList().getRows().clear();
		clearInstanceControls();
	}
	/**
	 * gather screen data into local context vo and save updating the local context vo
	 * returns true for successful save
	 * @return boolean
	 * @throws PresentationLogicException 
	 */	
	public boolean save() throws PresentationLogicException
	{
		FamilyHistoryVo voFamHist = populateInstanceData();
		
		//set clinical contact
		if (!voFamHist.getClinicalContactIsNotNull())
			voFamHist.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
				
		//validate Vo
		String[] arrErrors =  voFamHist.validate(validateUIRules());	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.save(voFamHist));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		return true;
	}
	/**
	 * 
	 * @return void 
	 */	
	public void initialize() throws FormOpenException
	{		
	}
	public void newInstance() throws PresentationLogicException
	{
		if (allowNew())
		{
			// initalise the screen for a new record
			form.getLocalContext().setSelectedRecord(new FamilyHistoryVo());
			clearInstanceControls();
			form.ctnFamilyHistory().setCollapsed(false);
			//set the form mode

			form.setMode(FormMode.EDIT);

			// Enable Diagnosis and Relationship
			form.ctnFamilyHistory().cbRelationship().setEnabled(true);
			//set any control status specific this form	
			form.ctnFamilyHistory().customControlAuthoringInfo().initializeComponent();
			form.ctnFamilyHistory().setcustomControlAuthoringInfoEnabled(true);
		}	
	}
	/**
	 * called from context menus and update button for initiating an update
	 * @return void 
	 */	
	public void updateInstance() 
	{
		if (allowUpdate())
		{
			form.setMode(FormMode.EDIT);
			form.ctnFamilyHistory().cbRelationship().setEnabled(false);
			form.ctnFamilyHistory().setcustomControlAuthoringInfoEnabled(false);
		}
	}
	/**
	 * called to populate the screen with List and Instance Data in the occurance of opening a form,canceling a new or update and staleobject exception.
	 * @return      void
	 */	
	public void open() throws PresentationLogicException	
	{
		if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			populateListControl(domain.list(null, form.getGlobalContext().Core.getPatientShort()));
		
		//set selection back
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			// Select row kept in local context
			form.grdList().setValue(form.getLocalContext().getSelectedRecord());
			// Update local context
			form.getLocalContext().setSelectedRecord((FamilyHistoryVo) form.grdList().getValue());
			
			//need to get timestamp from record retrieved from List call.
			GenForm.grdListRow row = form.grdList().getRowByValue(form.getLocalContext().getSelectedRecord());
			if (row != null && row.getValue() != null && row.getValue() instanceof FamilyHistoryVo)
			{			
				form.getLocalContext().setSelectedRecord((FamilyHistoryVo)row.getValue());
				form.grdList().setValue(form.getLocalContext().getSelectedRecord());
				populateInstanceControl(form.grdList().getValue());
			}
			else
				clearInstanceControls();
			updateControlsState();			
		}
		else		
			form.ctnFamilyHistory().setCollapsed(true);
		
		preSelectSavedFamilyHistory();
		
		//WDEV-15463
		if(form.grdList().getValue() != null)
			form.ctnFamilyHistory().setCollapsed(false);
		else
			form.ctnFamilyHistory().setCollapsed(true);
		
		form.setMode(FormMode.VIEW);
		
	}	
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onFormOpen()
	 */
	protected void onFormOpen() throws PresentationLogicException
	{		
		initializeCustomControl();
		open();
	}	
	private void initializeCustomControl() 
	{
		form.ctnFamilyHistory().customControlCodingItem().setCodingItemType(CodingItemType.FAMILY_HISTORY);
		form.ctnFamilyHistory().customControlCodingItem().setHotlist(new Boolean(false));
		form.ctnFamilyHistory().customControlCodingItem().setIsRequired(true);	
		form.ctnFamilyHistory().customControlAuthoringInfo().setIsRequiredPropertyToControls(true);
	}

	/*
	 * updates the context menus and other dependant screen controls
	 * @see ims.clinical.forms.familyhistory.Handlers#onFormModeChanged()
	 */
	protected void onFormModeChanged()
	{
		updateControlsState(); 
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onBtnSaveClick()
	 */
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{		
		if (save())
			open();			
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onBtnCancelClick()
	 */
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onGridDetailsSelectionChanged()
	 */
	protected void onGridDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		selectionChanged();
	}

	private void selectionChanged()
	{
		//Display Panel and detail
		form.getLocalContext().setSelectedRecord((FamilyHistoryVo)form.grdList().getValue());
		populateInstanceControl(form.grdList().getValue());
		updateControlsState();
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onContextMenuItemClick(int, ims.framework.Control)
	 */
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{		
		if (menuItemID == form.getContextMenus().getLIPNewItem().getID())
			newInstance();
		else if (menuItemID == form.getContextMenus().getLIPUpdateItem().getID())
			updateInstance();
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onFormDialogClosed(ims.framework.FormName, ims.framework.enumerations.DialogResult)
	 */
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
	}

	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onCbLivingValueChanged()
	 */	
	protected void onCbLivingValueChanged() throws PresentationLogicException
	{
		setAgeDeathEnableStatus();
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onBtnUpdateClick()
	 */
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{		
		updateInstance();		
	}
	/*
	 * @see ims.clinical.forms.familyhistory.Handlers#onBtnNewClick()
	 */
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		newInstance();
	}
	private void preSelectSavedFamilyHistory()
	{
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			boolean rowSelected = false;
			for (int i = 0; i < form.grdList().getRows().size(); i++)
			{
				if (form.grdList().getRows().get(i).getValue().equals(form.getLocalContext().getSelectedRecord()))
				{
					form.grdList().setValue(form.grdList().getRows().get(i).getValue());
					rowSelected = true;
					break;
				}
			}
			if (rowSelected)
				selectionChanged();
		}
	}


}
