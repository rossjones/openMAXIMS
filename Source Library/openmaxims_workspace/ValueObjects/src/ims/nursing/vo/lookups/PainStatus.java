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

public class PainStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PainStatus()
	{
		super();
	}
	public PainStatus(int id)
	{
		super(id, "", true);
	}
	public PainStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PainStatus(int id, String text, boolean active, PainStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PainStatus(int id, String text, boolean active, PainStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PainStatus(int id, String text, boolean active, PainStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PainStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PainStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PainStatus)super.getParentInstance();
	}
	public PainStatus getParent()
	{
		return (PainStatus)super.getParentInstance();
	}
	public void setParent(PainStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PainStatus[] typedChildren = new PainStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PainStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PainStatus)
		{
			super.addChild((PainStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PainStatus)
		{
			super.removeChild((PainStatus)child);
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
		PainStatusCollection result = new PainStatusCollection();
		result.add(DISCONTINUED);
		result.add(CONTINUED);
		return result;
	}
	public static PainStatus[] getNegativeInstances()
	{
		PainStatus[] instances = new PainStatus[2];
		instances[0] = DISCONTINUED;
		instances[1] = CONTINUED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "DISCONTINUED";
		negativeInstances[1] = "CONTINUED";
		return negativeInstances;
	}
	public static PainStatus getNegativeInstance(String name)
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
	public static PainStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PainStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1001010;
	public static final PainStatus DISCONTINUED = new PainStatus(-29, "Discontinued", true, null, null, Color.Black);
	public static final PainStatus CONTINUED = new PainStatus(-152, "Copied", true, null, null, Color.Black);
}
