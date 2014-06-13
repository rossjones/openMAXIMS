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

package ims.emergency.forms.medicnotes;

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
	public static class grdNotesRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdNotesRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setColNoteReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isColNoteReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showColNoteOpened()
		{
			super.row.showOpened(0);
		}
		public String getColNote()
		{
			return (String)super.row.get(0);
		}
		public void setColNote(String value)
		{
			super.row.set(0, value);
		}
		public void setCellColNoteTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public ims.emergency.vo.MedicNotesVo getValue()
		{
			return (ims.emergency.vo.MedicNotesVo)super.row.getValue();
		}
		public void setValue(ims.emergency.vo.MedicNotesVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdNotesRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdNotesRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdNotesRow get(int index)
		{
			return new grdNotesRow(super.collection.get(index));
		}
		public grdNotesRow newRow()
		{
			return new grdNotesRow(super.collection.newRow());
		}
		public grdNotesRow newRow(boolean autoSelect)
		{
			return new grdNotesRow(super.collection.newRow(autoSelect));
		}
		public grdNotesRow newRowAt(int index)
		{
			return new grdNotesRow(super.collection.newRowAt(index));
		}
		public grdNotesRow newRowAt(int index, boolean autoSelect)
		{
			return new grdNotesRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdNotesGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addHtmlColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, boolean canGrow)
		{
			super.grid.addHtmlColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, canGrow);
		}
		public ims.emergency.vo.MedicNotesVoCollection getValues()
		{
			ims.emergency.vo.MedicNotesVoCollection listOfValues = new ims.emergency.vo.MedicNotesVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.emergency.vo.MedicNotesVo getValue()
		{
			return (ims.emergency.vo.MedicNotesVo)super.grid.getValue();
		}
		public void setValue(ims.emergency.vo.MedicNotesVo value)
		{
			super.grid.setValue(value);
		}
		public grdNotesRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdNotesRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdNotesRowCollection getRows()
		{
			return new grdNotesRowCollection(super.grid.getRows());
		}
		public grdNotesRow getRowByValue(ims.emergency.vo.MedicNotesVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdNotesRow(row);
		}
		public void setColNoteHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getColNoteHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(664, 448);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Emergency.contextMenuMedicNoteMenu = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Emergency.contextMenuMedicNoteMenuNEWItem = factory.createMenuItem(startControlID.intValue() + 1, "New", true, false, new Integer(102149), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4660001)))
			contextMenus.Emergency.contextMenuMedicNoteMenu.add(contextMenus.Emergency.contextMenuMedicNoteMenuNEWItem);
		contextMenus.Emergency.contextMenuMedicNoteMenuEDITItem = factory.createMenuItem(startControlID.intValue() + 2, "Correct", true, false, new Integer(102150), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4660002)))
			contextMenus.Emergency.contextMenuMedicNoteMenu.add(contextMenus.Emergency.contextMenuMedicNoteMenuEDITItem);
		contextMenus.Emergency.contextMenuMedicNoteMenuRIEItem = factory.createMenuItem(startControlID.intValue() + 3, "RIE", true, false, new Integer(102142), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4660003)))
			contextMenus.Emergency.contextMenuMedicNoteMenu.add(contextMenus.Emergency.contextMenuMedicNoteMenuRIEItem);
		form.registerMenu(contextMenus.Emergency.contextMenuMedicNoteMenu);


		// Button Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 272, 424, 128, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "RIE", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 140, 424, 128, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Correct", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 8, 424, 128, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "New", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Grid Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 648, 411, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdNotesTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, contextMenus.Emergency.contextMenuMedicNoteMenu, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdNotesTemp);
		grdNotesGrid grdNotes = (grdNotesGrid)GridFlyweightFactory.getInstance().createGridBridge(grdNotesGrid.class, m_grdNotesTemp);
		grdNotes.addHtmlColumn("Medic Notes", 0, 0, -1, true, false, 0, true);
		super.addGrid(grdNotes);
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}
	public Button btnRIE()
	{
		return (Button)super.getControl(0);
	}
	public Button btnEdit()
	{
		return (Button)super.getControl(1);
	}
	public Button btnNew()
	{
		return (Button)super.getControl(2);
	}
	public grdNotesGrid grdNotes()
	{
		return (grdNotesGrid)super.getGrid(0);
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
			Emergency = new EmergencyForms();
		}
		public final class CoreForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreForms()
			{
				RieConfirmationDialog = new LocalFormName(102370);
			}
			public final FormName RieConfirmationDialog;
		}
		public final class EmergencyForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private EmergencyForms()
			{
				MedicNoteDialog = new LocalFormName(129145);
			}
			public final FormName MedicNoteDialog;
		}

		public CoreForms Core;
		public EmergencyForms Emergency;
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
			cxl_Patient = new ims.framework.ContextVariable("Patient", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__Patient_" + componentIdentifier + "");
			cxl_EpisodeOfCare = new ims.framework.ContextVariable("EpisodeOfCare", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__EpisodeOfCare_" + componentIdentifier + "");
			cxl_CareContext = new ims.framework.ContextVariable("CareContext", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__CareContext_" + componentIdentifier + "");
			cxl_IsEnabled = new ims.framework.ContextVariable("IsEnabled", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__IsEnabled_" + componentIdentifier + "");
			cxl_RIERecord = new ims.framework.ContextVariable("RIERecord", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__RIERecord_" + componentIdentifier + "");
			cxl_ClinicalProblem = new ims.framework.ContextVariable("ClinicalProblem", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__ClinicalProblem_" + componentIdentifier + "");
			cxl_LoggedHCP = new ims.framework.ContextVariable("LoggedHCP", prefix + "_lv_Emergency.MedicNotes.__internal_x_context__LoggedHCP_" + componentIdentifier + "");
		}
		
		public boolean getPatientIsNotNull()
		{
			return !cxl_Patient.getValueIsNull(context);
		}
		public ims.core.patient.vo.PatientRefVo getPatient()
		{
			return (ims.core.patient.vo.PatientRefVo)cxl_Patient.getValue(context);
		}
		public void setPatient(ims.core.patient.vo.PatientRefVo value)
		{
			if(value != null && (value.getBoId() == null || value.getBoId().intValue() < 1))
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid domain object id for 'Patient' RefVo context variable.");
			if(value == null)
				cxl_Patient.setValue(context, null);
			else
				cxl_Patient.setValue(context, new ims.core.patient.vo.PatientRefVo(value.getBoId(), value.getBoVersion()));
		}
		private ims.framework.ContextVariable cxl_Patient = null;
		public boolean getEpisodeOfCareIsNotNull()
		{
			return !cxl_EpisodeOfCare.getValueIsNull(context);
		}
		public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
		{
			return (ims.core.admin.vo.EpisodeOfCareRefVo)cxl_EpisodeOfCare.getValue(context);
		}
		public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
		{
			if(value != null && (value.getBoId() == null || value.getBoId().intValue() < 1))
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid domain object id for 'EpisodeOfCare' RefVo context variable.");
			if(value == null)
				cxl_EpisodeOfCare.setValue(context, null);
			else
				cxl_EpisodeOfCare.setValue(context, new ims.core.admin.vo.EpisodeOfCareRefVo(value.getBoId(), value.getBoVersion()));
		}
		private ims.framework.ContextVariable cxl_EpisodeOfCare = null;
		public boolean getCareContextIsNotNull()
		{
			return !cxl_CareContext.getValueIsNull(context);
		}
		public ims.core.admin.vo.CareContextRefVo getCareContext()
		{
			return (ims.core.admin.vo.CareContextRefVo)cxl_CareContext.getValue(context);
		}
		public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
		{
			if(value != null && (value.getBoId() == null || value.getBoId().intValue() < 1))
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid domain object id for 'CareContext' RefVo context variable.");
			if(value == null)
				cxl_CareContext.setValue(context, null);
			else
				cxl_CareContext.setValue(context, new ims.core.admin.vo.CareContextRefVo(value.getBoId(), value.getBoVersion()));
		}
		private ims.framework.ContextVariable cxl_CareContext = null;
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
		public boolean getRIERecordIsNotNull()
		{
			return !cxl_RIERecord.getValueIsNull(context);
		}
		public ims.emergency.vo.MedicNotesVo getRIERecord()
		{
			return (ims.emergency.vo.MedicNotesVo)cxl_RIERecord.getValue(context);
		}
		public void setRIERecord(ims.emergency.vo.MedicNotesVo value)
		{
			cxl_RIERecord.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_RIERecord = null;
		public boolean getClinicalProblemIsNotNull()
		{
			return !cxl_ClinicalProblem.getValueIsNull(context);
		}
		public ims.clinical.configuration.vo.ClinicalProblemRefVo getClinicalProblem()
		{
			return (ims.clinical.configuration.vo.ClinicalProblemRefVo)cxl_ClinicalProblem.getValue(context);
		}
		public void setClinicalProblem(ims.clinical.configuration.vo.ClinicalProblemRefVo value)
		{
			if(value != null && (value.getBoId() == null || value.getBoId().intValue() < 1))
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid domain object id for 'ClinicalProblem' RefVo context variable.");
			if(value == null)
				cxl_ClinicalProblem.setValue(context, null);
			else
				cxl_ClinicalProblem.setValue(context, new ims.clinical.configuration.vo.ClinicalProblemRefVo(value.getBoId(), value.getBoVersion()));
		}
		private ims.framework.ContextVariable cxl_ClinicalProblem = null;
		public boolean getLoggedHCPIsNotNull()
		{
			return !cxl_LoggedHCP.getValueIsNull(context);
		}
		public ims.core.resource.people.vo.HcpRefVo getLoggedHCP()
		{
			return (ims.core.resource.people.vo.HcpRefVo)cxl_LoggedHCP.getValue(context);
		}
		public void setLoggedHCP(ims.core.resource.people.vo.HcpRefVo value)
		{
			if(value != null && (value.getBoId() == null || value.getBoId().intValue() < 1))
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid domain object id for 'LoggedHCP' RefVo context variable.");
			if(value == null)
				cxl_LoggedHCP.setValue(context, null);
			else
				cxl_LoggedHCP.setValue(context, new ims.core.resource.people.vo.HcpRefVo(value.getBoId(), value.getBoVersion()));
		}
		private ims.framework.ContextVariable cxl_LoggedHCP = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public EmergencyNamespace Emergency = new EmergencyNamespace();
		public final class EmergencyNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class MedicNoteMenu implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int NEW = 1;
				public static final int EDIT = 2;
				public static final int RIE = 3;
			}
			public void disableAllMedicNoteMenuMenuItems()
			{
				this.contextMenuMedicNoteMenuNEWItem.setEnabled(false);
				this.contextMenuMedicNoteMenuEDITItem.setEnabled(false);
				this.contextMenuMedicNoteMenuRIEItem.setEnabled(false);
			}
			public void hideAllMedicNoteMenuMenuItems()
			{
				this.contextMenuMedicNoteMenuNEWItem.setVisible(false);
				this.contextMenuMedicNoteMenuEDITItem.setVisible(false);
				this.contextMenuMedicNoteMenuRIEItem.setVisible(false);
			}
			private Menu contextMenuMedicNoteMenu;
			public ReadOnlyMenuItem getMedicNoteMenuNEWItem()
			{
				return this.contextMenuMedicNoteMenuNEWItem;
			}
			private MenuItem contextMenuMedicNoteMenuNEWItem;
			public ReadOnlyMenuItem getMedicNoteMenuEDITItem()
			{
				return this.contextMenuMedicNoteMenuEDITItem;
			}
			private MenuItem contextMenuMedicNoteMenuEDITItem;
			public ReadOnlyMenuItem getMedicNoteMenuRIEItem()
			{
				return this.contextMenuMedicNoteMenuRIEItem;
			}
			private MenuItem contextMenuMedicNoteMenuRIEItem;
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
			IReportField[] fields = new IReportField[86];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Emergency.MedicNote", "BO-1086100015-ID", "ID_MedicNotes");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Emergency.MedicNote", "BO-1086100015-PATIENT", "Patient");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Emergency.MedicNote", "BO-1086100015-EPISODE", "Episode");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Emergency.MedicNote", "BO-1086100015-ATTENDANCE", "Attendance");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Emergency.MedicNote", "BO-1086100015-MEDICNOTE", "MedicNote");
			fields[76] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__Patient_" + componentIdentifier, "BO-1001100000-ID", "ID_Patient");
			fields[77] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__EpisodeOfCare_" + componentIdentifier, "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__CareContext_" + componentIdentifier, "BO-1004100019-ID", "ID_CareContext");
			fields[79] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__RIERecord_" + componentIdentifier, "BO-1086100015-ID", "ID_MedicNotes");
			fields[80] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__RIERecord_" + componentIdentifier, "BO-1086100015-PATIENT", "Patient");
			fields[81] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__RIERecord_" + componentIdentifier, "BO-1086100015-EPISODE", "Episode");
			fields[82] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__RIERecord_" + componentIdentifier, "BO-1086100015-ATTENDANCE", "Attendance");
			fields[83] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__RIERecord_" + componentIdentifier, "BO-1086100015-MEDICNOTE", "MedicNote");
			fields[84] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__ClinicalProblem_" + componentIdentifier, "BO-1073100005-ID", "ID_ClinicalProblem");
			fields[85] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.MedicNotes.__internal_x_context__LoggedHCP_" + componentIdentifier, "BO-1006100000-ID", "ID_Hcp");
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
