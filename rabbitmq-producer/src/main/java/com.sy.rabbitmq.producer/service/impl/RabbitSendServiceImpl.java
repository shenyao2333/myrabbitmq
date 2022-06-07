package com.sy.rabbitmq.producer.service.impl;

import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import com.sy.rabbitmq.common.config.rabbitmq.MQMessage;
import com.sy.rabbitmq.common.config.utils.IdUtils;
import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private RabbitTemplate rabbitTemplate;


    @Override
    public void sendDemo1Message(String message) {
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessage(message);
        send(Constants.SY_TOPIC,Constants.TOPIC_DEMO1_QUEUE,mqMessage);
    }

    @Override
    public void sendDemo2Message(MQMessage message) {
        send(Constants.SY_TOPIC,Constants.TOPIC_DEMO2_QUEUE,message);
    }


    @Override
    public void sendFanoutMessage(String message) {
        MQMessage mqMessage = new MQMessage();
        mqMessage.setMessage(message);
        send(Constants.SY_FANOUT,"",mqMessage);
    }


    public void send(String exchange,String routingKey,MQMessage message){
        //设置消息id，也可以用rabbit自带的，但这里我使用自己定义的消息id
        long id= new IdUtils().nextId();
        message.setMessageId(id);
        CorrelationData correlationData = new CorrelationData(id+"");

        rabbitTemplate.convertAndSend(exchange,routingKey,message,correlationData);


    }







}
