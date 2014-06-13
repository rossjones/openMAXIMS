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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.53 build 2680.25741)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.forms.cancerreferraldetails;

import ims.admin.vo.PracticeSearchCriteriaVo;
import ims.clinical.vo.ReferralsRecordingVo;
import ims.clinical.vo.ReferralsRecordingVoCollection;
import ims.clinical.vo.lookups.PrimaryPreceeding;
import ims.clinical.vo.lookups.ReferralSource;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.GP;
import ims.core.vo.GpLiteVo;
import ims.core.vo.GpShortVo;
import ims.core.vo.GpShortVoCollection;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.MedicVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.OrganisationVo;
import ims.core.vo.OrganisationVoCollection;
import ims.core.vo.OrganisationWithSitesVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.oncology.forms.cancerreferraldetails.GenForm.grdPreceedingReferralsRow;
import ims.clinical.vo.lookups.ReferralCategory;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		loadOrganisations();
		open();
		
		form.setMode(FormMode.VIEW);

	}
	private void loadOrganisations() 
	{
		form.qmbReferringOrg().clear();
		
		OrganisationVoCollection voColl = domain.listOrganisation(new OrganisationVo());

		for (int i = 0 ; i < voColl.size() ; i++)
		{
			if (voColl.get(i).getIsActiveIsNotNull() && voColl.get(i).getIsActive().booleanValue())
				form.qmbReferringOrg().newRow(voColl.get(i), voColl.get(i).getName());
		}
	}
	
	private void open() 
	{
		clearScreen();
		updateContextMenus();
		form.getLocalContext().setSelectedReferral(null);
		
		ReferralsRecordingVo voRR = domain.getPrimaryPreecedingReferralRecording(form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getCareSpell());
		if (voRR != null)
		{
			form.getLocalContext().setSelectedReferral(voRR);

			populateScreenFromData(voRR);
		}
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.btnNew().setEnabled(voRR == null);
			form.btnNew().setVisible(true);
			form.btnEdit().setEnabled(voRR != null);
			form.btnEdit().setVisible(true);
		}
	}

	private void addOrReplaceReferralRow(ReferralsRecordingVo rrVo, grdPreceedingReferralsRow existingRow) 
	{
		grdPreceedingReferralsRow row = null;
		if (existingRow == null)
			row = form.grdPreceedingReferrals().getRows().newRow();
		else
			row = existingRow;
		
		row.setColSourceOfReferral(rrVo.getReferralSourceIsNotNull() ? rrVo.getReferralSource().toString() :"");
		row.setColRefOrga(rrVo.getRefOrgaCodeIsNotNull() ? rrVo.getRefOrgaCode().getName() : "");
		row.setColReferredTo(rrVo.getReferralHCPIsNotNull() ? rrVo.getReferralHCP().getName().toString() : "");
		row.setColReferralDate(rrVo.getDateReceivedIsNotNull() ? rrVo.getDateReceived().toString() : "");
		row.setColDateFirstSeen(rrVo.getDateFirstSeenIsNotNull() ? rrVo.getDateFirstSeen().toString() : "");
		row.setValue(rrVo);
	}
	
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getMode().equals(FormMode.EDIT) && formName.equals(form.getForms().Clinical.PreceedingReferral) && result.equals(DialogResult.OK))
		{
			//existing row and edited - Update
			if (form.grdPreceedingReferrals().getSelectedRowIndex() >= 0
				&& form.getGlobalContext().Clinical.getPreceedingReferralDialogMode().equals(FormMode.EDIT))
			{
				addOrReplaceReferralRow((ims.clinical.vo.ReferralsRecordingVo)form.getGlobalContext().Clinical.getSelectedPreceedingReferralVo(), form.grdPreceedingReferrals().getSelectedRow());
			}
			//No row and edited - New
			else if (form.grdPreceedingReferrals().getSelectedRowIndex() == -1
				&& form.getGlobalContext().Clinical.getPreceedingReferralDialogMode().equals(FormMode.EDIT))
			{
				addOrReplaceReferralRow((ims.clinical.vo.ReferralsRecordingVo)form.getGlobalContext().Clinical.getSelectedPreceedingReferralVo(), null);
			}
			//existing row and view - View
			else if (form.grdPreceedingReferrals().getSelectedRowIndex() >= 0
					&& form.getGlobalContext().Clinical.getPreceedingReferralDialogMode().equals(FormMode.VIEW))
			{
				//do nothing
			}
			form.getGlobalContext().Clinical.setPreceedingReferralDialogMode(null);
			form.getGlobalContext().Clinical.setSelectedPreceedingReferralVo(null);
		}
		updateContextMenus();
	}

	protected void onFormModeChanged()
	{
		updateContextMenus();

	}
	
	private void updateContextMenus() 
	{
		form.getContextMenus().hideAllGenericGridMenuItems();
		if(form.getMode().equals(FormMode.EDIT))
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setEnabled(form.grdPreceedingReferrals().getSelectedRowIndex() >= 0 ? true : false);
			form.getContextMenus().getGenericGridViewItem().setVisible(true);
			form.getContextMenus().getGenericGridViewItem().setEnabled(form.grdPreceedingReferrals().getSelectedRowIndex() >= 0 ? true : false);
		}
		else
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(false);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.getContextMenus().getGenericGridViewItem().setVisible(form.grdPreceedingReferrals().getSelectedRowIndex() >= 0 ? true : false);
			form.getContextMenus().getGenericGridViewItem().setEnabled(form.grdPreceedingReferrals().getSelectedRowIndex() >= 0 ? true : false);
		}
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ReferralsRecordingVo rrVo = form.getLocalContext().getSelectedReferral();
		if (rrVo == null)
			rrVo = new ReferralsRecordingVo();
		
		rrVo = populateDataFromScreen(rrVo);

		//Top half of screen
		rrVo.setPrimaryPreceeding(PrimaryPreceeding.PRIMARY);
		rrVo.setReferralCategory(ReferralCategory.PRECEEDEDEPISODE);
		
		if (rrVo.getClinicalContact() == null)
			rrVo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (rrVo.getCareContext() == null)
			rrVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		if (rrVo.getCareSpell() == null)
			rrVo.setCareSpell(form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getCareSpell());
		
		//Fill in the mandatory AuthoringInfo field. Dont bother getting value for AuthoringHcp......
		//it would need a domain call and is equivalent to the RecordingMOS value that is saved.
		if (rrVo.getAuthoringInfo() == null)
		{
			AuthoringInformationVo authoring = new AuthoringInformationVo();			
			authoring.setAuthoringHcp(null);
			authoring.setAuthoringDateTime(new DateTime());
			rrVo.setAuthoringInfo(authoring);
		}
		
		try 
		{
			String[] errors = rrVo.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
			
			rrVo = domain.saveReferralsRecording(rrVo);
			
			form.getLocalContext().setSelectedReferral(rrVo);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		form.setMode(FormMode.VIEW);
		open();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		
		open();
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);

	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		
		clearScreen();
		form.getLocalContext().setSelectedReferral(new ReferralsRecordingVo());
