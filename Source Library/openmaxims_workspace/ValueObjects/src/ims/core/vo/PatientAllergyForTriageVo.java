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

/**
 * Linked to core.clinical.PatientAllergy business object (ID: 1003100008).
 */
public class PatientAllergyForTriageVo extends ims.core.clinical.vo.PatientAllergyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAllergyForTriageVo()
	{
	}
	public PatientAllergyForTriageVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAllergyForTriageVo(ims.core.vo.beans.PatientAllergyForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergen = bean.getAllergen() == null ? null : bean.getAllergen().buildVo();
		this.allergendescription = bean.getAllergenDescription();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientAllergyForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergen = bean.getAllergen() == null ? null : bean.getAllergen().buildVo(map);
		this.allergendescription = bean.getAllergenDescription();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientAllergyForTriageVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientAllergyForTriageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientAllergyForTriageVoBean();
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
		if(fieldName.equals("ALLERGEN"))
			return getAllergen();
		if(fieldName.equals("ALLERGENDESCRIPTION"))
			return getAllergenDescription();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAllergenIsNotNull()
	{
		return this.allergen != null;
	}
	public ims.core.vo.AllergenVo getAllergen()
	{
		return this.allergen;
	}
	public void setAllergen(ims.core.vo.AllergenVo value)
	{
		this.isValidated = false;
		this.allergen = value;
	}
	public boolean getAllergenDescriptionIsNotNull()
	{
		return this.allergendescription != null;
	}
	public String getAllergenDescription()
	{
		return this.allergendescription;
	}
	public static int getAllergenDescriptionMaxLength()
	{
		return 255;
	}
	public void setAllergenDescription(String value)
	{
		this.isValidated = false;
		this.allergendescription = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
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
		if(this.allergendescription == null || this.allergendescription.length() == 0)
			listOfErrors.add("AllergenDescription is mandatory");
		else if(this.allergendescription.length() > 255)
			listOfErrors.add("The length of the field [allergendescription] in the value object [ims.core.vo.PatientAllergyForTriageVo] is too big. It should be less or equal to 255");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		PatientAllergyForTriageVo clone = new PatientAllergyForTriageVo(this.id, this.version);
		
		if(this.allergen == null)
			clone.allergen = null;
		else
			clone.allergen = (ims.core.vo.AllergenVo)this.allergen.clone();
		clone.allergendescription = this.allergendescription;
		clone.patient = this.patient;
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
		if (!(PatientAllergyForTriageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAllergyForTriageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientAllergyForTriageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientAllergyForTriageVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.allergen != null)
			count++;
		if(this.allergendescription != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.AllergenVo allergen;
	protected String allergendescription;
	protected ims.core.patient.vo.PatientRefVo patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
