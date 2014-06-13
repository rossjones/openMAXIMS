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
 * @author Rory Fitzpatrick
 */
public class AtConsultationVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.AtConsultationVo copy(ims.careuk.vo.AtConsultationVo valueObjectDest, ims.careuk.vo.AtConsultationVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_AtConsultation(valueObjectSrc.getID_AtConsultation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// CatsReferral
		valueObjectDest.setCatsReferral(valueObjectSrc.getCatsReferral());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// Diagnosis
		valueObjectDest.setDiagnosis(valueObjectSrc.getDiagnosis());
		// Procedures
		valueObjectDest.setProcedures(valueObjectSrc.getProcedures());
		// Medications
		valueObjectDest.setMedications(valueObjectSrc.getMedications());
		// FirstDefinitiveTreatmentDate
		valueObjectDest.setFirstDefinitiveTreatmentDate(valueObjectSrc.getFirstDefinitiveTreatmentDate());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createAtConsultationVoCollectionFromAtConsultation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.AtConsultation objects.
	 */
	public static ims.careuk.vo.AtConsultationVoCollection createAtConsultationVoCollectionFromAtConsultation(java.util.Set domainObjectSet)	
	{
		return createAtConsultationVoCollectionFromAtConsultation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.AtConsultation objects.
	 */
	public static ims.careuk.vo.AtConsultationVoCollection createAtConsultationVoCollectionFromAtConsultation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.AtConsultationVoCollection voList = new ims.careuk.vo.AtConsultationVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.AtConsultation domainObject = (ims.careuk.domain.objects.AtConsultation) iterator.next();
			ims.careuk.vo.AtConsultationVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.careuk.domain.objects.AtConsultation objects.
	 */
	public static ims.careuk.vo.AtConsultationVoCollection createAtConsultationVoCollectionFromAtConsultation(java.util.List domainObjectList) 
	{
		return createAtConsultationVoCollectionFromAtConsultation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.AtConsultation objects.
	 */
	public static ims.careuk.vo.AtConsultationVoCollection createAtConsultationVoCollectionFromAtConsultation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.AtConsultationVoCollection voList = new ims.careuk.vo.AtConsultationVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.AtConsultation domainObject = (ims.careuk.domain.objects.AtConsultation) domainObjectList.get(i);
			ims.careuk.vo.AtConsultationVo vo = create(map, domainObject);

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
	 * Create the ims.careuk.domain.objects.AtConsultation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractAtConsultationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AtConsultationVoCollection voCollection) 
	 {
	 	return extractAtConsultationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractAtConsultationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AtConsultationVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.AtConsultationVo vo = voCollection.get(i);
			ims.careuk.domain.objects.AtConsultation domainObject = AtConsultationVoAssembler.extractAtConsultation(domainFactory, vo, domMap);

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
	 * Create the ims.careuk.domain.objects.AtConsultation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractAtConsultationList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AtConsultationVoCollection voCollection) 
	 {
	 	return extractAtConsultationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractAtConsultationList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AtConsultationVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.AtConsultationVo vo = voCollection.get(i);
			ims.careuk.domain.objects.AtConsultation domainObject = AtConsultationVoAssembler.extractAtConsultation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.careuk.domain.objects.AtConsultation object.
	 * @param domainObject ims.careuk.domain.objects.AtConsultation
	 */
	 public static ims.careuk.vo.AtConsultationVo create(ims.careuk.domain.objects.AtConsultation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.AtConsultation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.AtConsultationVo create(DomainObjectMap map, ims.careuk.domain.objects.AtConsultation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.AtConsultationVo valueObject = (ims.careuk.vo.AtConsultationVo) map.getValueObject(domainObject, ims.careuk.vo.AtConsultationVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.AtConsultationVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.AtConsultation
	 */
	 public static ims.careuk.vo.AtConsultationVo insert(ims.careuk.vo.AtConsultationVo valueObject, ims.careuk.domain.objects.AtConsultation domainObject) 
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
	 * @param domainObject ims.careuk.domain.objects.AtConsultation
	 */
	 public static ims.careuk.vo.AtConsultationVo insert(DomainObjectMap map, ims.careuk.vo.AtConsultationVo valueObject, ims.careuk.domain.objects.AtConsultation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_AtConsultation(domainObject.getId());
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
		// Diagnosis
		valueObject.setDiagnosis(ims.core.vo.domain.PatientDiagnosisAtConsultationVoAssembler.createPatientDiagnosisAtConsultationVoCollectionFromPatientDiagnosis(map, domainObject.getDiagnosis()) );
		// Procedures
		valueObject.setProcedures(ims.core.vo.domain.PatientProcedureLiteVoAssembler.createPatientProcedureLiteVoCollectionFromPatientProcedure(map, domainObject.getProcedures()) );
		// Medications
		valueObject.setMedications(ims.core.vo.domain.PatientMedicationLiteVoAssembler.createPatientMedicationLiteVoCollectionFromPatientMedication(map, domainObject.getMedications()) );
		// FirstDefinitiveTreatmentDate
		java.util.Date FirstDefinitiveTreatmentDate = domainObject.getFirstDefinitiveTreatmentDate();
		if ( null != FirstDefinitiveTreatmentDate ) 
		{
			valueObject.setFirstDefinitiveTreatmentDate(new ims.framework.utils.Date(FirstDefinitiveTreatmentDate) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.AtConsultation extractAtConsultation(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AtConsultationVo valueObject) 
	{
		return 	extractAtConsultation(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.AtConsultation extractAtConsultation(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AtConsultationVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_AtConsultation();
		ims.careuk.domain.objects.AtConsultation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.AtConsultation)domMap.get(valueObject);
			}
			// ims.careuk.vo.AtConsultationVo ID_AtConsultation field is unknown
			domainObject = new ims.careuk.domain.objects.AtConsultation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_AtConsultation());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.AtConsultation)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.AtConsultation) domainFactory.getDomainObject(ims.careuk.domain.objects.AtConsultation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_AtConsultation());

		ims.careuk.domain.objects.CatsReferral value1 = null;
		if ( null != valueObject.getCatsReferral() ) 
		{
			if (valueObject.getCatsReferral().getBoId() == null)
			{
				if (domMap.get(valueObject.getCatsReferral()) != null)
				{
					value1 = (ims.careuk.domain.objects.CatsReferral)domMap.get(valueObject.getCatsReferral());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getCatsReferral();	
			}
			else
			{
				value1 = (ims.careuk.domain.objects.CatsReferral)domainFactory.getDomainObject(ims.careuk.domain.objects.CatsReferral.class, valueObject.getCatsReferral().getBoId());
			}
		}
		domainObject.setCatsReferral(value1);
		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));
		domainObject.setDiagnosis(ims.core.vo.domain.PatientDiagnosisAtConsultationVoAssembler.extractPatientDiagnosisSet(domainFactory, valueObject.getDiagnosis(), domainObject.getDiagnosis(), domMap));		
		domainObject.setProcedures(ims.core.vo.domain.PatientProcedureLiteVoAssembler.extractPatientProcedureSet(domainFactory, valueObject.getProcedures(), domainObject.getProcedures(), domMap));		
		domainObject.setMedications(ims.core.vo.domain.PatientMedicationLiteVoAssembler.extractPatientMedicationSet(domainFactory, valueObject.getMedications(), domainObject.getMedications(), domMap));		
		java.util.Date value6 = null;
		ims.framework.utils.Date date6 = valueObject.getFirstDefinitiveTreatmentDate();		
		if ( date6 != null ) 
		{
			value6 = date6.getDate();
		}
		domainObject.setFirstDefinitiveTreatmentDate(value6);

		return domainObject;
	}

}
