import { AxiosRequestConfig } from "axios";
import { requestBckend } from "../utils/requests";

export function findByIdRequest(id: number){
    const config : AxiosRequestConfig ={
        url: `/orders/${id}`,
        withCredentials: true,
    }
    return requestBckend(config);
}