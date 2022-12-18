package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @Author WYC
 * @Create 2022-11-05-下午 01:35
 **/
public class TestPing {
    public static void main(String[] args) {
        //1、new一个Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //Jedis的所有命令就是我们之前学的所有命令，指令学习很重要！
        System.out.println(jedis.ping());
    }
}
