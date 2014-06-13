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

public class NewResultsSearchOrderSessionVoBean extends ims.vo.ValueObjectBean
{
	public NewResultsSearchOrderSessionVoBean()
	{
	}
	public NewResultsSearchOrderSessionVoBean(ims.ocrr.vo.NewResultsSearchOrderSessionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpMinVoBean)vo.getResponsibleClinician().getBean();
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpMinVoBean)vo.getResponsibleGp().getBean();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationMinVoBean)vo.getPatientLocation().getBean();
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicMinVoBean)vo.getPatientClinic().getBean();
		this.outpatientdept = vo.getOutpatientDept() == null ? null : (ims.core.vo.beans.LocationMinVoBean)vo.getOutpatientDept().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.NewResultsSearchOrderSessionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean(map);
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpMinVoBean)vo.getResponsibleClinician().getBean(map);
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpMinVoBean)vo.getResponsibleGp().getBean(map);
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationMinVoBean)vo.getPatientLocation().getBean(map);
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicMinVoBean)vo.getPatientClinic().getBean(map);
		this.outpatientdept = vo.getOutpatientDept() == null ? null : (ims.core.vo.beans.LocationMinVoBean)vo.getOutpatientDept().getBean(map);
	}

	public ims.ocrr.vo.NewResultsSearchOrderSessionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.NewResultsSearchOrderSessionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.NewResultsSearchOrderSessionVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.NewResultsSearchOrderSessionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.NewResultsSearchOrderSessionVo();
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
	public ims.core.vo.beans.PatientLite_IdentifiersVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLite_IdentifiersVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.HcpMinVoBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.beans.HcpMinVoBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.core.vo.beans.GpMinVoBean getResponsibleGp()
	{
		return this.responsiblegp;
	}
	public void setResponsibleGp(ims.core.vo.beans.GpMinVoBean value)
	{
		this.responsiblegp = value;
	}
	public ims.core.vo.beans.LocationMinVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.beans.LocationMinVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.core.vo.beans.ClinicMinVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.core.vo.beans.ClinicMinVoBean value)
	{
		this.patientclinic = value;
	}
	public ims.core.vo.beans.LocationMinVoBean getOutpatientDept()
	{
		return this.outpatientdept;
	}
	public void setOutpatientDept(ims.core.vo.beans.LocationMinVoBean value)
	{
		this.outpatientdept = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientLite_IdentifiersVoBean patient;
	private ims.core.vo.beans.HcpMinVoBean responsibleclinician;
	private ims.core.vo.beans.GpMinVoBean responsiblegp;
	private ims.core.vo.beans.LocationMinVoBean patientlocation;
	private ims.core.vo.beans.ClinicMinVoBean patientclinic;
	private ims.core.vo.beans.LocationMinVoBean outpatientdept;
}
