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

package ims.core.vo.beans;

public class PatientDiagnosisEDischargeListVoBean extends ims.vo.ValueObjectBean
{
	public PatientDiagnosisEDischargeListVoBean()
	{
	}
	public PatientDiagnosisEDischargeListVoBean(ims.core.vo.PatientDiagnosisEDischargeListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.iscomplication = vo.getIsComplication();
		this.iscomorbidity = vo.getIsComorbidity();
		this.dateresolved = vo.getDateResolved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateResolved().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextForEdischargeDiagnosisVoBean)vo.getCareContext().getBean();
		this.diaglaterality = vo.getDiagLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiagLaterality().getBean();
		this.sitetext = vo.getSiteText();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.includediagnosisindiscreports = vo.getIncludeDiagnosisInDiscReports() == null ? null : vo.getIncludeDiagnosisInDiscReports().getBeanCollection();
		this.isprevrelevantdiagnosis = vo.getIsPrevRelevantDiagnosis();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.dateonset = vo.getDateOnset() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnset().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.primaryforcarespells = vo.getPrimaryForCareSpells() == null ? null : vo.getPrimaryForCareSpells().getBeanCollection();
		this.comorbidityforepisodeofcares = vo.getCoMorbidityForEpisodeOfCares() == null ? null : vo.getCoMorbidityForEpisodeOfCares().getBeanCollection();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDiagnosisEDischargeListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean(map);
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.iscomplication = vo.getIsComplication();
		this.iscomorbidity = vo.getIsComorbidity();
		this.dateresolved = vo.getDateResolved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateResolved().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextForEdischargeDiagnosisVoBean)vo.getCareContext().getBean(map);
		this.diaglaterality = vo.getDiagLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiagLaterality().getBean();
		this.sitetext = vo.getSiteText();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.includediagnosisindiscreports = vo.getIncludeDiagnosisInDiscReports() == null ? null : vo.getIncludeDiagnosisInDiscReports().getBeanCollection();
		this.isprevrelevantdiagnosis = vo.getIsPrevRelevantDiagnosis();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.dateonset = vo.getDateOnset() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnset().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.primaryforcarespells = vo.getPrimaryForCareSpells() == null ? null : vo.getPrimaryForCareSpells().getBeanCollection();
		this.comorbidityforepisodeofcares = vo.getCoMorbidityForEpisodeOfCares() == null ? null : vo.getCoMorbidityForEpisodeOfCares().getBeanCollection();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public ims.core.vo.PatientDiagnosisEDischargeListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDiagnosisEDischargeListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDiagnosisEDischargeListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDiagnosisEDischargeListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDiagnosisEDischargeListVo();
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
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.diagnoseddate = value;
	}
	public ims.core.vo.beans.DiagLiteVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.beans.DiagLiteVoBean value)
	{
		this.diagnosis = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public Boolean getIsComplication()
	{
		return this.iscomplication;
	}
	public void setIsComplication(Boolean value)
	{
		this.iscomplication = value;
	}
	public Boolean getIsComorbidity()
	{
		return this.iscomorbidity;
	}
	public void setIsComorbidity(Boolean value)
	{
		this.iscomorbidity = value;
	}
	public ims.framework.utils.beans.DateBean getDateResolved()
	{
		return this.dateresolved;
	}
	public void setDateResolved(ims.framework.utils.beans.DateBean value)
	{
		this.dateresolved = value;
	}
	public ims.core.vo.beans.CareContextForEdischargeDiagnosisVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextForEdischargeDiagnosisVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.LookupInstanceBean getDiagLaterality()
	{
		return this.diaglaterality;
	}
	public void setDiagLaterality(ims.vo.LookupInstanceBean value)
	{
		this.diaglaterality = value;
	}
	public String getSiteText()
	{
		return this.sitetext;
	}
	public void setSiteText(String value)
	{
		this.sitetext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public ims.core.vo.beans.IncludeDiagnosisInDischargeReportVoBean[] getIncludeDiagnosisInDiscReports()
	{
		return this.includediagnosisindiscreports;
	}
	public void setIncludeDiagnosisInDiscReports(ims.core.vo.beans.IncludeDiagnosisInDischargeReportVoBean[] value)
	{
		this.includediagnosisindiscreports = value;
	}
	public Boolean getIsPrevRelevantDiagnosis()
	{
		return this.isprevrelevantdiagnosis;
	}
	public void setIsPrevRelevantDiagnosis(Boolean value)
	{
		this.isprevrelevantdiagnosis = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.framework.utils.beans.DateBean getDateOnset()
	{
		return this.dateonset;
	}
	public void setDateOnset(ims.framework.utils.beans.DateBean value)
	{
		this.dateonset = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.CSPrimaryDiagnosisVoBean[] getPrimaryForCareSpells()
	{
		return this.primaryforcarespells;
	}
	public void setPrimaryForCareSpells(ims.core.vo.beans.CSPrimaryDiagnosisVoBean[] value)
	{
		this.primaryforcarespells = value;
	}
	public ims.core.vo.beans.EpisodeOfCareCoMorbidityVoBean[] getCoMorbidityForEpisodeOfCares()
	{
		return this.comorbidityforepisodeofcares;
	}
	public void setCoMorbidityForEpisodeOfCares(ims.core.vo.beans.EpisodeOfCareCoMorbidityVoBean[] value)
	{
		this.comorbidityforepisodeofcares = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}

	private Integer id;
	private int version;
	private String diagnosisdescription;
	private ims.framework.utils.beans.PartialDateBean diagnoseddate;
	private ims.core.vo.beans.DiagLiteVoBean diagnosis;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private Boolean iscomplication;
	private Boolean iscomorbidity;
	private ims.framework.utils.beans.DateBean dateresolved;
	private ims.core.vo.beans.CareContextForEdischargeDiagnosisVoBean carecontext;
	private ims.vo.LookupInstanceBean diaglaterality;
	private String sitetext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private ims.core.vo.beans.IncludeDiagnosisInDischargeReportVoBean[] includediagnosisindiscreports;
	private Boolean isprevrelevantdiagnosis;
	private ims.vo.SysInfoBean sysinfo;
	private ims.framework.utils.beans.DateBean dateonset;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.core.vo.beans.CSPrimaryDiagnosisVoBean[] primaryforcarespells;
	private ims.core.vo.beans.EpisodeOfCareCoMorbidityVoBean[] comorbidityforepisodeofcares;
	private ims.vo.RefVoBean episodeofcare;
}
