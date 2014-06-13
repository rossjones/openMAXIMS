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
package ims.therapies.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Alexie Ursache
 */
public class StrengtheningProgramVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.therapies.vo.StrengtheningProgramVo copy(ims.therapies.vo.StrengtheningProgramVo valueObjectDest, ims.therapies.vo.StrengtheningProgramVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_StrengtheningProgram(valueObjectSrc.getID_StrengtheningProgram());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// Comment
		valueObjectDest.setComment(valueObjectSrc.getComment());
		// Excercise
		valueObjectDest.setExcercise(valueObjectSrc.getExcercise());
		// LimbWeight
		valueObjectDest.setLimbWeight(valueObjectSrc.getLimbWeight());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createStrengtheningProgramVoCollectionFromStrengtheningProgram(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.therapies.treatment.domain.objects.StrengtheningProgram objects.
	 */
	public static ims.therapies.vo.StrengtheningProgramVoCollection createStrengtheningProgramVoCollectionFromStrengtheningProgram(java.util.Set domainObjectSet)	
	{
		return createStrengtheningProgramVoCollectionFromStrengtheningProgram(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.therapies.treatment.domain.objects.StrengtheningProgram objects.
	 */
	public static ims.therapies.vo.StrengtheningProgramVoCollection createStrengtheningProgramVoCollectionFromStrengtheningProgram(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.therapies.vo.StrengtheningProgramVoCollection voList = new ims.therapies.vo.StrengtheningProgramVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject = (ims.therapies.treatment.domain.objects.StrengtheningProgram) iterator.next();
			ims.therapies.vo.StrengtheningProgramVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.therapies.treatment.domain.objects.StrengtheningProgram objects.
	 */
	public static ims.therapies.vo.StrengtheningProgramVoCollection createStrengtheningProgramVoCollectionFromStrengtheningProgram(java.util.List domainObjectList) 
	{
		return createStrengtheningProgramVoCollectionFromStrengtheningProgram(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.therapies.treatment.domain.objects.StrengtheningProgram objects.
	 */
	public static ims.therapies.vo.StrengtheningProgramVoCollection createStrengtheningProgramVoCollectionFromStrengtheningProgram(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.therapies.vo.StrengtheningProgramVoCollection voList = new ims.therapies.vo.StrengtheningProgramVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject = (ims.therapies.treatment.domain.objects.StrengtheningProgram) domainObjectList.get(i);
			ims.therapies.vo.StrengtheningProgramVo vo = create(map, domainObject);

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
	 * Create the ims.therapies.treatment.domain.objects.StrengtheningProgram set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractStrengtheningProgramSet(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.StrengtheningProgramVoCollection voCollection) 
	 {
	 	return extractStrengtheningProgramSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractStrengtheningProgramSet(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.StrengtheningProgramVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.therapies.vo.StrengtheningProgramVo vo = voCollection.get(i);
			ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject = StrengtheningProgramVoAssembler.extractStrengtheningProgram(domainFactory, vo, domMap);

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
	 * Create the ims.therapies.treatment.domain.objects.StrengtheningProgram list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractStrengtheningProgramList(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.StrengtheningProgramVoCollection voCollection) 
	 {
	 	return extractStrengtheningProgramList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractStrengtheningProgramList(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.StrengtheningProgramVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.therapies.vo.StrengtheningProgramVo vo = voCollection.get(i);
			ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject = StrengtheningProgramVoAssembler.extractStrengtheningProgram(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.therapies.treatment.domain.objects.StrengtheningProgram object.
	 * @param domainObject ims.therapies.treatment.domain.objects.StrengtheningProgram
	 */
	 public static ims.therapies.vo.StrengtheningProgramVo create(ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.therapies.treatment.domain.objects.StrengtheningProgram object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.therapies.vo.StrengtheningProgramVo create(DomainObjectMap map, ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.therapies.vo.StrengtheningProgramVo valueObject = (ims.therapies.vo.StrengtheningProgramVo) map.getValueObject(domainObject, ims.therapies.vo.StrengtheningProgramVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.therapies.vo.StrengtheningProgramVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.therapies.treatment.domain.objects.StrengtheningProgram
	 */
	 public static ims.therapies.vo.StrengtheningProgramVo insert(ims.therapies.vo.StrengtheningProgramVo valueObject, ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject) 
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
	 * @param domainObject ims.therapies.treatment.domain.objects.StrengtheningProgram
	 */
	 public static ims.therapies.vo.StrengtheningProgramVo insert(DomainObjectMap map, ims.therapies.vo.StrengtheningProgramVo valueObject, ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_StrengtheningProgram(domainObject.getId());
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
		// ClinicalContact
		if (domainObject.getClinicalContact() != null)
		{
			if(domainObject.getClinicalContact() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getClinicalContact();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(id, -1));				
			}
			else
			{
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(domainObject.getClinicalContact().getId(), domainObject.getClinicalContact().getVersion()));
			}
		}
		// Comment
		valueObject.setComment(domainObject.getComment());
		// Excercise
		java.util.List listExcercise = domainObject.getExcercise();
		ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection Excercise = new ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection();
		for(java.util.Iterator iterator = listExcercise.iterator(); iterator.hasNext(); ) 
		{
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;
		
			ims.domain.lookups.LookupInstance instance = 
				(ims.domain.lookups.LookupInstance) iterator.next();
			if (instance.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance.getImage().getImageId(), instance.getImage().getImagePath());
			}
			else 
			{
				img = null;
			}
			color = instance.getColor();
			if (color != null) 
				color.getValue();
			ims.spinalinjuries.vo.lookups.StrengtheningProgramExercise voInstance = new ims.spinalinjuries.vo.lookups.StrengtheningProgramExercise(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
			ims.spinalinjuries.vo.lookups.StrengtheningProgramExercise parentVoInstance = voInstance;
			ims.domain.lookups.LookupInstance parent = instance.getParent();
			while (parent != null)
			{
				if (parent.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent.getImage().getImageId(), parent.getImage().getImagePath());
				}
				else 
				{
					img = null;
				}
				color = parent.getColor();
				if (color != null) 
					color.getValue();
								parentVoInstance.setParent(new ims.spinalinjuries.vo.lookups.StrengtheningProgramExercise(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
				parentVoInstance = parentVoInstance.getParent();
								parent = parent.getParent();
			}			
			Excercise.add(voInstance);
		}
		valueObject.setExcercise( Excercise );
		// LimbWeight
		valueObject.setLimbWeight(ims.therapies.vo.domain.StrengtheningProgramLimbWeightVoAssembler.createStrengtheningProgramLimbWeightVoCollectionFromStrengtheningProgramLimbWeight(map, domainObject.getLimbWeight()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.therapies.treatment.domain.objects.StrengtheningProgram extractStrengtheningProgram(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.StrengtheningProgramVo valueObject) 
	{
		return 	extractStrengtheningProgram(domainFactory, valueObject, new HashMap());
	}

	public static ims.therapies.treatment.domain.objects.StrengtheningProgram extractStrengtheningProgram(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.StrengtheningProgramVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_StrengtheningProgram();
		ims.therapies.treatment.domain.objects.StrengtheningProgram domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.therapies.treatment.domain.objects.StrengtheningProgram)domMap.get(valueObject);
			}
			// ims.therapies.vo.StrengtheningProgramVo ID_StrengtheningProgram field is unknown
			domainObject = new ims.therapies.treatment.domain.objects.StrengtheningProgram();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_StrengtheningProgram());
			if (domMap.get(key) != null)
			{
				return (ims.therapies.treatment.domain.objects.StrengtheningProgram)domMap.get(key);
			}
			domainObject = (ims.therapies.treatment.domain.objects.StrengtheningProgram) domainFactory.getDomainObject(ims.therapies.treatment.domain.objects.StrengtheningProgram.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_StrengtheningProgram());

		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));
		ims.core.admin.domain.objects.ClinicalContact value2 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value2 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getClinicalContact();	
			}
			else
			{
				value2 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value2);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComment() != null && valueObject.getComment().equals(""))
		{
			valueObject.setComment(null);
		}
		domainObject.setComment(valueObject.getComment());
		ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection collection4 =
	valueObject.getExcercise();
	    java.util.List domainExcercise = domainObject.getExcercise();;			
	    int collection4Size=0;
		if (collection4 == null)
		{
			domainExcercise = new java.util.ArrayList(0);
		}
		else
		{
			collection4Size = collection4.size();
		}
		
		for(int i=0; i<collection4Size; i++) 
		{
			int instanceId = collection4.get(i).getID();
			ims.domain.lookups.LookupInstanceRef dom =new ims.domain.lookups.LookupInstanceRef(domainFactory.getLookupInstance(instanceId));
			
			int domIdx = domainExcercise.indexOf(dom);
			if (domIdx == -1)
			{
				domainExcercise.add(i, dom);
			}
			else if (i != domIdx && i < domainExcercise.size())
			{
				Object tmp = domainExcercise.get(i);
				domainExcercise.set(i, domainExcercise.get(domIdx));
				domainExcercise.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int j4 = domainExcercise.size();
		while (j4 > collection4Size)
		{
			domainExcercise.remove(j4-1);
			j4 = domainExcercise.size();
		}

		domainObject.setExcercise(domainExcercise);		
		domainObject.setLimbWeight(ims.therapies.vo.domain.StrengtheningProgramLimbWeightVoAssembler.extractStrengtheningProgramLimbWeightSet(domainFactory, valueObject.getLimbWeight(), domainObject.getLimbWeight(), domMap));		

		return domainObject;
	}

}
