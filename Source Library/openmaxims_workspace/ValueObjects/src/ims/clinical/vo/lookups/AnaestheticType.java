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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AnaestheticType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AnaestheticType()
	{
		super();
	}
	public AnaestheticType(int id)
	{
		super(id, "", true);
	}
	public AnaestheticType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AnaestheticType(int id, String text, boolean active, AnaestheticType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AnaestheticType(int id, String text, boolean active, AnaestheticType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AnaestheticType(int id, String text, boolean active, AnaestheticType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AnaestheticType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AnaestheticType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AnaestheticType)super.getParentInstance();
	}
	public AnaestheticType getParent()
	{
		return (AnaestheticType)super.getParentInstance();
	}
	public void setParent(AnaestheticType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AnaestheticType[] typedChildren = new AnaestheticType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AnaestheticType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AnaestheticType)
		{
			super.addChild((AnaestheticType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AnaestheticType)
		{
			super.removeChild((AnaestheticType)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		AnaestheticTypeCollection result = new AnaestheticTypeCollection();
		result.add(NOT_APPLICABLE);
		result.add(LA);
		return result;
	}
	public static AnaestheticType[] getNegativeInstances()
	{
		AnaestheticType[] instances = new AnaestheticType[2];
		instances[0] = NOT_APPLICABLE;
		instances[1] = LA;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "NOT_APPLICABLE";
		negativeInstances[1] = "LA";
		return negativeInstances;
	}
	public static AnaestheticType getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static AnaestheticType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AnaestheticType[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1231108;
	public static final AnaestheticType NOT_APPLICABLE = new AnaestheticType(-2166, "Not Applicable", true, null, null, Color.Default);
	public static final AnaestheticType LA = new AnaestheticType(-2205, "LA", true, null, null, Color.Default);
}
