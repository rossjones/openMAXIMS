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
 * Linked to nursing.care plans.Care Plan Intervention business object (ID: 1010100005).
 */
public class CarePlanInterventions extends ims.nursing.careplans.vo.CarePlanInterventionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CarePlanInterventions()
	{
	}
	public CarePlanInterventions(Integer id, int version)
	{
		super(id, version);
	}
	public CarePlanInterventions(ims.nursing.vo.beans.CarePlanInterventionsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.description = bean.getDescription();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.startby = bean.getStartBy() == null ? null : bean.getStartBy().buildVo();
		this.stopdate = bean.getStopDate() == null ? null : bean.getStopDate().buildDate();
		this.stopby = bean.getStopBy() == null ? null : bean.getStopBy().buildVo();
		this.active = bean.getActive();
		this.order = bean.getOrder();
		this.interventiontype = bean.getInterventionType() == null ? null : ims.nursing.vo.lookups.CarePlanInterventionManOpt.buildLookup(bean.getInterventionType());
		this.frequency = bean.getFrequency() == null ? null : ims.nursing.vo.lookups.CPActionFrequency.buildLookup(bean.getFrequency());
		this.additionalinfo = bean.getAdditionalInfo();
		this.isremoved = bean.getIsRemoved();
		this.removeddate = bean.getRemovedDate() == null ? null : bean.getRemovedDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.CarePlanInterventionsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.description = bean.getDescription();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.startby = bean.getStartBy() == null ? null : bean.getStartBy().buildVo(map);
		this.stopdate = bean.getStopDate() == null ? null : bean.getStopDate().buildDate();
		this.stopby = bean.getStopBy() == null ? null : bean.getStopBy().buildVo(map);
		this.active = bean.getActive();
		this.order = bean.getOrder();
		this.interventiontype = bean.getInterventionType() == null ? null : ims.nursing.vo.lookups.CarePlanInterventionManOpt.buildLookup(bean.getInterventionType());
		this.frequency = bean.getFrequency() == null ? null : ims.nursing.vo.lookups.CPActionFrequency.buildLookup(bean.getFrequency());
		this.additionalinfo = bean.getAdditionalInfo();
		this.isremoved = bean.getIsRemoved();
		this.removeddate = bean.getRemovedDate() == null ? null : bean.getRemovedDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.CarePlanInterventionsBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.CarePlanInterventionsBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.CarePlanInterventionsBean();
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
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("STARTBY"))
			return getStartBy();
		if(fieldName.equals("STOPDATE"))
			return getStopDate();
		if(fieldName.equals("STOPBY"))
			return getStopBy();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("ORDER"))
			return getOrder();
		if(fieldName.equals("INTERVENTIONTYPE"))
			return getInterventionType();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		if(fieldName.equals("ADDITIONALINFO"))
			return getAdditionalInfo();
		if(fieldName.equals("ISREMOVED"))
			return getIsRemoved();
		if(fieldName.equals("REMOVEDDATE"))
			return getRemovedDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getStartByIsNotNull()
	{
		return this.startby != null;
	}
	public ims.core.vo.HcpLiteVo getStartBy()
	{
		return this.startby;
	}
	public void setStartBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.startby = value;
	}
	public boolean getStopDateIsNotNull()
	{
		return this.stopdate != null;
	}
	public ims.framework.utils.Date getStopDate()
	{
		return this.stopdate;
	}
	public void setStopDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.stopdate = value;
	}
	public boolean getStopByIsNotNull()
	{
		return this.stopby != null;
	}
	public ims.core.vo.HcpLiteVo getStopBy()
	{
		return this.stopby;
	}
	public void setStopBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.stopby = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getOrderIsNotNull()
	{
		return this.order != null;
	}
	public Integer getOrder()
	{
		return this.order;
	}
	public void setOrder(Integer value)
	{
		this.isValidated = false;
		this.order = value;
	}
	public boolean getInterventionTypeIsNotNull()
	{
		return this.interventiontype != null;
	}
	public ims.nursing.vo.lookups.CarePlanInterventionManOpt getInterventionType()
	{
		return this.interventiontype;
	}
	public void setInterventionType(ims.nursing.vo.lookups.CarePlanInterventionManOpt value)
	{
		this.isValidated = false;
		this.interventiontype = value;
	}
	public boolean getFrequencyIsNotNull()
	{
		return this.frequency != null;
	}
	public ims.nursing.vo.lookups.CPActionFrequency getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.nursing.vo.lookups.CPActionFrequency value)
	{
		this.isValidated = false;
		this.frequency = value;
	}
	public boolean getAdditionalInfoIsNotNull()
	{
		return this.additionalinfo != null;
	}
	public String getAdditionalInfo()
	{
		return this.additionalinfo;
	}
	public static int getAdditionalInfoMaxLength()
	{
		return 255;
	}
	public void setAdditionalInfo(String value)
	{
		this.isValidated = false;
		this.additionalinfo = value;
	}
	public boolean getIsRemovedIsNotNull()
	{
		return this.isremoved != null;
	}
	public Boolean getIsRemoved()
	{
		return this.isremoved;
	}
	public void setIsRemoved(Boolean value)
	{
		this.isValidated = false;
		this.isremoved = value;
	}
	public boolean getRemovedDateIsNotNull()
	{
		return this.removeddate != null;
	}
	public ims.framework.utils.Date getRemovedDate()
	{
		return this.removeddate;
	}
	public void setRemovedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.removeddate = value;
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
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.nursing.vo.CarePlanInterventions] is too big. It should be less or equal to 255");
		if(this.additionalinfo != null)
			if(this.additionalinfo.length() > 255)
				listOfErrors.add("The length of the field [additionalinfo] in the value object [ims.nursing.vo.CarePlanInterventions] is too big. It should be less or equal to 255");
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
	
		CarePlanInterventions clone = new CarePlanInterventions(this.id, this.version);
		
		clone.description = this.description;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.startby == null)
			clone.startby = null;
		else
			clone.startby = (ims.core.vo.HcpLiteVo)this.startby.clone();
		if(this.stopdate == null)
			clone.stopdate = null;
		else
			clone.stopdate = (ims.framework.utils.Date)this.stopdate.clone();
		if(this.stopby == null)
			clone.stopby = null;
		else
			clone.stopby = (ims.core.vo.HcpLiteVo)this.stopby.clone();
		clone.active = this.active;
		clone.order = this.order;
		if(this.interventiontype == null)
			clone.interventiontype = null;
		else
			clone.interventiontype = (ims.nursing.vo.lookups.CarePlanInterventionManOpt)this.interventiontype.clone();
		if(this.frequency == null)
			clone.frequency = null;
		else
			clone.frequency = (ims.nursing.vo.lookups.CPActionFrequency)this.frequency.clone();
		clone.additionalinfo = this.additionalinfo;
		clone.isremoved = this.isremoved;
		if(this.removeddate == null)
			clone.removeddate = null;
		else
			clone.removeddate = (ims.framework.utils.Date)this.removeddate.clone();
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
		if (!(CarePlanInterventions.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CarePlanInterventions object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CarePlanInterventions compareObj = (CarePlanInterventions)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getOrder() == null && compareObj.getOrder() != null)
				return -1;
			if(this.getOrder() != null && compareObj.getOrder() == null)
				return 1;
			if(this.getOrder() != null && compareObj.getOrder() != null)
				retVal = this.getOrder().compareTo(compareObj.getOrder());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.description != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.startby != null)
			count++;
		if(this.stopdate != null)
			count++;
		if(this.stopby != null)
			count++;
		if(this.active != null)
			count++;
		if(this.order != null)
			count++;
		if(this.interventiontype != null)
			count++;
		if(this.frequency != null)
			count++;
		if(this.additionalinfo != null)
			count++;
		if(this.isremoved != null)
			count++;
		if(this.removeddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String description;
	protected ims.framework.utils.Date startdate;
	protected ims.core.vo.HcpLiteVo startby;
	protected ims.framework.utils.Date stopdate;
	protected ims.core.vo.HcpLiteVo stopby;
	protected Boolean active;
	protected Integer order;
	protected ims.nursing.vo.lookups.CarePlanInterventionManOpt interventiontype;
	protected ims.nursing.vo.lookups.CPActionFrequency frequency;
	protected String additionalinfo;
	protected Boolean isremoved;
	protected ims.framework.utils.Date removeddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
