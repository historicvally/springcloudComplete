package com.sericefeign.serviceRemote;

import org.springframework.stereotype.Component;

@Component
public class SpeakServiceHystric implements SpeakService {
    @Override
    public String speakFromClient(String name) {
        return "sorry Hystric "+name;
    }
}