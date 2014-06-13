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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 3951.27823)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.EDischargePatientReadyToLeaveSTHKComponent;
import ims.clinical.domain.base.impl.BaseEDischargeSTHKImpl;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeReadyToLeaveVo;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.DischargeReportDetailVoCollection;
import ims.clinical.vo.DischargeSupplementaryNotesVo;
import ims.clinical.vo.DischargeSupplementaryNotesVoCollection;
import ims.clinical.vo.EDischargeSTHKSummaryVo;
import ims.clinical.vo.domain.DischargeDetailsVoAssembler;
import ims.clinical.vo.domain.DischargeReportDetailVoAssembler;
import ims.clinical.vo.domain.DischargeSupplementaryNotesVoAssembler;
import ims.clinical.vo.domain.EDischargeSTHKSummaryVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.DischargeDetails;
import ims.edischarge.domain.objects.DischargeSupplementaryNotes;
import ims.edischarge.domain.objects.Summary;
import ims.framework.exceptions.CodingRuntimeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EDischargeSTHKImpl extends BaseEDischargeSTHKImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* get Discharge Details
	*/
	public ims.clinical.vo.DischargeDetailsVo getDischargeDetails(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.getDischargeDetails(careContextRefvo);
	}

	public DischargeDetailsVo saveDischargeDetails(DischargeDetailsVo voDischargeDetails) throws DomainInterfaceException, StaleObjectException 
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.saveDischargeDetails(voDischargeDetails);
	}

	public DischargeReadyToLeaveVo getReadyToLeave(CareContextRefVo careContextRefvo) 
	{
		EDischargePatientReadyToLeaveSTHKComponent impl = (EDischargePatientReadyToLeaveSTHKComponent) getDomainImpl(EDischargePatientReadyToLeaveSTHKComponentImpl.class);
		return impl.getReadyToLeave(careContextRefvo);
	}

	public DischargeSupplementaryNotesVo getSupplementary(CareContextRefVo voCareContextRefVo) 
	{
		if(voCareContextRefVo == null)
			throw new CodingRuntimeException("voCareContextRefVo Filter not provided for list call. ");

		if(voCareContextRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from DischargeSupplementaryNotes ds where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " ds.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(voCareContextRefVo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				DischargeSupplementaryNotesVoCollection voColl = DischargeSupplementaryNotesVoAssembler.createDischargeSupplementaryNotesVoCollectionFromDischargeSupplementaryNotes(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public String[] getSystemReportAndTemplate(Integer imsId) 
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	public DischargeSupplementaryNotesVo saveSupplementaryAndDDAndSummary(DischargeSupplementaryNotesVo voDischSupp, DischargeDetailsVo voDD, EDischargeSTHKSummaryVo voSumm) throws DomainInterfaceException, StaleObjectException
	{
		if(voDischSupp == null)
			throw new CodingRuntimeException("DischargeSupplementaryNotesVo is null");
		
		if(!voDischSupp.isValidated())
			throw new CodingRuntimeException("DischargeSupplementaryNotesVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		DischargeSupplementaryNotes doDSN = DischargeSupplementaryNotesVoAssembler.extractDischargeSupplementaryNotes(factory, voDischSupp);
		
		//WDEV-8813
		// Workaround for the case when 2 users save in the same time a new DischargeSupplementaryNotesVO
		//In this case the domain.save call doesn't throw a StaleObjectExeption, even if it is the case
		if (!voDischSupp.getID_DischargeSupplementaryNotesIsNotNull())
		{
			DischargeSupplementaryNotesVo voDischargeSupp = getSupplementary(voDischSupp.getCareContext());
			if (voDischargeSupp!=null)
			{
				throw new StaleObjectException(doDSN,"A DischargeSupplementaryNotesVo was already saved by another user");
			}
		}
		
		
		factory.save(doDSN);
		
		
		if (voDD != null)
		{
			DischargeDetails doDD = DischargeDetailsVoAssembler.extractDischargeDetails(factory, voDD);
			factory.save(doDD);
		}

		if (voSumm != null)
		{
			Summary doSumm = EDischargeSTHKSummaryVoAssembler.extractSummary(factory, voSumm);
			factory.save(doSumm);
		}

		return DischargeSupplementaryNotesVoAssembler.create(doDSN);
	}

	public DischargeReportDetailVo getDischargeReportDetailsForCareContext(	CareContextRefVo careContext) 
	{
		if(careContext == null ||
				careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContext is null or id not provided for getDischargeDetailsForCareContext");	
		
		DomainFactory factory = getDomainFactory();
		List domainObjectList = factory.find("select drd from DischargeReportDetail as drd left join drd.careContext as cc where cc.id = :idCareContext", new String[]{"idCareContext"}, new Object[]{careContext.getID_CareContext()});
		DischargeReportDetailVoCollection reportDetail = DischargeReportDetailVoAssembler.createDischargeReportDetailVoCollectionFromDischargeReportDetail(domainObjectList);		
		
		return reportDetail != null && reportDetail.size() > 0 ? (reportDetail.get(0) != null ? reportDetail.get(0) : null) : null;
	}

	public EDischargeSTHKSummaryVo getSummaryByCareContext(CareContextRefVo careContext)
	{
		if (careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("careContext is null or id not provided in method getNeonatalByCareContext");
		
		DomainFactory factory = getDomainFactory();
		List nnItems =  factory.find("from Summary ds where ds.careContext.id = " + careContext.getID_CareContext());
		
		if(nnItems != null && nnItems.size() > 0)
			return EDischargeSTHKSummaryVoAssembler.create((Summary) nnItems.get(0));
		
		return null;
	}

	public Boolean isPasEventMissing(CareContextRefVo careContext)
	{
		String hql = "select count(c1_1.id) from CareContext as c1_1 where (c1_1.pasEvent is null  and c1_1.id = :careContextId)";
		long countWithHQL = getDomainFactory().countWithHQL(hql, new String[]{"careContextId"}, new Object[]{careContext.getID_CareContext()});
		return countWithHQL>0;
	}

}
