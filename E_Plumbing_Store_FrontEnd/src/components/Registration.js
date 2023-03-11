import React, { useState } from 'react';
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
import UserServices from '../service/UserServices';
import { useNavigate } from 'react-router-dom';

function Registration() {
  let [user ,setUser]= useState({userName:"",firstName:"",lastName:"",email:"",password:"",roleNames : []});
 let [role,setRole]=useState({roleNames : []});
  const handleChange = (event) => {
    const { name, value } = event.target
    setUser({ ...user, [name]: value })
    console.log(user+"user")
  }
  const navigate = useNavigate();
  const handleChange1 = (e) => {
    // Destructuring
    const { value, checked } = e.target;
    const { roleNames } = role;
      
    console.log(`${value} is ${checked}`);
     
    // Case 1 : The user checks the box
    if (checked) {
      setUser({
        ...user,roleNames: [...roleNames, value],
        
      });
      
    }
  
    // Case 2  : The user unchecks the box
    else {
      setUser({
        ...user,roleNames: roleNames.filter((e) => e !== value),
      });
    }
  };    
    const registerUser=(event)=>{
      event.preventDefault();
    // checkAll();
    
      console.log(user.roleNames+"fghdj");
      console.log("inside register user")
      UserServices.registerUSer(user).then(
        (result)=>console.log(result.data),
      navigate("/login")
      ).catch(()=> {})
    }
  return (
    <MDBContainer className='my-5'>
      <MDBCard>

        <MDBRow className='g-0 d-flex align-items-center'>
        <MDBCol md='2'></MDBCol>
          <MDBCol md='4'>
            <MDBCardImage src='https://images.pexels.com/photos/1907785/pexels-photo-1907785.jpeg?auto=compress&cs=tinysrgb&w=600' 
            alt='phone' className='rounded-t-5 rounded-tr-lg-0' fluid />
          </MDBCol>
          <MDBCol md='2'></MDBCol>  
          <MDBCol md='4' >
            <form action='/' onSubmit={registerUser} method="POST">
            <MDBCardBody>
              <MDBInput wrapperClass='mb-4' label='Fisrt Name' id='first_name' type='text' onChange={handleChange} name="firstName" />
              <MDBInput wrapperClass='mb-4' label='Last Name' id='last_name' type='text' onChange={handleChange} name="lastName"/>
              <MDBInput wrapperClass='mb-4' label='Email address' id='email' type='email' onChange={handleChange} name="email"/>
              <MDBInput wrapperClass='mb-4' label='User Name' id='user_name' type='text' onChange={handleChange} name="userName"/>
              <MDBInput wrapperClass='mb-4' label='Password' id='password' type='password' onChange={handleChange} name="password"/>
              <div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="roleNames" id="Role_Admin" value="Role_Admin" onChange={handleChange1}  />
  <label class="form-check-label" for="Role_Admin">Admin</label>
</div>

<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="roleNames" id="Role_Customer" value="Role_Customer" onChange={handleChange1} />
  <label class="form-check-label" for="Role_Customer">Customer</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="roleNames" id="Role_Vendor" value="Role_Vendor" onChange={handleChange1}/>
  <label class="form-check-label" for="Role_Vendor">Vendor</label>
</div>

              <MDBBtn type='submit' className="mb-4 w-100">Register</MDBBtn>

            </MDBCardBody>
          </form>
          </MDBCol>

        </MDBRow>

      </MDBCard>
    </MDBContainer>
  );
}

export default Registration;