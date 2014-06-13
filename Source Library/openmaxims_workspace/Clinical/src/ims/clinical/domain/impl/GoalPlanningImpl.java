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
// This code was generated by Peter Martin using IMS Development Environment (version 1.39 build 2159.23853)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.clinical.domain.objects.PatientGoal;
import ims.clinical.domain.objects.PatientGoalTarget;
import ims.clinical.vo.PatientGoalRefVo;
import ims.clinical.vo.PatientGoalTargetRefVo;
import ims.clinical.vo.PatientGoalTargetVo;
import ims.clinical.vo.PatientGoalVo;
import ims.clinical.vo.PatientGoalVoCollection;
import ims.clinical.vo.domain.PatientGoalTargetVoAssembler;
import ims.clinical.vo.domain.PatientGoalVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.domain.HcpAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.hibernate3.IMSCriteria;
import ims.domain.impl.DomainImpl;

public class GoalPlanningImpl extends DomainImpl implements ims.clinical.domain.GoalPlanning, ims.domain.impl.Transactional
{
	/**
	 * Function used to list all PatientGoals based on a CareContext
	 */
	public PatientGoalVoCollection listPatientGoals(CareContextRefVo careContextRef)
	{
		// Check for a valid CareContext
		if (careContextRef == null || !careContextRef.getID_CareContextIsNotNull())
		{
			throw new DomainRuntimeException("Major logical error - Provide a care context to search patient goals");
		}

		// Define filter criteria
		IMSCriteria criteria = new IMSCriteria(PatientGoal.class, getDomainFactory());
		criteria.equal("this.careContext.id", careContextRef.getID_CareContext());

		// Return corresponding PatientGoal collection
		return PatientGoalVoAssembler.createPatientGoalVoCollectionFromPatientGoal(criteria.find());
	}

	/**
	 * Function used to get a PatientGoal from database
	 */
	public PatientGoalVo getPatientGoal(PatientGoalRefVo patientGoalRef)
	{
		// If no PatientGoalRefVo is provided or no ID is present return null
		if (patientGoalRef == null || !patientGoalRef.getID_PatientGoalIsNotNull())
			return null;
		
		// Return PatientGoal based on ID
		return PatientGoalVoAssembler.create((PatientGoal) getDomainFactory().getDomainObject(PatientGoal.class, patientGoalRef.getID_PatientGoal()));
	}

	/**
	 * Function used to get a PatientGoalTarget from database
	 */
	public PatientGoalTargetVo getPatientGoalTarget(PatientGoalTargetRefVo patientGoalTargetRef)
	{
		// If no PatientGoalTargetRefVo is provided or no ID is present return null
		if (patientGoalTargetRef == null || !patientGoalTargetRef.getID_PatientGoalTargetIsNotNull())
			return null;
		
		// Return PatientGoalTarget based on ID
		return PatientGoalTargetVoAssembler.create((PatientGoalTarget) getDomainFactory().getDomainObject(PatientGoalTarget.class, patientGoalTargetRef.getID_PatientGoalTarget()));
	}

	/**
	 * Function used to save a PatientGoal to database
	 */
	public PatientGoalVo savePatientGoal(PatientGoalVo patientGoal) throws StaleObjectException, UniqueKeyViolationException
	{
		// Check if PatientGoalVo was validated	
		if (patientGoal == null || !patientGoal.isValidated())
		{
			throw new DomainRuntimeException("Logical Error - This PatientGoalVo has not been validated");
		}

		// Extract a domain object from PatientGoalVo
		DomainFactory factory = getDomainFactory();
		PatientGoal domPatientGoalVo = PatientGoalVoAssembler.extractPatientGoal(factory, patientGoal);

		// Save to database
		factory.save(domPatientGoalVo);

		// Return saved PatientGoalVo (with ID from database)
		return PatientGoalVoAssembler.create(domPatientGoalVo);
	}

	/**
	 *  Function used to save a PatientGoalTarget to database
	 */
	public PatientGoalTargetVo savePatientGoalTarget(PatientGoalTargetVo patientGoalTarget) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		// Check if PatientGoalTargetVo was validated
		if (patientGoalTarget == null || !patientGoalTarget.isValidated())
		{
			throw new DomainRuntimeException("Logical error - PatientGoalTargetVo has not been validated");
		}
		
		// Extract a domain object from PatientGoalTargetVo
		DomainFactory factory = getDomainFactory();
		PatientGoalTarget doPatientGoalTarget = PatientGoalTargetVoAssembler.extractPatientGoalTarget(factory, patientGoalTarget);
		
		// Save to database
		factory.save(doPatientGoalTarget);
		
		// Return saved PatientGoalTargetVo (with ID from database)
		return PatientGoalTargetVoAssembler.create(doPatientGoalTarget);
	}

	/**
	 * Function used to list HCPs from database
	 */
	public HcpCollection listHCP(String hcpName) throws DomainInterfaceException
	{
		// Check for a non null, non empty string
		if (hcpName == null || hcpName.length() == 0)
			throw new DomainInterfaceException("Can not search HCP with empty name");
		
		// Build HQL Query
		String hqlQuery = "from Hcp as hcp where hcp.mos.name.surname like :NAME or hcp.mos.name.forename like :NAME";

		// Create a parameters table (array of parameters names and array of parameters values)
		ArrayList<String> params = new ArrayList<String>();
		params.add("NAME");
		ArrayList<Object> values = new ArrayList<Object>();
		values.add("%" + hcpName + "%");

		// Return the result of the query (Hcp collection)
		DomainFactory factory = getDomainFactory();
		return HcpAssembler.createHcpCollectionFromHcp(factory.find(hqlQuery, params, values));
	}
}
