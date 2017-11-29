package com.mall;

import com.mall.bus.rabbitmq.demo.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusServerApplication.class)
public class HelloQueueTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }
}
