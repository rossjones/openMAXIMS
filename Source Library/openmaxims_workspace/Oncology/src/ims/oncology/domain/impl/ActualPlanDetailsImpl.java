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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.53 build 2645.24233)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.oncology.domain.base.impl.BaseActualPlanDetailsImpl;
import ims.oncology.domain.objects.ActualPlanDetails;
import ims.oncology.vo.ActualPlanDetailsVo;
import ims.oncology.vo.domain.ActualPlanDetailsVoAssembler;

public class ActualPlanDetailsImpl extends BaseActualPlanDetailsImpl
{
	private static final long serialVersionUID = 1L;

	public ActualPlanDetailsVo getRecord(CareContextRefVo careContext) 
	{
		if (careContext == null)
			throw new RuntimeException("Cannot get ActualPlanDetailsVo for null CareContext");

		StringBuffer hql = new StringBuffer();
		hql.append("from  ActualPlanDetails as a1_1 where a1_1.careContext.id = :id and a1_1.isRIE is null");
		java.util.List list = getDomainFactory().find(hql.toString(), "id", careContext.getID_CareContext());
		if (list == null || list.size() == 0)
			return null;
		if (list.size() > 1)
			throw new RuntimeException("More than one ActualPlanDetailsVo found for the current Care Context");
		
		return ActualPlanDetailsVoAssembler.createActualPlanDetailsVoCollectionFromActualPlanDetails(list).get(0);
	}

	public ActualPlanDetailsVo saveRecord(ActualPlanDetailsVo record) throws DomainInterfaceException, StaleObjectException 
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid record");

		if(!record.isValidated())
			throw new CodingRuntimeException("Record not validated");
			
		DomainFactory factory = getDomainFactory();
		ActualPlanDetails domainRecord = ActualPlanDetailsVoAssembler.extractActualPlanDetails(factory, record);		
		
		factory.save(domainRecord);		
		
		return ActualPlanDetailsVoAssembler.create(domainRecord);
	}
}
