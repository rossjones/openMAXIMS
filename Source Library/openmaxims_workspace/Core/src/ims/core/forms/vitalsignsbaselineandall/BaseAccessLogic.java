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

package ims.core.forms.vitalsignsbaselineandall;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{
		if(!form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			return false;

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Nursing = new NursingForms();
			Assessment = new AssessmentForms();
			Core = new CoreForms();
		}
		public final class NursingForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private NursingForms()
			{
				SECS = new LocalFormName(100123);
			}
			public final FormName SECS;
		}
		public final class AssessmentForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private AssessmentForms()
			{
				DynamicAssessmentsDialog = new LocalFormName(127116);
			}
			public final FormName DynamicAssessmentsDialog;
		}
		public final class CoreForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CoreForms()
			{
				VitalSignsBMI = new LocalFormName(102125);
				VitalSignsBP = new LocalFormName(102111);
				VitalSignsGCS = new LocalFormName(102114);
				VitalSignsOxygenSaturation = new LocalFormName(102115);
				VitalSignsMetrics = new LocalFormName(102118);
				VitalSignsPainLadder = new LocalFormName(102138);
				VitalSignsPeakFlow = new LocalFormName(102117);
				VitalSignsPulse = new LocalFormName(102109);
				VitalSignsPupils = new LocalFormName(102112);
				VitalSignsRespiration = new LocalFormName(102110);
				VitalSignsBloodSugar = new LocalFormName(102116);
				VitalSignsVisualAcuity = new LocalFormName(102113);
				VitalSignsTemperature = new LocalFormName(102108);
			}
			public final FormName VitalSignsBMI;
			public final FormName VitalSignsBP;
			public final FormName VitalSignsGCS;
			public final FormName VitalSignsOxygenSaturation;
			public final FormName VitalSignsMetrics;
			public final FormName VitalSignsPainLadder;
			public final FormName VitalSignsPeakFlow;
			public final FormName VitalSignsPulse;
			public final FormName VitalSignsPupils;
			public final FormName VitalSignsRespiration;
			public final FormName VitalSignsBloodSugar;
			public final FormName VitalSignsVisualAcuity;
			public final FormName VitalSignsTemperature;
		}

		public NursingForms Nursing;
		public AssessmentForms Assessment;
		public CoreForms Core;
	}
}
