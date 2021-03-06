// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.canceltciforpatientelectivelistdialog;

import java.util.ArrayList;

import ims.RefMan.vo.ElectiveTCIForReferralDetailsVo;
import ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo;
import ims.RefMan.vo.lookups.AdmissionOfferOutcome;
import ims.RefMan.vo.lookups.AdmissionOfferOutcomeCollection;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.enums.MosType;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.interfaces.IMos;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		form.ccMos().initialize(MosType.ALL);
		form.ccMos().isRequired(Boolean.TRUE);
		form.ccMos().setValue((IMos) domain.getMosUser());
		form.dtimCancelled().setValue(new DateTime());
		populateCancelationType(); // WDEV-18390 
	}

	private void populateCancelationType()
	{
		form.cmbCancellationType().clear();
		
		AdmissionOfferOutcomeCollection cancelationType = ims.RefMan.vo.lookups.LookupHelper.getAdmissionOfferOutcome(domain.getLookupService());

		for (int i = 0; cancelationType != null && i < cancelationType.size(); i++)
		{
			if (!AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_PATIENT_2.equals(cancelationType.get(i)) &&
				!AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7.equals(cancelationType.get(i)) &&	
				!AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6.equals(cancelationType.get(i)))
				continue;

			form.cmbCancellationType().newRow(cancelationType.get(i), cancelationType.get(i).toString());
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (!validateUiRules())
			return;

		TCIOutcomeForPatientElectiveListVo tciOutcome = form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList();
		
		if (tciOutcome == null)
			tciOutcome = new TCIOutcomeForPatientElectiveListVo();

		tciOutcome.setCancelTheatreAppointment(Boolean.FALSE);
		tciOutcome.setChangeBy((MemberOfStaffRefVo) form.ccMos().getValue());
		tciOutcome.setOutcome(form.cmbCancellationType().getValue());
		tciOutcome.setStatusDateTime(form.dtimCancelled().getValue());
		tciOutcome.setCancelledForNonMedicalReason(form.chkCancelledForNonMedicalReason().getValue());	//wdev-18419
		
		form.getGlobalContext().RefMan.setTCIOutcomeForPatientElectiveList(tciOutcome);
		
		//WDEV-18541
		if (tciOutcome.getTciId() != null)
		{
			ElectiveTCIForReferralDetailsVo tciDetails = domain.getTCIDetails(tciOutcome.getTciId());
			
			if (tciDetails != null && tciDetails.getAppointment() != null && tciDetails.getAppointment().getTheatreBooking() != null 
				&& Status_Reason.BOOKED.equals(tciDetails.getAppointment().getApptStatus()) && tciDetails.getAppointment().getAppointmentDate() != null
				&& tciDetails.getAppointment().getAppointmentDate().isGreaterOrEqualThan(new Date()))
			{
				engine.showMessage("Would you like to cancel the associated Theatre Appointment ?", "Warning", MessageButtons.YESNO, MessageIcon.WARNING);
				return;
			}
		}

		engine.close(DialogResult.OK);
	}

	private boolean validateUiRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.cmbCancellationType().getValue() == null)
		{
			listOfErrors.add("Cancellation Type is mandatory.");
		}

		if (form.ccMos().getValue() == null)
		{
			listOfErrors.add("Cancelled By is mandatory.");
		}

		if (form.dtimCancelled().getValue() == null)
		{
			listOfErrors.add("Cancelled Date/Time is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (DialogResult.YES.equals(result))
		{
			form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().setCancelTheatreAppointment(Boolean.TRUE);
		}
		
		engine.close(DialogResult.OK);
	}
}
