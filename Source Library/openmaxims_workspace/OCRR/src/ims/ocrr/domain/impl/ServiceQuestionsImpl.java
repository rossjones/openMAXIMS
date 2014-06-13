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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.45 build 2392.21875)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import java.util.Iterator;
import java.util.List;
import ims.admin.domain.Service;
import ims.admin.domain.impl.ServiceImpl;
import ims.core.clinical.domain.objects.QuestionInformation;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.ServiceCategoryCollection;
import ims.domain.DomainFactory;
import ims.domain.hibernate3.IMSCriteria;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.configuration.domain.objects.ServiceQuestion;
import ims.ocrr.configuration.vo.ServiceQuestionRefVo;
import ims.ocrr.domain.base.impl.BaseServiceQuestionsImpl;
import ims.ocrr.vo.domain.ServiceQuestionShortVoAssembler;

public class ServiceQuestionsImpl extends BaseServiceQuestionsImpl
{

	private static final long serialVersionUID = 1L;

	public void saveServiceQuestions(ims.ocrr.vo.ServiceQuestionShortVoCollection voCollServiceQuestions, ims.core.clinical.vo.ServiceRefVo service) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException
	{
		if(voCollServiceQuestions == null)
			throw new CodingRuntimeException("voCollCatQuestions is null : method saveCategoryQuestions");
		if(service == null)
			throw new CodingRuntimeException("category is null : method saveCategoryQuestions");
		if (voCollServiceQuestions.isValidated() == false)
			throw new CodingRuntimeException("voCollCatQuestions is not validated");

		DomainFactory factory = getDomainFactory();
		
		factory.delete("from ServiceQuestion ser where ser.service.id = '" +  String.valueOf(service.getID_Service()) + "'");
		
		ServiceQuestion doSerQuestion;
		List questions = ServiceQuestionShortVoAssembler.extractServiceQuestionList(factory, voCollServiceQuestions);
		Iterator it = questions.iterator();
		while(it.hasNext())
		{
			doSerQuestion = (ServiceQuestion) it.next();
			factory.save(doSerQuestion);
		}
	}

	/**
	* listServiceQuestions
	*/
	public ims.ocrr.vo.ServiceQuestionShortVoCollection listServiceQuestions(ims.core.clinical.vo.ServiceRefVo service)
	{
		if(service == null)
			throw new CodingRuntimeException("service parameter is null - listServiceQuestions");
		
		List list = getDomainFactory().find("from ServiceQuestion ser where ser.service.id = :idService order by systemInformation.creationDateTime", new String[]{"idService"}, new Object[]{service.getID_Service()});
		return ServiceQuestionShortVoAssembler.createServiceQuestionShortVoCollectionFromServiceQuestion(list);
	}

	/**
	* listActiveServiceLiteByName
	*/
	public ims.core.vo.ServiceLiteVoCollection listActiveServiceLiteByName(String name)
	{
		return ((Service)getDomainImpl(ServiceImpl.class)).listActiveServiceLiteByName(name);
	}

	public ServiceLiteVoCollection listActiveServiceLiteByNameAndCategories(String name, ServiceCategoryCollection categoryCollection)
	{
		return ((Service)getDomainImpl(ServiceImpl.class)).listActiveServiceLiteByNameAndCategories(name, categoryCollection);
	}
}