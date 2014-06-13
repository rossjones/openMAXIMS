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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseProcedureSpecialtyHotlistImpl;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;

import java.util.ArrayList;
import java.util.List;

public class ProcedureSpecialtyHotlistImpl extends BaseProcedureSpecialtyHotlistImpl
{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public ims.core.vo.ProcedureLiteVoCollection listProcedures(ims.core.vo.lookups.Specialty speciality, String nameFilter) throws ims.domain.exceptions.DomainInterfaceException
	{
		if (speciality == null && nameFilter == null)
			throw new DomainInterfaceException("At least one search value must be not null");
		StringBuilder query = new StringBuilder();
		query.append("select p3_1 from ProcedureHotlist as p1_1 left join p1_1.hotlistItem as p2_1 " +
				"left join p2_1.procedure as p3_1 where (p3_1.isActive = 1 and ");
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		if (speciality!=null)
		{
			query.append("p1_1.specialty.id = :specialityId");
			paramNames.add("specialityId");
			paramValues.add(speciality.getID());
		}
		if (speciality!=null && nameFilter != null)
		{
			query.append(" and ");
		}
		if (nameFilter != null)
		{
			query.append("UPPER(p3_1.procedureName) like :nameFilter");//WDEV-14088
			paramNames.add("nameFilter");
			paramValues.add("%"+nameFilter.toUpperCase()+"%"); //WDEV-14088
		}
		query.append(") order by p3_1.procedureName asc ");
		List domObj = getDomainFactory().find(query.toString(),paramNames,paramValues);
		if (domObj == null || domObj.size() == 0)
			return null;
		return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(domObj);
	}
}
