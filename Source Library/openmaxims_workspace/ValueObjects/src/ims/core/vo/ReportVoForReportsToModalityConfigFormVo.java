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
 * Linked to core.admin.ReportBo business object (ID: 1004100009).
 */
public class ReportVoForReportsToModalityConfigFormVo extends ims.core.admin.vo.ReportBoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReportVoForReportsToModalityConfigFormVo()
	{
	}
	public ReportVoForReportsToModalityConfigFormVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReportVoForReportsToModalityConfigFormVo(ims.core.vo.beans.ReportVoForReportsToModalityConfigFormVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.isactive = bean.getIsActive();
		this.seeds = ims.admin.vo.ReportSeedVoCollection.buildFromBeanCollection(bean.getSeeds());
		this.imsid = bean.getImsId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ReportVoForReportsToModalityConfigFormVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.isactive = bean.getIsActive();
		this.seeds = ims.admin.vo.ReportSeedVoCollection.buildFromBeanCollection(bean.getSeeds());
		this.imsid = bean.getImsId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ReportVoForReportsToModalityConfigFormVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ReportVoForReportsToModalityConfigFormVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ReportVoForReportsToModalityConfigFormVoBean();
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
		if(fieldName.equals("REPORTNAME"))
			return getReportName();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("SEEDS"))
			return getSeeds();
		if(fieldName.equals("IMSID"))
			return getImsId();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReportNameIsNotNull()
	{
		return this.reportname != null;
	}
	public String getReportName()
	{
		return this.reportname;
	}
	public static int getReportNameMaxLength()
	{
		return 255;
	}
	public void setReportName(String value)
	{
		this.isValidated = false;
		this.reportname = value;
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
	public boolean getSeedsIsNotNull()
	{
		return this.seeds != null;
	}
	public ims.admin.vo.ReportSeedVoCollection getSeeds()
	{
		return this.seeds;
	}
	public void setSeeds(ims.admin.vo.ReportSeedVoCollection value)
	{
		this.isValidated = false;
		this.seeds = value;
	}
	public boolean getImsIdIsNotNull()
	{
		return this.imsid != null;
	}
	public Integer getImsId()
	{
		return this.imsid;
	}
	public void setImsId(Integer value)
	{
		this.isValidated = false;
		this.imsid = value;
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
		if(this.reportname == null || this.reportname.length() == 0)
			listOfErrors.add("reportName is mandatory");
		else if(this.reportname.length() > 255)
			listOfErrors.add("The length of the field [reportname] in the value object [ims.core.vo.ReportVoForReportsToModalityConfigFormVo] is too big. It should be less or equal to 255");
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
	
		ReportVoForReportsToModalityConfigFormVo clone = new ReportVoForReportsToModalityConfigFormVo(this.id, this.version);
		
		clone.reportname = this.reportname;
		clone.isactive = this.isactive;
		if(this.seeds == null)
			clone.seeds = null;
		else
			clone.seeds = (ims.admin.vo.ReportSeedVoCollection)this.seeds.clone();
		clone.imsid = this.imsid;
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
		if (!(ReportVoForReportsToModalityConfigFormVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReportVoForReportsToModalityConfigFormVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReportVoForReportsToModalityConfigFormVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReportVoForReportsToModalityConfigFormVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.reportname != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.seeds != null)
			count++;
		if(this.imsid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String reportname;
	protected Boolean isactive;
	protected ims.admin.vo.ReportSeedVoCollection seeds;
	protected Integer imsid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
