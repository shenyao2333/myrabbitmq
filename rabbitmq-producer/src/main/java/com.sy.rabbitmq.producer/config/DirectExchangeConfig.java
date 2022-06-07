package com.sy.rabbitmq.producer.config;

import com.sy.rabbitmq.common.config.rabbitmq.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @author sy
 * Date: 2019/10/25 9:30
 * @Description direct交换器配置
 */
@Slf4j
@Configuration
public class DirectExchangeConfig {


    /**
     * 声明一个direct（交换机），是Fanout形式,名为Constants.SY_DIRECT（自定义的）
     * 参数说明：
     * 1、第一个为交换器名
     * 2、是否持久化，默认true
     * 3、消费者断开时是否删除
     * 4、还可以加一个消息其他参数    实际开发需要持久化，只需要输入交换器的名称，其他用默认的
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(Constants.SY_DIRECT);
    }


    /**
     * 创建延时交换机
     * @return
     */
    @Bean
    CustomExchange directDelayedExchange(){
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(Constants.SY_DELAY,"x-delayed-message",false,false,args);
    }




    /**
     * 声明一个列队，参数一：列队名为Constants.FANOUT_DEMO1_QUEUE，参数二：是否持久化
     * @return
     */
    @Bean
    Queue queue1() {
        return new Queue(Constants.DIRECT_DEMO1_QUEUE,true);
    }

    /**
     * 声明一个列队，列队名为Constants.FANOUT_DEMO2_QUEUE
     * @return
     */
    @Bean
    Queue queue2() {
        return new Queue(Constants.DIRECT_DEMO2_QUEUE, true);
    }

    @Bean
    public Queue delayQueue(){
        return new Queue(Constants.DELAY_QUEUE,true);
    }


    /**
     * 消息通道与交换器绑定
     * @return
     */
    @Bean
    Binding fanoutQue1(){
        return BindingBuilder.bind(queue1()).to(directExchange()).with(Constants.DIRECT_DEMO1_QUEUE);
    }

    @Bean
    Binding fanoutQue2(){
        return BindingBuilder.bind(queue2()).to(directExchange()).with(Constants.DIRECT_DEMO2_QUEUE);
    }


    @Bean
    Binding fanoutQue3(){
        return BindingBuilder.bind(delayQueue()).to(directDelayedExchange()).with(Constants.DELAY_QUEUE).noargs();
    }
}
