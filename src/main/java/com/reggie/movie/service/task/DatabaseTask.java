package com.reggie.movie.service.task;

import com.reggie.movie.model.MovieInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 3:30 PM
 * ticket: AMS-12934
 * description: DatabaseTask
 **/
@Service
public class DatabaseTask {
    @Transactional("movieTransaction")
    public void insertAll(List<MovieInfo> movieInfoList){

    }
}
