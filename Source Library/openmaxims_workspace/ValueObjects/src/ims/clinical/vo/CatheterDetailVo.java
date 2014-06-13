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
 * Linked to core.clinical.CatheterDetail business object (ID: 1003100103).
 */
public class CatheterDetailVo extends ims.core.clinical.vo.CatheterDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatheterDetailVo()
	{
	}
	public CatheterDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatheterDetailVo(ims.clinical.vo.beans.CatheterDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catheterinserted = bean.getCatheterInserted() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getCatheterInserted());
		this.catheterinsertedby = bean.getCatheterInsertedBy() == null ? null : bean.getCatheterInsertedBy().buildVo();
		this.difficultywithinsertion = bean.getDifficultyWithInsertion() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getDifficultyWithInsertion());
		this.insertioncomments = bean.getInsertionComments();
		this.timeon = bean.getTimeOn() == null ? null : bean.getTimeOn().buildDateTime();
		this.timeoff = bean.getTimeOff() == null ? null : bean.getTimeOff().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.CatheterDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catheterinserted = bean.getCatheterInserted() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getCatheterInserted());
		this.catheterinsertedby = bean.getCatheterInsertedBy() == null ? null : bean.getCatheterInsertedBy().buildVo(map);
		this.difficultywithinsertion = bean.getDifficultyWithInsertion() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getDifficultyWithInsertion());
		this.insertioncomments = bean.getInsertionComments();
		this.timeon = bean.getTimeOn() == null ? null : bean.getTimeOn().buildDateTime();
		this.timeoff = bean.getTimeOff() == null ? null : bean.getTimeOff().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.CatheterDetailVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.CatheterDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.CatheterDetailVoBean();
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
		if(fieldName.equals("CATHETERINSERTED"))
			return getCatheterInserted();
		if(fieldName.equals("CATHETERINSERTEDBY"))
			return getCatheterInsertedBy();
		if(fieldName.equals("DIFFICULTYWITHINSERTION"))
			return getDifficultyWithInsertion();
		if(fieldName.equals("INSERTIONCOMMENTS"))
			return getInsertionComments();
		if(fieldName.equals("TIMEON"))
			return getTimeOn();
		if(fieldName.equals("TIMEOFF"))
			return getTimeOff();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCatheterInsertedIsNotNull()
	{
		return this.catheterinserted != null;
	}
	public ims.core.vo.lookups.YesNo getCatheterInserted()
	{
		return this.catheterinserted;
	}
	public void setCatheterInserted(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.catheterinserted = value;
	}
	public boolean getCatheterInsertedByIsNotNull()
	{
		return this.catheterinsertedby != null;
	}
	public ims.core.vo.HcpLiteVo getCatheterInsertedBy()
	{
		return this.catheterinsertedby;
	}
	public void setCatheterInsertedBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.catheterinsertedby = value;
	}
	public boolean getDifficultyWithInsertionIsNotNull()
	{
		return this.difficultywithinsertion != null;
	}
	public ims.core.vo.lookups.YesNo getDifficultyWithInsertion()
	{
		return this.difficultywithinsertion;
	}
	public void setDifficultyWithInsertion(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.difficultywithinsertion = value;
	}
	public boolean getInsertionCommentsIsNotNull()
	{
		return this.insertioncomments != null;
	}
	public String getInsertionComments()
	{
		return this.insertioncomments;
	}
	public static int getInsertionCommentsMaxLength()
	{
		return 500;
	}
	public void setInsertionComments(String value)
	{
		this.isValidated = false;
		this.insertioncomments = value;
	}
	public boolean getTimeOnIsNotNull()
	{
		return this.timeon != null;
	}
	public ims.framework.utils.DateTime getTimeOn()
	{
		return this.timeon;
	}
	public void setTimeOn(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeon = value;
	}
	public boolean getTimeOffIsNotNull()
	{
		return this.timeoff != null;
	}
	public ims.framework.utils.DateTime getTimeOff()
	{
		return this.timeoff;
	}
	public void setTimeOff(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeoff = value;
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
		if(this.catheterinserted == null)
			listOfErrors.add("CatheterInserted is mandatory");
		if(this.insertioncomments != null)
			if(this.insertioncomments.length() > 500)
				listOfErrors.add("The length of the field [insertioncomments] in the value object [ims.clinical.vo.CatheterDetailVo] is too big. It should be less or equal to 500");
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
	
		CatheterDetailVo clone = new CatheterDetailVo(this.id, this.version);
		
		if(this.catheterinserted == null)
			clone.catheterinserted = null;
		else
			clone.catheterinserted = (ims.core.vo.lookups.YesNo)this.catheterinserted.clone();
		if(this.catheterinsertedby == null)
			clone.catheterinsertedby = null;
		else
			clone.catheterinsertedby = (ims.core.vo.HcpLiteVo)this.catheterinsertedby.clone();
		if(this.difficultywithinsertion == null)
			clone.difficultywithinsertion = null;
		else
			clone.difficultywithinsertion = (ims.core.vo.lookups.YesNo)this.difficultywithinsertion.clone();
		clone.insertioncomments = this.insertioncomments;
		if(this.timeon == null)
			clone.timeon = null;
		else
			clone.timeon = (ims.framework.utils.DateTime)this.timeon.clone();
		if(this.timeoff == null)
			clone.timeoff = null;
		else
			clone.timeoff = (ims.framework.utils.DateTime)this.timeoff.clone();
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
		if (!(CatheterDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatheterDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CatheterDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CatheterDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.catheterinserted != null)
			count++;
		if(this.catheterinsertedby != null)
			count++;
		if(this.difficultywithinsertion != null)
			count++;
		if(this.insertioncomments != null)
			count++;
		if(this.timeon != null)
			count++;
		if(this.timeoff != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.lookups.YesNo catheterinserted;
	protected ims.core.vo.HcpLiteVo catheterinsertedby;
	protected ims.core.vo.lookups.YesNo difficultywithinsertion;
	protected String insertioncomments;
	protected ims.framework.utils.DateTime timeon;
	protected ims.framework.utils.DateTime timeoff;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
