import React, { useEffect, useState } from 'react';
import { Button, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import UserServices from '../service/UserServices';
import { MDBContainer, MDBRating } from 'mdbreact';
import StarRatings from 'react-star-ratings';
const Product = (props) => {
  const product = props.Product;
  let [img, setImg] = useState({})
  let[cartItem,setCartItem] = useState({"productId":"",
                                        "quantity":"1"});
  // $('.rating').rating(options); 
  let [ratings,setratings]=useState(0);

  const cart=(productId)=>{
    setCartItem({...cartItem,"productId":productId})
  }
  const addToCart=()=>{
  
   
    console.log(cartItem.productId+"fdgh"+cartItem.quantity)
    UserServices.addTocart(cartItem).then(()=>console.log("product added to cart"))
  }
    useEffect(() => {
      console.log(product.productId)
        UserServices.getProfileImageByUserName(product.productId).then((resp) => {
            setImg(URL.createObjectURL(resp.data))
        }).catch((err) => {
           console.log(" Err in getting images", err)
        })
    }, [product.productId])

    useEffect(() => {
      UserServices.getallratings(product.productId).then((resp) => {
        // setImg(URL.createObjectURL(resp.data))
        let  array=resp.data;
        var element=0;
        console.log(resp.data.length+"length of")
        for (let index = 0; index < array.length; index++) {
           element =element+ array[index].ratingValue;
          
        }
        console.log("Ratings"+array.length+""+product.productId+"element"+element)
        const avg=element/array.length;
          setratings(avg);
    }).catch((err) => {
        console.log(" Err in ratings for products", err)
        setratings(0);
    })
    }, [product.productId])

  return (
    <>
      <Card className='my-3 rounded' style={{ height: '380px',padding:'5px'}}>
        <Link to={`/product/${product.productId}`}>
          <Card.Img
            src={product.image}
            variant='top'
            style={{ height: '200px' }}
          ></Card.Img>
        </Link>
        <Card.Body style={{padding:'5px'}}>
          <Link to={`/product/${product.productId}`}>
            <Card.Title as='div'>
              <strong>{product.title}</strong>
            </Card.Title>
          </Link>

          {/* <Card.Text as='div'>
            <Rating value={product.averageRating} text={`${product.noOfRatings} reviews`}></Rating>
          </Card.Text> */}

          <Card.Text as='div' className='my-3'>
            <p>Rs.{product.unitPrice}</p>
          </Card.Text>
        
          {/* <MDBContainer>
      <MDBRating data={1}/>
    </MDBContainer>
          */}
          <StarRatings  
          rating={ratings}
          starRatedColor="blue"
          // changeRating={this.changeRating}
          numberOfStars={5}
          name='rating'
          starDimension="18px"
          starSpacing="4px"
          style={{}}
        />
          <Button className='btn btn-primary' onMouseOver={()=>cart(product.productId)} onClick={()=>addToCart()}>ADD TO CART</Button>
          {/* <Button className='btn btn-primary' onClick={()=>Cart(product.productId)}>CART</Button> */}
        </Card.Body>
      </Card>
    </>
  );
};

export default Product;
