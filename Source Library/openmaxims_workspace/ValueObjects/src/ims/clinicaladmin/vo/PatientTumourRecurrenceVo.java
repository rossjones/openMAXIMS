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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.PatientTumourRecurrence business object (ID: 1074100037).
 */
public class PatientTumourRecurrenceVo extends ims.oncology.vo.PatientTumourRecurrenceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientTumourRecurrenceVo()
	{
	}
	public PatientTumourRecurrenceVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientTumourRecurrenceVo(ims.clinicaladmin.vo.beans.PatientTumourRecurrenceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recurrencedate = bean.getRecurrenceDate() == null ? null : bean.getRecurrenceDate().buildDate();
		this.recurrencesite = bean.getRecurrenceSite() == null ? null : ims.oncology.vo.lookups.RecurrenceSite.buildLookup(bean.getRecurrenceSite());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.PatientTumourRecurrenceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recurrencedate = bean.getRecurrenceDate() == null ? null : bean.getRecurrenceDate().buildDate();
		this.recurrencesite = bean.getRecurrenceSite() == null ? null : ims.oncology.vo.lookups.RecurrenceSite.buildLookup(bean.getRecurrenceSite());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.PatientTumourRecurrenceVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.PatientTumourRecurrenceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.PatientTumourRecurrenceVoBean();
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
		if(fieldName.equals("RECURRENCEDATE"))
			return getRecurrenceDate();
		if(fieldName.equals("RECURRENCESITE"))
			return getRecurrenceSite();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRecurrenceDateIsNotNull()
	{
		return this.recurrencedate != null;
	}
	public ims.framework.utils.Date getRecurrenceDate()
	{
		return this.recurrencedate;
	}
	public void setRecurrenceDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.recurrencedate = value;
	}
	public boolean getRecurrenceSiteIsNotNull()
	{
		return this.recurrencesite != null;
	}
	public ims.oncology.vo.lookups.RecurrenceSite getRecurrenceSite()
	{
		return this.recurrencesite;
	}
	public void setRecurrenceSite(ims.oncology.vo.lookups.RecurrenceSite value)
	{
		this.isValidated = false;
		this.recurrencesite = value;
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
	
		PatientTumourRecurrenceVo clone = new PatientTumourRecurrenceVo(this.id, this.version);
		
		if(this.recurrencedate == null)
			clone.recurrencedate = null;
		else
			clone.recurrencedate = (ims.framework.utils.Date)this.recurrencedate.clone();
		if(this.recurrencesite == null)
			clone.recurrencesite = null;
		else
			clone.recurrencesite = (ims.oncology.vo.lookups.RecurrenceSite)this.recurrencesite.clone();
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
		if (!(PatientTumourRecurrenceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientTumourRecurrenceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientTumourRecurrenceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientTumourRecurrenceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.recurrencedate != null)
			count++;
		if(this.recurrencesite != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.framework.utils.Date recurrencedate;
	protected ims.oncology.vo.lookups.RecurrenceSite recurrencesite;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
