import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
// import { useHistory } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

function BasicExample() {
  var adminobj = JSON.parse(sessionStorage.getItem("admin"));
  console.log(adminobj);
  // const history = useHistory();
  const navigate = useNavigate();

  const handleProduct = () => {
    // history.push('/addproduct');
    navigate('/addproduct')
  }

  const handleCategory = () => {
    // history.push('/my-component');
    navigate('/addcategory')
  }
  const handleAllCategory = () => {
    // history.push('/my-component');
    navigate('/allcategory')
  }
  const handleAllProduct = () => {
    // history.push('/my-component');
    navigate('/allproduct')
  }
  const handleDelCategory = () => {
    // history.push('/my-component');
    navigate('/delcategory')
  }
  const handleDelProduct = () => {
    // history.push('/my-component');
    navigate('/delproduct')
  }

  const handleUpdateProduct = () => {
    // history.push('/my-component');
    navigate('/updateproduct')
  }
  return (
    <div>
    <Card style={{ width: '18rem' }}>
      {/* <Card.Img variant="top" src="https://e7.pngegg.com/pngimages/714/54/png-clipart-bourgeois-plumbing-ltd-plumber-hirth-plumbing-solahart-stillorgan-gas-heating-plumbing-plumbing-thumbnail.png" /> */}
      <Card.Body>
        <Button variant="primary" onClick={handleProduct}>Add Product</Button>
      </Card.Body>
      <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="" />
      <Card.Body>
        <Button variant="primary" onClick={handleAllProduct}>Show Products</Button>
      </Card.Body>
    </Card>
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="" />
      <Card.Body>
        <Button variant="primary" onClick={handleUpdateProduct}>Update Product</Button>
      </Card.Body>
    </Card>
    </Card>
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="" />
      <Card.Body>
        <Button variant="primary" onClick={handleDelProduct}>Delete Product</Button>
      </Card.Body>
    </Card>
    <Card style={{ width: '18rem' }}>
      {/* <Card.Img variant="top" src="https://www.shutterstock.com/image-vector/grunge-green-category-word-round-260nw-1794170542.jpg" /> */}
      <Card.Body>
        <Button variant="primary" onClick={handleCategory}>Add Category</Button>
      </Card.Body>
    </Card>
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="" />
      <Card.Body>
        <Button variant="primary" onClick={handleAllCategory}>Show Categories</Button>
      </Card.Body>
    </Card>
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="" />
      <Card.Body>
        <Button variant="primary" onClick={handleDelCategory}>Delete Category</Button>
      </Card.Body>
    </Card>
    <p>{adminobj.email}</p>
    <p>{adminobj.id}</p>
    </div>
  );
}

export default BasicExample;