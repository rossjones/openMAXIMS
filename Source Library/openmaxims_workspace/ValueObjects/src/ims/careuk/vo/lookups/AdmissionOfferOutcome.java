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

package ims.careuk.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AdmissionOfferOutcome extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AdmissionOfferOutcome()
	{
		super();
	}
	public AdmissionOfferOutcome(int id)
	{
		super(id, "", true);
	}
	public AdmissionOfferOutcome(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AdmissionOfferOutcome(int id, String text, boolean active, AdmissionOfferOutcome parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AdmissionOfferOutcome(int id, String text, boolean active, AdmissionOfferOutcome parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AdmissionOfferOutcome(int id, String text, boolean active, AdmissionOfferOutcome parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AdmissionOfferOutcome buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AdmissionOfferOutcome(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AdmissionOfferOutcome)super.getParentInstance();
	}
	public AdmissionOfferOutcome getParent()
	{
		return (AdmissionOfferOutcome)super.getParentInstance();
	}
	public void setParent(AdmissionOfferOutcome parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AdmissionOfferOutcome[] typedChildren = new AdmissionOfferOutcome[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AdmissionOfferOutcome)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AdmissionOfferOutcome)
		{
			super.addChild((AdmissionOfferOutcome)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AdmissionOfferOutcome)
		{
			super.removeChild((AdmissionOfferOutcome)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		AdmissionOfferOutcomeCollection result = new AdmissionOfferOutcomeCollection();
		result.add(PATIENT_ADMITTED_COMMENCED_8);
		result.add(PATIENT_ADMITTED_COMPLETED_1);
		result.add(ADMISSION_CANCELLED_BY_PATIENT_2);
		result.add(ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6);
		result.add(ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7);
		result.add(PATIENT_FAILED_TO_ARRIVE_4);
		result.add(PATIENT_ADMITTED_TREATMENT_DEFERRED_5);
		result.add(PATIENT_ADMITTED);
		result.add(NOT_APPLICABLE_OR_REMOVED_ETC_9);
		return result;
	}
	public static AdmissionOfferOutcome[] getNegativeInstances()
	{
		AdmissionOfferOutcome[] instances = new AdmissionOfferOutcome[9];
		instances[0] = PATIENT_ADMITTED_COMMENCED_8;
		instances[1] = PATIENT_ADMITTED_COMPLETED_1;
		instances[2] = ADMISSION_CANCELLED_BY_PATIENT_2;
		instances[3] = ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6;
		instances[4] = ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7;
		instances[5] = PATIENT_FAILED_TO_ARRIVE_4;
		instances[6] = PATIENT_ADMITTED_TREATMENT_DEFERRED_5;
		instances[7] = PATIENT_ADMITTED;
		instances[8] = NOT_APPLICABLE_OR_REMOVED_ETC_9;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[9];
		negativeInstances[0] = "PATIENT_ADMITTED_COMMENCED_8";
		negativeInstances[1] = "PATIENT_ADMITTED_COMPLETED_1";
		negativeInstances[2] = "ADMISSION_CANCELLED_BY_PATIENT_2";
		negativeInstances[3] = "ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6";
		negativeInstances[4] = "ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7";
		negativeInstances[5] = "PATIENT_FAILED_TO_ARRIVE_4";
		negativeInstances[6] = "PATIENT_ADMITTED_TREATMENT_DEFERRED_5";
		negativeInstances[7] = "PATIENT_ADMITTED";
		negativeInstances[8] = "NOT_APPLICABLE_OR_REMOVED_ETC_9";
		return negativeInstances;
	}
	public static AdmissionOfferOutcome getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static AdmissionOfferOutcome getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AdmissionOfferOutcome[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1341045;
	public static final AdmissionOfferOutcome PATIENT_ADMITTED_COMMENCED_8 = new AdmissionOfferOutcome(-2637, "Patient admitted - treatment commenced", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome PATIENT_ADMITTED_COMPLETED_1 = new AdmissionOfferOutcome(-2638, "Patient admitted - treatment completed", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome ADMISSION_CANCELLED_BY_PATIENT_2 = new AdmissionOfferOutcome(-2639, "Admission cancelled by- patient", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6 = new AdmissionOfferOutcome(-2640, "Admission cancelled by hospital before day offered for admission", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7 = new AdmissionOfferOutcome(-2641, "Admission cancelled by hospital on day offered for admission", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome PATIENT_FAILED_TO_ARRIVE_4 = new AdmissionOfferOutcome(-2642, "Patient failed to arrive", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome PATIENT_ADMITTED_TREATMENT_DEFERRED_5 = new AdmissionOfferOutcome(-2643, "Patient admitted - treatment deferred", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome PATIENT_ADMITTED = new AdmissionOfferOutcome(-2650, "Admitted", true, null, null, Color.Default);
	public static final AdmissionOfferOutcome NOT_APPLICABLE_OR_REMOVED_ETC_9 = new AdmissionOfferOutcome(-2677, "Not Applicable or Removed or similiar", true, null, null, Color.Default);
}
