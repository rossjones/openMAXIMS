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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface OPDMedicalNotes extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Save the OPDGenNotesVo
	*/
	public void saveOPDGenNotesVo(ims.generalmedical.vo.OPDGenNotesVo voOPDGenNotes) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Return OPDGenNotes record by care context.
	*/
	public ims.generalmedical.vo.OPDGenNotesVo getOPDGenNotesByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	/**
	* list OPD Gen Notes By Episode Of Care
	*/
	public ims.generalmedical.vo.OPDGenNotesShortVoCollection listOPDGenNotesByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo voEpisodeOfCare);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);
}
