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

package ims.careuk.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to CAREUK.ConsultationOutcome business object (ID: 1096100028).
 */
public class ConsultationOutcomeRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<ConsultationOutcomeRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ConsultationOutcomeRefVo> col = new ArrayList<ConsultationOutcomeRefVo>();
	public final String getBoClassName()
	{
		return "ims.careuk.domain.objects.ConsultationOutcome";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(ConsultationOutcomeRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ConsultationOutcomeRefVo value)
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
	public int indexOf(ConsultationOutcomeRefVo instance)
	{
		return col.indexOf(instance);
	}
	public ConsultationOutcomeRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ConsultationOutcomeRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ConsultationOutcomeRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ConsultationOutcomeRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ConsultationOutcomeRefVoCollection clone = new ConsultationOutcomeRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ConsultationOutcomeRefVo)this.col.get(x).clone());
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
	public ConsultationOutcomeRefVo[] toArray()
	{
		ConsultationOutcomeRefVo[] arr = new ConsultationOutcomeRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ConsultationOutcomeRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ConsultationOutcomeRefVoCollection sort(SortOrder order)
	{
		return sort(new ConsultationOutcomeRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public ConsultationOutcomeRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<ConsultationOutcomeRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ConsultationOutcomeRefVoComparator implements Comparator
	{
		private int direction = 1;
		public ConsultationOutcomeRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ConsultationOutcomeRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ConsultationOutcomeRefVo voObj1 = (ConsultationOutcomeRefVo)obj1;
			ConsultationOutcomeRefVo voObj2 = (ConsultationOutcomeRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
