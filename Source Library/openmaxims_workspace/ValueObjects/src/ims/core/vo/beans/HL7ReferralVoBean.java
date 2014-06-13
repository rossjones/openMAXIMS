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

public class HL7ReferralVoBean extends ims.vo.ValueObjectBean
{
	public HL7ReferralVoBean()
	{
	}
	public HL7ReferralVoBean(ims.core.vo.HL7ReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.referralreceiveddate = vo.getReferralReceivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralReceivedDate().getBean();
		this.originalreferraldate = vo.getOriginalReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getOriginalReferralDate().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.details = vo.getDetails();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.extreferralkey = vo.getExtReferralKey();
		this.clockid = vo.getClockId();
		this.authoringcp = vo.getAuthoringCP() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringCP().getBoId(), vo.getAuthoringCP().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.isactive = vo.getIsActive();
		this.firstapptdate = vo.getFirstApptDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getFirstApptDate().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.referringgp = vo.getReferringGP() == null ? null : new ims.vo.RefVoBean(vo.getReferringGP().getBoId(), vo.getReferringGP().getBoVersion());
		this.referringclinician = vo.getReferringClinician() == null ? null : new ims.vo.RefVoBean(vo.getReferringClinician().getBoId(), vo.getReferringClinician().getBoVersion());
		this.referralpriority = vo.getReferralPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralPriority().getBean();
		this.referredto = vo.getReferredTo() == null ? null : new ims.vo.RefVoBean(vo.getReferredTo().getBoId(), vo.getReferredTo().getBoVersion());
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.referraldetails = vo.getReferralDetails();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.referrallocation = vo.getReferralLocation();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.HL7ReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.referralreceiveddate = vo.getReferralReceivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralReceivedDate().getBean();
		this.originalreferraldate = vo.getOriginalReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getOriginalReferralDate().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.details = vo.getDetails();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.extreferralkey = vo.getExtReferralKey();
		this.clockid = vo.getClockId();
		this.authoringcp = vo.getAuthoringCP() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringCP().getBoId(), vo.getAuthoringCP().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.isactive = vo.getIsActive();
		this.firstapptdate = vo.getFirstApptDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getFirstApptDate().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.referringgp = vo.getReferringGP() == null ? null : new ims.vo.RefVoBean(vo.getReferringGP().getBoId(), vo.getReferringGP().getBoVersion());
		this.referringclinician = vo.getReferringClinician() == null ? null : new ims.vo.RefVoBean(vo.getReferringClinician().getBoId(), vo.getReferringClinician().getBoVersion());
		this.referralpriority = vo.getReferralPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralPriority().getBean();
		this.referredto = vo.getReferredTo() == null ? null : new ims.vo.RefVoBean(vo.getReferredTo().getBoId(), vo.getReferredTo().getBoVersion());
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.referraldetails = vo.getReferralDetails();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.referrallocation = vo.getReferralLocation();
	}

	public ims.core.vo.HL7ReferralVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.HL7ReferralVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.HL7ReferralVo vo = null;
		if(map != null)
			vo = (ims.core.vo.HL7ReferralVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.HL7ReferralVo();
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
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.framework.utils.beans.DateBean getReferralReceivedDate()
	{
		return this.referralreceiveddate;
	}
	public void setReferralReceivedDate(ims.framework.utils.beans.DateBean value)
	{
		this.referralreceiveddate = value;
	}
	public ims.framework.utils.beans.DateBean getOriginalReferralDate()
	{
		return this.originalreferraldate;
	}
	public void setOriginalReferralDate(ims.framework.utils.beans.DateBean value)
	{
		this.originalreferraldate = value;
	}
	public ims.vo.LookupInstanceBean getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.vo.LookupInstanceBean value)
	{
		this.referraltype = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getExtReferralKey()
	{
		return this.extreferralkey;
	}
	public void setExtReferralKey(String value)
	{
		this.extreferralkey = value;
	}
	public String getClockId()
	{
		return this.clockid;
	}
	public void setClockId(String value)
	{
		this.clockid = value;
	}
	public ims.vo.RefVoBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.vo.RefVoBean value)
	{
		this.authoringcp = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.framework.utils.beans.DateTimeBean getFirstApptDate()
	{
		return this.firstapptdate;
	}
	public void setFirstApptDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.firstapptdate = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public ims.vo.RefVoBean getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.vo.RefVoBean value)
	{
		this.referringgp = value;
	}
	public ims.vo.RefVoBean getReferringClinician()
	{
		return this.referringclinician;
	}
	public void setReferringClinician(ims.vo.RefVoBean value)
	{
		this.referringclinician = value;
	}
	public ims.vo.LookupInstanceBean getReferralPriority()
	{
		return this.referralpriority;
	}
	public void setReferralPriority(ims.vo.LookupInstanceBean value)
	{
		this.referralpriority = value;
	}
	public ims.vo.RefVoBean getReferredTo()
	{
		return this.referredto;
	}
	public void setReferredTo(ims.vo.RefVoBean value)
	{
		this.referredto = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public String getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(String value)
	{
		this.referraldetails = value;
	}
	public ims.framework.utils.beans.DateBean getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.beans.DateBean value)
	{
		this.dateofreferral = value;
	}
	public String getReferralLocation()
	{
		return this.referrallocation;
	}
	public void setReferralLocation(String value)
	{
		this.referrallocation = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.framework.utils.beans.DateBean referralreceiveddate;
	private ims.framework.utils.beans.DateBean originalreferraldate;
	private ims.vo.LookupInstanceBean referraltype;
	private String details;
	private ims.vo.RefVoBean patient;
	private String extreferralkey;
	private String clockid;
	private ims.vo.RefVoBean authoringcp;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
	private Boolean isactive;
	private ims.framework.utils.beans.DateTimeBean firstapptdate;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private ims.vo.RefVoBean referringgp;
	private ims.vo.RefVoBean referringclinician;
	private ims.vo.LookupInstanceBean referralpriority;
	private ims.vo.RefVoBean referredto;
	private ims.vo.LookupInstanceBean specialty;
	private String referraldetails;
	private ims.framework.utils.beans.DateBean dateofreferral;
	private String referrallocation;
}
