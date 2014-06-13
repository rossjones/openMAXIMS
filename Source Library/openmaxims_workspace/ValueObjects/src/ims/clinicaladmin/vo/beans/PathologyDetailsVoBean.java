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

package ims.clinicaladmin.vo.beans;

public class PathologyDetailsVoBean extends ims.vo.ValueObjectBean
{
	public PathologyDetailsVoBean()
	{
	}
	public PathologyDetailsVoBean(ims.clinicaladmin.vo.PathologyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigationtype = vo.getInvestigationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvestigationType().getBean();
		this.samplereceiptdate = vo.getSampleReceiptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSampleReceiptDate().getBean();
		this.investigationresultdate = vo.getInvestigationResultDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInvestigationResultDate().getBean();
		// Interface field type not supported.
		this.reportingorganisation = vo.getReportingOrganisation() == null ? null : (ims.core.vo.beans.OrgLiteVoBean)vo.getReportingOrganisation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.previousversion = vo.getPreviousVersion() == null ? null : new ims.vo.RefVoBean(vo.getPreviousVersion().getBoId(), vo.getPreviousVersion().getBoVersion());
		this.invasivelesionsize = vo.getInvasiveLesionSize();
		this.synchronoustumourindicator = vo.getSynchronousTumourIndicator() == null ? null : (ims.vo.LookupInstanceBean)vo.getSynchronousTumourIndicator().getBean();
		this.histology = vo.getHistology() == null ? null : vo.getHistology().getBeanCollection();
		this.vascularlymphinvasion = vo.getVascularLymphInvasion() == null ? null : (ims.vo.LookupInstanceBean)vo.getVascularLymphInvasion().getBean();
		this.excisionmargin = vo.getExcisionMargin() == null ? null : (ims.vo.LookupInstanceBean)vo.getExcisionMargin().getBean();
		this.numbernodesexamined = vo.getNumberNodesExamined();
		this.nodespositivenumber = vo.getNodesPositiveNumber();
		this.pathologicaltval = vo.getPathologicalTVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean)vo.getPathologicalTVal().getBean();
		this.pathologicalnval = vo.getPathologicalNVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean)vo.getPathologicalNVal().getBean();
		this.pathologicalmval = vo.getPathologicalMVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean)vo.getPathologicalMVal().getBean();
		this.pathologicaloverall = vo.getPathologicalOverall() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean)vo.getPathologicalOverall().getBean();
		this.servicereportid = vo.getServiceReportId();
		this.servicereportstatus = vo.getServiceReportStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getServiceReportStatus().getBean();
		this.specimennature = vo.getSpecimenNature() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenNature().getBean();
		this.orgacoderequester = vo.getOrgaCodeRequester() == null ? null : (ims.core.vo.beans.OrgLiteVoBean)vo.getOrgaCodeRequester().getBean();
		// Interface field type not supported.
		this.tcategoryextended = vo.getTCategoryExtended() == null ? null : vo.getTCategoryExtended().getBeanCollection();
		this.mcategoryextended = vo.getMCategoryExtended() == null ? null : vo.getMCategoryExtended().getBeanCollection();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.associatedquestions = vo.getAssociatedQuestions() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getAssociatedQuestions().getBean();
		this.associatiatedtumourdetails = vo.getAssociatiatedTumourDetails() == null ? null : (ims.oncology.vo.beans.PrimaryTumourDetailsShortVoBean)vo.getAssociatiatedTumourDetails().getBean();
		this.gradeofdifferentation = vo.getGradeOfDifferentation() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)vo.getGradeOfDifferentation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.PathologyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigationtype = vo.getInvestigationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvestigationType().getBean();
		this.samplereceiptdate = vo.getSampleReceiptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSampleReceiptDate().getBean();
		this.investigationresultdate = vo.getInvestigationResultDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInvestigationResultDate().getBean();
		// Interface field type not supported.
		this.reportingorganisation = vo.getReportingOrganisation() == null ? null : (ims.core.vo.beans.OrgLiteVoBean)vo.getReportingOrganisation().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.previousversion = vo.getPreviousVersion() == null ? null : new ims.vo.RefVoBean(vo.getPreviousVersion().getBoId(), vo.getPreviousVersion().getBoVersion());
		this.invasivelesionsize = vo.getInvasiveLesionSize();
		this.synchronoustumourindicator = vo.getSynchronousTumourIndicator() == null ? null : (ims.vo.LookupInstanceBean)vo.getSynchronousTumourIndicator().getBean();
		this.histology = vo.getHistology() == null ? null : vo.getHistology().getBeanCollection();
		this.vascularlymphinvasion = vo.getVascularLymphInvasion() == null ? null : (ims.vo.LookupInstanceBean)vo.getVascularLymphInvasion().getBean();
		this.excisionmargin = vo.getExcisionMargin() == null ? null : (ims.vo.LookupInstanceBean)vo.getExcisionMargin().getBean();
		this.numbernodesexamined = vo.getNumberNodesExamined();
		this.nodespositivenumber = vo.getNodesPositiveNumber();
		this.pathologicaltval = vo.getPathologicalTVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean)vo.getPathologicalTVal().getBean(map);
		this.pathologicalnval = vo.getPathologicalNVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean)vo.getPathologicalNVal().getBean(map);
		this.pathologicalmval = vo.getPathologicalMVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean)vo.getPathologicalMVal().getBean(map);
		this.pathologicaloverall = vo.getPathologicalOverall() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean)vo.getPathologicalOverall().getBean(map);
		this.servicereportid = vo.getServiceReportId();
		this.servicereportstatus = vo.getServiceReportStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getServiceReportStatus().getBean();
		this.specimennature = vo.getSpecimenNature() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenNature().getBean();
		this.orgacoderequester = vo.getOrgaCodeRequester() == null ? null : (ims.core.vo.beans.OrgLiteVoBean)vo.getOrgaCodeRequester().getBean(map);
		// Interface field type not supported.
		this.tcategoryextended = vo.getTCategoryExtended() == null ? null : vo.getTCategoryExtended().getBeanCollection();
		this.mcategoryextended = vo.getMCategoryExtended() == null ? null : vo.getMCategoryExtended().getBeanCollection();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.associatedquestions = vo.getAssociatedQuestions() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getAssociatedQuestions().getBean(map);
		this.associatiatedtumourdetails = vo.getAssociatiatedTumourDetails() == null ? null : (ims.oncology.vo.beans.PrimaryTumourDetailsShortVoBean)vo.getAssociatiatedTumourDetails().getBean(map);
		this.gradeofdifferentation = vo.getGradeOfDifferentation() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)vo.getGradeOfDifferentation().getBean(map);
	}

	public ims.clinicaladmin.vo.PathologyDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinicaladmin.vo.PathologyDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.PathologyDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinicaladmin.vo.PathologyDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinicaladmin.vo.PathologyDetailsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getInvestigationType()
	{
		return this.investigationtype;
	}
	public void setInvestigationType(ims.vo.LookupInstanceBean value)
	{
		this.investigationtype = value;
	}
	public ims.framework.utils.beans.DateBean getSampleReceiptDate()
	{
		return this.samplereceiptdate;
	}
	public void setSampleReceiptDate(ims.framework.utils.beans.DateBean value)
	{
		this.samplereceiptdate = value;
	}
	public ims.framework.utils.beans.DateBean getInvestigationResultDate()
	{
		return this.investigationresultdate;
	}
	public void setInvestigationResultDate(ims.framework.utils.beans.DateBean value)
	{
		this.investigationresultdate = value;
	}
	public ims.core.vo.beans.OrgLiteVoBean getReportingOrganisation()
	{
		return this.reportingorganisation;
	}
	public void setReportingOrganisation(ims.core.vo.beans.OrgLiteVoBean value)
	{
		this.reportingorganisation = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getPreviousVersion()
	{
		return this.previousversion;
	}
	public void setPreviousVersion(ims.vo.RefVoBean value)
	{
		this.previousversion = value;
	}
	public Integer getInvasiveLesionSize()
	{
		return this.invasivelesionsize;
	}
	public void setInvasiveLesionSize(Integer value)
	{
		this.invasivelesionsize = value;
	}
	public ims.vo.LookupInstanceBean getSynchronousTumourIndicator()
	{
		return this.synchronoustumourindicator;
	}
	public void setSynchronousTumourIndicator(ims.vo.LookupInstanceBean value)
	{
		this.synchronoustumourindicator = value;
	}
	public ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean[] getHistology()
	{
		return this.histology;
	}
	public void setHistology(ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean[] value)
	{
		this.histology = value;
	}
	public ims.vo.LookupInstanceBean getVascularLymphInvasion()
	{
		return this.vascularlymphinvasion;
	}
	public void setVascularLymphInvasion(ims.vo.LookupInstanceBean value)
	{
		this.vascularlymphinvasion = value;
	}
	public ims.vo.LookupInstanceBean getExcisionMargin()
	{
		return this.excisionmargin;
	}
	public void setExcisionMargin(ims.vo.LookupInstanceBean value)
	{
		this.excisionmargin = value;
	}
	public Integer getNumberNodesExamined()
	{
		return this.numbernodesexamined;
	}
	public void setNumberNodesExamined(Integer value)
	{
		this.numbernodesexamined = value;
	}
	public Integer getNodesPositiveNumber()
	{
		return this.nodespositivenumber;
	}
	public void setNodesPositiveNumber(Integer value)
	{
		this.nodespositivenumber = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean getPathologicalTVal()
	{
		return this.pathologicaltval;
	}
	public void setPathologicalTVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean value)
	{
		this.pathologicaltval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean getPathologicalNVal()
	{
		return this.pathologicalnval;
	}
	public void setPathologicalNVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean value)
	{
		this.pathologicalnval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean getPathologicalMVal()
	{
		return this.pathologicalmval;
	}
	public void setPathologicalMVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean value)
	{
		this.pathologicalmval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean getPathologicalOverall()
	{
		return this.pathologicaloverall;
	}
	public void setPathologicalOverall(ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean value)
	{
		this.pathologicaloverall = value;
	}
	public String getServiceReportId()
	{
		return this.servicereportid;
	}
	public void setServiceReportId(String value)
	{
		this.servicereportid = value;
	}
	public ims.vo.LookupInstanceBean getServiceReportStatus()
	{
		return this.servicereportstatus;
	}
	public void setServiceReportStatus(ims.vo.LookupInstanceBean value)
	{
		this.servicereportstatus = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenNature()
	{
		return this.specimennature;
	}
	public void setSpecimenNature(ims.vo.LookupInstanceBean value)
	{
		this.specimennature = value;
	}
	public ims.core.vo.beans.OrgLiteVoBean getOrgaCodeRequester()
	{
		return this.orgacoderequester;
	}
	public void setOrgaCodeRequester(ims.core.vo.beans.OrgLiteVoBean value)
	{
		this.orgacoderequester = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean[] getTCategoryExtended()
	{
		return this.tcategoryextended;
	}
	public void setTCategoryExtended(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean[] value)
	{
		this.tcategoryextended = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean[] getMCategoryExtended()
	{
		return this.mcategoryextended;
	}
	public void setMCategoryExtended(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean[] value)
	{
		this.mcategoryextended = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentVoBean getAssociatedQuestions()
	{
		return this.associatedquestions;
	}
	public void setAssociatedQuestions(ims.assessment.vo.beans.PatientAssessmentVoBean value)
	{
		this.associatedquestions = value;
	}
	public ims.oncology.vo.beans.PrimaryTumourDetailsShortVoBean getAssociatiatedTumourDetails()
	{
		return this.associatiatedtumourdetails;
	}
	public void setAssociatiatedTumourDetails(ims.oncology.vo.beans.PrimaryTumourDetailsShortVoBean value)
	{
		this.associatiatedtumourdetails = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean getGradeOfDifferentation()
	{
		return this.gradeofdifferentation;
	}
	public void setGradeOfDifferentation(ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean value)
	{
		this.gradeofdifferentation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean investigationtype;
	private ims.framework.utils.beans.DateBean samplereceiptdate;
	private ims.framework.utils.beans.DateBean investigationresultdate;
	private ims.core.vo.beans.OrgLiteVoBean reportingorganisation;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean previousversion;
	private Integer invasivelesionsize;
	private ims.vo.LookupInstanceBean synchronoustumourindicator;
	private ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean[] histology;
	private ims.vo.LookupInstanceBean vascularlymphinvasion;
	private ims.vo.LookupInstanceBean excisionmargin;
	private Integer numbernodesexamined;
	private Integer nodespositivenumber;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean pathologicaltval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean pathologicalnval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean pathologicalmval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean pathologicaloverall;
	private String servicereportid;
	private ims.vo.LookupInstanceBean servicereportstatus;
	private ims.vo.LookupInstanceBean specimennature;
	private ims.core.vo.beans.OrgLiteVoBean orgacoderequester;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean[] tcategoryextended;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueVoBean[] mcategoryextended;
	private ims.vo.LookupInstanceBean status;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.assessment.vo.beans.PatientAssessmentVoBean associatedquestions;
	private ims.oncology.vo.beans.PrimaryTumourDetailsShortVoBean associatiatedtumourdetails;
	private ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean gradeofdifferentation;
}
