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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40707.1600)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.assessbladdermanagement;

import ims.framework.enumerations.DialogResult;
import ims.nursing.vo.BladderManagement;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		// See if there is an existing pain medication VO to display
		BladderManagement man = form.getGlobalContext().Nursing.getBladderManagement();
		if (man != null)
		{
			form.comboBoxMethod().setValue(man.getMethod());
			form.comboBoxType().setValue(man.getType());
			form.dateInserted().setValue(man.getDateInserted());
			form.dateNextChange().setValue(man.getDateNextChange());
			form.intBoxSize().setValue(man.getSize());
			form.getLocalContext().setManage(man);
		}
	}
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
		BladderManagement man = form.getLocalContext().getManage();
		if (man == null)
			man = new BladderManagement();
		man.setDateInserted(form.dateInserted().getValue());
		man.setDateNextChange(form.dateNextChange().getValue());
		man.setType(form.comboBoxType().getValue());
		man.setMethod(form.comboBoxMethod().getValue());
		man.setSize(form.intBoxSize().getValue());
		
		if (form.chkInactive().getValue())
			man.setIsCurrentlyActive(Boolean.FALSE);
		else
			man.setIsCurrentlyActive(Boolean.TRUE);
		
		String[] errors = man.validate();
		if (errors != null && errors.length >0 )
		{
			engine.showErrors(errors);
			return;
		}
		form.getGlobalContext().Nursing.setBladderManagement(man);
		engine.close(DialogResult.OK);
	}
}
