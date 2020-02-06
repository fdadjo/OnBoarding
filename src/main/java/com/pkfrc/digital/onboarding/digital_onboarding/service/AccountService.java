package com.pkfrc.digital.onboarding.digital_onboarding.service;

import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.AccountDTO;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

public interface AccountService {

    AccountDTO create(AccountDTO accountDTO);

   BufferedImage decodeToImage(String imageString);


}
