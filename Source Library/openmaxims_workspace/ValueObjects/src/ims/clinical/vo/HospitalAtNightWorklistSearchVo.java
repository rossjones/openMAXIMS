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


public class HospitalAtNightWorklistSearchVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HospitalAtNightWorklistSearchVo()
	{
	}
	public HospitalAtNightWorklistSearchVo(ims.clinical.vo.beans.HospitalAtNightWorklistSearchVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.neworactive = bean.getNewOrActive();
		this.completed = bean.getCompleted();
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.typeofrequest = bean.getTypeOfRequest() == null ? null : ims.clinical.vo.lookups.HospitalAtNightRequestType.buildLookup(bean.getTypeOfRequest());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDateTime();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.HospitalAtNightWorklistSearchVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.neworactive = bean.getNewOrActive();
		this.completed = bean.getCompleted();
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.typeofrequest = bean.getTypeOfRequest() == null ? null : ims.clinical.vo.lookups.HospitalAtNightRequestType.buildLookup(bean.getTypeOfRequest());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDateTime();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.HospitalAtNightWorklistSearchVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.HospitalAtNightWorklistSearchVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.HospitalAtNightWorklistSearchVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 255;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 255;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getNewOrActiveIsNotNull()
	{
		return this.neworactive != null;
	}
	public Boolean getNewOrActive()
	{
		return this.neworactive;
	}
	public void setNewOrActive(Boolean value)
	{
		this.isValidated = false;
		this.neworactive = value;
	}
	public boolean getCompletedIsNotNull()
	{
		return this.completed != null;
	}
	public Boolean getCompleted()
	{
		return this.completed;
	}
	public void setCompleted(Boolean value)
	{
		this.isValidated = false;
		this.completed = value;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.vo.LocSiteLiteVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.LocSiteLiteVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getTypeOfRequestIsNotNull()
	{
		return this.typeofrequest != null;
	}
	public ims.clinical.vo.lookups.HospitalAtNightRequestType getTypeOfRequest()
	{
		return this.typeofrequest;
	}
	public void setTypeOfRequest(ims.clinical.vo.lookups.HospitalAtNightRequestType value)
	{
		this.isValidated = false;
		this.typeofrequest = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.DateTime getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.DateTime getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dateto = value;
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
		if(!(obj instanceof HospitalAtNightWorklistSearchVo))
			return false;
		HospitalAtNightWorklistSearchVo compareObj = (HospitalAtNightWorklistSearchVo)obj;
		if(this.getSurname() == null && compareObj.getSurname() != null)
			return false;
		if(this.getSurname() != null && compareObj.getSurname() == null)
			return false;
		if(this.getSurname() != null && compareObj.getSurname() != null)
			if(!this.getSurname().equals(compareObj.getSurname()))
				return false;
		if(this.getForename() == null && compareObj.getForename() != null)
			return false;
		if(this.getForename() != null && compareObj.getForename() == null)
			return false;
		if(this.getForename() != null && compareObj.getForename() != null)
			if(!this.getForename().equals(compareObj.getForename()))
				return false;
		if(this.getNewOrActive() == null && compareObj.getNewOrActive() != null)
			return false;
		if(this.getNewOrActive() != null && compareObj.getNewOrActive() == null)
			return false;
		if(this.getNewOrActive() != null && compareObj.getNewOrActive() != null)
			if(!this.getNewOrActive().equals(compareObj.getNewOrActive()))
				return false;
		if(this.getCompleted() == null && compareObj.getCompleted() != null)
			return false;
		if(this.getCompleted() != null && compareObj.getCompleted() == null)
			return false;
		if(this.getCompleted() != null && compareObj.getCompleted() != null)
			if(!this.getCompleted().equals(compareObj.getCompleted()))
				return false;
		if(this.getHospital() == null && compareObj.getHospital() != null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() == null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() != null)
			if(!this.getHospital().equals(compareObj.getHospital()))
				return false;
		if(this.getWard() == null && compareObj.getWard() != null)
			return false;
		if(this.getWard() != null && compareObj.getWard() == null)
			return false;
		if(this.getWard() != null && compareObj.getWard() != null)
			if(!this.getWard().equals(compareObj.getWard()))
				return false;
		if(this.getTypeOfRequest() == null && compareObj.getTypeOfRequest() != null)
			return false;
		if(this.getTypeOfRequest() != null && compareObj.getTypeOfRequest() == null)
			return false;
		if(this.getTypeOfRequest() != null && compareObj.getTypeOfRequest() != null)
			if(!this.getTypeOfRequest().equals(compareObj.getTypeOfRequest()))
				return false;
		if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
			return false;
		if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
			return false;
		if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
			if(!this.getDateFrom().equals(compareObj.getDateFrom()))
				return false;
		if(this.getDateTo() == null && compareObj.getDateTo() != null)
			return false;
		if(this.getDateTo() != null && compareObj.getDateTo() == null)
			return false;
		if(this.getDateTo() != null && compareObj.getDateTo() != null)
			return this.getDateTo().equals(compareObj.getDateTo());
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		HospitalAtNightWorklistSearchVo clone = new HospitalAtNightWorklistSearchVo();
		
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.neworactive = this.neworactive;
		clone.completed = this.completed;
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocSiteLiteVo)this.hospital.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.typeofrequest == null)
			clone.typeofrequest = null;
		else
			clone.typeofrequest = (ims.clinical.vo.lookups.HospitalAtNightRequestType)this.typeofrequest.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.DateTime)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.DateTime)this.dateto.clone();
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
		if (!(HospitalAtNightWorklistSearchVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HospitalAtNightWorklistSearchVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		HospitalAtNightWorklistSearchVo compareObj = (HospitalAtNightWorklistSearchVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSurname() == null && compareObj.getSurname() != null)
				return -1;
			if(this.getSurname() != null && compareObj.getSurname() == null)
				return 1;
			if(this.getSurname() != null && compareObj.getSurname() != null)
			{
				if(caseInsensitive)
					retVal = this.getSurname().toLowerCase().compareTo(compareObj.getSurname().toLowerCase());
				else
					retVal = this.getSurname().compareTo(compareObj.getSurname());
			}
		}
		if (retVal == 0)
		{
			if(this.getForename() == null && compareObj.getForename() != null)
				return -1;
			if(this.getForename() != null && compareObj.getForename() == null)
				return 1;
			if(this.getForename() != null && compareObj.getForename() != null)
			{
				if(caseInsensitive)
					retVal = this.getForename().toLowerCase().compareTo(compareObj.getForename().toLowerCase());
				else
					retVal = this.getForename().compareTo(compareObj.getForename());
			}
		}
		if (retVal == 0)
		{
			if(this.getNewOrActive() == null && compareObj.getNewOrActive() != null)
				return -1;
			if(this.getNewOrActive() != null && compareObj.getNewOrActive() == null)
				return 1;
			if(this.getNewOrActive() != null && compareObj.getNewOrActive() != null)
				retVal = this.getNewOrActive().compareTo(compareObj.getNewOrActive());
		}
		if (retVal == 0)
		{
			if(this.getCompleted() == null && compareObj.getCompleted() != null)
				return -1;
			if(this.getCompleted() != null && compareObj.getCompleted() == null)
				return 1;
			if(this.getCompleted() != null && compareObj.getCompleted() != null)
				retVal = this.getCompleted().compareTo(compareObj.getCompleted());
		}
		if (retVal == 0)
		{
			if(this.getHospital() == null && compareObj.getHospital() != null)
				return -1;
			if(this.getHospital() != null && compareObj.getHospital() == null)
				return 1;
			if(this.getHospital() != null && compareObj.getHospital() != null)
				retVal = this.getHospital().compareTo(compareObj.getHospital());
		}
		if (retVal == 0)
		{
			if(this.getWard() == null && compareObj.getWard() != null)
				return -1;
			if(this.getWard() != null && compareObj.getWard() == null)
				return 1;
			if(this.getWard() != null && compareObj.getWard() != null)
				retVal = this.getWard().compareTo(compareObj.getWard());
		}
		if (retVal == 0)
		{
			if(this.getTypeOfRequest() == null && compareObj.getTypeOfRequest() != null)
				return -1;
			if(this.getTypeOfRequest() != null && compareObj.getTypeOfRequest() == null)
				return 1;
			if(this.getTypeOfRequest() != null && compareObj.getTypeOfRequest() != null)
				retVal = this.getTypeOfRequest().compareTo(compareObj.getTypeOfRequest());
		}
		if (retVal == 0)
		{
			if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
				return -1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
				return 1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
				retVal = this.getDateFrom().compareTo(compareObj.getDateFrom());
		}
		if (retVal == 0)
		{
			if(this.getDateTo() == null && compareObj.getDateTo() != null)
				return -1;
			if(this.getDateTo() != null && compareObj.getDateTo() == null)
				return 1;
			if(this.getDateTo() != null && compareObj.getDateTo() != null)
				retVal = this.getDateTo().compareTo(compareObj.getDateTo());
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
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.neworactive != null)
			count++;
		if(this.completed != null)
			count++;
		if(this.hospital != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.typeofrequest != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String surname;
	protected String forename;
	protected Boolean neworactive;
	protected Boolean completed;
	protected ims.core.vo.LocSiteLiteVo hospital;
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.clinical.vo.lookups.HospitalAtNightRequestType typeofrequest;
	protected ims.framework.utils.DateTime datefrom;
	protected ims.framework.utils.DateTime dateto;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
