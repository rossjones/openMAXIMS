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

package ims.ocrr.forms.ordersetlist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getOrderSetEditorReadOnlyIsNotNull()
		{
			return !cx_OCRROrderSetEditorReadOnly.getValueIsNull(context);
		}
		public Boolean getOrderSetEditorReadOnly()
		{
			return (Boolean)cx_OCRROrderSetEditorReadOnly.getValue(context);
		}
		public void setOrderSetEditorReadOnly(Boolean value)
		{
			cx_OCRROrderSetEditorReadOnly.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrderSetEditorReadOnly = new ims.framework.ContextVariable("OCRR.OrderSetEditorReadOnly", "_cv_OCRR.OrderSetEditorReadOnly");
		public boolean getOrderSetListSearchCriteriaIsNotNull()
		{
			return !cx_OCRROrderSetListSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderSetListSearchCriteriaVo getOrderSetListSearchCriteria()
		{
			return (ims.ocrr.vo.OrderSetListSearchCriteriaVo)cx_OCRROrderSetListSearchCriteria.getValue(context);
		}
		public void setOrderSetListSearchCriteria(ims.ocrr.vo.OrderSetListSearchCriteriaVo value)
		{
			cx_OCRROrderSetListSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrderSetListSearchCriteria = new ims.framework.ContextVariable("OCRR.OrderSetListSearchCriteria", "_cv_OCRR.OrderSetListSearchCriteria");
		public boolean getSelectedOrderSetIDIsNotNull()
		{
			return !cx_OCRRSelectedOrderSetID.getValueIsNull(context);
		}
		public Integer getSelectedOrderSetID()
		{
			return (Integer)cx_OCRRSelectedOrderSetID.getValue(context);
		}
		public void setSelectedOrderSetID(Integer value)
		{
			cx_OCRRSelectedOrderSetID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedOrderSetID = new ims.framework.ContextVariable("OCRR.SelectedOrderSetID", "_cv_OCRR.SelectedOrderSetID");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
