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

public class ReportVoForReportsToModalityConfigFormVoBean extends ims.vo.ValueObjectBean
{
	public ReportVoForReportsToModalityConfigFormVoBean()
	{
	}
	public ReportVoForReportsToModalityConfigFormVoBean(ims.core.vo.ReportVoForReportsToModalityConfigFormVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.reportname = vo.getReportName();
		this.isactive = vo.getIsActive();
		this.seeds = vo.getSeeds() == null ? null : vo.getSeeds().getBeanCollection();
		this.imsid = vo.getImsId();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ReportVoForReportsToModalityConfigFormVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.reportname = vo.getReportName();
		this.isactive = vo.getIsActive();
		this.seeds = vo.getSeeds() == null ? null : vo.getSeeds().getBeanCollection();
		this.imsid = vo.getImsId();
	}

	public ims.core.vo.ReportVoForReportsToModalityConfigFormVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ReportVoForReportsToModalityConfigFormVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ReportVoForReportsToModalityConfigFormVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ReportVoForReportsToModalityConfigFormVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ReportVoForReportsToModalityConfigFormVo();
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
	public String getReportName()
	{
		return this.reportname;
	}
	public void setReportName(String value)
	{
		this.reportname = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.admin.vo.beans.ReportSeedVoBean[] getSeeds()
	{
		return this.seeds;
	}
	public void setSeeds(ims.admin.vo.beans.ReportSeedVoBean[] value)
	{
		this.seeds = value;
	}
	public Integer getImsId()
	{
		return this.imsid;
	}
	public void setImsId(Integer value)
	{
		this.imsid = value;
	}

	private Integer id;
	private int version;
	private String reportname;
	private Boolean isactive;
	private ims.admin.vo.beans.ReportSeedVoBean[] seeds;
	private Integer imsid;
}
