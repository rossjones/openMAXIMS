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

package ims.emergency.vo.beans;

public class TrackingAttendanceWorklist_SearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public TrackingAttendanceWorklist_SearchCriteriaVoBean()
	{
	}
	public TrackingAttendanceWorklist_SearchCriteriaVoBean(ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo vo)
	{
		this.medic = vo.getMedic() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getMedic().getBean();
		this.nurse = vo.getNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getNurse().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.teamspecialty = vo.getTeamSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getTeamSpecialty().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.breachedprioritykpi = vo.getBreachedPriorityKPI();
		this.patientsurname = vo.getPatientSurname();
		this.addresscontains = vo.getAddressContains();
		this.attendancefrom = vo.getAttendanceFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAttendanceFrom().getBean();
		this.attendanceto = vo.getAttendanceTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAttendanceTo().getBean();
		this.triagefrom = vo.getTriageFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTriageFrom().getBean();
		this.triageto = vo.getTriageTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTriageTo().getBean();
		this.dischargefrom = vo.getDischargeFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeFrom().getBean();
		this.dischargeto = vo.getDischargeTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeTo().getBean();
		this.edstatus = vo.getEDStatus();
		this.bedallocation = vo.getBedAllocation();
		this.awaitingreview = vo.getAwaitingReview();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.attendanceid = vo.getAttendanceID();
		this.presentingproblem = vo.getPresentingProblem() == null ? null : (ims.vo.LookupInstanceBean)vo.getPresentingProblem().getBean();
		this.attendancenotcoded = vo.getAttendanceNotCoded();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo vo)
	{
		this.medic = vo.getMedic() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getMedic().getBean(map);
		this.nurse = vo.getNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getNurse().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.teamspecialty = vo.getTeamSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getTeamSpecialty().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.breachedprioritykpi = vo.getBreachedPriorityKPI();
		this.patientsurname = vo.getPatientSurname();
		this.addresscontains = vo.getAddressContains();
		this.attendancefrom = vo.getAttendanceFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAttendanceFrom().getBean();
		this.attendanceto = vo.getAttendanceTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAttendanceTo().getBean();
		this.triagefrom = vo.getTriageFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTriageFrom().getBean();
		this.triageto = vo.getTriageTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTriageTo().getBean();
		this.dischargefrom = vo.getDischargeFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeFrom().getBean();
		this.dischargeto = vo.getDischargeTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeTo().getBean();
		this.edstatus = vo.getEDStatus();
		this.bedallocation = vo.getBedAllocation();
		this.awaitingreview = vo.getAwaitingReview();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.attendanceid = vo.getAttendanceID();
		this.presentingproblem = vo.getPresentingProblem() == null ? null : (ims.vo.LookupInstanceBean)vo.getPresentingProblem().getBean();
		this.attendancenotcoded = vo.getAttendanceNotCoded();
	}

	public ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.MedicVoBean getMedic()
	{
		return this.medic;
	}
	public void setMedic(ims.core.vo.beans.MedicVoBean value)
	{
		this.medic = value;
	}
	public ims.core.vo.beans.NurseVoBean getNurse()
	{
		return this.nurse;
	}
	public void setNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.nurse = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.LookupInstanceBean getTeamSpecialty()
	{
		return this.teamspecialty;
	}
	public void setTeamSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.teamspecialty = value;
	}
	public ims.vo.LookupInstanceBean getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.vo.LookupInstanceBean value)
	{
		this.priority = value;
	}
	public Boolean getBreachedPriorityKPI()
	{
		return this.breachedprioritykpi;
	}
	public void setBreachedPriorityKPI(Boolean value)
	{
		this.breachedprioritykpi = value;
	}
	public String getPatientSurname()
	{
		return this.patientsurname;
	}
	public void setPatientSurname(String value)
	{
		this.patientsurname = value;
	}
	public String getAddressContains()
	{
		return this.addresscontains;
	}
	public void setAddressContains(String value)
	{
		this.addresscontains = value;
	}
	public ims.framework.utils.beans.DateBean getAttendanceFrom()
	{
		return this.attendancefrom;
	}
	public void setAttendanceFrom(ims.framework.utils.beans.DateBean value)
	{
		this.attendancefrom = value;
	}
	public ims.framework.utils.beans.DateBean getAttendanceTo()
	{
		return this.attendanceto;
	}
	public void setAttendanceTo(ims.framework.utils.beans.DateBean value)
	{
		this.attendanceto = value;
	}
	public ims.framework.utils.beans.DateBean getTriageFrom()
	{
		return this.triagefrom;
	}
	public void setTriageFrom(ims.framework.utils.beans.DateBean value)
	{
		this.triagefrom = value;
	}
	public ims.framework.utils.beans.DateBean getTriageTo()
	{
		return this.triageto;
	}
	public void setTriageTo(ims.framework.utils.beans.DateBean value)
	{
		this.triageto = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeFrom()
	{
		return this.dischargefrom;
	}
	public void setDischargeFrom(ims.framework.utils.beans.DateBean value)
	{
		this.dischargefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeTo()
	{
		return this.dischargeto;
	}
	public void setDischargeTo(ims.framework.utils.beans.DateBean value)
	{
		this.dischargeto = value;
	}
	public Integer getEDStatus()
	{
		return this.edstatus;
	}
	public void setEDStatus(Integer value)
	{
		this.edstatus = value;
	}
	public Integer getBedAllocation()
	{
		return this.bedallocation;
	}
	public void setBedAllocation(Integer value)
	{
		this.bedallocation = value;
	}
	public Boolean getAwaitingReview()
	{
		return this.awaitingreview;
	}
	public void setAwaitingReview(Boolean value)
	{
		this.awaitingreview = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public Integer getAttendanceID()
	{
		return this.attendanceid;
	}
	public void setAttendanceID(Integer value)
	{
		this.attendanceid = value;
	}
	public ims.vo.LookupInstanceBean getPresentingProblem()
	{
		return this.presentingproblem;
	}
	public void setPresentingProblem(ims.vo.LookupInstanceBean value)
	{
		this.presentingproblem = value;
	}
	public Boolean getAttendanceNotCoded()
	{
		return this.attendancenotcoded;
	}
	public void setAttendanceNotCoded(Boolean value)
	{
		this.attendancenotcoded = value;
	}

	private ims.core.vo.beans.MedicVoBean medic;
	private ims.core.vo.beans.NurseVoBean nurse;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.LookupInstanceBean teamspecialty;
	private ims.vo.LookupInstanceBean priority;
	private Boolean breachedprioritykpi;
	private String patientsurname;
	private String addresscontains;
	private ims.framework.utils.beans.DateBean attendancefrom;
	private ims.framework.utils.beans.DateBean attendanceto;
	private ims.framework.utils.beans.DateBean triagefrom;
	private ims.framework.utils.beans.DateBean triageto;
	private ims.framework.utils.beans.DateBean dischargefrom;
	private ims.framework.utils.beans.DateBean dischargeto;
	private Integer edstatus;
	private Integer bedallocation;
	private Boolean awaitingreview;
	private ims.vo.LookupInstanceBean outcome;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private Integer attendanceid;
	private ims.vo.LookupInstanceBean presentingproblem;
	private Boolean attendancenotcoded;
}
