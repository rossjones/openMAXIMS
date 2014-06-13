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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.22 build 50307.1630)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.forms.profilesslotgeneric;

import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.vo.ServiceFunctionRefVo;
import ims.core.clinical.vo.ServiceFunctionRefVoCollection;
import ims.core.vo.ActivityVoCollection;
import ims.core.vo.ServiceFunctionLiteVo;
import ims.core.vo.ServiceFunctionLiteVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Time;
import ims.scheduling.forms.profilesslotgeneric.GenForm.grdClinicTypesRow;
import ims.scheduling.forms.profilesslotgeneric.GenForm.grdDOSRow;
import ims.scheduling.vo.DirectoryOfServiceVoCollection;
import ims.scheduling.vo.DirectoryofServiceRefVoCollection;
import ims.scheduling.vo.Profile_ListOwnerVo;
import ims.scheduling.vo.Profile_ListOwnerVoCollection;
import ims.scheduling.vo.Profile_SlotGenericVo;
import ims.scheduling.vo.SlotDirectoryOfServiceVo;
import ims.scheduling.vo.SlotDirectoryOfServiceVoCollection;
import ims.scheduling.vo.domain.Profile_SlotGenericVoAssembler;
import ims.scheduling.vo.lookups.SchedCABSlotType;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{	
		if(form.getGlobalContext().Scheduling.getProfileEndTimeIsNotNull())
			form.lblProfileEndTime().setValue(form.getGlobalContext().Scheduling.getProfileEndTime().toString());
	
		Profile_SlotGenericVo voSlot = form.getGlobalContext().Scheduling.getProfileSlotGeneric();
		
		//WDEV-12039
		form.getLocalContext().setProfileSlotVo(new Profile_SlotGenericVo());
		Profile_SlotGenericVoAssembler.copy(form.getLocalContext().getProfileSlotVo(), voSlot);
			
		loadActivities();

		if(ConfigFlag.DOM.SCHEDULING_SLOTS_CREATION.getValue().equals("Choose and Book"))
			loadDosGrid();
		
		loadListownerCombo();

		setControlStateByConfig();
		
		if (voSlot != null)
		{
			this.populateScreenFromData(voSlot);
			if(voSlot.getID_Profile_Slot() == null && voSlot.getIsActive() == null)
				form.chkActive().setValue(true);

		}
		
		cmbTypeValueChanged();
	}
	
	private void setControlStateByConfig()
	{
		if(ConfigFlag.DOM.SCHEDULING_SLOTS_CREATION.getValue().equals("Local Only"))
		{
			form.cmbType().setValue(SchedCABSlotType.LOCAL);
			form.lblType().setVisible(false);
			form.cmbType().setVisible(false);
			cmbTypeValueChanged();
			
			form.lblDos().setVisible(false);
			form.grdDOS().setVisible(false);
		}
		else
		{			
			form.ctnFunctionality().setVisible(false);
			form.grdDOS().setReadOnly(false);
		}
	}

	private void loadActivities()
	{
		ActivityVoCollection activities = domain.listActivities();	
		for (int i=0; i< activities.size(); i++)
			form.cmbActivity().newRow(activities.get(i),activities.get(i).getName());			
	}

	private void loadDosGrid() 
	{
		DirectoryOfServiceVoCollection voCollDirService = form.getGlobalContext().Scheduling.getDirectoryofServicesCollection();
		if(voCollDirService == null)
			return;
		
		for(int i=0;i<voCollDirService.size();i++)
		{
			grdDOSRow row = form.grdDOS().getRows().newRow();
			row.setColDOS(voCollDirService.get(i));
		}
	}

	private void loadListownerCombo() 
	{
		if (!form.getGlobalContext().Scheduling.getListOwnerCollectionIsNotNull())
			return;
		Profile_ListOwnerVoCollection voColl = form.getGlobalContext().Scheduling.getListOwnerCollection();
		
		for(int i=0;i<voColl.size();i++)
		{
			Profile_ListOwnerVo vo = voColl.get(i);
			if(vo.getHCP() != null && vo.getHCP().getName() != null)
				form.cmbSlotResp().newRow(vo, vo.getHCP().getName().toString());
		}
	}

	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Profile_SlotGenericVo voSlot = form.getGlobalContext().Scheduling.getProfileSlotGeneric();
		voSlot = this.populateDataFromScreen(voSlot);					
		String[] arrErrors = voSlot.validate(getUIValidation(voSlot));
		if(arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
		
		if(!validateUI())
			return;
		
		form.getGlobalContext().Scheduling.setProfileSlotGeneric(voSlot);
		engine.close(DialogResult.OK);
	}
	
	private String[] getUIValidation(Profile_SlotGenericVo voSlot)
	{
		List<String> errors = new ArrayList<String>();
		
		if(voSlot.getTypeIsNotNull())
		{
			if(!voSlot.getType().equals(SchedCABSlotType.LOCAL))
			{
				if(voSlot.getDirectoryOfService() == null || voSlot.getDirectoryOfService().size() == 0)
					errors.add("Directory of Service must be selected for a non-local slot.");
			}
		}
			
		return errors.size() > 0 ? errors.toArray(new String[0]) : null;
	}

	private boolean validateUI()
	{
		List<String> errors = new ArrayList<String>();
		
		if(form.timStart().getValue() != null && form.getGlobalContext().Scheduling.getProfileStartTimeIsNotNull())
			if(form.timStart().getValue().isLessThan(form.getGlobalContext().Scheduling.getProfileStartTime()))
				errors.add("Start Time of Slot ( " + form.timStart().getValue().toString() +  " ) cannot be before Profile Start Time ( " + form.getGlobalContext().Scheduling.getProfileStartTime() + " )");
		
		if(form.timStart().getValue() != null && form.getGlobalContext().Scheduling.getProfileEndTime() != null && form.timStart().getValue().isGreaterThan(form.getGlobalContext().Scheduling.getProfileEndTime()))
			errors.add("Start Time of Slot ( " + form.timStart().getValue().toString() +  " ) cannot exceed Profile End Time ( " + form.getGlobalContext().Scheduling.getProfileEndTime() + " )");
		else if(!isSlotEndTimeLessThanProfileEndTime())
			errors.add("End Time of Slots ( " + calculateEndTime() +  " ) cannot exceed Profile End Time ( " + form.getGlobalContext().Scheduling.getProfileEndTime() + " )");

		String[] arrErrors = errors.toArray(new String[0]);
		if(arrErrors.length > 0)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		return true;
	}

	private String calculateEndTime()
	{
		Time endTime = new Time();
		endTime = (Time) form.timStart().getValue().clone();
		endTime.addMinutes(form.intNoSlots().getValue() * form.intSlotInterval().getValue());
		return endTime.toString();
	}

	private boolean isSlotEndTimeLessThanProfileEndTime()
	{	
		int availableMins = 0;
		if(form.getGlobalContext().Scheduling.getProfileEndTimeIsNotNull())
		{
			if(form.getGlobalContext().Scheduling.getProfileEndTime().isGreaterThan(form.timStart().getValue()))
				availableMins = form.getGlobalContext().Scheduling.getProfileEndTime().getTotalMinutes() - form.timStart().getValue().getTotalMinutes();
		}
	
		int requiredMins = form.intNoSlots().getValue() * form.intSlotInterval().getValue();		
		return requiredMins <= availableMins;
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-12039 undo the changes
		form.getGlobalContext().Scheduling.setProfileSlotGeneric(Profile_SlotGenericVoAssembler.copy( form.getGlobalContext().Scheduling.getProfileSlotGeneric() , form.getLocalContext().getProfileSlotVo()));
		engine.close(DialogResult.CANCEL);
	}
	
	protected void clearScreen()
	{
		form.intDeallocateNumber().setValue(null);
		form.chkActive().setValue(false);
		form.intSlotInterval().setValue(null);
		form.timStart().setValue(null);
		form.cmbActivity().setValue(null);
		form.intNoSlots().setValue(null);
		form.cmbPriority().setValue(null);
		form.intNoInst().setValue(null);
	}

	protected void onCmbTypeValueChanged() throws PresentationLogicException
	{
		cmbTypeValueChanged();
	}

	private void cmbTypeValueChanged()
	{
		boolean isLocalSelected = false;
		if(form.cmbType().getValue() != null && form.cmbType().getValue().equals(SchedCABSlotType.LOCAL))
			isLocalSelected = true;
			
		form.intDeallocateNumber().setVisible(!isLocalSelected);
		form.lblDeallocate().setVisible(!isLocalSelected);
		form.lblDays().setVisible(!isLocalSelected);
		
		if(form.cmbType().getValue() != null)
		{
			if(form.cmbType().getValue().equals(SchedCABSlotType.LOCAL))
			{
				form.grdDOS().setVisible(false);
				form.lblDos().setVisible(false);
				ServiceFunctionLiteVoCollection voCollServiceFunctions = domain.listServiceFunctionByService(form.getGlobalContext().Scheduling.getProfileService());
				prepopulateClinicTypeGrid(voCollServiceFunctions, false);		
			}
			else if(form.cmbType().getValue().equals(SchedCABSlotType.BOTH) || form.cmbType().getValue().equals(SchedCABSlotType.CAB))
			{
				form.grdDOS().setVisible(true);
				form.lblDos().setVisible(true);
				DirectoryofServiceRefVoCollection voCollDos = getSelectedDOSs();
				if(voCollDos != null)
				{
					ServiceFunctionLiteVoCollection voCollServiceFunctions = domain.listServiceFunctionByDOSs(voCollDos);
					prepopulateClinicTypeGrid(voCollServiceFunctions, true);
				}
				else
					form.grdClinicTypes().getRows().clear();
			}
		}
		else
		{
			prepopulateClinicTypeGrid(null, false);
			form.grdDOS().setVisible(false);
			form.lblDos().setVisible(false);
		}
		
		populateSelecetdClinicTypesFromData(form.getGlobalContext().Scheduling.getProfileSlotGeneric());
	}
	
	/**
	 * load the config data
	 * @param bSelectAll 
	 */
	private void prepopulateClinicTypeGrid(ServiceFunctionLiteVoCollection voCollServiceFunctions, boolean bSelectAll)
	{
		form.grdClinicTypes().getRows().clear();
	
		if(voCollServiceFunctions == null)
			return;
	
		form.grdClinicTypes().setReadOnly(bSelectAll);
		for(ServiceFunctionLiteVo voServiceFunction : voCollServiceFunctions)
		{
			grdClinicTypesRow row = form.grdClinicTypes().getRows().newRow();
			row.setColClinicType((voServiceFunction != null && voServiceFunction.getFunctionIsNotNull()) ? voServiceFunction.getFunction().getText() : null);
			row.setColSelect(bSelectAll);
			row.setValue(voServiceFunction);
		}
	}

	private DirectoryofServiceRefVoCollection getSelectedDOSs()
	{
		DirectoryofServiceRefVoCollection voCollDos = new DirectoryofServiceRefVoCollection();
		for(int i=0;i<form.grdDOS().getRows().size(); i++)
		{
			grdDOSRow row = form.grdDOS().getRows().get(i); 
			if(row.getColSelect())
				voCollDos.add(row.getColDOS());
		}
		return voCollDos.size() > 0 ? voCollDos : null;
	}

	protected Profile_SlotGenericVo populateDataFromScreen(Profile_SlotGenericVo value)
	{
		value = super.populateDataFromScreen(value);
		
		SlotDirectoryOfServiceVoCollection voCollSlotDos = new SlotDirectoryOfServiceVoCollection();	
		for(int i=0;i<form.grdDOS().getRows().size();i++)
		{
			grdDOSRow row = form.grdDOS().getRows().get(i);
			if(row.getColSelect())
			{			
				SlotDirectoryOfServiceVo voSlotDos = row.getValue();
				if(voSlotDos == null)
					voSlotDos = new SlotDirectoryOfServiceVo();
				
				voSlotDos.setDirectoryOfService(row.getColDOS());
				voCollSlotDos.add(voSlotDos);
			}		
		}
		value.setDirectoryOfService(voCollSlotDos);
		
		ServiceFunctionRefVoCollection voCollServFunc = new ServiceFunctionRefVoCollection();
		for(int i=0;i<form.grdClinicTypes().getRows().size();i++)
		{
			grdClinicTypesRow row = form.grdClinicTypes().getRows().get(i);
			if(row.getColSelect())
			{			
				ServiceFunctionRefVo voServFunc = row.getValue();				
				voCollServFunc.add(voServFunc);
			}		
		}
		value.setFunctions(voCollServFunc);
		
		return value;
	}

	protected void populateScreenFromData(Profile_SlotGenericVo value)
	{
		super.populateScreenFromData(value);
		
		if(value.getDirectoryOfServiceIsNotNull() && value.getDirectoryOfService().size() > 0)
		{
			for(SlotDirectoryOfServiceVo item : value.getDirectoryOfService())
			{
				grdDOSRow row;
				for(int i=0;i<form.grdDOS().getRows().size();i++)
				{
					row = form.grdDOS().getRows().get(i);
					if(row.getColDOS().equals(item.getDirectoryOfService()))
					{
						row.setColSelect(true);
						row.setValue(item);
					}
				}	
			}
			
			
			//add in the itens that were not added because they were removed from the profile without removing from slot
			for(SlotDirectoryOfServiceVo item : value.getDirectoryOfService())
			{
				if(!form.grdDOS().getValues().contains(item))
				{
					grdDOSRow row = form.grdDOS().getRows().newRow();
					row.setColDOS(item.getDirectoryOfService());
					row.setColSelect(true);
				}
			}
		}
		
		populateSelecetdClinicTypesFromData(value);
	}

	private void populateSelecetdClinicTypesFromData(Profile_SlotGenericVo value)
	{
		if(value == null)
			return;
		
		if(value.getFunctionsIsNotNull() && value.getFunctions().size() > 0)
		{
			for(ServiceFunctionRefVo item : value.getFunctions())
			{
				grdClinicTypesRow row;
				for(int i=0;i<form.grdClinicTypes().getRows().size();i++)
				{
					row = form.grdClinicTypes().getRows().get(i);
					if(row.getValue().equals(item))
					{
						row.setColSelect(true);
					}
				}	
			}
		}
	}
	
	protected void onImbCalculateClick() throws PresentationLogicException
	{
		Time startTime = form.timStart().getValue();
		Time endTime = form.getGlobalContext().Scheduling.getProfileEndTime();

		//this is mandatory for dialog
		if(form.getGlobalContext().Scheduling.getProfileEndTime() == null)
			return;
		
		if(startTime == null || (form.intSlotInterval().getValue() == null || form.intSlotInterval().getValue() == 0))
		{
			engine.showErrors(new String[] {"Start Time and Slot Interval need to be provided for calculation"});
			return;
		}
		
		int iDuration = form.intSlotInterval().getValue();
		
		int iTime = endTime.getTotalMinutes() - startTime.getTotalMinutes(); 
		form.intNoSlots().setValue(iTime/iDuration);
	}

	@Override
	protected void onGrdDOSGridCheckBoxClicked(int column, grdDOSRow row, boolean isChecked) throws PresentationLogicException
	{
		cmbTypeValueChanged();
	}
}
