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

package ims.clinicaladmin.vo.beans;

public class OverallPrognosticGroupingVoBean extends ims.vo.ValueObjectBean
{
	public OverallPrognosticGroupingVoBean()
	{
	}
	public OverallPrognosticGroupingVoBean(ims.clinicaladmin.vo.OverallPrognosticGroupingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.prognosticgroup = vo.getPrognosticGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrognosticGroup().getBean();
		this.isactive = vo.getIsActive();
		this.tgroup = vo.getTGroup() == null ? null : new ims.vo.RefVoBean(vo.getTGroup().getBoId(), vo.getTGroup().getBoVersion());
		this.tsite = vo.getTSite() == null ? null : new ims.vo.RefVoBean(vo.getTSite().getBoId(), vo.getTSite().getBoVersion());
		this.tval = vo.getTVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getTVal().getBean();
		this.nval = vo.getNVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getNVal().getBean();
		this.mval = vo.getMVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getMVal().getBean();
		this.histval = vo.getHistVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean)vo.getHistVal().getBean();
		this.serummarkerval = vo.getSerumMarkerVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean)vo.getSerumMarkerVal().getBean();
		this.diffval = vo.getDiffVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)vo.getDiffVal().getBean();
		this.o45 = vo.getO45();
		this.prognosticlocationval = vo.getPrognosticLocationVal() == null ? null : (ims.oncology.vo.beans.PrognosticLocationConfigVoBean)vo.getPrognosticLocationVal().getBean();
		this.prognosticriskval = vo.getPrognosticRiskVal() == null ? null : (ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean)vo.getPrognosticRiskVal().getBean();
		this.prognosticpsaval = vo.getPrognosticPSAVal() == null ? null : (ims.clinicaladmin.vo.beans.PSAConfigVoBean)vo.getPrognosticPSAVal().getBean();
		this.prognosticgleasonval = vo.getPrognosticGleasonVal() == null ? null : (ims.clinicaladmin.vo.beans.GleasonConfigLiteVoBean)vo.getPrognosticGleasonVal().getBean();
		this.issaved = vo.getIsSaved();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.OverallPrognosticGroupingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.prognosticgroup = vo.getPrognosticGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrognosticGroup().getBean();
		this.isactive = vo.getIsActive();
		this.tgroup = vo.getTGroup() == null ? null : new ims.vo.RefVoBean(vo.getTGroup().getBoId(), vo.getTGroup().getBoVersion());
		this.tsite = vo.getTSite() == null ? null : new ims.vo.RefVoBean(vo.getTSite().getBoId(), vo.getTSite().getBoVersion());
		this.tval = vo.getTVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getTVal().getBean(map);
		this.nval = vo.getNVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getNVal().getBean(map);
		this.mval = vo.getMVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getMVal().getBean(map);
		this.histval = vo.getHistVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean)vo.getHistVal().getBean(map);
		this.serummarkerval = vo.getSerumMarkerVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean)vo.getSerumMarkerVal().getBean(map);
		this.diffval = vo.getDiffVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)vo.getDiffVal().getBean(map);
		this.o45 = vo.getO45();
		this.prognosticlocationval = vo.getPrognosticLocationVal() == null ? null : (ims.oncology.vo.beans.PrognosticLocationConfigVoBean)vo.getPrognosticLocationVal().getBean(map);
		this.prognosticriskval = vo.getPrognosticRiskVal() == null ? null : (ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean)vo.getPrognosticRiskVal().getBean(map);
		this.prognosticpsaval = vo.getPrognosticPSAVal() == null ? null : (ims.clinicaladmin.vo.beans.PSAConfigVoBean)vo.getPrognosticPSAVal().getBean(map);
		this.prognosticgleasonval = vo.getPrognosticGleasonVal() == null ? null : (ims.clinicaladmin.vo.beans.GleasonConfigLiteVoBean)vo.getPrognosticGleasonVal().getBean(map);
		this.issaved = vo.getIsSaved();
	}

	public ims.clinicaladmin.vo.OverallPrognosticGroupingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinicaladmin.vo.OverallPrognosticGroupingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.OverallPrognosticGroupingVo vo = null;
		if(map != null)
			vo = (ims.clinicaladmin.vo.OverallPrognosticGroupingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinicaladmin.vo.OverallPrognosticGroupingVo();
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
	public ims.vo.LookupInstanceBean getPrognosticGroup()
	{
		return this.prognosticgroup;
	}
	public void setPrognosticGroup(ims.vo.LookupInstanceBean value)
	{
		this.prognosticgroup = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.RefVoBean getTGroup()
	{
		return this.tgroup;
	}
	public void setTGroup(ims.vo.RefVoBean value)
	{
		this.tgroup = value;
	}
	public ims.vo.RefVoBean getTSite()
	{
		return this.tsite;
	}
	public void setTSite(ims.vo.RefVoBean value)
	{
		this.tsite = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean getTVal()
	{
		return this.tval;
	}
	public void setTVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean value)
	{
		this.tval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean getNVal()
	{
		return this.nval;
	}
	public void setNVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean value)
	{
		this.nval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean getMVal()
	{
		return this.mval;
	}
	public void setMVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean value)
	{
		this.mval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean getHistVal()
	{
		return this.histval;
	}
	public void setHistVal(ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean value)
	{
		this.histval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean getSerumMarkerVal()
	{
		return this.serummarkerval;
	}
	public void setSerumMarkerVal(ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean value)
	{
		this.serummarkerval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean getDiffVal()
	{
		return this.diffval;
	}
	public void setDiffVal(ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean value)
	{
		this.diffval = value;
	}
	public String getO45()
	{
		return this.o45;
	}
	public void setO45(String value)
	{
		this.o45 = value;
	}
	public ims.oncology.vo.beans.PrognosticLocationConfigVoBean getPrognosticLocationVal()
	{
		return this.prognosticlocationval;
	}
	public void setPrognosticLocationVal(ims.oncology.vo.beans.PrognosticLocationConfigVoBean value)
	{
		this.prognosticlocationval = value;
	}
	public ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean getPrognosticRiskVal()
	{
		return this.prognosticriskval;
	}
	public void setPrognosticRiskVal(ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean value)
	{
		this.prognosticriskval = value;
	}
	public ims.clinicaladmin.vo.beans.PSAConfigVoBean getPrognosticPSAVal()
	{
		return this.prognosticpsaval;
	}
	public void setPrognosticPSAVal(ims.clinicaladmin.vo.beans.PSAConfigVoBean value)
	{
		this.prognosticpsaval = value;
	}
	public ims.clinicaladmin.vo.beans.GleasonConfigLiteVoBean getPrognosticGleasonVal()
	{
		return this.prognosticgleasonval;
	}
	public void setPrognosticGleasonVal(ims.clinicaladmin.vo.beans.GleasonConfigLiteVoBean value)
	{
		this.prognosticgleasonval = value;
	}
	public Boolean getIsSaved()
	{
		return this.issaved;
	}
	public void setIsSaved(Boolean value)
	{
		this.issaved = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean prognosticgroup;
	private Boolean isactive;
	private ims.vo.RefVoBean tgroup;
	private ims.vo.RefVoBean tsite;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean tval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean nval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean mval;
	private ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean histval;
	private ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean serummarkerval;
	private ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean diffval;
	private String o45;
	private ims.oncology.vo.beans.PrognosticLocationConfigVoBean prognosticlocationval;
	private ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean prognosticriskval;
	private ims.clinicaladmin.vo.beans.PSAConfigVoBean prognosticpsaval;
	private ims.clinicaladmin.vo.beans.GleasonConfigLiteVoBean prognosticgleasonval;
	private Boolean issaved;
}
