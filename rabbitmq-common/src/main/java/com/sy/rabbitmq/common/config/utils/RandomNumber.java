package com.sy.rabbitmq.common.config.utils;

import java.util.Random;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2019.11.29 21:34
 * @version:
 */
public class RandomNumber {
    private static String number="0123456789";


    public static String getRandom(int length){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<length;i++){
            int i1 = new Random().nextInt(number.length());
            sb.append(number.charAt(i1));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String random = getRandom(6);
        System.out.println(random);

    }



}
