package com.reggie.movie.service.task;

import com.reggie.movie.mapper.MovieInfoMapper;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.parse.MovieObjectParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public boolean insertAll(){
        boolean flag=true;
        List<MovieInfo> movieInfoList= MovieObjectParser.getMovieFromJson();
        try {
            movieInfoMapper.deleteAll();
            movieInfoMapper.replace(movieInfoList);
        }catch (Exception ex) {
            log.error("数据库插入异常: [{}]", ex.getMessage());
            flag=false;
        }
        return flag;
    }
}
