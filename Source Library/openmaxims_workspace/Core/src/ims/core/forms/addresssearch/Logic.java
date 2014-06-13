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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.65 build 3202.18140)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.addresssearch;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.GeoCoOrdVo;
import ims.core.vo.PersonAddress;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IAddressProvider;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}

	private void initialize() 
	{
		if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("UK"))
		{			
			form.lblPostCode().setVisible(true);			
			form.txtPost().setVisible(true);
			form.txtPost().setEnabled(false);
			if (ConfigFlag.UI.DISPLAY_PCT_CODE.getValue())
			{
				form.lblPCTCode().setVisible(true);
				form.txtPctCode().setVisible(true);
				form.txtPctCode().setEnabled(false);
			}
			else
			{
				form.lblPCTCode().setVisible(false);
				form.txtPctCode().setVisible(false);
				form.txtPctCode().setEnabled(false);				
			}
			form.lblCounty().setVisible(false);
			form.cmbCounty().setVisible(false);			
			form.pnlAddressSearch().setVisible(ConfigFlag.UI.CAPSCAN_ENABLED.getValue());
			form.lblSearch().setVisible(ConfigFlag.UI.CAPSCAN_ENABLED.getValue());
			form.txtAddressSearchText().setVisible(ConfigFlag.UI.CAPSCAN_ENABLED.getValue());
			form.imbPostCodeSearch().setVisible(ConfigFlag.UI.CAPSCAN_ENABLED.getValue());			
			form.txtAddressPhone().setEnabled(false);
		}
		else if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH"))
		{			
			form.lblPostCode().setVisible(false);			
			form.txtPost().setVisible(false);			
			form.lblPostCode().setVisible(false);
			form.lblPCTCode().setVisible(false);
			form.txtPctCode().setVisible(false);
			form.lblSearch().setVisible(false);
			form.txtAddressSearchText().setVisible(false);
			form.imbPostCodeSearch().setVisible(false);
			form.pnlAddressSearch().setVisible(false);
			form.lblSearch().setVisible(false);
			form.txtAddressSearchText().setVisible(false);
			form.imbPostCodeSearch().setVisible(false);			
		}
		
		if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
			form.txtAddress5().setVisible(false);
		
		form.imbAddressHistory().setVisible(false);//WDEV-13009 only visible when set in form logic e.g. demographics 
		
		clearControl();		
	}

	private void clearControl() 
	{
		form.txtAddressSearchText().setValue("");
	}
	
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.AddressSelection) && result.equals(DialogResult.OK))
		{
			//display selected personAddress from GC
			form.getLocalContext().setaddressResult(form.getGlobalContext().Core.getPersonAddress());
			displayAddress();			
		}		
	}
		
	protected void displayAddress() 
	{
		//WDEV-15963
		boolean lbBuildingNameDisplayed = false;
		boolean lbBuildingNumberDisplayed = false;
		boolean lbPostTownDisplayed = false;
		boolean lbAddressStreetDisplayed = false;
		//WDEV-15963
		
		//WDEV-17696
		if (form.getMode().equals(FormMode.EDIT))
		{
			//display from local context
			if (form.getLocalContext().getaddressResult() != null)
			{
				if ((form.getLocalContext().getaddressResult().getAddressBuildingName() !=  null && !form.getLocalContext().getaddressResult().getAddressBuildingName().equals("")))
				{
					//address with building name
					if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
					{
						//WDEV-9025
						//WDEV-15963 
						//check length of address and display on available lines.						
						if (form.getLocalContext().getaddressResult().getOrganisationIsNotNull() && !form.getLocalContext().getaddressResult().getOrganisation().equals(""))
						{
							if (form.getLocalContext().getaddressResult().getOrganisation().length() 
									+ form.getLocalContext().getaddressResult().getAddressBuildingName().length() 
									<= form.getLocalContext().getaddressResult().getLine1MaxLength())
							{
								lbBuildingNameDisplayed = true;
								form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getOrganisation() + "," + form.getLocalContext().getaddressResult().getAddressBuildingName());																
							}
							else
							{
								form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getOrganisation().substring(0, form.getLocalContext().getaddressResult().getOrganisation().length()<=form.getLocalContext().getaddressResult().getLine1MaxLength()?form.getLocalContext().getaddressResult().getOrganisation().length():form.getLocalContext().getaddressResult().getLine1MaxLength()));	
							}
						}
						else
						{
							form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());
							lbBuildingNameDisplayed = true;
						}

						if (lbBuildingNameDisplayed)
						{
							form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingNumber());
							lbBuildingNumberDisplayed = true;
						}
						else
						{
							if ((form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressBuildingNumber()).length() 
									<= ims.core.vo.PersonAddress.getLine2MaxLength())
							{
								form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressBuildingNumber());
								lbBuildingNumberDisplayed = true;
							}
							else
							{
								form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());								
							}							
						}
						 
						String address3 = "";
						if (lbBuildingNumberDisplayed)
						{
							address3 += form.getLocalContext().getaddressResult().getAddressLocality() != null ? form.getLocalContext().getaddressResult().getAddressLocality() : "";
							address3 += form.getLocalContext().getaddressResult().getAddressPostTown() != null ? (address3.length() > 0 ? "," : "") + form.getLocalContext().getaddressResult().getAddressPostTown() : "";
							lbPostTownDisplayed = true;
						}
						else
						{
							address3 += form.getLocalContext().getaddressResult().getAddressBuildingNumber() + ",";
							address3 += form.getLocalContext().getaddressResult().getAddressLocality() != null ? form.getLocalContext().getaddressResult().getAddressLocality() : "";
							
							if ((address3 + form.getLocalContext().getaddressResult().getAddressPostTown()).length() <= ims.core.vo.PersonAddress.getLine3MaxLength())
							{
								address3 += form.getLocalContext().getaddressResult().getAddressPostTown() != null ? (address3.length() > 0 ? "," : "") + form.getLocalContext().getaddressResult().getAddressPostTown() : "";
								lbPostTownDisplayed = true;
							}							
						}
						
						form.txtAddress3().setValue(address3);// 	WDEV-17432
						
						if (lbPostTownDisplayed)
							form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressCounty());
						else
							form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressPostTown() != null ? form.getLocalContext().getaddressResult().getAddressPostTown() + "," : "" 
									+ form.getLocalContext().getaddressResult().getAddressCounty());
						
						//WDEV-15963
					}
					else
					{
						//WDEV-15963
						//check length of address and display on available lines.						
						if (form.getLocalContext().getaddressResult().getOrganisationIsNotNull() && !form.getLocalContext().getaddressResult().getOrganisation().equals(""))
						{
							if (form.getLocalContext().getaddressResult().getOrganisation().length() + form.getLocalContext().getaddressResult().getAddressBuildingName().length() 
									<= form.getLocalContext().getaddressResult().getLine1MaxLength())
							{
								lbBuildingNameDisplayed = true;
								form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getOrganisation() + "," + form.getLocalContext().getaddressResult().getAddressBuildingName());								
							}
							else
							{
								form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getOrganisation().substring(0, form.getLocalContext().getaddressResult().getOrganisation().length()<=form.getLocalContext().getaddressResult().getLine1MaxLength()?form.getLocalContext().getaddressResult().getOrganisation().length():form.getLocalContext().getaddressResult().getLine1MaxLength()));																
							}
						}
						else
						{
							form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());
							lbBuildingNameDisplayed = true;
						}

						if (form.getLocalContext().getaddressResult().getAddressStreet() != null && !form.getLocalContext().getaddressResult().getAddressStreet().equals(""))
						{
							if (form.getLocalContext().getaddressResult().getAddressLocality() != null && !form.getLocalContext().getaddressResult().getAddressLocality().equals(""))
							{
								//WDEV-15963
								if (lbBuildingNameDisplayed)
								{
									form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressStreet());
									lbBuildingNumberDisplayed = true; // at this point there will be no building number
								}
								else
								{
									//form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressStreet());
									if ((form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressStreet()).length() 
											<= ims.core.vo.PersonAddress.getLine2MaxLength())
									{
										form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressBuildingNumber());
										lbBuildingNameDisplayed = true;
										lbBuildingNumberDisplayed = true;
									}
									else
									{
										form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());										
									}							
								}									
								//WDEV-15963
								
								if (!lbBuildingNumberDisplayed)
								{
									form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressBuildingNumber() + "," +
											form.getLocalContext().getaddressResult().getAddressLocality());
								}
								else
									form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressLocality());
								
								form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressPostTown());
								form.txtAddress5().setValue(form.getLocalContext().getaddressResult().getAddressCounty());	
							}
							else
							{
								//WDEV-15963
								if (lbBuildingNameDisplayed)
								{
									form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressStreet());
									lbBuildingNumberDisplayed = true;
								}
								else
								{
									//form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressStreet());
									if ((form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressStreet()).length() 
											<= ims.core.vo.PersonAddress.getLine2MaxLength())
									{
										form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName() + "," + form.getLocalContext().getaddressResult().getAddressBuildingNumber());
										lbBuildingNameDisplayed = true;
										lbBuildingNumberDisplayed = true;
									}
									else
									{
										form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());										
									}																
								}
								//WDEV-15963
								
								if (!lbBuildingNumberDisplayed)
								{
									form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressBuildingNumber() + "," +
											form.getLocalContext().getaddressResult().getAddressPostTown());									
								}
								else
									form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressPostTown()!=null?form.getLocalContext().getaddressResult().getAddressPostTown():"");
								
								if (form.getLocalContext().getaddressResult().getAddressCounty() != null 
										&& !form.getLocalContext().getaddressResult().getAddressCounty().equals(form.getLocalContext().getaddressResult().getAddressPostTown()))// 	WDEV-17810
									form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressCounty());
								else
									form.txtAddress4().setValue("");
								form.txtAddress5().setValue("");
							}
							if (form.getLocalContext().getaddressResult().getCounty()!=null)
								form.cmbCounty().setValue(form.getLocalContext().getaddressResult().getCounty());
						}
						else
						{
							if (form.getLocalContext().getaddressResult().getAddressLocality() != null && !form.getLocalContext().getaddressResult().getAddressLocality().equals(""))
							{
								//WDEV-15963
								if (lbBuildingNameDisplayed)
									form.txtAddress2().setValue("");//WDEV-15211
								else
									form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());
								//WDEV-15963
																
								form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressLocality());
								form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressPostTown());
								form.txtAddress5().setValue(form.getLocalContext().getaddressResult().getAddressCounty());					
							}
							else
							{
								form.txtAddress2().setValue("");//WDEV-15211
								form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressPostTown());
								form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressCounty());
								form.txtAddress5().setValue("");
							}					
						}
					}
				}
				else
				{					
					//WDEV-15963
					if (form.getLocalContext().getaddressResult().getOrganisationIsNotNull() 
							&& !form.getLocalContext().getaddressResult().getOrganisation().equals(""))
					{
						if ((form.getLocalContext().getaddressResult().getOrganisation() + "," + form.getLocalContext().getaddressResult().getAddressStreet()).length()
								<= ims.core.vo.PersonAddress.getLine1MaxLength())
						{
							form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getOrganisation() + "," 
								+ form.getLocalContext().getaddressResult().getAddressStreet());
							lbAddressStreetDisplayed = true;
						}
						else
						{
							form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getOrganisation().substring(0, form.getLocalContext().getaddressResult().getOrganisation().length()<=form.getLocalContext().getaddressResult().getLine1MaxLength()?form.getLocalContext().getaddressResult().getOrganisation().length():form.getLocalContext().getaddressResult().getLine1MaxLength()));
						}						
					}
					else
					{						
						form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getAddressStreet());
						lbAddressStreetDisplayed = true;
					}
					
					
					if (form.getLocalContext().getaddressResult().getAddressLocality() != null && !form.getLocalContext().getaddressResult().getAddressLocality().equals(""))
					{
						if (!lbAddressStreetDisplayed)
						{
							form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressStreet() + "," 
									+ form.getLocalContext().getaddressResult().getAddressLocality());
						}
						else
							form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressLocality());
						
						form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressPostTown());
						
						if (form.getLocalContext().getaddressResult().getAddressCounty() != null && !form.getLocalContext().getaddressResult().getAddressCounty().equals(form.getLocalContext().getaddressResult().getAddressPostTown()))
							form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressCounty());
						else
							form.txtAddress4().setValue("");
						
						form.txtAddress5().setValue("");
					}
					else
					{
						form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressPostTown());
						form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressCounty());
						form.txtAddress4().setValue("");
						form.txtAddress5().setValue("");
					}					
				}

				form.txtPost().setValue(form.getLocalContext().getaddressResult().getAddressPostCode());
				form.txtPctCode().setValue(form.getLocalContext().getaddressResult().getPCT());
			}
		}
		else
		{
			//just display directly what was saved, i.e. no formatting
			form.txtAddress1().setValue(form.getLocalContext().getaddressResult().getAddressBuildingName());
			form.txtAddress2().setValue(form.getLocalContext().getaddressResult().getAddressBuildingNumber());
			form.txtAddress3().setValue(form.getLocalContext().getaddressResult().getAddressLocality());
			form.txtAddress4().setValue(form.getLocalContext().getaddressResult().getAddressPostTown());
			form.txtAddress5().setValue(form.getLocalContext().getaddressResult().getAddressCounty());
			form.txtPost().setValue(form.getLocalContext().getaddressResult().getAddressPostCode());
			form.txtPctCode().setValue(form.getLocalContext().getaddressResult().getPCT());
		}
		//WDEV-17696
	}
	private void displayPhone() 
	{
		//display phonenumber
		form.cmbCounty().setValue(form.getLocalContext().getaddressResult().getCounty());
		form.txtAddressPhone().setValue(form.getLocalContext().getaddressResult().getPhone());		
	}

	@Override
	protected void onFormModeChanged()
	{
		form.txtPost().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.txtPctCode().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.txtAddressSearchText().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.imbPostCodeSearch().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.txtAddressPhone().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.cmbCounty().setEnabled(form.getMode().equals(FormMode.EDIT));		
	}
	
	@Override
	protected void onImbPostCodeSearchClick() throws PresentationLogicException 
	{
		// Address provider helper
		IAddressProvider l_addressprovider = engine.getAddressProvider();
		if(l_addressprovider == null)
			throw new PresentationLogicException("Please Configure Address Provider");

		PersonAddress personAddress = new PersonAddress();
		PersonAddress[] personAddressResult = new PersonAddress[0];
				
		//Funtionality
		//To initiate search, the user will use either the poscode field or an additional address search field located on the right of the poscode field
		//The poscode field will initiate a search of type POSTCODE
		//the additional address search field will initiate a search of type BROWSE with input ADDR
				
		try
		{			
			if (form.txtAddressSearchText().getValue() != null && !form.txtAddressSearchText().getValue().equals(""))
			{
				personAddress.setAddressSearchText(form.txtAddressSearchText().getValue());// search criteria comma delimited.
				form.getGlobalContext().Core.setAddressSearchType("SEARCH");
			}
			else
			{
				engine.showMessage("Please enter a post code or keywords from the first or second line of the address.");
				return;
			}
			personAddressResult = (PersonAddress[])l_addressprovider.getAddress(personAddress,form.getGlobalContext().Core.getAddressSearchType(),"",""); // return result or ambiglist
		}
		catch (PresentationLogicException pe)
		{
			engine.showMessage(pe.getMessage());
		}
		
		//fill out rest of address fields if somthing found
		if (personAddressResult != null && personAddressResult.length == 1)
		{
			//exact match
			form.getLocalContext().setaddressResult(personAddressResult[0]);
			displayAddress();
		}
		else
		{
			form.getGlobalContext().Core.setAddressSearchText(form.txtAddressSearchText().getValue());
			form.getGlobalContext().Core.setPersonAddress(personAddress);
			engine.open(form.getForms().Core.AddressSelection);
		}						
	}
	//------------------- Component Interface methods ---------------------------
	
	public void setEnabled(Boolean value)
	{
		if (value != null)
		{			
			form.txtAddressSearchText().setEnabled(value);
			form.imbPostCodeSearch().setEnabled(value);
		}
	}
	public void setComponentEnabled(Boolean value)
	{
		if (value !=null)
		{
			if (value==true)
			{
				form.setMode(FormMode.EDIT);
				form.txtAddress5().setEnabled(true);
			}
			else if (value==false)
			{
				form.setMode(FormMode.VIEW);
				form.txtAddress5().setEnabled(false);
			}
		}
	}

	public void isRequired(Boolean value) 
	{
		if (value != null)
		{
			if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("UK"))
			{
				form.txtPost().setRequired(value);
				if (ConfigFlag.UI.DISPLAY_PCT_CODE.getValue())
					form.txtPctCode().setRequired(value);
			}
			else if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH"))
			{
				form.txtPost().setVisible(false);
				form.txtPctCode().setVisible(false);
			}
			
			form.getLocalContext().setIsRequired(value);
		}
	}

	public void clear() 
	{
		form.txtAddressSearchText().setValue(null);
	}

	public String getError(String labelName) 
	{
		if (form.getLocalContext().getIsRequiredIsNotNull() && form.getLocalContext().getIsRequired())
		{
			if(labelName == null || (labelName != null && labelName.length() == 0))
			{
				labelName = "Post Code";
			}
			
			String label = labelName.charAt(labelName.length() - 1) == ' ' ? labelName : labelName + " ";
			
			if (form.txtAddressSearchText().getValue() == null)
				return new String(label + "is mandatory");
		}
		
		return null;
	}

	public void setValue(ims.core.vo.PersonAddress address) 
	{
		// fill patient address
		if (address == null)
		{
			address = new PersonAddress();
		}
		
		form.getLocalContext().setaddressResult(address);
		form.getGlobalContext().Core.setPersonAddress(address);
		displayAddress();
		displayPhone();
	}
	
	public ims.core.vo.PersonAddress getValue() 
	{		
		if (form.getLocalContext().getaddressResultIsNotNull())
			return getlines((PersonAddress) form.getLocalContext().getaddressResult().clone());
		return null;		
	}
	
	private PersonAddress getlines(PersonAddress addressResult)
	{
		if (addressResult == null)
			return null;
		
		addressResult.setLine1((form.txtAddress1().getValue()));
		addressResult.setLine2((form.txtAddress2().getValue()));
		addressResult.setLine3((form.txtAddress3().getValue()));
		addressResult.setLine4((form.txtAddress4().getValue()));
		if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
			addressResult.setLine5("");
		else
			addressResult.setLine5((form.txtAddress5().getValue()));
		
		return addressResult;
	}
	
	public void clearscreen() 
	{
		form.txtAddress1().setValue(null);
		form.txtAddress2().setValue(null);
		form.txtAddress3().setValue(null);
		form.txtAddress4().setValue(null);
		form.txtAddress5().setValue(null);
		form.txtAddressPhone().setValue(null);
		form.txtAddressSearchText().setValue(null);
		form.txtPost().setValue(null);
		form.txtPctCode().setValue(null);
		form.cmbCounty().setValue(null);
		
		form.getLocalContext().setaddressResult(null); //WDEV-14367
	
	}

	@Override
	protected void onCmbCountyValueChanged() throws PresentationLogicException 
	{		
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
		if (form.cmbCounty().getValue() !=  null)
		{
			form.getLocalContext().getaddressResult().setCounty(form.cmbCounty().getValue());
			form.getLocalContext().getaddressResult().setAddressCounty(form.cmbCounty().getValue().getIItemText());
		}		
	}

	@Override
	protected void onTxtAddress1ValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
		
