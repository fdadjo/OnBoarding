package com.pkfrc.digital.onboarding.digital_onboarding.rest;

import com.codahale.metrics.annotation.Timed;
import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.AccountDTO;
import com.pkfrc.digital.onboarding.digital_onboarding.rest.util.HeaderUtil;
import com.pkfrc.digital.onboarding.digital_onboarding.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import java.util.Base64;

@RestController
@RequestMapping("/api/v1/account")
@Api(value="Digital OnBoarding System", description="Operations pertaining to Account in Digital OnBoarding System")
public class AccountResource {



    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private AccountService accountService;
    /**
     *
     * @param AccountDTO
     * @return
     */
    @ApiOperation(value = "Create a Account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Account"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden")
    })
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO accountDTO) throws UnsupportedEncodingException {
        log.debug("REST request to save account : {}", accountDTO);

        if (accountDTO.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .headers(HeaderUtil.createFailureAlert("account", "invalid object", "A new account can not be already have an ID"))
                    .body(accountDTO);
        }



        AccountDTO result = accountService.create(accountDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
        return ResponseEntity.created(location)
                .headers(HeaderUtil.createEntityCreationAlert("account", result.toString()))
                .body(result);
    }



}
