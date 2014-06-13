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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.clinical.domain.base.impl.BaseHCPsWithRecordsForProcedureImpl;
import ims.clinicaladmin.vo.domain.SurgicalOperationDetailsConfigVoAssembler;
import ims.domain.DomainFactory;

public class HCPsWithRecordsForProcedureImpl extends BaseHCPsWithRecordsForProcedureImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVoCollection getSurgicalOpDetailsConfig(ims.core.clinical.vo.ProcedureRefVo procedure)
	{
		// TODO: Add your code here and change the return value.
		DomainFactory factory = getDomainFactory();
		List surgvo =getDomainFactory().find("from SurgicalOperationDetailsConfig as s1_1 where (s1_1.procedureReference.id = :ID) ", new String[] {"ID"}, new Object[] {procedure.getID_Procedure()});
		if(surgvo.size() > 0)
			return SurgicalOperationDetailsConfigVoAssembler.createSurgicalOperationDetailsConfigVoCollectionFromSurgicalOperationDetailsConfig(surgvo);
			
		return null;
		
		
	}
}
