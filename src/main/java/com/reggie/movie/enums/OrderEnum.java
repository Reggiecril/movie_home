package com.reggie.movie.enums;

import java.util.Arrays;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 9:31 AM
 * ticket: AMS-12934
 * description: OrderEnum
 **/
public enum OrderEnum {
    PUBLISH_YEAR(0),
    ADD_DATE(1),
    HOT_RANK(2),
    INTEREST(3),
    UNLIKE(4),
    REVIEW(5);
    private Integer code;

    OrderEnum(Integer code) {
        this.code = code;
    }

    public static OrderEnum getOrderByCode(Integer code){
        return Arrays.stream(OrderEnum.values()).filter(x->x.code.equals(code)).findFirst().orElse(OrderEnum.PUBLISH_YEAR);
    }

}
