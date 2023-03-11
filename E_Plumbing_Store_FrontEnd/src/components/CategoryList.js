import React, { useState, useEffect } from 'react';
import axios from 'axios';

function CategoryList() {
  const [categories, setcategories] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/categories')
      .then(response => setcategories(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div class="container">
  <h1>Category List</h1>
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
        <th>CategoryId</th>
        <th>Title</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
      {categories.map(category => (
        <tr key={category.id}>
          <td>{category.id}</td>
          <td>{category.title}</td>
          <td>{category.description}</td>
        </tr>
      ))}
    </tbody>
  </table>
</div>


    // <div>
    //   <h1>Category List</h1>
    //   <ul className="category-list">
    //     {categories.map(categories => (
    //       <li key={categories.id} className="category-item">
    //         {categories.title}
            
    //         {categories.description}
    //       </li>
    //     ))}
    //   </ul>
    // </div>
  );
}

export default CategoryList;