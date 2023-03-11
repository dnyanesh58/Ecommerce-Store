import axios from "axios";

class AuthenticationService {
    constructor() {
        this.baseUrl = "http://localhost:8080/"
    }

    authenticateUser(user) {
        return axios.post(this.baseUrl + "admin/login", user);
    }

    removeUserDetails() {
        sessionStorage.removeItem("user_details");
        sessionStorage.removeItem("user_role");
        sessionStorage.removeItem("jwt");
    }

    storeUserDetails(userName, data) {
        console.log("In auth Service userName is", userName);
        console.log("In auth Service JWT is", data.jwt);
        this.setupRequestInterceptor();
        sessionStorage.setItem("user_details", userName);
        sessionStorage.setItem("user_role", data.roles[0].roleName);
        sessionStorage.setItem("jwt", data.jwt);
    }

    setupRequestInterceptor() {
        axios.interceptors.request.use((config) => {
            if (this.isUserLoggedIn()) {

                config.headers["Authorization"] = "Bearer " + sessionStorage.getItem("jwt");
            }
            return config;
        })
    }

    isUserLoggedIn() {
        console.log("Check Login Status")
        let loggedIn=sessionStorage.getItem("user_details") === null ? false : true;
        return loggedIn;
    }

    getUserName() {
        return sessionStorage.getItem("user_details")
    }
}

export default new AuthenticationService();