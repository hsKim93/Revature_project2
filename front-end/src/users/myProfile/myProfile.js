const editProfileButton = document.getElementById("editProfileButton");
const userId = sessionStorage.getItem("userId");


const loadMyProfile = async () => {
    const response = await fetch(url + "/user/" + userId, {
        method: "GET",
        mode: "cors"
    });
    
    if (response.status === 200) {
        const body = await response.json();
        document.getElementById("name").innerText = body.firstName + " " + body.lastName;
        document.getElementById("userName").innerText = "@" + body.userName;
        document.getElementById("email").innerText = body.email;
    } else {
        console.log("This should never happen - loadMyProfile");
    }
}

const getFollowing = async () => {
    const response = await fetch(url + "/following/" + userId, {
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
    const response = await fetch(url + "/followers/" + userId, {
        method: "GET",
        mode: "cors"
    });
    
    if (response.status === 201) {
        const body = await response.json();
    
        document.getElementById("followers").innerText = body.length;
    } else {
        console.log("This should never happen - getFollower");
    }
}

const editMyProfile = async () => {
    document.getElementById("statusMessage").innerText = "Processing request...";

    const userName = document.getElementById("editUsername");
    const password = document.getElementById("editPassword");
    const firstName = document.getElementById("editFirstName");
    const lastName = document.getElementById("editLastName");
    const email = document.getElementById("editEmail");
    
    let newInfo = {};
    
    if (userName.value === "") {
        newInfo.userName = sessionStorage.getItem("userName");
    } else {
        newInfo.userName = userName.value;
    }
    
    if (password.value === "") {
        newInfo.password = "";
    } else {
        newInfo.password = password.value;
    }

    if (firstName.value === "") {
        newInfo.firstName = sessionStorage.getItem("firstName");
    } else {
        newInfo.firstName = firstName.value;
    }

    if (lastName.value === "") {
        newInfo.lastName = sessionStorage.getItem("lastName");
    } else {
        newInfo.lastName = lastName.value;
    }

    if (email.value === "") {
        newInfo.email = sessionStorage.getItem("email");
    } else {
        newInfo.email = email.value;
    }
    
    const response = await fetch(url + "/user/" + userId, {
        method: "PATCH",
        mode: "cors",
        body: JSON.stringify(newInfo),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });
    
    /**
     * @todo 
     * fix
     */
    if (response.status === 200) {
        document.getElementById("statusMessage").innerText = "Profile edited succesfully";
        sessionStorage.setItem("firstName", newInfo.firstName);
        sessionStorage.setItem("lastName", newInfo.lastName);
        sessionStorage.setItem("email", newInfo.email);
        sessionStorage.setItem("userName", newInfo.userName);
        loadAll(true);
    } else {
        let message = await response.text();
        if (message === "duplicate user name") {
            message = "username is already taken";
        } else if (message === "duplicate email") {
            message = "email already exists";
        } else {
            message = "something went wrong, please try again."
        }
        document.getElementById("statusMessage").innerText = message;
    }
    
    firstName.value = "";
    lastName.value = "";
    email.value = "";
    userName.value = "";
    password.value = "";
    
}

const loadAll = async (edited) => {
    loadMyProfile();
    if (!edited) {
        getFollowing();
        getFollower();
    }
}

editProfileButton.addEventListener("click", editMyProfile, false);
loadAll(false);


document.getElementById("sendPostButton").addEventListener("click",createPost);

async function createPost() {
  const rqjson = {
    postId: 0,
    userId: sessionStorage.getItem("userId"),
    content: document.getElementById("postInput").value,
    date: "",
  };
  let response = await fetch(url + "/post/create", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  if(responseBody == true){
    document.getElementById("postInfo").innerHTML = `Post sent`;
    document.getElementById("postInfo").innerHTML = `
    <div class="accordion-item boxstyle" style="margin-top:1em;margin-bottom:1em;">
    <div class="accordion-header" id="headingNew">
      <img src="../../resources/postIcon.png" style="height:2em;width:2em;">
      <a style="font-weight: bold;">` +
      sessionStorage.getItem("firstName") + " " +sessionStorage.getItem("lastName") +
      `</a>
     <span style=" float:right;font-size: 0.8em;color:grey;">now<br></span>  </span><span style="color:rgb(69, 155, 212);font-size: 0.9em;">@` +
      sessionStorage.getItem("userName")
+      `</span></span><div class="border-bottom" style="margin-top:0.7em;">
        <p>` +
     document.getElementById("postInput").value +
      `</p>
      </div>
       <div > <p><a class="btn btn-sm text-white" id="likeButton" type="button" ><span> Like</span >(<span id="likeStatus">0</span>)</a><span>  
       </span><a class="btn text-white btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#collapse" aria-expanded="true" aria-controls="collapse"> Comments (0)
        </a></p>
        </div>
    </div>
    <div id="collapse" class="accordion-collapse collapse" aria-labelledby="heading" data-bs-parent="#accordion">
      <div class="accordion-"> 
      <ul class="list-group" id="comment" style="list-style: none;margin-bottom:0.5em"></ul>

    
      <textarea class="form-control form-control-sm bg-black text-white" style="display:inline-block;" id="inputComment"  maxlength = "500" rows="3"></textarea>
      
      <div id="commentSection">   <button class="btn btn-outline-info" styl ">Chirp</button></div>
   
    </div>
      </div>
    </div>
  </div>`;

  }else{
    document.getElementById("postInfo").innerHTML = `Post could not be sent`
  }
}

async function getOneUserModulebyUserId(id) {
  let response = await fetch(url + `/post/oneUserModule/${id}`, {
    method: "GET",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
  });
  let responseBody = await response.json();
  return responseBody;
}


async function deleteComment1(commentId) {
  const response = await fetch(url + "/comment/commentId/" + commentId, {
      method: "DELETE",
      mode: "cors"
  });
  const body = await response.json();
  if (response.status === 200) {
      document.getElementById("commentOb"+commentId).remove();
  } else {
      document.getElementById("commentOb"+commentId).innerHTML =+ "Could not be deleted"
  }
}

async function deletePost1(postId) {
    const response = await fetch(url + "/post/delete/" + postId, {
        method: "GET",
        mode: "cors"
    });
    const body = await response.json();
    if (response.status === 200) {
        document.getElementById("accordionTop"+postId).remove();
    } else {
        document.getElementById("likeInfo"+postId).innerHTML = "Post could not be deleted"
    }
}

async function likePost(userId, postId) {
  const rqjson = {
    userId: userId,
    postId: postId,
  };

  let response = await fetch(url + "/post/like", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  if(responseBody === false){
    unlikePost(userId,postId)
  }
  else{
    document.getElementById("likeStatus"+postId).innerHTML =Number(document.getElementById("likeStatus"+postId).textContent) + 1;
  };
}

async function unlikePost(userId, postId) {
  const rqjson = {
    userId: userId,
    postId: postId,
  };

  let response = await fetch(url + "/post/unlike", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  if(responseBody === true){
    document.getElementById("likeStatus"+postId).innerHTML =Number(document.getElementById("likeStatus"+postId).textContent) - 1;
  }
}

async function createComment1(postId) {
  const rqjson = {
    commentId:"0", 
    postId: Number(postId), 
    userId:Number(sessionStorage.getItem("userId")),
    commentContent: document.getElementById("inputComment"+postId).value,
    date: ""
  };

  let response = await fetch(url + "/comment/create", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  if(response.status == 201){
    document.getElementById("comment"+postId).insertAdjacentHTML("afterbegin", `<li style="margin-bottom:1em;"><img 
    src="../../resources/commentIcon.png" style="height:1.5em;width:1.5em;">
    <span class="font-weight-bold" style="color:rgb(69, 155, 212);">  @`+sessionStorage.getItem("userName")+`  </span><span>`+ document.getElementById("inputComment"+postId).value+`</span></li>`);

  }else{
    document.getElementById("commentInfo"+postId).innerHTML = `Comment could not be sent`
  }
}

async function loadPostModule() {
  let userId = sessionStorage.getItem("userId");
  let posts = await getOneUserModulebyUserId(userId);
  document.getElementById("accordionHome").innerHTML = "";
  posts.sort(function (a, b) {
    return b.postId - a.postId;
  });
 if(posts.length == 0){
  document.getElementById("accordionHome").innerHTML += `<h1>NO POSTS</h1>`
 }
  for(let a of posts){
    let slicedDate= a.date.slice(0,-10);
    document.getElementById("accordionHome").innerHTML +=      `
    <div id="accordionTop${a.postId}"class="accordion-item boxstyle" style="margin-top:1em;margin-bottom:1em;">
    <div class="accordion-header" id="heading` +
      a.postId +
      `">
      <img src="../../resources/postIcon.png" style="height:2em;width:2em;">
      <a style="font-weight: bold;">` +
      a.firstName + " " + a.lastName +
      `</a>
      <a class="btn" style="text-align:end;color:red;Float:right;" onclick="deletePost1(`+a.postId+`)">Delete</a>
     <span style=" float:right;font-size: 0.8em;color:grey;">` +
     slicedDate+
      `<br></span> 
       </span><span style="color:rgb(69, 155, 212);font-size: 0.9em;">@` +
      a.userName +
      `</span></span><div class="border-bottom" style="margin-top:0.7em;">
        <p>` +
      a.content +
      `</p>
      </div>
       <div > <p><a class="btn btn-sm text-white" id="likeButton`+a.postId+`" type="button" onclick="likePost(`+a.userId+`,`+a.postId+`)"><span> Like</span >(<span id="likeStatus`+a.postId+`">`+a.likes+`</span>)</a><span>  </span><a class="btn text-white btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#collapse` +
      a.postId +
      `" aria-expanded="true" aria-controls="collapse` +
      a.postId +
      `"> Comments (`+a.comment.length +`)
        </a></p>
        <p id="likeInfo`+a.postId+`"></p>
        </div>
    </div>
    <div id="collapse` +
      a.postId +
      `" class="accordion-collapse collapse" aria-labelledby="headingNew` +
      a.postId +
      `" data-bs-parent="#accordion">
      <div class="accordion-`+a.postId+`"> 
      <ul class="list-group" id="comment`+a.postId+`" style="list-style: none;margin-bottom:0.5em"></ul>

    
      <textarea class="form-control form-control-sm bg-black text-white" style="display:inline-block;" id="inputComment`+a.postId+`"  maxlength = "500" rows="3"></textarea>
      
      <div id="commentSection`+a.postId+`">   <button class="btn btn-outline-info" styl onclick="createComment1(`+a.postId+`)">Chirp</button></div>
   
      <p id="commentInfo`+a.postId+`"></p>
    </div>
      </div>
    </div>
  </div>`;




  for(let b of a.comment){

    document.getElementById("comment" + b.postId).innerHTML +=  `<li id="commentOb${b.commentId}"class="list-group-item bg-black text-white">
    <img src="../../resources/commentIcon.png" style="height:1.5em;width:1.5em;">
    <span class="font-weight-bold" style="color:rgb(69, 155, 212);">  @`+b.userName+`</span>  `+ b.commentContent+` <a class="btn" style="text-align:end;color:red;Float:right;" id="deleteComment${b.commentId}" onclick="deleteComment1(${b.commentId})">delete</a></li>`;

}
  }
}
