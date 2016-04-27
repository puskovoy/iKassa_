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
            console.log(danni[i].name);
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
function validate(fld, lbl, mx, my) {
    var errorMsg = "";
    var illegalChars = /[\W_]/; // allow only letters and numbers
    if (fld.val().length == "") {
        errorMsg = "Вы ни чего не уазали";
        console.log(errorMsg);
        msgToLabal(errorMsg, lbl);
        fld.focus();
        return false;
    } else if ((fld.val().length < mx) || (fld.val().length > my)) {
        errorMsg = "Колличество символов может быть в пределах от " + mx + " до " + my + " символов";
        console.log(errorMsg);
        msgToLabal(errorMsg, lbl);
        fld.focus();
        return false;
    } else if (illegalChars.test(fld.val())) {
        errorMsg = "Указаны не верные символы.";
        console.log(errorMsg);
        msgToLabal(errorMsg, lbl);
        fld.focus();
        return false;
    }
    return true;
}
function allLetter(userName, msgLbl) {
    var letters = /^[А-Яа-яA-Za-z\s]+$/;
    var errorMsg = "";
    console.log('проверяем имя пользователя');
    if (userName.val().length == "") {
        errorMsg = "Вы не указали имя пользователя.";
        console.log(errorMsg);
        msgToLabal(errorMsg, msgLbl);
        userName.focus();
        return false;
    } else if (userName.val().match(letters)) {
        return true;
    } else {
        errorMsg = 'Не верный символ в имени пользователя.';
        console.log(errorMsg);
        msgToLabal(errorMsg, msgLbl);
        userName.focus();
        return false;
    }
}
function validateEmail(email, msgLbl) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var errorMsg = "";
    console.log('проверяе мыло');
    if (email.val().length == "") {
        errorMsg = "Вы не указали адрес электронной почты.";
        console.log(errorMsg);
        msgToLabal(errorMsg, msgLbl);
        email.focus();
        return false;
    } else if (email.val().match(mailformat)) {
        return true;
    }
    else {
        errorMsg = 'Указан не верный адрес электронной почты.';
        console.log(errorMsg);
        msgToLabal(errorMsg, msgLbl);
        email.focus();
        return false;
    }
}
function validRegistration() {
    var user = $("#userName");
    var login = $("#userID");
    var email = $("#userEmail");
    var address = $("#userAddress");
    var password = $("#userPassword");
    var msgLbl = $("#errorMsgRegistration");
    var buton = $("#btnRegistration");
    console.log('регистрация валидация');
    if (validate(login, msgLbl, 3, 12)) {
        if (allLetter(user, msgLbl)) {
            if (validateEmail(email, msgLbl)) {
                if (validate(password, msgLbl, 7, 12)) {
                    console.log('start registration');
                    buton.append("  <i class='fa fa-spinner fa-spin'>");
                    msgLbl.html('');
                    useAjax("reg", {
                        name: user.val(),
                        login: login.val(),
                        email: email.val(),
                        address: address.val(),
                        password: password.val()
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
    var user = $("#userLogin");
    var password = $("#userPasswordLogin");
    var msgLbl = $("#errorMsgLogin");
    var btn = $("#btnLogin");
    console.log('логин валидация');
    if (validate(user, msgLbl, 3, 12)) {
        if (validate(password, msgLbl, 7, 12)) {
            console.log('start login');
            btn.append("  <i class='fa fa-spinner fa-spin'>");
            msgLbl.html('');
            useAjax("login", {name: user.val(), password: password.val()}, function valid() {
                var isValid = danni.isValid;
                if (isValid) {
                    var url = "/startPage.html";
                    $(location).attr('href', url);
                } else {
                    msgToLabal('Указан не верный логин или пароль!', msgLbl);
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