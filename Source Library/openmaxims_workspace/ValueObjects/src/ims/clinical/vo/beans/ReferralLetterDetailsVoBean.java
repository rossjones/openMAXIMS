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

public class ReferralLetterDetailsVoBean extends ims.vo.ValueObjectBean
{
	public ReferralLetterDetailsVoBean()
	{
	}
	public ReferralLetterDetailsVoBean(ims.clinical.vo.ReferralLetterDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
		this.gpname = vo.getGPName() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getGPName().getBean();
		this.alliedhealthprofname = vo.getAlliedHealthProfName();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.interpreterrequired = vo.getInterpreterRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getInterpreterRequired().getBean();
		this.language = vo.getLanguage() == null ? null : (ims.vo.LookupInstanceBean)vo.getLanguage().getBean();
		this.transportrequired = vo.getTransportRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransportRequired().getBean();
		this.transport = vo.getTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransport().getBean();
		this.authoringuser = vo.getAuthoringUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringUser().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.copydischargetopatient = vo.getCopyDischargeToPatient();
		this.pct = vo.getPCT();
		this.function = vo.getFunction() == null ? null : (ims.core.vo.beans.ServiceFunctionLiteVoBean)vo.getFunction().getBean();
		this.otherlanguage = vo.getOtherLanguage();
		this.specialrequirements = vo.getSpecialRequirements();
		this.isdadreferral = vo.getIsDADReferral();
		this.dadubrn = vo.getDadUbrn();
		this.practice = vo.getPractice() == null ? null : (ims.core.vo.beans.OrganisationWithSitesVoBean)vo.getPractice().getBean();
		this.isreferrerpatientsgp = vo.getIsReferrerPatientsGp();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.enddatekpi = vo.getEndDateKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateKPI().getBean();
		this.enddateemailkpi = vo.getEndDateEmailKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateEmailKPI().getBean();
		this.enddatepaperkpi = vo.getEndDatePaperKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDatePaperKPI().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.core.vo.beans.EpisodeofCareShortVoBean)vo.getEpisodeOfCare().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConsultant().getBean();
		this.transportrequirements = vo.getTransportRequirements() == null ? null : (ims.core.vo.beans.PatientTransportRequirementsVoBean)vo.getTransportRequirements().getBean();
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.HcpBean)vo.getReferringConsultant().getBean();
		this.originaldateofreferral = vo.getOriginalDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getOriginalDateOfReferral().getBean();
		this.refereraddress = vo.getRefererAddress();
		this.transferedby = vo.getTransferedBY();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.ReferralLetterDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
		this.gpname = vo.getGPName() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getGPName().getBean(map);
		this.alliedhealthprofname = vo.getAlliedHealthProfName();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.interpreterrequired = vo.getInterpreterRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getInterpreterRequired().getBean();
		this.language = vo.getLanguage() == null ? null : (ims.vo.LookupInstanceBean)vo.getLanguage().getBean();
		this.transportrequired = vo.getTransportRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransportRequired().getBean();
		this.transport = vo.getTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransport().getBean();
		this.authoringuser = vo.getAuthoringUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringUser().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.copydischargetopatient = vo.getCopyDischargeToPatient();
		this.pct = vo.getPCT();
		this.function = vo.getFunction() == null ? null : (ims.core.vo.beans.ServiceFunctionLiteVoBean)vo.getFunction().getBean(map);
		this.otherlanguage = vo.getOtherLanguage();
		this.specialrequirements = vo.getSpecialRequirements();
		this.isdadreferral = vo.getIsDADReferral();
		this.dadubrn = vo.getDadUbrn();
		this.practice = vo.getPractice() == null ? null : (ims.core.vo.beans.OrganisationWithSitesVoBean)vo.getPractice().getBean(map);
		this.isreferrerpatientsgp = vo.getIsReferrerPatientsGp();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.enddatekpi = vo.getEndDateKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateKPI().getBean();
		this.enddateemailkpi = vo.getEndDateEmailKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateEmailKPI().getBean();
		this.enddatepaperkpi = vo.getEndDatePaperKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDatePaperKPI().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.core.vo.beans.EpisodeofCareShortVoBean)vo.getEpisodeOfCare().getBean(map);
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConsultant().getBean(map);
		this.transportrequirements = vo.getTransportRequirements() == null ? null : (ims.core.vo.beans.PatientTransportRequirementsVoBean)vo.getTransportRequirements().getBean(map);
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.HcpBean)vo.getReferringConsultant().getBean(map);
		this.originaldateofreferral = vo.getOriginalDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getOriginalDateOfReferral().getBean();
		this.refereraddress = vo.getRefererAddress();
		this.transferedby = vo.getTransferedBY();
	}

	public ims.clinical.vo.ReferralLetterDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.ReferralLetterDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.ReferralLetterDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.ReferralLetterDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.ReferralLetterDetailsVo();
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
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getReferrerType()
	{
		return this.referrertype;
	}
	public void setReferrerType(ims.vo.LookupInstanceBean value)
	{
		this.referrertype = value;
	}
	public ims.core.vo.beans.GpLiteVoBean getGPName()
	{
		return this.gpname;
	}
	public void setGPName(ims.core.vo.beans.GpLiteVoBean value)
	{
		this.gpname = value;
	}
	public String getAlliedHealthProfName()
	{
		return this.alliedhealthprofname;
	}
	public void setAlliedHealthProfName(String value)
	{
		this.alliedhealthprofname = value;
	}
	public ims.framework.utils.beans.DateBean getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.beans.DateBean value)
	{
		this.dateofreferral = value;
	}
	public ims.framework.utils.beans.DateBean getDateReferralReceived()
	{
		return this.datereferralreceived;
	}
	public void setDateReferralReceived(ims.framework.utils.beans.DateBean value)
	{
		this.datereferralreceived = value;
	}
	public ims.framework.utils.beans.DateBean getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.beans.DateBean value)
	{
		this.end18ww = value;
	}
	public ims.vo.LookupInstanceBean getInterpreterRequired()
	{
		return this.interpreterrequired;
	}
	public void setInterpreterRequired(ims.vo.LookupInstanceBean value)
	{
		this.interpreterrequired = value;
	}
	public ims.vo.LookupInstanceBean getLanguage()
	{
		return this.language;
	}
	public void setLanguage(ims.vo.LookupInstanceBean value)
	{
		this.language = value;
	}
	public ims.vo.LookupInstanceBean getTransportRequired()
	{
		return this.transportrequired;
	}
	public void setTransportRequired(ims.vo.LookupInstanceBean value)
	{
		this.transportrequired = value;
	}
	public ims.vo.LookupInstanceBean getTransport()
	{
		return this.transport;
	}
	public void setTransport(ims.vo.LookupInstanceBean value)
	{
		this.transport = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.authoringuser = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public Boolean getCopyDischargeToPatient()
	{
		return this.copydischargetopatient;
	}
	public void setCopyDischargeToPatient(Boolean value)
	{
		this.copydischargetopatient = value;
	}
	public String getPCT()
	{
		return this.pct;
	}
	public void setPCT(String value)
	{
		this.pct = value;
	}
	public ims.core.vo.beans.ServiceFunctionLiteVoBean getFunction()
	{
		return this.function;
	}
	public void setFunction(ims.core.vo.beans.ServiceFunctionLiteVoBean value)
	{
		this.function = value;
	}
	public String getOtherLanguage()
	{
		return this.otherlanguage;
	}
	public void setOtherLanguage(String value)
	{
		this.otherlanguage = value;
	}
	public String getSpecialRequirements()
	{
		return this.specialrequirements;
	}
	public void setSpecialRequirements(String value)
	{
		this.specialrequirements = value;
	}
	public Boolean getIsDADReferral()
	{
		return this.isdadreferral;
	}
	public void setIsDADReferral(Boolean value)
	{
		this.isdadreferral = value;
	}
	public String getDadUbrn()
	{
		return this.dadubrn;
	}
	public void setDadUbrn(String value)
	{
		this.dadubrn = value;
	}
	public ims.core.vo.beans.OrganisationWithSitesVoBean getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.core.vo.beans.OrganisationWithSitesVoBean value)
	{
		this.practice = value;
	}
	public Boolean getIsReferrerPatientsGp()
	{
		return this.isreferrerpatientsgp;
	}
	public void setIsReferrerPatientsGp(Boolean value)
	{
		this.isreferrerpatientsgp = value;
	}
	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.framework.utils.beans.DateBean getEndDateKPI()
	{
		return this.enddatekpi;
	}
	public void setEndDateKPI(ims.framework.utils.beans.DateBean value)
	{
		this.enddatekpi = value;
	}
	public ims.framework.utils.beans.DateBean getEndDateEmailKPI()
	{
		return this.enddateemailkpi;
	}
	public void setEndDateEmailKPI(ims.framework.utils.beans.DateBean value)
	{
		this.enddateemailkpi = value;
	}
	public ims.framework.utils.beans.DateBean getEndDatePaperKPI()
	{
		return this.enddatepaperkpi;
	}
	public void setEndDatePaperKPI(ims.framework.utils.beans.DateBean value)
	{
		this.enddatepaperkpi = value;
	}
	public ims.core.vo.beans.EpisodeofCareShortVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.beans.EpisodeofCareShortVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.consultant = value;
	}
	public ims.core.vo.beans.PatientTransportRequirementsVoBean getTransportRequirements()
	{
		return this.transportrequirements;
	}
	public void setTransportRequirements(ims.core.vo.beans.PatientTransportRequirementsVoBean value)
	{
		this.transportrequirements = value;
	}
	public ims.core.vo.beans.HcpBean getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.vo.beans.HcpBean value)
	{
		this.referringconsultant = value;
	}
	public ims.framework.utils.beans.DateBean getOriginalDateOfReferral()
	{
		return this.originaldateofreferral;
	}
	public void setOriginalDateOfReferral(ims.framework.utils.beans.DateBean value)
	{
		this.originaldateofreferral = value;
	}
	public String getRefererAddress()
	{
		return this.refereraddress;
	}
	public void setRefererAddress(String value)
	{
		this.refereraddress = value;
	}
	public String getTransferedBY()
	{
		return this.transferedby;
	}
	public void setTransferedBY(String value)
	{
		this.transferedby = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean referrertype;
	private ims.core.vo.beans.GpLiteVoBean gpname;
	private String alliedhealthprofname;
	private ims.framework.utils.beans.DateBean dateofreferral;
	private ims.framework.utils.beans.DateBean datereferralreceived;
	private ims.framework.utils.beans.DateBean end18ww;
	private ims.vo.LookupInstanceBean interpreterrequired;
	private ims.vo.LookupInstanceBean language;
	private ims.vo.LookupInstanceBean transportrequired;
	private ims.vo.LookupInstanceBean transport;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean authoringuser;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private Boolean copydischargetopatient;
	private String pct;
	private ims.core.vo.beans.ServiceFunctionLiteVoBean function;
	private String otherlanguage;
	private String specialrequirements;
	private Boolean isdadreferral;
	private String dadubrn;
	private ims.core.vo.beans.OrganisationWithSitesVoBean practice;
	private Boolean isreferrerpatientsgp;
	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.framework.utils.beans.DateBean enddatekpi;
	private ims.framework.utils.beans.DateBean enddateemailkpi;
	private ims.framework.utils.beans.DateBean enddatepaperkpi;
	private ims.core.vo.beans.EpisodeofCareShortVoBean episodeofcare;
	private ims.core.vo.beans.HcpLiteVoBean consultant;
	private ims.core.vo.beans.PatientTransportRequirementsVoBean transportrequirements;
	private ims.core.vo.beans.HcpBean referringconsultant;
	private ims.framework.utils.beans.DateBean originaldateofreferral;
	private String refereraddress;
	private String transferedby;
}
