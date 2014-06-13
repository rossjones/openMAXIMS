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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4694.23489)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.forms.dementiacolourconfig;

import ims.admin.vo.DementiaColourConfigVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	} 
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		DementiaColourConfigVo voColourConfig = populateDataFromScreen(form.getGlobalContext().Admin.getSelectedDementiaColourConfig());
		
		String[] errors = voColourConfig.validate(getUIErrors());
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return ;
		}
		
		form.getGlobalContext().Admin.setSelectedDementiaColourConfig(voColourConfig);
		engine.close(DialogResult.OK);
	}
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.intFromHours().getValue()!=null && form.intToHours().getValue()!=null && form.intFromHours().getValue().intValue()>=form.intToHours().getValue().intValue())
		{
			errors.add("'Start(hours)' should be less than 'End (hours)'!");
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	
	private DementiaColourConfigVo populateDataFromScreen(DementiaColourConfigVo voColourConfig)
	{
		if (voColourConfig==null)
			voColourConfig=new DementiaColourConfigVo();
		else
			voColourConfig=(DementiaColourConfigVo)voColourConfig.clone();
		
		voColourConfig.setFromHours(form.intFromHours().getValue());
		voColourConfig.setToHours(form.intToHours().getValue());
		voColourConfig.setWorklistEntryColour(form.cmbColour().getValue());
		
		return voColourConfig;
		
	}
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		populateColourCombo();
		clear();
		
		DementiaColourConfigVo voColourConfig = form.getGlobalContext().Admin.getSelectedDementiaColourConfig();
		
		if (voColourConfig==null)
			return;
		
		form.intFromHours().setValue(voColourConfig.getFromHoursIsNotNull()?voColourConfig.getFromHours():null);
		form.intToHours().setValue(voColourConfig.getToHoursIsNotNull()?voColourConfig.getToHours():null);
		form.cmbColour().setValue(voColourConfig.getWorklistEntryColourIsNotNull()?voColourConfig.getWorklistEntryColour():null);
		
	}
	
	private void populateColourCombo()
	{
		Color[] ca = Color.getAllColors();
		for (int i = 0; i < ca.length; i++)
		{
			form.cmbColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());
		}
	}
	private void clear()
	{
		form.intFromHours().setValue(null);
		form.intToHours().setValue(null);
		form.cmbColour().setValue(null);
	}
}