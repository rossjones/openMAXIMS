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

package ims.training.vo.enums;

public final class AppSearchAction2 extends ims.framework.utils.Enum
{
	public final static AppSearchAction2 NONE = new AppSearchAction2(0, "NONE", null, ims.framework.utils.Color.Default);
	public final static AppSearchAction2 NEW = new AppSearchAction2(1, "NEW", null, ims.framework.utils.Color.Default);
	public final static AppSearchAction2 EDIT = new AppSearchAction2(2, "EDIT", null, ims.framework.utils.Color.Default);
	public final static AppSearchAction2 SELECTION_CHANGED = new AppSearchAction2(3, "SELECTION_CHANGED", null, ims.framework.utils.Color.Default);

	private AppSearchAction2(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
