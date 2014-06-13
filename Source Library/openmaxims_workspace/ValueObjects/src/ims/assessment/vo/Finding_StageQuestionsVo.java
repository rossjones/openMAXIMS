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

package ims.assessment.vo;

/**
 * Linked to Assessment.Configuration.FindingStageQuestions business object (ID: 1083100002).
 */
public class Finding_StageQuestionsVo extends ims.assessment.configuration.vo.FindingStageQuestionsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Finding_StageQuestionsVo()
	{
	}
	public Finding_StageQuestionsVo(Integer id, int version)
	{
		super(id, version);
	}
	public Finding_StageQuestionsVo(ims.assessment.vo.beans.Finding_StageQuestionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentstage = bean.getAssessmentStage() == null ? null : bean.getAssessmentStage().buildVo();
		this.associatedquestions = ims.assessment.vo.Graphic_AssessmentFindingQuestionVoCollection.buildFromBeanCollection(bean.getAssociatedQuestions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.Finding_StageQuestionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentstage = bean.getAssessmentStage() == null ? null : bean.getAssessmentStage().buildVo(map);
		this.associatedquestions = ims.assessment.vo.Graphic_AssessmentFindingQuestionVoCollection.buildFromBeanCollection(bean.getAssociatedQuestions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.Finding_StageQuestionsVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.Finding_StageQuestionsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.Finding_StageQuestionsVoBean();
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
		if(fieldName.equals("ASSESSMENTSTAGE"))
			return getAssessmentStage();
		if(fieldName.equals("ASSOCIATEDQUESTIONS"))
			return getAssociatedQuestions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssessmentStageIsNotNull()
	{
		return this.assessmentstage != null;
	}
	public ims.assessment.vo.Graphic_AssessmentStageVo getAssessmentStage()
	{
		return this.assessmentstage;
	}
	public void setAssessmentStage(ims.assessment.vo.Graphic_AssessmentStageVo value)
	{
		this.isValidated = false;
		this.assessmentstage = value;
	}
	public boolean getAssociatedQuestionsIsNotNull()
	{
		return this.associatedquestions != null;
	}
	public ims.assessment.vo.Graphic_AssessmentFindingQuestionVoCollection getAssociatedQuestions()
	{
		return this.associatedquestions;
	}
	public void setAssociatedQuestions(ims.assessment.vo.Graphic_AssessmentFindingQuestionVoCollection value)
	{
		this.isValidated = false;
		this.associatedquestions = value;
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
		if(this.assessmentstage != null)
		{
			if(!this.assessmentstage.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.associatedquestions != null)
		{
			if(!this.associatedquestions.isValidated())
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
		if(this.assessmentstage == null)
			listOfErrors.add("AssessmentStage is mandatory");
		if(this.assessmentstage != null)
		{
			String[] listOfOtherErrors = this.assessmentstage.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.associatedquestions != null)
		{
			String[] listOfOtherErrors = this.associatedquestions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		Finding_StageQuestionsVo clone = new Finding_StageQuestionsVo(this.id, this.version);
		
		if(this.assessmentstage == null)
			clone.assessmentstage = null;
		else
			clone.assessmentstage = (ims.assessment.vo.Graphic_AssessmentStageVo)this.assessmentstage.clone();
		if(this.associatedquestions == null)
			clone.associatedquestions = null;
		else
			clone.associatedquestions = (ims.assessment.vo.Graphic_AssessmentFindingQuestionVoCollection)this.associatedquestions.clone();
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
		if (!(Finding_StageQuestionsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Finding_StageQuestionsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Finding_StageQuestionsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Finding_StageQuestionsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.assessmentstage != null)
			count++;
		if(this.associatedquestions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.assessment.vo.Graphic_AssessmentStageVo assessmentstage;
	protected ims.assessment.vo.Graphic_AssessmentFindingQuestionVoCollection associatedquestions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
