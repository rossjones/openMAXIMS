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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.71 build 3832.22959)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import ims.icp.domain.base.impl.BaseICPConfigLinkActionsImpl;
import ims.icp.vo.ICPConfigurationDisplayVo;
import ims.icp.vo.domain.ICPConfigurationDisplayVoAssembler;
import ims.icps.configuration.domain.objects.ICP;

public class ICPConfigLinkActionsImpl extends BaseICPConfigLinkActionsImpl
{

	private static final long serialVersionUID = 1L;

	public ICPConfigurationDisplayVo getDisplayICP(ims.icps.configuration.vo.ICPRefVo icpRef)
	{
		// Check parameter
		if (icpRef == null || !icpRef.getID_ICPIsNotNull())
			return null;

		// Return the ICP for display
		return ICPConfigurationDisplayVoAssembler.create((ICP) getDomainFactory().getDomainObject(ICP.class, icpRef.getID_ICP()));
	}
}
