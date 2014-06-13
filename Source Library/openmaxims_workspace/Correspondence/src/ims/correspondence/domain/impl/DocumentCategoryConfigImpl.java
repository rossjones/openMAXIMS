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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3922.16454)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.correspondence.domain.impl;

import ims.admin.vo.ReportTemplateLiteVo;
import ims.admin.vo.domain.ReportTemplateLiteVoAssembler;
import ims.core.admin.domain.objects.TemplateBo;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.admin.vo.TemplateBoRefVoCollection;
import ims.core.documents.domain.objects.DocumentCategoryConfig;
import ims.core.vo.DocumentCategoryConfigShortVo;
import ims.core.vo.DocumentCategoryConfigShortVoCollection;
import ims.core.vo.TemplateForPatientDocumentVoCollection;
import ims.core.vo.domain.DocumentCategoryConfigShortVoAssembler;
import ims.core.vo.domain.TemplateForPatientDocumentVoAssembler;
import ims.core.vo.lookups.DocumentCategory;
import ims.correspondence.domain.base.impl.BaseDocumentCategoryConfigImpl;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;

import java.util.ArrayList;
import java.util.List;

public class DocumentCategoryConfigImpl extends BaseDocumentCategoryConfigImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * List all the Reports that are active
	 */
	public TemplateForPatientDocumentVoCollection listReports(String templateName, TemplateBoRefVoCollection notThisOnes, DocumentCategory cat)
	{

		String hql = "select tem from TemplateBo as tem left join tem.report as rep where (tem.name like :name and tem.isActive = 1 and rep.isActive = 1 and tem.isRIE is null ";
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("name");
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(templateName != null ? "%" + templateName + "%" : "%");

		if (notThisOnes != null && notThisOnes.size() > 0)
		{
			hql += "	and tem.id not in (";
			for (int i = 0; i < notThisOnes.size(); i++)
			{
				hql += notThisOnes.get(i).getID_TemplateBo();
				if (i < (notThisOnes.size() - 1))
				{
					hql += ",";
				}
			}

			hql += " )";
		}

		// Only not configured or configured for this category
		if (cat != null)
		{
			hql += " and tem.id not in " + "(select dtem.id from DocumentCategoryConfig as dcc left join dcc.template as dtem " + "where (dcc.category.id <> :cat))  ";
			paramNames.add("cat");
			paramValues.add(cat.getId());
		}

		hql += ") order by upper(rep.reportName) asc, upper(tem.name) asc";//		WDEV-13654

		List<?> dOs = getDomainFactory().find(hql, paramNames, paramValues);
		if (dOs == null || dOs.size() == 0)
			return null;
		return TemplateForPatientDocumentVoAssembler.createTemplateForPatientDocumentVoCollectionFromTemplateBo(dOs);

	}

	public DocumentCategoryConfigShortVo getDocCatConfig(TemplateBoRefVo template)
	{

		if (!template.getID_TemplateBoIsNotNull())
			throw new DomainRuntimeException("Unable to retrive document category config for template with null id!");

		String hql = "select dcc from DocumentCategoryConfig as dcc left join dcc.template as temp where dcc.isRIE is null and temp.id=:idTemp";
		List<?> dos = getDomainFactory().find(hql, "idTemp", template.getID_TemplateBo());
		if (dos == null || dos.size() == 0)
			return null;
		return DocumentCategoryConfigShortVoAssembler.createDocumentCategoryConfigShortVoCollectionFromDocumentCategoryConfig(dos).get(0);
	}

	public DocumentCategoryConfigShortVo save(DocumentCategoryConfigShortVo record) throws StaleObjectException, ForeignKeyViolationException
	{
		if (!record.isValidated())
			throw new DomainRuntimeException("Unable to save a record that is not validated");

		DomainFactory factory = getDomainFactory();
		if (!record.getID_DocumentCategoryConfigIsNotNull())
		{
			String count = "select count(dcc.id) from DocumentCategoryConfig as dcc left join dcc.template as tem	where (tem.id = :templateId)";
			long configs = factory.countWithHQL(count, new String[] { "templateId" }, new Object[]{record.getTemplate().getID_TemplateBo()});

			if (configs > 0)
			{
				throw new StaleObjectException(null);
			}
		}

		DocumentCategoryConfig dccDO = DocumentCategoryConfigShortVoAssembler.extractDocumentCategoryConfig(factory, record);
		factory.save(dccDO);

		return DocumentCategoryConfigShortVoAssembler.create(dccDO);
	}

	public ReportTemplateLiteVo getReportTemplateLite(TemplateBoRefVo templateRef)
	{
		if (!templateRef.getID_TemplateBoIsNotNull())
			throw new DomainRuntimeException("Unable to get Template with null id");

		return ReportTemplateLiteVoAssembler.create((TemplateBo) getDomainFactory().getDomainObject(TemplateBo.class, templateRef.getBoId()));

	}

	public DocumentCategoryConfigShortVoCollection listDocCateConfig(DocumentCategory docCat)
	{

		String hql = "from DocumentCategoryConfig as dcc where (dcc.category.id = :catId) order by upper(dcc.template.name) asc";//		WDEV-13654
		List<?> domObjs = getDomainFactory().find(hql, new String[] { "catId" }, new Object[] { docCat.getId() });
		if (domObjs == null || domObjs.size() == 0)
			return null;
		return DocumentCategoryConfigShortVoAssembler.createDocumentCategoryConfigShortVoCollectionFromDocumentCategoryConfig(domObjs);
	}

	public DocumentCategoryConfigShortVoCollection saveAll(DocumentCategoryConfigShortVoCollection oldCats, DocumentCategoryConfigShortVoCollection newCats) throws StaleObjectException, ForeignKeyViolationException
	{
		DomainFactory df = getDomainFactory();
		if (oldCats != null)
		{
			if (newCats != null)
				for (int i = oldCats.size() - 1; i >= 0; i--)
				{
					if (newCats.contains(oldCats.get(i)))
					{
						oldCats.remove(i);
					}
				}

			for (int i = 0; i < oldCats.size(); i++)
			{
				df.delete(DocumentCategoryConfigShortVoAssembler.extractDocumentCategoryConfig(df, oldCats.get(i)));
			}
		}
		if (newCats == null)
			return null;

		DocumentCategoryConfigShortVoCollection result = new DocumentCategoryConfigShortVoCollection();
		for (int i = 0; i < newCats.size(); i++)
		{
			result.add(save(newCats.get(i)));
		}
		return result;
	}

}
