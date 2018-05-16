package com.example.demo.tickets;


import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * Created by ningcs on 2018/5/15.
 */
public class TicketsThreadPoolTask implements Callable<String>, Serializable {
    private static final long serialVersionUID = 0;
    Logger logger = Logger.getLogger(getClass());
    private int ticketsNums = 100;
    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    private static int consumeTaskSleepTime = 2000;

    public TicketsThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    @Override
    public String call(){
        // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
        System.out.println("开始执行任务：" + threadPoolTaskData);
        String result = "";
        while (true) {
            //同步代码块,相当于一个事务，相当于售票总部完成的工作
            try {
            synchronized (this) {
                //判断票余量
                if (ticketsNums > 0) {
                    logger.info(Thread.currentThread().getName() + "正在销售第" + (100 - ticketsNums + 1) + "张票");
                    result = Thread.currentThread().getName() + "第" + (100 - ticketsNums + 1) + "张票销售完成";
                    ticketsNums--;
                } else {
                    logger.info("票已售罄，请购买其他时间的票！！！");
                    result = "票已售罄，请购买其他时间的票！！！";
                    break;
                }
            }}catch (Exception e){
                logger.info("获取不到锁");
            }
        }
        return result;
    }
}