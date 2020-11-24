package top.taotianhao.gitshow.swagger2;

import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.taotianhao.gitshow.entity.File;

import java.util.*;

/**
 * @Author Tianhao Tao
 * @Date 2020/11/24 11:08
 * @Version 1.0
 */
@Api(tags = "文件目录接口")
@Controller
@RequestMapping(value = "/file")
public class FilePathController {
   File file = new File("123","test.txt", "root","null",true,true);


    @ApiOperation(value="获取文件列表", notes="根据文件id获取文件名称")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public String getFileName(String id) {
        String filename = file.getName();
        if (id.equals(file.getId())){
            return filename;
        }
        return "Not found";
    }
}
