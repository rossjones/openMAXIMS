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

package ims.core.forms.uploaddocumentdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		CareUk = new CareUkContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getUploadDocumentActionIsNotNull()
		{
			return !cx_CoreUploadDocumentAction.getValueIsNull(context);
		}
		public ims.core.vo.enums.UploadDocumentAction getUploadDocumentAction()
		{
			return (ims.core.vo.enums.UploadDocumentAction)cx_CoreUploadDocumentAction.getValue(context);
		}
		public void setUploadDocumentAction(ims.core.vo.enums.UploadDocumentAction value)
		{
			cx_CoreUploadDocumentAction.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreUploadDocumentAction = new ims.framework.ContextVariable("Core.UploadDocumentAction", "_cv_Core.UploadDocumentAction");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}
		public void setEpisodeofCareShort(ims.core.vo.EpisodeofCareShortVo value)
		{
			cx_CoreEpisodeofCareShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getPatientDocumentIsNotNull()
		{
			return !cx_CorePatientDocument.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentVo getPatientDocument()
		{
			return (ims.core.vo.PatientDocumentVo)cx_CorePatientDocument.getValue(context);
		}
		public void setPatientDocument(ims.core.vo.PatientDocumentVo value)
		{
			cx_CorePatientDocument.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDocument = new ims.framework.ContextVariable("Core.PatientDocument", "_cv_Core.PatientDocument");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}
	public final class CareUkContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CareUkContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getUploadDocumentsDialogDocumentTypeIsNotNull()
		{
			return !cx_CareUkUploadDocumentsDialogDocumentType.getValueIsNull(context);
		}
		public ims.core.vo.lookups.DocumentCategory getUploadDocumentsDialogDocumentType()
		{
			return (ims.core.vo.lookups.DocumentCategory)cx_CareUkUploadDocumentsDialogDocumentType.getValue(context);
		}
		public void setUploadDocumentsDialogDocumentType(ims.core.vo.lookups.DocumentCategory value)
		{
			cx_CareUkUploadDocumentsDialogDocumentType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkUploadDocumentsDialogDocumentType = new ims.framework.ContextVariable("CareUk.UploadDocumentsDialogDocumentType", "_cv_CareUk.UploadDocumentsDialogDocumentType");
		public boolean getCatsReferralIsNotNull()
		{
			return !cx_CareUkCatsReferral.getValueIsNull(context);
		}
		public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.careuk.vo.CatsReferralRefVo)cx_CareUkCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
		{
			cx_CareUkCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferral = new ims.framework.ContextVariable("CareUk.CatsReferral", "_cvp_CareUk.CatsReferral");
		public boolean getCatsReferralWizardIsNotNull()
		{
			return !cx_CareUkCatsReferralWizard.getValueIsNull(context);
		}
		public ims.careuk.vo.CatsReferralWizardVo getCatsReferralWizard()
		{
			return (ims.careuk.vo.CatsReferralWizardVo)cx_CareUkCatsReferralWizard.getValue(context);
		}
		public void setCatsReferralWizard(ims.careuk.vo.CatsReferralWizardVo value)
		{
			cx_CareUkCatsReferralWizard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferralWizard = new ims.framework.ContextVariable("CareUk.CatsReferralWizard", "_cv_CareUk.CatsReferralWizard");
		public boolean getCatsReferralHasGpLetterIsNotNull()
		{
			return !cx_CareUkCatsReferralHasGpLetter.getValueIsNull(context);
		}
		public Boolean getCatsReferralHasGpLetter()
		{
			return (Boolean)cx_CareUkCatsReferralHasGpLetter.getValue(context);
		}
		public void setCatsReferralHasGpLetter(Boolean value)
		{
			cx_CareUkCatsReferralHasGpLetter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferralHasGpLetter = new ims.framework.ContextVariable("CareUk.CatsReferralHasGpLetter", "_cv_CareUk.CatsReferralHasGpLetter");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public CareUkContext CareUk;
}
