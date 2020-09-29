package com.reggie.movie.service.search;

import com.reggie.movie.model.MovieInfo;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 5:14 PM
 * ticket: AMS-12934
 * description: MovieDetailService
 **/
public interface MovieDetailService {
    MovieInfo getById(String duonaoId);
}
