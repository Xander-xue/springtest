package com.xdy.service;

import com.xdy.model.UserInfo;

/**
 * User: xuedaiyao
 * Date: 2017/8/14
 * Time: 17:51
 * Description:
 */

public interface UserInfoService  {

    void save(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void delUser(Integer[] ids);
}
