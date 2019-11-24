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
 * <p>
 *     创建rabbitMQ生产者配置
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 16:29
 * @version:
 */
@Configuration
public class ProducerConfig {


    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }


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
    Queue queue1() {
        return new Queue(Constants.TOPIC_DEMO1_QUEUE,false);
    }

    /**
     * 声明一个列队，列队名为Constants.TOPIC_DEMO2_QUEUE,并且持久化
     * @return
     */
    @Bean
    Queue queue2() {
        return new Queue(Constants.TOPIC_DEMO2_QUEUE, false);
    }

/*    @Bean
    Queue queue12() {
        return new Queue(Constants.TOPIC_ALL, true);
    }*/



    /**
     * 交换机与列队绑定,SY_TOPIC与TOPIC_DEMO2_QUEUE绑定
     * @return
     */
    @Bean
    Binding bindingQue1() {
        return BindingBuilder.bind(queue1()).to(topExchange())
                .with(Constants.TOPIC_DEMO1);
    }

    /**
     * 交换机与列队绑定,SY_TOPIC与TOPIC_DEMO2_QUEUE绑定
     * @return
     */
    @Bean
    Binding bindingQue2() {
        return BindingBuilder.bind(queue2()).to(topExchange())
                .with(Constants.TOPIC_DEMO2);
    }

/*    @Bean
    Binding bindingQue3(){
        return BindingBuilder.bind(queue12()).to(topExchange())
                .with(Constants.TOPIC_ALL);
    }*/


    /**
     * 声明一个Fanout（交换机），是Fanout形式,名为Constants.SY_TOPIC
     * @return
     */
    @Bean
    TopicExchange fanoutExchange( ){
        return new TopicExchange(Constants.SY_FANOUT);
    }

    /**
     * 声明一个列队，列队名为Constants.FANOUT_DEMO1_QUEUE,并且持久化
     * @return
     */
    @Bean
    Queue queue3() {
        return new Queue(Constants.FANOUT_DEMO1_QUEUE,false);
    }

    /**
     * 声明一个列队，列队名为Constants.FANOUT_DEMO2_QUEUE,并且持久化
     * @return
     */
    @Bean
    Queue queue4() {
        return new Queue(Constants.FANOUT_DEMO2_QUEUE, false);
    }



    @Bean
    Binding fanoutQue1(){
        return BindingBuilder.bind(queue3()).to(fanoutExchange()).with(Constants.FANOUT_DEMO1_QUEUE);
    }

    @Bean
    Binding fanoutQue2(){
        return BindingBuilder.bind(queue3()).to(fanoutExchange()).with(Constants.FANOUT_DEMO2_QUEUE);
    }



    /**
     * 生产者用 可以用来转化为json
     *
     * @return
     */
    @Bean
    public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
        RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
        rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
        rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
        return rabbitMessagingTemplate;
    }

    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        return new MappingJackson2MessageConverter();
    }




}
