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

public class DementiaVoBean extends ims.vo.ValueObjectBean
{
	public DementiaVoBean()
	{
	}
	public DementiaVoBean(ims.clinical.vo.DementiaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.breachdatetime = vo.getBreachDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBreachDateTime().getBean();
		this.ageonadmission = vo.getAgeOnAdmission();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.currentworkliststatus = vo.getCurrentWorklistStatus() == null ? null : (ims.clinical.vo.beans.DementiaWorklistStatusVoBean)vo.getCurrentWorklistStatus().getBean();
		this.historicalworkliststatus = vo.getHistoricalWorklistStatus() == null ? null : vo.getHistoricalWorklistStatus().getBeanCollection();
		this.dementiaconfirmed = vo.getDementiaConfirmed();
		this.deliriumconfirmed = vo.getDeliriumConfirmed();
		this.amtsscore = vo.getAMTSScore();
		this.steponefind = vo.getStepOneFind() == null ? null : (ims.clinical.vo.beans.DementiaFindVoBean)vo.getStepOneFind().getBean();
		this.steptwoassess = vo.getStepTwoAssess() == null ? null : (ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean)vo.getStepTwoAssess().getBean();
		this.confirmedpatientputondementiapathway = vo.getConfirmedPatientPutOnDementiaPathway();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionDetail().getBoId(), vo.getAdmissionDetail().getBoVersion());
		this.isexcludedfromworklist = vo.getIsExcludedFromWorklist();
		this.followupassessments = vo.getFollowUpAssessments() == null ? null : vo.getFollowUpAssessments().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.DementiaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.breachdatetime = vo.getBreachDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBreachDateTime().getBean();
		this.ageonadmission = vo.getAgeOnAdmission();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.currentworkliststatus = vo.getCurrentWorklistStatus() == null ? null : (ims.clinical.vo.beans.DementiaWorklistStatusVoBean)vo.getCurrentWorklistStatus().getBean(map);
		this.historicalworkliststatus = vo.getHistoricalWorklistStatus() == null ? null : vo.getHistoricalWorklistStatus().getBeanCollection();
		this.dementiaconfirmed = vo.getDementiaConfirmed();
		this.deliriumconfirmed = vo.getDeliriumConfirmed();
		this.amtsscore = vo.getAMTSScore();
		this.steponefind = vo.getStepOneFind() == null ? null : (ims.clinical.vo.beans.DementiaFindVoBean)vo.getStepOneFind().getBean(map);
		this.steptwoassess = vo.getStepTwoAssess() == null ? null : (ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean)vo.getStepTwoAssess().getBean(map);
		this.confirmedpatientputondementiapathway = vo.getConfirmedPatientPutOnDementiaPathway();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionDetail().getBoId(), vo.getAdmissionDetail().getBoVersion());
		this.isexcludedfromworklist = vo.getIsExcludedFromWorklist();
		this.followupassessments = vo.getFollowUpAssessments() == null ? null : vo.getFollowUpAssessments().getBeanCollection();
	}

	public ims.clinical.vo.DementiaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.DementiaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.DementiaVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.DementiaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.DementiaVo();
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
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getBreachDateTime()
	{
		return this.breachdatetime;
	}
	public void setBreachDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.breachdatetime = value;
	}
	public Integer getAgeOnAdmission()
	{
		return this.ageonadmission;
	}
	public void setAgeOnAdmission(Integer value)
	{
		this.ageonadmission = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
	}
	public ims.clinical.vo.beans.DementiaWorklistStatusVoBean getCurrentWorklistStatus()
	{
		return this.currentworkliststatus;
	}
	public void setCurrentWorklistStatus(ims.clinical.vo.beans.DementiaWorklistStatusVoBean value)
	{
		this.currentworkliststatus = value;
	}
	public ims.clinical.vo.beans.DementiaWorklistStatusVoBean[] getHistoricalWorklistStatus()
	{
		return this.historicalworkliststatus;
	}
	public void setHistoricalWorklistStatus(ims.clinical.vo.beans.DementiaWorklistStatusVoBean[] value)
	{
		this.historicalworkliststatus = value;
	}
	public Boolean getDementiaConfirmed()
	{
		return this.dementiaconfirmed;
	}
	public void setDementiaConfirmed(Boolean value)
	{
		this.dementiaconfirmed = value;
	}
	public Boolean getDeliriumConfirmed()
	{
		return this.deliriumconfirmed;
	}
	public void setDeliriumConfirmed(Boolean value)
	{
		this.deliriumconfirmed = value;
	}
	public Integer getAMTSScore()
	{
		return this.amtsscore;
	}
	public void setAMTSScore(Integer value)
	{
		this.amtsscore = value;
	}
	public ims.clinical.vo.beans.DementiaFindVoBean getStepOneFind()
	{
		return this.steponefind;
	}
	public void setStepOneFind(ims.clinical.vo.beans.DementiaFindVoBean value)
	{
		this.steponefind = value;
	}
	public ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean getStepTwoAssess()
	{
		return this.steptwoassess;
	}
	public void setStepTwoAssess(ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean value)
	{
		this.steptwoassess = value;
	}
	public Boolean getConfirmedPatientPutOnDementiaPathway()
	{
		return this.confirmedpatientputondementiapathway;
	}
	public void setConfirmedPatientPutOnDementiaPathway(Boolean value)
	{
		this.confirmedpatientputondementiapathway = value;
	}
	public ims.vo.RefVoBean getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.vo.RefVoBean value)
	{
		this.admissiondetail = value;
	}
	public Boolean getIsExcludedFromWorklist()
	{
		return this.isexcludedfromworklist;
	}
	public void setIsExcludedFromWorklist(Boolean value)
	{
		this.isexcludedfromworklist = value;
	}
	public ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean[] getFollowUpAssessments()
	{
		return this.followupassessments;
	}
	public void setFollowUpAssessments(ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean[] value)
	{
		this.followupassessments = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.framework.utils.beans.DateTimeBean breachdatetime;
	private Integer ageonadmission;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private ims.clinical.vo.beans.DementiaWorklistStatusVoBean currentworkliststatus;
	private ims.clinical.vo.beans.DementiaWorklistStatusVoBean[] historicalworkliststatus;
	private Boolean dementiaconfirmed;
	private Boolean deliriumconfirmed;
	private Integer amtsscore;
	private ims.clinical.vo.beans.DementiaFindVoBean steponefind;
	private ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean steptwoassess;
	private Boolean confirmedpatientputondementiapathway;
	private ims.vo.RefVoBean admissiondetail;
	private Boolean isexcludedfromworklist;
	private ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean[] followupassessments;
}
