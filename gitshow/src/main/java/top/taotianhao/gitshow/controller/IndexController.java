package top.taotianhao.gitshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Tianhao Tao
 * @Date 2020/11/13 17:36
 * @Version 1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){return "index";}
}
