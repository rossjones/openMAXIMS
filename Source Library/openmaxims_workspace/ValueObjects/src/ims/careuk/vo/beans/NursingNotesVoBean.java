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

package ims.careuk.vo.beans;

public class NursingNotesVoBean extends ims.vo.ValueObjectBean
{
	public NursingNotesVoBean()
	{
	}
	public NursingNotesVoBean(ims.careuk.vo.NursingNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringuser = vo.getAuthoringUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringUser().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.vitalsigns = vo.getVitalSigns() == null ? null : (ims.core.vo.beans.VitalSignsForNursingNotesVoBean)vo.getVitalSigns().getBean();
		this.allergies = vo.getAllergies() == null ? null : vo.getAllergies().getBeanCollection();
		this.smokingstatus = vo.getSmokingStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSmokingStatus().getBean();
		this.advicegiven = vo.getAdviceGiven();
		this.unitsofalcoholconsumedperweek = vo.getUnitsOfAlcoholConsumedPerWeek();
		this.referredtosomkingcessation = vo.getReferredToSomkingCessation();
		this.observationnotes = vo.getObservationNotes();
		this.comorbidities = vo.getComorbidities() == null ? null : vo.getComorbidities().getBeanCollection();
		this.mrsaresult = vo.getMRSAResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getMRSAResult().getBean();
		if(vo.getSpecialNeeds() != null)
		{
			this.specialneeds = new ims.vo.RefVoBean[vo.getSpecialNeeds().size()];
			for(int specialneeds_i = 0; specialneeds_i < vo.getSpecialNeeds().size(); specialneeds_i++)
			{
				this.specialneeds[specialneeds_i] = new ims.vo.RefVoBean(vo.getSpecialNeeds().get(specialneeds_i).getBoId(),vo.getSpecialNeeds().get(specialneeds_i).getBoVersion());
			}
		}
		this.currentmedications = vo.getCurrentMedications() == null ? null : vo.getCurrentMedications().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.NursingNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringuser = vo.getAuthoringUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringUser().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.vitalsigns = vo.getVitalSigns() == null ? null : (ims.core.vo.beans.VitalSignsForNursingNotesVoBean)vo.getVitalSigns().getBean(map);
		this.allergies = vo.getAllergies() == null ? null : vo.getAllergies().getBeanCollection();
		this.smokingstatus = vo.getSmokingStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSmokingStatus().getBean();
		this.advicegiven = vo.getAdviceGiven();
		this.unitsofalcoholconsumedperweek = vo.getUnitsOfAlcoholConsumedPerWeek();
		this.referredtosomkingcessation = vo.getReferredToSomkingCessation();
		this.observationnotes = vo.getObservationNotes();
		this.comorbidities = vo.getComorbidities() == null ? null : vo.getComorbidities().getBeanCollection();
		this.mrsaresult = vo.getMRSAResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getMRSAResult().getBean();
		if(vo.getSpecialNeeds() != null)
		{
			this.specialneeds = new ims.vo.RefVoBean[vo.getSpecialNeeds().size()];
			for(int specialneeds_i = 0; specialneeds_i < vo.getSpecialNeeds().size(); specialneeds_i++)
			{
				this.specialneeds[specialneeds_i] = new ims.vo.RefVoBean(vo.getSpecialNeeds().get(specialneeds_i).getBoId(),vo.getSpecialNeeds().get(specialneeds_i).getBoVersion());
			}
		}
		this.currentmedications = vo.getCurrentMedications() == null ? null : vo.getCurrentMedications().getBeanCollection();
	}

	public ims.careuk.vo.NursingNotesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.NursingNotesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.NursingNotesVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.NursingNotesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.NursingNotesVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.authoringuser = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.VitalSignsForNursingNotesVoBean getVitalSigns()
	{
		return this.vitalsigns;
	}
	public void setVitalSigns(ims.core.vo.beans.VitalSignsForNursingNotesVoBean value)
	{
		this.vitalsigns = value;
	}
	public ims.core.vo.beans.PatientAllergyForNursingNotesVoBean[] getAllergies()
	{
		return this.allergies;
	}
	public void setAllergies(ims.core.vo.beans.PatientAllergyForNursingNotesVoBean[] value)
	{
		this.allergies = value;
	}
	public ims.vo.LookupInstanceBean getSmokingStatus()
	{
		return this.smokingstatus;
	}
	public void setSmokingStatus(ims.vo.LookupInstanceBean value)
	{
		this.smokingstatus = value;
	}
	public Boolean getAdviceGiven()
	{
		return this.advicegiven;
	}
	public void setAdviceGiven(Boolean value)
	{
		this.advicegiven = value;
	}
	public Float getUnitsOfAlcoholConsumedPerWeek()
	{
		return this.unitsofalcoholconsumedperweek;
	}
	public void setUnitsOfAlcoholConsumedPerWeek(Float value)
	{
		this.unitsofalcoholconsumedperweek = value;
	}
	public Boolean getReferredToSomkingCessation()
	{
		return this.referredtosomkingcessation;
	}
	public void setReferredToSomkingCessation(Boolean value)
	{
		this.referredtosomkingcessation = value;
	}
	public String getObservationNotes()
	{
		return this.observationnotes;
	}
	public void setObservationNotes(String value)
	{
		this.observationnotes = value;
	}
	public ims.core.vo.beans.PatientDiagnosisForNursingNotesVoBean[] getComorbidities()
	{
		return this.comorbidities;
	}
	public void setComorbidities(ims.core.vo.beans.PatientDiagnosisForNursingNotesVoBean[] value)
	{
		this.comorbidities = value;
	}
	public ims.vo.LookupInstanceBean getMRSAResult()
	{
		return this.mrsaresult;
	}
	public void setMRSAResult(ims.vo.LookupInstanceBean value)
	{
		this.mrsaresult = value;
	}
	public ims.vo.RefVoBean[] getSpecialNeeds()
	{
		return this.specialneeds;
	}
	public void setSpecialNeeds(ims.vo.RefVoBean[] value)
	{
		this.specialneeds = value;
	}
	public ims.core.vo.beans.PatientMedicationForNursingNotesVoBean[] getCurrentMedications()
	{
		return this.currentmedications;
	}
	public void setCurrentMedications(ims.core.vo.beans.PatientMedicationForNursingNotesVoBean[] value)
	{
		this.currentmedications = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean authoringuser;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.VitalSignsForNursingNotesVoBean vitalsigns;
	private ims.core.vo.beans.PatientAllergyForNursingNotesVoBean[] allergies;
	private ims.vo.LookupInstanceBean smokingstatus;
	private Boolean advicegiven;
	private Float unitsofalcoholconsumedperweek;
	private Boolean referredtosomkingcessation;
	private String observationnotes;
	private ims.core.vo.beans.PatientDiagnosisForNursingNotesVoBean[] comorbidities;
	private ims.vo.LookupInstanceBean mrsaresult;
	private ims.vo.RefVoBean[] specialneeds;
	private ims.core.vo.beans.PatientMedicationForNursingNotesVoBean[] currentmedications;
}
