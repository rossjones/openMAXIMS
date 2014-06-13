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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.domain.base.impl.BaseScreeningOverviewImpl;
import ims.assessment.vo.ScreeningOverviewVo;
import ims.assessment.vo.ScreeningOverviewVoCollection;
import ims.core.vo.CareContextShortVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;

import java.util.List;

public class ScreeningOverviewImpl extends BaseScreeningOverviewImpl
{

	private static final long serialVersionUID = 1L;

	public ScreeningOverviewVoCollection listProfilesByContextType(CareContextShortVo careContext)
	{
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find("select s2_1.id, u1_1.id, u1_1.name, g1_1.id, g1_1.name, g1_1.activeStatus.id from ScreeningProfile as s1_1 left join s1_1.profileComponents as s2_1 left join s2_1.userAssessment as u1_1 left join s2_1.graphic as g1_1 where (s1_1.contextType.id = :CONTEXT_ID  and  (u1_1.activeStatus.id = -617 or g1_1.activeStatus.id = -617) and s1_1.activeStatus.id = -617) order by s2_1.id asc ", new String[] {"CONTEXT_ID"}, new Object[] {new Integer(careContext.getContext().getID())});
		
		ScreeningOverviewVoCollection coll = new ScreeningOverviewVoCollection();
		StringBuilder sbUA = new StringBuilder();
		StringBuilder sbGA = new StringBuilder();
		
		for (int i = 0; i < list.size(); i++)
		{
			ScreeningOverviewVo item = new ScreeningOverviewVo();
			
			Object[] listItem = (Object[]) list.get(i);
			
			item.setScreenProfileComponentID((Integer)listItem[0]);
			item.setUserAssessmentID((Integer)listItem[1]);
			item.setUserAssessmentName((String)listItem[2]);
			item.setGraphicAssessmentID((Integer)listItem[3]);
			item.setGraphicAssessmentName((String)listItem[4]);
			
			coll.add(item);
			
			if(item.getUserAssessmentIDIsNotNull())
			{
				if(sbUA.length() > 0)
					sbUA.append(", ");
				
				sbUA.append(item.getUserAssessmentID());
			}
			
			if(item.getGraphicAssessmentIDIsNotNull())
			{
				if(sbGA.length() > 0)
					sbGA.append(", ");
				
				sbGA.append(item.getGraphicAssessmentID());
			}
			
		}
		
		List listUA = null;
		List listGA = null;
		
		if(sbUA.length() > 0)
			listUA = factory.find("select p2_1.userAssessment.id, p1_1.status.text, p1_1.id from PatientAssessment as p1_1 join p1_1.assessmentData as p2_1 left join p1_1.status as l1_1 where p1_1.careContext.id = :CARE_CONTEXT_ID and p2_1.userAssessment.id in (" + sbUA + ")", new String[] {"CARE_CONTEXT_ID"}, new Object[] {new Integer(careContext.getID_CareContext())});
		if(sbGA.length() > 0)
			listGA = factory.find("select p2_1.graphic.id, p1_1.status.text, p1_1.id from PatientAssessment as p1_1 join p1_1.assessmentData as p2_1 left join p1_1.status as l1_1 where p1_1.careContext.id = :CARE_CONTEXT_ID and p2_1.graphic.id in (" + sbGA + ")", new String[] {"CARE_CONTEXT_ID"}, new Object[] {new Integer(careContext.getID_CareContext())});

		if(listUA != null)
		{
			for (int i = 0; i < listUA.size(); i++)
			{
				Object[] listItem = (Object[]) listUA.get(i);
				
				for (int j = 0; j < coll.size(); j++)
				{
					ScreeningOverviewVo item = coll.get(j);
					
					if(listItem[0].equals(item.getUserAssessmentID()))
					{
						item.setPatientAssessmentID((Integer)listItem[2]);
						item.setStatus((String)listItem[1]);
					}
				}
			}
		}
		
		if(listGA != null)
		{
			for (int i = 0; i < listGA.size(); i++)
			{
				Object[] listItem = (Object[]) listGA.get(i);
				
				for (int j = 0; j < coll.size(); j++)
				{
					ScreeningOverviewVo item = coll.get(j);
					
					if(listItem[0].equals(item.getGraphicAssessmentID()))
					{
						item.setPatientAssessmentID((Integer)listItem[2]);
						item.setStatus((String)listItem[1]);
					}
				}
			}
		}
		
		return coll;
	}

	public String getActiveProfileName(CareContextShortVo careContext) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find("select s1_1.profileName from ScreeningProfile as s1_1 where (s1_1.contextType.id = :CONTEXT_ID  and s1_1.activeStatus.id = -617) ", new String[] {"CONTEXT_ID"}, new Object[] {new Integer(careContext.getContext().getID())});

		if(list.size() > 1)
			throw new DomainInterfaceException("There is more than one active record saved against the current context type !");
		else if(list.size() == 0)
			return null;
		else
			return (String)list.get(0);
	}
}
