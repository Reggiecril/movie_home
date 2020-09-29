package com.reggie.movie.mapper;

import com.github.pagehelper.Page;
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
public interface MovieInfoMapper {

    void replace(@Param("movieInfoList") List<MovieInfo> movieInfoList);

    MovieInfo findById(@Param("duonaoId") String duonaoId);

}
