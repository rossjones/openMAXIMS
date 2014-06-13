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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.70 build 3545.21176)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.patientcorrespondencediagnosisdialog;

import ims.core.clinical.domain.objects.AuthoringInformation;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.framework.utils.Date;
import ims.framework.utils.PartialDate;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		// TODO Add your code here.
		
		
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		AuthoringInformationVo temp = new AuthoringInformationVo();
		Date dt = new Date();
		form.pdt2().setValue(dt.toPartialDate());
		
		temp.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		form.cc3().setValue(temp);
		/*Object hcp;
		if((hcp = domain.getHcpUser()) != null )
		{
			
			temp.setAuthoringHcp((HcpLiteVo)hcp);
			form.cc3().setValue(temp);
		}*/
	}
}
