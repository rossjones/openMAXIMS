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
public interface AuditList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List Audit Records based on the search criteria passed as parameters to the method
	*/
	public ims.core.vo.AuditVoCollection listAuditRecords(ims.core.vo.AuditListFilterVo filter);

	// Generated from form domain interface definition
	/**
	* List all app users for the combo
	*/
	public ims.admin.vo.AppUserShortVoCollection listAppUsers(String name);

	// Generated from form domain interface definition
	/**
	* Returns a list of domain class names
	*/
	public String[] listDomainClassNames();

	// Generated from form domain interface definition
	/**
	* Returns the RecordedInError record for the given classId and Name
	*/
	public ims.admin.vo.RecordedInErrorVo getRIEReason(Integer boClassId, String boClassName);

	// Generated from form domain interface definition
	/**
	* Lists all active locations for the given value
	*/
	public ims.core.vo.LocationLiteVoCollection listActiveLocations(String value);

	// Generated from form domain interface definition
	public String getObjectXML(String className, Integer objectId) throws ims.domain.exceptions.StaleObjectException;
}
