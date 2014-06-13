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

public class OcsOrderLiteVoBean extends ims.vo.ValueObjectBean
{
	public OcsOrderLiteVoBean()
	{
	}
	public OcsOrderLiteVoBean(ims.ocrr.vo.OcsOrderLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleClinician().getBean();
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getResponsibleGp().getBean();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean();
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getPatientClinic().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OcsOrderLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleClinician().getBean(map);
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getResponsibleGp().getBean(map);
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean(map);
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getPatientClinic().getBean(map);
	}

	public ims.ocrr.vo.OcsOrderLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OcsOrderLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OcsOrderLiteVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OcsOrderLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OcsOrderLiteVo();
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
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.core.vo.beans.GpLiteVoBean getResponsibleGp()
	{
		return this.responsiblegp;
	}
	public void setResponsibleGp(ims.core.vo.beans.GpLiteVoBean value)
	{
		this.responsiblegp = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.core.vo.beans.ClinicLiteVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.core.vo.beans.ClinicLiteVoBean value)
	{
		this.patientclinic = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean responsibleclinician;
	private ims.core.vo.beans.GpLiteVoBean responsiblegp;
	private ims.core.vo.beans.LocationLiteVoBean patientlocation;
	private ims.core.vo.beans.ClinicLiteVoBean patientclinic;
}
