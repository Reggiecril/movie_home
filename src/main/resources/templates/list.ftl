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
<div class="wrapper">

    <#include "header.ftl">

    <main class="content" style="margin-top: 80px">
        <section>
            <div class="category">

                <#list attrsMap?keys as itemKey>
                    <dl>
                        <dt><a href="#">${itemKey}<i> &gt;</i></a></dt>
                        <#assign item = attrsMap[itemKey]>
                        <dd>
                            <#list item as itemValue>
                                <a href="${itemValue}">${itemValue}</a>
                            </#list>
                        </dd>
                    </dl>
                </#list>

            </div>
        </section>
        <section class="centered">
            <h3>Most Watched Movies</h3>
            <div class="movies">
                <#list movieList.list as movie>
                    <div class="mov">
                        <a href="detail?id=${movie.duonaoId}">
                            <img src="/images/${movie.image}.jpeg">
                            <h2 class="movietitle">${movie.name}</h2>
                        </a>
                    </div>
                </#list>
            </div>
            <nav class="pagination">
                <ul>
                    <li>
                        <a href="<#if RequestParameters['pageNume']??>&<#else>?</#if>pageNum=${movieList.prePage}">Prev</a>
                    </li>
                    <#list movieList.navigatepageNums as pages>
                        <li><a <#if pages==movieList.pageNum>
                                class="menuactive"
                            </#if>
                                    href="<#if RequestParameters['pageNume']??>&<#else>?</#if>pageNum=${pages}">${pages}</a>
                        </li>
                    </#list>

                    <li>
                        <a href="<#if RequestParameters['pageNume']??>&<#else>?</#if>pageNum=${movieList.nextPage}">Next</a>
                    </li>
                </ul>
            </nav>
        </section>
    </main>
    <#include "footer.ftl">
</div>
</body>
</html>