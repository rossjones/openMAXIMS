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

package ims.clinical.vo.beans;

public class HospitalAtNightPatientDetailVoBean extends ims.vo.ValueObjectBean
{
	public HospitalAtNightPatientDetailVoBean()
	{
	}
	public HospitalAtNightPatientDetailVoBean(ims.clinical.vo.HospitalAtNightPatientDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.situation = vo.getSituation();
		this.background = vo.getBackground();
		this.assessment = vo.getAssessment();
		this.recommendation = vo.getRecommendation();
		this.mews = vo.getMEWS() == null ? null : (ims.vo.LookupInstanceBean)vo.getMEWS().getBean();
		this.typeofrequest = vo.getTypeOfRequest() == null ? null : (ims.vo.LookupInstanceBean)vo.getTypeOfRequest().getBean();
		this.clinicaltasks = vo.getClinicalTasks() == null ? null : vo.getClinicalTasks().getBeanCollection();
		this.requestingdatetime = vo.getRequestingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequestingDateTime().getBean();
		this.requestinghcp = vo.getRequestingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getRequestingHCP().getBean();
		this.notes = vo.getNotes() == null ? null : vo.getNotes().getBeanCollection();
		this.wardwhenplacedonlist = vo.getWardWhenPlacedOnList() == null ? null : new ims.vo.RefVoBean(vo.getWardWhenPlacedOnList().getBoId(), vo.getWardWhenPlacedOnList().getBoVersion());
		this.hospitalatnightlistanddates = vo.getHospitalAtNightListAndDates() == null ? null : new ims.vo.RefVoBean(vo.getHospitalAtNightListAndDates().getBoId(), vo.getHospitalAtNightListAndDates().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.HospitalAtNightPatientDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.situation = vo.getSituation();
		this.background = vo.getBackground();
		this.assessment = vo.getAssessment();
		this.recommendation = vo.getRecommendation();
		this.mews = vo.getMEWS() == null ? null : (ims.vo.LookupInstanceBean)vo.getMEWS().getBean();
		this.typeofrequest = vo.getTypeOfRequest() == null ? null : (ims.vo.LookupInstanceBean)vo.getTypeOfRequest().getBean();
		this.clinicaltasks = vo.getClinicalTasks() == null ? null : vo.getClinicalTasks().getBeanCollection();
		this.requestingdatetime = vo.getRequestingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequestingDateTime().getBean();
		this.requestinghcp = vo.getRequestingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getRequestingHCP().getBean(map);
		this.notes = vo.getNotes() == null ? null : vo.getNotes().getBeanCollection();
		this.wardwhenplacedonlist = vo.getWardWhenPlacedOnList() == null ? null : new ims.vo.RefVoBean(vo.getWardWhenPlacedOnList().getBoId(), vo.getWardWhenPlacedOnList().getBoVersion());
		this.hospitalatnightlistanddates = vo.getHospitalAtNightListAndDates() == null ? null : new ims.vo.RefVoBean(vo.getHospitalAtNightListAndDates().getBoId(), vo.getHospitalAtNightListAndDates().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
	}

	public ims.clinical.vo.HospitalAtNightPatientDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.HospitalAtNightPatientDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.HospitalAtNightPatientDetailVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.HospitalAtNightPatientDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.HospitalAtNightPatientDetailVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getSituation()
	{
		return this.situation;
	}
	public void setSituation(String value)
	{
		this.situation = value;
	}
	public String getBackground()
	{
		return this.background;
	}
	public void setBackground(String value)
	{
		this.background = value;
	}
	public String getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(String value)
	{
		this.assessment = value;
	}
	public String getRecommendation()
	{
		return this.recommendation;
	}
	public void setRecommendation(String value)
	{
		this.recommendation = value;
	}
	public ims.vo.LookupInstanceBean getMEWS()
	{
		return this.mews;
	}
	public void setMEWS(ims.vo.LookupInstanceBean value)
	{
		this.mews = value;
	}
	public ims.vo.LookupInstanceBean getTypeOfRequest()
	{
		return this.typeofrequest;
	}
	public void setTypeOfRequest(ims.vo.LookupInstanceBean value)
	{
		this.typeofrequest = value;
	}
	public java.util.Collection getClinicalTasks()
	{
		return this.clinicaltasks;
	}
	public void setClinicalTasks(java.util.Collection value)
	{
		this.clinicaltasks = value;
	}
	public void addClinicalTasks(java.util.Collection value)
	{
		if(this.clinicaltasks == null)
			this.clinicaltasks = new java.util.ArrayList();
		this.clinicaltasks.add(value);
	}
	public ims.framework.utils.beans.DateTimeBean getRequestingDateTime()
	{
		return this.requestingdatetime;
	}
	public void setRequestingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.requestingdatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getRequestingHCP()
	{
		return this.requestinghcp;
	}
	public void setRequestingHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.requestinghcp = value;
	}
	public ims.clinical.vo.beans.HospitalAtNightNotesVoBean[] getNotes()
	{
		return this.notes;
	}
	public void setNotes(ims.clinical.vo.beans.HospitalAtNightNotesVoBean[] value)
	{
		this.notes = value;
	}
	public ims.vo.RefVoBean getWardWhenPlacedOnList()
	{
		return this.wardwhenplacedonlist;
	}
	public void setWardWhenPlacedOnList(ims.vo.RefVoBean value)
	{
		this.wardwhenplacedonlist = value;
	}
	public ims.vo.RefVoBean getHospitalAtNightListAndDates()
	{
		return this.hospitalatnightlistanddates;
	}
	public void setHospitalAtNightListAndDates(ims.vo.RefVoBean value)
	{
		this.hospitalatnightlistanddates = value;
	}
	public ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean[] value)
	{
		this.statushistory = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean patient;
	private String situation;
	private String background;
	private String assessment;
	private String recommendation;
	private ims.vo.LookupInstanceBean mews;
	private ims.vo.LookupInstanceBean typeofrequest;
	private java.util.Collection clinicaltasks;
	private ims.framework.utils.beans.DateTimeBean requestingdatetime;
	private ims.core.vo.beans.HcpLiteVoBean requestinghcp;
	private ims.clinical.vo.beans.HospitalAtNightNotesVoBean[] notes;
	private ims.vo.RefVoBean wardwhenplacedonlist;
	private ims.vo.RefVoBean hospitalatnightlistanddates;
	private ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean currentstatus;
	private ims.clinical.vo.beans.HospitalAtNightPatientDetailStatusVoBean[] statushistory;
}
