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
package ims.therapies.homeandenvironmentalvisit.domain.objects;

/**
 * 
 * @author Joan Heelan
 * Generated.
 */


public class VisitAssessmentComponent extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1019100090;
	private static final long serialVersionUID = 1019100090L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Environmental Visit Component Type */
	private ims.domain.lookups.LookupInstance type;
	/** Details */
	private String details;
	/** Short Term Plan */
	private String shortTermPlan;
	/** Long Term Plan */
	private String longTermPlan;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public VisitAssessmentComponent (Integer id, int ver)
    {
    	super(id, ver);
    }
    public VisitAssessmentComponent ()
    {
    	super();
    }
    public VisitAssessmentComponent (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.therapies.homeandenvironmentalvisit.domain.objects.VisitAssessmentComponent.class;
	}


	public ims.domain.lookups.LookupInstance getType() {
		return type;
	}
	public void setType(ims.domain.lookups.LookupInstance type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		if ( null != details && details.length() > 500 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for details. Tried to set value: "+
				details);
		}
		this.details = details;
	}

	public String getShortTermPlan() {
		return shortTermPlan;
	}
	public void setShortTermPlan(String shortTermPlan) {
		if ( null != shortTermPlan && shortTermPlan.length() > 250 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for shortTermPlan. Tried to set value: "+
				shortTermPlan);
		}
		this.shortTermPlan = shortTermPlan;
	}

	public String getLongTermPlan() {
		return longTermPlan;
	}
	public void setLongTermPlan(String longTermPlan) {
		if ( null != longTermPlan && longTermPlan.length() > 250 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for longTermPlan. Tried to set value: "+
				longTermPlan);
		}
		this.longTermPlan = longTermPlan;
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
		
		auditStr.append("\r\n*type* :");
		if (type != null)
			auditStr.append(type.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*details* :");
		auditStr.append(details);
	    auditStr.append("; ");
		auditStr.append("\r\n*shortTermPlan* :");
		auditStr.append(shortTermPlan);
	    auditStr.append("; ");
		auditStr.append("\r\n*longTermPlan* :");
		auditStr.append(longTermPlan);
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
		
		String keyClassName = "VisitAssessmentComponent";
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
		if (this.getType() != null)
		{
			sb.append("<type>");
			sb.append(this.getType().toXMLString()); 
			sb.append("</type>");		
		}
		if (this.getDetails() != null)
		{
			sb.append("<details>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getDetails().toString()));
			sb.append("</details>");		
		}
		if (this.getShortTermPlan() != null)
		{
			sb.append("<shortTermPlan>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getShortTermPlan().toString()));
			sb.append("</shortTermPlan>");		
		}
		if (this.getLongTermPlan() != null)
		{
			sb.append("<longTermPlan>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getLongTermPlan().toString()));
			sb.append("</longTermPlan>");		
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
			VisitAssessmentComponent domainObject = getVisitAssessmentComponentfromXML(itemEl, factory, domMap);

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
			VisitAssessmentComponent domainObject = getVisitAssessmentComponentfromXML(itemEl, factory, domMap);

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
		
	public static VisitAssessmentComponent getVisitAssessmentComponentfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getVisitAssessmentComponentfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static VisitAssessmentComponent getVisitAssessmentComponentfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!VisitAssessmentComponent.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!VisitAssessmentComponent.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the VisitAssessmentComponent class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (VisitAssessmentComponent)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(VisitAssessmentComponent.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		VisitAssessmentComponent ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (VisitAssessmentComponent)factory.getImportedDomainObject(VisitAssessmentComponent.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new VisitAssessmentComponent();
		}
		String keyClassName = "VisitAssessmentComponent";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (VisitAssessmentComponent)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, VisitAssessmentComponent obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("type");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("details");
		if(fldEl != null)
		{	
    		obj.setDetails(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("shortTermPlan");
		if(fldEl != null)
		{	
    		obj.setShortTermPlan(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("longTermPlan");
		if(fldEl != null)
		{	
    		obj.setLongTermPlan(new String(fldEl.getTextTrim()));	
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
		public static final String Type = "type";
		public static final String Details = "details";
		public static final String ShortTermPlan = "shortTermPlan";
		public static final String LongTermPlan = "longTermPlan";
	}
}

