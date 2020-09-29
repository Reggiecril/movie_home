package com.reggie.movie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.service.search.MovieListQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 2:54 PM
 * ticket: AMS-12934
 * description: MovieListController
 **/
@Controller
@RequestMapping("/list")
public class MovieListController {
    @Autowired
    private MovieListQueryService movieListQueryService;

    @GetMapping("/page")
    public ModelAndView getMovieByPage(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "30", required = false) Integer pageSize,
                                              @RequestParam(value = "order", defaultValue = "0", required = false) Integer order) {
        ModelAndView modelAndView=new ModelAndView();
        Page<MovieBrief> movieInfos = movieListQueryService.selectByPage(pageNum, pageSize, order);
        modelAndView.addObject("name", PageInfo.of(movieInfos));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/all")
    public PageInfo<MovieBrief> getAllMovies() {
        Page<MovieBrief> movieInfos = movieListQueryService.selectAll();
        return PageInfo.of(movieInfos);
    }
}
