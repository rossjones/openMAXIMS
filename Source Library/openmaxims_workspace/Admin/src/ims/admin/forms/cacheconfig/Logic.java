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
// This code was generated by John MacEnri using IMS Development Environment (version 1.53 build 2566.31117)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.cacheconfig;

import ims.admin.forms.cacheconfig.GenForm.grdObjectListRow;
import ims.admin.vo.CachedClassVo;
import ims.admin.vo.CachedClassVoCollection;
import ims.admin.vo.HibernateCacheStatisticsVo;
import ims.admin.vo.lookups.CacheUsage;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Logic extends BaseLogic
{ 
	private static final long	serialVersionUID	= 1L;

	//On Form Open Method.
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.txtSearch().setFocus();
		form.lblWarn().setTextColor(Color.Red);
		form.getContextMenus().getGenericGridRemoveItem().setText("Clear from global cache.");
		setFormMode(FormMode.VIEW);
		showHibernateStatistics();
	}

	private void showHibernateStatistics()
	{
		HibernateCacheStatisticsVo vo = domain.getHibernateCacheStatistics();
		form.hits().setValue(vo.getSecondLevelCacheHitCount());
		form.misses().setValue(vo.getSecondLevelCacheMissCount());
		form.puts().setValue(vo.getSecondLevelCachePutCount());
		
	}

	protected void onBtnApplyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		HashMap rootClasses = engine.getClassConfig().getMappedRootClasses();
		rootClasses = filterClasses(rootClasses, form.txtSearch().getValue());
		populateGrid(rootClasses, domain.getCachedClasses());
		form.txtSearch().setFocus();
		setFormMode(FormMode.VIEW);
	}

	private HashMap filterClasses(HashMap rootClasses, String value)
	{
		if (value == null)
			value = "";

		if (value.equals(""))
			return rootClasses;

		String lv = value.toLowerCase();

		HashMap ret = new HashMap();

		Iterator iter = rootClasses.keySet().iterator();
		while (iter.hasNext())
		{
			String fullName = (String)iter.next();
			String[] collFields = (String[])rootClasses.get(fullName);
			
			String shortName = fullName.substring(fullName.lastIndexOf('.') + 1);
			if (shortName.toLowerCase().indexOf(lv) != -1)
			{
				ret.put(fullName, collFields);
			}
		}
		return ret;
	}

	private void populateGrid(HashMap rootClasses, CachedClassVoCollection cachedClasses)
	{
		form.grdObjectList().getRows().clear();
		grdObjectListRow row;
		grdObjectListRow childRow;

		Set keysSet = rootClasses.keySet();		
		String[] keys = new String[keysSet.size()];
		keysSet.toArray(keys);
		//Arrays.sort(keys);

		int totalCount = 0;
		for (int i = 0; i < keys.length; i++)
		{
			totalCount++;

			String fullName = keys[i];			
			String shortName = fullName.substring(fullName.lastIndexOf('.') + 1);
			String[] collFields = (String[])rootClasses.get(fullName);
			
			row = form.grdObjectList().getRows().newRow();
			row.setClassName(shortName);
			row.setValue(fullName);
			row.setTooltip(fullName);
			row.setSelectable(true);
			
			CachedClassVo vo = getCachedClassVo(fullName, cachedClasses);
			if (vo != null)
			{
				row.setCacheUsage(vo.getCacheUsage());
				if (row.getCacheUsage().equals(CacheUsage.READ_ONLY))
					row.setBackColor(Color.Beige);
				else if (row.getCacheUsage().equals(CacheUsage.READ_WRITE))
					row.setBackColor(Color.BlanchedAlmond);
				else if (row.getCacheUsage().equals(CacheUsage.NONSTRICT_READ_WRITE))
					row.setBackColor(Color.Bisque);
				else if (row.getCacheUsage().equals(CacheUsage.TRANSACTIONAL))
					row.setBackColor(Color.Azure);
			}
			
			for (int j = 0; j < collFields.length; j++)
			{
				totalCount++;

				String field =  collFields[j];
				String role = fullName + "." + field;
				
				childRow = row.getRows().newRow();
				childRow.setClassName(field);
				childRow.setValue(role);
				childRow.setTooltip(role);			
				childRow.setSelectable(false);
				
				CachedClassVo cachedCollField = getCachedClassVo(role, cachedClasses);
				if (cachedCollField != null)
				{
					childRow.setCacheUsage(cachedCollField.getCacheUsage());
					if (childRow.getCacheUsage().equals(CacheUsage.READ_ONLY))
						childRow.setBackColor(Color.Beige);
					else if (childRow.getCacheUsage().equals(CacheUsage.READ_WRITE))
						childRow.setBackColor(Color.BlanchedAlmond);
					else if (childRow.getCacheUsage().equals(CacheUsage.NONSTRICT_READ_WRITE))
						childRow.setBackColor(Color.Bisque);
					else if (childRow.getCacheUsage().equals(CacheUsage.TRANSACTIONAL))
						childRow.setBackColor(Color.Azure);
				}
			}
		}
		form.lblTotal().setValue("Total : " + totalCount);
		form.grdObjectList().expandAll();
	}

	private CachedClassVo getCachedClassVo(String fullName, CachedClassVoCollection cachedClasses)
	{
		if (fullName == null)
			return null;

		for (int i = 0; i < cachedClasses.size(); i++)
		{
			if (cachedClasses.get(i).getClassName().equals(fullName))
				return cachedClasses.get(i);
		}
		return null;
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setFormMode(FormMode.VIEW);		
	}

	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setFormMode(FormMode.EDIT);		
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		CachedClassVoCollection cachedClasses = new CachedClassVoCollection();
		int size = form.grdObjectList().getRows().size();
		for (int i = 0; i < size; i++)
		{
			String className = form.grdObjectList().getRows().get(i).getValue();
			CacheUsage usage = form.grdObjectList().getRows().get(i).getCacheUsage();
			CachedClassVo vo = new CachedClassVo();
			vo.setClassName(className);
			vo.setCacheUsage(usage);
			vo.setIsCollection(Boolean.FALSE);
			cachedClasses.add(vo);
			
			addChildRowInstances(form.grdObjectList().getRows().get(i), cachedClasses);
		}
		try
		{
			domain.saveCacheConfig(cachedClasses);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		onBtnApplyClick();
		setFormMode(FormMode.VIEW);		
	}

	private void setFormMode(FormMode mode)
	{
		form.setMode(mode);
		setContextMenuItems();		
	}

	private void addChildRowInstances(grdObjectListRow row, CachedClassVoCollection cachedClasses)
	{		
		int size = row.getRows().size();
		for (int i = 0; i < size; i++)
		{
			String className = row.getRows().get(i).getValue();
			CacheUsage usage = row.getRows().get(i).getCacheUsage();
			CachedClassVo vo = new CachedClassVo();
			vo.setClassName(className);
			vo.setCacheUsage(usage);
			vo.setIsCollection(Boolean.TRUE);
			cachedClasses.add(vo);
		}
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Remove :
				clearClassFromCache();
			break;
			default :
				break;
		}
	}

	private void clearClassFromCache()
	{
		if (form.grdObjectList().getValue() == null)
			return;
		
		String className = form.grdObjectList().getValue();
		domain.clearCache(className);				
	}

	protected void onGrdObjectListSelectionChanged() throws PresentationLogicException
	{
		setContextMenuItems();
	}
	
	private void setContextMenuItems()
	{
		if (form.getMode().equals(FormMode.VIEW) && form.grdObjectList().getValue() != null)
			form.getContextMenus().getGenericGridRemoveItem().setVisible(true);
		else
			form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
	}

	@Override
	protected void onClearCacheClick() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		domain.clearCache();
		showHibernateStatistics();
		
	}

	@Override
	protected void onBtnRefreshClick() throws PresentationLogicException 
	{
		showHibernateStatistics();
	}
}
