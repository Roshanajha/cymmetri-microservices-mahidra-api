package com.cymmetri.ms.user.service;

import com.cymmetri.common.mfa.dto.AdminRemoveRegisteredMfaRequest;
import com.cymmetri.ms.user.dto.AdminRemoveRegisteredMfaRequestDto;

public interface MfaService {

	Boolean mfaConfig(AdminRemoveRegisteredMfaRequestDto mfaRequest);
}
