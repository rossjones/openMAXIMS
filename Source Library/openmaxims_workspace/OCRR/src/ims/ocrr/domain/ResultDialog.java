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

package ims.ocrr.domain;

// Generated from form domain impl
public interface ResultDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.ocrr.vo.PathologySpecimenVo getSpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo id);

	// Generated from form domain interface definition
	public ims.ocrr.vo.PathologySpecimenVo getSpecimen(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orvInvRef);

	// Generated from form domain interface definition
	/**
	* getClinicalImagingResult
	*/
	public ims.ocrr.vo.ClinicalImagingResultVo getClinicalImagingResult(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultId);

	// Generated from form domain interface definition
	/**
	* listAssignedReports
	*/
	public ims.admin.vo.ReportVoCollection listAssignedReports(Integer formId);

	// Generated from form domain interface definition
	/**
	* getReportAndTemplate
	*/
	public String[] getReportAndTemplate(Integer reportId, Integer templateId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* getSystemReportAndTemplate
	*/
	public String[] getSystemReportAndTemplate(Integer imsId);

	// Generated from form domain interface definition
	public ims.ocrr.vo.NewResultSpecDocVo getOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo refOrderInvestigation);

	// Generated from form domain interface definition
	/**
	* getNewResultOcsOrderVo
	*/
	public ims.ocrr.vo.NewResultOcsOrderVo getNewResultOcsOrderVo(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultId);

	// Generated from form domain interface definition
	public String getCentricityPacsAccessionNumber(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo voOrderInvRefVo);

	// Generated from form domain interface definition
	/**
	* addViewedToStatusHistory
	*/
	public ims.ocrr.vo.OcsPathRadResultVo addViewedToStatusHistory(ims.ocrr.vo.OcsPathRadResultVo pathRadResultVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean wasSecondaryMatching(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigation);

	// Generated from form domain interface definition
	public ims.ocrr.vo.OrderInvestigationVo updateRadResultStatus(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInv, ims.vo.LookupInstVo newStatus, ims.core.resource.people.vo.HcpRefVo hcp) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.ocrr.vo.OrderInvestigationVo updatePathologyResultStatus(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo ordInvRef, ims.vo.LookupInstVo newStatus, ims.core.resource.people.vo.HcpRefVo hcp) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.ocrr.vo.OrderInvestigationVo resetAllocatedReviewHCP(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.PatientClericalTaskVo getPatientClericalTask(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultSelectedId);

	// Generated from form domain interface definition
	public String getMappingForResultStatusLookup(ims.ocrr.vo.lookups.ResultStatus resultStatusInstance, ims.core.vo.lookups.TaxonomyType extSystem);

	// Generated from form domain interface definition
	public ims.ocrr.vo.OcsPathRadResultVo refreshCurrentPathRadResult(ims.ocrr.vo.OcsPathRadResultVo currentPathRadResult);

	// Generated from form domain interface definition
	public ims.ocrr.vo.ClinicalResultVo getClinicalResult(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultId);
}
