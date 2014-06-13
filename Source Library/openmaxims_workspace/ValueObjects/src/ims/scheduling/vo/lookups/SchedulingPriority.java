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

package ims.scheduling.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SchedulingPriority extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SchedulingPriority()
	{
		super();
	}
	public SchedulingPriority(int id)
	{
		super(id, "", true);
	}
	public SchedulingPriority(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SchedulingPriority(int id, String text, boolean active, SchedulingPriority parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SchedulingPriority(int id, String text, boolean active, SchedulingPriority parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SchedulingPriority(int id, String text, boolean active, SchedulingPriority parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SchedulingPriority buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SchedulingPriority(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SchedulingPriority)super.getParentInstance();
	}
	public SchedulingPriority getParent()
	{
		return (SchedulingPriority)super.getParentInstance();
	}
	public void setParent(SchedulingPriority parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SchedulingPriority[] typedChildren = new SchedulingPriority[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SchedulingPriority)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SchedulingPriority)
		{
			super.addChild((SchedulingPriority)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SchedulingPriority)
		{
			super.removeChild((SchedulingPriority)child);
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
		SchedulingPriorityCollection result = new SchedulingPriorityCollection();
		result.add(URGENT);
		result.add(ROUTINE);
		return result;
	}
	public static SchedulingPriority[] getNegativeInstances()
	{
		SchedulingPriority[] instances = new SchedulingPriority[2];
		instances[0] = URGENT;
		instances[1] = ROUTINE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "URGENT";
		negativeInstances[1] = "ROUTINE";
		return negativeInstances;
	}
	public static SchedulingPriority getNegativeInstance(String name)
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
	public static SchedulingPriority getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SchedulingPriority[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1141009;
	public static final SchedulingPriority URGENT = new SchedulingPriority(-276, "Urgent", true, null, new ims.framework.utils.ImagePath(102103, "Images/Core/AnswerBox_NotAvailable.gif"), Color.Default);
	public static final SchedulingPriority ROUTINE = new SchedulingPriority(-277, "Routine", true, null, new ims.framework.utils.ImagePath(102106, "Images/Core/R.gif"), Color.Default);
}
