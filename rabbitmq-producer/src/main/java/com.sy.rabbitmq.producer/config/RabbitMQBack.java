package com.sy.rabbitmq.producer.config;

import com.sy.rabbitmq.producer.rabbitmq.RabbitConfirmCallBack;
import com.sy.rabbitmq.producer.rabbitmq.RabbitReturnCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 23:09
 * @version:
 */
@Component
@Slf4j
public class RabbitMQBack {

    @Autowired
    private ConnectionFactory connectionFactory;

    /**
     * 定义rabbit template用于数据的接收和发送
     * 可以设置消息确认机制和回调
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        // template.setMessageConverter(); 可以自定义消息转换器  默认使用的JDK的，所以消息对象需要实现Serializable
        // template.setMessageConverter(new Jackson2JsonMessageConverter());
        template.setConfirmCallback(msgSendConfirmCallBack());

        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
        template.setReturnCallback(msgSendReturnCallback());
        template.setMandatory(true);
        return template;
    }

    /**
     * 关于 msgSendConfirmCallBack 和 msgSendReturnCallback 的回调说明：
     * 1.如果消息没有到exchange,则confirm回调,ack=false
     * 2.如果消息到达exchange,则confirm回调,ack=true
     * 3.exchange到queue成功,则不回调return
     * 4.exchange到queue失败,则回调return(需设置mandatory=true,否则不回调,消息就丢了)
     */

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * @return
     */
    @Bean
    public RabbitConfirmCallBack msgSendConfirmCallBack(){
        return new RabbitConfirmCallBack();
    }

    @Bean
    public RabbitReturnCallback msgSendReturnCallback(){
        return new RabbitReturnCallback();
    }
}
