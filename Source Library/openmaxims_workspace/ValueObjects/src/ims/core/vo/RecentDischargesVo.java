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
 * Linked to core.generic.Person Name business object (ID: 1002100001).
 */
public class RecentDischargesVo extends ims.core.generic.vo.PersonNameRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RecentDischargesVo()
	{
	}
	public RecentDischargesVo(Integer id, int version)
	{
		super(id, version);
	}
	public RecentDischargesVo(ims.core.vo.beans.RecentDischargesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.hospnumber = bean.getHospNumber();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.coe.vo.lookups.DischargeDestination.buildLookup(bean.getDischargeDestination());
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.RecentDischargesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.hospnumber = bean.getHospNumber();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.coe.vo.lookups.DischargeDestination.buildLookup(bean.getDischargeDestination());
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.RecentDischargesVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.RecentDischargesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.RecentDischargesVoBean();
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
		if(fieldName.equals("SURNAME"))
			return getSurname();
		if(fieldName.equals("FORENAME"))
			return getForename();
		if(fieldName.equals("HOSPNUMBER"))
			return getHospNumber();
		if(fieldName.equals("DISCHARGEDESTINATION"))
			return getDischargeDestination();
		if(fieldName.equals("HCP"))
			return getHcp();
		return super.getFieldValueByFieldName(fieldName);
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
		return 40;
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
		return 40;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getHospNumberIsNotNull()
	{
		return this.hospnumber != null;
	}
	public String getHospNumber()
	{
		return this.hospnumber;
	}
	public static int getHospNumberMaxLength()
	{
		return 255;
	}
	public void setHospNumber(String value)
	{
		this.isValidated = false;
		this.hospnumber = value;
	}
	public boolean getDischargeDestinationIsNotNull()
	{
		return this.dischargedestination != null;
	}
	public ims.coe.vo.lookups.DischargeDestination getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.coe.vo.lookups.DischargeDestination value)
	{
		this.isValidated = false;
		this.dischargedestination = value;
	}
	public boolean getHcpIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.HcpLiteVo getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.hcp = value;
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
		if(this.hcp != null)
		{
			if(!this.hcp.isValidated())
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
		if(this.surname == null || this.surname.length() == 0)
			listOfErrors.add("surname is mandatory");
		else if(this.surname.length() > 40)
			listOfErrors.add("The length of the field [surname] in the value object [ims.core.vo.RecentDischargesVo] is too big. It should be less or equal to 40");
		if(this.forename != null)
			if(this.forename.length() > 40)
				listOfErrors.add("The length of the field [forename] in the value object [ims.core.vo.RecentDischargesVo] is too big. It should be less or equal to 40");
		if(this.hcp != null)
		{
			String[] listOfOtherErrors = this.hcp.validate();
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
	
		RecentDischargesVo clone = new RecentDischargesVo(this.id, this.version);
		
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.hospnumber = this.hospnumber;
		if(this.dischargedestination == null)
			clone.dischargedestination = null;
		else
			clone.dischargedestination = (ims.coe.vo.lookups.DischargeDestination)this.dischargedestination.clone();
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.HcpLiteVo)this.hcp.clone();
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
		if (!(RecentDischargesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RecentDischargesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RecentDischargesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RecentDischargesVo)obj).getBoId());
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
		if(this.hospnumber != null)
			count++;
		if(this.dischargedestination != null)
			count++;
		if(this.hcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String surname;
	protected String forename;
	protected String hospnumber;
	protected ims.coe.vo.lookups.DischargeDestination dischargedestination;
	protected ims.core.vo.HcpLiteVo hcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
