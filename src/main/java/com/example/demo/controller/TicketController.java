package com.example.demo.controller;

import com.example.demo.service.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ningcs on 2018/5/16.
 */
@RestController
@RequestMapping(value = "/test")
public class TicketController {
    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private AsyncTaskService asyncTaskService;



//    @RequestMapping(value = "/buyTicket",method = {RequestMethod.GET,RequestMethod.POST})
//    public void contextLoads() {
//        int i=0;
////        try {
//////            Thread.sleep(10);
////        } catch (InterruptedException e1) {
////            e1.printStackTrace();
////        }
//        new Thread(new StartTicketsTaskThread(taskExecutor,i)).start();
//    }

    @RequestMapping(value = "/buyTicket",method = {RequestMethod.GET,RequestMethod.POST})
    public void contextLoads() {
        for(int i = 0; i < 10; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }
}
