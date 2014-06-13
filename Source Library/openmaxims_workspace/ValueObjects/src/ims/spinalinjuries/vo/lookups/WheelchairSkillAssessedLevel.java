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

public class WheelchairSkillAssessedLevel extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public WheelchairSkillAssessedLevel()
	{
		super();
	}
	public WheelchairSkillAssessedLevel(int id)
	{
		super(id, "", true);
	}
	public WheelchairSkillAssessedLevel(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public WheelchairSkillAssessedLevel(int id, String text, boolean active, WheelchairSkillAssessedLevel parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public WheelchairSkillAssessedLevel(int id, String text, boolean active, WheelchairSkillAssessedLevel parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public WheelchairSkillAssessedLevel(int id, String text, boolean active, WheelchairSkillAssessedLevel parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static WheelchairSkillAssessedLevel buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new WheelchairSkillAssessedLevel(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (WheelchairSkillAssessedLevel)super.getParentInstance();
	}
	public WheelchairSkillAssessedLevel getParent()
	{
		return (WheelchairSkillAssessedLevel)super.getParentInstance();
	}
	public void setParent(WheelchairSkillAssessedLevel parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		WheelchairSkillAssessedLevel[] typedChildren = new WheelchairSkillAssessedLevel[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (WheelchairSkillAssessedLevel)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof WheelchairSkillAssessedLevel)
		{
			super.addChild((WheelchairSkillAssessedLevel)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof WheelchairSkillAssessedLevel)
		{
			super.removeChild((WheelchairSkillAssessedLevel)child);
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
		WheelchairSkillAssessedLevelCollection result = new WheelchairSkillAssessedLevelCollection();
		result.add(CONTINUOUSLYGOOD);
		result.add(FAIR);
		result.add(POOR);
		return result;
	}
	public static WheelchairSkillAssessedLevel[] getNegativeInstances()
	{
		WheelchairSkillAssessedLevel[] instances = new WheelchairSkillAssessedLevel[3];
		instances[0] = CONTINUOUSLYGOOD;
		instances[1] = FAIR;
		instances[2] = POOR;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "CONTINUOUSLYGOOD";
		negativeInstances[1] = "FAIR";
		negativeInstances[2] = "POOR";
		return negativeInstances;
	}
	public static WheelchairSkillAssessedLevel getNegativeInstance(String name)
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
	public static WheelchairSkillAssessedLevel getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		WheelchairSkillAssessedLevel[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1051068;
	public static final WheelchairSkillAssessedLevel CONTINUOUSLYGOOD = new WheelchairSkillAssessedLevel(-247, "Continuously Good", true, null, null, Color.Default);
	public static final WheelchairSkillAssessedLevel FAIR = new WheelchairSkillAssessedLevel(-248, "Fair", true, null, null, Color.Default);
	public static final WheelchairSkillAssessedLevel POOR = new WheelchairSkillAssessedLevel(-249, "Poor", true, null, null, Color.Default);
}
