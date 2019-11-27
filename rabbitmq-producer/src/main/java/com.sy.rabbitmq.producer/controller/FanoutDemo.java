package com.sy.rabbitmq.producer.controller;

import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sy
 * Date: 2019/11/25 10:18
 * @Description Fanout交换器模式demo
 */
@RestController
@RequestMapping("/fanout")
public class FanoutDemo {

    @Resource
    private RabbitSendService rabbitSendService;


    @GetMapping("/test1")
    public String test1(String message){
        rabbitSendService.sendFanoutMessage(message);
        return "发送成功";
    }

}
