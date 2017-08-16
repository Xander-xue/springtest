package com.xdy.service.impl;

import com.xdy.exception.CustomerException;
import com.xdy.mapper.AccessTokenMapper;
import com.xdy.mapper.UserInfoMapper;
import com.xdy.model.AccessToken;
import com.xdy.model.UserInfo;
import com.xdy.service.UserInfoService;
import com.xiaoleilu.hutool.lang.Assert;
import com.xiaoleilu.hutool.util.CollectionUtil;
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
    @Autowired
    private AccessTokenMapper accessTokenMapper;


    @Override
    public UserInfo getLoginUser(String userToken) {
        //如果用户没登录
        if (!isUserLogin(userToken)) {
            throw new CustomerException(401, "请登录");
        }
        return  this.getUserByToken(userToken,0);
    }

    /**
     *  根据用户token查询是否存在token未过期的记录
     * @param userToken
     * @return
     */
    private boolean isUserLogin(String userToken) {
        Example example = new Example(AccessToken.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("accessToken",userToken);
        criteria.andEqualTo("expire",0);//0-未过期 1- 过期
        List<AccessToken> accessToken = accessTokenMapper.selectByExample(example);
        if (CollectionUtil.isNotEmpty(accessToken)){
            return true;
        }
        return false;
    }

    private UserInfo getUserByToken(String userToken, int expire) {
        Example example = new Example(AccessToken.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("accessToken",userToken);
        criteria.andEqualTo("expire",0);//0-未过期 1- 过期
        List<AccessToken> accessToken = accessTokenMapper.selectByExample(example);
        Assert.notEmpty(accessToken);
        return userInfoMapper.selectByPrimaryKey(accessToken.get(0).getUserId());
    }

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
        u.setPhoneNumber("18916292333");
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
