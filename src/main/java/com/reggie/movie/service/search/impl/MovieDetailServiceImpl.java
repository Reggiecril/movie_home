package com.reggie.movie.service.search.impl;

import com.github.pagehelper.PageHelper;
import com.reggie.movie.enums.OrderEnum;
import com.reggie.movie.mapper.MovieInfoMapper;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.service.search.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 5:16 PM
 * ticket: AMS-12934
 * description: MovieDetailServiceImpl
 **/
@Service
public class MovieDetailServiceImpl implements MovieDetailService {
    @Autowired(required = false)
    private MovieInfoMapper movieInfoMapper;
    @Override
    public MovieInfo getById(String duonaoId) {
        return movieInfoMapper.findById(duonaoId);
    }
}
