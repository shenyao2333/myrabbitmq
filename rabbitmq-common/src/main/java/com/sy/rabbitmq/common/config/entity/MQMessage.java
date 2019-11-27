package com.sy.rabbitmq.common.config.entity;

import lombok.Data;

/**
 * @author sy
 * Date: 2019/11/25 11:35
 * @Description MQ消息实体
 */
@Data
public class MQMessage {
    private String messageId;
    private String message;

}
