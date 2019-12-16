package com.sy.rabbitmq.producer.rabbitmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 19:26
 * @version:
 */
@Slf4j
@Component
public class RabbitConfirmCallBack implements RabbitTemplate.ConfirmCallback {


    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean b, @Nullable String s) {
        System.out.println("发送的消息为ID为"+correlationData.getId());
        if(b){
            log.info("消息推送到交换器成功");
        }else{
            log.info("消息推送到交换器失败");
            // 失败原因
            System.out.println("失败的原因：" + s);
        }
    }
}
