package com.leesin.sentinelweb;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.leesin.SentinelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentinelController {

    @Reference
    SentinelService sentinelService;//proxy$0

    @GetMapping("/say")
    public String sayHello(){
        RpcContext.getContext().setAttachment("dubboApplication", "sentinel-web");
        return sentinelService.sayHello("test");
    }
}
