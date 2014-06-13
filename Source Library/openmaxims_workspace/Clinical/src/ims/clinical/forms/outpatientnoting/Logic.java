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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.70 build 3545.21176)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.outpatientnoting;

//This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.70 build 3509.17128)
//Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.


import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		boolean bEnable = false;
		//form.lyrDetails().tabPagePreview().ccPreview().initialise();
//		grdProcOpsRow nRow = form.lyrDetails().tabPageFuturePlan().grdProcOps().getRows().newRow();
//		nRow.setValue(ProcedureHighCostDrug.FNA_BREAST_SEROMA_OR_LESION);
//		nRow.setcolProcHighCost(ProcedureHighCostDrug.FNA_BREAST_SEROMA_OR_LESION);
		//ProcedureHighCostDrug
		//form.btnStart().setVisible(false);
		/*
		if (domain.getDischargeDetails(form.getGlobalContext().Core.getCurrentCareContext()) != null)
		{
			
			form.btnStart().setVisible(false);
		}*/
		boolean	bEnable1 = true;
		form.lnkReturn().setVisible(engine.getPreviousNonDialogFormName().equals(form.getForms().Clinical.EDischargeList));
		/*	
		form.lyrDetails().tabPageDiagnosis().setHeaderEnabled(bEnable);
		form.lyrDetails().tabPageOpsProcs().setHeaderEnabled(bEnable);*/
		//form.lyrDetails().tabPageAlerts().setHeaderEnabled(bEnable1);
		form.lyrDetails().tabClinicalNoting().setHeaderEnabled(bEnable1);
		form.lyrDetails().tabPageAssessment().setHeaderEnabled(bEnable1);
		form.lyrDetails().tabPageMedication().setHeaderEnabled(bEnable1);
		form.lyrDetails().tabPagePreview().setHeaderEnabled(bEnable1);
		form.lyrDetails().tabPageReady().setHeaderEnabled(bEnable1);
		//form.lyrDetails().tabClinicalNoting().ccAllergies().setMode(FormMode.VIEW);
		//form.lyrDetails().tabPageAssessment().cc1().initialise();
		form.lyrDetails().tabDocuments().btnDocNext().setVisible(true);
		form.btnStart().setVisible(false);
		Date dt = new Date();
		for (int i=0 ; i<2; i++){
			
			
//			grdPrevoiusDiagnosesCoMorbiditesRow nRow1 =  form.lyrDetails().tabPageClinicalInfo().grdPrevoiusDiagnosesCoMorbidites().getRows().newRow();
//			nRow1.setColDCDesc("Diagnosis" + i);
//			nRow1.setColDCDate(dt.toPartialDate());
//			nRow1.setColInclude(true);
//			if(i == 0)
//				nRow1.setBackColor(Color.LightGreen);
		}
		updateControlsState();
		//form.lyrDetails().tabDocuments().cc3().
	}
	
	@Override
	protected void onBtnStartClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getMode().equals(FormMode.EDIT)){
			form.setMode(FormMode.VIEW);
		form.btnStart().setVisible(false);}
		else
			form.setMode(FormMode.EDIT);
		updateControlsState();
	}
	@Override
	protected void onLnkReturnClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	@Override
	protected void onlyrDetailsTabChanged(ims.framework.LayerBridge tab)
	{
		// TODO Add your code here.
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if (menuItemID == GenForm.ContextMenus.ClinicalNamespace.PatientCo.ADDDIAGNOSIS)
		{
			engine.open(form.getForms().Clinical.PatientCorrespondenceDiagnosisDialog);
		}
		else if(menuItemID == GenForm.ContextMenus.ClinicalNamespace.PatientCo.ADDCOMORBIDITY)
		{
			
		}
		else if(menuItemID == GenForm.ContextMenus.ClinicalNamespace.OutOfCountyRecipient.AddOutOfCountyRecipient)
		{
			engine.open(form.getForms().Clinical.OutOfCountyDialog);
		}
	}
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	public void clearInstanceControls()
	{
		// TODO: Add you code here.
	}
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
		return false;
	}
	public void updateControlsState()
	{
		form.getContextMenus().Clinical.getPatientCoADDDIAGNOSISItem().setVisible(true);
		form.getContextMenus().Clinical.getPatientCoADDCOMORBIDITYItem().setVisible(true);
		form.getContextMenus().Clinical.getProcedureHighMenuADDPROCEDUREItem().setVisible(true);
		form.getContextMenus().Clinical.getProcedureHighMenuADDHIGHCOSTDRUGItem().setVisible(true);
		form.getContextMenus().Clinical.getOutOfCountyRecipientAddOutOfCountyRecipientItem().setVisible(true);
		
			
	}
	public void updateInstance()
	{
		
	}

	
	@Override
	protected void onChkClinicalDetailsValueChanged()
			throws PresentationLogicException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onBtnCancelCorrespondenceClick()
			throws PresentationLogicException {
		form.setMode(FormMode.VIEW);
		
	}
	@Override
	protected void onBtnEditClincalNotingClick()
			throws PresentationLogicException {
		form.setMode(FormMode.EDIT);
		
	}
	@Override
	protected void onBtnEditCorrespondenceClick()
			throws PresentationLogicException {
		form.setMode(FormMode.EDIT);
		
	}
	@Override
	protected void onBtnEditMedicationClick() throws PresentationLogicException {
		form.setMode(FormMode.EDIT);
		
	}
	@Override
	protected void onBtnEditPreviewClick() throws PresentationLogicException {
		form.setMode(FormMode.EDIT);
		
	}
	@Override
	protected void onBtnNextClinicalNotingClick()
			throws PresentationLogicException {
		form.setMode(FormMode.VIEW);
		
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException {
		// TODO Auto-generated method stub
		
	}
}
