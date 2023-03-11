import axios from 'axios';


class VendorServices {
    constructor() {
        this.baseUrl = "http://localhost:8080/"
    }
    AddProduct(product){
        return  axios.post(this.baseUrl+"product/create",product)
    }
    AddImage(imageFile,Productid){
     return   axios.post(this.baseUrl+"product/"+Productid+"/image",imageFile,{
            headers :{
                'Content-Type': 'multipart/form-data'
            }
        })
    }
}
export default new VendorServices();