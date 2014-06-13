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

public class PatientCoreClinicalDataVoBean extends ims.vo.ValueObjectBean
{
	public PatientCoreClinicalDataVoBean()
	{
	}
	public PatientCoreClinicalDataVoBean(ims.core.vo.PatientCoreClinicalDataVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.allergystatus = vo.getAllergyStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAllergyStatus().getBean();
		this.alertstatus = vo.getAlertStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlertStatus().getBean();
		this.supportnetworkstatus = vo.getSupportNetworkStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupportNetworkStatus().getBean();
		this.supportnetworkservicestatus = vo.getSupportNetworkServiceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupportNetworkServiceStatus().getBean();
		this.allergyauthoringinformation = vo.getAllergyAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAllergyAuthoringInformation().getBean();
		this.alertauthoringinformation = vo.getAlertAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAlertAuthoringInformation().getBean();
		this.snstatusauthoringinformation = vo.getSnStatusAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getSnStatusAuthoringInformation().getBean();
		this.snserviceauthoringinformation = vo.getSnServiceAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getSnServiceAuthoringInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientCoreClinicalDataVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.allergystatus = vo.getAllergyStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAllergyStatus().getBean();
		this.alertstatus = vo.getAlertStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlertStatus().getBean();
		this.supportnetworkstatus = vo.getSupportNetworkStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupportNetworkStatus().getBean();
		this.supportnetworkservicestatus = vo.getSupportNetworkServiceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupportNetworkServiceStatus().getBean();
		this.allergyauthoringinformation = vo.getAllergyAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAllergyAuthoringInformation().getBean(map);
		this.alertauthoringinformation = vo.getAlertAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAlertAuthoringInformation().getBean(map);
		this.snstatusauthoringinformation = vo.getSnStatusAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getSnStatusAuthoringInformation().getBean(map);
		this.snserviceauthoringinformation = vo.getSnServiceAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getSnServiceAuthoringInformation().getBean(map);
	}

	public ims.core.vo.PatientCoreClinicalDataVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientCoreClinicalDataVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientCoreClinicalDataVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientCoreClinicalDataVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientCoreClinicalDataVo();
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
	public ims.vo.LookupInstanceBean getAllergyStatus()
	{
		return this.allergystatus;
	}
	public void setAllergyStatus(ims.vo.LookupInstanceBean value)
	{
		this.allergystatus = value;
	}
	public ims.vo.LookupInstanceBean getAlertStatus()
	{
		return this.alertstatus;
	}
	public void setAlertStatus(ims.vo.LookupInstanceBean value)
	{
		this.alertstatus = value;
	}
	public ims.vo.LookupInstanceBean getSupportNetworkStatus()
	{
		return this.supportnetworkstatus;
	}
	public void setSupportNetworkStatus(ims.vo.LookupInstanceBean value)
	{
		this.supportnetworkstatus = value;
	}
	public ims.vo.LookupInstanceBean getSupportNetworkServiceStatus()
	{
		return this.supportnetworkservicestatus;
	}
	public void setSupportNetworkServiceStatus(ims.vo.LookupInstanceBean value)
	{
		this.supportnetworkservicestatus = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAllergyAuthoringInformation()
	{
		return this.allergyauthoringinformation;
	}
	public void setAllergyAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.allergyauthoringinformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAlertAuthoringInformation()
	{
		return this.alertauthoringinformation;
	}
	public void setAlertAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.alertauthoringinformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getSnStatusAuthoringInformation()
	{
		return this.snstatusauthoringinformation;
	}
	public void setSnStatusAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.snstatusauthoringinformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getSnServiceAuthoringInformation()
	{
		return this.snserviceauthoringinformation;
	}
	public void setSnServiceAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.snserviceauthoringinformation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.LookupInstanceBean allergystatus;
	private ims.vo.LookupInstanceBean alertstatus;
	private ims.vo.LookupInstanceBean supportnetworkstatus;
	private ims.vo.LookupInstanceBean supportnetworkservicestatus;
	private ims.core.vo.beans.AuthoringInformationVoBean allergyauthoringinformation;
	private ims.core.vo.beans.AuthoringInformationVoBean alertauthoringinformation;
	private ims.core.vo.beans.AuthoringInformationVoBean snstatusauthoringinformation;
	private ims.core.vo.beans.AuthoringInformationVoBean snserviceauthoringinformation;
}
