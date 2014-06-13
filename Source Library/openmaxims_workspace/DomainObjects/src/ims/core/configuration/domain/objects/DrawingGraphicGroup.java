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
package ims.core.configuration.domain.objects;

/**
 * 
 * @author Daniel Laffan
 * Generated.
 */


public class DrawingGraphicGroup extends ims.domain.DomainObject implements java.io.Serializable {
	public static final int CLASSID = 1028100009;
	private static final long serialVersionUID = 1028100009L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Group ID as returned by the Drawing Control Configurator */
	private Integer groupID;
	/** Group Name */
	private String groupName;
	/** Child groups
	  * Collection of ims.core.configuration.domain.objects.DrawingGraphicGroup.
	  */
	private java.util.Set childGroups;
	/** areaCollection
	  * Collection of ims.core.configuration.domain.objects.DrawingGraphicArea.
	  */
	private java.util.Set areaCollection;
    public DrawingGraphicGroup (Integer id, int ver)
    {
    	super(id, ver);
    }
    public DrawingGraphicGroup ()
    {
    	super();
    }
    public DrawingGraphicGroup (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.configuration.domain.objects.DrawingGraphicGroup.class;
	}


	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		if ( null != groupName && groupName.length() > 150 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for groupName. Tried to set value: "+
				groupName);
		}
		this.groupName = groupName;
	}

	public java.util.Set getChildGroups() {
		if ( null == childGroups ) {
			childGroups = new java.util.HashSet();
		}
		return childGroups;
	}
	public void setChildGroups(java.util.Set paramValue) {
		this.childGroups = paramValue;
	}

	public java.util.Set getAreaCollection() {
		if ( null == areaCollection ) {
			areaCollection = new java.util.HashSet();
		}
		return areaCollection;
	}
	public void setAreaCollection(java.util.Set paramValue) {
		this.areaCollection = paramValue;
	}

	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Configuration".equals("Configuration") )
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
		
		auditStr.append("\r\n*groupID* :");
		auditStr.append(groupID);
	    auditStr.append("; ");
		auditStr.append("\r\n*groupName* :");
		auditStr.append(groupName);
	    auditStr.append("; ");
		auditStr.append("\r\n*childGroups* :");
		if (childGroups != null)
		{
			java.util.Iterator it3 = childGroups.iterator();
			int i3=0;
			while (it3.hasNext())
			{
				if (i3 > 0)
					auditStr.append(",");
				ims.core.configuration.domain.objects.DrawingGraphicGroup obj = (ims.core.configuration.domain.objects.DrawingGraphicGroup)it3.next();
		if (obj != null)
		{
		   if (i3 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i3++;
		}
		if (i3 > 0)
			auditStr.append("] " + i3);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*areaCollection* :");
		if (areaCollection != null)
		{
			java.util.Iterator it4 = areaCollection.iterator();
			int i4=0;
			while (it4.hasNext())
			{
				if (i4 > 0)
					auditStr.append(",");
				ims.core.configuration.domain.objects.DrawingGraphicArea obj = (ims.core.configuration.domain.objects.DrawingGraphicArea)it4.next();
		if (obj != null)
		{
		   if (i4 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i4++;
		}
		if (i4 > 0)
			auditStr.append("] " + i4);
		}
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
		
		String keyClassName = "DrawingGraphicGroup";
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
		if (this.getGroupID() != null)
		{
			sb.append("<groupID>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getGroupID().toString()));
			sb.append("</groupID>");		
		}
		if (this.getGroupName() != null)
		{
			sb.append("<groupName>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getGroupName().toString()));
			sb.append("</groupName>");		
		}
		if (this.getChildGroups() != null)
		{
			if (this.getChildGroups().size() > 0 )
			{
			sb.append("<childGroups>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getChildGroups(), domMap));
			sb.append("</childGroups>");		
			}
		}
		if (this.getAreaCollection() != null)
		{
			if (this.getAreaCollection().size() > 0 )
			{
			sb.append("<areaCollection>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getAreaCollection(), domMap));
			sb.append("</areaCollection>");		
			}
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
			DrawingGraphicGroup domainObject = getDrawingGraphicGroupfromXML(itemEl, factory, domMap);

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
			DrawingGraphicGroup domainObject = getDrawingGraphicGroupfromXML(itemEl, factory, domMap);

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
		
	public static DrawingGraphicGroup getDrawingGraphicGroupfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getDrawingGraphicGroupfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static DrawingGraphicGroup getDrawingGraphicGroupfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!DrawingGraphicGroup.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!DrawingGraphicGroup.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the DrawingGraphicGroup class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (DrawingGraphicGroup)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(DrawingGraphicGroup.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		DrawingGraphicGroup ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (DrawingGraphicGroup)factory.getImportedDomainObject(DrawingGraphicGroup.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new DrawingGraphicGroup();
		}
		String keyClassName = "DrawingGraphicGroup";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (DrawingGraphicGroup)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, DrawingGraphicGroup obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("groupID");
		if(fldEl != null)
		{	
    		obj.setGroupID(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("groupName");
		if(fldEl != null)
		{	
    		obj.setGroupName(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("childGroups");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setChildGroups(ims.core.configuration.domain.objects.DrawingGraphicGroup.fromSetXMLString(fldEl, factory, obj.getChildGroups(), domMap));
		}
		fldEl = el.element("areaCollection");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setAreaCollection(ims.core.configuration.domain.objects.DrawingGraphicArea.fromSetXMLString(fldEl, factory, obj.getAreaCollection(), domMap));
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "childGroups"
		, "areaCollection"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String GroupID = "groupID";
		public static final String GroupName = "groupName";
		public static final String ChildGroups = "childGroups";
		public static final String AreaCollection = "areaCollection";
	}
}

