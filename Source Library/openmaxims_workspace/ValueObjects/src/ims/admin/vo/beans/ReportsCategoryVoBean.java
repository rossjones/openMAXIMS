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

package ims.admin.vo.beans;

public class ReportsCategoryVoBean extends ims.vo.ValueObjectBean
{
	public ReportsCategoryVoBean()
	{
	}
	public ReportsCategoryVoBean(ims.admin.vo.ReportsCategoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		if(vo.getReports() != null)
		{
			this.reports = new ims.vo.RefVoBean[vo.getReports().size()];
			for(int reports_i = 0; reports_i < vo.getReports().size(); reports_i++)
			{
				this.reports[reports_i] = new ims.vo.RefVoBean(vo.getReports().get(reports_i).getBoId(),vo.getReports().get(reports_i).getBoVersion());
			}
		}
		this.parentcategory = vo.getParentCategory() == null ? null : new ims.vo.RefVoBean(vo.getParentCategory().getBoId(), vo.getParentCategory().getBoVersion());
		if(vo.getSubCategories() != null)
		{
			this.subcategories = new ims.vo.RefVoBean[vo.getSubCategories().size()];
			for(int subcategories_i = 0; subcategories_i < vo.getSubCategories().size(); subcategories_i++)
			{
				this.subcategories[subcategories_i] = new ims.vo.RefVoBean(vo.getSubCategories().get(subcategories_i).getBoId(),vo.getSubCategories().get(subcategories_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ReportsCategoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		if(vo.getReports() != null)
		{
			this.reports = new ims.vo.RefVoBean[vo.getReports().size()];
			for(int reports_i = 0; reports_i < vo.getReports().size(); reports_i++)
			{
				this.reports[reports_i] = new ims.vo.RefVoBean(vo.getReports().get(reports_i).getBoId(),vo.getReports().get(reports_i).getBoVersion());
			}
		}
		this.parentcategory = vo.getParentCategory() == null ? null : new ims.vo.RefVoBean(vo.getParentCategory().getBoId(), vo.getParentCategory().getBoVersion());
		if(vo.getSubCategories() != null)
		{
			this.subcategories = new ims.vo.RefVoBean[vo.getSubCategories().size()];
			for(int subcategories_i = 0; subcategories_i < vo.getSubCategories().size(); subcategories_i++)
			{
				this.subcategories[subcategories_i] = new ims.vo.RefVoBean(vo.getSubCategories().get(subcategories_i).getBoId(),vo.getSubCategories().get(subcategories_i).getBoVersion());
			}
		}
	}

	public ims.admin.vo.ReportsCategoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ReportsCategoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ReportsCategoryVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ReportsCategoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ReportsCategoryVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.vo.RefVoBean[] getReports()
	{
		return this.reports;
	}
	public void setReports(ims.vo.RefVoBean[] value)
	{
		this.reports = value;
	}
	public ims.vo.RefVoBean getParentCategory()
	{
		return this.parentcategory;
	}
	public void setParentCategory(ims.vo.RefVoBean value)
	{
		this.parentcategory = value;
	}
	public ims.vo.RefVoBean[] getSubCategories()
	{
		return this.subcategories;
	}
	public void setSubCategories(ims.vo.RefVoBean[] value)
	{
		this.subcategories = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.vo.RefVoBean[] reports;
	private ims.vo.RefVoBean parentcategory;
	private ims.vo.RefVoBean[] subcategories;
}
