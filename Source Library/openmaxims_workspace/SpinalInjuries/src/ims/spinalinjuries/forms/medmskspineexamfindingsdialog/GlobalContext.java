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

package ims.spinalinjuries.forms.medmskspineexamfindingsdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		SpinalInjuries = new SpinalInjuriesContext(context);
		Core = new CoreContext(context);
	}
	public final class SpinalInjuriesContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SpinalInjuriesContext(ims.framework.Context context)
		{
			this.context = context;

			Back = new BackContext(context);
		}
		public final class BackContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private BackContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getAdminSpineExamVoIsNotNull()
			{
				return !cx_SpinalInjuriesBackAdminSpineExamVo.getValueIsNull(context);
			}
			public ims.generalmedical.vo.AdmisSpineExamVo getAdminSpineExamVo()
			{
				return (ims.generalmedical.vo.AdmisSpineExamVo)cx_SpinalInjuriesBackAdminSpineExamVo.getValue(context);
			}
		public void setAdminSpineExamVo(ims.generalmedical.vo.AdmisSpineExamVo value)
		{
				cx_SpinalInjuriesBackAdminSpineExamVo.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_SpinalInjuriesBackAdminSpineExamVo = new ims.framework.ContextVariable("SpinalInjuries.Back.AdminSpineExamVo", "_cv_SpinalInjuries.Back.AdminSpineExamVo");
			public boolean getMskSpineExamFindingVoIsNotNull()
			{
				return !cx_SpinalInjuriesBackMskSpineExamFindingVo.getValueIsNull(context);
			}
			public ims.generalmedical.vo.MskSpineExamFindingVo getMskSpineExamFindingVo()
			{
				return (ims.generalmedical.vo.MskSpineExamFindingVo)cx_SpinalInjuriesBackMskSpineExamFindingVo.getValue(context);
			}
		public void setMskSpineExamFindingVo(ims.generalmedical.vo.MskSpineExamFindingVo value)
		{
				cx_SpinalInjuriesBackMskSpineExamFindingVo.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_SpinalInjuriesBackMskSpineExamFindingVo = new ims.framework.ContextVariable("SpinalInjuries.Back.MskSpineExamFindingVo", "_cv_SpinalInjuries.Back.MskSpineExamFindingVo");
			private ims.framework.Context context;
		}

		public boolean getMedicalProbToSaveIsNotNull()
		{
			return !cx_SpinalInjuriesMedicalProbToSave.getValueIsNull(context);
		}
		public ims.generalmedical.vo.MedicalProbOnAdmisVo getMedicalProbToSave()
		{
			return (ims.generalmedical.vo.MedicalProbOnAdmisVo)cx_SpinalInjuriesMedicalProbToSave.getValue(context);
		}
		public void setMedicalProbToSave(ims.generalmedical.vo.MedicalProbOnAdmisVo value)
		{
			cx_SpinalInjuriesMedicalProbToSave.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SpinalInjuriesMedicalProbToSave = new ims.framework.ContextVariable("SpinalInjuries.MedicalProbToSave", "_cv_SpinalInjuries.MedicalProbToSave");

		public BackContext Back;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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

		private ims.framework.Context context;
	}

	public SpinalInjuriesContext SpinalInjuries;
	public CoreContext Core;
}
