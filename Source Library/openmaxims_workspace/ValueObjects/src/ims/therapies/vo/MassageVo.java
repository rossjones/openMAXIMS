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
 * Linked to therapies.treatment.Massage business object (ID: 1019100016).
 */
public class MassageVo extends ims.therapies.treatment.vo.MassageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MassageVo()
	{
	}
	public MassageVo(Integer id, int version)
	{
		super(id, version);
	}
	public MassageVo(ims.therapies.vo.beans.MassageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.softtissuemassage = ims.therapies.vo.SoftTissueMassageVoCollection.buildFromBeanCollection(bean.getSoftTissueMassage());
		this.deepfriction = ims.therapies.vo.DeepFrictionMassageVoCollection.buildFromBeanCollection(bean.getDeepFriction());
		this.connectivetissuemassage = ims.therapies.vo.ConnectiveTissueMassageVoCollection.buildFromBeanCollection(bean.getConnectiveTissueMassage());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.MassageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.softtissuemassage = ims.therapies.vo.SoftTissueMassageVoCollection.buildFromBeanCollection(bean.getSoftTissueMassage());
		this.deepfriction = ims.therapies.vo.DeepFrictionMassageVoCollection.buildFromBeanCollection(bean.getDeepFriction());
		this.connectivetissuemassage = ims.therapies.vo.ConnectiveTissueMassageVoCollection.buildFromBeanCollection(bean.getConnectiveTissueMassage());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.MassageVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.MassageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.MassageVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("SOFTTISSUEMASSAGE"))
			return getSoftTissueMassage();
		if(fieldName.equals("DEEPFRICTION"))
			return getDeepFriction();
		if(fieldName.equals("CONNECTIVETISSUEMASSAGE"))
			return getConnectiveTissueMassage();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getSoftTissueMassageIsNotNull()
	{
		return this.softtissuemassage != null;
	}
	public ims.therapies.vo.SoftTissueMassageVoCollection getSoftTissueMassage()
	{
		return this.softtissuemassage;
	}
	public void setSoftTissueMassage(ims.therapies.vo.SoftTissueMassageVoCollection value)
	{
		this.isValidated = false;
		this.softtissuemassage = value;
	}
	public boolean getDeepFrictionIsNotNull()
	{
		return this.deepfriction != null;
	}
	public ims.therapies.vo.DeepFrictionMassageVoCollection getDeepFriction()
	{
		return this.deepfriction;
	}
	public void setDeepFriction(ims.therapies.vo.DeepFrictionMassageVoCollection value)
	{
		this.isValidated = false;
		this.deepfriction = value;
	}
	public boolean getConnectiveTissueMassageIsNotNull()
	{
		return this.connectivetissuemassage != null;
	}
	public ims.therapies.vo.ConnectiveTissueMassageVoCollection getConnectiveTissueMassage()
	{
		return this.connectivetissuemassage;
	}
	public void setConnectiveTissueMassage(ims.therapies.vo.ConnectiveTissueMassageVoCollection value)
	{
		this.isValidated = false;
		this.connectivetissuemassage = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
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
		if(this.softtissuemassage != null)
		{
			if(!this.softtissuemassage.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.deepfriction != null)
		{
			if(!this.deepfriction.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.connectivetissuemassage != null)
		{
			if(!this.connectivetissuemassage.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.softtissuemassage != null)
		{
			String[] listOfOtherErrors = this.softtissuemassage.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.deepfriction != null)
		{
			String[] listOfOtherErrors = this.deepfriction.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.connectivetissuemassage != null)
		{
			String[] listOfOtherErrors = this.connectivetissuemassage.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is a mandatory field");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
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
	
		MassageVo clone = new MassageVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.softtissuemassage == null)
			clone.softtissuemassage = null;
		else
			clone.softtissuemassage = (ims.therapies.vo.SoftTissueMassageVoCollection)this.softtissuemassage.clone();
		if(this.deepfriction == null)
			clone.deepfriction = null;
		else
			clone.deepfriction = (ims.therapies.vo.DeepFrictionMassageVoCollection)this.deepfriction.clone();
		if(this.connectivetissuemassage == null)
			clone.connectivetissuemassage = null;
		else
			clone.connectivetissuemassage = (ims.therapies.vo.ConnectiveTissueMassageVoCollection)this.connectivetissuemassage.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
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
		if (!(MassageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MassageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MassageVo compareObj = (MassageVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Massage() == null && compareObj.getID_Massage() != null)
				return -1;
			if(this.getID_Massage() != null && compareObj.getID_Massage() == null)
				return 1;
			if(this.getID_Massage() != null && compareObj.getID_Massage() != null)
				retVal = this.getID_Massage().compareTo(compareObj.getID_Massage());
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
		if(this.clinicalcontact != null)
			count++;
		if(this.softtissuemassage != null)
			count++;
		if(this.deepfriction != null)
			count++;
		if(this.connectivetissuemassage != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.therapies.vo.SoftTissueMassageVoCollection softtissuemassage;
	protected ims.therapies.vo.DeepFrictionMassageVoCollection deepfriction;
	protected ims.therapies.vo.ConnectiveTissueMassageVoCollection connectivetissuemassage;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
