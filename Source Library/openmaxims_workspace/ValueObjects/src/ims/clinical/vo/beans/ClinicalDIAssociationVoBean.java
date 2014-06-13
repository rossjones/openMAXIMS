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

public class ClinicalDIAssociationVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalDIAssociationVoBean()
	{
	}
	public ClinicalDIAssociationVoBean(ims.clinical.vo.ClinicalDIAssociationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.primdiagnosis = vo.getPrimDiagnosis() == null ? null : new ims.vo.RefVoBean(vo.getPrimDiagnosis().getBoId(), vo.getPrimDiagnosis().getBoVersion());
		this.primprocedure = vo.getPrimProcedure() == null ? null : new ims.vo.RefVoBean(vo.getPrimProcedure().getBoId(), vo.getPrimProcedure().getBoVersion());
		this.primproblem = vo.getPrimProblem() == null ? null : new ims.vo.RefVoBean(vo.getPrimProblem().getBoId(), vo.getPrimProblem().getBoVersion());
		this.associationdescription = vo.getAssociationDescription() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssociationDescription().getBean();
		this.assocdiagnosis = vo.getAssocDiagnosis() == null ? null : new ims.vo.RefVoBean(vo.getAssocDiagnosis().getBoId(), vo.getAssocDiagnosis().getBoVersion());
		this.assocprocedure = vo.getAssocProcedure() == null ? null : new ims.vo.RefVoBean(vo.getAssocProcedure().getBoId(), vo.getAssocProcedure().getBoVersion());
		this.assocproblem = vo.getAssocProblem() == null ? null : new ims.vo.RefVoBean(vo.getAssocProblem().getBoId(), vo.getAssocProblem().getBoVersion());
		this.reverseassociation = vo.getReverseAssociation() == null ? null : (ims.vo.LookupInstanceBean)vo.getReverseAssociation().getBean();
		this.isactive = vo.getIsActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.ClinicalDIAssociationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.primdiagnosis = vo.getPrimDiagnosis() == null ? null : new ims.vo.RefVoBean(vo.getPrimDiagnosis().getBoId(), vo.getPrimDiagnosis().getBoVersion());
		this.primprocedure = vo.getPrimProcedure() == null ? null : new ims.vo.RefVoBean(vo.getPrimProcedure().getBoId(), vo.getPrimProcedure().getBoVersion());
		this.primproblem = vo.getPrimProblem() == null ? null : new ims.vo.RefVoBean(vo.getPrimProblem().getBoId(), vo.getPrimProblem().getBoVersion());
		this.associationdescription = vo.getAssociationDescription() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssociationDescription().getBean();
		this.assocdiagnosis = vo.getAssocDiagnosis() == null ? null : new ims.vo.RefVoBean(vo.getAssocDiagnosis().getBoId(), vo.getAssocDiagnosis().getBoVersion());
		this.assocprocedure = vo.getAssocProcedure() == null ? null : new ims.vo.RefVoBean(vo.getAssocProcedure().getBoId(), vo.getAssocProcedure().getBoVersion());
		this.assocproblem = vo.getAssocProblem() == null ? null : new ims.vo.RefVoBean(vo.getAssocProblem().getBoId(), vo.getAssocProblem().getBoVersion());
		this.reverseassociation = vo.getReverseAssociation() == null ? null : (ims.vo.LookupInstanceBean)vo.getReverseAssociation().getBean();
		this.isactive = vo.getIsActive();
	}

	public ims.clinical.vo.ClinicalDIAssociationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.ClinicalDIAssociationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.ClinicalDIAssociationVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.ClinicalDIAssociationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.ClinicalDIAssociationVo();
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
	public ims.vo.RefVoBean getPrimDiagnosis()
	{
		return this.primdiagnosis;
	}
	public void setPrimDiagnosis(ims.vo.RefVoBean value)
	{
		this.primdiagnosis = value;
	}
	public ims.vo.RefVoBean getPrimProcedure()
	{
		return this.primprocedure;
	}
	public void setPrimProcedure(ims.vo.RefVoBean value)
	{
		this.primprocedure = value;
	}
	public ims.vo.RefVoBean getPrimProblem()
	{
		return this.primproblem;
	}
	public void setPrimProblem(ims.vo.RefVoBean value)
	{
		this.primproblem = value;
	}
	public ims.vo.LookupInstanceBean getAssociationDescription()
	{
		return this.associationdescription;
	}
	public void setAssociationDescription(ims.vo.LookupInstanceBean value)
	{
		this.associationdescription = value;
	}
	public ims.vo.RefVoBean getAssocDiagnosis()
	{
		return this.assocdiagnosis;
	}
	public void setAssocDiagnosis(ims.vo.RefVoBean value)
	{
		this.assocdiagnosis = value;
	}
	public ims.vo.RefVoBean getAssocProcedure()
	{
		return this.assocprocedure;
	}
	public void setAssocProcedure(ims.vo.RefVoBean value)
	{
		this.assocprocedure = value;
	}
	public ims.vo.RefVoBean getAssocProblem()
	{
		return this.assocproblem;
	}
	public void setAssocProblem(ims.vo.RefVoBean value)
	{
		this.assocproblem = value;
	}
	public ims.vo.LookupInstanceBean getReverseAssociation()
	{
		return this.reverseassociation;
	}
	public void setReverseAssociation(ims.vo.LookupInstanceBean value)
	{
		this.reverseassociation = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean primdiagnosis;
	private ims.vo.RefVoBean primprocedure;
	private ims.vo.RefVoBean primproblem;
	private ims.vo.LookupInstanceBean associationdescription;
	private ims.vo.RefVoBean assocdiagnosis;
	private ims.vo.RefVoBean assocprocedure;
	private ims.vo.RefVoBean assocproblem;
	private ims.vo.LookupInstanceBean reverseassociation;
	private Boolean isactive;
}
