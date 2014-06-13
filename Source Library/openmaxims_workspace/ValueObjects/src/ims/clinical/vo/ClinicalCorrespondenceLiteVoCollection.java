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

package ims.clinical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to clinical.ClinicalCorrespondence business object (ID: 1072100040).
 */
public class ClinicalCorrespondenceLiteVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ClinicalCorrespondenceLiteVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ClinicalCorrespondenceLiteVo> col = new ArrayList<ClinicalCorrespondenceLiteVo>();
	public String getBoClassName()
	{
		return "ims.clinical.domain.objects.ClinicalCorrespondence";
	}
	public boolean add(ClinicalCorrespondenceLiteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ClinicalCorrespondenceLiteVo value)
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
	public int indexOf(ClinicalCorrespondenceLiteVo instance)
	{
		return col.indexOf(instance);
	}
	public ClinicalCorrespondenceLiteVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ClinicalCorrespondenceLiteVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ClinicalCorrespondenceLiteVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ClinicalCorrespondenceLiteVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ClinicalCorrespondenceLiteVoCollection clone = new ClinicalCorrespondenceLiteVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ClinicalCorrespondenceLiteVo)this.col.get(x).clone());
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
	public ClinicalCorrespondenceLiteVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ClinicalCorrespondenceLiteVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ClinicalCorrespondenceLiteVoCollection sort(SortOrder order)
	{
		return sort(new ClinicalCorrespondenceLiteVoComparator(order));
	}
	public ClinicalCorrespondenceLiteVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ClinicalCorrespondenceLiteVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ClinicalCorrespondenceLiteVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.clinical.vo.ClinicalCorrespondenceRefVoCollection toRefVoCollection()
	{
		ims.clinical.vo.ClinicalCorrespondenceRefVoCollection result = new ims.clinical.vo.ClinicalCorrespondenceRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ClinicalCorrespondenceLiteVo[] toArray()
	{
		ClinicalCorrespondenceLiteVo[] arr = new ClinicalCorrespondenceLiteVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ClinicalCorrespondenceLiteVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ClinicalCorrespondenceLiteVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ClinicalCorrespondenceLiteVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ClinicalCorrespondenceLiteVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ClinicalCorrespondenceLiteVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ClinicalCorrespondenceLiteVo voObj1 = (ClinicalCorrespondenceLiteVo)obj1;
			ClinicalCorrespondenceLiteVo voObj2 = (ClinicalCorrespondenceLiteVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean[] result = new ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ClinicalCorrespondenceLiteVo vo = ((ClinicalCorrespondenceLiteVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean)vo.getBean();
		}
		return result;
	}
	public static ClinicalCorrespondenceLiteVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ClinicalCorrespondenceLiteVoCollection coll = new ClinicalCorrespondenceLiteVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ClinicalCorrespondenceLiteVoCollection buildFromBeanCollection(ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean[] beans)
	{
		ClinicalCorrespondenceLiteVoCollection coll = new ClinicalCorrespondenceLiteVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
