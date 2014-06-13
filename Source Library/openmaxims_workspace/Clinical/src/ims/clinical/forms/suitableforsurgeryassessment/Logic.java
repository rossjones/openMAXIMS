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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.70 build 3467.22451)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.suitableforsurgeryassessment;

import ims.careuk.vo.SuitableForSurgeryAssessmentLiteVo;
import ims.careuk.vo.SuitableForSurgeryAssessmentLiteVoCollection;
import ims.careuk.vo.SuitableForSurgeryAssessmentRefVo;
import ims.careuk.vo.SuitableForSurgeryCommentVo;
import ims.careuk.vo.SuitableForSurgeryCommentVoCollection;
import ims.clinical.vo.catsReferralLiteVo;
import ims.clinical.vo.lookups.AnaestheticType;
import ims.clinical.vo.lookups.CodingItemType;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicVo;
import ims.core.vo.PatientProcedureLiteVo;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PatientProcedureStatus;
import ims.core.vo.lookups.SourceofInformation;
import ims.core.vo.lookups.YesNoUnknown;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.controls.DynamicGrid;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridColumnCollection;
import ims.framework.controls.DynamicGridRow;
import ims.framework.controls.DynamicGridRowCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;
import ims.framework.utils.Time;
import ims.scheduling.vo.lookups.TheatreType;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final Integer COLUMN_AHCP = new Integer(-2);
	private static final Integer COLUMN_ADTE = new Integer(-1);
	private static final Integer COLUMN_COMMENTS = new Integer(-3);
	
	private static final int COLUMN_AHCPWIDTH = 200;
	private static final int COLUMN_ADTEWIDTH = 150;
	private static final int COLUMN_COMMENTSWIDTH = -1;
	
