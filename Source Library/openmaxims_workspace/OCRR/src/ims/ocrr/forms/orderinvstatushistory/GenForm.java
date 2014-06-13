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

package ims.ocrr.forms.orderinvstatushistory;

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
	public static class cmbInvestigationComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.ocrr.vo.OcsPathRadResultVo value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.ocrr.vo.OcsPathRadResultVo value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.ocrr.vo.OcsPathRadResultVo value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.ocrr.vo.OcsPathRadResultVo value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.ocrr.vo.OcsPathRadResultVo value)
		{
			return super.control.removeRow(value);
		}
		public ims.ocrr.vo.OcsPathRadResultVo getValue()
		{
			return (ims.ocrr.vo.OcsPathRadResultVo)super.control.getValue();
		}
		public void setValue(ims.ocrr.vo.OcsPathRadResultVo value)
		{
			super.control.setValue(value);
		}
	}
	public static class grdHistoryRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdHistoryRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setColDateTimeReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isColDateTimeReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showColDateTimeOpened()
		{
			super.row.showOpened(0);
		}
		public void setTooltipForColDateTime(String value)
		{
			super.row.setTooltip(0, value);
		}
		public String getColDateTime()
		{
			return (String)super.row.get(0);
		}
		public void setColDateTime(String value)
		{
			super.row.set(0, value);
		}
		public void setCellColDateTimeTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setprocessedDateTimeReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean isprocessedDateTimeReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showprocessedDateTimeOpened()
		{
			super.row.showOpened(1);
		}
		public void setTooltipForprocessedDateTime(String value)
		{
			super.row.setTooltip(1, value);
		}
		public String getprocessedDateTime()
		{
			return (String)super.row.get(1);
		}
		public void setprocessedDateTime(String value)
		{
			super.row.set(1, value);
		}
		public void setCellprocessedDateTimeTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setColUserReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean isColUserReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showColUserOpened()
		{
			super.row.showOpened(2);
		}
		public void setTooltipForColUser(String value)
		{
			super.row.setTooltip(2, value);
		}
		public String getColUser()
		{
			return (String)super.row.get(2);
		}
		public void setColUser(String value)
		{
			super.row.set(2, value);
		}
		public void setCellColUserTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public void setColStatusReadOnly(boolean value)
		{
			super.row.setReadOnly(3, value);
		}
		public boolean isColStatusReadOnly()
		{
			return super.row.isReadOnly(3);
		}
		public void showColStatusOpened()
		{
			super.row.showOpened(3);
		}
		public void setTooltipForColStatus(String value)
		{
			super.row.setTooltip(3, value);
		}
		public String getColStatus()
		{
			return (String)super.row.get(3);
		}
		public void setColStatus(String value)
		{
			super.row.set(3, value);
		}
		public void setCellColStatusTooltip(String value)
		{
			super.row.setTooltip(3, value);
		}
		public void setColReasonReadOnly(boolean value)
		{
			super.row.setReadOnly(4, value);
		}
		public boolean isColReasonReadOnly()
		{
			return super.row.isReadOnly(4);
		}
		public void showColReasonOpened()
		{
			super.row.showOpened(4);
		}
		public void setTooltipForColReason(String value)
		{
			super.row.setTooltip(4, value);
		}
		public String getColReason()
		{
			return (String)super.row.get(4);
		}
		public void setColReason(String value)
		{
			super.row.set(4, value);
		}
		public void setCellColReasonTooltip(String value)
		{
			super.row.setTooltip(4, value);
		}
		public ims.ocrr.vo.OrderedInvestigationStatusVo getValue()
		{
			return (ims.ocrr.vo.OrderedInvestigationStatusVo)super.row.getValue();
		}
		public void setValue(ims.ocrr.vo.OrderedInvestigationStatusVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdHistoryRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdHistoryRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdHistoryRow get(int index)
		{
			return new grdHistoryRow(super.collection.get(index));
		}
		public grdHistoryRow newRow()
		{
			return new grdHistoryRow(super.collection.newRow());
		}
		public grdHistoryRow newRow(boolean autoSelect)
		{
			return new grdHistoryRow(super.collection.newRow(autoSelect));
		}
		public grdHistoryRow newRowAt(int index)
		{
			return new grdHistoryRow(super.collection.newRowAt(index));
		}
		public grdHistoryRow newRowAt(int index, boolean autoSelect)
		{
			return new grdHistoryRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdHistoryGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public ims.ocrr.vo.OrderedInvestigationStatusVoCollection getValues()
		{
			ims.ocrr.vo.OrderedInvestigationStatusVoCollection listOfValues = new ims.ocrr.vo.OrderedInvestigationStatusVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.ocrr.vo.OrderedInvestigationStatusVo getValue()
		{
			return (ims.ocrr.vo.OrderedInvestigationStatusVo)super.grid.getValue();
		}
		public void setValue(ims.ocrr.vo.OrderedInvestigationStatusVo value)
		{
			super.grid.setValue(value);
		}
		public grdHistoryRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdHistoryRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdHistoryRowCollection getRows()
		{
			return new grdHistoryRowCollection(super.grid.getRows());
		}
		public grdHistoryRow getRowByValue(ims.ocrr.vo.OrderedInvestigationStatusVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdHistoryRow(row);
		}
		public void setColDateTimeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getColDateTimeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setprocessedDateTimeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getprocessedDateTimeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setColUserHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getColUserHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
		public void setColStatusHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(3, value);
		}
		public String getColStatusHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(3);
		}
		public void setColReasonHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(4, value);
		}
		public String getColReasonHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(4);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	private void validateMandatoryContext(Context context)
	{
		if(new ims.framework.ContextVariable("OCRR.SelectedInvs", "_cv_OCRR.SelectedInvs").getValueIsNull(context))
			throw new ims.framework.exceptions.FormMandatoryContextMissingException("The required context data 'OCRR.SelectedInvs' is not available.");
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
			validateMandatoryContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(728, 440);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 24, 16, 88, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Investigation :", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 20, 400, 200, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Reset Result Status to New", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 634, 400, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Close", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 120, 16, 592, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbInvestigationTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbInvestigationTemp);
		cmbInvestigationComboBox cmbInvestigation = (cmbInvestigationComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbInvestigationComboBox.class, m_cmbInvestigationTemp);
		super.addComboBox(cmbInvestigation);

		// Grid Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 20, 56, 692, 336, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdHistoryTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.FALSE, Boolean.FALSE, new Integer(24), Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdHistoryTemp);
		grdHistoryGrid grdHistory = (grdHistoryGrid)GridFlyweightFactory.getInstance().createGridBridge(grdHistoryGrid.class, m_grdHistoryTemp);
		grdHistory.addStringColumn("Date / Time", 0, 0, 115, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdHistory.addStringColumn("Processed", 0, 0, 115, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdHistory.addStringColumn("User", 0, 0, 140, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdHistory.addStringColumn("Status", 0, 0, 160, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdHistory.addStringColumn("Reason", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdHistory);
	}


	public Button btnReset()
	{
		return (Button)super.getControl(1);
	}
	public Button btnClose()
	{
		return (Button)super.getControl(2);
	}
	public cmbInvestigationComboBox cmbInvestigation()
	{
		return (cmbInvestigationComboBox)super.getComboBox(0);
	}
	public grdHistoryGrid grdHistory()
	{
		return (grdHistoryGrid)super.getGrid(0);
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
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
			IReportField[] fields = new IReportField[71];
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
