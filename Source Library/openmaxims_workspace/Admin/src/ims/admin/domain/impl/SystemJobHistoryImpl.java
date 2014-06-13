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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.80 build 3999.26423)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.admin.domain.base.impl.BaseSystemJobHistoryImpl;
import ims.core.vo.domain.ConfiguredJobExecutionSummaryVoAssembler;
import ims.domain.DomainFactory;

public class SystemJobHistoryImpl extends BaseSystemJobHistoryImpl
{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public ims.core.vo.ConfiguredJobExecutionSummaryVoCollection getHistory(ims.core.configuration.vo.ConfiguredJobRefVo job)
	{
		DomainFactory factory = getDomainFactory();		
		List history = factory.find("from ConfiguredJobExecutionSummary job where job.configuredJob.id = " + job.getID_ConfiguredJob() + " order by id desc", 200);
		return ConfiguredJobExecutionSummaryVoAssembler.createConfiguredJobExecutionSummaryVoCollectionFromConfiguredJobExecutionSummary(history);
	}
}
