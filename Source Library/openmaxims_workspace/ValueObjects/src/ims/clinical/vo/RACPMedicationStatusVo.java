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
 * Linked to clinical.RACPMedicationStatus business object (ID: 1072100080).
 */
public class RACPMedicationStatusVo extends ims.clinical.vo.RACPMedicationStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RACPMedicationStatusVo()
	{
	}
	public RACPMedicationStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public RACPMedicationStatusVo(ims.clinical.vo.beans.RACPMedicationStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication() == null ? null : ims.clinical.vo.lookups.RACPMedication.buildLookup(bean.getMedication());
		this.medicationstatus = bean.getMedicationStatus() == null ? null : ims.clinical.vo.lookups.RACPMedicationStatus.buildLookup(bean.getMedicationStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.RACPMedicationStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication() == null ? null : ims.clinical.vo.lookups.RACPMedication.buildLookup(bean.getMedication());
		this.medicationstatus = bean.getMedicationStatus() == null ? null : ims.clinical.vo.lookups.RACPMedicationStatus.buildLookup(bean.getMedicationStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.RACPMedicationStatusVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.RACPMedicationStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.RACPMedicationStatusVoBean();
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
		if(fieldName.equals("MEDICATION"))
			return getMedication();
		if(fieldName.equals("MEDICATIONSTATUS"))
			return getMedicationStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMedicationIsNotNull()
	{
		return this.medication != null;
	}
	public ims.clinical.vo.lookups.RACPMedication getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.clinical.vo.lookups.RACPMedication value)
	{
		this.isValidated = false;
		this.medication = value;
	}
	public boolean getMedicationStatusIsNotNull()
	{
		return this.medicationstatus != null;
	}
	public ims.clinical.vo.lookups.RACPMedicationStatus getMedicationStatus()
	{
		return this.medicationstatus;
	}
	public void setMedicationStatus(ims.clinical.vo.lookups.RACPMedicationStatus value)
	{
		this.isValidated = false;
		this.medicationstatus = value;
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
		if(this.medication == null)
			listOfErrors.add("Medication is mandatory");
		if(this.medicationstatus == null)
			listOfErrors.add("MedicationStatus is mandatory");
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
	
		RACPMedicationStatusVo clone = new RACPMedicationStatusVo(this.id, this.version);
		
		if(this.medication == null)
			clone.medication = null;
		else
			clone.medication = (ims.clinical.vo.lookups.RACPMedication)this.medication.clone();
		if(this.medicationstatus == null)
			clone.medicationstatus = null;
		else
			clone.medicationstatus = (ims.clinical.vo.lookups.RACPMedicationStatus)this.medicationstatus.clone();
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
		if (!(RACPMedicationStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RACPMedicationStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RACPMedicationStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RACPMedicationStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.medication != null)
			count++;
		if(this.medicationstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinical.vo.lookups.RACPMedication medication;
	protected ims.clinical.vo.lookups.RACPMedicationStatus medicationstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
