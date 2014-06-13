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

package ims.core.vo;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientMergeVo extends ims.core.patient.vo.PatientRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientMergeVo()
	{
	}
	public PatientMergeVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientMergeVo(ims.core.vo.beans.PatientMergeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.dod = bean.getDod() == null ? null : bean.getDod().buildDate();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.gp = bean.getGp() == null ? null : bean.getGp().buildVo();
		this.gpsurgery = bean.getGpSurgery() == null ? null : bean.getGpSurgery().buildVo();
		this.ethnicorigin = bean.getEthnicOrigin() == null ? null : ims.core.vo.lookups.EthnicOrigin.buildLookup(bean.getEthnicOrigin());
		this.religion = bean.getReligion() == null ? null : ims.core.vo.lookups.Religion.buildLookup(bean.getReligion());
		this.maritalstatus = bean.getMaritalStatus() == null ? null : ims.core.vo.lookups.MaritalStatus.buildLookup(bean.getMaritalStatus());
		this.occupation = bean.getOccupation() == null ? null : ims.core.vo.lookups.Occupation.buildLookup(bean.getOccupation());
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.nok = bean.getNok() == null ? null : bean.getNok().buildVo();
		this.insurance = bean.getInsurance() == null ? null : bean.getInsurance().buildVo();
		this.addresses = ims.core.vo.PersonAddressCollection.buildFromBeanCollection(bean.getAddresses());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientMergeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.dod = bean.getDod() == null ? null : bean.getDod().buildDate();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.gp = bean.getGp() == null ? null : bean.getGp().buildVo(map);
		this.gpsurgery = bean.getGpSurgery() == null ? null : bean.getGpSurgery().buildVo(map);
		this.ethnicorigin = bean.getEthnicOrigin() == null ? null : ims.core.vo.lookups.EthnicOrigin.buildLookup(bean.getEthnicOrigin());
		this.religion = bean.getReligion() == null ? null : ims.core.vo.lookups.Religion.buildLookup(bean.getReligion());
		this.maritalstatus = bean.getMaritalStatus() == null ? null : ims.core.vo.lookups.MaritalStatus.buildLookup(bean.getMaritalStatus());
		this.occupation = bean.getOccupation() == null ? null : ims.core.vo.lookups.Occupation.buildLookup(bean.getOccupation());
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.nok = bean.getNok() == null ? null : bean.getNok().buildVo(map);
		this.insurance = bean.getInsurance() == null ? null : bean.getInsurance().buildVo(map);
		this.addresses = ims.core.vo.PersonAddressCollection.buildFromBeanCollection(bean.getAddresses());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientMergeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientMergeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientMergeVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("SEX"))
			return getSex();
		if(fieldName.equals("DOB"))
			return getDob();
		if(fieldName.equals("DOD"))
			return getDod();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("IDENTIFIERS"))
			return getIdentifiers();
		if(fieldName.equals("GP"))
			return getGp();
		if(fieldName.equals("GPSURGERY"))
			return getGpSurgery();
		if(fieldName.equals("ETHNICORIGIN"))
			return getEthnicOrigin();
		if(fieldName.equals("RELIGION"))
			return getReligion();
		if(fieldName.equals("MARITALSTATUS"))
			return getMaritalStatus();
		if(fieldName.equals("OCCUPATION"))
			return getOccupation();
		if(fieldName.equals("LANGUAGE"))
			return getLanguage();
		if(fieldName.equals("COMMCHANNELS"))
			return getCommChannels();
		if(fieldName.equals("NOK"))
			return getNok();
		if(fieldName.equals("INSURANCE"))
			return getInsurance();
		if(fieldName.equals("ADDRESSES"))
			return getAddresses();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getSexIsNotNull()
	{
		return this.sex != null;
	}
	public ims.core.vo.lookups.Sex getSex()
	{
		return this.sex;
	}
	public void setSex(ims.core.vo.lookups.Sex value)
	{
		this.isValidated = false;
		this.sex = value;
	}
	public boolean getDobIsNotNull()
	{
		return this.dob != null;
	}
	public ims.framework.utils.PartialDate getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.dob = value;
	}
	public boolean getDodIsNotNull()
	{
		return this.dod != null;
	}
	public ims.framework.utils.Date getDod()
	{
		return this.dod;
	}
	public void setDod(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dod = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public ims.core.vo.PersonAddress getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.PersonAddress value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getIdentifiersIsNotNull()
	{
		return this.identifiers != null;
	}
	public ims.core.vo.PatientIdCollection getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.PatientIdCollection value)
	{
		this.isValidated = false;
		this.identifiers = value;
	}
	public boolean getGpIsNotNull()
	{
		return this.gp != null;
	}
	public ims.core.vo.GpMergeVo getGp()
	{
		return this.gp;
	}
	public void setGp(ims.core.vo.GpMergeVo value)
	{
		this.isValidated = false;
		this.gp = value;
	}
	public boolean getGpSurgeryIsNotNull()
	{
		return this.gpsurgery != null;
	}
	public ims.core.vo.LocSiteLiteVo getGpSurgery()
	{
		return this.gpsurgery;
	}
	public void setGpSurgery(ims.core.vo.LocSiteLiteVo value)
	{
		this.isValidated = false;
		this.gpsurgery = value;
	}
	public boolean getEthnicOriginIsNotNull()
	{
		return this.ethnicorigin != null;
	}
	public ims.core.vo.lookups.EthnicOrigin getEthnicOrigin()
	{
		return this.ethnicorigin;
	}
	public void setEthnicOrigin(ims.core.vo.lookups.EthnicOrigin value)
	{
		this.isValidated = false;
		this.ethnicorigin = value;
	}
	public boolean getReligionIsNotNull()
	{
		return this.religion != null;
	}
	public ims.core.vo.lookups.Religion getReligion()
	{
		return this.religion;
	}
	public void setReligion(ims.core.vo.lookups.Religion value)
	{
		this.isValidated = false;
		this.religion = value;
	}
	public boolean getMaritalStatusIsNotNull()
	{
		return this.maritalstatus != null;
	}
	public ims.core.vo.lookups.MaritalStatus getMaritalStatus()
	{
		return this.maritalstatus;
	}
	public void setMaritalStatus(ims.core.vo.lookups.MaritalStatus value)
	{
		this.isValidated = false;
		this.maritalstatus = value;
	}
	public boolean getOccupationIsNotNull()
	{
		return this.occupation != null;
	}
	public ims.core.vo.lookups.Occupation getOccupation()
	{
		return this.occupation;
	}
	public void setOccupation(ims.core.vo.lookups.Occupation value)
	{
		this.isValidated = false;
		this.occupation = value;
	}
	public boolean getLanguageIsNotNull()
	{
		return this.language != null;
	}
	public ims.core.vo.lookups.Language getLanguage()
	{
		return this.language;
	}
	public void setLanguage(ims.core.vo.lookups.Language value)
	{
		this.isValidated = false;
		this.language = value;
	}
	public boolean getCommChannelsIsNotNull()
	{
		return this.commchannels != null;
	}
	public ims.core.vo.CommChannelVoCollection getCommChannels()
	{
		return this.commchannels;
	}
	public void setCommChannels(ims.core.vo.CommChannelVoCollection value)
	{
		this.isValidated = false;
		this.commchannels = value;
	}
	public boolean getNokIsNotNull()
	{
		return this.nok != null;
	}
	public ims.core.vo.NextOfKin getNok()
	{
		return this.nok;
	}
	public void setNok(ims.core.vo.NextOfKin value)
	{
		this.isValidated = false;
		this.nok = value;
	}
	public boolean getInsuranceIsNotNull()
	{
		return this.insurance != null;
	}
	public ims.core.vo.InsuranceVo getInsurance()
	{
		return this.insurance;
	}
	public void setInsurance(ims.core.vo.InsuranceVo value)
	{
		this.isValidated = false;
		this.insurance = value;
	}
	public boolean getAddressesIsNotNull()
	{
		return this.addresses != null;
	}
	public ims.core.vo.PersonAddressCollection getAddresses()
	{
		return this.addresses;
	}
	public void setAddresses(ims.core.vo.PersonAddressCollection value)
	{
		this.isValidated = false;
		this.addresses = value;
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.address != null)
		{
			if(!this.address.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.identifiers != null)
		{
			if(!this.identifiers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.commchannels != null)
		{
			if(!this.commchannels.isValidated())
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
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.address != null)
		{
			String[] listOfOtherErrors = this.address.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.identifiers != null)
		{
			String[] listOfOtherErrors = this.identifiers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.commchannels != null)
		{
			String[] listOfOtherErrors = this.commchannels.validate();
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
	
		PatientMergeVo clone = new PatientMergeVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.sex == null)
			clone.sex = null;
		else
			clone.sex = (ims.core.vo.lookups.Sex)this.sex.clone();
		if(this.dob == null)
			clone.dob = null;
		else
			clone.dob = (ims.framework.utils.PartialDate)this.dob.clone();
		if(this.dod == null)
			clone.dod = null;
		else
			clone.dod = (ims.framework.utils.Date)this.dod.clone();
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.PersonAddress)this.address.clone();
		if(this.identifiers == null)
			clone.identifiers = null;
		else
			clone.identifiers = (ims.core.vo.PatientIdCollection)this.identifiers.clone();
		if(this.gp == null)
			clone.gp = null;
		else
			clone.gp = (ims.core.vo.GpMergeVo)this.gp.clone();
		if(this.gpsurgery == null)
			clone.gpsurgery = null;
		else
			clone.gpsurgery = (ims.core.vo.LocSiteLiteVo)this.gpsurgery.clone();
		if(this.ethnicorigin == null)
			clone.ethnicorigin = null;
		else
			clone.ethnicorigin = (ims.core.vo.lookups.EthnicOrigin)this.ethnicorigin.clone();
		if(this.religion == null)
			clone.religion = null;
		else
			clone.religion = (ims.core.vo.lookups.Religion)this.religion.clone();
		if(this.maritalstatus == null)
			clone.maritalstatus = null;
		else
			clone.maritalstatus = (ims.core.vo.lookups.MaritalStatus)this.maritalstatus.clone();
		if(this.occupation == null)
			clone.occupation = null;
		else
			clone.occupation = (ims.core.vo.lookups.Occupation)this.occupation.clone();
		if(this.language == null)
			clone.language = null;
		else
			clone.language = (ims.core.vo.lookups.Language)this.language.clone();
		if(this.commchannels == null)
			clone.commchannels = null;
		else
			clone.commchannels = (ims.core.vo.CommChannelVoCollection)this.commchannels.clone();
		if(this.nok == null)
			clone.nok = null;
		else
			clone.nok = (ims.core.vo.NextOfKin)this.nok.clone();
		if(this.insurance == null)
			clone.insurance = null;
		else
			clone.insurance = (ims.core.vo.InsuranceVo)this.insurance.clone();
		if(this.addresses == null)
			clone.addresses = null;
		else
			clone.addresses = (ims.core.vo.PersonAddressCollection)this.addresses.clone();
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
		if (!(PatientMergeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientMergeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientMergeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientMergeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.sex != null)
			count++;
		if(this.dob != null)
			count++;
		if(this.dod != null)
			count++;
		if(this.address != null)
			count++;
		if(this.identifiers != null)
			count++;
		if(this.gp != null)
			count++;
		if(this.gpsurgery != null)
			count++;
		if(this.ethnicorigin != null)
			count++;
		if(this.religion != null)
			count++;
		if(this.maritalstatus != null)
			count++;
		if(this.occupation != null)
			count++;
		if(this.language != null)
			count++;
		if(this.commchannels != null)
			count++;
		if(this.nok != null)
			count++;
		if(this.insurance != null)
			count++;
		if(this.addresses != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.vo.PersonName name;
	protected ims.core.vo.lookups.Sex sex;
	protected ims.framework.utils.PartialDate dob;
	protected ims.framework.utils.Date dod;
	protected ims.core.vo.PersonAddress address;
	protected ims.core.vo.PatientIdCollection identifiers;
	protected ims.core.vo.GpMergeVo gp;
	protected ims.core.vo.LocSiteLiteVo gpsurgery;
	protected ims.core.vo.lookups.EthnicOrigin ethnicorigin;
	protected ims.core.vo.lookups.Religion religion;
	protected ims.core.vo.lookups.MaritalStatus maritalstatus;
	protected ims.core.vo.lookups.Occupation occupation;
	protected ims.core.vo.lookups.Language language;
	protected ims.core.vo.CommChannelVoCollection commchannels;
	protected ims.core.vo.NextOfKin nok;
	protected ims.core.vo.InsuranceVo insurance;
	protected ims.core.vo.PersonAddressCollection addresses;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
