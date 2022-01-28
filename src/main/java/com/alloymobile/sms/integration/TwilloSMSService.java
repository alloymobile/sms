package com.alloymobile.sms.integration;

import com.alloymobile.sms.config.SmsProperties;
import com.alloymobile.sms.exception.InternalServerException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;


@Component
public class TwilloSMSService {

    private final SmsProperties properties;

    public TwilloSMSService(SmsProperties properties) {
        this.properties = properties;
    }

    public Message sendSMS(String number, String msg) throws InternalServerException {
        Twilio.init(properties.getTwilloAccountId(), properties.getTwilloAuthToken());
        try{
            return  Message.creator(
                    new PhoneNumber(number),
                    new PhoneNumber(properties.getTwilloNumber()),msg)
                    .create();
        }catch(InternalServerException e){
            throw new InternalServerException("Phone number [" + number + "] is not a valid number");
        }
    }
}
