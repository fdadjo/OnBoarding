package com.pkfrc.digital.onboarding.digital_onboarding.rest;

import com.pkfrc.digital.onboarding.digital_onboarding.models.dto.UserDTO;
import com.pkfrc.digital.onboarding.digital_onboarding.rest.util.HeaderUtil;
import com.pkfrc.digital.onboarding.digital_onboarding.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codahale.metrics.annotation.Timed;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
@Api(value="Digital OnBoarding System", description="Operations pertaining to User in Digital OnBoarding System")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;
    /**
     *
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "Create a User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Employe"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden")
    })
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        log.debug("REST request to save user : {}", userDTO);

        if (userDTO.getId() != null) {
            return ResponseEntity.unprocessableEntity()
                    .headers(HeaderUtil.createFailureAlert("user", "invalid object", "A new user can not be already have an ID"))
                    .body(userDTO);
        }

        UserDTO result = userService.create(userDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
        return ResponseEntity.created(location)
                .headers(HeaderUtil.createEntityCreationAlert("absence", result.toString()))
                .body(result);
    }


}

