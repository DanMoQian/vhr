package org.javaboy.vhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docket(Environment environment){

        //已经开启
        /*////设置要显示的 Swagger环境
        Profiles profiles =  Profiles.of("dev", "test");
        //通过 environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean isDev = environment.acceptsProfiles(profiles);*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("但鹏")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo = new ApiInfo("但鹏的Api文档",
            "阿弥陀佛， 永无bug", "1.0", "urn:tos",
            new Contact("DMQi", "", "956432673@qq.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList());

}
