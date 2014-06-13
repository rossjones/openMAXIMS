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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.45 build 2421.18554)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BaseDailyPatternandShiftsImpl;
import ims.clinicaladmin.vo.domain.DailyPatternConfigVoAssembler;
import ims.clinicaladmin.vo.domain.DailyPatternShortConfigVoAssembler;
import ims.core.configuration.domain.objects.DailyPattern;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.ServiceVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.exceptions.CodingRuntimeException;

public class DailyPatternandShiftsImpl extends BaseDailyPatternandShiftsImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* list Daily pattern Config Short Vo
	*/
	public ims.clinicaladmin.vo.DailyPatternShortConfigVoCollection list()
	{
		DomainFactory factory = getDomainFactory();
		String hql = "from DailyPattern dp ";
		
		return DailyPatternShortConfigVoAssembler.createDailyPatternShortConfigVoCollectionFromDailyPattern(factory.find(hql));
	}

	/**
	* save 
	 * @throws UniqueKeyViolationException 
	*/
	public ims.clinicaladmin.vo.DailyPatternConfigVo save(ims.clinicaladmin.vo.DailyPatternConfigVo record) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid record");
		if(!record.isValidated())
			throw new CodingRuntimeException("Record not validated");
		
		DomainFactory factory = getDomainFactory();
		DailyPattern domainRecord = DailyPatternConfigVoAssembler.extractDailyPattern(factory, record);		
		try
		{
			factory.save(domainRecord);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("A Daily Pattern record of this type already exists. Duplicates not allowed.", e);
		}
		
		return DailyPatternConfigVoAssembler.create(domainRecord);
	}

	/**
	* getInvasiveDeviceConfig
	*/
	public ims.clinicaladmin.vo.DailyPatternConfigVo get(ims.core.configuration.vo.DailyPatternRefVo refVo)
	{
		if(refVo == null || refVo.getID_DailyPattern() == null)
			throw new DomainRuntimeException("Invalid record");
		
		DomainFactory factory = getDomainFactory();
		DailyPattern domainRecord = (DailyPattern)factory.getDomainObject(DailyPattern.class, refVo.getID_DailyPattern().intValue());
		return DailyPatternConfigVoAssembler.create(domainRecord);
	}

	/**
	* list full Daily pattern Config Vo
	*/
	public ims.clinicaladmin.vo.DailyPatternConfigVoCollection listFull()
	{
		DomainFactory factory = getDomainFactory();
		String hql = "from DailyPattern dp ";
		
		return DailyPatternConfigVoAssembler.createDailyPatternConfigVoCollectionFromDailyPattern(factory.find(hql));
	}
}
