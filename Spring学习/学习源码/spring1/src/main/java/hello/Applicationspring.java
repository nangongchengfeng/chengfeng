package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Applicationspring {
    public static void main(String[] args) {
        System.out.println("applictionspring");
        //初始化spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(Applicationspring.class);
        //从容器中获取MessagePrinter对象
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        //从容器中获取MessageService对象
//        MessagesService service=context.getBean(MessagesService.class);
//        System.out.println(printer);
//        System.out.println(service);

        // printer.setService(service);
        printer.printMessage();
    }
}
