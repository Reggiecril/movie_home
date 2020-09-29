package com.reggie.movie.service.search.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.reggie.movie.enums.OrderEnum;
import com.reggie.movie.mapper.MovieBriefMapper;
import com.reggie.movie.mapper.MovieInfoMapper;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.service.search.MovieListQueryService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 9:19 AM
 * ticket: AMS-12934
 * description: MovieListQueryServiceImpl
 **/
@Service
public class MovieListQueryServiceImpl implements MovieListQueryService {
    @Autowired(required = false)
    private MovieBriefMapper movieBriefMapper;
    @Override
    public Page<MovieBrief> selectAll() {
        PageHelper.orderBy(OrderEnum.getOrderByCode(0).name().toLowerCase());
        return movieBriefMapper.findByPage();
    }

    @Override
    public Page<MovieBrief> selectByPage(Integer pageNum, Integer pageSize,Integer order) {
        PageHelper.startPage(pageNum, pageSize, OrderEnum.getOrderByCode(order).name().toLowerCase());
        return movieBriefMapper.findByPage();
    }
}
