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
        ;
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
   /* $.fancybox.close();*/
    $(".logo").hide();
    $(".top_contacts").hide();
    $(".slider_container").hide();
    $(".order").hide();
    $(".blog_item").hide();

}
function showLogo() {
    /* $.fancybox.close();*/
    $(".logo").show();
    $(".top_contacts").show();
    $(".slider_container").show();
    $(".order").show();
    $(".blog_item").show();

}

function allall() {
    var sht;

    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServletAll',
            dataType: "json",
            data: {},

            success: function (data) {
                sht = JSON.parse(JSON.stringify(data));
                callback(data);

            }
        });
    };
    respoajax(function allhtml() {

        for (var i = 0; i < sht.count; i++) {
            var row ="<tr ><td>"+sht.name[i]+"</td><td>"+sht.number[i]+"</td><td>"+sht.quad[i]+"</td><td>" +sht.thick[i]+"</td><td>"+sht.material[i]+"</td><td>"+sht.densities[i]+"</td><td>"+sht.price[i]+"</td></tr>";
            $('#bodyTabl').append(row);
        }

    });
};
//этот скрипт выводит таблицу
function calcPrice() {
    var name = document.getElementById("name").value;
    var number = document.getElementById("number").value;
    var quad = document.getElementById("quad").value;
    var thick = document.getElementById("thick").value;
    var density = document.getElementById("density").value;
    var gridRadios = document.getElementById("gridRadios").value;
    var sht;


    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServlet',
            dataType: "json",
            data: {
                name: name,
                number: number,
                quad: quad,
                thick: thick,
                density: density,
                gridRadios: gridRadios
            },
            success: function (data) {
                sht = JSON.parse(JSON.stringify(data))
                callback(data);
                console.log(sht.price);
            }
        });
    };
    respoajax(function allhtml() {
        $('#price').html(sht.price + 'грн');
        $('#myModal').modal('show');
    });

};