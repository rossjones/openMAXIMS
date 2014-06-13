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
 * Linked to therapies.treatment.FunctionalTransfers business object (ID: 1019100029).
 */
public class FunctionalTransfersVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<FunctionalTransfersVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<FunctionalTransfersVo> col = new ArrayList<FunctionalTransfersVo>();
	public String getBoClassName()
	{
		return "ims.therapies.treatment.domain.objects.FunctionalTransfers";
	}
	public boolean add(FunctionalTransfersVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, FunctionalTransfersVo value)
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
	public int indexOf(FunctionalTransfersVo instance)
	{
		return col.indexOf(instance);
	}
	public FunctionalTransfersVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, FunctionalTransfersVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(FunctionalTransfersVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(FunctionalTransfersVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		FunctionalTransfersVoCollection clone = new FunctionalTransfersVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((FunctionalTransfersVo)this.col.get(x).clone());
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
	public FunctionalTransfersVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public FunctionalTransfersVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public FunctionalTransfersVoCollection sort(SortOrder order)
	{
		return sort(new FunctionalTransfersVoComparator(order));
	}
	public FunctionalTransfersVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new FunctionalTransfersVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public FunctionalTransfersVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.therapies.treatment.vo.FunctionalTransfersRefVoCollection toRefVoCollection()
	{
		ims.therapies.treatment.vo.FunctionalTransfersRefVoCollection result = new ims.therapies.treatment.vo.FunctionalTransfersRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public FunctionalTransfersVo[] toArray()
	{
		FunctionalTransfersVo[] arr = new FunctionalTransfersVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<FunctionalTransfersVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class FunctionalTransfersVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public FunctionalTransfersVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public FunctionalTransfersVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public FunctionalTransfersVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			FunctionalTransfersVo voObj1 = (FunctionalTransfersVo)obj1;
			FunctionalTransfersVo voObj2 = (FunctionalTransfersVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.therapies.vo.beans.FunctionalTransfersVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.therapies.vo.beans.FunctionalTransfersVoBean[] getBeanCollectionArray()
	{
		ims.therapies.vo.beans.FunctionalTransfersVoBean[] result = new ims.therapies.vo.beans.FunctionalTransfersVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			FunctionalTransfersVo vo = ((FunctionalTransfersVo)col.get(i));
			result[i] = (ims.therapies.vo.beans.FunctionalTransfersVoBean)vo.getBean();
		}
		return result;
	}
	public static FunctionalTransfersVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		FunctionalTransfersVoCollection coll = new FunctionalTransfersVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.therapies.vo.beans.FunctionalTransfersVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static FunctionalTransfersVoCollection buildFromBeanCollection(ims.therapies.vo.beans.FunctionalTransfersVoBean[] beans)
	{
		FunctionalTransfersVoCollection coll = new FunctionalTransfersVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
