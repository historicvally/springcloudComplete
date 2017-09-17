package com.sericefeign.serviceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "eurekaclient1",fallback = SpeakServiceHystric.class)
public interface SpeakService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String speakFromClient(@RequestParam(value = "name") String name);
}
