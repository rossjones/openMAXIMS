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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41105.1500)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.supportnetworkprofessionaldialog;

import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.SupportNetworkProfessionalVo;
import ims.core.vo.SupportNetworkProfessionalVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateFormat;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{	
		CareContextShortVoCollection careContextColl = form.getGlobalContext().Core.getSupportNetworkPreviousCareContexts();
		
		
		for (int i=0; i<careContextColl.size(); i++)
		{
			CareContextShortVo vo = careContextColl.get(i);
			if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull() &&
					!form.getGlobalContext().Core.getCurrentCareContext().equals(vo))
			{
				StringBuffer detail = new StringBuffer();
				if (vo.getStartDateTimeIsNotNull())
					detail.append(vo.getStartDateTime().getDate().toString(DateFormat.STANDARD));
				if (vo.getEpisodeOfCare().getResponsibleHCPIsNotNull())
					detail.append(" - " + vo.getEpisodeOfCare().getResponsibleHCP().toString()); //WDEV-17267
				form.cmbEpisode().newRow(vo, detail.toString());
			}
		}
		// Commenting out as this may be needed at a later stage
//		ClinicalContactShortVo voClinicalContactShort = null;
//		for(int i = 0 ; i < voColl.size() ; i++)
//		{
//			voClinicalContactShort = voColl.get(i);
//			if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
//			{
//				if(!voClinicalContactShort.equals(form.getGlobalContext().Core.getCurrentClinicalContact()))
//				{
//					StringBuffer detail = new StringBuffer();
//					if (voClinicalContactShort.getStartDateTimeIsNotNull())
//						detail.append(voClinicalContactShort.getStartDateTime().getDate().toString(DateFormat.STANDARD) + " - ");
//										
//					if (voClinicalContactShort.getSeenByIsNotNull())
//						detail.append(voClinicalContactShort.getSeenBy().toString());
//	
//					form.cmbEpisode().newRow(voClinicalContactShort, detail.toString());
//				}
//			}
//		}
	}


	protected void onCmbEpisodeValueChanged() throws PresentationLogicException 
	{
		form.grdProfessional().getRows().clear();
		//09/09/2005 - check for null
		CareContextShortVo voCareContextShort = form.cmbEpisode().getValue();
		if(voCareContextShort == null)
			return;
		SupportNetworkProfessionalVoCollection voColl = domain.listSupportNetworkProfessionalByCareContext(voCareContextShort, Boolean.TRUE);
		
		SupportNetworkProfessionalVo voProf = null;
		GenForm.grdProfessionalRow row = null;


		if(voColl == null)
			return;
	
		for(int i = 0 ; i < voColl.size() ; i++)
		{
			voProf = voColl.get(i);
			row = form.grdProfessional().getRows().newRow();
	
			if(voProf.getMOS() != null)
			{
				row.setName(voProf.getMOS().toString());
				if(voProf.getHcpSubType() != null)
					row.setProfession(voProf.getHcpSubType().getText());
		
				MemberOfStaffVo voMos = domain.getMos(voProf.getMOS());
				
				if(voMos != null && voMos.getLocations() != null)
				{
					for(int k = 0 ; k < voMos.getLocations().size() ; k++)
					{
						if (voMos.getLocations().get(k).getIsPrimaryIsNotNull() && voMos.getLocations().get(k).getIsPrimary().equals(Boolean.TRUE))
							if (voMos.getLocations().get(k).getLocation().getAddressIsNotNull())
								row.setPhone(voMos.getLocations().get(k).getLocation().getAddress().getPhone());
					}
				}
			}
			
			row.setSelect(true);
			row.setValue(voProf);
		}			
	}

	protected void onBtnOkClick() throws PresentationLogicException 
	{
		if(form.cmbEpisode().getValues().size() < 1)
		{
			engine.showMessage("No previous episodes to copy from.");
			engine.close(DialogResult.CANCEL);
			return;
		}
		
		SupportNetworkProfessionalVoCollection voColl = new SupportNetworkProfessionalVoCollection();
		
		if(form.grdProfessional().getRows() != null)
		{
			GenForm.grdProfessionalRow row = null;
			for(int i=0;i<form.grdProfessional().getRows().size();i++)
			{
				row = form.grdProfessional().getRows().get(i);
				if(row.getSelect() == true)
				{
					voColl.add(row.getValue());
				}
			}	
		}
	
		if(voColl.size() > 0)
		{
			form.getGlobalContext().COE.setSupportNetworkProfessionalCollection(voColl);
			engine.close(DialogResult.OK);
		}
		else
			engine.showMessage("Please select at least one professional.");
			
	}

	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		engine.close(DialogResult.CANCEL);
	}


	protected void onLnkGPDetailsClick() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setParentFormMode(FormMode.VIEW);
		engine.open(form.getForms().Core.GPDetails);
	}
}
