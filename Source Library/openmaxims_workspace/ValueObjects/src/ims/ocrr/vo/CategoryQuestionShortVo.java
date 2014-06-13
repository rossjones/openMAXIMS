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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.CategoryQuestion business object (ID: 1061100011).
 */
public class CategoryQuestionShortVo extends ims.ocrr.configuration.vo.CategoryQuestionRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IQuestionType
{
	private static final long serialVersionUID = 1L;

	public CategoryQuestionShortVo()
	{
	}
	public CategoryQuestionShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public CategoryQuestionShortVo(ims.ocrr.vo.beans.CategoryQuestionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ismandatory = bean.getIsMandatory();
		this.askforinvestigations = bean.getAskForInvestigations();
		this.questioninformation = bean.getQuestionInformation() == null ? null : bean.getQuestionInformation().buildVo();
		this.ocrrcategory = bean.getOCRRCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getOCRRCategory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.CategoryQuestionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ismandatory = bean.getIsMandatory();
		this.askforinvestigations = bean.getAskForInvestigations();
		this.questioninformation = bean.getQuestionInformation() == null ? null : bean.getQuestionInformation().buildVo(map);
		this.ocrrcategory = bean.getOCRRCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getOCRRCategory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.CategoryQuestionShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.CategoryQuestionShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.CategoryQuestionShortVoBean();
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
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("ASKFORINVESTIGATIONS"))
			return getAskForInvestigations();
		if(fieldName.equals("QUESTIONINFORMATION"))
			return getQuestionInformation();
		if(fieldName.equals("OCRRCATEGORY"))
			return getOCRRCategory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsMandatoryIsNotNull()
	{
		return this.ismandatory != null;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.isValidated = false;
		this.ismandatory = value;
	}
	public boolean getAskForInvestigationsIsNotNull()
	{
		return this.askforinvestigations != null;
	}
	public Boolean getAskForInvestigations()
	{
		return this.askforinvestigations;
	}
	public void setAskForInvestigations(Boolean value)
	{
		this.isValidated = false;
		this.askforinvestigations = value;
	}
	public boolean getQuestionInformationIsNotNull()
	{
		return this.questioninformation != null;
	}
	public ims.core.vo.QuestionInformationShortVo getQuestionInformation()
	{
		return this.questioninformation;
	}
	public void setQuestionInformation(ims.core.vo.QuestionInformationShortVo value)
	{
		this.isValidated = false;
		this.questioninformation = value;
	}
	public boolean getOCRRCategoryIsNotNull()
	{
		return this.ocrrcategory != null;
	}
	public ims.ocrr.vo.lookups.Category getOCRRCategory()
	{
		return this.ocrrcategory;
	}
	public void setOCRRCategory(ims.ocrr.vo.lookups.Category value)
	{
		this.isValidated = false;
		this.ocrrcategory = value;
	}
	/**
	* IQuestionType Interface Methods
	*/
	public ims.core.vo.QuestionInformationShortVo getIQuestionTypeQuestion() 
	{
		return this.questioninformation;
	}
	public ims.ocrr.vo.lookups.OrderQuestionType getIQuestionTypeOrderQuestionType() 
	{
		return ims.ocrr.vo.lookups.OrderQuestionType.CATEGORY;
	}
	public Boolean getIQuestionTypeIsMandatory()
	{
		return getIsMandatory();
	}
	public String getIQuestionTypeItemName()
	{
		return "";
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
		if(this.questioninformation != null)
		{
			if(!this.questioninformation.isValidated())
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
		if(this.askforinvestigations == null)
			listOfErrors.add("askForInvestigations is mandatory");
		if(this.questioninformation == null)
			listOfErrors.add("QuestionInformation is mandatory");
		if(this.questioninformation != null)
		{
			String[] listOfOtherErrors = this.questioninformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ocrrcategory == null)
			listOfErrors.add("OCRRCategory is mandatory");
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
	
		CategoryQuestionShortVo clone = new CategoryQuestionShortVo(this.id, this.version);
		
		clone.ismandatory = this.ismandatory;
		clone.askforinvestigations = this.askforinvestigations;
		if(this.questioninformation == null)
			clone.questioninformation = null;
		else
			clone.questioninformation = (ims.core.vo.QuestionInformationShortVo)this.questioninformation.clone();
		if(this.ocrrcategory == null)
			clone.ocrrcategory = null;
		else
			clone.ocrrcategory = (ims.ocrr.vo.lookups.Category)this.ocrrcategory.clone();
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
		if (!(CategoryQuestionShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CategoryQuestionShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CategoryQuestionShortVo compareObj = (CategoryQuestionShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_CategoryQuestion() == null && compareObj.getID_CategoryQuestion() != null)
				return -1;
			if(this.getID_CategoryQuestion() != null && compareObj.getID_CategoryQuestion() == null)
				return 1;
			if(this.getID_CategoryQuestion() != null && compareObj.getID_CategoryQuestion() != null)
				retVal = this.getID_CategoryQuestion().compareTo(compareObj.getID_CategoryQuestion());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ismandatory != null)
			count++;
		if(this.askforinvestigations != null)
			count++;
		if(this.questioninformation != null)
			count++;
		if(this.ocrrcategory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected Boolean ismandatory;
	protected Boolean askforinvestigations;
	protected ims.core.vo.QuestionInformationShortVo questioninformation;
	protected ims.ocrr.vo.lookups.Category ocrrcategory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
