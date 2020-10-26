package cn.lnfvc.springbootsecurity.service;

import cn.lnfvc.springbootsecurity.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: KenChen
 * @date 2020/10/26 2:00 下午
 */
@Service
public class MyUserDetailServiceImpl  implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("整合mybatis 查询用户信息");
        return userDao.loadUserByUsername(username);
 }
}
