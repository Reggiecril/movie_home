package com.reggie.movie.controller;

import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.service.search.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 5:13 PM
 * ticket: AMS-12934
 * description: MovieDetailController
 **/
@Controller
@RequestMapping("/detail")
public class MovieDetailController {
    @Autowired
    private MovieDetailService movieDetailService;

    @GetMapping("")
    public ModelAndView getMovieByPage(@RequestParam(value = "id") String duonaoId) {
        ModelAndView modelAndView = new ModelAndView();
        MovieInfo movieInfo = movieDetailService.getById(duonaoId);
        modelAndView.addObject("name", movieInfo);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
