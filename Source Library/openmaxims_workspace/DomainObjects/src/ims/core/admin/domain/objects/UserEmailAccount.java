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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 16/04/2014, 12:34
 *
 */
package ims.core.admin.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class UserEmailAccount extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1004100026;
	private static final long serialVersionUID = 1004100026L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** POP incoming mail server */
	private String pOP;
	/** SMTPOutgoing mail server */
	private String sMTP;
	/** UserLogon Name */
	private String userLogon;
	/** User Password */
	private String userPassword;
	/** POP incoming mail server port */
	private String pOPPort;
	/** SMTP outgoing mail server port */
	private String sMTPPort;
	/** Email Address */
	private String emailAddress;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public UserEmailAccount (Integer id, int ver)
    {
    	super(id, ver);
    }
    public UserEmailAccount ()
    {
    	super();
    }
    public UserEmailAccount (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.admin.domain.objects.UserEmailAccount.class;
	}


	public String getPOP() {
		return pOP;
	}
	public void setPOP(String pOP) {
		if ( null != pOP && pOP.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for pOP. Tried to set value: "+
				pOP);
		}
		this.pOP = pOP;
	}

	public String getSMTP() {
		return sMTP;
	}
	public void setSMTP(String sMTP) {
		if ( null != sMTP && sMTP.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for sMTP. Tried to set value: "+
				sMTP);
		}
		this.sMTP = sMTP;
	}

	public String getUserLogon() {
		return userLogon;
	}
	public void setUserLogon(String userLogon) {
		if ( null != userLogon && userLogon.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for userLogon. Tried to set value: "+
				userLogon);
		}
		this.userLogon = userLogon;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		if ( null != userPassword && userPassword.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for userPassword. Tried to set value: "+
				userPassword);
		}
		this.userPassword = userPassword;
	}

	public String getPOPPort() {
		return pOPPort;
	}
	public void setPOPPort(String pOPPort) {
		if ( null != pOPPort && pOPPort.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for pOPPort. Tried to set value: "+
				pOPPort);
		}
		this.pOPPort = pOPPort;
	}

	public String getSMTPPort() {
		return sMTPPort;
	}
	public void setSMTPPort(String sMTPPort) {
		if ( null != sMTPPort && sMTPPort.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for sMTPPort. Tried to set value: "+
				sMTPPort);
		}
		this.sMTPPort = sMTPPort;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		if ( null != emailAddress && emailAddress.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for emailAddress. Tried to set value: "+
				emailAddress);
		}
		this.emailAddress = emailAddress;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*pOP* :");
		auditStr.append(pOP);
	    auditStr.append("; ");
		auditStr.append("\r\n*sMTP* :");
		auditStr.append(sMTP);
	    auditStr.append("; ");
		auditStr.append("\r\n*userLogon* :");
		auditStr.append(userLogon);
	    auditStr.append("; ");
		auditStr.append("\r\n*userPassword* :");
		auditStr.append(userPassword);
	    auditStr.append("; ");
		auditStr.append("\r\n*pOPPort* :");
		auditStr.append(pOPPort);
	    auditStr.append("; ");
		auditStr.append("\r\n*sMTPPort* :");
		auditStr.append(sMTPPort);
	    auditStr.append("; ");
		auditStr.append("\r\n*emailAddress* :");
		auditStr.append(emailAddress);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "UserEmailAccount";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getPOP() != null)
		{
			sb.append("<pOP>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getPOP().toString()));
			sb.append("</pOP>");		
		}
		if (this.getSMTP() != null)
		{
			sb.append("<sMTP>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getSMTP().toString()));
			sb.append("</sMTP>");		
		}
		if (this.getUserLogon() != null)
		{
			sb.append("<userLogon>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getUserLogon().toString()));
			sb.append("</userLogon>");		
		}
		if (this.getUserPassword() != null)
		{
			sb.append("<userPassword>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getUserPassword().toString()));
			sb.append("</userPassword>");		
		}
		if (this.getPOPPort() != null)
		{
			sb.append("<pOPPort>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getPOPPort().toString()));
			sb.append("</pOPPort>");		
		}
		if (this.getSMTPPort() != null)
		{
			sb.append("<sMTPPort>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getSMTPPort().toString()));
			sb.append("</sMTPPort>");		
		}
		if (this.getEmailAddress() != null)
		{
			sb.append("<emailAddress>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getEmailAddress().toString()));
			sb.append("</emailAddress>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			UserEmailAccount domainObject = getUserEmailAccountfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			UserEmailAccount domainObject = getUserEmailAccountfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static UserEmailAccount getUserEmailAccountfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getUserEmailAccountfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static UserEmailAccount getUserEmailAccountfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!UserEmailAccount.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!UserEmailAccount.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the UserEmailAccount class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (UserEmailAccount)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(UserEmailAccount.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		UserEmailAccount ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (UserEmailAccount)factory.getImportedDomainObject(UserEmailAccount.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new UserEmailAccount();
		}
		String keyClassName = "UserEmailAccount";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (UserEmailAccount)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, UserEmailAccount obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("pOP");
		if(fldEl != null)
		{	
    		obj.setPOP(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("sMTP");
		if(fldEl != null)
		{	
    		obj.setSMTP(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("userLogon");
		if(fldEl != null)
		{	
    		obj.setUserLogon(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("userPassword");
		if(fldEl != null)
		{	
    		obj.setUserPassword(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("pOPPort");
		if(fldEl != null)
		{	
    		obj.setPOPPort(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("sMTPPort");
		if(fldEl != null)
		{	
    		obj.setSMTPPort(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("emailAddress");
		if(fldEl != null)
		{	
    		obj.setEmailAddress(new String(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String POP = "pOP";
		public static final String SMTP = "sMTP";
		public static final String UserLogon = "userLogon";
		public static final String UserPassword = "userPassword";
		public static final String POPPort = "pOPPort";
		public static final String SMTPPort = "sMTPPort";
		public static final String EmailAddress = "emailAddress";
	}
}

