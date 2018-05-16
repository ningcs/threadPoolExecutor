package com.example.demo.tickets;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
/** 
* StartTicketsTaskThread Tester. 
* 
* @author <ningcs> 
* @since <pre>05/16/2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class StartTicketsTaskThreadTest {
    Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    private static int produceTaskSleepTime = 20;

    private static int produceTaskMaxNumber = 30;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        return threadPoolTaskExecutor;
    }

    public void setThreadPoolTaskExecutor(
            ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    @Test
    public void contextLoads() {
        for (int i = 1; i <= produceTaskMaxNumber; i++) {
            try {
                Thread.sleep(produceTaskSleepTime);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new Thread(new StartTicketsTaskThread(threadPoolTaskExecutor, i)).start();
        }

    }

} 
