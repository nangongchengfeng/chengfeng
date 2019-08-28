package soundsystem;

import org.springframework.stereotype.Component;

@Component

public class Power {
    public Power() {
        super();
    }

    public void sunplay() {
        System.out.println("电源供电中...");
    }
}
