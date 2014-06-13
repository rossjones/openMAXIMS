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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.careuk.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Aidan Mc Donnell
 */
public class ReferralOutcomeVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.ReferralOutcomeVo copy(ims.careuk.vo.ReferralOutcomeVo valueObjectDest, ims.careuk.vo.ReferralOutcomeVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReferralOutcome(valueObjectSrc.getID_ReferralOutcome());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ReferralDischarge
		valueObjectDest.setReferralDischarge(valueObjectSrc.getReferralDischarge());
		// FurtherManagementDetails
		valueObjectDest.setFurtherManagementDetails(valueObjectSrc.getFurtherManagementDetails());
		// Prescriptions
		valueObjectDest.setPrescriptions(valueObjectSrc.getPrescriptions());
		// ReferralDischargeHistory
		valueObjectDest.setReferralDischargeHistory(valueObjectSrc.getReferralDischargeHistory());
		// CatsFinalReportStatus
		valueObjectDest.setCatsFinalReportStatus(valueObjectSrc.getCatsFinalReportStatus());
		// ActiveMonitoring
		valueObjectDest.setActiveMonitoring(valueObjectSrc.getActiveMonitoring());
		// CatsReferral
		valueObjectDest.setCatsReferral(valueObjectSrc.getCatsReferral());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// SysInfo
		valueObjectDest.setSysInfo(valueObjectSrc.getSysInfo());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReferralOutcomeVoCollectionFromReferralOutcome(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.ReferralOutcome objects.
	 */
	public static ims.careuk.vo.ReferralOutcomeVoCollection createReferralOutcomeVoCollectionFromReferralOutcome(java.util.Set domainObjectSet)	
	{
		return createReferralOutcomeVoCollectionFromReferralOutcome(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.ReferralOutcome objects.
	 */
	public static ims.careuk.vo.ReferralOutcomeVoCollection createReferralOutcomeVoCollectionFromReferralOutcome(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.ReferralOutcomeVoCollection voList = new ims.careuk.vo.ReferralOutcomeVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.ReferralOutcome domainObject = (ims.careuk.domain.objects.ReferralOutcome) iterator.next();
			ims.careuk.vo.ReferralOutcomeVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.careuk.domain.objects.ReferralOutcome objects.
	 */
	public static ims.careuk.vo.ReferralOutcomeVoCollection createReferralOutcomeVoCollectionFromReferralOutcome(java.util.List domainObjectList) 
	{
		return createReferralOutcomeVoCollectionFromReferralOutcome(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.ReferralOutcome objects.
	 */
	public static ims.careuk.vo.ReferralOutcomeVoCollection createReferralOutcomeVoCollectionFromReferralOutcome(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.ReferralOutcomeVoCollection voList = new ims.careuk.vo.ReferralOutcomeVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.ReferralOutcome domainObject = (ims.careuk.domain.objects.ReferralOutcome) domainObjectList.get(i);
			ims.careuk.vo.ReferralOutcomeVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.careuk.domain.objects.ReferralOutcome set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReferralOutcomeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralOutcomeVoCollection voCollection) 
	 {
	 	return extractReferralOutcomeSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReferralOutcomeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralOutcomeVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ReferralOutcomeVo vo = voCollection.get(i);
			ims.careuk.domain.objects.ReferralOutcome domainObject = ReferralOutcomeVoAssembler.extractReferralOutcome(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.careuk.domain.objects.ReferralOutcome list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReferralOutcomeList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralOutcomeVoCollection voCollection) 
	 {
	 	return extractReferralOutcomeList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReferralOutcomeList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralOutcomeVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ReferralOutcomeVo vo = voCollection.get(i);
			ims.careuk.domain.objects.ReferralOutcome domainObject = ReferralOutcomeVoAssembler.extractReferralOutcome(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.careuk.domain.objects.ReferralOutcome object.
	 * @param domainObject ims.careuk.domain.objects.ReferralOutcome
	 */
	 public static ims.careuk.vo.ReferralOutcomeVo create(ims.careuk.domain.objects.ReferralOutcome domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.ReferralOutcome object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.ReferralOutcomeVo create(DomainObjectMap map, ims.careuk.domain.objects.ReferralOutcome domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.ReferralOutcomeVo valueObject = (ims.careuk.vo.ReferralOutcomeVo) map.getValueObject(domainObject, ims.careuk.vo.ReferralOutcomeVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.ReferralOutcomeVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.ReferralOutcome
	 */
	 public static ims.careuk.vo.ReferralOutcomeVo insert(ims.careuk.vo.ReferralOutcomeVo valueObject, ims.careuk.domain.objects.ReferralOutcome domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.ReferralOutcome
	 */
	 public static ims.careuk.vo.ReferralOutcomeVo insert(DomainObjectMap map, ims.careuk.vo.ReferralOutcomeVo valueObject, ims.careuk.domain.objects.ReferralOutcome domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReferralOutcome(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// ReferralDischarge
		valueObject.setReferralDischarge(ims.careuk.vo.domain.ReferralDischargeVoAssembler.create(map, domainObject.getReferralDischarge()) );
		// FurtherManagementDetails
		valueObject.setFurtherManagementDetails(ims.careuk.vo.domain.FurtherManagementDetailsVoAssembler.createFurtherManagementDetailsVoCollectionFromFurtherManagement(map, domainObject.getFurtherManagementDetails()) );
		// Prescriptions
		valueObject.setPrescriptions(ims.careuk.vo.domain.PrescriptionsVoAssembler.createPrescriptionsVoCollectionFromPrescription(map, domainObject.getPrescriptions()) );
		// ReferralDischargeHistory
		valueObject.setReferralDischargeHistory(ims.careuk.vo.domain.ReferralDischargeVoAssembler.createReferralDischargeVoCollectionFromDischargeOutcome(map, domainObject.getReferralDischargeHistory()) );
		// CatsFinalReportStatus
		ims.domain.lookups.LookupInstance instance5 = domainObject.getCatsFinalReportStatus();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.careuk.vo.lookups.ReportStatus voLookup5 = new ims.careuk.vo.lookups.ReportStatus(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.careuk.vo.lookups.ReportStatus parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.careuk.vo.lookups.ReportStatus(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setCatsFinalReportStatus(voLookup5);
		}
				// ActiveMonitoring
		valueObject.setActiveMonitoring(ims.careuk.vo.domain.ActiveMonitoringVoAssembler.create(map, domainObject.getActiveMonitoring()) );
		// CatsReferral
		if (domainObject.getCatsReferral() != null)
		{
			if(domainObject.getCatsReferral() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCatsReferral();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCatsReferral(new ims.careuk.vo.CatsReferralRefVo(id, -1));				
			}
			else
			{
				valueObject.setCatsReferral(new ims.careuk.vo.CatsReferralRefVo(domainObject.getCatsReferral().getId(), domainObject.getCatsReferral().getVersion()));
			}
		}
		// AuthoringInformation
		valueObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthoringInformation()) );
		// SysInfo
		// set system information
		valueObject.setSysInfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.ReferralOutcome extractReferralOutcome(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralOutcomeVo valueObject) 
	{
		return 	extractReferralOutcome(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.ReferralOutcome extractReferralOutcome(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralOutcomeVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReferralOutcome();
		ims.careuk.domain.objects.ReferralOutcome domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.ReferralOutcome)domMap.get(valueObject);
			}
			// ims.careuk.vo.ReferralOutcomeVo ID_ReferralOutcome field is unknown
			domainObject = new ims.careuk.domain.objects.ReferralOutcome();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReferralOutcome());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.ReferralOutcome)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.ReferralOutcome) domainFactory.getDomainObject(ims.careuk.domain.objects.ReferralOutcome.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReferralOutcome());

		domainObject.setReferralDischarge(ims.careuk.vo.domain.ReferralDischargeVoAssembler.extractDischargeOutcome(domainFactory, valueObject.getReferralDischarge(), domMap));
		domainObject.setFurtherManagementDetails(ims.careuk.vo.domain.FurtherManagementDetailsVoAssembler.extractFurtherManagementSet(domainFactory, valueObject.getFurtherManagementDetails(), domainObject.getFurtherManagementDetails(), domMap));		
		domainObject.setPrescriptions(ims.careuk.vo.domain.PrescriptionsVoAssembler.extractPrescriptionSet(domainFactory, valueObject.getPrescriptions(), domainObject.getPrescriptions(), domMap));		
		domainObject.setReferralDischargeHistory(ims.careuk.vo.domain.ReferralDischargeVoAssembler.extractDischargeOutcomeSet(domainFactory, valueObject.getReferralDischargeHistory(), domainObject.getReferralDischargeHistory(), domMap));		
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getCatsFinalReportStatus() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getCatsFinalReportStatus().getID());
		}
		domainObject.setCatsFinalReportStatus(value5);
		domainObject.setActiveMonitoring(ims.careuk.vo.domain.ActiveMonitoringVoAssembler.extractActiveMonitoring(domainFactory, valueObject.getActiveMonitoring(), domMap));
		ims.careuk.domain.objects.CatsReferral value7 = null;
		if ( null != valueObject.getCatsReferral() ) 
		{
			if (valueObject.getCatsReferral().getBoId() == null)
			{
				if (domMap.get(valueObject.getCatsReferral()) != null)
				{
					value7 = (ims.careuk.domain.objects.CatsReferral)domMap.get(valueObject.getCatsReferral());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value7 = domainObject.getCatsReferral();	
			}
			else
			{
				value7 = (ims.careuk.domain.objects.CatsReferral)domainFactory.getDomainObject(ims.careuk.domain.objects.CatsReferral.class, valueObject.getCatsReferral().getBoId());
			}
		}
		domainObject.setCatsReferral(value7);
		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));

		return domainObject;
	}

}
