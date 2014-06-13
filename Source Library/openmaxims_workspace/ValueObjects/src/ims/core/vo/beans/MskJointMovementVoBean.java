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

public class MskJointMovementVoBean extends ims.vo.ValueObjectBean
{
	public MskJointMovementVoBean()
	{
	}
	public MskJointMovementVoBean(ims.core.vo.MskJointMovementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movetype = vo.getMoveType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMoveType().getBean();
		this.movefinding = vo.getMoveFinding() == null ? null : (ims.vo.LookupInstanceBean)vo.getMoveFinding().getBean();
		this.movsor = vo.getMovSOR();
		this.moveor = vo.getMovEOR();
		this.qualitativerange = vo.getQualitativeRange() == null ? null : (ims.vo.LookupInstanceBean)vo.getQualitativeRange().getBean();
		this.limited = vo.getLimited() == null ? null : (ims.vo.LookupInstanceBean)vo.getLimited().getBean();
		this.moveaction = vo.getMoveAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getMoveAction().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.MskJointMovementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movetype = vo.getMoveType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMoveType().getBean();
		this.movefinding = vo.getMoveFinding() == null ? null : (ims.vo.LookupInstanceBean)vo.getMoveFinding().getBean();
		this.movsor = vo.getMovSOR();
		this.moveor = vo.getMovEOR();
		this.qualitativerange = vo.getQualitativeRange() == null ? null : (ims.vo.LookupInstanceBean)vo.getQualitativeRange().getBean();
		this.limited = vo.getLimited() == null ? null : (ims.vo.LookupInstanceBean)vo.getLimited().getBean();
		this.moveaction = vo.getMoveAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getMoveAction().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.core.vo.MskJointMovementVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.MskJointMovementVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.MskJointMovementVo vo = null;
		if(map != null)
			vo = (ims.core.vo.MskJointMovementVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.MskJointMovementVo();
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
	public ims.vo.LookupInstanceBean getMoveType()
	{
		return this.movetype;
	}
	public void setMoveType(ims.vo.LookupInstanceBean value)
	{
		this.movetype = value;
	}
	public ims.vo.LookupInstanceBean getMoveFinding()
	{
		return this.movefinding;
	}
	public void setMoveFinding(ims.vo.LookupInstanceBean value)
	{
		this.movefinding = value;
	}
	public Integer getMovSOR()
	{
		return this.movsor;
	}
	public void setMovSOR(Integer value)
	{
		this.movsor = value;
	}
	public Integer getMovEOR()
	{
		return this.moveor;
	}
	public void setMovEOR(Integer value)
	{
		this.moveor = value;
	}
	public ims.vo.LookupInstanceBean getQualitativeRange()
	{
		return this.qualitativerange;
	}
	public void setQualitativeRange(ims.vo.LookupInstanceBean value)
	{
		this.qualitativerange = value;
	}
	public ims.vo.LookupInstanceBean getLimited()
	{
		return this.limited;
	}
	public void setLimited(ims.vo.LookupInstanceBean value)
	{
		this.limited = value;
	}
	public ims.vo.LookupInstanceBean getMoveAction()
	{
		return this.moveaction;
	}
	public void setMoveAction(ims.vo.LookupInstanceBean value)
	{
		this.moveaction = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean movetype;
	private ims.vo.LookupInstanceBean movefinding;
	private Integer movsor;
	private Integer moveor;
	private ims.vo.LookupInstanceBean qualitativerange;
	private ims.vo.LookupInstanceBean limited;
	private ims.vo.LookupInstanceBean moveaction;
	private ims.vo.SysInfoBean sysinfo;
}
