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

package ims.core.forms.alertscc;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	protected void fireCustomControlValueChanged()
	{
		super.fireValueChanged();
	}
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
	public static class grdAlertsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdAlertsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setColAlertReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isColAlertReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showColAlertOpened()
		{
			super.row.showOpened(0);
		}
		public void setTooltipForColAlert(String value)
		{
			super.row.setTooltip(0, value);
		}
		public String getColAlert()
		{
			return (String)super.row.get(0);
		}
		public void setColAlert(String value)
		{
			super.row.set(0, value);
		}
		public void setCellColAlertTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public ims.core.vo.PatientAlertLiteVo getValue()
		{
			return (ims.core.vo.PatientAlertLiteVo)super.row.getValue();
		}
		public void setValue(ims.core.vo.PatientAlertLiteVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdAlertsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdAlertsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdAlertsRow get(int index)
		{
			return new grdAlertsRow(super.collection.get(index));
		}
		public grdAlertsRow newRow()
		{
			return new grdAlertsRow(super.collection.newRow());
		}
		public grdAlertsRow newRow(boolean autoSelect)
		{
			return new grdAlertsRow(super.collection.newRow(autoSelect));
		}
		public grdAlertsRow newRowAt(int index)
		{
			return new grdAlertsRow(super.collection.newRowAt(index));
		}
		public grdAlertsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdAlertsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdAlertsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public ims.core.vo.PatientAlertLiteVoCollection getValues()
		{
			ims.core.vo.PatientAlertLiteVoCollection listOfValues = new ims.core.vo.PatientAlertLiteVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.core.vo.PatientAlertLiteVo getValue()
		{
			return (ims.core.vo.PatientAlertLiteVo)super.grid.getValue();
		}
		public void setValue(ims.core.vo.PatientAlertLiteVo value)
		{
			super.grid.setValue(value);
		}
		public grdAlertsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdAlertsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdAlertsRowCollection getRows()
		{
			return new grdAlertsRowCollection(super.grid.getRows());
		}
		public grdAlertsRow getRowByValue(ims.core.vo.PatientAlertLiteVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdAlertsRow(row);
		}
		public void setColAlertHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getColAlertHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(280, 136);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Core.contextMenuAlertsCcMenu = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Core.contextMenuAlertsCcMenuADDItem = factory.createMenuItem(startControlID.intValue() + 1, "Add", true, false, new Integer(102179), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4630001)))
			contextMenus.Core.contextMenuAlertsCcMenu.add(contextMenus.Core.contextMenuAlertsCcMenuADDItem);
		contextMenus.Core.contextMenuAlertsCcMenuEDITItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit", true, false, new Integer(102150), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4630002)))
			contextMenus.Core.contextMenuAlertsCcMenu.add(contextMenus.Core.contextMenuAlertsCcMenuEDITItem);
		form.registerMenu(contextMenus.Core.contextMenuAlertsCcMenu);


		// CheckBox Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 1, 104, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"No Known Alerts", Boolean.TRUE, null}));

		// Grid Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 8, 17, 232, 111, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdAlertsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.READONLY, ControlState.READONLY, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, contextMenus.Core.contextMenuAlertsCcMenu, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdAlertsTemp);
		grdAlertsGrid grdAlerts = (grdAlertsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdAlertsGrid.class, m_grdAlertsTemp);
		grdAlerts.addStringColumn("Alert", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdAlerts);

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 248, 56, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.Edit, this.getImages().Core.EditDisabled, "Edit Alert", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 248, 16, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.AddFile16, this.getImages().Core.AddFile16Disable, "Add Alert", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public CheckBox chkNoAlerts()
	{
		return (CheckBox)super.getControl(0);
	}
	public grdAlertsGrid grdAlerts()
	{
		return (grdAlertsGrid)super.getGrid(0);
	}
	public ImageButton imbEdit()
	{
		return (ImageButton)super.getControl(2);
	}
	public ImageButton imbNew()
	{
		return (ImageButton)super.getControl(3);
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
				AlertsForTriage = new LocalFormName(101196);
			}
			public final FormName AlertsForTriage;
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
				AddFile16 = new ImageHelper(102330, "Images/Core/add-file_16x16.png", new Integer(16), new Integer(16));
				AddFile16Disable = new ImageHelper(102565, "Images/Core/add-fileDisable_16x16.png", new Integer(16), new Integer(16));
				Edit = new ImageHelper(102150, "Images/Core/Edit16.gif", new Integer(16), new Integer(16));
				EditDisabled = new ImageHelper(102178, "Images/Core/EditDisabled16.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image AddFile16;
			public final ims.framework.utils.Image AddFile16Disable;
			public final ims.framework.utils.Image Edit;
			public final ims.framework.utils.Image EditDisabled;
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
	public LocalContext getLocalContext()
	{
		return (LocalContext)super.getLocalCtx();
	}
	public class LocalContext extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
		
		public LocalContext(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			super.setContext(context);
			String prefix = formInfo.getLocalVariablesPrefix();
			cxl_IsEnabled = new ims.framework.ContextVariable("IsEnabled", prefix + "_lv_Core.AlertsCc.__internal_x_context__IsEnabled_" + componentIdentifier + "");
			cxl_NoAlert = new ims.framework.ContextVariable("NoAlert", prefix + "_lv_Core.AlertsCc.__internal_x_context__NoAlert_" + componentIdentifier + "");
			cxl_selectedAlert = new ims.framework.ContextVariable("selectedAlert", prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier + "");
			cxl_SelectedEvent = new ims.framework.ContextVariable("SelectedEvent", prefix + "_lv_Core.AlertsCc.__internal_x_context__SelectedEvent_" + componentIdentifier + "");
			cxl_IsHidden = new ims.framework.ContextVariable("IsHidden", prefix + "_lv_Core.AlertsCc.__internal_x_context__IsHidden_" + componentIdentifier + "");
		}
		
		public boolean getIsEnabledIsNotNull()
		{
			return !cxl_IsEnabled.getValueIsNull(context);
		}
		public Boolean getIsEnabled()
		{
			return (Boolean)cxl_IsEnabled.getValue(context);
		}
		public void setIsEnabled(Boolean value)
		{
			cxl_IsEnabled.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_IsEnabled = null;
		public boolean getNoAlertIsNotNull()
		{
			return !cxl_NoAlert.getValueIsNull(context);
		}
		public ims.core.vo.PatientNoAlertInfoForTriageVo getNoAlert()
		{
			return (ims.core.vo.PatientNoAlertInfoForTriageVo)cxl_NoAlert.getValue(context);
		}
		public void setNoAlert(ims.core.vo.PatientNoAlertInfoForTriageVo value)
		{
			cxl_NoAlert.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_NoAlert = null;
		public boolean getselectedAlertIsNotNull()
		{
			return !cxl_selectedAlert.getValueIsNull(context);
		}
		public ims.core.vo.PatientAlertLiteVo getselectedAlert()
		{
			return (ims.core.vo.PatientAlertLiteVo)cxl_selectedAlert.getValue(context);
		}
		public void setselectedAlert(ims.core.vo.PatientAlertLiteVo value)
		{
			cxl_selectedAlert.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_selectedAlert = null;
		public boolean getSelectedEventIsNotNull()
		{
			return !cxl_SelectedEvent.getValueIsNull(context);
		}
		public ims.emergency.vo.enums.EdAssessment_CustomControlsEvents getSelectedEvent()
		{
			return (ims.emergency.vo.enums.EdAssessment_CustomControlsEvents)cxl_SelectedEvent.getValue(context);
		}
		public void setSelectedEvent(ims.emergency.vo.enums.EdAssessment_CustomControlsEvents value)
		{
			cxl_SelectedEvent.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedEvent = null;
		public boolean getIsHiddenIsNotNull()
		{
			return !cxl_IsHidden.getValueIsNull(context);
		}
		public Boolean getIsHidden()
		{
			return (Boolean)cxl_IsHidden.getValue(context);
		}
		public void setIsHidden(Boolean value)
		{
			cxl_IsHidden.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_IsHidden = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public CoreNamespace Core = new CoreNamespace();
		public final class CoreNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class AlertsCcMenu implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int ADD = 1;
				public static final int EDIT = 2;
			}
			public void disableAllAlertsCcMenuMenuItems()
			{
				this.contextMenuAlertsCcMenuADDItem.setEnabled(false);
				this.contextMenuAlertsCcMenuEDITItem.setEnabled(false);
			}
			public void hideAllAlertsCcMenuMenuItems()
			{
				this.contextMenuAlertsCcMenuADDItem.setVisible(false);
				this.contextMenuAlertsCcMenuEDITItem.setVisible(false);
			}
			private Menu contextMenuAlertsCcMenu;
			public ReadOnlyMenuItem getAlertsCcMenuADDItem()
			{
				return this.contextMenuAlertsCcMenuADDItem;
			}
			private MenuItem contextMenuAlertsCcMenuADDItem;
			public ReadOnlyMenuItem getAlertsCcMenuEDITItem()
			{
				return this.contextMenuAlertsCcMenuEDITItem;
			}
			private MenuItem contextMenuAlertsCcMenuEDITItem;
		}
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
			IReportField[] fields = new IReportField[83];
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
			fields[71] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__NoAlert_" + componentIdentifier, "BO-1003100084-ID", "ID_PatientNoAlertInfo");
			fields[72] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__NoAlert_" + componentIdentifier, "BO-1003100084-PATIENT", "Patient");
			fields[73] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__NoAlert_" + componentIdentifier, "BO-1003100084-ALERTSTATUS", "AlertStatus");
			fields[74] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__NoAlert_" + componentIdentifier, "BO-1003100084-WHENIDENTIFIED", "WhenIdentified");
			fields[75] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__NoAlert_" + componentIdentifier, "BO-1003100084-NOALERTSOURCEOFINFORMATION", "NoAlertSourceofInformation");
			fields[76] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-ID", "ID_PatientAlert");
			fields[77] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-ALERTTYPE", "AlertType");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-ISCURRENTLYACTIVEALERT", "IsCurrentlyActiveAlert");
			fields[79] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-SOURCEOFINFORMATION", "SourceofInformation");
			fields[80] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-PATIENT", "Patient");
			fields[81] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-COMMENTS", "Comments");
			fields[82] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.AlertsCc.__internal_x_context__selectedAlert_" + componentIdentifier, "BO-1003100012-DATEIDENTIFIED", "DateIdentified");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return formInfo.getLocalVariablesPrefix() + formInfo.getNamespaceName() + formInfo.getFormName() + formInfo.getFormId() + "_" + this.componentIdentifier;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
