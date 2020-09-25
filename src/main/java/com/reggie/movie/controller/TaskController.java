package com.reggie.movie.controller;

import com.reggie.movie.service.task.DatabaseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 4:03 PM
 * ticket: AMS-12934
 * description: TaskController
 **/
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private DatabaseTask databaseTask;

    @GetMapping("/load")
    public boolean databaseTask() {
        return databaseTask.insertAll();
    }
}
