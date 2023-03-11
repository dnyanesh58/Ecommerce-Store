export const isAdmin = () => {
    // const userInfoLocalStorage = localStorage.getItem('userInfo');
    if (sessionStorage.getItem("user_role") === "Role_Admin") {
    //   const token = JSON.parse(userInfoLocalStorage).token;
    //   let decodedToken = jwtDecode(token);
      return true;
    }
    return false;
  };
  export const isVendor = () => {
    // const userInfoLocalStorage = localStorage.getItem('userInfo');
    if (sessionStorage.getItem("user_role") === "Role_Vendor") {
    //   const token = JSON.parse(userInfoLocalStorage).token;
    //   let decodedToken = jwtDecode(token);
      return true;
    }
    return false;
  };

    export const isUserLoggedIn=() =>{
    console.log("Check Login Status")
    let loggedIn=sessionStorage.getItem("user_details") === null ? false : true;
    return loggedIn;
}