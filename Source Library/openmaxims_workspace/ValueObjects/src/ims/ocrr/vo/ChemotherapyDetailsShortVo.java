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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.vo;

/**
 * Linked to Oncology.ChemotherapyDetails business object (ID: 1074100004).
 */
public class ChemotherapyDetailsShortVo extends ims.ocrr.vo.ChemotherapyDetailsLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemotherapyDetailsShortVo()
	{
	}
	public ChemotherapyDetailsShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemotherapyDetailsShortVo(ims.ocrr.vo.beans.ChemotherapyDetailsShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.drugtherapytype = bean.getDrugTherapyType() == null ? null : ims.oncology.vo.lookups.DrugTherapyType.buildLookup(bean.getDrugTherapyType());
		this.regimenacronym = bean.getRegimenAcronym() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getRegimenAcronym());
		this.cancertreatementintent = bean.getCancerTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getCancerTreatementIntent());
		this.treatmentresponse = bean.getTreatmentResponse() == null ? null : ims.oncology.vo.lookups.DrugProgramResponse.buildLookup(bean.getTreatmentResponse());
		this.treatingconsultant = bean.getTreatingConsultant() == null ? null : bean.getTreatingConsultant().buildVo();
		this.txchangereason = bean.getTxChangeReason() == null ? null : ims.oncology.vo.lookups.ChemoTxChangeReason.buildLookup(bean.getTxChangeReason());
		this.pretreatsurfacearea = bean.getPreTreatSurfaceArea();
		this.creatinineclearance = bean.getCreatinineClearance();
		this.heightvaluecm = bean.getHeightValueCM();
		this.weightvaluekg = bean.getWeightValueKG();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ChemotherapyDetailsShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.drugtherapytype = bean.getDrugTherapyType() == null ? null : ims.oncology.vo.lookups.DrugTherapyType.buildLookup(bean.getDrugTherapyType());
		this.regimenacronym = bean.getRegimenAcronym() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getRegimenAcronym());
		this.cancertreatementintent = bean.getCancerTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getCancerTreatementIntent());
		this.treatmentresponse = bean.getTreatmentResponse() == null ? null : ims.oncology.vo.lookups.DrugProgramResponse.buildLookup(bean.getTreatmentResponse());
		this.treatingconsultant = bean.getTreatingConsultant() == null ? null : bean.getTreatingConsultant().buildVo(map);
		this.txchangereason = bean.getTxChangeReason() == null ? null : ims.oncology.vo.lookups.ChemoTxChangeReason.buildLookup(bean.getTxChangeReason());
		this.pretreatsurfacearea = bean.getPreTreatSurfaceArea();
		this.creatinineclearance = bean.getCreatinineClearance();
		this.heightvaluecm = bean.getHeightValueCM();
		this.weightvaluekg = bean.getWeightValueKG();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ChemotherapyDetailsShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ChemotherapyDetailsShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ChemotherapyDetailsShortVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("TREATINGCONSULTANT"))
			return getTreatingConsultant();
		if(fieldName.equals("TXCHANGEREASON"))
			return getTxChangeReason();
		if(fieldName.equals("PRETREATSURFACEAREA"))
			return getPreTreatSurfaceArea();
		if(fieldName.equals("CREATININECLEARANCE"))
			return getCreatinineClearance();
		if(fieldName.equals("HEIGHTVALUECM"))
			return getHeightValueCM();
		if(fieldName.equals("WEIGHTVALUEKG"))
			return getWeightValueKG();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatingConsultantIsNotNull()
	{
		return this.treatingconsultant != null;
	}
	public ims.core.vo.HcpLiteVo getTreatingConsultant()
	{
		return this.treatingconsultant;
	}
	public void setTreatingConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.treatingconsultant = value;
	}
	public boolean getTxChangeReasonIsNotNull()
	{
		return this.txchangereason != null;
	}
	public ims.oncology.vo.lookups.ChemoTxChangeReason getTxChangeReason()
	{
		return this.txchangereason;
	}
	public void setTxChangeReason(ims.oncology.vo.lookups.ChemoTxChangeReason value)
	{
		this.isValidated = false;
		this.txchangereason = value;
	}
	public boolean getPreTreatSurfaceAreaIsNotNull()
	{
		return this.pretreatsurfacearea != null;
	}
	public Float getPreTreatSurfaceArea()
	{
		return this.pretreatsurfacearea;
	}
	public void setPreTreatSurfaceArea(Float value)
	{
		this.isValidated = false;
		this.pretreatsurfacearea = value;
	}
	public boolean getCreatinineClearanceIsNotNull()
	{
		return this.creatinineclearance != null;
	}
	public Float getCreatinineClearance()
	{
		return this.creatinineclearance;
	}
	public void setCreatinineClearance(Float value)
	{
		this.isValidated = false;
		this.creatinineclearance = value;
	}
	public boolean getHeightValueCMIsNotNull()
	{
		return this.heightvaluecm != null;
	}
	public Float getHeightValueCM()
	{
		return this.heightvaluecm;
	}
	public void setHeightValueCM(Float value)
	{
		this.isValidated = false;
		this.heightvaluecm = value;
	}
	public boolean getWeightValueKGIsNotNull()
	{
		return this.weightvaluekg != null;
	}
	public Float getWeightValueKG()
	{
		return this.weightvaluekg;
	}
	public void setWeightValueKG(Float value)
	{
		this.isValidated = false;
		this.weightvaluekg = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.episodeofcare == null)
			listOfErrors.add("Episode Of Care is mandatory");
		if(this.drugtherapytype == null)
			listOfErrors.add("Drug Therapy Type is mandatory");
		if(this.regimenacronym == null)
			listOfErrors.add("Regimen Acronym is mandatory");
		if(this.treatingconsultant == null)
			listOfErrors.add("Treating Consultant is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ChemotherapyDetailsShortVo clone = new ChemotherapyDetailsShortVo(this.id, this.version);
		
		clone.episodeofcare = this.episodeofcare;
		clone.carecontext = this.carecontext;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.drugtherapytype == null)
			clone.drugtherapytype = null;
		else
			clone.drugtherapytype = (ims.oncology.vo.lookups.DrugTherapyType)this.drugtherapytype.clone();
		if(this.regimenacronym == null)
			clone.regimenacronym = null;
		else
			clone.regimenacronym = (ims.oncology.vo.lookups.RegimenAcronym)this.regimenacronym.clone();
		if(this.cancertreatementintent == null)
			clone.cancertreatementintent = null;
		else
			clone.cancertreatementintent = (ims.oncology.vo.lookups.CancerTreatmentIntent)this.cancertreatementintent.clone();
		if(this.treatmentresponse == null)
			clone.treatmentresponse = null;
		else
			clone.treatmentresponse = (ims.oncology.vo.lookups.DrugProgramResponse)this.treatmentresponse.clone();
		if(this.treatingconsultant == null)
			clone.treatingconsultant = null;
		else
			clone.treatingconsultant = (ims.core.vo.HcpLiteVo)this.treatingconsultant.clone();
		if(this.txchangereason == null)
			clone.txchangereason = null;
		else
			clone.txchangereason = (ims.oncology.vo.lookups.ChemoTxChangeReason)this.txchangereason.clone();
		clone.pretreatsurfacearea = this.pretreatsurfacearea;
		clone.creatinineclearance = this.creatinineclearance;
		clone.heightvaluecm = this.heightvaluecm;
		clone.weightvaluekg = this.weightvaluekg;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ChemotherapyDetailsShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemotherapyDetailsShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ChemotherapyDetailsShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ChemotherapyDetailsShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.treatingconsultant != null)
			count++;
		if(this.txchangereason != null)
			count++;
		if(this.pretreatsurfacearea != null)
			count++;
		if(this.creatinineclearance != null)
			count++;
		if(this.heightvaluecm != null)
			count++;
		if(this.weightvaluekg != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.core.vo.HcpLiteVo treatingconsultant;
	protected ims.oncology.vo.lookups.ChemoTxChangeReason txchangereason;
	protected Float pretreatsurfacearea;
	protected Float creatinineclearance;
	protected Float heightvaluecm;
	protected Float weightvaluekg;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
