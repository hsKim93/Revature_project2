const url = "http://localhost:8080/";

async function createPost(getP, method) {
  const rqjson = {
    postId: 0,
    userId: sessionStorage.getItem("userId"),
    content: "Testing postman",
    date: "",
  };
  let response = await fetch(url + "post/create", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  return responseBody;
}

async function getPostbyUserId(id) {
  let response = await fetch(url + `post/byUserId/${id}`, {
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

async function getPostbyId(id) {
  let response = await fetch(url + `post/byPostId/${id}`, {
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

async function getLikesByPostId(id) {
  let response = await fetch(url + `post/likes/${id}`, {
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

async function getUserById(id) {
  let response = await fetch(url + `user/${id}`, {
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

async function getCommentsByPostId(id) {
    let response = await fetch(url + `comment/postId/${id}`, {
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

async function likePost(userId, postId) {
  const rqjson = {
    userId: userId,
    PostId: postId,
  };

  let response = await fetch(url + "post/like", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  return responseBody;
}

async function unlikePost(userId, postId) {
  const rqjson = {
    userId: userId,
    PostId: postId,
  };

  let response = await fetch(url + "post/unlike", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    body: JSON.stringify(rqjson),
  });
  let responseBody = await response.json();
  return responseBody;
}

async function getFollowingByUserId(id) {
  let response = await fetch(url + `following/${id}`, {
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

async function loadPostModule() {
  let userId = 8001;
  let following = await getFollowingByUserId(userId);

  let postList = [];
  for (let users of following) {
    userPosts = await getPostbyUserId(users);

    console.log(userPosts);
    for (let post of userPosts) {
      let user = await getUserById(post.userId);
      post.fullName = user.firstName + " " + user.lastName;
      post.date= post.date.slice(0,-10);
      post.userName = user.userName;
      post.comments = await getCommentsByPostId(post.postId);
      post.likes= await getLikesByPostId(post.postId);
      postList.push(post);
    }
  }
  postList.sort(function (a, b) {
    return a.postId - b.postId;
  });
  console.log(postList);

  for (let a of postList) {

    document.getElementById("accordionHome").innerHTML += 
      `
    <div class="accordion-item bg-black border-dark p-1">
    <div class="accordion-header" id="heading` +
      a.postId +
      `">
      <img src="postIcon.png" style="height:2em;width:2em;">
      <a style="font-weight: bold;">` +
      a.fullName +
      `</a>
     <span style=" font-size: 0.8em;color:grey;">` +
      a.date+
      `<br><span>  </span><span style="color:rgb(69, 155, 212);font-size: 0.9em;">@` +
      a.userName +
      `</span></span>
        <p>` +
      a.content +
      `</p>
        <p><a class="btn btn-sm text-white" type="button">Like (`+a.likes+`)<a><span>  </span><a class="btn text-white btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#collapse` +
      a.postId +
      `" aria-expanded="true" aria-controls="collapse` +
      a.postId +
      `"> Comments (`+a.comments.length +`)
        </a></p>
    </div>
    <div id="collapse` +
      a.postId +
      `" class="accordion-collapse collapse" aria-labelledby="heading` +
      a.postId +
      `" data-bs-parent="#accordion">
      <div class="accordion-`+a.postId+`"> 
      <ul class="list-group" id="comment`+a.postId+`"></ul>

      <div class="row justify-content-evenly">
      <div class="col-lg-10 col-md-10 col-sm-8">

      <textarea class="form-control form-control-sm bg-black text-white" style="display:inline-block;" id="exampleFormControlTextarea1"  maxlength = "500" rows="3"></textarea>
       </div>
      <div class="col-lg-2 col-md-2 col-sm-4"><button type="button" style="display:inline-block;" class="btn btn-outline-info align-self-center ">Chirp</button>   </div>
      </div>
    </div>
      </div>
    </div>
  </div>`;
  for(let b of a.comments){
      let user = await getUserById(b.userId)
      document.getElementById("comment" + b.postId).innerHTML +=  `<li class="list-group-item bg-black text-white"><img src="commentIcon.png" style="height:1.5em;width:1.5em;"><span class="font-weight-bold" style="color:rgb(69, 155, 212);">  @`+user.userName+`  </span>`+ b.commentContent+`</li>`

  }
  }
}