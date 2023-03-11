import React, { useState } from 'react';
import axios from 'axios';

function AddProduct() {
  const [title, settitle] = useState('');
  const [description, setdescription] = useState('');

  const handleNameChange = event => {
    settitle(event.target.value);
  };

  const handleDescriptionChange = event => {
    setdescription(event.target.value);
  };

  const handleSubmit = event => {
    event.preventDefault();
    const newCategory = { title, description };
    axios.post('http://localhost:8080/categories', newCategory)
      .then(response => {
        console.log(response.data);
        settitle('');
        setdescription('');
      })
      .catch(error => {
        console.log(error);
      });
  };

  return (
    <form onSubmit={handleSubmit} class="form">
  <div class="form-group">
    <label for="category-name">Category Name:</label>
    <input type="text" class="form-control" id="category-name" value={title} onChange={handleNameChange} />
  </div>
  <div class="form-group">
    <label for="category-description">Category Description:</label>
    <input type="text" class="form-control" id="category-description" value={description} onChange={handleDescriptionChange} />
  </div>
  <button type="submit" class="btn btn-primary">Add Category</button>
</form>


    // <form onSubmit={handleSubmit}>
    //   <label>
    //     Category Name:
    //     <input type="text" value={title} onChange={handleNameChange} />
    //   </label>
    //   <label>
    //     Category Description:
    //     <input type="text" value={description} onChange={handleDescriptionChange} />
    //   </label>
    //   <button type="submit">Add Category</button>
    // </form>
  );
}

export default AddProduct;