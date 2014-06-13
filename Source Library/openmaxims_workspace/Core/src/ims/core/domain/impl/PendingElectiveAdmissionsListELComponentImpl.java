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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.careuk.domain.objects.PatientElectiveList;
import ims.careuk.domain.objects.TCIForPatientElectiveList;
import ims.careuk.vo.PatientElectiveListForPendingAdmissionVo;
import ims.careuk.vo.PatientElectiveListForPendingAdmissionVoCollection;
import ims.careuk.vo.PatientElectiveListRefVo;
import ims.careuk.vo.PatientElectiveTCIBedManagerCommentVo;
import ims.careuk.vo.domain.PatientElectiveListForPendingAdmissionVoAssembler;
import ims.careuk.vo.domain.PatientElectiveTCIBedManagerCommentVoAssembler;
import ims.careuk.vo.lookups.ElectiveAdmissionType;
import ims.configuration.gen.ConfigFlag;
import ims.core.domain.base.impl.BasePendingElectiveAdmissionsListELComponentImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PendingElectiveAdmissionListFilterVo;
import ims.core.vo.domain.LocMostVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.io.Serializable;
import java.util.ArrayList;

public class PendingElectiveAdmissionsListELComponentImpl extends BasePendingElectiveAdmissionsListELComponentImpl
{

	private static final long serialVersionUID = 1L;

	public HcpLiteVoCollection listHCPs(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin implHcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return implHcpAdmin.listHcpLite(filter);
	}

