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

public class ChartValueVoBean extends ims.vo.ValueObjectBean
{
	public ChartValueVoBean()
	{
	}
	public ChartValueVoBean(ims.core.vo.ChartValueVo vo)
	{
		this.value = vo.getValue();
		this.isabnormal = vo.getIsAbnormal();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDate().getBean();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.istimesuplied = vo.getIsTimeSuplied();
		this.investigationcomments = vo.getInvestigationComments() == null ? null : (ims.core.vo.beans.ChartInvestigationCommentsVoBean)vo.getInvestigationComments().getBean();
		this.specimencomments = vo.getSpecimenComments() == null ? null : (ims.core.vo.beans.ChartSpecimenCommentsVoBean)vo.getSpecimenComments().getBean();
		this.resultspecimentype = vo.getResultSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultSpecimenType().getBean();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.isreceiveddatetime = vo.getIsReceivedDateTime();
		this.valuestring = vo.getValueString();
		this.refrange = vo.getRefRange();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ChartValueVo vo)
	{
		this.value = vo.getValue();
		this.isabnormal = vo.getIsAbnormal();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDate().getBean();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.istimesuplied = vo.getIsTimeSuplied();
		this.investigationcomments = vo.getInvestigationComments() == null ? null : (ims.core.vo.beans.ChartInvestigationCommentsVoBean)vo.getInvestigationComments().getBean(map);
		this.specimencomments = vo.getSpecimenComments() == null ? null : (ims.core.vo.beans.ChartSpecimenCommentsVoBean)vo.getSpecimenComments().getBean(map);
		this.resultspecimentype = vo.getResultSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultSpecimenType().getBean();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.isreceiveddatetime = vo.getIsReceivedDateTime();
		this.valuestring = vo.getValueString();
		this.refrange = vo.getRefRange();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
	}

	public ims.core.vo.ChartValueVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ChartValueVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ChartValueVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ChartValueVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ChartValueVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Float getValue()
	{
		return this.value;
	}
	public void setValue(Float value)
	{
		this.value = value;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isabnormal = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.date = value;
	}
	public ims.core.vo.beans.ChartValueCommentVoBean[] getComments()
	{
		return this.comments;
	}
	public void setComments(ims.core.vo.beans.ChartValueCommentVoBean[] value)
	{
		this.comments = value;
	}
	public Boolean getIsTimeSuplied()
	{
		return this.istimesuplied;
	}
	public void setIsTimeSuplied(Boolean value)
	{
		this.istimesuplied = value;
	}
	public ims.core.vo.beans.ChartInvestigationCommentsVoBean getInvestigationComments()
	{
		return this.investigationcomments;
	}
	public void setInvestigationComments(ims.core.vo.beans.ChartInvestigationCommentsVoBean value)
	{
		this.investigationcomments = value;
	}
	public ims.core.vo.beans.ChartSpecimenCommentsVoBean getSpecimenComments()
	{
		return this.specimencomments;
	}
	public void setSpecimenComments(ims.core.vo.beans.ChartSpecimenCommentsVoBean value)
	{
		this.specimencomments = value;
	}
	public ims.vo.LookupInstanceBean getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstanceBean value)
	{
		this.resultspecimentype = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public Boolean getIsReceivedDateTime()
	{
		return this.isreceiveddatetime;
	}
	public void setIsReceivedDateTime(Boolean value)
	{
		this.isreceiveddatetime = value;
	}
	public String getValueString()
	{
		return this.valuestring;
	}
	public void setValueString(String value)
	{
		this.valuestring = value;
	}
	public String getRefRange()
	{
		return this.refrange;
	}
	public void setRefRange(String value)
	{
		this.refrange = value;
	}
	public ims.vo.LookupInstanceBean getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.vo.LookupInstanceBean value)
	{
		this.unitofmeasure = value;
	}

	private Float value;
	private Boolean isabnormal;
	private ims.framework.utils.beans.DateTimeBean date;
	private ims.core.vo.beans.ChartValueCommentVoBean[] comments;
	private Boolean istimesuplied;
	private ims.core.vo.beans.ChartInvestigationCommentsVoBean investigationcomments;
	private ims.core.vo.beans.ChartSpecimenCommentsVoBean specimencomments;
	private ims.vo.LookupInstanceBean resultspecimentype;
	private ims.vo.LookupInstanceBean specimensource;
	private Boolean isreceiveddatetime;
	private String valuestring;
	private String refrange;
	private ims.vo.LookupInstanceBean unitofmeasure;
}
