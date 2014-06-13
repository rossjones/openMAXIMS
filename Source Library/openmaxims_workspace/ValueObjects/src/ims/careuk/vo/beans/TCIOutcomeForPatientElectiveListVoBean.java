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

package ims.careuk.vo.beans;

public class TCIOutcomeForPatientElectiveListVoBean extends ims.vo.ValueObjectBean
{
	public TCIOutcomeForPatientElectiveListVoBean()
	{
	}
	public TCIOutcomeForPatientElectiveListVoBean(ims.careuk.vo.TCIOutcomeForPatientElectiveListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.changeby = vo.getChangeBy() == null ? null : new ims.vo.RefVoBean(vo.getChangeBy().getBoId(), vo.getChangeBy().getBoVersion());
		this.statusdatetime = vo.getStatusDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDateTime().getBean();
		this.outcomereason = vo.getOutcomeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeReason().getBean();
		this.cancelledfornonmedicalreason = vo.getCancelledForNonMedicalReason();
		this.canceltheatreappointment = vo.getCancelTheatreAppointment();
		this.tciid = vo.getTciId();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.TCIOutcomeForPatientElectiveListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.changeby = vo.getChangeBy() == null ? null : new ims.vo.RefVoBean(vo.getChangeBy().getBoId(), vo.getChangeBy().getBoVersion());
		this.statusdatetime = vo.getStatusDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDateTime().getBean();
		this.outcomereason = vo.getOutcomeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeReason().getBean();
		this.cancelledfornonmedicalreason = vo.getCancelledForNonMedicalReason();
		this.canceltheatreappointment = vo.getCancelTheatreAppointment();
		this.tciid = vo.getTciId();
	}

	public ims.careuk.vo.TCIOutcomeForPatientElectiveListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.TCIOutcomeForPatientElectiveListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.TCIOutcomeForPatientElectiveListVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.TCIOutcomeForPatientElectiveListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.TCIOutcomeForPatientElectiveListVo();
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
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public ims.vo.RefVoBean getChangeBy()
	{
		return this.changeby;
	}
	public void setChangeBy(ims.vo.RefVoBean value)
	{
		this.changeby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.statusdatetime = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeReason()
	{
		return this.outcomereason;
	}
	public void setOutcomeReason(ims.vo.LookupInstanceBean value)
	{
		this.outcomereason = value;
	}
	public Boolean getCancelledForNonMedicalReason()
	{
		return this.cancelledfornonmedicalreason;
	}
	public void setCancelledForNonMedicalReason(Boolean value)
	{
		this.cancelledfornonmedicalreason = value;
	}
	public Boolean getCancelTheatreAppointment()
	{
		return this.canceltheatreappointment;
	}
	public void setCancelTheatreAppointment(Boolean value)
	{
		this.canceltheatreappointment = value;
	}
	public Integer getTciId()
	{
		return this.tciid;
	}
	public void setTciId(Integer value)
	{
		this.tciid = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean outcome;
	private ims.vo.RefVoBean changeby;
	private ims.framework.utils.beans.DateTimeBean statusdatetime;
	private ims.vo.LookupInstanceBean outcomereason;
	private Boolean cancelledfornonmedicalreason;
	private Boolean canceltheatreappointment;
	private Integer tciid;
}
