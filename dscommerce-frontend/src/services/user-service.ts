import { requestBckend } from "../utils/requests";
import * as authService from './auth-service';

export function findMe(){

    const headers = {
        Authorization: 'Bearer ' + authService.getAccessToken() // Chama a função para obter o token
    }

    //console.log(headers);

    return requestBckend ({url: `/users/me`, headers: headers })
}
