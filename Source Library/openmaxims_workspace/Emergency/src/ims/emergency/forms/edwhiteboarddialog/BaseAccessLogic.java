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
			Emergency = new EmergencyForms();
		}
		public final class EmergencyForms implements Serializable
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
}
