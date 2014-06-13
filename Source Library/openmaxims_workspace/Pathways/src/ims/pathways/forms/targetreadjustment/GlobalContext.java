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

package ims.pathways.forms.targetreadjustment;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Pathways = new PathwaysContext(context);
	}
	public final class PathwaysContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PathwaysContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTargetReadjustmentsIsNotNull()
		{
			return !cx_PathwaysTargetReadjustments.getValueIsNull(context);
		}
		public ims.pathways.vo.TargetReadjustmentVoCollection getTargetReadjustments()
		{
			return (ims.pathways.vo.TargetReadjustmentVoCollection)cx_PathwaysTargetReadjustments.getValue(context);
		}
		public void setTargetReadjustments(ims.pathways.vo.TargetReadjustmentVoCollection value)
		{
			cx_PathwaysTargetReadjustments.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysTargetReadjustments = new ims.framework.ContextVariable("Pathways.TargetReadjustments", "_cv_Pathways.TargetReadjustments");
		public boolean getTargetReadjustmentsActionIsNotNull()
		{
			return !cx_PathwaysTargetReadjustmentsAction.getValueIsNull(context);
		}
		public ims.pathways.vo.enums.TargetReadjustmentsAction getTargetReadjustmentsAction()
		{
			return (ims.pathways.vo.enums.TargetReadjustmentsAction)cx_PathwaysTargetReadjustmentsAction.getValue(context);
		}
		public void setTargetReadjustmentsAction(ims.pathways.vo.enums.TargetReadjustmentsAction value)
		{
			cx_PathwaysTargetReadjustmentsAction.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysTargetReadjustmentsAction = new ims.framework.ContextVariable("Pathways.TargetReadjustmentsAction", "_cv_Pathways.TargetReadjustmentsAction");

		private ims.framework.Context context;
	}

	public PathwaysContext Pathways;
}
