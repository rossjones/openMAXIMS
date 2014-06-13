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

package ims.oncology.vo.beans;

public class ChemoDosageDetailsVoBean extends ims.vo.ValueObjectBean
{
	public ChemoDosageDetailsVoBean()
	{
	}
	public ChemoDosageDetailsVoBean(ims.oncology.vo.ChemoDosageDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patientmedication = vo.getPatientMedication() == null ? null : (ims.core.vo.beans.PatientMedicationLiteVoBean)vo.getPatientMedication().getBean();
		this.numberdoses = vo.getNumberDoses();
		this.providerorganisation = vo.getProviderOrganisation() == null ? null : (ims.vo.LookupInstanceBean)vo.getProviderOrganisation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.ChemoDosageDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patientmedication = vo.getPatientMedication() == null ? null : (ims.core.vo.beans.PatientMedicationLiteVoBean)vo.getPatientMedication().getBean(map);
		this.numberdoses = vo.getNumberDoses();
		this.providerorganisation = vo.getProviderOrganisation() == null ? null : (ims.vo.LookupInstanceBean)vo.getProviderOrganisation().getBean();
	}

	public ims.oncology.vo.ChemoDosageDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.ChemoDosageDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.ChemoDosageDetailsVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.ChemoDosageDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.ChemoDosageDetailsVo();
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
	public ims.core.vo.beans.PatientMedicationLiteVoBean getPatientMedication()
	{
		return this.patientmedication;
	}
	public void setPatientMedication(ims.core.vo.beans.PatientMedicationLiteVoBean value)
	{
		this.patientmedication = value;
	}
	public Integer getNumberDoses()
	{
		return this.numberdoses;
	}
	public void setNumberDoses(Integer value)
	{
		this.numberdoses = value;
	}
	public ims.vo.LookupInstanceBean getProviderOrganisation()
	{
		return this.providerorganisation;
	}
	public void setProviderOrganisation(ims.vo.LookupInstanceBean value)
	{
		this.providerorganisation = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientMedicationLiteVoBean patientmedication;
	private Integer numberdoses;
	private ims.vo.LookupInstanceBean providerorganisation;
}
