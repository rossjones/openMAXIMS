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

package ims.core.forms.reporttemplatesearch;

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
	public static class grdResultRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdResultRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolReportReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolReportReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolReportOpened()
		{
			super.row.showOpened(0);
		}
		public String getcolReport()
		{
			return (String)super.row.get(0);
		}
		public void setcolReport(String value)
		{
			super.row.set(0, value);
		}
		public void setCellcolReportTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setcolTemplateReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean iscolTemplateReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showcolTemplateOpened()
		{
			super.row.showOpened(1);
		}
		public String getcolTemplate()
		{
			return (String)super.row.get(1);
		}
		public void setcolTemplate(String value)
		{
			super.row.set(1, value);
		}
		public void setCellcolTemplateTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public ims.core.vo.TemplateForReportTemplateSearchVo getValue()
		{
			return (ims.core.vo.TemplateForReportTemplateSearchVo)super.row.getValue();
		}
		public void setValue(ims.core.vo.TemplateForReportTemplateSearchVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdResultRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdResultRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdResultRow get(int index)
		{
			return new grdResultRow(super.collection.get(index));
		}
		public grdResultRow newRow()
		{
			return new grdResultRow(super.collection.newRow());
		}
		public grdResultRow newRow(boolean autoSelect)
		{
			return new grdResultRow(super.collection.newRow(autoSelect));
		}
		public grdResultRow newRowAt(int index)
		{
			return new grdResultRow(super.collection.newRowAt(index));
		}
		public grdResultRow newRowAt(int index, boolean autoSelect)
		{
			return new grdResultRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdResultGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public ims.core.vo.TemplateForReportTemplateSearchVoCollection getValues()
		{
			ims.core.vo.TemplateForReportTemplateSearchVoCollection listOfValues = new ims.core.vo.TemplateForReportTemplateSearchVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.core.vo.TemplateForReportTemplateSearchVo getValue()
		{
			return (ims.core.vo.TemplateForReportTemplateSearchVo)super.grid.getValue();
		}
		public void setValue(ims.core.vo.TemplateForReportTemplateSearchVo value)
		{
			super.grid.setValue(value);
		}
		public grdResultRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdResultRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdResultRowCollection getRows()
		{
			return new grdResultRowCollection(super.grid.getRows());
		}
		public grdResultRow getRowByValue(ims.core.vo.TemplateForReportTemplateSearchVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdResultRow(row);
		}
		public void setcolReportHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolReportHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setcolTemplateHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getcolTemplateHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
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
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(360, 592);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Panel Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 6, 344, 586, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(Panel.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.ALL,"Template Search", new Integer(2), ""}));

		// Label Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 16, 58, 98, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Template Name:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 16, 32, 83, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Report Name:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 269, 86, 75, 23, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, "Search", Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 116, 56, 228, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,Boolean.FALSE, new Integer(255), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 116, 30, 228, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,Boolean.FALSE, new Integer(255), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// Grid Controls
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 16, 118, 328, 464, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdResultTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdResultTemp);
		grdResultGrid grdResult = (grdResultGrid)GridFlyweightFactory.getInstance().createGridBridge(grdResultGrid.class, m_grdResultTemp);
		grdResult.addStringColumn("Report", 0, 0, 120, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdResult.addStringColumn("Template", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdResult);
	}


	public Button btnSearch()
	{
		return (Button)super.getControl(3);
	}
	public TextBox txtTemplateName()
	{
		return (TextBox)super.getControl(4);
	}
	public TextBox txtReportName()
	{
		return (TextBox)super.getControl(5);
	}
	public grdResultGrid grdResult()
	{
		return (grdResultGrid)super.getGrid(0);
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
			cxl_selectedEvent = new ims.framework.ContextVariable("selectedEvent", prefix + "_lv_Core.ReportTemplateSearch.__internal_x_context__selectedEvent_" + componentIdentifier + "");
			cxl_selectedTemplate = new ims.framework.ContextVariable("selectedTemplate", prefix + "_lv_Core.ReportTemplateSearch.__internal_x_context__selectedTemplate_" + componentIdentifier + "");
		}
		
		public boolean getselectedEventIsNotNull()
		{
			return !cxl_selectedEvent.getValueIsNull(context);
		}
		public ims.core.vo.enums.ReportTemplateSearchEvent getselectedEvent()
		{
			return (ims.core.vo.enums.ReportTemplateSearchEvent)cxl_selectedEvent.getValue(context);
		}
		public void setselectedEvent(ims.core.vo.enums.ReportTemplateSearchEvent value)
		{
			cxl_selectedEvent.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_selectedEvent = null;
		public boolean getselectedTemplateIsNotNull()
		{
			return !cxl_selectedTemplate.getValueIsNull(context);
		}
		public ims.core.vo.TemplateForReportTemplateSearchVo getselectedTemplate()
		{
			return (ims.core.vo.TemplateForReportTemplateSearchVo)cxl_selectedTemplate.getValue(context);
		}
		public void setselectedTemplate(ims.core.vo.TemplateForReportTemplateSearchVo value)
		{
			cxl_selectedTemplate.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_selectedTemplate = null;
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
			IReportField[] fields = new IReportField[75];
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
			fields[71] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.ReportTemplateSearch.__internal_x_context__selectedTemplate_" + componentIdentifier, "BO-1004100008-ID", "ID_TemplateBo");
			fields[72] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.ReportTemplateSearch.__internal_x_context__selectedTemplate_" + componentIdentifier, "BO-1004100008-NAME", "Name");
			fields[73] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.ReportTemplateSearch.__internal_x_context__selectedTemplate_" + componentIdentifier, "BO-1004100008-DESCRIPTION", "Description");
			fields[74] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.ReportTemplateSearch.__internal_x_context__selectedTemplate_" + componentIdentifier, "BO-1004100008-ISACTIVE", "IsActive");
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
	private IReportField[] reportFields = null;
}
