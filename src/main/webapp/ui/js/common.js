function showLogo() {
    $("#name_company").show();
    $("#main_content").show();
    $("#form_enter").hide();
    $("#form_registration").hide();
}

function getdetails(obj) {
    switch (obj.id) {
        case "btn_enter":
            $("#name_company").hide();
            $("#main_content").hide();
            $("#form_registration").hide();
            $("#form_enter").show();
            break;
        case "btn_registration":
            $("#name_company").hide();
            $("#main_content").hide();
            $("#form_enter").hide();
            $("#form_registration").show();
            break;
        default:
            break
    }
}

function Login() {
    var sht;
    var user = document.getElementById("user_name").value;
    var password = document.getElementById("user_password").value;

    function getLogin(callback) {
        console.log(user);
        console.log(password);
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/login',
            dataType: "json",
            data: ({name: user, password: password}),
            success: function (data) {
                sht = JSON.parse(JSON.stringify(data));
                callback(data);
            }
        });
    }

    getLogin(function valid() {
        console.log("test4");
        console.log(sht.isValid);
        var isValid = sht.isValid;
        if (isValid) {
            $("#btn_enter").hide();
            $("#btn_registration").hide();
            showLogo();
        } else {
            $("#bad_login").show();
        }
    });
}

function Registration() {
    var sht;
    var user = document.getElementById("user_name_reg").value;
    var email = document.getElementById("user_email_reg").value;
    var password1 = document.getElementById("user_password_reg1").value;
    var password2 = document.getElementById("user_password_reg2").value;

    if (user_password_reg1 == user_password_reg2) {
        function reg_user(callback) {
            console.log(user);
            console.log(email);
            console.log(password1);
            console.log(password2);
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/reg',
                dataType: "json",
                data: ({name: user,
                    email: email,
                    password: password1}),
                success: function (data) {
                    sht = JSON.parse(JSON.stringify(data));
                    callback(data);
                }
            });
        }

        reg_user(function valid() {
            console.log("test4");
            console.log(sht.stan);
            var isValid = sht.isValid;
            if (isValid) {
                $("#btn_enter").hide();
                $("#btn_registration").hide();
                showLogo();
            } else {
                $("#bad_login").show();
            }
        });
    } else {
        console.log("Проверьте пароль!");
    }
}