package com.cymmetri.ms.user.service;

import com.cymmetri.common.changepassword.dto.ChangePassword;
import com.cymmetri.ms.user.exception.ChangePasswordException;
import com.cymmetri.ms.user.exception.PasswordValidationException;

public interface ChangePasswordService {

	Boolean changePassword(ChangePassword changePassword) throws PasswordValidationException, ChangePasswordException;
}
