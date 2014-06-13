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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AdviceToPatient extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AdviceToPatient()
	{
		super();
	}
	public AdviceToPatient(int id)
	{
		super(id, "", true);
	}
	public AdviceToPatient(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AdviceToPatient(int id, String text, boolean active, AdviceToPatient parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AdviceToPatient(int id, String text, boolean active, AdviceToPatient parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AdviceToPatient(int id, String text, boolean active, AdviceToPatient parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AdviceToPatient buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AdviceToPatient(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AdviceToPatient)super.getParentInstance();
	}
	public AdviceToPatient getParent()
	{
		return (AdviceToPatient)super.getParentInstance();
	}
	public void setParent(AdviceToPatient parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AdviceToPatient[] typedChildren = new AdviceToPatient[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AdviceToPatient)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AdviceToPatient)
		{
			super.addChild((AdviceToPatient)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AdviceToPatient)
		{
			super.removeChild((AdviceToPatient)child);
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
		AdviceToPatientCollection result = new AdviceToPatientCollection();
		return result;
	}
	public static AdviceToPatient[] getNegativeInstances()
	{
		return new AdviceToPatient[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static AdviceToPatient getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static AdviceToPatient getNegativeInstance(Integer id)
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
	public static final int TYPE_ID = 1021248;
}
