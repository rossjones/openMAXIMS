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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3539.20347)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.webpaslaunchdialog;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		String url = buildWebPasUrl();
		if(engine.isValidUrl(url))
		{	
			engine.openUrl(url);
			engine.close(DialogResult.OK);
		}
		else
		{
			engine.showErrors(new String[]{"Invalid MAXIMS WebPas URL please check Configuration", "URL : " + url });
		}
	}

	private String buildWebPasUrl()
	{
		String url = ConfigFlag.UI.MAXIMS_WEBPAS_URL.getValue();
		
		if(engine.getLoggedInUser() != null)
			url += engine.getLoggedInUser().getUsername();
		if(form.getGlobalContext().Core.getPatientShortIsNotNull() && form.getGlobalContext().Core.getPatientShort().getHospnum() != null)
			url += "&hospnum=" + form.getGlobalContext().Core.getPatientShort().getHospnum().getValue();
		
		try
		{
			url += "&id=" + domain.getWebPASSecurityCode();
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
		}
		return url;
	}
}
