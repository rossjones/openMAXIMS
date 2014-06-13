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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.Configuration.TumourGroupSiteOverallStaging business object (ID: 1074100013).
 */
public class TumourGroupSiteOverallStagingLiteVo extends ims.oncology.configuration.vo.TumourGroupSiteOverallStagingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourGroupSiteOverallStagingLiteVo()
	{
	}
	public TumourGroupSiteOverallStagingLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourGroupSiteOverallStagingLiteVo(ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.overallstagedescription = bean.getOverallStageDescription() == null ? null : ims.oncology.vo.lookups.TumourOverallStage.buildLookup(bean.getOverallStageDescription());
		this.isactive = bean.getIsActive();
		this.o45 = bean.getO45();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.overallstagedescription = bean.getOverallStageDescription() == null ? null : ims.oncology.vo.lookups.TumourOverallStage.buildLookup(bean.getOverallStageDescription());
		this.isactive = bean.getIsActive();
		this.o45 = bean.getO45();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean();
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
		if(fieldName.equals("OVERALLSTAGEDESCRIPTION"))
			return getOverallStageDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("O45"))
			return getO45();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOverallStageDescriptionIsNotNull()
	{
		return this.overallstagedescription != null;
	}
	public ims.oncology.vo.lookups.TumourOverallStage getOverallStageDescription()
	{
		return this.overallstagedescription;
	}
	public void setOverallStageDescription(ims.oncology.vo.lookups.TumourOverallStage value)
	{
		this.isValidated = false;
		this.overallstagedescription = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getO45IsNotNull()
	{
		return this.o45 != null;
	}
	public String getO45()
	{
		return this.o45;
	}
	public static int getO45MaxLength()
	{
		return 1;
	}
	public void setO45(String value)
	{
		this.isValidated = false;
		this.o45 = value;
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
		if(this.overallstagedescription == null)
			listOfErrors.add("Overall Staging Value is mandatory");
		if(this.o45 != null)
			if(this.o45.length() > 1)
				listOfErrors.add("The length of the field [o45] in the value object [ims.clinicaladmin.vo.TumourGroupSiteOverallStagingLiteVo] is too big. It should be less or equal to 1");
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
	
		TumourGroupSiteOverallStagingLiteVo clone = new TumourGroupSiteOverallStagingLiteVo(this.id, this.version);
		
		if(this.overallstagedescription == null)
			clone.overallstagedescription = null;
		else
			clone.overallstagedescription = (ims.oncology.vo.lookups.TumourOverallStage)this.overallstagedescription.clone();
		clone.isactive = this.isactive;
		clone.o45 = this.o45;
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
		if (!(TumourGroupSiteOverallStagingLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourGroupSiteOverallStagingLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourGroupSiteOverallStagingLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourGroupSiteOverallStagingLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.overallstagedescription != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.o45 != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.oncology.vo.lookups.TumourOverallStage overallstagedescription;
	protected Boolean isactive;
	protected String o45;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
