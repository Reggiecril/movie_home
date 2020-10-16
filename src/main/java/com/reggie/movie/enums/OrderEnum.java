package com.reggie.movie.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author: yuncheng.xie
 * @date: 9/29/20 9:31 AM
 * ticket: AMS-12934
 * description: OrderEnum
 **/
@Getter
public enum OrderEnum {
    PUBLISH_YEAR(0, "PUBLISH_YEAR DESC"),
    ADD_DATE(1, "ADD_DATE DESC"),
    HOT_RANK(2, "HOT_RANK DESC"),
    INTEREST(3, "INTEREST DESC"),
    UNLIKE(4, "UNLIKE DESC"),
    REVIEW(5, "REVIEW DESC");
    private Integer code;
    private String name;

    OrderEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static OrderEnum getOrderByCode(Integer code){
        return Arrays.stream(OrderEnum.values()).filter(x->x.code.equals(code)).findFirst().orElse(OrderEnum.PUBLISH_YEAR);
    }

}
