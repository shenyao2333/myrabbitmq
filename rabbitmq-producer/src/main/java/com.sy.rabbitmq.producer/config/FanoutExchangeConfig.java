package com.sy.rabbitmq.producer.config;

import com.sy.rabbitmq.common.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sy
 * Date: 2019/11/25 10:05
 * @Description fanout广播模式的交换器配置
 */
@Configuration
@Slf4j
public class FanoutExchangeConfig {




    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(Constants.SY_FANOUT);
    }


    @Bean
    Queue queue3(){
      return   new Queue(Constants.FANOUT_DEMO1_QUEUE,true);
    }

    @Bean
    Queue queue4(){
        return new Queue(Constants.FANOUT_DEMO2_QUEUE,true);
    }

    @Bean
    Binding fanoutQueue1(){
        return  BindingBuilder.bind(queue3()).to(fanoutExchange());
    }

    @Bean
    Binding fanoutQueue2(){
        return  BindingBuilder.bind(queue4()).to(fanoutExchange());
    }

}
