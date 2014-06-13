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

package ims.assessment.domain;

// Generated from form domain impl
public interface AssessmentFavourites extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list Graphic Assessments
	*/
	public ims.assessment.vo.GraphicAssessmentShortVoCollection listGraphicAssessment(String name);

	// Generated from form domain interface definition
	/**
	* get Graphic Assessment
	*/
	public ims.assessment.vo.GraphicAssessmentVo getGraphicAssessment(ims.assessment.configuration.vo.GraphicAssessmentRefVo graphicRefVo);

	// Generated from form domain interface definition
	/**
	* Returns a Favourite
	*/
	public ims.assessment.vo.UserPatientAssessmentFavouritesVo getFavourite(ims.core.resource.people.vo.HcpRefVo hcpRefVo);

	// Generated from form domain interface definition
	/**
	* Favourite
	*/
	public ims.assessment.vo.UserPatientAssessmentFavouritesVo saveFavourite(ims.assessment.vo.UserPatientAssessmentFavouritesVo favouriteVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list Userassessments
	*/
	public ims.assessment.vo.UserAssessmentShortVoCollection listUserAssessments(String name);

	// Generated from form domain interface definition
	/**
	* User Defined Oject
	*/
	public ims.assessment.vo.UserAssessmentVo getUserAssessment(ims.assessment.configuration.vo.UserAssessmentRefVo userassessRefVo);
}
