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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.40 build 2194.25473)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.therapies.treatment.domain.objects.GaitReEducation;
import ims.therapies.vo.GaitReEducationVo;
import ims.therapies.vo.GaitReEducationVoCollection;
import ims.therapies.vo.domain.GaitReEducationVoAssembler;


public class GaitReEducationImpl extends DomainImpl implements ims.therapies.domain.GaitReEducation, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	
	/**
	 *	WDEV-13648
	 *	List Gait Re-education records for a certain Care Context
	 */
	public GaitReEducationVoCollection listGaitReeducation(CareContextRefVo careContext) 
	{
		String hql = "from GaitReEducation gr where gr.clinicalContact.careContext.id = :RCC";

		return GaitReEducationVoAssembler.createGaitReEducationVoCollectionFromGaitReEducation(getDomainFactory().find(hql, "RCC", careContext.getID_CareContext()));
	}


	public void saveGaitReEducation(GaitReEducationVo voGaitReeducation) throws StaleObjectException, UniqueKeyViolationException
	{
		if(!voGaitReeducation.isValidated())
			throw new DomainRuntimeException("This Gait Re-Education has not been validated");
	
		DomainFactory factory = getDomainFactory();
		GaitReEducation doGait = GaitReEducationVoAssembler.extractGaitReEducation(factory, voGaitReeducation);
		factory.save(doGait);
	}

	
	public HcpCollection listHCPs(HcpFilter hcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(hcpFilter);
	}

	/**
	 *	WDEV-13648
	 *	List Gait Re-education records for a certain clinical contact
	 */
	public GaitReEducationVoCollection listGaitReEducation(ClinicalContactRefVo voClinicalContact)
	{
		String query = "from GaitReEducation gr where gr.clinicalContact.id = :RCC";
		
		return GaitReEducationVoAssembler.createGaitReEducationVoCollectionFromGaitReEducation(getDomainFactory().find(query, "RCC", voClinicalContact.getID_ClinicalContact()));
	}
}
