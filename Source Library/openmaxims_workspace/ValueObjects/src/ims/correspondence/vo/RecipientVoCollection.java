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

package ims.correspondence.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to correspondence.Recipient business object (ID: 1052100003).
 */
public class RecipientVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<RecipientVo>, ims.vo.interfaces.IRecipientList
{
	private static final long serialVersionUID = 1L;

	private ArrayList<RecipientVo> col = new ArrayList<RecipientVo>();
	public String getBoClassName()
	{
		return "ims.correspondence.domain.objects.Recipient";
	}
	public boolean add(RecipientVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, RecipientVo value)
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
	public int indexOf(RecipientVo instance)
	{
		return col.indexOf(instance);
	}
	public RecipientVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, RecipientVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(RecipientVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(RecipientVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		RecipientVoCollection clone = new RecipientVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((RecipientVo)this.col.get(x).clone());
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
	public RecipientVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public RecipientVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public RecipientVoCollection sort(SortOrder order)
	{
		return sort(new RecipientVoComparator(order));
	}
	public RecipientVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new RecipientVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public RecipientVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.correspondence.vo.RecipientRefVoCollection toRefVoCollection()
	{
		ims.correspondence.vo.RecipientRefVoCollection result = new ims.correspondence.vo.RecipientRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public RecipientVo[] toArray()
	{
		RecipientVo[] arr = new RecipientVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IRecipient[] toIRecipientArray()
	{
		ims.vo.interfaces.IRecipient[] arr = new ims.vo.interfaces.IRecipient[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<RecipientVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class RecipientVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public RecipientVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public RecipientVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public RecipientVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			RecipientVo voObj1 = (RecipientVo)obj1;
			RecipientVo voObj2 = (RecipientVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.correspondence.vo.beans.RecipientVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.correspondence.vo.beans.RecipientVoBean[] getBeanCollectionArray()
	{
		ims.correspondence.vo.beans.RecipientVoBean[] result = new ims.correspondence.vo.beans.RecipientVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			RecipientVo vo = ((RecipientVo)col.get(i));
			result[i] = (ims.correspondence.vo.beans.RecipientVoBean)vo.getBean();
		}
		return result;
	}
	public static RecipientVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		RecipientVoCollection coll = new RecipientVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.correspondence.vo.beans.RecipientVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static RecipientVoCollection buildFromBeanCollection(ims.correspondence.vo.beans.RecipientVoBean[] beans)
	{
		RecipientVoCollection coll = new RecipientVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
	/**
	* IRecipientList Interface Implementation
	*/
	public ims.vo.interfaces.IRecipient[] toIRecipientlistItemArray()
	{
		ims.vo.interfaces.IRecipient[] arr = new ims.vo.interfaces.IRecipient[col.size()];
		col.toArray(arr);
		return arr;
	}
	
	public ims.correspondence.vo.RecipientVoCollection getRecipientlistItems()
	{
		return this;
	}
	public ims.vo.interfaces.IRecipient[] getIRecipientlistItems()
	{
		return this.getRecipientlistItems().toIRecipientlistItemArray();
	}
	
	public ims.vo.interfaces.IRecipient[] getRecipients()
	{
		return getIRecipientlistItems();
	}
	
	public String getIRecipientsWithNoEmail()
	{
		String noEmail = null;
		for (int i = 0; i < this.size(); i++)
		{
			if (this.get(i).getEmailAddress() == null)
				noEmail += this.get(i).getRecipientName();
		}
		return noEmail;
	}
	
	public void setRecipients(ims.vo.interfaces.IRecipient[] recipients)
	{
		if (recipients == null)
			return;
		for (int i = 0; i < recipients.length; i++)
		{
			this.add((RecipientVo)recipients[i]);
		}
	}
	
	public void addRecipient(ims.vo.interfaces.IRecipient recipient)
	{
		this.getRecipientlistItems().add((RecipientVo)recipient);
	}
	
	public void removeRecipient(ims.vo.interfaces.IRecipient ilistItem)
	{
		this.getRecipientlistItems().remove((RecipientVo)ilistItem);
	}
	
}
