import React, { useEffect, useState } from 'react'
import AdminServices from '../service/AdminServices';
import UserServices from '../service/UserServices';

function UserList() {
  let [user,setUser]=useState([{}]);
    useEffect(()=>{
        UserServices.getAllUser().then((result)=>{
            console.log(result.data);
            setUser(result.data);
        }).catch(()=>{
          
        })
    },[])
    const deleteUser=(userId)=>{
        AdminServices.deleteUser(userId).then(()=>console.log("user Deleted")).catch(()=>{

        });
    }
    return (
    <div>
        <table class="table">
  <thead>
    <tr>
      <th scope="col">UserId</th>
      <th scope="col">UserName</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Email</th>
      <th scope="col">DeleteUser</th>
    </tr>
  </thead>
  <tbody>
         {   user.map((u)=>{
    return(                
    <tr>
      <td>{u.userId}</td>
      <td>{u.userName}</td>
      <td>{u.firstName}</td>
      <td>{u.lastName}</td>
      <td>{u.email}</td>
      <td><button className='btn btn-danger' onClick={()=>deleteUser(u.userId)}><i class="far fa-trash-alt"></i></button></td>
    </tr>
  
  ) })}
         </tbody>
         </table>   

        
    </div>
  )
}

export default UserList