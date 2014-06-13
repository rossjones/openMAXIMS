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

package ims.correspondence.forms.glossaryadminconfiguration;

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
	public static class ctnGlossaryContainer extends ContainerBridge
	{
		private static final long serialVersionUID = 1L;
		protected void setContext(Form form, ims.framework.interfaces.IAppForm appForm, Control control, FormLoader loader, Images form_images_local, ContextMenus contextMenus, Integer startControlID, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize, Integer startTabIndex, boolean skipContextValidation) throws Exception
		{
			if(form == null)
				throw new RuntimeException("Invalid form");
			if(appForm == null)
				throw new RuntimeException("Invalid application form");
			if(control == null); // this is to avoid eclipse warning only.
			if(loader == null); // this is to avoid eclipse warning only.
			if(form_images_local == null); // this is to avoid eclipse warning only.
			if(contextMenus == null); // this is to avoid eclipse warning only.
			if(startControlID == null)
				throw new RuntimeException("Invalid startControlID");
			if(designSize == null); // this is to avoid eclipse warning only.
			if(runtimeSize == null); // this is to avoid eclipse warning only.
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex");
	
	
			// Rich Text Controls
			RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 800, 136, ims.framework.enumerations.ControlAnchoring.ALL);
			super.addControl(factory.getControl(RichTextControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.ALL, Boolean.FALSE, Boolean.FALSE, new Integer(0)} ));
		}
		protected void setCollapsed(boolean value)
		{
			super.container.setCollapsed(value);
		}
		//protected boolean isCollapsed()
		//{
			//return super.container.isCollapsed();
		//}
		protected void setCaption(String value)
		{
			super.container.setCaption(value);
		}
		public RichTextControl richText()
		{
			return (RichTextControl)super.getControl(0);
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationADDItem = factory.createMenuItem(startControlID.intValue() + 1, "Add Profile", true, false, new Integer(102179), true, false);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration.add(contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationADDItem);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationADDGLOSSARYTEXTItem = factory.createMenuItem(startControlID.intValue() + 2, "Add Glossary Text", true, false, new Integer(102179), true, false);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration.add(contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationADDGLOSSARYTEXTItem);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationEDITGLOSSARYTEXTItem = factory.createMenuItem(startControlID.intValue() + 3, "Edit Glossary Text", true, false, new Integer(102150), true, false);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration.add(contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationEDITGLOSSARYTEXTItem);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationDELETEPROFILEItem = factory.createMenuItem(startControlID.intValue() + 4, "Remove", true, false, new Integer(102148), true, false);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration.add(contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationDELETEPROFILEItem);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem = factory.createMenuItem(startControlID.intValue() + 5, "Delete Glossary Text", true, false, new Integer(102148), true, false);
		contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration.add(contextMenus.Correspondence.contextMenuGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem);
		form.registerMenu(contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration);


		// Container Clasess
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 16, 416, 816, 168, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
		Container m_ctnGlossary = (Container)factory.getControl(Container.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT, "Glossary Text", new Boolean(true)});
		addControl(m_ctnGlossary);
		ctnGlossaryContainer ctnGlossary = (ctnGlossaryContainer)ContainerBridgeFlyweightFactory.getInstance().createContainerBridge(ctnGlossaryContainer.class, m_ctnGlossary, factory);
		ims.framework.utils.SizeInfo m_ctnGlossaryDesignSize = new ims.framework.utils.SizeInfo(816, 168);
		ims.framework.utils.SizeInfo m_ctnGlossaryRuntimeSize = new ims.framework.utils.SizeInfo(anchoringHelper2.getWidth(), anchoringHelper2.getHeight());
		ctnGlossary.setContext(form, appForm, m_ctnGlossary, loader, this.getImages(), contextMenus, startControlID, m_ctnGlossaryDesignSize, m_ctnGlossaryRuntimeSize, startTabIndex, skipContextValidation);
		super.addContainer(ctnGlossary);

		// Button Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 16, 592, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.HIDDEN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Edit", Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 674, 592, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Save", Boolean.FALSE, null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 754, 592, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 816, 392, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, contextMenus.Correspondence.contextMenuGlossaryAdminConfiguration, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE}));
	}



	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public ctnGlossaryContainer ctnGlossary()
	{
		return (ctnGlossaryContainer)super.getContainer(0);
	}
	public Button btnEdit()
	{
		return (Button)super.getControl(1);
	}
	public Button btnSave()
	{
		return (Button)super.getControl(2);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(3);
	}
	public DynamicGrid dyngrdGlossary()
	{
		return (DynamicGrid)super.getControl(4);
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
			Admin = new AdminImages();
			Core = new CoreImages();
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				Leaf = new ImageHelper(103101, "Images/Admin/Leaf.gif", new Integer(16), new Integer(16));
				MemberOfStaff = new ImageHelper(103133, "Images/Admin/User-Offline.gif", new Integer(16), new Integer(16));
				Service = new ImageHelper(103110, "Images/Admin/clinical_service.png", new Integer(16), new Integer(16));
				Specialty = new ImageHelper(103162, "Images/Admin/Specialies.jpg", new Integer(16), new Integer(16));
				Specialty2 = new ImageHelper(103163, "Images/Admin/Specialty.jpg", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image Leaf;
			public final ims.framework.utils.Image MemberOfStaff;
			public final ims.framework.utils.Image Service;
			public final ims.framework.utils.Image Specialty;
			public final ims.framework.utils.Image Specialty2;
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				TextBox = new ImageHelper(102240, "Images/Core/Textbox.gif", new Integer(16), new Integer(16));
				User = new ImageHelper(102316, "Images/Core/user.ico", new Integer(16), new Integer(16));
				Users = new ImageHelper(102317, "Images/Core/users.ico", new Integer(16), new Integer(16));
				BookOpenEnabled = new ImageHelper(102186, "Images/Core/Book-Open.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image TextBox;
			public final ims.framework.utils.Image User;
			public final ims.framework.utils.Image Users;
			public final ims.framework.utils.Image BookOpenEnabled;
		}
		public final AdminImages Admin;
		public final CoreImages Core;
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
			cxl_GlossaryCategoryColl = new ims.framework.ContextVariable("GlossaryCategoryColl", prefix + "_lv_Correspondence.GlossaryAdminConfiguration.__internal_x_context__GlossaryCategoryColl_" + componentIdentifier + "");
			cxl_ProfileTypeColl = new ims.framework.ContextVariable("ProfileTypeColl", prefix + "_lv_Correspondence.GlossaryAdminConfiguration.__internal_x_context__ProfileTypeColl_" + componentIdentifier + "");
			cxl_LastRecord = new ims.framework.ContextVariable("LastRecord", prefix + "_lv_Correspondence.GlossaryAdminConfiguration.__internal_x_context__LastRecord_" + componentIdentifier + "");
			cxl_GlossaryProfileForSave = new ims.framework.ContextVariable("GlossaryProfileForSave", prefix + "_lv_Correspondence.GlossaryAdminConfiguration.__internal_x_context__GlossaryProfileForSave_" + componentIdentifier + "");
			cxl_CanAddNewProfile = new ims.framework.ContextVariable("CanAddNewProfile", prefix + "_lv_Correspondence.GlossaryAdminConfiguration.__internal_x_context__CanAddNewProfile_" + componentIdentifier + "");
		}
		
		public boolean getGlossaryCategoryCollIsNotNull()
		{
			return !cxl_GlossaryCategoryColl.getValueIsNull(context);
		}
		public ims.correspondence.vo.lookups.GlossaryCategoryCollection getGlossaryCategoryColl()
		{
			return (ims.correspondence.vo.lookups.GlossaryCategoryCollection)cxl_GlossaryCategoryColl.getValue(context);
		}
		public void setGlossaryCategoryColl(ims.correspondence.vo.lookups.GlossaryCategoryCollection value)
		{
			cxl_GlossaryCategoryColl.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_GlossaryCategoryColl = null;
		public boolean getProfileTypeCollIsNotNull()
		{
			return !cxl_ProfileTypeColl.getValueIsNull(context);
		}
		public ims.correspondence.vo.lookups.ProfileTypeCollection getProfileTypeColl()
		{
			return (ims.correspondence.vo.lookups.ProfileTypeCollection)cxl_ProfileTypeColl.getValue(context);
		}
		public void setProfileTypeColl(ims.correspondence.vo.lookups.ProfileTypeCollection value)
		{
			cxl_ProfileTypeColl.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ProfileTypeColl = null;
		public boolean getLastRecordIsNotNull()
		{
			return !cxl_LastRecord.getValueIsNull(context);
		}
		public Object getLastRecord()
		{
			return cxl_LastRecord.getValue(context);
		}
		public void setLastRecord(Object value)
		{
			cxl_LastRecord.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_LastRecord = null;
		public boolean getGlossaryProfileForSaveIsNotNull()
		{
			return !cxl_GlossaryProfileForSave.getValueIsNull(context);
		}
		public ims.correspondence.vo.GlossaryProfileVoCollection getGlossaryProfileForSave()
		{
			return (ims.correspondence.vo.GlossaryProfileVoCollection)cxl_GlossaryProfileForSave.getValue(context);
		}
		public void setGlossaryProfileForSave(ims.correspondence.vo.GlossaryProfileVoCollection value)
		{
			cxl_GlossaryProfileForSave.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_GlossaryProfileForSave = null;
		public boolean getCanAddNewProfileIsNotNull()
		{
			return !cxl_CanAddNewProfile.getValueIsNull(context);
		}
		public Boolean getCanAddNewProfile()
		{
			return (Boolean)cxl_CanAddNewProfile.getValue(context);
		}
		public void setCanAddNewProfile(Boolean value)
		{
			cxl_CanAddNewProfile.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_CanAddNewProfile = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public CorrespondenceNamespace Correspondence = new CorrespondenceNamespace();
		public final class CorrespondenceNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class GlossaryAdminConfiguration implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int ADD = 1;
				public static final int ADDGLOSSARYTEXT = 2;
				public static final int EDITGLOSSARYTEXT = 3;
				public static final int DELETEPROFILE = 4;
				public static final int DELETEGLOSSARYTEXT = 5;
			}
			public void disableAllGlossaryAdminConfigurationMenuItems()
			{
				this.contextMenuGlossaryAdminConfigurationADDItem.setEnabled(false);
				this.contextMenuGlossaryAdminConfigurationADDGLOSSARYTEXTItem.setEnabled(false);
				this.contextMenuGlossaryAdminConfigurationEDITGLOSSARYTEXTItem.setEnabled(false);
				this.contextMenuGlossaryAdminConfigurationDELETEPROFILEItem.setEnabled(false);
				this.contextMenuGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem.setEnabled(false);
			}
			public void hideAllGlossaryAdminConfigurationMenuItems()
			{
				this.contextMenuGlossaryAdminConfigurationADDItem.setVisible(false);
				this.contextMenuGlossaryAdminConfigurationADDGLOSSARYTEXTItem.setVisible(false);
				this.contextMenuGlossaryAdminConfigurationEDITGLOSSARYTEXTItem.setVisible(false);
				this.contextMenuGlossaryAdminConfigurationDELETEPROFILEItem.setVisible(false);
				this.contextMenuGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem.setVisible(false);
			}
			private Menu contextMenuGlossaryAdminConfiguration;
			public ReadOnlyMenuItem getGlossaryAdminConfigurationADDItem()
			{
				return this.contextMenuGlossaryAdminConfigurationADDItem;
			}
			private MenuItem contextMenuGlossaryAdminConfigurationADDItem;
			public ReadOnlyMenuItem getGlossaryAdminConfigurationADDGLOSSARYTEXTItem()
			{
				return this.contextMenuGlossaryAdminConfigurationADDGLOSSARYTEXTItem;
			}
			private MenuItem contextMenuGlossaryAdminConfigurationADDGLOSSARYTEXTItem;
			public ReadOnlyMenuItem getGlossaryAdminConfigurationEDITGLOSSARYTEXTItem()
			{
				return this.contextMenuGlossaryAdminConfigurationEDITGLOSSARYTEXTItem;
			}
			private MenuItem contextMenuGlossaryAdminConfigurationEDITGLOSSARYTEXTItem;
			public ReadOnlyMenuItem getGlossaryAdminConfigurationDELETEPROFILEItem()
			{
				return this.contextMenuGlossaryAdminConfigurationDELETEPROFILEItem;
			}
			private MenuItem contextMenuGlossaryAdminConfigurationDELETEPROFILEItem;
			public ReadOnlyMenuItem getGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem()
			{
				return this.contextMenuGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem;
			}
			private MenuItem contextMenuGlossaryAdminConfigurationDELETEGLOSSARYTEXTItem;
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
	private IReportField[] reportFields = null;
}
