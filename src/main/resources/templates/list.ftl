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

    <main class="content">
        <section>
            <div class="category">
                <dl>
                    <#list attrsMap?keys as itemKey>
                        <dt><a href="#">${itemKey}<i> &gt;</i></a></dt>
                        <#assign item = map[itemKey]>
                        <dd>
                            <#list item as itemValue>//根据key遍历对应的list
                                <a href="${itemValue}">${itemValue}</a>
                            </#list>
                        </dd>
                    </#list>
                </dl>

            </div>
        </section>
        <section class="centered">
            <h3>Most Watched Movies</h3>
            <div class="movies">
                <div class="mov">
                    <a href="single.html">
                        <img src="/images/9.jpg">
                        <h2 class="movietitle">The Space Between Us</h2>
                    </a>
                </div>
            </div>
            <nav class="pagination">
                <ul>
                    <li><a href="#">Prev</a></li>
                    <li><a href="#">1</a></li>
                    <li><a class="menuactive" href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">...</a></li>
                    <li><a href="#">20</a></li>
                    <li><a href="#">21</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </nav>
        </section>
    </main>
    <#include "footer.ftl">
</div>
</body>
</html>