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

package ims.admin.vo;

/**
 * Linked to core.configuration.AppNavRootGroup business object (ID: 1028100028).
 */
public class AppNavRootGroupVo extends ims.core.configuration.vo.AppNavRootGroupRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.INavRootGroup, ims.vo.interfaces.INavigationNode
{
	private static final long serialVersionUID = 1L;

	public AppNavRootGroupVo()
	{
	}
	public AppNavRootGroupVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppNavRootGroupVo(ims.admin.vo.beans.AppNavRootGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.groupname = bean.getGroupName();
		this.forms = ims.admin.vo.AppNavFormVoCollection.buildFromBeanCollection(bean.getForms());
		this.groups = ims.admin.vo.AppNavSecondGroupVoCollection.buildFromBeanCollection(bean.getGroups());
		this.image = bean.getImage() == null ? null : bean.getImage().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppNavRootGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.groupname = bean.getGroupName();
		this.forms = ims.admin.vo.AppNavFormVoCollection.buildFromBeanCollection(bean.getForms());
		this.groups = ims.admin.vo.AppNavSecondGroupVoCollection.buildFromBeanCollection(bean.getGroups());
		this.image = bean.getImage() == null ? null : bean.getImage().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppNavRootGroupVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppNavRootGroupVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppNavRootGroupVoBean();
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
		if(fieldName.equals("GROUPNAME"))
			return getGroupName();
		if(fieldName.equals("FORMS"))
			return getForms();
		if(fieldName.equals("GROUPS"))
			return getGroups();
		if(fieldName.equals("IMAGE"))
			return getImage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGroupNameIsNotNull()
	{
		return this.groupname != null;
	}
	public String getGroupName()
	{
		return this.groupname;
	}
	public static int getGroupNameMaxLength()
	{
		return 50;
	}
	public void setGroupName(String value)
	{
		this.isValidated = false;
		this.groupname = value;
	}
	public boolean getFormsIsNotNull()
	{
		return this.forms != null;
	}
	public ims.admin.vo.AppNavFormVoCollection getForms()
	{
		return this.forms;
	}
	public void setForms(ims.admin.vo.AppNavFormVoCollection value)
	{
		this.isValidated = false;
		this.forms = value;
	}
	public boolean getGroupsIsNotNull()
	{
		return this.groups != null;
	}
	public ims.admin.vo.AppNavSecondGroupVoCollection getGroups()
	{
		return this.groups;
	}
	public void setGroups(ims.admin.vo.AppNavSecondGroupVoCollection value)
	{
		this.isValidated = false;
		this.groups = value;
	}
	public boolean getImageIsNotNull()
	{
		return this.image != null;
	}
	public ims.admin.vo.AppImageVo getImage()
	{
		return this.image;
	}
	public void setImage(ims.admin.vo.AppImageVo value)
	{
		this.isValidated = false;
		this.image = value;
	}
	/**
	* INavRootGroup interface methods
	*/
		public int getId()
		{
			if (this.getID_AppNavRootGroup() == null)
				return 0;
			else
				return this.getID_AppNavRootGroup().intValue();
		}
		public ims.framework.interfaces.INavForm[] getNavForms()
		{
			if (this.getForms() == null)
				return new ims.framework.interfaces.INavForm[0];
			else
				return this.getForms().toArray();
		}
		public ims.framework.interfaces.INavSecondGroup[] getNavGroups()
		{
			if (this.getGroups() == null)
				return new ims.framework.interfaces.INavSecondGroup[0];
			else
				return this.getGroups().toArray();
		}
		public ims.framework.interfaces.IAppImage getNavGroupImage() 
		{
			return image;
		}
	
	/**
	* INavNode interface methods
	*/
	public AppImageVo getImageNode()
	{
		return getImage();
	}
	public Integer getIndexPositionNode()
	{
		return null;
	}
	public String getTextNode() 
	{
		return getGroupName();
	}
	public void setImageNode(AppImageVo image)
	{
		setImage(image);
	}
	public void setIndexPositionNode(Integer index)
	{
		return;
	}
	public void setTextNode(String text)
	{
		setGroupName(text);
	}
	public AppNavAccessRightsVo getAccessRightsNode()
	{
		return null;
	}
			
	public ims.admin.vo.enums.NavigationNodeType getTypeNode()
	{
		return ims.admin.vo.enums.NavigationNodeType.ROOTGROUP;
	}
	public void setAccessRightsNode(AppNavAccessRightsVo rights)
	{
		if (rights==null)
			return;
				
		if (groups != null)
		{
			for ( int i = 0 ; i<groups.size() ; i++)
			{
				groups.get(i).setAccessRightsNode(rights);
			}
		}
		if (forms != null)
		{
			for (int i = 0 ; i < forms.size() ; i++)
			{
				forms.get(i).setAccessRightsNode(rights);
			}
		}
				
	}
	public void setFormChildsNode(AppNavFormVoCollection childs)
	{
		setForms(childs);
				
	}
	public void setGroupsChildsNode(AppNavSecondGroupVoCollection groups)
	{
		setGroups(groups);
	}
	public AppNavFormVoCollection getFormChildsNode()
	{
		return getForms();
	}
	public AppNavSecondGroupVoCollection getGroupsChildsNode()
	{
		return getGroups();
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
		if(this.forms != null)
		{
			if(!this.forms.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.groups != null)
		{
			if(!this.groups.isValidated())
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
		if(this.groupname == null || this.groupname.length() == 0)
			listOfErrors.add("GroupName is mandatory");
		else if(this.groupname.length() > 50)
			listOfErrors.add("The length of the field [groupname] in the value object [ims.admin.vo.AppNavRootGroupVo] is too big. It should be less or equal to 50");
		if(this.forms != null)
		{
			String[] listOfOtherErrors = this.forms.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.groups != null)
		{
			String[] listOfOtherErrors = this.groups.validate();
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
	
		AppNavRootGroupVo clone = new AppNavRootGroupVo(this.id, this.version);
		
		clone.groupname = this.groupname;
		if(this.forms == null)
			clone.forms = null;
		else
			clone.forms = (ims.admin.vo.AppNavFormVoCollection)this.forms.clone();
		if(this.groups == null)
			clone.groups = null;
		else
			clone.groups = (ims.admin.vo.AppNavSecondGroupVoCollection)this.groups.clone();
		if(this.image == null)
			clone.image = null;
		else
			clone.image = (ims.admin.vo.AppImageVo)this.image.clone();
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
		if (!(AppNavRootGroupVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppNavRootGroupVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppNavRootGroupVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppNavRootGroupVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.groupname != null)
			count++;
		if(this.forms != null)
			count++;
		if(this.groups != null)
			count++;
		if(this.image != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String groupname;
	protected ims.admin.vo.AppNavFormVoCollection forms;
	protected ims.admin.vo.AppNavSecondGroupVoCollection groups;
	protected ims.admin.vo.AppImageVo image;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
