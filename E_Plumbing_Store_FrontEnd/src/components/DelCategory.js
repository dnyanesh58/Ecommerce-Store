import React, { useState } from 'react';
import axios from 'axios';

function DeleteCategoryById() {
  const [categoryId, setCategoryId] = useState('');
  const [message, setMessage] = useState('');

  const handleDelete = () => {
    axios.delete(`http://localhost:8080/categories/`+categoryId)
      .then(response => {
        setMessage(`Category with ID ${categoryId} was deleted successfully.`);
        setCategoryId('');
      })
      .catch(error => {
        setMessage(`Error deleting category with ID ${categoryId}: ${error.message}`);
      });
  };

  return (
    <div>
      <h2>Delete Category by ID</h2>
      <p>Enter the ID of the category you want to delete:</p>
      <input type="text" value={categoryId} onChange={e => setCategoryId(e.target.value)} />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default DeleteCategoryById;
