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
// This code was generated by John MacEnri using IMS Development Environment (version 1.45 build 2370.25160)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.auditconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ims.admin.forms.auditconfig.GenForm.grdObjectListRow;
import ims.admin.vo.AuditedClassVo;
import ims.admin.vo.AuditedClassVoCollection;
import ims.configuration.ClassConfig;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() 
	{
		form.txtSearch().setFocus();
		form.btnEdit().setEnabled(false);
	}
		
	protected void onBtnApplyClick() throws PresentationLogicException
	{
		ClassConfig cfg = engine.getClassConfig();
		String [] classes = cfg.getAuditableClasses();
		classes = filterClasses(classes, form.txtSearch().getValue());
		Map m = shortenAndSort(classes);		
		populateGrid(m, cfg);		
		
		form.txtSearch().setFocus();
		
		if(form.grdObjectList().getRows().size() >0)
		{
			form.btnEdit().setEnabled(true);
		}
		else
		{
			form.btnEdit().setEnabled(false);
		}
	}
	
	private void populateGrid(Map map, ClassConfig cfg)
	{
		form.grdObjectList().getRows().clear();		
		grdObjectListRow row;
		
		Set keysSet = map.keySet();		
		String[] keys = new String[keysSet.size()];
		keysSet.toArray(keys);
		Arrays.sort(keys);

		for (int i = 0; i < keys.length; i++)
		{
			String shortName = keys[i];
			String fullName = (String)map.get(shortName);
			row = form.grdObjectList().getRows().newRow();
			row.setClassName(shortName);
			row.setIsAudited(cfg.isBoAudited(fullName));
			row.setValue(fullName);			
			row.setTooltip(fullName);
			if (!row.getIsAudited())
				row.setBackColor(Color.Bisque);
		}
		
		form.lblTotal().setValue("Total:" + form.grdObjectList().getRows().size());
		
	}
	
	private Map shortenAndSort(String[] classes)
	{
		Map ret = new HashMap();
		for (int i = 0; i < classes.length; i++)
		{
			ret.put(classes[i].substring(classes[i].lastIndexOf('.') + 1), classes[i]);
		}
		return ret;
	}
	
	private String[] filterClasses(String[] classes, String value)
	{
		if (value == null || value.equals(""))
				return classes;
		
		String lv = value.toLowerCase();
		
		ArrayList l = new ArrayList();
		
		for (int i = 0; i < classes.length; i++)
		{
			String shortName = classes[i].substring(classes[i].lastIndexOf('.') + 1);
			if (shortName.toLowerCase().indexOf(lv) != -1)
			{
				l.add(classes[i]);
			}
		}		
		String[] ret = new String[l.size()];
		l.toArray(ret);
		return ret;
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		onBtnApplyClick();//WDEV-13873
		
		form.setMode(FormMode.VIEW);
		form.btnEdit().setVisible(true);
	}

	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnEdit().setVisible(false);
		
	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{
		
		form.btnEdit().setVisible(true);
		AuditedClassVoCollection auditedClasses = new AuditedClassVoCollection();
		int size = form.grdObjectList().getRows().size();
		for (int i = 0; i < size; i++)
		{
			String className = form.grdObjectList().getRows().get(i).getValue();
			boolean isAudited = form.grdObjectList().getRows().get(i).getIsAudited();
			AuditedClassVo vo = new AuditedClassVo();
			vo.setClassName(className);
			vo.setIsAudited(new Boolean(isAudited));
			auditedClasses.add(vo);				
		}
		try
		{
			domain.saveAuditConfig(auditedClasses);
			domain.activateAuditConfig();
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		onBtnApplyClick();
		form.setMode(FormMode.VIEW);		
	}
}
