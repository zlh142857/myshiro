package com.hx.dao;
/*用户信息仓库
 */

import com.hx.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
}
