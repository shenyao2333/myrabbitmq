package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import com.sy.rabbitmq.common.config.rabbitmq.MQMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Map;


/**
 * @author sy
 * Date: 2019/10/25 10:25
 * @Description Fanout消息测试
 */
@Component
@Slf4j
public class FanoutMessage {


    @RabbitListener(queues = Constants.FANOUT_DEMO1_QUEUE)
    public void test1(@Payload MQMessage message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("消息1进来");
        channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false);
    }


    @RabbitListener(queues = Constants.FANOUT_DEMO2_QUEUE)
    public void test2(@Payload MQMessage message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println(message);
        channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false);
    }


}
