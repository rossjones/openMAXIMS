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
 * Linked to core.clinical.Procedure business object (ID: 1003100019).
 */
public class ProcedureVo extends ims.core.vo.ProcedureLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.ICciFull, ims.vo.interfaces.IGenericItemInfo
{
	private static final long serialVersionUID = 1L;

	public ProcedureVo()
	{
	}
	public ProcedureVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProcedureVo(ims.core.vo.beans.ProcedureVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedurename = bean.getProcedureName();
		this.isactive = bean.getIsActive();
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.ProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.durationinmins = bean.getDurationInMins();
		this.tcilagtime = bean.getTCILagTime();
		this.los = bean.getLOS();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
		this.surgeoncategory = bean.getSurgeonCategory() == null ? null : ims.clinicaladmin.vo.lookups.CaseTypeProcedure.buildLookup(bean.getSurgeonCategory());
		this.anaesthetistcategory = bean.getAnaesthetistCategory() == null ? null : ims.clinicaladmin.vo.lookups.CaseTypeProcedure.buildLookup(bean.getAnaesthetistCategory());
		this.hospitalcategory = bean.getHospitalCategory() == null ? null : ims.clinicaladmin.vo.lookups.CaseTypeProcedure.buildLookup(bean.getHospitalCategory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ProcedureVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedurename = bean.getProcedureName();
		this.isactive = bean.getIsActive();
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.ProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.durationinmins = bean.getDurationInMins();
		this.tcilagtime = bean.getTCILagTime();
		this.los = bean.getLOS();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
		this.surgeoncategory = bean.getSurgeonCategory() == null ? null : ims.clinicaladmin.vo.lookups.CaseTypeProcedure.buildLookup(bean.getSurgeonCategory());
		this.anaesthetistcategory = bean.getAnaesthetistCategory() == null ? null : ims.clinicaladmin.vo.lookups.CaseTypeProcedure.buildLookup(bean.getAnaesthetistCategory());
		this.hospitalcategory = bean.getHospitalCategory() == null ? null : ims.clinicaladmin.vo.lookups.CaseTypeProcedure.buildLookup(bean.getHospitalCategory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ProcedureVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ProcedureVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ProcedureVoBean();
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
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("KEYWORDS"))
			return getKeywords();
		if(fieldName.equals("SURGEONCATEGORY"))
			return getSurgeonCategory();
		if(fieldName.equals("ANAESTHETISTCATEGORY"))
			return getAnaesthetistCategory();
		if(fieldName.equals("HOSPITALCATEGORY"))
			return getHospitalCategory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getKeywordsIsNotNull()
	{
		return this.keywords != null;
	}
	public ims.core.vo.KeywordVoCollection getKeywords()
	{
		return this.keywords;
	}
	public void setKeywords(ims.core.vo.KeywordVoCollection value)
	{
		this.isValidated = false;
		this.keywords = value;
	}
	public boolean getSurgeonCategoryIsNotNull()
	{
		return this.surgeoncategory != null;
	}
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getSurgeonCategory()
	{
		return this.surgeoncategory;
	}
	public void setSurgeonCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure value)
	{
		this.isValidated = false;
		this.surgeoncategory = value;
	}
	public boolean getAnaesthetistCategoryIsNotNull()
	{
		return this.anaesthetistcategory != null;
	}
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getAnaesthetistCategory()
	{
		return this.anaesthetistcategory;
	}
	public void setAnaesthetistCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure value)
	{
		this.isValidated = false;
		this.anaesthetistcategory = value;
	}
	public boolean getHospitalCategoryIsNotNull()
	{
		return this.hospitalcategory != null;
	}
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getHospitalCategory()
	{
		return this.hospitalcategory;
	}
	public void setHospitalCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure value)
	{
		this.isValidated = false;
		this.hospitalcategory = value;
	}
	/**
	* getExternalCode(ims.core.vo.lookups.TaxonomyType taxonomyType)
	*/
	public String getExternalCode(ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
		if (this.taxonomymap == null) return null;
		for (int i = 0; i < this.taxonomymap.size(); i++)
		{
			ims.core.vo.TaxonomyMap taxonomyMap = this.taxonomymap.get(i);
			if (taxonomyMap.getTaxonomyName().equals(taxonomyType))
			{
				return taxonomyMap.getTaxonomyCode();
			}
		}
		return null;
	}
	
	/**
	* getNominalCode
	*/
	public String getNominalCode()
	{
		return getExternalCode(ims.core.vo.lookups.TaxonomyType.NOMI);
	}
	
	/**
	* ICciFull Interface Methods
	*/
	public TaxonomyMapCollection getCciMappings() 
	{
		return this.getTaxonomyMap();
	}
	
	public KeywordVoCollection getCciKeywords() 
	{
		return this.getKeywords();
	}
	
	public void setCciKeywords(KeywordVoCollection cciKeywords) 
	{
		this.setKeywords(cciKeywords);
	}
	
	public void setCciMappings(TaxonomyMapCollection cciMappings) 
	{
		this.setTaxonomyMap(cciMappings);
	}
	
	public void setCciAllergenType(ims.core.vo.lookups.AllergenType type)
	{
		; // this function is only for the allergen vo. 
	}
	
	public ims.core.vo.lookups.AllergenType getCciAllergenType()
	{
		return null; // this function is only for the allergen vo.
	}
	
	public Integer getCciProcedureDuration()
	{
		return this.getDurationInMins();
	}
		
	public void setCciProcedureDuration(Integer duration)
	{
		this.setDurationInMins(duration);
	}
	
	public Integer getCciProcedureLOS()
	{
		return this.getLOS();
	}
		
	public void setCciProcedureLOS(Integer intLOS)
	{
		this.setLOS(intLOS);
	}
	
	public Integer getCciTCILagTime()
	{
		return this.tcilagtime; 
	}
	
	public void setCciTCILagTime(Integer tciLagTime)
	{
		this.tcilagtime = tciLagTime;
	}
	
	public String[] validateCci()
	{
		return this.validate();
	}
		
	public Boolean isValidatedCci()
	{
		return Boolean.valueOf(this.isValidated());
	}
	public void setCciTreatmentInterventionType(ims.clinical.vo.lookups.TreatmentInterventionType type)
	{
		// this function is only for the TreatmentIntervention vo
	}
	
	public ims.clinical.vo.lookups.TreatmentInterventionType getCciTreatmentInterventionType()
	{
		return null; // this function is only for the TreatmentIntervention vo
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
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activity != null)
		{
			if(!this.activity.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.keywords != null)
		{
			if(!this.keywords.isValidated())
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
		if(this.procedurename == null || this.procedurename.length() == 0)
			listOfErrors.add("ProcedureName is mandatory");
		else if(this.procedurename.length() > 255)
			listOfErrors.add("The length of the field [procedurename] in the value object [ims.core.vo.ProcedureVo] is too big. It should be less or equal to 255");
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activity != null)
		{
			String[] listOfOtherErrors = this.activity.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.keywords != null)
		{
			String[] listOfOtherErrors = this.keywords.validate();
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
	
		ProcedureVo clone = new ProcedureVo(this.id, this.version);
		
		clone.procedurename = this.procedurename;
		clone.isactive = this.isactive;
		if(this.procedurestatus == null)
			clone.procedurestatus = null;
		else
			clone.procedurestatus = (ims.core.vo.lookups.ProcedureStatus)this.procedurestatus.clone();
		clone.durationinmins = this.durationinmins;
		clone.tcilagtime = this.tcilagtime;
		clone.los = this.los;
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityVo)this.activity.clone();
		if(this.keywords == null)
			clone.keywords = null;
		else
			clone.keywords = (ims.core.vo.KeywordVoCollection)this.keywords.clone();
		if(this.surgeoncategory == null)
			clone.surgeoncategory = null;
		else
			clone.surgeoncategory = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)this.surgeoncategory.clone();
		if(this.anaesthetistcategory == null)
			clone.anaesthetistcategory = null;
		else
			clone.anaesthetistcategory = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)this.anaesthetistcategory.clone();
		if(this.hospitalcategory == null)
			clone.hospitalcategory = null;
		else
			clone.hospitalcategory = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)this.hospitalcategory.clone();
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
		if (!(ProcedureVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProcedureVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ProcedureVo compareObj = (ProcedureVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getProcedureName() == null && compareObj.getProcedureName() != null)
				return -1;
			if(this.getProcedureName() != null && compareObj.getProcedureName() == null)
				return 1;
			if(this.getProcedureName() != null && compareObj.getProcedureName() != null)
			{
				if(caseInsensitive)
					retVal = this.getProcedureName().toLowerCase().compareTo(compareObj.getProcedureName().toLowerCase());
				else
					retVal = this.getProcedureName().compareTo(compareObj.getProcedureName());
			}
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
		if(this.taxonomymap != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.keywords != null)
			count++;
		if(this.surgeoncategory != null)
			count++;
		if(this.anaesthetistcategory != null)
			count++;
		if(this.hospitalcategory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	protected ims.core.vo.ActivityVo activity;
	protected ims.core.vo.KeywordVoCollection keywords;
	protected ims.clinicaladmin.vo.lookups.CaseTypeProcedure surgeoncategory;
	protected ims.clinicaladmin.vo.lookups.CaseTypeProcedure anaesthetistcategory;
	protected ims.clinicaladmin.vo.lookups.CaseTypeProcedure hospitalcategory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
