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

package ims.admin.forms.cacheconfig;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.CacheConfig.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.CacheConfig domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.admin.vo.lookups.CacheUsageCollection.class, ims.admin.vo.lookups.CacheUsage.class, 1031009, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'CacheUsage' (ID: 1031009) must have at least one active instance configured.");
		}
	}
	public final String[] getLookupUsageErrors()
	{
		if(lookupUsageErrors == null)
			return null;
		String[] errors = new String[lookupUsageErrors.size()];
		for(int x = 0; x < lookupUsageErrors.size(); x++)
		{
			errors[x] = (String)lookupUsageErrors.get(x);
		}
		return errors;
	}
	protected final void bindgrdObjectListCacheUsageLookup()
	{
		this.form.grdObjectList().CacheUsageComboBox().clear();
		ims.admin.vo.lookups.CacheUsageCollection lookupCollection = ims.admin.vo.lookups.LookupHelper.getCacheUsage(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdObjectList().CacheUsageComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.CacheConfig domain;
}