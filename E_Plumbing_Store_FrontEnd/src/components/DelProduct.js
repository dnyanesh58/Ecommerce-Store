import React, { useState } from 'react';
import axios from 'axios';

function DeleteProductById() {
  const [ProductId, setProductId] = useState('');
  const [message, setMessage] = useState('');

  const handleDelete = () => {
    axios.delete(`http://localhost:8080/products/`+ProductId)
      .then(response => {
        setMessage(`Product with ID ${ProductId} was deleted successfully.`);
        setProductId('');
      })
      .catch(error => {
        setMessage(`Error deleting Product with ID ${ProductId}: ${error.message}`);
      });
  };

  return (
    <div>
      <h2>Delete Product by ID</h2>
      <p>Enter the ID of the Product you want to delete:</p>
      <input type="text" value={ProductId} onChange={e => setProductId(e.target.value)} />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default DeleteProductById;
