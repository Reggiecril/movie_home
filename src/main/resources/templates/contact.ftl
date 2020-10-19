<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Contact</title>
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
        <section class="centered">
            <h3>Contact</h3>
            <div class="contact">
                <form action="#" id="myForm" method="POST">
                    <label for="name">Name:</label>
                    <input id="name" name="name" type="text">

                    <label for="email">Email:</label>
                    <input id="email" name="email" type="text">

                    <label for="message">Message:</label>
                    <textarea id="message" name="message"></textarea>

                    <input name="submit" type="submit" value="SEND">
                </form>

                <span class="success">Message sent succesfully</span>
                <span class="error">Failed sending message</span>
            </div>
</div>
</section>

</main>

<#include "footer.ftl">

</div>
</body>
</html>