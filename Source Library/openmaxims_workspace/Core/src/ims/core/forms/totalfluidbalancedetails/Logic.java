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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.45 build 2426.28575)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.totalfluidbalancedetails;

import ims.clinicaladmin.helper.DailyPatternAndShiftsHelper;
import ims.clinicaladmin.vo.DailyPatternConfigVo;
import ims.clinicaladmin.vo.DailyPatternShortConfigVo;
import ims.clinicaladmin.vo.SignatoryPeriodConfigVo;
import ims.core.vo.DailyFluidBalanceVo;
import ims.core.vo.DailyFluidBalanceVoCollection;
import ims.core.vo.FluidBalanceInstanceVo;
import ims.core.vo.FluidBalanceInstanceVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.NurseVo;
import ims.core.vo.ShiftDetailsVo;
import ims.core.vo.SignatoryShiftDetailsVo;
import ims.core.vo.SignatoryShiftDetailsVoCollection;
import ims.core.vo.lookups.DailyPatternType;
import ims.core.vo.lookups.DailyTimePeriods;
import ims.core.vo.lookups.DailyTimePeriodsCollection;
import ims.core.vo.lookups.HcpDisType;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.vo.ValueObject;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();
		
		initialise();

		if ((form.getGlobalContext().Core.getCurrentDailyPatternConfigVo() == null) 
			|| (form.getGlobalContext().Core.getCurrentDailyPatternConfigVo().getUseSignatoryPeriods() == null)
			|| (form.getGlobalContext().Core.getCurrentDailyPatternConfigVo().getUseSignatoryPeriods().booleanValue() == false)
			|| (form.getGlobalContext().Core.getCurrentDailyPatternConfigVo().getSignatoryPeriod() == null)
			|| (form.getGlobalContext().Core.getCurrentDailyPatternConfigVo().getSignatoryPeriod().size() == 0) )
			throw new FormOpenException("The is no Fluid Balance configuration available or the saved configuration has no Signatory periods configured. ");
			
		open(false);//WDEV-15228
	}
	
	private void initialise()
	{
		DailyPatternShortConfigVo configShortVo = new DailyPatternShortConfigVo();
		configShortVo.setDailyPatternType(DailyPatternType.FLUIDBALANCE);
		form.getGlobalContext().Core.setCurrentDailyPatternConfigVo(domain.getFluidBalanceDailyPatternConfig(configShortVo));
		
		form.dteDateTo().setValue(new Date());
		form.dteDateFrom().setValue(new Date().addDay(-7));
	}

	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setCurrentDailyFluidBalanceInstanceVo(null);
		open(false);//WDEV-15228
		updateControlsState(); //WDEV-16562
	}
	
	protected void onGrdBalanceSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();
		
		ValueObject value = form.grdDetails().getValue();
		
		form.getLocalContext().setRIERecord(value instanceof DailyFluidBalanceVo ? (DailyFluidBalanceVo)value : null);
	}
	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open(true);//WDEV-15228
	}
	
	private void updateControlsState() 
	{
		form.getContextMenus().getFluidBalanceNEW_FLUIDItem().setVisible(true);
		form.getContextMenus().getFluidBalanceUPDATE_FLUIDItem().setVisible(form.grdDetails().getValue() instanceof FluidBalanceInstanceVo);
		form.getContextMenus().getFluidBalanceCONFIRMItem().setVisible(form.grdDetails().getValue() instanceof SignatoryShiftDetailsVo);

		//Cant be a student nurse
		MemberOfStaffShortVo mos = (MemberOfStaffShortVo)domain.getMosUser();
		if (mos != null && mos.getHcpIsNotNull())
		{
			if (mos.getHcp() instanceof NurseVo)
			{
				if (HcpDisType.STUDENTNURSE.equals(((NurseVo) mos.getHcp()).getNurseType()))
					form.getContextMenus().getFluidBalanceCONFIRMItem().setVisible(false);
			}
		}
		
		//Check is already confirmed
		if (form.grdDetails().getValue() instanceof SignatoryShiftDetailsVo && ((SignatoryShiftDetailsVo)form.grdDetails().getValue()).getDateTimeSignedIsNotNull())
			form.getContextMenus().getFluidBalanceCONFIRMItem().setVisible(false);
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{		
		switch(menuItemID)
		{
			case GenForm.ContextMenus.FluidBalance.NEW_FLUID:
				form.getGlobalContext().Core.setCurrentDailyFluidBalanceInstanceVo(null);
				engine.open(form.getForms().Core.FluidBalanceDetails);
				break;
			case GenForm.ContextMenus.FluidBalance.UPDATE_FLUID:
				updateFluid();
				break;	
			case GenForm.ContextMenus.FluidBalance.CONFIRM:
				confirmShift();
				break;
			default:
				break;
		}
		updateControlsState();
	}

	private void updateFluid() 
	{
		if (form.grdDetails().getValue() instanceof FluidBalanceInstanceVo)
		{
			form.getGlobalContext().Core.setCurrentDailyFluidBalanceInstanceVo((FluidBalanceInstanceVo)form.grdDetails().getSelectedRow().getValue());
			form.getGlobalContext().Core.setCurrentDailyFluidBalanceVo((DailyFluidBalanceVo)form.grdDetails().getSelectedRow().getParentRow().getParentRow().getValue());

			engine.open(form.getForms().Core.FluidBalanceDetails);
		}
	}

	private void confirmShift() 
	{
		if (form.grdDetails().getValue() instanceof SignatoryShiftDetailsVo)
		{
			form.getGlobalContext().Core.setChosenSignatoryShiftDetailsVo((SignatoryShiftDetailsVo)form.grdDetails().getSelectedRow().getValue());
			form.getGlobalContext().Core.setCurrentDailyFluidBalanceVo((DailyFluidBalanceVo)form.grdDetails().getSelectedRow().getParentRow().getValue());

			engine.open(form.getForms().Core.FluidBalanceConfirm);
		}
	}

	private void open(boolean showNoRecordsMessage) //WDEV-15228
	{
		//Clear out the localContexts
		clearLocalContexts();
		form.grdDetails().getRows().clear(); // WDEV-16562 
		DailyPatternConfigVo dailyPattern = form.getGlobalContext().Core.getCurrentDailyPatternConfigVo();
		
		if(dailyPattern == null)
		{
			engine.showMessage("The is no Fluid Balance configuration available or the saved configuration has no Signatory periods configured. ");
			return;
		}

		if(form.dteDateFrom().getValue()==null || form.dteDateTo().getValue()==null ){			
			engine.showMessage("'Date From' and 'Date To' are both required.");
			return;
		}
		
		DateTime dt1 = new DateTime(form.dteDateFrom().getValue(), dailyPattern.getStartTime());
		DateTime dt2 = new DateTime(form.dteDateTo().getValue(), dailyPattern.getStartTime());
		if(dt1.getDate()!=null && dt2.getDate() !=null && dt1.getDate().isGreaterThan(dt2.getDate())){

			engine.showMessage("'Date From' cannot be later than 'Date To'.");
			return;
		}
		dt2.addDays(1);
		dt2.addSeconds(-1);
		
		//List all fluid balances for this clinicalContact
		populateGrid(domain.listFluidBalanceByCareContextAndDates(form.getGlobalContext().Core.getCurrentCareContext(), 
				dt1, dt2));
		
		if(form.grdDetails().getRows().size() == 0 && showNoRecordsMessage)//WDEV-15228
		{
			engine.showMessage("No records found.");
		}
		
		form.setMode(FormMode.VIEW);
	}
	
	private void populateGrid(DailyFluidBalanceVoCollection coll)
	{
		form.grdDetails().getRows().clear();
		
		if (coll != null)
		{
			for (int i=0; i<coll.size(); i++)
			{
				DailyFluidBalanceVo bal = coll.get(i);
				displayParentAndItsChild(bal);
			}
		}
		form.grdDetails().expandAll();
	}
	
	private void displayParentAndItsChild(DailyFluidBalanceVo bal)
	{
		GenForm.grdDetailsRow row = null; 
		GenForm.grdDetailsRow rowShift = null;
		GenForm.grdDetailsRow rowInstance = null;
		
		clearLocalContexts();
		
		//display parent
		if(bal != null)
		{
			row = form.grdDetails().getRows().newRow();
			row.setValue(bal);
			row.setColDate(displayHeader(bal));
		}
		
		//Display Shifts
		if(row != null && bal.getShiftDetailsIsNotNull() && bal.getShiftDetails().getSignatoryShiftsIsNotNull())
		{
			SignatoryShiftDetailsVoCollection voShiftColl = bal.getShiftDetails().getSignatoryShifts();
			voShiftColl.sort(SortOrder.ASCENDING);
			for(int i = 0 ; i < voShiftColl.size() ; i++)
			{
				rowShift = row.getRows().newRow();
				SignatoryShiftDetailsVo voShift = voShiftColl.get(i);
				
				StringBuffer sb = new StringBuffer();
				
				if(voShift.getStartTimeIsNotNull())
				{
					sb.append("Start: " + getConfiguredTime(voShift.getStartTime()).substring(0, 5));
					sb.append("  ");
					sb.append("End: " + getConfiguredTime(voShift.getEndTime()).substring(8) );//.substring(8, 5));
				}

				if (voShift.getDateTimeSignedIsNotNull())
				{
					sb.append("\n");
					sb.append("Confirmed : ");
					sb.append(voShift.getSignedOffByIsNotNull() ? voShift.getSignedOffBy().getMos().getName().toShortForm() : "");
					sb.append(" - ");
					sb.append(voShift.getDateTimeSignedIsNotNull() ? voShift.getDateTimeSigned().toString() : "");
					
					rowShift.setBackColor(Color.Bisque);
				}
				rowShift.setColDate(sb.toString());
					
				rowShift.setValue(voShift);

				FluidBalanceInstanceVoCollection voInstanceColl = bal.getFluidBalanceInstances();
				if (voInstanceColl != null)
				{
					voInstanceColl.sort(SortOrder.ASCENDING);
					for(int j = 0 ; j < voInstanceColl.size() ; j++)
					{
						if (isFluidBalanceInThisShift(voShift, voInstanceColl.get(j)) )
						{
							rowInstance = rowShift.getRows().newRow();
							FluidBalanceInstanceVo voFluidBalInst = voInstanceColl.get(j);
							
							if(voFluidBalInst.getFluidBalanceDate() != null && voFluidBalInst.getStartTime() != null)
								rowInstance.setColDate(voFluidBalInst.getFluidBalanceDate().toString() + "  " + voFluidBalInst.getStartTime().toString() + " - " + voFluidBalInst.getEndTime().toString());
							if(voFluidBalInst.getTotalIntake() != null)
								rowInstance.setColTotalIn(voFluidBalInst.getTotalIntake().toString() + " / " + calculateTotalInput(voFluidBalInst));
							if(voFluidBalInst.getTotalOutput() != null)
								rowInstance.setColTotalOut(voFluidBalInst.getTotalOutput().toString()+ " / " + calculateTotalOutput(voFluidBalInst));
							if(voFluidBalInst.getBalanceIsNotNull()) 
								rowInstance.setColBalance(calculateTotalBalance(voFluidBalInst.getBalance()));
							
							if(voFluidBalInst.getVentilationChartIsNotNull())
								rowInstance.setBackColor(Color.AliceBlue);
							
							rowInstance.setValue(voFluidBalInst);
						}
					}
					if(rowInstance != null)
						rowInstance.setBold(true);
				}
			}
		}
		form.grdDetails().sort(0, SortOrder.DESCENDING);  
	}
	
	private boolean isFluidBalanceInThisShift(SignatoryShiftDetailsVo voShift, FluidBalanceInstanceVo voFluidBalInstance) 
	{
		DailyPatternConfigVo configVo = form.getGlobalContext().Core.getCurrentDailyPatternConfigVo();

		if (configVo.getSignatoryPeriodIsNotNull())
		{
			for (int j = 0 ; j < configVo.getSignatoryPeriod().size() ; j++)
			{
				SignatoryPeriodConfigVo voPeriod = configVo.getSignatoryPeriod().get(j);
				if (voPeriod.getTimePeriodsIsNotNull())
				{
					for (int i = 0 ; i < voPeriod.getTimePeriods().size() ; i++)
					{
						if (voShift.getStartTimeIsNotNull() && voShift.getStartTime().equals(voPeriod.getTimePeriods().get(i)))
						{
							//Shift Found now see if the FluidBalanceInstanceVo is in this shift
							for (int k = 0 ; k < voPeriod.getTimePeriods().size() ; k++)
							{
								if (voFluidBalInstance.getTimePeriodIsNotNull() && voFluidBalInstance.getTimePeriod().equals(voPeriod.getTimePeriods().get(k)))
									return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	private void clearLocalContexts()
	{
		//clear out LocalContext to re-calculate the amounts
		form.getLocalContext().setCurrentTotalInput(null);
		form.getLocalContext().setCurrentTotalOutput(null);
		form.getLocalContext().setCurrentTotalBalance(null);
		form.getLocalContext().setRIERecord(null);
	}
	
	//calculates the overall balance of Fluid Balance Instances
	private Integer calculateTotalBalance(Integer balance)
	{
		Integer totalBal = form.getLocalContext().getCurrentTotalBalance();
		if(balance != null)
		{
			int newBal = balance.intValue();
			if(totalBal != null)
				newBal = balance.intValue() + totalBal.intValue();
			form.getLocalContext().setCurrentTotalBalance(new Integer(newBal));
		}
		return form.getLocalContext().getCurrentTotalBalance();
	}
	
	//calculates the Total Output of a Fluid balance Instance
	private Integer calculateTotalOutput(FluidBalanceInstanceVo voFluidBal)
	{
		Integer totalOut = form.getLocalContext().getCurrentTotalOutput();
		if(voFluidBal.getTotalOutputIsNotNull())
		{
			int newTotal = voFluidBal.getTotalOutput().intValue();
			if(totalOut != null)
				newTotal += totalOut.intValue();
			form.getLocalContext().setCurrentTotalOutput(new Integer(newTotal));
		}
		return form.getLocalContext().getCurrentTotalOutput();
	}
	
	//calculates the Total Input of a Fluid balance Instance
	private Integer calculateTotalInput(FluidBalanceInstanceVo voFluidBal)
	{
		Integer totalInput = form.getLocalContext().getCurrentTotalInput();
		if(voFluidBal.getTotalIntakeIsNotNull())
		{
			int newTotal = voFluidBal.getTotalIntake().intValue();
			if(totalInput != null)
				newTotal += totalInput.intValue();
			form.getLocalContext().setCurrentTotalInput(new Integer(newTotal));
		}
		return form.getLocalContext().getCurrentTotalInput();
	}

	private String displayHeader(DailyFluidBalanceVo voDailyFluidBal)
	{		
		if(voDailyFluidBal.getShiftDetailsIsNotNull())
		{
			ShiftDetailsVo voShift = voDailyFluidBal.getShiftDetails();
			String shiftHeader = voShift.getStartDateTime() + " - " + voShift.getEndDateTime();
			return shiftHeader;
		}
		return null;
	}

	private String getConfiguredTime(DailyTimePeriods timePeriod) 
	{
		DailyPatternConfigVo configVo = form.getGlobalContext().Core.getCurrentDailyPatternConfigVo();
		
		if (configVo != null)
		{
			DailyTimePeriodsCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDailyTimePeriods(domain.getLookupService());
			DailyPatternAndShiftsHelper helper = new DailyPatternAndShiftsHelper();
			if (configVo.getStartTime() != null)
			{
				lookupCollection = helper.configureCustomTimePeriods(configVo.getStartTime(), lookupCollection);
				
				if (lookupCollection != null)
				{
					for (int j = 0 ; j < lookupCollection.size() ; j ++)
					{
						if (timePeriod.equals(lookupCollection.get(j)) )
							return lookupCollection.get(j).getText();
					}
				}
			}
		}
		return "";
	}

	protected void onFormModeChanged() 
	{
		updateControlsState();
	}
}
