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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2420.16410)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.charttypelist;

import ims.core.charting.vo.ChartTypeRefVo;
import ims.core.vo.ChartTypeDatasetVo;
import ims.core.vo.ChartTypeShortVo;
import ims.core.vo.ChartTypeShortVoCollection;
import ims.core.vo.ChartTypeVo;
import ims.core.vo.DataSetTypeVo;
import ims.core.vo.DataSetTypeVoCollection;
import ims.core.vo.lookups.LineColourPointIcon;
import ims.core.vo.lookups.LineType;
import ims.core.vo.lookups.LineTypeStatus;
import ims.framework.Control;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final Integer COL_NAME = new Integer(0);
	private static final Integer COL_ANSWERBOX = new Integer(1);
	private static final Integer COL_LINETYPE = new Integer(2);
	private static final Integer COL_COLOR_ICON = new Integer(3);
	
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
 	{
		createDynamicGridColumns();
		
		form.txtName().setValue(form.getGlobalContext().Core.getLastNameSelected());
		
		if(form.getGlobalContext().Core.getDataSetRecordIsNotNull())
		{
			submitQmbDataset(form.getGlobalContext().Core.getDataSetRecord().getName(), form.getGlobalContext().Core.getDataSetRecord());
			
			if(form.qmbDataset().getValues() != null && form.qmbDataset().getValues().size() > 0)
			{
				doSearch();
				
				form.dyngrdChart().setValue(form.getGlobalContext().Core.getChartTypeRecord());
			}
		}
		else if(form.getGlobalContext().Core.getLastNameSelectedIsNotNull())
		{
			doSearch();
			
			form.dyngrdChart().setValue(form.getGlobalContext().Core.getChartTypeRecord());
		}
		
		updateContextMenu();
	}
	private void createDynamicGridColumns()
	{
		DynamicGridColumn col = form.dyngrdChart().getColumns().newColumn("Chart type", COL_NAME);
		col.setDynamicWidthSupported(true);
		col = form.dyngrdChart().getColumns().newColumn("  ", COL_ANSWERBOX);
		col.setWidth(25);
		col = form.dyngrdChart().getColumns().newColumn("", COL_LINETYPE);
		col.setWidth(200);
		col = form.dyngrdChart().getColumns().newColumn("", COL_COLOR_ICON);
		col.setWidth(-1);
		
	}
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbDataset().clear();
		form.txtName().setValue(null);
		form.dyngrdChart().getRows().clear();
		form.getGlobalContext().Core.setChartTypeRecord(null);
		updateContextMenu();
	}
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if((form.txtName().getValue() == null || form.txtName().getValue().trim().length() == 0) && form.qmbDataset().getValue() == null)
		{
			engine.showMessage("Please enter a name or a dataset to search for.");
			return;
		}
		
		doSearch();
		//wdev-12517
		if(form.dyngrdChart().getRows().size() < 1)
			engine.showMessage("No records found.");
		//--------
		updateContextMenu();
	}
	private void doSearch()
	{
		String name = form.txtName().getValue();
		
		if(name != null)
			name = "%" + name + "%"; 

		ChartTypeShortVoCollection coll = domain.listChartType(name, form.qmbDataset().getValue());
		
		displayChartTypes(coll);
	}
	private void displayChartTypes(ChartTypeShortVoCollection coll)
	{
		form.dyngrdChart().getRows().clear();
		for (int i = 0; i < coll.size(); i++)
		{
			DynamicGridRow row = form.dyngrdChart().getRows().newRow();
			
			DynamicGridCell cell = row.getCells().newCell(form.dyngrdChart().getColumns().getByIdentifier(COL_NAME), DynamicCellType.STRING);
			cell.setWidth(600);
			cell.setReadOnly(true);
			cell.setValue(coll.get(i).getName() + " - " + (coll.get(i).getDescriptionIsNotNull() ? coll.get(i).getDescription() : ""));
			row.setValue(coll.get(i));
			
			//dummy record
			row.getRows().newRow();
		}
	}
	protected void onQmbDatasetValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.dyngrdChart().getRows().clear();
		form.getGlobalContext().Core.setChartTypeRecord(null);
		updateContextMenu();
	}
	private void updateContextMenu()
	{
		form.getContextMenus().hideAllChartTypeMenuItems();
		
		form.getContextMenus().getChartTypeADDItem().setVisible(true);
		form.getContextMenus().getChartTypeEDITItem().setVisible(form.dyngrdChart().getValue() instanceof ChartTypeShortVo);
	}
	protected void onQmbDatasetTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		if(value == null || value.trim().length() == 0)
		{
			engine.showMessage("Please enter a name to search for.");
			return;
		}
		
		submitQmbDataset(value, null);
	}
	private void submitQmbDataset(String value, DataSetTypeVo voToSelect)
	{
		form.qmbDataset().clear();
		
		DataSetTypeVoCollection dataset = domain.listDataset("%" + value + "%");
		
		for (int i = 0; i < dataset.size(); i++)
		{
			form.qmbDataset().newRow(dataset.get(i), dataset.get(i).getName());
		}
		
		if(dataset.size() == 1)
		{
			form.qmbDataset().setValue(dataset.get(0));
		}
		else
		{
			if(voToSelect == null)
				form.qmbDataset().showOpened();
			else
				form.qmbDataset().setValue(voToSelect);
		}
		
		form.dyngrdChart().getRows().clear();
	}
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.ChartType.ADD :
				form.getGlobalContext().Core.setChartTypeRecord(null);
				form.getGlobalContext().Core.setDataSetRecord(form.qmbDataset().getValue());
				form.getGlobalContext().Core.setLastNameSelected(form.txtName().getValue());
				engine.open(form.getForms().Core.ChartTypeDetails);
				return;
			case GenForm.ContextMenus.ChartType.EDIT :
				form.getGlobalContext().Core.setChartTypeRecord((ChartTypeShortVo) form.dyngrdChart().getValue());
				form.getGlobalContext().Core.setDataSetRecord(form.qmbDataset().getValue());
				form.getGlobalContext().Core.setLastNameSelected(form.txtName().getValue());
				engine.open(form.getForms().Core.ChartTypeDetails);
				return;
			
			default :
				break;
		}
		updateContextMenu();
		
	}
	protected void expandCollapse(DynamicGridRow row) 
	{
		Object item = row.getValue();
		
		if(row.isExpanded() && item instanceof ChartTypeShortVo)
		{
			ChartTypeVo fullItem = domain.getChartType((ChartTypeRefVo) item);
			
			row.getRows().clear();
			
			for (int i = 0; i < fullItem.getDatasetTypes().size(); i++)
			{
				ChartTypeDatasetVo dataset = fullItem.getDatasetTypes().get(i);
				
				DynamicGridRow childRow = row.getRows().newRow();
				
				childRow.setValue(dataset.getDatasetType());

				if(dataset.getLineType() == null)
				{
					createVariableCells(childRow, true);
				}
				else
				{
					createVariableCells(childRow, false);
				}

				DynamicGridCell cell = childRow.getCells().newCell(form.dyngrdChart().getColumns().getByIdentifier(COL_NAME), DynamicCellType.STRING);
				cell.setValue(dataset.getDatasetType().getName());
				cell.setReadOnly(true);
				
				cell = childRow.getCells().newCell(form.dyngrdChart().getColumns().getByIdentifier(COL_ANSWERBOX), DynamicCellType.ANSWER);
				cell.getItems().newItem(LineTypeStatus.DEFAULT, LineTypeStatus.DEFAULT.getImage());
				cell.getItems().newItem(LineTypeStatus.CUSTOM, LineTypeStatus.CUSTOM.getImage());
				cell.setValue(dataset.getLineTypeIsNotNull() ? LineTypeStatus.CUSTOM : LineTypeStatus.DEFAULT);
				cell.setReadOnly(true);
				
				if(dataset.getLineType() == null)
				{
					DynamicGridCell dynamicGridCell = childRow.getCells().get(form.dyngrdChart().getColumns().getByIdentifier(COL_LINETYPE));
					dynamicGridCell.setValue(dataset.getDatasetType().getDefaultLineType());
					dynamicGridCell.setReadOnly(true);
					dynamicGridCell = childRow.getCells().get(form.dyngrdChart().getColumns().getByIdentifier(COL_COLOR_ICON));
					dynamicGridCell.setValue(dataset.getDatasetType().getDefLineColPtIcon());
					dynamicGridCell.setReadOnly(true);
					
					childRow.setExpandedImage(dataset.getDatasetType().getDefLineColPtIconIsNotNull() ? dataset.getDatasetType().getDefLineColPtIcon().getImage() : null);
					childRow.setCollapsedImage(dataset.getDatasetType().getDefLineColPtIconIsNotNull() ? dataset.getDatasetType().getDefLineColPtIcon().getImage() : null);
				}
				else
				{
					DynamicGridCell dynamicGridCell = childRow.getCells().get(form.dyngrdChart().getColumns().getByIdentifier(COL_LINETYPE));
					dynamicGridCell.setValue(dataset.getLineType());
					dynamicGridCell.setReadOnly(true);
					dynamicGridCell = childRow.getCells().get(form.dyngrdChart().getColumns().getByIdentifier(COL_COLOR_ICON));
					dynamicGridCell.setValue(dataset.getLineColourPointIcon());
					dynamicGridCell.setReadOnly(true);
					
					childRow.setExpandedImage(dataset.getLineColourPointIconIsNotNull() ? dataset.getLineColourPointIcon().getImage() : null);
					childRow.setCollapsedImage(dataset.getLineColourPointIconIsNotNull() ? dataset.getLineColourPointIcon().getImage() : null);
				}
			}
		}
		
		updateContextMenu();
	}
	private void createVariableCells(DynamicGridRow row, boolean bDefault)
	{
		clearVariableCells(row);

		DynamicGridCell cell = row.getCells().newCell(form.dyngrdChart().getColumns().getByIdentifier(COL_LINETYPE), DynamicCellType.ENUMERATION);
		engine.populate(cell, LineType.getNegativeInstancesAsIItemCollection());
		cell.setReadOnly(true);
		if(bDefault)
		{
			cell.setValue(((DataSetTypeVo)row.getValue()).getDefaultLineType());
		}
		
		cell = row.getCells().newCell(form.dyngrdChart().getColumns().getByIdentifier(COL_COLOR_ICON), DynamicCellType.ENUMERATION);
		engine.populate(cell, LineColourPointIcon.getNegativeInstancesAsIItemCollection());
		cell.setReadOnly(true);
		if(bDefault)
		{
			cell.setValue(((DataSetTypeVo)row.getValue()).getDefLineColPtIcon());
		}
	}
	private void clearVariableCells(DynamicGridRow row)
	{
		removeCellByColumn(row, COL_LINETYPE);
		removeCellByColumn(row, COL_COLOR_ICON);
	}
	private void removeCellByColumn(DynamicGridRow row, Integer colIdentifier)
	{
		DynamicGridCell cell;
		cell = row.getCells().get(form.dyngrdChart().getColumns().getByIdentifier(colIdentifier));
		if(cell != null)
			row.getCells().remove(cell);
	}
	protected void onDyngrdChartRowSelectionChanged(DynamicGridRow row)
	{
		updateContextMenu();
	}
	protected void onDyngrdChartRowExpandCollapse(DynamicGridRow row) throws PresentationLogicException
	{
		expandCollapse(row);
	}
}
