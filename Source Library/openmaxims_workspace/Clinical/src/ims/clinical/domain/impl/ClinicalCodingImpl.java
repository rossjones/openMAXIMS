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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.helper.Keywords;
import ims.clinical.configuration.domain.objects.ClinicalProblem;
import ims.clinical.configuration.domain.objects.DiagnosisHotlistItem;
import ims.clinical.configuration.domain.objects.MedicationHotlistItem;
import ims.clinical.configuration.domain.objects.ProblemHotlistItem;
import ims.clinical.configuration.domain.objects.ProcedureHotlistItem;
import ims.clinical.configuration.domain.objects.CancerImagingHotlistItem;
import ims.clinical.domain.base.impl.BaseClinicalCodingImpl;
import ims.clinical.vo.ProblemConfigVo;
import ims.clinical.vo.domain.ClinicalProblemShortVoAssembler;
import ims.clinical.vo.domain.ProblemConfigVoAssembler;
import ims.core.clinical.domain.objects.Allergen;
import ims.core.clinical.domain.objects.CancerImagingEvent;
import ims.core.clinical.domain.objects.Diagnosis;
import ims.core.clinical.domain.objects.Medication;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.vo.AllergenDetails;
import ims.core.vo.AllergenVo;
import ims.core.vo.AllergenVoCollection;
import ims.core.vo.CancerImagingEventLiteVoCollection;
import ims.core.vo.CancerImagingEventVo;
import ims.core.vo.DiagnosisVo;
import ims.core.vo.MedicationLiteVoCollection;
import ims.core.vo.MedicationVo;
import ims.core.vo.ProcedureVo;
import ims.core.vo.domain.AllergenDetailsAssembler;
import ims.core.vo.domain.AllergenVoAssembler;
import ims.core.vo.domain.CancerImagingEventLiteVoAssembler;
import ims.core.vo.domain.CancerImagingEventVoAssembler;
import ims.core.vo.domain.DiagLiteVoAssembler;
import ims.core.vo.domain.DiagnosisVoAssembler;
import ims.core.vo.domain.MedicationLiteVoAssembler;
import ims.core.vo.domain.MedicationVoAssembler;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.core.vo.domain.ProcedureVoAssembler;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;


