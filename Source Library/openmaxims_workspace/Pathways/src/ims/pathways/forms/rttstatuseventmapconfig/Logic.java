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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.pathways.forms.rttstatuseventmapconfig;

import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.pathways.forms.rttstatuseventmapconfig.GenForm.grdResultsRow;
import ims.pathways.vo.EventLiteVoCollection;
import ims.pathways.vo.RTTStatusEventMapVo;
import ims.pathways.vo.RTTStatusEventMapVoCollection;
import ims.pathways.vo.RTTStatusPointVo;
import ims.pathways.vo.RTTStatusPointVoCollection;
import ims.pathways.vo.lookups.AdminEventOutcomeCollection;
import ims.pathways.vo.lookups.EventEncounterType;
import ims.pathways.vo.lookups.LookupHelper;
import ims.scheduling.vo.lookups.ApptOutcomeCollection;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	private void updateControlsState()
	{
		form.btnUpdate().setVisible(form.getMode().equals(FormMode.VIEW)&& form.grdResults().getValue() != null);
		form.ctnDetails().setCollapsed( !(FormMode.EDIT.equals(form.getMode()) || form.grdResults().getValue() != null));
		form.getContextMenus().Pathways.getRTTSTatusEventMapConfigNEWItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().Pathways.getRTTSTatusEventMapConfigEDITItem().setVisible(form.getMode().equals(FormMode.VIEW)&& form.grdResults().getValue() != null);
		form.ctnDetails().cmbEncounterInstance().setRequired(FormMode.EDIT.equals(form.getMode()) && form.ctnDetails().cmbCurrentRTTStat().getValue() == null);
		form.ctnDetails().cmbCurrentRTTStat().setRequired(FormMode.EDIT.equals(form.getMode()) && form.ctnDetails().cmbEncounterInstance().getValue() == null);
		//WDEV-18434
		form.ctnDetails().cmbTargetRTTStat().setRequired(FormMode.EDIT.equals(form.getMode()) && form.ctnDetails().cmbEncounterInstance().getValue() != null);
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	private void open()
	{
		if (form.getLocalContext().getSelectedRecord() != null)
		{	
			form.getLocalContext().setSelectedRecord(domain.getRTTStatusPointToEvent(form.getLocalContext().getSelectedRecord()));
			form.grdResults().setValue(form.getLocalContext().getSelectedRecord());
		}
		search(false);
		populateInstanceControls(form.grdResults().getValue());
		
		form.setMode(FormMode.VIEW);

	}
	private void initialize()
	{
		loadRTTStatusPointsData();
		populateEncounterInstanceCombo();
		form.chkActiveSearch().setValue(Boolean.TRUE);
	}

	private void loadRTTStatusPointsData()
	{
		RTTStatusPointVoCollection coll = domain.listRTTStatusPoints();

		if (coll == null || (coll != null && coll.size()== 0)) 						
			return;   

		for (int i=0;i<coll.size();i++)
		{	 
			RTTStatusPointVo rttStat = coll.get(i);
			if (rttStat == null)
				continue;
			form.cmbCurrentRTTStatusSearch().newRow(rttStat.getNationalCode(), rttStat.getNationalCode().toString());
			form.cmbTargetRTTStatusSearch().newRow(rttStat.getNationalCode(), rttStat.getNationalCode().toString());
			
			form.ctnDetails().cmbCurrentRTTStat().newRow(rttStat,(rttStat.getNationalCodeIsNotNull() ? rttStat.getNationalCode().toString() : "") + " - " + (rttStat.getDescriptionIsNotNull() ? rttStat.getDescription().toString() : ""));
			form.ctnDetails().cmbTargetRTTStat().newRow(rttStat,(rttStat.getNationalCodeIsNotNull() ? rttStat.getNationalCode().toString() : "") + " - " + (rttStat.getDescriptionIsNotNull() ? rttStat.getDescription().toString() : ""));
		}
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{	
			if (form.ctnDetails().qmbEvent().getValue() != null && form.ctnDetails().cmbTargetRTTStat().getValue() != null && form.ctnDetails().cmbTargetRTTStat().getValue().getNationalCode() != null)
			{
				String prefix = "3";
				if (form.ctnDetails().cmbTargetRTTStat().getValue().getNationalCode().toString().startsWith(prefix) && Boolean.FALSE.equals(form.ctnDetails().qmbEvent().getValue().getStopsClock()))
					engine.showMessage("You have selected to map a Target RTT Status Point that stops the pathway clock to '" + form.ctnDetails().qmbEvent().getValue().toString()+ "' pathway event. \rPlease make sure you configure the '" + form.ctnDetails().qmbEvent().getValue().toString() + "' event to stop the pathway clock as well. " , "WARNING!", MessageButtons.OK, MessageIcon.WARNING);
			}	
			open();
		}	
	}
	private boolean save()
	{
		RTTStatusEventMapVo statusPointEventVo = populateDataFromScreen(form.getLocalContext().getSelectedRecord());

		String[] errors = statusPointEventVo.validate(validateUIRules());

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			form.getLocalContext().setSelectedRecord(domain.saveRTTStatusPointEvent(statusPointEventVo));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 

		return true;
	}

	private RTTStatusEventMapVo populateDataFromScreen(RTTStatusEventMapVo rttStatusEventVo)
	{	
		if (rttStatusEventVo == null)
			rttStatusEventVo = new  RTTStatusEventMapVo();
		else
		{
			rttStatusEventVo = (RTTStatusEventMapVo) rttStatusEventVo.clone();
		}

		rttStatusEventVo.setEvent(form.ctnDetails().qmbEvent().getValue());
		rttStatusEventVo.setEncounterType(form.ctnDetails().cmbEncounterType().getValue());
		rttStatusEventVo.setEncounterInstance(form.ctnDetails().cmbEncounterInstance().getValue());
		rttStatusEventVo.setCurrentRTTStatus(form.ctnDetails().cmbCurrentRTTStat().getValue());
		rttStatusEventVo.setTargetRTTStatus(form.ctnDetails().cmbTargetRTTStat().getValue());
		rttStatusEventVo.setActive(form.ctnDetails().chkActive().getValue());

		return rttStatusEventVo;
	}
	private String[] validateUIRules()
	{
		ArrayList <String>  errors = new ArrayList <String>();
		//WDEV-18434 
		if (form.ctnDetails().cmbEncounterInstance().getValue() == null && form.ctnDetails().cmbCurrentRTTStat().getValue() == null)
		{
			errors.add("Current RTT Status Point is mandatory when Encounter Instance is not specified.");
		}
		
		if (form.ctnDetails().cmbEncounterInstance().getValue() != null && form.ctnDetails().cmbTargetRTTStat().getValue() == null)
		{
			errors.add("Target RTT Status Point is mandatory when Encounter Instance is specified.");
		}
		//-------------
		if (form.ctnDetails().cmbCurrentRTTStat().getValue() == null && form.ctnDetails().cmbEncounterInstance().getValue() == null)
		{
			errors.add("Encounter Instance is mandatory when Current RTT Status Point is not specified.");
		}
		
		String[] sErrors = new String[errors.size()];
		errors.toArray(sErrors);
		return sErrors;

	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onGrdResultsSelectionChanged()
	{
		selectionChanged();
		updateControlsState();
	}

	private void selectionChanged()
	{
		form.getLocalContext().setSelectedRecord(domain.getRTTStatusPointToEvent(form.grdResults().getValue()));
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		updateControlsState();

	}
	private void populateInstanceControls(RTTStatusEventMapVo selectedRecordVo)
	{
		clearInstanceControls();

		if (selectedRecordVo == null)
			return;
		
		if (selectedRecordVo.getEventIsNotNull())
		{	
			form.ctnDetails().qmbEvent().newRow(selectedRecordVo.getEvent(),selectedRecordVo.getEvent().toString());
			form.ctnDetails().qmbEvent().setValue(selectedRecordVo.getEvent());
		}
		
		form.ctnDetails().cmbCurrentRTTStat().setValue(selectedRecordVo.getCurrentRTTStatus());
		populateTargetRTTs(form.ctnDetails().cmbCurrentRTTStat().getValue());
		form.ctnDetails().cmbTargetRTTStat().setValue(selectedRecordVo.getTargetRTTStatus());
		
		form.ctnDetails().cmbEncounterType().setValue(selectedRecordVo.getEncounterType());
		populateEncounterInstanceCombo();
		form.ctnDetails().cmbEncounterInstance().setValue(selectedRecordVo.getEncounterInstance());
								
		form.ctnDetails().chkActive().setValue(selectedRecordVo.getActive());
	}

	private void clearSearchCriteria()
	{
		form.cmbEncounterTypeSearch().setValue(null);
		form.cmbCurrentRTTStatusSearch().setValue(null);
		form.cmbTargetRTTStatusSearch().setValue(null);
		form.chkActiveSearch().setValue(null);
		form.txtNameSearch().setValue(null);
		
	}
	
	private void clearInstanceControls()
	{
		form.ctnDetails().qmbEvent().clear();
		form.ctnDetails().cmbEncounterType().setValue(null);
		form.ctnDetails().cmbCurrentRTTStat().setValue(null);
		form.ctnDetails().cmbTargetRTTStat().clear();
		form.ctnDetails().cmbEncounterInstance().clear();
		form.ctnDetails().cmbEncounterInstance().setValue(null);
		form.ctnDetails().chkActive().setValue(null);
		
	}
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearchCriteria();
		form.getLocalContext().setSelectedRecord(null);
		form.grdResults().getRows().clear();
		clearInstanceControls();
		updateControlsState();
	}

	private void search(boolean fromBtn)
	{
		clearInstanceControls();
		RTTStatusEventMapVoCollection listColl = domain.listRTTEventsMapped(form.cmbEncounterTypeSearch().getValue(), form.cmbCurrentRTTStatusSearch().getValue(), form.cmbTargetRTTStatusSearch().getValue(), form.chkActiveSearch().getValue(), form.txtNameSearch().getValue());

		if (listColl == null || (listColl != null && listColl.size() == 0))
		{	
			engine.showMessage("No records were found matching search criteria entered");
		}
		
		populateResultsGrid(listColl);
		if (fromBtn)
		{
			form.getLocalContext().setSelectedRecord(null);
			form.grdResults().setValue(null);
		}	
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search(true);		
		updateControlsState();
	}
	
	private void populateResultsGrid(RTTStatusEventMapVoCollection coll)
	{
		form.grdResults().getRows().clear();

		for (int i=0;i<coll.size();i++)
		{
			RTTStatusEventMapVo statusEventMapVo = coll.get(i);
			if (statusEventMapVo == null)
				continue;
			grdResultsRow row = form.grdResults().getRows().newRow();
			
			row.setcolEncounterType(statusEventMapVo.getEncounterTypeIsNotNull() ? statusEventMapVo.getEncounterType().getText().toString() : "");
			
			row.setcolEncounter(statusEventMapVo.getEncounterInstanceIsNotNull() ? statusEventMapVo.getEncounterInstance().getText(): "");
						
			row.setcolRTTStatus(statusEventMapVo.getCurrentRTTStatusIsNotNull() ? statusEventMapVo.getCurrentRTTStatus().getNationalCode().toString() + " - " + statusEventMapVo.getCurrentRTTStatus().getDescription() : "");
			row.setCellcolRTTStatusTooltip(statusEventMapVo.getCurrentRTTStatusIsNotNull() ? statusEventMapVo.getCurrentRTTStatus().getNationalCode().toString() + " - " + statusEventMapVo.getCurrentRTTStatus().getDescription() : "");

			row.setcolTargetRTTStatus(statusEventMapVo.getTargetRTTStatusIsNotNull() ? statusEventMapVo.getTargetRTTStatus().getNationalCode().toString() + " - " + statusEventMapVo.getTargetRTTStatus().getDescription() : "");
			row.setCellcolTargetRTTStatusTooltip(statusEventMapVo.getTargetRTTStatusIsNotNull() ? statusEventMapVo.getTargetRTTStatus().getNationalCode().toString() + " - " + statusEventMapVo.getTargetRTTStatus().getDescription() : "");

			row.setcolEvent(statusEventMapVo.getEventIsNotNull() ? statusEventMapVo.getEvent().getName().toString() : "");
			row.setCellcolEventTooltip(statusEventMapVo.getEventIsNotNull() ? statusEventMapVo.getEvent().getName().toString() : "");
			
			row.setValue(statusEventMapVo);
		}	

		form.grdResults().setValue(form.getLocalContext().getSelectedRecord());
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance()
	{
		clearInstanceControls();
		populateTargetRTTs(null);
		form.getLocalContext().setSelectedRecord(null);
		form.grdResults().setValue(null);
		form.setMode(FormMode.EDIT);

	}

	@Override
	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		editInstance();

	}
	private void editInstance()
	{
		form.setMode(FormMode.EDIT);

	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender)throws PresentationLogicException
	{
		switch(menuItemID)
		{
		case GenForm.ContextMenus.PathwaysNamespace.RTTSTatusEventMapConfig.NEW:
			newInstance();
			break;
		case GenForm.ContextMenus.PathwaysNamespace.RTTSTatusEventMapConfig.EDIT:
			editInstance();
			break;
		}
		updateControlsState();

	}
	@Override
	protected void onQmbEventTextSubmited(String value)	throws PresentationLogicException
	{
		form.ctnDetails().qmbEvent().clear();
		populateEvents(value);

	}
	private void populateEvents(String value)
	{
		EventLiteVoCollection eventColl = domain.listEvents(value);

		if (eventColl == null || (eventColl != null && eventColl.size() == 0)) 						
		{                                               
			return;   
		}
		if  (eventColl.size() == 1)							
		{
			form.ctnDetails().qmbEvent().newRow(eventColl.get(0),eventColl.get(0).getName().toString());
			form.ctnDetails().qmbEvent().setValue(eventColl.get(0));
		}
		else
		{
			for (int i=0; i<eventColl.size();i++)
			{
				form.ctnDetails().qmbEvent().newRow(eventColl.get(i), eventColl.get(i).getName().toString());
				form.ctnDetails().qmbEvent().showOpened();
			}
		}
	}

	@Override
	protected void onCmbCurrentRTTStatValueChanged()throws PresentationLogicException
	{
		populateTargetRTTs(form.ctnDetails().cmbCurrentRTTStat().getValue());
		updateControlsState();

	}
	private void populateTargetRTTs(RTTStatusPointVo value)
	{
		form.ctnDetails().cmbTargetRTTStat().clear();
		
		RTTStatusPointVoCollection targetRTTs = domain.listTargetRTTStatusPoints(value);
		
		if (targetRTTs == null || targetRTTs.size() == 0)
			return;
		
		for (int k=0;k<targetRTTs.size();k++)
		{
			if (targetRTTs.get(k) == null)
				continue;
			form.ctnDetails().cmbTargetRTTStat().newRow(targetRTTs.get(k),(targetRTTs.get(k).getNationalCodeIsNotNull() ? targetRTTs.get(k).getNationalCode().toString() : "") + " - " + (targetRTTs.get(k).getDescriptionIsNotNull() ? targetRTTs.get(k).getDescription().toString() : ""));
		}
	}
	@Override
	protected void onCmbEncounterTypeValueChanged()	throws PresentationLogicException
	{
		populateEncounterInstanceCombo();
		updateControlsState();
	}
	
	private void populateEncounterInstanceCombo()
	{
		if (EventEncounterType.CLINICAL_APPOINTMENT.equals(form.ctnDetails().cmbEncounterType().getValue()))
		{
			populateEncounterfromApptOutcome();
		}
		else if (EventEncounterType.ADMIN_EVENT.equals(form.ctnDetails().cmbEncounterType().getValue()))
		{
			populateEncounterfromAdminEventOutcome();
		}
		else
		{
			form.ctnDetails().cmbEncounterInstance().clear();
		}
	}
	private void populateEncounterfromApptOutcome()
	{
		form.ctnDetails().cmbEncounterInstance().clear();
		
		ApptOutcomeCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getApptOutcome(domain.getLookupService());
		
		for(int i = 0; i < lookupCollection.size(); i++)
		{
			form.ctnDetails().cmbEncounterInstance().newRow(lookupCollection.get(i), lookupCollection.get(i).getText(), lookupCollection.get(i).getImage(), lookupCollection.get(i).getTextColor());
		}
		
	}
	private void populateEncounterfromAdminEventOutcome()
	{
		form.ctnDetails().cmbEncounterInstance().clear();
				
		AdminEventOutcomeCollection lookupCollection = LookupHelper.getAdminEventOutcome(domain.getLookupService());
		
		for(int i = 0; i < lookupCollection.size(); i++)
		{
			form.ctnDetails().cmbEncounterInstance().newRow(lookupCollection.get(i), lookupCollection.get(i).getText(), lookupCollection.get(i).getImage(), lookupCollection.get(i).getTextColor());
		}
	}
	@Override
	protected void onCmbEncounterInstanceValueChanged() throws PresentationLogicException
	{
	
		updateControlsState();
	}
}
