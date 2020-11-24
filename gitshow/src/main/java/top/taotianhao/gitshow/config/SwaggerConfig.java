package top.taotianhao.gitshow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Tianhao Tao
 * @Date 2020/11/24 11:00
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    /**
//     * API接口包路径
//     */
//    private String basePackage;
//
//    /**
//     * API页面标题
//     */
//    private String title;
//
//    /**
//     * API描述
//     */
//    private String description;
//
//    /**
//     * 服务条款地址
//     */
//    private String termsOfServiceUrl;
//
//    /**
//     * 版本号
//     */
//    private String version;
//
//    /**
//     * 联系人
//     */
//    private Contact contact;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.taotianhao.gitshow.swagger2"))
                .paths(PathSelectors.any())
                .build();
    }
    //配置在线文档的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("学习swagger2")
                .termsOfServiceUrl("https://taotianhao.top")
                .version("1.0")
                .build();
    }

}
