package hello;


/**
 * 打印
 */
public class MessagesService {
//    无参构造函数
    public MessagesService() {
        super();
        System.out.println("MessageService..");
    }

    public String getMessage(){
      return "Hello Word";
    }
}
