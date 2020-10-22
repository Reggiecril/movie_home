package com.reggie.movie.service.search;

import com.github.pagehelper.Page;
import com.reggie.movie.enums.FieldMap;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;

import java.util.List;
import java.util.Map;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 8:58 AM
 * ticket: AMS-12934
 * description: MovieListQueryService
 **/
public interface MovieListQueryService {
    Page<MovieBrief> selectAll();

    Page<MovieBrief> selectByPage(Integer pageNum, Integer pageSize, Integer order);

    Page<MovieBrief> selectByPageWithAttrs(Integer pageNum, Integer pageSize, Integer order, Map<String, String> map);

    List<String> selectByAttrs(FieldMap fieldMap);

    Map<String, List<String>> selectAllAttrs();

    Page<MovieBrief> selectRelatedMovies(String duonaoId);

}
