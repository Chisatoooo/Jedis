package com.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author WYC
 * @Create 2022-11-05-下午 02:36
 **/
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("study", "jedis");
        String result = jsonObject.toJSONString();
        //监视result
        //jedis.watch(result);

        //开启事务
        Transaction multi = jedis.multi();

        //使用alt + Enter快捷键来创建相应类型的变量增加开发的效率
        //Idea如何包裹 try+catch+final
        //将光标定位到这段代码，按快捷键【CTRL+ALT+T】
        try {
            multi.set("user1", result);
            multi.set("user2", result);
            //代码抛出异常事务，执行失败（运行时异常）
            //int i = 1/0;
            multi.exec();
        } catch (Exception e) {
            //放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            //关闭连接
            jedis.close();
        }
    }
}
