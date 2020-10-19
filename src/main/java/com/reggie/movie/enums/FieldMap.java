package com.reggie.movie.enums;

import lombok.Getter;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 5:34 PM
 * ticket: AMS-12934
 * description: FieldMap
 **/
@Getter
public enum FieldMap {
    REGION("区域", "region"),
    LANGUAGE("语言", "language"),
    CATEGORY("分类", "category"),
    PUBLISH_YEAR("年份", "publishYear"),
    CHANNEL("频道", "channel");
    private String attribution;
    private String chineseName;

    FieldMap(String chineseName, String attribution) {
        this.chineseName = chineseName;
        this.attribution = attribution;
    }
}
