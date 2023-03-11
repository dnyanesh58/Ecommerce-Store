import { useEffect, useState } from "react";
import UserServices from "../../service/UserServices";
import ProductForAdmin from "../ProductForAdmin";
import UserList from "../UserList";


const Admin = () => {
   
    let [product , setProduct] =useState([{}]);
    const [bool1, setbool1] = useState(false)
    const [bool, setbool] = useState(false)
    useEffect(() => {
  UserServices.getAllProduct().then((resp) => {
    console.log(resp.data[0].email+"inside home request")
      setProduct(resp.data)
  }).catch((err) => {
      console.log("Employee Profile Image Err", err)
  })
}, [])
 const userlist=()=>{
    if(!bool1){
        setbool1(true);
        }else{
            setbool1(false);
 }
}
 const productlist=()=>{
    if(!bool){
    setbool(true);
    }else{
        setbool(false);
    }

 }
 

    return (
        <div className="dashboardBody">

  <div>
    <button type="button" onClick={userlist}>userlist</button> <br></br>
    <button type="button" onClick={productlist}>productlist</button>

        {
        bool?
      <div className=''>
        <button type="button" onClick={productlist}>home</button>
        <main className='col-lg-10' style={{margin:"25px 50px 75px 100px"}}>
          <div className='row'>
          {/* <div className='col-lg-2 col-md-6 col-sm-6'></div> */}
      {
        product.map((p)=>{
          return (
            <div className='col-lg-2 col-md-6 col-sm-6'>
              <ProductForAdmin Product={p}></ProductForAdmin>
            </div>
          )
        })

        }
         {/* <div className='col-lg-1 col-md-6 col-sm-6'></div> */}
      
        </div>
      </main>
     </div>:""
}


    


  </div>

<div>

{
            bool1?
            <div>
            <button type="button" onClick={userlist}>home</button>
         <UserList></UserList>
         </div>:""
}
</div>
        </div>
    )
}

export default Admin;