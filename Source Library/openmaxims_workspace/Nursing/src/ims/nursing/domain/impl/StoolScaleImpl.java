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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.22 build 41206.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.nursing.vo.StoolScaleVo;
import ims.nursing.vo.StoolScaleVoCollection;
import ims.nursing.vo.domain.StoolScaleVoAssembler;


public class StoolScaleImpl extends DomainImpl implements ims.nursing.domain.StoolScale, ims.domain.impl.Transactional
{
	/**
	 * Function used to list care contexts for given patient that have a Stool Assessment registered
	 */
	public CareContextShortVoCollection listStoolScaleCareContexts(PatientRefVo patient)
	{
		if (patient == null || !patient.getID_PatientIsNotNull())
			return null;
		
		return CareContextShortVoAssembler.createCareContextShortVoCollectionFromCareContext(getDomainFactory().find("select distinct stool.careContext from StoolScale stool where stool.careContext.episodeOfCare.careSpell.patient.id = " + patient.getID_Patient().toString()));
	}

	/**
	 * Function used to list stool scale assessments for given care context
	 */
	public StoolScaleVoCollection listStoolScaleAssessments(CareContextRefVo careContext)
	{
		if (careContext == null || !careContext.getID_CareContextIsNotNull())
			return null;
		List ss = getDomainFactory().find("from StoolScale stool where stool.careContext.id = " + careContext.getID_CareContext().toString());
		return StoolScaleVoAssembler.createStoolScaleVoCollectionFromStoolScale(ss);
	}


	public StoolScaleVo saveStoolScaleAssessment(StoolScaleVo voStoolScale) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		// Ensure the Value Object was validated
		if (!voStoolScale.isValidated())
			throw new DomainRuntimeException("This Stool Scale has not been validated");

		DomainFactory factory = getDomainFactory();
		ims.nursing.assessmenttools.domain.objects.StoolScale domStoolScale = StoolScaleVoAssembler.extractStoolScale(factory, voStoolScale);

		factory.save(domStoolScale);
		return StoolScaleVoAssembler.create(domStoolScale);
	}

	public HcpLiteVoCollection listHCP(String name)
	{
		// Check parameter
		if (name == null)
			return null;
		
		String hqlQuery = "from Hcp hcp where hcp.mos.name.upperSurname like :NAME or hcp.mos.name.upperForename like :NAME order by hcp.mos.name.upperForename asc";
		
		ArrayList<String> paramNames = new ArrayList<String>();
			paramNames.add("NAME");
			
		ArrayList<Object> paramValues = new ArrayList<Object>();
			paramValues.add("%" + name.toUpperCase() + "%");
		
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(getDomainFactory().find(hqlQuery, paramNames, paramValues));
	}

}
