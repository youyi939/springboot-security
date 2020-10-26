package cn.lnfvc.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;

/**
 * @version 1.0
 * @author: KenChen
 * @date 2020/10/13 6:46 下午
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    //todo
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/level1/**").hasRole("vip1")
//                .antMatchers("/level2/**").hasRole("vip2");
//        http.formLogin();//默认自动生成登录页面
//    }
//
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 基于内存的用户存储
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("root")
//                .password(
//                        new BCryptPasswordEncoder().encode("password")).roles("vip1","vip2")
//                .and()
//                .withUser("user1")
//                .password(new BCryptPasswordEncoder().encode("password")).roles("vip1");
//
//    }




//
//    private DataSource dataSource;
//
//    @Autowired
//    public SecurityConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    /**
     * 配置拦截器保护请求
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();
    }

//    /**
//     * UserDetailsService 用户名，密码，以及其他属性的查找，Spring Security提供内存以及JDBC实现
//     */
//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setDataSource(dataSource);
//        return jdbcUserDetailsManager;
//    }

    /**
     * 根据自动匹配密码编码器
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



}

