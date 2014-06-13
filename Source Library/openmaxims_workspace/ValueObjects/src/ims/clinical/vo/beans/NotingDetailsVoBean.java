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

package ims.clinical.vo.beans;

public class NotingDetailsVoBean extends ims.vo.ValueObjectBean
{
	public NotingDetailsVoBean()
	{
	}
	public NotingDetailsVoBean(ims.clinical.vo.NotingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalnote = vo.getClinicalNote() == null ? null : new ims.vo.RefVoBean(vo.getClinicalNote().getBoId(), vo.getClinicalNote().getBoVersion());
		this.iswritten = vo.getIsWritten();
		this.isdictated = vo.getIsDictated();
		this.istyped = vo.getIsTyped();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.NotingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalnote = vo.getClinicalNote() == null ? null : new ims.vo.RefVoBean(vo.getClinicalNote().getBoId(), vo.getClinicalNote().getBoVersion());
		this.iswritten = vo.getIsWritten();
		this.isdictated = vo.getIsDictated();
		this.istyped = vo.getIsTyped();
	}

	public ims.clinical.vo.NotingDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.NotingDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.NotingDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.NotingDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.NotingDetailsVo();
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
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(ims.vo.RefVoBean value)
	{
		this.clinicalnote = value;
	}
	public Boolean getIsWritten()
	{
		return this.iswritten;
	}
	public void setIsWritten(Boolean value)
	{
		this.iswritten = value;
	}
	public Boolean getIsDictated()
	{
		return this.isdictated;
	}
	public void setIsDictated(Boolean value)
	{
		this.isdictated = value;
	}
	public Boolean getIsTyped()
	{
		return this.istyped;
	}
	public void setIsTyped(Boolean value)
	{
		this.istyped = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean clinicalnote;
	private Boolean iswritten;
	private Boolean isdictated;
	private Boolean istyped;
}
