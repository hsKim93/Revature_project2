const editProfileButton = document.getElementById("editProfileButton");
const userId = sessionStorage.getItem("userId");


const loadMyProfile = async () => {
    const response = await fetch(url + "/user/" + userId, {
        method: "GET",
        mode: "cors"
    });
    
    if (response.status === 200) {
        const body = await response.json();
        document.getElementById("name").innerText = body.firstName + " " + body.lastName;
        document.getElementById("userName").innerText = "@" + body.userName;
        document.getElementById("email").innerText = body.email;
    } else {
        console.log("This should never happen - loadMyProfile");
    }
}

const getFollowing = async () => {
    const response = await fetch(url + "/following/" + 8000, {
        method: "GET",
        mode: "cors"
    });
    if (response.status === 201) {
        const body = await response.json();
        console.log(body);
        document.getElementById("following").innerText = body.length;
    } else {
        console.log("This should never happen - getFollowing");
    }
}

const getFollower = async () => {
    const response = await fetch(url + "/followers/" + 8000, {
        method: "GET",
        mode: "cors"
    });
    
    if (response.status === 201) {
        const body = await response.json();
        console.log(body);
        document.getElementById("followers").innerText = body.length;
    } else {
        console.log("This should never happen - getFollower");
    }
}

const editMyProfile = async () => {
    document.getElementById("statusMessage").innerText = "Processing request...";

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
    if (response.status === 200) {
        document.getElementById("statusMessage").innerText = "Profile edited succesfully";
        sessionStorage.setItem("firstName", newInfo.firstName);
        sessionStorage.setItem("lastName", newInfo.lastName);
        sessionStorage.setItem("email", newInfo.email);
        sessionStorage.setItem("userName", newInfo.userName);
        loadAll(true);
    } else {
        let message = await response.text();
        if (message === "duplicate user name") {
            message = "username is already taken";
        } else if (message === "duplicate email") {
            message = "email already exists";
        } else {
            message = "something went wrong, please try again."
        }
        document.getElementById("statusMessage").innerText = message;
    }
    
    firstName.value = "";
    lastName.value = "";
    email.value = "";
    userName.value = "";
    password.value = "";
    
}

const loadAll = async (edited) => {
    loadMyProfile();
    if (!edited) {
        getFollowing();
        getFollower();
    }
}

editProfileButton.addEventListener("click", editMyProfile, false);
loadAll(false);
