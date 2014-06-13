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

public class TumourGroupListForPrimaryTumourDetailsVoBean extends ims.vo.ValueObjectBean
{
	public TumourGroupListForPrimaryTumourDetailsVoBean()
	{
	}
	public TumourGroupListForPrimaryTumourDetailsVoBean(ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.groupname = vo.getGroupName();
		this.sites = vo.getSites() == null ? null : vo.getSites().getBeanCollection();
		this.tnmrequiresover45 = vo.getTnmRequiresOver45();
		this.isactive = vo.getIsActive();
		this.tnmvalues = vo.getTNMValues() == null ? null : vo.getTNMValues().getBeanCollection();
		this.serummarkers = vo.getSerumMarkers() == null ? null : vo.getSerumMarkers().getBeanCollection();
		this.otherclassifications = vo.getOtherClassifications() == null ? null : vo.getOtherClassifications().getBeanCollection();
		this.associatedspecialties = vo.getAssociatedSpecialties() == null ? null : vo.getAssociatedSpecialties().getBeanCollection();
		this.hastnm = vo.getHasTNM();
		this.histologies = vo.getHistologies() == null ? null : vo.getHistologies().getBeanCollection();
		this.histopathologicgrades = vo.getHistopathologicGrades() == null ? null : vo.getHistopathologicGrades().getBeanCollection();
		this.assessment = vo.getAssessment() == null ? null : new ims.vo.RefVoBean(vo.getAssessment().getBoId(), vo.getAssessment().getBoVersion());
		this.isprognosticgroupingrelevant = vo.getIsPrognosticGroupingRelevant();
		this.prognosticgroupingconfig = vo.getPrognosticGroupingConfig() == null ? null : (ims.clinicaladmin.vo.beans.PrognosticGroupingCongfigVoBean)vo.getPrognosticGroupingConfig().getBean();
		this.tnmrequiresdiff = vo.getTnmRequiresDiff();
		this.tnmrequireshisto = vo.getTnmRequiresHisto();
		this.tnmrequiressmarkers = vo.getTnmRequiresSMarkers();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.groupname = vo.getGroupName();
		this.sites = vo.getSites() == null ? null : vo.getSites().getBeanCollection();
		this.tnmrequiresover45 = vo.getTnmRequiresOver45();
		this.isactive = vo.getIsActive();
		this.tnmvalues = vo.getTNMValues() == null ? null : vo.getTNMValues().getBeanCollection();
		this.serummarkers = vo.getSerumMarkers() == null ? null : vo.getSerumMarkers().getBeanCollection();
		this.otherclassifications = vo.getOtherClassifications() == null ? null : vo.getOtherClassifications().getBeanCollection();
		this.associatedspecialties = vo.getAssociatedSpecialties() == null ? null : vo.getAssociatedSpecialties().getBeanCollection();
		this.hastnm = vo.getHasTNM();
		this.histologies = vo.getHistologies() == null ? null : vo.getHistologies().getBeanCollection();
		this.histopathologicgrades = vo.getHistopathologicGrades() == null ? null : vo.getHistopathologicGrades().getBeanCollection();
		this.assessment = vo.getAssessment() == null ? null : new ims.vo.RefVoBean(vo.getAssessment().getBoId(), vo.getAssessment().getBoVersion());
		this.isprognosticgroupingrelevant = vo.getIsPrognosticGroupingRelevant();
		this.prognosticgroupingconfig = vo.getPrognosticGroupingConfig() == null ? null : (ims.clinicaladmin.vo.beans.PrognosticGroupingCongfigVoBean)vo.getPrognosticGroupingConfig().getBean(map);
		this.tnmrequiresdiff = vo.getTnmRequiresDiff();
		this.tnmrequireshisto = vo.getTnmRequiresHisto();
		this.tnmrequiressmarkers = vo.getTnmRequiresSMarkers();
	}

