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

package ims.assessment.forms.userassessments;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getUserAssessmentActionIsNotNull()
		{
			return !cx_CoreUserAssessmentAction.getValueIsNull(context);
		}
		public String getUserAssessmentAction()
		{
			return (String)cx_CoreUserAssessmentAction.getValue(context);
		}
		public void setUserAssessmentAction(String value)
		{
			cx_CoreUserAssessmentAction.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreUserAssessmentAction = new ims.framework.ContextVariable("Core.UserAssessmentAction", "_cv_Core.UserAssessmentAction");
		public boolean getSelectedUserAssessmentIsNotNull()
		{
			return !cx_CoreSelectedUserAssessment.getValueIsNull(context);
		}
		public ims.assessment.vo.UserAssessmentShortVo getSelectedUserAssessment()
		{
			return (ims.assessment.vo.UserAssessmentShortVo)cx_CoreSelectedUserAssessment.getValue(context);
		}
		public void setSelectedUserAssessment(ims.assessment.vo.UserAssessmentShortVo value)
		{
			cx_CoreSelectedUserAssessment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedUserAssessment = new ims.framework.ContextVariable("Core.SelectedUserAssessment", "_cv_Core.SelectedUserAssessment");
		public boolean getUserAssessmentFilterIsNotNull()
		{
			return !cx_CoreUserAssessmentFilter.getValueIsNull(context);
		}
		public ims.assessment.vo.UserAssessmentShortVo getUserAssessmentFilter()
		{
			return (ims.assessment.vo.UserAssessmentShortVo)cx_CoreUserAssessmentFilter.getValue(context);
		}
		public void setUserAssessmentFilter(ims.assessment.vo.UserAssessmentShortVo value)
		{
			cx_CoreUserAssessmentFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreUserAssessmentFilter = new ims.framework.ContextVariable("Core.UserAssessmentFilter", "_cv_Core.UserAssessmentFilter");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
