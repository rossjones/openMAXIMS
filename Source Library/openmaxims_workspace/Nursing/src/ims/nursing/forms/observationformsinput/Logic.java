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
// This code was generated by Callum Wells using IMS Development Environment (version 1.18 build 40702.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.observationformsinput;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.nursing.vo.ObservationForm;

public class Logic extends BaseLogic
{
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form event handlers
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen() throws FormOpenException
	{
		if (form.getGlobalContext().Core.getCurrentCareContext() == null)
			throw new FormOpenException("Please select a Care Context.");
		
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
		if (formName.equals(form.getForms().Core.OkDialog))
			engine.close(DialogResult.OK);		
	}

	@Override
	protected void onBSavClick() throws ims.framework.exceptions.PresentationLogicException
	{		
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}

	@Override
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onCheckBoxCompleteValueChanged() throws PresentationLogicException
	{
		populateDefaultCompleteData();
		
		updateControlsState();
	}


	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------


	private void open()
	{	
		//setMode(false);
		ObservationForm formsCommenced = form.getGlobalContext().COE.getFormCommenced();
		
		// Populate controls with record data
		populateInstanceControlsFromData(formsCommenced);
		
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);
	}

	private void clearInstanceControls()
	{
		form.dteStartDate().setValue(null);
		form.tmeStartTime().setValue(null);
		
		form.qmbStartHCP().clear();
		
		form.comboBoxForms().setValue(null);
		form.textBoxDetails().setValue(null);
		
		form.checkBoxComplete().setValue(Boolean.FALSE);
		
		form.dteStopDate().setValue(null);
		form.tmeStopTime().setValue(null);
		
		form.qmbStopHCP().clear();
	}
	
	private boolean save()
	{
		try
		{
			ObservationForm formCommenced;
			
			if (form.getGlobalContext().COE.getFormCommenced() == null)
				formCommenced = populateDataFromInstanceControls(null);
			else
				formCommenced = populateDataFromInstanceControls((ObservationForm) form.getGlobalContext().COE.getFormCommenced().clone());

			String[] errors = formCommenced.validate(validateUI());
			if (errors != null)
			{
				engine.showErrors(errors);
				return false;
			}

			form.getGlobalContext().COE.setFormCommenced(domain.saveFormsCommenced(formCommenced));
			return true;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
	}

	private String[] validateUI()
	{
		ArrayList<String> errorList = new ArrayList<String>();

		if (form.checkBoxComplete().getValue())
		{
			if (form.dteStopDate().getValue() == null || form.tmeStopTime().getValue() == null)
			{
				errorList.add("Stop date and time are mandatory");
			}
			
			if (form.dteStartDate().getValue() != null && form.tmeStartTime().getValue() != null
				&& form.dteStopDate().getValue() != null && form.tmeStopTime().getValue() != null)
			{
				if (new DateTime(form.dteStartDate().getValue(), form.tmeStartTime().getValue()).isGreaterThan(new DateTime(form.dteStopDate().getValue(), form.tmeStopTime().getValue())))
				{
					errorList.add("Stop date/time can not be set before start date/time.");
				}
			}
		}
		
		return errorList.toArray(new String[errorList.size()]);
	}

	private void populateDefaultCompleteData()
	{
		form.dteStopDate().setValue(new Date());
		form.tmeStopTime().setValue(new Time());
		
		form.qmbStopHCP().clear();
		
		HcpLiteVo userHCP = (HcpLiteVo) domain.getHcpLiteUser();
		
		if (userHCP != null)
		{
			form.qmbStopHCP().newRow(userHCP, userHCP.toString());
			form.qmbStopHCP().setValue(userHCP);
		}
	}

	private void updateControlsState()
	{
		form.dteStopDate().setEnabled(true);
		form.tmeStopTime().setEnabled(true);
		form.qmbStopHCP().setEnabled(false);

		form.dteStopDate().setVisible(form.checkBoxComplete().getValue());
		form.tmeStopTime().setVisible(form.checkBoxComplete().getValue());
		form.lblStopDate().setVisible(form.checkBoxComplete().getValue());
		
		form.qmbStopHCP().setVisible(form.checkBoxComplete().getValue());
		form.lblBy().setVisible(form.checkBoxComplete().getValue());
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Functions used to exchange data between screen and data layer
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------

	private void populateInstanceControlsFromData(ObservationForm formsCommenced)
	{
		// Clear instance controls
		clearInstanceControls();
		

		// Populate controls with default values
		if (formsCommenced == null)
		{
			form.dteStartDate().setValue(new Date());
			form.tmeStartTime().setValue(new Time());
			
			HcpLiteVo userHCP = (HcpLiteVo) domain.getHcpLiteUser();
			
			if (userHCP != null)
			{
				form.qmbStartHCP().newRow(userHCP, userHCP.toString());
				form.qmbStartHCP().setValue(userHCP);
			}
			
			return;
		}
		
		// Populate controls with data from record
		form.dteStartDate().setValue(formsCommenced.getDateTimeStart().getDate());
		form.tmeStartTime().setValue(formsCommenced.getDateTimeStart().getTime());

		if (formsCommenced.getHCPStart() != null)
		{
    		form.qmbStartHCP().newRow(formsCommenced.getHCPStart(), formsCommenced.getHCPStart().toString());
    		form.qmbStartHCP().setValue(formsCommenced.getHCPStart());
		}
		
		form.comboBoxForms().setValue(formsCommenced.getFormType());
		form.textBoxDetails().setValue(formsCommenced.getDetails());
		
		if (Boolean.TRUE.equals(formsCommenced.getIsStopped()))
		{
			form.checkBoxComplete().setValue(formsCommenced.getIsStopped());
			
			form.dteStopDate().setValue(formsCommenced.getDateTimeStop().getDate());
			form.tmeStopTime().setValue(formsCommenced.getDateTimeStop().getTime());
			
			if (formsCommenced.getHCPStop() != null)
			{
				form.qmbStopHCP().newRow(formsCommenced.getHCPStop(), formsCommenced.getHCPStop().toString());
				form.qmbStopHCP().setValue(formsCommenced.getHCPStop());
			}
		}
	}


	private ObservationForm populateDataFromInstanceControls(ObservationForm formCommenced)
	{
		if (formCommenced == null)
		{
			formCommenced = new ObservationForm();
			
			formCommenced.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			formCommenced.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		}
		
		formCommenced.setDateTimeStart(new DateTime(form.dteStartDate().getValue(), form.tmeStartTime().getValue()));
		formCommenced.setHCPStart(form.qmbStartHCP().getValue());
		
		formCommenced.setFormType(form.comboBoxForms().getValue());
		formCommenced.setDetails(form.textBoxDetails().getValue());
		
		formCommenced.setIsStopped(form.checkBoxComplete().getValue());
		
		if (form.checkBoxComplete().getValue())
		{
			formCommenced.setDateTimeStop(new DateTime(form.dteStopDate().getValue(), form.tmeStopTime().getValue()));
			formCommenced.setHCPStop(form.qmbStopHCP().getValue());
		}
		else
		{
			formCommenced.setDateTimeStop(null);
			formCommenced.setHCPStop(null);
		}
		
		return formCommenced;
	}
}
