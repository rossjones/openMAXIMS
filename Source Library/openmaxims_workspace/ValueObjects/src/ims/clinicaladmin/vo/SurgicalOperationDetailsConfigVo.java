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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.SurgicalOperationDetailsConfig business object (ID: 1073100029).
 */
public class SurgicalOperationDetailsConfigVo extends ims.clinical.configuration.vo.SurgicalOperationDetailsConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SurgicalOperationDetailsConfigVo()
	{
	}
	public SurgicalOperationDetailsConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public SurgicalOperationDetailsConfigVo(ims.clinicaladmin.vo.beans.SurgicalOperationDetailsConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo();
		this.procedurereference = bean.getProcedureReference() == null ? null : bean.getProcedureReference().buildVo();
		this.procedure = bean.getProcedure();
		this.incision = bean.getIncision();
		this.findings = bean.getFindings();
		this.closure = bean.getClosure();
		this.postopinstructions = bean.getPostOpInstructions();
		this.prosthesis = bean.getProsthesis();
		this.drain = bean.getDrain();
		this.actionsforgp = bean.getActionsforGP();
		this.nurseenabledinstructions = bean.getNurseEnabledInstructions();
		this.hospitalplan = bean.getHospitalPlan();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.SurgicalOperationDetailsConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo(map);
		this.procedurereference = bean.getProcedureReference() == null ? null : bean.getProcedureReference().buildVo(map);
		this.procedure = bean.getProcedure();
		this.incision = bean.getIncision();
		this.findings = bean.getFindings();
		this.closure = bean.getClosure();
		this.postopinstructions = bean.getPostOpInstructions();
		this.prosthesis = bean.getProsthesis();
		this.drain = bean.getDrain();
		this.actionsforgp = bean.getActionsforGP();
		this.nurseenabledinstructions = bean.getNurseEnabledInstructions();
		this.hospitalplan = bean.getHospitalPlan();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.SurgicalOperationDetailsConfigVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.SurgicalOperationDetailsConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.SurgicalOperationDetailsConfigVoBean();
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
		if(fieldName.equals("SURGEON"))
			return getSurgeon();
		if(fieldName.equals("PROCEDUREREFERENCE"))
			return getProcedureReference();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("INCISION"))
			return getIncision();
		if(fieldName.equals("FINDINGS"))
			return getFindings();
		if(fieldName.equals("CLOSURE"))
			return getClosure();
		if(fieldName.equals("POSTOPINSTRUCTIONS"))
			return getPostOpInstructions();
		if(fieldName.equals("PROSTHESIS"))
			return getProsthesis();
		if(fieldName.equals("DRAIN"))
			return getDrain();
		if(fieldName.equals("ACTIONSFORGP"))
			return getActionsforGP();
		if(fieldName.equals("NURSEENABLEDINSTRUCTIONS"))
			return getNurseEnabledInstructions();
		if(fieldName.equals("HOSPITALPLAN"))
			return getHospitalPlan();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSurgeonIsNotNull()
	{
		return this.surgeon != null;
	}
	public ims.core.vo.HcpLiteVo getSurgeon()
	{
		return this.surgeon;
	}
	public void setSurgeon(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.surgeon = value;
	}
	public boolean getProcedureReferenceIsNotNull()
	{
		return this.procedurereference != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedureReference()
	{
		return this.procedurereference;
	}
	public void setProcedureReference(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedurereference = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public String getProcedure()
	{
		return this.procedure;
	}
	public static int getProcedureMaxLength()
	{
		return 5000;
	}
	public void setProcedure(String value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getIncisionIsNotNull()
	{
		return this.incision != null;
	}
	public String getIncision()
	{
		return this.incision;
	}
	public static int getIncisionMaxLength()
	{
		return 5000;
	}
	public void setIncision(String value)
	{
		this.isValidated = false;
		this.incision = value;
	}
	public boolean getFindingsIsNotNull()
	{
		return this.findings != null;
	}
	public String getFindings()
	{
		return this.findings;
	}
	public static int getFindingsMaxLength()
	{
		return 5000;
	}
	public void setFindings(String value)
	{
		this.isValidated = false;
		this.findings = value;
	}
	public boolean getClosureIsNotNull()
	{
		return this.closure != null;
	}
	public String getClosure()
	{
		return this.closure;
	}
	public static int getClosureMaxLength()
	{
		return 5000;
	}
	public void setClosure(String value)
	{
		this.isValidated = false;
		this.closure = value;
	}
	public boolean getPostOpInstructionsIsNotNull()
	{
		return this.postopinstructions != null;
	}
	public String getPostOpInstructions()
	{
		return this.postopinstructions;
	}
	public static int getPostOpInstructionsMaxLength()
	{
		return 5000;
	}
	public void setPostOpInstructions(String value)
	{
		this.isValidated = false;
		this.postopinstructions = value;
	}
	public boolean getProsthesisIsNotNull()
	{
		return this.prosthesis != null;
	}
	public String getProsthesis()
	{
		return this.prosthesis;
	}
	public static int getProsthesisMaxLength()
	{
		return 5000;
	}
	public void setProsthesis(String value)
	{
		this.isValidated = false;
		this.prosthesis = value;
	}
	public boolean getDrainIsNotNull()
	{
		return this.drain != null;
	}
	public String getDrain()
	{
		return this.drain;
	}
	public static int getDrainMaxLength()
	{
		return 5000;
	}
	public void setDrain(String value)
	{
		this.isValidated = false;
		this.drain = value;
	}
	public boolean getActionsforGPIsNotNull()
	{
		return this.actionsforgp != null;
	}
	public String getActionsforGP()
	{
		return this.actionsforgp;
	}
	public static int getActionsforGPMaxLength()
	{
		return 3500;
	}
	public void setActionsforGP(String value)
	{
		this.isValidated = false;
		this.actionsforgp = value;
	}
	public boolean getNurseEnabledInstructionsIsNotNull()
	{
		return this.nurseenabledinstructions != null;
	}
	public String getNurseEnabledInstructions()
	{
		return this.nurseenabledinstructions;
	}
	public static int getNurseEnabledInstructionsMaxLength()
	{
		return 3500;
	}
	public void setNurseEnabledInstructions(String value)
	{
		this.isValidated = false;
		this.nurseenabledinstructions = value;
	}
	public boolean getHospitalPlanIsNotNull()
	{
		return this.hospitalplan != null;
	}
	public String getHospitalPlan()
	{
		return this.hospitalplan;
	}
	public static int getHospitalPlanMaxLength()
	{
		return 3500;
	}
	public void setHospitalPlan(String value)
	{
		this.isValidated = false;
		this.hospitalplan = value;
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
		if(this.procedurereference == null)
			listOfErrors.add("ProcedureReference is mandatory");
		if(this.actionsforgp != null)
			if(this.actionsforgp.length() > 3500)
				listOfErrors.add("The length of the field [actionsforgp] in the value object [ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo] is too big. It should be less or equal to 3500");
		if(this.nurseenabledinstructions != null)
			if(this.nurseenabledinstructions.length() > 3500)
				listOfErrors.add("The length of the field [nurseenabledinstructions] in the value object [ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo] is too big. It should be less or equal to 3500");
		if(this.hospitalplan != null)
			if(this.hospitalplan.length() > 3500)
				listOfErrors.add("The length of the field [hospitalplan] in the value object [ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo] is too big. It should be less or equal to 3500");
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
	
		SurgicalOperationDetailsConfigVo clone = new SurgicalOperationDetailsConfigVo(this.id, this.version);
		
		if(this.surgeon == null)
			clone.surgeon = null;
		else
			clone.surgeon = (ims.core.vo.HcpLiteVo)this.surgeon.clone();
		if(this.procedurereference == null)
			clone.procedurereference = null;
		else
			clone.procedurereference = (ims.core.vo.ProcedureLiteVo)this.procedurereference.clone();
		clone.procedure = this.procedure;
		clone.incision = this.incision;
		clone.findings = this.findings;
		clone.closure = this.closure;
		clone.postopinstructions = this.postopinstructions;
		clone.prosthesis = this.prosthesis;
		clone.drain = this.drain;
		clone.actionsforgp = this.actionsforgp;
		clone.nurseenabledinstructions = this.nurseenabledinstructions;
		clone.hospitalplan = this.hospitalplan;
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
		if (!(SurgicalOperationDetailsConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SurgicalOperationDetailsConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SurgicalOperationDetailsConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SurgicalOperationDetailsConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.surgeon != null)
			count++;
		if(this.procedurereference != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.incision != null)
			count++;
		if(this.findings != null)
			count++;
		if(this.closure != null)
			count++;
		if(this.postopinstructions != null)
			count++;
		if(this.prosthesis != null)
			count++;
		if(this.drain != null)
			count++;
		if(this.actionsforgp != null)
			count++;
		if(this.nurseenabledinstructions != null)
			count++;
		if(this.hospitalplan != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.core.vo.HcpLiteVo surgeon;
	protected ims.core.vo.ProcedureLiteVo procedurereference;
	protected String procedure;
	protected String incision;
	protected String findings;
	protected String closure;
	protected String postopinstructions;
	protected String prosthesis;
	protected String drain;
	protected String actionsforgp;
	protected String nurseenabledinstructions;
	protected String hospitalplan;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
