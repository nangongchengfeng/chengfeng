package hello;

import org.springframework.stereotype.Component;

/**
 * 打印
 */
@Component
public class MessagesService {
    public MessagesService() {
        super();
        System.out.println("MessageService..");
    }

    public String getMessage() {
        return "Hello Word";
    }
}
