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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.domain;

// Generated from form domain impl
public interface TaxonomyCodeAdmin extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public void openLogFiles();

	// Generated from form domain interface definition
	public ims.admin.vo.TaxonomyUploadVoCollection listCodeLoaderDef() throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.admin.vo.TaxonomyUploadVo saveCodeLoaderDef(ims.admin.vo.TaxonomyUploadVo codeLoaderDef) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.admin.vo.TaxonomyUploadVo getCodeLoaderDef(ims.core.admin.vo.TaxonomyUploadRefVo codeLoaderDefRef) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* getCode Loader Definition for a specified external code type and element
	*/
	public ims.admin.vo.TaxonomyUploadVo getCodeLoaderDef(Integer externalCodeTypeId, Integer taxonomyElementId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* get OPCS4 code based on code
	*/
	public ims.admin.vo.Opcs4Vo getOpcs4Code(String code) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* get icd10 code based n code
	*/
	public ims.admin.vo.Icd10AmProcVo getIcd10Code(String code) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.admin.vo.Opcs4Vo saveOpcs4Record(ims.admin.vo.Opcs4Vo vo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.admin.vo.Icd10AmProcVo saveIcd10Record(ims.admin.vo.Icd10AmProcVo vo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.admin.vo.TaxonomySnomedConceptVo getSnomedConcept(String code) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* save a snomed concept
	*/
	public ims.admin.vo.TaxonomySnomedConceptVo saveSnomedConceptRecord(ims.admin.vo.TaxonomySnomedConceptVo snomedConceptVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.admin.vo.TaxonomySnomedConWrdIdxVo getSnomedConceptWrdIdx(String keyword, String conceptId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.admin.vo.TaxonomySnomedConWrdIdxVo saveSnomedConceptWrdIdx(ims.admin.vo.TaxonomySnomedConWrdIdxVo vo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* delete all snomed concept word index records
	*/
	public void deleteSnomedConceptWrdIdx() throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.OrgVo savePracticeRecord(ims.core.vo.OrgVo vo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.OrgVo getPracticeCode(String code) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.GpVo saveGPRecord(ims.core.vo.GpVo vo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.GpVo getGPCode(String code) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.lookups.PersonTitle getLkpPersonTitle(String text) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteUpprNameVo saveSurgeryRecord(ims.core.vo.LocSiteUpprNameVo surgery) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteUpprNameVo getSurgeryCode(String code) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteUpprNameVo getSurgery(ims.core.vo.AddressVo address, ims.core.vo.OrgVo parent_org) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.CCGPCTPCCodesVo saveCCGRecord(ims.core.vo.CCGPCTPCCodesVo ccgVO) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.CCGPCTPCCodesVo getCCGRecord(String postcode);
}
