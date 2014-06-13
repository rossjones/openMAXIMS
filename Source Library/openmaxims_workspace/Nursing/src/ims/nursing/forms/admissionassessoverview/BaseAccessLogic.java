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

package ims.nursing.forms.admissionassessoverview;

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
			COE = new COEForms();
			SpinalInjuries = new SpinalInjuriesForms();
		}
		public final class COEForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private COEForms()
			{
				AssessAccommodation = new LocalFormName(101101);
				AssessActivityLevel = new LocalFormName(101102);
				AssessBreathing = new LocalFormName(101103);
				AssessCommunication = new LocalFormName(101108);
				AssessSleeping = new LocalFormName(101106);
				AssessMobility = new LocalFormName(101115);
				AssessPersonalHygiene = new LocalFormName(101111);
				AssessDressingGrooming = new LocalFormName(101114);
				AssessSkin = new LocalFormName(101112);
				AssessEating = new LocalFormName(101110);
				AssessBowels = new LocalFormName(101104);
				AssessBladder = new LocalFormName(101105);
				AssessPain = new LocalFormName(101113);
				AssessEmotionalState = new LocalFormName(101109);
				AssessLeisure = new LocalFormName(101116);
				AssessSpirituality = new LocalFormName(101121);
				AssessInfectionControl = new LocalFormName(101163);
			}
			public final FormName AssessAccommodation;
			public final FormName AssessActivityLevel;
			public final FormName AssessBreathing;
			public final FormName AssessCommunication;
			public final FormName AssessSleeping;
			public final FormName AssessMobility;
			public final FormName AssessPersonalHygiene;
			public final FormName AssessDressingGrooming;
			public final FormName AssessSkin;
			public final FormName AssessEating;
			public final FormName AssessBowels;
			public final FormName AssessBladder;
			public final FormName AssessPain;
			public final FormName AssessEmotionalState;
			public final FormName AssessLeisure;
			public final FormName AssessSpirituality;
			public final FormName AssessInfectionControl;
		}
		public final class SpinalInjuriesForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SpinalInjuriesForms()
			{
				NurAssessmentAccommodationProperty = new LocalFormName(105119);
				NurAssessmentBreathing = new LocalFormName(105108);
				NurAssessmentMobility = new LocalFormName(105136);
				NurAssessmentCommunication = new LocalFormName(105134);
				NurAssessmentBladder = new LocalFormName(105141);
				NurAssessmentCleansing = new LocalFormName(105137);
				NurAssessmentEating = new LocalFormName(105139);
				NurAssessmentBowels = new LocalFormName(105140);
				NurAssessmentPersonalDetails = new LocalFormName(105135);
				NurAssessmentSafeEnvironement = new LocalFormName(105133);
				NurAssessmentSkin = new LocalFormName(105114);
			}
			public final FormName NurAssessmentAccommodationProperty;
			public final FormName NurAssessmentBreathing;
			public final FormName NurAssessmentMobility;
			public final FormName NurAssessmentCommunication;
			public final FormName NurAssessmentBladder;
			public final FormName NurAssessmentCleansing;
			public final FormName NurAssessmentEating;
			public final FormName NurAssessmentBowels;
			public final FormName NurAssessmentPersonalDetails;
			public final FormName NurAssessmentSafeEnvironement;
			public final FormName NurAssessmentSkin;
		}

		public COEForms COE;
		public SpinalInjuriesForms SpinalInjuries;
	}
}
