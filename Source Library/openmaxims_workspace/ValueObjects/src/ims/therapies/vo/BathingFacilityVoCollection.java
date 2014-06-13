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

package ims.therapies.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to therapies.homeAndEnvironmentalVisit.VisitAssessmentComponent business object (ID: 1019100090).
 */
public class BathingFacilityVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<BathingFacilityVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<BathingFacilityVo> col = new ArrayList<BathingFacilityVo>();
	public String getBoClassName()
	{
		return "ims.therapies.homeandenvironmentalvisit.domain.objects.VisitAssessmentComponent";
	}
	public boolean add(BathingFacilityVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, BathingFacilityVo value)
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
	public int indexOf(BathingFacilityVo instance)
	{
		return col.indexOf(instance);
	}
	public BathingFacilityVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, BathingFacilityVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(BathingFacilityVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(BathingFacilityVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		BathingFacilityVoCollection clone = new BathingFacilityVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((BathingFacilityVo)this.col.get(x).clone());
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
	public BathingFacilityVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public BathingFacilityVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public BathingFacilityVoCollection sort(SortOrder order)
	{
		return sort(new BathingFacilityVoComparator(order));
	}
	public BathingFacilityVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new BathingFacilityVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public BathingFacilityVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.therapies.homeandenvironmentalvisit.vo.VisitAssessmentComponentRefVoCollection toRefVoCollection()
	{
		ims.therapies.homeandenvironmentalvisit.vo.VisitAssessmentComponentRefVoCollection result = new ims.therapies.homeandenvironmentalvisit.vo.VisitAssessmentComponentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public BathingFacilityVo[] toArray()
	{
		BathingFacilityVo[] arr = new BathingFacilityVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<BathingFacilityVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class BathingFacilityVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public BathingFacilityVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public BathingFacilityVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public BathingFacilityVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			BathingFacilityVo voObj1 = (BathingFacilityVo)obj1;
			BathingFacilityVo voObj2 = (BathingFacilityVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.therapies.vo.beans.BathingFacilityVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.therapies.vo.beans.BathingFacilityVoBean[] getBeanCollectionArray()
	{
		ims.therapies.vo.beans.BathingFacilityVoBean[] result = new ims.therapies.vo.beans.BathingFacilityVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			BathingFacilityVo vo = ((BathingFacilityVo)col.get(i));
			result[i] = (ims.therapies.vo.beans.BathingFacilityVoBean)vo.getBean();
		}
		return result;
	}
	public static BathingFacilityVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		BathingFacilityVoCollection coll = new BathingFacilityVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.therapies.vo.beans.BathingFacilityVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static BathingFacilityVoCollection buildFromBeanCollection(ims.therapies.vo.beans.BathingFacilityVoBean[] beans)
	{
		BathingFacilityVoCollection coll = new BathingFacilityVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
