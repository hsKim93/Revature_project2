const url = "http://localhost:8080"
let postList = [];




async function deletePost(postId) {
    const response = await fetch(url + "/post/delete/" + postId, {
        method: "GET",
        mode: "cors"
    });
    const body = await response.json();
    if (response.status === 200) {
        document.getElementById("postRow"+postId).remove();
    } else {
        document.getElementById("likeInfo"+postId).innerHTML = "Post could not be deleted"
    }
}

async function deleteComment1(commmentId) {
    const response = await fetch(url + "/comment/commentId/" + commmentId, {
        method: "DELETE",
        mode: "cors"
    });
    const body = await response.json();
    if (response.status === 200) {
        document.getElementById("commentRow"+commmentId).remove();
    } else {
        document.getElementById("commentRow"+commentRow).innerHTML = "Post could not be deleted"
    }
}

async function showComments(postId) {
    const response = await fetch(url + "/comment/postId/" +postId, {
        method: "GET",
        mode: "cors"
    });
    document.getElementById("modaltableBody").innerHTML = "";
    const body = await response.json();
    if(body.length == 0){
        document.getElementById("modaltableBody").innerHTML = `<h3 class="text-black"> NO Comments</h3>`
       }
    if (response.status === 200) {
       for(comments of body){
        document.getElementById("modaltableBody").innerHTML +=  `<tr id="commentRow${comments.commentId}">
        <td scope="row">#${comments.commentId}</td>
        <td>${comments.commentContent}</td>
        <td>${comments.date}</td>
        <td><button class="btn btn-danger" id="deleteComment${comments.commentId}" onclick="deleteComment1(${comments.commentId})">delete</button></td>
      </tr>`;
       }
    } else {
        document.getElementById("modaltableBody").innerHTML = "Can not show posts";    }
}


const loadPostList = async () => {
    const response = await fetch(url + "/post/all", {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();
        for (post of body) {
            document.getElementById("tableBody").innerHTML += 
            `
            <tr id="postRow${post.postId}">
            <th scope="row">#${post.userId}</th>
            <td>#${post.postId}</td>
            <td>${post.content}</td>
            <td>${post.date}</td>
            <td><button class="btn btn-primary" id="showComments${post.postId}" data-bs-toggle="modal" data-bs-target="#modalComments"  onclick="showComments(${post.postId})">Comments</button></td>
            <td><button class="btn btn-danger" id="deletePost${post.postId}" onclick="deletePost(${post.postId})">delete</button></td>
          </tr>

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
