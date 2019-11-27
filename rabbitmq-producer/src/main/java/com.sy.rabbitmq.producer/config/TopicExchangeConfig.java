package com.sy.rabbitmq.producer.config;


import com.sy.rabbitmq.common.config.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;


/**
 * @author sy
 * Date: 2019/11/25 9:30
 * @Description topic交换器配置
 */
@Configuration
public class TopicExchangeConfig {



    /**
     * 声明一个exchange（交换机），是top形式,名为Constants.SY_TOPIC
     * @return
     */
    @Bean
    TopicExchange topExchange(){
        return new TopicExchange(Constants.SY_TOPIC);
    }

    /**
     * 声明一个列队，列队名为Constants.TOPIC_DEMO1_QUEUE,并且持久化
     * @return
     */
    @Bean
    Queue queue5() {
        return new Queue(Constants.TOPIC_DEMO1_QUEUE,true);
    }

    /**
     * 声明一个列队，列队名为Constants.TOPIC_DEMO2_QUEUE,并且持久化
     * @return
     */
    @Bean
    Queue queue6() {
        return new Queue(Constants.TOPIC_DEMO2_QUEUE, true);
    }





    /**
     * 交换机与列队绑定,SY_TOPIC与TOPIC_DEMO2_QUEUE绑定
     * @return
     */
    @Bean
    Binding bindingQue1() {
        return BindingBuilder.bind(queue5()).to(topExchange())
                .with(Constants.TOPIC_DEMO1);
    }

    /**
     * 交换机与列队绑定,SY_TOPIC与TOPIC_DEMO2_QUEUE绑定
     * @return
     */
    @Bean
    Binding bindingQue2() {
        return BindingBuilder.bind(queue6()).to(topExchange())
                .with(Constants.TOPIC_DEMO2);
    }

/*    @Bean
    Binding bindingQue3(){
        return BindingBuilder.bind(queue12()).to(topExchange())
                .with(Constants.TOPIC_ALL);
    }*/










}
