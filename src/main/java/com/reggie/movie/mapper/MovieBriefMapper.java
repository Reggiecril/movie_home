package com.reggie.movie.mapper;

import com.github.pagehelper.Page;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 3:33 PM
 * ticket: AMS-12934
 * description: MovieInfoMapper
 **/
@Mapper
public interface MovieBriefMapper {
    Page<MovieBrief> findByPage();
}
