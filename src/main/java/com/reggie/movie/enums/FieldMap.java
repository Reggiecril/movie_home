package com.reggie.movie.enums;

import lombok.Data;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 5:34 PM
 * ticket: AMS-12934
 * description: FieldMap
 **/

public enum FieldMap {
    REGION("region"),
    LANGUAGE("language"),
    CATEGORY("category");
    private String attribution;
    FieldMap(String attribution) {
        this.attribution=attribution;
    }

    public String getAttribution() {
        return attribution;
    }
}
