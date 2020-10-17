package com.reggie.movie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.reggie.movie.enums.OrderEnum;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.service.search.MovieListQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 2:54 PM
 * ticket: AMS-12934
 * description: MovieListController
 **/
@Controller
@RequestMapping("/")
public class MovieListController {
    private static final int pageSize = 30;
    @Autowired
    private MovieListQueryService movieListQueryService;

    @GetMapping("/page")
    public ModelAndView getMovieByPage(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "30", required = false) Integer pageSize,
                                       @RequestParam(value = "order", defaultValue = "0", required = false) Integer order) {
        ModelAndView modelAndView = new ModelAndView();
        Page<MovieBrief> movieInfos = movieListQueryService.selectByPage(pageNum, pageSize, order);

        List<Object> a = new ArrayList<>();
        a.add(movieListQueryService.selectAllRegion());
        a.add(movieListQueryService.selectAllLanguage());
        a.add(movieListQueryService.selectAllCategory());
        modelAndView.addObject("name", a);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/all")
    public PageInfo<MovieBrief> getAllMovies() {
        Page<MovieBrief> movieInfos = movieListQueryService.selectAll();
        return PageInfo.of(movieInfos);
    }

    @GetMapping(value = {"/", "/index"})
    public String getIndex(ModelMap map) {
        Page<MovieBrief> recentBriefs = movieListQueryService.selectByPage(1, pageSize, OrderEnum.PUBLISH_YEAR.getCode());
        Page<MovieBrief> hotBriefs = movieListQueryService.selectByPage(1, pageSize, OrderEnum.HOT_RANK.getCode());
        Page<MovieBrief> rateBriefs = movieListQueryService.selectByPage(1, pageSize, OrderEnum.RATE.getCode());
        Page<MovieBrief> interestBriefs = movieListQueryService.selectByPage(1, pageSize, OrderEnum.INTEREST.getCode());
        Page<MovieBrief> mostReviewsBriefs = movieListQueryService.selectByPage(1, pageSize, OrderEnum.REVIEW.getCode());
        map.addAttribute("recentBriefs", recentBriefs);
        map.addAttribute("hotBriefs", hotBriefs);
        map.addAttribute("rateBriefs", rateBriefs);
        map.addAttribute("interestBriefs", interestBriefs);
        map.addAttribute("mostReviewsBriefs", mostReviewsBriefs);
        return "index";
    }
}
