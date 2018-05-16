package com.example.demo.tickets;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by ningcs on 2018/5/15.
 */
public class StartTicketsTaskThread implements Runnable {
    Logger logger = Logger.getLogger(getClass());

    private TaskExecutor threadPoolTaskExecutor;

    private int i=1;

    public StartTicketsTaskThread(TaskExecutor threadPoolTaskExecutor, int i) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
        this.i = i;
    }

    @Override
    public synchronized void run() {
        String task = "task@ " + i;
        System.out.println("创建任务并提交到线程池中：" + task);
        FutureTask<String> futureTask = new FutureTask<String>(
                new TicketsThreadPoolTask(task));
        threadPoolTaskExecutor.execute(futureTask);
////        获取当前线程池活动的线程数：
//        int count = threadPoolTaskExecutor.getActiveCount();
//        logger.info("[x] - now threadpool active threads totalNum : " +count);
        // 在这里可以做别的任何事情
        String result = null;
        try {
            // 取得结果，同时设置超时执行时间为1秒。同样可以用future.get()，不设置执行超时时间取得结果
            result = futureTask.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            futureTask.cancel(true);
        } catch (Exception e) {
            futureTask.cancel(true);
            // 超时后，进行相应处理
        } finally {
            System.out.println("task@" + i + ":result=" + result);
        }

    }
}
