const editProfileButton = document.getElementById("editProfileButton");
const userId = sessionStorage.getItem("userId");

const loadMyProfile = async () => {
    const response = await fetch(url + "/user/" + userId, {
        method: "GET",
        mode: "cors"
    });

    if (response.status === 200) {
        const body = await response.json();
    } else {
        /**
         * fatal error. should never happen
         */
    }
}

const editMyProfile = async () => {
    const userName = document.getElementById("editUsername");
    const password = document.getElementById("editPassword");
    const firstName = document.getElementById("editFirstName");
    const lastName = document.getElementById("editLastName");
    const email = document.getElementById("editEmail");

    let newInfo = {};

    console.log(sessionStorage);

    if (userName.value === "") {
        newInfo.userName = sessionStorage.getItem("userName");
    }
    if (password.value === "") {
        newInfo.password = "";
    }
    if (firstName.value === "") {
        newInfo.firstName = sessionStorage.getItem("firstName");
    }
    if (lastName.value === "") {
        newInfo.lastName = sessionStorage.getItem("lastName");
    }
    if (email.value === "") {
        newInfo.email = sessionStorage.getItem("email");
    }

    console.log(newInfo);

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
    
    // if (response.status === 200) {
    //     document.getElementById("modal2").innerHTML += 
    //     `<div class="modal fade text-black" id="exampleModalToggle2" aria-hidden="true"
    //         aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
    //         <div class="modal-dialog modal-dialog-centered">
    //             <div class="modal-content">

    //                 <div class="modal-header">
    //                 <h5 class="modal-title" id="exampleModalToggleLabel2">
    //                      Modal 2
    //                 </h5>
    //                 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
    //                 </div>

    //                 <div class="modal-body">
    //                 Update Successful!
    //                 </div>

    //                 <div class="modal-footer">
    //                     <button class="btn btn-primary" data-bs-target="#profile" data-bs-toggle="modal">
    //                         Back to page
    //                     </button>
    //                 </div>

    //             </div>
    //         </div>
    //     </div>
    //     `
    //     console.log("Hi I worked");
    //     loadMyProfile();
    // } else {
    //     let message = await response.text();
    //     if (message === "duplicate user name") {
    //         message = "username is already taken";
    //     } else if (message === "duplicate email") {
    //         message = "email already exists";
    //     } else {
    //         message = "something went wrong, please try again."
    //     }
    //     document.getElementById("modal2").innerHTML += 
    //     `<div class="modal fade text-black" id="exampleModalToggle2" aria-hidden="true"
    //         aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
    //         <div class="modal-dialog modal-dialog-centered">
    //             <div class="modal-content">

    //                 <div class="modal-header">
    //                 <h5 class="modal-title" id="exampleModalToggleLabel2">
    //                      Modal 2
    //                 </h5>
    //                 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
    //                 </div>

    //                 <div class="modal-body">`
    //                 + message +
    //                 `</div>

    //                 <div class="modal-footer">
    //                     <button class="btn btn-primary" data-bs-target="#profile" data-bs-toggle="modal">
    //                         Back to page
    //                     </button>
    //                 </div>

    //             </div>
    //         </div>
    //     </div>
    //     `
    // }

}

editProfileButton.addEventListener("click", editMyProfile);
loadMyProfile();