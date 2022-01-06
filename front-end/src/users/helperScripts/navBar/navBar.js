const url = "http://localhost:8080";
const searchField = document.getElementById("search1");

/**
 * search
 */

const searchUserByFirstName = async () => {
    const firstName = searchField.value;

    const response = await fetch(url + "/search/" + firstName, {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();
        userList = [];
        for (user of body) {
            userList.push(user)
        }
        console.log(userList);
        /**
         * @todo
         * create a dropdown with results
         */
    } else {
        /**
         * @todo
         * create a dropdowon with "no result" text
         */
    }
}

document.getElementById("searchButton").addEventListener("click", searchUserByFirstName);

searchField.onkeydown = (e) => {
    if (e.keyCode === 13) {
        searchUserByFirstName();
    }
}


/**
 * logout
 */

const logout = () => {
    sessionStorage.clear();
    location.href = "../../login/index.html";
}

document.getElementById("logout").addEventListener("click", logout);

/**
 * home
 */

const toHome = () => {
    location.href = "../homepage/homepage.html";
}

document.getElementById("home").addEventListener("click", toHome);

/**
 * my profile
 */

const toMyProfile = () => {
    location.href = "../myProfile/myProfile.html";
}

document.getElementById("myProfile").addEventListener("click", toMyProfile);