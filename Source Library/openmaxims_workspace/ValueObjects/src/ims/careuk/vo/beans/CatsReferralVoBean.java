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

public class CatsReferralVoBean extends ims.vo.ValueObjectBean
{
	public CatsReferralVoBean()
	{
	}
	public CatsReferralVoBean(ims.careuk.vo.CatsReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.icabreferral = vo.getICABReferral() == null ? null : (ims.core.vo.beans.ICABReferralVoBean)vo.getICABReferral().getBean();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.clinical.vo.beans.ReferralLetterDetailsVoBean)vo.getReferralDetails().getBean();
		this.investigationorders = vo.getInvestigationOrders() == null ? null : vo.getInvestigationOrders().getBeanCollection();
		this.appointments = vo.getAppointments() == null ? null : vo.getAppointments().getBeanCollection();
		this.hasdocuments = vo.getHasDocuments();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.careuk.vo.beans.CatsReferralStatusVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.callattempts = vo.getCallAttempts() == null ? null : vo.getCallAttempts().getBeanCollection();
		this.consultationappt = vo.getConsultationAppt() == null ? null : (ims.scheduling.vo.beans.Booking_AppointmentVoBean)vo.getConsultationAppt().getBean();
		this.issuitableforsurgery = vo.getIsSuitableForSurgery();
		this.isfitforsurgery = vo.getIsFitForSurgery();
		this.hastheatreappt = vo.getHasTheatreAppt();
		this.hasdnaapptsforreview = vo.getHasDNAApptsForReview();
		this.hascancelledapptsforreview = vo.getHasCancelledApptsForReview();
		this.isawaitingclinicalinfo = vo.getIsAwaitingClinicalInfo();
		this.hasrejectedinv = vo.getHasRejectedInv();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.CatsReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.icabreferral = vo.getICABReferral() == null ? null : (ims.core.vo.beans.ICABReferralVoBean)vo.getICABReferral().getBean(map);
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.clinical.vo.beans.ReferralLetterDetailsVoBean)vo.getReferralDetails().getBean(map);
		this.investigationorders = vo.getInvestigationOrders() == null ? null : vo.getInvestigationOrders().getBeanCollection();
		this.appointments = vo.getAppointments() == null ? null : vo.getAppointments().getBeanCollection();
		this.hasdocuments = vo.getHasDocuments();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.careuk.vo.beans.CatsReferralStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.callattempts = vo.getCallAttempts() == null ? null : vo.getCallAttempts().getBeanCollection();
		this.consultationappt = vo.getConsultationAppt() == null ? null : (ims.scheduling.vo.beans.Booking_AppointmentVoBean)vo.getConsultationAppt().getBean(map);
		this.issuitableforsurgery = vo.getIsSuitableForSurgery();
		this.isfitforsurgery = vo.getIsFitForSurgery();
		this.hastheatreappt = vo.getHasTheatreAppt();
		this.hasdnaapptsforreview = vo.getHasDNAApptsForReview();
		this.hascancelledapptsforreview = vo.getHasCancelledApptsForReview();
		this.isawaitingclinicalinfo = vo.getIsAwaitingClinicalInfo();
		this.hasrejectedinv = vo.getHasRejectedInv();
	}

	public ims.careuk.vo.CatsReferralVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.CatsReferralVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.CatsReferralVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.CatsReferralVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.CatsReferralVo();
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
	public ims.core.vo.beans.ICABReferralVoBean getICABReferral()
	{
		return this.icabreferral;
	}
	public void setICABReferral(ims.core.vo.beans.ICABReferralVoBean value)
	{
		this.icabreferral = value;
	}
	public ims.clinical.vo.beans.ReferralLetterDetailsVoBean getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.clinical.vo.beans.ReferralLetterDetailsVoBean value)
	{
		this.referraldetails = value;
	}
	public ims.ocrr.vo.beans.OcsOrderVoBean[] getInvestigationOrders()
	{
		return this.investigationorders;
	}
	public void setInvestigationOrders(ims.ocrr.vo.beans.OcsOrderVoBean[] value)
	{
		this.investigationorders = value;
	}
	public ims.scheduling.vo.beans.Booking_AppointmentVoBean[] getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.scheduling.vo.beans.Booking_AppointmentVoBean[] value)
	{
		this.appointments = value;
	}
	public Boolean getHasDocuments()
	{
		return this.hasdocuments;
	}
	public void setHasDocuments(Boolean value)
	{
		this.hasdocuments = value;
	}
	public ims.careuk.vo.beans.CatsReferralStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.careuk.vo.beans.CatsReferralStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.careuk.vo.beans.CatsReferralStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.careuk.vo.beans.CatsReferralStatusVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.careuk.vo.beans.AppointmentCallAttemptsVoBean[] getCallAttempts()
	{
		return this.callattempts;
	}
	public void setCallAttempts(ims.careuk.vo.beans.AppointmentCallAttemptsVoBean[] value)
	{
		this.callattempts = value;
	}
	public ims.scheduling.vo.beans.Booking_AppointmentVoBean getConsultationAppt()
	{
		return this.consultationappt;
	}
	public void setConsultationAppt(ims.scheduling.vo.beans.Booking_AppointmentVoBean value)
	{
		this.consultationappt = value;
	}
	public Boolean getIsSuitableForSurgery()
	{
		return this.issuitableforsurgery;
	}
	public void setIsSuitableForSurgery(Boolean value)
	{
		this.issuitableforsurgery = value;
	}
	public Boolean getIsFitForSurgery()
	{
		return this.isfitforsurgery;
	}
	public void setIsFitForSurgery(Boolean value)
	{
		this.isfitforsurgery = value;
	}
	public Boolean getHasTheatreAppt()
	{
		return this.hastheatreappt;
	}
	public void setHasTheatreAppt(Boolean value)
	{
		this.hastheatreappt = value;
	}
	public Boolean getHasDNAApptsForReview()
	{
		return this.hasdnaapptsforreview;
	}
	public void setHasDNAApptsForReview(Boolean value)
	{
		this.hasdnaapptsforreview = value;
	}
	public Boolean getHasCancelledApptsForReview()
	{
		return this.hascancelledapptsforreview;
	}
	public void setHasCancelledApptsForReview(Boolean value)
	{
		this.hascancelledapptsforreview = value;
	}
	public Boolean getIsAwaitingClinicalInfo()
	{
		return this.isawaitingclinicalinfo;
	}
	public void setIsAwaitingClinicalInfo(Boolean value)
	{
		this.isawaitingclinicalinfo = value;
	}
	public Boolean getHasRejectedInv()
	{
		return this.hasrejectedinv;
	}
	public void setHasRejectedInv(Boolean value)
	{
		this.hasrejectedinv = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.ICABReferralVoBean icabreferral;
	private ims.clinical.vo.beans.ReferralLetterDetailsVoBean referraldetails;
	private ims.ocrr.vo.beans.OcsOrderVoBean[] investigationorders;
	private ims.scheduling.vo.beans.Booking_AppointmentVoBean[] appointments;
	private Boolean hasdocuments;
	private ims.careuk.vo.beans.CatsReferralStatusVoBean currentstatus;
	private ims.careuk.vo.beans.CatsReferralStatusVoBean[] statushistory;
	private ims.careuk.vo.beans.AppointmentCallAttemptsVoBean[] callattempts;
	private ims.scheduling.vo.beans.Booking_AppointmentVoBean consultationappt;
	private Boolean issuitableforsurgery;
	private Boolean isfitforsurgery;
	private Boolean hastheatreappt;
	private Boolean hasdnaapptsforreview;
	private Boolean hascancelledapptsforreview;
	private Boolean isawaitingclinicalinfo;
	private Boolean hasrejectedinv;
}
