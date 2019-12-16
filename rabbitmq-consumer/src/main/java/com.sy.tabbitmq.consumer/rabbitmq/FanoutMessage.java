package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.IOException;


/**
 * @author sy
 * Date: 2019/10/25 10:25
 * @Description Fanout消息测试
 */
@Component
@Slf4j
public class FanoutMessage {

    static int i=1;


    @RabbitListener(queues = Constants.FANOUT_DEMO1_QUEUE)
    public void test1(Message message, Channel channel) throws IOException {
        System.out.println("消息1进来");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


    @RabbitListener(queues = Constants.FANOUT_DEMO2_QUEUE)
    public void test2(Message message, Channel channel) throws IOException {
        System.out.println("进来i"+i);
        System.out.println(message.getMessageProperties().toString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


}
