package com.pkfrc.digital.onboarding.digital_onboarding.repository;

import com.pkfrc.digital.onboarding.digital_onboarding.models.EntrepriseAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntrepriseAuthorityRepository  extends JpaRepository<EntrepriseAuthority, Long> {

    @Query("SELECT sa " +
            "from EntrepriseAuthority as sa " +
            "where sa.user.login = :username")
    List<EntrepriseAuthority> getEntrepriseAuthoritiesByUserName(@Param("username") String username);
}
