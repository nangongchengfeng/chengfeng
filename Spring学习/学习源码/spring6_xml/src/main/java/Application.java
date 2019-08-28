import com.sun.org.apache.bcel.internal.util.ClassPath;
import com.wei.demo.soundsystem.CompactDisc;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        System.out.println("Application。。。");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CompactDisc cd =context.getBean(CompactDisc.class);
        CompactDisc cd1 =(CompactDisc) context.getBean("compactDisc1");
        CompactDisc cd2 =(CompactDisc) context.getBean("compactDisc2");
        cd1.play();
        cd2.play();
    }
}
