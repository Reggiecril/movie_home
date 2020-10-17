package com.reggie.movie.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: yuncheng.xie
 * @date: 9/25/20 1:41 PM
 * ticket: AMS-12934
 * description: MovieInfo
 **/
@Data
public class MovieInfo {
    private String duonaoId;
    private String language;
    private Integer publishYear;
    private String image;
    private String brief;
    private Integer review;
    private LocalDate addDate;
    private Integer unlike;
    private String region;
    private Integer hotRank;
    private String actor;
    private String channel;
    private String name;
    private String director;
    private Integer interest;
    private String category;
    private Double rate;

    public void setRate() {
        this.rate = new BigDecimal(rate * 10).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
