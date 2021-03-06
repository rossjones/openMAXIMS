// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface ExternalEvents extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.RefMan.vo.IFCATSExternalEventVo getCATSIFValues(ims.ocs_if.vo.IfOrderInvestigationVo investigationRef, Boolean includeApptStatus);

	// Generated from form domain interface definition
	public ims.scheduling.vo.IfPatientLocationVo getPatientLocFromAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appointment) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.patient.vo.PatientRefVo getPatientFromAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appointment) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderFromInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.ExternalEventVo updateEventVoWithInvestigation(ims.scheduling.vo.ExternalEventVo event) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentRefVo getLatestAppointmentForInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo invRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void generateOrderCancelAsRequestedEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo inv) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void generateOrderNumberAllocatedEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void setCATSReferralHasRejectedInv(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvRef) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updates status of all Booked appointments to Arrived for a particularUBRN
	*/
	public void setAppointmentArrivedForUBRN(ims.core.patient.vo.PatientRefVo patient, String uBRN, String maximsApptId, ims.framework.utils.DateTime arrivalDateTime) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void acceptReferralFromInvestigation(ims.ocs_if.vo.IfOrderInvestigationVo inv) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.vo.interfaces.IHL7OutboundMessageHandler getEvent(ims.ocs_if.vo.QueuedEventVo event);
}
