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

package ims.nursing.assessment.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to nursing.assessment.Eating Manual Dexterity business object (ID: 1012100023).
 */
public class EatingManualDexterityRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<EatingManualDexterityRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<EatingManualDexterityRefVo> col = new ArrayList<EatingManualDexterityRefVo>();
	public final String getBoClassName()
	{
		return "ims.nursing.assessment.domain.objects.EatingManualDexterity";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(EatingManualDexterityRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, EatingManualDexterityRefVo value)
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
	public int indexOf(EatingManualDexterityRefVo instance)
	{
		return col.indexOf(instance);
	}
	public EatingManualDexterityRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, EatingManualDexterityRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(EatingManualDexterityRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(EatingManualDexterityRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		EatingManualDexterityRefVoCollection clone = new EatingManualDexterityRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((EatingManualDexterityRefVo)this.col.get(x).clone());
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
	public EatingManualDexterityRefVo[] toArray()
	{
		EatingManualDexterityRefVo[] arr = new EatingManualDexterityRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public EatingManualDexterityRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public EatingManualDexterityRefVoCollection sort(SortOrder order)
	{
		return sort(new EatingManualDexterityRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public EatingManualDexterityRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<EatingManualDexterityRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class EatingManualDexterityRefVoComparator implements Comparator
	{
		private int direction = 1;
		public EatingManualDexterityRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public EatingManualDexterityRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			EatingManualDexterityRefVo voObj1 = (EatingManualDexterityRefVo)obj1;
			EatingManualDexterityRefVo voObj2 = (EatingManualDexterityRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
