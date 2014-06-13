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

package ims.ocs_if.vo.beans;

public class DemographicsMessageQueueVoBean extends ims.vo.ValueObjectBean
{
	public DemographicsMessageQueueVoBean()
	{
	}
	public DemographicsMessageQueueVoBean(ims.ocs_if.vo.DemographicsMessageQueueVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.providersystem = vo.getProviderSystem() == null ? null : new ims.vo.RefVoBean(vo.getProviderSystem().getBoId(), vo.getProviderSystem().getBoVersion());
		this.wasprocessed = vo.getWasProcessed();
		this.wasdiscarded = vo.getWasDiscarded();
		this.msgtext = vo.getMsgText();
		this.acktext = vo.getAckText();
		this.failuremsg = vo.getFailureMsg();
		this.messagestatus = vo.getMessageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageStatus().getBean();
		this.msgtype = vo.getMsgType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMsgType().getBean();
		this.queuetype = vo.getQueueType() == null ? null : (ims.vo.LookupInstanceBean)vo.getQueueType().getBean();
		this.priorpatient = vo.getPriorPatient() == null ? null : new ims.vo.RefVoBean(vo.getPriorPatient().getBoId(), vo.getPriorPatient().getBoVersion());
		this.mergehistory = vo.getMergeHistory() == null ? null : new ims.vo.RefVoBean(vo.getMergeHistory().getBoId(), vo.getMergeHistory().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.DemographicsMessageQueueVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.providersystem = vo.getProviderSystem() == null ? null : new ims.vo.RefVoBean(vo.getProviderSystem().getBoId(), vo.getProviderSystem().getBoVersion());
		this.wasprocessed = vo.getWasProcessed();
		this.wasdiscarded = vo.getWasDiscarded();
		this.msgtext = vo.getMsgText();
		this.acktext = vo.getAckText();
		this.failuremsg = vo.getFailureMsg();
		this.messagestatus = vo.getMessageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageStatus().getBean();
		this.msgtype = vo.getMsgType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMsgType().getBean();
		this.queuetype = vo.getQueueType() == null ? null : (ims.vo.LookupInstanceBean)vo.getQueueType().getBean();
		this.priorpatient = vo.getPriorPatient() == null ? null : new ims.vo.RefVoBean(vo.getPriorPatient().getBoId(), vo.getPriorPatient().getBoVersion());
		this.mergehistory = vo.getMergeHistory() == null ? null : new ims.vo.RefVoBean(vo.getMergeHistory().getBoId(), vo.getMergeHistory().getBoVersion());
	}

	public ims.ocs_if.vo.DemographicsMessageQueueVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.DemographicsMessageQueueVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.DemographicsMessageQueueVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.DemographicsMessageQueueVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.DemographicsMessageQueueVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.vo.RefVoBean value)
	{
		this.providersystem = value;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.wasprocessed = value;
	}
	public Boolean getWasDiscarded()
	{
		return this.wasdiscarded;
	}
	public void setWasDiscarded(Boolean value)
	{
		this.wasdiscarded = value;
	}
	public String getMsgText()
	{
		return this.msgtext;
	}
	public void setMsgText(String value)
	{
		this.msgtext = value;
	}
	public String getAckText()
	{
		return this.acktext;
	}
	public void setAckText(String value)
	{
		this.acktext = value;
	}
	public String getFailureMsg()
	{
		return this.failuremsg;
	}
	public void setFailureMsg(String value)
	{
		this.failuremsg = value;
	}
	public ims.vo.LookupInstanceBean getMessageStatus()
	{
		return this.messagestatus;
	}
	public void setMessageStatus(ims.vo.LookupInstanceBean value)
	{
		this.messagestatus = value;
	}
	public ims.vo.LookupInstanceBean getMsgType()
	{
		return this.msgtype;
	}
	public void setMsgType(ims.vo.LookupInstanceBean value)
	{
		this.msgtype = value;
	}
	public ims.vo.LookupInstanceBean getQueueType()
	{
		return this.queuetype;
	}
	public void setQueueType(ims.vo.LookupInstanceBean value)
	{
		this.queuetype = value;
	}
	public ims.vo.RefVoBean getPriorPatient()
	{
		return this.priorpatient;
	}
	public void setPriorPatient(ims.vo.RefVoBean value)
	{
		this.priorpatient = value;
	}
	public ims.vo.RefVoBean getMergeHistory()
	{
		return this.mergehistory;
	}
	public void setMergeHistory(ims.vo.RefVoBean value)
	{
		this.mergehistory = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean providersystem;
	private Boolean wasprocessed;
	private Boolean wasdiscarded;
	private String msgtext;
	private String acktext;
	private String failuremsg;
	private ims.vo.LookupInstanceBean messagestatus;
	private ims.vo.LookupInstanceBean msgtype;
	private ims.vo.LookupInstanceBean queuetype;
	private ims.vo.RefVoBean priorpatient;
	private ims.vo.RefVoBean mergehistory;
}
