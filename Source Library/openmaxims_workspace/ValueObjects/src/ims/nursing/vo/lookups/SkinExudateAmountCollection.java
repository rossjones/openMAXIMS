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

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class SkinExudateAmountCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(SkinExudateAmount value)
	{
		super.add(value);
	}
	public int indexOf(SkinExudateAmount instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(SkinExudateAmount instance)
	{
		return indexOf(instance) >= 0;
	}
	public SkinExudateAmount get(int index)
	{
		return (SkinExudateAmount)super.getIndex(index);
	}
	public void remove(SkinExudateAmount instance)
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
		SkinExudateAmountCollection newCol = new SkinExudateAmountCollection();
		SkinExudateAmount item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new SkinExudateAmount(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
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
					item.setParent((SkinExudateAmount)item.getParent().clone());
			}
		}
		return newCol;
	}
	public SkinExudateAmount getInstance(int instanceId)
	{
		return (SkinExudateAmount)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public SkinExudateAmount[] toArray()
	{
		SkinExudateAmount[] arr = new SkinExudateAmount[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static SkinExudateAmountCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SkinExudateAmountCollection coll = new SkinExudateAmountCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(SkinExudateAmount.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static SkinExudateAmountCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		SkinExudateAmountCollection coll = new SkinExudateAmountCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(SkinExudateAmount.buildLookup(beans[x]));
		}
		return coll;
	}
}
