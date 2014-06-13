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

package ims.emergency.vo;

/**
 * Linked to emergency.Tracking business object (ID: 1086100005).
 */
public class TrackingLiteVo extends ims.emergency.vo.TrackingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingLiteVo()
	{
	}
	public TrackingLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingLiteVo(ims.emergency.vo.beans.TrackingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentarea = bean.getCurrentArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getCurrentArea().getId()), bean.getCurrentArea().getVersion());
		this.isprimarycare = bean.getIsPrimaryCare();
		this.isdischarged = bean.getIsDischarged();
		this.lastmovementdatetime = bean.getLastMovementDateTime() == null ? null : bean.getLastMovementDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentarea = bean.getCurrentArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getCurrentArea().getId()), bean.getCurrentArea().getVersion());
		this.isprimarycare = bean.getIsPrimaryCare();
		this.isdischarged = bean.getIsDischarged();
		this.lastmovementdatetime = bean.getLastMovementDateTime() == null ? null : bean.getLastMovementDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingLiteVoBean();
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
		if(fieldName.equals("CURRENTAREA"))
			return getCurrentArea();
		if(fieldName.equals("ISPRIMARYCARE"))
			return getIsPrimaryCare();
		if(fieldName.equals("ISDISCHARGED"))
			return getIsDischarged();
		if(fieldName.equals("LASTMOVEMENTDATETIME"))
			return getLastMovementDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCurrentAreaIsNotNull()
	{
		return this.currentarea != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.currentarea = value;
	}
	public boolean getIsPrimaryCareIsNotNull()
	{
		return this.isprimarycare != null;
	}
	public Boolean getIsPrimaryCare()
	{
		return this.isprimarycare;
	}
	public void setIsPrimaryCare(Boolean value)
	{
		this.isValidated = false;
		this.isprimarycare = value;
	}
	public boolean getIsDischargedIsNotNull()
	{
		return this.isdischarged != null;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isValidated = false;
		this.isdischarged = value;
	}
	public boolean getLastMovementDateTimeIsNotNull()
	{
		return this.lastmovementdatetime != null;
	}
	public ims.framework.utils.DateTime getLastMovementDateTime()
	{
		return this.lastmovementdatetime;
	}
	public void setLastMovementDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastmovementdatetime = value;
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
	
		TrackingLiteVo clone = new TrackingLiteVo(this.id, this.version);
		
		clone.currentarea = this.currentarea;
		clone.isprimarycare = this.isprimarycare;
		clone.isdischarged = this.isdischarged;
		if(this.lastmovementdatetime == null)
			clone.lastmovementdatetime = null;
		else
			clone.lastmovementdatetime = (ims.framework.utils.DateTime)this.lastmovementdatetime.clone();
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
		if (!(TrackingLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.currentarea != null)
			count++;
		if(this.isprimarycare != null)
			count++;
		if(this.isdischarged != null)
			count++;
		if(this.lastmovementdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.emergency.configuration.vo.TrackingAreaRefVo currentarea;
	protected Boolean isprimarycare;
	protected Boolean isdischarged;
	protected ims.framework.utils.DateTime lastmovementdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
