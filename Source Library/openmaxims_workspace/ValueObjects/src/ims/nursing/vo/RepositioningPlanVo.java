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

package ims.nursing.vo;

/**
 * Linked to nursing.RepositioningPlan business object (ID: 1009100006).
 */
public class RepositioningPlanVo extends ims.nursing.vo.RepositioningPlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RepositioningPlanVo()
	{
	}
	public RepositioningPlanVo(Integer id, int version)
	{
		super(id, version);
	}
	public RepositioningPlanVo(ims.nursing.vo.beans.RepositioningPlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.positioningfreq = bean.getPositioningFreq() == null ? null : ims.nursing.vo.lookups.TurnsDuration.buildLookup(bean.getPositioningFreq());
		this.position = ims.core.vo.lookups.PatientPositionCollection.buildFromBeanCollection(bean.getPosition());
		this.skintolerancetest = bean.getSkinToleranceTest() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinToleranceTest());
		this.blanching = bean.getBlanching() == null ? null : ims.nursing.vo.lookups.Blanching.buildLookup(bean.getBlanching());
		this.positioningsuitable = bean.getPositioningSuitable() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getPositioningSuitable());
		this.comment = bean.getComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.RepositioningPlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.positioningfreq = bean.getPositioningFreq() == null ? null : ims.nursing.vo.lookups.TurnsDuration.buildLookup(bean.getPositioningFreq());
		this.position = ims.core.vo.lookups.PatientPositionCollection.buildFromBeanCollection(bean.getPosition());
		this.skintolerancetest = bean.getSkinToleranceTest() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinToleranceTest());
		this.blanching = bean.getBlanching() == null ? null : ims.nursing.vo.lookups.Blanching.buildLookup(bean.getBlanching());
		this.positioningsuitable = bean.getPositioningSuitable() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getPositioningSuitable());
		this.comment = bean.getComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.RepositioningPlanVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.RepositioningPlanVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.RepositioningPlanVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("POSITIONINGFREQ"))
			return getPositioningFreq();
		if(fieldName.equals("POSITION"))
			return getPosition();
		if(fieldName.equals("SKINTOLERANCETEST"))
			return getSkinToleranceTest();
		if(fieldName.equals("BLANCHING"))
			return getBlanching();
		if(fieldName.equals("POSITIONINGSUITABLE"))
			return getPositioningSuitable();
		if(fieldName.equals("COMMENT"))
			return getComment();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
	public boolean getPositioningFreqIsNotNull()
	{
		return this.positioningfreq != null;
	}
	public ims.nursing.vo.lookups.TurnsDuration getPositioningFreq()
	{
		return this.positioningfreq;
	}
	public void setPositioningFreq(ims.nursing.vo.lookups.TurnsDuration value)
	{
		this.isValidated = false;
		this.positioningfreq = value;
	}
	public boolean getPositionIsNotNull()
	{
		return this.position != null;
	}
	public ims.core.vo.lookups.PatientPositionCollection getPosition()
	{
		return this.position;
	}
	public void setPosition(ims.core.vo.lookups.PatientPositionCollection value)
	{
		this.isValidated = false;
		this.position = value;
	}
	public boolean getSkinToleranceTestIsNotNull()
	{
		return this.skintolerancetest != null;
	}
	public ims.core.vo.lookups.YesNo getSkinToleranceTest()
	{
		return this.skintolerancetest;
	}
	public void setSkinToleranceTest(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.skintolerancetest = value;
	}
	public boolean getBlanchingIsNotNull()
	{
		return this.blanching != null;
	}
	public ims.nursing.vo.lookups.Blanching getBlanching()
	{
		return this.blanching;
	}
	public void setBlanching(ims.nursing.vo.lookups.Blanching value)
	{
		this.isValidated = false;
		this.blanching = value;
	}
	public boolean getPositioningSuitableIsNotNull()
	{
		return this.positioningsuitable != null;
	}
	public ims.core.vo.lookups.YesNo getPositioningSuitable()
	{
		return this.positioningsuitable;
	}
	public void setPositioningSuitable(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.positioningsuitable = value;
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
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("Both 'Authoring HCP' and 'Authoring Date/Time' are mandatory");
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
		if(this.positioningfreq == null)
			listOfErrors.add("'Frequency of repositioning' is mandatory");
		if(this.position == null || this.position.size() == 0)
			listOfErrors.add("'Sides that can be used to turn patient onto' are mandatory");
		if(this.positioningsuitable == null)
			listOfErrors.add("'Frequency of repositioning suitable' is mandatory");
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.nursing.vo.RepositioningPlanVo] is too big. It should be less or equal to 255");
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
	
		RepositioningPlanVo clone = new RepositioningPlanVo(this.id, this.version);
		
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.positioningfreq == null)
			clone.positioningfreq = null;
		else
			clone.positioningfreq = (ims.nursing.vo.lookups.TurnsDuration)this.positioningfreq.clone();
		if(this.position == null)
			clone.position = null;
		else
			clone.position = (ims.core.vo.lookups.PatientPositionCollection)this.position.clone();
		if(this.skintolerancetest == null)
			clone.skintolerancetest = null;
		else
			clone.skintolerancetest = (ims.core.vo.lookups.YesNo)this.skintolerancetest.clone();
		if(this.blanching == null)
			clone.blanching = null;
		else
			clone.blanching = (ims.nursing.vo.lookups.Blanching)this.blanching.clone();
		if(this.positioningsuitable == null)
			clone.positioningsuitable = null;
		else
			clone.positioningsuitable = (ims.core.vo.lookups.YesNo)this.positioningsuitable.clone();
		clone.comment = this.comment;
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
		if (!(RepositioningPlanVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RepositioningPlanVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RepositioningPlanVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RepositioningPlanVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.positioningfreq != null)
			count++;
		if(this.position != null)
			count++;
		if(this.skintolerancetest != null)
			count++;
		if(this.blanching != null)
			count++;
		if(this.positioningsuitable != null)
			count++;
		if(this.comment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.nursing.vo.lookups.TurnsDuration positioningfreq;
	protected ims.core.vo.lookups.PatientPositionCollection position;
	protected ims.core.vo.lookups.YesNo skintolerancetest;
	protected ims.nursing.vo.lookups.Blanching blanching;
	protected ims.core.vo.lookups.YesNo positioningsuitable;
	protected String comment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
