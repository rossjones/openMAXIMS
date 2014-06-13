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

package ims.ocs_if.vo;

/**
 * Linked to OCRR.OrderingResults.ClinicalResultDetail business object (ID: 1070100009).
 */
public class IfOcsRadResultVo extends ims.ocrr.orderingresults.vo.ClinicalResultDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfOcsRadResultVo()
	{
	}
	public IfOcsRadResultVo(Integer id, int version)
	{
		super(id, version);
	}
	public IfOcsRadResultVo(ims.ocs_if.vo.beans.IfOcsRadResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.examdatetime = bean.getExamDateTime() == null ? null : bean.getExamDateTime().buildDateTime();
		this.examtimesupplied = bean.getExamTimeSupplied();
		this.authoringradiologistname = bean.getAuthoringRadiologistName();
		this.verifyingradiologistname = bean.getVerifyingRadiologistName();
		this.radiographername = bean.getRadiographerName();
		this.transcribername = bean.getTranscriberName();
		this.reporttext = bean.getReportText();
		if(bean.getResultComments() != null)
		{
			this.resultcomments = new ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection();
			for(int resultcomments_i = 0; resultcomments_i < bean.getResultComments().length; resultcomments_i++)
			{
				this.resultcomments.add(new ims.ocrr.orderingresults.vo.ResultCommentRefVo(new Integer(bean.getResultComments()[resultcomments_i].getId()), bean.getResultComments()[resultcomments_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.IfOcsRadResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.examdatetime = bean.getExamDateTime() == null ? null : bean.getExamDateTime().buildDateTime();
		this.examtimesupplied = bean.getExamTimeSupplied();
		this.authoringradiologistname = bean.getAuthoringRadiologistName();
		this.verifyingradiologistname = bean.getVerifyingRadiologistName();
		this.radiographername = bean.getRadiographerName();
		this.transcribername = bean.getTranscriberName();
		this.reporttext = bean.getReportText();
		if(bean.getResultComments() != null)
		{
			this.resultcomments = new ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection();
			for(int resultcomments_i = 0; resultcomments_i < bean.getResultComments().length; resultcomments_i++)
			{
				this.resultcomments.add(new ims.ocrr.orderingresults.vo.ResultCommentRefVo(new Integer(bean.getResultComments()[resultcomments_i].getId()), bean.getResultComments()[resultcomments_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.IfOcsRadResultVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.IfOcsRadResultVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.IfOcsRadResultVoBean();
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
		if(fieldName.equals("EXAMDATETIME"))
			return getExamDateTime();
		if(fieldName.equals("EXAMTIMESUPPLIED"))
			return getExamTimeSupplied();
		if(fieldName.equals("AUTHORINGRADIOLOGISTNAME"))
			return getAuthoringRadiologistName();
		if(fieldName.equals("VERIFYINGRADIOLOGISTNAME"))
			return getVerifyingRadiologistName();
		if(fieldName.equals("RADIOGRAPHERNAME"))
			return getRadiographerName();
		if(fieldName.equals("TRANSCRIBERNAME"))
			return getTranscriberName();
		if(fieldName.equals("REPORTTEXT"))
			return getReportText();
		if(fieldName.equals("RESULTCOMMENTS"))
			return getResultComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getExamDateTimeIsNotNull()
	{
		return this.examdatetime != null;
	}
	public ims.framework.utils.DateTime getExamDateTime()
	{
		return this.examdatetime;
	}
	public void setExamDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.examdatetime = value;
	}
	public boolean getExamTimeSuppliedIsNotNull()
	{
		return this.examtimesupplied != null;
	}
	public Boolean getExamTimeSupplied()
	{
		return this.examtimesupplied;
	}
	public void setExamTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.examtimesupplied = value;
	}
	public boolean getAuthoringRadiologistNameIsNotNull()
	{
		return this.authoringradiologistname != null;
	}
	public String getAuthoringRadiologistName()
	{
		return this.authoringradiologistname;
	}
	public static int getAuthoringRadiologistNameMaxLength()
	{
		return 100;
	}
	public void setAuthoringRadiologistName(String value)
	{
		this.isValidated = false;
		this.authoringradiologistname = value;
	}
	public boolean getVerifyingRadiologistNameIsNotNull()
	{
		return this.verifyingradiologistname != null;
	}
	public String getVerifyingRadiologistName()
	{
		return this.verifyingradiologistname;
	}
	public static int getVerifyingRadiologistNameMaxLength()
	{
		return 100;
	}
	public void setVerifyingRadiologistName(String value)
	{
		this.isValidated = false;
		this.verifyingradiologistname = value;
	}
	public boolean getRadiographerNameIsNotNull()
	{
		return this.radiographername != null;
	}
	public String getRadiographerName()
	{
		return this.radiographername;
	}
	public static int getRadiographerNameMaxLength()
	{
		return 100;
	}
	public void setRadiographerName(String value)
	{
		this.isValidated = false;
		this.radiographername = value;
	}
	public boolean getTranscriberNameIsNotNull()
	{
		return this.transcribername != null;
	}
	public String getTranscriberName()
	{
		return this.transcribername;
	}
	public static int getTranscriberNameMaxLength()
	{
		return 100;
	}
	public void setTranscriberName(String value)
	{
		this.isValidated = false;
		this.transcribername = value;
	}
	public boolean getReportTextIsNotNull()
	{
		return this.reporttext != null;
	}
	public String getReportText()
	{
		return this.reporttext;
	}
	public static int getReportTextMaxLength()
	{
		return 64000;
	}
	public void setReportText(String value)
	{
		this.isValidated = false;
		this.reporttext = value;
	}
	public boolean getResultCommentsIsNotNull()
	{
		return this.resultcomments != null;
	}
	public ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection getResultComments()
	{
		return this.resultcomments;
	}
	public void setResultComments(ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection value)
	{
		this.isValidated = false;
		this.resultcomments = value;
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
		if(this.examdatetime == null)
			listOfErrors.add("ExamDateTime is mandatory");
		if(this.examtimesupplied == null)
			listOfErrors.add("ExamTimeSupplied is mandatory");
		if(this.authoringradiologistname != null)
			if(this.authoringradiologistname.length() > 100)
				listOfErrors.add("The length of the field [authoringradiologistname] in the value object [ims.ocs_if.vo.IfOcsRadResultVo] is too big. It should be less or equal to 100");
		if(this.verifyingradiologistname != null)
			if(this.verifyingradiologistname.length() > 100)
				listOfErrors.add("The length of the field [verifyingradiologistname] in the value object [ims.ocs_if.vo.IfOcsRadResultVo] is too big. It should be less or equal to 100");
		if(this.radiographername != null)
			if(this.radiographername.length() > 100)
				listOfErrors.add("The length of the field [radiographername] in the value object [ims.ocs_if.vo.IfOcsRadResultVo] is too big. It should be less or equal to 100");
		if(this.transcribername != null)
			if(this.transcribername.length() > 100)
				listOfErrors.add("The length of the field [transcribername] in the value object [ims.ocs_if.vo.IfOcsRadResultVo] is too big. It should be less or equal to 100");
		if(this.reporttext == null || this.reporttext.length() == 0)
			listOfErrors.add("ReportText is mandatory");
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
	
		IfOcsRadResultVo clone = new IfOcsRadResultVo(this.id, this.version);
		
		if(this.examdatetime == null)
			clone.examdatetime = null;
		else
			clone.examdatetime = (ims.framework.utils.DateTime)this.examdatetime.clone();
		clone.examtimesupplied = this.examtimesupplied;
		clone.authoringradiologistname = this.authoringradiologistname;
		clone.verifyingradiologistname = this.verifyingradiologistname;
		clone.radiographername = this.radiographername;
		clone.transcribername = this.transcribername;
		clone.reporttext = this.reporttext;
		clone.resultcomments = this.resultcomments;
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
		if (!(IfOcsRadResultVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfOcsRadResultVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IfOcsRadResultVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IfOcsRadResultVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.examdatetime != null)
			count++;
		if(this.examtimesupplied != null)
			count++;
		if(this.authoringradiologistname != null)
			count++;
		if(this.verifyingradiologistname != null)
			count++;
		if(this.radiographername != null)
			count++;
		if(this.transcribername != null)
			count++;
		if(this.reporttext != null)
			count++;
		if(this.resultcomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.framework.utils.DateTime examdatetime;
	protected Boolean examtimesupplied;
	protected String authoringradiologistname;
	protected String verifyingradiologistname;
	protected String radiographername;
	protected String transcribername;
	protected String reporttext;
	protected ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection resultcomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
