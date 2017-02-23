package com.dream;

import com.dream.site.Service.test.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationRunTest {
    @Autowired
    TestService testService;

    @Test
    public void test001() {
        for (int i=1; i<100000; i++) {
            if (i % 2 == 1 && i % 3 == 0 && (i - 1) % 4 == 0 && (i + 1) % 5 == 0 && (i + 3) % 6 == 0 && i % 7 == 0 && (i - 1) % 8 == 0 && i % 9 == 0) {
                System.out.println(i);
            }
        }

    }


}
