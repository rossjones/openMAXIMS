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
// This code was generated by John MacEnri using IMS Development Environment (version 1.20 build 40727.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.applicationusers;

import ims.admin.vo.AppRoleShortVo;
import ims.admin.vo.AppRoleShortVoCollection;
import ims.admin.vo.AppUserPasswordVo;
import ims.admin.vo.AppUserPasswordVoCollection;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.AppUserVo;
import ims.admin.vo.UserDTOVo;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.AppRight;
import ims.configuration.Configuration;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.lookups.ChannelType;
import ims.domain.exceptions.DTODomainInterfaceException;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.EngineException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws FormOpenException
	{
		if(!ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
			form.imbHeartsUser().setVisible(false);		
				
		form.btnUpdate().setEnabled(false);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		AppRoleShortVoCollection roles = domain.listRoles();
		GenForm.grdRolesRow row;
		
		for (int i = 0; i < roles.size(); i++)
		{
			AppRoleShortVo role = roles.get(i);
			row = form.grdRoles().getRows().newRow();
			row.setValue(role);
			row.setRoleName(role.getName());
			row.setAssigned(false);
		}
		form.txtSrhUserName().setFocus();
		form.qmbMos().setRequired(!ConfigFlag.GEN.ALLOW_NON_MOS_USERS.getValue());
	}

	private boolean isRoleAssigned(AppRoleShortVo role, AppRoleShortVoCollection appRoles)
	{
		if (appRoles == null)
			return false;
		return (appRoles.indexOf(role) != -1);
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		clearScreen();
		form.setMode(FormMode.VIEW);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.btnUpdate().setEnabled(false);
		
		form.grdAppUsers().setValue(null);
		clearScreen();
		
	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{
		AppUserVo voAppUser = form.getLocalContext().getAppUserVo();
		
		voAppUser.setNotificationDetails(form.getGlobalContext().Admin.getUserNotificationSettings());
		
		voAppUser.setDebugMode(form.chkDebugMode().getValue());
		voAppUser.setUseExternalAuthentication(form.chkUseExternalAuthentication().getValue());

		boolean mosRequired = !ConfigFlag.GEN.ALLOW_NON_MOS_USERS.getValue();
		if (mosRequired && form.qmbMos().getValue() == null)
		{
			engine.showMessage("Please select a Member of Staff");
			return;
		}
		
		if(activatingUserWithInactiveMOS())
			return;
		
		//wdev-13963
		form.getLocalContext().setMemberOfStaffOld(null);
		if(voAppUser != null && voAppUser.getMos() != null)
		{
			if(voAppUser.getMos().equals(form.qmbMos().getValue()))
				form.getLocalContext().setMemberOfStaffOld(null);
			else
				form.getLocalContext().setMemberOfStaffOld(voAppUser.getMos());
		}
		//------------
		voAppUser.setMos(form.qmbMos().getValue());

		if (form.txtUsername().getValue() == null)
		{
			engine.showMessage("Please enter Username");
			return;
		}

		// wdev-10839
		boolean replicationRequired=checkReplicationRequired(voAppUser);
		
		voAppUser.setUsername(form.txtUsername().getValue());

		if (form.chkIsActive().getValue() == true)
			voAppUser.setIsActive(Boolean.TRUE);
		else
			voAppUser.setIsActive(Boolean.FALSE);
		
		if(usesExternalAuthentication())
		{
			String ldapDummyPassword = "LDAPAuth4i68a9ion123";
			form.txtPwd().setValue(ldapDummyPassword);
			form.txtRepeatPwd().setValue(ldapDummyPassword);
			voAppUser.setClearPassword(ldapDummyPassword);
			try 
			{
				voAppUser.setPassword(Configuration.getHash(ldapDummyPassword));
			}
			catch (Exception e1)
			{
				throw new PresentationLogicException("Failed to encrypt User password " + e1.getMessage(), e1);
			}
		}
		else
		{
			// wdev-8744 - For external authentication, if expiry is in the future, it is ok to have a blank password
			if (ConfigFlag.DOM.EXTERNAL_AUTHENTICATION.getValue() == true && form.getGlobalContext().Admin.getHeartsUser() != null 
					&& form.dtePwdExp().getValue() != null && form.dtePwdExp().getValue().getDate().after(new java.util.Date()))
			{
				// wdev-8744 - set a dummy password as the database insists on one
				// though this should NOT be replicated to HEARTS
				if (!voAppUser.getPasswordIsNotNull())
				{
					voAppUser.setPassword("DUMMY");
				}
			}
			else
			{
				
				
				if (form.txtPwd().getValue() == null)
				{
					engine.showMessage("Please enter a password");
					return;		
				}
		
				if (form.txtRepeatPwd().getValue() == null)
				{
					engine.showMessage("Please re-enter password");
					return;
				}
			
				// wdev-9034 - password expiry can be in the past for external authentication and hearts
				// as set in hearts environment
				if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue() &&
						ConfigFlag.DOM.EXTERNAL_AUTHENTICATION.getValue());
				else
				{

					if (form.dtePwdExp().getValue() != null)
					{
						DateTime today = new DateTime();
						if (new DateTime(form.dtePwdExp().getValue(),form.timPwdExp().getValue()).isLessThan(today))
						{
							engine.showMessage("Password Expiry can not be in the past.");
							return;
						}
					}
				}
				
				if (form.txtPwd().getValue() != null && form.txtRepeatPwd().getValue() != null)
				{
					
					if (!form.txtPwd().getValue().equals(form.txtRepeatPwd().getValue()))
					{
						engine.showMessage("Passwords do not match");
						return;
					}
	
					// Need to detect if the user has changed the password
					if (!form.txtPwd().getValue().equals(voAppUser.getPassword()))
					{
						try 
						{
							engine.checkPasswordRequirements(form.txtPwd().getValue(), null, voAppUser.getUserPreviousPasswords());
						} 
						catch (EngineException e) 
						{
							engine.showMessage(e.getMessage());
							return;
						}
	
						try
						{
							voAppUser.setPassword(Configuration.getHash(form.txtPwd().getValue()));
							
							AppUserPasswordVoCollection previousPasswords = voAppUser.getPreviousPasswords();
							if(previousPasswords == null)
								previousPasswords = new AppUserPasswordVoCollection();					
							AppUserPasswordVo previousPassword = new AppUserPasswordVo();
							previousPassword.setDateTime(new DateTime());
							previousPassword.setEncodedPassword(voAppUser.getEncodedPassword());
							voAppUser.setPreviousPasswords(previousPasswords);
							
							voAppUser.setEncodedPassword(Configuration.encryptPasswordWithCloak(form.txtPwd().getValue()));
						}
						catch (Exception e1)
						{
							throw new PresentationLogicException("Failed to encrypt User password " + e1.getMessage(), e1);
						}
					}
				}		
			
				// wdev-6512 If replicating this user to Hearts, the pwd length limit is 8, so need to enforce that here
				if (ConfigFlag.DOM.DTO_REPLICATE_APPUSERS.getValue() && ConfigFlag.DTO.DTO_CONNECTION_TYPE.getValue().equals("HEARTS"))
				{
					if (form.txtPwd().getValue() != null && form.txtPwd().getValue().length() > 8)
					{
						engine.showMessage("Password length cannot be longer than 8 characters when replicating to HEARTS");
						return;
					}
				}
			}
			


			/*
					implements WDEV-3817
			*/
			if((form.dteEffectiveFrm().getValue() != null && form.timEffectiveFrm().getValue() != null)&&(form.dteEffectiveTo().getValue() != null && form.timEffectiveTo().getValue()!= null))
			{ 
				
				DateTime EffectiveFrom = new DateTime(form.dteEffectiveFrm().getValue(), form.timEffectiveFrm().getValue());
				DateTime EffectiveTo  = new DateTime(form.dteEffectiveTo().getValue(), form.timEffectiveTo().getValue());
				
				if (validateDate(EffectiveFrom,EffectiveTo) == 0)
				{
					engine.showMessage("The User Valid From date cannot exceed the User Valid Until date");
					return;
				}
				else if (validateDate(EffectiveFrom,EffectiveTo) == -1)
				{
					engine.showMessage("The User Valid To date cannot preceed the User Valid From date");
					return;
				}
			}
			
			if (form.dteEffectiveFrm().getValue() != null)
				voAppUser.setEffectiveFrom(new DateTime(form.dteEffectiveFrm().getValue(), form.timEffectiveFrm().getValue()));
			else
				voAppUser.setEffectiveFrom(null);
	
			if (form.dteEffectiveTo().getValue() != null)
				voAppUser.setEffectiveTo(new DateTime(form.dteEffectiveTo().getValue(), form.timEffectiveTo().getValue()));
			else
				voAppUser.setEffectiveTo(null);
	
			if (form.dtePwdExp().getValue() != null)
				voAppUser.setPwdExpDate(new DateTime(form.dtePwdExp().getValue(), form.timPwdExp().getValue()));
			else
				voAppUser.setPwdExpDate(null);
		}

		voAppUser.setTheme("blue");

		voAppUser.setRoles(new AppRoleShortVoCollection());
		for (int i = 0; i < form.grdRoles().getRows().size(); i++)
		{
			GenForm.grdRolesRow row = form.grdRoles().getRows().get(i);
			if (row.getAssigned())
			{
				voAppUser.getRoles().add(row.getValue());
			}
		}

		if (voAppUser.getRoles().size() == 0)
		{
			engine.showMessage("Please assign a role to this user");
			return;
		}

		String[] arrErrors = voAppUser.validate();
		if (arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
		try
		{
			voAppUser = domain.saveAppUser(voAppUser, replicationRequired,form.getLocalContext().getMemberOfStaffOld()); //wdev-13963
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			clearScreen();
			return;
		}
		catch (DTODomainInterfaceException dtoEx)
		{
			engine.showMessage(dtoEx.getMessage());
			return;
		}
		catch (DomainInterfaceException DomEx)
		{
			engine.showMessage(DomEx.getMessage());
			return;
		}


		form.setMode(FormMode.VIEW);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.btnUpdate().setEnabled(false);
		form.grdAppUsers().setValue(null);
		clearScreen();
		this.onBtnSearchClick();
	}

	/**
	 * wdev-10839
	 * Replication is only required if updating items in the dto/hearts
	 * instance.  This method will check to see whether replication is needed
	 * and if so a boolean will be passed to the domain method to inform it 
	 * of the requirement
	 * @param voAppUser
	 * @return true to replicate else false
	 */
	private boolean checkReplicationRequired(AppUserVo voAppUser)
	{
		if (!ConfigFlag.DOM.DTO_REPLICATE_APPUSERS.getValue())
			return false;
		
		// In the impl, replicate to dto only if
		// username, pwd, active or date values change
		if (voAppUser == null || !voAppUser.getID_AppUserIsNotNull())
			return true;
		
		if (!voAppUser.getUsernameIsNotNull() || !voAppUser.getUsername().equals(form.txtUsername().getValue()))
			return true;;
		
		if (form.chkIsActive().getValue() == true)
		{
			if (!voAppUser.getIsActiveIsNotNull() || voAppUser.getIsActive().booleanValue() == false)
				return true;
		}
		else
		{
			if (!voAppUser.getIsActiveIsNotNull() || voAppUser.getIsActive().booleanValue() == true)
				return true;
		}
		
		if (!voAppUser.getPasswordIsNotNull() || (form.txtPwd().getValue() != null && !form.txtPwd().getValue().equals(voAppUser.getPassword()))) //WDEV-14791
			return true;
		
		if ((!voAppUser.getEffectiveFromIsNotNull() && form.dteEffectiveFrm().getValue() != null)
				|| (voAppUser.getEffectiveFromIsNotNull() && form.dteEffectiveFrm().getValue() == null)
				|| (voAppUser.getEffectiveFromIsNotNull() && !voAppUser.getEffectiveFrom().equals(new DateTime(form.dteEffectiveFrm().getValue(), form.timEffectiveFrm().getValue()))))
			return true;
			
		if ((!voAppUser.getEffectiveToIsNotNull() && form.dteEffectiveTo().getValue() != null)
				|| (voAppUser.getEffectiveToIsNotNull() && form.dteEffectiveTo().getValue() == null)
				|| (voAppUser.getEffectiveToIsNotNull() && !voAppUser.getEffectiveTo().equals(new DateTime(form.dteEffectiveTo().getValue(), form.timEffectiveTo().getValue()))))
			return true;
		
		if ((!voAppUser.getPwdExpDateIsNotNull() && form.dtePwdExp().getValue() != null)
				|| (voAppUser.getEffectiveToIsNotNull() && form.dtePwdExp().getValue() == null)
				|| (voAppUser.getPwdExpDateIsNotNull() && !voAppUser.getPwdExpDate().equals(new DateTime(form.dtePwdExp().getValue(), form.timPwdExp().getValue()))))
			return true;
		
		return false;
	}
	
	private boolean activatingUserWithInactiveMOS() {
		if(form.getLocalContext().getAppUserVoIsNotNull() 
				&& form.getLocalContext().getAppUserVo().getIsActiveIsNotNull()
					&& !form.getLocalContext().getAppUserVo().getIsActive() 
						&& form.chkIsActive().getValue()){
			
			if (form.qmbMos().getValue() != null
					&& form.qmbMos().getValue().getIsActiveIsNotNull() 
						&& !form.qmbMos().getValue().getIsActive())
			{
				engine.showMessage("Cannot activate user with inactive Member of Staff. Please select an active Member of Staff.");
				return true;
			}
		}
		
		return false;
	}

	protected void onBtnClearClick()
	{
		clearSearchFields();
		clearScreen();
	}

	protected void onBtnSearchClick() throws PresentationLogicException
	{
		AppUserVo appuser = new AppUserVo();

		appuser.setUsername(form.txtSrhUserName().getValue());

		if (form.chkActiveOnly().getValue() == true)
			appuser.setIsActive(Boolean.TRUE);

		populateAppUserGrid(domain.listAppUsers(appuser));
		form.btnUpdate().setEnabled(false);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		// AppUserVo user = domain.getAppUser(form.grdAppUsers().getValue());
		// form.getLocalContext().setAppUserVo(user);
		form.setMode(FormMode.EDIT);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.btnUpdate().setEnabled(false);
		if (form.getLocalContext().getAppUserVoIsNotNull())
			if (form.getLocalContext().getAppUserVo().getMosIsNotNull())
				if (form.getLocalContext().getAppUserVo().getMos().getCommChannelsIsNotNull())
					for (int i=0;i<form.getLocalContext().getAppUserVo().getMos().getCommChannels().size();i++)
					{
						if (form.getLocalContext().getAppUserVo().getMos().getCommChannels().get(i).getChannelType().equals(ChannelType.EMAIL))
						{
							
							form.getGlobalContext().Admin.setuserEmailAccount(domain.getEmailData(form.getLocalContext().getAppUserVo().toAppUserRefVo()));
						}
					}
		
	}

	protected void onBtnNewClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.getLocalContext().setAppUserVo(new AppUserVo());
		clearScreen();
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.btnUpdate().setEnabled(false);
		form.chkIsActive().setValue(true);
		form.timEffectiveFrm().setValue(new Time("00:00"));
		form.timEffectiveTo().setValue(new Time("00:00"));
		form.timPwdExp().setValue(new Time("00:00"));
		form.chkUseExternalAuthentication().setValue(false);
		updateControlsState();
		
	}

	private String getCommChannel(ims.core.vo.CommChannelVoCollection voCollCommChannel, ims.core.vo.lookups.ChannelType lkChannelType)
	{
		if (voCollCommChannel != null && voCollCommChannel.size() > 0)
		{
			for (int i = 0; i < voCollCommChannel.size(); i++)
				if (voCollCommChannel.get(i).getChannelType().equals(lkChannelType))
					return voCollCommChannel.get(i).getCommValue();
		}
		return null;
	}

	private void displayRecord(AppUserVo voAppUser)
	{
		clearScreen();
		
		form.getGlobalContext().Admin.setUserNotificationSettings(voAppUser.getNotificationDetails());
		
		form.txtUsername().setValue(voAppUser.getUsername());
		if (voAppUser.getEffectiveFrom() != null)
		{
			form.dteEffectiveFrm().setValue(voAppUser.getEffectiveFrom().getDate());
			form.timEffectiveFrm().setValue(voAppUser.getEffectiveFrom().getTime());
		}
		if (voAppUser.getEffectiveTo() != null)
		{
			form.dteEffectiveTo().setValue(voAppUser.getEffectiveTo().getDate());
			form.timEffectiveTo().setValue(voAppUser.getEffectiveTo().getTime());
		}
		if (voAppUser.getPwdExpDate() != null)
		{
			form.dtePwdExp().setValue(voAppUser.getPwdExpDate().getDate());
			form.timPwdExp().setValue(voAppUser.getPwdExpDate().getTime());
		}

		form.chkIsActive().setValue(voAppUser.getIsActive().booleanValue());
		form.chkDebugMode().setValue(voAppUser.getDebugMode() == null ? false : voAppUser.getDebugMode().booleanValue());
		form.chkUseExternalAuthentication().setValue(voAppUser.useExternalAuthentication());
		form.txtPwd().setValue(voAppUser.getPassword());
		form.txtRepeatPwd().setValue(voAppUser.getPassword());

		form.qmbMos().clear();
		if (voAppUser.getMos() != null)
		{
			String strNameAndId = "";
			if (voAppUser.getMos().getPasCode() != null)
			{
				strNameAndId = voAppUser.getMos().toString();
				strNameAndId += (" (" + voAppUser.getMos().getPasCode() + ")");
				form.qmbMos().newRow(voAppUser.getMos(), strNameAndId);
			}
			else
				form.qmbMos().newRow(voAppUser.getMos(), voAppUser.getMos().toString());

			form.qmbMos().setValue(voAppUser.getMos());

			// application user must have an email address linked to MOS before
			// entering in email authentication.
			form.lnkEmailAccountInfo().setTooltip(getCommChannel(voAppUser.getMos().getCommChannels(), ims.core.vo.lookups.ChannelType.EMAIL));
		}

		setRolesAssigned(voAppUser);
	}

	private void setRolesAssigned(AppUserVo voAppUser)
	{
		for (int i = 0; i < form.grdRoles().getRows().size(); i++)
		{
			GenForm.grdRolesRow row = form.grdRoles().getRows().get(i);
			row.setAssigned(isRoleAssigned(row.getValue(), voAppUser.getRoles()));
		}
	}

	private void clearScreen()
	{
		form.getGlobalContext().Admin.ApplicationUsers.setSelectedUser(null);
		
		form.txtPwd().setValue(null);
		form.txtRepeatPwd().setValue(null);
		form.txtUsername().setValue(null);
		form.dteEffectiveFrm().setValue(null);
		form.dteEffectiveTo().setValue(null);
		form.dtePwdExp().setValue(null);
		form.timEffectiveFrm().setValue(null);
		form.timEffectiveTo().setValue(null);
		form.timPwdExp().setValue(null);
		form.qmbMos().setValue(null);
		form.qmbMos().clear();
		form.txtForename().setValue(null);
		form.chkIsActive().setValue(false);
		form.chkDebugMode().setValue(false);
		form.lnkEmailAccountInfo().setEnabled(false);
		clearRolesAssigned();
		form.getGlobalContext().Admin.setAppUserVo(null);
		form.getGlobalContext().Admin.setuserEmailAccount(null);
		
		form.chkUseExternalAuthentication().setValue(false); //WDEV-14802
	}

	private void clearRolesAssigned()
	{
		for (int i = 0; i < form.grdRoles().getRows().size(); i++)
		{
			GenForm.grdRolesRow row = form.grdRoles().getRows().get(i);
			row.setAssigned(false);
		}
	}

	private void clearSearchFields()
	{
		form.txtSrhUserName().setValue(null);
		form.chkActiveOnly().setValue(false);
		form.grdAppUsers().setValue(null);
		form.grdAppUsers().getRows().clear();
	}

	private void populateAppUserGrid(AppUserShortVoCollection coll)
	{
		form.grdAppUsers().getRows().clear();
		form.getGlobalContext().Admin.ApplicationUsers.setSelectedUser(null);
		form.grdAppUsers().setValue(null);
		clearScreen();
		GenForm.grdAppUsersRow row = null;
		for (int i = 0; i < coll.size(); i++)
		{
			row = form.grdAppUsers().getRows().newRow();
			row.setValue(coll.get(i));
			row.setUserName(coll.get(i).getUsername());
			row.setRealName(coll.get(i).getUserRealName());
		}
	}

	protected void onQmbMosTextSubmited(String value) throws PresentationLogicException
	{
		if (value != null)
		{
			MemberOfStaffShortVoCollection mosColl = domain.listMos(value.toString(), form.txtForename().getValue());
			form.qmbMos().setValue(null);
			form.qmbMos().clear();
			form.txtForename().setValue(null);
			String strName = null;
			if (mosColl != null)
			{
				for (int i = 0; i < mosColl.size(); i++)
				{
					strName = "";
					if ((mosColl.get(i).getName() != null) && (mosColl.get(i).getID_MemberOfStaff() != null))
					{
						MemberOfStaffShortVo mos = mosColl.get(i);
						strName = mos.getName().toShortForm();
						if (mos.getPasCode() != null)
						{
							strName += (" (" + mos.getPasCode() + ")");
						}
						form.qmbMos().newRow(mosColl.get(i), strName);
					}
				}
				if (mosColl.size() == 1)
				{
					form.qmbMos().setValue(mosColl.get(0));
				}
				else if (mosColl.size() > 1)
				{
					form.qmbMos().showOpened();
				}
			}
		}
		updateControlsState();
	}

	protected void onGrdAppUsersSelectionChanged() throws PresentationLogicException
	{
		form.btnUpdate().setEnabled(true);
		if (form.grdAppUsers().getValue() != null)
		{
			AppUserVo user = domain.getAppUser(form.grdAppUsers().getValue());
			form.getGlobalContext().Admin.ApplicationUsers.setSelectedUser(user);
			// wdev-9034 - External Authentication, get date values from Hearts
			if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue() &&
					ConfigFlag.DOM.EXTERNAL_AUTHENTICATION.getValue())
			{
				try
				{
					UserDTOVo dtoUser = domain.getDtoAppUserByName(user.getUsername());
					if (dtoUser != null)
					{
						user.setPwdExpDate(new DateTime(dtoUser.getPasswordExpiryDate()));
						user.setEffectiveFrom(dtoUser.getEffectiveFrom());
						user.setEffectiveTo(dtoUser.getEffectiveTo());
					}
				}
				catch (DomainInterfaceException e) 
				{
					engine.showMessage(e.getMessage());
				}
			}

			form.getLocalContext().setAppUserVo(user);
			displayRecord(user);
			
			form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
			
		}
		updateControlsState();
	}

	protected void onChkActiveOnlyValueChanged() throws PresentationLogicException
	{
		onBtnSearchClick();
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if (menuItemID == GenForm.ContextMenus.GenericGrid.Add) 			
		{
			form.setMode(FormMode.EDIT);
			form.getLocalContext().setAppUserVo(new AppUserVo());
			clearScreen();
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.btnUpdate().setEnabled(false);
			form.chkIsActive().setValue(true);
			form.timEffectiveFrm().setValue(new Time("00:00"));
			form.timEffectiveTo().setValue(new Time("00:00"));
			form.timPwdExp().setValue(new Time("00:00"));
		}
		else if (menuItemID == GenForm.ContextMenus.GenericGrid.Update)
		{
			onBtnUpdateClick();
		}
		else if (menuItemID == GenForm.ContextMenus.GenericGrid.Remove)
		{
			AppUserVo user = domain.getAppUser(form.grdAppUsers().getValue());
			form.getLocalContext().setAppUserVo(user);
			form.setMode(FormMode.EDIT);
			
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.btnUpdate().setEnabled(false);
		}

	}

	protected void onFormModeChanged()
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW));
		updateControlsState();
		
	}

	public void updateControlsState()
	{		
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.dtePwdExp().setEnabled(false);
			form.timPwdExp().setEnabled(false);
			form.dteEffectiveFrm().setEnabled(false);
			form.timEffectiveFrm().setEnabled(false);
			form.dteEffectiveTo().setEnabled(false);
			form.timEffectiveTo().setEnabled(false);
			form.btnUpdate().setVisible(true); //WDEV-15408
			
			form.grdRoles().setReadOnly(true);//WDEV-15767
			
			if (form.grdAppUsers().getValue() != null)
			{
				if (form.getLocalContext().getAppUserVoIsNotNull() && form.getLocalContext().getAppUserVo().getEmailAccountIsNotNull())
				{
					// application user must have an email address linked to MOS
					// before entering in email authentication.
					form.lnkEmailAccountInfo().setEnabled(true);
				}
			}
			else
				form.lnkEmailAccountInfo().setEnabled(false);
		}
		else if (form.getMode().equals(FormMode.EDIT))
		{
			form.btnUpdate().setVisible(false); //WDEV-15408
			form.lnkEmailAccountInfo().setEnabled(true);
			form.chkUseExternalAuthentication().setEnabled(ConfigFlag.DOM.EXTERNAL_AUTHENTICATION.getValue());
			
			if(!ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
			{
				form.dtePwdExp().setEnabled(true);
				form.timPwdExp().setEnabled(true);
				form.dteEffectiveFrm().setEnabled(true);
				form.timEffectiveFrm().setEnabled(true);
				form.dteEffectiveTo().setEnabled(true);
				form.timEffectiveTo().setEnabled(true);
			}
			
			// wdev-8744 
			form.txtPwd().setRequired(true);
			form.txtRepeatPwd().setRequired(true);
			
			form.grdRoles().setEnabled(!engine.hasRight(AppRight.ALLOW_USER_PASSWORD_UPDATE_ONLY));//WDEV-15767
		}

		form.imbHeartsUser().setEnabled(form.getMode().equals(FormMode.EDIT));
		
	}

	protected void onLnkEmailAccountInfoClick() throws PresentationLogicException
	{
		
		form.getGlobalContext().Admin.setAppUserVo(form.getLocalContext().getAppUserVo());
		engine.open(form.getForms().Admin.UserEmailAccount,new Object[]{form.getMode()});
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Admin.UserEmailAccount))
		{
			if (result.equals(DialogResult.OK))
			{
				form.getGlobalContext().Admin.setuserEmailAccount((form.getGlobalContext().Admin.getAppUserVo().getEmailAccount()));
				
			}
		}
		else if (formName.equals(form.getForms().Core.YesNoDialog))
		{
			if (result.equals(DialogResult.OK) || result.equals(DialogResult.YES))
			{
				String password = form.getGlobalContext().getPasswordEntered();
				if (password == null || !password.equals("xxxx"))
				{
					engine.showMessage("Incorrect password entered.");
					form.chkDebugMode().setValue(!form.chkDebugMode().getValue());
					return;
				}
			}
			else
			{
				form.chkDebugMode().setValue(!form.chkDebugMode().getValue());
				return;
			}
		}
		else if (formName.equals(form.getForms().Admin.SearchAndSelectPASUser))
		{
			if (result.equals(DialogResult.OK))
			{
				populateScreenFromPasUser();
			}
		}
	}

	private void populateScreenFromPasUser()
	{
		if(form.getGlobalContext().Admin.getHeartsUser() == null)
			throw new CodingRuntimeException("Hearts User is null in method populateScreenFromPasUser");
		
		UserDTOVo voUser = form.getGlobalContext().Admin.getHeartsUser();
		try
		{
			voUser = domain.getDtoAppUserByName(voUser.getUserName());
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		form.txtUsername().setValue(voUser.getUserName());
		
		if(voUser.getEffectiveFromIsNotNull())
		{
			form.dteEffectiveFrm().setValue(voUser.getEffectiveFrom().getDate());
			form.timEffectiveFrm().setValue(voUser.getEffectiveFrom().getTime());
		}
		
		if(voUser.getEffectiveToIsNotNull())
		{
			form.dteEffectiveTo().setValue(voUser.getEffectiveTo().getDate());
			form.timEffectiveTo().setValue(voUser.getEffectiveTo().getTime());
		}
		
		form.dtePwdExp().setValue(voUser.getPasswordExpiryDate());
		// wdev-8744 If password expiry is today, set time to 23:59
		if (voUser.getPasswordExpiryDateIsNotNull() && !voUser.getPasswordExpiryDate().getDate().after(new java.util.Date()))
		{
			form.timPwdExp().setValue(new Time(23, 59));
		}
		
		// wdev-8744 If the expiry is in the future, the password is not mandatory
		if (voUser.getPasswordExpiryDateIsNotNull() && voUser.getPasswordExpiryDate().getDate().after(new java.util.Date()))
		{
			form.txtPwd().setRequired(false);
			form.txtRepeatPwd().setRequired(false);
		}
		else
		{
			form.txtPwd().setRequired(true);
			form.txtRepeatPwd().setRequired(true);
		}
		
		
		form.txtUsername().setValue(voUser.getUserName());
	}

	@Override
	protected void onChkDebugModeValueChanged() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setYesNoDialogMessage("A system password is needed to enable/disable this option.");
		engine.open(form.getForms().Core.YesNoDialog);
	}

	/*
	 * This function validates the date or date/time in the "User Valid Until"
	 * field is later that the date or date/time in the "User Valid From" field.
	 * SEE WDEV-3817
	 */

	private int validateDate(DateTime validFrom, DateTime validUntil)
	{
		
			if (validFrom.isGreaterThan(validUntil))
			{
				return 0;
			}
			else if(validUntil.isLessThan(validFrom))
			{
				return -1;
			}
				return 1;
	}

	@Override
	protected void onQmbMosValueChanged() throws PresentationLogicException 
	{
		if (form.qmbMos().getValue()!=null)
		{
			MemberOfStaffShortVo mos = form.qmbMos().getValue();
			if (mos.getCommChannelsIsNotNull())
				for (int i=0;i<mos.getCommChannels().size();i++)
				{
					if (mos.getCommChannels().get(i).getChannelType().equals(ChannelType.EMAIL))
					{
						form.getGlobalContext().Admin.setuserEmailAccount(domain.getEmailData(form.getLocalContext().getAppUserVo().toAppUserRefVo()));
					}
				}
			form.lnkEmailAccountInfo().setEnabled(true);
		}
		
	}

	@Override
	protected void onImbHeartsUserClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Admin.SearchAndSelectPASUser);
	}
	
	private boolean usesExternalAuthentication() 
	{
		return ConfigFlag.DOM.EXTERNAL_AUTHENTICATION.getValue() && form.chkUseExternalAuthentication().getValue();
	}

	@Override
	protected void onLnkNotificationSettingsClick() throws PresentationLogicException 
	{
		engine.open(form.getForms().Admin.UserNotificationSettings);
	}
}

