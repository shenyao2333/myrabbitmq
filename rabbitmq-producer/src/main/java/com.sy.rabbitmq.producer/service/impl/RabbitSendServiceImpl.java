package com.sy.rabbitmq.producer.service.impl;

import com.sy.rabbitmq.common.config.Constants;
import com.sy.rabbitmq.common.config.utils.RandomNumber;
import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 17:41
 * @version:
 */
@Service
public class RabbitSendServiceImpl implements RabbitSendService {

    @Resource
    private RabbitMessagingTemplate rabbitTemplate;

    @Override
    public void sendAllMessage(String message) {
        rabbitTemplate.convertAndSend(Constants.SY_TOPIC,Constants.TOPIC_ALL,message);
    }

    @Override
    public void sendDemo1Message(String message) {
        rabbitTemplate.convertAndSend(Constants.SY_TOPIC,Constants.TOPIC_DEMO1_QUEUE,message);
    }

    @Override
    public void sendDemo2Message(String message) {
        rabbitTemplate.convertAndSend(Constants.SY_TOPIC,Constants.TOPIC_DEMO2_QUEUE,message);
    }

    @Override
    public void sendFanoutMessage(String message) {
        CorrelationData correlationData = new CorrelationData(RandomNumber.getRandom(4));
        rabbitTemplate.convertAndSend(Constants.SY_FANOUT,"",message);
    }





}
