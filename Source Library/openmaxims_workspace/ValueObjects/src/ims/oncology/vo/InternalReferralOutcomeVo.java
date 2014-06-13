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

package ims.oncology.vo;

/**
 * Linked to Oncology.InternalReferralOutcome business object (ID: 1074100042).
 */
public class InternalReferralOutcomeVo extends ims.oncology.vo.InternalReferralOutcomeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InternalReferralOutcomeVo()
	{
	}
	public InternalReferralOutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public InternalReferralOutcomeVo(ims.oncology.vo.beans.InternalReferralOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referraloutcome = bean.getReferralOutcome() == null ? null : ims.oncology.vo.lookups.ReferralOutcome.buildLookup(bean.getReferralOutcome());
		this.referraloutcomedate = bean.getReferralOutcomeDate() == null ? null : bean.getReferralOutcomeDate().buildDate();
		this.referraloutcomenotes = bean.getReferralOutcomeNotes();
		this.referralseen = bean.getReferralSeen();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.InternalReferralOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referraloutcome = bean.getReferralOutcome() == null ? null : ims.oncology.vo.lookups.ReferralOutcome.buildLookup(bean.getReferralOutcome());
		this.referraloutcomedate = bean.getReferralOutcomeDate() == null ? null : bean.getReferralOutcomeDate().buildDate();
		this.referraloutcomenotes = bean.getReferralOutcomeNotes();
		this.referralseen = bean.getReferralSeen();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.InternalReferralOutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.InternalReferralOutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.InternalReferralOutcomeVoBean();
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
		if(fieldName.equals("REFERRALOUTCOME"))
			return getReferralOutcome();
		if(fieldName.equals("REFERRALOUTCOMEDATE"))
			return getReferralOutcomeDate();
		if(fieldName.equals("REFERRALOUTCOMENOTES"))
			return getReferralOutcomeNotes();
		if(fieldName.equals("REFERRALSEEN"))
			return getReferralSeen();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferralOutcomeIsNotNull()
	{
		return this.referraloutcome != null;
	}
	public ims.oncology.vo.lookups.ReferralOutcome getReferralOutcome()
	{
		return this.referraloutcome;
	}
	public void setReferralOutcome(ims.oncology.vo.lookups.ReferralOutcome value)
	{
		this.isValidated = false;
		this.referraloutcome = value;
	}
	public boolean getReferralOutcomeDateIsNotNull()
	{
		return this.referraloutcomedate != null;
	}
	public ims.framework.utils.Date getReferralOutcomeDate()
	{
		return this.referraloutcomedate;
	}
	public void setReferralOutcomeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.referraloutcomedate = value;
	}
	public boolean getReferralOutcomeNotesIsNotNull()
	{
		return this.referraloutcomenotes != null;
	}
	public String getReferralOutcomeNotes()
	{
		return this.referraloutcomenotes;
	}
	public static int getReferralOutcomeNotesMaxLength()
	{
		return 1000;
	}
	public void setReferralOutcomeNotes(String value)
	{
		this.isValidated = false;
		this.referraloutcomenotes = value;
	}
	public boolean getReferralSeenIsNotNull()
	{
		return this.referralseen != null;
	}
	public Boolean getReferralSeen()
	{
		return this.referralseen;
	}
	public void setReferralSeen(Boolean value)
	{
		this.isValidated = false;
		this.referralseen = value;
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
		if(this.referraloutcomenotes != null)
			if(this.referraloutcomenotes.length() > 1000)
				listOfErrors.add("The length of the field [referraloutcomenotes] in the value object [ims.oncology.vo.InternalReferralOutcomeVo] is too big. It should be less or equal to 1000");
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
	
		InternalReferralOutcomeVo clone = new InternalReferralOutcomeVo(this.id, this.version);
		
		if(this.referraloutcome == null)
			clone.referraloutcome = null;
		else
			clone.referraloutcome = (ims.oncology.vo.lookups.ReferralOutcome)this.referraloutcome.clone();
		if(this.referraloutcomedate == null)
			clone.referraloutcomedate = null;
		else
			clone.referraloutcomedate = (ims.framework.utils.Date)this.referraloutcomedate.clone();
		clone.referraloutcomenotes = this.referraloutcomenotes;
		clone.referralseen = this.referralseen;
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
		if (!(InternalReferralOutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InternalReferralOutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InternalReferralOutcomeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InternalReferralOutcomeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.referraloutcome != null)
			count++;
		if(this.referraloutcomedate != null)
			count++;
		if(this.referraloutcomenotes != null)
			count++;
		if(this.referralseen != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.oncology.vo.lookups.ReferralOutcome referraloutcome;
	protected ims.framework.utils.Date referraloutcomedate;
	protected String referraloutcomenotes;
	protected Boolean referralseen;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
