const url = "http://localhost:8080"
let userList = [];

const loadUserList = async () => {
    const response = await fetch(url + "/users", {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();
        for (user of body) {
            userList.push(user);
        }
    } else {
        console.log("this should never happen - loadUserList");
    }
}

const deleteUser = async (userId) => {
    const response = await fetch(url + "/user/" + userId, {
        method: "DELETE",
        mode: "cors"
    });

    if (response.status === 200) {
        /**
         * @todo
         * delete html of this user OR reload the users list
         */
    } else {
        console.log("this should never happen - deleteUser");
    }
}

loadUserList();