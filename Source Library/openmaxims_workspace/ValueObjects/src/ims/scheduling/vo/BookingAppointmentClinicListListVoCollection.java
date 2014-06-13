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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointmentClinicListListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<BookingAppointmentClinicListListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<BookingAppointmentClinicListListVo> col = new ArrayList<BookingAppointmentClinicListListVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Booking_Appointment";
	}
	public boolean add(BookingAppointmentClinicListListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, BookingAppointmentClinicListListVo value)
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
	public int indexOf(BookingAppointmentClinicListListVo instance)
	{
		return col.indexOf(instance);
	}
	public BookingAppointmentClinicListListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, BookingAppointmentClinicListListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(BookingAppointmentClinicListListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(BookingAppointmentClinicListListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		BookingAppointmentClinicListListVoCollection clone = new BookingAppointmentClinicListListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((BookingAppointmentClinicListListVo)this.col.get(x).clone());
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
	public BookingAppointmentClinicListListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public BookingAppointmentClinicListListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public BookingAppointmentClinicListListVoCollection sort(SortOrder order)
	{
		return sort(new BookingAppointmentClinicListListVoComparator(order));
	}
	public BookingAppointmentClinicListListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new BookingAppointmentClinicListListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public BookingAppointmentClinicListListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Booking_AppointmentRefVoCollection result = new ims.scheduling.vo.Booking_AppointmentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public BookingAppointmentClinicListListVo[] toArray()
	{
		BookingAppointmentClinicListListVo[] arr = new BookingAppointmentClinicListListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<BookingAppointmentClinicListListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class BookingAppointmentClinicListListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public BookingAppointmentClinicListListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public BookingAppointmentClinicListListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public BookingAppointmentClinicListListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			BookingAppointmentClinicListListVo voObj1 = (BookingAppointmentClinicListListVo)obj1;
			BookingAppointmentClinicListListVo voObj2 = (BookingAppointmentClinicListListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean[] result = new ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			BookingAppointmentClinicListListVo vo = ((BookingAppointmentClinicListListVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean)vo.getBean();
		}
		return result;
	}
	public static BookingAppointmentClinicListListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		BookingAppointmentClinicListListVoCollection coll = new BookingAppointmentClinicListListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static BookingAppointmentClinicListListVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.BookingAppointmentClinicListListVoBean[] beans)
	{
		BookingAppointmentClinicListListVoCollection coll = new BookingAppointmentClinicListListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
