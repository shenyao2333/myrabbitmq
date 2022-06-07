package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import com.sy.rabbitmq.common.config.rabbitmq.MQMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: sy
 * @Date: Created by 2022.6.7-18:57
 * @description: 延时消息测试
 */
@Component
public class DelayedMessage {


    @RabbitListener(queues = Constants.DELAY_QUEUE)
    public void test1(@Payload MQMessage message, @Headers Map<String, Object> headers, Channel channel) throws IOException {

        System.out.println("延时消息进来"+ message);
        channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false);
    }


}
