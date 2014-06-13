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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.55 build 2763.22113)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.forms.tumourotherclassification;

import ims.clinicaladmin.domain.impl.TumourOtherClassificationImpl;
import ims.clinicaladmin.forms.tumourotherclassification.GenForm.grdClassificationGrid;
import ims.clinicaladmin.forms.tumourotherclassification.GenForm.grdClassificationRow;
import ims.clinicaladmin.vo.OtherClassificationValueListVoCollection;
import ims.clinicaladmin.vo.OtherClassificationValueVoCollection;
import ims.clinicaladmin.vo.StagingClassificationListVoCollection;
import ims.clinicaladmin.vo.StagingClassificationVoCollection;
import ims.clinicaladmin.vo.TumourStagingClassificationVoCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open() 
	{
		populateGrid();
		checkOtherClassification();
	}

	private void populateGrid() 
	{
		form.grdClassification().getRows().clear();
		
		StagingClassificationVoCollection voColl = domain.listOtherClassification();
		if (voColl != null)
		{
			for (int x=0; x < voColl.size(); x++)
			{
				grdClassificationRow row = form.grdClassification().getRows().newRow();
				row.setStagingClassification(voColl.get(x).getName());
				row.setValue(voColl.get(x));
			}
		}
	}

	private void checkOtherClassification() 
	{
		if (form.getGlobalContext().ClinicalAdmin.getTumourGroupOtherClassificationIsNotNull() &&
				form.getGlobalContext().ClinicalAdmin.getTumourGroupOtherClassification().size() > 0)
		{
			StagingClassificationVoCollection voColl = form.getGlobalContext().ClinicalAdmin.getTumourGroupOtherClassification();
			
			for ( int i = 0; i < voColl.size(); i++ )
			{
				for (int j = 0; j < form.grdClassification().getRows().size(); j++ )
				{
					if ( form.grdClassification().getRows().get(j).getValue().equals(voColl.get(i)))
					{
						form.grdClassification().getRows().get(j).setPresent(true);
					}
				}
			}
		}
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setGlobalContext();
		engine.close(DialogResult.OK);
	}	

	private void setGlobalContext() 
	{
		StagingClassificationVoCollection voColl = new StagingClassificationVoCollection();
		
		for ( int i = 0; i < form.grdClassification().getRows().size(); i++ )
		{
			if ( form.grdClassification().getRows().get(i).getPresent() )
			{
				voColl.add(form.grdClassification().getRows().get(i).getValue());
			}
		}
		form.getGlobalContext().ClinicalAdmin.setTumourGroupOtherClassification(voColl);
	}
}