//		form.customControlAuthoringInfo().initializeComponent();
		if (engine.getLoggedInUser().getMosId() != null)
		{
			MemberOfStaffRefVo voRef = new MemberOfStaffRefVo();
			voRef.setID_MemberOfStaff(engine.getLoggedInUser().getMosId());
			MemberOfStaffShortVo voMOSShort = domain.getMemberOfStaff(voRef);
			//wdev-12035
			form.txtRecordingUser().setValue(voMOSShort.getNameIsNotNull() ? (voMOSShort.getName().getTitleIsNotNull() ? voMOSShort.getName().getTitle() : "" )+ " " + (voMOSShort.getName().getForenameIsNotNull() ? voMOSShort.getName().getForename() : "") + " " + (voMOSShort.getName().getSurnameIsNotNull() ? voMOSShort.getName().getSurname() : "") : "");
			//----
			
			form.getLocalContext().setLoggedInMOS(voMOSShort);
		}
		
		form.dtimRecordingDate().setValue(new DateTime());//getAuthoringInfo());

	}

	private void clearScreen() 
	{
		form.grdPreceedingReferrals().getRows().clear();
		
		form.cmbSourceofReferral().setValue(null);
		form.qmbReferringOrg().setValue(null);
		form.qmbReferringOrg().clear();
		form.qmbReferredBy().setValue(null);
		form.qmbReferredBy().clear();
		form.cmbPriority().setValue(null);
		form.dteDecisionToRefer().setValue(null);
		form.dteRecieptReferral().setValue(null);
		form.cmbReasonReferral().setValue(null);
		form.cmbUrgntReferralType().setValue(null);
		form.cmbCancerStatus().setValue(null);
		form.qmbReferredTo().setValue(null);
		form.cmbSpecialtyCode().setValue(null);
		form.dteFirstSeen().setValue(null);
		form.cmbDelayReasonFirstSeen().setValue(null);
		form.txtDelayResonComments().setValue(null);
	}

	private void populateScreenFromData(ReferralsRecordingVo rrVo) 
	{
		if (rrVo == null)
			return;
		
		form.cmbSourceofReferral().setValue(rrVo.getReferralSource());
		form.qmbReferringOrg().setValue(rrVo.getRefOrgaCode());
		if (form.qmbReferringOrg().getValue() == null && rrVo.getRefOrgaCodeIsNotNull())
		{
			form.qmbReferringOrg().newRow(rrVo.getRefOrgaCode(), rrVo.getRefOrgaCode().getName(), null, null);
			form.qmbReferringOrg().setValue(rrVo.getRefOrgaCode());
		}

		if (rrVo.getReferredByIsNotNull()) 
		{
			form.qmbReferredBy().setValue(rrVo.getReferredBy());
			if (form.qmbReferredBy().getValue() == null)
			{
				form.qmbReferredBy().newRow(rrVo.getReferredBy(), rrVo.getReferredBy().getName().toString());
				form.qmbReferredBy().setValue(rrVo.getReferredBy());
			}
		}
		else if (rrVo.getReferredByGPIsNotNull()) 
		{
			form.qmbReferredBy().setValue(rrVo.getReferredByGP());
			if (form.qmbReferredBy().getValue() == null)
			{
				form.qmbReferredBy().newRow(rrVo.getReferredByGP(), rrVo.getReferredByGP().getName().toString());
				form.qmbReferredBy().setValue(rrVo.getReferredByGP());
				
				GP gpVo = domain.getGP(rrVo.getReferredByGP());
				if (gpVo.getPracticesIsNotNull() && gpVo.getPractices().size() > 0)
				{
					for (int i = 0 ; i < gpVo.getPractices().size() ; i++)
					{
						if (gpVo.getPractices().get(i).getIsPrimaryPracticeIsNotNull() &&
							gpVo.getPractices().get(i).getIsPrimaryPractice().booleanValue() )
						{
							form.qmbReferringOrg().newRow(gpVo.getPractices().get(i).getPractice(), gpVo.getPractices().get(i).getPractice().getName(), null, null);
							form.qmbReferringOrg().setValue(gpVo.getPractices().get(i).getPractice());
						}
					}
				}
				
			}
		}
		
		form.cmbPriority().setValue(rrVo.getReferralPriority());
		form.dteDecisionToRefer().setValue(rrVo.getDateSent());
		form.dteRecieptReferral().setValue(rrVo.getDateReceived());
		form.cmbReasonReferral().setValue(rrVo.getReasonForReferral());
		form.cmbUrgntReferralType().setValue(rrVo.getUrgentCancerReferralType());
		form.cmbCancerStatus().setValue(rrVo.getCancerStatus());
		form.qmbReferredTo().setValue(rrVo.getReferralHCP());
		if (form.qmbReferredTo().getValue() == null && rrVo.getReferralHCP() != null)
		{
			form.qmbReferredTo().newRow(rrVo.getReferralHCP(), rrVo.getReferralHCP().getName().toString());
			form.qmbReferredTo().setValue(rrVo.getReferralHCP());
		}
		form.cmbSpecialtyCode().setValue(rrVo.getSpecialtyFunctionCode());
		form.dteFirstSeen().setValue(rrVo.getDateFirstSeen());
		form.cmbDelayReasonFirstSeen().setValue(rrVo.getDelayReasonGPUrgentReferral());
		form.txtDelayResonComments().setValue(rrVo.getDelayReasonText());
		form.dtimRecordingDate().setValue(rrVo.getSysInfo().getCreationDateTime());//getAuthoringInfo());
		//wdev-12035
		form.txtRecordingUser().setValue(rrVo.getRecordingMOSIsNotNull() && rrVo.getRecordingMOS().getNameIsNotNull() ? (rrVo.getRecordingMOS().getName().getTitleIsNotNull() ? rrVo.getRecordingMOS().getName().getTitle() : "" )+ " " + (rrVo.getRecordingMOS().getName().getForenameIsNotNull() ? rrVo.getRecordingMOS().getName().getForename():"") + " " + (rrVo.getRecordingMOS().getName().getSurnameIsNotNull() ? rrVo.getRecordingMOS().getName().getSurname():"") : "");
		//---
		
		fillReferralGrid(rrVo);
		
	}

	private void fillReferralGrid(ReferralsRecordingVo rrVo) 
	{
		if (rrVo.getPreceedingReferralsIsNotNull())
		{
			rrVo.getPreceedingReferrals().sort();
			
			for (int i = 0 ; i < rrVo.getPreceedingReferrals().size() ; i++)
				addOrReplaceReferralRow(rrVo.getPreceedingReferrals().get(i), null);
		}
	}

	private ReferralsRecordingVo populateDataFromScreen(ReferralsRecordingVo rrVo) 
	{
		rrVo.setReferralSource(form.cmbSourceofReferral().getValue());
		rrVo.setRefOrgaCode(form.qmbReferringOrg().getValue());
		
		if (form.qmbReferredBy().getValue() instanceof MedicVo) 
		{
			rrVo.setReferredBy((Hcp) form.qmbReferredBy().getValue());
			rrVo.setReferredByGP(null);
		}
		else if (form.qmbReferredBy().getValue() instanceof GpLiteVo) 
		{
			rrVo.setReferredByGP((GpShortVo)form.qmbReferredBy().getValue());
			rrVo.setReferredBy(null);
		}
		 
		rrVo.setReferralPriority(form.cmbPriority().getValue());
		rrVo.setDateSent(form.dteDecisionToRefer().getValue());
		rrVo.setDateReceived(form.dteRecieptReferral().getValue());
		rrVo.setReasonForReferral(form.cmbReasonReferral().getValue());
		rrVo.setUrgentCancerReferralType(form.cmbUrgntReferralType().getValue());
		rrVo.setCancerStatus(form.cmbCancerStatus().getValue());
		rrVo.setReferralHCP(form.qmbReferredTo().getValue());
		rrVo.setSpecialtyFunctionCode(form.cmbSpecialtyCode().getValue());
		rrVo.setDateFirstSeen(form.dteFirstSeen().getValue());
		rrVo.setDelayReasonGPUrgentReferral(form.cmbDelayReasonFirstSeen().getValue());
		rrVo.setDelayReasonText(form.txtDelayResonComments().getValue());		

		if (rrVo.getRecordingMOS() == null && form.getLocalContext().getLoggedInMOSIsNotNull())
			rrVo.setRecordingMOS(form.getLocalContext().getLoggedInMOS());

		ReferralsRecordingVoCollection voRRColl = new ReferralsRecordingVoCollection(); 
		for (int i = 0 ; i < form.grdPreceedingReferrals().getRows().size() ; i++)
		{
			ReferralsRecordingVo prVo = new ReferralsRecordingVo();
			prVo = form.grdPreceedingReferrals().getRows().get(i).getValue();

			prVo.setPrimaryPreceeding(PrimaryPreceeding.PREECEDING);
			prVo.setReferralCategory(ReferralCategory.PRECEEDEDEPISODE);
	
			if (prVo.getClinicalContact() == null)
				prVo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
			if (prVo.getCareContext() == null)
				prVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

			if (prVo.getCareSpell() == null)
				prVo.setCareSpell(form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getCareSpell());
			
			voRRColl.add(prVo);
		}

		rrVo.setPreceedingReferrals(voRRColl);
		
		return rrVo;
	}

	protected void onQmbReferredByTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbReferredBy().clear();
		
		if (form.cmbSourceofReferral().getValue() != null && form.cmbSourceofReferral().getValue().equals(ReferralSource.GPREFERRAL))
		{
			GpShortVoCollection gpColl = domain.listGPsBySurname(value);
			if(gpColl != null)
			{
				for (int i = 0; i < gpColl.size(); i++)
					form.qmbReferredBy().newRow(gpColl.get(i), gpColl.get(i).toString());			

				if (gpColl.size() == 1)
				{
					form.qmbReferredBy().setValue(gpColl.get(0));
					loadGPsPractice(gpColl.get(0));
				}
				else if (gpColl.size() > 1)
					form.qmbReferredBy().showOpened();		
			}		
		}
		else
		{
			HcpFilter filter = new HcpFilter();
			PersonName name = new PersonName();
			name.setSurname(value);
			filter.setQueryName(name);
			filter.setHcpType(HcpDisType.MEDICAL);
			HcpCollection coll = domain.listHcps(filter, HcpDisType.MEDICAL);
			if(coll != null)
			{
				for (int i = 0; i < coll.size(); i++)
					form.qmbReferredBy().newRow(coll.get(i), coll.get(i).toString());			

				if (coll.size() == 1)
					form.qmbReferredBy().setValue(coll.get(0));
				else if (coll.size() > 1)
					form.qmbReferredBy().showOpened();		
			}		
		}
	}
	
	private void loadGPsPractice(GpShortVo vo) 
	{
		GP gpVo = domain.getGP(vo);
		if (gpVo.getPracticesIsNotNull() && gpVo.getPractices().size() > 0)
		{
			for (int i = 0 ; i < gpVo.getPractices().size() ; i++)
			{
				if (gpVo.getPractices().get(i).getIsPrimaryPracticeIsNotNull() &&
					gpVo.getPractices().get(i).getIsPrimaryPractice().booleanValue() )
				{
					form.qmbReferringOrg().newRow(gpVo.getPractices().get(i).getPractice(), gpVo.getPractices().get(i).getPractice().getName(), null, null);
					form.qmbReferringOrg().setValue(gpVo.getPractices().get(i).getPractice());
				}
			}
		}
	}
	protected void onQmbReferringOrgTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbReferringOrg().clear();
		
		if (form.cmbSourceofReferral().getValue() != null && form.cmbSourceofReferral().getValue().equals(ReferralSource.GPREFERRAL))
		{
			PracticeSearchCriteriaVo voGP = new PracticeSearchCriteriaVo();
			voGP.setName(value);
			voGP.setIsActive(new Boolean(true));
			
			OrganisationWithSitesVoCollection voColl = domain.listPractice(voGP);
			for (int i = 0 ; i < voColl.size() ; i++)
			{
				if (voColl.get(i).getIsActiveIsNotNull() && voColl.get(i).getIsActive().booleanValue())
					form.qmbReferringOrg().newRow(voColl.get(i), voColl.get(i).getName());

				if (voColl.size() == 1)
					form.qmbReferringOrg().setValue(voColl.get(0));
				else if (voColl.size() > 1)
					form.qmbReferringOrg().showOpened();		
			}
		}
		else
		{
			OrganisationVo voOrg = new OrganisationVo();
			voOrg.setName(value);
			
			OrganisationVoCollection voColl = domain.listOrganisation(voOrg);
			for (int i = 0 ; i < voColl.size() ; i++)
			{
				if (voColl.get(i).getIsActiveIsNotNull() && voColl.get(i).getIsActive().booleanValue())
					form.qmbReferringOrg().newRow(voColl.get(i), voColl.get(i).getName());

				if (voColl.size() == 1)
					form.qmbReferringOrg().setValue(voColl.get(0));
				else if (voColl.size() > 1)
					form.qmbReferringOrg().showOpened();		
			}
		}
	}
	
	protected void onGrdPreceedingReferralsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenus();
		
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdPreceedingReferrals()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add :
					newPreceedingReferral();
				break;			
				case GenForm.ContextMenus.GenericGrid.Update :
					updatePreceedingReferral();
				break;
				case GenForm.ContextMenus.GenericGrid.View :
					viewPreceedingReferral();
				break;
				default :
				break;
			}
		}
	}

	private void viewPreceedingReferral() 
	{
		form.getGlobalContext().Clinical.setPreceedingReferralDialogMode(FormMode.VIEW);
		
		form.getGlobalContext().Clinical.setSelectedPreceedingReferralVo(form.grdPreceedingReferrals().getSelectedRow().getValue());
		
		engine.open(form.getForms().Clinical.PreceedingReferral);
	}
	
	private void updatePreceedingReferral() 
	{
		form.getGlobalContext().Clinical.setPreceedingReferralDialogMode(FormMode.EDIT);
		form.getGlobalContext().Clinical.setSelectedPreceedingReferralVo(form.grdPreceedingReferrals().getSelectedRow().getValue());

		engine.open(form.getForms().Clinical.PreceedingReferral);
	}
	
	private void newPreceedingReferral() 
	{
		form.getGlobalContext().Clinical.setPreceedingReferralDialogMode(FormMode.EDIT);
		form.getGlobalContext().Clinical.setSelectedPreceedingReferralVo(null);
		form.grdPreceedingReferrals().setValue(null);
		
		engine.open(form.getForms().Clinical.PreceedingReferral);
	}
	
	@Override
	protected void onCmbReasonReferralValueChanged() throws PresentationLogicException 
	{
		//enableReasonCombosCombo();
	}
