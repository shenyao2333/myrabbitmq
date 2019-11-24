package com.sy.rabbitmq.producer.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 19:49
 * @version:
 */
@Slf4j
@Component
public class RabbitReturnCallback implements RabbitTemplate.ReturnCallback  {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息主体: {}", message);
        log.info("回复编码: {}", replyCode);
        log.info("回复内容: {}", replyText);
        log.info("交换器: {}", exchange);
        log.info("路由键: {}", routingKey);

    }
}
