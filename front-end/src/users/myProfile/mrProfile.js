
let userId = sessionStorage.getItem(userId)

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

    /**
     * @todo
     * get newInfo json
     */

    const response = await fetch(url + "/user/" + userId, {
        method: "UPDATE",
        mode: "cors",
        body: JSON.stringify(newInfo),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });

    
}


loadMyProfile();