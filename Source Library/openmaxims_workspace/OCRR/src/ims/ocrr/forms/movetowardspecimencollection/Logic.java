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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4772.16308)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.movetowardspecimencollection;

import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.PatientShort;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.ocrr.vo.OrderSpecimenListVo;
import ims.ocrr.vo.SpecimenWorkListItemListVo;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.SpecimenCollectionMethod;
import ims.ocrr.vo.lookups.SpecimenCollectionStatus;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialise();
	}

	private void initialise()
	{
		populateHospitalAndWardControls();

		Date date = form.getLocalContext().getSpecimenWorkListItem().getDateToCollect();
		Time time = new Time(0, 0);
		form.dtimCollection().setValue(new DateTime(date, time));
	}

	private void populateHospitalAndWardControls()
	{
		SpecimenWorkListItemListVo specimenWorkListItem = domain.getSpecimenWorklistItem(form.getGlobalContext().OCRR.getMoveToWardDetails().getSpecimenId());
		PatientShort patientShort = domain.getPatient(specimenWorkListItem.getSpecimen().getOrder().getPatient().getID_Patient());
		
		form.getLocalContext().setSpecimenWorkListItem(specimenWorkListItem);
		form.getGlobalContext().Core.setPatientShort(patientShort);

		LocShortMappingsVoCollection coll = domain.listActiveHospitals();

		LocationLiteVo patientWard = domain.getPatientWard(specimenWorkListItem.getSpecimen().getOrder().getPatient().getWard().getID_Location());
		LocationLiteVo hospital = null;

		if (patientWard != null)
		{
			hospital = domain.getHospitalForCurrentLocation(patientWard.getID_Location());
		}

		for (int i = 0; i < coll.size(); i++)
		{
			form.cmbHospital().newRow(coll.get(i), coll.get(i).getName());
		}

		form.cmbHospital().setValue(hospital);

		if (patientWard != null)
		{
			form.qmbWard().newRow(patientWard, patientWard.getName().toString());
			form.qmbWard().setValue(patientWard);
		}

	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		SpecimenWorkListItemListVo specimenWorkListItem = form.getLocalContext().getSpecimenWorkListItem();

		//WDEV-16582
		if (specimenWorkListItem.getWard() != null) //this means the round was already closed and the screen should be refreshed 
		{
			form.getGlobalContext().OCRR.getMoveToWardDetails().setIsRoundClosed(Boolean.TRUE);
			engine.showMessage("Round was closed by another user. Screen will be refreshed.");
			engine.close(DialogResult.OK);
			return;
		}
		
		if (saveWorkListItem(specimenWorkListItem))
			engine.close(DialogResult.OK);
	}

	private boolean saveWorkListItem(SpecimenWorkListItemListVo specimenWorkListItem)
	{
		specimenWorkListItem.setCollectionStatus(SpecimenCollectionStatus.FORCOLLECTION);
		specimenWorkListItem.setListType(SpecimenCollectionMethod.WARDCOLLECTION);
		specimenWorkListItem.setDateToCollect(form.dtimCollection().getValue() != null ? form.dtimCollection().getValue().getDate() : null);
		specimenWorkListItem.setTimeToCollect(form.dtimCollection().getValue() != null ? form.dtimCollection().getValue().getTime() : null);
		specimenWorkListItem.setRoundToCollect(null);
		
		OrderSpecimenListVo item = specimenWorkListItem.getSpecimen(); //WDEV-16898

		for (int j = 0; item.getInvestigationsIsNotNull() && j < item.getInvestigations().size(); j++)
		{
			// cancelled investigations will not be modified
			if (item.getInvestigations().get(j).getInvestigationIsNotNull() && item.getInvestigations().get(j).getOrdInvCurrentStatusIsNotNull() && item.getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatusIsNotNull() && (!item.getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatus().equals(OrderInvStatus.CANCEL_REQUEST) && !item.getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatus().equals(OrderInvStatus.CANCELLED)))
			{
				item.getInvestigations().get(j).setRequiredByDate(form.dtimCollection().getValue());
			}
		}

		String[] errors = specimenWorkListItem.validate(validateUIRules());
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			domain.saveWorkListItem(specimenWorkListItem);
		}
		catch (StaleObjectException e)
		{
			if (domain.getSpecimenWorklistItem(form.getLocalContext().getSpecimenWorkListItem().getID_SpecimenWorkListItem()).getWard() != null)
			{
				form.getGlobalContext().OCRR.getMoveToWardDetails().setIsRoundClosed(Boolean.TRUE);
				engine.showMessage("Round was closed by another user. Screen will be refreshed.");
			}
			else
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			
			return true;
		}

		return true;
	}

	private String[] validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.dtimCollection().getValue() == null)
		{
			listOfErrors.add("Collection Time is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		return result;
	}

	@Override
	protected void onQmbWardTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		if (value != null)
		{
			form.qmbWard().clear();

			LocShortVoCollection voLocShortMapColl = domain.listActiveWardsForHospital(form.cmbHospital().getValue(), value);

			for (int i = 0; i < voLocShortMapColl.size(); i++)
			{
				form.qmbWard().newRow(voLocShortMapColl.get(i), voLocShortMapColl.get(i).getName().toString());
			}

			if (voLocShortMapColl.size() == 1)
			{
				form.qmbWard().setValue(voLocShortMapColl.get(0));
			}
			else if (voLocShortMapColl.size() > 1)
			{
				form.qmbWard().showOpened();
			}
		}
	}

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException
	{
		form.qmbWard().clear();
		form.qmbWard().setEnabled(form.cmbHospital().getValue() != null);
	}
}
