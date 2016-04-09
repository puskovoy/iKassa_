$(document).ready(function () {

    $(".autth_buttons").click(function () {
        $(this).next().slideToggle();
    });
    $(".main_menu_btn").click(function () {
        $(".main_mnu ul").slideToggle();
    });

    //Таймер обратного отсчета
    //Документация: http://keith-wood.name/countdown.html
    //<div class="countdown" date-time="2015-01-07"></div>
    var austDay = new Date($(".countdown").attr("date-time"));
    $(".countdown").countdown({until: austDay, format: 'yowdHMS'});

    //Попап менеджер FancyBox
    //Документация: http://fancybox.net/howto
    //<a class="fancybox"><img src="image.jpg" /></a>
    //<a class="fancybox" data-fancybox-group="group"><img src="image.jpg" /></a>
    $(".fancybox").fancybox();

    //Навигация по Landing Page
    //$(".top_mnu") - это верхняя панель со ссылками.
    //Ссылки вида <a href="#contacts">Контакты</a>
    $(".top_mnu").navigation();

    //Добавляет классы дочерним блокам .block для анимации
    //Документация: http://imakewebthings.com/jquery-waypoints/
    $(".block").waypoint(function (direction) {
        if (direction === "down") {
            $(".class").addClass("active");
        } else if (direction === "up") {
            $(".class").removeClass("deactive");
        }
    }, {offset: 100});

    //Плавный скролл до блока .div по клику на .scroll
    //Документация: https://github.com/flesler/jquery.scrollTo
    $("a.scroll").click(function () {
        $.scrollTo($(".div"), 800, {
            offset: -90
        });
    });

    //Каруселька
    //Документация: http://owlgraphic.com/owlcarousel/
    var owl = $(".carousel");
    owl.owlCarousel({
        items: 2,
        autoHeight: true
    });
    owl.on("mousewheel", ".owl-wrapper", function (e) {
        if (e.deltaY > 0) {
            owl.trigger("owl.prev");
        } else {
            owl.trigger("owl.next");
        }
        e.preventDefault();
    });
    $(".next_button").click(function () {
        owl.trigger("owl.next");
    });
    $(".prev_button").click(function () {
        owl.trigger("owl.prev");
    });

    //Кнопка "Наверх"
    //Документация:
    //http://api.jquery.com/scrolltop/
    //http://api.jquery.com/animate/
    $("#top").click(function () {
        $("body, html").animate({
            scrollTop: 0
        }, 800);
        return false;
    });

    //Аякс отправка форм
    //Документация: http://api.jquery.com/jquery.ajax/
    $("#callback").submit(function () {
        $.ajax({
            type: "GET",
            url: "mail.php",
            data: $("#callback").serialize()
        }).done(function () {
            alert("Спасибо за заявку!");
            setTimeout(function () {
                $.fancybox.close();
            }, 1000);
        });
        return false;
    });


});

function hideLogo() {
    var sht;
    /* $.fancybox.close();*/
    $(".logo").hide();
    $(".top_contacts").hide();
    $(".slider_container").hide();
    $(".order").hide();
    $(".blog_item").hide();
    console.log("test");

    function testAjax(callback) {
        console.log("test2");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/login',
            dataType: "json",//если подставить html тогда success: function (data) - выполнится.
            data: ({name:'start',number:5}),

            success: function (data) {
                console.log("test3");
                sht = JSON.parse(JSON.stringify(data));
                callback(data);
                console.log(sht.user.name);
            }
        });
    }

    testAjax(function testHTML() {
        console.log("test4");
        $("#information2").html(sht.user);
    });
}
function showLogo() {
    /* $.fancybox.close();*/
    $(".logo").show();
    $(".top_contacts").show();
    $(".slider_container").show();
    $(".order").show();
    $(".blog_item").show();

}

