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
// This code was generated by Callum Wells using IMS Development Environment (version 1.20 build 40818.600)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.transfer;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;
import ims.nursing.vo.TransferNote;
import ims.nursing.vo.TransferNoteCollection;
import ims.framework.FormName;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{

	protected void onFormOpen() throws FormOpenException
	{
		initialize();

		load();
	}

	private void initialize()
	{
		// Clear local contexts
		form.getLocalContext().setRecord(null);

	}

	protected void onBtnPrintClick() throws PresentationLogicException
	{
		/*
		 * if(ConfigFlag.GEN.REPORTS_TYPE.getValue().equals("Crystal"))
		 * engine.open(form.getForms().COE.RptEpisodeSummary); else
		 * if(ConfigFlag.GEN.REPORTS_TYPE.getValue().equals("QueryBuilder"))
		 * engine.open(form.getForms().Core.Reports);
		 */

		engine.open(form.getForms().Core.Reports);
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		clearScreen();
		form.grdTransfer().getRows().clear();
		form.setMode(FormMode.VIEW);
		load();
		if (form.getLocalContext().getRecord().getID_TransferNoteIsNotNull())
		{
			form.grdTransfer().setValue(form.getLocalContext().getRecord());
			onGrdTransferSelectionChanged();
		}
		else
		{
			form.getLocalContext().setRecord(null);
		}
	}

	protected ims.nursing.vo.TransferNote populateDataFromScreen(ims.nursing.vo.TransferNote value)
	{
		value = super.populateDataFromScreen(value);

		if (value == null)
			return null;

		if (value.getTransferDateIsNotNull())
		{
			if (form.timTransfer().getValue() == null)
			{
				Date date = value.getTransferDate().getDate();
				
				value.getTransferDate().setDateTime(date, new Time());
			}
		}

		if (value.getClinicalContact() == null)
			value.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		if (value.getCareContext() == null)
			value.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo) domain.getMosUser();
		if (memStaffShortVo != null && memStaffShortVo.getHcp() != null)
			value.setAuthoringCP(memStaffShortVo.getHcp());

		return value;

	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{

		TransferNote voTran = form.getLocalContext().getRecord();

		voTran = this.populateDataFromScreen(voTran);

		if (voTran == null)
			return;

		String[] errors = voTran.validate();
		if (errors != null)
		{
			engine.showErrors("Transfer Errors", errors);
			return;
		}

		try
		{
			form.getLocalContext().setRecord(domain.saveTransferNote(voTran));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			load();
			return;
		}

		clearScreen();
		load();
		form.grdTransfer().setValue(form.getLocalContext().getRecord());
		onGrdTransferSelectionChanged();
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnUpdate().setEnabled(false);
		form.getLocalContext().setRecord(form.grdTransfer().getValue());
	}

	protected void onBtnNewClick() throws PresentationLogicException
	{

		clearScreen();
		form.setMode(FormMode.EDIT);
		form.txtComments().setFocus();

		TransferNote voTran = new TransferNote();
		form.getLocalContext().setRecord(voTran);

		if (domain.getMosUser() != null)
			form.txtHCP().setValue(((MemberOfStaffShortVo) domain.getMosUser()).toString());

		form.dteRecording().setValue(new Date());
		form.timRecording().setValue(new Time());

		form.dteTransfer().setValue(new Date());
		form.timTransfer().setValue(new Time());

		form.btnUpdate().setEnabled(false);
	}

	protected void onGrdTransferSelectionChanged() throws PresentationLogicException
	{

		TransferNote voTran = form.grdTransfer().getValue();
		populateScreenFromData(voTran);
		form.getGlobalContext().COE.setTransferNote(voTran);
		form.getLocalContext().setRecord(voTran);
		form.btnUpdate().setEnabled(true);
		form.btnPrint().setEnabled(true);
	}

	protected void clearScreen()
	{
		super.clearScreen();
		form.txtHCP().setValue("");
		form.timRecording().setValue(null);
		form.dteRecording().setValue(null);
	}

	private void load()
	{
		form.setMode(FormMode.VIEW);
		form.grdTransfer().getRows().clear();
		form.btnPrint().setEnabled(false);
		form.btnUpdate().setEnabled(false);
		clearScreen();

		// cm TransferNoteCollection voColl =
		// domain.listTransferNotes(form.getGlobalContext().Core.getClinicalEpisode());.getRootContactDetails()
		TransferNoteCollection voColl = domain.listTransferNotes(form.getGlobalContext().Core.getCurrentCareContext());

		GenForm.grdTransferRow row = null;
		if (voColl != null)
		{
			for (int i = 0; i < voColl.size(); i++)
			{
				row = form.grdTransfer().getRows().newRow();

				if (voColl.get(i).getSysInfoIsNotNull() && voColl.get(i).getSysInfo().getCreationUser() != null)
				{
					MemberOfStaffShortVo mosUser = (MemberOfStaffShortVo) domain.getMosUser(voColl.get(i).getSysInfo().getCreationUser().toString());

					if (mosUser != null)
						row.setColHCP(mosUser.getName().toString());
				}
				row.setColNote(voColl.get(i).getTransferNote());
				if (voColl.get(i).getTransferDate() != null)
					row.setColDateTime(voColl.get(i).getTransferDate().toString());
				// row.setCollapsedImage()

				row.setValue(voColl.get(i));
			}
		}
	}

	protected void populateScreenFromData(ims.nursing.vo.TransferNote value)
	{
		clearScreen();
		if (value == null)
			return;

		super.populateScreenFromData(value);

		if (value.getSysInfoIsNotNull())
			this.form.timRecording().setValue(value.getSysInfo().getCreationDateTime().getTime());
		else
			this.form.timRecording().setValue(null);
		if (value.getSysInfoIsNotNull())
			this.form.dteRecording().setValue(value.getSysInfo().getCreationDateTime().getDate());
		else
			this.form.dteRecording().setValue(null);

		// if (value.getSysInfoIsNotNull() &&
		// value.getSysInfo().getCreationUser() != null)
		if (value.getAuthoringCP() != null)
			form.txtHCP().setValue(domain.getHCP(value.getAuthoringCP()).getName().toShortForm());
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.OK) && formName.equals(form.getForms().Core.Reports))
		{
			printReport();
		}
	}

	private void printReport()
	{
		if (form.getGlobalContext().COE.getTransferNote() == null || (form.getGlobalContext().COE.getTransferNoteIsNotNull() && form.getGlobalContext().COE.getTransferNote().getID_TransferNote() == null))
		{
			engine.showMessage("No Transfer Selected");
			return;
		}

		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		String[] obj = null;
		try
		{
			obj = domain.getReportAndTemplate(form.getGlobalContext().Core.getReportID(), form.getGlobalContext().Core.getTemplateID());
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage("Error retrieving report template !\r\n" + e.getMessage());
			return;
		}

		if (obj == null || obj.length == 0)
		{
			engine.showMessage("Failed to retrieve the report and template !");
			return;
		}

		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("TransferNote_id", form.getGlobalContext().COE.getTransferNote().getID_TransferNote(), Integer.class));
		client.addSeed(new SeedValue("PATIDTYPE", new Integer(PatIdType.CHARTNUM.getID()), Integer.class));
		client.addSeed(new SeedValue("Age", form.getGlobalContext().Core.getPatientShort().calculateAge(), Integer.class));

		String resultUrl = "";
		try
		{
			resultUrl = client.buildReportAsUrl(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
		}
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}

		engine.openUrl(resultUrl);
	}
}
