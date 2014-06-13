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
 * Linked to clinical.SurgicalOperationNotes business object (ID: 1003100106).
 */
public class SurgicalOperationNotesGeneralDetailsVo extends ims.clinical.vo.SurgicalOperationNotesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SurgicalOperationNotesGeneralDetailsVo()
	{
	}
	public SurgicalOperationNotesGeneralDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public SurgicalOperationNotesGeneralDetailsVo(ims.clinical.vo.beans.SurgicalOperationNotesGeneralDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.proceduresperformed = ims.core.vo.PatientProcedureSurgicalOpVoCollection.buildFromBeanCollection(bean.getProceduresPerformed());
		this.patientdiagnoses = ims.clinical.vo.PatientDiagnosisOpNotesVoCollection.buildFromBeanCollection(bean.getPatientDiagnoses());
		this.mainprocedure = bean.getMainProcedure() == null ? null : bean.getMainProcedure().buildVo();
		this.principalanaesthetist = bean.getPrincipalAnaesthetist() == null ? null : bean.getPrincipalAnaesthetist().buildVo();
		this.consultantanaesthetist = bean.getConsultantAnaesthetist() == null ? null : bean.getConsultantAnaesthetist().buildVo();
		this.anaestheticgiven = bean.getAnaestheticGiven() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticGiven());
		this.estimateddateofdischarge = bean.getEstimatedDateOfDischarge() == null ? null : bean.getEstimatedDateOfDischarge().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SurgicalOperationNotesGeneralDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.proceduresperformed = ims.core.vo.PatientProcedureSurgicalOpVoCollection.buildFromBeanCollection(bean.getProceduresPerformed());
		this.patientdiagnoses = ims.clinical.vo.PatientDiagnosisOpNotesVoCollection.buildFromBeanCollection(bean.getPatientDiagnoses());
		this.mainprocedure = bean.getMainProcedure() == null ? null : bean.getMainProcedure().buildVo(map);
		this.principalanaesthetist = bean.getPrincipalAnaesthetist() == null ? null : bean.getPrincipalAnaesthetist().buildVo(map);
		this.consultantanaesthetist = bean.getConsultantAnaesthetist() == null ? null : bean.getConsultantAnaesthetist().buildVo(map);
		this.anaestheticgiven = bean.getAnaestheticGiven() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticGiven());
		this.estimateddateofdischarge = bean.getEstimatedDateOfDischarge() == null ? null : bean.getEstimatedDateOfDischarge().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SurgicalOperationNotesGeneralDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SurgicalOperationNotesGeneralDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SurgicalOperationNotesGeneralDetailsVoBean();
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
		if(fieldName.equals("AUTHORINGINFO"))
			return getAuthoringInfo();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("PROCEDURESPERFORMED"))
			return getProceduresPerformed();
		if(fieldName.equals("PATIENTDIAGNOSES"))
			return getPatientDiagnoses();
		if(fieldName.equals("MAINPROCEDURE"))
			return getMainProcedure();
		if(fieldName.equals("PRINCIPALANAESTHETIST"))
			return getPrincipalAnaesthetist();
		if(fieldName.equals("CONSULTANTANAESTHETIST"))
			return getConsultantAnaesthetist();
		if(fieldName.equals("ANAESTHETICGIVEN"))
			return getAnaestheticGiven();
		if(fieldName.equals("ESTIMATEDDATEOFDISCHARGE"))
			return getEstimatedDateOfDischarge();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInfoIsNotNull()
	{
		return this.authoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinfo = value;
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
	public boolean getProceduresPerformedIsNotNull()
	{
		return this.proceduresperformed != null;
	}
	public ims.core.vo.PatientProcedureSurgicalOpVoCollection getProceduresPerformed()
	{
		return this.proceduresperformed;
	}
	public void setProceduresPerformed(ims.core.vo.PatientProcedureSurgicalOpVoCollection value)
	{
		this.isValidated = false;
		this.proceduresperformed = value;
	}
	public boolean getPatientDiagnosesIsNotNull()
	{
		return this.patientdiagnoses != null;
	}
	public ims.clinical.vo.PatientDiagnosisOpNotesVoCollection getPatientDiagnoses()
	{
		return this.patientdiagnoses;
	}
	public void setPatientDiagnoses(ims.clinical.vo.PatientDiagnosisOpNotesVoCollection value)
	{
		this.isValidated = false;
		this.patientdiagnoses = value;
	}
	public boolean getMainProcedureIsNotNull()
	{
		return this.mainprocedure != null;
	}
	public ims.core.vo.PatientProcedureSurgicalOpVo getMainProcedure()
	{
		return this.mainprocedure;
	}
	public void setMainProcedure(ims.core.vo.PatientProcedureSurgicalOpVo value)
	{
		this.isValidated = false;
		this.mainprocedure = value;
	}
	public boolean getPrincipalAnaesthetistIsNotNull()
	{
		return this.principalanaesthetist != null;
	}
	public ims.core.vo.HcpLiteVo getPrincipalAnaesthetist()
	{
		return this.principalanaesthetist;
	}
	public void setPrincipalAnaesthetist(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.principalanaesthetist = value;
	}
	public boolean getConsultantAnaesthetistIsNotNull()
	{
		return this.consultantanaesthetist != null;
	}
	public ims.core.vo.HcpLiteVo getConsultantAnaesthetist()
	{
		return this.consultantanaesthetist;
	}
	public void setConsultantAnaesthetist(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultantanaesthetist = value;
	}
	public boolean getAnaestheticGivenIsNotNull()
	{
		return this.anaestheticgiven != null;
	}
	public ims.clinical.vo.lookups.AnaestheticType getAnaestheticGiven()
	{
		return this.anaestheticgiven;
	}
	public void setAnaestheticGiven(ims.clinical.vo.lookups.AnaestheticType value)
	{
		this.isValidated = false;
		this.anaestheticgiven = value;
	}
	public boolean getEstimatedDateOfDischargeIsNotNull()
	{
		return this.estimateddateofdischarge != null;
	}
	public ims.framework.utils.Date getEstimatedDateOfDischarge()
	{
		return this.estimateddateofdischarge;
	}
	public void setEstimatedDateOfDischarge(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.estimateddateofdischarge = value;
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
		if(this.authoringinfo != null)
		{
			if(!this.authoringinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.proceduresperformed != null)
		{
			if(!this.proceduresperformed.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.patientdiagnoses != null)
		{
			if(!this.patientdiagnoses.isValidated())
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
		if(this.authoringinfo == null)
			listOfErrors.add("AuthoringInfo is mandatory");
		if(this.authoringinfo != null)
		{
			String[] listOfOtherErrors = this.authoringinfo.validate();
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
		if(this.proceduresperformed != null)
		{
			String[] listOfOtherErrors = this.proceduresperformed.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patientdiagnoses != null)
		{
			String[] listOfOtherErrors = this.patientdiagnoses.validate();
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
	
		SurgicalOperationNotesGeneralDetailsVo clone = new SurgicalOperationNotesGeneralDetailsVo(this.id, this.version);
		
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
		clone.carecontext = this.carecontext;
		if(this.proceduresperformed == null)
			clone.proceduresperformed = null;
		else
			clone.proceduresperformed = (ims.core.vo.PatientProcedureSurgicalOpVoCollection)this.proceduresperformed.clone();
		if(this.patientdiagnoses == null)
			clone.patientdiagnoses = null;
		else
			clone.patientdiagnoses = (ims.clinical.vo.PatientDiagnosisOpNotesVoCollection)this.patientdiagnoses.clone();
		if(this.mainprocedure == null)
			clone.mainprocedure = null;
		else
			clone.mainprocedure = (ims.core.vo.PatientProcedureSurgicalOpVo)this.mainprocedure.clone();
		if(this.principalanaesthetist == null)
			clone.principalanaesthetist = null;
		else
			clone.principalanaesthetist = (ims.core.vo.HcpLiteVo)this.principalanaesthetist.clone();
		if(this.consultantanaesthetist == null)
			clone.consultantanaesthetist = null;
		else
			clone.consultantanaesthetist = (ims.core.vo.HcpLiteVo)this.consultantanaesthetist.clone();
		if(this.anaestheticgiven == null)
			clone.anaestheticgiven = null;
		else
			clone.anaestheticgiven = (ims.clinical.vo.lookups.AnaestheticType)this.anaestheticgiven.clone();
		if(this.estimateddateofdischarge == null)
			clone.estimateddateofdischarge = null;
		else
			clone.estimateddateofdischarge = (ims.framework.utils.Date)this.estimateddateofdischarge.clone();
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
		if (!(SurgicalOperationNotesGeneralDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SurgicalOperationNotesGeneralDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SurgicalOperationNotesGeneralDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SurgicalOperationNotesGeneralDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinfo != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.proceduresperformed != null)
			count++;
		if(this.patientdiagnoses != null)
			count++;
		if(this.mainprocedure != null)
			count++;
		if(this.principalanaesthetist != null)
			count++;
		if(this.consultantanaesthetist != null)
			count++;
		if(this.anaestheticgiven != null)
			count++;
		if(this.estimateddateofdischarge != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinfo;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.PatientProcedureSurgicalOpVoCollection proceduresperformed;
	protected ims.clinical.vo.PatientDiagnosisOpNotesVoCollection patientdiagnoses;
	protected ims.core.vo.PatientProcedureSurgicalOpVo mainprocedure;
	protected ims.core.vo.HcpLiteVo principalanaesthetist;
	protected ims.core.vo.HcpLiteVo consultantanaesthetist;
	protected ims.clinical.vo.lookups.AnaestheticType anaestheticgiven;
	protected ims.framework.utils.Date estimateddateofdischarge;
	private boolean isValidated = false;
	private boolean isBusy = false;
}