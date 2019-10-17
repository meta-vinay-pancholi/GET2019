var clicks = 0;

function validateName() {
    var inputField = document.getElementById("inputField");
    var filtercontact = new RegExp('([a-zA-Z!@#$%^&*()_+])');
    var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    var filterEmail = new RegExp("^[A-Za-z0-9_.]+\@([A-Za-z0-9_])+\.([A-Za-z]{2,4})$");
    var regex = new RegExp("\\d");
    var pasword;
    if (inputField.value.length <= 4 && clicks == 0) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";
        inputField.value = inputField.value.toUpperCase();
        return false;
    }
    if (regex.test(inputField.value) && clicks == 0) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";

        return false;

    } else if (inputField.value.length >= 5 && clicks == 0) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        inputField.value = inputField.value.toUpperCase();
        return true;
    }

    if (inputField.value == "" || inputField.value.length < 8 && clicks == 1) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";

        return false;

    } else if (!filterEmail.test(inputField.value) && clicks == 1) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";

        return false;
    } else if (clicks == 1) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        return true;
    }

    if (filtercontact.test(inputField.value) && clicks == 2) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";

        return false;
    } else if (inputField.value.length < 10 || inputField.value.length > 10 && clicks == 2) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";
        return false;
    } else if (inputField.value.length == 10 && clicks == 2) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        return true;
    }

    if (!filterPassword.test(inputField.value) && clicks == 3) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";
        return false;
    } else if (clicks == 3) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        return true;
    }
    pasword = localStorage.getItem("Employee_Password");
    if (pasword != inputField.value && clicks == 4) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";
        return false;
    } else if (clicks == 4) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        return true;
    }

    if (clicks == 5 && inputField.value.length < 4) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";
        return false;
    } else if (clicks == 5) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        return true;
    }

    if (inputField.value.length < 4 && clicks == 6) {
        document.getElementById("inputField").style.borderColor = "#f23a3a";
        return false;
    } else if (clicks == 6) {
        document.getElementById("inputField").style.borderColor = "#52eb34";
        return true;
    }
    return true;
}

function nameSubmit() {
    if (clicks == 0) {
        var inputField = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Name", inputField);
            document.getElementById('demo').innerHTML = "Nice!!, " + inputField + " please Enter your mail id in correct format";
            document.getElementById('inputField').value = "";
            clicks = clicks + 1;
        }
    } else if (clicks == 1) {
        var empEmail = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Email", empEmail);
            document.getElementById('demo').innerHTML = "Now enter your 10 digit mobile number!!";
            document.getElementById('inputField').value = "";
            clicks = clicks + 1;
        }

    } else if (clicks == 2) {
        var empContact = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Contact", empContact);
            document.getElementById('demo').innerHTML = "Choose a strong password for your profile in desired format !! eg. Vinay@123";
            document.getElementById('inputField').value = "";
            clicks = clicks + 1;
        }
    } else if (clicks == 3) {
        var empPassword = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Password", empPassword);
            document.getElementById('demo').innerHTML = "Confirm your password..";
            document.getElementById('inputField').value = "";
            clicks = clicks + 1;
        }
    } else if (clicks == 4) {
        var empConPassword = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Confirm_Password", empConPassword);
            document.getElementById('congrats').innerHTML = "Great you are succesfully registered!! Now fill vehicle registration form..";
            document.getElementById('demo').innerHTML = "Enter Vehicle Name";
            document.getElementById('label').innerHTML = "Vehicle Registration form";
            document.getElementById('inputField').value = "";
            clicks = clicks + 1;
        }
    } else if (clicks == 5) {
        var empVname = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Vehcile_Name", empVname);
            document.getElementById('congrats').innerHTML = "";
            document.getElementById('demo').innerHTML = "Enter Vehicle Number";
            document.getElementById('inputField').value = "";
            clicks = clicks + 1;
        }
    } else if (clicks == 6) {
        var empVnumber = document.getElementById("inputField").value;
        var flag = validateName();
        if (flag == true) {
            localStorage.setItem("Employee_Vehcile_Number", empVnumber);
            document.getElementById('demo').innerHTML = "Choose Vehicle Type";
            var x = document.getElementById("form_div");
            x.style.display = "none";
            document.getElementById('vehicle_div').style.visibility = 'visible';
            clicks = clicks + 1;
        }
    }
}

function vehicleType(clicked_id) {
    document.getElementById('vehicle_div').style.visibility = 'hidden';
    document.getElementById('currency_div').style.visibility = 'visible';
    localStorage.setItem("Employee_Vehcile_Type", clicked_id);
    document.getElementById('demo').innerHTML = "Choose your currency and Pass";
    if (clicked_id == "cycle") {
        document.getElementById("cycle1").style.visibility = "visible";
    } else if (clicked_id == "bike") {
        document.getElementById("bike1").style.visibility = "visible";
    } else {
        document.getElementById("car1").style.visibility = "visible";
    }
    document.getElementById("bill").style.visibility = "visible";
}


function currency(currecy_type) {
    var ve_type = localStorage.getItem("Employee_Vehcile_Type");
    localStorage.setItem("Currency_type", currecy_type);
    switch (currecy_type) {
        case "rupee":
            var a = document.getElementById(ve_type + "1").querySelectorAll(".p1");
            for (var index = 0; index < a.length; index++) {
                var element = a[index].innerHTML;
                element = parseInt(element);
                element = element * 1;
                a[index].innerHTML = element;

            }
            break;

        case "dollar":
            var a = document.getElementById(ve_type).querySelectorAll(".p1");
            for (var index = 0; index < a.length; index++) {
                var element = a[index].innerHTML;
                element = parseInt(element);
                element = element * 0.014;
                a[index].innerHTML = element;

            }
            break;
        case "yen":
            var a = document.getElementById(ve_type).querySelectorAll(".p1");
            for (var index = 0; index < a.length; index++) {
                var element = a[index].innerHTML;
                element = parseInt(element);
                element = element * 1.48;
                a[index].innerHTML = element;

            }
            break;
    }
}

function bill_cal() {
    var ve_type = localStorage.getItem("Employee_Vehcile_Type");
    var ctype = localStorage.getItem("Currency_type");
    var ele = document.getElementsByName(ve_type);
    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked)
            document.getElementById("show_price").innerHTML = "Total bill in USD : " + ele[i].value * 0.014;

    }
}