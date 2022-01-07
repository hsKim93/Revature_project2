const profileId = sessionStorage.getItem("profileId");
const userId = sessionStorage.getItem("userId");
const followButton = document.getElementById("followButton");

let followed = false;

const follow = async () => {

    console.log("follow called");

    const body = {
        userId: userId,
        targetId: profileId
    };

    const response = await fetch(url + "/follow", {
        method: "POST",
        mode: "cors",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });

    if (response.status === 201) {
        currentFollowing = document.getElementById("following").innerText;
        document.getElementById("following").textContent = parseInt(currentFollowing)+1;
        followButton.innerText = "following";
        followed = true;
    } else {
        console.log("This should never happen - follow");
    }
}

const unfollow = async () => {

    console.log("unfollow called");

    const body = {
        userId: userId,
        targetId: profileId
    };

    const response = await fetch(url + "/unfollow", {
        method: "POST",
        mode: "cors",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });

    if (response.status === 201) {
        currentFollowing = document.getElementById("following").innerText;
        document.getElementById("following").textContent = parseInt(currentFollowing)-1;
        followButton.innerText = "follow";
        followed = false;
    } else {
        console.log("This should never happen - unfollow");
    }
}

const followButtonPressed = async () => {
    console.log(followed);
    if (followed) {
        unfollow();
    } else {
        follow();
    }
}


const loadProfile = async () => {
    const response = await fetch(url + "/user/" + profileId, {
        method: "GET",
        mode: "cors"
    });
    
    if (response.status === 200) {
        const body = await response.json();
        document.getElementById("name").innerText = body.firstName + " " + body.lastName;
        document.getElementById("userName").innerText = "@" + body.userName;
        document.getElementById("email").innerText = body.email;
    } else {
        console.log("This should never happen - loadProfile");
    }
}

const getFollowing = async () => {
    const response = await fetch(url + "/following/" + profileId, {
        method: "GET",
        mode: "cors"
    });
    if (response.status === 201) {
        const body = await response.json();
        document.getElementById("following").innerText = body.length;
    } else {
        console.log("This should never happen - getFollowing");
    }
}

const getFollower = async () => {
    const response = await fetch(url + "/followers/" + profileId, {
        method: "GET",
        mode: "cors"
    });
    
    if (response.status === 201) {
        const body = await response.json();
        for (userId of body) {
            if (userId === sessionStorage.getItem("userId")) {
                followed = true;
                break;
            } 
        }
        document.getElementById("followers").innerText = body.length;
    } else {
        console.log("This should never happen - getFollower");
    }
}

const loadAll = async () => {
    loadProfile();
    getFollower();
    getFollowing();
}

console.log(followed);
followButton.addEventListener("click", followButtonPressed.bind(followed));
loadAll();