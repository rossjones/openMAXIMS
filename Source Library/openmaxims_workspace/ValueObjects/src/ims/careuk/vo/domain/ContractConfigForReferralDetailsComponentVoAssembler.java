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
 * @author Calin Perebiceanu
 */
public class ContractConfigForReferralDetailsComponentVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVo copy(ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObjectDest, ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ContractConfig(valueObjectSrc.getID_ContractConfig());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ContractOrganisation
		valueObjectDest.setContractOrganisation(valueObjectSrc.getContractOrganisation());
		// DaysToRTTBreachDate
		valueObjectDest.setDaysToRTTBreachDate(valueObjectSrc.getDaysToRTTBreachDate());
		// ContractType
		valueObjectDest.setContractType(valueObjectSrc.getContractType());
		// ContractId
		valueObjectDest.setContractId(valueObjectSrc.getContractId());
		// ContractName
		valueObjectDest.setContractName(valueObjectSrc.getContractName());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.configuration.domain.objects.ContractConfig objects.
	 */
	public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(java.util.Set domainObjectSet)	
	{
		return createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.configuration.domain.objects.ContractConfig objects.
	 */
	public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection voList = new ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.configuration.domain.objects.ContractConfig domainObject = (ims.core.configuration.domain.objects.ContractConfig) iterator.next();
			ims.careuk.vo.ContractConfigForReferralDetailsComponentVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.configuration.domain.objects.ContractConfig objects.
	 */
	public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(java.util.List domainObjectList) 
	{
		return createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.configuration.domain.objects.ContractConfig objects.
	 */
	public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection createContractConfigForReferralDetailsComponentVoCollectionFromContractConfig(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection voList = new ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.configuration.domain.objects.ContractConfig domainObject = (ims.core.configuration.domain.objects.ContractConfig) domainObjectList.get(i);
			ims.careuk.vo.ContractConfigForReferralDetailsComponentVo vo = create(map, domainObject);

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
	 * Create the ims.core.configuration.domain.objects.ContractConfig set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractContractConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection voCollection) 
	 {
	 	return extractContractConfigSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractContractConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ContractConfigForReferralDetailsComponentVo vo = voCollection.get(i);
			ims.core.configuration.domain.objects.ContractConfig domainObject = ContractConfigForReferralDetailsComponentVoAssembler.extractContractConfig(domainFactory, vo, domMap);

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
	 * Create the ims.core.configuration.domain.objects.ContractConfig list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractContractConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection voCollection) 
	 {
	 	return extractContractConfigList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractContractConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ContractConfigForReferralDetailsComponentVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ContractConfigForReferralDetailsComponentVo vo = voCollection.get(i);
			ims.core.configuration.domain.objects.ContractConfig domainObject = ContractConfigForReferralDetailsComponentVoAssembler.extractContractConfig(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.configuration.domain.objects.ContractConfig object.
	 * @param domainObject ims.core.configuration.domain.objects.ContractConfig
	 */
	 public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVo create(ims.core.configuration.domain.objects.ContractConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.configuration.domain.objects.ContractConfig object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVo create(DomainObjectMap map, ims.core.configuration.domain.objects.ContractConfig domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObject = (ims.careuk.vo.ContractConfigForReferralDetailsComponentVo) map.getValueObject(domainObject, ims.careuk.vo.ContractConfigForReferralDetailsComponentVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.ContractConfigForReferralDetailsComponentVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.configuration.domain.objects.ContractConfig
	 */
	 public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVo insert(ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObject, ims.core.configuration.domain.objects.ContractConfig domainObject) 
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
	 * @param domainObject ims.core.configuration.domain.objects.ContractConfig
	 */
	 public static ims.careuk.vo.ContractConfigForReferralDetailsComponentVo insert(DomainObjectMap map, ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObject, ims.core.configuration.domain.objects.ContractConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ContractConfig(domainObject.getId());
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
			
		// ContractOrganisation
		valueObject.setContractOrganisation(ims.core.vo.domain.OrganisationLiteVoAssembler.create(map, domainObject.getContractOrganisation()) );
		// DaysToRTTBreachDate
		valueObject.setDaysToRTTBreachDate(domainObject.getDaysToRTTBreachDate());
		// ContractType
		ims.domain.lookups.LookupInstance instance3 = domainObject.getContractType();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.ReferralManagementContractType voLookup3 = new ims.core.vo.lookups.ReferralManagementContractType(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.ReferralManagementContractType parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.core.vo.lookups.ReferralManagementContractType(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setContractType(voLookup3);
		}
				// ContractId
		valueObject.setContractId(domainObject.getContractId());
		// ContractName
		valueObject.setContractName(domainObject.getContractName());
		// Status
		ims.domain.lookups.LookupInstance instance6 = domainObject.getStatus();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup6 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setStatus(voLookup6);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.configuration.domain.objects.ContractConfig extractContractConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObject) 
	{
		return 	extractContractConfig(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.configuration.domain.objects.ContractConfig extractContractConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ContractConfigForReferralDetailsComponentVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ContractConfig();
		ims.core.configuration.domain.objects.ContractConfig domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.configuration.domain.objects.ContractConfig)domMap.get(valueObject);
			}
			// ims.careuk.vo.ContractConfigForReferralDetailsComponentVo ID_ContractConfig field is unknown
			domainObject = new ims.core.configuration.domain.objects.ContractConfig();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ContractConfig());
			if (domMap.get(key) != null)
			{
				return (ims.core.configuration.domain.objects.ContractConfig)domMap.get(key);
			}
			domainObject = (ims.core.configuration.domain.objects.ContractConfig) domainFactory.getDomainObject(ims.core.configuration.domain.objects.ContractConfig.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ContractConfig());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.place.domain.objects.Organisation value1 = null;
		if ( null != valueObject.getContractOrganisation() ) 
		{
			if (valueObject.getContractOrganisation().getBoId() == null)
			{
				if (domMap.get(valueObject.getContractOrganisation()) != null)
				{
					value1 = (ims.core.resource.place.domain.objects.Organisation)domMap.get(valueObject.getContractOrganisation());
				}
			}
			else
			{
				value1 = (ims.core.resource.place.domain.objects.Organisation)domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Organisation.class, valueObject.getContractOrganisation().getBoId());
			}
		}
		domainObject.setContractOrganisation(value1);
		domainObject.setDaysToRTTBreachDate(valueObject.getDaysToRTTBreachDate());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getContractType() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getContractType().getID());
		}
		domainObject.setContractType(value3);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getContractId() != null && valueObject.getContractId().equals(""))
		{
			valueObject.setContractId(null);
		}
		domainObject.setContractId(valueObject.getContractId());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getContractName() != null && valueObject.getContractName().equals(""))
		{
			valueObject.setContractName(null);
		}
		domainObject.setContractName(valueObject.getContractName());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value6);

		return domainObject;
	}

}
