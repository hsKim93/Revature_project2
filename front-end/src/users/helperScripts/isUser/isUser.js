try {
    sessionStorage.getItem(isAdmin);
} catch (err) {
    sessionStorage.clear;
    location.href = "../../login/index.html";
}