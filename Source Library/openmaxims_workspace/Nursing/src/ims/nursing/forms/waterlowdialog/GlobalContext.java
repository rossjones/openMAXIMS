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

package ims.nursing.forms.waterlowdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Nursing = new NursingContext(context);
		Core = new CoreContext(context);
	}
	public final class NursingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NursingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAssessmentScoreIsNotNull()
		{
			return !cx_NursingAssessmentScore.getValueIsNull(context);
		}
		public Float getAssessmentScore()
		{
			return (Float)cx_NursingAssessmentScore.getValue(context);
		}
		public void setAssessmentScore(Float value)
		{
			cx_NursingAssessmentScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentScore = new ims.framework.ContextVariable("Nursing.AssessmentScore", "_cv_Nursing.AssessmentScore");
		public boolean getWaterlowAssessmentsIsNotNull()
		{
			return !cx_NursingWaterlowAssessments.getValueIsNull(context);
		}
		public ims.coe.vo.RiskAssessmentCollection getWaterlowAssessments()
		{
			return (ims.coe.vo.RiskAssessmentCollection)cx_NursingWaterlowAssessments.getValue(context);
		}
		public void setWaterlowAssessments(ims.coe.vo.RiskAssessmentCollection value)
		{
			cx_NursingWaterlowAssessments.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingWaterlowAssessments = new ims.framework.ContextVariable("Nursing.WaterlowAssessments", "_cv_Nursing.WaterlowAssessments");
		public boolean getWaterlowRecordIsNotNull()
		{
			return !cx_NursingWaterlowRecord.getValueIsNull(context);
		}
		public ims.nursing.vo.WaterlowAssessmentVo getWaterlowRecord()
		{
			return (ims.nursing.vo.WaterlowAssessmentVo)cx_NursingWaterlowRecord.getValue(context);
		}
		public void setWaterlowRecord(ims.nursing.vo.WaterlowAssessmentVo value)
		{
			cx_NursingWaterlowRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingWaterlowRecord = new ims.framework.ContextVariable("Nursing.WaterlowRecord", "_cv_Nursing.WaterlowRecord");
		public boolean getAssessmentComponentIsNotNull()
		{
			return !cx_NursingAssessmentComponent.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentComponent getAssessmentComponent()
		{
			return (ims.nursing.vo.AssessmentComponent)cx_NursingAssessmentComponent.getValue(context);
		}
		public void setAssessmentComponent(ims.nursing.vo.AssessmentComponent value)
		{
			cx_NursingAssessmentComponent.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentComponent = new ims.framework.ContextVariable("Nursing.AssessmentComponent", "_cv_Nursing.AssessmentComponent");
		public boolean getAssessmentHeaderInfoIsNotNull()
		{
			return !cx_NursingAssessmentHeaderInfo.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentHeaderInfo getAssessmentHeaderInfo()
		{
			return (ims.nursing.vo.AssessmentHeaderInfo)cx_NursingAssessmentHeaderInfo.getValue(context);
		}
		public void setAssessmentHeaderInfo(ims.nursing.vo.AssessmentHeaderInfo value)
		{
			cx_NursingAssessmentHeaderInfo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentHeaderInfo = new ims.framework.ContextVariable("Nursing.AssessmentHeaderInfo", "_cv_Nursing.AssessmentHeaderInfo");
		public boolean getDisplayScoreIsNotNull()
		{
			return !cx_NursingDisplayScore.getValueIsNull(context);
		}
		public Boolean getDisplayScore()
		{
			return (Boolean)cx_NursingDisplayScore.getValue(context);
		}
		public void setDisplayScore(Boolean value)
		{
			cx_NursingDisplayScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingDisplayScore = new ims.framework.ContextVariable("Nursing.DisplayScore", "_cv_Nursing.DisplayScore");
		public boolean getEditIsNotNull()
		{
			return !cx_NursingEdit.getValueIsNull(context);
		}
		public Boolean getEdit()
		{
			return (Boolean)cx_NursingEdit.getValue(context);
		}
		public void setEdit(Boolean value)
		{
			cx_NursingEdit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingEdit = new ims.framework.ContextVariable("Nursing.Edit", "_cv_Nursing.Edit");
		public boolean getCopyLastIsNotNull()
		{
			return !cx_NursingCopyLast.getValueIsNull(context);
		}
		public Boolean getCopyLast()
		{
			return (Boolean)cx_NursingCopyLast.getValue(context);
		}
		public void setCopyLast(Boolean value)
		{
			cx_NursingCopyLast.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingCopyLast = new ims.framework.ContextVariable("Nursing.CopyLast", "_cv_Nursing.CopyLast");

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

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
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

		private ims.framework.Context context;
	}

	public NursingContext Nursing;
	public CoreContext Core;
}
