package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用单元测试的方案
 * <p>
 * 引入Spring单元测试模块
 * maven：junit，spring-test
 *
 * @RunWith(SpringJUnit4ClassRunner.class) 加载配置类
 * @ContextConfiguration(class=AppConfig.class)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
    @Autowired
    private CDPlayer player;

    @Test

    public void textPlay() {

        player.play1();
    }
}
