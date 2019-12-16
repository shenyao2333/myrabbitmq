package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import com.sy.rabbitmq.common.config.rabbitmq.MQMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 20:33
 * @version:
 */

@Slf4j
@Component
public class Topic1Demo {

    private static int i= 0;

    @RabbitListener(queues = Constants.TOPIC_DEMO1_QUEUE)
    public void test1(@Payload MQMessage message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("开始消费topic.demo1的消息：" + message.getMessage());
        if (i<5){
            i++;
            log.info("消息进入重发机制，i："+i);
            channel.basicNack((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false,true);
        }else {
            log.info("消息进入正常消息，I"+i);
            channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false);
        }
    }

}
