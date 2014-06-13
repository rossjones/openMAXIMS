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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BasePatientAssessmentListAndSearchImpl;
import ims.clinical.vo.PatientAssessmentListVo;
import ims.clinical.vo.PatientAssessmentListVoCollection;
import ims.clinical.vo.domain.PatientAssessmentListVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.ClinicalContact;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.EpisodeofCareShortVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.ClinicalContactShortVoAssembler;
import ims.core.vo.domain.EpisodeofCareShortVoAssembler;
import ims.core.vo.lookups.PatientAssessmentStatusReason;
import ims.core.vo.lookups.Specialty;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;

import java.util.ArrayList;
import java.util.Comparator;


public class PatientAssessmentListAndSearchImpl extends BasePatientAssessmentListAndSearchImpl
{

	/**
	 * Custom comparator - sort by 'Event Date'
	 * First option for 'Event Date' is Clinical Contact Start DateTime
	 * Second option for 'Event Date' is Care Context Start DateTime
	 */
	private static class EventDateComparator implements Comparator<PatientAssessmentListVo>
	{
		int sortOrder = 1;

		public EventDateComparator(SortOrder descending)
		{
			if (SortOrder.DESCENDING.equals(descending))
				sortOrder = -1;
		}

		public int compare(PatientAssessmentListVo o1, PatientAssessmentListVo o2)
		{
			DateTime eventDate1 = null;
			DateTime eventDate2 = null;
			
			if (o1.getClinicalContactIsNotNull() && o1.getClinicalContact().getStartDateTimeIsNotNull())
			{
				eventDate1 = o1.getClinicalContact().getStartDateTime();
			}
			else if (o1.getCareContextIsNotNull() && o1.getCareContext().getStartDateTimeIsNotNull())
			{
				eventDate1 = o1.getCareContext().getStartDateTime();
			}
			
			if (o2.getClinicalContactIsNotNull() && o2.getClinicalContact().getStartDateTimeIsNotNull())
			{
				eventDate2 = o2.getClinicalContact().getStartDateTime();
			}
			else if (o2.getCareContextIsNotNull() && o2.getCareContext().getStartDateTimeIsNotNull())
			{
				eventDate2 = o2.getCareContext().getStartDateTime();
			}
			
			
			if (eventDate1 == null && eventDate2 != null)
			{
				return -1 * sortOrder;
			}
			
			if (eventDate1 != null && eventDate2 == null)
			{
				return sortOrder;
			}

			return sortOrder * eventDate1.compareTo(eventDate2);
		}

	}


