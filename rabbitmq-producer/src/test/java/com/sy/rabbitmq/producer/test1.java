package com.sy.rabbitmq.producer;

import com.sy.rabbitmq.producer.service.RabbitSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 17:48
 * @version:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {

    @Resource
    private RabbitSendService rabbitSendService;

    @Test
    public void test1(){
        rabbitSendService.sendDemo1Message("我这个是测试发送");
    }


}
