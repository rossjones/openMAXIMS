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
 * Linked to emergency.Triage business object (ID: 1086100004).
 */
public class TriageForClinicianWorklistVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<TriageForClinicianWorklistVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TriageForClinicianWorklistVo> col = new ArrayList<TriageForClinicianWorklistVo>();
	public String getBoClassName()
	{
		return "ims.emergency.domain.objects.Triage";
	}
	public boolean add(TriageForClinicianWorklistVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TriageForClinicianWorklistVo value)
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
	public int indexOf(TriageForClinicianWorklistVo instance)
	{
		return col.indexOf(instance);
	}
	public TriageForClinicianWorklistVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TriageForClinicianWorklistVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TriageForClinicianWorklistVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TriageForClinicianWorklistVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TriageForClinicianWorklistVoCollection clone = new TriageForClinicianWorklistVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TriageForClinicianWorklistVo)this.col.get(x).clone());
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
	public TriageForClinicianWorklistVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TriageForClinicianWorklistVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public TriageForClinicianWorklistVoCollection sort(SortOrder order)
	{
		return sort(new TriageForClinicianWorklistVoComparator(order));
	}
	public TriageForClinicianWorklistVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new TriageForClinicianWorklistVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public TriageForClinicianWorklistVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.emergency.vo.TriageRefVoCollection toRefVoCollection()
	{
		ims.emergency.vo.TriageRefVoCollection result = new ims.emergency.vo.TriageRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public TriageForClinicianWorklistVo[] toArray()
	{
		TriageForClinicianWorklistVo[] arr = new TriageForClinicianWorklistVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<TriageForClinicianWorklistVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TriageForClinicianWorklistVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public TriageForClinicianWorklistVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TriageForClinicianWorklistVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public TriageForClinicianWorklistVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			TriageForClinicianWorklistVo voObj1 = (TriageForClinicianWorklistVo)obj1;
			TriageForClinicianWorklistVo voObj2 = (TriageForClinicianWorklistVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.emergency.vo.beans.TriageForClinicianWorklistVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.emergency.vo.beans.TriageForClinicianWorklistVoBean[] getBeanCollectionArray()
	{
		ims.emergency.vo.beans.TriageForClinicianWorklistVoBean[] result = new ims.emergency.vo.beans.TriageForClinicianWorklistVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			TriageForClinicianWorklistVo vo = ((TriageForClinicianWorklistVo)col.get(i));
			result[i] = (ims.emergency.vo.beans.TriageForClinicianWorklistVoBean)vo.getBean();
		}
		return result;
	}
	public static TriageForClinicianWorklistVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		TriageForClinicianWorklistVoCollection coll = new TriageForClinicianWorklistVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.emergency.vo.beans.TriageForClinicianWorklistVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static TriageForClinicianWorklistVoCollection buildFromBeanCollection(ims.emergency.vo.beans.TriageForClinicianWorklistVoBean[] beans)
	{
		TriageForClinicianWorklistVoCollection coll = new TriageForClinicianWorklistVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
