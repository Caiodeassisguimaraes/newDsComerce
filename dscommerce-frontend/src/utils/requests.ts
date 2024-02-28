import axios from "axios";
import { BASE_URL } from "./system";


export function requestBckend(config: AxiosRequestConfig){
    return axios ({...config, baseURL: BASE_URL})
}