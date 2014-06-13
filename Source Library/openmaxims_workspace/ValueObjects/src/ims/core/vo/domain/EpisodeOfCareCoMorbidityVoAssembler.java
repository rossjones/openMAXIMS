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
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class EpisodeOfCareCoMorbidityVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.EpisodeOfCareCoMorbidityVo copy(ims.core.vo.EpisodeOfCareCoMorbidityVo valueObjectDest, ims.core.vo.EpisodeOfCareCoMorbidityVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_EpisodeOfCareCoMorbidity(valueObjectSrc.getID_EpisodeOfCareCoMorbidity());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// Diagnosis
		valueObjectDest.setDiagnosis(valueObjectSrc.getDiagnosis());
		// isActive
		valueObjectDest.setIsActive(valueObjectSrc.getIsActive());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity objects.
	 */
	public static ims.core.vo.EpisodeOfCareCoMorbidityVoCollection createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(java.util.Set domainObjectSet)	
	{
		return createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity objects.
	 */
	public static ims.core.vo.EpisodeOfCareCoMorbidityVoCollection createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.EpisodeOfCareCoMorbidityVoCollection voList = new ims.core.vo.EpisodeOfCareCoMorbidityVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject = (ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity) iterator.next();
			ims.core.vo.EpisodeOfCareCoMorbidityVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity objects.
	 */
	public static ims.core.vo.EpisodeOfCareCoMorbidityVoCollection createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(java.util.List domainObjectList) 
	{
		return createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity objects.
	 */
	public static ims.core.vo.EpisodeOfCareCoMorbidityVoCollection createEpisodeOfCareCoMorbidityVoCollectionFromEpisodeOfCareCoMorbidity(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.EpisodeOfCareCoMorbidityVoCollection voList = new ims.core.vo.EpisodeOfCareCoMorbidityVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject = (ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity) domainObjectList.get(i);
			ims.core.vo.EpisodeOfCareCoMorbidityVo vo = create(map, domainObject);

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
	 * Create the ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractEpisodeOfCareCoMorbiditySet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.EpisodeOfCareCoMorbidityVoCollection voCollection) 
	 {
	 	return extractEpisodeOfCareCoMorbiditySet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractEpisodeOfCareCoMorbiditySet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.EpisodeOfCareCoMorbidityVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.EpisodeOfCareCoMorbidityVo vo = voCollection.get(i);
			ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject = EpisodeOfCareCoMorbidityVoAssembler.extractEpisodeOfCareCoMorbidity(domainFactory, vo, domMap);

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
	 * Create the ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractEpisodeOfCareCoMorbidityList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.EpisodeOfCareCoMorbidityVoCollection voCollection) 
	 {
	 	return extractEpisodeOfCareCoMorbidityList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractEpisodeOfCareCoMorbidityList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.EpisodeOfCareCoMorbidityVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.EpisodeOfCareCoMorbidityVo vo = voCollection.get(i);
			ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject = EpisodeOfCareCoMorbidityVoAssembler.extractEpisodeOfCareCoMorbidity(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity object.
	 * @param domainObject ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity
	 */
	 public static ims.core.vo.EpisodeOfCareCoMorbidityVo create(ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.EpisodeOfCareCoMorbidityVo create(DomainObjectMap map, ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.EpisodeOfCareCoMorbidityVo valueObject = (ims.core.vo.EpisodeOfCareCoMorbidityVo) map.getValueObject(domainObject, ims.core.vo.EpisodeOfCareCoMorbidityVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.EpisodeOfCareCoMorbidityVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity
	 */
	 public static ims.core.vo.EpisodeOfCareCoMorbidityVo insert(ims.core.vo.EpisodeOfCareCoMorbidityVo valueObject, ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject) 
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
	 * @param domainObject ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity
	 */
	 public static ims.core.vo.EpisodeOfCareCoMorbidityVo insert(DomainObjectMap map, ims.core.vo.EpisodeOfCareCoMorbidityVo valueObject, ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_EpisodeOfCareCoMorbidity(domainObject.getId());
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
			
		// AuthoringInformation
		valueObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthoringInformation()) );
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
		// Diagnosis
		if (domainObject.getDiagnosis() != null)
		{
			if(domainObject.getDiagnosis() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getDiagnosis();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setDiagnosis(new ims.core.clinical.vo.PatientDiagnosisRefVo(id, -1));				
			}
			else
			{
				valueObject.setDiagnosis(new ims.core.clinical.vo.PatientDiagnosisRefVo(domainObject.getDiagnosis().getId(), domainObject.getDiagnosis().getVersion()));
			}
		}
		// isActive
		valueObject.setIsActive( domainObject.isIsActive() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity extractEpisodeOfCareCoMorbidity(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.EpisodeOfCareCoMorbidityVo valueObject) 
	{
		return 	extractEpisodeOfCareCoMorbidity(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity extractEpisodeOfCareCoMorbidity(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.EpisodeOfCareCoMorbidityVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_EpisodeOfCareCoMorbidity();
		ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity)domMap.get(valueObject);
			}
			// ims.core.vo.EpisodeOfCareCoMorbidityVo ID_EpisodeOfCareCoMorbidity field is unknown
			domainObject = new ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_EpisodeOfCareCoMorbidity());
			if (domMap.get(key) != null)
			{
				return (ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity)domMap.get(key);
			}
			domainObject = (ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity) domainFactory.getDomainObject(ims.core.clinical.domain.objects.EpisodeOfCareCoMorbidity.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_EpisodeOfCareCoMorbidity());

		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));
		ims.core.admin.domain.objects.CareContext value2 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value2 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getCareContext();	
			}
			else
			{
				value2 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value2);
		ims.core.clinical.domain.objects.PatientDiagnosis value3 = null;
		if ( null != valueObject.getDiagnosis() ) 
		{
			if (valueObject.getDiagnosis().getBoId() == null)
			{
				if (domMap.get(valueObject.getDiagnosis()) != null)
				{
					value3 = (ims.core.clinical.domain.objects.PatientDiagnosis)domMap.get(valueObject.getDiagnosis());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getDiagnosis();	
			}
			else
			{
				value3 = (ims.core.clinical.domain.objects.PatientDiagnosis)domainFactory.getDomainObject(ims.core.clinical.domain.objects.PatientDiagnosis.class, valueObject.getDiagnosis().getBoId());
			}
		}
		domainObject.setDiagnosis(value3);
		domainObject.setIsActive(valueObject.getIsActive());

		return domainObject;
	}

}
