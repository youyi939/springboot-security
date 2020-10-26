package cn.lnfvc.springbootsecurity.dao;

import cn.lnfvc.springbootsecurity.entitis.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version 1.0
 * @author: KenChen
 * @date 2020/10/26 1:49 下午
 */
@Mapper
public interface UserDao {
    UserPo loadUserByUsername(String username);
}
