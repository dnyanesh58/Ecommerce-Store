import React, { useEffect, useState } from 'react'

import {
    MDBContainer,
    MDBNavbar,
    MDBNavbarBrand,
    MDBNavbarToggler,
    MDBIcon,
    MDBNavbarNav,
    MDBNavbarItem,
    MDBNavbarLink,
    MDBBtn,
    MDBDropdown,
    MDBDropdownToggle,
    MDBDropdownMenu,
    MDBDropdownItem,
    MDBCollapse,
    MDBInputGroup
  } from 'mdb-react-ui-kit'
import { isAdmin ,isUserLoggedIn} from '../service/common';
function Header() {

  const [userInfo, setuserInfo] = useState("");
  useEffect(() => {
    isUserLoggedIn()?(setuserInfo(sessionStorage.getItem("user_details"))):setuserInfo("");
  },[])
  
  
    const [showBasic, setShowBasic] = useState(false);
  return (
    <div>
    <MDBNavbar expand='lg' light bgColor='light' className='fixed-top'>
    <MDBContainer fluid>
      <MDBNavbarBrand href='/'>Plumbing Store</MDBNavbarBrand>

      <MDBNavbarToggler
        aria-controls='navbarSupportedContent'
        aria-expanded='false'
        aria-label='Toggle navigation'
        onClick={() => setShowBasic(!showBasic)}
      >
        <MDBIcon icon='bars' fas />
      </MDBNavbarToggler>

      <MDBCollapse navbar show={showBasic}>
        <MDBNavbarNav right fullWidth={false} className='mr-auto mb-2 mb-lg-0'>
          <MDBNavbarItem>
            
            <MDBNavbarLink active aria-current='page' href='/'>
              HOME
            </MDBNavbarLink>
          </MDBNavbarItem>
          
         
          <MDBNavbarItem>
            <MDBNavbarLink active aria-current='page' href='/login'>
              LOGIN 
            </MDBNavbarLink>
          </MDBNavbarItem>
          <MDBNavbarItem>
            <MDBNavbarLink active aria-current='page' href='/login'>
              LOGOUT
            </MDBNavbarLink>
          </MDBNavbarItem>
          <MDBNavbarItem>
            <MDBNavbarLink active aria-current='page' href='/login'>
            {userInfo}
            </MDBNavbarLink>
          </MDBNavbarItem>
         
          {/* <MDBNavbarItem>
              <MDBDropdown>
                <MDBDropdownToggle tag='a' className='nav-link b' role='button'>
                  Category
                </MDBDropdownToggle>
                <MDBDropdownMenu>
                  <MDBDropdownItem link>CAT1</MDBDropdownItem>
                  <MDBDropdownItem link>CAT2</MDBDropdownItem>
                  <MDBDropdownItem link>CAT3</MDBDropdownItem>
                </MDBDropdownMenu>
              </MDBDropdown>
            </MDBNavbarItem> */}
        
          {/* <MDBNavbarItem>
            <MDBNavbarLink active aria-current='page' href='/cart'>
              CART<a href="/cart"><i class="fas fa-shopping-cart text-dark"></i></a>
            </MDBNavbarLink>
          </MDBNavbarItem> */}
        
          <MDBNavbarItem>
            <MDBNavbarLink href='/cart'>
            <a href="/cart"><i class="fas fa-shopping-cart text-dark"></i></a>
            </MDBNavbarLink>
          </MDBNavbarItem>
          <MDBInputGroup tag="form" className='d-flex w-auto mb-3'>
              <input className='form-control' placeholder="Search Product" aria-label="Search" type='Search' />
              <MDBBtn outline >Search</MDBBtn>
            </MDBInputGroup>
        </MDBNavbarNav>
      </MDBCollapse>
    </MDBContainer>
  </MDBNavbar>
  </div>
  )
}

export default Header
