<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${movieInfo.name}</title>
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


    <main class="content">
        <div class="single">
            <section class="movie" style="opacity:1;background-color: #cecece ">
                <img src="/images/${movieInfo.image}.jpeg">
                <ul>
                    <li style="color: #2d2d2d">${movieInfo.name}</li>
                    <li>${movieInfo.brief}</li>
                </ul>
            </section>
            <section class="links" style="opacity:1;background-color: #cecece ">
                <div style="padding-top: 20px;padding-bottom: 20px;margin-bottom: 10px;border-bottom: #202020 solid 1px;line-height: 15px;">
                    <h3 style="color: #2d2d2d">详细信息</h3>
                </div>
                <ul class="dlinks">
                    <li>
                        <div style="display:inline-block;">
                            <p>分类：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.category}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>频道：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.channel}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>年份：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.publishYear}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>添加：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.addDate}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>区域：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.region}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>语言：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.language}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>导演：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.director}</p>
                        </div>
                    </li>
                    <li>
                        <div style="display:inline-block;">
                            <p>主演：</p>
                        </div>
                        <div style="display:inline-block;">
                            <p>${movieInfo.actor}</p>
                        </div>
                    </li>
                </ul>
            </section>

            <section class="related" style="opacity:1;background-color: #cecece ">
                <div style="padding-top: 20px;padding-bottom: 20px;margin-bottom: 10px;border-bottom: #202020 solid 1px;line-height: 15px;">
                    <h3 style="color: #2d2d2d">相关影片</h3>
                </div>
                <#list relatedMovies as movie>
                    <div class="relatemovie">
                        <a href="/detail?id=${movie.duonaoId}"><img src="/images/${movie.image}.jpeg" width="250px"
                                                                    height="280px"></a>
                        <a href="/detail?id=${movie.duonaoId}"><span class="relatedname">${movie.name}</span></a>
                    </div>
                </#list>
            </section>
        </div>
    </main>
    <#include "footer.ftl">


</div>
</body>
</html>