//	
//	private void enableReasonCombosCombo() 
//	{
//		if (form.cmbReasonReferral().getValue() != null 
//			&& form.cmbReasonReferral().getValue().equals(ReasonForReferral.GPSUSPECTEDCANCER))
//		{
//			form.cmbUrgntReferralType().setEnabled(true);
//			form.cmbCancerStatus().setEnabled(true);
//		}
//		else
//		{
//			form.cmbUrgntReferralType().setEnabled(false);
//			form.cmbCancerStatus().setEnabled(false);
//		}
//				
//	}
	@Override
	protected void onQmbReferredToTextSubmited(String value) throws PresentationLogicException 
	{
		form.qmbReferredTo().clear();
		
		MemberOfStaffShortVo voMOS = new MemberOfStaffShortVo();
		PersonName personName = new PersonName();
		personName.setSurname(value);
		voMOS.setName(personName);
		voMOS.setIsActive(Boolean.TRUE);
		
		MemberOfStaffShortVoCollection coll = domain.listMembersOfStaff(voMOS);
		if(coll != null)
		{
			for (int i = 0; i < coll.size(); i++)
				form.qmbReferredTo().newRow(coll.get(i), coll.get(i).toString());			

			if (coll.size() == 1)
				form.qmbReferredTo().setValue(coll.get(0));
			else if (coll.size() > 1)
				form.qmbReferredTo().showOpened();		
		}		
	}
	@Override
	protected void onQmbReferredByValueChanged() throws PresentationLogicException
	{
		if (form.qmbReferredBy().getValue() instanceof GpShortVo)
		{
			loadGPsPractice((GpShortVo)form.qmbReferredBy().getValue());
		}
	}
	@Override
	protected void onCmbSourceofReferralValueChanged() throws PresentationLogicException 
	{
		form.qmbReferredBy().clear();
		form.qmbReferredBy().setValue(null);
		form.qmbReferringOrg().setValue(null);
		form.qmbReferringOrg().clear();
	}
}
