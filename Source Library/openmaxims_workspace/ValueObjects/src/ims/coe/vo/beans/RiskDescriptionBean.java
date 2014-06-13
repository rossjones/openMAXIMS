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

package ims.coe.vo.beans;

public class RiskDescriptionBean extends ims.vo.ValueObjectBean
{
	public RiskDescriptionBean()
	{
	}
	public RiskDescriptionBean(ims.coe.vo.RiskDescription vo)
	{
		this.id = vo.getId();
		this.name = vo.getName();
		this.score = vo.getScore();
		this.description = vo.getDescription();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.RiskDescription vo)
	{
		this.id = vo.getId();
		this.name = vo.getName();
		this.score = vo.getScore();
		this.description = vo.getDescription();
	}

	public ims.coe.vo.RiskDescription buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.RiskDescription buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.RiskDescription vo = null;
		if(map != null)
			vo = (ims.coe.vo.RiskDescription)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.RiskDescription();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getId()
	{
		return this.id;
	}
	public void setId(String value)
	{
		this.id = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getScore()
	{
		return this.score;
	}
	public void setScore(String value)
	{
		this.score = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}

	private String id;
	private String name;
	private String score;
	private String description;
}
