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

package ims.pathways.vo;

/**
 * Linked to Pathways.PathwayClock business object (ID: 1088100005).
 */
public class PathwayClockVo extends ims.pathways.vo.PathwayClockRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPatientJourneyClock
{
	private static final long serialVersionUID = 1L;

	public PathwayClockVo()
	{
	}
	public PathwayClockVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathwayClockVo(ims.pathways.vo.beans.PathwayClockVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.extclockid = bean.getExtClockId();
		this.extclockname = bean.getExtClockName();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.stopdate = bean.getStopDate() == null ? null : bean.getStopDate().buildDate();
		this.pausedetails = ims.pathways.vo.PauseDetailsVoCollection.buildFromBeanCollection(bean.getPauseDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PathwayClockVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.extclockid = bean.getExtClockId();
		this.extclockname = bean.getExtClockName();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.stopdate = bean.getStopDate() == null ? null : bean.getStopDate().buildDate();
		this.pausedetails = ims.pathways.vo.PauseDetailsVoCollection.buildFromBeanCollection(bean.getPauseDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PathwayClockVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PathwayClockVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PathwayClockVoBean();
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
		if(fieldName.equals("EXTCLOCKID"))
			return getExtClockId();
		if(fieldName.equals("EXTCLOCKNAME"))
			return getExtClockName();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("STOPDATE"))
			return getStopDate();
		if(fieldName.equals("PAUSEDETAILS"))
			return getPauseDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getExtClockIdIsNotNull()
	{
		return this.extclockid != null;
	}
	public String getExtClockId()
	{
		return this.extclockid;
	}
	public static int getExtClockIdMaxLength()
	{
		return 20;
	}
	public void setExtClockId(String value)
	{
		this.isValidated = false;
		this.extclockid = value;
	}
	public boolean getExtClockNameIsNotNull()
	{
		return this.extclockname != null;
	}
	public String getExtClockName()
	{
		return this.extclockname;
	}
	public static int getExtClockNameMaxLength()
	{
		return 20;
	}
	public void setExtClockName(String value)
	{
		this.isValidated = false;
		this.extclockname = value;
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
	public boolean getPauseDetailsIsNotNull()
	{
		return this.pausedetails != null;
	}
	public ims.pathways.vo.PauseDetailsVoCollection getPauseDetails()
	{
		return this.pausedetails;
	}
	public void setPauseDetails(ims.pathways.vo.PauseDetailsVoCollection value)
	{
		this.isValidated = false;
		this.pausedetails = value;
	}
	/**
	* IPatientJourneyClock
	*/
	public String getIPatientJourneyClockName() 
	{		
		return extclockname;
	}
	public ims.framework.utils.Date getIPatientJourneyClockStartDate() 
	{
		return startdate;
	}
	public ims.framework.utils.Date getIPatientJourneyClockStopDate() 
	{
		return stopdate;
	}
	public ims.pathways.vo.PauseDetailsVo getIPatientJourneyCurrentPause() 
	{
		return null;
	}
	
	public ims.pathways.vo.PauseDetailsVoCollection getIPatientJourneyPauseDetails() 
	{
		return (ims.pathways.vo.PauseDetailsVoCollection) pausedetails;
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
		if(this.pausedetails != null)
		{
			if(!this.pausedetails.isValidated())
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
		if(this.extclockid != null)
			if(this.extclockid.length() > 20)
				listOfErrors.add("The length of the field [extclockid] in the value object [ims.pathways.vo.PathwayClockVo] is too big. It should be less or equal to 20");
		if(this.extclockname != null)
			if(this.extclockname.length() > 20)
				listOfErrors.add("The length of the field [extclockname] in the value object [ims.pathways.vo.PathwayClockVo] is too big. It should be less or equal to 20");
		if(this.pausedetails != null)
		{
			String[] listOfOtherErrors = this.pausedetails.validate();
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
	
		PathwayClockVo clone = new PathwayClockVo(this.id, this.version);
		
		clone.extclockid = this.extclockid;
		clone.extclockname = this.extclockname;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.stopdate == null)
			clone.stopdate = null;
		else
			clone.stopdate = (ims.framework.utils.Date)this.stopdate.clone();
		if(this.pausedetails == null)
			clone.pausedetails = null;
		else
			clone.pausedetails = (ims.pathways.vo.PauseDetailsVoCollection)this.pausedetails.clone();
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
		if (!(PathwayClockVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathwayClockVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathwayClockVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathwayClockVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.extclockid != null)
			count++;
		if(this.extclockname != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.stopdate != null)
			count++;
		if(this.pausedetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String extclockid;
	protected String extclockname;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date stopdate;
	protected ims.pathways.vo.PauseDetailsVoCollection pausedetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
