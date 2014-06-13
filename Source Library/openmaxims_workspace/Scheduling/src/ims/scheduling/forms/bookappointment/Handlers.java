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

package ims.scheduling.forms.bookappointment;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbPriorityLookup();
	abstract protected void defaultcmbPriorityLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbRefreshClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbSpecialtyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPriorityValueSet(Object value);
	abstract protected void onBtnBookClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviousSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSessionSlotsGridCheckBoxClicked(int column, GenForm.grdSessionSlotsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBookingCalendar1DateSelected(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBookingCalendar1MonthSelected(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNextSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.imbRefresh().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbRefreshClick();
			}
		});
		this.form.btnClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCloseClick();
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.cmbSpecialty().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbSpecialtyValueChanged();
			}
		});
		this.form.cmbPriority().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPriorityValueSet(value);
			}
		});
		this.form.btnBook().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookClick();
			}
		});
		this.form.btnPreviousSession().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviousSessionClick();
			}
		});
		this.form.grdSessionSlots().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSessionSlotsGridCheckBoxClicked(column, new GenForm.grdSessionSlotsRow(row), isChecked);
			}
		});
		this.form.bookingCalendar1().setBookingCalendarDateSelectedEvent(new BookingCalendarDateSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException
			{
				onBookingCalendar1DateSelected(date);
			}
		});
		this.form.bookingCalendar1().setBookingCalendarMonthSelectedEvent(new BookingCalendarMonthSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException
			{
				onBookingCalendar1MonthSelected(date);
			}
		});
		this.form.btnNextSession().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNextSessionClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbPriorityLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbPriorityLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbPriorityLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
