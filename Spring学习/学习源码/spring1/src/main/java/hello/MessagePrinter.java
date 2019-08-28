package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 打印机
 */
@Component
public class MessagePrinter {

    public MessagePrinter() {
        super();
        System.out.println("MessagePinter..");
    }

    /**
     * 建立和MessageService的关联关系
     */
    private MessagesService service;

    /**
     * 设置service的值
     *
     * @param service
     */
    @Autowired
    public void setService(MessagesService service) {
        this.service = service;
    }


    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
