package top.taotianhao.gitshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Tianhao Tao
 * @Date 2020/11/26 16:49
 * @Version 1.0
 */
@Controller
public class gitController {
    @GetMapping("/git")
    public String gitIndex(){
        return "gitindex";}
}
