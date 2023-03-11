

const UnAuthorizedUser=()=>{
    console.log("session storage"+sessionStorage.getItem("user_role"));
    return(
        <div>
          inside uautherised
          
        </div>
    )
}

export default UnAuthorizedUser;