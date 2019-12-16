package com.sy.rabbitmq.common.config.rabbitmq;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.10.24 16:41
 * @version:
 */
public class Constants {

    /**
     * 发送中的状态
     */
    public static final String SEND_RUN="0";
    /**
     * 发送成功
     */
    private static final String SEND_SUCCESS="1";
    /**
     * 发送失败
     */
    public static final String SEND_FAIL="2";
    /**
     * 超时时间，单位 min
     */
    public static final int SEND_TIMEOUT=1;
    /**
     * 最大重试次数
     */
    public static final int MAX_RETRY=3;


    /**
     * Fanout创建交换器
     */
    public static final String SY_FANOUT="fanout1";
    /**
     * 与Fanout交换机绑定的队列
     */
    public static final String FANOUT_DEMO1_QUEUE="fanout.demo1";
    public static final String FANOUT_DEMO2_QUEUE="d.demo2";

    /**
     * 创建Topic交换器
     */
    public static final String SY_TOPIC="topic1";
    /**
     * 与topic交换器绑定的队列
     */
    public static final String TOPIC_DEMO1_QUEUE="topic.demo1";
    public static final String TOPIC_DEMO2_QUEUE="topic.demo2";


    /**
     * 创建Topic的几种RoutingKey
     */
    public static final String TOPIC_ALL="topic.*";
    public static final String TOPIC_DEMO1="topic.demo1";
    public static final String TOPIC_DEMO2="topic.demo2";


    /**
     * direct 交换器
     */
    public static final String SY_DIRECT="direct1";

    public static final String DIRECT_DEMO1_QUEUE="direct1.demo1";
    public static final String DIRECT_DEMO2_QUEUE="direct1.demo2";



}
