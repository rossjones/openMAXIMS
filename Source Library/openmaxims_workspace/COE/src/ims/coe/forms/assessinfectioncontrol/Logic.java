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
// This code was generated by Peter Martin using IMS Development Environment (version 1.60 build 2855.18658)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.assessinfectioncontrol;

import ims.coe.vo.InfectionControlComponentVo;
import ims.core.vo.lookups.YesNoUnknown;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.lookups.AssessmentComponentType;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}
	private void initialise() {
//		If there is an assessment in the global context, we want to call the get component
		// domain method
		// Otherwise, it is a new assessment component
		form.setMode(FormMode.EDIT);
		enablePreviousEpisodeText(false);
		form.btnSave().setEnabled(true);
		form.grdCarePlans().setReadOnly(false);
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setassmnt(assmnt);
		// Populate the Grid CarePlan Templates
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.INFECTION_CONTROL);
		if (tempColl != null)
		{
		 form.grdCarePlans().getRows().clear();
		 GenForm.grdCarePlansRow tempRow;
		 for (int i=0; i<tempColl.size(); i++)
		 {
			 CarePlanTemplateTitle template = tempColl.get(i);
			 tempRow = form.grdCarePlans().getRows().newRow();
			 tempRow.setValue(template);
			 tempRow.setcolCarePlans(template.getTitle());
		 }
		}

		// Cannot complete the infection component until
		// the repeatable assessment record exists.
		form.chkCopyPrevAssessment().setEnabled(false);
		form.lnkRepeatableAssessment().setEnabled(true);
		
		if (assmnt != null && assmnt.getID_AssessmentIsNotNull())
		{		
			InfectionControlComponentVo voInfectionControlComponent = (InfectionControlComponentVo)domain.getComponent(assmnt,AssessmentComponentType.INFECTION_CONTROL);
				
			
			if (voInfectionControlComponent == null)
				return;
			
			form.getGlobalContext().COE.setInfectionControlAssessment(voInfectionControlComponent.getInfectionControlAssessment());
			
			form.getLocalContext().setInfectionControlComponent(voInfectionControlComponent);
			
			populateFormInfo(voInfectionControlComponent);
			
			//If the Section has been completed previously then set the check box accordingly
			if(voInfectionControlComponent.getIsComplete().booleanValue() == true)
			{
				form.chkSectionComplete().setValue(true);	
				form.chkSectionComplete().setEnabled(false);
			}
			else if (voInfectionControlComponent.getInfectionControlAssessmentIsNotNull())
			{
				form.chkSectionComplete().setValue(false);	
				form.chkSectionComplete().setEnabled(true);
			}
			else
			{
				form.chkSectionComplete().setValue(false);	
				form.chkSectionComplete().setEnabled(false);
				
				
			}
		}
		else
		{
			form.chkSectionComplete().setEnabled(false);
			
			// Probably a Cancel was hit on the linked Form and no AssessmentHeaderInfo is saved so 
			// refresh the screen with any data that was entered befor using the link.
			if (form.getGlobalContext().Nursing.getAssessmentComponent() != null)		
			{
				InfectionControlComponentVo voInfectionControlComponent = (InfectionControlComponentVo)form.getGlobalContext().Nursing.getAssessmentComponent();
				if (voInfectionControlComponent.getInfectionControlAssessmentIsNotNull())
				{
					populateFormInfo(voInfectionControlComponent);
					form.chkSectionComplete().setEnabled(true);
				}
			}
			
			// check if there is a relevant component
			getLastAssessmentComponent();
			
			form.setMode(FormMode.EDIT);
		}
		
	}
	private void enablePreviousEpisodeText(boolean bEnable) {
		form.txtNorovirus().setEnabled(bEnable);
		form.txtTB().setEnabled(bEnable);
		form.txtESBC().setEnabled(bEnable);
		form.txtVRE().setEnabled(bEnable);
		form.txtClostridium().setEnabled(bEnable);
		form.txtMRSA().setEnabled(bEnable);
	}
	private void populateFormInfo(InfectionControlComponentVo voInfectionControlComponent) {
		if (voInfectionControlComponent == null)
			return;
		
		form.chkCopyPrevAssessment().setValue(voInfectionControlComponent.getCopy().booleanValue());
		if (voInfectionControlComponent.getCopy().booleanValue() == true)
			form.chkCopyPrevAssessment().setEnabled(false);
				
		form.ansMRSA().setValue(voInfectionControlComponent.getMRSA());
		if(voInfectionControlComponent.getMRSAIsNotNull() && voInfectionControlComponent.getMRSA().equals(YesNoUnknown.YES)){
			form.txtMRSA().setEnabled(true);
			form.txtMRSA().setValue(voInfectionControlComponent.getMRSAComment());
		}
		else
			form.txtMRSA().setEnabled(false);
		
		form.ansClostridium().setValue(voInfectionControlComponent.getClostridium());
		if(voInfectionControlComponent.getClostridiumIsNotNull() && voInfectionControlComponent.getClostridium().equals(YesNoUnknown.YES)){
			form.txtClostridium().setEnabled(true);
			form.txtClostridium().setValue(voInfectionControlComponent.getClostridiumComment());
		}
		else
			form.txtClostridium().setEnabled(false);
		
		form.ansVRE().setValue(voInfectionControlComponent.getVRE());
		if(voInfectionControlComponent.getVREIsNotNull() && voInfectionControlComponent.getVRE().equals(YesNoUnknown.YES)){
			form.txtVRE().setEnabled(true);
			form.txtVRE().setValue(voInfectionControlComponent.getVREComment());
		}
		else
			form.txtVRE().setEnabled(false);
		
		form.ansESBC().setValue(voInfectionControlComponent.getESBC());
		if(voInfectionControlComponent.getESBCIsNotNull() && voInfectionControlComponent.getESBC().equals(YesNoUnknown.YES)){
			form.txtESBC().setEnabled(true);
			form.txtESBC().setValue(voInfectionControlComponent.getESBCComment());
		}
		else
			form.txtESBC().setEnabled(false);
		
		form.ansTB().setValue(voInfectionControlComponent.getTB());
		if(voInfectionControlComponent.getTBIsNotNull() && voInfectionControlComponent.getTB().equals(YesNoUnknown.YES)){
			form.txtTB().setEnabled(true);
			form.txtTB().setValue(voInfectionControlComponent.getTBComment());		//wdev-10814
		}
		else
			form.txtTB().setEnabled(false);
		
		form.ansNorovirus().setValue(voInfectionControlComponent.getNorovirus());
		if(voInfectionControlComponent.getNorovirusIsNotNull() && voInfectionControlComponent.getNorovirus().equals(YesNoUnknown.YES)){
			form.txtNorovirus().setEnabled(true);
			form.txtNorovirus().setValue(voInfectionControlComponent.getNorovirusComment());
		}
		else
			form.txtNorovirus().setEnabled(false);
		
		form.txtNotes().setValue(voInfectionControlComponent.getNotes());
		form.ansInfectionControlReq().setValue(voInfectionControlComponent.getControlRequirement());
		
		// Populate the correct selected careplan template if one saved with the component
		if (voInfectionControlComponent.getCarePlanTemplate() != null && voInfectionControlComponent.getCarePlanTemplate().size() > 0)
		{
			GenForm.grdCarePlansRow cpRow;
			CarePlanTemplateCollection templateColl = voInfectionControlComponent.getCarePlanTemplate();
			CarePlanTemplate template;
			int i=0;
			// Find the correct row to set to selected
			for (int j=0; j<form.grdCarePlans().getRows().size(); j++)
			{
				cpRow = form.grdCarePlans().getRows().get(j);
				for (i=0; i<templateColl.size(); i++)
				{
					template = templateColl.get(i);
					if (cpRow.getValue().getID_CarePlanTemplate().equals(template.getID_CarePlanTemplate()))
					{
						cpRow.setcolSelected(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}
		
		if (voInfectionControlComponent.getInfectionControlAssessmentIsNotNull())
		{
			form.getGlobalContext().COE.setInfectionControlAssessment(voInfectionControlComponent.getInfectionControlAssessment());
		}
				
		form.chkSectionComplete().setValue(voInfectionControlComponent.getIsComplete().booleanValue());
		if (voInfectionControlComponent.getIsComplete().booleanValue() == true) // Complete
		{
			form.btnSave().setEnabled(false);
			form.setMode(FormMode.VIEW);
			form.chkCopyPrevAssessment().setEnabled(false);
			form.chkSectionComplete().setEnabled(false);
			form.grdCarePlans().setReadOnly(true);
		}
		
	}
	private void getLastAssessmentComponent() {
		InfectionControlComponentVo tmpInfectionControlComponent = (InfectionControlComponentVo)domain.getLastAssessmentComponent(form.getGlobalContext().Core.getPatientShort(), form.getGlobalContext().Core.getCurrentCareContext(),AssessmentComponentType.INFECTION_CONTROL);
		if (tmpInfectionControlComponent == null)
		{
			this.form.chkCopyPrevAssessment().setValue(false);
			return;
		}
		
		form.getLocalContext().setPrevInfectionControlComponent(tmpInfectionControlComponent);
		form.chkCopyPrevAssessment().setEnabled(true);
		
	}
	
	@Override
	protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getPrevInfectionControlComponent() == null)
			return;
		
		form.getLocalContext().getPrevInfectionControlComponent().setIsComplete(new Boolean(false));
		form.getLocalContext().getPrevInfectionControlComponent().setCarePlanTemplate(null);
		
		populateFormInfo(form.getLocalContext().getPrevInfectionControlComponent());
		form.chkCopyPrevAssessment().setValue(true);
		form.chkCopyPrevAssessment().setEnabled(false);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);
		form.getGlobalContext().COE.setInfectionControlAssessment(null);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			InfectionControlComponentVo voInfectionControlComponent = populateDataFromScreen();
			if (voInfectionControlComponent == null)
				return;
			
			AssessmentHeaderInfo newAssmnt = form.getLocalContext().getassmnt();
			
			if (newAssmnt.getCareContext() == null)
				newAssmnt.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
			if (newAssmnt.getClinicalContact() == null)
				newAssmnt.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
			newAssmnt = domain.saveComponent(newAssmnt, voInfectionControlComponent);
			form.getLocalContext().setInfectionControlComponent(voInfectionControlComponent);
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
			
			// If the careplan grid is not readonly, we may need to go to the careplanstep2 form
			if (form.grdCarePlans().getReadOnly() == false)
			{
				CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
				GenForm.grdCarePlansRow cpRow;
				for (int i=0; i<form.grdCarePlans().getRows().size(); i++)
				{
					cpRow = form.grdCarePlans().getRows().get(i);
					if (cpRow.getcolSelected() && !cpRow.isReadOnly())
						templList.add(cpRow.getValue());
				}
				if (templList.size() > 0)
				{
					form.getGlobalContext().COE.CarePlan.setTemplateList(templList);
					
					form.getGlobalContext().Nursing.setAssessmentComponent(voInfectionControlComponent);		
					
					engine.open(form.getForms().Nursing.CarePlanStep2);
				}
				else
					engine.open(form.getForms().Nursing.AdmissionAssessOverview);
			}
			else
				engine.open(form.getForms().Nursing.AdmissionAssessOverview);
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			// We may need to reset the current component value in GC for onFormOpen - if there was none previously
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(domain.getAssessment(form.getGlobalContext().Core.getCurrentCareContext()));
	
			onFormOpen();
			return;				
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(domain.getAssessment(form.getGlobalContext().Core.getCurrentCareContext()));
			
			onFormOpen();
			return;
		}
	}
	private InfectionControlComponentVo populateDataFromScreen() {
		InfectionControlComponentVo voInfectionControlComponent = form.getLocalContext().getInfectionControlComponent();
		if (voInfectionControlComponent == null)
		{
			voInfectionControlComponent = new InfectionControlComponentVo();
			voInfectionControlComponent.setComponentType(AssessmentComponentType.INFECTION_CONTROL);
		}
		
		voInfectionControlComponent.setIsComplete(new Boolean(this.form.chkSectionComplete().getValue()));
		voInfectionControlComponent.setCopy(new Boolean(this.form.chkCopyPrevAssessment().getValue()));	
		voInfectionControlComponent.setMRSA(form.ansMRSA().getValue());
		voInfectionControlComponent.setMRSAComment(form.txtMRSA().getValue());
		voInfectionControlComponent.setClostridium(form.ansClostridium().getValue());
		voInfectionControlComponent.setClostridiumComment(form.txtClostridium().getValue());
		voInfectionControlComponent.setVRE(form.ansVRE().getValue());
		voInfectionControlComponent.setVREComment(form.txtVRE().getValue());
		voInfectionControlComponent.setESBC(form.ansESBC().getValue());
		voInfectionControlComponent.setESBCComment(form.txtESBC().getValue());
		voInfectionControlComponent.setTB(form.ansTB().getValue());
		voInfectionControlComponent.setTBComment(form.txtTB().getValue());
		voInfectionControlComponent.setNorovirus(form.ansNorovirus().getValue());
		voInfectionControlComponent.setNorovirusComment(form.txtNorovirus().getValue());
		
		voInfectionControlComponent.setNotes(form.txtNotes().getValue());
		voInfectionControlComponent.setControlRequirement(form.ansInfectionControlReq().getValue());
		voInfectionControlComponent.setInfectionControlAssessment(form.getGlobalContext().COE.getInfectionControlAssessment());
		
		String[] messages = voInfectionControlComponent.validate();
		if (messages != null)
		{
			engine.showErrors("Validation Errors", messages);
			return null;
		}
		return voInfectionControlComponent;
	}
	@Override
	protected void onLnkRepeatableAssessmentClick() throws PresentationLogicException {
		InfectionControlComponentVo voInfectionControlComponent = populateDataFromScreen();
		if (voInfectionControlComponent == null)
			return;
		
		
		form.getGlobalContext().Nursing.setAssessmentComponent(voInfectionControlComponent);	
		engine.open(form.getForms().COE.InfectionControlRepeatableAssessment);
	}
	@Override
	protected void onAnsNorovirusValueChanged() throws PresentationLogicException {
		if(form.ansNorovirus().getValue()!=null && form.ansNorovirus().getValue().equals(YesNoUnknown.YES))
			form.txtNorovirus().setEnabled(true);
		else{
			form.txtNorovirus().setEnabled(false);
			form.txtNorovirus().setValue("");
		}
	}
	@Override
	protected void onAnsTBValueChanged() throws PresentationLogicException {
		if(form.ansTB().getValue()!=null && form.ansTB().getValue().equals(YesNoUnknown.YES))
			form.txtTB().setEnabled(true);
		else{
			form.txtTB().setEnabled(false);
			form.txtTB().setValue("");
		}
	}
	@Override
	protected void onAnsESBCValueChanged() throws PresentationLogicException {
		if(form.ansESBC().getValue()!=null && form.ansESBC().getValue().equals(YesNoUnknown.YES))
			form.txtESBC().setEnabled(true);
		else{
			form.txtESBC().setEnabled(false);
			form.txtESBC().setValue("");
		}
	}
	@Override
	protected void onAnsVREValueChanged() throws PresentationLogicException {
		if(form.ansVRE().getValue()!=null && form.ansVRE().getValue().equals(YesNoUnknown.YES))
			form.txtVRE().setEnabled(true);
		else{
			form.txtVRE().setEnabled(false);
			form.txtVRE().setValue("");
		}		
	}
	@Override
	protected void onAnsClostridiumValueChanged() throws PresentationLogicException {
		if(form.ansClostridium().getValue()!=null && form.ansClostridium().getValue().equals(YesNoUnknown.YES))
			form.txtClostridium().setEnabled(true);
		else{
			form.txtClostridium().setEnabled(false);
			form.txtClostridium().setValue("");
		}		
	}
	@Override
	protected void onAnsMRSAValueChanged() throws PresentationLogicException {
		if(form.ansMRSA().getValue()!=null && form.ansMRSA().getValue().equals(YesNoUnknown.YES))
			form.txtMRSA().setEnabled(true);
		else{
			form.txtMRSA().setEnabled(false);
			form.txtMRSA().setValue("");
		}
	}
	@Override
	protected void onLnkInfoClick() throws PresentationLogicException {
		if (form.getLocalContext().getInfectionControlComponent() != null && form.getLocalContext().getInfectionControlComponent().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getInfectionControlComponent().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}
		
	}
}
