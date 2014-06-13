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

package ims.emergency.vo;

/**
 * Linked to emergency.Triage business object (ID: 1086100004).
 */
public class TriageForTriageProtocolAssessmentVo extends ims.emergency.vo.TriageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TriageForTriageProtocolAssessmentVo()
	{
	}
	public TriageForTriageProtocolAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public TriageForTriageProtocolAssessmentVo(ims.emergency.vo.beans.TriageForTriageProtocolAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo();
		this.currenttriageassessment = bean.getCurrentTriageAssessment() == null ? null : bean.getCurrentTriageAssessment().buildVo();
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
		this.currenttriagepathway = bean.getCurrentTriagePathway() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getCurrentTriagePathway().getId()), bean.getCurrentTriagePathway().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TriageForTriageProtocolAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo(map);
		this.currenttriageassessment = bean.getCurrentTriageAssessment() == null ? null : bean.getCurrentTriageAssessment().buildVo(map);
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
		this.currenttriagepathway = bean.getCurrentTriagePathway() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getCurrentTriagePathway().getId()), bean.getCurrentTriagePathway().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TriageForTriageProtocolAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TriageForTriageProtocolAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TriageForTriageProtocolAssessmentVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("MAINPRESENTINGPROBLEM"))
			return getMainPresentingProblem();
		if(fieldName.equals("CURRENTTRIAGEASSESSMENT"))
			return getCurrentTriageAssessment();
		if(fieldName.equals("CURRENTTRIAGEPRIORITY"))
			return getCurrentTriagePriority();
		if(fieldName.equals("CURRENTTRIAGEPATHWAY"))
			return getCurrentTriagePathway();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMainPresentingProblemIsNotNull()
	{
		return this.mainpresentingproblem != null;
	}
	public ims.core.vo.PatientProblemVo getMainPresentingProblem()
	{
		return this.mainpresentingproblem;
	}
	public void setMainPresentingProblem(ims.core.vo.PatientProblemVo value)
	{
		this.isValidated = false;
		this.mainpresentingproblem = value;
	}
	public boolean getCurrentTriageAssessmentIsNotNull()
	{
		return this.currenttriageassessment != null;
	}
	public ims.emergency.vo.TriageProtocolAssessmentVo getCurrentTriageAssessment()
	{
		return this.currenttriageassessment;
	}
	public void setCurrentTriageAssessment(ims.emergency.vo.TriageProtocolAssessmentVo value)
	{
		this.isValidated = false;
		this.currenttriageassessment = value;
	}
	public boolean getCurrentTriagePriorityIsNotNull()
	{
		return this.currenttriagepriority != null;
	}
	public ims.emergency.vo.lookups.TriagePriority getCurrentTriagePriority()
	{
		return this.currenttriagepriority;
	}
	public void setCurrentTriagePriority(ims.emergency.vo.lookups.TriagePriority value)
	{
		this.isValidated = false;
		this.currenttriagepriority = value;
	}
	public boolean getCurrentTriagePathwayIsNotNull()
	{
		return this.currenttriagepathway != null;
	}
	public ims.icps.instantiation.vo.PatientICPRefVo getCurrentTriagePathway()
	{
		return this.currenttriagepathway;
	}
	public void setCurrentTriagePathway(ims.icps.instantiation.vo.PatientICPRefVo value)
	{
		this.isValidated = false;
		this.currenttriagepathway = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.mainpresentingproblem != null)
		{
			if(!this.mainpresentingproblem.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currenttriageassessment != null)
		{
			if(!this.currenttriageassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.mainpresentingproblem != null)
		{
			String[] listOfOtherErrors = this.mainpresentingproblem.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currenttriageassessment != null)
		{
			String[] listOfOtherErrors = this.currenttriageassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		TriageForTriageProtocolAssessmentVo clone = new TriageForTriageProtocolAssessmentVo(this.id, this.version);
		
		if(this.mainpresentingproblem == null)
			clone.mainpresentingproblem = null;
		else
			clone.mainpresentingproblem = (ims.core.vo.PatientProblemVo)this.mainpresentingproblem.clone();
		if(this.currenttriageassessment == null)
			clone.currenttriageassessment = null;
		else
			clone.currenttriageassessment = (ims.emergency.vo.TriageProtocolAssessmentVo)this.currenttriageassessment.clone();
		if(this.currenttriagepriority == null)
			clone.currenttriagepriority = null;
		else
			clone.currenttriagepriority = (ims.emergency.vo.lookups.TriagePriority)this.currenttriagepriority.clone();
		clone.currenttriagepathway = this.currenttriagepathway;
		clone.episode = this.episode;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(TriageForTriageProtocolAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TriageForTriageProtocolAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TriageForTriageProtocolAssessmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TriageForTriageProtocolAssessmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.mainpresentingproblem != null)
			count++;
		if(this.currenttriageassessment != null)
			count++;
		if(this.currenttriagepriority != null)
			count++;
		if(this.currenttriagepathway != null)
			count++;
		if(this.episode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.PatientProblemVo mainpresentingproblem;
	protected ims.emergency.vo.TriageProtocolAssessmentVo currenttriageassessment;
	protected ims.emergency.vo.lookups.TriagePriority currenttriagepriority;
	protected ims.icps.instantiation.vo.PatientICPRefVo currenttriagepathway;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
