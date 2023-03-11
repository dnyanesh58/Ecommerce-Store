import React, { useState } from 'react';
import axios from 'axios';

function AddProduct() {
  const [title, settitle] = useState('');
  const [unitPrice, setunitPrice] = useState('');
  const [unitStock, setunitStock] = useState('');
  const [categoryId, setcategoryId] = useState('');
  const [image, setimage] = useState('');

  const handleNameChange = event => {
    settitle(event.target.value);
  };

  const handleImageChange = event => {
    setimage(event.target.value);
  };

  const handlePriceChange = event => {
    setunitPrice(event.target.value);
  };

  const handleStockChange = event => {
    setunitStock(event.target.value);
  };

  const handleCategoryChange = event => {
    setcategoryId(event.target.value);
  };

  const handleSubmit = event => {
    event.preventDefault();
    const newProduct = { title, unitPrice, unitStock, image };
    axios.post('http://localhost:8080/products/'+categoryId, newProduct)
      .then(response => {
        console.log(response.data);
        settitle('');
        setunitPrice('');
        setunitStock('');
        setcategoryId('');
        setimage('');
      })
      .catch(error => {
        console.log(error);
      });
  };

  return (
    <form class="form-group" onSubmit={handleSubmit}>
  <div class="form-group">
    <label for="productName">Product Name:</label>
    <input class="form-control" type="text" id="productName" value={title} onChange={handleNameChange} />
  </div>
  <div class="form-group">
    <label for="productPrice">Product Price:</label>
    <input class="form-control" type="text" id="productPrice" value={unitPrice} onChange={handlePriceChange} />
  </div>
  <div class="form-group">
    <label for="productImage">Product Image:</label>
    <input class="form-control" type="text" id="productImage" value={image} onChange={handleImageChange} />
  </div>
  <div class="form-group">
    <label for="productQuantity">Product Quantity:</label>
    <input class="form-control" type="number" id="productQuantity" value={unitStock} onChange={handleStockChange} />
  </div>
  <div class="form-group">
    <label for="categoryId">Category ID:</label>
    <input class="form-control" type="number" id="categoryId" value={categoryId} onChange={handleCategoryChange} />
  </div>
  <button class="btn btn-primary" type="submit">Add Product</button>
</form>

    // <form onSubmit={handleSubmit}>
    //   <label>
    //     Product Name:
    //     <input type="text" value={title} onChange={handleNameChange} />
    //   </label>
    //   <label>
    //     Product Price:
    //     <input type="text" value={unitPrice} onChange={handlePriceChange} />
    //   </label>
    //   <label>
    //     Product Image:
    //     <input type="text" value={image} onChange={handleImageChange} />
    //   </label>
    //   <label>
    //     Product Quantity:
    //     <input type="number" value={unitStock} onChange={handleStockChange} />
    //   </label>
    //   <label>
    //     Category ID:
    //     <input type="number" value={categoryId} onChange={handleCategoryChange} />
    //   </label>
    //   <button type="submit">Add Product</button>
    // </form>
  );
}

export default AddProduct;
