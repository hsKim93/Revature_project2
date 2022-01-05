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
        console.log(userList);
    } else {
        /**
         * @todo
         * show error message instead of users
         */
        console.log("didn't work");
    }
}

loadUserList();