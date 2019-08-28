package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Autowired的使用方法 1：用在构造函数上（多种依赖的情况下）
 * 2：用在成员变量上
 * 3：用在setter方法上
 * 4：用在任意方法上
 */

@Component
public class CDPlayer {

    @Autowired
    private Power power;
    @Autowired(required = false)
    private CompactDisc cd;

    //    @Autowired
//    public void setPower(Power power) {
//        this.power = power;
//        System.out.println("调用setpower");
//    }
//    @Autowired
//    public void setCd(CompactDisc cd) {
//        this.cd = cd;
//        System.out.println("调用setCD");
//    }


    //    @Autowired
//    public CDPlayer(Power power, CompactDisc cd) {
//        this.power = power;
//        this.cd = cd;
//        System.out.println("CDPlay多参构造方法");
//    }
//自动装配
//    @Autowired
//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }
//    @Autowired
//    public void pre(CompactDisc cd, Power power) {
//        this.cd = cd;
//        this.power = power;
//    }

    public void play1() {
        if (cd != null) {
            cd.play();
        }
        power.sunplay();
    }
}
