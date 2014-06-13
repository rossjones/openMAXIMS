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

package ims.core.forms.patientmerge;

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

		public boolean getPatientSourceIsNotNull()
		{
			return !cx_CorePatientSource.getValueIsNull(context);
		}
		public ims.core.patient.vo.PatientRefVo getPatientSource()
		{
			return (ims.core.patient.vo.PatientRefVo)cx_CorePatientSource.getValue(context);
		}
		public void setPatientSource(ims.core.patient.vo.PatientRefVo value)
		{
			cx_CorePatientSource.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientSource = new ims.framework.ContextVariable("Core.PatientSource", "_cv_Core.PatientSource");
		public boolean getPatientDestinationIsNotNull()
		{
			return !cx_CorePatientDestination.getValueIsNull(context);
		}
		public ims.core.patient.vo.PatientRefVo getPatientDestination()
		{
			return (ims.core.patient.vo.PatientRefVo)cx_CorePatientDestination.getValue(context);
		}
		public void setPatientDestination(ims.core.patient.vo.PatientRefVo value)
		{
			cx_CorePatientDestination.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDestination = new ims.framework.ContextVariable("Core.PatientDestination", "_cv_Core.PatientDestination");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
