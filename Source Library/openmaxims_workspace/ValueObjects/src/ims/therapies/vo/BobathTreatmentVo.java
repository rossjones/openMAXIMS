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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.Bobath Treatment business object (ID: 1019100036).
 */
public class BobathTreatmentVo extends ims.therapies.treatment.vo.BobathTreatmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BobathTreatmentVo()
	{
	}
	public BobathTreatmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public BobathTreatmentVo(ims.therapies.vo.beans.BobathTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.areatreated = bean.getAreaTreated();
		this.position = bean.getPosition();
		this.analysis = bean.getAnalysis();
		this.clinicalreasoning = bean.getClinicalReasoning();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.BobathTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.areatreated = bean.getAreaTreated();
		this.position = bean.getPosition();
		this.analysis = bean.getAnalysis();
		this.clinicalreasoning = bean.getClinicalReasoning();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.BobathTreatmentVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.BobathTreatmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.BobathTreatmentVoBean();
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
		if(fieldName.equals("AREATREATED"))
			return getAreaTreated();
		if(fieldName.equals("POSITION"))
			return getPosition();
		if(fieldName.equals("ANALYSIS"))
			return getAnalysis();
		if(fieldName.equals("CLINICALREASONING"))
			return getClinicalReasoning();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAreaTreatedIsNotNull()
	{
		return this.areatreated != null;
	}
	public String getAreaTreated()
	{
		return this.areatreated;
	}
	public static int getAreaTreatedMaxLength()
	{
		return 100;
	}
	public void setAreaTreated(String value)
	{
		this.isValidated = false;
		this.areatreated = value;
	}
	public boolean getPositionIsNotNull()
	{
		return this.position != null;
	}
	public String getPosition()
	{
		return this.position;
	}
	public static int getPositionMaxLength()
	{
		return 100;
	}
	public void setPosition(String value)
	{
		this.isValidated = false;
		this.position = value;
	}
	public boolean getAnalysisIsNotNull()
	{
		return this.analysis != null;
	}
	public String getAnalysis()
	{
		return this.analysis;
	}
	public static int getAnalysisMaxLength()
	{
		return 255;
	}
	public void setAnalysis(String value)
	{
		this.isValidated = false;
		this.analysis = value;
	}
	public boolean getClinicalReasoningIsNotNull()
	{
		return this.clinicalreasoning != null;
	}
	public String getClinicalReasoning()
	{
		return this.clinicalreasoning;
	}
	public static int getClinicalReasoningMaxLength()
	{
		return 255;
	}
	public void setClinicalReasoning(String value)
	{
		this.isValidated = false;
		this.clinicalreasoning = value;
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
		if(this.areatreated == null || this.areatreated.length() == 0)
			listOfErrors.add("Area Treated is a mandatory field");
		else if(this.areatreated.length() > 100)
			listOfErrors.add("The length of the field [areatreated] in the value object [ims.therapies.vo.BobathTreatmentVo] is too big. It should be less or equal to 100");
		if(this.position != null)
			if(this.position.length() > 100)
				listOfErrors.add("The length of the field [position] in the value object [ims.therapies.vo.BobathTreatmentVo] is too big. It should be less or equal to 100");
		if(this.analysis != null)
			if(this.analysis.length() > 255)
				listOfErrors.add("The length of the field [analysis] in the value object [ims.therapies.vo.BobathTreatmentVo] is too big. It should be less or equal to 255");
		if(this.clinicalreasoning != null)
			if(this.clinicalreasoning.length() > 255)
				listOfErrors.add("The length of the field [clinicalreasoning] in the value object [ims.therapies.vo.BobathTreatmentVo] is too big. It should be less or equal to 255");
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
	
		BobathTreatmentVo clone = new BobathTreatmentVo(this.id, this.version);
		
		clone.areatreated = this.areatreated;
		clone.position = this.position;
		clone.analysis = this.analysis;
		clone.clinicalreasoning = this.clinicalreasoning;
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
		if (!(BobathTreatmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BobathTreatmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BobathTreatmentVo compareObj = (BobathTreatmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_BobathTreatment() == null && compareObj.getID_BobathTreatment() != null)
				return -1;
			if(this.getID_BobathTreatment() != null && compareObj.getID_BobathTreatment() == null)
				return 1;
			if(this.getID_BobathTreatment() != null && compareObj.getID_BobathTreatment() != null)
				retVal = this.getID_BobathTreatment().compareTo(compareObj.getID_BobathTreatment());
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
		if(this.areatreated != null)
			count++;
		if(this.position != null)
			count++;
		if(this.analysis != null)
			count++;
		if(this.clinicalreasoning != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String areatreated;
	protected String position;
	protected String analysis;
	protected String clinicalreasoning;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
