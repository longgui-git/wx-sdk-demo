package cn.trawe.operation.base.third;

import javax.sql.CommonDataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "cn.trawe.operation", "cn.trawe.pay" })
@EnableEurekaClient
@EnableAspectJAutoProxy
@EnableSwagger2
@MapperScan("cn.trawe.operation.**.mapper")
@EnableApolloConfig
@Slf4j
public class ThirdAbilityApplication  {

//	@Value("${wx.defalut.appId}")
//    private String wxDefaultAppId;

	public static void main(String[] args) {
		
		SpringApplication.run(ThirdAbilityApplication.class, args);
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		log.info("wxDefaultAppId-->"+wxDefaultAppId);
//
//	}

}
