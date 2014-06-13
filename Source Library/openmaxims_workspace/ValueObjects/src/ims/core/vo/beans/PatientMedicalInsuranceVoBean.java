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

public class PatientMedicalInsuranceVoBean extends ims.vo.ValueObjectBean
{
	public PatientMedicalInsuranceVoBean()
	{
	}
	public PatientMedicalInsuranceVoBean(ims.core.vo.PatientMedicalInsuranceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.company = vo.getCompany() == null ? null : (ims.core.vo.beans.PrivateInsuranceCompanyVoBean)vo.getCompany().getBean();
		this.policynumber = vo.getPolicyNumber();
		this.policytype = vo.getPolicyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPolicyType().getBean();
		this.authorisationnumber = vo.getAuthorisationNumber();
		this.expirydate = vo.getExpiryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpiryDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
		this.statuschangedate = vo.getStatusChangeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStatusChangeDate().getBean();
		this.planorunits = vo.getPlanOrUnits();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientMedicalInsuranceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.company = vo.getCompany() == null ? null : (ims.core.vo.beans.PrivateInsuranceCompanyVoBean)vo.getCompany().getBean(map);
		this.policynumber = vo.getPolicyNumber();
		this.policytype = vo.getPolicyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPolicyType().getBean();
		this.authorisationnumber = vo.getAuthorisationNumber();
		this.expirydate = vo.getExpiryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpiryDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
		this.statuschangedate = vo.getStatusChangeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStatusChangeDate().getBean();
		this.planorunits = vo.getPlanOrUnits();
	}

	public ims.core.vo.PatientMedicalInsuranceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientMedicalInsuranceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientMedicalInsuranceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientMedicalInsuranceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientMedicalInsuranceVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.PrivateInsuranceCompanyVoBean getCompany()
	{
		return this.company;
	}
	public void setCompany(ims.core.vo.beans.PrivateInsuranceCompanyVoBean value)
	{
		this.company = value;
	}
	public String getPolicyNumber()
	{
		return this.policynumber;
	}
	public void setPolicyNumber(String value)
	{
		this.policynumber = value;
	}
	public ims.vo.LookupInstanceBean getPolicyType()
	{
		return this.policytype;
	}
	public void setPolicyType(ims.vo.LookupInstanceBean value)
	{
		this.policytype = value;
	}
	public String getAuthorisationNumber()
	{
		return this.authorisationnumber;
	}
	public void setAuthorisationNumber(String value)
	{
		this.authorisationnumber = value;
	}
	public ims.framework.utils.beans.DateBean getExpiryDate()
	{
		return this.expirydate;
	}
	public void setExpiryDate(ims.framework.utils.beans.DateBean value)
	{
		this.expirydate = value;
	}
	public ims.vo.LookupInstanceBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.vo.LookupInstanceBean value)
	{
		this.currentstatus = value;
	}
	public ims.framework.utils.beans.DateBean getStatusChangeDate()
	{
		return this.statuschangedate;
	}
	public void setStatusChangeDate(ims.framework.utils.beans.DateBean value)
	{
		this.statuschangedate = value;
	}
	public String getPlanOrUnits()
	{
		return this.planorunits;
	}
	public void setPlanOrUnits(String value)
	{
		this.planorunits = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.PrivateInsuranceCompanyVoBean company;
	private String policynumber;
	private ims.vo.LookupInstanceBean policytype;
	private String authorisationnumber;
	private ims.framework.utils.beans.DateBean expirydate;
	private ims.vo.LookupInstanceBean currentstatus;
	private ims.framework.utils.beans.DateBean statuschangedate;
	private String planorunits;
}
