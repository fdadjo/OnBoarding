package com.pkfrc.digital.onboarding.digital_onboarding.service.impl;

import com.pkfrc.digital.onboarding.digital_onboarding.models.User;
import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.UserDTO;
import com.pkfrc.digital.onboarding.digital_onboarding.repository.UserRepository;
import com.pkfrc.digital.onboarding.digital_onboarding.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO create(UserDTO userDTO) {

        User user = new User();
        user.setLogin(userDTO.getFirstName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        return new UserDTO(userRepository.save(user));
    }
}
