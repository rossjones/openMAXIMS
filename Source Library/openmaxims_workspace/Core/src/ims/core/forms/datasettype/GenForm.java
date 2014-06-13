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

package ims.core.forms.datasettype;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	public static class cmbCategoryComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.core.vo.lookups.DataSetCategory value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.core.vo.lookups.DataSetCategory value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.core.vo.lookups.DataSetCategory value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.core.vo.lookups.DataSetCategory value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.core.vo.lookups.DataSetCategory value)
		{
			return super.control.removeRow(value);
		}
		public ims.core.vo.lookups.DataSetCategory getValue()
		{
			return (ims.core.vo.lookups.DataSetCategory)super.control.getValue();
		}
		public void setValue(ims.core.vo.lookups.DataSetCategory value)
		{
			super.control.setValue(value);
		}
	}
	public static class grdListRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdListRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setColNameReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isColNameReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showColNameOpened()
		{
			super.row.showOpened(0);
		}
		public String getColName()
		{
			return (String)super.row.get(0);
		}
		public void setColName(String value)
		{
			super.row.set(0, value);
		}
		public void setCellColNameTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setColCategoryReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean isColCategoryReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showColCategoryOpened()
		{
			super.row.showOpened(1);
		}
		public String getColCategory()
		{
			return (String)super.row.get(1);
		}
		public void setColCategory(String value)
		{
			super.row.set(1, value);
		}
		public void setCellColCategoryTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setColBandReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean isColBandReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showColBandOpened()
		{
			super.row.showOpened(2);
		}
		public String getColBand()
		{
			return (String)super.row.get(2);
		}
		public void setColBand(String value)
		{
			super.row.set(2, value);
		}
		public void setCellColBandTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public void setColMaxFactorReadOnly(boolean value)
		{
			super.row.setReadOnly(3, value);
		}
		public boolean isColMaxFactorReadOnly()
		{
			return super.row.isReadOnly(3);
		}
		public void showColMaxFactorOpened()
		{
			super.row.showOpened(3);
		}
		public String getColMaxFactor()
		{
			return (String)super.row.get(3);
		}
		public void setColMaxFactor(String value)
		{
			super.row.set(3, value);
		}
		public void setCellColMaxFactorTooltip(String value)
		{
			super.row.setTooltip(3, value);
		}
		public void setColLineTypeReadOnly(boolean value)
		{
			super.row.setReadOnly(4, value);
		}
		public boolean isColLineTypeReadOnly()
		{
			return super.row.isReadOnly(4);
		}
		public void showColLineTypeOpened()
		{
			super.row.showOpened(4);
		}
		public String getColLineType()
		{
			return (String)super.row.get(4);
		}
		public void setColLineType(String value)
		{
			super.row.set(4, value);
		}
		public void setCellColLineTypeTooltip(String value)
		{
			super.row.setTooltip(4, value);
		}
		public void setColColourIconReadOnly(boolean value)
		{
			super.row.setReadOnly(5, value);
		}
		public boolean isColColourIconReadOnly()
		{
			return super.row.isReadOnly(5);
		}
		public void showColColourIconOpened()
		{
			super.row.showOpened(5);
		}
		public ims.core.vo.lookups.LineColourPointIcon getColColourIcon()
		{
			return (ims.core.vo.lookups.LineColourPointIcon)super.row.get(5);
		}
		public void setColColourIcon(ims.core.vo.lookups.LineColourPointIcon value)
		{
			super.row.set(5, value, true);
		}
		public void setCellColColourIconTooltip(String value)
		{
			super.row.setTooltip(5, value);
		}
		public ims.core.vo.DataSetTypeVo getValue()
		{
			return (ims.core.vo.DataSetTypeVo)super.row.getValue();
		}
		public void setValue(ims.core.vo.DataSetTypeVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdListRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdListRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdListRow get(int index)
		{
			return new grdListRow(super.collection.get(index));
		}
		public grdListRow newRow()
		{
			return new grdListRow(super.collection.newRow());
		}
		public grdListRow newRow(boolean autoSelect)
		{
			return new grdListRow(super.collection.newRow(autoSelect));
		}
		public grdListRow newRowAt(int index)
		{
			return new grdListRow(super.collection.newRowAt(index));
		}
		public grdListRow newRowAt(int index, boolean autoSelect)
		{
			return new grdListRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdListGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		private void addComboBoxColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean canBeEmpty, boolean autoPostBack, boolean bold, boolean canGrow, int maxDropDownItems)
		{
			super.grid.addComboBoxColumn(caption, captionAlignment, alignment, width, readOnly, canBeEmpty, autoPostBack, bold, canGrow, maxDropDownItems);
		}
		public ims.core.vo.DataSetTypeVoCollection getValues()
		{
			ims.core.vo.DataSetTypeVoCollection listOfValues = new ims.core.vo.DataSetTypeVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.core.vo.DataSetTypeVo getValue()
		{
			return (ims.core.vo.DataSetTypeVo)super.grid.getValue();
		}
		public void setValue(ims.core.vo.DataSetTypeVo value)
		{
			super.grid.setValue(value);
		}
		public grdListRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdListRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdListRowCollection getRows()
		{
			return new grdListRowCollection(super.grid.getRows());
		}
		public grdListRow getRowByValue(ims.core.vo.DataSetTypeVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdListRow(row);
		}
		public void setColNameHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getColNameHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setColCategoryHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getColCategoryHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setColBandHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getColBandHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
		public void setColMaxFactorHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(3, value);
		}
		public String getColMaxFactorHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(3);
		}
		public void setColLineTypeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(4, value);
		}
		public String getColLineTypeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(4);
		}
		public void setColColourIconHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(5, value);
		}
		public String getColColourIconHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(5);
		}
		public GridComboBox ColColourIconComboBox()
		{
			return new GridComboBox(super.grid, 5);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
		}
	
		super.setContext(form);

		form.setDarkHeight(50);
		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.contextMenuDataSetTypeMenu = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.contextMenuDataSetTypeMenuADD_DATASETItem = factory.createMenuItem(startControlID.intValue() + 1, "Add DataSet Type", true, false, new Integer(102179), true, false);
		contextMenus.contextMenuDataSetTypeMenu.add(contextMenus.contextMenuDataSetTypeMenuADD_DATASETItem);
		contextMenus.contextMenuDataSetTypeMenuEDIT_DATASETItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit DataSet Type", true, false, new Integer(102150), true, false);
		contextMenus.contextMenuDataSetTypeMenu.add(contextMenus.contextMenuDataSetTypeMenuEDIT_DATASETItem);
		form.registerMenu(contextMenus.contextMenuDataSetTypeMenu);


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 456, 16, 60, 17, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, "Category:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 41, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Name:", new Integer(1), null, new Integer(0)}));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 64, 16, 376, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,Boolean.FALSE, new Integer(0), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 528, 16, 224, 21, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		ComboBox m_cmbCategoryTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPRIGHT ,Boolean.TRUE, Boolean.FALSE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbCategoryTemp);
		cmbCategoryComboBox cmbCategory = (cmbCategoryComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbCategoryComboBox.class, m_cmbCategoryTemp);
		super.addComboBox(cmbCategory);

		// Grid Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 16, 64, 816, 552, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdListTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, contextMenus.contextMenuDataSetTypeMenu, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.TRUE, Boolean.TRUE});
		addControl(m_grdListTemp);
		grdListGrid grdList = (grdListGrid)GridFlyweightFactory.getInstance().createGridBridge(grdListGrid.class, m_grdListTemp);
		grdList.addStringColumn("Name", 0, 0, 180, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdList.addStringColumn("Category", 0, 0, 120, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdList.addStringColumn("Band ( Min - Max)", 0, 0, 140, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdList.addStringColumn("Factor (Min - Max)", 0, 0, 130, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdList.addStringColumn("Line Type", 0, 0, 80, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdList.addComboBoxColumn("Colour / Icon", 0, 0, -1, true, true, false, false, true, -1);
		super.addGrid(grdList);

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 768, 12, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.FindEnabled24, this.getImages().Core.FindDisabled24, "Search DataSet", Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 800, 12, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.ClearEnabled24, this.getImages().Core.ClearDisabled24, "Clear All", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public TextBox txtName()
	{
		return (TextBox)super.getControl(2);
	}
	public cmbCategoryComboBox cmbCategory()
	{
		return (cmbCategoryComboBox)super.getComboBox(0);
	}
	public grdListGrid grdList()
	{
		return (grdListGrid)super.getGrid(0);
	}
	public ImageButton imbSearch()
	{
		return (ImageButton)super.getControl(5);
	}
	public ImageButton imbClear()
	{
		return (ImageButton)super.getControl(6);
	}

	public static class Forms implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			private LocalFormName(int name)
			{
				super(name);
			}
		}

		private Forms()
		{
			Core = new CoreForms();
		}
		public final class CoreForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreForms()
			{
				DataSetTypeAddEdit = new LocalFormName(102236);
			}
			public final FormName DataSetTypeAddEdit;
		}

		public CoreForms Core;
	}


	public static class Images implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private final class ImageHelper extends ims.framework.utils.ImagePath
		{
			private static final long serialVersionUID = 1L;
			
			private ImageHelper(int id, String path, Integer width, Integer height)
			{
				super(id, path, width, height);
			}
		}
		private Images()
		{
			Core = new CoreImages();
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				FindEnabled24 = new ImageHelper(102175, "Images/Core/Find_24.png", new Integer(24), new Integer(24));
				FindDisabled24 = new ImageHelper(102172, "Images/Core/FindDisabled_24.png", new Integer(24), new Integer(24));
				ClearEnabled24 = new ImageHelper(102174, "Images/Core/ClearEnabled_24.png", new Integer(24), new Integer(24));
				ClearDisabled24 = new ImageHelper(102173, "Images/Core/ClearDisabled_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image FindEnabled24;
			public final ims.framework.utils.Image FindDisabled24;
			public final ims.framework.utils.Image ClearEnabled24;
			public final ims.framework.utils.Image ClearDisabled24;
		}
		public final CoreImages Core;
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public final class DataSetTypeMenu implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public static final int ADD_DATASET = 1;
			public static final int EDIT_DATASET = 2;
		}
		public void disableAllDataSetTypeMenuMenuItems()
		{
			this.contextMenuDataSetTypeMenuADD_DATASETItem.setEnabled(false);
			this.contextMenuDataSetTypeMenuEDIT_DATASETItem.setEnabled(false);
		}
		public void hideAllDataSetTypeMenuMenuItems()
		{
			this.contextMenuDataSetTypeMenuADD_DATASETItem.setVisible(false);
			this.contextMenuDataSetTypeMenuEDIT_DATASETItem.setVisible(false);
		}
		private Menu contextMenuDataSetTypeMenu;
		public MenuItem getDataSetTypeMenuADD_DATASETItem()
		{
			return this.contextMenuDataSetTypeMenuADD_DATASETItem;
		}
		private MenuItem contextMenuDataSetTypeMenuADD_DATASETItem;
		public MenuItem getDataSetTypeMenuEDIT_DATASETItem()
		{
			return this.contextMenuDataSetTypeMenuEDIT_DATASETItem;
		}
		private MenuItem contextMenuDataSetTypeMenuEDIT_DATASETItem;
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}

	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[84];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_CareUk.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-ID", "ID_DatasetType");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-NAME", "Name");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-CATEGORY", "Category");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-MAXFACTOR", "MaxFactor");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-MINFACTOR", "MinFactor");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-DEFAULTLINETYPE", "DefaultLineType");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-DEFLINECOLPTICON", "DefLineColPtIcon");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-NORMALBANDMAXVALUEMALE", "NormalBandMaxValueMale");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-NORMALBANDMINVALUEMALE", "NormalBandMinValueMale");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-NORMALBANDMAXVALUEFEMALE", "NormalBandMaxValueFemale");
			fields[81] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-NORMALBANDMINVALUEFEMALE", "NormalBandMinValueFemale");
			fields[82] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-ISACTIVE", "IsActive");
			fields[83] = new ims.framework.ReportField(this.context, "_cv_Core.DataSetRecord", "BO-1081100001-UNITOFMEASURE", "UnitOfMeasure");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
