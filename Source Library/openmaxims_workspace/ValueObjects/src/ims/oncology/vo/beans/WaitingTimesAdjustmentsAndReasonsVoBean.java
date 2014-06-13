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

package ims.oncology.vo.beans;

public class WaitingTimesAdjustmentsAndReasonsVoBean extends ims.vo.ValueObjectBean
{
	public WaitingTimesAdjustmentsAndReasonsVoBean()
	{
	}
	public WaitingTimesAdjustmentsAndReasonsVoBean(ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.adjreferralfirstseen = vo.getAdjReferralFirstSeen();
		this.reasreferralfirstseen = vo.getReasReferralFirstSeen() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasReferralFirstSeen().getBean();
		this.adjfirstseendectreat = vo.getAdjFirstSeenDecTreat();
		this.reasfirstseendectreat = vo.getReasFirstSeenDecTreat() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasFirstSeenDecTreat().getBean();
		this.adjdectreattreatment = vo.getAdjDecTreatTreatment();
		this.reasdectreattreatment = vo.getReasDecTreatTreatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasDecTreatTreatment().getBean();
		this.delayreasreferraltreat = vo.getDelayReasReferralTreat() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReasReferralTreat().getBean();
		this.notesreferraltreat = vo.getNotesReferralTreat();
		this.delayreasdectreattreat = vo.getDelayReasDecTreatTreat() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReasDecTreatTreat().getBean();
		this.notesdectreattreat = vo.getNotesDecTreatTreat();
		this.episodeofcare = vo.getEpisodeofCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeofCare().getBoId(), vo.getEpisodeofCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.adjreferralfirstseen = vo.getAdjReferralFirstSeen();
		this.reasreferralfirstseen = vo.getReasReferralFirstSeen() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasReferralFirstSeen().getBean();
		this.adjfirstseendectreat = vo.getAdjFirstSeenDecTreat();
		this.reasfirstseendectreat = vo.getReasFirstSeenDecTreat() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasFirstSeenDecTreat().getBean();
		this.adjdectreattreatment = vo.getAdjDecTreatTreatment();
		this.reasdectreattreatment = vo.getReasDecTreatTreatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasDecTreatTreatment().getBean();
		this.delayreasreferraltreat = vo.getDelayReasReferralTreat() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReasReferralTreat().getBean();
		this.notesreferraltreat = vo.getNotesReferralTreat();
		this.delayreasdectreattreat = vo.getDelayReasDecTreatTreat() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReasDecTreatTreat().getBean();
		this.notesdectreattreat = vo.getNotesDecTreatTreat();
		this.episodeofcare = vo.getEpisodeofCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeofCare().getBoId(), vo.getEpisodeofCare().getBoVersion());
	}

	public ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public Integer getAdjReferralFirstSeen()
	{
		return this.adjreferralfirstseen;
	}
	public void setAdjReferralFirstSeen(Integer value)
	{
		this.adjreferralfirstseen = value;
	}
	public ims.vo.LookupInstanceBean getReasReferralFirstSeen()
	{
		return this.reasreferralfirstseen;
	}
	public void setReasReferralFirstSeen(ims.vo.LookupInstanceBean value)
	{
		this.reasreferralfirstseen = value;
	}
	public Integer getAdjFirstSeenDecTreat()
	{
		return this.adjfirstseendectreat;
	}
	public void setAdjFirstSeenDecTreat(Integer value)
	{
		this.adjfirstseendectreat = value;
	}
	public ims.vo.LookupInstanceBean getReasFirstSeenDecTreat()
	{
		return this.reasfirstseendectreat;
	}
	public void setReasFirstSeenDecTreat(ims.vo.LookupInstanceBean value)
	{
		this.reasfirstseendectreat = value;
	}
	public Integer getAdjDecTreatTreatment()
	{
		return this.adjdectreattreatment;
	}
	public void setAdjDecTreatTreatment(Integer value)
	{
		this.adjdectreattreatment = value;
	}
	public ims.vo.LookupInstanceBean getReasDecTreatTreatment()
	{
		return this.reasdectreattreatment;
	}
	public void setReasDecTreatTreatment(ims.vo.LookupInstanceBean value)
	{
		this.reasdectreattreatment = value;
	}
	public ims.vo.LookupInstanceBean getDelayReasReferralTreat()
	{
		return this.delayreasreferraltreat;
	}
	public void setDelayReasReferralTreat(ims.vo.LookupInstanceBean value)
	{
		this.delayreasreferraltreat = value;
	}
	public String getNotesReferralTreat()
	{
		return this.notesreferraltreat;
	}
	public void setNotesReferralTreat(String value)
	{
		this.notesreferraltreat = value;
	}
	public ims.vo.LookupInstanceBean getDelayReasDecTreatTreat()
	{
		return this.delayreasdectreattreat;
	}
	public void setDelayReasDecTreatTreat(ims.vo.LookupInstanceBean value)
	{
		this.delayreasdectreattreat = value;
	}
	public String getNotesDecTreatTreat()
	{
		return this.notesdectreattreat;
	}
	public void setNotesDecTreatTreat(String value)
	{
		this.notesdectreattreat = value;
	}
	public ims.vo.RefVoBean getEpisodeofCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeofCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private Integer adjreferralfirstseen;
	private ims.vo.LookupInstanceBean reasreferralfirstseen;
	private Integer adjfirstseendectreat;
	private ims.vo.LookupInstanceBean reasfirstseendectreat;
	private Integer adjdectreattreatment;
	private ims.vo.LookupInstanceBean reasdectreattreatment;
	private ims.vo.LookupInstanceBean delayreasreferraltreat;
	private String notesreferraltreat;
	private ims.vo.LookupInstanceBean delayreasdectreattreat;
	private String notesdectreattreat;
	private ims.vo.RefVoBean episodeofcare;
}
