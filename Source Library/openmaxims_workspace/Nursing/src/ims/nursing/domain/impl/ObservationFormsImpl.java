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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41101.1201)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.nursing.vo.ObservationForm;
import ims.nursing.vo.ObservationFormCollection;
import ims.nursing.vo.domain.ObservationFormAssembler;

public class ObservationFormsImpl extends DomainImpl implements ims.nursing.domain.ObservationForms, ims.domain.impl.Transactional
{
	/**
	 * List Forms Commencement
	 */
	public ObservationFormCollection listFormsCommencement(ObservationForm voObservationForm)
	{
		ObservationFormCollection voCollObservationForm = new ObservationFormCollection();
		if (voCollObservationForm == null)
			return voCollObservationForm;

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from ObservationForm t ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (voObservationForm.getCareContextIsNotNull())
		{
			hql.append(andStr + " t.careContext.id = :cc");
			markers.add("cc");
			values.add(voObservationForm.getCareContext().getID_CareContext());
			andStr = " and ";

			if (voObservationForm.getIsStoppedIsNotNull())
			{
				hql.append(andStr + " t.isStopped = :stopped");
				markers.add("stopped");
				values.add(voObservationForm.getIsStopped());
				andStr = " and ";
			}
		}

		if (andStr.equals(" and "))
			query += " where ";

		query += hql.toString();
		List procs = factory.find(query, markers, values);
		return ObservationFormAssembler.createObservationFormCollectionFromObservationForm(procs).sort(SortOrder.DESCENDING);
	}
}
