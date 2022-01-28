package com.alloymobile.sms.service;

import com.alloymobile.sms.integration.TwilloSMSService;
import com.alloymobile.sms.mapper.SmsMapper;
import com.alloymobile.sms.model.ResponseDTO;
import com.alloymobile.sms.model.SmsDTO;
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
