//package com.example.demo.config;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
//
///**
// * Created by ningcs on 2018/5/9.
// */
//@Configuration
//@EnableAsync
//public class BeanConfig   {
//    Logger logger = Logger.getLogger(getClass());
//    @Bean
//    public TaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        // 设置核心线程数
//        executor.setCorePoolSize(20);
//        // 设置最大线程数
//        executor.setMaxPoolSize(20);
//        // 设置队列容量
//        executor.setQueueCapacity(20);
//        // 设置线程活跃时间（秒）
//        executor.setKeepAliveSeconds(60);
//        // 设置默认线程名称
//        executor.setThreadNamePrefix("hello-");
////        AbortPolicy，用于被拒绝任务的处理程序，它将抛出RejectedExecutionException。
////        CallerRunsPolicy，用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务。
////        DiscardOldestPolicy，用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute。
////        DiscardPolicy，用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务。
//        // 设置拒绝策略
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        // 等待所有任务结束后再关闭线程池
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        return executor;
//    }
//
//
//}
