package com.alloymobile.sms.mapper;

import com.alloymobile.sms.model.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.twilio.rest.api.v2010.account.Message;

@Component
public class SmsMapper {

    public ResponseEntity<ResponseDTO> smsResponse(Message message){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(message.getBody());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
