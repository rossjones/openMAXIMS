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

package ims.spinalinjuries.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class MskBonesJointFindings extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public MskBonesJointFindings()
	{
		super();
	}
	public MskBonesJointFindings(int id)
	{
		super(id, "", true);
	}
	public MskBonesJointFindings(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public MskBonesJointFindings(int id, String text, boolean active, MskBonesJointFindings parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public MskBonesJointFindings(int id, String text, boolean active, MskBonesJointFindings parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public MskBonesJointFindings(int id, String text, boolean active, MskBonesJointFindings parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static MskBonesJointFindings buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new MskBonesJointFindings(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (MskBonesJointFindings)super.getParentInstance();
	}
	public MskBonesJointFindings getParent()
	{
		return (MskBonesJointFindings)super.getParentInstance();
	}
	public void setParent(MskBonesJointFindings parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		MskBonesJointFindings[] typedChildren = new MskBonesJointFindings[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (MskBonesJointFindings)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof MskBonesJointFindings)
		{
			super.addChild((MskBonesJointFindings)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof MskBonesJointFindings)
		{
			super.removeChild((MskBonesJointFindings)child);
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
		MskBonesJointFindingsCollection result = new MskBonesJointFindingsCollection();
		return result;
	}
	public static MskBonesJointFindings[] getNegativeInstances()
	{
		return new MskBonesJointFindings[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static MskBonesJointFindings getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static MskBonesJointFindings getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1051129;
}
