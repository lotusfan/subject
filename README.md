# spring boot 基础操练
##一、概述
优点：快速构建项目、
对主流开发框架的无配置集成、
无须外部依赖Servlet容器、
准生产级的应用监控
*注：提倡“习惯优于配置”理念*

>上面第二点提到的“无须配置集成”，并不是真的不需要配置，只是spring boot为我们提供了一些常用的习惯性的默认配置
>在后面的演示都是依赖这几点来实际操作spring boot

##二、基础、核心应用
> spring boot的基础、核心其实也是依赖于spring的，在2.0中引入了spring 5.0 那同时就会引入很多与spring 5.0相关的特性了，这里我只是挑了几个在使用上spring boot特有的点来简单说明一下

####1. 独立运行Spring项目
> 首先说一下运行；与我们平时部署的war包不同，spring boot可以以jar形式来运行web项目；我们在项目搭建的时候会进行演示

Spring Boot可以以jar包的形式独立运行，运行一个Spring Boot项目只需通过java -jar xxx.jar来运行
####2. 内嵌Servlet容器
> Spring boot可以以jar包的形式运行，也是因为本身内嵌了servlet容器

Spring Boot可选择内嵌Tomcat、Jetty或者Undertow，我们无须以war包形式部署项目,大大简化了项目部署复杂性
####3. 提供了start模块来简化Maven配置
Spring提供了一系列的start pom来简化Maven的依赖加载
> start是一套方便的依赖描述符，通过它你可以一站式的获取所需要的Spring依赖和相关技术依赖

*常用的有：
spring-boot-starter             核心starter，包含自动配置、日志
spring-boot-starter-actuator    准生产特性，用来监控和管理应用 
spring-boot-starter-amqp 
spring-boot-starter-aop 
spring-boot-starter-jdbc 
spring-boot-starter-redis 
spring-boot-starter-security
spring-boot-starter-test 单元测试和集成测试
spring-boot-starter-web 支持Web项目的开发，包含Tomcat和spring-mvc*
####4. 新特性

* 除了支持普通properties格式`application.properties`；还支持yaml格式文件`application.yaml`；如果需要单独添加自定义properties，需要使用`@PropertySource("path")`指定加载文件、使用`@ConfigurationProperties`映射attribute，最后在配置类中添加`@EnableConfigurationProperties(class)`启动properties映射

* spring boot 提倡项目零配置，一切使用注解（*无xml*）。如果必须使用，可以使用`@ImportResource("example_path")`来加载
> 这里所说的零配置其实也是spring boot为我们自动载了常用的依赖bean，具体加载哪些bean可以查看spring-boot-autoconfigure包源码

* @RestController 修饰controller类，使当前类的所有方法以json格式返回输出对象，如果返回是字符串就直接返回了。

##三、快速搭建、准生产的应用监控
####1. 快速搭建
*注：spring boot 提供了一个项目生成工具，网址：http://start.spring.io*
#####1. web项目搭建
>① 新建一个项目不添加任何依赖，mvn打jar包运行，看一下启动日志。说明入口main方法，@SpringBootApplication注解。 接着打开starter-boot包中查看spring.provides引入了spring-boot,spring-context,spring-beans
>② 新建一个项目添加starter-web，新建一个controller，运行演示。接着打开starter-web包中查看spring.provides引入了spring-webmvc,spring-web
>③ 在上一个web项目中演示加载自定义properties，映射到Model中

#####2. filter配置
默认注册CharacterEncodingFilter（设置编码spring.http.encoding=UTF-8);配置一个filter需要在config class中使用`@ServletComponentScan(basePackages = "")`来加载已实现了Filter的类。实现Filter的类需要使用`@WebFilter`（servlet 3.0中添加的注解）来初始filter的属性
> 使用事先准备好的subject项目演示

#####3. 模板引擎加载
spring boot 对jsp的支持不是特别好，内嵌Tomcat、Jetty不支持以jar形式运行jsp,Undertow不支持jsp；spring boot 推荐使用Thymeleaf模板引擎。使用Thymeleaf只需要添加spring-boot-starter-thymeleaf即可完成相关bean的注入（*详细配置可以查看ThymeleafAutoConfiguration类的源码*）。
> 不做演示

#####4. redis使用
pom.xml中添加spring-boot-starter-data-redis，application.properties中指定redis服务器`spring.redis.host=127.0.0.1`
> 使用事先准备好的subject项目演示

#####5. mybatis使用
pom.xml中添加mybatis-spring-boot-starter版本1.3.2、mysql-connector-java，application.properties中指定`spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.datasource.url = jdbc:mysql://127.0.0.1:3307/mj?useUnicode=true&characterEncoding=utf-8
spring.datasource.username = root
spring.datasource.password = 123456`,配置类Application添加`@MapperScan("mapper path")`注解
> 使用事先准备好的subject项目演示

#####6. profile配置
添加application-{profile}.properties,接着在application.properties里指定`spring.profiles.active={profile}`
> 使用事先准备好的subject项目演示

####2. 快速部署
* 生成jar包部署
> mvn jar:jar -f pom.xml

* 生成war包部署
> mvn war:war -f pom.xml

####3. 应用监控
>spring boot为我们提供了两种监控方式web,jmx 使用web方式，默认只提供health、info，通过设置management.endpoints.web.exposure.include= *可以将加载其它内容beans、evn、mappings、heapdump、threaddump等

首先添加spring-boot-admin-starter-client 在被监控的项目里，配置spring.boot.admin.client.url=“server address”(*注册服务器地址*)。新建server监控项目，添加spring-boot-admin-starter-server、spring-boot-admin-starter-server-ui，不需要添加其它配置。启动项目先启动server监控，才能使client端可以注册成功。

> 使用事先准备好的subject和admin项目演示

##四、spring boot 版本 1.0 和 2.0


|   | 最低JDK版本要求 | spring版本 | 定时任务 | 数据库连接池 | redis连接方式 | Thymeleaf版本 | OAuth |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 2.0 | jdk8 | 5.0 | 集成Quartz | HikariCP | lettuce | 3.0 | 引入 |
| 1.0 | jdk6 | 4.0 | 无 | tomcat-pool | jedis | 2.0 | 未引入 |

##Spring boot遗留问题
* 消失的web.xml(*https://blog.csdn.net/wang11234ilike/article/details/60575239*)
* spring boot ssl配置
* spring boot websocket
* Spring Boot CLI，控制台命令工具
