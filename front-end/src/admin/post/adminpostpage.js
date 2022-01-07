const url = "http://localhost:8080"
let postList = [];

const loadPostList = async () => {
    const response = await fetch(url + "/post/all", {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();
        for (post of body) {
            postList.push(post);
            document.getElementById("postDetail").innerHTML += 
            `
            <div class="list-group bg-black border-dark p-1">
            <a href="#" class="list-group-item list-group-item-action list-group-item-light" style="font-weight: bold;">` + post.postId + " " + post.postContent +
            `</a>
            </div>
            `;
        }
    } else {
        console.log("this should never happen - loadUserList");
    }
}

const toAdminHomePage = () => {
    location.href = "../homepage/adminhomepage.html";
}
document.getElementById("users").addEventListener("click", toAdminHomePage);


const logout = () => {
    sessionStorage.clear();
    location.href = "../../login/index.html";
}
document.getElementById("logout").addEventListener("click", logout);

loadPostList();