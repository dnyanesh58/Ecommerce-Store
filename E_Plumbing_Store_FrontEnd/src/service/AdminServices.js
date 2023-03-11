import axios from 'axios';


class AdminServices {
    constructor() {
        this.baseUrl = "http://localhost:8080/"
    }
    deleteProduct(productId){
        return axios.delete(this.baseUrl+"product/product/"+productId);
    }

    deleteUser(userId){
        return axios.delete(this.baseUrl+"user/"+userId);
    }

}
export default new AdminServices();