package com.pkfrc.digital.onboarding.digital_onboarding.repository;

import com.pkfrc.digital.onboarding.digital_onboarding.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
