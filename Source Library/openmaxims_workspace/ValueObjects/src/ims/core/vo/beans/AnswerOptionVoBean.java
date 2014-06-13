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

public class AnswerOptionVoBean extends ims.vo.ValueObjectBean
{
	public AnswerOptionVoBean()
	{
	}
	public AnswerOptionVoBean(ims.core.vo.AnswerOptionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.optiontext = vo.getOptionText();
		this.optiondescription = vo.getOptionDescription();
		this.score = vo.getScore();
		this.taxonomymappings = vo.getTaxonomyMappings() == null ? null : vo.getTaxonomyMappings().getBeanCollection();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.AnswerOptionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.optiontext = vo.getOptionText();
		this.optiondescription = vo.getOptionDescription();
		this.score = vo.getScore();
		this.taxonomymappings = vo.getTaxonomyMappings() == null ? null : vo.getTaxonomyMappings().getBeanCollection();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
	}

	public ims.core.vo.AnswerOptionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.AnswerOptionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.AnswerOptionVo vo = null;
		if(map != null)
			vo = (ims.core.vo.AnswerOptionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.AnswerOptionVo();
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
	public String getOptionText()
	{
		return this.optiontext;
	}
	public void setOptionText(String value)
	{
		this.optiontext = value;
	}
	public String getOptionDescription()
	{
		return this.optiondescription;
	}
	public void setOptionDescription(String value)
	{
		this.optiondescription = value;
	}
	public Float getScore()
	{
		return this.score;
	}
	public void setScore(Float value)
	{
		this.score = value;
	}
	public ims.core.vo.beans.NonUniqueTaxonomyMapVoBean[] getTaxonomyMappings()
	{
		return this.taxonomymappings;
	}
	public void setTaxonomyMappings(ims.core.vo.beans.NonUniqueTaxonomyMapVoBean[] value)
	{
		this.taxonomymappings = value;
	}
	public ims.framework.utils.beans.ColorBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.beans.ColorBean value)
	{
		this.colour = value;
	}

	private Integer id;
	private int version;
	private String optiontext;
	private String optiondescription;
	private Float score;
	private ims.core.vo.beans.NonUniqueTaxonomyMapVoBean[] taxonomymappings;
	private ims.framework.utils.beans.ColorBean colour;
}
