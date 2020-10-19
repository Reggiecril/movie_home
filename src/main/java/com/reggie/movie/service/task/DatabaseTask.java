package com.reggie.movie.service.task;

import com.reggie.movie.mapper.BannerMapper;
import com.reggie.movie.mapper.MovieInfoMapper;
import com.reggie.movie.model.Banner;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.parse.MovieObjectParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 3:30 PM
 * ticket: AMS-12934
 * description: DatabaseTask
 **/
@Service
@Slf4j
public class DatabaseTask {
    @Autowired(required = false)
    private MovieInfoMapper movieInfoMapper;
    @Autowired(required = false)
    private BannerMapper bannerMapper;

    @Transactional
    public boolean insertAll() {
        boolean flag = true;
        List<MovieInfo> movieInfoList = MovieObjectParser.getMovieFromJson();
        List<Banner> bannerList = MovieObjectParser.getBannerFromJson();
        try {
            if (!CollectionUtils.isEmpty(movieInfoList)) {
                movieInfoMapper.deleteAll();
                movieInfoMapper.replace(movieInfoList);
            }
            if (!CollectionUtils.isEmpty(bannerList)) {
                bannerMapper.deleteAll();
                bannerMapper.replace(bannerList);
            }

        }catch (Exception ex) {
            log.error("数据库插入异常: [{}]", ex.getMessage());
            flag=false;
        }
        return flag;
    }
}
