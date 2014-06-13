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

public class IntraOperativeCareRecordLiteVoBean extends ims.vo.ValueObjectBean
{
	public IntraOperativeCareRecordLiteVoBean()
	{
	}
	public IntraOperativeCareRecordLiteVoBean(ims.clinical.vo.IntraOperativeCareRecordLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.actualprocedure = vo.getActualProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureForSurgicalOperationNotesVoBean)vo.getActualProcedure().getBean();
		this.proceduredate = vo.getProcedureDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getProcedureDate().getBean();
		this.theatre = vo.getTheatre() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getTheatre().getBean();
		this.surgeon = vo.getSurgeon() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSurgeon().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.IntraOperativeCareRecordLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.actualprocedure = vo.getActualProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureForSurgicalOperationNotesVoBean)vo.getActualProcedure().getBean(map);
		this.proceduredate = vo.getProcedureDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getProcedureDate().getBean();
		this.theatre = vo.getTheatre() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getTheatre().getBean(map);
		this.surgeon = vo.getSurgeon() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSurgeon().getBean(map);
	}

	public ims.clinical.vo.IntraOperativeCareRecordLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.IntraOperativeCareRecordLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.IntraOperativeCareRecordLiteVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.IntraOperativeCareRecordLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.IntraOperativeCareRecordLiteVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.PatientProcedureForSurgicalOperationNotesVoBean getActualProcedure()
	{
		return this.actualprocedure;
	}
	public void setActualProcedure(ims.core.vo.beans.PatientProcedureForSurgicalOperationNotesVoBean value)
	{
		this.actualprocedure = value;
	}
	public ims.framework.utils.beans.DateBean getProcedureDate()
	{
		return this.proceduredate;
	}
	public void setProcedureDate(ims.framework.utils.beans.DateBean value)
	{
		this.proceduredate = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getTheatre()
	{
		return this.theatre;
	}
	public void setTheatre(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.theatre = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSurgeon()
	{
		return this.surgeon;
	}
	public void setSurgeon(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.surgeon = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.PatientProcedureForSurgicalOperationNotesVoBean actualprocedure;
	private ims.framework.utils.beans.DateBean proceduredate;
	private ims.core.vo.beans.LocationLiteVoBean theatre;
	private ims.core.vo.beans.HcpLiteVoBean surgeon;
}
