package com.xdy.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * User: xuedaiyao
 * Date: 2017/8/16
 * Time: 16:37
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    RedisTemplate<String, String> redisTemplate = null;

    @Test
    public void redisTest() {
        String key = "redisTestKey";
        String value = "I am test value";

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();

        //数据插入测试：
        opsForValue.set(key, value);
        String valueFromRedis = opsForValue.get(key);
        logger.info("redis value after set: {}dd d ", valueFromRedis);
        assertThat(valueFromRedis, is(value));

        //数据删除测试：
        redisTemplate.delete(key);
        valueFromRedis = opsForValue.get(key);
        logger.info("redis value after delete: {}", valueFromRedis);
        assertThat(valueFromRedis, equalTo(null));
    }
}

