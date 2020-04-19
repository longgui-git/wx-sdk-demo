package cn.trawe.operation.base.third.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Value("${swagger2.api.doc.enable}")
	private boolean enable;
	
	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.trawe.wechat.chongqing"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("重庆微信公众号服务")
				.description("后端API文档")
				.version("1.0")
				.build();
	}

}
