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

public class InvestigationVoBean extends ims.vo.ValueObjectBean
{
	public InvestigationVoBean()
	{
	}
	public InvestigationVoBean(ims.ocrr.vo.InvestigationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocrr.vo.beans.InvestigationIndexVoBean)vo.getInvestigationIndex().getBean();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.providerinvcode = vo.getProviderInvCode();
		this.pathinvdetails = vo.getPathInvDetails() == null ? null : (ims.ocrr.vo.beans.PathInvDetailsVoBean)vo.getPathInvDetails().getBean();
		this.clinimaginvdetails = vo.getClinImagInvDetails() == null ? null : (ims.ocrr.vo.beans.ClinImagInvDetailsVoBean)vo.getClinImagInvDetails().getBean();
		this.assocquestions = vo.getAssocQuestions() == null ? null : vo.getAssocQuestions().getBeanCollection();
		this.helptext = vo.getHelpText() == null ? null : vo.getHelpText().getBeanCollection();
		this.providerservice = vo.getProviderService() == null ? null : (ims.ocrr.vo.beans.LocSvcProviderSysVoBean)vo.getProviderService().getBean();
		this.associnvestigations = vo.getAssocInvestigations() == null ? null : vo.getAssocInvestigations().getBeanCollection();
		this.separateorder = vo.getSeparateOrder();
		this.isaddon = vo.getIsAddon();
		this.minreorderperiodval = vo.getMinReorderPeriodVal();
		this.minreorderperiodunit = vo.getMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getMinReorderPeriodUnit().getBean();
		this.femaleminreorderperiodval = vo.getFemaleMinReorderPeriodVal();
		this.femaleminreorderperiodunit = vo.getFemaleMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getFemaleMinReorderPeriodUnit().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.nolabelsets = vo.getNoLabelSets();
		this.turnaroundmeasure = vo.getTurnaroundMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getTurnaroundMeasure().getBean();
		this.expectedturnaround = vo.getExpectedTurnaround();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.InvestigationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocrr.vo.beans.InvestigationIndexVoBean)vo.getInvestigationIndex().getBean(map);
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.providerinvcode = vo.getProviderInvCode();
		this.pathinvdetails = vo.getPathInvDetails() == null ? null : (ims.ocrr.vo.beans.PathInvDetailsVoBean)vo.getPathInvDetails().getBean(map);
		this.clinimaginvdetails = vo.getClinImagInvDetails() == null ? null : (ims.ocrr.vo.beans.ClinImagInvDetailsVoBean)vo.getClinImagInvDetails().getBean(map);
		this.assocquestions = vo.getAssocQuestions() == null ? null : vo.getAssocQuestions().getBeanCollection();
		this.helptext = vo.getHelpText() == null ? null : vo.getHelpText().getBeanCollection();
		this.providerservice = vo.getProviderService() == null ? null : (ims.ocrr.vo.beans.LocSvcProviderSysVoBean)vo.getProviderService().getBean(map);
		this.associnvestigations = vo.getAssocInvestigations() == null ? null : vo.getAssocInvestigations().getBeanCollection();
		this.separateorder = vo.getSeparateOrder();
		this.isaddon = vo.getIsAddon();
		this.minreorderperiodval = vo.getMinReorderPeriodVal();
		this.minreorderperiodunit = vo.getMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getMinReorderPeriodUnit().getBean();
		this.femaleminreorderperiodval = vo.getFemaleMinReorderPeriodVal();
		this.femaleminreorderperiodunit = vo.getFemaleMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getFemaleMinReorderPeriodUnit().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.nolabelsets = vo.getNoLabelSets();
		this.turnaroundmeasure = vo.getTurnaroundMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getTurnaroundMeasure().getBean();
		this.expectedturnaround = vo.getExpectedTurnaround();
	}

	public ims.ocrr.vo.InvestigationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.InvestigationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.InvestigationVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.InvestigationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.InvestigationVo();
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
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public ims.ocrr.vo.beans.InvestigationIndexVoBean getInvestigationIndex()
	{
		return this.investigationindex;
	}
	public void setInvestigationIndex(ims.ocrr.vo.beans.InvestigationIndexVoBean value)
	{
		this.investigationindex = value;
	}
	public ims.framework.utils.beans.ColorBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.beans.ColorBean value)
	{
		this.colour = value;
	}
	public String getProviderInvCode()
	{
		return this.providerinvcode;
	}
	public void setProviderInvCode(String value)
	{
		this.providerinvcode = value;
	}
	public ims.ocrr.vo.beans.PathInvDetailsVoBean getPathInvDetails()
	{
		return this.pathinvdetails;
	}
	public void setPathInvDetails(ims.ocrr.vo.beans.PathInvDetailsVoBean value)
	{
		this.pathinvdetails = value;
	}
	public ims.ocrr.vo.beans.ClinImagInvDetailsVoBean getClinImagInvDetails()
	{
		return this.clinimaginvdetails;
	}
	public void setClinImagInvDetails(ims.ocrr.vo.beans.ClinImagInvDetailsVoBean value)
	{
		this.clinimaginvdetails = value;
	}
	public ims.ocrr.vo.beans.InvestigationQuestionVoBean[] getAssocQuestions()
	{
		return this.assocquestions;
	}
	public void setAssocQuestions(ims.ocrr.vo.beans.InvestigationQuestionVoBean[] value)
	{
		this.assocquestions = value;
	}
	public ims.ocrr.vo.beans.HelpTextVoBean[] getHelpText()
	{
		return this.helptext;
	}
	public void setHelpText(ims.ocrr.vo.beans.HelpTextVoBean[] value)
	{
		this.helptext = value;
	}
	public ims.ocrr.vo.beans.LocSvcProviderSysVoBean getProviderService()
	{
		return this.providerservice;
	}
	public void setProviderService(ims.ocrr.vo.beans.LocSvcProviderSysVoBean value)
	{
		this.providerservice = value;
	}
	public ims.ocrr.vo.beans.InvestShortVoBean[] getAssocInvestigations()
	{
		return this.associnvestigations;
	}
	public void setAssocInvestigations(ims.ocrr.vo.beans.InvestShortVoBean[] value)
	{
		this.associnvestigations = value;
	}
	public Boolean getSeparateOrder()
	{
		return this.separateorder;
	}
	public void setSeparateOrder(Boolean value)
	{
		this.separateorder = value;
	}
	public Boolean getIsAddon()
	{
		return this.isaddon;
	}
	public void setIsAddon(Boolean value)
	{
		this.isaddon = value;
	}
	public Integer getMinReorderPeriodVal()
	{
		return this.minreorderperiodval;
	}
	public void setMinReorderPeriodVal(Integer value)
	{
		this.minreorderperiodval = value;
	}
	public ims.vo.LookupInstanceBean getMinReorderPeriodUnit()
	{
		return this.minreorderperiodunit;
	}
	public void setMinReorderPeriodUnit(ims.vo.LookupInstanceBean value)
	{
		this.minreorderperiodunit = value;
	}
	public Integer getFemaleMinReorderPeriodVal()
	{
		return this.femaleminreorderperiodval;
	}
	public void setFemaleMinReorderPeriodVal(Integer value)
	{
		this.femaleminreorderperiodval = value;
	}
	public ims.vo.LookupInstanceBean getFemaleMinReorderPeriodUnit()
	{
		return this.femaleminreorderperiodunit;
	}
	public void setFemaleMinReorderPeriodUnit(ims.vo.LookupInstanceBean value)
	{
		this.femaleminreorderperiodunit = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public Integer getNoLabelSets()
	{
		return this.nolabelsets;
	}
	public void setNoLabelSets(Integer value)
	{
		this.nolabelsets = value;
	}
	public ims.vo.LookupInstanceBean getTurnaroundMeasure()
	{
		return this.turnaroundmeasure;
	}
	public void setTurnaroundMeasure(ims.vo.LookupInstanceBean value)
	{
		this.turnaroundmeasure = value;
	}
	public Integer getExpectedTurnaround()
	{
		return this.expectedturnaround;
	}
	public void setExpectedTurnaround(Integer value)
	{
		this.expectedturnaround = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean activestatus;
	private ims.ocrr.vo.beans.InvestigationIndexVoBean investigationindex;
	private ims.framework.utils.beans.ColorBean colour;
	private String providerinvcode;
	private ims.ocrr.vo.beans.PathInvDetailsVoBean pathinvdetails;
	private ims.ocrr.vo.beans.ClinImagInvDetailsVoBean clinimaginvdetails;
	private ims.ocrr.vo.beans.InvestigationQuestionVoBean[] assocquestions;
	private ims.ocrr.vo.beans.HelpTextVoBean[] helptext;
	private ims.ocrr.vo.beans.LocSvcProviderSysVoBean providerservice;
	private ims.ocrr.vo.beans.InvestShortVoBean[] associnvestigations;
	private Boolean separateorder;
	private Boolean isaddon;
	private Integer minreorderperiodval;
	private ims.vo.LookupInstanceBean minreorderperiodunit;
	private Integer femaleminreorderperiodval;
	private ims.vo.LookupInstanceBean femaleminreorderperiodunit;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.LookupInstanceBean type;
	private ims.vo.LookupInstanceBean eventtype;
	private Integer nolabelsets;
	private ims.vo.LookupInstanceBean turnaroundmeasure;
	private Integer expectedturnaround;
}
