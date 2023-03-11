import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { MDBBtn, MDBCard, MDBCardBody, MDBCardImage, MDBCol, MDBContainer, MDBIcon, MDBInput, MDBRow, MDBTypography } from 'mdb-react-ui-kit';
import CartServices from '../service/CartServices';
function ShippingAdress() {
    let [address,setAddress] = useState({addressLine1 :"",addressLine2:"",state:"",city:"",postalCode:"",country:"",phone:"",userName:"user123"});
    const navigate =useNavigate();
    const location = useLocation();
  const statePassed = location.state;
  
    const handleChange=(event)=>{
        const {name ,value}= event.target;
        setAddress({...address,[name]:value});
        console.log("address"+address.addressLine1);
    }

    const paymentpage =()=>{
        
        setAddress({...address,userName:sessionStorage.getItem("user_details")});
        console.log(address)
        CartServices.addshippingaddress(address).then((res)=>{
          console.log(res.data)
          const stateToPass = {
            TotalPrice1: statePassed,
            Addressid:res.data
          };
          navigate("/paymentpage", { state: stateToPass })
        }).catch(()=>{

        })
       
    }
  return (
    <div>
    <MDBContainer className="py-5" style={{ maxWidth: '1100px' }}>
      <MDBRow className="justify-content-center align-items-center">
        <MDBCol>
          <MDBCard className="my-4 shadow-3">
            <MDBRow className="g-0">
              <MDBCol md="6" className="d-xl-block bg-image">
                <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Others/extended-example/delivery.webp" alt="Sample photo" fluid />
                <div className='mask' style={{ backgroundColor: 'rgba(0, 0, 0, 0.6)' }}>
                  <div className="justify-content-center align-items-center h-100">
                    <div className="text-center" style={{ marginTop: '220px' }}>
                      <MDBIcon fas icon="truck text-white" size="3x" />
                      <p className="text-white title-style">DELIVERY</p>
                      <p className="text-white mb-0"></p>

                      <figure className="text-center mb-0">
                        <blockquote className="blockquote text-white">
                          <p className="pb-3">
                            <MDBIcon fas icon="quote-left text-primary" size="xs" style={{color: 'hsl(210, 100%, 50%)'}} />
                            <span className="lead font-italic">Everything at your doorstep.</span>
                            <MDBIcon fas icon="quote-right text-primary" size="xs" style={{color: 'hsl(210, 100%, 50%)'}} />
                          </p>
                        </blockquote>
                      </figure>
                    </div>
                  </div>
                </div>
              </MDBCol>
              <MDBCol md="6">
                <MDBCardBody className="p-md-5 text-black">
                  <MDBTypography tag="h3" className="mb-4 text-uppercase">Delivery Info</MDBTypography>


                  <MDBInput label='AddressLine1' name='addressLine1' type='text' className="mb-4" size="lg" onChange={handleChange} />
                  <MDBInput label='AddressLine2' name='addressLine2'  type='text' className="mb-4" size="lg" onChange={handleChange} />

                  <MDBRow>
                    <MDBCol md="6" className="mb-4">
                      <MDBInput label='State' name='state' type='text' size="lg" onChange={handleChange}/>
                    </MDBCol>
                    <MDBCol md="6" className="mb-4">
                      <MDBInput label='City' name='city' type='text' size="lg" onChange={handleChange}/>
                    </MDBCol>
                  </MDBRow>

                  <MDBInput label='Zip' type='text' name='postalCode' className="mb-4" size="lg" onChange={handleChange}/>
                  <MDBInput label='Country' name='country' type='text' className="mb-4" size="lg" onChange={handleChange}/>
                  <MDBInput label='Phone' name='phone' type='text' className="mb-4" size="lg" onChange={handleChange}/>
                  <div className="d-flex justify-content-end pt-3">
                    <MDBBtn size="lg"  className="ms-2" style={{backgroundColor: 'hsl(210, 100%, 50%)'}} onClick={()=>paymentpage()} >Place order</MDBBtn>
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

export default ShippingAdress