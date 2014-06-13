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

package ims.clinical.domain;

// Generated from form domain impl
public interface SurgicalAuditProcedureStaffDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getLocationLite(ims.core.resource.place.vo.LocationRefVo locRef);

	// Generated from form domain interface definition
	public ims.core.vo.MedicLiteVoCollection getMedics(ims.core.resource.place.vo.LocationRefVo locRef, ims.core.vo.lookups.HcpDisType hcpType, ims.core.vo.lookups.HcpDisType medicType, ims.core.vo.lookups.MedicGrade medicGrade);

	// Generated from form domain interface definition
	public ims.core.vo.NurseVoCollection getNurses(ims.core.resource.place.vo.LocationRefVo locRef, ims.core.vo.lookups.HcpDisType hcpType);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection getOtheDisciplineHcp(ims.core.resource.place.vo.LocationRefVo locationRef, ims.core.vo.lookups.HcpDisType hcpDisType);
}
