package com.sy.rabbitmq.producer.controller;

import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 18:03
 * @version:
 */
@RestController
@RequestMapping("demo1")
public class Demo1 {

    @Resource
    RabbitSendService rabbitSendService;

    @GetMapping("/test1")
    public void test1(String message){
        rabbitSendService.sendAllMessage(message);
        System.out.println("发送成功");
    }

    @GetMapping("/test2")
    public void test2(String message){
        rabbitSendService.sendDemo1Message(message);
        System.out.println("发送成功");
    }


    @GetMapping("/test3")
    public void test3(String message){
        rabbitSendService.sendDemo2Message(message);
        System.out.println("发送成功");
    }





}
