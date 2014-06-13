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


public class DiscontinueMedicationReasonValuesVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DiscontinueMedicationReasonValuesVo()
	{
	}
	public DiscontinueMedicationReasonValuesVo(ims.clinical.vo.beans.DiscontinueMedicationReasonValuesVoBean bean)
	{
		this.stoppeddate = bean.getStoppedDate() == null ? null : bean.getStoppedDate().buildDate();
		this.stoppedhcp = bean.getStoppedHCP() == null ? null : bean.getStoppedHCP().buildVo();
		this.stoppedreason = bean.getStoppedReason() == null ? null : ims.core.vo.lookups.MedicationDoseReasonStopped.buildLookup(bean.getStoppedReason());
		this.stoppedreasondesc = bean.getStoppedReasonDesc();
		this.stoppedbytype = bean.getStoppedByType() == null ? null : ims.core.vo.lookups.MedciationCommencedDiscontinuedType.buildLookup(bean.getStoppedByType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.DiscontinueMedicationReasonValuesVoBean bean)
	{
		this.stoppeddate = bean.getStoppedDate() == null ? null : bean.getStoppedDate().buildDate();
		this.stoppedhcp = bean.getStoppedHCP() == null ? null : bean.getStoppedHCP().buildVo(map);
		this.stoppedreason = bean.getStoppedReason() == null ? null : ims.core.vo.lookups.MedicationDoseReasonStopped.buildLookup(bean.getStoppedReason());
		this.stoppedreasondesc = bean.getStoppedReasonDesc();
		this.stoppedbytype = bean.getStoppedByType() == null ? null : ims.core.vo.lookups.MedciationCommencedDiscontinuedType.buildLookup(bean.getStoppedByType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.DiscontinueMedicationReasonValuesVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.DiscontinueMedicationReasonValuesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.DiscontinueMedicationReasonValuesVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getStoppedDateIsNotNull()
	{
		return this.stoppeddate != null;
	}
	public ims.framework.utils.Date getStoppedDate()
	{
		return this.stoppeddate;
	}
	public void setStoppedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.stoppeddate = value;
	}
	public boolean getStoppedHCPIsNotNull()
	{
		return this.stoppedhcp != null;
	}
	public ims.core.vo.Hcp getStoppedHCP()
	{
		return this.stoppedhcp;
	}
	public void setStoppedHCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.stoppedhcp = value;
	}
	public boolean getStoppedReasonIsNotNull()
	{
		return this.stoppedreason != null;
	}
	public ims.core.vo.lookups.MedicationDoseReasonStopped getStoppedReason()
	{
		return this.stoppedreason;
	}
	public void setStoppedReason(ims.core.vo.lookups.MedicationDoseReasonStopped value)
	{
		this.isValidated = false;
		this.stoppedreason = value;
	}
	public boolean getStoppedReasonDescIsNotNull()
	{
		return this.stoppedreasondesc != null;
	}
	public String getStoppedReasonDesc()
	{
		return this.stoppedreasondesc;
	}
	public static int getStoppedReasonDescMaxLength()
	{
		return 255;
	}
	public void setStoppedReasonDesc(String value)
	{
		this.isValidated = false;
		this.stoppedreasondesc = value;
	}
	public boolean getStoppedByTypeIsNotNull()
	{
		return this.stoppedbytype != null;
	}
	public ims.core.vo.lookups.MedciationCommencedDiscontinuedType getStoppedByType()
	{
		return this.stoppedbytype;
	}
	public void setStoppedByType(ims.core.vo.lookups.MedciationCommencedDiscontinuedType value)
	{
		this.isValidated = false;
		this.stoppedbytype = value;
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
		if(!(obj instanceof DiscontinueMedicationReasonValuesVo))
			return false;
		DiscontinueMedicationReasonValuesVo compareObj = (DiscontinueMedicationReasonValuesVo)obj;
		if(this.getStoppedDate() == null && compareObj.getStoppedDate() != null)
			return false;
		if(this.getStoppedDate() != null && compareObj.getStoppedDate() == null)
			return false;
		if(this.getStoppedDate() != null && compareObj.getStoppedDate() != null)
			return this.getStoppedDate().equals(compareObj.getStoppedDate());
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
		if(this.stoppedhcp != null)
		{
			if(!this.stoppedhcp.isValidated())
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
		if(this.stoppedhcp != null)
		{
			String[] listOfOtherErrors = this.stoppedhcp.validate();
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
	
		DiscontinueMedicationReasonValuesVo clone = new DiscontinueMedicationReasonValuesVo();
		
		if(this.stoppeddate == null)
			clone.stoppeddate = null;
		else
			clone.stoppeddate = (ims.framework.utils.Date)this.stoppeddate.clone();
		if(this.stoppedhcp == null)
			clone.stoppedhcp = null;
		else
			clone.stoppedhcp = (ims.core.vo.Hcp)this.stoppedhcp.clone();
		if(this.stoppedreason == null)
			clone.stoppedreason = null;
		else
			clone.stoppedreason = (ims.core.vo.lookups.MedicationDoseReasonStopped)this.stoppedreason.clone();
		clone.stoppedreasondesc = this.stoppedreasondesc;
		if(this.stoppedbytype == null)
			clone.stoppedbytype = null;
		else
			clone.stoppedbytype = (ims.core.vo.lookups.MedciationCommencedDiscontinuedType)this.stoppedbytype.clone();
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
		if (!(DiscontinueMedicationReasonValuesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DiscontinueMedicationReasonValuesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DiscontinueMedicationReasonValuesVo compareObj = (DiscontinueMedicationReasonValuesVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStoppedDate() == null && compareObj.getStoppedDate() != null)
				return -1;
			if(this.getStoppedDate() != null && compareObj.getStoppedDate() == null)
				return 1;
			if(this.getStoppedDate() != null && compareObj.getStoppedDate() != null)
				retVal = this.getStoppedDate().compareTo(compareObj.getStoppedDate());
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
		if(this.stoppeddate != null)
			count++;
		if(this.stoppedhcp != null)
			count++;
		if(this.stoppedreason != null)
			count++;
		if(this.stoppedreasondesc != null)
			count++;
		if(this.stoppedbytype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.framework.utils.Date stoppeddate;
	protected ims.core.vo.Hcp stoppedhcp;
	protected ims.core.vo.lookups.MedicationDoseReasonStopped stoppedreason;
	protected String stoppedreasondesc;
	protected ims.core.vo.lookups.MedciationCommencedDiscontinuedType stoppedbytype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
