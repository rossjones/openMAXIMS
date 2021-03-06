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
 * Linked to core.clinical.VTERiskAssessment business object (ID: 1072100100).
 */
public class VTERiskAssessmentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<VTERiskAssessmentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<VTERiskAssessmentVo> col = new ArrayList<VTERiskAssessmentVo>();
	public String getBoClassName()
	{
		return "ims.core.clinical.domain.objects.VTERiskAssessment";
	}
	public boolean add(VTERiskAssessmentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, VTERiskAssessmentVo value)
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
	public int indexOf(VTERiskAssessmentVo instance)
	{
		return col.indexOf(instance);
	}
	public VTERiskAssessmentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, VTERiskAssessmentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(VTERiskAssessmentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(VTERiskAssessmentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		VTERiskAssessmentVoCollection clone = new VTERiskAssessmentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((VTERiskAssessmentVo)this.col.get(x).clone());
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
	public VTERiskAssessmentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public VTERiskAssessmentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public VTERiskAssessmentVoCollection sort(SortOrder order)
	{
		return sort(new VTERiskAssessmentVoComparator(order));
	}
	public VTERiskAssessmentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new VTERiskAssessmentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public VTERiskAssessmentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.clinical.vo.VTERiskAssessmentRefVoCollection toRefVoCollection()
	{
		ims.core.clinical.vo.VTERiskAssessmentRefVoCollection result = new ims.core.clinical.vo.VTERiskAssessmentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public VTERiskAssessmentVo[] toArray()
	{
		VTERiskAssessmentVo[] arr = new VTERiskAssessmentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<VTERiskAssessmentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class VTERiskAssessmentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public VTERiskAssessmentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public VTERiskAssessmentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public VTERiskAssessmentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			VTERiskAssessmentVo voObj1 = (VTERiskAssessmentVo)obj1;
			VTERiskAssessmentVo voObj2 = (VTERiskAssessmentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.VTERiskAssessmentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.VTERiskAssessmentVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.VTERiskAssessmentVoBean[] result = new ims.clinical.vo.beans.VTERiskAssessmentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			VTERiskAssessmentVo vo = ((VTERiskAssessmentVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.VTERiskAssessmentVoBean)vo.getBean();
		}
		return result;
	}
	public static VTERiskAssessmentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		VTERiskAssessmentVoCollection coll = new VTERiskAssessmentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.VTERiskAssessmentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static VTERiskAssessmentVoCollection buildFromBeanCollection(ims.clinical.vo.beans.VTERiskAssessmentVoBean[] beans)
	{
		VTERiskAssessmentVoCollection coll = new VTERiskAssessmentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
