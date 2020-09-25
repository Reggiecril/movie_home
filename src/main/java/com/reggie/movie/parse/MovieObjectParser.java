package com.reggie.movie.parse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.reggie.movie.model.MovieInfo;
import com.reggie.movie.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 1:46 PM
 * ticket: AMS-12934
 * description: MovieObjectParser
 **/
@Slf4j
public class MovieObjectParser {
    public static List<MovieInfo> getMovieFromJson(){
        InputStream is = MovieObjectParser.class.getClassLoader().getResourceAsStream("json/movie_detail.json");
        try {
            List<MovieInfo> list = JsonUtil.MAPPER.readValue(is, new TypeReference<List<MovieInfo>>() {
            });
            System.out.println(list);
            return list;
        } catch (IOException ignored) {
            log.error("[{}] file read failed","json/movie_detail.json");
        }
        return null;
    }

    public static void main(String[] args) {
        MovieObjectParser.getMovieFromJson();
    }
}
