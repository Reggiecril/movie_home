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

    <header class="header">
        <figure class="logo"><a href="/"><img alt="Logo"
                                              src="/icons/logo.png"/>

        </a></figure>
        <nav class="menu">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a>Genres</a>
                    <ul>
                        <li><a href="genre.html">Action</a></li>
                        <li><a href="genre.html">Comedy</a></li>
                        <li><a href="genre.html">Drama</a></li>
                        <li><a href="genre.html">Romance</a></li>
                    </ul>
                </li>
                <li><a>Year</a>
                    <ul>
                        <li><a href="year.html">2017</a></li>
                        <li><a href="year.html">2016</a></li>
                        <li><a href="year.html">2015</a></li>
                        <li><a href="year.html">2014</a></li>
                    </ul>
                </li>
                <li><a>Language</a>
                    <ul>
                        <li><a href="language.html">English</a></li>
                        <li><a href="language.html">German</a></li>
                    </ul>
                </li>
                <li><a href="mostwatched.html">Most Watched</a></li>
                <li class="mobsearch">
                    <form class="mobform">
                        <input class="mobsearchfield" name="s" placeholder="Search..." type="text"/>
                        <input class="mobsearchsubmit" type="submit" value=""/>
                    </form>
                </li>
            </ul>
        </nav>
        <form class="search">
            <input class="searchfield" name="s" placeholder="Search..." type="text">
            <input class="searchsubmit" type="submit" value="">
        </form>

        <div class="toggle"><img src="/icons/menu.svg"></div>
    </header>
    <!-- Swiper -->
    <div class="homeslider">
        <div class="swiper-container">

            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <img src="/slider/poster2.jpg">
                    <div class="caption">
                        <div class="captioninside">
                            <h3>Movie Title</h3>
                            <p>Lorem ipsum dolor siamet</p>
                            <a class="playbutton" href="single.html">Play</a>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide">
                    <img src="/slider/poster1.jpg">
                    <div class="caption">
                        <div class="captioninside">
                            <h3>Movie Title 2</h3>
                            <p>Lorem ipsum dolor siamet</p>
                            <a class="playbutton" href="single.html">Play</a>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide">
                    <img src="/slider/poster2.jpg">
                    <div class="caption">
                        <div class="captioninside">
                            <h3>Movie Title 3</h3>
                            <p>Lorem ipsum dolor siamet</p>
                            <a class="playbutton" href="single.html">Play</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
        </div>
    </div>

    <main class="content">
        <section class="panel">
            <h2>Recently Added</h2>
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
            <h2>Most Watched</h2>
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
            <h2>Most Reviewed</h2>
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
            <h2>Most Rated</h2>
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
            <h2>Most Interested</h2>
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

    <footer class="footer">
        <div class="copyright"><p>Copyright &copy 2017 www.focusoncode.com</p></div>
        <div class="footermenu">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="terms.html">Terms and conditions</a></li>
            </ul>
        </div>
        <div class="tags">
            <ul>
                <li>Watch Free Movies Trailers</li>
                <li>Movie Trailers</li>
                <li>English Subtitled Movies Trailers</li>
                <li>Latest Movies Trailers</li>
                <li>New Movies Trailers</li>

            </ul>
        </div>

    </footer>

    <!-- Swiper JS -->
    <script src="/js/swiper.min.js"></script>

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