package com.reggie.movie.controller;

import com.github.pagehelper.Page;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.service.search.MovieDetailService;
import com.reggie.movie.service.search.MovieListQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private MovieListQueryService movieListQueryService;

    @GetMapping("")
    public String getMovieByPage(@RequestParam(value = "id") String duonaoId, ModelMap modelMap) {
        MovieInfo movieInfo = movieDetailService.getById(duonaoId);
        modelMap.addAttribute("movieInfo", movieInfo);

        Page<MovieBrief> movieBriefPage = movieListQueryService.selectRelatedMovies(duonaoId);
        modelMap.addAttribute("relatedMovies", movieBriefPage);

        return "single";
    }
}
