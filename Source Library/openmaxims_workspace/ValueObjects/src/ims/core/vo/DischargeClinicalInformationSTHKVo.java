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
public class DischargeClinicalInformationSTHKVo extends ims.core.vo.DischargeClinicalInformationVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IEDischargeSummary
{
	private static final long serialVersionUID = 1L;

	public DischargeClinicalInformationSTHKVo()
	{
	}
	public DischargeClinicalInformationSTHKVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeClinicalInformationSTHKVo(ims.core.vo.beans.DischargeClinicalInformationSTHKVoBean bean)
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
		this.patientalerts = ims.core.vo.PatientAlertLiteVoCollection.buildFromBeanCollection(bean.getPatientAlerts());
		this.reasonforadmissionandpresentingcomplaints = bean.getReasonForAdmissionAndPresentingComplaints();
		this.relevantinfectionsriskswarnings = bean.getRelevantInfectionsRisksWarnings();
		this.summaryofinpatientepisode = bean.getSummaryOfInpatientEpisode();
		this.relevantinvsandresults = bean.getRelevantInvsAndResults();
		this.pendingresultscomments = bean.getPendingResultsComments();
		this.relevanttreatmentsandchanges = bean.getRelevantTreatmentsAndChanges();
		this.schoolnursery = bean.getSchoolNursery();
		this.iscomplete = bean.getIsComplete();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DischargeClinicalInformationSTHKVoBean bean)
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
		this.patientalerts = ims.core.vo.PatientAlertLiteVoCollection.buildFromBeanCollection(bean.getPatientAlerts());
		this.reasonforadmissionandpresentingcomplaints = bean.getReasonForAdmissionAndPresentingComplaints();
		this.relevantinfectionsriskswarnings = bean.getRelevantInfectionsRisksWarnings();
		this.summaryofinpatientepisode = bean.getSummaryOfInpatientEpisode();
		this.relevantinvsandresults = bean.getRelevantInvsAndResults();
		this.pendingresultscomments = bean.getPendingResultsComments();
		this.relevanttreatmentsandchanges = bean.getRelevantTreatmentsAndChanges();
		this.schoolnursery = bean.getSchoolNursery();
		this.iscomplete = bean.getIsComplete();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DischargeClinicalInformationSTHKVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DischargeClinicalInformationSTHKVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DischargeClinicalInformationSTHKVoBean();
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
		if(fieldName.equals("PATIENTALERTS"))
			return getPatientAlerts();
		if(fieldName.equals("REASONFORADMISSIONANDPRESENTINGCOMPLAINTS"))
			return getReasonForAdmissionAndPresentingComplaints();
		if(fieldName.equals("RELEVANTINFECTIONSRISKSWARNINGS"))
			return getRelevantInfectionsRisksWarnings();
		if(fieldName.equals("SUMMARYOFINPATIENTEPISODE"))
			return getSummaryOfInpatientEpisode();
		if(fieldName.equals("RELEVANTINVSANDRESULTS"))
			return getRelevantInvsAndResults();
		if(fieldName.equals("PENDINGRESULTSCOMMENTS"))
			return getPendingResultsComments();
		if(fieldName.equals("RELEVANTTREATMENTSANDCHANGES"))
			return getRelevantTreatmentsAndChanges();
		if(fieldName.equals("SCHOOLNURSERY"))
			return getSchoolNursery();
		if(fieldName.equals("ISCOMPLETE"))
			return getIsComplete();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientAlertsIsNotNull()
	{
		return this.patientalerts != null;
	}
	public ims.core.vo.PatientAlertLiteVoCollection getPatientAlerts()
	{
		return this.patientalerts;
	}
	public void setPatientAlerts(ims.core.vo.PatientAlertLiteVoCollection value)
	{
		this.isValidated = false;
		this.patientalerts = value;
	}
	public boolean getReasonForAdmissionAndPresentingComplaintsIsNotNull()
	{
		return this.reasonforadmissionandpresentingcomplaints != null;
	}
	public String getReasonForAdmissionAndPresentingComplaints()
	{
		return this.reasonforadmissionandpresentingcomplaints;
	}
	public static int getReasonForAdmissionAndPresentingComplaintsMaxLength()
	{
		return 3500;
	}
	public void setReasonForAdmissionAndPresentingComplaints(String value)
	{
		this.isValidated = false;
		this.reasonforadmissionandpresentingcomplaints = value;
	}
	public boolean getRelevantInfectionsRisksWarningsIsNotNull()
	{
		return this.relevantinfectionsriskswarnings != null;
	}
	public String getRelevantInfectionsRisksWarnings()
	{
		return this.relevantinfectionsriskswarnings;
	}
	public static int getRelevantInfectionsRisksWarningsMaxLength()
	{
		return 3500;
	}
	public void setRelevantInfectionsRisksWarnings(String value)
	{
		this.isValidated = false;
		this.relevantinfectionsriskswarnings = value;
	}
	public boolean getSummaryOfInpatientEpisodeIsNotNull()
	{
		return this.summaryofinpatientepisode != null;
	}
	public String getSummaryOfInpatientEpisode()
	{
		return this.summaryofinpatientepisode;
	}
	public static int getSummaryOfInpatientEpisodeMaxLength()
	{
		return 3500;
	}
	public void setSummaryOfInpatientEpisode(String value)
	{
		this.isValidated = false;
		this.summaryofinpatientepisode = value;
	}
	public boolean getRelevantInvsAndResultsIsNotNull()
	{
		return this.relevantinvsandresults != null;
	}
	public String getRelevantInvsAndResults()
	{
		return this.relevantinvsandresults;
	}
	public static int getRelevantInvsAndResultsMaxLength()
	{
		return 3500;
	}
	public void setRelevantInvsAndResults(String value)
	{
		this.isValidated = false;
		this.relevantinvsandresults = value;
	}
	public boolean getPendingResultsCommentsIsNotNull()
	{
		return this.pendingresultscomments != null;
	}
	public String getPendingResultsComments()
	{
		return this.pendingresultscomments;
	}
	public static int getPendingResultsCommentsMaxLength()
	{
		return 3500;
	}
	public void setPendingResultsComments(String value)
	{
		this.isValidated = false;
		this.pendingresultscomments = value;
	}
	public boolean getRelevantTreatmentsAndChangesIsNotNull()
	{
		return this.relevanttreatmentsandchanges != null;
	}
	public String getRelevantTreatmentsAndChanges()
	{
		return this.relevanttreatmentsandchanges;
	}
	public static int getRelevantTreatmentsAndChangesMaxLength()
	{
		return 3500;
	}
	public void setRelevantTreatmentsAndChanges(String value)
	{
		this.isValidated = false;
		this.relevanttreatmentsandchanges = value;
	}
	public boolean getSchoolNurseryIsNotNull()
	{
		return this.schoolnursery != null;
	}
	public String getSchoolNursery()
	{
		return this.schoolnursery;
	}
	public static int getSchoolNurseryMaxLength()
	{
		return 255;
	}
	public void setSchoolNursery(String value)
	{
		this.isValidated = false;
		this.schoolnursery = value;
	}
	public boolean getIsCompleteIsNotNull()
	{
		return this.iscomplete != null;
	}
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.isValidated = false;
		this.iscomplete = value;
	}
	/**
	* IEDischargeSummary interface methods
	*/
	public Boolean getIEDischargeSummaryIsComplete()
	{
		return iscomplete != null ? iscomplete : false;
	}
	
	public ims.clinical.vo.lookups.EDischargeSummarySection getIEDischargeSummarySection()
	{
		return ims.clinical.vo.lookups.EDischargeSummarySection.CLINICALINFO;
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
		if(this.patientalerts != null)
		{
			if(!this.patientalerts.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.presentingcomplaints != null)
			if(this.presentingcomplaints.length() > 3500)
				listOfErrors.add("The length of the field [presentingcomplaints] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.summaryofadmission != null)
			if(this.summaryofadmission.length() > 3500)
				listOfErrors.add("The length of the field [summaryofadmission] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.investigationcomments != null)
			if(this.investigationcomments.length() > 3500)
				listOfErrors.add("The length of the field [investigationcomments] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.relevanttreatments != null)
			if(this.relevanttreatments.length() > 3500)
				listOfErrors.add("The length of the field [relevanttreatments] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.additionalcomments != null)
			if(this.additionalcomments.length() > 3500)
				listOfErrors.add("The length of the field [additionalcomments] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.patientalerts != null)
		{
			String[] listOfOtherErrors = this.patientalerts.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.reasonforadmissionandpresentingcomplaints != null)
			if(this.reasonforadmissionandpresentingcomplaints.length() > 3500)
				listOfErrors.add("The length of the field [reasonforadmissionandpresentingcomplaints] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.relevantinfectionsriskswarnings != null)
			if(this.relevantinfectionsriskswarnings.length() > 3500)
				listOfErrors.add("The length of the field [relevantinfectionsriskswarnings] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.summaryofinpatientepisode != null)
			if(this.summaryofinpatientepisode.length() > 3500)
				listOfErrors.add("The length of the field [summaryofinpatientepisode] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.relevantinvsandresults != null)
			if(this.relevantinvsandresults.length() > 3500)
				listOfErrors.add("The length of the field [relevantinvsandresults] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.pendingresultscomments != null)
			if(this.pendingresultscomments.length() > 3500)
				listOfErrors.add("The length of the field [pendingresultscomments] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.relevanttreatmentsandchanges != null)
			if(this.relevanttreatmentsandchanges.length() > 3500)
				listOfErrors.add("The length of the field [relevanttreatmentsandchanges] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 3500");
		if(this.schoolnursery != null)
			if(this.schoolnursery.length() > 255)
				listOfErrors.add("The length of the field [schoolnursery] in the value object [ims.core.vo.DischargeClinicalInformationSTHKVo] is too big. It should be less or equal to 255");
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
	
		DischargeClinicalInformationSTHKVo clone = new DischargeClinicalInformationSTHKVo(this.id, this.version);
		
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
		if(this.patientalerts == null)
			clone.patientalerts = null;
		else
			clone.patientalerts = (ims.core.vo.PatientAlertLiteVoCollection)this.patientalerts.clone();
		clone.reasonforadmissionandpresentingcomplaints = this.reasonforadmissionandpresentingcomplaints;
		clone.relevantinfectionsriskswarnings = this.relevantinfectionsriskswarnings;
		clone.summaryofinpatientepisode = this.summaryofinpatientepisode;
		clone.relevantinvsandresults = this.relevantinvsandresults;
		clone.pendingresultscomments = this.pendingresultscomments;
		clone.relevanttreatmentsandchanges = this.relevanttreatmentsandchanges;
		clone.schoolnursery = this.schoolnursery;
		clone.iscomplete = this.iscomplete;
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
		if (!(DischargeClinicalInformationSTHKVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeClinicalInformationSTHKVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeClinicalInformationSTHKVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeClinicalInformationSTHKVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.patientalerts != null)
			count++;
		if(this.reasonforadmissionandpresentingcomplaints != null)
			count++;
		if(this.relevantinfectionsriskswarnings != null)
			count++;
		if(this.summaryofinpatientepisode != null)
			count++;
		if(this.relevantinvsandresults != null)
			count++;
		if(this.pendingresultscomments != null)
			count++;
		if(this.relevanttreatmentsandchanges != null)
			count++;
		if(this.schoolnursery != null)
			count++;
		if(this.iscomplete != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected ims.core.vo.PatientAlertLiteVoCollection patientalerts;
	protected String reasonforadmissionandpresentingcomplaints;
	protected String relevantinfectionsriskswarnings;
	protected String summaryofinpatientepisode;
	protected String relevantinvsandresults;
	protected String pendingresultscomments;
	protected String relevanttreatmentsandchanges;
	protected String schoolnursery;
	protected Boolean iscomplete;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
