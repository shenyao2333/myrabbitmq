package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author sy
 * Date: 2019/11/25 10:25
 * @Description Fanout消息测试
 */
@Component
@Slf4j
public class FanoutMessage {


    @RabbitListener(queues = Constants.FANOUT_DEMO1_QUEUE)
    public void test1(String message){
        System.out.println("消息通道"+Constants.FANOUT_DEMO1_QUEUE+": 收到消息"+message);
    }



    @RabbitListener(queues = Constants.FANOUT_DEMO2_QUEUE)
    public void test2(Message message, Channel channel){
        System.out.println("消息通道"+Constants.FANOUT_DEMO2_QUEUE+": 收到消息"+message.toString());
        System.out.println(message.getPayload().toString());
    }


}
