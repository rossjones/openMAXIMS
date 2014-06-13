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

package ims.emergency.vo;

/**
 * Linked to emergency.ReferralToSpecTeam business object (ID: 1086100003).
 */
public class ReferralToSpecialtyTeamForEventHistoryVo extends ims.emergency.vo.ReferralToSpecTeamRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralToSpecialtyTeamForEventHistoryVo()
	{
	}
	public ReferralToSpecialtyTeamForEventHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralToSpecialtyTeamForEventHistoryVo(ims.emergency.vo.beans.ReferralToSpecialtyTeamForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.teamconsultant = bean.getTeamConsultant() == null ? null : ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam.buildLookup(bean.getTeamConsultant());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.referreddatetime = bean.getReferredDateTime() == null ? null : bean.getReferredDateTime().buildDateTime();
		this.seendatetime = bean.getSeenDateTime() == null ? null : bean.getSeenDateTime().buildDateTime();
		this.completiondatetime = bean.getCompletionDateTime() == null ? null : bean.getCompletionDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ReferralToSpecialtyTeamForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.teamconsultant = bean.getTeamConsultant() == null ? null : ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam.buildLookup(bean.getTeamConsultant());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.referreddatetime = bean.getReferredDateTime() == null ? null : bean.getReferredDateTime().buildDateTime();
		this.seendatetime = bean.getSeenDateTime() == null ? null : bean.getSeenDateTime().buildDateTime();
		this.completiondatetime = bean.getCompletionDateTime() == null ? null : bean.getCompletionDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ReferralToSpecialtyTeamForEventHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ReferralToSpecialtyTeamForEventHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ReferralToSpecialtyTeamForEventHistoryVoBean();
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
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("TEAMCONSULTANT"))
			return getTeamConsultant();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("REFERREDDATETIME"))
			return getReferredDateTime();
		if(fieldName.equals("SEENDATETIME"))
			return getSeenDateTime();
		if(fieldName.equals("COMPLETIONDATETIME"))
			return getCompletionDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getTeamConsultantIsNotNull()
	{
		return this.teamconsultant != null;
	}
	public ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam getTeamConsultant()
	{
		return this.teamconsultant;
	}
	public void setTeamConsultant(ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam value)
	{
		this.isValidated = false;
		this.teamconsultant = value;
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
	public boolean getReferredDateTimeIsNotNull()
	{
		return this.referreddatetime != null;
	}
	public ims.framework.utils.DateTime getReferredDateTime()
	{
		return this.referreddatetime;
	}
	public void setReferredDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.referreddatetime = value;
	}
	public boolean getSeenDateTimeIsNotNull()
	{
		return this.seendatetime != null;
	}
	public ims.framework.utils.DateTime getSeenDateTime()
	{
		return this.seendatetime;
	}
	public void setSeenDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.seendatetime = value;
	}
	public boolean getCompletionDateTimeIsNotNull()
	{
		return this.completiondatetime != null;
	}
	public ims.framework.utils.DateTime getCompletionDateTime()
	{
		return this.completiondatetime;
	}
	public void setCompletionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completiondatetime = value;
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
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.specialty == null)
			listOfErrors.add("Specialty is mandatory");
		if(this.referreddatetime == null)
			listOfErrors.add("ReferredDateTime is mandatory");
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
	
		ReferralToSpecialtyTeamForEventHistoryVo clone = new ReferralToSpecialtyTeamForEventHistoryVo(this.id, this.version);
		
		clone.attendance = this.attendance;
		if(this.teamconsultant == null)
			clone.teamconsultant = null;
		else
			clone.teamconsultant = (ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam)this.teamconsultant.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.referreddatetime == null)
			clone.referreddatetime = null;
		else
			clone.referreddatetime = (ims.framework.utils.DateTime)this.referreddatetime.clone();
		if(this.seendatetime == null)
			clone.seendatetime = null;
		else
			clone.seendatetime = (ims.framework.utils.DateTime)this.seendatetime.clone();
		if(this.completiondatetime == null)
			clone.completiondatetime = null;
		else
			clone.completiondatetime = (ims.framework.utils.DateTime)this.completiondatetime.clone();
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
		if (!(ReferralToSpecialtyTeamForEventHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralToSpecialtyTeamForEventHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralToSpecialtyTeamForEventHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralToSpecialtyTeamForEventHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.attendance != null)
			count++;
		if(this.teamconsultant != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.referreddatetime != null)
			count++;
		if(this.seendatetime != null)
			count++;
		if(this.completiondatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam teamconsultant;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.framework.utils.DateTime referreddatetime;
	protected ims.framework.utils.DateTime seendatetime;
	protected ims.framework.utils.DateTime completiondatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
