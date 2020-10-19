package com.reggie.movie.mapper;

import com.github.pagehelper.Page;
import com.reggie.movie.model.Banner;
import com.reggie.movie.model.MovieBrief;
import com.reggie.movie.model.MovieInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuncheng.xie
 * @date 10/19/20 3:27 PM
 * ticket: AMS-11595
 * description: BannerMapper
 */
@Mapper
public interface BannerMapper {
    List<Banner> getAllBanners();

    void replace(@Param("bannerList") List<Banner> bannerList);

    void deleteAll();

}
