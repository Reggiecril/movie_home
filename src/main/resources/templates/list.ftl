<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Most Watched</title>
    <meta content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" name="viewport">

    <!-- Link Swiper's CSS -->
    <link href="/css/swiper.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet">

    <script src="/js/jquery-3.1.1.min.js"></script>
    <script src="/js/script.js"></script>


    <!-- Demo styles -->
    <style>


    </style>
</head>
<body>
<#assign urlPath=url>
<#if params??&&(params?size>0)>
    <#assign urlPath=url+'?'>
</#if>

<div class="wrapper">

    <#include "header.ftl">

    <main class="content" style="margin-top: 80px">
        <section>
            <div class="category">
                <dl>
                    <dt><a href="#">频道<i> &gt;</i></a></dt>
                    <dd>
                        ${urlPath}
                        <a href="${urlPath?replace('(^|\\\\?|&)channel=([^&]*)','','r')+"channel=All"}">全部</a>
                        <#list attrsMap['channel'] as category>
                            <#if params['channel']??>
                                <a href="${urlPath?replace('(^|\\\\?|&)channel=([^&]*)','','r')+"channel="+category}">${category}</a>
                            <#else>
                                <a href="${urlPath+params['channel']}">${category}</a>
                            </#if>
                        </#list>
                    </dd>
                </dl>
                <dl>
                    <dt><a href="#">区域<i> &gt;</i></a></dt>
                    <dd>
                        <a href="${urlPath?replace('(^|\\\\?|&)region=([^&]*)','','r')+"region=All"}">全部</a>
                        <#list attrsMap['region'] as category>
                            <a href="${urlPath?replace('(^|\\\\?|&)region=([^&]*)','','r')+"region="+category}">${category}</a>
                        </#list>
                    </dd>
                </dl>
                <dl>
                    <dt><a href="#">语言<i> &gt;</i></a></dt>
                    <dd>
                        <a href="${urlPath?replace('(^|\\\\?|&)language=([^&]*)','','r')+"language=All"}">全部</a>
                        <#list attrsMap['language'] as category>
                            <a href="${urlPath?replace('(^|\\\\?|&)language=([^&]*)','','r')+"language="+category}">${category}</a>
                        </#list>
                    </dd>
                </dl>
                <dl>
                    <dt><a href="#">分类<i> &gt;</i></a></dt>
                    <dd>
                        <a href="${urlPath?replace('(^|\\\\?|&)category=([^&]*)','','r')+"category=All"}">全部</a>
                        <#list attrsMap['category'] as category>
                            <a href="${urlPath?replace('(^|\\\\?|&)category=([^&]*)','','r')+"category="+category}">${category}</a>
                        </#list></dd>
                </dl>
                <dl>
                    <dt><a href="#">年份<i> &gt;</i></a></dt>
                    <dd>
                        <a href="${urlPath?replace('(^|\\\\?|&)publishYear=([^&]*)','','r')+"publishYear=All"}">全部</a>
                        <#list attrsMap['publishYear'] as category>
                            <a href="${urlPath?replace('(^|\\\\?|&)publishYear=([^&]*)','','r')+"publishYear="+category}">${category}</a>
                        </#list></dd>
                </dl>

            </div>
        </section>
        <#--        <section class="centered">-->
        <#--            <h3>Most Watched Movies</h3>-->
        <#--            <div class="movies">-->
        <#--                <#list movieList.list as movie>-->
        <#--                    <div class="mov">-->
        <#--                        <a href="detail?id=${movie.duonaoId}">-->
        <#--                            <img src="/images/${movie.image}.jpeg">-->
        <#--                            <h2 class="movietitle">${movie.name}</h2>-->
        <#--                        </a>-->
        <#--                    </div>-->
        <#--                </#list>-->
        <#--            </div>-->
        <#--            <nav class="pagination">-->
        <#--                <ul>-->
        <#--                    <li>-->
        <#--                        <a href="<#if RequestParameters['pageNume']??>&<#else>?</#if>pageNum=${movieList.prePage}">Prev</a>-->
        <#--                    </li>-->
        <#--                    <#list movieList.navigatepageNums as pages>-->
        <#--                        <li><a <#if pages==movieList.pageNum>-->
        <#--                                class="menuactive"-->
        <#--                            </#if>-->
        <#--                                    href="<#if RequestParameters['pageNume']??>&<#else>?</#if>pageNum=${pages}">${pages}</a>-->
        <#--                        </li>-->
        <#--                    </#list>-->

        <#--                    <li>-->
        <#--                        <a href="<#if RequestParameters['pageNume']??>&<#else>?</#if>pageNum=${movieList.nextPage}">Next</a>-->
        <#--                    </li>-->
        <#--                </ul>-->
        <#--            </nav>-->
        <#--        </section>-->
    </main>
    <#include "footer.ftl">
</div>
</body>
<script>

    $(document).ready(function () {
        var url = window.location.href;
        console.log(url);
    });
</script>
</html>