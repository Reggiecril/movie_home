package com.reggie.movie.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 2:44 PM
 * ticket: AMS-12934
 * description: MovieBrief
 **/
@Data
public class MovieBrief {
    private String duonaoId;
    private String image;
    private Integer hotRank;
    private String name;
    private Double rate;

    public Double getRate() {
        return new BigDecimal(rate * 10).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
