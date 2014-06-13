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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.31 build 2068.27671)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.core.configuration.domain.objects.DrawingImage;
import ims.core.vo.DrawingImageVersionVo;
import ims.core.vo.DrawingImageVo;
import ims.core.vo.DrawingImageVoCollection;
import ims.core.vo.domain.DrawingImageVoAssembler;
import ims.domain.exceptions.DomainException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;

public class DrawingConfigurationImpl extends DomainImpl implements ims.admin.domain.DrawingConfiguration, ims.domain.impl.Transactional
{
	/**
	* Gets a DrawingImage
	*/
	public ims.core.vo.DrawingImageVo getDrawingImage(ims.core.vo.DrawingImageVo drawingImageVo)
	{
		DomainFactory factory = getDomainFactory();
		DrawingImage doImage = null;

		if(drawingImageVo.getID_DrawingImage() != null)
		{
			doImage = (DrawingImage) factory.getDomainObject(DrawingImage.class, drawingImageVo.getID_DrawingImage());
			return DrawingImageVoAssembler.create(doImage);
		}

		String hql;
		List diList = null;

		if(drawingImageVo.getVersionNumber() != null)
		{
			hql = " from DrawingImage di where di.versionNumber = :versionNum ";
			hql += "and di.imagename = :imagename";
			diList = factory.find(hql, new String[]{"versionNum","imagename"}, new Object[]{drawingImageVo.getVersionNumber(),drawingImageVo.getImageName()});
		}
		else
		{
			hql = " from DrawingImage di where di.versionNumber = (select max(di2.versionNumber) from DrawingImage di2 ";
			hql += "where di2.imagename = :imagename1 ) and di.imagename = :imagename2";
			diList = factory.find(hql, new String[]{"imagename1","imagename2"}, new Object[]{drawingImageVo.getImageName(),drawingImageVo.getImageName()});
		}

		if (diList.size() == 0)
			return null;

		return DrawingImageVoAssembler.createDrawingImageVoCollectionFromDrawingImage(diList).get(0);
	
	
	}

	/**
	* Saves a Drawing Image Record
	*/
	public ims.core.vo.DrawingImageVo saveDrawingImage(ims.core.vo.DrawingImageVo drawingImage) throws StaleObjectException
	{
		if(!drawingImage.isValidated())
			throw new DomainRuntimeException("Drawing Image Value Object not validated");

		DomainFactory factory = getDomainFactory();
		DrawingImage doDrawingImage = DrawingImageVoAssembler.extractDrawingImage(factory, drawingImage);
		
		if(doDrawingImage.getVersionNumber() == null)
			doDrawingImage.setVersionNumber(new Integer(1));
		else
			doDrawingImage.setVersionNumber(new Integer(drawingImage.getVersionNumber().intValue() + 1));

		try {
			factory.save(doDrawingImage);
		} catch (DomainException e) {
			throw new DomainRuntimeException("DomainException occurred " + e.getMessage());
		}

		drawingImage.setID_DrawingImage(doDrawingImage.getId());
		drawingImage.setVersionNumber(doDrawingImage.getVersionNumber());

		return drawingImage;
	}

	/**
	* Retrieves a list of all the saved DrawingImages
	*/
	public ims.core.vo.DrawingImageVoCollection listDrawingImage()
	{
		DomainFactory factory = getDomainFactory();

		String hql = " select new ims.core.vo.DrawingImageVersionVo(di.imagename, max(di.versionNumber)) from DrawingImage di group by di.imagename";

		List lstImages = factory.find(hql);

		DrawingImageVo voItem = null;
		DrawingImageVoCollection voColl = new DrawingImageVoCollection();

		int i=0;
		while (i < lstImages.size())
		{
			DrawingImageVersionVo image = (DrawingImageVersionVo) lstImages.get(i);
			voItem = new DrawingImageVo();
			voItem.setVersionNumber(image.getVersionNumber());
			voItem.setImageName(image.getImageName());
			voColl.add(voItem);
			i++;
		}

		return voColl.sort();
	}
}
