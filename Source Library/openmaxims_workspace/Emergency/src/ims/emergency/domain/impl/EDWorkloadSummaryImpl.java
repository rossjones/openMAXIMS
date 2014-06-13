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
// This code was generated by Ancuta Ciubotaru using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.domain.DomainFactory;
import ims.emergency.configuration.vo.TrackingAreaRefVo;
import ims.emergency.domain.base.impl.BaseEDWorkloadSummaryImpl;
import ims.emergency.vo.MosLiteEDVoCollection;
import ims.emergency.vo.TrackingAreaVoCollection;
import ims.emergency.vo.domain.MosLiteEDVoAssembler;
import ims.emergency.vo.domain.TrackingAreaVoAssembler;
import ims.emergency.vo.lookups.TriagePriority;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class EDWorkloadSummaryImpl extends BaseEDWorkloadSummaryImpl
{

	private static final long serialVersionUID = 1L;

	
	public TrackingAreaVoCollection getAreas(ILocation location) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		
		hql.append("select  t2_1 ");
		hql.append(" from TrackingConfiguration as t1_1 left join t1_1.eDLocation as l1_1 left join t1_1.areas as t2_1 left join t2_1.status as l2_1");
		hql.append(" where ");
		hql.append("(l1_1.id = :Location_id and t1_1.isActive = 1 and l2_1.id = :lookup_inst and  (t2_1.isOverallView = 0 or t2_1.isOverallView is null ))");
		
		List<?> list = factory.find(hql.toString(), new String[] {"Location_id","lookup_inst"}, new Object[] {location.getID(),ims.core.vo.lookups.PreActiveActiveInactiveStatus.ACTIVE.getID()});
		
		return TrackingAreaVoAssembler.createTrackingAreaVoCollectionFromTrackingArea(list);
	}

	
	public String getAwaitingTriageCounts(ILocation currentLocation,TrackingAreaRefVo area) {
		// TODO Auto-generated method stub
		
		if (currentLocation == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient) ");			
		hql.append(" from Tracking as t1_1 left join t1_1.currentStatus as t2_1 left join t2_1.status as l1_1");
		hql.append(" where ");
		hql.append("(t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and l1_1.id = :lookup_inst and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null ))");
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id","lookup_inst"}, new Object[] {currentLocation.getID(),area.getID_TrackingArea(),ims.emergency.vo.lookups.TrackingStatus.WAITING_TO_BE_TRIAGED.getID()});
		
		return list.get(0).toString();
	}

	
	public String getPriorityXCounts(ILocation location, TrackingAreaRefVo area,TriagePriority lookup) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient)");			
		hql.append(" from Tracking as t1_1 left join t1_1.triageDetails as t2_1 left join t2_1.currentTriagePriority as l1_1 left join l1_1.type as l2_1");
		hql.append(" where ");
		hql.append("(t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and l1_1.id = :lookup_inst and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null ))");
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id","lookup_inst"}, new Object[] {location.getID(),area.getID_TrackingArea(),lookup.getID()});
		
		return list.get(0).toString();		
	}



	public String getUnallocated(ILocation location, TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient)");			
		hql.append(" from Tracking as t1_1");
		hql.append(" where ");
		hql.append("(t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and t1_1.seenBy is null  and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null ))");//WDEV-16816
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id"}, new Object[] {location.getID(),area.getID_TrackingArea()});
		
		return list.get(0).toString();
				
	}


	
	public String getAllocated(ILocation location, TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient)");			
		hql.append(" from Tracking as t1_1");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and  (t1_1.seenBy.allocatedMedic is not null  or t1_1.seenBy.allocatedNurse is not null ) and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null ))");//WDEV-16816
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id"}, new Object[] {location.getID(),area.getID_TrackingArea()});
		
		return list.get(0).toString();
	}


	
	public String getReferredToSpecialty(ILocation location,TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient)");			
		hql.append(" from Tracking as t1_1");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and t1_1.currentReferral is not null and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null ))");
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id"}, new Object[] {location.getID(),area.getID_TrackingArea()});
		
		return list.get(0).toString();
	}


	
	public String totalPatientsOnArea(ILocation location, TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient)");			
		hql.append(" from Tracking as t1_1");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null )) ");
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id"}, new Object[] {location.getID(),area.getID_TrackingArea()});
		
		return list.get(0).toString();
	}


	
	public MosLiteEDVoCollection getMedics(ILocation location) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select m2_1 ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedMedic as m1_1 left join m1_1.mos as m2_1");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedMedic is not null )  ");
		hql.append(" order by m2_1.name.surname asc, m2_1.name.forename asc ");
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id"}, new Object[] {location.getID()});
				
		return MosLiteEDVoAssembler.createMosLiteEDVoCollectionFromMemberOfStaff(list);
		
	}


	
	public MosLiteEDVoCollection getNurses(ILocation location) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select m1_1 ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedNurse as h1_1 left join h1_1.mos as m1_1");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedNurse is not null )   ");
		
		hql.append(" order by m1_1.name.surname asc, m1_1.name.forename asc  ");
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id"}, new Object[] {location.getID()});
				
		return MosLiteEDVoAssembler.createMosLiteEDVoCollectionFromMemberOfStaff(list);
	}


	
	public String getCurrentlyAllocatedCountsMedics(ILocation location, MemberOfStaffRefVo mos) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816	
		hql.append("select count (m1_1)  ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedMedic as m1_1 left join m1_1.mos as m2_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedMedic is not null  and m2_1.id = :mos_id)");	
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}


	public String getMedicsToBeSeenCounts(ILocation location, MemberOfStaffRefVo mos) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count (m1_1)  ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy  as seenBy left join seenBy.allocatedMedic as m1_1 left join m1_1.mos as m2_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedMedic is not null  and m2_1.id = :mos_id and seenBy.seenDateTime is null)");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}



	public String getMedicsSeenCounts(ILocation location, MemberOfStaffRefVo mos) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count ( m1_1)  ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedMedic as m1_1 left join m1_1.mos as m2_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedMedic is not null  and m2_1.id = :mos_id and seenBy.seenDateTime is not null)");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}


	
	public String getAwaitingCompletionCounts(ILocation location,MemberOfStaffRefVo mos) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count (m1_1)  ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedMedic as m1_1 left join m1_1.mos as m2_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedMedic is not null  and m2_1.id = :mos_id and seenBy.seenDateTime is not null  and seenBy.completedDateTime is null)");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}


	
	public String getCurrentlyAllocatedNursesCounts(ILocation location,MemberOfStaffRefVo mos) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count (h1_1) ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedNurse as h1_1 left join h1_1.mos as m1_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedNurse is not null  and m1_1.id = :mos_id)  ");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}



	public String getNursesToBeSeenCounts(ILocation location,MemberOfStaffRefVo mos)
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count (h1_1) ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedNurse as h1_1 left join h1_1.mos as m1_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedNurse is not null  and m1_1.id = :mos_id and seenBy.seenDateTime is null)  ");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}


	
	public String getNursesSeenCounts(ILocation location, MemberOfStaffRefVo mos)
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count (h1_1) ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedNurse as h1_1 left join h1_1.mos as m1_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedNurse is not null  and m1_1.id = :mos_id and seenBy.seenDateTime is not null)  ");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}


	
	public String getNursesAwaitingCompletionCounts(ILocation location,MemberOfStaffRefVo mos)
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		//WDEV-16816
		hql.append("select count (h1_1) ");			
		hql.append(" from Tracking as t1_1 left join t1_1.seenBy as seenBy left join seenBy.allocatedNurse as h1_1 left join h1_1.mos as m1_1 ");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and seenBy.allocatedNurse is not null  and m1_1.id = :mos_id and seenBy.seenDateTime is not null and seenBy.completedDateTime is null)  ");		
		
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id", "mos_id"}, new Object[] {location.getID(), mos.getID_MemberOfStaff()});
				
		return list.get(0).toString();
	}



	public String getLOSBreached(ILocation location, TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		hql.append("select count (t1_1.patient)");			
		hql.append(" from Tracking as t1_1 left join t1_1.attendance as e1_1");
		hql.append(" where ");
		hql.append(" (t1_1.eDLocation.id = :Location_id and t1_1.currentArea.id = :area_id and  (t1_1.isDischarged = 0 or t1_1.isDischarged is null ) and  DATEDIFF(MINUTE, (e1_1.registrationDateTime),:current_time)  > (select a1_1.losBreachedKPI  from AttendanceKPIConfig as a1_1  where   (a1_1.eDLocation.id = :Location_id)))");
				
		List<?> list  = factory.find(hql.toString(), new String[] {"Location_id","area_id", "current_time"}, new Object[] {location.getID(),area.getID_TrackingArea(),new DateTime().getJavaDate()});
		
		return list.get(0).toString();
	}



	public String getAverageLengthOfStay(ILocation location,TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
        Connection conection = factory.getJdbcConnection();
        
        StringBuffer sql = new StringBuffer();
        

        sql.append("select avg(DATEDIFF(MINUTE,c1.registrati,getdate()))*60" );
        sql.append(" from emer_tracking e1 LEFT OUTER JOIN core_emergencyatten c1 ON e1.attendance = c1.id");		
        sql.append(" where (e1.edlocation = ? and e1.currentare = ? and  (e1.isdischarg = 0 or e1.isdischarg is null ))");
                     
        PreparedStatement ps;
        String ret="0";
        try 
        {
        	ps = conection.prepareCall(sql.toString());
        	ps.setLong(1, location.getID());
        	ps.setLong(2, area.getID_TrackingArea() );
        
        	ResultSet rs=ps.executeQuery();    
        	
        	while( rs.next() )
        	{
        		ret=rs.getString(1);
        	}
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
        return ret;
	}


	
	public String get15MinLOS(ILocation location, TrackingAreaRefVo area) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}		
		if (area == null ||area.getID_TrackingArea()==null)
		{
			throw new CodingRuntimeException("Cannot get Area on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
        Connection conection = factory.getJdbcConnection();
        
        StringBuffer sql = new StringBuffer();
        
        int losKPI=getLOSKPI(location)==null?0:Integer.valueOf(getLOSKPI(location)).intValue();
        
        sql.append("select  count(e1.patient) ");
        sql.append(" from emer_tracking e1 LEFT OUTER JOIN core_emergencyatten c1 ON e1.attendance = c1.id ");		
        sql.append(" where (e1.edlocation = ? and e1.currentare = ? and  (e1.isdischarg = 0 or e1.isdischarg is null ) ");
        sql.append(" and (DATEDIFF(MINUTE, c1.registrati,getdate()) - ? )<15) ");
        
        PreparedStatement ps;
        String ret="0";
        try 
        {
        	ps = conection.prepareCall(sql.toString());
        	ps.setLong(1, location.getID());
        	ps.setLong(2, area.getID_TrackingArea() );
        	ps.setLong(3, losKPI);
        	
        	ResultSet rs=ps.executeQuery();    
        	
        	while(rs.next())
        	{
        		ret=rs.getString(1);
        	}                
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
        return ret;
	}


	
	public String getLOSKPI(ILocation location) 
	{
		if (location == null )
		{
			throw new CodingRuntimeException("Cannot get Location on null Id ");
		}			
		
		DomainFactory factory = getDomainFactory();
        Connection conection = factory.getJdbcConnection();
        
        StringBuffer sql = new StringBuffer();
        

        sql.append("select e1.losbreache kpi from emer_attendancekpic e1 where (e1.edlocation = ?) ");
         
        PreparedStatement ps;
        String ret="0";
        try 
        {
        	ps = conection.prepareCall(sql.toString());
        	ps.setLong(1, location.getID());
        	/*ps.setLong(2, area.getID_TrackingArea() );
        	ps.setLong(3, location.getID());*/
        	
        	ResultSet rs=ps.executeQuery();    
        	
        	while(rs.next())
        	{
        		ret=rs.getString(1);
        	}                
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
        return ret;
		
	}




	


	

	



	

	

	
	

	
	
	
}
