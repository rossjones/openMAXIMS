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

package ims.emergency.vo.beans;

public class FlashingKPITextCoulourVoBean extends ims.vo.ValueObjectBean
{
	public FlashingKPITextCoulourVoBean()
	{
	}
	public FlashingKPITextCoulourVoBean(ims.emergency.vo.FlashingKPITextCoulourVo vo)
	{
		this.breachwarningflashingtest = vo.getBreachWarningFlashingTest() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachWarningFlashingTest().getBean();
		this.breachedkpiflashingtext = vo.getBreachedKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachedKPIFlashingText().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.FlashingKPITextCoulourVo vo)
	{
		this.breachwarningflashingtest = vo.getBreachWarningFlashingTest() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachWarningFlashingTest().getBean();
		this.breachedkpiflashingtext = vo.getBreachedKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachedKPIFlashingText().getBean();
	}

	public ims.emergency.vo.FlashingKPITextCoulourVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.FlashingKPITextCoulourVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.FlashingKPITextCoulourVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.FlashingKPITextCoulourVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.FlashingKPITextCoulourVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getBreachWarningFlashingTest()
	{
		return this.breachwarningflashingtest;
	}
	public void setBreachWarningFlashingTest(ims.vo.LookupInstanceBean value)
	{
		this.breachwarningflashingtest = value;
	}
	public ims.vo.LookupInstanceBean getBreachedKPIFlashingText()
	{
		return this.breachedkpiflashingtext;
	}
	public void setBreachedKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.breachedkpiflashingtext = value;
	}

	private ims.vo.LookupInstanceBean breachwarningflashingtest;
	private ims.vo.LookupInstanceBean breachedkpiflashingtext;
}
