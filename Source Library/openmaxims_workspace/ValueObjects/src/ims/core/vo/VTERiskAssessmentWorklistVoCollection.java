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
 * Linked to core.admin.pas.Inpatient Episode business object (ID: 1014100000).
 */
public class VTERiskAssessmentWorklistVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<VTERiskAssessmentWorklistVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<VTERiskAssessmentWorklistVo> col = new ArrayList<VTERiskAssessmentWorklistVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.pas.domain.objects.InpatientEpisode";
	}
	public boolean add(VTERiskAssessmentWorklistVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, VTERiskAssessmentWorklistVo value)
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
	public int indexOf(VTERiskAssessmentWorklistVo instance)
	{
		return col.indexOf(instance);
	}
	public VTERiskAssessmentWorklistVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, VTERiskAssessmentWorklistVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(VTERiskAssessmentWorklistVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(VTERiskAssessmentWorklistVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		VTERiskAssessmentWorklistVoCollection clone = new VTERiskAssessmentWorklistVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((VTERiskAssessmentWorklistVo)this.col.get(x).clone());
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
	public VTERiskAssessmentWorklistVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public VTERiskAssessmentWorklistVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public VTERiskAssessmentWorklistVoCollection sort(SortOrder order)
	{
		return sort(new VTERiskAssessmentWorklistVoComparator(order));
	}
	public VTERiskAssessmentWorklistVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new VTERiskAssessmentWorklistVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public VTERiskAssessmentWorklistVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.pas.vo.InpatientEpisodeRefVoCollection toRefVoCollection()
	{
		ims.core.admin.pas.vo.InpatientEpisodeRefVoCollection result = new ims.core.admin.pas.vo.InpatientEpisodeRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public VTERiskAssessmentWorklistVo[] toArray()
	{
		VTERiskAssessmentWorklistVo[] arr = new VTERiskAssessmentWorklistVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IVTERiskAssessment[] toIVTERiskAssessmentArray()
	{
		ims.vo.interfaces.IVTERiskAssessment[] arr = new ims.vo.interfaces.IVTERiskAssessment[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<VTERiskAssessmentWorklistVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class VTERiskAssessmentWorklistVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public VTERiskAssessmentWorklistVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public VTERiskAssessmentWorklistVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public VTERiskAssessmentWorklistVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			VTERiskAssessmentWorklistVo voObj1 = (VTERiskAssessmentWorklistVo)obj1;
			VTERiskAssessmentWorklistVo voObj2 = (VTERiskAssessmentWorklistVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.VTERiskAssessmentWorklistVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.VTERiskAssessmentWorklistVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.VTERiskAssessmentWorklistVoBean[] result = new ims.core.vo.beans.VTERiskAssessmentWorklistVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			VTERiskAssessmentWorklistVo vo = ((VTERiskAssessmentWorklistVo)col.get(i));
			result[i] = (ims.core.vo.beans.VTERiskAssessmentWorklistVoBean)vo.getBean();
		}
		return result;
	}
	public static VTERiskAssessmentWorklistVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		VTERiskAssessmentWorklistVoCollection coll = new VTERiskAssessmentWorklistVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.VTERiskAssessmentWorklistVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static VTERiskAssessmentWorklistVoCollection buildFromBeanCollection(ims.core.vo.beans.VTERiskAssessmentWorklistVoBean[] beans)
	{
		VTERiskAssessmentWorklistVoCollection coll = new VTERiskAssessmentWorklistVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
