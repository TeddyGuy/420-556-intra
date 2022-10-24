import axios from "axios"

export const mathService = {
    add: (a, b) => {
       return axios.post("http://localhost:8080/api/math/add",{a:a,b:b})
    },
    subtract: (a, b) => {
        return axios.post("http://localhost:8080/api/math/subtract",{a:a,b:b})
     }
}

export default mathService;