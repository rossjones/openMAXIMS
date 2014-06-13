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

package ims.admin.forms.mossearch;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	/**
	* Lists members of staff based on the last search carried out.
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff();

	/**
	* this flag determines whether the component searches for MembersOfStaff or HcpLites.
	*/
	public void setHCPType(Boolean boolHCP);

	/**
	* List HcpLites based on the last search carried out.
	*/
	public ims.core.vo.HcpLiteVoCollection listHCPLites();

	public void clear();

	public void initializeComponent(Boolean boolHCP);

	/**
	* get last action
	*/
	public ims.admin.vo.enums.MOSSearchLastAction getActionEvent();

	public void refreshGrid();

	public void setActionEvent(ims.admin.vo.enums.MOSSearchLastAction action);
}
