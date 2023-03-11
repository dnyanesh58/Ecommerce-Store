import Admin from "./dashboard/Admin";
import Vendor from "./dashboard/Vendor";
import UnAuthorizedError401 from "./dashboard/UnAuthorizedError401";
import Home from "./Home";


const AuthorizationRouter = () => {
    return (
        sessionStorage.getItem("user_role") === "Role_Admin" ?
            <Admin></Admin> :
            sessionStorage.getItem("user_role") === "Role_Vendor" ?
                <Vendor></Vendor> :
                sessionStorage.getItem("user_role") === "Role_Customer" ?
                    <Home></Home>:
<UnAuthorizedError401></UnAuthorizedError401>
    )
}

export default AuthorizationRouter;