	private static final long serialVersionUID = 1L;

	
	/**
	 * Function used to search for PatientAssessments
	 */
	public PatientAssessmentListVoCollection listPatientAssessments(PatientRefVo patient, Specialty specialty, HcpRefVo authoringHcp, HcpRefVo responsibleHcp, String assessmentName, PatientAssessmentStatusReason status, Date dateFrom, Date dateTo, Boolean useEventDate)
	{
		// Build query
		StringBuilder query = new StringBuilder();
		StringBuilder condition = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append("SELECT assessment FROM PatientAssessment AS assessment LEFT JOIN assessment.patient as patient ");
		query.append(" LEFT JOIN assessment.episodeOfCare AS episode LEFT JOIN assessment.clinicalContact AS contact ");
		query.append(" LEFT JOIN assessment.careContext AS context ");
		query.append(" LEFT JOIN assessment.assessmentData AS data LEFT JOIN data.userAssessment AS userAss LEFT JOIN data.graphic AS graphic ");

		String aux = " ";
		
		
		// Patient filter
		if (patient != null)
		{
			condition.append(aux);
			condition.append(" patient.id = :PATIENT_ID");
			
			paramNames.add("PATIENT_ID");
			paramValues.add(patient.getID_Patient());
			
			aux = " AND ";
		}
		
		// Speciality filter
		if (specialty != null)
		{
			query.append(" LEFT JOIN contact.specialty AS contactSpecialty ");
			query.append(" LEFT JOIN episode.specialty AS episodeSpecialty ");
			
			condition.append(aux);
			condition.append(" (contactSpecialty.id = :SPEC_ID OR (episodeSpecialty.id = :SPEC_ID AND contactSpecialty is null) ) ");
			
			paramNames.add("SPEC_ID");
			paramValues.add(specialty.getID());
			
			aux = " AND ";
		}
		
		// Authoring HCP filter
		if (authoringHcp != null)
		{
			query.append(" LEFT JOIN assessment.authoringInformation.authoringHcp AS auth_hcp ");
			condition.append(aux);
			condition.append(" auth_hcp.id = :AUTH_ID ");
			
			paramNames.add("AUTH_ID");
			paramValues.add(authoringHcp.getID_Hcp());
			
			aux = " AND ";
		}
		
		// Responsible HCP filter
		if (responsibleHcp != null)
		{
			query.append(" LEFT JOIN episode.responsibleHCP AS resp_hcp ");
			condition.append(aux);
			condition.append(" resp_hcp.id = :RESP_ID ");
			
			paramNames.add("RESP_ID");
			paramValues.add(responsibleHcp.getID_Hcp());
			
			aux = " AND ";
		}
		
		// Assessment Name filter
		if (assessmentName != null && assessmentName.length() > 0)
		{
			condition.append(aux);
			condition.append(" ( UPPER(userAss.name) LIKE :ASS_NAME OR UPPER(graphic.name) LIKE :ASS_NAME ) ");
			
			paramNames.add("ASS_NAME");
			paramValues.add("%" + assessmentName.toUpperCase() + "%");
			
			aux = " AND ";
		}
		
		// Assessment Status filter
		if (status != null)
		{
			condition.append(aux);
			condition.append(" assessment.status.id = :ASS_STATUS ");
			
			paramNames.add("ASS_STATUS");
			paramValues.add(status.getID());
			
			aux = " AND ";
		}
		
		
		// Date interval filter
		if (dateFrom != null)
		{
			condition.append(aux);

			if (Boolean.TRUE.equals(useEventDate))
			{
				condition.append(" (contact.startDateTime >= :DATE_FROM OR ");
				condition.append(" (contact is null AND context.startDateTime >= :DATE_FROM) ");
				condition.append(" OR (contact is null AND context is null AND episode.startDate >= :DATE_FROM) ) ");
				
				paramNames.add("DATE_FROM");
				paramValues.add(dateFrom.getDate());

				aux = " AND "; 
			}
			else
			{
				condition.append(" assessment.systemInformation.creationDateTime >= :DATE_FROM ");
				
				paramNames.add("DATE_FROM");
				paramValues.add(dateFrom.getDate());
				
				aux = " AND ";
			}
		}
		
		if (dateTo != null)
		{
			condition.append(aux);
			
			if (Boolean.TRUE.equals(useEventDate))
			{
				condition.append(" (contact.startDateTime <= :DATE_TO OR ");
				condition.append(" (contact is null AND context.startDateTime <= :DATE_TO) ");
				condition.append(" OR (contact is null AND context is null AND episode.startDate <= :DATE_TO) ) ");
				
				paramNames.add("DATE_TO");
				paramValues.add(new DateTime(dateTo, new ims.framework.utils.Time(23, 59, 59)).getJavaDate());
				
				aux = " AND ";
			}
			else
			{
				condition.append(" assessment.systemInformation.creationDateTime <= :DATE_TO ");
				
				paramNames.add("DATE_TO");
				paramValues.add(new DateTime(dateTo, new ims.framework.utils.Time(23, 59, 59)).getJavaDate());
				
				aux = " AND ";
			}
		}


		// Complete query
		query.append(" WHERE ");
		query.append(condition.toString());

		PatientAssessmentListVoCollection searchResults = PatientAssessmentListVoAssembler.createPatientAssessmentListVoCollectionFromPatientAssessment(getDomainFactory().find(query.toString(), paramNames, paramValues));
		
		searchResults.sort(new EventDateComparator(SortOrder.DESCENDING));
		
		return searchResults;
	}


	/**
	 * Function used to retrieve Episode Of Care (ShortVo) record
	 */
	public EpisodeofCareShortVo getEpisodeOfCare(EpisodeOfCareRefVo episodeOfCare)
	{
		if (episodeOfCare == null || !episodeOfCare.getID_EpisodeOfCareIsNotNull())
			return null;
		
		return EpisodeofCareShortVoAssembler.create((EpisodeOfCare) getDomainFactory().getDomainObject(EpisodeOfCare.class, episodeOfCare.getID_EpisodeOfCare()));
	}

	/**
	 * Function used to retrieve Care Context (ShortVo) record
	 */
	public CareContextShortVo getCareContext(CareContextRefVo careContext)
	{
		if (careContext == null || !careContext.getID_CareContextIsNotNull())
			return null;
		
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContext.getID_CareContext()));
	}


	/**
	 * Function used to retrieve Clinical Contact (ShortVo) record
	 */
	public ClinicalContactShortVo getClinicalContact(ClinicalContactRefVo clinicalContact)
	{
		if (clinicalContact == null || !clinicalContact.getID_ClinicalContactIsNotNull())
			return null;
		
		return ClinicalContactShortVoAssembler.create((ClinicalContact) getDomainFactory().getDomainObject(ClinicalContact.class, clinicalContact.getID_ClinicalContact()));
	}
}
