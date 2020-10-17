package com.reggie.movie.service.search;

import com.github.pagehelper.Page;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;

import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 8:58 AM
 * ticket: AMS-12934
 * description: MovieListQueryService
 **/
public interface MovieListQueryService {
    Page<MovieBrief> selectAll();
    Page<MovieBrief> selectByPage(Integer pageNum, Integer pageSize,Integer order);
    List<String> selectAllRegion();
    List<String> selectAllLanguage();
    List<String> selectAllCategory();

    Page<MovieBrief> selectRelatedMovies(String duonaoId);

}
