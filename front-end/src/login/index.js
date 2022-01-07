const loginBtn = document.getElementById("signInButton");
const signupBtn = document.getElementById("signUpButton");

const url = "http://localhost:8080"

let loginStatus = false;
let signupStatus = false;

const displayMessage = (errorMessage, container, id, status) => {
    status = true;
    const div = document.getElementById(container);
    const message = document.createElement("p");
    message.setAttribute("id", id);
    message.textContent = errorMessage;
    div.appendChild(message);
    setTimeout(deleteMessage, 2500, id, status);
}

const deleteMessage = (id, status) => {
    document.getElementById(id).remove();
    status = false;
}

const login = async () => {
    const userName = document.getElementById("inputUserName");
    const password = document.getElementById("inputPassword");

    const credential = { userName: userName.value, password: password.value };

    const response = await fetch(url + "/login", {
        method: "POST",
        mode: "cors",
        body: JSON.stringify(credential),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });

    if (response.status === 200) {
        const body = await response.json();
        sessionStorage.setItem("userId", body.userId);
        sessionStorage.setItem("userName", body.userName);
        sessionStorage.setItem("firstName", body.firstName);
        sessionStorage.setItem("lastName", body.lastName);
        sessionStorage.setItem("email", body.email);
        sessionStorage.setItem("isAdmin", body.isAdmin);
        const isAdmin = sessionStorage.getItem("isAdmin");
        console.log(isAdmin);
        if (isAdmin == "true") {
            location.href = "../admin/homepage/adminhomepage.html";
        } else {
            location.href = "../users/homepage/homepage.html";
        }
    } else {
        userName.value = "";
        password.value = "";
        if (!loginStatus) {
            displayMessage("Incorrect Credentials", "signInContainer", "logInFailed", loginStatus);
        }
    }
};

const signup = async () => {
    const firstName = document.getElementById("createFirstName");
    const lastName = document.getElementById("createUserLastName");
    const userName = document.getElementById("createUserName");
    const password = document.getElementById("createPassword");
    const email = document.getElementById("createEmail");

    const user = {
        firstName: firstName.value,
        lastName: lastName.value,
        userName: userName.value,
        password: password.value,
        email: email.value
    };

    const response = await fetch(url + "/user", {
        method: "POST",
        mode: "cors",
        body: JSON.stringify(user),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });


    if (response.status === 201) {
        const body = await response.json();
        sessionStorage.setItem("userId", body.userId);
        sessionStorage.setItem("userName", body.userName);
        sessionStorage.setItem("firstName", body.firstName);
        sessionStorage.setItem("lastName", body.lastName);
        sessionStorage.setItem("email", body.email);
        sessionStorage.setItem("isAdmin", body.isAdmin);
        location.href = "../users/homepage/homepage.html";
    } else {
        const message = await response.text();
        if (message === "duplicate user name") {
            if (!signupStatus) {
                displayMessage("User name already exists!", "signUpContainter", "registerFailed", signupStatus);
            }
        } else if (message === "duplicate email") {
            if (!signupStatus) {
                displayMessage("Email already exists!", "signUpContainter", "registerFailed", signupStatus);
            }
        } else {
            if (!signupStatus) {
                displayMessage("Incorrect input", "signUpContainter", "registerFailed", signupStatus);
            }
        }
        firstName.value = "";
        lastName.value = "";
        email.value = "";
        userName.value = "";
        password.value = "";
    }
}

document.getElementById("inputUserName").onkeydown = (e) => {
    if (e.keyCode === 13) {
        login();
    }
}

document.getElementById("inputPassword").onkeydown = (e) => {
    if (e.keyCode === 13) {
        login();
    }
}

loginBtn.addEventListener("click", login);
signupBtn.addEventListener("click", signup);