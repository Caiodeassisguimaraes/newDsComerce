import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "../utils/system";
import { requestBckend } from "../utils/requests";

export function findPageRequest(page: number, name: string, size = 12, sort = "name"){

    const config : AxiosRequestConfig = {
        method: "GET",
        url: "/products",
        params: {
            page,
            name,
            size,
            sort,
        }
    }

    return requestBckend(config);
}

export function findById(id: number){
    return requestBckend ({url: `/products/${id}` })
}

