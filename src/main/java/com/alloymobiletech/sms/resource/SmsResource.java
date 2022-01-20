package com.alloymobiletech.sms.resource;

import com.alloymobiletech.sms.model.ResponseDTO;
import com.alloymobiletech.sms.model.SmsDTO;
import com.alloymobiletech.sms.service.SmsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Send SMS APIs", description = "The API is used to send sms to any number")
public class SmsResource {

    SmsService smsService;

    public SmsResource(SmsService smsService) {
        this.smsService = smsService;
    }

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping(value = "/api/v1/sms",consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseDTO> sendSms(@RequestBody SmsDTO smsDTO){
        return smsService.sendSms(smsDTO);
    }
}
