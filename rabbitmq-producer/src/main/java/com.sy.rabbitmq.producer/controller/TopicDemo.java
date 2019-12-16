package com.sy.rabbitmq.producer.controller;

import com.sy.rabbitmq.common.config.entity.MQMessage;
import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 18:03
 * @version:
 */
@RestController
@RequestMapping("/topic")
public class TopicDemo {

    public static String  s="0123456789";

    @Resource
    RabbitSendService rabbitSendService;


    @GetMapping("/test1")
    public void test1(String message){
        rabbitSendService.sendDemo1Message(message);
    }


    @PostMapping("/test2")
    public void test2(@RequestBody MQMessage message){
        System.out.println(message);
        rabbitSendService.sendDemo2Message(message);
        System.out.println("发送成功");
    }




}
