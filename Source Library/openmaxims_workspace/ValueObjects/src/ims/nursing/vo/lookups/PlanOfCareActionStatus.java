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

package ims.nursing.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PlanOfCareActionStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PlanOfCareActionStatus()
	{
		super();
	}
	public PlanOfCareActionStatus(int id)
	{
		super(id, "", true);
	}
	public PlanOfCareActionStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PlanOfCareActionStatus(int id, String text, boolean active, PlanOfCareActionStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PlanOfCareActionStatus(int id, String text, boolean active, PlanOfCareActionStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PlanOfCareActionStatus(int id, String text, boolean active, PlanOfCareActionStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PlanOfCareActionStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PlanOfCareActionStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PlanOfCareActionStatus)super.getParentInstance();
	}
	public PlanOfCareActionStatus getParent()
	{
		return (PlanOfCareActionStatus)super.getParentInstance();
	}
	public void setParent(PlanOfCareActionStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PlanOfCareActionStatus[] typedChildren = new PlanOfCareActionStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PlanOfCareActionStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PlanOfCareActionStatus)
		{
			super.addChild((PlanOfCareActionStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PlanOfCareActionStatus)
		{
			super.removeChild((PlanOfCareActionStatus)child);
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
		PlanOfCareActionStatusCollection result = new PlanOfCareActionStatusCollection();
		result.add(ACTIVE);
		result.add(RESOLVED);
		result.add(REQUIRES_CONFIRMATION);
		return result;
	}
	public static PlanOfCareActionStatus[] getNegativeInstances()
	{
		PlanOfCareActionStatus[] instances = new PlanOfCareActionStatus[3];
		instances[0] = ACTIVE;
		instances[1] = RESOLVED;
		instances[2] = REQUIRES_CONFIRMATION;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "ACTIVE";
		negativeInstances[1] = "RESOLVED";
		negativeInstances[2] = "REQUIRES_CONFIRMATION";
		return negativeInstances;
	}
	public static PlanOfCareActionStatus getNegativeInstance(String name)
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
	public static PlanOfCareActionStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PlanOfCareActionStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1001073;
	public static final PlanOfCareActionStatus ACTIVE = new PlanOfCareActionStatus(-1129, "Active", true, null, null, Color.Default);
	public static final PlanOfCareActionStatus RESOLVED = new PlanOfCareActionStatus(-1130, "Resolved", true, null, null, Color.Default);
	public static final PlanOfCareActionStatus REQUIRES_CONFIRMATION = new PlanOfCareActionStatus(-1131, "Requires Confirmation", true, null, null, Color.Default);
}
