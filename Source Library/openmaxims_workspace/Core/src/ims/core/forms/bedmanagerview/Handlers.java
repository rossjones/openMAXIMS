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

package ims.core.forms.bedmanagerview;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrListsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onCcPengingEmergencyAdmsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTimer(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen(args);
			}
		});
		this.form.lyrLists().tabPageCurrentIP().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPageCurrentIPActivated();
			}
		});
		this.form.lyrLists().tabPagePendingElectiveAdmissions().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPagePendingElectiveAdmissionsActivated();
			}
		});
		this.form.lyrLists().tabElectiveListPendingElectiveAdms().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabElectiveListPendingElectiveAdmsActivated();
			}
		});
		this.form.lyrLists().tabPageBedState().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPageBedStateActivated();
			}
		});
		this.form.lyrLists().tabPageRecentDischarges().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPageRecentDischargesActivated();
			}
		});
		this.form.lyrLists().tabPagePendingEmergencyAdmissions().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPagePendingEmergencyAdmissionsActivated();
			}
		});
		this.form.lyrLists().tabPageTransfers().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPageTransfersActivated();
			}
		});
		this.form.lyrLists().tabPagePendingDischarges().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrListstabPagePendingDischargesActivated();
			}
		});
		this.form.lyrLists().tabPagePendingEmergencyAdmissions().setccPengingEmergencyAdmsValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcPengingEmergencyAdmsValueChanged();
			}
		});
		this.form.setTimerElapsedEvent(new ims.framework.delegates.TimerElapsed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException
			{
				onTimer(timer);
			}
		});
	}
	private void onlyrListstabPageCurrentIPActivated()
	{
		this.form.lyrLists().showtabPageCurrentIP();
		onlyrListsTabChanged(this.form.lyrLists().tabPageCurrentIP());
	}
	private void onlyrListstabPagePendingElectiveAdmissionsActivated()
	{
		this.form.lyrLists().showtabPagePendingElectiveAdmissions();
		onlyrListsTabChanged(this.form.lyrLists().tabPagePendingElectiveAdmissions());
	}
	private void onlyrListstabElectiveListPendingElectiveAdmsActivated()
	{
		this.form.lyrLists().showtabElectiveListPendingElectiveAdms();
		onlyrListsTabChanged(this.form.lyrLists().tabElectiveListPendingElectiveAdms());
	}
	private void onlyrListstabPageBedStateActivated()
	{
		this.form.lyrLists().showtabPageBedState();
		onlyrListsTabChanged(this.form.lyrLists().tabPageBedState());
	}
	private void onlyrListstabPageRecentDischargesActivated()
	{
		this.form.lyrLists().showtabPageRecentDischarges();
		onlyrListsTabChanged(this.form.lyrLists().tabPageRecentDischarges());
	}
	private void onlyrListstabPagePendingEmergencyAdmissionsActivated()
	{
		this.form.lyrLists().showtabPagePendingEmergencyAdmissions();
		onlyrListsTabChanged(this.form.lyrLists().tabPagePendingEmergencyAdmissions());
	}
	private void onlyrListstabPageTransfersActivated()
	{
		this.form.lyrLists().showtabPageTransfers();
		onlyrListsTabChanged(this.form.lyrLists().tabPageTransfers());
	}
	private void onlyrListstabPagePendingDischargesActivated()
	{
		this.form.lyrLists().showtabPagePendingDischarges();
		onlyrListsTabChanged(this.form.lyrLists().tabPagePendingDischarges());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
