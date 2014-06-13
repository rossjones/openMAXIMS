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

package ims.core.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.Documents.PatientDocument business object (ID: 1068100001).
 */
public class PatientDocumentSearchListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientDocumentSearchListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientDocumentSearchListVo> col = new ArrayList<PatientDocumentSearchListVo>();
	public String getBoClassName()
	{
		return "ims.core.documents.domain.objects.PatientDocument";
	}
	public boolean add(PatientDocumentSearchListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientDocumentSearchListVo value)
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
	public int indexOf(PatientDocumentSearchListVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientDocumentSearchListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientDocumentSearchListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientDocumentSearchListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientDocumentSearchListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientDocumentSearchListVoCollection clone = new PatientDocumentSearchListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientDocumentSearchListVo)this.col.get(x).clone());
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
	public PatientDocumentSearchListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientDocumentSearchListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientDocumentSearchListVoCollection sort(SortOrder order)
	{
		return sort(new PatientDocumentSearchListVoComparator(order));
	}
	public PatientDocumentSearchListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientDocumentSearchListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientDocumentSearchListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.documents.vo.PatientDocumentRefVoCollection toRefVoCollection()
	{
		ims.core.documents.vo.PatientDocumentRefVoCollection result = new ims.core.documents.vo.PatientDocumentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientDocumentSearchListVo[] toArray()
	{
		PatientDocumentSearchListVo[] arr = new PatientDocumentSearchListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientDocumentSearchListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientDocumentSearchListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientDocumentSearchListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientDocumentSearchListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientDocumentSearchListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientDocumentSearchListVo voObj1 = (PatientDocumentSearchListVo)obj1;
			PatientDocumentSearchListVo voObj2 = (PatientDocumentSearchListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.PatientDocumentSearchListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.PatientDocumentSearchListVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.PatientDocumentSearchListVoBean[] result = new ims.core.vo.beans.PatientDocumentSearchListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientDocumentSearchListVo vo = ((PatientDocumentSearchListVo)col.get(i));
			result[i] = (ims.core.vo.beans.PatientDocumentSearchListVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientDocumentSearchListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientDocumentSearchListVoCollection coll = new PatientDocumentSearchListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.PatientDocumentSearchListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientDocumentSearchListVoCollection buildFromBeanCollection(ims.core.vo.beans.PatientDocumentSearchListVoBean[] beans)
	{
		PatientDocumentSearchListVoCollection coll = new PatientDocumentSearchListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
