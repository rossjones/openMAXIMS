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


public class CatsReferralDetailsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatsReferralDetailsVo()
	{
	}
	public CatsReferralDetailsVo(ims.careuk.vo.beans.CatsReferralDetailsVoBean bean)
	{
		this.appointmentdetail = bean.getAppointmentDetail() == null ? null : bean.getAppointmentDetail().buildVo();
		this.presentation = bean.getPresentation() == null ? null : bean.getPresentation().buildVo();
		this.letterdetail = bean.getLetterDetail() == null ? null : bean.getLetterDetail().buildVo();
		this.referralapptstatus = bean.getReferralApptStatus() == null ? null : ims.careuk.vo.lookups.ReferralApptStatus.buildLookup(bean.getReferralApptStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.CatsReferralDetailsVoBean bean)
	{
		this.appointmentdetail = bean.getAppointmentDetail() == null ? null : bean.getAppointmentDetail().buildVo(map);
		this.presentation = bean.getPresentation() == null ? null : bean.getPresentation().buildVo(map);
		this.letterdetail = bean.getLetterDetail() == null ? null : bean.getLetterDetail().buildVo(map);
		this.referralapptstatus = bean.getReferralApptStatus() == null ? null : ims.careuk.vo.lookups.ReferralApptStatus.buildLookup(bean.getReferralApptStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.CatsReferralDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.CatsReferralDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.CatsReferralDetailsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getAppointmentDetailIsNotNull()
	{
		return this.appointmentdetail != null;
	}
	public ims.careuk.vo.ReferralAppointmentDetailsVo getAppointmentDetail()
	{
		return this.appointmentdetail;
	}
	public void setAppointmentDetail(ims.careuk.vo.ReferralAppointmentDetailsVo value)
	{
		this.isValidated = false;
		this.appointmentdetail = value;
	}
	public boolean getPresentationIsNotNull()
	{
		return this.presentation != null;
	}
	public ims.careuk.vo.PresentationReferralSummaryVo getPresentation()
	{
		return this.presentation;
	}
	public void setPresentation(ims.careuk.vo.PresentationReferralSummaryVo value)
	{
		this.isValidated = false;
		this.presentation = value;
	}
	public boolean getLetterDetailIsNotNull()
	{
		return this.letterdetail != null;
	}
	public ims.clinical.vo.ReferralLetterDetailsVo getLetterDetail()
	{
		return this.letterdetail;
	}
	public void setLetterDetail(ims.clinical.vo.ReferralLetterDetailsVo value)
	{
		this.isValidated = false;
		this.letterdetail = value;
	}
	public boolean getReferralApptStatusIsNotNull()
	{
		return this.referralapptstatus != null;
	}
	public ims.careuk.vo.lookups.ReferralApptStatus getReferralApptStatus()
	{
		return this.referralapptstatus;
	}
	public void setReferralApptStatus(ims.careuk.vo.lookups.ReferralApptStatus value)
	{
		this.isValidated = false;
		this.referralapptstatus = value;
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
		if(!(obj instanceof CatsReferralDetailsVo))
			return false;
		CatsReferralDetailsVo compareObj = (CatsReferralDetailsVo)obj;
		if(this.getAppointmentDetail() == null && compareObj.getAppointmentDetail() != null)
			return false;
		if(this.getAppointmentDetail() != null && compareObj.getAppointmentDetail() == null)
			return false;
		if(this.getAppointmentDetail() != null && compareObj.getAppointmentDetail() != null)
			return this.getAppointmentDetail().equals(compareObj.getAppointmentDetail());
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
		if(this.appointmentdetail != null)
		{
			if(!this.appointmentdetail.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.presentation != null)
		{
			if(!this.presentation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.letterdetail != null)
		{
			if(!this.letterdetail.isValidated())
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
		if(this.appointmentdetail != null)
		{
			String[] listOfOtherErrors = this.appointmentdetail.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.presentation != null)
		{
			String[] listOfOtherErrors = this.presentation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.letterdetail != null)
		{
			String[] listOfOtherErrors = this.letterdetail.validate();
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
	
		CatsReferralDetailsVo clone = new CatsReferralDetailsVo();
		
		if(this.appointmentdetail == null)
			clone.appointmentdetail = null;
		else
			clone.appointmentdetail = (ims.careuk.vo.ReferralAppointmentDetailsVo)this.appointmentdetail.clone();
		if(this.presentation == null)
			clone.presentation = null;
		else
			clone.presentation = (ims.careuk.vo.PresentationReferralSummaryVo)this.presentation.clone();
		if(this.letterdetail == null)
			clone.letterdetail = null;
		else
			clone.letterdetail = (ims.clinical.vo.ReferralLetterDetailsVo)this.letterdetail.clone();
		if(this.referralapptstatus == null)
			clone.referralapptstatus = null;
		else
			clone.referralapptstatus = (ims.careuk.vo.lookups.ReferralApptStatus)this.referralapptstatus.clone();
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
		if (!(CatsReferralDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CatsReferralDetailsVo compareObj = (CatsReferralDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAppointmentDetail() == null && compareObj.getAppointmentDetail() != null)
				return -1;
			if(this.getAppointmentDetail() != null && compareObj.getAppointmentDetail() == null)
				return 1;
			if(this.getAppointmentDetail() != null && compareObj.getAppointmentDetail() != null)
				retVal = this.getAppointmentDetail().compareTo(compareObj.getAppointmentDetail());
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
		if(this.appointmentdetail != null)
			count++;
		if(this.presentation != null)
			count++;
		if(this.letterdetail != null)
			count++;
		if(this.referralapptstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.careuk.vo.ReferralAppointmentDetailsVo appointmentdetail;
	protected ims.careuk.vo.PresentationReferralSummaryVo presentation;
	protected ims.clinical.vo.ReferralLetterDetailsVo letterdetail;
	protected ims.careuk.vo.lookups.ReferralApptStatus referralapptstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
