package hello;


/**
 * 打印机
 */
public class MessagePrinter {
    /**
     * 无参构造函数
     */
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
     * @param service
     */
    public void setService(MessagesService service) {
        this.service = service;
    }


    public void printMessage(){
        System.out.println(this.service.getMessage());
    }
}
