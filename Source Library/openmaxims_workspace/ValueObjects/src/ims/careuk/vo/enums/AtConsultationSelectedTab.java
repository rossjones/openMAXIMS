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

package ims.careuk.vo.enums;

public final class AtConsultationSelectedTab extends ims.framework.utils.Enum
{
	public final static AtConsultationSelectedTab DOCS = new AtConsultationSelectedTab(0, "Docs", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab BASELINEOBS = new AtConsultationSelectedTab(1, "BaselineObs", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab CLINICALNOTES = new AtConsultationSelectedTab(2, "CLINICALNOTES", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab INV = new AtConsultationSelectedTab(3, "Inv", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab PRESCRIPTION = new AtConsultationSelectedTab(4, "PRESCRIPTION", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab ASSESSMENTS = new AtConsultationSelectedTab(5, "Assessments", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab OUTCOME = new AtConsultationSelectedTab(6, "Outcome", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab DISCHARGE = new AtConsultationSelectedTab(7, "DISCHARGE", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab NOTES = new AtConsultationSelectedTab(8, "Notes", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab APPOINTMENTS = new AtConsultationSelectedTab(9, "APPOINTMENTS", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab SPECIMENCOLL = new AtConsultationSelectedTab(10, "SPECIMENCOLL", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab ONEXAM = new AtConsultationSelectedTab(11, "OnExam", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab ATCONSULTATION = new AtConsultationSelectedTab(12, "AtConsultation", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab APPTS = new AtConsultationSelectedTab(13, "Appts", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab OVERVIEW = new AtConsultationSelectedTab(14, "Overview", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab CATSREPORT = new AtConsultationSelectedTab(15, "CatsReport", null, ims.framework.utils.Color.Default);
	public final static AtConsultationSelectedTab PRESENTATION = new AtConsultationSelectedTab(16, "Presentation", null, ims.framework.utils.Color.Default);

	private AtConsultationSelectedTab(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
