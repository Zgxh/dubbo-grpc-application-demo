package com.zgxh.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yu Yang
 */
@RestController
@Slf4j
public class TestController {

    @DubboReference
    private DemoService demoService;

    @GetMapping("/test")
    public String sayHello() {
        HelloRequest request = HelloRequest.newBuilder().setName("zgxh").build();
        log.info("request: {}", request);
        HelloReply helloReply = demoService.sayHello(request);
        log.info("reply: {}", helloReply);
        return helloReply.getMessage();
    }
}
