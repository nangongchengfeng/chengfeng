package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


//自动扫描器

//@ComponentScan
public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        CDPlayer player = context.getBean(CDPlayer.class);
        player.play1();
    }
}
