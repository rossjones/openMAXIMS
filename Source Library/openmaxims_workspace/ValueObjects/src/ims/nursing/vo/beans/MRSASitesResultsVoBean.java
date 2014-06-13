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

package ims.nursing.vo.beans;

public class MRSASitesResultsVoBean extends ims.vo.ValueObjectBean
{
	public MRSASitesResultsVoBean()
	{
	}
	public MRSASitesResultsVoBean(ims.nursing.vo.MRSASitesResultsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.site = vo.getSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getSite().getBean();
		this.other = vo.getOther();
		this.dateresult = vo.getDateResult() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateResult().getBean();
		this.result = vo.getResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getResult().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.MRSASitesResultsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.site = vo.getSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getSite().getBean();
		this.other = vo.getOther();
		this.dateresult = vo.getDateResult() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateResult().getBean();
		this.result = vo.getResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getResult().getBean();
	}

	public ims.nursing.vo.MRSASitesResultsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.MRSASitesResultsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.MRSASitesResultsVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.MRSASitesResultsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.MRSASitesResultsVo();
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
	public ims.vo.LookupInstanceBean getSite()
	{
		return this.site;
	}
	public void setSite(ims.vo.LookupInstanceBean value)
	{
		this.site = value;
	}
	public String getOther()
	{
		return this.other;
	}
	public void setOther(String value)
	{
		this.other = value;
	}
	public ims.framework.utils.beans.DateBean getDateResult()
	{
		return this.dateresult;
	}
	public void setDateResult(ims.framework.utils.beans.DateBean value)
	{
		this.dateresult = value;
	}
	public ims.vo.LookupInstanceBean getResult()
	{
		return this.result;
	}
	public void setResult(ims.vo.LookupInstanceBean value)
	{
		this.result = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean site;
	private String other;
	private ims.framework.utils.beans.DateBean dateresult;
	private ims.vo.LookupInstanceBean result;
}