//		form.getLocalContext().getaddressResult().setAddressBuildingNumber(form.txtAddress1().getValue());
//		form.getLocalContext().getaddressResult().setAddressBuildingName(form.txtAddress1().getValue());
		form.getLocalContext().getaddressResult().setLine1(form.txtAddress1().getValue());
		
	}

	@Override
	protected void onTxtAddress2ValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
//		form.getLocalContext().getaddressResult().setAddressLocality(form.txtAddress2().getValue());		
//		form.getLocalContext().getaddressResult().setAddressBuildingNumber(form.txtAddress2().getValue());
		form.getLocalContext().getaddressResult().setLine2(form.txtAddress2().getValue());
	}

	@Override
	protected void onTxtAddress3ValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
//		form.getLocalContext().getaddressResult().setAddressPostTown((form.txtAddress3().getValue()));				
//		form.getLocalContext().getaddressResult().setAddressLocality((form.txtAddress3().getValue()));
		form.getLocalContext().getaddressResult().setLine3(form.txtAddress3().getValue());
	}

	@Override
	protected void onTxtAddress4ValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
//		form.getLocalContext().getaddressResult().setAddressCounty((form.txtAddress4().getValue()));						
//		form.getLocalContext().getaddressResult().setAddressPostTown((form.txtAddress4().getValue()));
		form.getLocalContext().getaddressResult().setLine4(form.txtAddress4().getValue());
	}

	@Override
	protected void onTxtAddress5ValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
