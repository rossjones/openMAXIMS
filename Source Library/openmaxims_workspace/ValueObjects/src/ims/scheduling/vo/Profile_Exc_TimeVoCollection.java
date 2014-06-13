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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Profile_Exc_Time business object (ID: 1055100004).
 */
public class Profile_Exc_TimeVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Profile_Exc_TimeVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Profile_Exc_TimeVo> col = new ArrayList<Profile_Exc_TimeVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Profile_Exc_Time";
	}
	public boolean add(Profile_Exc_TimeVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Profile_Exc_TimeVo value)
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
	public int indexOf(Profile_Exc_TimeVo instance)
	{
		return col.indexOf(instance);
	}
	public Profile_Exc_TimeVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Profile_Exc_TimeVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Profile_Exc_TimeVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Profile_Exc_TimeVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Profile_Exc_TimeVoCollection clone = new Profile_Exc_TimeVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Profile_Exc_TimeVo)this.col.get(x).clone());
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
	public Profile_Exc_TimeVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Profile_Exc_TimeVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Profile_Exc_TimeVoCollection sort(SortOrder order)
	{
		return sort(new Profile_Exc_TimeVoComparator(order));
	}
	public Profile_Exc_TimeVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Profile_Exc_TimeVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Profile_Exc_TimeVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Profile_Exc_TimeRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Profile_Exc_TimeRefVoCollection result = new ims.scheduling.vo.Profile_Exc_TimeRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Profile_Exc_TimeVo[] toArray()
	{
		Profile_Exc_TimeVo[] arr = new Profile_Exc_TimeVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Profile_Exc_TimeVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Profile_Exc_TimeVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Profile_Exc_TimeVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Profile_Exc_TimeVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Profile_Exc_TimeVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Profile_Exc_TimeVo voObj1 = (Profile_Exc_TimeVo)obj1;
			Profile_Exc_TimeVo voObj2 = (Profile_Exc_TimeVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] result = new ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Profile_Exc_TimeVo vo = ((Profile_Exc_TimeVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.Profile_Exc_TimeVoBean)vo.getBean();
		}
		return result;
	}
	public static Profile_Exc_TimeVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Profile_Exc_TimeVoCollection coll = new Profile_Exc_TimeVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.Profile_Exc_TimeVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Profile_Exc_TimeVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] beans)
	{
		Profile_Exc_TimeVoCollection coll = new Profile_Exc_TimeVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
