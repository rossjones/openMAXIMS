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

package ims.nursing.vo;

/**
 * Linked to core.clinical.Assessment business object (ID: 1003100002).
 */
public class MRSAAssessmentVo extends ims.core.vo.AssessmentToolVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MRSAAssessmentVo()
	{
	}
	public MRSAAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public MRSAAssessmentVo(ims.nursing.vo.beans.MRSAAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo();
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.datescreening = bean.getDateScreening() == null ? null : bean.getDateScreening().buildDate();
		this.sitesandresults = ims.nursing.vo.MRSASitesResultsVoCollection.buildFromBeanCollection(bean.getSitesAndResults());
		this.treatment = bean.getTreatment() == null ? null : bean.getTreatment().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.MRSAAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo(map);
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.datescreening = bean.getDateScreening() == null ? null : bean.getDateScreening().buildDate();
		this.sitesandresults = ims.nursing.vo.MRSASitesResultsVoCollection.buildFromBeanCollection(bean.getSitesAndResults());
		this.treatment = bean.getTreatment() == null ? null : bean.getTreatment().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.MRSAAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.MRSAAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.MRSAAssessmentVoBean();
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
		if(fieldName.equals("DATESCREENING"))
			return getDateScreening();
		if(fieldName.equals("SITESANDRESULTS"))
			return getSitesAndResults();
		if(fieldName.equals("TREATMENT"))
			return getTreatment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateScreeningIsNotNull()
	{
		return this.datescreening != null;
	}
	public ims.framework.utils.Date getDateScreening()
	{
		return this.datescreening;
	}
	public void setDateScreening(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datescreening = value;
	}
	public boolean getSitesAndResultsIsNotNull()
	{
		return this.sitesandresults != null;
	}
	public ims.nursing.vo.MRSASitesResultsVoCollection getSitesAndResults()
	{
		return this.sitesandresults;
	}
	public void setSitesAndResults(ims.nursing.vo.MRSASitesResultsVoCollection value)
	{
		this.isValidated = false;
		this.sitesandresults = value;
	}
	public boolean getTreatmentIsNotNull()
	{
		return this.treatment != null;
	}
	public ims.nursing.vo.MRSATreatmentVo getTreatment()
	{
		return this.treatment;
	}
	public void setTreatment(ims.nursing.vo.MRSATreatmentVo value)
	{
		this.isValidated = false;
		this.treatment = value;
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
		if(this.sitesandresults != null)
		{
			if(!this.sitesandresults.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.treatment != null)
		{
			if(!this.treatment.isValidated())
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
		if(this.datescreening == null)
			listOfErrors.add("DateScreening is mandatory");
		if(this.sitesandresults != null)
		{
			String[] listOfOtherErrors = this.sitesandresults.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.treatment != null)
		{
			String[] listOfOtherErrors = this.treatment.validate();
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
	
		MRSAAssessmentVo clone = new MRSAAssessmentVo(this.id, this.version);
		
		if(this.hcpinitiated == null)
			clone.hcpinitiated = null;
		else
			clone.hcpinitiated = (ims.core.vo.HcpLiteVo)this.hcpinitiated.clone();
		if(this.datetimeinitiated == null)
			clone.datetimeinitiated = null;
		else
			clone.datetimeinitiated = (ims.framework.utils.DateTime)this.datetimeinitiated.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		if(this.datescreening == null)
			clone.datescreening = null;
		else
			clone.datescreening = (ims.framework.utils.Date)this.datescreening.clone();
		if(this.sitesandresults == null)
			clone.sitesandresults = null;
		else
			clone.sitesandresults = (ims.nursing.vo.MRSASitesResultsVoCollection)this.sitesandresults.clone();
		if(this.treatment == null)
			clone.treatment = null;
		else
			clone.treatment = (ims.nursing.vo.MRSATreatmentVo)this.treatment.clone();
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
		if (!(MRSAAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MRSAAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MRSAAssessmentVo compareObj = (MRSAAssessmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDateScreening() == null && compareObj.getDateScreening() != null)
				return -1;
			if(this.getDateScreening() != null && compareObj.getDateScreening() == null)
				return 1;
			if(this.getDateScreening() != null && compareObj.getDateScreening() != null)
				retVal = this.getDateScreening().compareTo(compareObj.getDateScreening());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.datescreening != null)
			count++;
		if(this.sitesandresults != null)
			count++;
		if(this.treatment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.framework.utils.Date datescreening;
	protected ims.nursing.vo.MRSASitesResultsVoCollection sitesandresults;
	protected ims.nursing.vo.MRSATreatmentVo treatment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
