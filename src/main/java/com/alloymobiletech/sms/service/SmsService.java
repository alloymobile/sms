package com.alloymobiletech.sms.service;

import com.alloymobiletech.sms.integration.TwilloSMSService;
import com.alloymobiletech.sms.mapper.SmsMapper;
import com.alloymobiletech.sms.model.ResponseDTO;
import com.alloymobiletech.sms.model.SmsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private final TwilloSMSService twilloSMSService;
    private final SmsMapper smsMapper;

    public SmsService(TwilloSMSService twilloSMSService, SmsMapper smsMapper) {
        this.twilloSMSService = twilloSMSService;
        this.smsMapper = smsMapper;
    }

    public ResponseEntity<ResponseDTO> sendSms(SmsDTO smsDTO){
        return this.smsMapper.smsResponse(twilloSMSService.sendSMS(smsDTO.getNumber(), smsDTO.getMessage()));
    }
}
