package com.sy.rabbitmq.producer.controller;

import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 18:03
 * @version:
 */
@RestController
@RequestMapping("topic")
public class TopicDemo {

    public static String  s="0123456789";

    @Resource
    RabbitSendService rabbitSendService;


    @GetMapping("/test1")
    public void test1(String message){
        rabbitSendService.sendDemo1Message(message);
        System.out.println("发送成功");
    }


    @GetMapping("/test2")
    public void test2(String message){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<8;i++){
            Random random = new Random();
            int number = random.nextInt(s.length());
            sb.append(s.charAt(number));
        }
        CorrelationData correlationData = new CorrelationData(sb.toString());
        rabbitSendService.sendDemo2Message(message);
        System.out.println("发送成功");
    }









}
