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

package ims.emergency.configuration.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to emergency.Configuration.TrackingArea business object (ID: 1087100001).
 */
public class TrackingAreaRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<TrackingAreaRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TrackingAreaRefVo> col = new ArrayList<TrackingAreaRefVo>();
	public final String getBoClassName()
	{
		return "ims.emergency.configuration.domain.objects.TrackingArea";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(TrackingAreaRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TrackingAreaRefVo value)
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
	public int indexOf(TrackingAreaRefVo instance)
	{
		return col.indexOf(instance);
	}
	public TrackingAreaRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TrackingAreaRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TrackingAreaRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TrackingAreaRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TrackingAreaRefVoCollection clone = new TrackingAreaRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TrackingAreaRefVo)this.col.get(x).clone());
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
	public TrackingAreaRefVo[] toArray()
	{
		TrackingAreaRefVo[] arr = new TrackingAreaRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public TrackingAreaRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TrackingAreaRefVoCollection sort(SortOrder order)
	{
		return sort(new TrackingAreaRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public TrackingAreaRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<TrackingAreaRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TrackingAreaRefVoComparator implements Comparator
	{
		private int direction = 1;
		public TrackingAreaRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TrackingAreaRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			TrackingAreaRefVo voObj1 = (TrackingAreaRefVo)obj1;
			TrackingAreaRefVo voObj2 = (TrackingAreaRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
