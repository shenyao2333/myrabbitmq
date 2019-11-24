package com.sy.tabbitmq.consumer.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.24 20:11
 * @version:
 */
@Data
public class MQMessage implements Serializable {

    private static final long serialVersionUID = -5103185555156125704L;

    private String message;

    private String messageId;

}
