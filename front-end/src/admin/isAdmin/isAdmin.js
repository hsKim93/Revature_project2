try {
    if (sessionStorage.getItem(isAdmin) !== "true") {
        sessionStorage.clear;
        location.href = "../../login/index.html";
    }
} catch (err) {
    sessionStorage.clear;
    location.href = "../../login/index.html";
}