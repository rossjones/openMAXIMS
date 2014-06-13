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

package ims.admin.domain;

// Generated from form domain impl
public interface ReportTemplateBoRef extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List all templates matching the given search criteria
	*/
	public ims.admin.vo.ReportTemplateVoCollection listTemplates(String searchFilter);

	// Generated from form domain interface definition
	/**
	* Returns the template assigned to the currently selected Business Object
	*/
	public ims.admin.vo.ReportTemplateBoRefVo getAssignedTemplate(String businessObject);

	// Generated from form domain interface definition
	/**
	* Saves the given report template and valueobject relationship
	*/
	public ims.admin.vo.ReportTemplateBoRefVo saveAssignedTemplates(ims.admin.vo.ReportTemplateBoRefVo reference) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* listDomainObjectClasses
	*/
	public String[] listDomainObjectClasses();

	// Generated from form domain interface definition
	/**
	* listAssignedTemplates
	*/
	public ims.admin.vo.ReportTemplateBoRefVoCollection listAssignedTemplates();

	// Generated from form domain interface definition
	/**
	* removeLink
	*/
	public void removeLink(ims.core.admin.vo.ReportTemplateBoRefRefVo item) throws ims.domain.exceptions.ForeignKeyViolationException;
}
