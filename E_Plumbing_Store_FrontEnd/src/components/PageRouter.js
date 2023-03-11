import React from 'react'
import {Link , Route , Routes ,BrowserRouter } from 'react-router-dom'
import Registration from './Registration'
import Login from './Login'
import Home from './Home'
import AuthenticationService from '../service/AuthenticationService'
import Header from './Header'
import Footer from './Footer'
function PageRouter() {
  return (
    <div>
        {console.log("User Role", sessionStorage.getItem("user_role"))}
            {
                AuthenticationService.setupRequestInterceptor()
            }
            
           
         
            
    </div>
  )
}

export default PageRouter