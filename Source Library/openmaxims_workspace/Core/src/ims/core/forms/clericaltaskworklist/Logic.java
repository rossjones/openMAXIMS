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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.forms.clericaltaskworklist;

import ims.core.forms.clericaltaskworklist.GenForm.grdClericalTaskRow;
import ims.core.vo.ClericalTaskWorklistSearchVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.PatientClericalTaskVo;
import ims.core.vo.PatientClericalTaskVoCollection;
import ims.core.vo.PatientIdListVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.PatIdType;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.ocrr.vo.lookups.PatientClericalTaskStatus;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	private void open() 
	{
		if(form.getGlobalContext().Core.getClericalTaskWorklistSearchIsNotNull())
		{
			populateSearchCriteriaScreenFromData(form.getGlobalContext().Core.getClericalTaskWorklistSearch());
			search();
		}
		
		form.setMode(FormMode.VIEW);
		
	}
	private void populateSearchCriteriaScreenFromData(ClericalTaskWorklistSearchVo criteria) 
	{
		clearScreen();
		
		if(criteria == null)
			return;
		
		form.txtSurname().setValue(criteria.getSurname());
		form.txtForename().setValue(criteria.getForename());
		form.txtHospitalNo().setValue(criteria.getHospitalNo());
		form.ccRequestor().setValue(criteria.getRequestor());
		form.ccAllocate().setValue(criteria.getAllocatedTo());
		form.cmbCurrentStatus().setValue(criteria.getStatus());
		form.dteFromDate().setValue(criteria.getDateFrom());
		form.dteToDate().setValue(criteria.getDateTo());
		
	}

	private void clearScreen() 
	{
		//clear search criteria
		form.txtSurname().setValue(null);
		form.txtForename().setValue(null);
		form.txtHospitalNo().setValue(null);
		
		form.ccRequestor().clear();
		form.ccAllocate().clear();
		form.cmbCurrentStatus().setValue(null);
		
		form.dteFromDate().setValue(null);
		form.dteToDate().setValue(null);
		
		//clear grid and row selected
		form.grdClericalTask().getRows().clear();
		form.grdClericalTask().setValue(null);
		updateSearchTotal(0);
		
	}

	private boolean search()
	{
		if(isSearchCriteriaValid())
		{
			populateScreenFromData(domain.listClericalTasks(populateSearchCriteriaDataFromScreen()));
			//update total
			updateSearchTotal(form.grdClericalTask().getRows().size());
						
			if(form.grdClericalTask().getRows().size() == 0)
				engine.showMessage("No records found.");
			
			return true;
		}
		
		return false;	
		
	}
	
	private ClericalTaskWorklistSearchVo populateSearchCriteriaDataFromScreen() 
	{
		ClericalTaskWorklistSearchVo criteria=new ClericalTaskWorklistSearchVo();
		criteria.setSurname(form.txtSurname().getValue());
		criteria.setForename(form.txtForename().getValue());
		criteria.setHospitalNo(form.txtHospitalNo().getValue());
		criteria.setRequestor((MemberOfStaffLiteVo) form.ccRequestor().getValue());
		criteria.setAllocatedTo((MemberOfStaffLiteVo) form.ccAllocate().getValue());
		criteria.setStatus((PatientClericalTaskStatus)form.cmbCurrentStatus().getValue());
		criteria.setDateFrom(form.dteFromDate().getValue());
		criteria.setDateTo(form.dteToDate().getValue());
		
		return criteria;
	}

	private void populateScreenFromData(PatientClericalTaskVoCollection listClericalTasks) 
	{
		form.grdClericalTask().getRows().clear();
		
		if(listClericalTasks == null || listClericalTasks.size() == 0)
			return;
		
		for(int i=0;i<listClericalTasks.size();i++)
		{
			PatientClericalTaskVo record=listClericalTasks.get(i);
			if(record == null)
				continue;
			
			addPatientClericalTaskDetailsRow(record);
			
		}
		
	}
	private void addPatientClericalTaskDetailsRow(PatientClericalTaskVo record) 
	{
		if(record == null)
			return;
		
		 grdClericalTaskRow row = form.grdClericalTask().getRows().newRow();
		 
		  PatientIdListVoCollection identifiers = record.getPatient().getIdentifiers();
		  
		 for (int i=0;i<identifiers.size();i++)
		 {
			if (identifiers.get(i).getType().equals(PatIdType.HOSPNUM))
				row.setcolHospitalNo(identifiers.get(i).getValue().toString());
			if (identifiers.get(i).getType().equals(PatIdType.NHSN))
				row.setcolNHSNumber(identifiers.get(i).getValue().toString());	
		 }  
		  
		 row.setcolSurname(record.getPatient().getName().getSurname());	
		 row.setTooltipForcolSurname(record.getPatient().getName().getSurname());
		 
		 row.setcolForname(record.getPatient().getName().getForename());
		 row.setTooltipForcolForname(record.getPatient().getName().getForename());
		 
		 row.setcolDOB(record.getPatient().getDob());
		 
		 row.setcolRequestor(record.getRequestor().toString());
		 row.setTooltipForcolRequestor(record.getRequestor().toString());
		 
		 row.setcolAllocated(record.getAllocatedTo().toString());
		 row.setTooltipForcolAllocated(record.getAllocatedTo().toString());
		 
		 row.setcolRequestedDateTime(record.getRequestedDateTime().toString());
		 
		 row.setcolStatus(record.getStatus().toString());
		 
		 if (record.getStatus().equals(PatientClericalTaskStatus.COMPLETED) && record.getCompletedBy() != null)
		 {
			 row.setTooltipForcolStatus("Completed By: "+record.getCompletedBy().toString()+"<br>Completed On: "+record.getCompletedDateTime().toString());//
		 }
		row.setValue(record);
	}
	private boolean isSearchCriteriaValid() 
	{
		ArrayList<String> uiErrors = new ArrayList<String>();
		
		Date dateFrom = form.dteFromDate().getValue();
		Date dateTo = form.dteToDate().getValue();
		
		if (form.txtForename().getValue()==null && form.txtSurname().getValue()==null && form.txtHospitalNo().getValue()==null && form.ccRequestor().getValue()==null && form.ccAllocate().getValue()==null && form.cmbCurrentStatus().getValue()==null && form.dteFromDate().getValue()==null && form.dteToDate().getValue()==null)
		{
			uiErrors.add("At least one search criteria must be provided!");
		}
		
		if (dateFrom != null && dateTo != null && dateTo.isLessThan(dateFrom))
		{
			uiErrors.add("'Date From' can not be greater than 'Date To'");
		}
		
		if (uiErrors.size() > 0)
		{
			engine.showErrors(uiErrors.toArray(new String[uiErrors.size()]));
			return false;
		}
		
		return true;
	}
	
	protected void onGrdClericalTaskSelectionChanged()
	{
		//FB latest changes for WDEV-13879 - 12.01.2012
		if (domain.getMosUser() == null)//WDEV-15411
		{
			engine.showMessage("Only MOS users can access this form! Current user is not a MOS user.");
			form.grdClericalTask().setValue(null);
			return ;
		}
		
		if (form.grdClericalTask().getValue() instanceof PatientClericalTaskVo)
		{
			form.getGlobalContext().Core.setPatientClericalTask(form.grdClericalTask().getValue());
			
			//WDEV-14080	
			PatientShort patientShort = new PatientShort(form.getGlobalContext().Core.getPatientClericalTask().getPatient().getID_Patient(), form.getGlobalContext().Core.getPatientClericalTask().getPatient().getVersion_Patient());
			form.getGlobalContext().Core.setPatientShort(patientShort);
			
			engine.open(form.getForms().Core.PatientClericalTaskDialog,false);//FB latest changes for WDEV-13879 - 13.01.2012(to hide [X] button when opening from Clerical Task Worklist )	
		}
		
	}
	
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		form.getGlobalContext().Core.setClericalTaskWorklistSearch(null);//WDEV-14080
	}
	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (search())
		{
			form.getGlobalContext().Core.setClericalTaskWorklistSearch(populateSearchCriteriaDataFromScreen());
		}
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		//WDEV-14080
		form.getGlobalContext().Core.setPatientClericalTask(null);
		form.getGlobalContext().Core.setPatientShort(null);
		
		open();
	}
	private void updateSearchTotal(int count)
	{
		form.lblTotal().setValue("Total : " + count);
	}
}
