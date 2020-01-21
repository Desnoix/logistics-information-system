package com.yjq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName SwaggerConfig
 * @Author GDMZ_jqyang@outlook.com
 * @Description SwaggerConfig 配置类
 * @Date 2020/1/19 23:57
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {

    private final String version = "1.0";

    private final String title = "综合物流信息管理";

    private final String description = "API文档自动生成";

    private final String termsOfServiceUrl = "http://www.kingeid.com";

    private final String license = "MIT";

    private final String licenseUrl = "https://mit-license.org/";

    private final Contact contact = new Contact("yjq", "https://github.com/calebman", "gdmz_jqyang@outlook.com");

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf())
                .select().build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title(title).termsOfServiceUrl(termsOfServiceUrl).description(description)
                .version(version).license(license).licenseUrl(licenseUrl).contact(contact).build();

    }

}
