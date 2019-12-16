package com.sy.rabbitmq.producer.service.impl;

import com.sy.rabbitmq.common.config.Constants;
import com.sy.rabbitmq.common.config.entity.MQMessage;
import com.sy.rabbitmq.common.config.utils.RandomNumber;
import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


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
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendAllMessage(String message) {
        String random = RandomNumber.getRandom(4);
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessageId(random);
        mqMessage.setMessage(message);
        CorrelationData correlationData = new CorrelationData(random);
        rabbitTemplate.convertAndSend(Constants.SY_TOPIC,Constants.TOPIC_DEMO1_QUEUE,mqMessage,correlationData);
    }

    @Override
    public void sendDemo1Message(String message) {
        String random = RandomNumber.getRandom(4);
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessageId(random);
        mqMessage.setMessage(message);
        CorrelationData correlationData = new CorrelationData(random);
        rabbitTemplate.convertAndSend(Constants.SY_TOPIC,Constants.TOPIC_DEMO1_QUEUE,mqMessage,correlationData);
    }

    @Override
    public void sendDemo2Message(MQMessage message) {
        String random = RandomNumber.getRandom(4);
        message.setMessageId(random);
        CorrelationData correlationData = new CorrelationData(random);
        rabbitTemplate.convertAndSend(Constants.SY_TOPIC,Constants.TOPIC_DEMO2_QUEUE,message, correlationData);
    }

    @Override
    public void sendFanoutMessage(String message) {
        String random = RandomNumber.getRandom(4);
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessageId(random);
        mqMessage.setMessage(message);
        CorrelationData correlationData = new CorrelationData(random);
        rabbitTemplate.convertAndSend(Constants.SY_FANOUT,"",mqMessage,correlationData);
    }



    public void send(){
        String random = RandomNumber.getRandom(4);
        MQMessage mqMessage = new MQMessage();


    }





}
