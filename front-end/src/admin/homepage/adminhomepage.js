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
            document.getElementById("userDetail").innerHTML += 
            `
            <div class="list-group bg-black border-dark p-1">
            <li href="#" class="list-group-item list-group-item-dark" style="font-weight: bold;">` + user.firstName + " " + user.lastName +
            `
            <button type="button" class="btn-close btn-close-dark float-end" aria-label="Close" id=user` + user.userId +  `
            ></button>
            </li>
            </div>
            `;
        }
    } else {
        document.getElementById("userDetail").innerHTML = "No User Found!";
    }
}



const deleteUser = async (userId) => {
    const response = await fetch(url + "/user/" + userId, {
        method: "DELETE",
        mode: "cors"
    });
    let responseBody = await response.json();
    if (response.status === 200) {
        /**
         * @todo
         * delete html of this user OR reload the users list
         */
        
    } else {
        console.log("this should never happen - deleteUser");
    }
}


const toAdminPostPage = () => {
    location.href = "../post/adminpostpage.html";
}
document.getElementById("posts").addEventListener("click", toAdminPostPage);

const logout = () => {
    sessionStorage.clear();
    location.href = "../../login/index.html";
}
document.getElementById("logout").addEventListener("click", logout);

loadUserList();
document.getElementById("").addEventListener("click", );