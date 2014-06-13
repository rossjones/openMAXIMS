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
 * Linked to eDischarge.NeoNatal business object (ID: 1099100013).
 */
public class NeonatalVo extends ims.edischarge.vo.NeoNatalRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IEDischargeSummary
{
	private static final long serialVersionUID = 1L;

	public NeonatalVo()
	{
	}
	public NeonatalVo(Integer id, int version)
	{
		super(id, version);
	}
	public NeonatalVo(ims.clinical.vo.beans.NeonatalVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		// Interface field type not supported.
		this.gestationweeks = bean.getGestationWeeks();
		this.ismidwife = bean.getIsMidwife();
		this.ishealthvisitor = bean.getIsHealthVisitor();
		this.feeding = bean.getFeeding() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getFeeding());
		this.isvitaminkgiven = bean.getIsVitaminKGiven();
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.firstpkutestdate = bean.getFirstPKUTestDate() == null ? null : bean.getFirstPKUTestDate().buildDate();
		this.secondpkutestdate = bean.getSecondPKUTestDate() == null ? null : bean.getSecondPKUTestDate().buildDate();
		this.apgar1minute = bean.getApgar1Minute();
		this.apgar5minute = bean.getApgar5Minute();
		this.birthweight = bean.getBirthWeight();
		this.length = bean.getLength();
		this.dischargeweight = bean.getDischargeWeight();
		this.iscomplete = bean.getIsComplete();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.NeonatalVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		// Interface field type not supported.
		this.gestationweeks = bean.getGestationWeeks();
		this.ismidwife = bean.getIsMidwife();
		this.ishealthvisitor = bean.getIsHealthVisitor();
		this.feeding = bean.getFeeding() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getFeeding());
		this.isvitaminkgiven = bean.getIsVitaminKGiven();
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.firstpkutestdate = bean.getFirstPKUTestDate() == null ? null : bean.getFirstPKUTestDate().buildDate();
		this.secondpkutestdate = bean.getSecondPKUTestDate() == null ? null : bean.getSecondPKUTestDate().buildDate();
		this.apgar1minute = bean.getApgar1Minute();
		this.apgar5minute = bean.getApgar5Minute();
		this.birthweight = bean.getBirthWeight();
		this.length = bean.getLength();
		this.dischargeweight = bean.getDischargeWeight();
		this.iscomplete = bean.getIsComplete();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.NeonatalVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.NeonatalVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.NeonatalVoBean();
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
		if(fieldName.equals("DISCHARGINGNURSE"))
			return getDischargingNurse();
		if(fieldName.equals("GESTATIONWEEKS"))
			return getGestationWeeks();
		if(fieldName.equals("ISMIDWIFE"))
			return getIsMidwife();
		if(fieldName.equals("ISHEALTHVISITOR"))
			return getIsHealthVisitor();
		if(fieldName.equals("FEEDING"))
			return getFeeding();
		if(fieldName.equals("ISVITAMINKGIVEN"))
			return getIsVitaminKGiven();
		if(fieldName.equals("ROUTE"))
			return getRoute();
		if(fieldName.equals("FIRSTPKUTESTDATE"))
			return getFirstPKUTestDate();
		if(fieldName.equals("SECONDPKUTESTDATE"))
			return getSecondPKUTestDate();
		if(fieldName.equals("APGAR1MINUTE"))
			return getApgar1Minute();
		if(fieldName.equals("APGAR5MINUTE"))
			return getApgar5Minute();
		if(fieldName.equals("BIRTHWEIGHT"))
			return getBirthWeight();
		if(fieldName.equals("LENGTH"))
			return getLength();
		if(fieldName.equals("DISCHARGEWEIGHT"))
			return getDischargeWeight();
		if(fieldName.equals("ISCOMPLETE"))
			return getIsComplete();
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
	public boolean getDischargingNurseIsNotNull()
	{
		return this.dischargingnurse != null;
	}
	public ims.vo.interfaces.IMos getDischargingNurse()
	{
		return this.dischargingnurse;
	}
	public void setDischargingNurse(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.dischargingnurse = (ims.core.vo.NurseVo)value;
	}
	public boolean getGestationWeeksIsNotNull()
	{
		return this.gestationweeks != null;
	}
	public Integer getGestationWeeks()
	{
		return this.gestationweeks;
	}
	public void setGestationWeeks(Integer value)
	{
		this.isValidated = false;
		this.gestationweeks = value;
	}
	public boolean getIsMidwifeIsNotNull()
	{
		return this.ismidwife != null;
	}
	public Boolean getIsMidwife()
	{
		return this.ismidwife;
	}
	public void setIsMidwife(Boolean value)
	{
		this.isValidated = false;
		this.ismidwife = value;
	}
	public boolean getIsHealthVisitorIsNotNull()
	{
		return this.ishealthvisitor != null;
	}
	public Boolean getIsHealthVisitor()
	{
		return this.ishealthvisitor;
	}
	public void setIsHealthVisitor(Boolean value)
	{
		this.isValidated = false;
		this.ishealthvisitor = value;
	}
	public boolean getFeedingIsNotNull()
	{
		return this.feeding != null;
	}
	public ims.pci.vo.lookups.BreastFeedingStatus getFeeding()
	{
		return this.feeding;
	}
	public void setFeeding(ims.pci.vo.lookups.BreastFeedingStatus value)
	{
		this.isValidated = false;
		this.feeding = value;
	}
	public boolean getIsVitaminKGivenIsNotNull()
	{
		return this.isvitaminkgiven != null;
	}
	public Boolean getIsVitaminKGiven()
	{
		return this.isvitaminkgiven;
	}
	public void setIsVitaminKGiven(Boolean value)
	{
		this.isValidated = false;
		this.isvitaminkgiven = value;
	}
	public boolean getRouteIsNotNull()
	{
		return this.route != null;
	}
	public ims.core.vo.lookups.MedicationRoute getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.core.vo.lookups.MedicationRoute value)
	{
		this.isValidated = false;
		this.route = value;
	}
	public boolean getFirstPKUTestDateIsNotNull()
	{
		return this.firstpkutestdate != null;
	}
	public ims.framework.utils.Date getFirstPKUTestDate()
	{
		return this.firstpkutestdate;
	}
	public void setFirstPKUTestDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.firstpkutestdate = value;
	}
	public boolean getSecondPKUTestDateIsNotNull()
	{
		return this.secondpkutestdate != null;
	}
	public ims.framework.utils.Date getSecondPKUTestDate()
	{
		return this.secondpkutestdate;
	}
	public void setSecondPKUTestDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.secondpkutestdate = value;
	}
	public boolean getApgar1MinuteIsNotNull()
	{
		return this.apgar1minute != null;
	}
	public Integer getApgar1Minute()
	{
		return this.apgar1minute;
	}
	public void setApgar1Minute(Integer value)
	{
		this.isValidated = false;
		this.apgar1minute = value;
	}
	public boolean getApgar5MinuteIsNotNull()
	{
		return this.apgar5minute != null;
	}
	public Integer getApgar5Minute()
	{
		return this.apgar5minute;
	}
	public void setApgar5Minute(Integer value)
	{
		this.isValidated = false;
		this.apgar5minute = value;
	}
	public boolean getBirthWeightIsNotNull()
	{
		return this.birthweight != null;
	}
	public Float getBirthWeight()
	{
		return this.birthweight;
	}
	public void setBirthWeight(Float value)
	{
		this.isValidated = false;
		this.birthweight = value;
	}
	public boolean getLengthIsNotNull()
	{
		return this.length != null;
	}
	public Integer getLength()
	{
		return this.length;
	}
	public void setLength(Integer value)
	{
		this.isValidated = false;
		this.length = value;
	}
	public boolean getDischargeWeightIsNotNull()
	{
		return this.dischargeweight != null;
	}
	public Float getDischargeWeight()
	{
		return this.dischargeweight;
	}
	public void setDischargeWeight(Float value)
	{
		this.isValidated = false;
		this.dischargeweight = value;
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
		return ims.clinical.vo.lookups.EDischargeSummarySection.NEONATAL;
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
		if(this.gestationweeks == null)
			listOfErrors.add("Gestation is mandatory");
		if(this.ismidwife == null)
			listOfErrors.add("Community Midwife Required is mandatory");
		if(this.ishealthvisitor == null)
			listOfErrors.add("Health Visitor Required is mandatory");
		if(this.feeding == null)
			listOfErrors.add("Feeding is mandatory");
		if(this.isvitaminkgiven == null)
			listOfErrors.add("Vitamin K Given is mandatory");
		if(this.firstpkutestdate == null)
			listOfErrors.add("1st PKU Test Date is mandatory");
		if(this.apgar1minute == null)
			listOfErrors.add("Apgar at 1 Minute is mandatory");
		if(this.apgar5minute == null)
			listOfErrors.add("Apgar at 5 Minutes is mandatory");
		if(this.birthweight == null)
			listOfErrors.add("Birth Weight is mandatory");
		if(this.length == null)
			listOfErrors.add("Length is mandatory");
		if(this.dischargeweight == null)
			listOfErrors.add("Discharge Weight is mandatory");
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
	
		NeonatalVo clone = new NeonatalVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		clone.dischargingnurse = this.dischargingnurse;
		clone.gestationweeks = this.gestationweeks;
		clone.ismidwife = this.ismidwife;
		clone.ishealthvisitor = this.ishealthvisitor;
		if(this.feeding == null)
			clone.feeding = null;
		else
			clone.feeding = (ims.pci.vo.lookups.BreastFeedingStatus)this.feeding.clone();
		clone.isvitaminkgiven = this.isvitaminkgiven;
		if(this.route == null)
			clone.route = null;
		else
			clone.route = (ims.core.vo.lookups.MedicationRoute)this.route.clone();
		if(this.firstpkutestdate == null)
			clone.firstpkutestdate = null;
		else
			clone.firstpkutestdate = (ims.framework.utils.Date)this.firstpkutestdate.clone();
		if(this.secondpkutestdate == null)
			clone.secondpkutestdate = null;
		else
			clone.secondpkutestdate = (ims.framework.utils.Date)this.secondpkutestdate.clone();
		clone.apgar1minute = this.apgar1minute;
		clone.apgar5minute = this.apgar5minute;
		clone.birthweight = this.birthweight;
		clone.length = this.length;
		clone.dischargeweight = this.dischargeweight;
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
		if (!(NeonatalVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NeonatalVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NeonatalVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NeonatalVo)obj).getBoId());
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
		if(this.dischargingnurse != null)
			count++;
		if(this.gestationweeks != null)
			count++;
		if(this.ismidwife != null)
			count++;
		if(this.ishealthvisitor != null)
			count++;
		if(this.feeding != null)
			count++;
		if(this.isvitaminkgiven != null)
			count++;
		if(this.route != null)
			count++;
		if(this.firstpkutestdate != null)
			count++;
		if(this.secondpkutestdate != null)
			count++;
		if(this.apgar1minute != null)
			count++;
		if(this.apgar5minute != null)
			count++;
		if(this.birthweight != null)
			count++;
		if(this.length != null)
			count++;
		if(this.dischargeweight != null)
			count++;
		if(this.iscomplete != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 16;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.NurseVo dischargingnurse;
	protected Integer gestationweeks;
	protected Boolean ismidwife;
	protected Boolean ishealthvisitor;
	protected ims.pci.vo.lookups.BreastFeedingStatus feeding;
	protected Boolean isvitaminkgiven;
	protected ims.core.vo.lookups.MedicationRoute route;
	protected ims.framework.utils.Date firstpkutestdate;
	protected ims.framework.utils.Date secondpkutestdate;
	protected Integer apgar1minute;
	protected Integer apgar5minute;
	protected Float birthweight;
	protected Integer length;
	protected Float dischargeweight;
	protected Boolean iscomplete;
	private boolean isValidated = false;
	private boolean isBusy = false;
}