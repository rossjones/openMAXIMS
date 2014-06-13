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

package ims.emergency.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to emergency.Configuration.AdviceLeafletsConfig business object (ID: 1087100013).
 */
public class AdviceLeafletConfigDisplayVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<AdviceLeafletConfigDisplayVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<AdviceLeafletConfigDisplayVo> col = new ArrayList<AdviceLeafletConfigDisplayVo>();
	public String getBoClassName()
	{
		return "ims.emergency.configuration.domain.objects.AdviceLeafletsConfig";
	}
	public boolean add(AdviceLeafletConfigDisplayVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, AdviceLeafletConfigDisplayVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(AdviceLeafletConfigDisplayVo instance)
	{
		return col.indexOf(instance);
	}
	public AdviceLeafletConfigDisplayVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, AdviceLeafletConfigDisplayVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(AdviceLeafletConfigDisplayVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(AdviceLeafletConfigDisplayVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		AdviceLeafletConfigDisplayVoCollection clone = new AdviceLeafletConfigDisplayVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((AdviceLeafletConfigDisplayVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public AdviceLeafletConfigDisplayVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public AdviceLeafletConfigDisplayVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public AdviceLeafletConfigDisplayVoCollection sort(SortOrder order)
	{
		return sort(new AdviceLeafletConfigDisplayVoComparator(order));
	}
	public AdviceLeafletConfigDisplayVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new AdviceLeafletConfigDisplayVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public AdviceLeafletConfigDisplayVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.emergency.configuration.vo.AdviceLeafletsConfigRefVoCollection toRefVoCollection()
	{
		ims.emergency.configuration.vo.AdviceLeafletsConfigRefVoCollection result = new ims.emergency.configuration.vo.AdviceLeafletsConfigRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public AdviceLeafletConfigDisplayVo[] toArray()
	{
		AdviceLeafletConfigDisplayVo[] arr = new AdviceLeafletConfigDisplayVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<AdviceLeafletConfigDisplayVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class AdviceLeafletConfigDisplayVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public AdviceLeafletConfigDisplayVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public AdviceLeafletConfigDisplayVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public AdviceLeafletConfigDisplayVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			AdviceLeafletConfigDisplayVo voObj1 = (AdviceLeafletConfigDisplayVo)obj1;
			AdviceLeafletConfigDisplayVo voObj2 = (AdviceLeafletConfigDisplayVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean[] getBeanCollectionArray()
	{
		ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean[] result = new ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			AdviceLeafletConfigDisplayVo vo = ((AdviceLeafletConfigDisplayVo)col.get(i));
			result[i] = (ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean)vo.getBean();
		}
		return result;
	}
	public static AdviceLeafletConfigDisplayVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		AdviceLeafletConfigDisplayVoCollection coll = new AdviceLeafletConfigDisplayVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static AdviceLeafletConfigDisplayVoCollection buildFromBeanCollection(ims.emergency.vo.beans.AdviceLeafletConfigDisplayVoBean[] beans)
	{
		AdviceLeafletConfigDisplayVoCollection coll = new AdviceLeafletConfigDisplayVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
