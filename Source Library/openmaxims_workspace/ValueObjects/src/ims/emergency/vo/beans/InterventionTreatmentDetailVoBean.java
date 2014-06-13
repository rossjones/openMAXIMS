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

package ims.emergency.vo.beans;

public class InterventionTreatmentDetailVoBean extends ims.vo.ValueObjectBean
{
	public InterventionTreatmentDetailVoBean()
	{
	}
	public InterventionTreatmentDetailVoBean(ims.emergency.vo.InterventionTreatmentDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.treatmentinterventiondescription = vo.getTreatmentInterventionDescription();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.treatmentintervention = vo.getTreatmentIntervention() == null ? null : (ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean)vo.getTreatmentIntervention().getBean();
		this.addedduringcoding = vo.getAddedDuringCoding();
		this.codingsequence = vo.getCodingSequence();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.InterventionTreatmentDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.treatmentinterventiondescription = vo.getTreatmentInterventionDescription();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.treatmentintervention = vo.getTreatmentIntervention() == null ? null : (ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean)vo.getTreatmentIntervention().getBean(map);
		this.addedduringcoding = vo.getAddedDuringCoding();
		this.codingsequence = vo.getCodingSequence();
	}

	public ims.emergency.vo.InterventionTreatmentDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.InterventionTreatmentDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.InterventionTreatmentDetailVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.InterventionTreatmentDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.InterventionTreatmentDetailVo();
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
	public String getTreatmentInterventionDescription()
	{
		return this.treatmentinterventiondescription;
	}
	public void setTreatmentInterventionDescription(String value)
	{
		this.treatmentinterventiondescription = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean getTreatmentIntervention()
	{
		return this.treatmentintervention;
	}
	public void setTreatmentIntervention(ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean value)
	{
		this.treatmentintervention = value;
	}
	public Boolean getAddedDuringCoding()
	{
		return this.addedduringcoding;
	}
	public void setAddedDuringCoding(Boolean value)
	{
		this.addedduringcoding = value;
	}
	public Integer getCodingSequence()
	{
		return this.codingsequence;
	}
	public void setCodingSequence(Integer value)
	{
		this.codingsequence = value;
	}

	private Integer id;
	private int version;
	private String treatmentinterventiondescription;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean treatmentintervention;
	private Boolean addedduringcoding;
	private Integer codingsequence;
}
