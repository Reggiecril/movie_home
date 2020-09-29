package com.reggie.movie.model;

import lombok.Data;

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
}
