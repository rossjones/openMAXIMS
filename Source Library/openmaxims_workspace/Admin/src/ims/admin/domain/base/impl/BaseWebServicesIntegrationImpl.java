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

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseWebServicesIntegrationImpl extends DomainImpl implements ims.admin.domain.WebServicesIntegration, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesetPatientIdentifierTypeAndValue(String identifierType, String identifierValue)
	{
		if(identifierType == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'identifierType' of type 'String' cannot be null.");
		if(identifierValue == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'identifierValue' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesetPatientIdentifierType(String sessionToken, String identifierType)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
		if(identifierType == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'identifierType' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesetPatientIdentifier(String sessionToken, String identifier)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
		if(identifier == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'identifier' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesetUserLocation(String sessionToken, String location)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
		if(location == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'location' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesetUserRole(String sessionToken, String role)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
		if(role == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'role' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesetStartupForm(String sessionToken, String form)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
		if(form == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'form' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validaterestrictPatientAccess(String sessionToken, String restrict)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
		if(restrict == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'restrict' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetSecurityToken(String sessionToken)
	{
		if(sessionToken == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'sessionToken' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatebuildReport(String templateId, String imsId, String templateName, String reportId, String format)
	{
	}

	@SuppressWarnings("unused")
	public void validatebuildReportAsUrl(String templateId, String imsId, String templateName, String reportId, String format)
	{
	}

	@SuppressWarnings("unused")
	public void validatebuildReportAsUrlInlineFrame(String templateId, String imsId, String templateName, String reportId, String format)
	{
	}

	@SuppressWarnings("unused")
	public void validateaddSeed(String name, String value)
	{
		if(name == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'name' of type 'String' cannot be null.");
		if(value == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'value' of type 'String' cannot be null.");
	}
}
