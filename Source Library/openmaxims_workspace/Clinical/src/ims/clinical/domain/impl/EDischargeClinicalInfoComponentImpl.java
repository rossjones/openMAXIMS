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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.EDischargeHINTConfig;
import ims.admin.domain.impl.EDischargeHINTConfigImpl;
import ims.clinical.domain.base.impl.BaseEDischargeClinicalInfoComponentImpl;
import ims.clinicaladmin.vo.lookups.EDischargeHINT;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.DischargeClinicalInformationVoCollection;
import ims.core.vo.FieldHelpVo;
import ims.core.vo.domain.DischargeClinicalInformationVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.DischargeClinicalInformation;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.ocrr.vo.OrderInvestigationBookingVoCollection;
import ims.ocrr.vo.domain.OrderInvestigationBookingVoAssembler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EDischargeClinicalInfoComponentImpl extends BaseEDischargeClinicalInfoComponentImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * get Clinicalinte
	 */
	public ims.core.vo.DischargeClinicalInformationVo getClinicalInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
		if (careContextRefVo == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if (careContextRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from DischargeClinicalInformation clininfo where ");
			String andStr = " ";

			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();

			hql.append(andStr + " clininfo.careContext.id = :careContextId");
			markers.add("careContextId");
			values.add(careContextRefVo.getID_CareContext());
			andStr = " and ";

			List listNotes = factory.find(hql.toString(), markers, values);
			if (listNotes != null && listNotes.size() > 0)
			{
				DischargeClinicalInformationVoCollection voColl = DischargeClinicalInformationVoAssembler.createDischargeClinicalInformationVoCollectionFromDischargeClinicalInformation(listNotes);
				if (voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	/**
	 * Save clinical info
	 */
	public ims.core.vo.DischargeClinicalInformationVo saveClinicalInfo(ims.core.vo.DischargeClinicalInformationVo voClinicalInfo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		if (voClinicalInfo == null)
			throw new CodingRuntimeException("DischargeClinicalInformationVo is null");

		if (!voClinicalInfo.isValidated())
			throw new CodingRuntimeException("DischargeClinicalInformationVo Value Object Alert has not been validated");

		DomainFactory factory = getDomainFactory();
		DischargeClinicalInformation doClinInfo = DischargeClinicalInformationVoAssembler.extractDischargeClinicalInformation(factory, voClinicalInfo);// //

		if (!voClinicalInfo.getID_DischargeClinicalInformationIsNotNull())
		{
			List list = factory.find("from DischargeClinicalInformation as dci where dci.careContext.id = :CONTEXTID and dci.isRIE is null", new String[] { "CONTEXTID" }, new Object[] { voClinicalInfo.getCareContext().getID_CareContext() });
			if (list != null && list.size() > 0)
			{
				throw new StaleObjectException(null);
			}
		}

		factory.save(doClinInfo);
		return DischargeClinicalInformationVoAssembler.create(doClinInfo);
	}

	public FieldHelpVo getHintByLookupID(EDischargeHINT voLookup)
	{
		EDischargeHINTConfig impl = (EDischargeHINTConfig) getDomainImpl(EDischargeHINTConfigImpl.class);
		return impl.getHintByLookupID(voLookup);
	}

	public OrderInvestigationBookingVoCollection listInvestigationResults(PatientRefVo patientRefVo, Integer numDays)
	{
		if (numDays == null)
			throw new CodingRuntimeException("Invalid numDays");

		if (patientRefVo == null)
			throw new CodingRuntimeException("Invalid patientRefVo");

		Date dtFrom = new Date().addDay(-numDays);

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer("SELECT oi FROM OrderInvestigation AS oi LEFT JOIN oi.resultDetails AS resDetails");
		sb.append(" LEFT JOIN resDetails.pathologyResultDetails AS pathResDetails LEFT JOIN resDetails.clinicalResultDetails AS clinicalResult where ");

		sb.append(" oi.systemInformation.creationDateTime >= :fromDate");
		markers.add("fromDate");
		values.add(dtFrom.getDate());

		sb.append(" and ( pathResDetails != null");
		sb.append(" or clinicalResult != null)");

		sb.append(" and ");
		sb.append(" oi.orderDetails.patient.id = :pat ");
		markers.add("pat");
		values.add(patientRefVo.getID_Patient());

		sb.append(" order by oi.repDateTime desc, oi.ordInvSeq asc");

		return OrderInvestigationBookingVoAssembler.createOrderInvestigationBookingVoCollectionFromOrderInvestigation(getDomainFactory().find(sb.toString(), markers, values));
	}
}
