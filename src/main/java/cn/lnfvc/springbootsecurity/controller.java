package cn.lnfvc.springbootsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: KenChen
 * @date 2020/10/19 5:59 下午
 */
@RestController
public class controller {


    @GetMapping(value = "/level1/vip1")
    public String vip1(){
        return "vip1";
    }


    @GetMapping(value = "/level2/vip2")
    public String vip2(){
        return "vip2";
    }


}
