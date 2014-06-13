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

package ims.core.forms.viewreport;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Correspondence = new CorrespondenceContext(context);
		Core = new CoreContext(context);
	}
	public final class CorrespondenceContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CorrespondenceContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDocDetailIdReportSeedIsNotNull()
		{
			return !cx_CorrespondenceDocDetailIdReportSeed.getValueIsNull(context);
		}
		public Integer getDocDetailIdReportSeed()
		{
			return (Integer)cx_CorrespondenceDocDetailIdReportSeed.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorrespondenceDocDetailIdReportSeed = new ims.framework.ContextVariable("Correspondence.DocDetailIdReportSeed", "_cv_Correspondence.DocDetailIdReportSeed");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getReportIDIsNotNull()
		{
			return !cx_CoreReportID.getValueIsNull(context);
		}
		public Integer getReportID()
		{
			return (Integer)cx_CoreReportID.getValue(context);
		}
		public void setReportID(Integer value)
		{
			cx_CoreReportID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReportID = new ims.framework.ContextVariable("Core.ReportID", "_cv_Core.ReportID");
		public boolean getTemplateIDIsNotNull()
		{
			return !cx_CoreTemplateID.getValueIsNull(context);
		}
		public Integer getTemplateID()
		{
			return (Integer)cx_CoreTemplateID.getValue(context);
		}
		public void setTemplateID(Integer value)
		{
			cx_CoreTemplateID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplateID = new ims.framework.ContextVariable("Core.TemplateID", "_cv_Core.TemplateID");
		public boolean getCurrentFormNameIsNotNull()
		{
			return !cx_CoreCurrentFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getCurrentFormName()
		{
			return (ims.framework.FormName)cx_CoreCurrentFormName.getValue(context);
		}
		public void setCurrentFormName(ims.framework.FormName value)
		{
			cx_CoreCurrentFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentFormName = new ims.framework.ContextVariable("Core.CurrentFormName", "_cv_Core.CurrentFormName");
		public boolean getDocumentIDIsNotNull()
		{
			return !cx_CoreDocumentID.getValueIsNull(context);
		}
		public Integer getDocumentID()
		{
			return (Integer)cx_CoreDocumentID.getValue(context);
		}
		public void setDocumentID(Integer value)
		{
			cx_CoreDocumentID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreDocumentID = new ims.framework.ContextVariable("Core.DocumentID", "_cv_Core.DocumentID");

		private ims.framework.Context context;
	}

	public CorrespondenceContext Correspondence;
	public CoreContext Core;
}
