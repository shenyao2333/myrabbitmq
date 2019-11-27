package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.Constants;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author sy
 * Date: 2019/11/25 11:29
 * @Description
 */
//如何接收，注意队列名称、exchange名称、routingKey的指定。

@Component
@RabbitListener(
containerFactory = "rabbitListenerContainerFactory",
bindings = @QueueBinding(value = @Queue(value = Constants.TOPIC_DEMO2_QUEUE, durable = "true"),
exchange = @Exchange(value = Constants.SY_TOPIC,
type = ExchangeTypes.TOPIC), key = Constants.TOPIC_DEMO2))
public class TestDemo {


    @RabbitHandler
    public void processMessage( Message msg,  Channel channel) throws IOException {
        try {
            MessageProperties messageProperties = msg.getMessageProperties();
            System.out.println( "消息实体为："+ messageProperties.toString());
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), true);
        }catch (Exception e){
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), true);
            System.out.println("报错原因："+e.getMessage());
        }finally {
            MessageProperties messageProperties = msg.getMessageProperties();
            System.out.println( "消息实体为："+ messageProperties.toString());
            System.out.println("");
        }

    }


}
