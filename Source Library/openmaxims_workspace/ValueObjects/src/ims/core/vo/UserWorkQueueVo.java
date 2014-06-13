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
 * Linked to core.resource.place.UserWorkQueue business object (ID: 1038100000).
 */
public class UserWorkQueueVo extends ims.core.resource.place.vo.UserWorkQueueRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserWorkQueueVo()
	{
	}
	public UserWorkQueueVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserWorkQueueVo(ims.core.vo.beans.UserWorkQueueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.targetuser = bean.getTargetUser() == null ? null : bean.getTargetUser().buildVo();
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo();
		this.requestdatetime = bean.getRequestDateTime() == null ? null : bean.getRequestDateTime().buildDateTime();
		this.requiredondate = bean.getRequiredOnDate() == null ? null : bean.getRequiredOnDate().buildDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.ntpf.vo.lookups.WorkQueueStatus.buildLookup(bean.getCurrentStatus());
		this.requestingobjectid = bean.getRequestingObjectID();
		this.description = bean.getDescription();
		this.targetobjectid = bean.getTargetObjectID();
		this.requestingform = bean.getRequestingForm() == null ? null : bean.getRequestingForm().buildFormName();
		this.targetform = bean.getTargetForm() == null ? null : bean.getTargetForm().buildFormName();
		this.requesttype = bean.getRequestType() == null ? null : bean.getRequestType().buildVo();
		this.statushistory = ims.core.vo.WorkQueueStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.orignotetype = bean.getOrigNoteType() == null ? null : ims.ntpf.vo.lookups.CommentContextType.buildLookup(bean.getOrigNoteType());
		this.comments = bean.getComments();
		this.procedurelocationservice = bean.getProcedureLocationService() == null ? null : new ims.core.resource.place.vo.LocationServiceRefVo(new Integer(bean.getProcedureLocationService().getId()), bean.getProcedureLocationService().getVersion());
		this.procedureactivity = bean.getProcedureActivity() == null ? null : new ims.core.resource.place.vo.ActivityRefVo(new Integer(bean.getProcedureActivity().getId()), bean.getProcedureActivity().getVersion());
		this.procedurecontext = bean.getProcedureContext() == null ? null : ims.core.vo.lookups.ProcedureContext.buildLookup(bean.getProcedureContext());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.UserWorkQueueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.targetuser = bean.getTargetUser() == null ? null : bean.getTargetUser().buildVo(map);
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo(map);
		this.requestdatetime = bean.getRequestDateTime() == null ? null : bean.getRequestDateTime().buildDateTime();
		this.requiredondate = bean.getRequiredOnDate() == null ? null : bean.getRequiredOnDate().buildDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.ntpf.vo.lookups.WorkQueueStatus.buildLookup(bean.getCurrentStatus());
		this.requestingobjectid = bean.getRequestingObjectID();
		this.description = bean.getDescription();
		this.targetobjectid = bean.getTargetObjectID();
		this.requestingform = bean.getRequestingForm() == null ? null : bean.getRequestingForm().buildFormName();
		this.targetform = bean.getTargetForm() == null ? null : bean.getTargetForm().buildFormName();
		this.requesttype = bean.getRequestType() == null ? null : bean.getRequestType().buildVo(map);
		this.statushistory = ims.core.vo.WorkQueueStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.orignotetype = bean.getOrigNoteType() == null ? null : ims.ntpf.vo.lookups.CommentContextType.buildLookup(bean.getOrigNoteType());
		this.comments = bean.getComments();
		this.procedurelocationservice = bean.getProcedureLocationService() == null ? null : new ims.core.resource.place.vo.LocationServiceRefVo(new Integer(bean.getProcedureLocationService().getId()), bean.getProcedureLocationService().getVersion());
		this.procedureactivity = bean.getProcedureActivity() == null ? null : new ims.core.resource.place.vo.ActivityRefVo(new Integer(bean.getProcedureActivity().getId()), bean.getProcedureActivity().getVersion());
		this.procedurecontext = bean.getProcedureContext() == null ? null : ims.core.vo.lookups.ProcedureContext.buildLookup(bean.getProcedureContext());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.UserWorkQueueVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.UserWorkQueueVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.UserWorkQueueVoBean();
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
		if(fieldName.equals("TARGETUSER"))
			return getTargetUser();
		if(fieldName.equals("REQUESTEDBY"))
			return getRequestedBy();
		if(fieldName.equals("REQUESTDATETIME"))
			return getRequestDateTime();
		if(fieldName.equals("REQUIREDONDATE"))
			return getRequiredOnDate();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("REQUESTINGOBJECTID"))
			return getRequestingObjectID();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("TARGETOBJECTID"))
			return getTargetObjectID();
		if(fieldName.equals("REQUESTINGFORM"))
			return getRequestingForm();
		if(fieldName.equals("TARGETFORM"))
			return getTargetForm();
		if(fieldName.equals("REQUESTTYPE"))
			return getRequestType();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("ORIGNOTETYPE"))
			return getOrigNoteType();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("PROCEDURELOCATIONSERVICE"))
			return getProcedureLocationService();
		if(fieldName.equals("PROCEDUREACTIVITY"))
			return getProcedureActivity();
		if(fieldName.equals("PROCEDURECONTEXT"))
			return getProcedureContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTargetUserIsNotNull()
	{
		return this.targetuser != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getTargetUser()
	{
		return this.targetuser;
	}
	public void setTargetUser(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.targetuser = value;
	}
	public boolean getRequestedByIsNotNull()
	{
		return this.requestedby != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.requestedby = value;
	}
	public boolean getRequestDateTimeIsNotNull()
	{
		return this.requestdatetime != null;
	}
	public ims.framework.utils.DateTime getRequestDateTime()
	{
		return this.requestdatetime;
	}
	public void setRequestDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.requestdatetime = value;
	}
	public boolean getRequiredOnDateIsNotNull()
	{
		return this.requiredondate != null;
	}
	public ims.framework.utils.Date getRequiredOnDate()
	{
		return this.requiredondate;
	}
	public void setRequiredOnDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.requiredondate = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.ntpf.vo.lookups.WorkQueueStatus getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.ntpf.vo.lookups.WorkQueueStatus value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getRequestingObjectIDIsNotNull()
	{
		return this.requestingobjectid != null;
	}
	public Integer getRequestingObjectID()
	{
		return this.requestingobjectid;
	}
	public void setRequestingObjectID(Integer value)
	{
		this.isValidated = false;
		this.requestingobjectid = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 1500;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getTargetObjectIDIsNotNull()
	{
		return this.targetobjectid != null;
	}
	public Integer getTargetObjectID()
	{
		return this.targetobjectid;
	}
	public void setTargetObjectID(Integer value)
	{
		this.isValidated = false;
		this.targetobjectid = value;
	}
	public boolean getRequestingFormIsNotNull()
	{
		return this.requestingform != null;
	}
	public ims.framework.FormName getRequestingForm()
	{
		return this.requestingform;
	}
	public void setRequestingForm(ims.framework.FormName value)
	{
		this.isValidated = false;
		this.requestingform = value;
	}
	public boolean getTargetFormIsNotNull()
	{
		return this.targetform != null;
	}
	public ims.framework.FormName getTargetForm()
	{
		return this.targetform;
	}
	public void setTargetForm(ims.framework.FormName value)
	{
		this.isValidated = false;
		this.targetform = value;
	}
	public boolean getRequestTypeIsNotNull()
	{
		return this.requesttype != null;
	}
	public ims.core.vo.ActivityVo getRequestType()
	{
		return this.requesttype;
	}
	public void setRequestType(ims.core.vo.ActivityVo value)
	{
		this.isValidated = false;
		this.requesttype = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.core.vo.WorkQueueStatusHistoryVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.WorkQueueStatusHistoryVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getOrigNoteTypeIsNotNull()
	{
		return this.orignotetype != null;
	}
	public ims.ntpf.vo.lookups.CommentContextType getOrigNoteType()
	{
		return this.orignotetype;
	}
	public void setOrigNoteType(ims.ntpf.vo.lookups.CommentContextType value)
	{
		this.isValidated = false;
		this.orignotetype = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getProcedureLocationServiceIsNotNull()
	{
		return this.procedurelocationservice != null;
	}
	public ims.core.resource.place.vo.LocationServiceRefVo getProcedureLocationService()
	{
		return this.procedurelocationservice;
	}
	public void setProcedureLocationService(ims.core.resource.place.vo.LocationServiceRefVo value)
	{
		this.isValidated = false;
		this.procedurelocationservice = value;
	}
	public boolean getProcedureActivityIsNotNull()
	{
		return this.procedureactivity != null;
	}
	public ims.core.resource.place.vo.ActivityRefVo getProcedureActivity()
	{
		return this.procedureactivity;
	}
	public void setProcedureActivity(ims.core.resource.place.vo.ActivityRefVo value)
	{
		this.isValidated = false;
		this.procedureactivity = value;
	}
	public boolean getProcedureContextIsNotNull()
	{
		return this.procedurecontext != null;
	}
	public ims.core.vo.lookups.ProcedureContext getProcedureContext()
	{
		return this.procedurecontext;
	}
	public void setProcedureContext(ims.core.vo.lookups.ProcedureContext value)
	{
		this.isValidated = false;
		this.procedurecontext = value;
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
		if(this.requesttype != null)
		{
			if(!this.requesttype.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
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
		if(this.description != null)
			if(this.description.length() > 1500)
				listOfErrors.add("The length of the field [description] in the value object [ims.core.vo.UserWorkQueueVo] is too big. It should be less or equal to 1500");
		if(this.requesttype != null)
		{
			String[] listOfOtherErrors = this.requesttype.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.statushistory != null)
		{
			String[] listOfOtherErrors = this.statushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments != null)
			if(this.comments.length() > 1500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.UserWorkQueueVo] is too big. It should be less or equal to 1500");
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
	
		UserWorkQueueVo clone = new UserWorkQueueVo(this.id, this.version);
		
		if(this.targetuser == null)
			clone.targetuser = null;
		else
			clone.targetuser = (ims.core.vo.MemberOfStaffShortVo)this.targetuser.clone();
		if(this.requestedby == null)
			clone.requestedby = null;
		else
			clone.requestedby = (ims.core.vo.MemberOfStaffShortVo)this.requestedby.clone();
		if(this.requestdatetime == null)
			clone.requestdatetime = null;
		else
			clone.requestdatetime = (ims.framework.utils.DateTime)this.requestdatetime.clone();
		if(this.requiredondate == null)
			clone.requiredondate = null;
		else
			clone.requiredondate = (ims.framework.utils.Date)this.requiredondate.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.ntpf.vo.lookups.WorkQueueStatus)this.currentstatus.clone();
		clone.requestingobjectid = this.requestingobjectid;
		clone.description = this.description;
		clone.targetobjectid = this.targetobjectid;
		if(this.requestingform == null)
			clone.requestingform = null;
		else
			clone.requestingform = (ims.framework.FormName)this.requestingform.clone();
		if(this.targetform == null)
			clone.targetform = null;
		else
			clone.targetform = (ims.framework.FormName)this.targetform.clone();
		if(this.requesttype == null)
			clone.requesttype = null;
		else
			clone.requesttype = (ims.core.vo.ActivityVo)this.requesttype.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.core.vo.WorkQueueStatusHistoryVoCollection)this.statushistory.clone();
		if(this.orignotetype == null)
			clone.orignotetype = null;
		else
			clone.orignotetype = (ims.ntpf.vo.lookups.CommentContextType)this.orignotetype.clone();
		clone.comments = this.comments;
		clone.procedurelocationservice = this.procedurelocationservice;
		clone.procedureactivity = this.procedureactivity;
		if(this.procedurecontext == null)
			clone.procedurecontext = null;
		else
			clone.procedurecontext = (ims.core.vo.lookups.ProcedureContext)this.procedurecontext.clone();
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
		if (!(UserWorkQueueVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserWorkQueueVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		UserWorkQueueVo compareObj = (UserWorkQueueVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getRequestDateTime() == null && compareObj.getRequestDateTime() != null)
				return -1;
			if(this.getRequestDateTime() != null && compareObj.getRequestDateTime() == null)
				return 1;
			if(this.getRequestDateTime() != null && compareObj.getRequestDateTime() != null)
				retVal = this.getRequestDateTime().compareTo(compareObj.getRequestDateTime());
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
		if(this.targetuser != null)
			count++;
		if(this.requestedby != null)
			count++;
		if(this.requestdatetime != null)
			count++;
		if(this.requiredondate != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.requestingobjectid != null)
			count++;
		if(this.description != null)
			count++;
		if(this.targetobjectid != null)
			count++;
		if(this.requestingform != null)
			count++;
		if(this.targetform != null)
			count++;
		if(this.requesttype != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.orignotetype != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.procedurelocationservice != null)
			count++;
		if(this.procedureactivity != null)
			count++;
		if(this.procedurecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.vo.MemberOfStaffShortVo targetuser;
	protected ims.core.vo.MemberOfStaffShortVo requestedby;
	protected ims.framework.utils.DateTime requestdatetime;
	protected ims.framework.utils.Date requiredondate;
	protected ims.ntpf.vo.lookups.WorkQueueStatus currentstatus;
	protected Integer requestingobjectid;
	protected String description;
	protected Integer targetobjectid;
	protected ims.framework.FormName requestingform;
	protected ims.framework.FormName targetform;
	protected ims.core.vo.ActivityVo requesttype;
	protected ims.core.vo.WorkQueueStatusHistoryVoCollection statushistory;
	protected ims.ntpf.vo.lookups.CommentContextType orignotetype;
	protected String comments;
	protected ims.core.resource.place.vo.LocationServiceRefVo procedurelocationservice;
	protected ims.core.resource.place.vo.ActivityRefVo procedureactivity;
	protected ims.core.vo.lookups.ProcedureContext procedurecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
