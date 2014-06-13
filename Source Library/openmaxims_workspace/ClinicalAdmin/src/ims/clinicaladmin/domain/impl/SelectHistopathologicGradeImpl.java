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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BaseSelectHistopathologicGradeImpl;
import ims.clinicaladmin.vo.domain.HistopathologicGradeVoAssembler;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.configuration.domain.objects.HistopathologicGrade;

public class SelectHistopathologicGradeImpl extends BaseSelectHistopathologicGradeImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Lists HistopathologicGrade records.
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVoCollection listHistopathologicGrade()
	{
		String query = " from HistopathologicGrade as histoGrade where histoGrade.isActive = 1";
		
		return HistopathologicGradeVoAssembler.createHistopathologicGradeVoCollectionFromHistopathologicGrade(getDomainFactory().find(query));
	}

	/**
	* Returns selected HistopathologicGrade record or null if none is found.
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVo getHistopathologicGrade(ims.oncology.configuration.vo.HistopathologicGradeRefVo histopathologicGrade)
	{
		if (histopathologicGrade == null || !histopathologicGrade.getID_HistopathologicGradeIsNotNull())
			return null;
		
		return HistopathologicGradeVoAssembler.create((HistopathologicGrade) getDomainFactory().getDomainObject(HistopathologicGrade.class, histopathologicGrade.getID_HistopathologicGrade()));
	}

	/**
	* Save a HistopathologicRecord
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVo saveHistopathologicGrade(ims.clinicaladmin.vo.HistopathologicGradeVo histopathologicGrade) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException
	{
		// Check for value to save
		if (histopathologicGrade == null)
			throw new DomainRuntimeException("Domain Error - Can not save a null histology grade record");
		
		// Check for validated record
		if (!histopathologicGrade.isValidated())
			throw new DomainRuntimeException("Domain Error - Histology grade record must be validated before save");
		
		// Get domain object
		HistopathologicGrade histologyGrade = HistopathologicGradeVoAssembler.extractHistopathologicGrade(getDomainFactory(), histopathologicGrade);
		
		// Attempt save
		getDomainFactory().save(histologyGrade);
		
		return HistopathologicGradeVoAssembler.create(histologyGrade);
	}
}
