package com.pkfrc.digital.onboarding.digital_onboarding.repository;

import com.pkfrc.digital.onboarding.digital_onboarding.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);

    //Optional<User> findOneByEmail(String email);

    /*Optional<User> findOneByActivationKey(String key);

    Optional<User> findOneByResetKey(String key);*/

    Optional<User> findOneById(Long id);

    User findByLogin(String login);
}
