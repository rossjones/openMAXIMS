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

package ims.core.vo;


public class OutPatientFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OutPatientFilterVo()
	{
	}
	public OutPatientFilterVo(ims.core.vo.beans.OutPatientFilterVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.specialty = bean.getSpecialty() == null ? null : bean.getSpecialty().buildVo();
		this.clinicdatefrom = bean.getClinicDateFrom() == null ? null : bean.getClinicDateFrom().buildDate();
		this.clinicdateto = bean.getClinicDateTo() == null ? null : bean.getClinicDateTo().buildDate();
		this.docstatus = bean.getDocStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getDocStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.OutPatientFilterVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.specialty = bean.getSpecialty() == null ? null : bean.getSpecialty().buildVo(map);
		this.clinicdatefrom = bean.getClinicDateFrom() == null ? null : bean.getClinicDateFrom().buildDate();
		this.clinicdateto = bean.getClinicDateTo() == null ? null : bean.getClinicDateTo().buildDate();
		this.docstatus = bean.getDocStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getDocStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.OutPatientFilterVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.OutPatientFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.OutPatientFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getClinicIsNotNull()
	{
		return this.clinic != null;
	}
	public ims.core.vo.LocMostVo getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.LocMostVo value)
	{
		this.isValidated = false;
		this.clinic = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.MedicVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.MedicVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.ServiceVo getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.ServiceVo value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getClinicDateFromIsNotNull()
	{
		return this.clinicdatefrom != null;
	}
	public ims.framework.utils.Date getClinicDateFrom()
	{
		return this.clinicdatefrom;
	}
	public void setClinicDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.clinicdatefrom = value;
	}
	public boolean getClinicDateToIsNotNull()
	{
		return this.clinicdateto != null;
	}
	public ims.framework.utils.Date getClinicDateTo()
	{
		return this.clinicdateto;
	}
	public void setClinicDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.clinicdateto = value;
	}
	public boolean getDocStatusIsNotNull()
	{
		return this.docstatus != null;
	}
	public ims.core.vo.lookups.DocumentStatus getDocStatus()
	{
		return this.docstatus;
	}
	public void setDocStatus(ims.core.vo.lookups.DocumentStatus value)
	{
		this.isValidated = false;
		this.docstatus = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof OutPatientFilterVo))
			return false;
		OutPatientFilterVo compareObj = (OutPatientFilterVo)obj;
		if(this.getPatient() == null && compareObj.getPatient() != null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() == null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() != null)
			if(!this.getPatient().equals(compareObj.getPatient()))
				return false;
		if(this.getClinic() == null && compareObj.getClinic() != null)
			return false;
		if(this.getClinic() != null && compareObj.getClinic() == null)
			return false;
		if(this.getClinic() != null && compareObj.getClinic() != null)
			return this.getClinic().equals(compareObj.getClinic());
		return super.equals(obj);
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
		if(this.patient != null)
		{
			if(!this.patient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinic != null)
		{
			if(!this.clinic.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consultant != null)
		{
			if(!this.consultant.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.specialty != null)
		{
			if(!this.specialty.isValidated())
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
		if(this.patient != null)
		{
			String[] listOfOtherErrors = this.patient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinic != null)
		{
			String[] listOfOtherErrors = this.clinic.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consultant != null)
		{
			String[] listOfOtherErrors = this.consultant.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.specialty != null)
		{
			String[] listOfOtherErrors = this.specialty.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		OutPatientFilterVo clone = new OutPatientFilterVo();
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.clinic == null)
			clone.clinic = null;
		else
			clone.clinic = (ims.core.vo.LocMostVo)this.clinic.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.MedicVo)this.consultant.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.ServiceVo)this.specialty.clone();
		if(this.clinicdatefrom == null)
			clone.clinicdatefrom = null;
		else
			clone.clinicdatefrom = (ims.framework.utils.Date)this.clinicdatefrom.clone();
		if(this.clinicdateto == null)
			clone.clinicdateto = null;
		else
			clone.clinicdateto = (ims.framework.utils.Date)this.clinicdateto.clone();
		if(this.docstatus == null)
			clone.docstatus = null;
		else
			clone.docstatus = (ims.core.vo.lookups.DocumentStatus)this.docstatus.clone();
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
		if (!(OutPatientFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OutPatientFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OutPatientFilterVo compareObj = (OutPatientFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
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
		if(this.patient != null)
			count++;
		if(this.clinic != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.clinicdatefrom != null)
			count++;
		if(this.clinicdateto != null)
			count++;
		if(this.docstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.PatientShort patient;
	protected ims.core.vo.LocMostVo clinic;
	protected ims.core.vo.MedicVo consultant;
	protected ims.core.vo.ServiceVo specialty;
	protected ims.framework.utils.Date clinicdatefrom;
	protected ims.framework.utils.Date clinicdateto;
	protected ims.core.vo.lookups.DocumentStatus docstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
