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
 * Linked to eDischarge.TTAMedicationDetail business object (ID: 1099100016).
 */
public class TTAMedicationDetailForTTAHistoryVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<TTAMedicationDetailForTTAHistoryVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TTAMedicationDetailForTTAHistoryVo> col = new ArrayList<TTAMedicationDetailForTTAHistoryVo>();
	public String getBoClassName()
	{
		return "ims.edischarge.domain.objects.TTAMedicationDetail";
	}
	public boolean add(TTAMedicationDetailForTTAHistoryVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TTAMedicationDetailForTTAHistoryVo value)
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
	public int indexOf(TTAMedicationDetailForTTAHistoryVo instance)
	{
		return col.indexOf(instance);
	}
	public TTAMedicationDetailForTTAHistoryVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TTAMedicationDetailForTTAHistoryVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TTAMedicationDetailForTTAHistoryVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TTAMedicationDetailForTTAHistoryVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TTAMedicationDetailForTTAHistoryVoCollection clone = new TTAMedicationDetailForTTAHistoryVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TTAMedicationDetailForTTAHistoryVo)this.col.get(x).clone());
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
	public TTAMedicationDetailForTTAHistoryVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TTAMedicationDetailForTTAHistoryVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public TTAMedicationDetailForTTAHistoryVoCollection sort(SortOrder order)
	{
		return sort(new TTAMedicationDetailForTTAHistoryVoComparator(order));
	}
	public TTAMedicationDetailForTTAHistoryVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new TTAMedicationDetailForTTAHistoryVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public TTAMedicationDetailForTTAHistoryVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.edischarge.vo.TTAMedicationDetailRefVoCollection toRefVoCollection()
	{
		ims.edischarge.vo.TTAMedicationDetailRefVoCollection result = new ims.edischarge.vo.TTAMedicationDetailRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public TTAMedicationDetailForTTAHistoryVo[] toArray()
	{
		TTAMedicationDetailForTTAHistoryVo[] arr = new TTAMedicationDetailForTTAHistoryVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<TTAMedicationDetailForTTAHistoryVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TTAMedicationDetailForTTAHistoryVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public TTAMedicationDetailForTTAHistoryVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TTAMedicationDetailForTTAHistoryVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public TTAMedicationDetailForTTAHistoryVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			TTAMedicationDetailForTTAHistoryVo voObj1 = (TTAMedicationDetailForTTAHistoryVo)obj1;
			TTAMedicationDetailForTTAHistoryVo voObj2 = (TTAMedicationDetailForTTAHistoryVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean[] result = new ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			TTAMedicationDetailForTTAHistoryVo vo = ((TTAMedicationDetailForTTAHistoryVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean)vo.getBean();
		}
		return result;
	}
	public static TTAMedicationDetailForTTAHistoryVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		TTAMedicationDetailForTTAHistoryVoCollection coll = new TTAMedicationDetailForTTAHistoryVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static TTAMedicationDetailForTTAHistoryVoCollection buildFromBeanCollection(ims.clinical.vo.beans.TTAMedicationDetailForTTAHistoryVoBean[] beans)
	{
		TTAMedicationDetailForTTAHistoryVoCollection coll = new TTAMedicationDetailForTTAHistoryVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
