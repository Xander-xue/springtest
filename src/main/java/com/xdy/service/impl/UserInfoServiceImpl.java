package com.xdy.service.impl;

import com.xdy.mapper.UserInfoMapper;
import com.xdy.model.UserInfo;
import com.xdy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;

/**
 * User: xuedaiyao
 * Date: 2017/8/14
 * Time: 17:53
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public void save(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void delUser(Integer[] ids) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids));
        userInfoMapper.deleteByExample(example);
//        userInfoMapper.deleteByIds(ids);
    }
}
