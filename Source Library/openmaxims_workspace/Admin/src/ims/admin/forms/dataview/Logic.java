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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2340.34011)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.dataview;

import java.util.ArrayList;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

import ims.admin.forms.dataview.GenForm.grdAuditRow;
import ims.admin.vo.ReportTemplateBoRefLiteVoCollection;
import ims.admin.vo.ReportTemplateVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.CareContextRefVoCollection;
import ims.core.vo.AuditVo;
import ims.core.vo.AuditVoCollection;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalContactShortVoCollection;
import ims.core.vo.EpisodeofCareShortVo;
import ims.core.vo.EpisodeofCareShortVoCollection;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTimeFormat;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(); 
	}

	private void initialize()
	{
		ReportTemplateBoRefLiteVoCollection classes = domain.listClassesWithTemplates();
		
		for (int i = 0; i < classes.size(); i++)
		{
			form.cmbClass().newRow(classes.get(i).getBusinessObj(), getShortClassname(classes.get(i).getBusinessObj()));
		}
		
		EpisodeofCareShortVoCollection episList = domain.listEpisodeOfCaresByPatient(form.getGlobalContext().Core.getPatientShort());
		for (int i = 0; i < episList.size(); i++)
		{
			form.cmbEpisodeOfCare().newRow(episList.get(i), getEpisodeOfCareDisplayString(episList.get(i)));
		}
		
		setDefaults();
	
	}

	private void setDefaults()
	{
		if (form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull())
		{
			form.cmbEpisodeOfCare().setValue(form.getGlobalContext().Core.getEpisodeofCareShort());
			if (form.cmbEpisodeOfCare().getValue() != null)
			{
				loadCareContexts(form.cmbEpisodeOfCare().getValue());
				if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
					form.cmbCareContext().setValue(form.getGlobalContext().Core.getCurrentCareContext());
				
				if (form.cmbCareContext().getValue() != null )
				{
					loadClinicalContacts(form.cmbCareContext().getValue());
					if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
						form.cmbClinicalContact().setValue(form.getGlobalContext().Core.getCurrentClinicalContact());
				}
					
				
			}
		}
		
	}

	private String getEpisodeOfCareDisplayString(EpisodeofCareShortVo voEpis)
	{
		String strEpisodeOfCare = "";
		if (voEpis != null)
		{
			strEpisodeOfCare = voEpis.getStartDateIsNotNull() ? voEpis.getStartDate().toString() : "";
			strEpisodeOfCare += voEpis.getEndDateIsNotNull() ? " - " + voEpis.getEndDate().toString() : " - Ongoing";
		
			if(voEpis.getResponsibleHCPIsNotNull())
				strEpisodeOfCare += " - " + voEpis.getResponsibleHCP().toString();

		}
		return strEpisodeOfCare;
	}

	private String getCareContextDisplayString(CareContextShortVo cc)
	{
		String strCareContext = cc.getStartDateTimeIsNotNull() ? cc.getStartDateTime().toString() : "";
	
		if (cc.getContextIsNotNull() && cc.getContext().equals(ims.core.vo.lookups.ContextType.INPATIENT))
			strCareContext += cc.getEndDateTimeIsNotNull() ? " - " + cc.getEndDateTime().toString() : " - Ongoing";
	
		if(cc.getContextIsNotNull())
			strCareContext += " - " + cc.getContext().getText();
		return strCareContext;
	}

	private String getShortClassname(String className)
	{
		if(className == null)
			return null;
		
		if(className.length() == 0)
			return className;
		
		int pos = className.lastIndexOf(".");
		
		if(pos < 0)
			return className;
		
		return className.substring(pos + 1);
	}

	protected void onImbClearClick() throws PresentationLogicException
	{
		clearCareContextCombo();
		form.cmbEpisodeOfCare().setValue(null);
		form.cmbClass().setValue(null);
		form.cmbClinicalContact().setValue(null);
		
		form.grdAudit().getRows().clear();
		form.dteStart().setValue(null);
		form.dteTo().setValue(null);
		
		form.ctnDetails().htmDetails().setHTML("");
	}

	protected void onImbSearchClick() throws PresentationLogicException
	{
		search();
	}

	private void search()
	{
		form.grdAudit().getRows().clear();
		form.ctnDetails().htmDetails().setHTML("");
		
		if(form.dteStart().getValue() != null && form.dteTo().getValue() == null)
		{
			engine.showMessage("'To' date is mandatory.");
			return;
		}

		if(form.dteStart().getValue() == null && form.dteTo().getValue() != null)
		{
			engine.showMessage("'From' date is mandatory.");
			return;
		}
		
		if(form.dteStart().getValue() != null 
				&& form.dteTo().getValue() != null
				&& form.dteStart().getValue().isGreaterThan(form.dteTo().getValue()))
		{
				engine.showMessage("'From' date must not be after 'To' date.");
				return;
		}
		CareContextRefVoCollection voCareContextColl = new CareContextRefVoCollection();
		if (form.cmbEpisodeOfCare().getValue() != null && form.cmbCareContext().getValues().size() > 0)
		{
			if (form.cmbCareContext().getValue() != null)
			{
				voCareContextColl.add(form.cmbCareContext().getValue());
			}
			else
			{
				ArrayList arrCareContext = form.cmbCareContext().getValues();
				for (int i=0; i<arrCareContext.size(); i++)
				{
					CareContextRefVo refVo = (CareContextRefVo)arrCareContext.get(i);
					voCareContextColl.add(refVo);
				}
			}
		}
			
		AuditVoCollection coll = domain.listAuditRecords(form.cmbClass().getValue(), form.dteStart().getValue(), form.dteTo().getValue(),voCareContextColl, form.cmbClinicalContact().getValue(),form.getGlobalContext().Core.getPatientShort());
		
		// WDEV-18111 
		if (coll == null || coll.size() == 0)
		{
			engine.showMessage("No matching records found");
		}
		
		for (int i=0; i<coll.size(); i++)
		{
			AuditVo audit = coll.get(i);
			grdAuditRow row = form.grdAudit().getRows().newRow();
			row.setValue(audit);
			
			row.setTooltip(audit.getClassName());
			row.setColumnClass(audit.getClassName());
			row.setColumnIdentifier(audit.getClassIdentifier());
			row.setColumnHost(audit.getHostName());
			if (audit.getAuditDateTime() != null)
			{
				row.setColumnDateTime(audit.getAuditDateTime().toString(DateTimeFormat.STANDARD_SECS));
			}
			if (audit.getAuditUser() != null)
				row.setColumnUser(audit.getAuditUser());
		}
		
	}

	protected void onCmbCareContextValueChanged() throws PresentationLogicException
	{
		loadClinicalContacts(form.cmbCareContext().getValue());
		
	}

	private void loadClinicalContacts(CareContextShortVo voCareContext)
	{
		form.cmbClinicalContact().clear();
		
		if(form.cmbCareContext().getValue() != null)
		{
			ClinicalContactShortVoCollection clinicalContacts = domain.listClinicalContacts(voCareContext);
			
			for (int i = 0; i < clinicalContacts.size(); i++)
			{
				form.cmbClinicalContact().newRow(clinicalContacts.get(i), getClinicalContactDisplayString(clinicalContacts.get(i)));
			}
			
		}
		
	}

	private String getClinicalContactDisplayString(ClinicalContactShortVo cc)
	{
		String strClinContact = cc.getStartDateTimeIsNotNull() ? cc.getStartDateTime().toString() : "";
		strClinContact += cc.getEndDateTimeIsNotNull() ? " - " + cc.getEndDateTime().toString() : "";
	
		if(cc.getSpecialtyIsNotNull())
			strClinContact += " - " + cc.getSpecialty().getText();
		
		if(cc.getContactTypeIsNotNull())
			strClinContact += " - " + cc.getContactType().getText();
		
		return strClinContact;
	}

	protected void onGrdAuditSelectionChanged() throws PresentationLogicException
	{
		form.ctnDetails().htmDetails().setHTML("");
		String fullClassName = getFullBoName(form.grdAudit().getValue().getClassName());
		
		if(fullClassName == null)
		{
			form.ctnDetails().htmDetails().setHTML("<BR><BR><BR><CENTER><STRONG>No template was linked to '" + form.grdAudit().getValue().getClassName() + "' business object !</STRONG></CENTER>");
		}
		else
		{
			ReportTemplateVo template = domain.getLinkedTemplate(fullClassName);
			
			String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
			String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

			QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

			client.addSeed(new SeedValue("ID", form.grdAudit().getValue().getClassIdentifier(), Integer.class));
			
			String resultUrl = "";
			try
			{
				resultUrl = client.buildReportAsUrlInlineFrame(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, QueryBuilderClient.HTML, "", 1);
			} 
			catch (QueryBuilderClientException e1)
			{
				engine.showMessage("Error creating report: " + e1.getMessage());
				return;
			}
			
			form.ctnDetails().htmDetails().setHTML(resultUrl);
		}
	}

	private String getFullBoName(String className)
	{
		ArrayList classes = form.cmbClass().getValues();
		
		for (int i = 0; i < classes.size(); i++)
		{
			if(((String)classes.get(i)).endsWith("." + className))
				return (String)classes.get(i);
		}
		
		return null;
	}

	protected void onCmbEpisodeOfCareValueChanged() throws PresentationLogicException
	{
		loadCareContexts(form.cmbEpisodeOfCare().getValue());	
	}

	private void loadCareContexts(EpisodeofCareShortVo voEpisOfCare)
	{
		clearCareContextCombo();
		
		if (voEpisOfCare != null)
		{
			CareContextShortVoCollection ccList = domain.listCareContexts(form.cmbEpisodeOfCare().getValue());
			
			for (int i = 0; i < ccList.size(); i++)
			{
				form.cmbCareContext().newRow(ccList.get(i), getCareContextDisplayString(ccList.get(i)));
			}
		}
		
	}

	private void clearCareContextCombo()
	{
		form.cmbCareContext().clear();
		form.cmbCareContext().setValue(null);
		clearClinicalContactCombo();
	}

	private void clearClinicalContactCombo()
	{
		form.cmbClinicalContact().clear();
		form.cmbClinicalContact().setValue(null);
	}
}
