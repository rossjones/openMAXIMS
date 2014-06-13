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

public class MDTListAndDatesExtraVoBean extends ims.vo.ValueObjectBean
{
	public MDTListAndDatesExtraVoBean()
	{
	}
	public MDTListAndDatesExtraVoBean(ims.clinical.vo.MDTListAndDatesExtraVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.listpatientison = vo.getListPatientisOn() == null ? null : (ims.vo.LookupInstanceBean)vo.getListPatientisOn().getBean();
		if(vo.getKeyDates() != null)
		{
			this.keydates = new ims.vo.RefVoBean[vo.getKeyDates().size()];
			for(int keydates_i = 0; keydates_i < vo.getKeyDates().size(); keydates_i++)
			{
				this.keydates[keydates_i] = new ims.vo.RefVoBean(vo.getKeyDates().get(keydates_i).getBoId(),vo.getKeyDates().get(keydates_i).getBoVersion());
			}
		}
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.MDTListAndDatesExtraVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.listpatientison = vo.getListPatientisOn() == null ? null : (ims.vo.LookupInstanceBean)vo.getListPatientisOn().getBean();
		if(vo.getKeyDates() != null)
		{
			this.keydates = new ims.vo.RefVoBean[vo.getKeyDates().size()];
			for(int keydates_i = 0; keydates_i < vo.getKeyDates().size(); keydates_i++)
			{
				this.keydates[keydates_i] = new ims.vo.RefVoBean(vo.getKeyDates().get(keydates_i).getBoId(),vo.getKeyDates().get(keydates_i).getBoVersion());
			}
		}
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.MDTListAndDatesExtraVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.MDTListAndDatesExtraVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.MDTListAndDatesExtraVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.MDTListAndDatesExtraVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.MDTListAndDatesExtraVo();
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
	public ims.vo.LookupInstanceBean getListPatientisOn()
	{
		return this.listpatientison;
	}
	public void setListPatientisOn(ims.vo.LookupInstanceBean value)
	{
		this.listpatientison = value;
	}
	public ims.vo.RefVoBean[] getKeyDates()
	{
		return this.keydates;
	}
	public void setKeyDates(ims.vo.RefVoBean[] value)
	{
		this.keydates = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean listpatientison;
	private ims.vo.RefVoBean[] keydates;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.vo.RefVoBean carecontext;
}
