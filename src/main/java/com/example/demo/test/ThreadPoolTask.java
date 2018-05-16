package com.example.demo.test;


import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * Created by ningcs on 2018/5/15.
 */
public class ThreadPoolTask implements Callable<String>, Serializable {
    private static final long serialVersionUID = 0;
    Logger logger = Logger.getLogger(getClass());
    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    private static int consumeTaskSleepTime = 2000;

    public ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    @Override
    public String call() throws Exception {
        // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
        System.out.println("开始执行任务：" + threadPoolTaskData);
        String result = "";
        // //便于观察，等待一段时间
        try {
            // long r = 5/0;
            for (int i = 0; i < 100000000; i++) {
//                Thread.sleep(200);
            }
            result = "OK";
        } catch (Exception e) {
            logger.info("执行失败");
            e.printStackTrace();
            result = "ERROR";
        }
        threadPoolTaskData = null;
        return result;
}
}
