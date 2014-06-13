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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.20 build 40713.1615)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.dto.DTODomainImplementation;
import ims.nursing.vo.CarePlanOverviewCollection;
import ims.nursing.vo.CarePlanStatus;
import ims.nursing.vo.domain.CarePlanOverviewAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.impl.LookupServiceImpl;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.Demographics;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.LocShortVo;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocMostVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.framework.enumerations.SortOrder;

public class CarePlanReviewImpl extends DTODomainImplementation implements ims.nursing.domain.CarePlanReview, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	public boolean dtoOnly() 
	{
		return false;
	}

	public Class<LookupServiceImpl> getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}

	public Patient getPatient(PatientShort patient) throws StaleObjectException
	{
		Demographics impl = (Demographics)getDomainImpl(DemographicsImpl.class);
		return impl.getPatient(patient);
	}

	

	/* (non-Javadoc)
	 * @see ims.nursing.domain.CarePlanReviMootClinicalContacts(ims.core.vo.LocShortVo)
	 */
	public CareContextShortVoCollection listCareContexts(LocShortVo wardVo)
	{
		DomainFactory factory = getDomainFactory();
		
		CareContextShortVoCollection  voCareContextColl = new CareContextShortVoCollection();
		List contacts = null;
		String hql;
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();

		hql = " from CareContext cc "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";	
		// WDEV-4491
		condStr.append(andStr + " cc.episodeOfCare.careSpell.patient.ward.id = :wardId and cc.endDateTime is null ");
		markers.add("wardId");
		values.add(wardVo.getID_Location());

		hql += " where " + condStr.toString();	
			
		contacts = factory.find(hql, markers, values);	
		
		for (int x = 0; x < contacts.size(); x++)
		{
			CareContext domCareContext = (CareContext) contacts.get(x);	
			CareContextShortVo voCareContext = CareContextShortVoAssembler.create(domCareContext);		
			voCareContextColl.add(voCareContext);
		}
	
		return voCareContextColl.sort();
	}

	/**
	 *  list wards
	 */
	public LocMostVoCollection listWards()
	{
		ims.admin.domain.OrganisationAndLocation wardImpl = (ims.admin.domain.OrganisationAndLocation)getDomainImpl(ims.admin.domain.impl.OrganisationAndLocationImpl.class);
		LocMostVo filter = new LocMostVo();
		filter.setType(LocationType.WARD);
		return wardImpl.listLocation(filter);		
	}

	/**
	 *  list locations
	 */
	public LocMostVoCollection listLocations(LocMostVo locationFilterVo)
	{
		OrganisationAndLocation locImpl = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return locImpl.listLocation(locationFilterVo).sort();
	}

	/* (non-Javadoc)
	 * @see ims.nursing.domain.CarePlanReview#listCarePlansForReview(ims.core.vo.ClinicalContactShortVo)
	 */
	public CarePlanOverviewCollection listCarePlansForReview(CareContextShortVo careContextShortVo, CarePlanStatus activeFilter)
	{
		DomainFactory factory = getDomainFactory();
		
		String hqlQuery = " from CarePlan cp ";
		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markerNames = new ArrayList<String>();
		ArrayList<Integer> markerValues = new ArrayList<Integer>();
				
		CarePlanOverviewCollection voColl = null;
		
		condStr.append(" where ");
		
		if(careContextShortVo != null)
		{
			condStr.append(" cp.careContext.id = :careContext");
			markerNames.add("careContext");
			markerValues.add(careContextShortVo.getID_CareContext());
		}
		
		if(activeFilter != null)
		{
			if(activeFilter.getStatus() != null)
			{
				if(activeFilter != null)
					condStr.append(" and ");
				
				condStr.append(" cp.currentCarePlanStatus.status.id = :status");
				markerNames.add("status");
				markerValues.add(new Integer(activeFilter.getStatus().getId()));
			}
		}

		hqlQuery += condStr.toString();
		
		List careplans = factory.find(hqlQuery,markerNames,markerValues);	

		if(careplans != null)
			voColl = (CarePlanOverviewAssembler.createCarePlanOverviewCollectionFromCarePlan(careplans)); 
		
		if(voColl != null)
			voColl.sort(SortOrder.ASCENDING);
		
		return voColl;	
	}
	
	public PatientShort getPatientFromCareContext(CareContextRefVo voRef)
	{
		String hqlQuery = " select cs.patient from CareSpell cs left join cs.episodes ep left join ep.careContexts cc where cc.id = " + voRef.getID_CareContext()+ " and cs.patient.isActive = true and cs.patient.dod is null";
		List list = getDomainFactory().find(hqlQuery);
		
		if(list != null && list.size() > 0)
		{
			return PatientShortAssembler.createPatientShortCollectionFromPatient(list).get(0); 
		}
		
		return null;
	}
}
	

