package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.Constants;
import com.sy.rabbitmq.common.config.entity.MQMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author sy
 * Date: 2019/10/25 11:29
 * @Description
 */
@Component
public class Topic2Demo {


    @RabbitListener(queues = Constants.TOPIC_DEMO2_QUEUE)
    public void processMessage(@Payload MQMessage msg, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("开始消费topic.demo2的消息：" + msg);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag,false);
    }


}
