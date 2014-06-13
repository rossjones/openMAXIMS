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

package ims.emergency.forms.edwhiteboarddialog;

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
	public static class cmbStatusComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.emergency.vo.lookups.TrackingStatus value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.emergency.vo.lookups.TrackingStatus value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.emergency.vo.lookups.TrackingStatus value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.emergency.vo.lookups.TrackingStatus value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.emergency.vo.lookups.TrackingStatus value)
		{
			return super.control.removeRow(value);
		}
		public ims.emergency.vo.lookups.TrackingStatus getValue()
		{
			return (ims.emergency.vo.lookups.TrackingStatus)super.control.getValue();
		}
		public void setValue(ims.emergency.vo.lookups.TrackingStatus value)
		{
			super.control.setValue(value);
		}
	}
	public static class cmbAreaComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.emergency.vo.TrackingAreaShortVo value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.emergency.vo.TrackingAreaShortVo value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.emergency.vo.TrackingAreaShortVo value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.emergency.vo.TrackingAreaShortVo value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.emergency.vo.TrackingAreaShortVo value)
		{
			return super.control.removeRow(value);
		}
		public ims.emergency.vo.TrackingAreaShortVo getValue()
		{
			return (ims.emergency.vo.TrackingAreaShortVo)super.control.getValue();
		}
		public void setValue(ims.emergency.vo.TrackingAreaShortVo value)
		{
			super.control.setValue(value);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
		if(!context.isValidContextType(ims.core.vo.CareContextShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.CareContextShortVo' of the global context variable 'Core.CurrentCareContext' is not supported.");
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(1280, 800);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 256, 8, 97, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Tracking Status:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 40, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Areas:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 520, 768, 120, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 7), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, " Seen/Complete", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 248, 768, 136, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Assessment Details", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 392, 768, 120, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, " Allocate Cubicle", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 904, 768, 120, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 10), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, " Move", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 776, 768, 120, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 9), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, " Pat Status", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 648, 768, 120, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 8), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, " Result", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 352, 8, 176, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbStatusTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.FALSE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbStatusTemp);
		cmbStatusComboBox cmbStatus = (cmbStatusComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbStatusComboBox.class, m_cmbStatusTemp);
		super.addComboBox(cmbStatus);
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 48, 8, 176, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbAreaTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1009), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.FALSE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbAreaTemp);
		cmbAreaComboBox cmbArea = (cmbAreaComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbAreaComboBox.class, m_cmbAreaTemp);
		super.addComboBox(cmbArea);

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper11 = new RuntimeAnchoring(designSize, runtimeSize, 8, 40, 1264, 720, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1010), new Integer(anchoringHelper11.getX()), new Integer(anchoringHelper11.getY()), new Integer(anchoringHelper11.getWidth()), new Integer(anchoringHelper11.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, null, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE}));

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper12 = new RuntimeAnchoring(designSize, runtimeSize, 1242, 3, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1011), new Integer(anchoringHelper12.getX()), new Integer(anchoringHelper12.getY()), new Integer(anchoringHelper12.getWidth()), new Integer(anchoringHelper12.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.TimerStartEnabled24, this.getImages().Core.TimerStartDisabled24, "Search for results matching 'Search Criteria'", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Button btnSeenCompleteHCP()
	{
		return (Button)super.getControl(2);
	}
	public Button btnAssessmentDetails()
	{
		return (Button)super.getControl(3);
	}
	public Button btnAllocatedCubicle()
	{
		return (Button)super.getControl(4);
	}
	public Button btnMove()
	{
		return (Button)super.getControl(5);
	}
	public Button btnPatStatus()
	{
		return (Button)super.getControl(6);
	}
	public Button btnResult()
	{
		return (Button)super.getControl(7);
	}
	public cmbStatusComboBox cmbStatus()
	{
		return (cmbStatusComboBox)super.getComboBox(0);
	}
	public cmbAreaComboBox cmbArea()
	{
		return (cmbAreaComboBox)super.getComboBox(1);
	}
	public DynamicGrid dyngrdWhiteBoard()
	{
		return (DynamicGrid)super.getControl(10);
	}
	public ImageButton imbRefresh()
	{
		return (ImageButton)super.getControl(11);
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
			Emergency = new EmergencyForms();
		}
		public final class EmergencyForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private EmergencyForms()
			{
				AttendanceClinicalNoteDialog = new LocalFormName(129190);
				EDWhiteBoardEditDialog = new LocalFormName(129206);
				EDWhiteBoardDialog = new LocalFormName(129203);
				AllocateCubicle = new LocalFormName(129132);
				EDAssessmentDialog = new LocalFormName(129184);
				EDSeenByAndCompleteDialog = new LocalFormName(129191);
				TrackingStatusDialog = new LocalFormName(129153);
				AttendanceResultListDialog = new LocalFormName(129166);
				SendToAreaDialog = new LocalFormName(129121);
			}
			public final FormName AttendanceClinicalNoteDialog;
			public final FormName EDWhiteBoardEditDialog;
			public final FormName EDWhiteBoardDialog;
			public final FormName AllocateCubicle;
			public final FormName EDAssessmentDialog;
			public final FormName EDSeenByAndCompleteDialog;
			public final FormName TrackingStatusDialog;
			public final FormName AttendanceResultListDialog;
			public final FormName SendToAreaDialog;
		}

		public EmergencyForms Emergency;
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
			Correspondence = new CorrespondenceImages();
			Emergency = new EmergencyImages();
			Nursing = new NursingImages();
			Assessment = new AssessmentImages();
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				TimerStartEnabled24 = new ImageHelper(102308, "Images/Core/sinc_24x24.png", new Integer(24), new Integer(24));
				CriticalError = new ImageHelper(102250, "Images/Core/CriticalError.gif", new Integer(16), new Integer(16));
				TimerStartDisabled24 = new ImageHelper(102310, "Images/Core/sinc_disabled_24x24.png", new Integer(24), new Integer(24));
				NoPatientImage = new ImageHelper(102554, "Images/Core/silhouette_blue.png", new Integer(177), new Integer(177));
				Alert48 = new ImageHelper(102342, "Images/Core/Alert_48.png", new Integer(48), new Integer(48));
				Allergies48 = new ImageHelper(102542, "Images/Core/infirmary_48_new.png", new Integer(48), new Integer(48));
				Memo = new ImageHelper(102136, "Images/Core/memo.GIF", new Integer(17), new Integer(17));
			}
			public final ims.framework.utils.Image TimerStartEnabled24;
			public final ims.framework.utils.Image CriticalError;
			public final ims.framework.utils.Image TimerStartDisabled24;
			public final ims.framework.utils.Image NoPatientImage;
			public final ims.framework.utils.Image Alert48;
			public final ims.framework.utils.Image Allergies48;
			public final ims.framework.utils.Image Memo;
		}
		public final class CorrespondenceImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CorrespondenceImages()
			{
				NoLetterRequired = new ImageHelper(111104, "Images/Correspondence/cancel.gif", new Integer(16), new Integer(16));
				PatientDocumentCreated16 = new ImageHelper(111150, "Images/Correspondence/new_patient_document.png", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image NoLetterRequired;
			public final ims.framework.utils.Image PatientDocumentCreated16;
		}
		public final class EmergencyImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private EmergencyImages()
			{
				RefreshEnabled16 = new ImageHelper(129110, "Images/Emergency/sinc_16x16.png", new Integer(16), new Integer(16));
				Female = new ImageHelper(129138, "Images/Emergency/female.png", new Integer(48), new Integer(48));
				Male = new ImageHelper(129137, "Images/Emergency/male.png", new Integer(48), new Integer(48));
				EvenHistoryEnabled16 = new ImageHelper(129101, "Images/Emergency/clock.gif", new Integer(16), new Integer(16));
				ALLOCATECUBICLE16 = new ImageHelper(129143, "Images/Emergency/AllocateCubicle16.png", new Integer(16), new Integer(16));
				ASSESSMNTDETAILS16 = new ImageHelper(129144, "Images/Emergency/AssessmentDetails16.png", new Integer(16), new Integer(16));
				MOVE16 = new ImageHelper(129151, "Images/Emergency/Move16.png", new Integer(16), new Integer(16));
				PATIENTSTATUS16 = new ImageHelper(129153, "Images/Emergency/PatientStatus.png", new Integer(16), new Integer(16));
				RESULTS16 = new ImageHelper(129156, "Images/Emergency/Results16.png", new Integer(16), new Integer(16));
				SEENCOMPLETE16 = new ImageHelper(129157, "Images/Emergency/SeenComplete16.png", new Integer(16), new Integer(16));
				Risk24 = new ImageHelper(129164, "Images/Emergency/Risk24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image RefreshEnabled16;
			public final ims.framework.utils.Image Female;
			public final ims.framework.utils.Image Male;
			public final ims.framework.utils.Image EvenHistoryEnabled16;
			public final ims.framework.utils.Image ALLOCATECUBICLE16;
			public final ims.framework.utils.Image ASSESSMNTDETAILS16;
			public final ims.framework.utils.Image MOVE16;
			public final ims.framework.utils.Image PATIENTSTATUS16;
			public final ims.framework.utils.Image RESULTS16;
			public final ims.framework.utils.Image SEENCOMPLETE16;
			public final ims.framework.utils.Image Risk24;
		}
		public final class NursingImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private NursingImages()
			{
				FallAssessment24 = new ImageHelper(100167, "Images/Nursing/project_down_24.png", new Integer(24), new Integer(24));
				WaterlowView24 = new ImageHelper(100165, "Images/Nursing/waterlow_view_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image FallAssessment24;
			public final ims.framework.utils.Image WaterlowView24;
		}
		public final class AssessmentImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AssessmentImages()
			{
				Assessment24 = new ImageHelper(127119, "Images/Assessment/Assessment_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image Assessment24;
		}
		public final CoreImages Core;
		public final CorrespondenceImages Correspondence;
		public final EmergencyImages Emergency;
		public final NursingImages Nursing;
		public final AssessmentImages Assessment;
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
			cxl_PatientImagesList = new ims.framework.ContextVariable("PatientImagesList", prefix + "_lv_Emergency.EDWhiteBoardDialog.__internal_x_context__PatientImagesList_" + componentIdentifier + "");
			cxl_SelectedComboValue = new ims.framework.ContextVariable("SelectedComboValue", prefix + "_lv_Emergency.EDWhiteBoardDialog.__internal_x_context__SelectedComboValue_" + componentIdentifier + "");
			cxl_SelectedEvent = new ims.framework.ContextVariable("SelectedEvent", prefix + "_lv_Emergency.EDWhiteBoardDialog.__internal_x_context__SelectedEvent_" + componentIdentifier + "");
		}
		
		public boolean getPatientImagesListIsNotNull()
		{
			return !cxl_PatientImagesList.getValueIsNull(context);
		}
		public java.util.List<String> getPatientImagesList()
		{
			return (java.util.List<String>)cxl_PatientImagesList.getValue(context);
		}
		public void setPatientImagesList(java.util.List<String> value)
		{
			cxl_PatientImagesList.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_PatientImagesList = null;
		public boolean getSelectedComboValueIsNotNull()
		{
			return !cxl_SelectedComboValue.getValueIsNull(context);
		}
		public ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues getSelectedComboValue()
		{
			return (ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues)cxl_SelectedComboValue.getValue(context);
		}
		public void setSelectedComboValue(ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues value)
		{
			cxl_SelectedComboValue.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedComboValue = null;
		public boolean getSelectedEventIsNotNull()
		{
			return !cxl_SelectedEvent.getValueIsNull(context);
		}
		public ims.emergency.vo.enums.EDWhiteBoardEvent getSelectedEvent()
		{
			return (ims.emergency.vo.enums.EDWhiteBoardEvent)cxl_SelectedEvent.getValue(context);
		}
		public void setSelectedEvent(ims.emergency.vo.enums.EDWhiteBoardEvent value)
		{
			cxl_SelectedEvent.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedEvent = null;
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
			IReportField[] fields = new IReportField[72];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Emergency.Tracking", "BO-1086100005-ID", "ID_Tracking");
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
