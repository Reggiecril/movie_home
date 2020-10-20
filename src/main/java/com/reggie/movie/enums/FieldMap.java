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
    REGION("region"),
    LANGUAGE("language"),
    CATEGORY("category"),
    PUBLISH_YEAR("publishYear"),
    CHANNEL("channel");
    private String attribution;

    FieldMap(String attribution) {
        this.attribution = attribution;
    }
}
