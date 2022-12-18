package com.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author WYC
 * @Create 2022-11-05-下午 02:15
 **/
public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("清空数据：" + jedis.flushDB());
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        // 添加名称为 hash（key）的 hash 元素
        jedis.hmset("hash", map);
        // 向名称为 hash 的 hash 中添加 key 为 key5，value 为 value5 元素
        jedis.hset("hash", "key5", "value5");
        // return Map<String,String>
        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll(" hash"));
        // return Set<String>
        System.out.println("散列hash的所有键为：" + jedis.hkeys("hash"));
        // return List<String>
        System.out.println("散列hash的所有值为：" + jedis.hvals("hash"));
        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6：" + jedis.hincrBy(" hash", " key6", 6));
        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6：" + jedis.hincrBy(" hash", " key6", 3));
        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对：" + jedis.hdel("hash", "key2"));
        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
        System.out.println("散列hash中键值对的个数：" + jedis.hlen("hash"));
        System.out.println("判断hash中是否存在key2：" + jedis.hexists(" hash", " key2"));
        System.out.println("判断hash中是否存在key3：" + jedis.hexists(" hash", " key3"));
        System.out.println("获取hash中的值：" + jedis.hmget("hash", "key3"));
        System.out.println("获取hash中的值：" + jedis.hmget(" hash", " key3", " key4"));
    }
}