//	private static final String CHECK_BOX_TEXT_ON_TRUE = "Suitable for surgery";
//	private static final String CHECK_BOX_TEXT_ON_FALSE = "Suitable for surgery (checking it will erase not suitable for surgery comments)";

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// REGION EVENTS
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Initialise the form
		initialize();
		
		// Populate form with data
		open();
	}
	
	public void open() 
	{
		SuitableForSurgeryAssessmentLiteVoCollection list = null;
		try 
		{
			list = domain.listAssessments(form.getGlobalContext().Core.getCurrentCareContext());
		
			populateRecordBrowser(list);
		
			if(form.getLocalContext().getAssessment() instanceof SuitableForSurgeryAssessmentLiteVo)
			{
				form.getLocalContext().setAssessment(domain.getAssessment(form.getLocalContext().getAssessment()));
			}
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		if(form.getLocalContext().getAssessment() == null)  //RIE
			form.getLocalContext().setAssessment((list != null && list.size() >0) ? list.get(0) : null);
		
		form.recbrAssessments().setValue(form.getLocalContext().getAssessment());
		
		populateScreenFromData(form.getLocalContext().getAssessment());
		
		form.setMode(FormMode.VIEW);
	}
	
	private void populateRecordBrowser(SuitableForSurgeryAssessmentLiteVoCollection list) 
	{
		form.recbrAssessments().clear();
		
		if(list == null)
			return;
		
		for (int i = 0 ; list != null && i < list.size() ; i++)
		{
			addRecordBrowserItem(list.get(i));
		}
	}
	
	private void addRecordBrowserItem(SuitableForSurgeryAssessmentLiteVo item) 
	{
		if(item == null)
			return;
		
		StringBuffer sb = new StringBuffer();
		if (item.getAuthoringInformationIsNotNull())
		{
			sb.append(item.getAuthoringInformation().getAuthoringDateTimeIsNotNull() ? item.getAuthoringInformation().getAuthoringDateTime().toString(true) : "");
			sb.append(" - ");
			sb.append(item.getAuthoringInformation().getAuthoringHcpIsNotNull() ? item.getAuthoringInformation().getAuthoringHcp().toString() : "");
		}
		sb.append(" - ");
		sb.append(item.getProcedureIsNotNull() ? item.getProcedure().getProcedureDescription().toString() : "");
		form.recbrAssessments().newRow(item, sb.toString());
	}

	@Override
	protected void onFormModeChanged()
	{
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Create new instance
		newInstance();
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Save current instance and refresh the form
		if (save())
			open();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Refresh the form
		open();
	}

	private void suitableOrPerformedChecked() 
	{
		form.ctnConclusions().txtComments().setEnabled(false);
		form.ctnConclusions().txtComments().setValue(null);
		form.ctnConclusions().cmbReasonNotSuitable().setEnabled(false);
		form.ctnConclusions().cmbReasonNotSuitable().setValue(null);

		if (form.ctnConclusions().chkPerformed().getValue()
			|| Boolean.FALSE.equals(form.ctnConclusions().chkSuitable().getValue()))
			form.ctnConclusions().dteSuitable().setValue(null);

		// Update the state for text box Comments
		updateControlsState();
	}

	@Override
	protected void onChkSpecialEquipmentValueChanged() throws PresentationLogicException
	{
		// Update controls state 
		updateControlsState();
	}

	@Override
	protected void onChkSpecialInstructionsValueChanged() throws PresentationLogicException
	{
		// Update controls state
		updateControlsState();
	}

	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form state control functions
	//------------------------------------------------------------------------------------------------------------------------------------------------

	public void initialize() throws FormOpenException
	{
		// Set the procedure as the clinical coding
		form.ccClinicalProcedure().setCodingItemType(CodingItemType.PROCEDURE);
		form.ccClinicalProcedure().setHotlist(Boolean.FALSE);
	
		// Remove BOTH value from theatre type lookup
		form.cmbTheatreType().removeRow(TheatreType.BOTH);
		
		// Initialise the Authoring Component
		form.ccAuthoring().setIsRequiredPropertyToControls(true);
				
		form.getLocalContext().setAssessment(null);

		initDynGridComments();
		
		Object hcpLiteUser = domain.getHcpLiteUser();
		
		if (hcpLiteUser instanceof HcpLiteVo)
		{
			form.getLocalContext().setLoggedInHcp((HcpRefVo) hcpLiteUser);
		}
		
		// WDEV-11667 - Initialise MosQuery component to work with HCP of type Medic
		form.ccNamedSurgeon().initialize(MosType.MEDIC);
	}
	
	private void initDynGridComments()
	{
		form.lyrSuitable().tabPageComments().dyngrdComments().clear();
		DynamicGridColumnCollection columns = form.lyrSuitable().tabPageComments().dyngrdComments().getColumns();
		DynamicGridColumn newColumn = columns.newColumn("Authoring Date/Time",COLUMN_ADTE,true);
		newColumn.setWidth(COLUMN_ADTEWIDTH);
			
		newColumn = columns.newColumn("Authoring HCP",COLUMN_AHCP,true);
		newColumn.setWidth(COLUMN_AHCPWIDTH);
				
		newColumn = columns.newColumn("Comments",COLUMN_COMMENTS,true);
		newColumn.setWidth(COLUMN_COMMENTSWIDTH);
		newColumn.setCanGrow(true);
		
		form.lyrSuitable().tabPageComments().dyngrdComments().setSelectable(true);
	}
	
	private void updateControlsState()
	{
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnUpdate().setVisible(form.getLocalContext().getAssessmentIsNotNull() ? true : false);	//WDEV-10751
			//WDEV-11277
			form.ctnConclusions().dteSuitable().setEnabled(false);
		}

		// Update the mandatory state for description
		form.ccClinicalProcedure().setParentEditing(new Boolean(FormMode.EDIT.equals(form.getMode())));
		form.ccClinicalProcedure().setParentEditing(new Boolean(FormMode.EDIT.equals(form.getMode())), true);
		form.ccClinicalProcedure().setMode(form.getMode());
		

		// WDEV-11667 Update the state for Special Instruction and Special Equipment tabs
		form.lyrSuitable().tabPageSpecialEquiptment().setHeaderVisible(form.ctnConclusions().chkSpecialEquipment().getValue());
		form.lyrSuitable().tabPageSpecialInstructions().setHeaderVisible(form.ctnConclusions().chkSpecialInstructions().getValue());
		
		if (Boolean.FALSE.equals(form.ctnConclusions().chkSpecialEquipment().getValue())
				&& form.lyrSuitable().tabPageSpecialEquiptment().isVisible())
		{
			form.lyrSuitable().showtabPageDetails();
		}
		
		if (Boolean.FALSE.equals(form.ctnConclusions().chkSpecialInstructions().getValue())
				&& form.lyrSuitable().tabPageSpecialInstructions().isVisible())
		{
			form.lyrSuitable().showtabPageDetails();
		}

		
		// EDIT mode
		if (FormMode.EDIT.equals(form.getMode()))
		{
			form.ccAuthoring().setEnabledAuthoringHCP(form.ccAuthoring().getValue() == null || !form.ccAuthoring().getValue().getAuthoringHcpIsNotNull());
			form.ccAuthoring().setEnabledDateTime(false);
			boolean isMyRecord = (form.getLocalContext().getAssessmentIsNotNull() && 
			((form.getLocalContext().getAssessment().getAuthoringInformationIsNotNull() && 
			form.getLocalContext().getAssessment().getAuthoringInformation().getAuthoringHcpIsNotNull() &&
			form.getLocalContext().getAssessment().getAuthoringInformation().getAuthoringHcp().equals(form.getLocalContext().getLoggedInHcp())) || 
			!form.getLocalContext().getAssessment().getID_SuitableForSurgeryAssessmentIsNotNull())) || !form.getLocalContext().getAssessmentIsNotNull();
			
			
			form.lyrSuitable().tabPageDetails().richTextExamination().setEnabled(isMyRecord);
			form.lyrSuitable().tabPageDetails().richTextHistoryComplaint().setEnabled(isMyRecord);
			form.ctnConclusions().richTextConclusions().setEnabled(isMyRecord);
			
			// Update the state of text box Comments (enable only when the surgery is denied)
			form.ctnConclusions().txtComments().setEnabled( ! form.ctnConclusions().chkSuitable().getValue() && ! form.ctnConclusions().chkPerformed().getValue());
			
	//		form.ctnConclusions().chkSuitable().setEnabled( true);

			if (form.ctnConclusions().chkSuitable().getValue()
				|| form.ctnConclusions().chkPerformed().getValue())
				form.ctnConclusions().cmbReasonNotSuitable().setEnabled(false);
			else
				form.ctnConclusions().cmbReasonNotSuitable().setEnabled(true);

			form.cmbLaterality().setEnabled(form.ccClinicalProcedure().getSelectedItem() != null);
			form.intDuration().setEnabled(form.ccClinicalProcedure().getSelectedItem() != null);
			
			//WDEV-11277
			form.ctnConclusions().dteSuitable().setEnabled(form.ctnConclusions().chkSuitable().getValue());
			
			//wdev-10501
			form.ctnConclusions().setCollapsed(false);
			//-----
		}
		
		updateContextMenuCommentsState();
	}

	private void updateContextMenuCommentsState() {
		boolean isEditMode = FormMode.EDIT.equals(form.getMode());
		boolean isSelectedCommentMine  = false;
		if (form.lyrSuitable().tabPageComments().dyngrdComments().getValue() instanceof SuitableForSurgeryCommentVo)
		{
			 SuitableForSurgeryCommentVo comment  = (SuitableForSurgeryCommentVo) form.lyrSuitable().tabPageComments().dyngrdComments().getValue();
			 if (comment.getAuthoringInformationIsNotNull() && comment.getAuthoringInformation().getAuthoringHcpIsNotNull())
				 isSelectedCommentMine = comment.getAuthoringInformation().getAuthoringHcp().equals(form.getLocalContext().getLoggedInHcp());
		}
		
		form.getContextMenus().Clinical.getSuitableForSurgeryCommentsAddCommentItem().setVisible(isEditMode);
		form.getContextMenus().Clinical.getSuitableForSurgeryCommentsEditCommentItem().setVisible(isEditMode && isSelectedCommentMine);
	}
	
	private void clearInstanceControls()
	{
		form.ccAuthoring().setValue(null);
		form.ccClinicalProcedure().setValue(null);
		form.cmbLaterality().setValue(null);
		
		form.cmbTheatreType().setValue(null);
		form.lyrSuitable().tabPageDetails().richTextExamination().setValue(null);
		form.lyrSuitable().tabPageDetails().richTextHistoryComplaint().setValue(null);
		
		form.lyrSuitable().tabPageComments().dyngrdComments().getRows().clear();
		
		form.ctnConclusions().richTextConclusions().setValue(null);
		form.ctnConclusions().chkSuitable().setValue(null);
		form.ctnConclusions().chkPerformed().setValue(null);
		form.ctnConclusions().txtComments().setValue(null);
		form.ctnConclusions().cmbReasonNotSuitable().setValue(null);
		form.ctnConclusions().dteSuitable().setValue(null);
		
		// WDEV-11667
		form.ccNamedSurgeon().clear();
		form.cmbAnaesthetic().setValue(null);
		form.intDuration().setValue(null);
		form.ctnConclusions().chkSpecialInstructions().setValue(null);
		form.lyrSuitable().tabPageSpecialInstructions().richSpecialInstructions().setValue(null);
		form.ctnConclusions().chkSpecialEquipment().setValue(null);
		form.lyrSuitable().tabPageSpecialEquiptment().richSpecialEquipment().setValue(null);
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Logic functions (new, update, save)
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void newInstance()
	{
		clearInstanceControls();

		// Initialise authoring information
		form.ccAuthoring().initializeComponent();
		
		// Initialise the Named surgeon component
		form.ccNamedSurgeon().setValue(domain.getHcpLiteUser() instanceof HcpLiteVo
				&& HcpDisType.MEDICAL.equals(((HcpLiteVo)domain.getHcpLiteUser()).getHcpType()) ? (IMos) domain.getHcpLiteUser() : null);

		form.getLocalContext().setAssessment(null);
		
		// Set the form in EDIT mode
		form.setMode(FormMode.EDIT);
	}
	
	private void updateInstance()
	{
		// Set the form in EDIT mode
		form.setMode(FormMode.EDIT);
	}
	
	private boolean save() throws PresentationLogicException
	{
		// Read data from screen
		SuitableForSurgeryAssessmentLiteVo assessment = form.getLocalContext().getAssessment();
		
		assessment = populateDataFromScreen(assessment);
		
		if (assessment.getProcedure() == null)
		{
			if (form.ctnConclusions().chkPerformed().getValue()
				|| form.ctnConclusions().chkSuitable().getValue())  
			{
				engine.showMessage("When 'Suitable for Surgery' or 'Procedure Performed' are selected, a 'Planned Procedure' is required.");
				return false;
			}
		}

		// Validate data
		String[] errors = assessment.validate(validateUIControls());
		if (errors != null && errors.length != 0)
		{
			engine.showErrors(errors);
			return false;
		}
		//wdev-13765
		catsReferralLiteVo catsReferralLiteVo = null;
		if(form.cmbAnaesthetic().getValue() != null && form.cmbTheatreType().getValue() != null && form.cmbAnaesthetic().getValue().equals(AnaestheticType.LA) && form.cmbTheatreType().getValue().equals(TheatreType.OP_CASE))
		{
			if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			{
				catsReferralLiteVo = domain.getCatsReferral(form.getGlobalContext().Core.getCurrentCareContext());
				if(catsReferralLiteVo != null)
				{
					catsReferralLiteVo.setHasOPProcAwaitingAppt(Boolean.TRUE);
					catsReferralLiteVo.setSuitableForSurgeryDate(form.ctnConclusions().dteSuitable().getValue());
				}
			}
		}
		//----------
		// Attempt to save data
		try
		{
			assessment = domain.saveAssessment(assessment,catsReferralLiteVo);  //wdev-13765
			form.getLocalContext().setAssessment(assessment);
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	private String[] validateUIControls() 
	{
		List<String> errors = new ArrayList<String>();
		
		if (form.ccClinicalProcedure().getSelectedItem() != null && form.ccClinicalProcedure().getDescription() == null)
			errors.add("Planned Procedure Description is mandatory.");
		
		if(form.ctnConclusions().chkSuitable().getValue())
		{
			if(form.ctnConclusions().dteSuitable().getValue() == null)
				errors.add("Suitable Date is mandatory.");
		}

		return errors.size()>0 ? errors.toArray(new String[0]) : null;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Populate functions
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void populateScreenFromData(SuitableForSurgeryAssessmentLiteVo assessment)
	{
		clearInstanceControls();
		
		if (assessment == null)
			return;
		
		// Set authoring information
		form.ccAuthoring().setValue(assessment.getAuthoringInformation());
		// Set procedure
		form.ccClinicalProcedure().setValue(assessment.getProcedure());
		form.cmbLaterality().setValue(assessment.getProcedureIsNotNull() ? assessment.getProcedure().getProcLaterality() : null);
		// Set theatre type
		form.cmbTheatreType().setValue(assessment.getTheatreType());
		// Set history of presenting complaint
		form.lyrSuitable().tabPageDetails().richTextHistoryComplaint().setValue(assessment.getHistoryPresComplaint());
		// Set examinations
		form.lyrSuitable().tabPageDetails().richTextExamination().setValue(assessment.getExamination());
		// Set conclusions
		form.ctnConclusions().richTextConclusions().setValue(assessment.getConclusions());
		// Set the answer suitable for surgery
//		form.ctnConclusions().chkSuitable().setValue(assessment.getSuitableForSurgery().equals(YesNoUnknown.YES) ? true : false);
//		form.ctnConclusions().chkProcedurePerformed().setValue(assessment.getProcedurePerformed());
		form.ctnConclusions().chkSuitable().setValue(assessment.getSuitableForSurgeryIsNotNull() && assessment.getSuitableForSurgery().equals(YesNoUnknown.YES) ? Boolean.TRUE : Boolean.FALSE);
		if (assessment.getProcedurePerformedIsNotNull() && assessment.getProcedurePerformed().booleanValue())
			form.ctnConclusions().chkPerformed().setValue(Boolean.TRUE);
		
		//WDEV-11277
		form.ctnConclusions().dteSuitable().setValue(assessment.getSuitableForSurgeryDate());
		// Set the comments
		form.ctnConclusions().txtComments().setValue(assessment.getNotSuitableForSurgeyComments());
		form.ctnConclusions().cmbReasonNotSuitable().setValue(assessment.getReasonNotSuitable());
		populateCommentsGridScreenFromData(assessment.getComments());
		
		// WDEV-11667
		form.ccNamedSurgeon().setValue(assessment.getNamedSurgeon());
		form.cmbAnaesthetic().setValue(assessment.getAnaestheticType());
		form.intDuration().setValue(assessment.getRequiredDurationInMins());
		form.ctnConclusions().chkSpecialEquipment().setValue(Boolean.TRUE.equals(assessment.getSpecialEquipmentRequired()));
		form.lyrSuitable().tabPageSpecialEquiptment().richSpecialEquipment().setValue(assessment.getSpecialEquipmentComments());
		form.ctnConclusions().chkSpecialInstructions().setValue(Boolean.TRUE.equals(assessment.getSpecialInstructionsRequired()));
		form.lyrSuitable().tabPageSpecialInstructions().richSpecialInstructions().setValue(assessment.getSpecialInstructionsComments());
	}

	private void populateCommentsGridScreenFromData(SuitableForSurgeryCommentVoCollection comments) 
	{
			if (comments == null)
				return;
			
			comments.sort(new Comparator<SuitableForSurgeryCommentVo>()
			{
			
				public int compare(SuitableForSurgeryCommentVo o1, SuitableForSurgeryCommentVo o2)
				{
					return o2.getAuthoringInformation().getAuthoringDateTime().compareTo(o1.getAuthoringInformation().getAuthoringDateTime());
				}
			});
			
			for (int i=0 ; i < comments.size() ; i++)
			{
				populateCommentInGrid(null, comments.get(i));
			}
		
	}

	

	@SuppressWarnings("unused")
	private SuitableForSurgeryAssessmentLiteVo populateDataFromScreen()
	{
		return populateDataFromScreen(null);
	}
	
	private SuitableForSurgeryAssessmentLiteVo populateDataFromScreen(SuitableForSurgeryAssessmentLiteVo assessment)
	{
		// WDEV-11667 - Changed the way CareContext is recorded
		if (assessment == null)
		{
			assessment = new SuitableForSurgeryAssessmentLiteVo();
			
			assessment.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		}
		
		// Get authoring information
		assessment.setAuthoringInformation(form.ccAuthoring().getValue());
		
		// Get procedure && procedure description
		if (form.ccClinicalProcedure().getValue() == null)
		{
			if (assessment.getProcedureIsNotNull())
			{
				assessment.getProcedure().setProcedure(null);
				assessment.getProcedure().setProcedureDescription(form.ccClinicalProcedure().getDescription() == null ? "" : form.ccClinicalProcedure().getDescription());
				assessment.getProcedure().setProcLaterality(form.cmbLaterality().getValue());
			}
		}
		else
		{
			ProcedureLiteVo procedure = (ProcedureLiteVo) form.ccClinicalProcedure().getSelectedItem();
			
			if (!assessment.getProcedureIsNotNull())
			{
				assessment.setProcedure(newPatientProcedure(procedure, form.ccClinicalProcedure().getDescription(),form.getGlobalContext().Core.getEpisodeofCareShort(), form.getGlobalContext().Core.getCurrentCareContext(), assessment.getAuthoringInformation(), SourceofInformation.CLINICALCONTACT));
			}
			else if (!procedure.equals(assessment.getProcedure().getProcedure()))
			{
				assessment.getProcedure().setProcedure(procedure);
				
			}
			assessment.getProcedure().setProcedureDescription(form.ccClinicalProcedure().getDescription());
			assessment.getProcedure().setProcLaterality(form.cmbLaterality().getValue());
			
			if (form.ctnConclusions().chkPerformed().getValue())
			{
				assessment.getProcedure().setProcedureStatus(PatientProcedureStatus.PERFORMED);
				if(assessment != null && assessment.getID_SuitableForSurgeryAssessmentIsNotNull()) //wdev-13824
				{
					if(assessment.getProcedureIsNotNull() && assessment.getProcedure().getProcDate() == null && assessment.getProcedure().getProcTime() == null ) //wdev-13824
					{
												
						assessment.getProcedure().setProcDate(new PartialDate(new ims.framework.utils.Date()));	//wdev-13824
						assessment.getProcedure().setProcTime(new Time());										//wdev-13824
						
					}
				}
			}
			else
			{
				assessment.getProcedure().setProcedureStatus(PatientProcedureStatus.PLANNED);
				assessment.getProcedure().setProcDate(null);
				assessment.getProcedure().setProcTime(null);
			}

		}
		
		// Get theatre information
		assessment.setTheatreType(form.cmbTheatreType().getValue());
		
		// Get history of presenting complaint
		assessment.setHistoryPresComplaint(form.lyrSuitable().tabPageDetails().richTextHistoryComplaint().getValue());
		
		// Get examinations
		assessment.setExamination(form.lyrSuitable().tabPageDetails().richTextExamination().getValue());
		
		// Get conclusions
		assessment.setConclusions(form.ctnConclusions().richTextConclusions().getValue());
		
		// Get the answer suitable for surgery
		assessment.setSuitableForSurgery(form.ctnConclusions().chkSuitable().getValue() ? YesNoUnknown.YES : YesNoUnknown.NO);
		
		//WDEV-11277
		assessment.setSuitableForSurgeryDate(form.ctnConclusions().dteSuitable().getValue());
		
		assessment.setProcedurePerformed(form.ctnConclusions().chkPerformed().getValue());

		assessment.setReasonNotSuitable(form.ctnConclusions().cmbReasonNotSuitable().getValue());
		
		// Get not suitable for surgery comments
		if ( ! form.ctnConclusions().chkSuitable().getValue()
			&&  ! form.ctnConclusions().chkPerformed().getValue())
		{
			assessment.setNotSuitableForSurgeyComments(form.ctnConclusions().txtComments().getValue());
		}
		else
		{
			assessment.setNotSuitableForSurgeyComments(null);
		}
		assessment.setComments(populateCommentsGridDataFromScreen());
		
		
		// WDEV-11667
		
		// Get named surgeon - a bit more tricky as the MosQuery Component can be initialised with a HCP instead of a Medic
		if (form.ccNamedSurgeon().getValue() instanceof MedicVo)
		{
			MedicVo value = (MedicVo) form.ccNamedSurgeon().getValue();
			
			MedicLiteVo medic = new MedicLiteVo();
			medic.setID_Hcp(value.getID_Hcp());
			medic.setMos(value.getMos());
			medic.setIsActive(value.getIsActive());
			
			assessment.setNamedSurgeon(medic);
		}
		else if (form.ccNamedSurgeon().getValue() instanceof HcpLiteVo)
		{
			HcpLiteVo hcp = (HcpLiteVo) form.ccNamedSurgeon().getValue();
			
			MedicLiteVo medic = new MedicLiteVo();
			medic.setID_Hcp(hcp.getID_Hcp());
			medic.setMos(hcp.getMos());
			medic.setIsActive(hcp.getIsActive());
			
			assessment.setNamedSurgeon(medic);
		}
		else if(form.ccNamedSurgeon().getValue() == null) //wdev-11846
			assessment.setNamedSurgeon(null);
		
		assessment.setAnaestheticType(form.cmbAnaesthetic().getValue());
		assessment.setRequiredDurationInMins(form.intDuration().getValue());
		assessment.setSpecialInstructionsRequired(form.ctnConclusions().chkSpecialInstructions().getValue());
		assessment.setSpecialInstructionsComments(form.lyrSuitable().tabPageSpecialInstructions().richSpecialInstructions().getValue());
		assessment.setSpecialEquipmentRequired(form.ctnConclusions().chkSpecialEquipment().getValue());
		assessment.setSpecialEquipmentComments(form.lyrSuitable().tabPageSpecialEquiptment().richSpecialEquipment().getValue());
		
		return assessment;
	}

	private SuitableForSurgeryCommentVoCollection populateCommentsGridDataFromScreen()
	{
		
		DynamicGridRowCollection rows = form.lyrSuitable().tabPageComments().dyngrdComments().getRows();
		if (rows == null)
			return null;
		SuitableForSurgeryCommentVoCollection comments  = new SuitableForSurgeryCommentVoCollection();
		for (int i=0 ; i<rows.size() ; i++)
		{
			Object value = rows.get(i).getValue();
			if (value instanceof SuitableForSurgeryCommentVo)
				comments.add((SuitableForSurgeryCommentVo) value);
		}
		return comments;
	}

	/**
	 * 
	 * @param procedure
	 * @param description
	 * @param episodeofCare 
	 * @param careContext
	 * @param authoringInformation
	 * @param sourceOfInformation
	 * @return
	 */
	// WDEV-11545 - added episodeofCare parameter
	private PatientProcedureLiteVo newPatientProcedure(ProcedureLiteVo procedure, String description, EpisodeOfCareRefVo episodeofCare, CareContextShortVo careContext, AuthoringInformationVo authoringInformation, SourceofInformation sourceOfInformation)
	{
		if (description == null || episodeofCare == null || careContext == null || sourceOfInformation == null)
			return null;
		
		PatientProcedureLiteVo patientProcedure = new PatientProcedureLiteVo();
		
		patientProcedure.setProcedure(procedure);
		patientProcedure.setProcedureDescription(description);
		patientProcedure.setEpisodeOfCare(episodeofCare);	// WDEV - 11545
		patientProcedure.setCareContext(careContext);
		patientProcedure.setAuthoringInformation(authoringInformation);
		patientProcedure.setInfoSource(sourceOfInformation);
		if (form.ctnConclusions().chkPerformed().getValue())//wdev-10274
		{
			patientProcedure.setProcedureStatus(PatientProcedureStatus.PERFORMED);
			patientProcedure.setInfoSource(SourceofInformation.CLINICALCONTACT);
			patientProcedure.setProcDate(form.ccAuthoring().getValue() != null && form.ccAuthoring().getValue().getAuthoringDateTimeIsNotNull() ? new PartialDate(form.ccAuthoring().getValue().getAuthoringDateTime().getDate()) : null);
			patientProcedure.setProcTime(form.ccAuthoring().getValue() != null && form.ccAuthoring().getValue().getAuthoringDateTimeIsNotNull() ? form.ccAuthoring().getValue().getAuthoringDateTime().getTime() : null);
		}
		else
			patientProcedure.setProcedureStatus(PatientProcedureStatus.PLANNED);

		patientProcedure.setProcLaterality(form.cmbLaterality().getValue());
		
		return patientProcedure;
	}
	
	@Override
	protected void onCcClinicalProcedureValueChanged() throws PresentationLogicException 
	{
		if (form.getMode().equals(FormMode.EDIT) )
		{
			form.cmbLaterality().setEnabled(form.ccClinicalProcedure().getSelectedItem() != null);
			form.intDuration().setEnabled(form.ccClinicalProcedure().getSelectedItem() != null);
			
			if (form.ccClinicalProcedure().getSelectedItem() == null)
				form.cmbLaterality().setValue(null);
			
			if (form.ccClinicalProcedure().getSelectedItem() instanceof ProcedureLiteVo)
				form.intDuration().setValue(((ProcedureLiteVo)form.ccClinicalProcedure().getSelectedItem()).getDurationInMins());
			else
				form.intDuration().setValue(null);
		}
		
		updateControlsState();
	}
	
	@Override
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		// Choose whether to create a new instance of update current instance
		if (form.getLocalContext().getAssessmentIsNotNull())
			updateInstance();
	}
	
	@Override
	protected void onRecbrAssessmentsValueChanged() throws PresentationLogicException
	{
//		 Populate form with data
		try
		{
			// Clear screen
			clearInstanceControls();
			
			form.ccClinicalProcedure().setParentEditing(Boolean.TRUE);
			
			if (form.recbrAssessments().getValue() != null)
				form.getLocalContext().setAssessment(domain.getAssessment(new SuitableForSurgeryAssessmentRefVo(form.recbrAssessments().getValue().getID_SuitableForSurgeryAssessment(), 0) ));
			populateScreenFromData(form.getLocalContext().getAssessment());
		}
		catch (DomainInterfaceException e)
		{
			// Show exception message
			engine.showMessage(e.getMessage());
		}
		
		// Set the form in VIEW mode
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onDyngrdCommentsRowSelectionChanged(DynamicGridRow row) throws PresentationLogicException 
	{
		updateContextMenuCommentsState();		
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID) 
		{
		case GenForm.ContextMenus.ClinicalNamespace.SuitableForSurgeryComments.AddComment:
			doAddComment();
			break;
		case GenForm.ContextMenus.ClinicalNamespace.SuitableForSurgeryComments.EditComment:
			doEditComment();
			break;
		
		}
		
	}

	private void doEditComment() {
		if (form.lyrSuitable().tabPageComments().dyngrdComments().getValue() instanceof SuitableForSurgeryCommentVo)
		{
			SuitableForSurgeryCommentVo value = (SuitableForSurgeryCommentVo) form.lyrSuitable().tabPageComments().dyngrdComments().getValue();
			form.getGlobalContext().Clinical.setSelectedSuitableforSurgeryComment((SuitableForSurgeryCommentVo)value.clone());
		}
		else
			throw new CodingRuntimeException("A SuitableForSurgeryVo must be selected in the grid");
		engine.open(form.getForms().Clinical.SuitableforSurgeryComment);
		
	}

	private void doAddComment() {
		form.lyrSuitable().tabPageComments().dyngrdComments().setValue(null);
		form.getGlobalContext().Clinical.setSelectedSuitableforSurgeryComment(null);
		engine.open(form.getForms().Clinical.SuitableforSurgeryComment);
		
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Clinical.SuitableforSurgeryComment) && DialogResult.OK.equals(result))
		{
			SuitableForSurgeryCommentVo comment = form.getGlobalContext().Clinical.getSelectedSuitableforSurgeryComment();
			if (comment == null)
				throw new CodingRuntimeException("A not null SuitableforSurgeyCommentVo was expected");
			
			DynamicGrid commG = form.lyrSuitable().tabPageComments().dyngrdComments();
			DynamicGridRow row = commG.getSelectedRow();
			if (row == null && commG.getRows().size() > 0)
				row = createNewRow(getWhereToInsert(comment.getAuthoringInformation().getAuthoringDateTime(), 0, form.lyrSuitable().tabPageComments().dyngrdComments().getRows().size()-1));
				
			populateCommentInGrid(row, comment);
			commG.setValue(null);
			commG.setValue(comment);
		
			
		}
		updateContextMenuCommentsState();
		
	}
	protected void populateCommentInGrid(DynamicGridRow row,SuitableForSurgeryCommentVo comment)
	{
		if (comment == null)
			return;
		if (row == null)
		{
			row =createNewRow();
		}
		
		DynamicGrid grid = form.lyrSuitable().tabPageComments().dyngrdComments();
		DynamicGridColumn column = null;
		if (comment.getAuthoringInformationIsNotNull())
		{
				column = grid.getColumns().getByIdentifier(COLUMN_ADTE);
				row.getCells().get(column).setValue(comment.getAuthoringInformation().getAuthoringDateTime());
				column = grid.getColumns().getByIdentifier(COLUMN_AHCP);
				row.getCells().get(column).setValue(comment.getAuthoringInformation().getAuthoringHcpIsNotNull()?comment.getAuthoringInformation().getAuthoringHcp().getIHcpName():"");
		}
		column = grid.getColumns().getByIdentifier(COLUMN_COMMENTS);
		row.getCells().get(column).setValue(comment.getComment());
		row.setValue(comment);
	}

	private DynamicGridRow createNewRow()
	{
		return createNewRow(null);
		
	}
	private DynamicGridRow createNewRow(DynamicGridRow beforeRow)
	{
		
		DynamicGridRow newRow;
		if (beforeRow == null)
		{
		 newRow = form.lyrSuitable().tabPageComments().dyngrdComments().getRows().newRow();
		}
		else
		{
			newRow = form.lyrSuitable().tabPageComments().dyngrdComments().getRows().newRowBefore(beforeRow);
		}
		newRow.setReadOnly(true);
		DynamicGridColumnCollection columns = form.lyrSuitable().tabPageComments().dyngrdComments().getColumns();
		DynamicGridCell newCell = newRow.getCells().newCell(columns.getByIdentifier(COLUMN_AHCP),DynamicCellType.STRING);
		newCell.setReadOnly(true);
		newCell =newRow.getCells().newCell(columns.getByIdentifier(COLUMN_ADTE),DynamicCellType.DATETIME);
		newCell.setReadOnly(true);
		newCell =newRow.getCells().newCell(columns.getByIdentifier(COLUMN_COMMENTS),DynamicCellType.WRAPTEXT);
		newCell.setReadOnly(true);
		return newRow;
	}
	private DynamicGridRow getWhereToInsert(DateTime date, int start, int end)
	{
		//Binary Search to find the position of the new comment in grid
		
		int pivot = (end-start)/2+start;
		
		DynamicGridRow pivotRow = form.lyrSuitable().tabPageComments().dyngrdComments().getRows().get(pivot);
		DateTime value = ((SuitableForSurgeryCommentVo)pivotRow.getValue()).getAuthoringInformation().getAuthoringDateTime();
		
		if (date.equals(value))
			return pivotRow;
		
		if (end-start <=0)
		{
			DynamicGridRow endRow = form.lyrSuitable().tabPageComments().dyngrdComments().getRows().get(end);
			if (date.isGreaterThan(((SuitableForSurgeryCommentVo)endRow.getValue()).getAuthoringInformation().getAuthoringDateTime()))
				return endRow;
			else
				return null;
		}
		
		if (date.isGreaterThan(value)) 
			return getWhereToInsert(date, start, pivot);
		else
			return getWhereToInsert(date, pivot+1, end);
			
	}

	//wdev-13765
	protected void onCmbAnaestheticValueChanged() throws PresentationLogicException 
	{
		if(form.cmbAnaesthetic().getValue() != null && form.cmbAnaesthetic().getValue().equals(AnaestheticType.LA))
		{
			form.cmbTheatreType().newRow(TheatreType.OP_CASE, TheatreType.OP_CASE.getText());
		}
		else
		{
			form.cmbTheatreType().removeRow(TheatreType.OP_CASE);
		}
		
	}

	@Override
	protected void onChkSuitableValueChanged() throws PresentationLogicException
	{
		if (form.ctnConclusions().chkSuitable().getValue())
			form.ctnConclusions().chkPerformed().setValue(Boolean.FALSE);
		
		suitableOrPerformedChecked();
	}

	@Override
	protected void onChkPerformedValueChanged() throws PresentationLogicException
	{
		if (form.ctnConclusions().chkPerformed().getValue())
			form.ctnConclusions().chkSuitable().setValue(Boolean.FALSE);

		suitableOrPerformedChecked();
	}

}
