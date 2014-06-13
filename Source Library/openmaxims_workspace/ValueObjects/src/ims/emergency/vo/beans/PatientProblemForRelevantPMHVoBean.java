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

public class PatientProblemForRelevantPMHVoBean extends ims.vo.ValueObjectBean
{
	public PatientProblemForRelevantPMHVoBean()
	{
	}
	public PatientProblemForRelevantPMHVoBean(ims.emergency.vo.PatientProblemForRelevantPMHVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patientproblem = vo.getPatientProblem();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.PatientProblemForRelevantPMHVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patientproblem = vo.getPatientProblem();
	}

	public ims.emergency.vo.PatientProblemForRelevantPMHVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.PatientProblemForRelevantPMHVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.PatientProblemForRelevantPMHVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.PatientProblemForRelevantPMHVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.PatientProblemForRelevantPMHVo();
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
	public String getPatientProblem()
	{
		return this.patientproblem;
	}
	public void setPatientProblem(String value)
	{
		this.patientproblem = value;
	}

	private Integer id;
	private int version;
	private String patientproblem;
}
