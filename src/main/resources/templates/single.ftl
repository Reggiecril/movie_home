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

    <header class="header">
        <figure class="logo"><a href="/index"><img alt="Logo"
                                                   src="/icons/logo.png">
        </figure>
        </a>
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
                        <input class="mobsearchfield" name="s" placeholder="Search..." type="text">
                        <input class="mobsearchsubmit" type="submit" value="">
                    </form>
                </li>
            </ul>
        </nav>
        <form class="search">
            <input class="searchfield" name="s" placeholder="Search..." type="text">
            <input class="searchsubmit" type="submit" value="">
        </form>

        <div class="toggle"><img src="/img/menu.svg"></div>
    </header>

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
                        <div style="width: 5%;float: left">
                            <p>添加：</p>
                        </div>
                        <div style="width: 90%;float: right">
                            <p style="float: left">${movieInfo.addDate}</p>
                        </div>
                    </li>
                    <li>
                        <div style="width: 5%;float: left">
                            <p>区域：</p>
                        </div>
                        <div style="width: 90%;float: right">
                            <p style="float: left">${movieInfo.region}</p>
                        </div>
                    </li>
                    <li>
                        <div style="width: 5%;float: left">
                            <p>语言：</p>
                        </div>
                        <div style="width: 90%;float: right">
                            <p style="float: left">${movieInfo.language}</p>
                        </div>
                    </li>
                    <li>
                        <div style="width: 5%;float: left">
                            <p>导演：</p>
                        </div>
                        <div style="width: 90%;float: right">
                            <p style="float: left">${movieInfo.director}</p>
                        </div>
                    </li>
                    <li>
                        <div style="width: 5%;float: left">
                            <p>主演：</p>
                        </div>
                        <div style="width: 90%;float: right">
                            <p style="float: left">${movieInfo.actor}</p>
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

    <footer class="footer">
        <div class="copyright"><p>Copyright &copy 2017 www.reggiecril.com</p></div>
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

</div>
</body>
</html>