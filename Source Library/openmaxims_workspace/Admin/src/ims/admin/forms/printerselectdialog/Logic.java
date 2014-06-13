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
// This code was generated by John MacEnri using IMS Development Environment (version 1.45 build 2327.20708)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.printerselectdialog;

import java.util.ArrayList;

import ims.admin.forms.printerselectdialog.GenForm.grdListRow;
import ims.admin.forms.printerselectdialog.GenForm.grdSearchRow;
import ims.admin.vo.PrinterVo;
import ims.admin.vo.PrinterVoCollection;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.PrinterScope;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IPrinter;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();		
	}
	
	private void initialize()
	{				
		form.getContextMenus().getDPPSelectedListREMOVEALLItem().setVisible(true);
		form.btnAdd().setEnabled(false);
		setLocalContexts();
	}
	
	private void setLocalContexts()
	{
		form.getLocalContext().setDefaultPrinter(form.getGlobalContext().getDefaultPrinter());
		form.getLocalContext().setDesignatedPrinterForNewResults(form.getGlobalContext().getDesignatedPrinterForNewResults());
		form.getLocalContext().setDesignatedPrinterForOCSOrder(form.getGlobalContext().getDesignatedPrinterForOCSOrder());
	}
	
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PrinterVoCollection printers = new PrinterVoCollection();
		
		for (int i = 0; i < form.grdList().getRows().size(); i++)
		{
			printers.add(form.grdList().getRows().get(i).getValue());			
		}		
		
		form.getGlobalContext().setDefaultPrinter(form.getLocalContext().getDefaultPrinter());
		form.getGlobalContext().setDesignatedPrinterForNewResults(form.getLocalContext().getDesignatedPrinterForNewResults());
		form.getGlobalContext().setDesignatedPrinterForOCSOrder(form.getLocalContext().getDesignatedPrinterForOCSOrder());
		form.getGlobalContext().setPrintersSelected(printers);		
		engine.close(DialogResult.OK);
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setDefaultPrinter(null);
		form.getLocalContext().setDesignatedPrinterForNewResults(null);
		form.getLocalContext().setDesignatedPrinterForOCSOrder(null);
		form.getLocalContext().setPrintersList(null);
		
		engine.close(DialogResult.CANCEL);
	}

	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		grdSearchRow row1;
		for (int i = 0; i < form.grdSearch().getRows().size(); i++)
		{
			row1 = form.grdSearch().getRows().get(i);
			if (row1.getColumnSelect())
			{
				grdListRow row2 = form.grdList().getRows().newRow();
				row2.setcolItems(row1.getcolItems());
				row2.setValue(row1.getValue());					
			}			
		}
		
		form.ccPrinters().initialize(null, PrinterScope.DEFAULT, false);		
		
		form.btnAdd().setEnabled(false);
		updateControlsState();
	}
	
	protected void onGrdListSelectionChanged() throws PresentationLogicException
	{
		updateControlsState();	
	}
	
	private void clearLocalContext()
	{
		form.getLocalContext().setDefaultPrinter(null);
		form.getLocalContext().setDesignatedPrinterForNewResults(null);
		form.getLocalContext().setDesignatedPrinterForOCSOrder(null);
	}
	
	private void removeSelectedRow()
	{
		form.grdList().removeSelectedRow();
	}
	
	private void removeRecord()
	{						
		unsetLocalContext();
		removeSelectedRow();		
		form.ccPrinters().initialize(null, PrinterScope.DEFAULT, false);
		updateControlsState();
	}
	
	private void unsetLocalContext()
	{
		if (form.grdList().getSelectedRow() != null && form.grdList().getSelectedRow().getValue() != null && form.grdList().getSelectedRow().getValue() instanceof PrinterVo)
		{
			if (form.grdList().getSelectedRow().getValue().equals(form.getLocalContext().getDefaultPrinter()))
			{
				form.getLocalContext().setDefaultPrinter(null);
			}
			if (form.grdList().getSelectedRow().getValue().equals(form.getLocalContext().getDesignatedPrinterForNewResults()))
			{
				form.getLocalContext().setDesignatedPrinterForNewResults(null);
			}
			if (form.grdList().getSelectedRow().getValue().equals(form.getLocalContext().getDesignatedPrinterForOCSOrder()))
			{
				form.getLocalContext().setDesignatedPrinterForOCSOrder(null);
			}
		}
	}

	private void removeAllRecords()
	{
		form.grdList().getRows().clear();
		clearLocalContext();
		form.ccPrinters().initialize(null, PrinterScope.DEFAULT, false);
		updateControlsState();
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.DPPSelectedList.MOVEDOWN :
				form.grdList().moveDown();
				updateControlsState();
			break;
			case GenForm.ContextMenus.DPPSelectedList.MOVEUP :
				form.grdList().moveUp();
				updateControlsState();
			break;
			case GenForm.ContextMenus.DPPSelectedList.REMOVE :
				removeRecord();
			break;
			case GenForm.ContextMenus.DPPSelectedList.REMOVEALL :
				removeAllRecords();
			break;				
		}		
	}

	private void open()
	{		
		form.grdList().getRows().clear();
		
		PrinterVoCollection printers = form.getGlobalContext().getPrintersSelected();
		if (printers != null)
		{		
			for (int i = 0; i < printers.size(); i++)
			{				
				grdListRow row = form.grdList().getRows().newRow();
				row.setcolItems(printers.get(i).getName());
				row.setValue(printers.get(i));
				
				if (form.getLocalContext().getDefaultPrinterIsNotNull())
				{
					if (printers.get(i).getName().equals(form.getLocalContext().getDefaultPrinter().getIPrinterName()))
					{
						row.setColDefault(true);
					}
				}
				if (form.getLocalContext().getDesignatedPrinterForNewResultsIsNotNull())
				{
					if (printers.get(i).getName().equals(form.getLocalContext().getDesignatedPrinterForNewResults().getIPrinterName()))
					{
						row.setColDesignatedToNewResults(true);
					}
				}
				if (form.getLocalContext().getDesignatedPrinterForOCSOrderIsNotNull())
				{
					if (printers.get(i).getName().equals(form.getLocalContext().getDesignatedPrinterForOCSOrder().getIPrinterName()))
					{
						row.setColDesignatedPrinterForOCSOrder(true);
					}
				}
			}					
		}
				
		form.ccPrinters().initialize(null, PrinterScope.DEFAULT, false);		
	}		
	
	//WDEV-17728
	private void updateControlsState()
	{
		boolean rowSelected = form.grdList().getValue() != null;
		boolean moreThanOneRecord = form.grdList().getRows().size() > 1;
		
		form.getContextMenus().getDPPSelectedListMOVEDOWNItem().setVisible(rowSelected && moreThanOneRecord && form.grdList().canMoveCurrentDown());
		form.getContextMenus().getDPPSelectedListMOVEUPItem().setVisible(rowSelected && moreThanOneRecord && form.grdList().canMoveCurrentUp());
		form.getContextMenus().getDPPSelectedListREMOVEItem().setVisible(rowSelected);
	}

	@Override
	protected void onCcPrintersValueChanged() throws PresentationLogicException
	{		
		IPrinter[] printers = form.ccPrinters().getPrinters();		
		
		if ( printers != null)
		{			
			form.grdSearch().getRows().clear();
			
			ArrayList<IPrinter> configuredPrinters = new ArrayList<IPrinter>();
			for (int i = 0; i <form.grdList().getRows().size(); i++)
			{
				configuredPrinters.add(form.grdList().getRows().get(i).getValue());
			}
			
			
			grdSearchRow row;
			for (int i = 0; i < printers.length; i++)
			{
				boolean alreadyConfigured = false;
				for (int j = 0; j < configuredPrinters.size(); j++)
				{
					if (printers[i].getIPrinterId() == configuredPrinters.get(j).getIPrinterId())
					{
						alreadyConfigured = true;
						break;
					}
				}
				
				if (!alreadyConfigured)
				{
					row = form.grdSearch().getRows().newRow();
					
					PrinterVo value = new PrinterVo(printers[i].getIPrinterId(), printers[i].getIPrinterRecordVersion());
					value.setID_Printer(printers[i].getIPrinterId() != 0 ? printers[i].getIPrinterId() : null);
					value.setName(printers[i].getIPrinterName());
					value.setActive(true);
					
					row.setcolItems(printers[i].getIPrinterName());
					row.setValue(value);
				}
				
			}
			
			form.ccPrinters().clear();
		}		
	}

	@Override
	protected void onGrdSearchGridCheckBoxClicked(int column, grdSearchRow row, boolean isChecked) throws PresentationLogicException
	{		
		form.btnAdd().setEnabled(true);
		
		int found = 0;
		for (int i = 0; i < form.grdSearch().getRows().size(); i++)
		{
			if (form.grdSearch().getRows().get(i).getColumnSelect())
			{
				found ++;
			}
		}
		
		if (found == 0 && !isChecked && (form.grdSearch().getSelectedRow() == null || form.grdSearch().getSelectedRow().getColumnSelect() == false)) //wdev-12389
		{
			form.btnAdd().setEnabled(false);
		}		
		
		if (form.getLocalContext().getDesignatedPrinterForNewResultsIsNotNull())
		{
			IPrinter designatedPrinterForNewResults = form.getLocalContext().getDesignatedPrinterForNewResults();
			if (row.getValue() != null &&
					row.getValue().getNameIsNotNull() && designatedPrinterForNewResults.getIPrinterName() != null &&
						row.getValue().getName().equals(designatedPrinterForNewResults.getIPrinterName()))				
			{
				form.getLocalContext().setDesignatedPrinterForNewResults(null);
			}
		}
		if (form.getLocalContext().getDefaultPrinterIsNotNull())
		{
			IPrinter defaultPrinter = form.getLocalContext().getDefaultPrinter();
			if (row.getValue() != null &&
					row.getValue().getNameIsNotNull() && defaultPrinter.getIPrinterName() != null &&
						row.getValue().getName().equals(defaultPrinter.getIPrinterName()))				
			{
				form.getLocalContext().setDefaultPrinter(null);
			}
		}
		if (form.getLocalContext().getDesignatedPrinterForOCSOrderIsNotNull())
		{
			IPrinter defaultPrinter = form.getLocalContext().getDesignatedPrinterForOCSOrder();
			if (row.getValue() != null &&
					row.getValue().getNameIsNotNull() && defaultPrinter.getIPrinterName() != null &&
						row.getValue().getName().equals(defaultPrinter.getIPrinterName()))				
			{
				form.getLocalContext().setDesignatedPrinterForOCSOrder(null);
			}
		}
	}

	@Override
	protected void onGrdListGridCheckBoxClicked(int column, grdListRow row, boolean isChecked) throws PresentationLogicException
	{
		if (isChecked)
		{				
			for (int i = 0; i < form.grdList().getRows().size(); i++)
			{
				if (!row.getValue().equals(form.grdList().getRows().get(i).getValue()))
				{
					if (form.grdList().getRows().get(i).getColDefault() && column == 1)
					{
						form.grdList().getRows().get(i).setColDefault(false);
						break;
					}
					if (form.grdList().getRows().get(i).getColDesignatedToNewResults() && column == 2)
					{
						form.grdList().getRows().get(i).setColDesignatedToNewResults(false);
						break;
					}
					if (form.grdList().getRows().get(i).getColDesignatedPrinterForOCSOrder() && column == 3)
					{
						form.grdList().getRows().get(i).setColDesignatedPrinterForOCSOrder(false);
						break;
					}
				}
			}		
			if (row.getColDefault() && column == 1)
			{
				form.getLocalContext().setDefaultPrinter(row.getValue());
			}
			else if (row.getColDesignatedToNewResults() && column == 2)
			{
				form.getLocalContext().setDesignatedPrinterForNewResults(row.getValue());
			}
			else if (row.getColDesignatedPrinterForOCSOrder() && column == 3)
			{
				form.getLocalContext().setDesignatedPrinterForOCSOrder(row.getValue());
			}
		}
		else
		{
			if (!row.getColDefault() && column == 1)
			{
				form.getLocalContext().setDefaultPrinter(null);
			}
			else if (!row.getColDesignatedToNewResults() && column == 2)
			{
				form.getLocalContext().setDesignatedPrinterForNewResults(null);
			}
			else if (!row.getColDesignatedPrinterForOCSOrder() && column == 3)
			{
				form.getLocalContext().setDesignatedPrinterForOCSOrder(null);
			}
		}
	}
}
