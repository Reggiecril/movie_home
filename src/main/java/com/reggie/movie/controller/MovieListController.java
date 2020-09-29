package com.reggie.movie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.service.search.MovieListQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public PageInfo<MovieInfo> getMovieByPage(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "30", required = false) Integer pageSize,
                                              @RequestParam(value = "order", defaultValue = "0", required = false) Integer order) {
        Page<MovieInfo> movieInfos = movieListQueryService.selectByPage(pageNum, pageSize, order);
        return PageInfo.of(movieInfos);
    }

    @GetMapping("/all")
    public PageInfo<MovieInfo> getAllMovies() {
        Page<MovieInfo> movieInfos = movieListQueryService.selectAll();
        return PageInfo.of(movieInfos);
    }
}
