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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.SpecialtyListVo;
import ims.core.vo.SpecialtyListVoCollection;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.correspondence.configuration.domain.objects.Glossary;
import ims.correspondence.configuration.domain.objects.GlossaryProfile;
import ims.correspondence.domain.base.impl.BaseGlossaryAdminConfigurationImpl;
import ims.correspondence.helper.SpecifierAdapter;
import ims.correspondence.vo.GlossaryProfileVoCollection;
import ims.correspondence.vo.GlossaryVo;
import ims.correspondence.vo.domain.GlossaryProfileVoAssembler;
import ims.correspondence.vo.domain.GlossaryVoAssembler;
import ims.correspondence.vo.lookups.ProfileType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.lookups.LookupService;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.LookupInstanceCollection;
import ims.vo.interfaces.ICspTypeSpecifier;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.Medic;

public class GlossaryAdminConfigurationImpl extends BaseGlossaryAdminConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	private ICspTypeSpecifier[] listGlossaryProfileConsultants(String textToSearch) 
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		MedicLiteVoCollection medicLite = listMedicsLite(textToSearch);
		if (medicLite != null) 
			return medicLite.toICspTypeSpecifierArray();
		else
			return null;
	}
	
	private MedicLiteVoCollection listMedicsLite(String textToSearch) 
	{
		MedicLiteVoCollection voCollMedicsLite = new MedicLiteVoCollection();
		List lstMedics = listActiveMedics(textToSearch);
		if (lstMedics != null)
		{
			for (int i = 0; i < lstMedics.size(); i++)
			{
				Hcp hcp = (Hcp) lstMedics.get(i);
				if (Medic.class.isAssignableFrom(hcp.getClass()))
					voCollMedicsLite.add(MedicLiteVoAssembler.create((Medic) hcp));
			}
		}
		
		return voCollMedicsLite;
	}

	private List listActiveMedics(String textToSearch) 
	{
		
		DomainFactory factory = getDomainFactory();
		return factory.find("from Hcp h where h.hcpType = :hcpType and h.isActive = :bActive and h.mos.name.surname like :sur or h.mos.name.forename like :for", new String[]{"hcpType", "bActive", "sur", "for"}, new Object[]{getDomLookup(HcpDisType.MEDICAL), Boolean.TRUE, "%" + textToSearch.toUpperCase() + "%", "%" + textToSearch.toUpperCase() + "%"});
		
	}

	private ICspTypeSpecifier[] listGlossaryProfileSpecialties(String textToSearch) 
	{
		LookupService lookup = this.getLookupService();
		SpecialtyCollection collection = (SpecialtyCollection) lookup.getLookupCollection(Specialty.TYPE_ID,SpecialtyCollection.class, Specialty.class);
		ICspTypeSpecifier[] result = new ICspTypeSpecifier[collection.size()];
		for(int x = 0; x < collection.size(); x++)
		{
			result[x] = new SpecifierAdapter(collection.get(x));
		}		
		return result;
	}

	public ims.correspondence.vo.GlossaryVoCollection listAllGlossaryItems()
	{
		DomainFactory factory = getDomainFactory();
		List glossaryList = factory.listDomainObjects(Glossary.class);
		return GlossaryVoAssembler.createGlossaryVoCollectionFromGlossary(glossaryList);
	}

	public ims.correspondence.vo.GlossaryVo saveGlossary(ims.correspondence.vo.GlossaryVo voGlossary) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (voGlossary == null)
			throw new CodingRuntimeException("Invalid argument: GlossaryVo is null");
		if (!voGlossary.isValidated())
			throw new DomainRuntimeException("Glossary VO not validated.");

		DomainFactory factory = getDomainFactory();
		Glossary domGlossary = GlossaryVoAssembler.extractGlossary(factory,voGlossary);
		try
		{
			factory.save(domGlossary);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("Text already exists within the system for this Glossary.", e);
		}

		return GlossaryVoAssembler.create(domGlossary);
	}

	public void deleteGlossary(ims.correspondence.configuration.vo.GlossaryRefVo voGlossaryRef) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException
	{
		DomainFactory factory = getDomainFactory();
		
		String hql1 = " from Glossary g " +
		" where g.id = " +  voGlossaryRef.getID_Glossary();
	
		try
		{
			factory.delete(hql1);
		}
		catch (ForeignKeyViolationException e)
		{
			throw new ForeignKeyViolationException("There are data items in the system referencing this item - delete access denied", e);
		}
	}

	public ims.correspondence.vo.GlossaryProfileVo saveGlossaryProfile(ims.correspondence.vo.GlossaryProfileVo voGlossaryProfile) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (voGlossaryProfile ==null)
			throw new CodingRuntimeException("Invalid argument: GlossaryProfileVo is null)");
			
		if (!voGlossaryProfile.isValidated())
			throw new DomainRuntimeException("GlossaryProfileVo has not been validated");
		
		DomainFactory factory = getDomainFactory();
		GlossaryProfile domGlossaryProfile = GlossaryProfileVoAssembler.extractGlossaryProfile(factory, voGlossaryProfile);
	
		try
		{
			factory.save(domGlossaryProfile);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("Profile already exists within the system for this user.", e);
		}

		return GlossaryProfileVoAssembler.create(domGlossaryProfile);
	}

	public ims.correspondence.vo.GlossaryProfileVo getGlossaryProfile(ims.vo.interfaces.ICspTypeSpecifier iCspTypeSpecifier)
	{
		DomainFactory factory = getDomainFactory();		
		GlossaryProfile domGlossaryProfile = GlossaryProfile.getGlossaryProfileFromspecifier_unq_idx1(factory, iCspTypeSpecifier.getIGenericItemInfoID(), getDomLookup(iCspTypeSpecifier.getSpecifierType()));		
		return GlossaryProfileVoAssembler.create(domGlossaryProfile);
	}

	public ims.correspondence.vo.GlossaryVo getGlossary(ims.correspondence.configuration.vo.GlossaryRefVo refVoGlossary)
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public GlossaryProfileVoCollection listGlossaryProfile(GlossaryVo glossary, ProfileType profile) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		if(glossary != null && glossary.getGlossary() != null && profile != null)
		{
			String query = "from GlossaryProfile gpf ";
			
			hql.append("gpf.id in (select gpf.id from GlossaryProfile as gpf left join gpf.glossaries as gl where gl.glossary.id = :glo)");
			markers.add("glo");
			values.add(glossary.getGlossary().getID());
			
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("gpf.specifierType.id = :spe");
			markers.add("spe");
			values.add(profile.getID());
			
			if (markers.size() > 0)
				query += " where ";
			query += hql.toString();
			
			List glossaryProfileList = factory.find(query, markers, values);
			
			return GlossaryProfileVoAssembler.createGlossaryProfileVoCollectionFromGlossaryProfile(glossaryProfileList);
		}
		
		return null;
	}

	public ICspTypeSpecifier getMedicOrSpec(ProfileType profile, Integer id) 
	{
		if (profile == null)
			throw new CodingRuntimeException("Invalid Profile Type passed in as argument");
		
		if (profile.equals(ProfileType.SPECIALTY))			
		{
			return getSpeciality(id);
		}
		else if (profile.equals(ProfileType.CONSULTANT))			
		{
			return getConsultant(id);
		}
		throw new CodingRuntimeException("Unsupported Profile Type");
	}

	private ICspTypeSpecifier getConsultant(Integer id) 
	{
		if (id == null)
			throw new CodingRuntimeException("Invalid argiment:Medic Id is null.");
		
		DomainFactory factory = getDomainFactory();
		Medic doMed = (Medic) factory.getDomainObject(Medic.class, id);
		
		MedicVo medic = MedicVoAssembler.create(doMed);
		return (ICspTypeSpecifier) medic;
	}
	
	private ICspTypeSpecifier getSpeciality(Integer id) 
	{
		if (id == null)
			throw new CodingRuntimeException("Invalid argiment:Specifier Id is null.");
		
		LookupService lookup = this.getLookupService();
		Specialty spec =(Specialty) lookup.getLookupInstance(Specialty.class, id);
		ICspTypeSpecifier result = new SpecifierAdapter(spec);
		
		return result;
	}

	public ICspTypeSpecifier[] listMedicAndSpec(ProfileType profileType, String textToSearch) 
	{
		if (profileType == null)
			throw new CodingRuntimeException("Invalid Profile Type passed in as argument");
		
		if(textToSearch == null)
			throw new CodingRuntimeException("Cannot search on null text!");
		
		if (profileType.equals(ProfileType.SPECIALTY))			
		{
			return listGlossaryProfileSpecialties(textToSearch);

		}
		else if (profileType.equals(ProfileType.CONSULTANT))			
		{
			return listGlossaryProfileConsultants(textToSearch);
		}
		
		throw new CodingRuntimeException("Unsupported Profile Type");
	}
}
