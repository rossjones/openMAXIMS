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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.20 build 40713.1615)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.careplanreview;

import ims.alerts.PatientAlert;
import ims.alerts.PatientAllergy;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.CarePlanReviewVo;
import ims.core.vo.PatientShort;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocMostVoCollection;
import ims.core.vo.PatientShortCollection;
import ims.nursing.forms.careplanreview.GlobalContext.COEContext.CarePlanReviewContext;
import ims.nursing.vo.CarePlanOverview;
import ims.nursing.vo.CarePlanOverviewCollection;
import ims.nursing.vo.CarePlanStatus;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.core.vo.lookups.LocationType;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		// List Hosptals and add to Hospital combo
		fillHospitalListCombo();

		form.imbRefresh().setEnabled(false);

		open();

	}

	private void fillHospitalListCombo()
	{
		LocMostVo locationFilter = new LocMostVo();
		locationFilter.setType(LocationType.HOSP);
		locationFilter.setIsActive(Boolean.TRUE);
		// Wards are used in 2 different tabs so if wards already retrieved dont
		// hit DB
		LocMostVoCollection voCollHospitals = null;
		voCollHospitals = domain.listLocations(locationFilter);
		if (voCollHospitals != null)
		{
			for (int i = 0; i < voCollHospitals.size(); i++)
			{
				form.cmbHospital().newRow(voCollHospitals.get(i), voCollHospitals.get(i).getName());
			}
		}

	}

	protected void open() throws ims.framework.exceptions.FormOpenException
	{
		// Select the Chosen Ward in combo

		if ((engine.getPreviousNonDialogFormName() != null) && (engine.getPreviousNonDialogFormName().equals(form.getForms().Nursing.CarePlanDetails)) && (form.getGlobalContext().Core.getHospital() != null) && (form.getGlobalContext().Core.getWard() != null))
		{
			if (form.getGlobalContext().COE.CarePlanReview.getSearchCriteria() != null)
			{

				form.cmbHospital().setValue(form.getGlobalContext().COE.CarePlanReview.getSearchCriteria().getHospital());

				try
				{
					onCmbHospitalValueChanged();
					form.cmbWard().setValue(form.getGlobalContext().COE.CarePlanReview.getSearchCriteria().getWard());

					onCmbWardValueChanged();

					form.cmbPatient().setValue(form.getGlobalContext().COE.CarePlanReview.getSearchCriteria().getCareContextVo());

					onCmbPatientValueChanged();
					
/*					if (form.grdCarePlans().getRows().get(0).getValue()!= null )
					form.grdCarePlans().setValue(form.grdCarePlans().getRows().get(0).getValue());
*/					
					// onBtnOKClick();
				}
				catch (PresentationLogicException e)
				{
					throw new FormOpenException();
				}
			}
		}

		form.btnConfirm().setEnabled(false);
		form.btnReviewHistory().setEnabled(false);
	}

	protected void onBtnReviewHistoryClick() throws ims.framework.exceptions.PresentationLogicException
	{

		form.getGlobalContext().Nursing.setShowCarePlanRvwDialog(Boolean.TRUE);
		form.getGlobalContext().COE.setCarePlanID(form.grdCarePlans().getValue().getID_CarePlan());
		engine.open(form.getForms().Nursing.CarePlanReviewDialog);
	}

	protected void onCmbPatientValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbHospital().getValue() == null)
			return;

		if (form.cmbWard().getValue() == null)
			return;

		if (form.cmbPatient().getValue() == null)
			return;

		PatientShort ps = null;
		if (form.cmbPatient().getValue() != null)
			ps = domain.getPatientFromCareContext(form.cmbPatient().getValue());

		if (ps != null)
		{
			// Set Chosen Patient in Context
			form.getGlobalContext().Core.setPatientShort(ps);
			form.getGlobalContext().Core.setCurrentCareContext(form.cmbPatient().getValue()); //WDEV-16082

			// TODO: code no longer valid, so commented out
			// form.getGlobalContext().Core.setCurrentClinicalContact(clinicalContactShortVo);
			// domain.setCurrentClinicalContactId(form.cmbPatient().getValue());

			// Set the selected patient information in the Engine
			if (ps.getIsDead().booleanValue())
			{
				engine.setPatientInfo(ps.getPatientInfo(), Color.getColor(ConfigFlag.UI.RIP_INFO_COLOUR.toString()));
			}
			else
			{
				engine.setPatientInfo(ps.getPatientInfo());
			}

			engine.clearAlerts();
			if (ps.getHasAlerts() != null && ps.getHasAlerts().booleanValue())
				engine.addAlert(new PatientAlert("The patient has alerts."));
			if (ps.getHasAllergies() != null && ps.getHasAllergies().booleanValue())
				engine.addAlert(new PatientAllergy("The patient has allergies."));
		}

		onImbRefreshClick();
		
		
		
		form.imbRefresh().setEnabled(true);
	}

	protected void onCmbWardValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// We need to call the InpatientEpisode list for the ward selected
		if (form.cmbWard().getValue() == null)
			return;

		form.imbRefresh().setEnabled(false);
		form.cmbPatient().clear();
		form.grdCarePlans().getRows().clear();
		LocMostVo voWard = form.cmbWard().getValue();
		form.getGlobalContext().Core.setWard(voWard);

		CareContextShortVoCollection voContactShortcoll = domain.listCareContexts(voWard);
		PatientShortCollection voPatientShortColl = new PatientShortCollection();

		String strDisplay = "";
		for (int i = 0; i < voContactShortcoll.size(); i++)
		{
			CareContextShortVo contactShortVo = voContactShortcoll.get(i);
			PatientShort patientShort = domain.getPatientFromCareContext(contactShortVo);

			if (patientShort == null)
				continue;

			strDisplay = "";
			strDisplay += patientShort.getName().toShortForm();
			if (patientShort.getDisplayId() != null)
			{
				strDisplay += " - ";
				strDisplay += patientShort.getDisplayId().getValue();
			}

			form.cmbPatient().newRow(contactShortVo, strDisplay);
			voPatientShortColl.add(patientShort);
		}

		form.cmbPatient().setValue(form.getGlobalContext().Core.getCurrentCareContext());

		PatientShort ps = form.getGlobalContext().Core.getPatientShort();
		// Now select the previous patient displayed
		if ((engine.getPreviousNonDialogFormName() != null) && (engine.getPreviousNonDialogFormName().equals(form.getForms().Nursing.CarePlanDetails)) && (ps != null))
		{
			CareContextShortVo clinicalContactSelect = findEpis(voContactShortcoll, ps);
			form.cmbPatient().setValue(clinicalContactSelect);
		}

		onCmbPatientValueChanged();
	}

	private CareContextShortVo findEpis(CareContextShortVoCollection coll, PatientShort ps)
	{
		for (int i = 0; i < coll.size(); i++)
		{
			if (coll.get(i) != null && ps != null)
			{
				PatientShort patShort = domain.getPatientFromCareContext(coll.get(i));
				if (patShort != null)
				{
					if (patShort.equals(ps))
						return coll.get(i);
				}
			}
		}
		return null;
	}

	protected void onBtnConfirmClick() throws ims.framework.exceptions.PresentationLogicException
	{
		CarePlanReviewVo careplan = new CarePlanReviewVo();
		careplan.setCareContextVo(form.cmbPatient().getValue());
		careplan.setHospital(form.cmbHospital().getValue());
		careplan.setWard(form.cmbWard().getValue());

		form.getGlobalContext().COE.CarePlanReview.setSearchCriteria(careplan);
		form.getGlobalContext().COE.setCarePlanID(form.grdCarePlans().getValue().getID_CarePlan());
		engine.open(form.getForms().Nursing.CarePlanDetails);
	}

	protected void onGrdCarePlansSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.btnConfirm().setEnabled(true);
		form.btnReviewHistory().setEnabled(true);
	}

	protected void onCmbHospitalValueChanged() throws PresentationLogicException
	{
		form.cmbPatient().clear();
		form.cmbWard().clear();
		form.grdCarePlans().getRows().clear();
		if (form.cmbHospital().getValue() == null)
			return;

		LocMostVo voHospital = form.cmbHospital().getValue();
		form.getGlobalContext().Core.setHospital(voHospital);
		if (form.cmbHospital().getValue().getType() != null)
		{
			if (form.cmbHospital().getValue().getType().equals(LocationType.HOSP))
			{
				fillWardListCombo();
			}
		}

	}

	private void fillWardListCombo()
	{
		form.imbRefresh().setEnabled(false);
		LocMostVo filter = new LocMostVo();
		filter.setType(LocationType.WARD);
		filter.setIsActive(Boolean.TRUE);
		filter.setParentLocation(form.cmbHospital().getValue());

		LocMostVoCollection voColl = domain.listLocations(filter);
		for (int i = 0; i < voColl.size(); i++)
		{
			LocMostVo ward = voColl.get(i);
			form.cmbWard().newRow(ward, ward.getName());
		}

	}

	protected void onImbRefreshClick() throws PresentationLogicException
	{
		// We need to call the InpatientEpisode list for the ward selected
		form.grdCarePlans().getRows().clear();
		if (form.cmbPatient().getValue() != null)
		{
			CarePlanStatus statusFilter = new CarePlanStatus();
			statusFilter.setStatus(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE);
			CarePlanOverviewCollection epColl = domain.listCarePlansForReview(form.cmbPatient().getValue(), statusFilter);

			CarePlanOverview voCpr;
			GenForm.grdCarePlansRow row;
			if (epColl != null)
			{
				for (int i = 0; i < epColl.size(); i++)
				{
					voCpr = epColl.get(i);
					row = form.grdCarePlans().getRows().newRow();
					row.setcolCarePlan(voCpr.getTitle());
					if (voCpr.getNextEvaluationDate() != null)
						row.setcolEvaluationDate(voCpr.getNextEvaluationDate().toString());
					if (voCpr.getLastReviewedDate() != null)
						row.setColDateReview(voCpr.getLastReviewedDate().toString());
					if (voCpr.getLastReviewedBy() != null)
						row.setColBy(voCpr.getLastReviewedBy().getName().toString());

					// If the careplan evaluation is due today, set the row
					// Orange
					if (voCpr.getNextEvaluationDate() != null && voCpr.getNextEvaluationDate().equals(new ims.framework.utils.Date()))
						row.setBackColor(Color.Orange);
					// If the careplan is overdue, set the row red
					if (voCpr.getNextEvaluationDate() != null && voCpr.getNextEvaluationDate().isLessThan(new ims.framework.utils.Date()))
						row.setBackColor(Color.LightCoral);

					row.setValue(voCpr);
				}
			}
		}
		form.btnConfirm().setEnabled(false);
		form.btnReviewHistory().setEnabled(false);

	}
}
