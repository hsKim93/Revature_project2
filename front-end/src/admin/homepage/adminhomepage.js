const url = "http://localhost:8080"

const loadUserList = async () => {
    const response = await fetch(url + "/users", {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();
        let tbody = document.getElementById("tableBody");
        for (user of body) {
            tbody.insertRow().innerHTML = createRow(user);
            addEvents(user.userId);
        }
    } else {
        console.log("this should never happen - loadUserList");
    }
}

const createRow = (user) => {
    return createTd(user.userId, user.userName, user.firstName, user.lastName);
}

const createTd = (userId, userName, firstName, lastName) => {
    return `<td class="center"># ` + userId + `</td>
    <td class="center">@` + userName + `</td>
    <td class="center">` + firstName + ` ` + lastName + `</td>
    <td class="center">
    <button id="` + userId + `d" class="btn btn-danger btn-w">delete</button>
    </td>`;
}

const addEvents = (userId) => {
    document.getElementById(userId + "d").addEventListener("click", deleteUser);
}

const deleteUser = async (e) => {
    let userId = e.target.id.substring(0, e.target.id.length-1);
    const response = await fetch(url + "/user/" + userId, {
        method: "DELETE",
        mode: "cors"
    });
    let responseBody = await response.json();
    if (response.status === 200) {
         let p = document.getElementById(userId + "d").parentNode.parentNode;
         p.parentNode.removeChild(p);
    } else {
        console.log("this should never happen - deleteUser");
    }
}


const toAdminHomePage = () => {
    location.href = "../homepage/adminhomepage.html";
}
document.getElementById("users").addEventListener("click", toAdminHomePage);

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
