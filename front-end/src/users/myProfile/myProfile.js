const editProfileButton = document.getElementById("editProfileButton");
const userId = sessionStorage.getItem("userId");

const loadMyProfile = async () => {
    const response = await fetch(url + "/user/" + userId, {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();


    } else {
        /**
         * fatal error. should never happen
         */
    }
}

const editMyProfile = async () => {
    const userName = document.getElementById("editUsername");
    const password = document.getElementById("editPassword");
    const firstName = document.getElementById("editFirstName");
    const lastName = document.getElementById("editLastName");
    const email = document.getElementById("editEmail");

    let newInfo = {};

    if (userName.value === "") {
        newInfo.userName = sessionStorage.getItem("userName");
    } else {
        newInfo.userName = userName.value;
    }
    if (password.value === "") {
        newInfo.password = "";
    } else {
        newInfo.password = password.value;
    }
    if (firstName.value === "") {
        newInfo.firstName = sessionStorage.getItem("firstName");
    } else {
        newInfo.firstName = firstName.value;
    }
    if (lastName.value === "") {
        newInfo.lastName = sessionStorage.getItem("lastName");
    } else {
        newInfo.lastName = lastName.value;
    }
    if (email.value === "") {
        newInfo.email = sessionStorage.getItem("email");
    } else {
        newInfo.email = email.value;
    }

    const response = await fetch(url + "/user/" + userId, {
        method: "PATCH",
        mode: "cors",
        body: JSON.stringify(newInfo),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });

    /**
     * @todo 
     * fix
     */

    let message = await response.text();
    if (response.status === 200) {
        document.getElementById("statusMessage").innerHTML = message;
        console.log("Hi I worked");
        loadMyProfile();

    } else {
        console.log(message);
        if (message === "duplicate user name") {
            message = "username is already taken";
        } else if (message === "duplicate email") {
            message = "email already exists";
        } else {
            message = "something went wrong, please try again."
        }
        document.getElementById("statusMessage").innerHTML = message;
    }

    firstName.value = "";
    lastName.value = "";
    email.value = "";
    userName.value = "";
    password.value = "";

}

editProfileButton.addEventListener("click", editMyProfile);
loadMyProfile();