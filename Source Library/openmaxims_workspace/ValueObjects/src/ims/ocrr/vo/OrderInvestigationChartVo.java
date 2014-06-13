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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class OrderInvestigationChartVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderInvestigationChartVo()
	{
	}
	public OrderInvestigationChartVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderInvestigationChartVo(ims.ocrr.vo.beans.OrderInvestigationChartVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.specimen = ims.ocrr.vo.OrderSpecimenChartVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderInvestigationChartVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.specimen = ims.ocrr.vo.OrderSpecimenChartVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderInvestigationChartVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderInvestigationChartVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderInvestigationChartVoBean();
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
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("DISPLAYFLAG"))
			return getDisplayFlag();
		if(fieldName.equals("RESULTSPECIMENTYPE"))
			return getResultSpecimenType();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationChartVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationChartVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.vo.OrderSpecimenChartVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.OrderSpecimenChartVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getDisplayDateTimeIsNotNull()
	{
		return this.displaydatetime != null;
	}
	public ims.framework.utils.DateTime getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.displaydatetime = value;
	}
	public boolean getDisplayFlagIsNotNull()
	{
		return this.displayflag != null;
	}
	public ims.ocrr.vo.lookups.OcsDisplayFlag getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.ocrr.vo.lookups.OcsDisplayFlag value)
	{
		this.isValidated = false;
		this.displayflag = value;
	}
	public boolean getResultSpecimenTypeIsNotNull()
	{
		return this.resultspecimentype != null;
	}
	public ims.vo.LookupInstVo getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstVo value)
	{
		this.isValidated = false;
		this.resultspecimentype = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocrr.vo.ResultDetailsForOrderInvestigationChartVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.ResultDetailsForOrderInvestigationChartVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
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
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.displayflag == null)
			listOfErrors.add("DisplayFlag is mandatory");
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
	
		OrderInvestigationChartVo clone = new OrderInvestigationChartVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationChartVo)this.investigation.clone();
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocrr.vo.OrderSpecimenChartVoCollection)this.specimen.clone();
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		if(this.displayflag == null)
			clone.displayflag = null;
		else
			clone.displayflag = (ims.ocrr.vo.lookups.OcsDisplayFlag)this.displayflag.clone();
		clone.resultspecimentype = this.resultspecimentype;
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocrr.vo.ResultDetailsForOrderInvestigationChartVo)this.resultdetails.clone();
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
		if (!(OrderInvestigationChartVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderInvestigationChartVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OrderInvestigationChartVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OrderInvestigationChartVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.investigation != null)
			count++;
		if(this.specimen != null)
			count++;
		if(this.displaydatetime != null)
			count++;
		if(this.displayflag != null)
			count++;
		if(this.resultspecimentype != null)
			count++;
		if(this.resultdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.ocrr.vo.InvestigationChartVo investigation;
	protected ims.ocrr.vo.OrderSpecimenChartVoCollection specimen;
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.vo.lookups.OcsDisplayFlag displayflag;
	protected ims.vo.LookupInstVo resultspecimentype;
	protected ims.ocrr.vo.ResultDetailsForOrderInvestigationChartVo resultdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
