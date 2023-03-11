import React, { useState } from "react";

function Admin() {
  const [productName, setProductName] = useState("");
  const [productDescription, setProductDescription] = useState("");
  const [productPrice, setProductPrice] = useState("");
  const [categoryName, setCategoryName] = useState("");
  const [categoryDescription, setCategoryDescription] = useState("");

  const handleProductSubmit = (event) => {
    event.preventDefault();
    // Call API to add product with the values of productName, productDescription, and productPrice
    // Reset the form values
    setProductName("");
    setProductDescription("");
    setProductPrice("");
  };

  const handleCategorySubmit = (event) => {
    event.preventDefault();
    // Call API to add category with the values of categoryName and categoryDescription
    // Reset the form values
    setCategoryName("");
    setCategoryDescription("");
  };

  return (
    <div>
      <h2>Add Product</h2>
      <form onSubmit={handleProductSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={productName}
            onChange={(event) => setProductName(event.target.value)}
          />
        </label>
        <br />
        <label>
          Description:
          <input
            type="text"
            value={productDescription}
            onChange={(event) => setProductDescription(event.target.value)}
          />
        </label>
        <br />
        <label>
          Price:
          <input
            type="text"
            value={productPrice}
            onChange={(event) => setProductPrice(event.target.value)}
          />
        </label>
        <br />
        <button type="submit">Add Product</button>
      </form>

      <h2>Add Category</h2>
      <form onSubmit={handleCategorySubmit}>
        <label>
          Name:
          <input
            type="text"
            value={categoryName}
            onChange={(event) => setCategoryName(event.target.value)}
          />
        </label>
        <br />
        <label>
          Description:
          <input
            type="text"
            value={categoryDescription}
            onChange={(event) => setCategoryDescription(event.target.value)}
          />
        </label>
        <br />
        <button type="submit">Add Category</button>
      </form>
    </div>
  );
}

export default Admin;
