package com.sy.rabbitmq.producer.service;

import com.sy.rabbitmq.common.config.entity.MQMessage;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 17:40
 * @version:
 */
public interface RabbitSendService {

    void sendAllMessage(String message);

    void sendDemo1Message(String message);

    void sendDemo2Message(MQMessage message);

    void sendFanoutMessage(String message);

}
