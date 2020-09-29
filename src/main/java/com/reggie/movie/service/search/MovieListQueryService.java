package com.reggie.movie.service.search;

import com.github.pagehelper.Page;
import com.reggie.movie.model.MovieInfo;

import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 8:58 AM
 * ticket: AMS-12934
 * description: MovieListQueryService
 **/
public interface MovieListQueryService {
    Page<MovieInfo> selectAll();
    Page<MovieInfo> selectByPage(Integer pageNum, Integer pageSize,Integer order);

}
