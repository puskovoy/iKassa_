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
    getDetails(['#formAddInkassator', '#tablCar', '#formAddCar'], '#tablInkassator');
    useAjax("inkassator", {}, function valid() {
        for (var i = 0; i < danni.length; i++) {
            var row = "<tr ><td>" + danni[i].id +
                "</td><td>" + danni[i].surname + " " + danni[i].name +
                "</td><td>" + danni[i].age +
                "</td></tr>";
            $('#bodyInkass').append(row);
        }
    });
}

function dropAllInkass() {
    getDetails(['#formAddInkassator', '#tablCar', '#formAddCar'], '#tablInkassator');
    useAjax("dropAllInkassator", {}, function valid() {
        $('#bodyInkass').html('');
        $('#modalDropAllInkass').modal('show');
    });
}

function addInkass() {
    var name = document.getElementById("inkassatorName").value;
    var surName = document.getElementById("inkassatorSurname").value;
    var age = document.getElementById("inkassatorAge").value;
    $('#bodyInkass').html('');
    useAjax("inkassator", {name: name, surname: surName, age: age}, function valid() {
        for (var i = 0; i < danni.length; i++) {
            var row = "<tr ><td>" + danni[i].id +
                "</td><td>" + danni[i].surname + " " + danni[i].name +
                "</td><td>" + danni[i].age +
                "</td></tr>";
            $('#bodyInkass').append(row);
        }
        getDetails(['#formAddInkassator'], '#tablInkassator')
    });
}

function getCar() {
    getDetails(['#formAddInkassator', '#tablInkassator', '#formAddCar'], '#tablCar');
    $('#bodyTablCar').html('');
    useAjax("car", {}, function valid() {
        for (var i = 0; i < danni.length; i++) {
            var row = "<tr ><td>" + danni[i].id +
                "</td><td>" + danni[i].name +
                "</td><td>" + danni[i].cost +
                "</td><td>" + danni[i].number +
                "</td><td>" + danni[i].date +
                "</td></tr>";
            $('#bodyTablCar').append(row);
        }
    });
}

function dropAllCar() {
    getDetails(['#formAddInkassator', '#tablInkassator', '#formAddCar'], '#tablCar');
    useAjax("dropAllCar", {}, function valid() {
        $('#bodyTablCar').html('');
        $('#modalDropAllCar').modal('show');
    });
}

function addCar() {
    getDetails(['#formAddInkassator', '#tablInkassator', '#formAddCar'], '#tablCar');
    var name = document.getElementById("carName").value;
    var cost = document.getElementById("carCost").value;
    var number = document.getElementById("carNumber").value;
    $('#bodyTablCar').html('');
    useAjax("car", {name: name, cost: cost, number: number}, function valid() {
        for (var i = 0; i < danni.length; i++) {
            var row = "<tr ><td>" + danni[i].id +
                "</td><td>" + danni[i].name +
                "</td><td>" + danni[i].cost +
                "</td><td>" + danni[i].number +
                "</td><td>" + danni[i].date +
                "</td></tr>";
            $('#bodyTablCar').append(row);
        }
    });
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
/*validating*/
function validateUserLogin(fld, lblMsg, lblFocus, mx, my) {
    var error = "";
    var illegalChars = /\W/; // allow letters, numbers, and underscores
    console.log('проверяем логин');
    if (fld.length == "") {
        error = "Вы не указали логин пользователя.";
        console.log(error);
        msgToLabal(error, lblMsg);
        lblFocus.focuse;
        return false;
    } else if ((fld.length < mx) || (fld.length > my)) {
        error = "Укажите длинну логина в пределах от " + mx + " до " + my + " символов";
        console.log(error);
        msgToLabal(error, lblMsg);
        return false;
    } else if (illegalChars.test(fld.value)) {
        error = "Логин пользователя содержит не верные символы.";
        console.log(error);
        msgToLabal(error, lblMsg);
        return false;
    }
    return true;
}
function validatePassword(fld, lbl, mx, my) {
    var error = "";
    var illegalChars = /[\W_]/; // allow only letters and numbers
    console.log('проверяем пароль');
    if (fld.length == "") {
        error = "Вы не уазали пароль";
        console.log(error);
        msgToLabal(error, lbl);
        return false;
    } else if ((fld.length < 7) || (fld.length > 15)) {
        error = "Укажите длинну пароля в пределах от " + mx + " до " + my + " символов";
        console.log(error);
        msgToLabal(error, lbl);
        return false;
    } else if (illegalChars.test(fld)) {
        error = "Пароль содержит не верные символы.";
        console.log(error);
        msgToLabal(error, lbl);
        return false;
    } else if ((fld.search(/[a-zA-Z]+/) == -1) || (fld.search(/[0-9]+/) == -1)) {
        error = "Последний символ пароля должен содержать цифру";
        console.log(error);
        msgToLabal(error, lbl);
        return false;
    }
    return true;
}
function allLetter(uname) {
    var letters = /^[А-Яа-яA-Za-z]+$/;
    var error = "";
    var msg = $("#bad_password");
    console.log('проверяем имя пользователя');
    if (uname.match(letters)) {
        return true;
    } else {
        error = 'Не верный символ в имени пользователя.';
        console.log(error);
        msgToLabal(error, msg);
        return false;
    }
}
function validateEmail(email) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var error = "";
    var msg = $("#bad_password");
    console.log('проверяе мыло');
    if (email.match(mailformat)) {
        return true;
    }
    else {
        error = 'Указан не верный адрес электронной почты.';
        console.log(error);
        msgToLabal(error, msg);
        return false;
    }
}
function validRegistration() {
    var user = document.getElementById("userName").value;
    var userFld = $("#userName");
    var login = document.getElementById("userID").value;
    var email = document.getElementById("userEmail").value;
    var address = document.getElementById("userAddress").value;
    var password = document.getElementById("userPassword").value;
    var msg = $("#bad_password");
    var buton = $("#btn_reg");
    console.log('регистрация валидация');
    console.log(userFld);
    if (validateUserLogin(login, msg, userFld, 3, 12)) {
        if (allLetter(user)) {
            if (validateEmail(email)) {
                if (validatePassword(password, 7, 12)) {
                    console.log('start registration');
                    buton.append("  <i class='fa fa-spinner fa-spin'>");
                    useAjax("reg", {
                        name: user,
                        login: login,
                        email: email,
                        address: address,
                        password: password
                    }, function valid() {
                        var url = "/startPage.html";
                        $(location).attr('href', url);
                    });
                    buton.html('Регистрация');
                }
            }
        }
    }
    return false;
}
function validLogin() {
    var user = document.getElementById("userLogin").value;
    var password = document.getElementById("userPasswordLogin").value;
    var msg = $("#bad_login");
    var btn = $("#btn_log");
    console.log('логин валидация');
    console.log(user);
    console.log(password);
    if (validateUserLogin(user, msg, 3, 12)) {
        if (validatePassword(password, msg, 7, 12)) {
            console.log('start login');
            btn.append("  <i class='fa fa-spinner fa-spin'>");
            msg.html('');
            useAjax("login", {name: user, password: password}, function valid() {
                var isValid = danni.isValid;
                if (isValid) {
                    var url = "/startPage.html";
                    $(location).attr('href', url);
                } else {
                    msgToLabal('Указан не верный логин или пароль!', msg);
                    btn.html("Вход");
                }
            })
        }
    }
    return false;
}
function msgToLabal(msg, label) {
    label.html(msg);
    label.show();
}