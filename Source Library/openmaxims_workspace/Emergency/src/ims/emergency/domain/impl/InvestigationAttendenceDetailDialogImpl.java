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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseInvestigationAttendenceDetailDialogImpl;
import ims.emergency.domain.objects.InvestigationAttendenceDetail;
import ims.emergency.vo.domain.InvestigationAttendenceDetailVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class InvestigationAttendenceDetailDialogImpl extends BaseInvestigationAttendenceDetailDialogImpl
{
	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.InvestigationAttendenceDetailVo save(ims.emergency.vo.InvestigationAttendenceDetailVo record) throws ims.domain.exceptions.StaleObjectException
	{
		if(record == null)
			throw new CodingRuntimeException("Cannot save a null InvestigationAttendenceDetailVo.");
		
		if(!record.isValidated())
			throw new CodingRuntimeException("InvestigationAttendenceDetailVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		InvestigationAttendenceDetail doRecord = InvestigationAttendenceDetailVoAssembler.extractInvestigationAttendenceDetail(factory, record);
		
		factory.save(doRecord);
		return InvestigationAttendenceDetailVoAssembler.create(doRecord);
	}
}
