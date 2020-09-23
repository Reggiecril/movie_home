package com.reggie.movie.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.reggie.movie.util.JsonUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: yuncheng.xie
 * @date: 9/22/20 5:35 PM
 * ticket: AMS-11777
 * description:
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> chineseMap = new ImmutableMap.Builder<String, String>()
                .put("语言", "language")
                .put("年份", "publishYear")
                .put("图片", "image")
                .put("简介", "brief")
                .put("评论", "review")
                .put("添加", "addDate")
                .put("踩", "unlike")
                .put("区域", "region")
                .put("热度排名", "hotRank")
                .put("主演", "actor")
                .put("频道", "channel")
                .put("电影名", "name")
                .put("导演", "director")
                .put("赞", "like")
                .put("分类", "category")
                .build();
        InputStream is = Test.class.getClassLoader().getResourceAsStream("json/movie_detail.json");
        try {
            List<Map<String, Object>> list = JsonUtil.MAPPER.readValue(is, new TypeReference<List<Map<String, Object>>>() {
            });
            Map<String, String> set = new HashMap<>();
            for (Map<String, Object> map : list) {
                set.putAll(map.keySet().stream().collect(Collectors.toMap(x -> x, x -> "1")));
            }
            System.out.println(JsonUtil.toJson(set));
        } catch (IOException e) {
        }
    }
}
