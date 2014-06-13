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

package ims.icp.vo.beans;

public class PatientICPPhase_DisplayVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPPhase_DisplayVoBean()
	{
	}
	public PatientICPPhase_DisplayVoBean(ims.icp.vo.PatientICPPhase_DisplayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.phase = vo.getPhase() == null ? null : (ims.icp.vo.beans.ICPPhaseLiteVoBean)vo.getPhase().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPPhaseStatusVoBean)vo.getCurrentStatus().getBean();
		if(vo.getStatusHistory() != null)
		{
			this.statushistory = new ims.vo.RefVoBean[vo.getStatusHistory().size()];
			for(int statushistory_i = 0; statushistory_i < vo.getStatusHistory().size(); statushistory_i++)
			{
				this.statushistory[statushistory_i] = new ims.vo.RefVoBean(vo.getStatusHistory().get(statushistory_i).getBoId(),vo.getStatusHistory().get(statushistory_i).getBoVersion());
			}
		}
		this.hasactions = vo.getHasActions();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPPhase_DisplayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.phase = vo.getPhase() == null ? null : (ims.icp.vo.beans.ICPPhaseLiteVoBean)vo.getPhase().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPPhaseStatusVoBean)vo.getCurrentStatus().getBean(map);
		if(vo.getStatusHistory() != null)
		{
			this.statushistory = new ims.vo.RefVoBean[vo.getStatusHistory().size()];
			for(int statushistory_i = 0; statushistory_i < vo.getStatusHistory().size(); statushistory_i++)
			{
				this.statushistory[statushistory_i] = new ims.vo.RefVoBean(vo.getStatusHistory().get(statushistory_i).getBoId(),vo.getStatusHistory().get(statushistory_i).getBoVersion());
			}
		}
		this.hasactions = vo.getHasActions();
	}

	public ims.icp.vo.PatientICPPhase_DisplayVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPPhase_DisplayVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPPhase_DisplayVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPPhase_DisplayVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPPhase_DisplayVo();
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
	public ims.vo.RefVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.vo.RefVoBean value)
	{
		this.icp = value;
	}
	public ims.icp.vo.beans.ICPPhaseLiteVoBean getPhase()
	{
		return this.phase;
	}
	public void setPhase(ims.icp.vo.beans.ICPPhaseLiteVoBean value)
	{
		this.phase = value;
	}
	public ims.icp.vo.beans.PatientICPPhaseStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.beans.PatientICPPhaseStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.RefVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.vo.RefVoBean[] value)
	{
		this.statushistory = value;
	}
	public Boolean getHasActions()
	{
		return this.hasactions;
	}
	public void setHasActions(Boolean value)
	{
		this.hasactions = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean icp;
	private ims.icp.vo.beans.ICPPhaseLiteVoBean phase;
	private ims.icp.vo.beans.PatientICPPhaseStatusVoBean currentstatus;
	private ims.vo.RefVoBean[] statushistory;
	private Boolean hasactions;
}
