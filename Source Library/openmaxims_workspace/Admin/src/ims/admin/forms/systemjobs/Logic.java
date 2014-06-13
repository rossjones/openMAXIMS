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
//This code was generated by Catalin Tomozei using IMS Development Environment (version 1.71 build 3895.20770)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.forms.systemjobs;

import ims.admin.vo.ConfiguredJobVo;
import ims.admin.vo.SystemJobVo;
import ims.admin.vo.SystemJobVoCollection;
import ims.core.vo.ConfiguredJobExecutionSummaryVo;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.controls.Timer;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.SchedulerJobStatus;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IConfiguredScheduledJob;
import ims.framework.interfaces.IScheduledJob;
import ims.framework.interfaces.ISchedulerServlet;
import ims.framework.utils.Color;
import ims.scheduler.IScheduledJobsProvider;
import ims.scheduler.SchedulerJobExecutionStatus;
import java.util.Iterator;
import java.util.TreeMap;

import javax.naming.NamingException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	public static final  Integer	COLNAME				= new Integer(-1);
	public static final  Integer	COLIMG				= new Integer(-2);
	public static final  Integer	COLTRIGGER			= new Integer(-3);

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{		
		initialize();
		open();
	}
		
	protected final void bindcmbRefreshInterval()
	{
		form.getTimers().getTimerRefresh().setEnabled(false); 
		
		form.cmbRefreshInterval().clear();	
		form.cmbRefreshInterval().newRow(0, "None");
		form.cmbRefreshInterval().newRow(2, "2 seconds");
		form.cmbRefreshInterval().newRow(5, "5 seconds");
		form.cmbRefreshInterval().newRow(10, "10 seconds");
		form.cmbRefreshInterval().newRow(30, "30 seconds");
		form.cmbRefreshInterval().setValue(0);
	}
	
	private void initialize() 
	{	
		bindcmbRefreshInterval();		
		initializeDyngrdConfiguredJobs();
		initializeDyngrdSystemJobs();
		updateContextMenu();		
	}

	private void updateContextMenu() 
	{		
		boolean isRunning = false;
		boolean isPaused = false;
		
		ConfiguredJobVo currentConfiguredJob = form.getLocalContext().getSelectedConfiguredJob();
		ISchedulerServlet servletInstance = getTaskSchedulerServlet();
		if (servletInstance == null)
		{			
			engine.showMessage("Cannot get SchedulerServletInstance");
			return ;
		}
		
		try 
		{
			isRunning = currentConfiguredJob != null ? (servletInstance.getStatus(currentConfiguredJob.getConfiguredScheduledJobID()).equals(SchedulerJobStatus.BLOCKED) ? true : false) : false;
			isPaused  = currentConfiguredJob != null ? (servletInstance.getStatus(currentConfiguredJob.getConfiguredScheduledJobID()).equals(SchedulerJobStatus.PAUSED) ? true : false) : false;
		} 
		catch (Exception e) 
		{	
			engine.showMessage("SchedulerServlet error: " + e.getMessage());
			return;
		}
		
		form.getContextMenus().Admin.getSystemJobNewItem().setVisible(form.dyngrdSystemJobs().getSelectedRow() != null ?  true: false);
		form.getContextMenus().Admin.getSystemJobEditItem().setVisible(form.dyngrdConfiguredJobs().getSelectedRow() != null ?  true: false);
		form.getContextMenus().Admin.getSystemJobRunOnceItem().setVisible((form.dyngrdConfiguredJobs().getSelectedRow() != null ?  true: false) && !isRunning && !isPaused);
		form.getContextMenus().Admin.getSystemJobPauseItem().setVisible((form.dyngrdConfiguredJobs().getSelectedRow() != null ?  true: false) && isRunning && !isPaused);
		form.getContextMenus().Admin.getSystemJobResumeItem().setVisible((form.dyngrdConfiguredJobs().getSelectedRow() != null ?  true: false) && isPaused);		
		form.getContextMenus().Admin.getSystemJobDeleteItem().setVisible((form.dyngrdConfiguredJobs().getSelectedRow() != null ?  true: false) && !isRunning && !isPaused);
		form.getContextMenus().Admin.getSystemJobViewHistoryItem().setVisible(form.dyngrdConfiguredJobs().getSelectedRow() != null ?  true: false);
	}
		
	private void open() 
	{	
		ISchedulerServlet servletInstance = getTaskSchedulerServlet();
		if (servletInstance == null)
		{			
			engine.showMessage("Cannot get SchedulerServletInstance");
			return ;
		}
		
		IScheduledJobsProvider provider = engine.getScheduledJobsProvider();		
		if (provider == null)
		{
			engine.showMessage("Cannot get ScheduledJobsProvider");
			return;
		}
		
		try 
		{			
			populateDyngrdSystemJobs(provider.getConfiguredScheduledJobs(), servletInstance);
		}
		catch (Exception err) 
		{		
			engine.showMessage(err.getMessage());
			return;
		}		
		
		updateContextMenu();
	}
		
	private DynamicGridColumn getColumnFromDynamicGridConfiguredJobs(Integer colName)
	{
		return form.dyngrdConfiguredJobs().getColumns().getByIdentifier(colName);
	}
	
	private DynamicGridColumn getColumnFromDynamicGridSystemJobs(Integer colName)
	{
		return form.dyngrdSystemJobs().getColumns().getByIdentifier(colName);
	}
		
	@Override
	protected void onDyngrdConfiguredJobsRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		form.getGlobalContext().Admin.setCurrentJobConfiguration((ConfiguredJobVo) form.dyngrdConfiguredJobs().getSelectedRow().getIdentifier());
		form.getLocalContext().setSelectedConfiguredJob((ConfiguredJobVo) form.dyngrdConfiguredJobs().getSelectedRow().getIdentifier());
		updateContextMenu();
	}
	
	private void countForConfiguredJobsForSystemJobs(IConfiguredScheduledJob[] list, SystemJobVoCollection jobs, TreeMap<IScheduledJob, Integer> map) 
	{
		for(int i = 0; i < jobs.size(); i++)
		{						
			IScheduledJob systemJob = jobs.get(i);						
			Integer count = 0;
			
			map.put(systemJob, count);
			
			for (int j = 0; j < list.length; j++) 
			{
				if (list[j].getScheduledJob().equals(jobs.get(i)))
				{
					map.put(systemJob, count += 1);					
				}
			}
		}
	}
	
	private DynamicGridRow addParentSystemRow(TreeMap<IScheduledJob, Integer> map, SystemJobVo systemJob) 
	{	
		DynamicGridRow dynRowSystemJob = form.dyngrdSystemJobs().getRows().newRow();
		DynamicGridCell systemJobCell = dynRowSystemJob.getCells().newCell(getColumnFromDynamicGridSystemJobs(COLNAME), DynamicCellType.HTMLVIEW);
		
		DynamicGridCell imgCell = dynRowSystemJob.getCells().newCell(getColumnFromDynamicGridSystemJobs(COLIMG), DynamicCellType.IMAGE);		
		imgCell.setValue(form.getImages().Admin.SystemJob32);			
		
		String 	jobText =  "<b>" + systemJob.getName() + "</b>" + " (" + map.get(systemJob)+ ")";
				jobText += "<br>";					
				jobText += systemJob.getDescription() != null ? systemJob.getDescription() : "No Description for job" + "<br>&nbsp;";
		systemJobCell.setValue(jobText);
		
		dynRowSystemJob.setSelectable(true);
		dynRowSystemJob.setIdentifier(systemJob);
		dynRowSystemJob.setValue(systemJob);
		
		return dynRowSystemJob;
	}
	
	private void addConfiguredJobRecord(SystemJobVo systemJob, IConfiguredScheduledJob configuredJob, DynamicGridRow jobRow, ISchedulerServlet servletInstance) throws Exception 
	{		
		jobRow.setIdentifier(configuredJob);
		jobRow.setValue(configuredJob);
		
		String jobName			=	"<font size='2'><b>" + configuredJob.getConfiguredScheduledJobName() + "</b></font><br>";
		String jobImageOk 		= 	"<img src='" + form.getImages().Admin.SystemJobConfigured32.getImagePath() +  "' width='35' heigth/>";
		String jobImageError 	= 	"<img src='" + form.getImages().Admin.SystemJobUnconfigured32.getImagePath() +  "'/>";
		String triggerText 		= 	configuredJob.getConfiguredScheduledJobCronExpression() != null ? "Run <font color=#0000FF>" +  configuredJob.getConfiguredScheduledJobCronExpressionText() : "No trigger for job" + "</font>";
		String lastTriggerStatus = "";
		
		if (configuredJob != null &&
				configuredJob.getConfiguredScheduledJobID() > 0)
		{			
			ConfiguredJobExecutionSummaryVo summary = domain.getHistory(configuredJob.getConfiguredScheduledJobID());
			if (summary != null && summary.getStartDateTimeIsNotNull() && summary.getEndDateTimeIsNotNull() && summary.getStatusIsNotNull())
			{
				lastTriggerStatus = " <font color=#000000>Last run: start on </font>" + summary.getStartDateTime() + "<font color=#000000> finished on </font>" + summary.getEndDateTime() + "<font color=#000000> with status: </font>" + (summary.getStatus() == null ? "Unknown" : SchedulerJobExecutionStatus.parse(summary.getStatus()) == null ? "Unknown" : (SchedulerJobExecutionStatus.parse(summary.getStatus()).toString() == "Succeeded" ? "<font color=#00FF00>" + SchedulerJobExecutionStatus.parse(summary.getStatus()).toString() + "</font>" : "<font color=#FF0000>" + SchedulerJobExecutionStatus.parse(summary.getStatus()).toString() + "</font>")); 
			}
		}
		
		DynamicGridCell jobNameCell = jobRow.getCells().newCell(getColumnFromDynamicGridConfiguredJobs(COLNAME), DynamicCellType.HTMLVIEW);	
		
		String jobImage;
		String jobText;
		String jobStatus;				
		
		try {
			if (servletInstance.getStatus(configuredJob.getConfiguredScheduledJobID()).equals(SchedulerJobStatus.ERROR))
			{
				jobImage 	= jobImageError;
				jobStatus 	= "<font color=#000000>Job Status: </font><font color=#FF0000>" + servletInstance.getStatus(configuredJob.getConfiguredScheduledJobID()) + "</font>";
			}
			else if (servletInstance.getStatus(configuredJob.getConfiguredScheduledJobID()).equals(SchedulerJobStatus.BLOCKED))
			{
				jobImage 	= jobImageOk;
				jobStatus 	= "<font color=#000000>Job Status: </font><font color=#FE2EF7>" + servletInstance.getStatus(configuredJob.getConfiguredScheduledJobID()) + "</font>";
			}
			else
			{
				jobImage 	= jobImageOk;
				jobStatus 	= "<font color=#000000>Job Status: </font><font color=#04B404>" + servletInstance.getStatus(configuredJob.getConfiguredScheduledJobID()) + "</font>";
			}
			
			jobText = "<table cellpadding='0' cellspacing='0' border='0' width='100%'><tr><td width='40' rowspan='2'>" + jobImage + "</td><td>"+ jobName +"</td></tr><tr><td>" + triggerText + "<br>" +  jobStatus + "<br>" + lastTriggerStatus + "</td></tr></table>";
		}
		catch (Exception err) 
		{		
			jobImage 	= jobImageError;
			jobText = "<table cellpadding='0' cellspacing='0' border='0' width='100%'><tr><td width='40' rowspan='2'>" + jobImage + "</td><td><font size='2' color=#FF0000><b>"+ "Trigger error!" +"</b></font></td></tr><tr><td><font color=#000000>Trigger with id " + configuredJob.getConfiguredScheduledJobID() + " has returned an error: " + "<br><font color=#0000FF><i>" +  err.getMessage() + "</i></font></td></tr></table>";
			jobRow.setSelectable(false);			
		}
			   	
		jobNameCell.setValue(jobText);						
	}
		
	private void populateDyngrdConfiguredJobs(IConfiguredScheduledJob[] configuredJobs, ISchedulerServlet servletInstance, SystemJobVo systemJob) throws Exception 
	{		
		form.dyngrdConfiguredJobs().getRows().clear();
		form.dyngrdConfiguredJobs().setFooterValue(null);
		
		int total = 0;
		
		for(int i = 0; i < configuredJobs.length; i++)
		{
			if (configuredJobs[i].getScheduledJob().getScheduledJobID()== systemJob.getID_SystemJob())
			{
				addConfiguredJobRecord(systemJob, configuredJobs[i], form.dyngrdConfiguredJobs().getRows().newRow(), servletInstance);	
				total ++;
			}
		}	
		
		form.dyngrdConfiguredJobs().setFooterValue("Total: " +  total + " configured jobs");
	}
	
	private void populateDyngrdSystemJobs(IConfiguredScheduledJob[] configuredJobs, ISchedulerServlet servletInstance) throws Exception 
	{
		TreeMap<IScheduledJob, Integer> map = new TreeMap<IScheduledJob, Integer>();				
		
		SystemJobVoCollection availableJobs = domain.listAvailableSystemJobs();
		
		countForConfiguredJobsForSystemJobs(configuredJobs, availableJobs, map);
		form.dyngrdSystemJobs().getRows().clear();		
		
		for (Iterator iter = map.keySet().iterator(); iter.hasNext();) 
		{
			SystemJobVo systemJob = (SystemJobVo) iter.next();
			addParentSystemRow(map, systemJob);			
		}
		
		form.dyngrdSystemJobs().setFooterValue("Total: " +  availableJobs.size() + " available system jobs");
		
		form.dyngrdSystemJobs().setValue(form.getGlobalContext().Admin.getSystemJob());	
		if (form.dyngrdSystemJobs().getSelectedRow() != null)
		{
			onDyngrdSystemJobsRowSelectionChanged(form.dyngrdSystemJobs().getSelectedRow());
		}	
	}
	
	private void initializeDyngrdConfiguredJobs() 
	{
		form.dyngrdConfiguredJobs().clear();
		form.dyngrdConfiguredJobs().setSelectable(true);
		
		DynamicGridColumn colName = form.dyngrdConfiguredJobs().getColumns().newColumn("Configured Jobs", COLNAME);
		colName.setWidth(-1);
	}
	
	private void initializeDyngrdSystemJobs() 
	{
		form.dyngrdSystemJobs().clear();
		form.dyngrdSystemJobs().setSelectable(true);
		
		DynamicGridColumn colImg = form.dyngrdSystemJobs().getColumns().newColumn("", COLIMG);
		colImg.setWidth(45);
		colImg.setCanGrow(false);
		colImg.setAlignment(Alignment.CENTER);	
		
		DynamicGridColumn colName = form.dyngrdSystemJobs().getColumns().newColumn("Available Jobs", COLNAME);
		colName.setWidth(-1);
	}
	
	private Integer getImsId()
	{
		if (form.dyngrdConfiguredJobs().getSelectedRow() != null)
		{
			return ((ConfiguredJobVo)form.dyngrdConfiguredJobs().getSelectedRow().getIdentifier()).getID_ConfiguredJob();
		}
		
		return null;
	}
	
	private ISchedulerServlet getTaskSchedulerServlet()
	{
		try 
		{
			return ims.configuration.JNDI.getTaskSchedulerServlet();
		} 
		catch (NamingException err) 
		{		
			engine.showMessage(err.getMessage());
			return null;
		}
	}			
	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result)
			throws PresentationLogicException 
	{		
		open();		
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{	
		switch (menuItemID)
		{
			case GenForm.ContextMenus.AdminNamespace.SystemJob.New:
				engine.open(form.getForms().Admin.SystemJobDetails);
			break;
			case GenForm.ContextMenus.AdminNamespace.SystemJob.Edit:		
				engine.open(form.getForms().Admin.SystemJobDetails, new Object[] {form.getLocalContext().getSelectedConfiguredJob()});				
			break;
			case GenForm.ContextMenus.AdminNamespace.SystemJob.RunOnce:				
				try
				{
					ISchedulerServlet instance = getTaskSchedulerServlet();
					if (instance != null)
					{
						Integer imsId = getImsId();
						if (imsId == null)
							return;
						
						instance.run(imsId);
				 	}
				}
				
				catch (Exception exception)
				{
					engine.showMessage(exception.getMessage());
					return;
				}
				
				open();	
				
			break;
			case GenForm.ContextMenus.AdminNamespace.SystemJob.Pause:
								
				try
				{
					ISchedulerServlet instance = getTaskSchedulerServlet();	
					if (instance != null)
					{
						Integer imsId = getImsId();
						if (imsId == null)
							return;
						
						instance.pause(imsId);
					}
				}
				catch (Exception exception)
				{
					engine.showMessage(exception.getMessage());
					return;
				}
				open();	
				
			break;
			case GenForm.ContextMenus.AdminNamespace.SystemJob.Resume:
				
				try
				{
					ISchedulerServlet instance = getTaskSchedulerServlet();
					if (instance != null)
					{
						Integer imsId = getImsId();
						if (imsId == null)
							return;
						
						instance.resume(imsId);
					}
				}
				catch (Exception exception)
				{
					engine.showMessage(exception.getMessage());
					return;
				}
				open();	
				
			break;
			case GenForm.ContextMenus.AdminNamespace.SystemJob.Delete:		
				
				try
				{
					ISchedulerServlet servletInstance = getTaskSchedulerServlet();
					if (servletInstance != null)
					{
						Integer imsId = getImsId();
						
						if (imsId == null)
							return;
						
						IScheduledJobsProvider provider = engine.getScheduledJobsProvider();						
						IConfiguredScheduledJob configuredJob = provider.getConfiguredScheduledJob(imsId);
						if (configuredJob != null)
						{
							//cleanup Configured Scheduled Job Settings
							provider.cleanUpConfiguredScheduledJobSettings(configuredJob.getConfiguredScheduledJobID());
							
							//Inactivate Configured Job
							ConfiguredJobVo vo = domain.getConfiguredJobVo(configuredJob.getConfiguredScheduledJobID());	
							vo.setIsActive(false);
							String[] errors = vo.validate();		
							if (errors != null)
							{
								engine.showErrors(errors);
								return;
							}
							domain.saveSystemJobDetails(vo);		
							
							// delete job from quartz
							servletInstance.delete(imsId);
							form.getLocalContext().setSelectedConfiguredJob(null);
						}
					}			
				}
				catch (Exception exception)
				{
					engine.showMessage(exception.getMessage());
					return;
				}				
				
				open();
				
			break;
			case GenForm.ContextMenus.AdminNamespace.SystemJob.ViewHistory:
				showJobHistory();
			break;
		}
	}

	private void showJobHistory() 
	{
		engine.open(form.getForms().Admin.SystemJobHistory);		
	}

	@Override
	protected void onTimer(Timer timer) throws PresentationLogicException 
	{	
		open();
	}

	@Override
	protected void onCmbRefreshIntervalValueChanged() throws PresentationLogicException 
	{	
		if (form.cmbRefreshInterval().getValue() == null)
		{
			engine.showMessage("Please select refresh interval");
			form.getTimers().getTimerRefresh().setEnabled(false);
			form.cmbRefreshInterval().setValue(0);			
		}
		else if (form.cmbRefreshInterval().getValue() == 0)
		{
			form.getTimers().getTimerRefresh().setEnabled(false);
			return;
		}
		else
		{
			form.getTimers().getTimerRefresh().setEnabled(false);
			form.getTimers().getTimerRefresh().setInterval(form.cmbRefreshInterval().getValue());
			form.getTimers().getTimerRefresh().setEnabled(true);
		}
	}

	@Override
	protected void onDyngrdSystemJobsRowSelectionChanged(DynamicGridRow row) throws PresentationLogicException 
	{
		ISchedulerServlet servletInstance = getTaskSchedulerServlet();
		if (servletInstance == null)
		{			
			engine.showMessage("Cannot get SchedulerServletInstance");
			return ;
		}
		
		IScheduledJobsProvider provider = engine.getScheduledJobsProvider();		
		if (provider == null)
		{
			engine.showMessage("Cannot get ScheduledJobsProvider");
			return;
		}
		
		try 
		{	
			form.getGlobalContext().Admin.setSystemJob((SystemJobVo)row.getIdentifier());
			populateDyngrdConfiguredJobs(provider.getConfiguredScheduledJobs(), servletInstance, (SystemJobVo)row.getIdentifier());			
		}
		catch (Exception err) 
		{		
			engine.showMessage(err.getMessage());
			return;
		}		
		
		updateContextMenu();
	}
}
