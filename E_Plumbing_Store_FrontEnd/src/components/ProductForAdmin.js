import React, { useEffect, useState } from 'react';
import { Button, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import UserServices from '../service/UserServices';
import { MDBContainer, MDBRating } from 'mdbreact';
import StarRatings from 'react-star-ratings';
import AdminServices from '../service/AdminServices';
const ProductForAdmin = (props) => {
  const product = props.Product;
  let [img, setImg] = useState({}) 
  let [ratings,setratings]=useState(0);
    useEffect(() => {
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
    
    const deleteproduct=(productId) =>{
        console.log(productId);
        AdminServices.deleteProduct(productId).then(()=>console.log("deleted"+productId));
    }

  return (
    <>
      <Card className='my-3 rounded' style={{ height: '380px',padding:'5px'}}>
        <Link to={`/product/${product.productId}`}>
          <Card.Img
            src={img}
            variant='top'
            style={{ height: '200px' }}
          ></Card.Img>
        </Link>
        <Card.Body style={{padding:'5px'}}>
          <Link to={`/product/${product.productId}`}>
            <Card.Title as='div'>
              <strong>{product.productName}</strong>
            </Card.Title>
          </Link>

          {/* <Card.Text as='div'>
            <Rating value={product.averageRating} text={`${product.noOfRatings} reviews`}></Rating>
          </Card.Text> */}

          <Card.Text as='div' className='my-3'>
            <p>Rs.{product.price}</p>
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
          <Button className='btn btn-Danger' onClick={()=>deleteproduct(product.productId)} >DELETE PRODUCT</Button>
        </Card.Body>
      </Card>
    </>
  );
};

export default ProductForAdmin;
