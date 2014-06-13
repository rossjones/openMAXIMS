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

package ims.clinicaladmin.vo.enums;

public final class CciType extends ims.framework.utils.Enum
{
	public final static CciType MEDICATION = new CciType(0, "Medication", null, ims.framework.utils.Color.Default);
	public final static CciType PROCEDURE = new CciType(1, "Procedure", null, ims.framework.utils.Color.Default);
	public final static CciType PROBLEM = new CciType(2, "Problem", null, ims.framework.utils.Color.Default);
	public final static CciType ALLERGEN = new CciType(3, "Allergen", null, ims.framework.utils.Color.Default);
	public final static CciType DIAGNOSIS = new CciType(4, "Diagnosis", null, ims.framework.utils.Color.Default);
	public final static CciType CANCERIMAGE = new CciType(5, "Cancer Image", null, ims.framework.utils.Color.Default);
	public final static CciType VACCINE = new CciType(6, "Vaccine", null, ims.framework.utils.Color.Default);
	public final static CciType PRESENTING_ISSUE = new CciType(7, "Presenting Issue", null, ims.framework.utils.Color.Default);
	public final static CciType TREATMENT_INTERVENTION = new CciType(8, "Treatment/Intervention", null, ims.framework.utils.Color.Default);

	private CciType(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
