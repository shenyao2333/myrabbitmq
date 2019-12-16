package com.sy.rabbitmq.producer.service;

import com.sy.rabbitmq.common.config.rabbitmq.MQMessage;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 17:40
 * @version:
 */
public interface RabbitSendService {


    void sendDemo1Message(String message);

    /**
     * toptic模式的列队2
     * @param message
     */
    void sendDemo2Message(MQMessage message);

    /**
     * fanout广播模式的消息发送
     * @param message
     */
    void sendFanoutMessage(String message);

}
