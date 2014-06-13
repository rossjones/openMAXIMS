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
 * Linked to nursing.PlanOfCareActions business object (ID: 1009100007).
 */
public class PlanOfCareActionsListVo extends ims.nursing.vo.PlanOfCareActionsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PlanOfCareActionsListVo()
	{
	}
	public PlanOfCareActionsListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PlanOfCareActionsListVo(ims.nursing.vo.beans.PlanOfCareActionsListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.action = bean.getAction();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.planofcare = bean.getPlanOfCare() == null ? null : bean.getPlanOfCare().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PlanOfCareActionsListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.action = bean.getAction();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.planofcare = bean.getPlanOfCare() == null ? null : bean.getPlanOfCare().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PlanOfCareActionsListVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PlanOfCareActionsListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PlanOfCareActionsListVoBean();
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
		if(fieldName.equals("ACTION"))
			return getAction();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("PLANOFCARE"))
			return getPlanOfCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActionIsNotNull()
	{
		return this.action != null;
	}
	public String getAction()
	{
		return this.action;
	}
	public static int getActionMaxLength()
	{
		return 255;
	}
	public void setAction(String value)
	{
		this.isValidated = false;
		this.action = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getPlanOfCareIsNotNull()
	{
		return this.planofcare != null;
	}
	public ims.nursing.vo.PlanOfCareLiteVo getPlanOfCare()
	{
		return this.planofcare;
	}
	public void setPlanOfCare(ims.nursing.vo.PlanOfCareLiteVo value)
	{
		this.isValidated = false;
		this.planofcare = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.planofcare != null)
		{
			if(!this.planofcare.isValidated())
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
		if(this.action != null)
			if(this.action.length() > 255)
				listOfErrors.add("The length of the field [action] in the value object [ims.nursing.vo.PlanOfCareActionsListVo] is too big. It should be less or equal to 255");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.planofcare != null)
		{
			String[] listOfOtherErrors = this.planofcare.validate();
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
	
		PlanOfCareActionsListVo clone = new PlanOfCareActionsListVo(this.id, this.version);
		
		clone.action = this.action;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.planofcare == null)
			clone.planofcare = null;
		else
			clone.planofcare = (ims.nursing.vo.PlanOfCareLiteVo)this.planofcare.clone();
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
		if (!(PlanOfCareActionsListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PlanOfCareActionsListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PlanOfCareActionsListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PlanOfCareActionsListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.action != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.planofcare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String action;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.nursing.vo.PlanOfCareLiteVo planofcare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
