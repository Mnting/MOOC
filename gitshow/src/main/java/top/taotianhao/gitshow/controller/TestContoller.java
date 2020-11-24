package top.taotianhao.gitshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Tianhao Tao
 * @Date 2020/11/18 15:32
 * @Version 1.0
 */
@Controller
public class TestContoller {
    @GetMapping("/test")
    public String graph(){return "test";}
}
