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

package ims.core.forms.uploaddocument;

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
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.CareContextShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.CareContextShortVo' of the global context variable 'Core.CurrentCareContext' is not supported.");
		if(!context.isValidContextType(Boolean.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'Boolean' of the global context variable 'CareUk.IsProviderCancellation' is not supported.");
		if(!context.isValidContextType(ims.core.vo.EpisodeofCareShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.EpisodeofCareShortVo' of the global context variable 'Core.EpisodeofCareShort' is not supported.");
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
		if(!context.isValidContextType(ims.careuk.vo.CatsReferralRefVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.careuk.vo.CatsReferralRefVo' of the global context variable 'CareUk.CatsReferral' is not supported.");
	}
	public boolean supportsRecordedInError()
	{
		return true;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return this.getLocalContext().getSelectedRecord();
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(680, 640);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Panel Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 664, 624, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(Panel.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,"Current Documents", new Integer(2), ""}));

		// Button Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 600, 64, 59, 23, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.HIDDEN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, "Import", Boolean.TRUE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 600, 32, 59, 23, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.HIDDEN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, "Scan", Boolean.TRUE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 16, 32, 576, 579, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, null, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}
	public Button btnImport()
	{
		return (Button)super.getControl(1);
	}
	public Button btnScan()
	{
		return (Button)super.getControl(2);
	}
	public DynamicGrid dyngrd()
	{
		return (DynamicGrid)super.getControl(3);
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
				UploadDocumentDialog = new LocalFormName(102268);
				DocumentPreview = new LocalFormName(102367);
			}
			public final FormName UploadDocumentDialog;
			public final FormName DocumentPreview;
		}

		public CoreForms Core;
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
			cxl_ServerDocuments = new ims.framework.ContextVariable("ServerDocuments", prefix + "_lv_Core.UploadDocument.__internal_x_context__ServerDocuments_" + componentIdentifier + "");
			cxl_DisplayDocument = new ims.framework.ContextVariable("DisplayDocument", prefix + "_lv_Core.UploadDocument.__internal_x_context__DisplayDocument_" + componentIdentifier + "");
			cxl_IntitializeType = new ims.framework.ContextVariable("IntitializeType", prefix + "_lv_Core.UploadDocument.__internal_x_context__IntitializeType_" + componentIdentifier + "");
			cxl_DocumentCategory = new ims.framework.ContextVariable("DocumentCategory", prefix + "_lv_Core.UploadDocument.__internal_x_context__DocumentCategory_" + componentIdentifier + "");
			cxl_CatsReferralRef = new ims.framework.ContextVariable("CatsReferralRef", prefix + "_lv_Core.UploadDocument.__internal_x_context__CatsReferralRef_" + componentIdentifier + "");
			cxl_IsGPLetterSelected = new ims.framework.ContextVariable("IsGPLetterSelected", prefix + "_lv_Core.UploadDocument.__internal_x_context__IsGPLetterSelected_" + componentIdentifier + "");
			cxl_IsGPLetterCategory = new ims.framework.ContextVariable("IsGPLetterCategory", prefix + "_lv_Core.UploadDocument.__internal_x_context__IsGPLetterCategory_" + componentIdentifier + "");
			cxl_SelectedRecord = new ims.framework.ContextVariable("SelectedRecord", prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier + "");
			cxl_UploadDocumentStoreLevel = new ims.framework.ContextVariable("UploadDocumentStoreLevel", prefix + "_lv_Core.UploadDocument.__internal_x_context__UploadDocumentStoreLevel_" + componentIdentifier + "");
			cxl_DocumentViewLevel = new ims.framework.ContextVariable("DocumentViewLevel", prefix + "_lv_Core.UploadDocument.__internal_x_context__DocumentViewLevel_" + componentIdentifier + "");
		}
		
		public boolean getServerDocumentsIsNotNull()
		{
			return !cxl_ServerDocuments.getValueIsNull(context);
		}
		public ims.core.vo.ServerDocumentVoCollection getServerDocuments()
		{
			return (ims.core.vo.ServerDocumentVoCollection)cxl_ServerDocuments.getValue(context);
		}
		public void setServerDocuments(ims.core.vo.ServerDocumentVoCollection value)
		{
			cxl_ServerDocuments.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ServerDocuments = null;
		public boolean getDisplayDocumentIsNotNull()
		{
			return !cxl_DisplayDocument.getValueIsNull(context);
		}
		public String getDisplayDocument()
		{
			return (String)cxl_DisplayDocument.getValue(context);
		}
		public void setDisplayDocument(String value)
		{
			cxl_DisplayDocument.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_DisplayDocument = null;
		public boolean getIntitializeTypeIsNotNull()
		{
			return !cxl_IntitializeType.getValueIsNull(context);
		}
		public Integer getIntitializeType()
		{
			return (Integer)cxl_IntitializeType.getValue(context);
		}
		public void setIntitializeType(Integer value)
		{
			cxl_IntitializeType.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_IntitializeType = null;
		public boolean getDocumentCategoryIsNotNull()
		{
			return !cxl_DocumentCategory.getValueIsNull(context);
		}
		public ims.core.vo.lookups.DocumentCategory getDocumentCategory()
		{
			return (ims.core.vo.lookups.DocumentCategory)cxl_DocumentCategory.getValue(context);
		}
		public void setDocumentCategory(ims.core.vo.lookups.DocumentCategory value)
		{
			cxl_DocumentCategory.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_DocumentCategory = null;
		public boolean getCatsReferralRefIsNotNull()
		{
			return !cxl_CatsReferralRef.getValueIsNull(context);
		}
		public ims.careuk.vo.CatsReferralRefVo getCatsReferralRef()
		{
			return (ims.careuk.vo.CatsReferralRefVo)cxl_CatsReferralRef.getValue(context);
		}
		public void setCatsReferralRef(ims.careuk.vo.CatsReferralRefVo value)
		{
			if(value != null && (value.getBoId() == null || value.getBoId().intValue() < 1))
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid domain object id for 'CatsReferralRef' RefVo context variable.");
			if(value == null)
				cxl_CatsReferralRef.setValue(context, null);
			else
				cxl_CatsReferralRef.setValue(context, new ims.careuk.vo.CatsReferralRefVo(value.getBoId(), value.getBoVersion()));
		}
		private ims.framework.ContextVariable cxl_CatsReferralRef = null;
		public boolean getIsGPLetterSelectedIsNotNull()
		{
			return !cxl_IsGPLetterSelected.getValueIsNull(context);
		}
		public Boolean getIsGPLetterSelected()
		{
			return (Boolean)cxl_IsGPLetterSelected.getValue(context);
		}
		public void setIsGPLetterSelected(Boolean value)
		{
			cxl_IsGPLetterSelected.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_IsGPLetterSelected = null;
		public boolean getIsGPLetterCategoryIsNotNull()
		{
			return !cxl_IsGPLetterCategory.getValueIsNull(context);
		}
		public Boolean getIsGPLetterCategory()
		{
			return (Boolean)cxl_IsGPLetterCategory.getValue(context);
		}
		public void setIsGPLetterCategory(Boolean value)
		{
			cxl_IsGPLetterCategory.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_IsGPLetterCategory = null;
		public boolean getSelectedRecordIsNotNull()
		{
			return !cxl_SelectedRecord.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentVo getSelectedRecord()
		{
			return (ims.core.vo.PatientDocumentVo)cxl_SelectedRecord.getValue(context);
		}
		public void setSelectedRecord(ims.core.vo.PatientDocumentVo value)
		{
			cxl_SelectedRecord.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedRecord = null;
		public boolean getUploadDocumentStoreLevelIsNotNull()
		{
			return !cxl_UploadDocumentStoreLevel.getValueIsNull(context);
		}
		public ims.core.vo.enums.UploadDocumentStoreLevel getUploadDocumentStoreLevel()
		{
			return (ims.core.vo.enums.UploadDocumentStoreLevel)cxl_UploadDocumentStoreLevel.getValue(context);
		}
		public void setUploadDocumentStoreLevel(ims.core.vo.enums.UploadDocumentStoreLevel value)
		{
			cxl_UploadDocumentStoreLevel.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_UploadDocumentStoreLevel = null;
		public boolean getDocumentViewLevelIsNotNull()
		{
			return !cxl_DocumentViewLevel.getValueIsNull(context);
		}
		public ims.core.vo.enums.DocumentViewLevel getDocumentViewLevel()
		{
			return (ims.core.vo.enums.DocumentViewLevel)cxl_DocumentViewLevel.getValue(context);
		}
		public void setDocumentViewLevel(ims.core.vo.enums.DocumentViewLevel value)
		{
			cxl_DocumentViewLevel.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_DocumentViewLevel = null;
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
			IReportField[] fields = new IReportField[128];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-ID", "ID_PatientDocument");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-PATIENT", "Patient");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-EPISODEOFCARE", "EpisodeofCare");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-CARECONTEXT", "CareContext");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-CLINICALCONTACT", "ClinicalContact");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-REFERRAL", "Referral");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-NAME", "Name");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-CREATIONTYPE", "CreationType");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-CATEGORY", "Category");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-STATUS", "Status");
			fields[81] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-RECORDINGUSER", "RecordingUser");
			fields[82] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-RECORDINGDATETIME", "RecordingDateTime");
			fields[83] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-AUTHORINGHCP", "AuthoringHCP");
			fields[84] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-AUTHORINGDATETIME", "AuthoringDateTime");
			fields[85] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-SPECIALTY", "Specialty");
			fields[86] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-CORRESPONDENCESTATUS", "CorrespondenceStatus");
			fields[87] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-DOCUMENTDATE", "DocumentDate");
			fields[88] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-CLINIC", "Clinic");
			fields[89] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-ISLOCKEDFOREDITING", "IsLockedForEditing");
			fields[90] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-LOCKEDBYUSER", "LockedByUser");
			fields[91] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-LOCKEDONDATETIME", "LockedOnDateTime");
			fields[92] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[93] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-NOOFCOPIES", "NoOfCopies");
			fields[94] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-HISTORICALFILENAME", "HistoricalFileName");
			fields[95] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-HISTORICDOCID", "HistoricDocId");
			fields[96] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-WASPRINTED", "WasPrinted");
			fields[97] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-EMAILSTATUS", "EmailStatus");
			fields[98] = new ims.framework.ReportField(this.context, "_cv_Core.PatientDocument", "BO-1068100001-COPYPATIENTONCORRESPONDENCE", "CopyPatientOnCorrespondence");
			fields[99] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__CatsReferralRef_" + componentIdentifier, "BO-1004100035-ID", "ID_CatsReferral");
			fields[100] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-ID", "ID_PatientDocument");
			fields[101] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-PATIENT", "Patient");
			fields[102] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-EPISODEOFCARE", "EpisodeofCare");
			fields[103] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-CARECONTEXT", "CareContext");
			fields[104] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-CLINICALCONTACT", "ClinicalContact");
			fields[105] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-REFERRAL", "Referral");
			fields[106] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-NAME", "Name");
			fields[107] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-CREATIONTYPE", "CreationType");
			fields[108] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-CATEGORY", "Category");
			fields[109] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-STATUS", "Status");
			fields[110] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-RECORDINGUSER", "RecordingUser");
			fields[111] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-RECORDINGDATETIME", "RecordingDateTime");
			fields[112] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-AUTHORINGHCP", "AuthoringHCP");
			fields[113] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-AUTHORINGDATETIME", "AuthoringDateTime");
			fields[114] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-SPECIALTY", "Specialty");
			fields[115] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-CORRESPONDENCESTATUS", "CorrespondenceStatus");
			fields[116] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-DOCUMENTDATE", "DocumentDate");
			fields[117] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-CLINIC", "Clinic");
			fields[118] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-ISLOCKEDFOREDITING", "IsLockedForEditing");
			fields[119] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-LOCKEDBYUSER", "LockedByUser");
			fields[120] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-LOCKEDONDATETIME", "LockedOnDateTime");
			fields[121] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[122] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-NOOFCOPIES", "NoOfCopies");
			fields[123] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-HISTORICALFILENAME", "HistoricalFileName");
			fields[124] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-HISTORICDOCID", "HistoricDocId");
			fields[125] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-WASPRINTED", "WasPrinted");
			fields[126] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-EMAILSTATUS", "EmailStatus");
			fields[127] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.UploadDocument.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1068100001-COPYPATIENTONCORRESPONDENCE", "CopyPatientOnCorrespondence");
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
