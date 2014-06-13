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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.53 build 2641.19803)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.deployreports;

import ims.admin.forms.deployreports.GenForm.grdReportsRow;
import ims.admin.vo.SystemReportVo;
import ims.admin.vo.SystemReportVoCollection;
import ims.admin.vo.enums.ReportSearchAction;
import ims.configuration.EnvironmentConfig;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.ReportBoRefVo;
import ims.core.admin.vo.ReportBoRefVoCollection;
import ims.core.vo.TemplateBoLiteVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.io.File;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final int DEPLOY_REPORTS_CONFIRMATION_IMS_ID = 340; 
	
	//------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers region
	//------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initilize();
		
		open();
	}
	

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (form.getForms().Admin.DeployReportsConfirmation.equals(formName) && DialogResult.OK.equals(result))
		{
			deployProcess();
		}
	}
	

	@Override
	protected void onCcSearchReportsValueChanged() throws PresentationLogicException
	{
		if (ReportSearchAction.SEARCH.equals(form.ccSearchReports().getEvent()))
		{
			form.ccSearchReports().clearEvent();
			displayReports(form.ccSearchReports().getReportCollection());
		}
		else if (ReportSearchAction.CLEAR.equals(form.ccSearchReports().getEvent()))
		{
			form.ccSearchReports().clearEvent();
			clearScreen();
		}
	}
	
	
	@Override
	protected void onBtnSelectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i = 0; i < form.grdReports().getRows().size(); i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);
			
			row.setColDeploy(true);

			if(Boolean.TRUE.equals(row.getValue().getQueryEditable()))
				row.setTextColor(Color.DodgerBlue);
			else
				row.setTextColor(Color.Blue);
		}
	}

	
	@Override
	protected void onBtnUnselectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i = 0; i < form.grdReports().getRows().size(); i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);
			
			row.setColDeploy(false);
			row.setTextColor(Color.Gray);
		}
	}

	
	@Override
	protected void onGrdReportsGridCheckBoxClicked(int column, GenForm.grdReportsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
	{
		if(isChecked)
		{
			if(Boolean.TRUE.equals(row.getValue().getQueryEditable()))
				row.setTextColor(Color.DodgerBlue);
			else
				row.setTextColor(Color.Blue);
		}
		else
			row.setTextColor(Color.Gray);
	}
	

	protected void onBtnDeployClick() throws ims.framework.exceptions.PresentationLogicException
	{
		startDeployProcess();
	}


	@Override
	protected void onBtnReportsModifiedClick() throws PresentationLogicException
	{
		String[] deployReport = domain.getSystemReportAndTemplate(DEPLOY_REPORTS_CONFIRMATION_IMS_ID);

		if (deployReport == null || deployReport.length < 2)
		{
			engine.showMessage("Could not get the report and template.");
			return;
		}
		
		if (deployReport[0] == null || deployReport[1] == null)
		{
			engine.showMessage("Report was not deployed");
			return;
		}
		
		ReportBoRefVoCollection reports = getReportsForDeployment();
		
		if (reports == null || reports.size() == 0)
		{
			return;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());
		for (ReportBoRefVo report : reports)
		{
			client.addSeed(new SeedValue("Report", report.getID_ReportBo(), Integer.class));
		}
		
		try
		{
			String url = client.buildReportAsUrl(deployReport[0], deployReport[1], ConfigFlag.GEN.REPORT_SERVER_URL.getValue(), "PDF", "", 1);

			if (url != null)
				engine.openUrl(url);
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error creating report: " + e.getMessage());
			return;
		}
	}

	
	//------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//------------------------------------------------------------------------------------------------------------------------------------


	private void initilize()
	{
		form.ccSearchReports().initialize(true);
	}


	private void open()
	{
		clearScreen();
		
		form.setMode(FormMode.VIEW);
	}

	
	private void clearScreen()
	{
		//form.ccSearchReports().clear();
		form.grdReports().getRows().clear();
	}


	
	//------------------------------------------------------------------------------------------------------------------------------------
	//	Data presentation functions
	//------------------------------------------------------------------------------------------------------------------------------------

	
	private void displayReports(SystemReportVoCollection coll)
	{
		form.grdReports().getRows().clear();
		
		if (coll == null || coll.size() == 0)
		{
			engine.showMessage("No reports found."); //WDEV-16544
			return;
		}
		
		String path = EnvironmentConfig.getBaseUri();
		String fileSep = System.getProperty("file.separator");
		String loadFolder = "";
		String customerFolder = "";

		//WDEV-12195
		try
		{
			customerFolder = domain.getSiteName();
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			engine.showMessage("Can't get the customer reports folder: " + e.toString());
		}
				
		String pathFirst = "";
		
		if(!path.endsWith(fileSep))
			path += fileSep;
		
		path += "reports" + fileSep;
		
		if(customerFolder.length() > 0)
			pathFirst = path + customerFolder + fileSep;

		for (SystemReportVo report : coll)
		{
			boolean deployFromCustomerFolder  = false;
			String firstFileName = pathFirst + report.getExportFileName();
			
			loadFolder = "/reports/";
			File file = new File(firstFileName);
			
			if(file.exists())
			{
				loadFolder += customerFolder + "/";
				deployFromCustomerFolder = true;
			}
			
			grdReportsRow row = form.grdReports().getRows().newRow();
			
			row.setColDeploy(true);
			row.setColDeployReadOnly(false);
			row.setColName(report.getReportName());
			row.setColImportFile(loadFolder + report.getExportFileName());
			
			if(deployFromCustomerFolder)
			{
				row.setBackColor(Color.fromRGB(153, 255, 255));
			}
			
			row.setValue(report);
			
			if(Boolean.TRUE.equals(report.getQueryEditable()))
				row.setTextColor(Color.DodgerBlue);
			else
				row.setTextColor(Color.Blue);
		}
	}




	
	//------------------------------------------------------------------------------------------------------------------------------------
	//	Functionality functions
	//------------------------------------------------------------------------------------------------------------------------------------

	
	private void startDeployProcess()
	{
		// Collection for reports modified since last deployment
		SystemReportVoCollection modifiedSinceDeployment = getReportsModifiedSinceLastDeployment();
		
		if (modifiedSinceDeployment != null && modifiedSinceDeployment.size() > 0)
		{
			form.getGlobalContext().Admin.setReportsModifiedSinceLastDeployment(modifiedSinceDeployment);
			engine.open(form.getForms().Admin.DeployReportsConfirmation);
			return;
		}
		
		deployProcess();
	}

	
	private ReportBoRefVoCollection getReportsForDeployment()
	{
		ReportBoRefVoCollection reports = new ReportBoRefVoCollection();
		
		for (int i = 0; i < form.grdReports().getRows().size(); i++)
		{
			if (form.grdReports().getRows().get(i).getColDeploy())
			{
				reports.add(form.grdReports().getRows().get(i).getValue());
			}
		}
		
		return reports;
	}

	
	private SystemReportVoCollection getReportsModifiedSinceLastDeployment()
	{
		SystemReportVoCollection reportsModified = new SystemReportVoCollection();
		
		for (int i = 0; i < form.grdReports().getRows().size(); i++)
		{
			if (form.grdReports().getRows().get(i).getColDeploy())
			{
				SystemReportVo report = form.grdReports().getRows().get(i).getValue();

				boolean wasUpdatedSinceLastDeploy = report.getLastDeployment() != null && report.getLastUpdated() != null && report.getLastDeployment().isLessThan(report.getLastUpdated());
				
				if (wasUpdatedSinceLastDeploy || hasTemplatesUpdatedSinceLastDeploy(report))
				{
					reportsModified.add(report);
				}
			}
		}
		
		return reportsModified;
	}


	private boolean hasTemplatesUpdatedSinceLastDeploy(SystemReportVo report)
	{
		if (report == null || report.getTemplates() == null)
			return false;
		
		for (TemplateBoLiteVo template : report.getTemplates())
		{
			if (template.getLastUpdated() != null && template.getLastDeployment() != null && template.getLastDeployment().isLessThan(template.getLastUpdated()))
				return true;
		}
		
		return false;
	}


	private void deployProcess()
	{
		for (int i = 0; i < form.grdReports().getRows().size(); i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);
			row.setColStatus("");
			row.setTooltip("");
		}
		
		for (int i = 0; i < form.grdReports().getRows().size(); i++)
		{
			grdReportsRow row = form.grdReports().getRows().get(i);

			if(row.getColDeploy())
			{
				String err = null;
				try
				{
					err = domain.deployReport((SystemReportVo) row.getValue());
				}
				catch (StaleObjectException e)
				{
					e.printStackTrace();
					err = e.toString();
				}
				catch (ForeignKeyViolationException e)
				{
					e.printStackTrace();
					err = e.toString();
				}
				catch (UniqueKeyViolationException e)
				{
					e.printStackTrace();
					err = e.toString();
				}
				catch (Exception e)
				{
					e.printStackTrace();
					err = e.toString();
				}
				
				if(err != null && err.length() > 2)
				{
					row.setColStatus("Failed.");
					row.setTooltipForColStatus(err);
					row.setColStatusTextColor(Color.Red);
				}
				else
				{
					if("QT".equalsIgnoreCase(err))
						row.setColStatus("Deployed queries and templates.");
					else if("Q_".equalsIgnoreCase(err))
						row.setColStatus("Deployed query only.");
					else if("_T".equalsIgnoreCase(err))
						row.setColStatus("Deployed template only.");
					else 
						row.setColStatus("The report settings don't allow overwriting of queries or templates.");
					
					row.setColStatusTextColor(Color.Green);
				}
			}
		}
	}
}
