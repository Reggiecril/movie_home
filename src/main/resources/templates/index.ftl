<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Movies</title>
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
    <!-- Swiper -->
    <div class="homeslider">
        <div class="swiper-container">

            <div class="swiper-wrapper">
                <#list bannerList as slide>
                    <div class="swiper-slide">
                        <img src="banner_image/${slide.image}">
                        <div class="caption">
                            <div class="captioninside">
                                <h3>${slide.title}</h3>
                                <a class="playbutton" href="/detail?id=${slide.id}">Enter</a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
        </div>
    </div>

    <main class="content">
        <section class="panel">
            <h2>最近添加</h2>
            <div class="recentslider">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <#list recentBriefs as movie>
                            <div class="swiper-slide">
                                <a href="/detail?id=${movie.duonaoId}">
                                    <img src="/images/${movie.image}.jpeg" width="250px" height="350px">
                                    <h3 class="hometitle">${movie.name}</h3>
                                </a>
                            </div>
                        </#list>
                    </div>
                    <div class="nextdirection recent-next"><img
                                src="/icons/right-arrow.svg"></div>
                    <div class="leftdirection recent-prev"><img
                                src="/icons/left-arrow.svg"></div>
                </div>
            </div>
        </section>

        <section class="panel">
            <h2>最多播放</h2>
            <div class="mostslider">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <#list hotBriefs as movie>
                            <div class="swiper-slide">
                                <a href="/detail?id=${movie.duonaoId}">
                                    <img src="/images/${movie.image}.jpeg" width="250px" height="350px">
                                    <h3 class="hometitle">${movie.name}</h3>
                                </a>
                            </div>
                        </#list>
                    </div>
                    <div class="nextdirection most-next"><img
                                src="/icons/right-arrow.svg"></div>
                    <div class="leftdirection most-prev"><img
                                src="/icons/left-arrow.svg"></div>
                    <!-- Add Pagination -->
                </div>
            </div>
        </section>

        <section class="panel">
            <h2>最多点评</h2>
            <div class="topslider">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <#list mostReviewsBriefs as movie>
                            <div class="swiper-slide">
                                <a href="/detail?id=${movie.duonaoId}">
                                    <img src="/images/${movie.image}.jpeg" width="250px" height="350px">
                                    <h3 class="hometitle">${movie.name}</h3>
                                </a>
                            </div>
                        </#list>
                    </div>
                    <div class="nextdirection top-next"><img
                                src="/icons/right-arrow.svg"></div>
                    <div class="leftdirection top-prev"><img
                                src="/icons/left-arrow.svg"></div>
                    <!-- Add Pagination -->
                </div>
            </div>
        </section>

        <section class="panel">
            <h2>最高评分</h2>
            <div class="topslider">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <#list rateBriefs as movie>
                            <div class="swiper-slide">
                                <a href="/detail?id=${movie.duonaoId}">
                                    <img src="/images/${movie.image}.jpeg" width="250px" height="350px">
                                    <h3 class="hometitle">${movie.name}</h3>
                                </a>
                            </div>
                        </#list>
                    </div>
                    <div class="nextdirection top-next"><img
                                src="/icons/right-arrow.svg"></div>
                    <div class="leftdirection top-prev"><img
                                src="/icons/left-arrow.svg"></div>
                    <!-- Add Pagination -->
                </div>
            </div>
        </section>

        <section class="panel">
            <h2>最多点赞</h2>
            <div class="topslider">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <#list interestBriefs as movie>
                            <div class="swiper-slide">
                                <a href="/detail?id=${movie.duonaoId}">
                                    <img src="/images/${movie.image}.jpeg" width="250px" height="350px">
                                    <h3 class="hometitle">${movie.name}</h3>
                                </a>
                            </div>
                        </#list>
                    </div>
                    <div class="nextdirection top-next"><img
                                src="/icons/right-arrow.svg"></div>
                    <div class="leftdirection top-prev"><img
                                src="/icons/left-arrow.svg"></div>
                    <!-- Add Pagination -->
                </div>
            </div>
        </section>

    </main>
    <#include "footer.ftl">


    <!-- Swiper JS -->
    <script src="/js/swiper.js"></script>

    <!-- Initialize Swiper -->
    <script>
        $(document).ready(function () {


            var swiper = new Swiper('.homeslider > .swiper-container', {
                pagination: '.swiper-pagination',
                paginationClickable: true,
                preventClicks: false,
                preventClicksPropagation: false,
                effect: 'fade',
                breakpoints: {
                    320: {
                        height: 200
                    },

                    480: {
                        height: 300
                    },

                    768: {
                        height: 400
                    },
                    1024: {
                        height: 500
                    }
                }
            });

            var recentswiper = new Swiper('.recentslider > .swiper-container', {
                nextButton: '.recent-next',
                prevButton: '.recent-prev',
                slidesPerView: 8,
                paginationClickable: true,
                preventClicks: false,
                preventClicksPropagation: false,
                spaceBetween: 10,
                breakpoints: {
                    320: {
                        slidesPerView: 3,
                        spaceBetween: 5
                    },

                    480: {
                        slidesPerView: 3,
                        spaceBetween: 5
                    },

                    768: {
                        slidesPerView: 5,
                        spaceBetween: 5
                    },
                    1024: {
                        slidesPerView: 6,
                        spaceBetween: 10
                    }
                }
            });

            var mostswiper = new Swiper('.mostslider > .swiper-container', {
                nextButton: '.most-next',
                prevButton: '.most-prev',
                slidesPerView: 8,
                paginationClickable: true,
                preventClicks: false,
                preventClicksPropagation: false,
                spaceBetween: 10,
                breakpoints: {
                    320: {
                        slidesPerView: 3,
                        spaceBetween: 5
                    },

                    480: {
                        slidesPerView: 3,
                        spaceBetween: 5
                    },

                    768: {
                        slidesPerView: 5,
                        spaceBetween: 5
                    },
                    1024: {
                        slidesPerView: 6,
                        spaceBetween: 10
                    }
                }
            });

            var topswiper = new Swiper('.topslider > .swiper-container', {
                nextButton: '.top-next',
                prevButton: '.top-prev',
                slidesPerView: 8,
                paginationClickable: true,
                preventClicks: false,
                preventClicksPropagation: false,
                spaceBetween: 10,
                breakpoints: {
                    320: {
                        slidesPerView: 3,
                        spaceBetween: 5
                    },

                    480: {
                        slidesPerView: 3,
                        spaceBetween: 5
                    },

                    768: {
                        slidesPerView: 5,
                        spaceBetween: 5
                    },
                    1024: {
                        slidesPerView: 6,
                        spaceBetween: 10
                    }
                }
            });

        });


    </script>


</div>
</body>
</html>