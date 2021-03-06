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

package ims.edischarge.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to eDischarge.Summary business object (ID: 1099100018).
 */
public class SummaryRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<SummaryRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SummaryRefVo> col = new ArrayList<SummaryRefVo>();
	public final String getBoClassName()
	{
		return "ims.edischarge.domain.objects.Summary";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(SummaryRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SummaryRefVo value)
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
	public int indexOf(SummaryRefVo instance)
	{
		return col.indexOf(instance);
	}
	public SummaryRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SummaryRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SummaryRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SummaryRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SummaryRefVoCollection clone = new SummaryRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SummaryRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public SummaryRefVo[] toArray()
	{
		SummaryRefVo[] arr = new SummaryRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public SummaryRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SummaryRefVoCollection sort(SortOrder order)
	{
		return sort(new SummaryRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public SummaryRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<SummaryRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SummaryRefVoComparator implements Comparator
	{
		private int direction = 1;
		public SummaryRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SummaryRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			SummaryRefVo voObj1 = (SummaryRefVo)obj1;
			SummaryRefVo voObj2 = (SummaryRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
