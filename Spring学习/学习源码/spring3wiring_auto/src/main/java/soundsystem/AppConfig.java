package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 组件扫描
 * @Component：表示这个类需要在应用程序中被创建
 * @ComponentScan：自动发现应用程序中被创建的类
 *
 * 自动装配
 * @Autowired：自动满足bean之间的依赖
 *
 * 定义配置类
 * @Configuration：表示当前类是一个配置类
 */




@Configuration
@ComponentScan
public class AppConfig {
}
