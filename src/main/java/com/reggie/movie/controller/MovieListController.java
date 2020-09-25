package com.reggie.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 2:54 PM
 * ticket: AMS-12934
 * description: MovieListController
 **/
@RestController
@RequestMapping("/api/list")
public class MovieListController {

    @GetMapping("/test")
    public String getTest(){
        return "hello world!";
    }
}
