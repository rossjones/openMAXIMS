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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2257.28884)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.sportsactivities;

import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.lookups.SportActivity;
import ims.spinalinjuries.vo.lookups.SportActivityCollection;
import ims.therapies.vo.SportsActivitySessionShortVo;
import ims.therapies.vo.SportsActivitySessionShortVoCollection;
import ims.therapies.vo.SportsActivitySessionVo;
import ims.therapies.vo.SportsActivityVo;
import ims.therapies.vo.SportsActivityVoCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	private void initialize() throws PresentationLogicException
	{
		validateLookups();
	}
	private void validateLookups() throws PresentationLogicException
	{
		SportActivityCollection voSportActivityColl = LookupHelper.getSportActivity(domain.getLookupService());
		if(voSportActivityColl == null || voSportActivityColl.size() == 0)
			throw new PresentationLogicException("Please configure SportActivity lookup");
	}
	private void open() 
	{		
		fillRecordBrowser();
	
		form.setMode(FormMode.VIEW);
	}
	private void fillRecordBrowser()
	{
		SportsActivitySessionShortVoCollection voSportsActivityShortColl = domain.listSportsActivityByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		boolean currentClinicalContactFound = false;
		loadCurrentCareContext();
		
		if(voSportsActivityShortColl != null)
		{
			for(int i=0; i<voSportsActivityShortColl.size(); i++)
			{
				SportsActivitySessionShortVo voSportsActivitySessionShort = voSportsActivityShortColl.get(i);
				ClinicalContactShortVo voClinicalContact = voSportsActivitySessionShort.getClinicalContact();
				if(voCurrentClinicalContact != null && voClinicalContact.getID_ClinicalContact().equals(voCurrentClinicalContact.getID_ClinicalContact()))
				{
					currentClinicalContactFound = true;
					form.recbrSports().newRow(voClinicalContact, "\t\t\t\tClinical Contact: " + voClinicalContact.getStartDateTime()+" - "+ voClinicalContact.getSeenBy(), Color.Green);
					form.recbrSports().setValue(voClinicalContact);
				}
				else
				{
					form.recbrSports().newRow(voClinicalContact, "\t\t\t\tClinical Contact: " + voClinicalContact.getStartDateTime()+" - "+ voClinicalContact.getSeenBy());
				}
			}
		}
		
		if(!currentClinicalContactFound && voCurrentClinicalContact != null)
			loadCurrentClinicalContact();
		
		browseRecord();
	}
	private void loadCurrentClinicalContact()
	{
		ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		form.recbrSports().newRow(voCurrentClinicalContact, "\t\t\t\tClinical Contact: " + voCurrentClinicalContact.getStartDateTime()+" - "+ voCurrentClinicalContact.getSeenBy(), Color.Green);
		form.recbrSports().setValue(voCurrentClinicalContact);
		
	}
	private void loadCurrentCareContext()
	{
		CareContextShortVo voCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		
		if(form.getGlobalContext().Core.getCurrentClinicalContact() == null)
		{
			form.recbrSports().newRow(voCareContext, voCareContext.getRecordBrowserText(), Color.Green);
			form.recbrSports().setValue(voCareContext);
		}
		else
		{
			form.recbrSports().newRow(voCareContext,  voCareContext.getRecordBrowserText());
		}
	}
	private void prePopulateSportsGrd()
	{
		form.grdSports().populateTree(LookupHelper.getSportActivity(domain.getLookupService()));
		form.grdSports().expandAll();
	}
	
	private void displayButtons()
	{
		if(form.getLocalContext().getSportsActivitySession() == null)
			enableButtons(true);
		else
			enableButtons(false);
	}
	private void enableButtons(boolean visible)
	{
		form.btnNew().setVisible(visible);
		form.btnUpdate().setVisible(!visible);
	}
	protected void onFormModeChanged()
	{
		if(form.getMode().equals(FormMode.EDIT))
		{
			form.btnNew().setVisible(false);
			form.btnUpdate().setVisible(false);
		}
	}
	private void clearControls()
	{
		form.dtimRecording().setValue(null);
		form.qmbHCP().setValue(null);
		form.grdSports().getRows().clear();
	}
	private void populateInstanceControls()
	{
		if(form.getLocalContext().getSportsActivitySession() == null) return;
		
		SportsActivitySessionVo voSportsActivitySess = form.getLocalContext().getSportsActivitySession();
		
		form.dtimRecording().setValue(voSportsActivitySess.getAuthoringDateTime());
		form.qmbHCP().newRow(voSportsActivitySess.getAuthoringCP(), voSportsActivitySess.getAuthoringCP().toString());
		form.qmbHCP().setValue(voSportsActivitySess.getAuthoringCP());
		
		populateSportsGrd(voSportsActivitySess.getSportsActivity());
	}
	
	private void populateSportsGrd(SportsActivityVoCollection voSportsActColl)
	{	
		if(voSportsActColl == null) return;
		
		SportsActivityVoCollection voSportsActivityColl = voSportsActColl;
		SportsActivityVoCollection voInactiveSportsColl = new SportsActivityVoCollection();
		GenForm.grdSportsRow row = null;
		for(int i=0; i<voSportsActivityColl.size(); i++)
		{
			int z=0;
			for(z=0; z<form.grdSports().getAllRows().length; z++)
			{
				row = form.grdSports().getAllRows()[z];
				SportsActivityVo voSportsAct = voSportsActivityColl.get(i);
				if(voSportsAct.getSportsActivity().equals(row.getColGroupSession()))
				{
					row.setValue(voSportsAct);
					row.setColGroupSession(voSportsAct.getSportsActivity());
					row.setColSelect(voSportsAct.getSelect());
					row.setColComments(voSportsAct.getComments());
					break;
				}
			}
			if(z == form.grdSports().getAllRows().length)
			{
				voInactiveSportsColl.add(voSportsActivityColl.get(i));
			}
		}
	
		//inactive record handling
		SportsActivityVo voSportsAct = null;
		SportActivity parentSport = null;
		for(int i=0;i<voInactiveSportsColl.size();i++)
		{
			voSportsAct = voInactiveSportsColl.get(i);
			parentSport = voSportsAct.getSportsActivity().getParent();
			if(parentSport != null)
			{
				GenForm.grdSportsRow rowChild = null;
				int j=0;
				for(j=0;j<form.grdSports().getRows().size();j++)
				{
					row = form.grdSports().getRows().get(j);
					if(row.getColGroupSession().equals(parentSport))
					{
						rowChild = row.getRows().newRow();
						rowChild.setValue(voSportsAct);
						rowChild.setColGroupSession(voSportsAct.getSportsActivity());
						rowChild.setColSelect(voSportsAct.getSelect());
						rowChild.setColComments(voSportsAct.getComments());
						break;
					}
				}
						
				if(j == form.grdSports().getAllRows().length)
				{
					row = row.getRows().newRow();
					row.setValue(voSportsAct);
					row.setColGroupSession(voSportsAct.getSportsActivity());
					row.setColSelect(voSportsAct.getSelect());
					row.setColComments(voSportsAct.getComments());
				}
				
			}
			else
			{
				//display inactive parent
				row = form.grdSports().getRows().newRow();
				row.setValue(voSportsAct);
				row.setColGroupSession(voSportsAct.getSportsActivity());
				row.setColSelect(voSportsAct.getSelect());	
				row.setColComments(voSportsAct.getComments());
			}
		}
	}
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		setDefaultValues();
		form.qmbHCP().setEnabled(true);
		form.dtimRecording().setEnabled(true);
	}
	private void setDefaultValues()
	{
		Hcp hcpUser = (Hcp)domain.getHcpUser();
		if(hcpUser != null)
		{
			form.qmbHCP().newRow(hcpUser, hcpUser.toString());
			form.qmbHCP().setValue(hcpUser);
		}
		form.dtimRecording().setValue(new DateTime());	
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	private boolean save() 
	{
		SportsActivitySessionVo voSportsActivitySession  = populateInstanceData();
		
		
		if (voSportsActivitySession.getClinicalContact() == null)
			voSportsActivitySession.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		String[] arrErrors =  voSportsActivitySession.validate(validateUIRules(voSportsActivitySession.getSportsActivity()));	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			domain.saveSportsActivity(voSportsActivitySession);
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Sports Activity record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		catch(DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		
		return true;		
	}
	private String[] validateUIRules(SportsActivityVoCollection voSportColl)
	{
		if(voSportColl.equals(null))
			return null;
		for(SportsActivityVo voSportsAct: voSportColl)
		{
			if(voSportsAct.getSelect() == null && voSportsAct.getComments() != null && !voSportsAct.getComments().equals(""))
				return new String[]{"Select is mandatory if Comments field is populated"};
		}
		return null;
	}
	private SportsActivitySessionVo populateInstanceData()
	{
		SportsActivitySessionVo voSportsActivitySession  = form.getLocalContext().getSportsActivitySession();
		if(voSportsActivitySession == null)
			voSportsActivitySession = new SportsActivitySessionVo();
		
		voSportsActivitySession.setAuthoringCP(form.qmbHCP().getValue());
		voSportsActivitySession.setAuthoringDateTime(form.dtimRecording().getValue());
		
		voSportsActivitySession.setSportsActivity(populateSportsActivitiesFromGrd());
		return voSportsActivitySession;
	}
	private SportsActivityVoCollection populateSportsActivitiesFromGrd()
	{
		SportsActivityVoCollection voSportColl = new SportsActivityVoCollection();
		for (int i = 0; i < form.grdSports().getRows().size(); i++)
		{
			GenForm.grdSportsRow rowPar = form.grdSports().getRows().get(i);
			if(rowPar.getColSelect()!= null || (rowPar.getColComments() != null && rowPar.getColComments() != ""))
			{
				SportsActivityVo voSportsAct = rowPar.getValue();
				if(voSportsAct == null)
					voSportsAct = new SportsActivityVo();
				voSportsAct.setSportsActivity(rowPar.getColGroupSession());
				voSportsAct.setSelect(rowPar.getColSelect());
				voSportsAct.setComments(rowPar.getColComments());
				voSportColl.add(voSportsAct);
			}
		
			for(int x=0; x<form.grdSports().getRows().get(i).getRows().size(); x++)
			{
				GenForm.grdSportsRow rowAct = form.grdSports().getRows().get(i).getRows().get(x);
				
				if(rowAct.getColSelect()!= null || (rowAct.getColComments() != null && rowAct.getColComments() != ""))
				{
					SportsActivityVo voSportsAct = rowAct.getValue();
					if(voSportsAct == null)
						voSportsAct = new SportsActivityVo();
					voSportsAct.setSportsActivity(rowAct.getColGroupSession());
					voSportsAct.setSelect(rowAct.getColSelect());
					voSportsAct.setComments(rowAct.getColComments());
					voSportColl.add(voSportsAct);
				}
			}
		}
		return voSportColl;	
	}
	
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	protected void onQmbHCPTextSubmited(String value) throws PresentationLogicException
	{
		setAuthoringCP(value);
	}
	private void setAuthoringCP(String value)
	{
		form.qmbHCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listMedics(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.qmbHCP().newRow(med, med.toString());			
		}
		
		if (coll.size() == 1)
			form.qmbHCP().setValue(coll.get(0));
		else if (coll.size() > 1)
			form.qmbHCP().showOpened();
		
	}
	protected void onRecbrSportsValueChanged() throws PresentationLogicException
	{
		browseRecord();
	}
	private void browseRecord()
	{
		clearControls();
		prePopulateSportsGrd();
		
		updateBrowseInformation();
		if(form.recbrSports().getValue() != null)
		{
			if(form.recbrSports().getValue() instanceof ClinicalContactShortVo)
			{
				form.getLocalContext().setSportsActivitySession(domain.getSportsActivityByClinicalContact((ClinicalContactRefVo) form.recbrSports().getValue()));
				populateInstanceControls();
			}
		}
		isRecordEditable();
	}
	private void updateBrowseInformation()
	{
		form.lblBrowserStatus().setValue(form.recbrSports().getRecordState("Assessment", "Assessments"));
	}
	private void isRecordEditable()
	{
		ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		if(voCurrentClinicalContact != null && form.recbrSports().getValue() instanceof ClinicalContactShortVo)
		{
			ClinicalContactShortVo voSelectedClinicalContact = (ClinicalContactShortVo) form.recbrSports().getValue();
			if(voCurrentClinicalContact.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
				displayButtons();
			else
				hideButtons();
		}
		else
		{
			hideButtons();
		}
		
	}
	private void hideButtons()
	{
		form.btnNew().setVisible(false);
		form.btnUpdate().setVisible(false);
	}
	//wdev-13637
	protected void onRIEDialogClosed(DialogResult result)throws PresentationLogicException 
	{
		if(result == DialogResult.OK)
		{
			SportsActivitySessionVo voSportsActivitySess = form.getLocalContext().getSportsActivitySession();
			
			if(voSportsActivitySess != null && voSportsActivitySess.getID_SportsActivitySessionIsNotNull())
			{
				if(voSportsActivitySess.getSportsActivityIsNotNull() && voSportsActivitySess.getSportsActivity().size() > 0)
				{
					for(int i = 0;i < voSportsActivitySess.getSportsActivity().size();i++ )
					{
						voSportsActivitySess.getSportsActivity().get(i).setIsRIE(Boolean.TRUE);
						try 
						{
							domain.saveSportActivities(voSportsActivitySess.getSportsActivity().get(i));
						} 
						catch (DomainInterfaceException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (StaleObjectException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (UniqueKeyViolationException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		}
		
	}
	
}
