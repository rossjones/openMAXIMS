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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.41 build 2196.21388)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.thermal;

import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.lookups.ThermalType;
import ims.therapies.forms.thermal.GenForm.grdThermalRow;
import ims.therapies.vo.ThermalActivityVo;
import ims.therapies.vo.ThermalActivityVoCollection;
import ims.therapies.vo.ThermalShortVo;
import ims.therapies.vo.ThermalShortVoCollection;
import ims.therapies.vo.ThermalVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}
	private void initialize()
	{
		form.ctnTherapy().setCollapsed(true);
		form.ctnTherapy().lyrThermal().tabEmpty().setHeaderVisible(false);
		loadThermalType();
	}
	private void open() 
	{
		clear();
		resetContextVariables();
		
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			populateParentNodes(domain.listThermalDetailsByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));			
		}
									
		form.setMode(FormMode.VIEW);
		reselectUpdatedNode();
	}
	private void reselectUpdatedNode()
	{
		//Pattern demands that the last updated node is displayed
		if (form.getLocalContext().getUpdatedChildIsNotNull())
		{
			form.grdThermal().setValue(form.getLocalContext().getUpdatedChild());
			getSelectedInstance();
			form.getLocalContext().setUpdatedChild(null);
		}
	}
	private void getSelectedInstance()
	{
		// In update mode we can select nodes without displaying anything but the context
		// menus can change based on what's selected so we need to update them
		if (form.getMode().equals(FormMode.EDIT)) 
		{
			updateContextMenusState();
			return;
		}		
		
		if(form.grdThermal().getValue() instanceof ThermalVo)
		{	
			populateParentInstanceControls((ThermalVo) form.grdThermal().getValue());
		}
		if(form.grdThermal().getValue() instanceof ThermalShortVo)
		{									 
			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ThermalShortVo) form.grdThermal().getValue()));
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());
			populateChildNodes(form.grdThermal().getSelectedRow(),form.getLocalContext().getSelectedParentInstance().getThermalActivity());
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}		
		else if(form.grdThermal().getValue() instanceof ThermalActivityVo)
		{
			GenForm.grdThermalRow parentRow = form.grdThermal().getSelectedRow().getParentRow();
			populateParentInstanceControls((ThermalVo) parentRow.getValue());
			form.getLocalContext().setSelectedParentInstance((ThermalVo) parentRow.getValue());
			
			form.getLocalContext().setSelectedChildInstance((ThermalActivityVo) form.grdThermal().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());			
		}
 
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(form.getLocalContext().getSelectedParentInstance().getClinicalContact().getID_ClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact())));
		
		updateControlsState();
	}

	private void updateControlsState()
	{
		// The new button
		form.btnNew().setVisible(form.getMode().equals(FormMode.VIEW) 
				&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
				&& form.getLocalContext().getGoldenInstanceFound().booleanValue() == false);

		// The collapsible container
		form.ctnTherapy().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		// The empty tab
		if (form.grdThermal().getValue() == null)
			form.ctnTherapy().lyrThermal().showtabEmpty();

		// The Parent tab
		setParentTabVisability();						

		// The details tab
		setDetailsTabVisibility();		

		// Pick a tab to show
		showHeaderOrDetailsTab();																				

		// The context menus
		updateContextMenusState();
	}
	private void showHeaderOrDetailsTab()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			// In view mode just show the selected node 
			if (form.grdThermal().getValue() instanceof ThermalShortVo)		
				form.ctnTherapy().lyrThermal().showtabHeader();
			else if(form.grdThermal().getValue() instanceof ThermalVo)
				form.ctnTherapy().lyrThermal().showtabHeader();
			else if (form.grdThermal().getValue() instanceof ThermalActivityVo)
				form.ctnTherapy().lyrThermal().showtabDetails();
			
			//enableParentControls(false);
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnTherapy().lyrThermal().showtabHeader();
			else
				form.ctnTherapy().lyrThermal().showtabDetails();
			
			if (form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					(form.getLocalContext().getSelectedParentInstance().getID_ThermalIsNotNull()))
				enableParentControls(false);		//on update
			else
				enableParentControls(true);			//new record
		}
	}
	private void enableParentControls(boolean enable)
	{
		form.ctnTherapy().lyrThermal().tabHeader().dtimAuthoring().setEnabled(enable);
		form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().setEnabled(enable);
	}
	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{	
			// In view mode, make the details tab visible if a detail instance is selected in the hierarchy grid.  
			form.ctnTherapy().lyrThermal().tabDetails().setHeaderVisible(form.grdThermal().getValue() instanceof ThermalActivityVo);									
		}
		else
		{			
			// In edit mode, make the details tab visible if a hierarchy item has been selected and we're not
			// editing a parent.
			form.ctnTherapy().lyrThermal().tabDetails().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE));
			
			setAddApplyCaption();			
		}			

		enableDetailsButtons();	
	}
	private void enableDetailsButtons()
	{
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) &&
				  form.ctnTherapy().lyrThermal().tabDetails().isHeaderVisible() &&
				  form.getLocalContext().getSelectedChildInstance() == null);

		form.ctnTherapy().lyrThermal().tabDetails().btnOk().setVisible(boolVisible);
		form.ctnTherapy().lyrThermal().tabDetails().btnClearDetails().setVisible(boolVisible);
	}
	private void setAddApplyCaption()
	{
		form.ctnTherapy().lyrThermal().tabDetails().btnOk().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdThermal().getValue() instanceof ThermalActivityVo))
				form.ctnTherapy().lyrThermal().tabDetails().btnOk().setText("Apply");
	}
	private void setParentTabVisability()
	{
		form.ctnTherapy().lyrThermal().tabHeader().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());
	}
	private void populateChildInstanceControls(ThermalActivityVo voThermalActivity)
	{
		if (voThermalActivity == null ) return;
		
		form.ctnTherapy().lyrThermal().tabDetails().cmbThermal().setValue(voThermalActivity.getThermal());
		if(voThermalActivity.getThermalTypeIsNotNull())
			form.ctnTherapy().lyrThermal().tabDetails().cmbType().newRow(voThermalActivity.getThermalType(), voThermalActivity.getThermalType().toString());
		form.ctnTherapy().lyrThermal().tabDetails().cmbType().setValue(voThermalActivity.getThermalType());
		form.ctnTherapy().lyrThermal().tabDetails().cmbArea().setValue(voThermalActivity.getArea());
		form.ctnTherapy().lyrThermal().tabDetails().cmbLaterality().setValue(voThermalActivity.getLaterality());
		form.ctnTherapy().lyrThermal().tabDetails().intDuration().setValue(voThermalActivity.getDuration());
		form.ctnTherapy().lyrThermal().tabDetails().txtDetails().setValue(voThermalActivity.getDetails());
		form.getLocalContext().setSelectedChildInstance(voThermalActivity);
	}
	private void populateParentInstanceControls(ThermalVo voThermalParent)
	{
		if(voThermalParent != null)
		{
			form.ctnTherapy().lyrThermal().tabHeader().dtimAuthoring().setValue(voThermalParent.getAuthoringDateTime());
			if(voThermalParent.getAuthoringCPIsNotNull())
				form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().newRow(voThermalParent.getAuthoringCP(), voThermalParent.getAuthoringCP().toString());
			form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().setValue(voThermalParent.getAuthoringCP());
		}
	}
	private void updateContextMenusState()
	{
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			if(form.getLocalContext().getGoldenInstanceSelected().booleanValue())
			{
				// If the golden instance is currently selected we change the text of the update context menu
				// based on whether a parent or child node is selected in the grid.
				if (form.grdThermal().getValue() instanceof ThermalShortVo)
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);						
				else if (form.grdThermal().getValue() instanceof ThermalActivityVo)
					form.getContextMenus().getGenericGridUpdateItem().setText("Edit Thermal Detail");
				
				// If the golden node is selected we can now only add child nodes so set the menu text accordingly.
				form.getContextMenus().getGenericGridAddItem().setText("Add Thermal Detail");			
	
				// Only show the update menu if the user has selected an item to update.
				form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW)&& 
																			 form.grdThermal().getSelectedRowIndex()>=0 && 
																			 form.grdThermal().getValue() instanceof ThermalActivityVo) ||
																			 (form.getMode().equals(FormMode.EDIT) &&
																			 form.grdThermal().getValue() instanceof ThermalActivityVo &&
																			 ((ThermalActivityVo)form.grdThermal().getValue()).getID_ThermalActivity() == null));																								
			}
			else
			{
				// If the golden instance has been found but NOT selected hide the context menu's 
				if (form.getLocalContext().getGoldenInstanceFound().booleanValue() == true)
				{
					form.getContextMenus().hideAllGenericGridMenuItems();
					return;
				}
				else
				{
					form.getContextMenus().getGenericGridAddItem().setText("New Thermal Therapy");
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);				
				}
			}
			
			form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW));
			form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) &&
					 form.grdThermal().getValue() instanceof ThermalActivityVo &&
					 ((ThermalActivityVo)form.grdThermal().getValue()).getID_ThermalActivity() == null);
		}
		else
		{
			form.getContextMenus().hideAllGenericGridMenuItems();
		}
	}
	private void populateParentNodes(ThermalShortVoCollection voThermalShortColl)
	{
		if (voThermalShortColl == null || voThermalShortColl.size() <= 0 ) return;
		
		for(int i=0; i<voThermalShortColl.size(); i++)
		{
			populateParentNode(voThermalShortColl.get(i));			
		}	
	}
	private void populateParentNode(ThermalShortVo voThermalShort)
	{
		GenForm.grdThermalRow parRow = form.grdThermal().getRows().newRow();
		parRow.setcolThermalTypeParent(voThermalShort.getAuthoringDateTime().toString()+ " - " + 
				voThermalShort.getAuthoringCP().toString());
		parRow.setValue(voThermalShort);	
		
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && voThermalShort.getClinicalContact().getID_ClinicalContact().equals
				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			form.grdThermal().setValue(voThermalShort);			
			expandParentNode(parRow);
		}		
	}
	private void expandParentNode(grdThermalRow selectedRow)
	{
		if (selectedRow.getValue() instanceof ThermalShortVo == false ) return;
		
		form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ThermalShortVo)selectedRow.getValue()));		
		if (form.getLocalContext().getSelectedParentInstance() == null ) return; 				

		ThermalVo voParentInstance = form.getLocalContext().getSelectedParentInstance();				
		if(voParentInstance.getClinicalContact().getID_ClinicalContact().equals
									(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			// If this is the Golden Node then we'll colour it golden (ok then beige).
			form.getLocalContext().setGoldenInstanceFound(new Boolean(true));
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
			selectedRow.setBackColor(Color.Beige);			
		}
		
		if (voParentInstance.getThermalActivity() != null)  
		{
			selectedRow.setValue(voParentInstance);
			selectedRow.setExpanded(true);
			populateChildNodes(selectedRow, voParentInstance.getThermalActivity());
		}
		
		populateParentInstanceControls(voParentInstance);	
	}
	
	private void populateChildNodes(grdThermalRow parRow, ThermalActivityVoCollection voThermalActivityColl)
	{
		parRow.getRows().clear();
		//	reselect parent
		parRow.setValue(form.getLocalContext().getSelectedParentInstance());
		form.grdThermal().setValue(parRow.getValue());
		if (voThermalActivityColl == null || voThermalActivityColl.size()<=0) return;		
		
		voThermalActivityColl.sort();
		for(int i=0; i<voThermalActivityColl.size(); i++)
		{
			if (parRow != null)
			{
				GenForm.grdThermalRow childRow = parRow.getRows().newRow();
				populateChildNode(childRow, voThermalActivityColl.get(i));				
			}
		}
		
		parRow.setExpanded(true);
	}
	private void populateChildNode(grdThermalRow childRow, ThermalActivityVo voThermalActivity)
	{
		if (voThermalActivity == null) return;		
		
		if(voThermalActivity.getThermal() != null)
			childRow.setcolThermalTypeParent(voThermalActivity.getThermal().toString());
		else
			childRow.setcolThermalTypeParent(null);
		if(voThermalActivity.getThermalType() != null)
			childRow.setcolThermalTypeChild(voThermalActivity.getThermalType().toString());
		else
			childRow.setcolThermalTypeChild(null);
		if(voThermalActivity.getArea() != null)
			childRow.setcolArea(voThermalActivity.getArea().toString());
		else
			childRow.setcolArea(null);
		if(voThermalActivity.getLaterality() != null)
			childRow.setcolLaterality(voThermalActivity.getLaterality().toString());
		else
			childRow.setcolLaterality(null);
		if(voThermalActivity.getDuration() != null)
			childRow.setcolDuration(voThermalActivity.getDuration().toString());
		else
			childRow.setcolDuration(null);
		childRow.setcolDetails(voThermalActivity.getDetails());
		childRow.setValue(voThermalActivity);
	
		//if not saved then set the colour
		if(voThermalActivity.getID_ThermalActivity() == null)
			childRow.setTextColor(Color.Red);
	}
	private ThermalVo getParentFromDomain(ThermalShortVo voThermalShort)
	{
		//return domain.getThermalDetailsByClinicalContact(voThermalShort.getClinicalContact());
		return domain.getThermal(voThermalShort);//	WDEV-13649
	}
	private void resetContextVariables()
	{
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		form.getLocalContext().setGoldenInstanceFound(new Boolean(false));
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);	
	}
	private void loadThermalType() 
	{
		TreeNode[] coll = LookupHelper.getThermalType(domain.getLookupService()).getRootNodes();
		if(coll != null)
		{
			for(int i=0;i<coll.length;i++)
			{
				ThermalType item = (ThermalType)coll[i];
				if(item.isActive())
					form.ctnTherapy().lyrThermal().tabDetails().cmbThermal().newRow(item, item.getText());
			}
		}
	}
	private void clear() 
	{
		form.grdThermal().getRows().clear();
		clearChildInstanceControls();
	}
	private void clearChildInstanceControls()
	{
		form.ctnTherapy().lyrThermal().tabDetails().cmbThermal().setValue(null);
		form.ctnTherapy().lyrThermal().tabDetails().cmbType().setValue(null);
		form.ctnTherapy().lyrThermal().tabDetails().cmbArea().setValue(null);
		form.ctnTherapy().lyrThermal().tabDetails().cmbLaterality().setValue(null);
		form.ctnTherapy().lyrThermal().tabDetails().intDuration().setValue(null);
		form.ctnTherapy().lyrThermal().tabDetails().txtDetails().setValue(null);
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	private boolean save()
	{
		if(checkForUnsavedChild())
			return false;	
		
		ThermalVo voThermal = populateInstanceData(form.getLocalContext().getSelectedParentInstance());
		
		if (voThermal.getClinicalContact() == null)
			voThermal.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
		String[] arrErrors =  voThermal.validate();	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.saveThermalDetails(voThermal));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Complementary Therapy record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		
		setUpdatedChild();
		return true;	
	}
	private void setUpdatedChild()
	{
		// Straight child update - Select the currently being updated child as the one so show - post save
		if (form.grdThermal().getValue() instanceof ThermalActivityVo)		
		{
			form.getLocalContext().setUpdatedChild((ThermalActivityVo) form.grdThermal().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				form.getLocalContext().getSelectedParentInstance().getThermalActivity().sort();
				if(form.getLocalContext().getSelectedParentInstance().getThermalActivity().size() >0)
					form.getLocalContext().setUpdatedChild(
							form.getLocalContext().getSelectedParentInstance().getThermalActivity().get(
									form.getLocalContext().getSelectedParentInstance().getThermalActivity().size() - 1));
			}
			
		}
	}
	private ThermalVo populateInstanceData(ThermalVo voThermal)
	{
		if (voThermal == null)
			voThermal = new ThermalVo();
				
		populateParentInstanceData(voThermal);						

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voThermal);			
		}
		else 		// Update child instance.
		{
			//ThermalActivityVo voThermalActivity = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(form.getLocalContext().getSelectedChildInstance());
			//form.getLocalContext().setSelectedChildInstance(voThermalActivity);
			
			for (int i=0; i < voThermal.getThermalActivity().size(); i++)
			{
				if (voThermal.getThermalActivity().get(i).getID_ThermalActivity() == 
					form.getLocalContext().getSelectedChildInstance().getID_ThermalActivity())
				{						
					voThermal.getThermalActivity().set(i, form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		return voThermal;
	}
	private void populateChildInstanceData(ThermalActivityVo voThermalActivity)
	{
		voThermalActivity.setThermal(form.ctnTherapy().lyrThermal().tabDetails().cmbThermal().getValue());
		voThermalActivity.setThermalType(form.ctnTherapy().lyrThermal().tabDetails().cmbType().getValue());
		voThermalActivity.setArea(form.ctnTherapy().lyrThermal().tabDetails().cmbArea().getValue());
		voThermalActivity.setLaterality(form.ctnTherapy().lyrThermal().tabDetails().cmbLaterality().getValue());
		voThermalActivity.setDuration(form.ctnTherapy().lyrThermal().tabDetails().intDuration().getValue());
		voThermalActivity.setDetails(form.ctnTherapy().lyrThermal().tabDetails().txtDetails().getValue());
	}
	private void populateChildCollectionFromGrid(ThermalVo voThermal)
	{
		if (form.grdThermal().getValue() == null) return;

		if (voThermal.getThermalActivity() == null)
			voThermal.setThermalActivity(new ThermalActivityVoCollection());
		
		GenForm.grdThermalRow parentRow = form.grdThermal().getValue() instanceof ThermalShortVo || form.grdThermal().getValue() instanceof ThermalVo ? 
										    form.grdThermal().getSelectedRow() : form.grdThermal().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() > 0 )
        	voThermal.getThermalActivity().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        {
			voThermal.getThermalActivity().add((ThermalActivityVo) parentRow.getRows().get(i).getValue());
        }
	}
	private void populateParentInstanceData(ThermalVo voThermal)
	{
		voThermal.setAuthoringCP(form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().getValue());
		voThermal.setAuthoringDateTime(form.ctnTherapy().lyrThermal().tabHeader().dtimAuthoring().getValue());		
	}
	private boolean checkForUnsavedChild()
	{
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{				
			if(addOrUpdateChild())
				return true;
		}
		return false;
	}

	private boolean addOrUpdateChild()
	{
		if (form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))			
			if(!newParentNode(form.getLocalContext().getSelectedParentInstance()))
				return false;				
				
		ThermalActivityVo voThermalActivity = form.getLocalContext().getSelectedChildInstance();
		
		if (voThermalActivity == null)
			voThermalActivity = new ThermalActivityVo(); 

		populateChildInstanceData(voThermalActivity);

		if (form.grdThermal().getValue() instanceof ThermalActivityVo && form.getLocalContext().getSelectedChildInstanceIsNotNull())
		{
			promoteUpdatedChild(voThermalActivity);
			newChildInstance();
			updateControlsState();
		}
		else
		{
			if(newChildNode(voThermalActivity))
				return true;
		}
		return false;
	}
	private boolean newChildNode(ThermalActivityVo voThermalActivity)
	{
		if (form.getLocalContext().getSelectedChildInstance() != null) return false;
		
		if (voThermalActivity.countFieldsWithValue() > 0)
		{
			String strErrors[] = voThermalActivity.validate();
		
			if(strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return true;
			}
	 				
			promoteChild(voThermalActivity);			
			clearChildInstanceControls();
		}
		return false;
	}
	private void promoteChild(ThermalActivityVo voThermalActivity)
	{
		if(voThermalActivity == null) return;
		GenForm.grdThermalRow childRow = null;
		form.grdThermal().setValue(form.getLocalContext().getSelectedParentInstance());//maybe need new localcontext
		if(form.grdThermal().getValue() != null)
		{
			if(form.grdThermal().getSelectedRow().getValue() instanceof ThermalActivityVo)
				childRow = form.grdThermal().getSelectedRow().getParentRow().getRows().newRow();
			else
				childRow = form.grdThermal().getSelectedRow().getRows().newRow();
		}
		populateChildNode(childRow, voThermalActivity);	
		
	}
	private void newChildInstance()
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
		form.grdThermal().setValue(form.grdThermal().getSelectedRow().getParentRow().getValue());
	}
	private void promoteUpdatedChild(ThermalActivityVo voThermalActivity)
	{
		if (voThermalActivity == null) return;
		form.grdThermal().setValue(form.getLocalContext().getSelectedChildInstance());
		populateChildNode(form.grdThermal().getSelectedRow(),voThermalActivity);
	}
	
	private boolean newParentNode(ThermalVo voNewParent)
	{
		if (voNewParent == null) return true;
		
		ThermalShortVo voParentShort = new ThermalShortVo();
		voParentShort.setAuthoringCP(form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().getValue());
		voParentShort.setAuthoringDateTime(form.ctnTherapy().lyrThermal().tabHeader().dtimAuthoring().getValue());
		voParentShort.setClinicalContact(voNewParent.getClinicalContact());
		
		String[] errors = voParentShort.validate();
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		GenForm.grdThermalRow parentRow = form.grdThermal().getRows().newRow();			
		parentRow.setcolThermalTypeParent(voParentShort.getAuthoringDateTime().toString()+ " - " + 
				   voParentShort.getAuthoringCP().toString());			
		parentRow.setValue(voParentShort);
		parentRow.setBackColor(Color.Beige);
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
		parentRow.setExpanded(true);
		form.grdThermal().setValue(voParentShort);	
		return true;
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		addOrUpdateChild();
	}
	
	protected void onGrdThermalSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		getSelectedInstance();
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeChild();
				break;
		}
	}
	
	private void removeChild()
	{
		ThermalShortVo voParentShort = null;
		ThermalVo voParent = null;
		
		if(form.grdThermal().getSelectedRow().getParentRow().getValue() instanceof ThermalShortVo)
		{
			voParentShort = (ThermalShortVo) form.grdThermal().getSelectedRow().getParentRow().getValue();
			form.grdThermal().removeSelectedRow();
			form.grdThermal().setValue(voParentShort);
		}
		else
		{
			voParent = (ThermalVo) form.grdThermal().getSelectedRow().getParentRow().getValue();
			form.grdThermal().removeSelectedRow();
			form.grdThermal().setValue(voParent);
		}
		
		updateContextMenusState();
	}
	private void updateInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(form.grdThermal().getValue() instanceof ThermalShortVo));
		form.setMode(FormMode.EDIT);
		if (form.grdThermal().getValue() instanceof ThermalActivityVo)			
		{
			ThermalActivityVo voCachedChild =  (ThermalActivityVo) form.grdThermal().getValue(); 
			if ( voCachedChild.getID_ThermalActivity() == null)
			{
				populateChildInstanceControls(voCachedChild);
			}			
		}
	}
	private void newInstance()
	{
		//clearChildInstanceControls();
		// New instance has been invoked for a parent instance with no current selection made OR
		// with a parent that is not the Golden node..
		if (form.grdThermal().getValue() == null || ((form.getLocalContext().getSelectedParentInstanceIsNotNull() 
				&& form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))))
		{
			newParentInstance();			
		}

		if (form.grdThermal().getValue() instanceof ThermalActivityVo)
		{
			newChildInstance();
		}
		
		form.setMode(FormMode.EDIT);
	}
	private void newParentInstance()
	{
		ThermalVo voNewParent = new ThermalVo(); 
		Hcp voHcp = (Hcp) domain.getHcpUser();
		if(voHcp != null)
			voNewParent.setAuthoringCP(voHcp);

		voNewParent.setAuthoringDateTime(new DateTime());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setThermalActivity(new ThermalActivityVoCollection());
		populateParentInstanceControls(voNewParent);		
		form.getLocalContext().setSelectedParentInstance(voNewParent);
	}
	
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException 
	{
		form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHcps(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.ctnTherapy().lyrThermal().tabHeader().qmbAuthoringCP().showOpened();		
		}		
	}	
	protected void onCmbThermalValueChanged() throws PresentationLogicException 
	{
		form.ctnTherapy().lyrThermal().tabDetails().cmbType().clear();
		if(form.ctnTherapy().lyrThermal().tabDetails().cmbThermal().getValue() == null) //for blank selection
			return;

		ArrayList coll = form.ctnTherapy().lyrThermal().tabDetails().cmbThermal().getValue().getChildInstances();
		ThermalType type = null;
		for(int i=0;i<coll.size();i++)
		{
			type = (ThermalType)coll.get(i);
			if(type.isActive())
				form.ctnTherapy().lyrThermal().tabDetails().cmbType().newRow((ThermalType)coll.get(i), coll.get(i).toString());
		}
	}
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		newInstance();
	}
	protected void onFormModeChanged()
	{
		updateControlsState();	
	}
	protected void onBtnCancelDetailsClick() throws PresentationLogicException
	{
		clearChildInstanceControls();
	}
}
