var danni;
function getDetails(compHide, compShow) {
    for (var i = 0; i < compHide.length; i++) {
        $(compHide[i]).hide();
    }
    $(compShow).show();
}

function mainPage() {
    var url = "/index.html";
    $(location).attr('href', url);    
}

function getInkass() {
    $('#bodyInkass').html('');
    useAjax("inkassator", {}, function valid() {
        for (var i = 0; i < danni.length; i++) {
            var row = "<tr ><td>" + danni[i].id + "</td><td>" +
                danni[i].name + "</td><td>" + danni[i].age +
                "</td></tr>";
            $('#bodyInkass').append(row);
        }
        $('#tablInkassator').show();
    });
}

function dropAllInkass() {
    useAjax("dropAllInkassator", {}, function valid() {
        $('#bodyInkass').html('');
        $('#modalDropAllInkass').modal('show');
    });
}

function addInkass() {
    var name=document.getElementById("inkassatorName").value;
    var age=document.getElementById("inkassatorAge").value;
    $('#bodyInkass').html('');
    useAjax("inkassator", {name:name, age:age}, function valid() {
        for (var i = 0; i < danni.length; i++) {
            var row = "<tr ><td>" + danni[i].id + "</td><td>" +
                danni[i].name + "</td><td>" + danni[i].age +
                "</td></tr>";
            $('#bodyInkass').append(row);
        }
        getDetails(['#formAddInkassator'],'#tablInkassator')
    });
}

function Registration(btn) {
    var user = document.getElementById("user_name_reg").value;
    var email = document.getElementById("user_email_reg").value;
    var password1 = document.getElementById("user_password_reg1").value;
    var password2 = document.getElementById("user_password_reg2").value;
    if (password1 == password2) {
        $("#" + btn.id).append("  <i class='fa fa-spinner fa-spin'>");
        useAjax("reg", {name: user, email: email, password: password1}, function valid() {
            var url = "/startPage.html";
            $(location).attr('href', url);
        });
    } else {
        console.log("Указанные пароли не совпадают!");
        $("#bad_password").show();
        $("#" + btn.id).html("Регистрация");
    }
}

function Login(btn) {
    var user = document.getElementById("user_name").value;
    var password = document.getElementById("user_password").value;

    $("#" + btn.id).append("  <i class='fa fa-spinner fa-spin'>");
    useAjax("login", {name: user, password: password}, function valid() {
        console.log("test4");
        console.log(danni.isValid);
        var isValid = danni.isValid;
        if (isValid) {
            var url = "/startPage.html";
            $(location).attr('href', url);
        } else {
            $("#bad_login").show();
            $("#" + btn.id).html("Вход");
        }
    })
}

function useAjax(type, data, callBack) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/' + type,
        dataType: "json",
        data: data,
        success: function (data) {
            danni = JSON.parse(JSON.stringify(data));
            callBack(data);
        }
    });
}
