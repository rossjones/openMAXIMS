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
 * Linked to core.clinical.ClinicalAdmission business object (ID: 1009100020).
 */
public class ClinicalAdmissionVo extends ims.nursing.vo.ClinicalAdmissionListVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalAdmissionVo()
	{
	}
	public ClinicalAdmissionVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalAdmissionVo(ims.nursing.vo.beans.ClinicalAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admittingnurse = bean.getAdmittingNurse() == null ? null : bean.getAdmittingNurse().buildVo();
		this.dischargeddatetime = bean.getDischargedDateTime() == null ? null : bean.getDischargedDateTime().buildDateTime();
		this.dischargedby = bean.getDischargedBy() == null ? null : bean.getDischargedBy().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.clientunderstanding = bean.getClientUnderstanding();
		this.socialcircumstance = bean.getSocialCircumstance();
		this.admissionchecklist = ims.nursing.vo.AdmissionChecklistVoCollection.buildFromBeanCollection(bean.getAdmissionChecklist());
		this.confirmeddatetime = bean.getConfirmedDateTime() == null ? null : bean.getConfirmedDateTime().buildDateTime();
		this.confirmedby = bean.getConfirmedBy() == null ? null : bean.getConfirmedBy().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.ClinicalAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admittingnurse = bean.getAdmittingNurse() == null ? null : bean.getAdmittingNurse().buildVo(map);
		this.dischargeddatetime = bean.getDischargedDateTime() == null ? null : bean.getDischargedDateTime().buildDateTime();
		this.dischargedby = bean.getDischargedBy() == null ? null : bean.getDischargedBy().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.clientunderstanding = bean.getClientUnderstanding();
		this.socialcircumstance = bean.getSocialCircumstance();
		this.admissionchecklist = ims.nursing.vo.AdmissionChecklistVoCollection.buildFromBeanCollection(bean.getAdmissionChecklist());
		this.confirmeddatetime = bean.getConfirmedDateTime() == null ? null : bean.getConfirmedDateTime().buildDateTime();
		this.confirmedby = bean.getConfirmedBy() == null ? null : bean.getConfirmedBy().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.ClinicalAdmissionVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.ClinicalAdmissionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.ClinicalAdmissionVoBean();
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
		if(fieldName.equals("CLIENTUNDERSTANDING"))
			return getClientUnderstanding();
		if(fieldName.equals("SOCIALCIRCUMSTANCE"))
			return getSocialCircumstance();
		if(fieldName.equals("ADMISSIONCHECKLIST"))
			return getAdmissionChecklist();
		if(fieldName.equals("CONFIRMEDDATETIME"))
			return getConfirmedDateTime();
		if(fieldName.equals("CONFIRMEDBY"))
			return getConfirmedBy();
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
	public boolean getClientUnderstandingIsNotNull()
	{
		return this.clientunderstanding != null;
	}
	public String getClientUnderstanding()
	{
		return this.clientunderstanding;
	}
	public static int getClientUnderstandingMaxLength()
	{
		return 1000;
	}
	public void setClientUnderstanding(String value)
	{
		this.isValidated = false;
		this.clientunderstanding = value;
	}
	public boolean getSocialCircumstanceIsNotNull()
	{
		return this.socialcircumstance != null;
	}
	public String getSocialCircumstance()
	{
		return this.socialcircumstance;
	}
	public static int getSocialCircumstanceMaxLength()
	{
		return 1000;
	}
	public void setSocialCircumstance(String value)
	{
		this.isValidated = false;
		this.socialcircumstance = value;
	}
	public boolean getAdmissionChecklistIsNotNull()
	{
		return this.admissionchecklist != null;
	}
	public ims.nursing.vo.AdmissionChecklistVoCollection getAdmissionChecklist()
	{
		return this.admissionchecklist;
	}
	public void setAdmissionChecklist(ims.nursing.vo.AdmissionChecklistVoCollection value)
	{
		this.isValidated = false;
		this.admissionchecklist = value;
	}
	public boolean getConfirmedDateTimeIsNotNull()
	{
		return this.confirmeddatetime != null;
	}
	public ims.framework.utils.DateTime getConfirmedDateTime()
	{
		return this.confirmeddatetime;
	}
	public void setConfirmedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.confirmeddatetime = value;
	}
	public boolean getConfirmedByIsNotNull()
	{
		return this.confirmedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getConfirmedBy()
	{
		return this.confirmedby;
	}
	public void setConfirmedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.confirmedby = value;
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
		if(this.admittingnurse != null)
		{
			if(!this.admittingnurse.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.dischargedby != null)
		{
			if(!this.dischargedby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.admissionchecklist != null)
		{
			if(!this.admissionchecklist.isValidated())
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
		if(this.admittingnurse == null)
			listOfErrors.add("AdmittingNurse is mandatory");
		if(this.admittingnurse != null)
		{
			String[] listOfOtherErrors = this.admittingnurse.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dischargedby != null)
		{
			String[] listOfOtherErrors = this.dischargedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
		if(this.clientunderstanding != null)
			if(this.clientunderstanding.length() > 1000)
				listOfErrors.add("The length of the field [clientunderstanding] in the value object [ims.nursing.vo.ClinicalAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.socialcircumstance != null)
			if(this.socialcircumstance.length() > 1000)
				listOfErrors.add("The length of the field [socialcircumstance] in the value object [ims.nursing.vo.ClinicalAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.admissionchecklist != null)
		{
			String[] listOfOtherErrors = this.admissionchecklist.validate();
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
	
		ClinicalAdmissionVo clone = new ClinicalAdmissionVo(this.id, this.version);
		
		if(this.admittingnurse == null)
			clone.admittingnurse = null;
		else
			clone.admittingnurse = (ims.core.vo.NurseVo)this.admittingnurse.clone();
		if(this.dischargeddatetime == null)
			clone.dischargeddatetime = null;
		else
			clone.dischargeddatetime = (ims.framework.utils.DateTime)this.dischargeddatetime.clone();
		if(this.dischargedby == null)
			clone.dischargedby = null;
		else
			clone.dischargedby = (ims.core.vo.MemberOfStaffLiteVo)this.dischargedby.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.clientunderstanding = this.clientunderstanding;
		clone.socialcircumstance = this.socialcircumstance;
		if(this.admissionchecklist == null)
			clone.admissionchecklist = null;
		else
			clone.admissionchecklist = (ims.nursing.vo.AdmissionChecklistVoCollection)this.admissionchecklist.clone();
		if(this.confirmeddatetime == null)
			clone.confirmeddatetime = null;
		else
			clone.confirmeddatetime = (ims.framework.utils.DateTime)this.confirmeddatetime.clone();
		if(this.confirmedby == null)
			clone.confirmedby = null;
		else
			clone.confirmedby = (ims.core.vo.MemberOfStaffLiteVo)this.confirmedby.clone();
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
		if (!(ClinicalAdmissionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalAdmissionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalAdmissionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalAdmissionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.authoringinformation != null)
			count++;
		if(this.clientunderstanding != null)
			count++;
		if(this.socialcircumstance != null)
			count++;
		if(this.admissionchecklist != null)
			count++;
		if(this.confirmeddatetime != null)
			count++;
		if(this.confirmedby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected String clientunderstanding;
	protected String socialcircumstance;
	protected ims.nursing.vo.AdmissionChecklistVoCollection admissionchecklist;
	protected ims.framework.utils.DateTime confirmeddatetime;
	protected ims.core.vo.MemberOfStaffLiteVo confirmedby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
