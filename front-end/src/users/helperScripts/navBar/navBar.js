const url = "http://localhost:8080";
const searchField = document.getElementById("search1");

/**
 * search
 */

function referToProfile(targetId){
    sessionStorage.setItem("targetId",targetId);
    location.href= "../../users/otherProfile/otherprofile.html";
}

const searchUserByFirstName = async () => {
    const firstName = searchField.value;

    const response = await fetch(url + "/search/" + firstName, {
        method: "GET",
        mode: "cors"
    });
    document.getElementById("searchList").innerHTML ="";
    if (response.status === 200) {
        const body = await response.json();
        for(a of body){
            if(a.userId != Number(sessionStorage.getItem("userId"))){
            document.getElementById("searchList").innerHTML += ` <li><a class="list-group-item list-group-item-sm list-group-item-action dropdown-item" onclick="referToProfile(`+a.userId+`)">
            <img src="../../resources/commentIcon.png" style="display:inline;height:1.5em;width:1.5em;">
            <span style="color:rgb(69, 155, 212);font-size: 0.9em;font-weight:bold;">@`+a.userName+`<p style="color:rgb(0, 0, 0);">  `+a.firstName+` `+a.lastName+`</p></span></a></li>`
        }}
    } else {
        document.getElementById("searchList").innerHTML = `<li>No results</li>`

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