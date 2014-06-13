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

package ims.generalmedical.vo.beans;

public class RangeOfMovementJointVoBean extends ims.vo.ValueObjectBean
{
	public RangeOfMovementJointVoBean()
	{
	}
	public RangeOfMovementJointVoBean(ims.generalmedical.vo.RangeOfMovementJointVo vo)
	{
		this.joint = vo.getJoint() == null ? null : (ims.core.vo.beans.MskJointVoBean)vo.getJoint().getBean();
		this.group = vo.getGroup() == null ? null : (ims.core.vo.beans.MskGroupLiteVoBean)vo.getGroup().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.RangeOfMovementJointVo vo)
	{
		this.joint = vo.getJoint() == null ? null : (ims.core.vo.beans.MskJointVoBean)vo.getJoint().getBean(map);
		this.group = vo.getGroup() == null ? null : (ims.core.vo.beans.MskGroupLiteVoBean)vo.getGroup().getBean(map);
	}

	public ims.generalmedical.vo.RangeOfMovementJointVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.RangeOfMovementJointVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.RangeOfMovementJointVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.RangeOfMovementJointVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.RangeOfMovementJointVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.MskJointVoBean getJoint()
	{
		return this.joint;
	}
	public void setJoint(ims.core.vo.beans.MskJointVoBean value)
	{
		this.joint = value;
	}
	public ims.core.vo.beans.MskGroupLiteVoBean getGroup()
	{
		return this.group;
	}
	public void setGroup(ims.core.vo.beans.MskGroupLiteVoBean value)
	{
		this.group = value;
	}

	private ims.core.vo.beans.MskJointVoBean joint;
	private ims.core.vo.beans.MskGroupLiteVoBean group;
}
