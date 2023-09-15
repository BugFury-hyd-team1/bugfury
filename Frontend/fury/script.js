// Simulated user database for registration and login
var users = [];

function validateRegistration() {
    var email = document.getElementById("email").value;
    var role = document.getElementById("role").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    // Check if the email is already registered
    if (users.some(user => user.email === email)) {
        var registrationError = document.getElementById("registration-error");
        registrationError.innerText = "Email address is already registered.";
        return;
    }

    // Check if the password meets the strong typing criteria (e.g., at least 8 characters)
    if (password.length < 8) {
        var registrationError = document.getElementById("registration-error");
        registrationError.innerText = "Password should be at least 8 characters long.";
        return;
    }

    // Check if the password and confirm password match
    if (password !== confirmPassword) {
        var registrationError = document.getElementById("registration-error");
        registrationError.innerText = "Passwords do not match.";
        return;
    }

    // Add the new user to the user database
    users.push({ email: email, role: role, password: password });
    var registrationSuccess = document.getElementById("registration-success");
    registrationSuccess.innerText = "Registration successful! Please proceed to login.";
window.location.href = "login1.html";
}

function validateLogin() {
    var loginEmail = document.getElementById("login-email").value;
    var loginPassword = document.getElementById("login-password").value;

    // Check if the user exists and credentials match
    var user = users.find(user => user.email === loginEmail && user.password === loginPassword);

    if (!user) {
        var loginError = document.getElementById("login-error");
        loginError.innerText = "Invalid email or password. Please try again.";
        return;
    }

    // Check if the user is already logged in
    if (user.isLoggedIn) {
        var loginError = document.getElementById("login-error");
        loginError.innerText = "User is already logged in.";
        return;
    }

    // Mark the user as logged in
    user.isLoggedIn = true;

    // Successful login, you can redirect the user to another page
    alert("Login successful!");
    window.location.href = "manager.html"; // Replace with the desired URL
}
