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
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class SOAPVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.SOAPVo copy(ims.core.vo.SOAPVo valueObjectDest, ims.core.vo.SOAPVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_SoapNote(valueObjectSrc.getID_SoapNote());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// SubjectiveNote
		valueObjectDest.setSubjectiveNote(valueObjectSrc.getSubjectiveNote());
		// ObjectiveNote
		valueObjectDest.setObjectiveNote(valueObjectSrc.getObjectiveNote());
		// AnalysisNote
		valueObjectDest.setAnalysisNote(valueObjectSrc.getAnalysisNote());
		// PlanNote
		valueObjectDest.setPlanNote(valueObjectSrc.getPlanNote());
		// ClinicalNote
		valueObjectDest.setClinicalNote(valueObjectSrc.getClinicalNote());
		// SysInfo
		valueObjectDest.setSysInfo(valueObjectSrc.getSysInfo());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSOAPVoCollectionFromSoapNote(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.SoapNote objects.
	 */
	public static ims.core.vo.SOAPVoCollection createSOAPVoCollectionFromSoapNote(java.util.Set domainObjectSet)	
	{
		return createSOAPVoCollectionFromSoapNote(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.SoapNote objects.
	 */
	public static ims.core.vo.SOAPVoCollection createSOAPVoCollectionFromSoapNote(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.SOAPVoCollection voList = new ims.core.vo.SOAPVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.SoapNote domainObject = (ims.clinical.domain.objects.SoapNote) iterator.next();
			ims.core.vo.SOAPVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.SoapNote objects.
	 */
	public static ims.core.vo.SOAPVoCollection createSOAPVoCollectionFromSoapNote(java.util.List domainObjectList) 
	{
		return createSOAPVoCollectionFromSoapNote(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.SoapNote objects.
	 */
	public static ims.core.vo.SOAPVoCollection createSOAPVoCollectionFromSoapNote(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.SOAPVoCollection voList = new ims.core.vo.SOAPVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.SoapNote domainObject = (ims.clinical.domain.objects.SoapNote) domainObjectList.get(i);
			ims.core.vo.SOAPVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.SoapNote set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSoapNoteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SOAPVoCollection voCollection) 
	 {
	 	return extractSoapNoteSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSoapNoteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SOAPVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.SOAPVo vo = voCollection.get(i);
			ims.clinical.domain.objects.SoapNote domainObject = SOAPVoAssembler.extractSoapNote(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.SoapNote list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSoapNoteList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SOAPVoCollection voCollection) 
	 {
	 	return extractSoapNoteList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSoapNoteList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SOAPVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.SOAPVo vo = voCollection.get(i);
			ims.clinical.domain.objects.SoapNote domainObject = SOAPVoAssembler.extractSoapNote(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.SoapNote object.
	 * @param domainObject ims.clinical.domain.objects.SoapNote
	 */
	 public static ims.core.vo.SOAPVo create(ims.clinical.domain.objects.SoapNote domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.SoapNote object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.SOAPVo create(DomainObjectMap map, ims.clinical.domain.objects.SoapNote domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.SOAPVo valueObject = (ims.core.vo.SOAPVo) map.getValueObject(domainObject, ims.core.vo.SOAPVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.SOAPVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.SoapNote
	 */
	 public static ims.core.vo.SOAPVo insert(ims.core.vo.SOAPVo valueObject, ims.clinical.domain.objects.SoapNote domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.SoapNote
	 */
	 public static ims.core.vo.SOAPVo insert(DomainObjectMap map, ims.core.vo.SOAPVo valueObject, ims.clinical.domain.objects.SoapNote domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_SoapNote(domainObject.getId());
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
			
		// SubjectiveNote
		valueObject.setSubjectiveNote(domainObject.getSubjectiveNote());
		// ObjectiveNote
		valueObject.setObjectiveNote(domainObject.getObjectiveNote());
		// AnalysisNote
		valueObject.setAnalysisNote(domainObject.getAnalysisNote());
		// PlanNote
		valueObject.setPlanNote(domainObject.getPlanNote());
		// ClinicalNote
		if (domainObject.getClinicalNote() != null)
		{
			if(domainObject.getClinicalNote() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getClinicalNote();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setClinicalNote(new ims.core.clinical.vo.ClinicalNotesRefVo(id, -1));				
			}
			else
			{
				valueObject.setClinicalNote(new ims.core.clinical.vo.ClinicalNotesRefVo(domainObject.getClinicalNote().getId(), domainObject.getClinicalNote().getVersion()));
			}
		}
		// SysInfo
		// set system information
		valueObject.setSysInfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
		// ClinicalContact
		valueObject.setClinicalContact(ims.core.vo.domain.ClinicalContactShortVoAssembler.create(map, domainObject.getClinicalContact()) );
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
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.SoapNote extractSoapNote(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SOAPVo valueObject) 
	{
		return 	extractSoapNote(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.SoapNote extractSoapNote(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SOAPVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_SoapNote();
		ims.clinical.domain.objects.SoapNote domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.SoapNote)domMap.get(valueObject);
			}
			// ims.core.vo.SOAPVo ID_SoapNote field is unknown
			domainObject = new ims.clinical.domain.objects.SoapNote();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_SoapNote());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.SoapNote)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.SoapNote) domainFactory.getDomainObject(ims.clinical.domain.objects.SoapNote.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_SoapNote());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSubjectiveNote() != null && valueObject.getSubjectiveNote().equals(""))
		{
			valueObject.setSubjectiveNote(null);
		}
		domainObject.setSubjectiveNote(valueObject.getSubjectiveNote());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getObjectiveNote() != null && valueObject.getObjectiveNote().equals(""))
		{
			valueObject.setObjectiveNote(null);
		}
		domainObject.setObjectiveNote(valueObject.getObjectiveNote());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAnalysisNote() != null && valueObject.getAnalysisNote().equals(""))
		{
			valueObject.setAnalysisNote(null);
		}
		domainObject.setAnalysisNote(valueObject.getAnalysisNote());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getPlanNote() != null && valueObject.getPlanNote().equals(""))
		{
			valueObject.setPlanNote(null);
		}
		domainObject.setPlanNote(valueObject.getPlanNote());
		ims.core.clinical.domain.objects.ClinicalNotes value5 = null;
		if ( null != valueObject.getClinicalNote() ) 
		{
			if (valueObject.getClinicalNote().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalNote()) != null)
				{
					value5 = (ims.core.clinical.domain.objects.ClinicalNotes)domMap.get(valueObject.getClinicalNote());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value5 = domainObject.getClinicalNote();	
			}
			else
			{
				value5 = (ims.core.clinical.domain.objects.ClinicalNotes)domainFactory.getDomainObject(ims.core.clinical.domain.objects.ClinicalNotes.class, valueObject.getClinicalNote().getBoId());
			}
		}
		domainObject.setClinicalNote(value5);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.ClinicalContact value7 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value7 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else
			{
				value7 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value7);
		ims.core.admin.domain.objects.CareContext value8 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value8 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value8 = domainObject.getCareContext();	
			}
			else
			{
				value8 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value8);

		return domainObject;
	}

}
