package com.reggie.movie.request;

import lombok.Data;

/**
 * @author yuncheng.xie
 * @date 10/19/20 7:02 PM
 * ticket: AMS-11595
 * description: Attribution
 */
@Data
public class Attribution {
    private String region;
    private String language;
    private String category;
    private String publicYear;
    private String channel;
    private Integer pageNum;
}
