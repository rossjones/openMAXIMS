// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseClinicalOutcomeImpl extends DomainImpl implements ims.RefMan.domain.ClinicalOutcome, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistIntraOperativeCareRecords(ims.core.patient.vo.PatientRefVo patient, ims.RefMan.vo.CatsReferralRefVo referral)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicalOutcomes(ims.core.patient.vo.PatientRefVo patient, ims.RefMan.vo.CatsReferralRefVo referral, ims.core.clinical.vo.IntraOperativeCareRecordRefVo intraOperative)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalOutcome(ims.RefMan.vo.ClinicalOutcomeRefVo clinicalOutcome)
	{
	}
}