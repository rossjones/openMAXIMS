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

package ims.clinical.vo;

/**
 * Linked to Assessment.Instantiation.PatientAssessment business object (ID: 1003100048).
 */
public class PatientAssessmentListVo extends ims.assessment.instantiation.vo.PatientAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentListVo()
	{
	}
	public PatientAssessmentListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAssessmentListVo(ims.clinical.vo.beans.PatientAssessmentListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.assessmentdata = bean.getAssessmentData() == null ? null : bean.getAssessmentData().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatus());
		this.statusreason = bean.getStatusReason() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatusReason());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientAssessmentListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.assessmentdata = bean.getAssessmentData() == null ? null : bean.getAssessmentData().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatus());
		this.statusreason = bean.getStatusReason() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatusReason());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientAssessmentListVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientAssessmentListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientAssessmentListVoBean();
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
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("ASSESSMENTDATA"))
			return getAssessmentData();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("STATUSREASON"))
			return getStatusReason();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactPatientAssessmentListVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactPatientAssessmentListVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextPatientAssessmentListVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextPatientAssessmentListVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.vo.EpisodeOfCarePatientAssessmentListVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.EpisodeOfCarePatientAssessmentListVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
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
	public boolean getAssessmentDataIsNotNull()
	{
		return this.assessmentdata != null;
	}
	public ims.assessment.vo.PatientAssessmentDataListVo getAssessmentData()
	{
		return this.assessmentdata;
	}
	public void setAssessmentData(ims.assessment.vo.PatientAssessmentDataListVo value)
	{
		this.isValidated = false;
		this.assessmentdata = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PatientAssessmentStatusReason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PatientAssessmentStatusReason value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getStatusReasonIsNotNull()
	{
		return this.statusreason != null;
	}
	public ims.core.vo.lookups.PatientAssessmentStatusReason getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(ims.core.vo.lookups.PatientAssessmentStatusReason value)
	{
		this.isValidated = false;
		this.statusreason = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
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
		if(this.assessmentdata == null)
			listOfErrors.add("AssessmentData is mandatory");
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
	
		PatientAssessmentListVo clone = new PatientAssessmentListVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactPatientAssessmentListVo)this.clinicalcontact.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextPatientAssessmentListVo)this.carecontext.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeOfCarePatientAssessmentListVo)this.episodeofcare.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.assessmentdata == null)
			clone.assessmentdata = null;
		else
			clone.assessmentdata = (ims.assessment.vo.PatientAssessmentDataListVo)this.assessmentdata.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PatientAssessmentStatusReason)this.status.clone();
		if(this.statusreason == null)
			clone.statusreason = null;
		else
			clone.statusreason = (ims.core.vo.lookups.PatientAssessmentStatusReason)this.statusreason.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
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
		if (!(PatientAssessmentListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientAssessmentListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientAssessmentListVo)obj).getBoId());
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
		if(this.episodeofcare != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.assessmentdata != null)
			count++;
		if(this.status != null)
			count++;
		if(this.statusreason != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.ClinicalContactPatientAssessmentListVo clinicalcontact;
	protected ims.core.vo.CareContextPatientAssessmentListVo carecontext;
	protected ims.core.vo.EpisodeOfCarePatientAssessmentListVo episodeofcare;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.assessment.vo.PatientAssessmentDataListVo assessmentdata;
	protected ims.core.vo.lookups.PatientAssessmentStatusReason status;
	protected ims.core.vo.lookups.PatientAssessmentStatusReason statusreason;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
