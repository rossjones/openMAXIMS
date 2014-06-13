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

public class ReferralLetterDetailsLiteVoBean extends ims.vo.ValueObjectBean
{
	public ReferralLetterDetailsLiteVoBean()
	{
	}
	public ReferralLetterDetailsLiteVoBean(ims.careuk.vo.ReferralLetterDetailsLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
		this.alliedhealthprofname = vo.getAlliedHealthProfName();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.transport = vo.getTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransport().getBean();
		this.specialrequirements = vo.getSpecialRequirements();
		this.isdadreferral = vo.getIsDADReferral();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.enddatekpi = vo.getEndDateKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateKPI().getBean();
		this.enddateemailkpi = vo.getEndDateEmailKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateEmailKPI().getBean();
		this.enddatepaperkpi = vo.getEndDatePaperKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDatePaperKPI().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.consultant = vo.getConsultant() == null ? null : new ims.vo.RefVoBean(vo.getConsultant().getBoId(), vo.getConsultant().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ReferralLetterDetailsLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
		this.alliedhealthprofname = vo.getAlliedHealthProfName();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.transport = vo.getTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransport().getBean();
		this.specialrequirements = vo.getSpecialRequirements();
		this.isdadreferral = vo.getIsDADReferral();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.enddatekpi = vo.getEndDateKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateKPI().getBean();
		this.enddateemailkpi = vo.getEndDateEmailKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateEmailKPI().getBean();
		this.enddatepaperkpi = vo.getEndDatePaperKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDatePaperKPI().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.consultant = vo.getConsultant() == null ? null : new ims.vo.RefVoBean(vo.getConsultant().getBoId(), vo.getConsultant().getBoVersion());
	}

	public ims.careuk.vo.ReferralLetterDetailsLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ReferralLetterDetailsLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ReferralLetterDetailsLiteVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ReferralLetterDetailsLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ReferralLetterDetailsLiteVo();
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
	public ims.vo.LookupInstanceBean getTransport()
	{
		return this.transport;
	}
	public void setTransport(ims.vo.LookupInstanceBean value)
	{
		this.transport = value;
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
	public ims.framework.utils.beans.DateBean getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.beans.DateBean value)
	{
		this.end18ww = value;
	}
	public ims.vo.RefVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.vo.RefVoBean value)
	{
		this.consultant = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean referrertype;
	private String alliedhealthprofname;
	private ims.framework.utils.beans.DateBean dateofreferral;
	private ims.framework.utils.beans.DateBean datereferralreceived;
	private ims.vo.LookupInstanceBean transport;
	private String specialrequirements;
	private Boolean isdadreferral;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.framework.utils.beans.DateBean enddatekpi;
	private ims.framework.utils.beans.DateBean enddateemailkpi;
	private ims.framework.utils.beans.DateBean enddatepaperkpi;
	private ims.framework.utils.beans.DateBean end18ww;
	private ims.vo.RefVoBean consultant;
}
