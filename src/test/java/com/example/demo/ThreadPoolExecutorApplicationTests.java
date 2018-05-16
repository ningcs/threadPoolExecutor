package com.example.demo;

import com.example.demo.test.StartTaskThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolExecutorApplicationTests {

	private static int produceTaskSleepTime = 10;

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
			new Thread(new StartTaskThread(threadPoolTaskExecutor, i)).start();
		}

}

}
