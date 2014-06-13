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

package ims.pathways.vo.beans;

public class WorkListSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public WorkListSearchCriteriaVoBean()
	{
	}
	public WorkListSearchCriteriaVoBean(ims.pathways.vo.WorkListSearchCriteriaVo vo)
	{
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		// Interface field type not supported.
		if(vo.getPathways() != null)
		{
			this.pathways = new ims.vo.RefVoBean[vo.getPathways().size()];
			for(int pathways_i = 0; pathways_i < vo.getPathways().size(); pathways_i++)
			{
				this.pathways[pathways_i] = new ims.vo.RefVoBean(vo.getPathways().get(pathways_i).getBoId(),vo.getPathways().get(pathways_i).getBoVersion());
			}
		}
		this.conditions = vo.getConditions() == null ? null : vo.getConditions().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.WorkListSearchCriteriaVo vo)
	{
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		// Interface field type not supported.
		if(vo.getPathways() != null)
		{
			this.pathways = new ims.vo.RefVoBean[vo.getPathways().size()];
			for(int pathways_i = 0; pathways_i < vo.getPathways().size(); pathways_i++)
			{
				this.pathways[pathways_i] = new ims.vo.RefVoBean(vo.getPathways().get(pathways_i).getBoId(),vo.getPathways().get(pathways_i).getBoVersion());
			}
		}
		this.conditions = vo.getConditions() == null ? null : vo.getConditions().getBeanCollection();
	}

	public ims.pathways.vo.WorkListSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.WorkListSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.WorkListSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.WorkListSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.WorkListSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.RefVoBean[] getPathways()
	{
		return this.pathways;
	}
	public void setPathways(ims.vo.RefVoBean[] value)
	{
		this.pathways = value;
	}
	public ims.pathways.vo.beans.WorkListTargetCriteriaVoBean[] getConditions()
	{
		return this.conditions;
	}
	public void setConditions(ims.pathways.vo.beans.WorkListTargetCriteriaVoBean[] value)
	{
		this.conditions = value;
	}

	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.RefVoBean[] pathways;
	private ims.pathways.vo.beans.WorkListTargetCriteriaVoBean[] conditions;
}
