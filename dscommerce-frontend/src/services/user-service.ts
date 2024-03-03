import { AxiosRequestConfig } from "axios";
import { requestBckend } from "../utils/requests";

export function findMe() {

    const config: AxiosRequestConfig = {
        url: `/users/me`,
        withCredentials: true,
    }

    return requestBckend(config)
}
