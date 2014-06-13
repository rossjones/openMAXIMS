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

public class PatientAlertBean extends ims.vo.ValueObjectBean
{
	public PatientAlertBean()
	{
	}
	public PatientAlertBean(ims.core.vo.PatientAlert vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.alerttype = vo.getAlertType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlertType().getBean();
		this.iscurrentlyactivealert = vo.getIsCurrentlyActiveAlert();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.comments = vo.getComments();
		this.dateidentified = vo.getDateIdentified() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDateIdentified().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.inactivationcomments = vo.getInactivationComments();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.inactivationauthoringinfo = vo.getInactivationAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getInactivationAuthoringInfo().getBean();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientAlert vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.alerttype = vo.getAlertType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlertType().getBean();
		this.iscurrentlyactivealert = vo.getIsCurrentlyActiveAlert();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.comments = vo.getComments();
		this.dateidentified = vo.getDateIdentified() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDateIdentified().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.inactivationcomments = vo.getInactivationComments();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.inactivationauthoringinfo = vo.getInactivationAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getInactivationAuthoringInfo().getBean(map);
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean(map);
	}

	public ims.core.vo.PatientAlert buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientAlert buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientAlert vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientAlert)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientAlert();
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
	public ims.vo.LookupInstanceBean getAlertType()
	{
		return this.alerttype;
	}
	public void setAlertType(ims.vo.LookupInstanceBean value)
	{
		this.alerttype = value;
	}
	public Boolean getIsCurrentlyActiveAlert()
	{
		return this.iscurrentlyactivealert;
	}
	public void setIsCurrentlyActiveAlert(Boolean value)
	{
		this.iscurrentlyactivealert = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDateIdentified()
	{
		return this.dateidentified;
	}
	public void setDateIdentified(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dateidentified = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public String getInactivationComments()
	{
		return this.inactivationcomments;
	}
	public void setInactivationComments(String value)
	{
		this.inactivationcomments = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getInactivationAuthoringInfo()
	{
		return this.inactivationauthoringinfo;
	}
	public void setInactivationAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.inactivationauthoringinfo = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.recordinginformation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean alerttype;
	private Boolean iscurrentlyactivealert;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private ims.vo.RefVoBean patient;
	private String comments;
	private ims.framework.utils.beans.PartialDateBean dateidentified;
	private ims.vo.SysInfoBean sysinfo;
	private String inactivationcomments;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.AuthoringInformationVoBean inactivationauthoringinfo;
	private ims.core.vo.beans.RecordingUserInformationVoBean recordinginformation;
}
