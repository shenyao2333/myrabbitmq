package com.sy.rabbitmq.producer.controller;

import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import com.sy.rabbitmq.common.config.rabbitmq.MQMessage;
import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test1")
    public String test1(String message){
        rabbitSendService.sendFanoutMessage(message);
        return "发送成功";
    }

    @GetMapping("/test2")
    public String sdf(){
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessage("123123");
        rabbitTemplate.convertAndSend(Constants.SY_DELAY, Constants.DELAY_QUEUE, mqMessage, tt -> {
            tt.getMessageProperties().setHeader("x-delay", 12000);
            return tt;
        });
        return "发送成功";
    }

}
