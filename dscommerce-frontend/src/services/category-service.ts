import { AxiosRequestConfig } from 'axios';
import { requestBackend } from '../utils/requests';



export function findAllPageRequest() {

  const config: AxiosRequestConfig = {
    method: "GET",
    url: "/categories",
  }
  return requestBackend(config);
}