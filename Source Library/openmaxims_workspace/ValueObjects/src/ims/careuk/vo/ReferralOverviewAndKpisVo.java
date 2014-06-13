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

package ims.careuk.vo;


public class ReferralOverviewAndKpisVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralOverviewAndKpisVo()
	{
	}
	public ReferralOverviewAndKpisVo(ims.careuk.vo.beans.ReferralOverviewAndKpisVoBean bean)
	{
		this.catsreferral = bean.getCatsReferral() == null ? null : bean.getCatsReferral().buildVo();
		this.enddayskpi = bean.getEndDaysKpi();
		this.enddayspaperkpi = bean.getEndDaysPaperKpi();
		this.enddaysemailkpi = bean.getEndDaysEmailKpi();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ReferralOverviewAndKpisVoBean bean)
	{
		this.catsreferral = bean.getCatsReferral() == null ? null : bean.getCatsReferral().buildVo(map);
		this.enddayskpi = bean.getEndDaysKpi();
		this.enddayspaperkpi = bean.getEndDaysPaperKpi();
		this.enddaysemailkpi = bean.getEndDaysEmailKpi();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ReferralOverviewAndKpisVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ReferralOverviewAndKpisVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ReferralOverviewAndKpisVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.careuk.vo.CatsReferralListVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.careuk.vo.CatsReferralListVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getEndDaysKpiIsNotNull()
	{
		return this.enddayskpi != null;
	}
	public Integer getEndDaysKpi()
	{
		return this.enddayskpi;
	}
	public void setEndDaysKpi(Integer value)
	{
		this.isValidated = false;
		this.enddayskpi = value;
	}
	public boolean getEndDaysPaperKpiIsNotNull()
	{
		return this.enddayspaperkpi != null;
	}
	public Integer getEndDaysPaperKpi()
	{
		return this.enddayspaperkpi;
	}
	public void setEndDaysPaperKpi(Integer value)
	{
		this.isValidated = false;
		this.enddayspaperkpi = value;
	}
	public boolean getEndDaysEmailKpiIsNotNull()
	{
		return this.enddaysemailkpi != null;
	}
	public Integer getEndDaysEmailKpi()
	{
		return this.enddaysemailkpi;
	}
	public void setEndDaysEmailKpi(Integer value)
	{
		this.isValidated = false;
		this.enddaysemailkpi = value;
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
		if(!(obj instanceof ReferralOverviewAndKpisVo))
			return false;
		ReferralOverviewAndKpisVo compareObj = (ReferralOverviewAndKpisVo)obj;
		if(this.getCatsReferral() == null && compareObj.getCatsReferral() != null)
			return false;
		if(this.getCatsReferral() != null && compareObj.getCatsReferral() == null)
			return false;
		if(this.getCatsReferral() != null && compareObj.getCatsReferral() != null)
			return this.getCatsReferral().equals(compareObj.getCatsReferral());
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
	
		ReferralOverviewAndKpisVo clone = new ReferralOverviewAndKpisVo();
		
		if(this.catsreferral == null)
			clone.catsreferral = null;
		else
			clone.catsreferral = (ims.careuk.vo.CatsReferralListVo)this.catsreferral.clone();
		clone.enddayskpi = this.enddayskpi;
		clone.enddayspaperkpi = this.enddayspaperkpi;
		clone.enddaysemailkpi = this.enddaysemailkpi;
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
		if (!(ReferralOverviewAndKpisVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralOverviewAndKpisVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ReferralOverviewAndKpisVo compareObj = (ReferralOverviewAndKpisVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCatsReferral() == null && compareObj.getCatsReferral() != null)
				return -1;
			if(this.getCatsReferral() != null && compareObj.getCatsReferral() == null)
				return 1;
			if(this.getCatsReferral() != null && compareObj.getCatsReferral() != null)
				retVal = this.getCatsReferral().compareTo(compareObj.getCatsReferral());
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
		if(this.catsreferral != null)
			count++;
		if(this.enddayskpi != null)
			count++;
		if(this.enddayspaperkpi != null)
			count++;
		if(this.enddaysemailkpi != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.careuk.vo.CatsReferralListVo catsreferral;
	protected Integer enddayskpi;
	protected Integer enddayspaperkpi;
	protected Integer enddaysemailkpi;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
