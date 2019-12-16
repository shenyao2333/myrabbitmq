package com.sy.rabbitmq.producer.config;

import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author sy
 * Date: 2019/10/25 9:30
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
     * 但是我这里没
     * @return
     */
    @Bean
    Binding bindingQue1() {
        return BindingBuilder.bind(queue5()).to(topExchange())
                .with(Constants.TOPIC_DEMO1);
    }



    /**
     * topic与direct最大的区别是topic能够用符号进行匹配，
     * 我将TOPIC_DEMO2_QUEUE的列队使用Binding：TOPIC_ALL（topic.*）进行绑定。
     * @return
     */
    @Bean
    Binding bindingQue3() {
        return BindingBuilder.bind(queue6()).to(topExchange())
                .with(Constants.TOPIC_ALL);
    }

}
