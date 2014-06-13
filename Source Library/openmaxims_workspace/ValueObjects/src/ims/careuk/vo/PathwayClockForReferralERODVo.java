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

package ims.careuk.vo;

/**
 * Linked to Pathways.PathwayClock business object (ID: 1088100005).
 */
public class PathwayClockForReferralERODVo extends ims.pathways.vo.PathwayClockRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathwayClockForReferralERODVo()
	{
	}
	public PathwayClockForReferralERODVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathwayClockForReferralERODVo(ims.careuk.vo.beans.PathwayClockForReferralERODVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		if(bean.getPauseDetails() != null)
		{
			this.pausedetails = new ims.pathways.vo.PauseDetailsRefVoCollection();
			for(int pausedetails_i = 0; pausedetails_i < bean.getPauseDetails().length; pausedetails_i++)
			{
				this.pausedetails.add(new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getPauseDetails()[pausedetails_i].getId()), bean.getPauseDetails()[pausedetails_i].getVersion()));
			}
		}
		this.currentpause = bean.getCurrentPause() == null ? null : new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getCurrentPause().getId()), bean.getCurrentPause().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PathwayClockForReferralERODVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		if(bean.getPauseDetails() != null)
		{
			this.pausedetails = new ims.pathways.vo.PauseDetailsRefVoCollection();
			for(int pausedetails_i = 0; pausedetails_i < bean.getPauseDetails().length; pausedetails_i++)
			{
				this.pausedetails.add(new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getPauseDetails()[pausedetails_i].getId()), bean.getPauseDetails()[pausedetails_i].getVersion()));
			}
		}
		this.currentpause = bean.getCurrentPause() == null ? null : new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getCurrentPause().getId()), bean.getCurrentPause().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PathwayClockForReferralERODVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PathwayClockForReferralERODVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PathwayClockForReferralERODVoBean();
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
		if(fieldName.equals("PAUSEDETAILS"))
			return getPauseDetails();
		if(fieldName.equals("CURRENTPAUSE"))
			return getCurrentPause();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPauseDetailsIsNotNull()
	{
		return this.pausedetails != null;
	}
	public ims.pathways.vo.PauseDetailsRefVoCollection getPauseDetails()
	{
		return this.pausedetails;
	}
	public void setPauseDetails(ims.pathways.vo.PauseDetailsRefVoCollection value)
	{
		this.isValidated = false;
		this.pausedetails = value;
	}
	public boolean getCurrentPauseIsNotNull()
	{
		return this.currentpause != null;
	}
	public ims.pathways.vo.PauseDetailsRefVo getCurrentPause()
	{
		return this.currentpause;
	}
	public void setCurrentPause(ims.pathways.vo.PauseDetailsRefVo value)
	{
		this.isValidated = false;
		this.currentpause = value;
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
	
		PathwayClockForReferralERODVo clone = new PathwayClockForReferralERODVo(this.id, this.version);
		
		clone.pausedetails = this.pausedetails;
		clone.currentpause = this.currentpause;
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
		if (!(PathwayClockForReferralERODVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathwayClockForReferralERODVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathwayClockForReferralERODVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathwayClockForReferralERODVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pausedetails != null)
			count++;
		if(this.currentpause != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.pathways.vo.PauseDetailsRefVoCollection pausedetails;
	protected ims.pathways.vo.PauseDetailsRefVo currentpause;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
