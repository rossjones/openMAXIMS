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

package ims.ocrr.vo.beans;

public class OcsOrderSummaryVoBean extends ims.vo.ValueObjectBean
{
	public OcsOrderSummaryVoBean()
	{
	}
	public OcsOrderSummaryVoBean(ims.ocrr.vo.OcsOrderSummaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpBean)vo.getResponsibleClinician().getBean();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean();
		this.specimens = vo.getSpecimens() == null ? null : vo.getSpecimens().getBeanCollection();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.clinicalinfo = vo.getClinicalInfo() == null ? null : (ims.ocrr.vo.beans.OcsQASessionVoBean)vo.getClinicalInfo().getBean();
		this.additclinnotes = vo.getAdditClinNotes();
		this.summaryclinicalinformation = vo.getSummaryClinicalInformation();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OcsOrderSummaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpBean)vo.getResponsibleClinician().getBean(map);
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean(map);
		this.specimens = vo.getSpecimens() == null ? null : vo.getSpecimens().getBeanCollection();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.clinicalinfo = vo.getClinicalInfo() == null ? null : (ims.ocrr.vo.beans.OcsQASessionVoBean)vo.getClinicalInfo().getBean(map);
		this.additclinnotes = vo.getAdditClinNotes();
		this.summaryclinicalinformation = vo.getSummaryClinicalInformation();
	}

	public ims.ocrr.vo.OcsOrderSummaryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OcsOrderSummaryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OcsOrderSummaryVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OcsOrderSummaryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OcsOrderSummaryVo();
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
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.HcpBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.beans.HcpBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.ocrr.vo.beans.PathologySpecimenVoBean[] getSpecimens()
	{
		return this.specimens;
	}
	public void setSpecimens(ims.ocrr.vo.beans.PathologySpecimenVoBean[] value)
	{
		this.specimens = value;
	}
	public ims.ocrr.vo.beans.OrderInvestigationListVoBean[] getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.beans.OrderInvestigationListVoBean[] value)
	{
		this.investigations = value;
	}
	public ims.ocrr.vo.beans.OcsQASessionVoBean getClinicalInfo()
	{
		return this.clinicalinfo;
	}
	public void setClinicalInfo(ims.ocrr.vo.beans.OcsQASessionVoBean value)
	{
		this.clinicalinfo = value;
	}
	public String getAdditClinNotes()
	{
		return this.additclinnotes;
	}
	public void setAdditClinNotes(String value)
	{
		this.additclinnotes = value;
	}
	public String getSummaryClinicalInformation()
	{
		return this.summaryclinicalinformation;
	}
	public void setSummaryClinicalInformation(String value)
	{
		this.summaryclinicalinformation = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.core.vo.beans.HcpBean responsibleclinician;
	private ims.core.vo.beans.LocationLiteVoBean patientlocation;
	private ims.ocrr.vo.beans.PathologySpecimenVoBean[] specimens;
	private ims.ocrr.vo.beans.OrderInvestigationListVoBean[] investigations;
	private ims.ocrr.vo.beans.OcsQASessionVoBean clinicalinfo;
	private String additclinnotes;
	private String summaryclinicalinformation;
}
