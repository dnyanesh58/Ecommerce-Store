import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { MDBBtn,MDBDropdown,MDBDropdownItem,MDBDropdownMenu,MDBDropdownToggle, MDBCard, MDBCardBody, MDBCardImage, MDBCol, MDBContainer, MDBIcon, MDBInput, MDBRow, MDBTypography } from 'mdb-react-ui-kit';
import VendorServices from '../service/VendorServices';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown'
function ProductAdd() {
    let [product,setProduct] = useState({ productName:"",price:"",description:"",productCategoryId:"2",availableItemCount:""});
    let [image,setImage] = useState({});
    let [productId,setProductId]=useState()
    const navigate =useNavigate();
    const location = useLocation();
  const statePassed = location.state;
  const [value,setValue]=useState('');
  const handleSelect=(e)=>{
    console.log(e)
    setProduct({...product,productCategoryId:e});
    console.log(product);
  }
  
    const handleChange=(event)=>{
        const {name ,value}= event.target;
        setProduct({...product,[name]:value});
        console.log(product);
        
    }
    
    const handleChange1=(event)=>{
        const {name,value}=event.target;
        setImage({image,[name]:value})
    }

    const addProduct=()=>{
        console.log(product)
        VendorServices.AddProduct(product).then((resp)=>{
            console.log("product Added")
            setProductId(resp.data)
        })
    }

    const uploadImage=()=>{
        VendorServices.AddImage(image,productId).then((resp)=>{
            console.log("added succeessfully")
        })
    }

  return (
    <div>
    <MDBContainer className="py-5" style={{ maxWidth: '1100px' }}>
      <MDBRow className="justify-content-center align-items-center">
      <MDBCol md="2"></MDBCol>
        <MDBCol>
          <MDBCard className="my-4 shadow-3">
            <MDBRow className="g-0">
              <MDBCol md="4" className="d-xl-block bg-image h-100">
                <MDBCardImage src="https://images.unsplash.com/photo-1532012197267-da84d127e765?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80" alt="Sample photo" fluid />
                <div className='mask' style={{ backgroundColor: 'rgba(0, 0, 0, 0.6)' }}>
                  <div className="justify-content-center align-items-center h-100">
                    <div className="text-center" style={{ marginTop: '220px' }}>
                      <MDBIcon fas icon="truck text-white" size="3x" />
                      <p className="text-white title-style">VENDOR PORTAL</p>
                      <p className="text-white mb-0"></p>
                    </div>
                  </div>
                </div>
              </MDBCol>
              <MDBCol md="6">
                <MDBCardBody className="p-md-5 text-black">
                  <MDBTypography tag="h3" className="mb-4 text-uppercase">Product Add</MDBTypography>


                  <MDBInput label='productName' name='productName' type='text' className="mb-4" size="lg" onChange={handleChange} />
                  <MDBInput label='price' name='price'  type='text' className="mb-4" size="lg" onChange={handleChange} />
                  <MDBInput label='description' name='description'  type='text' className="mb-4" size="lg" onChange={handleChange} />
                  {/* <MDBInput label='productCategory' name='productCategory' type='' className="mb-4" size="lg" onChange={handleChange} /> */}
                  
                  <MDBInput label='Quantity' name='availableItemCount' type='text' className="mb-4" size="lg" onChange={handleChange}/>
                  {/* <MDBDropdown className='md-4'> */}
                {/* <MDBDropdownToggle tag='a' role='button'>
                  ProductCategory
                </MDBDropdownToggle> */}
                {/* <MDBDropdownMenu value={"1"} onChange={handleChange}>
                  <MDBDropdownItem  value1="1">CAT1</MDBDropdownItem>
                  <MDBDropdownItem  value1="2">CAT2</MDBDropdownItem>
                  <MDBDropdownItem  value1="3">CAT3</MDBDropdownItem>
                  <MDBDropdownItem  value1="4">CAT4</MDBDropdownItem>
                </MDBDropdownMenu>
              </MDBDropdown> */}
              <DropdownButton
      alignRight
      title="Select category"
      id="dropdown-menu-align-right"
      onSelect={handleSelect}
        >
              <Dropdown.Item eventKey="1">option-1</Dropdown.Item>
              <Dropdown.Item eventKey="2">option-2</Dropdown.Item>
              <Dropdown.Item eventKey="3">option 3</Dropdown.Item>
              <Dropdown.Divider />
              <Dropdown.Item eventKey="some link">some link</Dropdown.Item>
      </DropdownButton>
                  <div className="d-flex justify-content-end pt-3">
                    <MDBBtn size="lg"  className="ms-2" style={{backgroundColor: 'hsl(210, 100%, 50%)'}} onClick={addProduct} >Add Product</MDBBtn>
                  </div>
                  <br></br>
                  
                  <MDBInput label='image' name='image'  type='file' className="mb-4" size="lg" onChange={handleChange1} />
                  <div className="d-flex justify-content-end pt-3">
                    <MDBBtn size="lg"  className="ms-2" style={{backgroundColor: 'hsl(210, 100%, 50%)'}} onClick={uploadImage} >Add Image</MDBBtn>
                  </div>
                </MDBCardBody>
              </MDBCol>
            </MDBRow>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
    </div>
  )
}

export default ProductAdd