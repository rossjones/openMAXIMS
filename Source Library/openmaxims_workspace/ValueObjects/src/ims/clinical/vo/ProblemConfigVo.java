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
 * Linked to clinical.configuration.ClinicalProblem business object (ID: 1073100005).
 */
public class ProblemConfigVo extends ims.clinical.vo.ClinicalProblemShortVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.ICciFull, ims.vo.interfaces.IGenericItemInfo
{
	private static final long serialVersionUID = 1L;

	public ProblemConfigVo()
	{
	}
	public ProblemConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProblemConfigVo(ims.clinical.vo.beans.ProblemConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pcname = bean.getPCName();
		this.isactive = bean.getIsActive();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ProblemConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pcname = bean.getPCName();
		this.isactive = bean.getIsActive();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ProblemConfigVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ProblemConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ProblemConfigVoBean();
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
		if(fieldName.equals("KEYWORDS"))
			return getKeywords();
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
	/**
	* ICciFull Interface Methods
	*/
	public ims.core.vo.TaxonomyMapCollection getCciMappings() 
	{
		return this.getTaxonomyMap();
	}
		
	public ims.core.vo.KeywordVoCollection getCciKeywords() 
	{
		return this.getKeywords();
	}
		
	public void setCciKeywords(ims.core.vo.KeywordVoCollection cciKeywords) 
	{
		this.setKeywords(cciKeywords);
	}
		
	public void setCciMappings(ims.core.vo.TaxonomyMapCollection cciMappings) 
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
		return null; // this function is only for the procedure vo.
	}
		
	public void setCciProcedureDuration(Integer duration)
	{
		// this function is only for the procedure vo. 
	}
	
	public Integer getCciProcedureLOS()
	{
		return null; // this function is only for the procedure vo.
	}
		
	public void setCciProcedureLOS(Integer intLOS)
	{
		// this function is only for the procedure vo. 
	}
	public Integer getCciTCILagTime()
	{
		return null; // this function is only for the procedure vo.
	}
	public void setCciTCILagTime(Integer tciLagTime)
	{
		// this function is only for the procedure vo. 		
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
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getSurgeonCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setSurgeonCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getAnaesthetistCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setAnaesthetistCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getHospitalCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setHospitalCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
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
		if(this.pcname == null || this.pcname.length() == 0)
			listOfErrors.add("PCName is mandatory");
		else if(this.pcname.length() > 255)
			listOfErrors.add("The length of the field [pcname] in the value object [ims.clinical.vo.ProblemConfigVo] is too big. It should be less or equal to 255");
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
	
		ProblemConfigVo clone = new ProblemConfigVo(this.id, this.version);
		
		clone.pcname = this.pcname;
		clone.isactive = this.isactive;
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		if(this.keywords == null)
			clone.keywords = null;
		else
			clone.keywords = (ims.core.vo.KeywordVoCollection)this.keywords.clone();
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
		if (!(ProblemConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProblemConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ProblemConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ProblemConfigVo)obj).getBoId());
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
		if(this.keywords != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	protected ims.core.vo.KeywordVoCollection keywords;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
