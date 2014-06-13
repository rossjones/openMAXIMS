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

package ims.pathways.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Pathways.PatientJourneyStatus business object (ID: 1088100004).
 */
public class PatientJourneyStatusRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<PatientJourneyStatusRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientJourneyStatusRefVo> col = new ArrayList<PatientJourneyStatusRefVo>();
	public final String getBoClassName()
	{
		return "ims.pathways.domain.objects.PatientJourneyStatus";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(PatientJourneyStatusRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientJourneyStatusRefVo value)
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
	public int indexOf(PatientJourneyStatusRefVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientJourneyStatusRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientJourneyStatusRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientJourneyStatusRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientJourneyStatusRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientJourneyStatusRefVoCollection clone = new PatientJourneyStatusRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientJourneyStatusRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public PatientJourneyStatusRefVo[] toArray()
	{
		PatientJourneyStatusRefVo[] arr = new PatientJourneyStatusRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public PatientJourneyStatusRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientJourneyStatusRefVoCollection sort(SortOrder order)
	{
		return sort(new PatientJourneyStatusRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public PatientJourneyStatusRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<PatientJourneyStatusRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientJourneyStatusRefVoComparator implements Comparator
	{
		private int direction = 1;
		public PatientJourneyStatusRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientJourneyStatusRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientJourneyStatusRefVo voObj1 = (PatientJourneyStatusRefVo)obj1;
			PatientJourneyStatusRefVo voObj2 = (PatientJourneyStatusRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
