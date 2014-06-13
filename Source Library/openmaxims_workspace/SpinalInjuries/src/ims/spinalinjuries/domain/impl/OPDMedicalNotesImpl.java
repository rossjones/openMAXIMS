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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.36 build 2109.20214)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.generalmedical.vo.OPDGenNotesShortVoCollection;
import ims.generalmedical.vo.OPDGenNotesVo;
import ims.generalmedical.vo.OPDGenNotesVoCollection;
import ims.generalmedical.vo.domain.OPDGenNotesShortVoAssembler;
import ims.generalmedical.vo.domain.OPDGenNotesVoAssembler;
import ims.medical.domain.objects.OPDGenNotes;

public class OPDMedicalNotesImpl extends DomainImpl implements ims.spinalinjuries.domain.OPDMedicalNotes, ims.domain.impl.Transactional
{

	public void saveOPDGenNotesVo(OPDGenNotesVo voOPDGenNotes) throws DomainInterfaceException, StaleObjectException 
	{
		// Ensure the value object has been validated
		if (!voOPDGenNotes.isValidated())
			throw new DomainRuntimeException("OPD Gen Notes has not been validated");
		
		DomainFactory factory = getDomainFactory();
		OPDGenNotes doOPDGenNotes = OPDGenNotesVoAssembler.extractOPDGenNotes(factory, voOPDGenNotes);

		factory.save(doOPDGenNotes);
	}

	public OPDGenNotesVo getOPDGenNotesByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from OPDGenNotes gennotes ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " gennotes.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List gnList = factory.find(query,markers,values);
		
		OPDGenNotesVoCollection voOPDGenNotesVoColl = OPDGenNotesVoAssembler.createOPDGenNotesVoCollectionFromOPDGenNotes(gnList);
		if(voOPDGenNotesVoColl.size()>0)
			return voOPDGenNotesVoColl.get(0);
		
		return null;
	}

	public OPDGenNotesShortVoCollection listOPDGenNotesByEpisodeOfCare(EpisodeOfCareRefVo voEpisodeOfCareRef)
	{		
		DomainFactory factory = getDomainFactory();
		
		String hql = " from OPDGenNotes gennotes "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voEpisodeOfCareRef != null)
		{
			condStr.append(andStr + " gennotes.careContext.episodeOfCare.id = :eoc"); 
			markers.add("eoc");
			values.add(voEpisodeOfCareRef.getID_EpisodeOfCare());
			andStr = " and ";
		}	
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		List notes = factory.find(hql, markers, values);
		OPDGenNotesShortVoCollection voOPDGenNotesVoColl = OPDGenNotesShortVoAssembler.createOPDGenNotesShortVoCollectionFromOPDGenNotes(notes);
		if(voOPDGenNotesVoColl.size()>0)
			return voOPDGenNotesVoColl.sort(SortOrder.DESCENDING);
		
		return null;
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);

	}
	
}
