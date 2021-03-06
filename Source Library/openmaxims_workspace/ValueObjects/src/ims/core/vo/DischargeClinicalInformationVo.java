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
 * Linked to eDischarge.DischargeClinicalInformation business object (ID: 1072100071).
 */
public class DischargeClinicalInformationVo extends ims.edischarge.vo.DischargeClinicalInformationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeClinicalInformationVo()
	{
	}
	public DischargeClinicalInformationVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeClinicalInformationVo(ims.core.vo.beans.DischargeClinicalInformationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.presentingcomplaints = bean.getPresentingComplaints();
		this.summaryofadmission = bean.getSummaryOfAdmission();
		this.investigationcomments = bean.getInvestigationComments();
		this.relevanttreatments = bean.getRelevantTreatments();
		this.additionalcomments = bean.getAdditionalComments();
		this.results = ims.ocrr.vo.OrderInvestigationBookingVoCollection.buildFromBeanCollection(bean.getResults());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DischargeClinicalInformationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.presentingcomplaints = bean.getPresentingComplaints();
		this.summaryofadmission = bean.getSummaryOfAdmission();
		this.investigationcomments = bean.getInvestigationComments();
		this.relevanttreatments = bean.getRelevantTreatments();
		this.additionalcomments = bean.getAdditionalComments();
		this.results = ims.ocrr.vo.OrderInvestigationBookingVoCollection.buildFromBeanCollection(bean.getResults());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DischargeClinicalInformationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DischargeClinicalInformationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DischargeClinicalInformationVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("PRESENTINGCOMPLAINTS"))
			return getPresentingComplaints();
		if(fieldName.equals("SUMMARYOFADMISSION"))
			return getSummaryOfAdmission();
		if(fieldName.equals("INVESTIGATIONCOMMENTS"))
			return getInvestigationComments();
		if(fieldName.equals("RELEVANTTREATMENTS"))
			return getRelevantTreatments();
		if(fieldName.equals("ADDITIONALCOMMENTS"))
			return getAdditionalComments();
		if(fieldName.equals("RESULTS"))
			return getResults();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getPresentingComplaintsIsNotNull()
	{
		return this.presentingcomplaints != null;
	}
	public String getPresentingComplaints()
	{
		return this.presentingcomplaints;
	}
	public static int getPresentingComplaintsMaxLength()
	{
		return 3500;
	}
	public void setPresentingComplaints(String value)
	{
		this.isValidated = false;
		this.presentingcomplaints = value;
	}
	public boolean getSummaryOfAdmissionIsNotNull()
	{
		return this.summaryofadmission != null;
	}
	public String getSummaryOfAdmission()
	{
		return this.summaryofadmission;
	}
	public static int getSummaryOfAdmissionMaxLength()
	{
		return 3500;
	}
	public void setSummaryOfAdmission(String value)
	{
		this.isValidated = false;
		this.summaryofadmission = value;
	}
	public boolean getInvestigationCommentsIsNotNull()
	{
		return this.investigationcomments != null;
	}
	public String getInvestigationComments()
	{
		return this.investigationcomments;
	}
	public static int getInvestigationCommentsMaxLength()
	{
		return 3500;
	}
	public void setInvestigationComments(String value)
	{
		this.isValidated = false;
		this.investigationcomments = value;
	}
	public boolean getRelevantTreatmentsIsNotNull()
	{
		return this.relevanttreatments != null;
	}
	public String getRelevantTreatments()
	{
		return this.relevanttreatments;
	}
	public static int getRelevantTreatmentsMaxLength()
	{
		return 3500;
	}
	public void setRelevantTreatments(String value)
	{
		this.isValidated = false;
		this.relevanttreatments = value;
	}
	public boolean getAdditionalCommentsIsNotNull()
	{
		return this.additionalcomments != null;
	}
	public String getAdditionalComments()
	{
		return this.additionalcomments;
	}
	public static int getAdditionalCommentsMaxLength()
	{
		return 3500;
	}
	public void setAdditionalComments(String value)
	{
		this.isValidated = false;
		this.additionalcomments = value;
	}
	public boolean getResultsIsNotNull()
	{
		return this.results != null;
	}
	public ims.ocrr.vo.OrderInvestigationBookingVoCollection getResults()
	{
		return this.results;
	}
	public void setResults(ims.ocrr.vo.OrderInvestigationBookingVoCollection value)
	{
		this.isValidated = false;
		this.results = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.presentingcomplaints != null)
			if(this.presentingcomplaints.length() > 3500)
				listOfErrors.add("The length of the field [presentingcomplaints] in the value object [ims.core.vo.DischargeClinicalInformationVo] is too big. It should be less or equal to 3500");
		if(this.summaryofadmission != null)
			if(this.summaryofadmission.length() > 3500)
				listOfErrors.add("The length of the field [summaryofadmission] in the value object [ims.core.vo.DischargeClinicalInformationVo] is too big. It should be less or equal to 3500");
		if(this.investigationcomments != null)
			if(this.investigationcomments.length() > 3500)
				listOfErrors.add("The length of the field [investigationcomments] in the value object [ims.core.vo.DischargeClinicalInformationVo] is too big. It should be less or equal to 3500");
		if(this.relevanttreatments != null)
			if(this.relevanttreatments.length() > 3500)
				listOfErrors.add("The length of the field [relevanttreatments] in the value object [ims.core.vo.DischargeClinicalInformationVo] is too big. It should be less or equal to 3500");
		if(this.additionalcomments != null)
			if(this.additionalcomments.length() > 3500)
				listOfErrors.add("The length of the field [additionalcomments] in the value object [ims.core.vo.DischargeClinicalInformationVo] is too big. It should be less or equal to 3500");
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
	
		DischargeClinicalInformationVo clone = new DischargeClinicalInformationVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		clone.presentingcomplaints = this.presentingcomplaints;
		clone.summaryofadmission = this.summaryofadmission;
		clone.investigationcomments = this.investigationcomments;
		clone.relevanttreatments = this.relevanttreatments;
		clone.additionalcomments = this.additionalcomments;
		if(this.results == null)
			clone.results = null;
		else
			clone.results = (ims.ocrr.vo.OrderInvestigationBookingVoCollection)this.results.clone();
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
		if (!(DischargeClinicalInformationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeClinicalInformationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeClinicalInformationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeClinicalInformationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.presentingcomplaints != null)
			count++;
		if(this.summaryofadmission != null)
			count++;
		if(this.investigationcomments != null)
			count++;
		if(this.relevanttreatments != null)
			count++;
		if(this.additionalcomments != null)
			count++;
		if(this.results != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected String presentingcomplaints;
	protected String summaryofadmission;
	protected String investigationcomments;
	protected String relevanttreatments;
	protected String additionalcomments;
	protected ims.ocrr.vo.OrderInvestigationBookingVoCollection results;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
