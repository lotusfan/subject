package com.subject.subject;

import com.subject.subject.filter.MyFilter;
import com.subject.subject.model.MyModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @SpringBootApplication 核心注解(组合注解)、开启自动配置;
 * 如果不使用，则可以使用@Configuration、@EnableAutoConfiguration、@ComponentScan 分别实现
 * @EnableAutoConfiguration 在spring-boot-autoconfigure 包META-INF/spring.factories有具体说明
 *
 */
@SpringBootApplication
@ServletComponentScan(basePackageClasses = MyFilter.class)
@EnableConfigurationProperties(MyModel.class)
//@MapperScan("com.subject.subject.mapper")
public class SubjectApplication {


	/**
	 * spring boot version: 2.0.2
	 * 项目程序入口 main()
	 * 运行：mvn spring-boot:run
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);
	}
}

