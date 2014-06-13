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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.70 build 3453.13770)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.rules.forms.rulexmlimport;

import ims.admin.vo.BusinessRuleVo;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.rules.exceptions.RulesEngineDeserializationException;
import ims.rules.helper.Entities;
import ims.rules.interfaces.IRule;
import ims.rules.utils.RuleXmlSerialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	//---------------------------------------------------------------------------------------------------------------------------------------------
	//	EVENTS REGION
	//---------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 
	 */
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{ 
		initialize();
		open();
	}
	
	/**
	 * 
	 */
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	/**
	 * 
	 */
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	/**
	 * 
	 */
	protected void onBtnImportClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
	}
	
	/**
	 * 
	 */
	protected void onfileupldXMLImportFileUploaded(String fileName)
	{
		try
		{
			// Uploaded file path
			String path = buildUploadPath() + "\\" + getBaseName(fileName);
			
			File file = new File(path);
			BufferedReader bufRead = new BufferedReader(new FileReader(file));
			StringBuffer strBuf = new StringBuffer();
			
			String line;
			while ((line = bufRead.readLine()) != null)
			{
				strBuf.append(line);
			}
			
			bufRead.close();
			
			IRule ruleInterface = RuleXmlSerialization.deserializeFromXml(strBuf.toString(), Entities.getInstance());
			
			// Create a new instance of BusinessRuleVo
			BusinessRuleVo rule = new BusinessRuleVo();

			// Initialize the VO
			rule.setName(ruleInterface.getName());
			rule.setDescription(ruleInterface.getDescription());
			rule.setValidFrom(ruleInterface.getValidFrom());
			rule.setValidTo(ruleInterface.getValidTo());
			rule.setPriority(ruleInterface.getPriority());
			rule.setXmlContent(strBuf.toString());
			rule.setActive(Boolean.FALSE);
			rule.setRootEntity(ruleInterface.getRootEntity().getName());
			
			// Set the global context
			form.getGlobalContext().Rules.setRuleToEdit(rule);
			
			// Close this form
			engine.close(DialogResult.OK);
		}
		catch (FileNotFoundException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (IOException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (DOMException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (SAXException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (ParseException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (RulesEngineDeserializationException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (Exception e)
		{
			engine.showMessage(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	protected void onfileupldXMLImportFileSelected(String fileName)
	{
		// TODO Add your code here.
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//	FORM FUNCTIONS
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	public void initialize() throws FormOpenException
	{
		// TODO Auto-generated method stub
		super.initialize();
	}
	
	/**
	 * 
	 */
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	
	/**
	 * 
	 */
	public void updateControlsState()
	{
		// TODO: Add you code here.
	}
	
	/**
	 * 
	 */
	public void clearInstanceControls()
	{
		// TODO: Add you code here.
	}
	
	/**
	 * 
	 */
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	
	/**
	 * 
	 */
	public void updateInstance()
	{
		// TODO: Add you code here.
	}

	/**
	 * 
	 */
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
		return false;
	}


	private String getBaseName(String fullFileName)
	{
		int ind = fullFileName.lastIndexOf("/");
		if (ind == -1)
		{
			ind = fullFileName.lastIndexOf("\\");			
		}
		if (ind == -1)
			return fullFileName;
		
		if (ind + 1 == fullFileName.length())
			return "";
		
		return fullFileName.substring(ind + 1);
	}

	private String buildUploadPath()
	{
		String path = EnvironmentConfig.getBaseUri();
		
		if (path == null || (path != null && path.length() == 0))
		{
			throw new RuntimeException("Config Flag BASE_URI is null or empty");
		}
		
		return (path + "\\" + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "\\ObjectImports");
	}
}
