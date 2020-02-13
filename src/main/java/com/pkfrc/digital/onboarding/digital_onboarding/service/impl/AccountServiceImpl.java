package com.pkfrc.digital.onboarding.digital_onboarding.service.impl;

import com.pkfrc.digital.onboarding.digital_onboarding.models.Account;
import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.UserDTO;
import com.pkfrc.digital.onboarding.digital_onboarding.repository.AccountRepository;
import com.pkfrc.digital.onboarding.digital_onboarding.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.AccountDTO;
import com.pkfrc.digital.onboarding.digital_onboarding.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.ZonedDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    static int any = 0;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {

        UserDTO userDTO = new UserDTO();
        userDTO.setLastName(accountDTO.getLastName());
        userDTO.setFirstName(accountDTO.getFirstName());
        userDTO.setEmail(accountDTO.getEmail());
        userDTO.setLogin(accountDTO.getLogin());
        userDTO.setNamePicture(accountDTO.getNamePicture());

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(accountDTO.getDate().toString() + "T08:00:00+00:00[Europe/London]");

        userDTO.setDate(zonedDateTime);
        userDTO.setPicture("a," + accountDTO.getPicture());


        if(userDTO.getPicture() != null){
            BufferedImage picture1 = accountService.decodeToImage(userDTO.getPicture());
        }

        UserDTO userDTO1 = userServiceImpl.create(userDTO);

        if (userDTO1.getId() != null) {
            AccountDTO accountDTO2 = new AccountDTO();
            accountDTO2.setFirstName(userDTO1.getFirstName());
            accountDTO2.setLastName(userDTO1.getLastName());

            Account account = new Account();
            account.setUser(userServiceImpl.findById(userDTO1.getId()));

            BufferedImage picture = accountService.decodeToImage(accountDTO.getSignature());

            AccountDTO accountDTO3 = new AccountDTO(accountRepository.save(account));

            accountDTO2.setId(accountDTO3.getId());
            return accountDTO2;

        }else {
            return null;
        }
    }

    @Override
    public BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        String[] url = imageString.split(",");
        String baseUrl = url[1];
        try {
            BASE64Decoder decoder = new BASE64Decoder();

            imageByte = decoder.decodeBuffer(baseUrl);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            try {
                File outputfile = new File(any + "pxxxxxictureTest.png");
                any = any + 1;
                ImageIO.write(image, "png", outputfile);
            } catch (IOException e) {
                // handle exception
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return image;
    }
}
