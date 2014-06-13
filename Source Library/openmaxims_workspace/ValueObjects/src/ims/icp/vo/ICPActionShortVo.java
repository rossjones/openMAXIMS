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

package ims.icp.vo;

/**
 * Linked to ICPs.Configuration.ICPAction business object (ID: 1060100008).
 */
public class ICPActionShortVo extends ims.icp.vo.ICPActionLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPActionShortVo()
	{
	}
	public ICPActionShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPActionShortVo(ims.icp.vo.beans.ICPActionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.discipline = ims.core.vo.lookups.HcpDisTypeCollection.buildFromBeanCollection(bean.getDiscipline());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.ismandatory = bean.getIsMandatory();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.helpurl = bean.getHelpURL();
		this.linkedtype = bean.getLinkedType() == null ? null : ims.core.vo.lookups.ICPCompLinkedType.buildLookup(bean.getLinkedType());
		this.haslinkedactions = bean.getHasLinkedActions();
		this.linkedform = bean.getLinkedForm() == null ? null : bean.getLinkedForm().buildVo();
		this.linkedassessment = bean.getLinkedAssessment() == null ? null : bean.getLinkedAssessment().buildVo();
		this.linkedgraphicassessment = bean.getLinkedGraphicAssessment() == null ? null : bean.getLinkedGraphicAssessment().buildVo();
		this.linkedorderentrytemplate = bean.getLinkedOrderEntryTemplate() == null ? null : bean.getLinkedOrderEntryTemplate().buildVo();
		this.requirescountersignature = bean.getRequiresCounterSignature();
		if(bean.getClinicalDetailActions() != null)
		{
			this.clinicaldetailactions = new ims.icps.configuration.vo.ICPActionRefVoCollection();
			for(int clinicaldetailactions_i = 0; clinicaldetailactions_i < bean.getClinicalDetailActions().length; clinicaldetailactions_i++)
			{
				this.clinicaldetailactions.add(new ims.icps.configuration.vo.ICPActionRefVo(new Integer(bean.getClinicalDetailActions()[clinicaldetailactions_i].getId()), bean.getClinicalDetailActions()[clinicaldetailactions_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPActionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.discipline = ims.core.vo.lookups.HcpDisTypeCollection.buildFromBeanCollection(bean.getDiscipline());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.ismandatory = bean.getIsMandatory();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.helpurl = bean.getHelpURL();
		this.linkedtype = bean.getLinkedType() == null ? null : ims.core.vo.lookups.ICPCompLinkedType.buildLookup(bean.getLinkedType());
		this.haslinkedactions = bean.getHasLinkedActions();
		this.linkedform = bean.getLinkedForm() == null ? null : bean.getLinkedForm().buildVo(map);
		this.linkedassessment = bean.getLinkedAssessment() == null ? null : bean.getLinkedAssessment().buildVo(map);
		this.linkedgraphicassessment = bean.getLinkedGraphicAssessment() == null ? null : bean.getLinkedGraphicAssessment().buildVo(map);
		this.linkedorderentrytemplate = bean.getLinkedOrderEntryTemplate() == null ? null : bean.getLinkedOrderEntryTemplate().buildVo(map);
		this.requirescountersignature = bean.getRequiresCounterSignature();
		if(bean.getClinicalDetailActions() != null)
		{
			this.clinicaldetailactions = new ims.icps.configuration.vo.ICPActionRefVoCollection();
			for(int clinicaldetailactions_i = 0; clinicaldetailactions_i < bean.getClinicalDetailActions().length; clinicaldetailactions_i++)
			{
				this.clinicaldetailactions.add(new ims.icps.configuration.vo.ICPActionRefVo(new Integer(bean.getClinicalDetailActions()[clinicaldetailactions_i].getId()), bean.getClinicalDetailActions()[clinicaldetailactions_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPActionShortVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPActionShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPActionShortVoBean();
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
		if(fieldName.equals("LINKEDFORM"))
			return getLinkedForm();
		if(fieldName.equals("LINKEDASSESSMENT"))
			return getLinkedAssessment();
		if(fieldName.equals("LINKEDGRAPHICASSESSMENT"))
			return getLinkedGraphicAssessment();
		if(fieldName.equals("LINKEDORDERENTRYTEMPLATE"))
			return getLinkedOrderEntryTemplate();
		if(fieldName.equals("REQUIRESCOUNTERSIGNATURE"))
			return getRequiresCounterSignature();
		if(fieldName.equals("CLINICALDETAILACTIONS"))
			return getClinicalDetailActions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLinkedFormIsNotNull()
	{
		return this.linkedform != null;
	}
	public ims.core.vo.AppFormLiteVo getLinkedForm()
	{
		return this.linkedform;
	}
	public void setLinkedForm(ims.core.vo.AppFormLiteVo value)
	{
		this.isValidated = false;
		this.linkedform = value;
	}
	public boolean getLinkedAssessmentIsNotNull()
	{
		return this.linkedassessment != null;
	}
	public ims.assessment.vo.UserAssessmentLiteVo getLinkedAssessment()
	{
		return this.linkedassessment;
	}
	public void setLinkedAssessment(ims.assessment.vo.UserAssessmentLiteVo value)
	{
		this.isValidated = false;
		this.linkedassessment = value;
	}
	public boolean getLinkedGraphicAssessmentIsNotNull()
	{
		return this.linkedgraphicassessment != null;
	}
	public ims.assessment.vo.GraphicAssessmentLiteVo getLinkedGraphicAssessment()
	{
		return this.linkedgraphicassessment;
	}
	public void setLinkedGraphicAssessment(ims.assessment.vo.GraphicAssessmentLiteVo value)
	{
		this.isValidated = false;
		this.linkedgraphicassessment = value;
	}
	public boolean getLinkedOrderEntryTemplateIsNotNull()
	{
		return this.linkedorderentrytemplate != null;
	}
	public ims.ocrr.vo.OrderEntryTemplateLiteVo getLinkedOrderEntryTemplate()
	{
		return this.linkedorderentrytemplate;
	}
	public void setLinkedOrderEntryTemplate(ims.ocrr.vo.OrderEntryTemplateLiteVo value)
	{
		this.isValidated = false;
		this.linkedorderentrytemplate = value;
	}
	public boolean getRequiresCounterSignatureIsNotNull()
	{
		return this.requirescountersignature != null;
	}
	public Boolean getRequiresCounterSignature()
	{
		return this.requirescountersignature;
	}
	public void setRequiresCounterSignature(Boolean value)
	{
		this.isValidated = false;
		this.requirescountersignature = value;
	}
	public boolean getClinicalDetailActionsIsNotNull()
	{
		return this.clinicaldetailactions != null;
	}
	public ims.icps.configuration.vo.ICPActionRefVoCollection getClinicalDetailActions()
	{
		return this.clinicaldetailactions;
	}
	public void setClinicalDetailActions(ims.icps.configuration.vo.ICPActionRefVoCollection value)
	{
		this.isValidated = false;
		this.clinicaldetailactions = value;
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
		if(this.linkedform != null)
		{
			if(!this.linkedform.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.linkedassessment != null)
		{
			if(!this.linkedassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.linkedgraphicassessment != null)
		{
			if(!this.linkedgraphicassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.linkedorderentrytemplate != null)
		{
			if(!this.linkedorderentrytemplate.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPActionShortVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.icp.vo.ICPActionShortVo] is too big. It should be less or equal to 255");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.discipline == null || this.discipline.size() == 0)
			listOfErrors.add("At least one discipline must be recorded.");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 255)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.icp.vo.ICPActionShortVo] is too big. It should be less or equal to 255");
		if(this.linkedtype == null)
			listOfErrors.add("LinkedType is mandatory");
		if(this.linkedform != null)
		{
			String[] listOfOtherErrors = this.linkedform.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.linkedassessment != null)
		{
			String[] listOfOtherErrors = this.linkedassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.linkedgraphicassessment != null)
		{
			String[] listOfOtherErrors = this.linkedgraphicassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.linkedorderentrytemplate != null)
		{
			String[] listOfOtherErrors = this.linkedorderentrytemplate.validate();
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
	
		ICPActionShortVo clone = new ICPActionShortVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		clone.sequence = this.sequence;
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.lookups.HcpDisTypeCollection)this.discipline.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.ismandatory = this.ismandatory;
		clone.isactivatedoninitiation = this.isactivatedoninitiation;
		clone.helpurl = this.helpurl;
		if(this.linkedtype == null)
			clone.linkedtype = null;
		else
			clone.linkedtype = (ims.core.vo.lookups.ICPCompLinkedType)this.linkedtype.clone();
		clone.haslinkedactions = this.haslinkedactions;
		if(this.linkedform == null)
			clone.linkedform = null;
		else
			clone.linkedform = (ims.core.vo.AppFormLiteVo)this.linkedform.clone();
		if(this.linkedassessment == null)
			clone.linkedassessment = null;
		else
			clone.linkedassessment = (ims.assessment.vo.UserAssessmentLiteVo)this.linkedassessment.clone();
		if(this.linkedgraphicassessment == null)
			clone.linkedgraphicassessment = null;
		else
			clone.linkedgraphicassessment = (ims.assessment.vo.GraphicAssessmentLiteVo)this.linkedgraphicassessment.clone();
		if(this.linkedorderentrytemplate == null)
			clone.linkedorderentrytemplate = null;
		else
			clone.linkedorderentrytemplate = (ims.ocrr.vo.OrderEntryTemplateLiteVo)this.linkedorderentrytemplate.clone();
		clone.requirescountersignature = this.requirescountersignature;
		clone.clinicaldetailactions = this.clinicaldetailactions;
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
		if (!(ICPActionShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPActionShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICPActionShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICPActionShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.linkedform != null)
			count++;
		if(this.linkedassessment != null)
			count++;
		if(this.linkedgraphicassessment != null)
			count++;
		if(this.linkedorderentrytemplate != null)
			count++;
		if(this.requirescountersignature != null)
			count++;
		if(this.clinicaldetailactions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.core.vo.AppFormLiteVo linkedform;
	protected ims.assessment.vo.UserAssessmentLiteVo linkedassessment;
	protected ims.assessment.vo.GraphicAssessmentLiteVo linkedgraphicassessment;
	protected ims.ocrr.vo.OrderEntryTemplateLiteVo linkedorderentrytemplate;
	protected Boolean requirescountersignature;
	protected ims.icps.configuration.vo.ICPActionRefVoCollection clinicaldetailactions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
