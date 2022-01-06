const searchField = document.getElementById("search1");
const searchButton = document.getElementById("searchButton");
const url = "http://localhost:8080/";

const searchUserByFirstName = async () => {
    const firstName = searchField.value;

    const response =  await fetch(url + "search/" + firstName, {
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
    } else {
        console.log("search is not working");
        /**
         * @Todo
         * create a dropdowon with "no result" text
         */
    }
}

searchField.onkeydown = (e) => {
    if (e.keyCode === 13) {
        searchUserByFirstName();
    }
};

searchButton.addEventListener("click", searchUserByFirstName);