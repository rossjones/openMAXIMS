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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.60 build 2838.16667)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.pathways.domain.impl;

import java.util.List;

import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.pathways.domain.base.impl.BasePathwaySearchAndSelectImpl;
import ims.pathways.vo.PathwayShortVoCollection;
import ims.pathways.vo.domain.PathwayShortVoAssembler;
import ims.vo.interfaces.IMos;

public class PathwaySearchAndSelectImpl extends BasePathwaySearchAndSelectImpl
{

	private static final long serialVersionUID = 1L;

	public List listDomainPathway(String name, Specialty specialty, IMos consultant, PreActiveActiveInactiveStatus status) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from Pathway pw");
		
		java.util.ArrayList markers = new java.util.ArrayList();		
		java.util.ArrayList values  = new java.util.ArrayList();
		String andStr = " where ";
	
		if(name != null)
		{
			hql.append(andStr);
			hql.append("pw.upperName like :name");
			markers.add("name");
			values.add(name.toUpperCase() + "%");
			andStr = " and ";
		}
		if(specialty != null)
		{
			hql.append(andStr);
			hql.append("pw.specialty = :spec");
			markers.add("spec");
			values.add(getDomLookup(specialty));
			andStr = " and ";
		}
		if(status != null)
		{
			hql.append(andStr);
			hql.append("pw.status = :status");
			markers.add("status");
			values.add(getDomLookup(status));
			andStr = " and ";
		}
		//WDEV-9946
		if(consultant != null && consultant.getIMosHcpId() != null)
		{
			hql.append(andStr);
			hql.append("pw.consultant.id = :idConsultant");
			markers.add("idConsultant");
			values.add(consultant.getIMosHcpId());
			andStr = " and ";
		}
			
		List pathways = factory.find(hql.toString(), markers, values);
		return pathways;
	}

	public PathwayShortVoCollection listPathway(String name, Specialty specialty, IMos consultant, PreActiveActiveInactiveStatus status) 
	{
		//TODO temporary measure until component or new control created
		if(name != null)
			name = name.replaceAll("%", ""); 
		
		List pathways = listDomainPathway(name, specialty, consultant, status);
		return PathwayShortVoAssembler.createPathwayShortVoCollectionFromPathway(pathways).sort();
	}
}
