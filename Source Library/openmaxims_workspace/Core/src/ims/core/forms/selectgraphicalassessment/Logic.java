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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3453.13770)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.selectgraphicalassessment;

import ims.assessment.vo.GraphicAssessmentShortVo;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.core.forms.selectgraphicalassessment.GenForm.grdGraphicAssessmentsRow;
import ims.framework.MessageButtons;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().ICP.setLinkedGraphicAssessment(null);
		form.getGlobalContext().ICP.setLinkedItem(null);
		form.btnSelect().setEnabled(Boolean.FALSE);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().ICP.setLinkedGraphicAssessment(null);
		form.getGlobalContext().ICP.setLinkedItem(null);
		
		engine.close(DialogResult.CANCEL);		
	}
	@Override
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i=0;i<form.grdGraphicAssessments().getRows().size();i++)
		{
			if (form.grdGraphicAssessments().getRows().get(i).getcolSelect())
			{
				form.getGlobalContext().ICP.setLinkedGraphicAssessment(form.grdGraphicAssessments().getRows().get(i).getValue());
				form.getGlobalContext().ICP.setLinkedItem(form.grdGraphicAssessments().getRows().get(i).getValue());
				form.getGlobalContext().EAS.setTreatmentSiteConfig(form.grdGraphicAssessments().getRows().get(i).getValue());//WDEV-16638
				break;
			}
		}
		if (!form.getGlobalContext().ICP.getLinkedGraphicAssessmentIsNotNull() || !form.getGlobalContext().ICP.getLinkedItemIsNotNull())
		{
			engine.showMessage("Select an Assessment from the Grid", "Message", MessageButtons.OK);
			return;
		}
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.txtName().setValue(null);
		form.grdGraphicAssessments().getRows().clear();
		form.btnSelect().setEnabled(Boolean.FALSE);//WDEV-16949
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
		form.btnSelect().setEnabled(Boolean.FALSE);//WDEV-17478
		
		if (form.txtName().getValue()==null)
		{
			engine.showMessage("Please enter a search criteria", "Message", MessageButtons.OK);
			return;
		}
		form.grdGraphicAssessments().getRows().clear();
		GraphicAssessmentShortVoCollection assessments=null;
		if (form.txtName()!=null)
			assessments = domain.listAssessments(form.txtName().getValue());

		if (assessments!=null)
			for (GraphicAssessmentShortVo item : assessments)
			{
				grdGraphicAssessmentsRow aRow = form.grdGraphicAssessments().getRows().newRow();
				aRow.setValue(item);
				aRow.setcolName(item.getName());
				aRow.setcolSelect(false);
			}
		else
			engine.showMessage("No results found", "Message", MessageButtons.OK);
	}
	@Override
	protected void onGrdGraphicAssessmentsGridCheckBoxClicked(int column, grdGraphicAssessmentsRow row, boolean isChecked) throws PresentationLogicException 
	{
		
		form.btnSelect().setEnabled(isChecked);//WDEV-16949
		
		for (int i=0;i<form.grdGraphicAssessments().getRows().size();i++)
		{
			if (isChecked)
				if (!form.grdGraphicAssessments().getRows().get(i).getValue().getID_GraphicAssessment().equals(row.getValue().getID_GraphicAssessment()))
					form.grdGraphicAssessments().getRows().get(i).setcolSelect(false);
		}

	}
}
