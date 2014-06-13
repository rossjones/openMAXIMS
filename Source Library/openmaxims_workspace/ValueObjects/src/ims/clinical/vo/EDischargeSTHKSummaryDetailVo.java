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

/**
 * Linked to eDischarge.SummaryDetail business object (ID: 1099100019).
 */
public class EDischargeSTHKSummaryDetailVo extends ims.edischarge.vo.SummaryDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EDischargeSTHKSummaryDetailVo()
	{
	}
	public EDischargeSTHKSummaryDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public EDischargeSTHKSummaryDetailVo(ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.section = bean.getSection() == null ? null : ims.clinical.vo.lookups.EDischargeSummarySection.buildLookup(bean.getSection());
		this.progressstatus = bean.getProgressStatus() == null ? null : ims.clinical.vo.lookups.EDischargeSummarySectionStatus.buildLookup(bean.getProgressStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.section = bean.getSection() == null ? null : ims.clinical.vo.lookups.EDischargeSummarySection.buildLookup(bean.getSection());
		this.progressstatus = bean.getProgressStatus() == null ? null : ims.clinical.vo.lookups.EDischargeSummarySectionStatus.buildLookup(bean.getProgressStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean();
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
		if(fieldName.equals("SECTION"))
			return getSection();
		if(fieldName.equals("PROGRESSSTATUS"))
			return getProgressStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSectionIsNotNull()
	{
		return this.section != null;
	}
	public ims.clinical.vo.lookups.EDischargeSummarySection getSection()
	{
		return this.section;
	}
	public void setSection(ims.clinical.vo.lookups.EDischargeSummarySection value)
	{
		this.isValidated = false;
		this.section = value;
	}
	public boolean getProgressStatusIsNotNull()
	{
		return this.progressstatus != null;
	}
	public ims.clinical.vo.lookups.EDischargeSummarySectionStatus getProgressStatus()
	{
		return this.progressstatus;
	}
	public void setProgressStatus(ims.clinical.vo.lookups.EDischargeSummarySectionStatus value)
	{
		this.isValidated = false;
		this.progressstatus = value;
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
		if(this.section == null)
			listOfErrors.add("Section is mandatory");
		if(this.progressstatus == null)
			listOfErrors.add("ProgressStatus is mandatory");
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
	
		EDischargeSTHKSummaryDetailVo clone = new EDischargeSTHKSummaryDetailVo(this.id, this.version);
		
		if(this.section == null)
			clone.section = null;
		else
			clone.section = (ims.clinical.vo.lookups.EDischargeSummarySection)this.section.clone();
		if(this.progressstatus == null)
			clone.progressstatus = null;
		else
			clone.progressstatus = (ims.clinical.vo.lookups.EDischargeSummarySectionStatus)this.progressstatus.clone();
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
		if (!(EDischargeSTHKSummaryDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EDischargeSTHKSummaryDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EDischargeSTHKSummaryDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EDischargeSTHKSummaryDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.section != null)
			count++;
		if(this.progressstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinical.vo.lookups.EDischargeSummarySection section;
	protected ims.clinical.vo.lookups.EDischargeSummarySectionStatus progressstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
