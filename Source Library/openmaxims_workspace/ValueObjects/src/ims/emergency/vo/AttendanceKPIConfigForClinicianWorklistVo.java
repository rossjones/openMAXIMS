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
 * Linked to emergency.Configuration.AttendanceKPIConfig business object (ID: 1087100007).
 */
public class AttendanceKPIConfigForClinicianWorklistVo extends ims.emergency.configuration.vo.AttendanceKPIConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AttendanceKPIConfigForClinicianWorklistVo()
	{
	}
	public AttendanceKPIConfigForClinicianWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public AttendanceKPIConfigForClinicianWorklistVo(ims.emergency.vo.beans.AttendanceKPIConfigForClinicianWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.triageprioritykpis = ims.emergency.vo.TriagePriorityKpConfigVoCollection.buildFromBeanCollection(bean.getTriagePriorityKPIs());
		this.losbreachwarningkpi = bean.getLosBreachWarningKPI();
		this.losbreachedkpi = bean.getLosBreachedKPI();
		this.losbreachwarningkpiflashingtextcolour = bean.getLosBreachWarningKPIFlashingTextColour() == null ? null : bean.getLosBreachWarningKPIFlashingTextColour().buildColor();
		this.losbreachwarningkpibackgroundcolour = bean.getLosBreachWarningKPIBackgroundColour() == null ? null : bean.getLosBreachWarningKPIBackgroundColour().buildColor();
		this.losbreachedkpiflashingtextcolour = bean.getLosBreachedKPIFlashingTextColour() == null ? null : bean.getLosBreachedKPIFlashingTextColour().buildColor();
		this.losbreachedkpibackgroundcolour = bean.getLosBreachedKPIBackgroundColour() == null ? null : bean.getLosBreachedKPIBackgroundColour().buildColor();
		this.losbreachwarningkpitextcolour = bean.getLosBreachWarningKPITextColour() == null ? null : bean.getLosBreachWarningKPITextColour().buildColor();
		this.losbreachwarningkpiflashingtext = bean.getLosBreachWarningKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getLosBreachWarningKPIFlashingText());
		this.losbreachkpitextcolour = bean.getLosBreachKPITextColour() == null ? null : bean.getLosBreachKPITextColour().buildColor();
		this.losbreachedkpiflashingtext = bean.getLosBreachedKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getLosBreachedKPIFlashingText());
		this.awaitingtriagebreachedkpi = bean.getAwaitingTriageBreachedKPI();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.AttendanceKPIConfigForClinicianWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.triageprioritykpis = ims.emergency.vo.TriagePriorityKpConfigVoCollection.buildFromBeanCollection(bean.getTriagePriorityKPIs());
		this.losbreachwarningkpi = bean.getLosBreachWarningKPI();
		this.losbreachedkpi = bean.getLosBreachedKPI();
		this.losbreachwarningkpiflashingtextcolour = bean.getLosBreachWarningKPIFlashingTextColour() == null ? null : bean.getLosBreachWarningKPIFlashingTextColour().buildColor();
		this.losbreachwarningkpibackgroundcolour = bean.getLosBreachWarningKPIBackgroundColour() == null ? null : bean.getLosBreachWarningKPIBackgroundColour().buildColor();
		this.losbreachedkpiflashingtextcolour = bean.getLosBreachedKPIFlashingTextColour() == null ? null : bean.getLosBreachedKPIFlashingTextColour().buildColor();
		this.losbreachedkpibackgroundcolour = bean.getLosBreachedKPIBackgroundColour() == null ? null : bean.getLosBreachedKPIBackgroundColour().buildColor();
		this.losbreachwarningkpitextcolour = bean.getLosBreachWarningKPITextColour() == null ? null : bean.getLosBreachWarningKPITextColour().buildColor();
		this.losbreachwarningkpiflashingtext = bean.getLosBreachWarningKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getLosBreachWarningKPIFlashingText());
		this.losbreachkpitextcolour = bean.getLosBreachKPITextColour() == null ? null : bean.getLosBreachKPITextColour().buildColor();
		this.losbreachedkpiflashingtext = bean.getLosBreachedKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getLosBreachedKPIFlashingText());
		this.awaitingtriagebreachedkpi = bean.getAwaitingTriageBreachedKPI();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.AttendanceKPIConfigForClinicianWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.AttendanceKPIConfigForClinicianWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.AttendanceKPIConfigForClinicianWorklistVoBean();
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
		if(fieldName.equals("TRIAGEPRIORITYKPIS"))
			return getTriagePriorityKPIs();
		if(fieldName.equals("LOSBREACHWARNINGKPI"))
			return getLosBreachWarningKPI();
		if(fieldName.equals("LOSBREACHEDKPI"))
			return getLosBreachedKPI();
		if(fieldName.equals("LOSBREACHWARNINGKPIFLASHINGTEXTCOLOUR"))
			return getLosBreachWarningKPIFlashingTextColour();
		if(fieldName.equals("LOSBREACHWARNINGKPIBACKGROUNDCOLOUR"))
			return getLosBreachWarningKPIBackgroundColour();
		if(fieldName.equals("LOSBREACHEDKPIFLASHINGTEXTCOLOUR"))
			return getLosBreachedKPIFlashingTextColour();
		if(fieldName.equals("LOSBREACHEDKPIBACKGROUNDCOLOUR"))
			return getLosBreachedKPIBackgroundColour();
		if(fieldName.equals("LOSBREACHWARNINGKPITEXTCOLOUR"))
			return getLosBreachWarningKPITextColour();
		if(fieldName.equals("LOSBREACHWARNINGKPIFLASHINGTEXT"))
			return getLosBreachWarningKPIFlashingText();
		if(fieldName.equals("LOSBREACHKPITEXTCOLOUR"))
			return getLosBreachKPITextColour();
		if(fieldName.equals("LOSBREACHEDKPIFLASHINGTEXT"))
			return getLosBreachedKPIFlashingText();
		if(fieldName.equals("AWAITINGTRIAGEBREACHEDKPI"))
			return getAwaitingTriageBreachedKPI();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTriagePriorityKPIsIsNotNull()
	{
		return this.triageprioritykpis != null;
	}
	public ims.emergency.vo.TriagePriorityKpConfigVoCollection getTriagePriorityKPIs()
	{
		return this.triageprioritykpis;
	}
	public void setTriagePriorityKPIs(ims.emergency.vo.TriagePriorityKpConfigVoCollection value)
	{
		this.isValidated = false;
		this.triageprioritykpis = value;
	}
	public boolean getLosBreachWarningKPIIsNotNull()
	{
		return this.losbreachwarningkpi != null;
	}
	public Integer getLosBreachWarningKPI()
	{
		return this.losbreachwarningkpi;
	}
	public void setLosBreachWarningKPI(Integer value)
	{
		this.isValidated = false;
		this.losbreachwarningkpi = value;
	}
	public boolean getLosBreachedKPIIsNotNull()
	{
		return this.losbreachedkpi != null;
	}
	public Integer getLosBreachedKPI()
	{
		return this.losbreachedkpi;
	}
	public void setLosBreachedKPI(Integer value)
	{
		this.isValidated = false;
		this.losbreachedkpi = value;
	}
	public boolean getLosBreachWarningKPIFlashingTextColourIsNotNull()
	{
		return this.losbreachwarningkpiflashingtextcolour != null;
	}
	public ims.framework.utils.Color getLosBreachWarningKPIFlashingTextColour()
	{
		return this.losbreachwarningkpiflashingtextcolour;
	}
	public void setLosBreachWarningKPIFlashingTextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.losbreachwarningkpiflashingtextcolour = value;
	}
	public boolean getLosBreachWarningKPIBackgroundColourIsNotNull()
	{
		return this.losbreachwarningkpibackgroundcolour != null;
	}
	public ims.framework.utils.Color getLosBreachWarningKPIBackgroundColour()
	{
		return this.losbreachwarningkpibackgroundcolour;
	}
	public void setLosBreachWarningKPIBackgroundColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.losbreachwarningkpibackgroundcolour = value;
	}
	public boolean getLosBreachedKPIFlashingTextColourIsNotNull()
	{
		return this.losbreachedkpiflashingtextcolour != null;
	}
	public ims.framework.utils.Color getLosBreachedKPIFlashingTextColour()
	{
		return this.losbreachedkpiflashingtextcolour;
	}
	public void setLosBreachedKPIFlashingTextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.losbreachedkpiflashingtextcolour = value;
	}
	public boolean getLosBreachedKPIBackgroundColourIsNotNull()
	{
		return this.losbreachedkpibackgroundcolour != null;
	}
	public ims.framework.utils.Color getLosBreachedKPIBackgroundColour()
	{
		return this.losbreachedkpibackgroundcolour;
	}
	public void setLosBreachedKPIBackgroundColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.losbreachedkpibackgroundcolour = value;
	}
	public boolean getLosBreachWarningKPITextColourIsNotNull()
	{
		return this.losbreachwarningkpitextcolour != null;
	}
	public ims.framework.utils.Color getLosBreachWarningKPITextColour()
	{
		return this.losbreachwarningkpitextcolour;
	}
	public void setLosBreachWarningKPITextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.losbreachwarningkpitextcolour = value;
	}
	public boolean getLosBreachWarningKPIFlashingTextIsNotNull()
	{
		return this.losbreachwarningkpiflashingtext != null;
	}
	public ims.core.vo.lookups.YesNo getLosBreachWarningKPIFlashingText()
	{
		return this.losbreachwarningkpiflashingtext;
	}
	public void setLosBreachWarningKPIFlashingText(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.losbreachwarningkpiflashingtext = value;
	}
	public boolean getLosBreachKPITextColourIsNotNull()
	{
		return this.losbreachkpitextcolour != null;
	}
	public ims.framework.utils.Color getLosBreachKPITextColour()
	{
		return this.losbreachkpitextcolour;
	}
	public void setLosBreachKPITextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.losbreachkpitextcolour = value;
	}
	public boolean getLosBreachedKPIFlashingTextIsNotNull()
	{
		return this.losbreachedkpiflashingtext != null;
	}
	public ims.core.vo.lookups.YesNo getLosBreachedKPIFlashingText()
	{
		return this.losbreachedkpiflashingtext;
	}
	public void setLosBreachedKPIFlashingText(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.losbreachedkpiflashingtext = value;
	}
	public boolean getAwaitingTriageBreachedKPIIsNotNull()
	{
		return this.awaitingtriagebreachedkpi != null;
	}
	public Integer getAwaitingTriageBreachedKPI()
	{
		return this.awaitingtriagebreachedkpi;
	}
	public void setAwaitingTriageBreachedKPI(Integer value)
	{
		this.isValidated = false;
		this.awaitingtriagebreachedkpi = value;
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
	
		AttendanceKPIConfigForClinicianWorklistVo clone = new AttendanceKPIConfigForClinicianWorklistVo(this.id, this.version);
		
		if(this.triageprioritykpis == null)
			clone.triageprioritykpis = null;
		else
			clone.triageprioritykpis = (ims.emergency.vo.TriagePriorityKpConfigVoCollection)this.triageprioritykpis.clone();
		clone.losbreachwarningkpi = this.losbreachwarningkpi;
		clone.losbreachedkpi = this.losbreachedkpi;
		if(this.losbreachwarningkpiflashingtextcolour == null)
			clone.losbreachwarningkpiflashingtextcolour = null;
		else
			clone.losbreachwarningkpiflashingtextcolour = (ims.framework.utils.Color)this.losbreachwarningkpiflashingtextcolour.clone();
		if(this.losbreachwarningkpibackgroundcolour == null)
			clone.losbreachwarningkpibackgroundcolour = null;
		else
			clone.losbreachwarningkpibackgroundcolour = (ims.framework.utils.Color)this.losbreachwarningkpibackgroundcolour.clone();
		if(this.losbreachedkpiflashingtextcolour == null)
			clone.losbreachedkpiflashingtextcolour = null;
		else
			clone.losbreachedkpiflashingtextcolour = (ims.framework.utils.Color)this.losbreachedkpiflashingtextcolour.clone();
		if(this.losbreachedkpibackgroundcolour == null)
			clone.losbreachedkpibackgroundcolour = null;
		else
			clone.losbreachedkpibackgroundcolour = (ims.framework.utils.Color)this.losbreachedkpibackgroundcolour.clone();
		if(this.losbreachwarningkpitextcolour == null)
			clone.losbreachwarningkpitextcolour = null;
		else
			clone.losbreachwarningkpitextcolour = (ims.framework.utils.Color)this.losbreachwarningkpitextcolour.clone();
		if(this.losbreachwarningkpiflashingtext == null)
			clone.losbreachwarningkpiflashingtext = null;
		else
			clone.losbreachwarningkpiflashingtext = (ims.core.vo.lookups.YesNo)this.losbreachwarningkpiflashingtext.clone();
		if(this.losbreachkpitextcolour == null)
			clone.losbreachkpitextcolour = null;
		else
			clone.losbreachkpitextcolour = (ims.framework.utils.Color)this.losbreachkpitextcolour.clone();
		if(this.losbreachedkpiflashingtext == null)
			clone.losbreachedkpiflashingtext = null;
		else
			clone.losbreachedkpiflashingtext = (ims.core.vo.lookups.YesNo)this.losbreachedkpiflashingtext.clone();
		clone.awaitingtriagebreachedkpi = this.awaitingtriagebreachedkpi;
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
		if (!(AttendanceKPIConfigForClinicianWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AttendanceKPIConfigForClinicianWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AttendanceKPIConfigForClinicianWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AttendanceKPIConfigForClinicianWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.triageprioritykpis != null)
			count++;
		if(this.losbreachwarningkpi != null)
			count++;
		if(this.losbreachedkpi != null)
			count++;
		if(this.losbreachwarningkpiflashingtextcolour != null)
			count++;
		if(this.losbreachwarningkpibackgroundcolour != null)
			count++;
		if(this.losbreachedkpiflashingtextcolour != null)
			count++;
		if(this.losbreachedkpibackgroundcolour != null)
			count++;
		if(this.losbreachwarningkpitextcolour != null)
			count++;
		if(this.losbreachwarningkpiflashingtext != null)
			count++;
		if(this.losbreachkpitextcolour != null)
			count++;
		if(this.losbreachedkpiflashingtext != null)
			count++;
		if(this.awaitingtriagebreachedkpi != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.emergency.vo.TriagePriorityKpConfigVoCollection triageprioritykpis;
	protected Integer losbreachwarningkpi;
	protected Integer losbreachedkpi;
	protected ims.framework.utils.Color losbreachwarningkpiflashingtextcolour;
	protected ims.framework.utils.Color losbreachwarningkpibackgroundcolour;
	protected ims.framework.utils.Color losbreachedkpiflashingtextcolour;
	protected ims.framework.utils.Color losbreachedkpibackgroundcolour;
	protected ims.framework.utils.Color losbreachwarningkpitextcolour;
	protected ims.core.vo.lookups.YesNo losbreachwarningkpiflashingtext;
	protected ims.framework.utils.Color losbreachkpitextcolour;
	protected ims.core.vo.lookups.YesNo losbreachedkpiflashingtext;
	protected Integer awaitingtriagebreachedkpi;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