///		form.getLocalContext().getaddressResult().setAddressLine5((form.txtAddress5().getValue()));
		form.getLocalContext().getaddressResult().setLine5(form.txtAddress5().getValue());
	}

	@Override
	protected void onTxtAddressPhoneValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
		form.getLocalContext().getaddressResult().setPhone((form.txtAddressPhone().getValue()));						
		
	}

	@Override
	protected void onTxtPostValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
		form.getLocalContext().getaddressResult().setPostCode((form.txtPost().getValue()));								
	}
	
	protected void onTxtPctCodeValueChanged() throws PresentationLogicException 
	{
		// update local context
		if (form.getLocalContext().getaddressResult() == null)
		{
			form.getLocalContext().setaddressResult(new PersonAddress());
		}
	
		form.getLocalContext().getaddressResult().setPCTcode((form.txtPctCode().getValue()));								
		
	}

	public void setPhoneVisible(Boolean value) 
	{
		form.lblAddressPhone().setVisible(value);
		form.txtAddressPhone().setVisible(value);
	}
	
	public void setHistoricAddressBtnVisible(Boolean value) 
	{
		form.imbAddressHistory().setVisible(value);
	}

	public void setSearchControlsVisible(Boolean value) 
	{
		form.pnlAddressSearch().setVisible(value);
		form.lblSearch().setVisible(value);
		form.txtAddressSearchText().setVisible(value);
		form.imbPostCodeSearch().setVisible(value);
	}
	
	public void setTitle(String title) 
	{
		form.pnlAddressSearch().setValue(title);
	}

	public String verifyPCT(String postCode)
	{
		// Address provider helper
		IAddressProvider l_addressprovider = engine.getAddressProvider();
		if(l_addressprovider == null)
			return null;

		PersonAddress address = new PersonAddress();
		PersonAddress[] personAddressResult = new PersonAddress[0];
		
		String l_pctCode = form.txtPctCode().getValue();
		
		if (ConfigFlag.UI.DISPLAY_PCT_CODE.getValue())
		{		
			if ((l_pctCode != null) && (l_pctCode != ""))
			{
											
				try
				{			
					if (form.txtPost().getValue() != null && !form.txtPost().getValue().equals(""))
					{
						form.getGlobalContext().Core.setAddressSearchType("SEARCH");
					}
					address.setAddressSearchText(postCode);
					personAddressResult = (PersonAddress[])l_addressprovider.getAddress(address,form.getGlobalContext().Core.getAddressSearchType(),"",""); // return result or ambiglist
				}
				catch (PresentationLogicException pe)
				{
					engine.showMessage(pe.getMessage());
				}
				
				boolean l_match = true;
				
				//fill out rest of address fields if somthing found
				if (personAddressResult == null)
					return null;
				
				if (personAddressResult != null && personAddressResult.length == 1)
				{
					//possible exact match
					if (personAddressResult[0].getPCTIsNotNull())
					{
						if (l_pctCode.equalsIgnoreCase(personAddressResult[0].getPCT()))
						{
							l_match = true;
						}
						else
							l_match = false;						
					}
				}
				else
				{
					PersonAddress pa = null;				
					for (int i =0; i< personAddressResult.length; i++)
					{
						pa = personAddressResult[i];
						if (pa.getPctCode() != null)
						{
							if (!l_pctCode.equalsIgnoreCase(pa.getPctCode()))
									l_match = false;
						}
					}
				}						
				
				if (l_match)
					return personAddressResult[0].getPCT();
				else
					return null;
			}
			else
			{
				//automatically fill in the pct if a postcode is given on editing, i.e. not through capscan
				if (form.txtPost().getValue() != "")
				{
					try
					{			
						if (form.txtPost().getValue() != null && !form.txtPost().getValue().equals(""))
						{
							form.getGlobalContext().Core.setAddressSearchType("SEARCH");
						}
						address.setAddressSearchText(postCode);
						personAddressResult = (PersonAddress[])l_addressprovider.getAddress(address,form.getGlobalContext().Core.getAddressSearchType(),"",""); // return result or ambiglist
					}
					catch (PresentationLogicException pe)
					{
						engine.showMessage(pe.getMessage());
					}
					
					//fill out rest of address fields if somthing found
					if (personAddressResult == null)
						return null;
					
					if (personAddressResult != null && personAddressResult.length >= 1)
					{
						//possible match
						if (personAddressResult[0].getPCTIsNotNull() && personAddressResult[0].getPCT() != "")
						{						
							form.txtPctCode().setValue(personAddressResult[0].getPCT());
							if (form.getLocalContext().getaddressResult() != null)
							{
								form.getLocalContext().getaddressResult().setPCT(form.txtPctCode().getValue());
								if (form.getGlobalContext().Core.getPersonAddressIsNotNull())
									form.getGlobalContext().Core.getPersonAddress().setPCT(form.txtPctCode().getValue());
								displayAddress();
							}
							return personAddressResult[0].getPCT();
						}
						else
							return null;
					}	
				}
			}
		}
		
		return null;
	}

	protected void onBtnShowGeoCoOrdsClick() throws PresentationLogicException 
	{
		
		try {
			if (form.txtPost().getValue() != null && form.txtPost().getValue() != "")
			{
				GeoCoOrdVo vo = domain.getGeoCoOrds(form.txtPost().getValue());
				if (vo != null)
				{
					if (vo.getLatitudeIsNotNull() && vo.getLogitudeIsNotNull())
					{
						String format = String.format("Lattitude: %f Longitude: %f",vo.getLatitude(),vo.getLogitude());
						engine.showMessage(format);
					}
				}
			}
		} catch (DomainInterfaceException e) 
		{
			throw new PresentationLogicException(e.getMessage());
		}
		
		/*
		double[] coOrds;
		ims.core.vo.PersonAddress lpa = new ims.core.vo.PersonAddress();
		
		if (form.txtPost().getValue() != null)
		{
			if (form.getGlobalContext().Core.getPersonAddressIsNotNull())
				coOrds = engine.getAddressProvider().getLatitudeLogitude(form.getGlobalContext().Core.getPersonAddress());
			else
			{
				lpa.setAddressPostCode(form.txtPost().getValue());
				coOrds = engine.getAddressProvider().getLatitudeLogitude(lpa);
			}
			
			if (coOrds != null)
			{
				if (coOrds.length == 2)
				{
					String format = String.format("Lattitude: %f Longitude: %f",coOrds[0],coOrds[1]);
					engine.showMessage(format);
				}
			}
		}
		*/
		
	}

	@Override
	protected void onImbAddressHistoryClick() throws PresentationLogicException {
		engine.open(form.getForms().Core.AddressHistoryDlg, new Object[] { form.getGlobalContext().Core.getOtherAddresses() });
		
	}

	//wdev-13268
	public void setRequireAdress(Boolean enable) 
	{				
		if(Boolean.TRUE.equals(enable))
			form.txtAddress1().setRequired(true);
		else
			form.txtAddress1().setRequired(false);
		

		
	}
}
