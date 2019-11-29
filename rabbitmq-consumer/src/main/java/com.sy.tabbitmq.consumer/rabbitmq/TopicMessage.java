package com.sy.tabbitmq.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.sy.rabbitmq.common.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 20:33
 * @version:
 */

@Component
@Slf4j
public class TopicMessage {

    private static int i= 0;

    @RabbitListener(queues = Constants.TOPIC_DEMO1_QUEUE)
    public void test1(Message message, Channel channel) throws IOException {
        System.out.println("开始消费topic.demo1的消息：" + message);
        if (i<8){
            i++;
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }


    }



   /* @RabbitListener(queues = Constants.TOPIC_DEMO2_QUEUE)
    public void test3(String message){
        System.out.println("开始消费topic.demo2的消息：" + message);
    }
*/



}
