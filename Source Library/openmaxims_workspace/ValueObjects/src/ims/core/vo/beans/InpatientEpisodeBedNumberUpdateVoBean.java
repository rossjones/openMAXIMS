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

public class InpatientEpisodeBedNumberUpdateVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeBedNumberUpdateVoBean()
	{
	}
	public InpatientEpisodeBedNumberUpdateVoBean(ims.core.vo.InpatientEpisodeBedNumberUpdateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.bedno = vo.getBedNo();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.InpatientEpisodeBedNumberUpdateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.bedno = vo.getBedNo();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
	}

	public ims.core.vo.InpatientEpisodeBedNumberUpdateVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.InpatientEpisodeBedNumberUpdateVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.InpatientEpisodeBedNumberUpdateVo vo = null;
		if(map != null)
			vo = (ims.core.vo.InpatientEpisodeBedNumberUpdateVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.InpatientEpisodeBedNumberUpdateVo();
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
	public String getBedNo()
	{
		return this.bedno;
	}
	public void setBedNo(String value)
	{
		this.bedno = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.framework.utils.beans.DateBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.estdischargedate = value;
	}

	private Integer id;
	private int version;
	private String bedno;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.framework.utils.beans.DateBean estdischargedate;
}
