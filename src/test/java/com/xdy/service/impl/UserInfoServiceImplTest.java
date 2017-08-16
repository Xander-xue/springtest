package com.xdy.service.impl;

import com.xdy.service.UserInfoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by user on 2017/8/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {
    @Autowired
    private UserInfoService userInfoService;
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testTransational() throws Exception {
        userInfoService.testTransational();
    }

}