public class ClinicalCodingImpl extends BaseClinicalCodingImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.ClinicalProblemShortVoCollection listConfiguredProblemsShort(String pcName, Boolean activeOnly) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from ClinicalProblem p join p.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (activeOnly.booleanValue() == true)
		{
			hql.append(" where p.isActive = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		
		return ClinicalProblemShortVoAssembler.createClinicalProblemShortVoCollectionFromClinicalProblem(Keywords.searchByKeywords(factory, pcName, hql.toString(), names, values));		
	}

	/**
	* listHotlistProblemsShort
	 * @throws DomainInterfaceException 
	*/
	public ims.clinical.vo.ClinicalProblemShortVoCollection listHotlistProblemsShort(String pcName, ims.core.vo.lookups.Specialty lkpSpecialty) throws DomainInterfaceException
	{
		if(pcName == null)
			throw new DomainRuntimeException("Invalid Search criteria. Clinical Problem name filter must be supplied.");
		
		if(lkpSpecialty == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("select distinct probHotListItem from ProblemHotlist as probHotList left join probHotList.hotlistItem as probHotListItem left join probHotListItem.problem as prob left join prob.keywords as kw "); 
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where prob.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		hql.append(" and probHotList.specialty = :spec");
		names.add("spec");
		values.add(getDomLookup(lkpSpecialty));			
	
		List hits = Keywords.searchByKeywords(factory, pcName, hql.toString(), names, values);		
		
		List ret = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			ret.add(((ProblemHotlistItem)hits.get(i)).getProblem());
		}
		
		return ClinicalProblemShortVoAssembler.createClinicalProblemShortVoCollectionFromClinicalProblem(ret);
	}

	/**
	* listHotlistProcedureShort
	 * @throws DomainInterfaceException 
	*/
	public ims.core.vo.ProcedureLiteVoCollection listHotlistProcedureShort(String procedureName, ims.core.vo.lookups.Specialty lkpSpecialty) throws DomainInterfaceException
	{
		if(procedureName == null)
			throw new DomainRuntimeException("Invalid Search criteria. Clinical Problem name filter must be supplied.");
		
		if(lkpSpecialty == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("select distinct procHotListItem from ProcedureHotlist as procHotList left join procHotList.hotlistItem as procHotListItem left join procHotListItem.procedure as proc left join proc.keywords as kw "); 
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where proc.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		if (lkpSpecialty !=null)
		{
			hql.append(" and procHotList.specialty = :spec");
			names.add("spec");
			values.add(getDomLookup(lkpSpecialty));			
		}
	
		List hits = Keywords.searchByKeywords(factory, procedureName, hql.toString(), names, values);		
		
		List ret = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			ret.add(((ProcedureHotlistItem)hits.get(i)).getProcedure());
		}
		
		return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(ret);
	}

	public ims.core.vo.ProcedureLiteVoCollection listProcLiteVo(String filter) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Procedure proc join proc.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql.append(" where proc.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	
		return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(Keywords.searchByKeywords(factory, filter, hql.toString(), names, values));		
	}

	/**
	* List of Diagnoses to choose from
	 * @throws DomainInterfaceException 
	*/
	public ims.core.vo.DiagLiteVoCollection listDiagnosisLiteVo(String filter) throws DomainInterfaceException
	{		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Diagnosis d join d.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql.append(" where d.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	
		
		return DiagLiteVoAssembler.createDiagLiteVoCollectionFromDiagnosis(Keywords.searchByKeywords(factory, filter, hql.toString(), names, values));			
	}

	/**
	* listHotListDiagnosis
	 * @throws DomainInterfaceException 
	*/
	public ims.core.vo.DiagLiteVoCollection listHotListDiagnosis(String name, ims.core.vo.lookups.Specialty specialty) throws DomainInterfaceException
	{
		if(name == null)
			throw new DomainRuntimeException("Invalid Search criteria. Diagnosis name filter must be supplied.");
		
		if(specialty == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("select distinct diagHotListItem from DiagnosisHotlist as diagHotList left join diagHotList.hotListItem as diagHotListItem left join diagHotListItem.diagnosis as diag left join diag.keywords as kw "); 
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where diag.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		hql.append(" and diagHotList.specialty = :spec");
		names.add("spec");
		values.add(getDomLookup(specialty));			
	
		List hits = Keywords.searchByKeywords(factory, name, hql.toString(), names, values);		
		
		List diags = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			diags.add(((DiagnosisHotlistItem)hits.get(i)).getDiagnosis());
		}
		
		return DiagLiteVoAssembler.createDiagLiteVoCollectionFromDiagnosis(diags);
	}
	
	public MedicationLiteVoCollection listHotlistMedication(String name, Specialty specialty)  throws DomainInterfaceException
	{
		if(name == null)
			throw new DomainRuntimeException("Invalid Search criteria. Medication name filter must be supplied.");
		
		if(specialty == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("select distinct medHotListItem from MedicationHotlist as medHotList left join medHotList.hotListItem as medHotListItem left join medHotListItem.medication as med left join med.keywords as kw "); 
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where med.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		hql.append(" and medHotList.specialty = :spec");
		names.add("spec");
		values.add(getDomLookup(specialty));			
	
		List hits = Keywords.searchByKeywords(factory, name, hql.toString(), names, values);		
		
		List meds = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			meds.add(((MedicationHotlistItem)hits.get(i)).getMedication());
		}
		
		return MedicationLiteVoAssembler.createMedicationLiteVoCollectionFromMedication(meds);
	}
	
	public AllergenVoCollection listAllergens(String strAllergen) throws DomainInterfaceException 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Allergen a join a.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql.append(" where a.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	
	
		return AllergenVoAssembler.createAllergenVoCollectionFromAllergen(Keywords.searchByKeywords(factory, strAllergen, hql.toString(), names, values));			

	}

	public MedicationLiteVoCollection listMedications(String filterMedication) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select distinct m from Medication m join m.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql.append(" where m.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);			
		return MedicationLiteVoAssembler.createMedicationLiteVoCollectionFromMedication(Keywords.searchByKeywords(factory, filterMedication, hql.toString(), names, values));			
	}

	
	
	public AllergenVo saveAllergenVo(AllergenVo allergenVo) throws StaleObjectException, UniqueKeyViolationException
	{
		AllergenDetails detVo = new AllergenDetails(allergenVo.getID_Allergen(), allergenVo.getVersion_Allergen());
		detVo.setAllergenName(allergenVo.getAllergenName());
		detVo.setAllergenType(allergenVo.getAllergenType());
		detVo.setIsActive(allergenVo.getIsActive());
		detVo.setIsRIE(allergenVo.getIsRIE());
		String[] arrErrors = detVo.validate();
		if( arrErrors != null)
		{
			throw new DomainRuntimeException("Error saving Allergen - Allergen not vlaidated correctly");
		}
		return  saveAllergenDetails(detVo);
	}

	public AllergenDetails saveAllergenDetails(AllergenDetails allergenDetails) throws StaleObjectException, UniqueKeyViolationException
	{
		if (!allergenDetails.isValidated())
		{
			throw new DomainRuntimeException("Allergen Details VO has not be validated.");
		}
		
		DomainFactory factory = getDomainFactory();
		Allergen domAllergen = AllergenDetailsAssembler.extractAllergen(factory, allergenDetails);	
		
		domAllergen.setKeywords(Keywords.setupKeyWords(domAllergen.getKeywords(), domAllergen.getAllergenName()));
		try
		{
			factory.save(domAllergen);
		} 
		catch (UnqViolationUncheckedException e) 
		{	
			//check which constraint was violated (name/taxononmy map)

			//name
			Allergen allergen = Allergen.getAllergenFromAllergenName(factory, allergenDetails.getAllergenName());
			if (allergen != null && allergen.getId() != null && !(allergen.getId().equals(allergenDetails.getID_Allergen())))
			{
				throw new UniqueKeyViolationException("Allergen record called \"" + allergenDetails.getAllergenName() + "\" already exists. Duplicates not allowed.", e);					
			}

			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domAllergen, allergenDetails.getTaxonomyMap(), "getAllergenName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);

			throw (e);
		}
		return AllergenDetailsAssembler.create(domAllergen);
	}
	
	
	public ProcedureVo saveProcedureVo(ProcedureVo voProcedureVo) throws StaleObjectException, UniqueKeyViolationException
	{
		if (!voProcedureVo.isValidated())
		{
			throw new DomainRuntimeException("This ProcedureVo has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();		
		
		// We need to ensure that the taxonomy map is not duplicated - based on Taxonomy and map
		
		voProcedureVo.setProcedureName(voProcedureVo.getProcedureName().trim());//wdev-1336
		
		Procedure domProcedure = ProcedureVoAssembler.extractProcedure(factory, voProcedureVo);
		domProcedure.setKeywords(Keywords.setupKeyWords(domProcedure.getKeywords(), domProcedure.getProcedureName()));
		
		try
		{
			factory.save(domProcedure);
		}
		catch(UnqViolationUncheckedException e)
		{
			//check which constraint was violated (name/taxononmy map)
			
			///name
			Procedure proc = Procedure.getProcedureFromProcedureName(factory, voProcedureVo.getProcedureName());
			if (proc != null && proc.getId() != null && !(proc.getId().equals(voProcedureVo.getID_Procedure())))
			{
				throw new UniqueKeyViolationException("Procedure record called \"" + voProcedureVo.getProcedureName() + "\" already exists. Duplicates not allowed.", e);	
			}
							
			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domProcedure, voProcedureVo.getTaxonomyMap(), "getProcedureName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
						
			throw (e);
		}
		
		return ProcedureVoAssembler.create(domProcedure);
	}

	public DiagnosisVo saveDiagnosisVo(DiagnosisVo voDiagnosisVo) throws StaleObjectException, UniqueKeyViolationException 
	{
		if (!voDiagnosisVo.isValidated())
		{
			throw new DomainRuntimeException("This DiagnosisVo has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();			
		Diagnosis domDiagnosis = DiagnosisVoAssembler.extractDiagnosis(factory, voDiagnosisVo);

		domDiagnosis.setKeywords(Keywords.setupKeyWords(domDiagnosis.getKeywords(), domDiagnosis.getDiagnosisName()));
		try
		{
			factory.save(domDiagnosis);
		}
		catch(UnqViolationUncheckedException e)
		{		
			//check which constraint was violated (name/taxononmy map)

			//name
			Diagnosis diag = Diagnosis.getDiagnosisFromDiagnosisName(factory, voDiagnosisVo.getDiagnosisName());
			if (diag != null && diag.getId() != null && !(diag.getId().equals(voDiagnosisVo.getID_Diagnosis())))
			{
				throw new UniqueKeyViolationException("Diagnosis record called \"" + voDiagnosisVo.getDiagnosisName() + "\" already exists. Duplicates not allowed.", e);	
			}

			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domDiagnosis, voDiagnosisVo.getTaxonomyMap(), "getDiagnosisName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
						
			throw (e);
		}
		return DiagnosisVoAssembler.create(domDiagnosis);
	}

	public ProblemConfigVo saveConfigVo(ProblemConfigVo voProblemConfig) throws StaleObjectException, UniqueKeyViolationException 
	{
		if (!voProblemConfig.isValidated())
		{
			throw new DomainRuntimeException("This ProblemConfigVo has not be validated.");
		}
		
		DomainFactory factory = getDomainFactory();			
		ClinicalProblem domProblem = ProblemConfigVoAssembler.extractClinicalProblem(factory, voProblemConfig);
		
		domProblem.setKeywords(Keywords.setupKeyWords(domProblem.getKeywords(), domProblem.getPCName()));
		try
		{
			factory.save(domProblem);
		}
		catch(UnqViolationUncheckedException e)
		{
			//check which constraint was violated (name/taxononmy map)

			//name
			ClinicalProblem prob = ClinicalProblem.getClinicalProblemFromPCName(factory, voProblemConfig.getPCName());
			if (prob != null && prob.getId() != null && !(prob.getId().equals(voProblemConfig.getID_ClinicalProblem())))
			{
				throw new UniqueKeyViolationException("Problem record called \"" + voProblemConfig.getPCName() + "\" already exists. Duplicates not allowed.", e);					
			}
			
			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domProblem, voProblemConfig.getTaxonomyMap(), "getPCName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
			
			throw (e);
		}
		return ProblemConfigVoAssembler.create(domProblem);
	}

	public MedicationVo saveConfigVo(MedicationVo voMedication) throws StaleObjectException, UniqueKeyViolationException 
	{
		if (!voMedication.isValidated())
		{
			throw new DomainRuntimeException("This MedicationVo has not been validated");
		}

		DomainFactory factory = getDomainFactory();

		voMedication.setMedicationName(voMedication.getMedicationName().trim());//wdev-1336

		Medication domMedication = MedicationVoAssembler.extractMedication(factory, voMedication);	
		
		domMedication.setKeywords(Keywords.setupKeyWords(domMedication.getKeywords(), domMedication.getMedicationName()));
	
		try
		{
			factory.save(domMedication);
		}
		catch (UnqViolationUncheckedException e)
		{		
//			check which constraint was violated (name/taxononmy map)

			//name
			Medication med = Medication.getMedicationFromMedicationName(factory, voMedication.getMedicationName());
			if (med != null && med.getId() != null && !(med.getId().equals(voMedication.getID_Medication())))
			{
				throw new UniqueKeyViolationException("Medication record called \"" + voMedication.getMedicationName() + "\" already exists. Duplicates not allowed.", e);	
			}
			
			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domMedication, voMedication.getTaxonomyMap(), "getMedicationName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
			
			throw (e);
		}

		return MedicationVoAssembler.create(domMedication);
	}

	public DiagnosisVo getDiagnosisByName(String strDiagnosisName) 
	{
		DomainFactory factory = getDomainFactory();
		Diagnosis domDiagnosis = Diagnosis.getDiagnosisFromDiagnosisName(factory, strDiagnosisName);
		return DiagnosisVoAssembler.create(domDiagnosis);
	}

	public MedicationVo getMedicationByName(String strName) 
	{
		DomainFactory factory = getDomainFactory();
		Medication domMedication = Medication.getMedicationFromMedicationName(factory, strName);
		return MedicationVoAssembler.create(domMedication);
	}

	public ProcedureVo getProcedureByName(String strName) 
	{
		DomainFactory factory = getDomainFactory();
		Procedure domProcedure = Procedure.getProcedureFromProcedureName(factory, strName);
		return ProcedureVoAssembler.create(domProcedure);
	}

	public ProblemConfigVo getProblemByName(String strName) 
	{
		DomainFactory factory = getDomainFactory();	
		ClinicalProblem domProblem = ClinicalProblem.getClinicalProblemFromPCName(factory, strName);
		return ProblemConfigVoAssembler.create(domProblem);
	}

	public AllergenVo getAllergenByName(String strName) 
	{
		DomainFactory factory = getDomainFactory();
		Allergen domAllergen = Allergen.getAllergenFromAllergenName(factory, strName);
		return AllergenVoAssembler.create(domAllergen);
	}

	public CancerImagingEventVo saveCancerImagingEventVo(CancerImagingEventVo voImagingEvent) throws StaleObjectException, UniqueKeyViolationException 
	{
		if (!voImagingEvent.isValidated())
		{
			throw new DomainRuntimeException("This CancerImagingEventVo has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();			
		CancerImagingEvent domCancerImagingEvent = CancerImagingEventVoAssembler.extractCancerImagingEvent(factory, voImagingEvent);

		domCancerImagingEvent.setKeywords(Keywords.setupKeyWords(domCancerImagingEvent.getKeywords(), domCancerImagingEvent.getImagingEventName()));
		try
		{
			factory.save(domCancerImagingEvent);
		}
		catch(UnqViolationUncheckedException e)
		{		
			//check which constraint was violated (name/taxononmy map)

			//name
			CancerImagingEvent cie = CancerImagingEvent.getCancerImagingEventFromImagingEventName(factory, voImagingEvent.getImagingEventName());
			if (cie != null && cie.getId() != null && !(cie.getId().equals(voImagingEvent.getID_CancerImagingEvent())))
			{
				throw new UniqueKeyViolationException("Cancer Imaging Event record called \"" + voImagingEvent.getImagingEventName() + "\" already exists. Duplicates not allowed.", e);	
			}

			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domCancerImagingEvent, voImagingEvent.getTaxonomyMap(), "getCancerImagingEvent");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
						
			throw (e);
		}
		return CancerImagingEventVoAssembler.create(domCancerImagingEvent);
	}

	public CancerImagingEventLiteVoCollection listHotlistImagingEventsLite(String name, Specialty specialty) throws DomainInterfaceException 
	{
		if(name == null)
			throw new DomainRuntimeException("Invalid Search criteria. Cancer Imagaing Event name filter must be supplied.");
		
		if(specialty == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer("select distinct cieItem from CancerImagingHotlist as cie left join cie.hotListItem as cieItem left join cieItem.cancerImagingEvent as cieEvent left join cieEvent.keywords as kw "); 
	
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where cieEvent.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		hql.append(" and cie.specialty = :spec");
		names.add("spec");
		values.add(getDomLookup(specialty));			
	
		List hits = Keywords.searchByKeywords(factory, name, hql.toString(), names, values);		
		
		List ret = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			ret.add(((CancerImagingHotlistItem)hits.get(i)).getCancerImagingEvent());
		}
		
		return CancerImagingEventLiteVoAssembler.createCancerImagingEventLiteVoCollectionFromCancerImagingEvent(ret);
	}

	public CancerImagingEventLiteVoCollection listImagingEventsLite(String name) throws DomainInterfaceException 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from CancerImagingEvent cie join cie.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql.append(" where cie.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	
		
		return CancerImagingEventLiteVoAssembler.createCancerImagingEventLiteVoCollectionFromCancerImagingEvent(Keywords.searchByKeywords(factory, name, hql.toString(), names, values));			
	}

	public CancerImagingEventVo getImagingEventByName(String name) 
	{
		DomainFactory factory = getDomainFactory();
		CancerImagingEvent domCIE = CancerImagingEvent.getCancerImagingEventFromImagingEventName(factory, name);
		return CancerImagingEventVoAssembler.create(domCIE);
	}
}
