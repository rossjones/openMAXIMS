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
package ims.coe.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Sinead McDermott
 */
public class AssessmentAccommodationAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.coe.vo.AssessmentAccommodation copy(ims.coe.vo.AssessmentAccommodation valueObjectDest, ims.coe.vo.AssessmentAccommodation valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_AssessmentComponent(valueObjectSrc.getID_AssessmentComponent());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// HomeFacilities
		valueObjectDest.setHomeFacilities(valueObjectSrc.getHomeFacilities());
		// AccommodationHousing
		valueObjectDest.setAccommodationHousing(valueObjectSrc.getAccommodationHousing());
		// isComplete
		valueObjectDest.setIsComplete(valueObjectSrc.getIsComplete());
		// AssessmentInfo
		valueObjectDest.setAssessmentInfo(valueObjectSrc.getAssessmentInfo());
		// Copy
		valueObjectDest.setCopy(valueObjectSrc.getCopy());
		// ComponentType
		valueObjectDest.setComponentType(valueObjectSrc.getComponentType());
		// CarePlanTemplate
		valueObjectDest.setCarePlanTemplate(valueObjectSrc.getCarePlanTemplate());
		// CarePlans
		valueObjectDest.setCarePlans(valueObjectSrc.getCarePlans());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createAssessmentAccommodationCollectionFromAccommodationComponent(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.coe.assessment.domain.objects.AccommodationComponent objects.
	 */
	public static ims.coe.vo.AssessmentAccommodationCollection createAssessmentAccommodationCollectionFromAccommodationComponent(java.util.Set domainObjectSet)	
	{
		return createAssessmentAccommodationCollectionFromAccommodationComponent(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.coe.assessment.domain.objects.AccommodationComponent objects.
	 */
	public static ims.coe.vo.AssessmentAccommodationCollection createAssessmentAccommodationCollectionFromAccommodationComponent(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.coe.vo.AssessmentAccommodationCollection voList = new ims.coe.vo.AssessmentAccommodationCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.coe.assessment.domain.objects.AccommodationComponent domainObject = (ims.coe.assessment.domain.objects.AccommodationComponent) iterator.next();
			ims.coe.vo.AssessmentAccommodation vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.coe.assessment.domain.objects.AccommodationComponent objects.
	 */
	public static ims.coe.vo.AssessmentAccommodationCollection createAssessmentAccommodationCollectionFromAccommodationComponent(java.util.List domainObjectList) 
	{
		return createAssessmentAccommodationCollectionFromAccommodationComponent(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.coe.assessment.domain.objects.AccommodationComponent objects.
	 */
	public static ims.coe.vo.AssessmentAccommodationCollection createAssessmentAccommodationCollectionFromAccommodationComponent(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.coe.vo.AssessmentAccommodationCollection voList = new ims.coe.vo.AssessmentAccommodationCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.coe.assessment.domain.objects.AccommodationComponent domainObject = (ims.coe.assessment.domain.objects.AccommodationComponent) domainObjectList.get(i);
			ims.coe.vo.AssessmentAccommodation vo = create(map, domainObject);

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
	 * Create the ims.coe.assessment.domain.objects.AccommodationComponent set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractAccommodationComponentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.coe.vo.AssessmentAccommodationCollection voCollection) 
	 {
	 	return extractAccommodationComponentSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractAccommodationComponentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.coe.vo.AssessmentAccommodationCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.coe.vo.AssessmentAccommodation vo = voCollection.get(i);
			ims.coe.assessment.domain.objects.AccommodationComponent domainObject = AssessmentAccommodationAssembler.extractAccommodationComponent(domainFactory, vo, domMap);

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
	 * Create the ims.coe.assessment.domain.objects.AccommodationComponent list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractAccommodationComponentList(ims.domain.ILightweightDomainFactory domainFactory, ims.coe.vo.AssessmentAccommodationCollection voCollection) 
	 {
	 	return extractAccommodationComponentList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractAccommodationComponentList(ims.domain.ILightweightDomainFactory domainFactory, ims.coe.vo.AssessmentAccommodationCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.coe.vo.AssessmentAccommodation vo = voCollection.get(i);
			ims.coe.assessment.domain.objects.AccommodationComponent domainObject = AssessmentAccommodationAssembler.extractAccommodationComponent(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.coe.assessment.domain.objects.AccommodationComponent object.
	 * @param domainObject ims.coe.assessment.domain.objects.AccommodationComponent
	 */
	 public static ims.coe.vo.AssessmentAccommodation create(ims.coe.assessment.domain.objects.AccommodationComponent domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.coe.assessment.domain.objects.AccommodationComponent object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.coe.vo.AssessmentAccommodation create(DomainObjectMap map, ims.coe.assessment.domain.objects.AccommodationComponent domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.coe.vo.AssessmentAccommodation valueObject = (ims.coe.vo.AssessmentAccommodation) map.getValueObject(domainObject, ims.coe.vo.AssessmentAccommodation.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.coe.vo.AssessmentAccommodation(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.coe.assessment.domain.objects.AccommodationComponent
	 */
	 public static ims.coe.vo.AssessmentAccommodation insert(ims.coe.vo.AssessmentAccommodation valueObject, ims.coe.assessment.domain.objects.AccommodationComponent domainObject) 
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
	 * @param domainObject ims.coe.assessment.domain.objects.AccommodationComponent
	 */
	 public static ims.coe.vo.AssessmentAccommodation insert(DomainObjectMap map, ims.coe.vo.AssessmentAccommodation valueObject, ims.coe.assessment.domain.objects.AccommodationComponent domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_AssessmentComponent(domainObject.getId());
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
			
		// HomeFacilities
		valueObject.setHomeFacilities(ims.coe.vo.domain.AccommodationHomeFacilitiesAssembler.createAccommodationHomeFacilitiesCollectionFromAccommodationHomeFacilities(map, domainObject.getHomeFacilities()) );
		// AccommodationHousing
		valueObject.setAccommodationHousing(ims.coe.vo.domain.AccommodationHousingVoAssembler.create(map, domainObject.getAccommodationHousing()) );
		// isComplete
		valueObject.setIsComplete( domainObject.isIsComplete() );
		// AssessmentInfo
		valueObject.setAssessmentInfo(ims.nursing.vo.domain.AssessmentInfoAssembler.createAssessmentInfoCollectionFromAssessmentInfo(map, domainObject.getAssessmentInfo()) );
		// Copy
		valueObject.setCopy( domainObject.isCopy() );
		// ComponentType
		ims.domain.lookups.LookupInstance instance6 = domainObject.getComponentType();
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

			ims.nursing.vo.lookups.AssessmentComponentType voLookup6 = new ims.nursing.vo.lookups.AssessmentComponentType(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.nursing.vo.lookups.AssessmentComponentType parentVoLookup6 = voLookup6;
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
								parentVoLookup6.setParent(new ims.nursing.vo.lookups.AssessmentComponentType(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setComponentType(voLookup6);
		}
				// CarePlanTemplate
		valueObject.setCarePlanTemplate(ims.nursing.vo.domain.CarePlanTemplateAssembler.createCarePlanTemplateCollectionFromCarePlanTemplate(map, domainObject.getCarePlanTemplate()) );
		// CarePlans
		valueObject.setCarePlans(ims.nursing.vo.domain.CarePlanAssembler.createCarePlanCollectionFromCarePlan(map, domainObject.getCarePlans()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.coe.assessment.domain.objects.AccommodationComponent extractAccommodationComponent(ims.domain.ILightweightDomainFactory domainFactory, ims.coe.vo.AssessmentAccommodation valueObject) 
	{
		return 	extractAccommodationComponent(domainFactory, valueObject, new HashMap());
	}

	public static ims.coe.assessment.domain.objects.AccommodationComponent extractAccommodationComponent(ims.domain.ILightweightDomainFactory domainFactory, ims.coe.vo.AssessmentAccommodation valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_AssessmentComponent();
		ims.coe.assessment.domain.objects.AccommodationComponent domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.coe.assessment.domain.objects.AccommodationComponent)domMap.get(valueObject);
			}
			// ims.coe.vo.AssessmentAccommodation ID_AccommodationComponent field is unknown
			domainObject = new ims.coe.assessment.domain.objects.AccommodationComponent();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_AssessmentComponent());
			if (domMap.get(key) != null)
			{
				return (ims.coe.assessment.domain.objects.AccommodationComponent)domMap.get(key);
			}
			domainObject = (ims.coe.assessment.domain.objects.AccommodationComponent) domainFactory.getDomainObject(ims.coe.assessment.domain.objects.AccommodationComponent.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_AssessmentComponent());

		domainObject.setHomeFacilities(ims.coe.vo.domain.AccommodationHomeFacilitiesAssembler.extractAccommodationHomeFacilitiesList(domainFactory, valueObject.getHomeFacilities(), domainObject.getHomeFacilities(), domMap));		
		domainObject.setAccommodationHousing(ims.coe.vo.domain.AccommodationHousingVoAssembler.extractAccommodationHousing(domainFactory, valueObject.getAccommodationHousing(), domMap));
		domainObject.setIsComplete(valueObject.getIsComplete());
		domainObject.setAssessmentInfo(ims.nursing.vo.domain.AssessmentInfoAssembler.extractAssessmentInfoList(domainFactory, valueObject.getAssessmentInfo(), domainObject.getAssessmentInfo(), domMap));		
		domainObject.setCopy(valueObject.getCopy());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getComponentType() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getComponentType().getID());
		}
		domainObject.setComponentType(value6);
		domainObject.setCarePlanTemplate(ims.nursing.vo.domain.CarePlanTemplateAssembler.extractCarePlanTemplateSet(domainFactory, valueObject.getCarePlanTemplate(), domainObject.getCarePlanTemplate(), domMap));		
		domainObject.setCarePlans(ims.nursing.vo.domain.CarePlanAssembler.extractCarePlanSet(domainFactory, valueObject.getCarePlans(), domainObject.getCarePlans(), domMap));		

		return domainObject;
	}

}
