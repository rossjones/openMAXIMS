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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseSessionAdminImpl extends DomainImpl implements ims.scheduling.domain.SessionAdmin, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistSession(ims.scheduling.vo.Sch_ProfileRefVo profile, ims.scheduling.vo.DirectoryofServiceRefVo dos, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProfile(String profileName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistDos(String dosName)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSession(ims.scheduling.vo.SessionVo session, Boolean editingSlots)
	{
		if(editingSlots == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'editingSlots' of type 'Boolean' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetSession(ims.scheduling.vo.SessionShortVo sessionShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelSession(ims.scheduling.vo.Sch_SessionRefVo session, ims.scheduling.vo.Appointment_StatusVo apptCancelStatus, Boolean cancelAppointment, Boolean isFlexible)
	{
		if(session == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'session' of type 'ims.scheduling.vo.Sch_SessionRefVo' cannot be null.");
		if(apptCancelStatus == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'apptCancelStatus' of type 'ims.scheduling.vo.Appointment_StatusVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatecancelSlot(ims.scheduling.vo.SessionSlotVo sessionSlot, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateJourney(ims.scheduling.domain.objects.Booking_Appointment doAppt, Boolean isCancel)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.careuk.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProcedureByHcpAndName(ims.core.resource.people.vo.HcpRefVoCollection hcps, String name)
	{
		if(hcps == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'hcps' of type 'ims.core.resource.people.vo.HcpRefVoCollection' cannot be null.");
		if(name == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'name' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveSessionForMaxContinuousTime(ims.scheduling.vo.SessionShortVo session)
	{
		if(session == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'session' of type 'ims.scheduling.vo.SessionShortVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatereOpenTheatreTCISlot(ims.scheduling.domain.objects.SessionTheatreTCISlot doTheatreSlot)
	{
		if(doTheatreSlot == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'doTheatreSlot' of type 'ims.scheduling.domain.objects.SessionTheatreTCISlot' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetTheatreSession(ims.scheduling.vo.Sch_SessionRefVo session)
	{
	}
}
