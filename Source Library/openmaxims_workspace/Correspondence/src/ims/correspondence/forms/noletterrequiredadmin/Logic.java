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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.noletterrequiredadmin;


import ims.core.resource.people.vo.MedicRefVoCollection;
import ims.core.resource.place.vo.ClinicRefVoCollection;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.ClinicVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.correspondence.forms.noletterrequiredadmin.GenForm;
import ims.correspondence.vo.NoLetterIsRequiredVo;
import ims.correspondence.vo.lookups.Yes;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.noletterrequiredadmin.Handlers#onFormOpen()
	 */
	protected void onFormOpen() throws FormOpenException 
	{
		open();		
	}

	/**
	 * 
	 */
	private void open() 
	{		
		clear();
		form.getLocalContext().setNoLetterIsRequiredInstance(domain.getNLRItems());	
				
		listExcludedConsultants();
		listExcludedSpecialties();
		listExcludedClinics();	
		form.setMode(FormMode.VIEW);
	}

	private void clear()
	{
		form.grdClinic().getRows().clear();
		form.grdConsultant().getRows().clear();
		form.grdSpecialty().getRows().clear();
		
	}

	/**
	 * 
	 */
	private void listConsultants() 
	{
		MedicLiteVoCollection voCollConsultants = domain.listConsultants();
		GenForm.grdConsultantRow row;
		for (int i=0; i < voCollConsultants.size(); i++)
		{
			row = form.grdConsultant().getRows().newRow();
			row.setValue(voCollConsultants.get(i));
			row.setcolConsultant(voCollConsultants.get(i).getMos().getName().toShortForm());
			row.setTooltipForcolConsultant(voCollConsultants.get(i).getMos().getName().toShortForm());
			row.setcolConsultantImage(form.getImages().Admin.MemberOfStaff);			
		}		
	}

	/**
	 * 
	 */
	private void listExcludedConsultants()
	{
		listConsultants();
		overlayExcludedConsultants();
	}

	private void overlayExcludedConsultants() 
	{
		if (form.getLocalContext().getNoLetterIsRequiredInstance() == null) return;
		
		MedicLiteVoCollection voCollConsultants = form.getLocalContext().getNoLetterIsRequiredInstance().getConsultantsIsNotNull() ? form.getLocalContext().getNoLetterIsRequiredInstance().getConsultants() : null; 
		if (voCollConsultants == null)
			return;
		
		for (int i = 0; i < voCollConsultants.size(); i++) 
		{
			GenForm.grdConsultantRow row = form.grdConsultant().getRowByValue(voCollConsultants.get(i));
			if (row != null)
				row.setcolExclude(Yes.YES);
		}
	}

	
	/**
	 * 
	 */
	private void listSpecialties()
	{
		SpecialtyCollection collSpecialties = LookupHelper.getSpecialty(domain.getLookupService());				
		if (collSpecialties != null)
		{
			form.grdSpecialty().getRows().clear();		
			GenForm.grdSpecialtyRow row;
			for (int i = 0; i < collSpecialties.size(); i++) 
			{
				row = form.grdSpecialty().getRows().newRow();
				row.setValue(collSpecialties.get(i));
				row.setcolSpecialty(collSpecialties.get(i).getText());
				row.setTooltipForcolSpecialty(collSpecialties.get(i).getText());
				row.setcolSpecialtyImage(form.getImages().Admin.Service);
			}
		}
	}
	
	/**
	 * 
	 */
	private void listExcludedSpecialties()
	{
		listSpecialties();
		overlayExcludedSpecialties();
	}
	
	private void overlayExcludedSpecialties() 
	{
		if (form.getLocalContext().getNoLetterIsRequiredInstance() == null) return;
		
		SpecialtyCollection lkpCollSpecialties = form.getLocalContext().getNoLetterIsRequiredInstance().getSpecialtiesIsNotNull() ? form.getLocalContext().getNoLetterIsRequiredInstance().getSpecialties() : null; 
		if (lkpCollSpecialties == null)
			return;
		
		for (int i = 0; i < lkpCollSpecialties.size(); i++) 
		{
			GenForm.grdSpecialtyRow row = form.grdSpecialty().getRowByValue(lkpCollSpecialties.get(i));
			if (row != null)
				row.setcolExclude(Yes.YES);
		}

		
	}


	/**
	 * 
	 */
	private void listClinics() 
	{
		ClinicVoCollection voCollClinics = domain.listClinics();
		GenForm.grdClinicRow row;
		for (int i=0; i < voCollClinics.size(); i++)
		{
			row = form.grdClinic().getRows().newRow();
			row.setcolClinic(voCollClinics.get(i).getClinicName());
			row.setTooltipForcolClinic(voCollClinics.get(i).getClinicName());
			row.setValue(voCollClinics.get(i));
			row.setcolClinicImage(form.getImages().Admin.Location);
		}		
	}

	/**
	 * 
	 */
	private void listExcludedClinics() 
	{
		listClinics();
		overlayExcludedClinics();
	}

	private void overlayExcludedClinics() 
	{
		if (form.getLocalContext().getNoLetterIsRequiredInstance() == null) return;
		
		ClinicLiteVoCollection voCollNewClinics = form.getLocalContext().getNoLetterIsRequiredInstance().getNewClinicsIsNotNull() ? form.getLocalContext().getNoLetterIsRequiredInstance().getNewClinics() : null; 
		if (voCollNewClinics == null) return;
		
		for (int i = 0; i < voCollNewClinics.size(); i++) 
		{
			GenForm.grdClinicRow row = form.grdClinic().getRowByValue(voCollNewClinics.get(i));
			if (row != null)
				row.setcolExcludeNew(Yes.YES);
		}
		
		ClinicLiteVoCollection voCollReviewClinics = form.getLocalContext().getNoLetterIsRequiredInstance().getReviewClinicsIsNotNull() ? form.getLocalContext().getNoLetterIsRequiredInstance().getReviewClinics() : null; 
		if (voCollReviewClinics == null) return;
		
		for (int i = 0; i < voCollReviewClinics.size(); i++) 
		{
			GenForm.grdClinicRow row = form.grdClinic().getRowByValue(voCollReviewClinics.get(i));
			if (row != null)
				row.setcolExcludeReview(Yes.YES);
		}		
		
	}
	

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.noletterrequiredadmin.Handlers#onBtnCancelClick()
	 */
	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		open();		
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.noletterrequiredadmin.Handlers#onBtnSaveClick()
	 */
	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		if (save())
			open();
				
	}

	private boolean save()
	{
		NoLetterIsRequiredVo voNLR = form.getLocalContext().getNoLetterIsRequiredInstance();
		if (voNLR == null)
			voNLR = new NoLetterIsRequiredVo();
		
		populateInstanceData(voNLR);		
		
		String[] errors = voNLR.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}						
		try 
		{
			domain.saveNoLetterIsRequired(voNLR);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		
		return true;
	}

	private void populateInstanceData(NoLetterIsRequiredVo voNLR) 
	{		
		voNLR.setConsultants(populateConsultantInstanceData());
		voNLR.setSpecialties(populateSpecialtyInstanceData());
		voNLR.setNewClinics(populateNewClinicInstanceData());
		voNLR.setReviewClinics(populateReviewClinicInstanceData());	
		voNLR.setIsActive(Boolean.TRUE);
	}

	private ClinicLiteVoCollection populateNewClinicInstanceData() 
	{
		ClinicLiteVoCollection voCollClinics = new ClinicLiteVoCollection();
		for (int i = 0; i < form.grdClinic().getRows().size(); i++) 
		{
			if (form.grdClinic().getRows().get(i).getcolExcludeNew() != null && form.grdClinic().getRows().get(i).getcolExcludeNew().equals(Yes.YES))					
				voCollClinics.add(form.grdClinic().getRows().get(i).getValue());
		}
		
		return voCollClinics;
	}

	private ClinicLiteVoCollection populateReviewClinicInstanceData() 
	{
		ClinicLiteVoCollection voCollClinics = new ClinicLiteVoCollection();
		for (int i = 0; i < form.grdClinic().getRows().size(); i++) 
		{
			if (form.grdClinic().getRows().get(i).getcolExcludeReview() != null && form.grdClinic().getRows().get(i).getcolExcludeReview().equals(Yes.YES))					
				voCollClinics.add(form.grdClinic().getRows().get(i).getValue());
		}
		
		return voCollClinics;
	}


	private SpecialtyCollection populateSpecialtyInstanceData() 
	{
		SpecialtyCollection lkpCollSpecialties = new SpecialtyCollection();
		for (int i = 0; i < form.grdSpecialty().getRows().size(); i++) 
		{
			if (form.grdSpecialty().getRows().get(i).getcolExclude() != null && form.grdSpecialty().getRows().get(i).getcolExclude().equals(Yes.YES))					
				lkpCollSpecialties.add(form.grdSpecialty().getRows().get(i).getValue());
		}
		
		return lkpCollSpecialties;
	}

	private MedicLiteVoCollection populateConsultantInstanceData() 
	{
		MedicLiteVoCollection voCollConsultants = new MedicLiteVoCollection();
		for (int i = 0; i < form.grdConsultant().getRows().size(); i++) 
		{
			if (form.grdConsultant().getRows().get(i).getcolExclude() != null && form.grdConsultant().getRows().get(i).getcolExclude().equals(Yes.YES))					
				voCollConsultants.add(form.grdConsultant().getRows().get(i).getValue());
		}
		
		return voCollConsultants;
	}




	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.noletterrequiredadmin.Handlers#onBtnUpdateClick()
	 */
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);		
	}

	
}
