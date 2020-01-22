package com.pkfrc.digital.onboarding.digital_onboarding.service;

import com.pkfrc.digital.onboarding.digital_onboarding.models.User;
import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.UserDTO;

public interface UserService {

    UserDTO create(UserDTO userDTO);
}
