package com.sy.tabbitmq.consumer.rabbitmq;

import com.sy.rabbitmq.common.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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

    @RabbitListener(queues = Constants.TOPIC_DEMO1_QUEUE)
    public void test1(String message){
        System.out.println("开始消费topic.demo1的消息：" + message);
    }



   /* @RabbitListener(queues = Constants.TOPIC_DEMO2_QUEUE)
    public void test3(String message){
        System.out.println("开始消费topic.demo2的消息：" + message);
    }
*/



}