	public ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinicaladmin.vo.TumourGroupListForPrimaryTumourDetailsVo();
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
	public String getGroupName()
	{
		return this.groupname;
	}
	public void setGroupName(String value)
	{
		this.groupname = value;
	}
	public ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean[] getSites()
	{
		return this.sites;
	}
	public void setSites(ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean[] value)
	{
		this.sites = value;
	}
	public Boolean getTnmRequiresOver45()
	{
		return this.tnmrequiresover45;
	}
	public void setTnmRequiresOver45(Boolean value)
	{
		this.tnmrequiresover45 = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean[] getTNMValues()
	{
		return this.tnmvalues;
	}
	public void setTNMValues(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean[] value)
	{
		this.tnmvalues = value;
	}
	public ims.clinicaladmin.vo.beans.TumourSerumMarkersVoBean[] getSerumMarkers()
	{
		return this.serummarkers;
	}
	public void setSerumMarkers(ims.clinicaladmin.vo.beans.TumourSerumMarkersVoBean[] value)
	{
		this.serummarkers = value;
	}
	public ims.oncology.vo.beans.TumourGroupClassificationVoBean[] getOtherClassifications()
	{
		return this.otherclassifications;
	}
	public void setOtherClassifications(ims.oncology.vo.beans.TumourGroupClassificationVoBean[] value)
	{
		this.otherclassifications = value;
	}
	public ims.oncology.vo.beans.TumourGroupSpecialtyVoBean[] getAssociatedSpecialties()
	{
		return this.associatedspecialties;
	}
	public void setAssociatedSpecialties(ims.oncology.vo.beans.TumourGroupSpecialtyVoBean[] value)
	{
		this.associatedspecialties = value;
	}
	public Boolean getHasTNM()
	{
		return this.hastnm;
	}
	public void setHasTNM(Boolean value)
	{
		this.hastnm = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean[] getHistologies()
	{
		return this.histologies;
	}
	public void setHistologies(ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean[] value)
	{
		this.histologies = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean[] getHistopathologicGrades()
	{
		return this.histopathologicgrades;
	}
	public void setHistopathologicGrades(ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean[] value)
	{
		this.histopathologicgrades = value;
	}
	public ims.vo.RefVoBean getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(ims.vo.RefVoBean value)
	{
		this.assessment = value;
	}
	public Boolean getIsPrognosticGroupingRelevant()
	{
		return this.isprognosticgroupingrelevant;
	}
	public void setIsPrognosticGroupingRelevant(Boolean value)
	{
		this.isprognosticgroupingrelevant = value;
	}
	public ims.clinicaladmin.vo.beans.PrognosticGroupingCongfigVoBean getPrognosticGroupingConfig()
	{
		return this.prognosticgroupingconfig;
	}
	public void setPrognosticGroupingConfig(ims.clinicaladmin.vo.beans.PrognosticGroupingCongfigVoBean value)
	{
		this.prognosticgroupingconfig = value;
	}
	public Boolean getTnmRequiresDiff()
	{
		return this.tnmrequiresdiff;
	}
	public void setTnmRequiresDiff(Boolean value)
	{
		this.tnmrequiresdiff = value;
	}
	public Boolean getTnmRequiresHisto()
	{
		return this.tnmrequireshisto;
	}
	public void setTnmRequiresHisto(Boolean value)
	{
		this.tnmrequireshisto = value;
	}
	public Boolean getTnmRequiresSMarkers()
	{
		return this.tnmrequiressmarkers;
	}
	public void setTnmRequiresSMarkers(Boolean value)
	{
		this.tnmrequiressmarkers = value;
	}

	private Integer id;
	private int version;
	private String groupname;
	private ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean[] sites;
	private Boolean tnmrequiresover45;
	private Boolean isactive;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean[] tnmvalues;
	private ims.clinicaladmin.vo.beans.TumourSerumMarkersVoBean[] serummarkers;
	private ims.oncology.vo.beans.TumourGroupClassificationVoBean[] otherclassifications;
	private ims.oncology.vo.beans.TumourGroupSpecialtyVoBean[] associatedspecialties;
	private Boolean hastnm;
	private ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean[] histologies;
	private ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean[] histopathologicgrades;
	private ims.vo.RefVoBean assessment;
	private Boolean isprognosticgroupingrelevant;
	private ims.clinicaladmin.vo.beans.PrognosticGroupingCongfigVoBean prognosticgroupingconfig;
	private Boolean tnmrequiresdiff;
	private Boolean tnmrequireshisto;
	private Boolean tnmrequiressmarkers;
}
