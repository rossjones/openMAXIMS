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

public class HrgConfigVoBean extends ims.vo.ValueObjectBean
{
	public HrgConfigVoBean()
	{
	}
	public HrgConfigVoBean(ims.core.vo.HrgConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hrgcode = vo.getHRGCode();
		this.hrgdescription = vo.getHRGDescription();
		this.costpounds = vo.getCostPounds();
		this.costpence = vo.getCostPence();
		this.mappings = vo.getMappings() == null ? null : vo.getMappings().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.HrgConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hrgcode = vo.getHRGCode();
		this.hrgdescription = vo.getHRGDescription();
		this.costpounds = vo.getCostPounds();
		this.costpence = vo.getCostPence();
		this.mappings = vo.getMappings() == null ? null : vo.getMappings().getBeanCollection();
	}

	public ims.core.vo.HrgConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.HrgConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.HrgConfigVo vo = null;
		if(map != null)
			vo = (ims.core.vo.HrgConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.HrgConfigVo();
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
	public String getHRGCode()
	{
		return this.hrgcode;
	}
	public void setHRGCode(String value)
	{
		this.hrgcode = value;
	}
	public String getHRGDescription()
	{
		return this.hrgdescription;
	}
	public void setHRGDescription(String value)
	{
		this.hrgdescription = value;
	}
	public Integer getCostPounds()
	{
		return this.costpounds;
	}
	public void setCostPounds(Integer value)
	{
		this.costpounds = value;
	}
	public Integer getCostPence()
	{
		return this.costpence;
	}
	public void setCostPence(Integer value)
	{
		this.costpence = value;
	}
	public ims.core.vo.beans.NonUniqueTaxonomyMapVoBean[] getMappings()
	{
		return this.mappings;
	}
	public void setMappings(ims.core.vo.beans.NonUniqueTaxonomyMapVoBean[] value)
	{
		this.mappings = value;
	}

	private Integer id;
	private int version;
	private String hrgcode;
	private String hrgdescription;
	private Integer costpounds;
	private Integer costpence;
	private ims.core.vo.beans.NonUniqueTaxonomyMapVoBean[] mappings;
}
