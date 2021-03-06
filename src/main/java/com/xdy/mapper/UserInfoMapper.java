package com.xdy.mapper;

import com.xdy.model.UserInfo;
import com.xdy.util.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 * User: xuedaiyao
 * Date: 2017/8/11
 * Time: 15:17
 * Description:
 */

public interface UserInfoMapper extends MyMapper<UserInfo> {

    void deleteByIds(@Param("ids") Integer[] ids);
}
