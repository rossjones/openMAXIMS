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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.StrengtheningProgram business object (ID: 1019100052).
 */
public class StrengtheningProgramVo extends ims.therapies.treatment.vo.StrengtheningProgramRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public StrengtheningProgramVo()
	{
	}
	public StrengtheningProgramVo(Integer id, int version)
	{
		super(id, version);
	}
	public StrengtheningProgramVo(ims.therapies.vo.beans.StrengtheningProgramVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.comment = bean.getComment();
		this.excercise = ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection.buildFromBeanCollection(bean.getExcercise());
		this.limbweight = ims.therapies.vo.StrengtheningProgramLimbWeightVoCollection.buildFromBeanCollection(bean.getLimbWeight());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.StrengtheningProgramVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.comment = bean.getComment();
		this.excercise = ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection.buildFromBeanCollection(bean.getExcercise());
		this.limbweight = ims.therapies.vo.StrengtheningProgramLimbWeightVoCollection.buildFromBeanCollection(bean.getLimbWeight());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.StrengtheningProgramVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.StrengtheningProgramVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.StrengtheningProgramVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("EXCERCISE"))
			return getExcercise();
		if(fieldName.equals("LIMBWEIGHT"))
			return getLimbWeight();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 1000;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getExcerciseIsNotNull()
	{
		return this.excercise != null;
	}
	public ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection getExcercise()
	{
		return this.excercise;
	}
	public void setExcercise(ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection value)
	{
		this.isValidated = false;
		this.excercise = value;
	}
	public boolean getLimbWeightIsNotNull()
	{
		return this.limbweight != null;
	}
	public ims.therapies.vo.StrengtheningProgramLimbWeightVoCollection getLimbWeight()
	{
		return this.limbweight;
	}
	public void setLimbWeight(ims.therapies.vo.StrengtheningProgramLimbWeightVoCollection value)
	{
		this.isValidated = false;
		this.limbweight = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.limbweight != null)
		{
			if(!this.limbweight.isValidated())
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.comment != null)
			if(this.comment.length() > 1000)
				listOfErrors.add("The length of the field [comment] in the value object [ims.therapies.vo.StrengtheningProgramVo] is too big. It should be less or equal to 1000");
		if(this.limbweight != null)
		{
			String[] listOfOtherErrors = this.limbweight.validate();
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
	
		StrengtheningProgramVo clone = new StrengtheningProgramVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.comment = this.comment;
		if(this.excercise == null)
			clone.excercise = null;
		else
			clone.excercise = (ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection)this.excercise.clone();
		if(this.limbweight == null)
			clone.limbweight = null;
		else
			clone.limbweight = (ims.therapies.vo.StrengtheningProgramLimbWeightVoCollection)this.limbweight.clone();
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
		if (!(StrengtheningProgramVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A StrengtheningProgramVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((StrengtheningProgramVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((StrengtheningProgramVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.excercise != null)
			count++;
		if(this.limbweight != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected String comment;
	protected ims.spinalinjuries.vo.lookups.StrengtheningProgramExerciseCollection excercise;
	protected ims.therapies.vo.StrengtheningProgramLimbWeightVoCollection limbweight;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
