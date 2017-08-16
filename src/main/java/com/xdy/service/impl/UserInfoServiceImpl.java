package com.xdy.service.impl;

import com.xdy.mapper.UserInfoMapper;
import com.xdy.model.UserInfo;
import com.xdy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

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

    //测试事务
    //注意：方法的@Transactional会覆盖类上面声明的事务
    //Propagation.REQUIRED ：有事务就处于当前事务中，没事务就创建一个事务
    //isolation=Isolation.DEFAULT：事务数据库的默认隔离级别
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void testTransational() {

        //删除全部
        userInfoMapper.deleteByIds(new Integer[]{1});
        //新增
        UserInfo u = new UserInfo();
        u.setId(11);
        u.setUserName("xuedaiyao");
        u.setPassword("jenny1013");
        userInfoMapper.insert(u);
        //制造异常
        //如果类上面没有@Transactional,方法上也没有，哪怕throw new RuntimeException,数据库也会提交
//        throw new RuntimeException("事务异常测试");
    }


    @Override
    public List<UserInfo> list() {
        return userInfoMapper.selectAll();
    }
}
