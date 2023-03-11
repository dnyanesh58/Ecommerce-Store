import React , {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBCardImage,
  MDBRow,
  MDBCol,
  MDBInput,
  MDBCheckbox
}
from 'mdb-react-ui-kit';
import AuthenticationService from '../service/AuthenticationService';
import Cart from './Cart';
import ProductAdd from './ProductAdd';
function Login() {
  let [userCred, setUserCred] = useState({ userName: "", password: "" });
  const [loginStatus, setLoginStatus] = useState("");
    const navigate = useNavigate();
    const validateUser = (event) => {
        event.preventDefault();
        console.log("in validate")
        AuthenticationService.authenticateUser(userCred)
            .then((resp) => {
                console.log("Auth Successful")
                console.log("User jwt", resp.data.jwt);
                console.log("User role", resp.data.roles[0].roleName);
                AuthenticationService.storeUserDetails(userCred.userName, resp.data);
                console.log("Login User Role Check", sessionStorage.getItem("user_role"))
                navigate("/dashboard")
            })
            .catch((err) => {
                console.log("Failed Auth", err);
                setLoginStatus("wrong credentials");
            })
    }
    const handleChange = (event) => {
      const { name, value } = event.target
      setUserCred({ ...userCred, [name]: value })
  }
  return (
    <div>
    <MDBContainer className='my-5'>
      <MDBCard>

        <MDBRow className='g-0 d-flex align-items-center'>
        <MDBCol md='2'></MDBCol>
          <MDBCol md='4'>
            <MDBCardImage src='https://media.istockphoto.com/id/1205230318/photo/male-plumber-using-wrench-to-fix-leaking-sink-in-home-bathroom.jpg?s=612x612&w=0&k=20&c=5tDjKkW64qQNUwTdegcvBkHqQEvIEnRLsXjsMdk_VKY=' 
            alt='phone' className='rounded-t-5 rounded-tr-lg-0' fluid />
          </MDBCol>
          <MDBCol md='2'></MDBCol>  
          <MDBCol md='4' >
            <form action='' onSubmit={validateUser} method="POST">
            <MDBCardBody>
            {loginStatus === "wrong credentials" && <p>Incorrect username or password</p>}
              <MDBInput wrapperClass='mb-4' label='UserName' id='user_name' name='userName' type='text' onChange={handleChange}/>
              <MDBInput wrapperClass='mb-4' label='Password' id='password' name='password' type='password' onChange={handleChange}/>
                
            
              <div className="d-flex justify-content-evenly mx-4 mb-4 ">
               <a href="/registration">Registration</a> 
                <a href="!#">Forgot password?</a>
              </div>

              <MDBBtn type='submit' className="mb-4 w-100">Sign in</MDBBtn>

            </MDBCardBody>
            </form>
          </MDBCol>

        </MDBRow>

      </MDBCard>
    </MDBContainer>
    
    </div>
  );
    
  }
export default Login;