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
 * Linked to core.configuration.PACSConfiguration business object (ID: 1028100071).
 */
public class PacsConfigurationVo extends ims.core.configuration.vo.PACSConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PacsConfigurationVo()
	{
	}
	public PacsConfigurationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PacsConfigurationVo(ims.core.vo.beans.PacsConfigurationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.serveraddress = bean.getServerAddress();
		this.usernameparam = bean.getUserNameParam();
		this.username = bean.getUsername();
		this.passwordparam = bean.getPasswordParam();
		this.password = bean.getPassword();
		this.accessionparam = bean.getAccessionParam();
		this.accessiontestvalue = bean.getAccessionTestValue();
		this.pacsclienttype = bean.getPACSClientType() == null ? null : ims.core.vo.lookups.PACSClientType.buildLookup(bean.getPACSClientType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PacsConfigurationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.serveraddress = bean.getServerAddress();
		this.usernameparam = bean.getUserNameParam();
		this.username = bean.getUsername();
		this.passwordparam = bean.getPasswordParam();
		this.password = bean.getPassword();
		this.accessionparam = bean.getAccessionParam();
		this.accessiontestvalue = bean.getAccessionTestValue();
		this.pacsclienttype = bean.getPACSClientType() == null ? null : ims.core.vo.lookups.PACSClientType.buildLookup(bean.getPACSClientType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PacsConfigurationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PacsConfigurationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PacsConfigurationVoBean();
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
		if(fieldName.equals("SERVERADDRESS"))
			return getServerAddress();
		if(fieldName.equals("USERNAMEPARAM"))
			return getUserNameParam();
		if(fieldName.equals("USERNAME"))
			return getUsername();
		if(fieldName.equals("PASSWORDPARAM"))
			return getPasswordParam();
		if(fieldName.equals("PASSWORD"))
			return getPassword();
		if(fieldName.equals("ACCESSIONPARAM"))
			return getAccessionParam();
		if(fieldName.equals("ACCESSIONTESTVALUE"))
			return getAccessionTestValue();
		if(fieldName.equals("PACSCLIENTTYPE"))
			return getPACSClientType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServerAddressIsNotNull()
	{
		return this.serveraddress != null;
	}
	public String getServerAddress()
	{
		return this.serveraddress;
	}
	public static int getServerAddressMaxLength()
	{
		return 250;
	}
	public void setServerAddress(String value)
	{
		this.isValidated = false;
		this.serveraddress = value;
	}
	public boolean getUserNameParamIsNotNull()
	{
		return this.usernameparam != null;
	}
	public String getUserNameParam()
	{
		return this.usernameparam;
	}
	public static int getUserNameParamMaxLength()
	{
		return 50;
	}
	public void setUserNameParam(String value)
	{
		this.isValidated = false;
		this.usernameparam = value;
	}
	public boolean getUsernameIsNotNull()
	{
		return this.username != null;
	}
	public String getUsername()
	{
		return this.username;
	}
	public static int getUsernameMaxLength()
	{
		return 50;
	}
	public void setUsername(String value)
	{
		this.isValidated = false;
		this.username = value;
	}
	public boolean getPasswordParamIsNotNull()
	{
		return this.passwordparam != null;
	}
	public String getPasswordParam()
	{
		return this.passwordparam;
	}
	public static int getPasswordParamMaxLength()
	{
		return 50;
	}
	public void setPasswordParam(String value)
	{
		this.isValidated = false;
		this.passwordparam = value;
	}
	public boolean getPasswordIsNotNull()
	{
		return this.password != null;
	}
	public String getPassword()
	{
		return this.password;
	}
	public static int getPasswordMaxLength()
	{
		return 50;
	}
	public void setPassword(String value)
	{
		this.isValidated = false;
		this.password = value;
	}
	public boolean getAccessionParamIsNotNull()
	{
		return this.accessionparam != null;
	}
	public String getAccessionParam()
	{
		return this.accessionparam;
	}
	public static int getAccessionParamMaxLength()
	{
		return 50;
	}
	public void setAccessionParam(String value)
	{
		this.isValidated = false;
		this.accessionparam = value;
	}
	public boolean getAccessionTestValueIsNotNull()
	{
		return this.accessiontestvalue != null;
	}
	public String getAccessionTestValue()
	{
		return this.accessiontestvalue;
	}
	public static int getAccessionTestValueMaxLength()
	{
		return 20;
	}
	public void setAccessionTestValue(String value)
	{
		this.isValidated = false;
		this.accessiontestvalue = value;
	}
	public boolean getPACSClientTypeIsNotNull()
	{
		return this.pacsclienttype != null;
	}
	public ims.core.vo.lookups.PACSClientType getPACSClientType()
	{
		return this.pacsclienttype;
	}
	public void setPACSClientType(ims.core.vo.lookups.PACSClientType value)
	{
		this.isValidated = false;
		this.pacsclienttype = value;
	}
	/**
	* getURLWithTestAccessionNumber:
	*/
	public String getURLWithTestAccessionNumber()
	{
		StringBuffer sbURL = new StringBuffer();
			
		sbURL.append(this.getServerAddressIsNotNull() ? this.getServerAddress() : "");
		sbURL.append("&");
		sbURL.append(this.getUserNameParamIsNotNull() ? this.getUserNameParam() : "");
		sbURL.append(this.getUsernameIsNotNull() ? this.getUsername() : "");
		sbURL.append("&");
		sbURL.append(this.getPasswordParamIsNotNull() ? this.getPasswordParam() : "");
		sbURL.append(this.getPasswordIsNotNull() ? this.getPassword() : "");
		sbURL.append("&");
		sbURL.append(this.getAccessionParamIsNotNull() ? this.getAccessionParam() : "");
		sbURL.append(this.getAccessionTestValueIsNotNull() ? this.getAccessionTestValue() : "");
	
		return sbURL.toString();
	}
	/**
	* getURLWithoutTestAccessionNumber:
	*/
	public String getURLWithoutTestAccessionNumber()
	{
		StringBuffer sbURL = new StringBuffer();
			
		sbURL.append(this.getServerAddressIsNotNull() ? this.getServerAddress() : "");
		sbURL.append("&");
		sbURL.append(this.getUserNameParamIsNotNull() ? this.getUserNameParam() : "");
		sbURL.append(this.getUsernameIsNotNull() ? this.getUsername() : "");
		sbURL.append("&");
		sbURL.append(this.getPasswordParamIsNotNull() ? this.getPasswordParam() : "");
		sbURL.append(this.getPasswordIsNotNull() ? this.getPassword() : "");
		sbURL.append("&");
		sbURL.append(this.getAccessionParamIsNotNull() ? this.getAccessionParam() : "");
	
		return sbURL.toString();
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
		if(this.serveraddress == null || this.serveraddress.length() == 0)
			listOfErrors.add("ServerAddress is mandatory");
		else if(this.serveraddress.length() > 250)
			listOfErrors.add("The length of the field [serveraddress] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 250");
		if(this.usernameparam == null || this.usernameparam.length() == 0)
			listOfErrors.add("UserNameParam is mandatory");
		else if(this.usernameparam.length() > 50)
			listOfErrors.add("The length of the field [usernameparam] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 50");
		if(this.username == null || this.username.length() == 0)
			listOfErrors.add("Username is mandatory");
		else if(this.username.length() > 50)
			listOfErrors.add("The length of the field [username] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 50");
		if(this.passwordparam == null || this.passwordparam.length() == 0)
			listOfErrors.add("PasswordParam is mandatory");
		else if(this.passwordparam.length() > 50)
			listOfErrors.add("The length of the field [passwordparam] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 50");
		if(this.password == null || this.password.length() == 0)
			listOfErrors.add("Password is mandatory");
		else if(this.password.length() > 50)
			listOfErrors.add("The length of the field [password] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 50");
		if(this.accessionparam == null || this.accessionparam.length() == 0)
			listOfErrors.add("AccessionParam is mandatory");
		else if(this.accessionparam.length() > 50)
			listOfErrors.add("The length of the field [accessionparam] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 50");
		if(this.accessiontestvalue != null)
			if(this.accessiontestvalue.length() > 20)
				listOfErrors.add("The length of the field [accessiontestvalue] in the value object [ims.core.vo.PacsConfigurationVo] is too big. It should be less or equal to 20");
		if(this.pacsclienttype == null)
			listOfErrors.add("PACSClientType is mandatory");
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
	
		PacsConfigurationVo clone = new PacsConfigurationVo(this.id, this.version);
		
		clone.serveraddress = this.serveraddress;
		clone.usernameparam = this.usernameparam;
		clone.username = this.username;
		clone.passwordparam = this.passwordparam;
		clone.password = this.password;
		clone.accessionparam = this.accessionparam;
		clone.accessiontestvalue = this.accessiontestvalue;
		if(this.pacsclienttype == null)
			clone.pacsclienttype = null;
		else
			clone.pacsclienttype = (ims.core.vo.lookups.PACSClientType)this.pacsclienttype.clone();
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
		if (!(PacsConfigurationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PacsConfigurationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PacsConfigurationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PacsConfigurationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.serveraddress != null)
			count++;
		if(this.usernameparam != null)
			count++;
		if(this.username != null)
			count++;
		if(this.passwordparam != null)
			count++;
		if(this.password != null)
			count++;
		if(this.accessionparam != null)
			count++;
		if(this.accessiontestvalue != null)
			count++;
		if(this.pacsclienttype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String serveraddress;
	protected String usernameparam;
	protected String username;
	protected String passwordparam;
	protected String password;
	protected String accessionparam;
	protected String accessiontestvalue;
	protected ims.core.vo.lookups.PACSClientType pacsclienttype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
