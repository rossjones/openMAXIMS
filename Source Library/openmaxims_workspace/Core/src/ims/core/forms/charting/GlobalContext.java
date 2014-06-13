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

package ims.core.forms.charting;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		OCRR = new OCRRContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getChartMaxGroupSelectionIsNotNull()
		{
			return !cx_CoreChartMaxGroupSelection.getValueIsNull(context);
		}
		public Integer getChartMaxGroupSelection()
		{
			return (Integer)cx_CoreChartMaxGroupSelection.getValue(context);
		}
		public void setChartMaxGroupSelection(Integer value)
		{
			cx_CoreChartMaxGroupSelection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreChartMaxGroupSelection = new ims.framework.ContextVariable("Core.ChartMaxGroupSelection", "_cv_Core.ChartMaxGroupSelection");
		public boolean getChartAvailableDatasetsIsNotNull()
		{
			return !cx_CoreChartAvailableDatasets.getValueIsNull(context);
		}
		public ims.vo.interfaces.IChartValueGroup[] getChartAvailableDatasets()
		{
			return (ims.vo.interfaces.IChartValueGroup[])cx_CoreChartAvailableDatasets.getValue(context);
		}
		public void setChartAvailableDatasets(ims.vo.interfaces.IChartValueGroup[] value)
		{
			cx_CoreChartAvailableDatasets.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreChartAvailableDatasets = new ims.framework.ContextVariable("Core.ChartAvailableDatasets", "_cv_Core.ChartAvailableDatasets");
		public boolean getChartDatasetSelectionIsNotNull()
		{
			return !cx_CoreChartDatasetSelection.getValueIsNull(context);
		}
		public ims.vo.interfaces.IChartValueGroup[] getChartDatasetSelection()
		{
			return (ims.vo.interfaces.IChartValueGroup[])cx_CoreChartDatasetSelection.getValue(context);
		}
		public void setChartDatasetSelection(ims.vo.interfaces.IChartValueGroup[] value)
		{
			cx_CoreChartDatasetSelection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreChartDatasetSelection = new ims.framework.ContextVariable("Core.ChartDatasetSelection", "_cv_Core.ChartDatasetSelection");
		public boolean getCommentDialogStringIsNotNull()
		{
			return !cx_CoreCommentDialogString.getValueIsNull(context);
		}
		public String getCommentDialogString()
		{
			return (String)cx_CoreCommentDialogString.getValue(context);
		}
		public void setCommentDialogString(String value)
		{
			cx_CoreCommentDialogString.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogString = new ims.framework.ContextVariable("Core.CommentDialogString", "_cv_Core.CommentDialogString");
		public boolean getCommentDialogReadOnlyIsNotNull()
		{
			return !cx_CoreCommentDialogReadOnly.getValueIsNull(context);
		}
		public Boolean getCommentDialogReadOnly()
		{
			return (Boolean)cx_CoreCommentDialogReadOnly.getValue(context);
		}
		public void setCommentDialogReadOnly(Boolean value)
		{
			cx_CoreCommentDialogReadOnly.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogReadOnly = new ims.framework.ContextVariable("Core.CommentDialogReadOnly", "_cv_Core.CommentDialogReadOnly");
		public boolean getCommentDialogTitleIsNotNull()
		{
			return !cx_CoreCommentDialogTitle.getValueIsNull(context);
		}
		public String getCommentDialogTitle()
		{
			return (String)cx_CoreCommentDialogTitle.getValue(context);
		}
		public void setCommentDialogTitle(String value)
		{
			cx_CoreCommentDialogTitle.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogTitle = new ims.framework.ContextVariable("Core.CommentDialogTitle", "_cv_Core.CommentDialogTitle");

		private ims.framework.Context context;
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectGroupsInViewGraphicIsNotNull()
		{
			return !cx_OCRRSelectGroupsInViewGraphic.getValueIsNull(context);
		}
		public Boolean getSelectGroupsInViewGraphic()
		{
			return (Boolean)cx_OCRRSelectGroupsInViewGraphic.getValue(context);
		}
		public void setSelectGroupsInViewGraphic(Boolean value)
		{
			cx_OCRRSelectGroupsInViewGraphic.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectGroupsInViewGraphic = new ims.framework.ContextVariable("OCRR.SelectGroupsInViewGraphic", "_cvp_OCRR.SelectGroupsInViewGraphic");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public OCRRContext OCRR;
}
