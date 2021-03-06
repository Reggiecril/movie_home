package com.reggie.movie.mapper;

import com.github.pagehelper.Page;
import com.reggie.movie.enums.FieldMap;
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
    Page<MovieBrief> findByPage(@Param("region") String region, @Param("language") String language, @Param("category") String category,
                                @Param("publishYear") String publishYear, @Param("channel") String channel);

    MovieBrief findById(@Param("duonaoId") String duonaoId);

    List<String> findByAttr(@Param("attr") String attr);

    Page<MovieBrief> findRelatedMovies(@Param("duonaoId") String duonaoId);
}
