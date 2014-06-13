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

package ims.admin.forms.useremailaccount;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Admin = new AdminContext(context);
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAppUserVoIsNotNull()
		{
			return !cx_AdminAppUserVo.getValueIsNull(context);
		}
		public ims.admin.vo.AppUserVo getAppUserVo()
		{
			return (ims.admin.vo.AppUserVo)cx_AdminAppUserVo.getValue(context);
		}
		public void setAppUserVo(ims.admin.vo.AppUserVo value)
		{
			cx_AdminAppUserVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminAppUserVo = new ims.framework.ContextVariable("Admin.AppUserVo", "_cv_Admin.AppUserVo");
		public boolean getuserEmailAccountIsNotNull()
		{
			return !cx_AdminuserEmailAccount.getValueIsNull(context);
		}
		public ims.admin.vo.UserEmailAccountVo getuserEmailAccount()
		{
			return (ims.admin.vo.UserEmailAccountVo)cx_AdminuserEmailAccount.getValue(context);
		}
		public void setuserEmailAccount(ims.admin.vo.UserEmailAccountVo value)
		{
			cx_AdminuserEmailAccount.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminuserEmailAccount = new ims.framework.ContextVariable("Admin.userEmailAccount", "_cv_Admin.userEmailAccount");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
}
