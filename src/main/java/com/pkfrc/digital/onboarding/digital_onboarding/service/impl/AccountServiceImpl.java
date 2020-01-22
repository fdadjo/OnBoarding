package com.pkfrc.digital.onboarding.digital_onboarding.service.impl;

import com.pkfrc.digital.onboarding.digital_onboarding.models.Account;
import com.pkfrc.digital.onboarding.digital_onboarding.repository.AccountRepository;
import com.pkfrc.digital.onboarding.digital_onboarding.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.AccountDTO;
import com.pkfrc.digital.onboarding.digital_onboarding.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {

        Account account = new Account();
        account.setLinkCNI(accountDTO.getLinkCNI());
        account.setLinkSignature(accountDTO.getLinkSignature());
        account.setLinkPicture(accountDTO.getLinkPicture());
        account.setLinkHomePlan(accountDTO.getLinkHomePlan());
        account.setLinkRegisterDocument(accountDTO.getLinkRegisterDocument());

        return new AccountDTO(accountRepository.save(account));
    }

}
