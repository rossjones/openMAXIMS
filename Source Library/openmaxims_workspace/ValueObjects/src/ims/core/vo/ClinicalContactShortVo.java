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
 * Linked to core.admin.Clinical Contact business object (ID: 1004100003).
 */
public class ClinicalContactShortVo extends ims.core.admin.vo.ClinicalContactRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalContactShortVo()
	{
	}
	public ClinicalContactShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalContactShortVo(ims.core.vo.beans.ClinicalContactShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo();
		this.contacttype = bean.getContactType() == null ? null : ims.core.vo.lookups.ContactType.buildLookup(bean.getContactType());
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.isclinicalnotecreated = bean.getIsClinicalNoteCreated();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.statushistory = ims.core.vo.ClinicalContactStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ClinicalContactShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo(map);
		this.contacttype = bean.getContactType() == null ? null : ims.core.vo.lookups.ContactType.buildLookup(bean.getContactType());
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.isclinicalnotecreated = bean.getIsClinicalNoteCreated();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.statushistory = ims.core.vo.ClinicalContactStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ClinicalContactShortVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ClinicalContactShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ClinicalContactShortVoBean();
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
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("SEENBY"))
			return getSeenBy();
		if(fieldName.equals("CONTACTTYPE"))
			return getContactType();
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("ENDDATETIME"))
			return getEndDateTime();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ISCLINICALNOTECREATED"))
			return getIsClinicalNoteCreated();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getSeenByIsNotNull()
	{
		return this.seenby != null;
	}
	public ims.core.vo.HcpLiteVo getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.seenby = value;
	}
	public boolean getContactTypeIsNotNull()
	{
		return this.contacttype != null;
	}
	public ims.core.vo.lookups.ContactType getContactType()
	{
		return this.contacttype;
	}
	public void setContactType(ims.core.vo.lookups.ContactType value)
	{
		this.isValidated = false;
		this.contacttype = value;
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getEndDateTimeIsNotNull()
	{
		return this.enddatetime != null;
	}
	public ims.framework.utils.DateTime getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.enddatetime = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getIsClinicalNoteCreatedIsNotNull()
	{
		return this.isclinicalnotecreated != null;
	}
	public Boolean getIsClinicalNoteCreated()
	{
		return this.isclinicalnotecreated;
	}
	public void setIsClinicalNoteCreated(Boolean value)
	{
		this.isValidated = false;
		this.isclinicalnotecreated = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.core.vo.ClinicalContactStatusHistoryVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.ClinicalContactStatusHistoryVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.core.vo.ClinicalContactStatusHistoryVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.ClinicalContactStatusHistoryVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	/**
	* buildContactDetailsString
	*/
	public String buildContactDetailsString() 
	{
		StringBuffer contactStr = new StringBuffer();
			
		contactStr.append("Date/Time:  ");
				
	/*	if (this.getStartDateTimeIsNotNull())
		{
			contactStr.append(this.getStartDateTime().toString());
			contactStr.append("   ");
		}
		else
			contactStr.append("Unknown Date\time");
			
		contactStr.append("RMO:  ");
				
		if (this.getResponsibleHCPIsNotNull() && this.getResponsibleHCP().getName() != null)
		{
			contactStr.append(this.getResponsibleHCP().getName().toString());
			contactStr.append("   ");
		}
		else
			contactStr.append("Unknown RMO");
	
		contactStr.append("Seen By:  ");
				
		if (this.getSeenByIsNotNull() && this.getSeenBy().getName() != null)
		{
			contactStr.append(this.getSeenBy().getName().toString());
		}
		else
			contactStr.append("Unknown RMO");*/
	
			
		return contactStr.toString();
	}
	/**
	* toString
	*/
	public String toString()
	{
		String display = "";
		display += this.startdatetime != null ? this.startdatetime.toString() : "";
		display += this.enddatetime != null ? " - " + this.enddatetime.toString() : " - Ongoing";
		return display;
	}
	/**
	* createDisplayString - used in Clinical.PatientSummary
	*/
	public String createDisplayString()
	{
		String strClinContact = this.getStartDateTimeIsNotNull() ? this.getStartDateTime().toString() : "";
		if(this.getCurrentStatusIsNotNull()&&ims.core.vo.lookups.ClinicalContactStatus.CANCELLED.equals(  this.getCurrentStatus().getStatus()))
		{
			strClinContact += this.getEndDateTimeIsNotNull() ? " - " + this.getEndDateTime().toString() + " - Cancelled " : " - Cancelled";
		}
		else
			strClinContact += this.getEndDateTimeIsNotNull() ? " - " + this.getEndDateTime().toString() : "";
	
		return strClinContact;
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
		if(this.seenby != null)
		{
			if(!this.seenby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
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
		if(this.seenby == null)
			listOfErrors.add("Seen By for 'Clinical Contact' is mandatory.");
		if(this.seenby != null)
		{
			String[] listOfOtherErrors = this.seenby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.contacttype == null)
			listOfErrors.add("Contact Type for 'Clinical Contact' is mandatory.");
		if(this.startdatetime == null)
			listOfErrors.add("Seen Date/Time for 'Clinical Contact' is mandatory.");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
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
	
		ClinicalContactShortVo clone = new ClinicalContactShortVo(this.id, this.version);
		
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.seenby == null)
			clone.seenby = null;
		else
			clone.seenby = (ims.core.vo.HcpLiteVo)this.seenby.clone();
		if(this.contacttype == null)
			clone.contacttype = null;
		else
			clone.contacttype = (ims.core.vo.lookups.ContactType)this.contacttype.clone();
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		if(this.enddatetime == null)
			clone.enddatetime = null;
		else
			clone.enddatetime = (ims.framework.utils.DateTime)this.enddatetime.clone();
		clone.carecontext = this.carecontext;
		clone.isclinicalnotecreated = this.isclinicalnotecreated;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.core.vo.ClinicalContactStatusHistoryVo)this.currentstatus.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.core.vo.ClinicalContactStatusHistoryVoCollection)this.statushistory.clone();
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
		if (!(ClinicalContactShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalContactShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicalContactShortVo compareObj = (ClinicalContactShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStartDateTime() == null && compareObj.getStartDateTime() != null)
				return -1;
			if(this.getStartDateTime() != null && compareObj.getStartDateTime() == null)
				return 1;
			if(this.getStartDateTime() != null && compareObj.getStartDateTime() != null)
				retVal = this.getStartDateTime().compareTo(compareObj.getStartDateTime());
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
		if(this.specialty != null)
			count++;
		if(this.seenby != null)
			count++;
		if(this.contacttype != null)
			count++;
		if(this.startdatetime != null)
			count++;
		if(this.enddatetime != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.isclinicalnotecreated != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.HcpLiteVo seenby;
	protected ims.core.vo.lookups.ContactType contacttype;
	protected ims.framework.utils.DateTime startdatetime;
	protected ims.framework.utils.DateTime enddatetime;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected Boolean isclinicalnotecreated;
	protected ims.core.vo.ClinicalContactStatusHistoryVo currentstatus;
	protected ims.core.vo.ClinicalContactStatusHistoryVoCollection statushistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
