import React, { useState ,useEffect } from 'react'
import CartServices from '../service/CartServices'
import CartItems from './CartItems';
import { useNavigate } from 'react-router-dom';
import Payment from './Payment';
function Cart() {
    let [cartItems,setCartItems]=useState([{}])
    const username=sessionStorage.getItem("user_details");
    const navigate =useNavigate();
    let [totalprice,settotalprice]=useState(0);
    // let totalprice=0;
    useEffect(() => {
        CartServices.getCartItem(username).then((res)=>{
            setCartItems(res.data);
            console.log("cart items")
            let price=0;
            for (let index = 0; index < res.data.length; index++) {
                price=price+parseInt(res.data[index].itemPrice);
            }
            settotalprice(price);
        })
    }, [])
    
    const shipping = () =>{
        navigate("/shipmentAddress", { state: totalprice })
    }


  return (
    <div>
        <section class="h-100" style={{background:"#eee"}}>
  <div class="container h-100 py-5">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-10">

        <div class="d-flex justify-content-between align-items-center mb-4">
          <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
        </div>
        { cartItems.map((c)=>{
            return (
                <div>
                    <CartItems CartItems={c}></CartItems>
                </div>
        )})}  
        <div class="card">
          <div class="card-body">
          <div>
                <h5 class="mb-0">Total Price = Rs.{totalprice}</h5>
              </div>
            <hr/>
            
         
            <button type="button" class="btn btn-warning btn-block btn-lg" onClick={()=>shipping()}>Proceed to Pay</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
                <Payment></Payment>
    </div>
  )

  }
export default Cart;