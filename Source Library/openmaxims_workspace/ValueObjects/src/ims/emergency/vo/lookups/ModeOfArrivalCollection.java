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

package ims.emergency.vo.lookups;

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class ModeOfArrivalCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(ModeOfArrival value)
	{
		super.add(value);
	}
	public int indexOf(ModeOfArrival instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(ModeOfArrival instance)
	{
		return indexOf(instance) >= 0;
	}
	public ModeOfArrival get(int index)
	{
		return (ModeOfArrival)super.getIndex(index);
	}
	public void remove(ModeOfArrival instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public Object clone()
	{
		ModeOfArrivalCollection newCol = new ModeOfArrivalCollection();
		ModeOfArrival item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new ModeOfArrival(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
		}
		for (int i = 0; i < newCol.size(); i++)
		{
			item = newCol.get(i);
			if (item.getParent() != null)
			{
				int parentIndex = this.indexOf(item.getParent());
				if(parentIndex >= 0)
					item.setParent(newCol.get(parentIndex));
				else
					item.setParent((ModeOfArrival)item.getParent().clone());
			}
		}
		return newCol;
	}
	public ModeOfArrival getInstance(int instanceId)
	{
		return (ModeOfArrival)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public ModeOfArrival[] toArray()
	{
		ModeOfArrival[] arr = new ModeOfArrival[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static ModeOfArrivalCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ModeOfArrivalCollection coll = new ModeOfArrivalCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(ModeOfArrival.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static ModeOfArrivalCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		ModeOfArrivalCollection coll = new ModeOfArrivalCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(ModeOfArrival.buildLookup(beans[x]));
		}
		return coll;
	}
}
