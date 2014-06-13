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

package ims.core.forms.printreport;

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

		public boolean getPrepareForPrintingIsNotNull()
		{
			return !cx_CorePrepareForPrinting.getValueIsNull(context);
		}
		public Boolean getPrepareForPrinting()
		{
			return (Boolean)cx_CorePrepareForPrinting.getValue(context);
		}
		public void setPrepareForPrinting(Boolean value)
		{
			cx_CorePrepareForPrinting.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrepareForPrinting = new ims.framework.ContextVariable("Core.PrepareForPrinting", "_cv_Core.PrepareForPrinting");
		public boolean getPrinterSelectIsNotNull()
		{
			return !cx_CorePrinterSelect.getValueIsNull(context);
		}
		public String getPrinterSelect()
		{
			return (String)cx_CorePrinterSelect.getValue(context);
		}
		public void setPrinterSelect(String value)
		{
			cx_CorePrinterSelect.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrinterSelect = new ims.framework.ContextVariable("Core.PrinterSelect", "_cv_Core.PrinterSelect");
		public boolean getReportIsNotNull()
		{
			return !cx_CoreReport.getValueIsNull(context);
		}
		public String getReport()
		{
			return (String)cx_CoreReport.getValue(context);
		}
		public void setReport(String value)
		{
			cx_CoreReport.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReport = new ims.framework.ContextVariable("Core.Report", "_cv_Core.Report");
		public boolean getTemplateIsNotNull()
		{
			return !cx_CoreTemplate.getValueIsNull(context);
		}
		public String getTemplate()
		{
			return (String)cx_CoreTemplate.getValue(context);
		}
		public void setTemplate(String value)
		{
			cx_CoreTemplate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplate = new ims.framework.ContextVariable("Core.Template", "_cv_Core.Template");
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

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