	public ims.core.vo.LocationLiteVoCollection listWards(Integer hospitalID, String searchName)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocationRefVo voRef = new LocationRefVo();
		voRef.setID_Location(hospitalID);
		return implLoc.listActiveWardsForHospitalByNameLite(voRef, searchName);
	}

	public HcpLiteVo getHCP(Integer idHCP)
	{
		HcpAdmin implHcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		HcpFilter voFilter = new HcpFilter();
		voFilter.setID_Hcp(idHCP);
		return implHcpAdmin.getHcpLite(voFilter);
	}

	public LocationLiteVo getWard(ims.core.resource.place.vo.LocationRefVo voWardRef)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return implLoc.getLocation(voWardRef.getID_Location());
	}

	public ims.core.vo.LocationLiteVoCollection listActiveHospitalsLite()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();
	}

	public LocationLiteVo getHospital(ims.core.resource.place.vo.LocationRefVo locationRefvo)
	{
		DomainFactory factory = getDomainFactory();
		return LocationLiteVoAssembler.create((Location) factory.getDomainObject(Location.class, locationRefvo.getID_Location()));
	}

	public LocMostVo getLocation(ims.core.resource.place.vo.LocationRefVo voLocRef)
	{
		DomainFactory factory = getDomainFactory();
		return LocMostVoAssembler.create((Location) factory.getDomainObject(Location.class, voLocRef.getID_Location()));
	}

	public PatientElectiveListForPendingAdmissionVoCollection getElectiveLists(PendingElectiveAdmissionListFilterVo searchFilter)
	{
		if (searchFilter == null)
			throw new CodingRuntimeException("Invalid searchFilter");


		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Serializable> values = new ArrayList<Serializable>();

		StringBuffer sb = new StringBuffer();
		String andStr = "";

		String hql = "select pel from PatientElectiveList as pel left join pel.patient as pat"; 

		String strSearchSurname = "";
		String strSearchForename = "";

		if (searchFilter.getHospNumIsNotNull())
		{
			hql += " left join pat.identifiers as ids ";
			
			String idVal = searchFilter.getHospNum().trim();			
			if (searchFilter.getIDType().equals(PatIdType.NHSN))
				idVal = searchFilter.getHospNum().replace(" ", "");//wdev-7305
			
			if(!ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue())
				idVal = idVal.toUpperCase();

			if (searchFilter.getIDType().equals(PatIdType.NHSN))
			{
				sb.append(andStr + " ids.value like :idnum ");
				idVal += "%";
			}
			else
				sb.append(andStr + " ids.value = :idnum");

			markers.add("idnum");
			values.add(idVal);
			
			andStr = " and ";
			sb.append(andStr + " ids.type = :idtype");
			markers.add("idtype");
			values.add(getDomLookup(searchFilter.getIDType()));
			andStr = " and ";
		}
		else
		{
			if(searchFilter.getForenameIsNotNull())
			{
				sb.append(andStr + " pat.name.upperForename like :patFore");
				markers.add("patFore");
				andStr = " and ";
				
				strSearchForename = searchFilter.getForename().toUpperCase().trim();
				strSearchForename = strSearchForename.replaceAll("[^a-zA-Z]", "");
					
				if(strSearchForename.length() >= 40)
				{
					strSearchForename = strSearchForename.substring(0,40);
					strSearchForename += '%';
				}
				else
				{
					strSearchForename += '%';
				}
				
				values.add(strSearchForename);
	
			}
	
			if(searchFilter.getSurnameIsNotNull())
			{
				sb.append(andStr + " pat.name.upperSurname like :patSur");
				markers.add("patSur");
				andStr = " and ";
	
				strSearchSurname = searchFilter.getSurname().toUpperCase().trim();
				strSearchSurname = strSearchSurname.replaceAll("[^a-zA-Z]", "");
					
				if(strSearchSurname.length() >= 40)
				{
					strSearchSurname = strSearchSurname.substring(0,40);
					strSearchSurname += '%';
				}
				else
				{
					strSearchSurname += '%';
				}
				
				values.add(strSearchSurname);
			}
		}
		
		if (searchFilter.getAlertIsNotNull())
		{
			hql += " left join pat.patientAlerts as patAlerts ";

			sb.append(andStr + "patAlerts.alertType = :alertID");
			markers.add("alertID");
			values.add(getDomLookup(searchFilter.getAlert()));
			andStr = " and ";
		}

		if (searchFilter.getConsultantIsNotNull())
		{
			hql += " left join pel.consultant as cons ";
			sb.append(andStr + " cons.id = :cons");
			markers.add("cons");
			values.add(searchFilter.getConsultant().getID_Hcp());
			andStr = " and ";
		}
		
		if (searchFilter.getHospitalIsNotNull())
		{
			sb.append(andStr + " pel.ward.parentLocation.id = :hosp");
			markers.add("hosp");
			values.add(searchFilter.getHospital().getID_Location());
			andStr = " and ";
		}
		
		if (searchFilter.getWardIsNotNull())
		{
			sb.append(andStr + " pel.ward.id = :ward");
			markers.add("ward");
			values.add(searchFilter.getWard().getID_Location());
			andStr = " and ";
		}
		
		if (searchFilter.getTCIIsNotNull())
		{ 
			if (Boolean.TRUE.equals(searchFilter.getTCIDateOnly()))
			{
				sb.append(andStr + " ( pel.tCIDetails.tCIDate >= :tci1 ");
				markers.add("tci1");
				values.add(new DateTime(searchFilter.getTCI(), new Time("00:00:00")).getJavaDate());
				andStr = " and ";
				sb.append(andStr + " pel.tCIDetails.tCIDate <= :tci2 )");
				markers.add("tci2");
				values.add(new DateTime(searchFilter.getTCI(), new Time("23:59:59")).getJavaDate());
				andStr = " and ";
			}
			else
			{
				sb.append(andStr + " pel.tCIDetails.tCIDate <= :tci");
				markers.add("tci");
				values.add(new DateTime(searchFilter.getTCI(), new Time("23:59:59")).getJavaDate());
				andStr = " and ";
			}
		}
		
		if (searchFilter.getSpecialtyIsNotNull())
		{
			hql += " left join pel.electiveList as el left join el.service as serv ";
			
			sb.append(andStr + " serv.specialty = :spec");
			markers.add("spec");
			values.add(getDomLookup(searchFilter.getSpecialty()));
			andStr = " and ";
		}
		
		
		sb.append(andStr + " pel.electiveAdmissionType = :stat");
		markers.add("stat");
		values.add(getDomLookup(ElectiveAdmissionType.BOOKED_TYPE12));
		
		hql += " where ";
		hql += sb.toString();
		
		
		return PatientElectiveListForPendingAdmissionVoAssembler.createPatientElectiveListForPendingAdmissionVoCollectionFromPatientElectiveList(getDomainFactory().find(hql.toString(), markers, values));
	}

	public PatientShort getPatientShort(PatientRefVo patientRef)
	{
		if(patientRef == null)
			throw new CodingRuntimeException("Cannot get Patient on null patientRef.");
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientRef.getID_Patient()));
	}

	public PatientElectiveListForPendingAdmissionVo getCurrentPendingRecord(PatientElectiveListRefVo patientElectiveListRef)
	{
		if(patientElectiveListRef == null)
			throw new CodingRuntimeException("Cannot get PatientElectiveList on null patientElectiveListRef.");
		
		return PatientElectiveListForPendingAdmissionVoAssembler.create((PatientElectiveList) getDomainFactory().getDomainObject(PatientElectiveList.class, patientElectiveListRef.getID_PatientElectiveList()));
	}

	public void saveTCIDetails(PatientElectiveTCIBedManagerCommentVo tciDetails) throws StaleObjectException
	{
		if (tciDetails == null)
			throw new CodingRuntimeException("Cannot save null TCIDetails");

		DomainFactory factory = getDomainFactory();
		TCIForPatientElectiveList domainTCIDetails = PatientElectiveTCIBedManagerCommentVoAssembler.extractTCIForPatientElectiveList(factory, tciDetails);

		factory.save(domainTCIDetails);
	}

	
}
