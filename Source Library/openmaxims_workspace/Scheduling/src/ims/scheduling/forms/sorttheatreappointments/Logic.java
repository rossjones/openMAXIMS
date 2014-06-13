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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3467.22451)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.sorttheatreappointments;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.scheduling.forms.sorttheatreappointments.GenForm.grdApptsRow;
import ims.scheduling.forms.sorttheatreappointments.GenForm.grdSessionsRow;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.BookingAppointmentTheatreVoCollection;
import ims.scheduling.vo.Sch_Session_Appointment_OrderVo;
import ims.scheduling.vo.SessionLiteVo;
import ims.scheduling.vo.SessionLiteVoCollection;
import ims.scheduling.vo.SessionTheatreTCISlotLiteVo;
import ims.scheduling.vo.lookups.LookupHelper;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.scheduling.vo.lookups.TCITime;
import ims.scheduling.vo.lookups.TCITimeCollection;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final int  TCICOLINDEX	= 6;
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
		
		if(engine.getParentDialogFormName() != null
			&& engine.getParentDialogFormName().equals(form.getForms().CAREUK.BookTheatreDialog) 
			&& form.getGlobalContext().Scheduling.getAppointmentIdsIsNotNull())
			engine.open(form.getForms().Scheduling.PrintAppointment);
	}
	
	private void initialize()
	{
		//if we have a Session in the context - auto-select it and find the Sch_Session_Appointment_OrderVo record to populate screen
		if(form.getGlobalContext().Scheduling.getTheatreSessionIsNotNull())
		{
			Sch_Session_Appointment_OrderVo voSessionApptOrder = domain.getSessionApptOrderBySession(form.getGlobalContext().Scheduling.getTheatreSession());
			if(voSessionApptOrder  == null)
			{
				engine.showMessage("No Appts Booked for this Session");
				return;
			}
			
			form.getLocalContext().setSessApptOrder(voSessionApptOrder);
			if(voSessionApptOrder.getSessionIsNotNull() && voSessionApptOrder.getSession().getSessionDateIsNotNull())
			{
				form.dteSession().setValue(voSessionApptOrder.getSession().getSessionDate());
				//Search Sessions and select the row
				searchSessions();
				form.grdSessions().setValue(voSessionApptOrder.getSession());
			}	
		}
		
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.grdAppts().setColHospitalNoCaption(dispIdType.getText());

	}

	private void open()
	{
		form.getLocalContext().setEditingTCI(false);
		form.setMode(FormMode.VIEW);
		clearInstanceControls();
	
		if(form.grdSessions().getValue() != null)
			grdSessionsSelectionChanged();			
		
		updateControlState();
	}
	
	private void populateScreenFromData(Sch_Session_Appointment_OrderVo voSessionApptOrder)
	{
		if(voSessionApptOrder == null)
			return;
		
		if(voSessionApptOrder.getSessionIsNotNull())
		{
			
			form.txtDate().setValue(voSessionApptOrder.getSession().getSessionDate().toString());
			
			form.txtTheatreDetail().setValue(voSessionApptOrder.getSession().getName());
			if(voSessionApptOrder.getFinalisedByIsNotNull())
				form.txtFinalisedBy().setValue(voSessionApptOrder.getFinalisedBy().toString());
				
			if(voSessionApptOrder.getFinalisedDateTimeIsNotNull())
				form.txtFinalisedDT().setValue(voSessionApptOrder.getFinalisedDateTime().toString());
				
			if(voSessionApptOrder.getSession().getListOwnersIsNotNull())
				form.txtListOwner().setValue(voSessionApptOrder.getSession().getListOwners().toString());
				
			if(voSessionApptOrder.getSession().getTheatreProceduresRemainingIsNotNull() && voSessionApptOrder.getSession().getTheatreProceduresRemaining().getProcedureDetailsIsNotNull()){
				
				form.txtProcedure().setValue(voSessionApptOrder.getSession().getTheatreProceduresRemaining().getProcedureDetails().toString());
				form.txtProcedure().setTooltip(voSessionApptOrder.getSession().getTheatreProceduresRemaining().getProcedureDetails().toString());
			}
		}
		
		if(voSessionApptOrder.getAppointmentsIsNotNull())
		{
			populateAppointmentsGridFromData(voSessionApptOrder.getAppointments());
		}
	}

	/**
	 * @param voAppts
	 */
	private void populateAppointmentsGridFromData(BookingAppointmentTheatreVoCollection voAppts)
	{
		for(BookingAppointmentTheatreVo voAppt : voAppts)
		{
			if(voAppt.getApptStatus().equals(Status_Reason.CANCELLED)
					|| voAppt.getApptStatus().equals(Status_Reason.DNA))
				continue;
				
			grdApptsRow aRow = form.grdAppts().getRows().newRow();
			
			//WDEV-11777 - keep the currently selected TheatreSlot in memory as we may need to update
			aRow.setColCurrentTheatreSlot(voAppt.getTheatreSlot());
			
			if(voAppt.getPatientIsNotNull())
			{
				if (voAppt.getPatient().getDisplayId() != null) 
					aRow.setColHospitalNo(voAppt.getPatient().getDisplayId().getValue());
				if(voAppt.getPatient().getNameIsNotNull())
				{
					aRow.setColSurname(voAppt.getPatient().getName().getSurname());
					aRow.setColForename(voAppt.getPatient().getName().getForename());
				}
				if(voAppt.getPatient().getSexIsNotNull())
					aRow.setColSex(voAppt.getPatient().getSex().getText());
				if(voAppt.getPatient().getDobIsNotNull())
					aRow.setColDob(voAppt.getPatient().getDob().toString());
			}
			if(voAppt.getTheatreBookingIsNotNull())
			{
				//WDEV-11777 cater for old type (TCITime Lookup)
				if(voAppt.getTheatreBooking().getTCITimeIsNotNull())
				{
					//WDEV-12674 load the tcitype lookup for slots that are done in this way
					TCITimeCollection collTCI = LookupHelper.getTCITime(domain.getLookupService());
					for(int i=0; i<collTCI.size(); i++)
					{
						aRow.getColComeInTime().newRow(collTCI.get(i), collTCI.get(i).getText());
					}
					
					//tcitime lookup instance was inactivated
					if(!collTCI.contains(voAppt.getTheatreBooking().getTCITime()))
						aRow.getColComeInTime().newRow(voAppt.getTheatreBooking().getTCITime(), voAppt.getTheatreBooking().getTCITime().getText());
						
					aRow.getColComeInTime().setValue(voAppt.getTheatreBooking().getTCITime());
				}
				else
				{
					if(voAppt.getTheatreSlotIsNotNull())
					{
						if(voAppt.getSessionIsNotNull() && voAppt.getSession().getTheatreSlotsIsNotNull())
						{
							voAppt.getSession().getTheatreSlots().sort();
							//load theatre slots for session
							for(SessionTheatreTCISlotLiteVo voSlot : voAppt.getSession().getTheatreSlots())
							{
								if((voSlot.getAppointment() == null && (voSlot.getStatusIsNotNull() && voSlot.getStatus().equals(Status_Reason.SLOTOPENED))) || voSlot.equals(voAppt.getTheatreSlot()))
									aRow.getColComeInTime().newRow(voSlot, voSlot.getToComeInTime().toString());
							}
						}
						aRow.getColComeInTime().setValue(voAppt.getTheatreSlot());
					}
				}
				
				if(voAppt.getTheatreBooking().getProcedureIsNotNull())
				{
					aRow.setColProcedure(voAppt.getTheatreBooking().getProcedure().getProcedureName());
					aRow.setTooltipForColProcedure(voAppt.getTheatreBooking().getProcedure().getProcedureName());
				}
			}
			aRow.setValue(voAppt);
		}
	}

	private void updateControlState()
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			if(form.getLocalContext().getSessApptOrderIsNotNull() && form.getLocalContext().getSessApptOrder().getFinalisedDateTime() == null)
			{
				form.btnEdit().setVisible(true);
				form.btnFinalise().setVisible(true);
			}
			else
			{
				form.btnEdit().setVisible(false);
				form.btnFinalise().setVisible(false);
			}
		}
		else
		{
			for(int i=0;i<form.grdAppts().getRows().size(); i++)
				form.grdAppts().getRows().get(i).setColComeInTimeReadOnly(true);
		}

		
		updateContextMenuState();	
	}

	private void updateContextMenuState()
	{
		form.getContextMenus().Scheduling.hideAllSortTheatreAppointmentsMenuItems();
		if(form.getMode().equals(FormMode.EDIT))
		{
			if(form.getLocalContext().getEditingTCIIsNotNull() && form.getLocalContext().getEditingTCI())
				return;
			
			if(form.grdAppts().getRows().size() > 1)
			{
				form.getContextMenus().Scheduling.getSortTheatreAppointmentsSORTTCIItem().setVisible(true);
				
				if(form.grdAppts().getSelectedRow() != null)
				{
					if(form.grdAppts().canMoveCurrentUp())
						form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEUPItem().setVisible(true);
					if(form.grdAppts().canMoveCurrentDown())
						form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEDOWNItem().setVisible(true);
				}
			}
			if(form.grdAppts().getSelectedRow() != null)
			{
				//WDEV-12170 - only allow editing TCI for 'Booked' status
				if(form.grdAppts().getValue() != null)
					if(form.grdAppts().getValue().getCurrentStatusRecordIsNotNull())
						if(form.grdAppts().getValue().getCurrentStatusRecord().getStatusIsNotNull())
							if(form.grdAppts().getValue().getCurrentStatusRecord().getStatus().equals(Status_Reason.BOOKED))
								form.getContextMenus().Scheduling.getSortTheatreAppointmentsEDITTCITIMEItem().setVisible(true);
			}
		}
	}

	private void clearInstanceControls()
	{
		form.txtTheatreDetail().setValue("");
		form.txtListOwner().setValue("");
		form.txtDate().setValue("");
		form.txtFinalisedBy().setValue("");
		form.txtProcedure().setValue("");
		form.txtProcedure().setTooltip(" ");
		form.txtFinalisedDT().setValue("");
		form.grdAppts().getRows().clear();
	}

	@Override
	protected void onGrdApptsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenuState();
	}
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onBtnFinaliseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = populateDataFromScreen();
		voSessApptOrder.setFinalisedBy((IMos)domain.getMosUser());
		voSessApptOrder.setFinalisedDateTime(new DateTime());
		if(save(voSessApptOrder))
			open();
	}

	private boolean save(Sch_Session_Appointment_OrderVo voSessApptOrder)
	{
		String[] arrErrors = voSessApptOrder.validate(getUIValidation());
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
	
		try
		{
			domain.saveSessionApptOrder(voSessApptOrder);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			
			//WDEV-11908
			open();
			return false;
		}
		
		return true;
	}
	private String[] getUIValidation()
	{
		List<String> errors = new ArrayList<String>();

		for(int i=0;i<form.grdAppts().getRows().size(); i++)
		{
			grdApptsRow row = form.grdAppts().getRows().get(i);
			if(row.getColComeInTime().getValue() == null)
				errors.add("Come In Time is mandatory");
		}
		
		return errors.size() > 0 ? errors.toArray(new String[0]) : null;
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = populateDataFromScreen();
		if(save(voSessApptOrder))
		{
			open();
		}
	}
	private Sch_Session_Appointment_OrderVo populateDataFromScreen()
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = form.getLocalContext().getSessApptOrder();
		if(voSessApptOrder == null)
			return null;
		
		BookingAppointmentTheatreVoCollection voCollTheatreAppt = new BookingAppointmentTheatreVoCollection();
		for(int i=0;i<form.grdAppts().getRows().size();i++)
		{
			grdApptsRow apptsRow = form.grdAppts().getRows().get(i);
			BookingAppointmentTheatreVo voAppt = apptsRow.getValue();
			
			//WDEV-11777
			if(apptsRow.getColComeInTime().getValue() instanceof TCITime)
				voAppt.getTheatreBooking().setTCITime((TCITime) apptsRow.getColComeInTime().getValue());
			else
			{
				//do a compare here to see it the slot has changed if so set the old slot into the unmapped (ChangeSlotFrom) field in the vo
				if(apptsRow.getColCurrentTheatreSlot() != null && apptsRow.getColComeInTime().getValue() instanceof SessionTheatreTCISlotLiteVo)
				{
					if(!apptsRow.getColCurrentTheatreSlot().equals((SessionTheatreTCISlotLiteVo)apptsRow.getColComeInTime().getValue()))
					{
						voAppt.setChangeSlotFrom(apptsRow.getColCurrentTheatreSlot());
						//voAppt.setApptStartTime(((SessionTheatreSlotLiteVo)apptsRow.getColComeInTime().getValue()).getToComeInTime());
					}
				}
		
				voAppt.setTheatreSlot((SessionTheatreTCISlotLiteVo) apptsRow.getColComeInTime().getValue());
				//nulling this to overwite the old type as we may select a time instead of the existing lookup type
				voAppt.getTheatreBooking().setTCITime(null); 
			}
			voCollTheatreAppt.add(voAppt);
		}
		
		voSessApptOrder.setAppointments(voCollTheatreAppt);
			
		return voSessApptOrder;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-11868
		if(form.getLocalContext().getEditingTCIIsNotNull() && form.getLocalContext().getEditingTCI())
			open();
		else
			engine.close(DialogResult.CANCEL);
	}
	@Override
	
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.SchedulingNamespace.SortTheatreAppointments.MOVEUP :
				form.grdAppts().moveUp();
				updateContextMenuState();
			break;
			case GenForm.ContextMenus.SchedulingNamespace.SortTheatreAppointments.MOVEDOWN :
				form.grdAppts().moveDown();
				updateContextMenuState();
			break;
			case GenForm.ContextMenus.SchedulingNamespace.SortTheatreAppointments.SORTTCI :
				//WDEV-9690
				SortOrder sortOrder = form.getLocalContext().getTCISortOrder();
				if(sortOrder == null)
					sortOrder = SortOrder.ASCENDING;
				else if(sortOrder == SortOrder.ASCENDING)
					sortOrder = SortOrder.DESCENDING;
				else if(sortOrder == SortOrder.DESCENDING)
					sortOrder = SortOrder.ASCENDING;
				
				form.getLocalContext().setTCISortOrder(sortOrder);
							
				//WDEV-11777
				BookingAppointmentTheatreVoCollection voCollAppts = form.grdAppts().getValues();
				voCollAppts.sort(BookingAppointmentTheatreVo.getTCIComparator(sortOrder));
				form.grdAppts().getRows().clear();
				populateAppointmentsGridFromData(voCollAppts);
				
				updateControlState();
			break;
			case GenForm.ContextMenus.SchedulingNamespace.SortTheatreAppointments.EDITTCITIME :
				form.getLocalContext().setEditingTCI(true);
				if(form.grdAppts().getSelectedRow() != null)
					form.grdAppts().getSelectedRow().setColComeInTimeReadOnly(false);
					
				updateContextMenuState();
			break;
			default:
		}
	}

	@Override
	protected void onGrdSessionsSelectionChanged() throws PresentationLogicException
	{
		grdSessionsSelectionChanged();
	}

	private void grdSessionsSelectionChanged()
	{
		Sch_Session_Appointment_OrderVo voSessionApptOrder = domain.getSessionApptOrderBySession(form.grdSessions().getValue());
		clearInstanceControls();
		form.getLocalContext().setSessApptOrder(voSessionApptOrder);

		updateControlState();
		if(voSessionApptOrder  == null)
		{
			engine.showMessage("No Appts Booked for this Session");
			return;
		}
		
		populateScreenFromData(voSessionApptOrder);
	}

	@Override
	
	protected void onImbClearClick() throws PresentationLogicException
	{
		clearScreen();		
		form.btnEdit().setVisible(false);
		form.btnFinalise().setVisible(false);
	}

	private void clearScreen()
	{
		form.dteSession().setValue(null);
		form.grdSessions().getRows().clear();
		clearInstanceControls();
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		searchSessions();
	}

	private void searchSessions()
	{
		if(form.dteSession().getValue() == null)
		{
			engine.showErrors(new String[] {"Session Date is mandatory"});
			return;
		}
		
		form.grdSessions().getRows().clear();
		clearInstanceControls();		
		
		SessionLiteVoCollection voCollSession = domain.listSessionByDate(form.dteSession().getValue());
		if(voCollSession != null)
		{
			for(SessionLiteVo voSession : voCollSession)
			{
				grdSessionsRow sRow = form.grdSessions().getRows().newRow();
				sRow.setColSession(voSession.getName());
				sRow.setValue(voSession);
			}
		}
		
		if(form.getMode().equals(FormMode.VIEW)){
			form.btnEdit().setVisible(false);
			form.btnFinalise().setVisible(false);
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
	}
}
