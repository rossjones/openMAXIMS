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

public class PatientDiagnosisForNursingNotesVoBean extends ims.vo.ValueObjectBean
{
	public PatientDiagnosisForNursingNotesVoBean()
	{
	}
	public PatientDiagnosisForNursingNotesVoBean(ims.core.vo.PatientDiagnosisForNursingNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosis = vo.getDiagnosis() == null ? null : new ims.vo.RefVoBean(vo.getDiagnosis().getBoId(), vo.getDiagnosis().getBoVersion());
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.iscomorbidity = vo.getIsComorbidity();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDiagnosisForNursingNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosis = vo.getDiagnosis() == null ? null : new ims.vo.RefVoBean(vo.getDiagnosis().getBoId(), vo.getDiagnosis().getBoVersion());
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.iscomorbidity = vo.getIsComorbidity();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public ims.core.vo.PatientDiagnosisForNursingNotesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDiagnosisForNursingNotesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDiagnosisForNursingNotesVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDiagnosisForNursingNotesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDiagnosisForNursingNotesVo();
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
	public ims.vo.RefVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.vo.RefVoBean value)
	{
		this.diagnosis = value;
	}
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public Boolean getIsComorbidity()
	{
		return this.iscomorbidity;
	}
	public void setIsComorbidity(Boolean value)
	{
		this.iscomorbidity = value;
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
	private ims.vo.RefVoBean diagnosis;
	private String diagnosisdescription;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private Boolean iscomorbidity;
	private ims.vo.RefVoBean episodeofcare;
}
