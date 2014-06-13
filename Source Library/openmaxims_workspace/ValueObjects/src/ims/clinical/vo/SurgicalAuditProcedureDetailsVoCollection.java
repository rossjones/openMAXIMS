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
 * Linked to clinical.SurgicalAuditProcedureDetails business object (ID: 1072100103).
 */
public class SurgicalAuditProcedureDetailsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SurgicalAuditProcedureDetailsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SurgicalAuditProcedureDetailsVo> col = new ArrayList<SurgicalAuditProcedureDetailsVo>();
	public String getBoClassName()
	{
		return "ims.clinical.domain.objects.SurgicalAuditProcedureDetails";
	}
	public boolean add(SurgicalAuditProcedureDetailsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SurgicalAuditProcedureDetailsVo value)
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
	public int indexOf(SurgicalAuditProcedureDetailsVo instance)
	{
		return col.indexOf(instance);
	}
	public SurgicalAuditProcedureDetailsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SurgicalAuditProcedureDetailsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SurgicalAuditProcedureDetailsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SurgicalAuditProcedureDetailsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SurgicalAuditProcedureDetailsVoCollection clone = new SurgicalAuditProcedureDetailsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SurgicalAuditProcedureDetailsVo)this.col.get(x).clone());
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
	public SurgicalAuditProcedureDetailsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SurgicalAuditProcedureDetailsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SurgicalAuditProcedureDetailsVoCollection sort(SortOrder order)
	{
		return sort(new SurgicalAuditProcedureDetailsVoComparator(order));
	}
	public SurgicalAuditProcedureDetailsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SurgicalAuditProcedureDetailsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SurgicalAuditProcedureDetailsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.clinical.vo.SurgicalAuditProcedureDetailsRefVoCollection toRefVoCollection()
	{
		ims.clinical.vo.SurgicalAuditProcedureDetailsRefVoCollection result = new ims.clinical.vo.SurgicalAuditProcedureDetailsRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SurgicalAuditProcedureDetailsVo[] toArray()
	{
		SurgicalAuditProcedureDetailsVo[] arr = new SurgicalAuditProcedureDetailsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SurgicalAuditProcedureDetailsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SurgicalAuditProcedureDetailsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SurgicalAuditProcedureDetailsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SurgicalAuditProcedureDetailsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SurgicalAuditProcedureDetailsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SurgicalAuditProcedureDetailsVo voObj1 = (SurgicalAuditProcedureDetailsVo)obj1;
			SurgicalAuditProcedureDetailsVo voObj2 = (SurgicalAuditProcedureDetailsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean[] result = new ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SurgicalAuditProcedureDetailsVo vo = ((SurgicalAuditProcedureDetailsVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean)vo.getBean();
		}
		return result;
	}
	public static SurgicalAuditProcedureDetailsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SurgicalAuditProcedureDetailsVoCollection coll = new SurgicalAuditProcedureDetailsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SurgicalAuditProcedureDetailsVoCollection buildFromBeanCollection(ims.clinical.vo.beans.SurgicalAuditProcedureDetailsVoBean[] beans)
	{
		SurgicalAuditProcedureDetailsVoCollection coll = new SurgicalAuditProcedureDetailsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
