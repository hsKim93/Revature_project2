try {
    if (!sessionStorage.getItem("isAdmin")) {
        sessionStorage.clear;
        location.href = "../../login/index.html";
    }
} catch (err) {
    sessionStorage.clear;
    location.href = "../../login/index.html";
}