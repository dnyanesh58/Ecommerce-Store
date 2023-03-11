import logo from './logo.svg';
import './App.css';
import Home from './components/Home';
import Header from './components/Header';
import Footer from './components/Footer';
import Registration from './components/Registration';
import {Link , Route , Routes ,BrowserRouter } from 'react-router-dom'
import Login from './components/Logins';
// import AuthorizationRouter from './components/AuthorizationRouter';
import Cart from './components/Cart';
import ShippingAdress from './components/ShippingAdress';
import Payment from './components/Payment';
import Vendor from './components/dashboard/Vendor';
import AdminLog from './components/AdminLog';
import Afunc from './components/AdminFunction';
import Apro from './components/AddProduct';
import AddProduct from './components/AddProduct';
import AddCategory from './components/Categories';
import Allcategory from './components/CategoryList';
import Delcategory from './components/DelCategory';
import Allproduct from './components/ProductList';
import Delproduct from './components/DelProduct';
import UpdateProduct from './components/UpdateProduct';

function App() {
  return (
    
    <div className="App">
       <Header></Header>
       <hr></hr>
       <hr></hr>
                <Routes>
                    <Route path="/" element={<Home></Home>}></Route>
                    <Route path="/home" element={<Home></Home>}></Route>
                    <Route path="/login" element={<Login></Login>}></Route>
                    {/* <Route path="/dashboard" element={<AuthorizationRouter></AuthorizationRouter>}></Route> */}
                    <Route path="/registration" element={<Registration></Registration>}></Route>
                    <Route path="/cart" element={<Cart></Cart>}></Route>
                    <Route path="/shipmentAddress" element={<ShippingAdress></ShippingAdress>}></Route>
                    <Route path="/paymentpage" element={<Payment></Payment>}></Route>
                    <Route path="/vendor" element={<Vendor></Vendor>}></Route>
                    <Route path="/admin" element={<AdminLog></AdminLog>}></Route>
                    <Route path="/addproduct" element={<AddProduct></AddProduct>}></Route>
                    <Route path="/addcategory" element={<AddCategory></AddCategory>}></Route>
                    <Route path="/addfunction" element={<Afunc></Afunc>}></Route>
                    <Route path="/allcategory" element={<Allcategory></Allcategory>}></Route>
                    <Route path="/delcategory" element={<Delcategory></Delcategory>}></Route>
                    <Route path="/allproduct" element={<Allproduct></Allproduct>}></Route>
                    <Route path="/delproduct" element={<Delproduct></Delproduct>}></Route>
                    <Route path="/updateproduct" element={<UpdateProduct></UpdateProduct>}></Route>
                </Routes>
      <Footer></Footer>
    </div>
  );
}

export default App;
