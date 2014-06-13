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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2382.34788)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.careuk.vo.CatsReferralRefVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientShort;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.IAppRole;
import ims.ocrr.configuration.domain.objects.Container;
import ims.ocrr.configuration.domain.objects.PathInvDetails;
import ims.ocrr.configuration.domain.objects.Specimen;
import ims.ocrr.domain.ClinicalImagingResults;
import ims.ocrr.domain.ResultDialog;
import ims.ocrr.domain.SelectandOrder;
import ims.ocrr.domain.base.impl.BaseOrderSummaryDialogImpl;
import ims.ocrr.helper.IOCRRSchedulingHelper;
import ims.ocrr.orderingresults.domain.objects.OcsOrderSession;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.OrderSpecimen;
import ims.ocrr.orderingresults.domain.objects.OrderSpecimenContainer;
import ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus;
import ims.ocrr.orderingresults.domain.objects.SpecimenWorkListItem;
import ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection;
import ims.ocrr.vo.OcsOrderShortVo;
import ims.ocrr.vo.OcsOrderSummaryVo;
import ims.ocrr.vo.OcsOrderVo;
import ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection;
import ims.ocrr.vo.OrderInvestigationListVo;
import ims.ocrr.vo.OrderInvestigationListVoCollection;
import ims.ocrr.vo.OrderInvestigationLiteVo;
import ims.ocrr.vo.PathologySpecimenOrderInvestigationVo;
import ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo;
import ims.ocrr.vo.domain.OcsOrderShortVoAssembler;
import ims.ocrr.vo.domain.OcsOrderSummaryVoAssembler;
import ims.ocrr.vo.domain.OcsOrderVoAssembler;
import ims.ocrr.vo.domain.OrderInvestigationListVoAssembler;
import ims.ocrr.vo.domain.OrderInvestigationLiteVoAssembler;
import ims.ocrr.vo.domain.PathologySpecimenOrderInvestigationVoAssembler;
import ims.ocrr.vo.enums.ORDERSTATE;
import ims.ocrr.vo.lookups.AuthorisationOrderStatus;
import ims.ocrr.vo.lookups.Category;
import ims.ocrr.vo.lookups.InvEventType;
import ims.ocrr.vo.lookups.InvestigationStatusChangeReason;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.SpecimenCollectionStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public class OrderSummaryImpl extends BaseOrderSummaryDialogImpl
{
	private static final long serialVersionUID = 1L;
	private static final Logger		LOG		= Logger.getLogger(OrderSummaryImpl.class);


	public OcsOrderSummaryVo getOrderSummary(OcsOrderSessionRefVo voOcsOrderRef) //WDEV-16232
	{
		if(voOcsOrderRef == null || voOcsOrderRef.getID_OcsOrderSession() == null)//WDEV-16232
			throw new DomainRuntimeException("Order ref is null");
		
		OcsOrderSession doOcsOrder = (OcsOrderSession) getDomainFactory().getDomainObject(voOcsOrderRef);//WDEV-16232
		OcsOrderSummaryVo voOcsOrder = OcsOrderSummaryVoAssembler.create(doOcsOrder);
		
		//WDEV-12054
		HashMap map = new HashMap();
		List results = new ArrayList(doOcsOrder.getInvestigations()); //convert set to list
		ClinicalImagingResults impl = (ClinicalImagingResults) getDomainImpl(ClinicalImagingResultsImpl.class);
		map = impl.getListXoHistory(map, results);
		
		OrderInvestigationListVoCollection voCollInvs = OrderInvestigationListVoAssembler.createOrderInvestigationListVoCollectionFromOrderInvestigation(results);
		
		if(voCollInvs != null)
		{
			for(OrderInvestigationListVo voResult : voCollInvs)
			{
				if(map.containsKey(voResult.getID_OrderInvestigation()))
				{
					voResult.setOrdInvXOStatusHistory((OrdInvXOStatusHistoryLiteVoCollection) map.get(voResult.getID_OrderInvestigation()));
				}
			}
		}
		
		voOcsOrder.setInvestigations(voCollInvs);
		return voOcsOrder;		
	}

	public OcsOrderShortVo getOrderDetails(OcsOrderSessionRefVo voOcsOrderRef)//WDEV-16232
	{
		if(voOcsOrderRef == null)
			throw new CodingRuntimeException("Order ref is null");
		
		return OcsOrderShortVoAssembler.create((OcsOrderSession) getDomainFactory().getDomainObject(voOcsOrderRef));//WDEV-16232	
	}
	

	/**
	 * WDEV-13999
	 * Retrieve full Order details
	 */
	public OcsOrderVo getOrderFullDetails(OcsOrderSessionRefVo order)//WDEV-16232
	{
		if (order == null || !order.getID_OcsOrderSessionIsNotNull())//WDEV-16232
			throw new CodingRuntimeException("Order ref is null");
		
		return OcsOrderVoAssembler.create((OcsOrderSession) getDomainFactory().getDomainObject(order));//WDEV-16232
	}


	public void authoriseOrder(OcsOrderSessionRefVo voOcsOrderRef) throws StaleObjectException//WDEV-16232
	{
		if(voOcsOrderRef == null)
			throw new CodingRuntimeException("Order ref is null");
		
		DomainFactory factory = getDomainFactory();
		OcsOrderSession doOcsOrder = (OcsOrderSession)factory.getDomainObject(voOcsOrderRef);//WDEV-16232
		updateOrder(factory, doOcsOrder, ORDERSTATE.AUTHORISING);
	}

	private void setDefaults(OrderInvestigation doOrderInv, ORDERSTATE state)
	{		
		//WDEV-13409 - don't authorise individual cancelled investigations if they are part of a valid order
		if (state != null && state.equals(ORDERSTATE.AUTHORISING))
		{
			if(doOrderInv.getOrdInvCurrentStatus() != null && doOrderInv.getOrdInvCurrentStatus().getOrdInvStatus() != null)
			{
				if(doOrderInv.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCEL_REQUEST)) || doOrderInv.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCELLED)))
				{
					return;
				}
			}
		}

		OrderedInvestigationStatus status = new OrderedInvestigationStatus();
		if (this.getSession().getUser() != null)
			status.setChangeUser(this.getSession().getUser().getUserRealName());

		status.setChangeDateTime(new java.util.Date());
		status.setProcessedDateTime(new java.util.Date());
		
		if(state.equals(ORDERSTATE.REQUESTING_AUTHORISATION))
		{
			status.setOrdInvStatus(getDomLookup(OrderInvStatus.AWAITING_AUTHORISATION));
			status.setStatusReason("Awaiting Authorisation");
		}
		else if (state.equals(ORDERSTATE.AUTHORISING))
		{
			status.setOrdInvStatus(getDomLookup(OrderInvStatus.ORDERED));
			status.setStatusReason("Ordered");
		}
		else if (state.equals(ORDERSTATE.CANCELLED))
		{
			status.setOrdInvStatus(getDomLookup(OrderInvStatus.CANCELLED));
			status.setStatusReason("Cancelled");
		}
		
		doOrderInv.setOrdInvCurrentStatus(status);
		doOrderInv.getOrdInvStatusHistory().add(doOrderInv.getOrdInvCurrentStatus());
	}

	private void updateOrder(DomainFactory factory, OcsOrderSession doOcsOrder, ORDERSTATE state) throws StaleObjectException//WDEV-16232
	{
		if(state == ORDERSTATE.AUTHORISING)
			doOcsOrder.setAuthorisationOrderStatus( getDomLookup(AuthorisationOrderStatus.AUTHORISED));
		else if(state == ORDERSTATE.CANCELLED)
			doOcsOrder.setAuthorisationOrderStatus( getDomLookup(AuthorisationOrderStatus.CANCELLED));
		
		Iterator it1 = doOcsOrder.getInvestigations().iterator();
		OrderInvestigation doOrderInvest;
		while(it1.hasNext())
		{
			doOrderInvest = (OrderInvestigation) it1.next();
			
			if (!getDomLookup(OrderInvStatus.CANCEL_REQUEST).equals(doOrderInvest.getOrdInvCurrentStatus().getOrdInvStatus())
					&& !getDomLookup(OrderInvStatus.CANCELLED).equals(doOrderInvest.getOrdInvCurrentStatus().getOrdInvStatus()))
			{
				setDefaults(doOrderInvest, state);
			}
		}
		
		//if we are cancelling do a get on the order to get the current specimen ids
		//then delete from worklistitem with the specimen id		
		if(state == ORDERSTATE.CANCELLED)
		{
			OcsOrderSession doCurrentOcsOrder = (OcsOrderSession) factory.getDomainObject(OcsOrderSession.class, doOcsOrder.getId().intValue());//WDEV-16232
			String idsValues = getSpecimenIds(doCurrentOcsOrder);
			
			if(idsValues != null && !idsValues.equals(""))
			{
				try
				{
					factory.delete("from SpecimenWorkListItem item where item.specimen.id in ( " + idsValues + " ) ");
				}
				catch (ForeignKeyViolationException e)
				{
					throw new CodingRuntimeException ("delete of SpecimenWorkListItem failed - Foreign Key Violation in updateOcsOrder");
				}
			}
		}
		else if(state == ORDERSTATE.AUTHORISING)
		{
			//for each specimen list its work list items and update the collection status to FORCOLLECTION
			String idsValues = getSpecimenIds(doOcsOrder);
			
			String dftInvestigationsID = getDFTInvestigationID(doOcsOrder);
			
			if(idsValues != null && !idsValues.equals(""))
			{
				List workListItems = factory.find("from SpecimenWorkListItem item where item.specimen.id in ( " + idsValues + " ) ");
				if(workListItems != null && workListItems.size() > 0)
				{
					Iterator it3 = workListItems.iterator();
					while (it3.hasNext())
					{
						SpecimenWorkListItem item = (SpecimenWorkListItem) it3.next();
						if(state == ORDERSTATE.AUTHORISING)
							item.setCollectionStatus( getDomLookup( SpecimenCollectionStatus.FORCOLLECTION));
						else if(state == ORDERSTATE.CANCELLED)
							item.setCollectionStatus( getDomLookup( SpecimenCollectionStatus.CANCELLED));
						
						factory.save(item);
					}
				}
			}
			
			if (dftInvestigationsID != null && !dftInvestigationsID.equals(""))
			{
				List<?> worklistItems = factory.find("from SpecimenWorkListItem item where item.dFTOrderInvestigation.id in ( " + dftInvestigationsID + " ) ");
				
				if (worklistItems != null && worklistItems.size() > 0)
				{
					Iterator<?> specimenWorklistIterator = worklistItems.iterator();
					
					while (specimenWorklistIterator.hasNext())
					{
						SpecimenWorkListItem item = (SpecimenWorkListItem) specimenWorklistIterator.next();
						item.setCollectionStatus(getDomLookup(SpecimenCollectionStatus.FORCOLLECTION));
						factory.save(item);
					}
				}
			}
		}
		
		//update the order
		factory.save(doOcsOrder);
	}

	private String getDFTInvestigationID(OcsOrderSession doOcsOrder)
	{
		Iterator<?> investigationIterator = doOcsOrder.getInvestigations().iterator();
		
		StringBuilder dftIDValues = new StringBuilder();
		
		while (investigationIterator.hasNext())
		{
			OrderInvestigation investigation = (OrderInvestigation) investigationIterator.next();
			
			if (!getDomLookup(OrderInvStatus.CANCEL_REQUEST).equals(investigation.getOrdInvCurrentStatus().getOrdInvStatus())
					&& !getDomLookup(OrderInvStatus.CANCELLED).equals(investigation.getOrdInvCurrentStatus().getOrdInvStatus()))
			{
				if (getDomLookup(InvEventType.TIME_SERIES).equals(investigation.getInvestigation().getEventType()))
				{
					if (dftIDValues.length() > 0)
						dftIDValues.append(", ");
					dftIDValues.append(investigation.getId());
				}
			}
		}

		return dftIDValues.toString();
	}

	private String getSpecimenIds(OcsOrderSession doOcsOrder)//WDEV-16232
	{
		Iterator it2 = doOcsOrder.getSpecimens().iterator();
		String idsValues = "";
		while (it2.hasNext())
		{
			OrderSpecimen doSpecimen = (OrderSpecimen) it2.next();
			
			// Check if Order Specimen has all investigations cancelled then do not add the ID
			if (!areAllInvestigationsCancelled(doSpecimen))
			{
				if(idsValues.length() > 0)
					idsValues += ",";

				idsValues += doSpecimen.getId();
			}
		}
		return idsValues;
	}

	public void cancelOrder(OcsOrderSessionRefVo voOcsOrderRef) throws StaleObjectException//WDEV-16232
	{
		if(voOcsOrderRef == null)
			throw new CodingRuntimeException("Order ref is null");
		
		DomainFactory factory = getDomainFactory();
		OcsOrderSession doOcsOrder = (OcsOrderSession) factory.getDomainObject(voOcsOrderRef);//WDEV-16232
		updateOrder(factory, doOcsOrder, ORDERSTATE.CANCELLED);
	}

	/**
	 * for each orderinv set the status to CANCEL_REQUEST and where it has
	 * an orderinvappt record call generateOrderCancelEvent 
	 */
	public void cancelOrderInvestigations(PatientShort patient, OrderInvestigationRefVoCollection collOrderInvestigation, InvestigationStatusChangeReason changeReason, String comment) throws StaleObjectException, ForeignKeyViolationException
	{
		if(collOrderInvestigation == null || collOrderInvestigation.size() == 0)
			throw new CodingRuntimeException("collOrderInvestigation is null or empty in method generateOrderCancelEvent");
		
		DomainFactory factory = getDomainFactory();
		String hql = "from OrderInvestigation ordInv where ordInv.id in (" + getIdString(collOrderInvestigation) + ")";
		List<?> doOrdInvs = factory.find(hql);
		
		// Hash map with containers to be modified
		HashMap<OrderSpecimenContainer, ArrayList<Container>> containersToBeModified = new HashMap<OrderSpecimenContainer, ArrayList<Container>>(); 
		
		if(doOrdInvs != null && doOrdInvs.size() > 0)
		{
			Iterator<?> it = doOrdInvs.iterator();
			while(it.hasNext())
			{
				//WDEV-5740
				OrderInvestigation doOrderInv = (OrderInvestigation) it.next();
				OrderedInvestigationStatus status = new OrderedInvestigationStatus();
				status.setOrdInvStatus(getDomLookup(OrderInvStatus.CANCEL_REQUEST));
				status.setChangeDateTime(new java.util.Date());
				status.setProcessedDateTime(new java.util.Date());
				status.setStatusReason("OrderInvestigation Cancelled from UI " + "Comment: " + comment);
				status.setChangeUser(getHcpLiteUser() != null ? ((HcpLiteVo)getHcpLiteUser()).getIMosName() : null );
				status.setStatusChangeReason(getDomLookup(changeReason));
				doOrderInv.setOrdInvCurrentStatus(status);
				doOrderInv.getOrdInvStatusHistory().add(status);
				
				//WDEV-13430
				setWasProcessed(doOrderInv);
				
				storeCancelledContainers(containersToBeModified, patient, doOrderInv);
				
				factory.save(doOrderInv);
			}
		}
		
		updateOrderSpecimenContainers(containersToBeModified);
		
		//WDEV-12898 for each order investigation get its specimen and then in turn any corresponding specimenworklistitem's and update the status to cancelled if all invs for that specimen are cancelled
		updateSpecimenWorkListItems(doOrdInvs);
		updateSpecimenWorkListItemsForDFT(doOrdInvs);
	}

	
	private void updateOrderSpecimenContainers(HashMap<OrderSpecimenContainer, ArrayList<Container>> containersToBeModified) throws StaleObjectException, ForeignKeyViolationException
	{
		Set<OrderSpecimenContainer> keys = containersToBeModified.keySet();
		
		for (OrderSpecimenContainer container : keys)
		{
			ArrayList<Container> configuredContainers = containersToBeModified.get(container);
			
			if (container.getContainer().getVolume() != null && container.getContainer().getVolume() != 0)
			{
				if (configuredContainers != null)
				{
					Float volumeToBeSubstracted = 0.0f;

					for (Container configuredContainer : configuredContainers)
					{
						volumeToBeSubstracted += configuredContainer.getVolume();
					}

					Float updatedRequiredVolume = container.getRequiredVolume() - volumeToBeSubstracted;
					Integer updateContainerQuantity = (int) Math.ceil(updatedRequiredVolume / container.getContainer().getVolume());

					// Update container
					container.setRequiredVolume(updatedRequiredVolume);
					container.setContainerQuantity(updateContainerQuantity);

					// Save container
					getDomainFactory().save(container);
				}
			}
			else
			{
				if (configuredContainers != null)
				{
					// Update container
					container.setContainerQuantity(areAllInvestigationsCancelledForContainer(container.getOrderInvestigation()) ? 0 : 1);
					
					// Save container
					getDomainFactory().save(container);
				}
			}
		}
	}

	//WDEV-17126
	private boolean areAllInvestigationsCancelledForContainer(List orderInvestigation)
	{
		if (orderInvestigation == null)
			return true;

		for (int i = 0; i < orderInvestigation.size(); i++)
		{
			OrderInvestigation curentInv = (OrderInvestigation) orderInvestigation.get(i);

			if (curentInv.getOrdInvCurrentStatus() != null)
			{
				if (!(curentInv.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCEL_REQUEST)) || curentInv.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCEL_REQUEST))))
					return false;
			}
		}

		return true;
	}

	/**
	 * When cancelling an Order Investigation then recalculate the OrderSpecimenContainers
	 */
	private void storeCancelledContainers(HashMap<OrderSpecimenContainer, ArrayList<Container>> containersToBeModified, PatientShort patient, OrderInvestigation orderInvestigation)
	{
		if (!getDomLookup(Category.PATHOLOGY).equals(orderInvestigation.getInvestigation().getInvestigationIndex().getCategory()))
			return;

		boolean usePediatricContainers = isUsePaedContainer(patient);

		Iterator<?> containerIterator = orderInvestigation.getContainer().iterator();

		while (containerIterator.hasNext())
		{
			OrderSpecimenContainer container = (OrderSpecimenContainer) containerIterator.next();

			// Get the values for the container
			ArrayList<Container> configurationContainers = containersToBeModified.get(container);
			if (configurationContainers == null)
				configurationContainers = new ArrayList<Container>();

			// Iterate configuration Specimens in the investigation - for now there should be only one specimen
			// until COMPLEX investigations are implemented
			PathInvDetails pathologyDetails = orderInvestigation.getInvestigation().getPathInvDetails();

			Iterator<?> specimensIterator = pathologyDetails.getSpecimens().iterator();
			while (specimensIterator.hasNext())
			{
				Specimen specimen = (Specimen) specimensIterator.next();

				// Check to see if adult container is used
				if (!usePediatricContainers)
				{
					Iterator<?> adultContainersIterator = specimen.getAdultContainers().iterator();
					while (adultContainersIterator.hasNext())
					{
						Container adultContainer = (Container) adultContainersIterator.next();
						if (container.getContainer().getId().equals(adultContainer.getSpecContainer().getId()))
						{
							configurationContainers.add(adultContainer);
						}
					}
				}
				else	// Pediatric containers are used
				{
					Iterator<?> pediatricContainersIterator = specimen.getPaediatricContainers().iterator();
					while (pediatricContainersIterator.hasNext())
					{
						Container pediatricContainer = (Container) pediatricContainersIterator.next();
						if (container.getContainer().getId().equals(pediatricContainer.getSpecContainer().getId()))
						{
							configurationContainers.add(pediatricContainer);
						}
					}
					
					// Also check alternate containers
					// This will work if the investigation is not configured with the container from pediatric in the alternative containers
					Iterator<?> alternateContainersIterator = specimen.getAlternativePaediatricContainers().iterator();
					while (alternateContainersIterator.hasNext())
					{
						Container alternateContainer = (Container) alternateContainersIterator.next();
						if (container.getContainer().getId().equals(alternateContainer.getSpecContainer().getId()))
						{
							configurationContainers.add(alternateContainer);
						}
					}
				}
			}
			
			// Update the configuration containers in the HashMap
			containersToBeModified.put(container, configurationContainers);
		}
	}
	
	private boolean isUsePaedContainer(PatientShort patient)
	{
		int cfgAge = ConfigFlag.GEN.PAEDIATRIC_AGE.getValue();
		int patAge = -1;

		Integer iAge = patient.calculateAge();
		if (iAge != null)
			patAge = patient.calculateAge().intValue();

		if (patAge > cfgAge || patAge == -1)
			return false;

		return true;
	}

	
	
	/**
	 * @param doOrderInv
	 */
	private void setWasProcessed(OrderInvestigation doOrderInv)
	{
		//WDEV-13430 - setting WasProcessed
		//1.
		doOrderInv.setWasProcessed(true);	
		if(doOrderInv.getSpecimen() != null && doOrderInv.getSpecimen().size() > 0)    //wdev-16488
		{
			//2.
			if(((OrderSpecimen)doOrderInv.getSpecimen().get(0)).getInvestigations() != null)
			{
				Iterator itWasProcess = ((OrderSpecimen) doOrderInv.getSpecimen().get(0)).getInvestigations().iterator();
				int countCancelledInvestigations = 0;
				while(itWasProcess.hasNext())
				{
					OrderInvestigation doOrdInvItem = (OrderInvestigation) itWasProcess.next();
					if(doOrdInvItem.getOrdInvCurrentStatus() != null && doOrdInvItem.getOrdInvCurrentStatus().getOrdInvStatus() != null)
						if(doOrdInvItem.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCELLED)) || doOrdInvItem.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCEL_REQUEST)))
							countCancelledInvestigations++;
				}
				
				if(countCancelledInvestigations > 0 && (countCancelledInvestigations == ((OrderSpecimen) doOrderInv.getSpecimen().get(0)).getInvestigations().size()))
					((OrderSpecimen) doOrderInv.getSpecimen().get(0)).setWasProcessed(true);
			}
		}
		
		//3.
		if(doOrderInv.getOrderDetails() != null)
		{
			if(doOrderInv.getOrderDetails().getInvestigations() != null)
			{
				int countCancelledInvestigations = 0;
				Iterator itInvestigation = doOrderInv.getOrderDetails().getInvestigations().iterator();
				while(itInvestigation.hasNext())
				{
					OrderInvestigation doOrderInvItem = (OrderInvestigation) itInvestigation.next();
					if(doOrderInvItem.getOrdInvCurrentStatus() != null && doOrderInvItem.getOrdInvCurrentStatus().getOrdInvStatus() != null)
						if(doOrderInvItem.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCELLED)) || doOrderInvItem.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCEL_REQUEST)))
							countCancelledInvestigations++;
				}
				
				if(countCancelledInvestigations > 0 && (countCancelledInvestigations == doOrderInv.getOrderDetails().getInvestigations().size()))
					doOrderInv.getOrderDetails().setWasProcessed(true);
			}
		}
	}
	
	private void updateSpecimenWorkListItemsForDFT(List<?> orderInvestigations) throws StaleObjectException
	{
		if (orderInvestigations == null)
			return;
		
		StringBuilder dftInvestigations = new StringBuilder();
		
		Iterator<?> investigationIterator = orderInvestigations.iterator();
		while (investigationIterator.hasNext())
		{
			OrderInvestigation investigation = (OrderInvestigation) investigationIterator.next();
			
			if (getDomLookup(InvEventType.TIME_SERIES).equals(investigation.getInvestigation().getEventType()))
			{
				if (dftInvestigations.length() > 0)
					dftInvestigations.append(", ");
				dftInvestigations.append(investigation.getId());
			}
		}
		
		if (dftInvestigations.length() > 0)
		{
			List<?> workListItems = getDomainFactory().find("SELECT item FROM SpecimenWorkListItem AS item LEFT JOIN item.dFTOrderInvestigation AS investigation WHERE investigation.id in (" + dftInvestigations.toString() + ")");
			if (workListItems != null && workListItems.size() > 0)
			{
				Iterator<?> worklistIterator = workListItems.iterator();
				while (worklistIterator.hasNext())
				{
					SpecimenWorkListItem worklistItem = (SpecimenWorkListItem) worklistIterator.next();
					worklistItem.setCollectionStatus(getDomLookup(SpecimenCollectionStatus.CANCELLED));
					getDomainFactory().save(worklistItem);
				}
			}
		}
	}


	
	/**
	 * get a distinct list of the specimens and check for a work list item for each one
	 * If one (specimenworklistitem) is found update its SpecimenCollectionStatus to CANCELLED
	 * @param doOrdInvs
	 */
	private void updateSpecimenWorkListItems(List doOrdInvs)  throws StaleObjectException
	{
		if (doOrdInvs == null)
			throw new CodingRuntimeException("doOrdInvs cannot be null in method updateSpecimenWorkListItems");
		
		HashMap map = new HashMap<Integer, OrderSpecimen>(); //list of distinct specimens
		Iterator it = doOrdInvs.iterator();
		while(it.hasNext())
		{
			OrderInvestigation doOrdInv = (OrderInvestigation) it.next();
			
			if(doOrdInv.getSpecimen() != null && doOrdInv.getSpecimen().size() > 0)				//wdev-16488
			{
				if(areAllInvestigationsCancelled((OrderSpecimen) doOrdInv.getSpecimen().get(0)))
					map.put(((OrderSpecimen)doOrdInv.getSpecimen().get(0)).getId(), doOrdInv.getSpecimen());
			}
		}
		if(map.size() > 0)
		{
			String idsValues = getSpecimenIdsFromMap(map);
			
			if(idsValues != null && !idsValues.equals(""))
			{
				List workListItems = getDomainFactory().find("from SpecimenWorkListItem item where item.specimen.id in ( " + idsValues + " ) ");
				if(workListItems != null && workListItems.size() > 0)
				{
					Iterator it3 = workListItems.iterator();
					while (it3.hasNext())
					{
						SpecimenWorkListItem item = (SpecimenWorkListItem) it3.next();
						item.setCollectionStatus( getDomLookup( SpecimenCollectionStatus.CANCELLED));
						getDomainFactory().save(item);
					}
				}
			}
			
		}
	}

	/**
	 * check that all investigations for the specimen are cancelled
	 * @param doOrdSpec
	 * @return
	 */
	private boolean areAllInvestigationsCancelled(OrderSpecimen doOrdSpec)
	{
		boolean addToList = false;
		if(doOrdSpec != null &&  doOrdSpec.getInvestigations() != null)
		{
			int cancelledCount = 0;
			Iterator it1 = doOrdSpec.getInvestigations().iterator();
			while(it1.hasNext())
			{
				OrderInvestigation doItem = (OrderInvestigation) it1.next();
				if(doItem.getOrdInvCurrentStatus() != null)
				{
					if(doItem.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCEL_REQUEST)) || doItem.getOrdInvCurrentStatus().getOrdInvStatus().equals(getDomLookup(OrderInvStatus.CANCELLED)))
						cancelledCount++;	
				}
			}
			
			if(cancelledCount > 0 && (cancelledCount == doOrdSpec.getInvestigations().size()))
				addToList = true;
		}
		
		return addToList;
	}

	private String getSpecimenIdsFromMap(HashMap map)
	{
		String idString = "";
	
		int i=0;
		Set<Integer> ids = map.keySet();
		Iterator it = ids.iterator();
		while(it.hasNext())
		{
			idString += ((Integer)it.next()).toString();
			idString += ((ids.size() - (i+1)) > 0 ? "," : "");
			i++;
		}
		
		return idString;
	}

	protected String getIdString(OrderInvestigationRefVoCollection orderInvs)
	{
		String idString = "";
		
		for(int i=0;i<orderInvs.size();i++)
		{
			idString += orderInvs.get(i).getID_OrderInvestigation();
			idString += ((orderInvs.size() - (i+1)) > 0 ? "," : "");
		}
		
		return idString;
	}

	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral) throws StaleObjectException
	{
		IOCRRSchedulingHelper impl;
		try {
			impl = (IOCRRSchedulingHelper) getDomainImpl(Class.forName("ims.ocrr.helper.OCRRSchedulingHelper"));
			impl.updateCatsReferralAdditionalInvStatus(catsReferral);			
		} catch (ClassNotFoundException e) {
			LOG.error("Attempting to Load CARE_UK code in non care uk context", e);
		}
	}

	public RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(IAppRole role)
	{
		SelectandOrder impl = (SelectandOrder)getDomainImpl(SelectandOrderImpl.class);
		return impl.getRoleDisciplineSecurityLevels(role);
	}

	public String getCentricityPacsAccessionNumber(OrderInvestigationListVo voOrderInvListVo) 
	{
		ResultDialog impl = (ResultDialog)getDomainImpl(PathologyDialogImpl.class);
		return impl.getCentricityPacsAccessionNumber(voOrderInvListVo);
	}

	//wdev-10546
	public OrderInvestigationLiteVo getOrderInvestigation(OrderInvestigationRefVo orderInvRef) 
	{
		if(orderInvRef == null)
			return null;
		OrderInvestigation doOrderInv = (OrderInvestigation)getDomainFactory().getDomainObject(OrderInvestigation.class, orderInvRef.getID_OrderInvestigation());
		return OrderInvestigationLiteVoAssembler.create(doOrderInv);
	}

	// 	WDEV-16504
	public PathologySpecimenOrderInvestigationVo getOrdInvestigation(OrderInvestigationRefVo orderInvestigationRef) 
	{
		if(orderInvestigationRef == null)
			return null;
		
		OrderInvestigation doOrderInv = (OrderInvestigation)getDomainFactory().getDomainObject(OrderInvestigation.class, orderInvestigationRef.getID_OrderInvestigation());
		return PathologySpecimenOrderInvestigationVoAssembler.create(doOrderInv);
	}
}
