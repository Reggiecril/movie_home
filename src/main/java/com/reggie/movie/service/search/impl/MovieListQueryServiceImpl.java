package com.reggie.movie.service.search.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.reggie.movie.enums.FieldMap;
import com.reggie.movie.enums.OrderEnum;
import com.reggie.movie.mapper.MovieBriefMapper;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.service.search.MovieListQueryService;
import com.reggie.movie.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PageHelper.startPage(pageNum, pageSize, OrderEnum.getOrderByCode(order).getName().toLowerCase());
        return movieBriefMapper.findByPage();
    }

    @Override
    public Map<String, List<String>> selectAllAttrs() {
        Map<String, List<String>> map = new HashMap<>(16);
        for (FieldMap value : FieldMap.values()) {
            map.put(value.getAttribution(), movieBriefMapper.findByAttr(TextUtil.humpToLine(value.getAttribution())));
        }
        return map;
    }

    @Override
    public List<String> selectByAttrs(FieldMap fieldMap) {
        return movieBriefMapper.findByAttr(fieldMap.getAttribution());
    }


    @Override
    public Page<MovieBrief> selectRelatedMovies(String duonaoId) {
        PageHelper.startPage(1, 6, OrderEnum.HOT_RANK.getName().toLowerCase());
        return movieBriefMapper.findRelatedMovies(duonaoId);
    }
}
