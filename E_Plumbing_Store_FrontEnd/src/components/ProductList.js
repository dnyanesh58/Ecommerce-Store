import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ProductList() {
  const [product, setproduct] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/products')
      .then(response => setproduct(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div class="container">
  <h1>Product List</h1>
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
        <th>ProductId</th>
        <th>Title</th>
        <th>Price</th>
        <th>Stock</th>
      </tr>
    </thead>
    <tbody>
      {product.map(Product => (
        <tr key={Product.id}>
          <td>{Product.id}</td>
          <td>{Product.title}</td>
          <td>{Product.unitPrice}</td>
          <td>{Product.unitStock}</td>
        </tr>
      ))}
    </tbody>
  </table>
</div>


    // <div>
    //   <h1>Product List</h1>
    //   <ul className="Product-list">
    //     {product.map(product => (
    //       <li key={product.id} className="Product-item">
    //         {product.title}
            
    //         {product.description}
    //       </li>
    //     ))}
    //   </ul>
    // </div>
  );
}

export default ProductList;